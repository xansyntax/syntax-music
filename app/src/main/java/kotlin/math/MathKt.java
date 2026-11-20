package kotlin.math;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.os.Trace;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.collection.IntListKt;
import androidx.collection.MutableIntList;
import androidx.collection.internal.Lock;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.MarqueeSpacing$Companion$$ExternalSyntheticLambda0;
import androidx.compose.foundation.OverscrollKt;
import androidx.compose.foundation.ScrollState$$ExternalSyntheticLambda0;
import androidx.compose.foundation.gestures.BringIntoViewSpec;
import androidx.compose.foundation.gestures.BringIntoViewSpec_androidKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.SnapFlingBehavior;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.layout.Arrangement$Horizontal;
import androidx.compose.foundation.layout.Arrangement$Vertical;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.OffsetKt$$ExternalSyntheticLambda0;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.foundation.lazy.LazyListBeyondBoundsState;
import androidx.compose.foundation.lazy.LazyListKt$$ExternalSyntheticLambda0;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.layout.CacheWindowLogic;
import androidx.compose.foundation.lazy.layout.CachedItem;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.foundation.lazy.layout.LazyLayoutKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasurePolicy;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScopeImpl;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState;
import androidx.compose.foundation.lazy.layout.StickyItemsPlacement$Companion;
import androidx.compose.foundation.pager.DefaultPagerBringIntoViewSpec;
import androidx.compose.foundation.pager.DefaultPagerNestedScrollConnection;
import androidx.compose.foundation.pager.PageSize;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.foundation.pager.PagerState$scrollToPage$2;
import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.foundation.text.selection.OffsetProvider;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.material3.ScrimKt$Scrim$dismissModifier$1$1;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.DerivedSnapshotState;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.GapComposer$$ExternalSyntheticLambda0;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.SnapshotStateKt__DerivedStateKt;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.autofill.AndroidContentType;
import androidx.compose.ui.autofill.ContentType;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.CollectionInfo;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.AnnotatedStringKt;
import androidx.compose.ui.text.LinkAnnotation;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.ParagraphInfo;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.DensityWithConverter;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.LinearFontScaleConverter;
import androidx.compose.ui.unit.fontscaling.FontScaleConverter;
import androidx.compose.ui.unit.fontscaling.FontScaleConverterFactory;
import androidx.core.os.BuildCompat;
import androidx.core.os.BundleCompat$Api33Impl;
import androidx.core.provider.CallbackWrapper;
import androidx.customview.poolingcontainer.PoolingContainerListenerHolder;
import androidx.emoji2.text.EmojiProcessor;
import androidx.emoji2.text.flatbuffer.MetadataList;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.lifecycle.ViewModelProvider$Factory;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactory;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSourceInputStream;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.HttpDataSource$InvalidResponseCodeException;
import androidx.media3.datasource.StatsDataSource;
import androidx.media3.exoplayer.drm.MediaDrmCallback$Response;
import androidx.media3.exoplayer.drm.MediaDrmCallbackException;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.navigation.NavControllerViewModel;
import androidx.navigation.NavControllerViewModelKt;
import androidx.navigation.NavHostController;
import androidx.navigation.NavigatorProvider;
import androidx.navigation.compose.ComposeNavGraphNavigator;
import androidx.navigation.compose.ComposeNavigator;
import androidx.navigation.compose.DialogNavigator;
import androidx.navigation.internal.NavControllerImpl;
import androidx.room.PooledConnection;
import androidx.room.RoomDatabase$$ExternalSyntheticLambda2;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import coil3.decode.FileImageSource;
import coil3.disk.RealDiskCache;
import coil3.size.Scale;
import coil3.size.Size;
import coil3.size.SizeKt;
import coil3.util.FileSystemsKt;
import coil3.util.UtilsKt;
import coil3.util.Utils_androidKt;
import com.google.common.io.ByteStreams;
import com.google.common.math.IntMath;
import com.google.common.math.LongMath$1;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda29;
import com.metrolist.music.ui.component.ItemsKt$$ExternalSyntheticLambda67;
import com.metrolist.music.utils.DataStoreKt$dataStore$2$2;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import dagger.hilt.android.internal.lifecycle.HiltViewModelFactory;
import io.ktor.http.HttpHeaders;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import io.ktor.utils.io.ByteChannelKt;
import io.ktor.websocket.WebSocketDeflateExtensionKt;
import java.io.IOException;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptyMap;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.reflect.KProperty0;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.Dispatcher;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okhttp3.internal.http.StatusLine;
import okio.FileSystem;
import okio.Okio__OkioKt;
import okio.Path;

/* JADX INFO: loaded from: classes.dex */
public abstract class MathKt {
    public static final AndroidContentType ContentType(String str) {
        return new AndroidContentType(CharsKt.setOf(str));
    }

    public static final DensityWithConverter Density(Context context) {
        float f = context.getResources().getConfiguration().fontScale;
        float f2 = context.getResources().getDisplayMetrics().density;
        FontScaleConverter fontScaleConverterForScale = FontScaleConverterFactory.forScale(f);
        if (fontScaleConverterForScale == null) {
            fontScaleConverterForScale = new LinearFontScaleConverter(f);
        }
        return new DensityWithConverter(f2, f, fontScaleConverterForScale);
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0142  */
    /* JADX WARN: Code duplicated, block: B:111:0x016d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:112:0x016f  */
    /* JADX WARN: Code duplicated, block: B:114:0x0174  */
    /* JADX WARN: Code duplicated, block: B:115:0x0177  */
    /* JADX WARN: Code duplicated, block: B:118:0x017e  */
    /* JADX WARN: Code duplicated, block: B:119:0x0194  */
    /* JADX WARN: Code duplicated, block: B:121:0x019b  */
    /* JADX WARN: Code duplicated, block: B:122:0x019e  */
    /* JADX WARN: Code duplicated, block: B:125:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:127:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:133:0x01d5 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:134:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:137:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:138:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:141:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:143:0x0218  */
    /* JADX WARN: Code duplicated, block: B:145:0x021e  */
    /* JADX WARN: Code duplicated, block: B:151:0x023a A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:152:0x023c  */
    /* JADX WARN: Code duplicated, block: B:155:0x0258  */
    /* JADX WARN: Code duplicated, block: B:157:0x02d2  */
    /* JADX WARN: Code duplicated, block: B:160:0x02e9  */
    /* JADX WARN: Code duplicated, block: B:162:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x0064  */
    /* JADX WARN: Code duplicated, block: B:39:0x0069  */
    /* JADX WARN: Code duplicated, block: B:41:0x006d  */
    /* JADX WARN: Code duplicated, block: B:43:0x0075  */
    /* JADX WARN: Code duplicated, block: B:44:0x0078  */
    /* JADX WARN: Code duplicated, block: B:48:0x0084  */
    /* JADX WARN: Code duplicated, block: B:50:0x008a  */
    /* JADX WARN: Code duplicated, block: B:51:0x008d  */
    /* JADX WARN: Code duplicated, block: B:55:0x009b  */
    /* JADX WARN: Code duplicated, block: B:57:0x009f  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:60:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:67:0x00be  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:71:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:72:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:78:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:80:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:81:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:85:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:87:0x0103  */
    /* JADX WARN: Code duplicated, block: B:88:0x0106  */
    /* JADX WARN: Code duplicated, block: B:92:0x011c  */
    /* JADX WARN: Code duplicated, block: B:96:0x0129  */
    /* JADX WARN: Code duplicated, block: B:99:0x0133  */
    /* JADX INFO: renamed from: HorizontalPager-IOMxRjY, reason: not valid java name */
    public static final void m1872HorizontalPagerIOMxRjY(final PagerState pagerState, final Modifier modifier, final PaddingValuesImpl paddingValuesImpl, PageSize pageSize, int i, final float f, Alignment.Vertical vertical, SnapFlingBehavior snapFlingBehavior, boolean z, NestedScrollConnection nestedScrollConnection, SnapPosition snapPosition, AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect, BringIntoViewSpec bringIntoViewSpec, final ComposableLambdaImpl composableLambdaImpl, Composer composer, final int i2, final int i3) {
        int i4;
        PageSize pageSize2;
        int i5;
        int i6;
        int i7;
        int i8;
        SnapFlingBehavior snapFlingBehavior2;
        int i9;
        boolean z2;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        BringIntoViewSpec bringIntoViewSpec2;
        int i15;
        boolean z3;
        boolean z4;
        final Alignment.Vertical vertical2;
        final boolean z5;
        final NestedScrollConnection nestedScrollConnection2;
        final SnapFlingBehavior snapFlingBehavior3;
        final BringIntoViewSpec bringIntoViewSpec3;
        final SnapPosition snapPosition2;
        final int i16;
        final PageSize pageSize3;
        final AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect2;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        int i17;
        Orientation orientation;
        int i18;
        Alignment.Vertical vertical3;
        Orientation orientation2;
        PagerState pagerState2;
        SnapFlingBehavior snapFlingBehaviorFlingBehavior;
        boolean z6;
        LayoutDirection layoutDirection;
        SnapFlingBehavior snapFlingBehavior4;
        boolean zChanged;
        Object objRememberedValue;
        SnapPosition snapPosition3;
        AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffectRememberOverscrollEffect;
        int i19;
        BringIntoViewSpec bringIntoViewSpec4;
        int i20;
        int i21;
        boolean z7;
        SnapPosition snapPosition4;
        int i22;
        BringIntoViewSpec bringIntoViewSpec5;
        LayoutDirection layoutDirection2;
        boolean zChanged2;
        Object objRememberedValue2;
        int i23;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-1864473085);
        if ((i2 & 6) == 0) {
            i4 = (gapComposer.changed(pagerState) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= gapComposer.changed(modifier) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i4 |= gapComposer.changed(paddingValuesImpl) ? 256 : 128;
        }
        int i24 = i3 & 8;
        if (i24 == 0) {
            if ((i2 & 3072) == 0) {
                pageSize2 = pageSize;
                i4 |= gapComposer.changed(pageSize2) ? 2048 : 1024;
            }
            i5 = i3 & 16;
            if (i5 != 0) {
                if ((i2 & 24576) == 0) {
                    i6 = i;
                    if (gapComposer.changed(i6)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i4 |= i7;
                }
                if ((i2 & 196608) == 0) {
                    if (gapComposer.changed(f)) {
                        i23 = 131072;
                    } else {
                        i23 = 65536;
                    }
                    i4 |= i23;
                }
                i8 = i4 | 1572864;
                if ((i2 & 12582912) == 0) {
                    if ((i3 & 128) == 0) {
                        snapFlingBehavior2 = snapFlingBehavior;
                        int i25 = gapComposer.changed(snapFlingBehavior2) ? 8388608 : 4194304;
                        i8 |= i25;
                    } else {
                        snapFlingBehavior2 = snapFlingBehavior;
                    }
                    i8 |= i25;
                } else {
                    snapFlingBehavior2 = snapFlingBehavior;
                }
                i9 = i3 & 256;
                if (i9 != 0) {
                    i8 |= 100663296;
                    z2 = z;
                } else {
                    z2 = z;
                    if ((i2 & 100663296) == 0) {
                        if (gapComposer.changed(z2)) {
                            i10 = 67108864;
                        } else {
                            i10 = 33554432;
                        }
                        i8 |= i10;
                    }
                }
                i11 = i8 | 805306368;
                i12 = i3 & 4096;
                if (i12 != 0) {
                    i14 = 197014;
                } else {
                    if (gapComposer.changed(snapPosition)) {
                        i13 = 256;
                    } else {
                        i13 = 128;
                    }
                    i14 = 196630 | i13;
                }
                int i26 = i14 | 1024;
                if ((i3 & 16384) == 0) {
                    bringIntoViewSpec2 = bringIntoViewSpec;
                    int i27 = gapComposer.changed(bringIntoViewSpec2) ? 16384 : 8192;
                    i15 = i26 | i27;
                    z3 = true;
                    if ((i11 & 306783379) == 306783378 || (74899 & i15) != 74898) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (gapComposer.shouldExecute(i11 & 1, z4)) {
                        gapComposer.startDefaults();
                        i17 = i2 & 1;
                        orientation = Orientation.Horizontal;
                        if (i17 != 0 || gapComposer.getDefaultsInvalid()) {
                            if (i24 != 0) {
                                pageSize2 = PageSize.Fill.INSTANCE;
                            }
                            if (i5 != 0) {
                                i18 = 0;
                            } else {
                                i18 = i6;
                            }
                            vertical3 = Alignment.Companion.CenterVertically;
                            if ((i3 & 128) != 0) {
                                orientation2 = orientation;
                                pagerState2 = pagerState;
                                snapFlingBehaviorFlingBehavior = IntMath.flingBehavior(pagerState2, null, null, gapComposer, (i11 & 14) | 196608, 30);
                                i11 &= -29360129;
                            } else {
                                orientation2 = orientation;
                                pagerState2 = pagerState;
                                snapFlingBehaviorFlingBehavior = snapFlingBehavior2;
                            }
                            if (i9 != 0) {
                                z6 = true;
                            } else {
                                z6 = z;
                            }
                            int i28 = (i11 & 14) | 432;
                            layoutDirection = (LayoutDirection) gapComposer.consume(CompositionLocalsKt.LocalLayoutDirection);
                            snapFlingBehavior4 = snapFlingBehaviorFlingBehavior;
                            zChanged = ((((i28 & 14) ^ 6) <= 4 && gapComposer.changed(pagerState2)) || (i28 & 6) == 4) | gapComposer.changed(layoutDirection.ordinal());
                            objRememberedValue = gapComposer.rememberedValue();
                            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                            if (zChanged || objRememberedValue == neverEqualPolicy) {
                                objRememberedValue = new DefaultPagerNestedScrollConnection(pagerState2, orientation2, layoutDirection);
                                gapComposer.updateRememberedValue(objRememberedValue);
                            }
                            DefaultPagerNestedScrollConnection defaultPagerNestedScrollConnection = (DefaultPagerNestedScrollConnection) objRememberedValue;
                            if (i12 != 0) {
                                snapPosition3 = SnapPosition.Start.INSTANCE;
                            } else {
                                snapPosition3 = snapPosition;
                            }
                            androidEdgeEffectOverscrollEffectRememberOverscrollEffect = OverscrollKt.rememberOverscrollEffect(gapComposer);
                            nestedScrollConnection2 = defaultPagerNestedScrollConnection;
                            i19 = i15 & (-7281);
                            if ((i3 & 16384) != 0) {
                                i22 = (i11 & 14) | 48;
                                bringIntoViewSpec5 = (BringIntoViewSpec) gapComposer.consume(BringIntoViewSpec_androidKt.LocalBringIntoViewSpec);
                                layoutDirection2 = (LayoutDirection) gapComposer.consume(CompositionLocalsKt.LocalLayoutDirection);
                                if ((((i22 & 14) ^ 6) > 4 || !gapComposer.changed(pagerState2)) && (i22 & 6) != 4) {
                                }
                                zChanged2 = z3 | gapComposer.changed(bringIntoViewSpec5) | gapComposer.changed(layoutDirection2.ordinal());
                                objRememberedValue2 = gapComposer.rememberedValue();
                                if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                                    objRememberedValue2 = new DefaultPagerBringIntoViewSpec(pagerState2, bringIntoViewSpec5, layoutDirection2);
                                    gapComposer.updateRememberedValue(objRememberedValue2);
                                }
                                bringIntoViewSpec4 = (DefaultPagerBringIntoViewSpec) objRememberedValue2;
                                i20 = i15 & (-64625);
                            } else {
                                bringIntoViewSpec4 = bringIntoViewSpec2;
                                i20 = i19;
                            }
                            i21 = i11;
                            z7 = z6;
                            snapPosition4 = snapPosition3;
                        } else {
                            gapComposer.skipToGroupEnd();
                            if ((i3 & 128) != 0) {
                                i11 &= -29360129;
                            }
                            i20 = i15 & (-7281);
                            if ((i3 & 16384) != 0) {
                                i20 = i15 & (-64625);
                            }
                            vertical3 = vertical;
                            nestedScrollConnection2 = nestedScrollConnection;
                            snapPosition4 = snapPosition;
                            androidEdgeEffectOverscrollEffectRememberOverscrollEffect = androidEdgeEffectOverscrollEffect;
                            i18 = i6;
                            snapFlingBehavior4 = snapFlingBehavior2;
                            z7 = z2;
                            bringIntoViewSpec4 = bringIntoViewSpec2;
                            orientation2 = orientation;
                            i21 = i11;
                        }
                        gapComposer.endDefaults();
                        int i29 = i21 >> 6;
                        int i30 = i21 << 12;
                        PageSize pageSize4 = pageSize2;
                        Alignment.Vertical vertical4 = vertical3;
                        SizeKt.m861PagerWMpiP2s(modifier, pagerState, paddingValuesImpl, orientation2, snapFlingBehavior4, z7, androidEdgeEffectOverscrollEffectRememberOverscrollEffect, i18, f, pageSize4, nestedScrollConnection2, Alignment.Companion.CenterHorizontally, vertical4, snapPosition4, bringIntoViewSpec4, composableLambdaImpl, gapComposer, (i21 & 896) | ((i21 >> 3) & 14) | 24576 | ((i21 << 3) & 112) | ((i21 >> 18) & 7168) | (i29 & 458752) | (i29 & 3670016) | (i30 & 234881024) | (i30 & 1879048192), ((i20 << 9) & 458752) | ((i21 >> 9) & 14) | 3456 | (i29 & 57344) | ((i20 << 6) & 3670016) | 12582912);
                        gapComposer = gapComposer;
                        snapFlingBehavior3 = snapFlingBehavior4;
                        pageSize3 = pageSize4;
                        snapPosition2 = snapPosition4;
                        bringIntoViewSpec3 = bringIntoViewSpec4;
                        z5 = z7;
                        i16 = i18;
                        vertical2 = vertical4;
                        androidEdgeEffectOverscrollEffect2 = androidEdgeEffectOverscrollEffectRememberOverscrollEffect;
                    } else {
                        gapComposer.skipToGroupEnd();
                        vertical2 = vertical;
                        z5 = z;
                        nestedScrollConnection2 = nestedScrollConnection;
                        snapFlingBehavior3 = snapFlingBehavior2;
                        bringIntoViewSpec3 = bringIntoViewSpec2;
                        snapPosition2 = snapPosition;
                        i16 = i6;
                        pageSize3 = pageSize2;
                        androidEdgeEffectOverscrollEffect2 = androidEdgeEffectOverscrollEffect;
                    }
                    recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                    if (recomposeScopeImplEndRestartGroup != null) {
                        recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.foundation.pager.PagerKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                ((Integer) obj2).getClass();
                                int iUpdateChangedFlags = Stack.updateChangedFlags(i2 | 1);
                                MathKt.m1872HorizontalPagerIOMxRjY(pagerState, modifier, paddingValuesImpl, pageSize3, i16, f, vertical2, snapFlingBehavior3, z5, nestedScrollConnection2, snapPosition2, androidEdgeEffectOverscrollEffect2, bringIntoViewSpec3, composableLambdaImpl, (Composer) obj, iUpdateChangedFlags, i3);
                                return Unit.INSTANCE;
                            }
                        };
                    }
                }
                bringIntoViewSpec2 = bringIntoViewSpec;
                i15 = i26 | i27;
                z3 = true;
                if ((i11 & 306783379) == 306783378) {
                    z4 = true;
                } else {
                    z4 = true;
                }
                if (gapComposer.shouldExecute(i11 & 1, z4)) {
                    gapComposer.startDefaults();
                    i17 = i2 & 1;
                    orientation = Orientation.Horizontal;
                    if (i17 != 0) {
                        if (i24 != 0) {
                            pageSize2 = PageSize.Fill.INSTANCE;
                        }
                        if (i5 != 0) {
                            i18 = 0;
                        } else {
                            i18 = i6;
                        }
                        vertical3 = Alignment.Companion.CenterVertically;
                        if ((i3 & 128) != 0) {
                            orientation2 = orientation;
                            pagerState2 = pagerState;
                            snapFlingBehaviorFlingBehavior = IntMath.flingBehavior(pagerState2, null, null, gapComposer, (i11 & 14) | 196608, 30);
                            i11 &= -29360129;
                        } else {
                            orientation2 = orientation;
                            pagerState2 = pagerState;
                            snapFlingBehaviorFlingBehavior = snapFlingBehavior2;
                        }
                        if (i9 != 0) {
                            z6 = true;
                        } else {
                            z6 = z;
                        }
                        int i210 = (i11 & 14) | 432;
                        layoutDirection = (LayoutDirection) gapComposer.consume(CompositionLocalsKt.LocalLayoutDirection);
                        snapFlingBehavior4 = snapFlingBehaviorFlingBehavior;
                        zChanged = ((((i210 & 14) ^ 6) <= 4 && gapComposer.changed(pagerState2)) || (i210 & 6) == 4) | gapComposer.changed(layoutDirection.ordinal());
                        objRememberedValue = gapComposer.rememberedValue();
                        NeverEqualPolicy neverEqualPolicy2 = Composer.Companion.Empty;
                        if (zChanged) {
                            objRememberedValue = new DefaultPagerNestedScrollConnection(pagerState2, orientation2, layoutDirection);
                            gapComposer.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new DefaultPagerNestedScrollConnection(pagerState2, orientation2, layoutDirection);
                            gapComposer.updateRememberedValue(objRememberedValue);
                        }
                        DefaultPagerNestedScrollConnection defaultPagerNestedScrollConnection2 = (DefaultPagerNestedScrollConnection) objRememberedValue;
                        if (i12 != 0) {
                            snapPosition3 = SnapPosition.Start.INSTANCE;
                        } else {
                            snapPosition3 = snapPosition;
                        }
                        androidEdgeEffectOverscrollEffectRememberOverscrollEffect = OverscrollKt.rememberOverscrollEffect(gapComposer);
                        nestedScrollConnection2 = defaultPagerNestedScrollConnection2;
                        i19 = i15 & (-7281);
                        if ((i3 & 16384) != 0) {
                            i22 = (i11 & 14) | 48;
                            bringIntoViewSpec5 = (BringIntoViewSpec) gapComposer.consume(BringIntoViewSpec_androidKt.LocalBringIntoViewSpec);
                            layoutDirection2 = (LayoutDirection) gapComposer.consume(CompositionLocalsKt.LocalLayoutDirection);
                            z3 = ((i22 & 14) ^ 6) > 4 ? false : false;
                            zChanged2 = z3 | gapComposer.changed(bringIntoViewSpec5) | gapComposer.changed(layoutDirection2.ordinal());
                            objRememberedValue2 = gapComposer.rememberedValue();
                            if (zChanged2) {
                                objRememberedValue2 = new DefaultPagerBringIntoViewSpec(pagerState2, bringIntoViewSpec5, layoutDirection2);
                                gapComposer.updateRememberedValue(objRememberedValue2);
                            } else {
                                objRememberedValue2 = new DefaultPagerBringIntoViewSpec(pagerState2, bringIntoViewSpec5, layoutDirection2);
                                gapComposer.updateRememberedValue(objRememberedValue2);
                            }
                            bringIntoViewSpec4 = (DefaultPagerBringIntoViewSpec) objRememberedValue2;
                            i20 = i15 & (-64625);
                        } else {
                            bringIntoViewSpec4 = bringIntoViewSpec2;
                            i20 = i19;
                        }
                        i21 = i11;
                        z7 = z6;
                        snapPosition4 = snapPosition3;
                    } else {
                        if (i24 != 0) {
                            pageSize2 = PageSize.Fill.INSTANCE;
                        }
                        if (i5 != 0) {
                            i18 = 0;
                        } else {
                            i18 = i6;
                        }
                        vertical3 = Alignment.Companion.CenterVertically;
                        if ((i3 & 128) != 0) {
                            orientation2 = orientation;
                            pagerState2 = pagerState;
                            snapFlingBehaviorFlingBehavior = IntMath.flingBehavior(pagerState2, null, null, gapComposer, (i11 & 14) | 196608, 30);
                            i11 &= -29360129;
                        } else {
                            orientation2 = orientation;
                            pagerState2 = pagerState;
                            snapFlingBehaviorFlingBehavior = snapFlingBehavior2;
                        }
                        if (i9 != 0) {
                            z6 = true;
                        } else {
                            z6 = z;
                        }
                        int i211 = (i11 & 14) | 432;
                        layoutDirection = (LayoutDirection) gapComposer.consume(CompositionLocalsKt.LocalLayoutDirection);
                        snapFlingBehavior4 = snapFlingBehaviorFlingBehavior;
                        zChanged = ((((i211 & 14) ^ 6) <= 4 && gapComposer.changed(pagerState2)) || (i211 & 6) == 4) | gapComposer.changed(layoutDirection.ordinal());
                        objRememberedValue = gapComposer.rememberedValue();
                        NeverEqualPolicy neverEqualPolicy3 = Composer.Companion.Empty;
                        if (zChanged) {
                            objRememberedValue = new DefaultPagerNestedScrollConnection(pagerState2, orientation2, layoutDirection);
                            gapComposer.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new DefaultPagerNestedScrollConnection(pagerState2, orientation2, layoutDirection);
                            gapComposer.updateRememberedValue(objRememberedValue);
                        }
                        DefaultPagerNestedScrollConnection defaultPagerNestedScrollConnection3 = (DefaultPagerNestedScrollConnection) objRememberedValue;
                        if (i12 != 0) {
                            snapPosition3 = SnapPosition.Start.INSTANCE;
                        } else {
                            snapPosition3 = snapPosition;
                        }
                        androidEdgeEffectOverscrollEffectRememberOverscrollEffect = OverscrollKt.rememberOverscrollEffect(gapComposer);
                        nestedScrollConnection2 = defaultPagerNestedScrollConnection3;
                        i19 = i15 & (-7281);
                        if ((i3 & 16384) != 0) {
                            i22 = (i11 & 14) | 48;
                            bringIntoViewSpec5 = (BringIntoViewSpec) gapComposer.consume(BringIntoViewSpec_androidKt.LocalBringIntoViewSpec);
                            layoutDirection2 = (LayoutDirection) gapComposer.consume(CompositionLocalsKt.LocalLayoutDirection);
                            if (((i22 & 14) ^ 6) > 4) {
                            }
                            zChanged2 = z3 | gapComposer.changed(bringIntoViewSpec5) | gapComposer.changed(layoutDirection2.ordinal());
                            objRememberedValue2 = gapComposer.rememberedValue();
                            if (zChanged2) {
                                objRememberedValue2 = new DefaultPagerBringIntoViewSpec(pagerState2, bringIntoViewSpec5, layoutDirection2);
                                gapComposer.updateRememberedValue(objRememberedValue2);
                            } else {
                                objRememberedValue2 = new DefaultPagerBringIntoViewSpec(pagerState2, bringIntoViewSpec5, layoutDirection2);
                                gapComposer.updateRememberedValue(objRememberedValue2);
                            }
                            bringIntoViewSpec4 = (DefaultPagerBringIntoViewSpec) objRememberedValue2;
                            i20 = i15 & (-64625);
                        } else {
                            bringIntoViewSpec4 = bringIntoViewSpec2;
                            i20 = i19;
                        }
                        i21 = i11;
                        z7 = z6;
                        snapPosition4 = snapPosition3;
                    }
                    gapComposer.endDefaults();
                    int i212 = i21 >> 6;
                    int i31 = i21 << 12;
                    PageSize pageSize5 = pageSize2;
                    Alignment.Vertical vertical5 = vertical3;
                    SizeKt.m861PagerWMpiP2s(modifier, pagerState, paddingValuesImpl, orientation2, snapFlingBehavior4, z7, androidEdgeEffectOverscrollEffectRememberOverscrollEffect, i18, f, pageSize5, nestedScrollConnection2, Alignment.Companion.CenterHorizontally, vertical5, snapPosition4, bringIntoViewSpec4, composableLambdaImpl, gapComposer, (i21 & 896) | ((i21 >> 3) & 14) | 24576 | ((i21 << 3) & 112) | ((i21 >> 18) & 7168) | (i212 & 458752) | (i212 & 3670016) | (i31 & 234881024) | (i31 & 1879048192), ((i20 << 9) & 458752) | ((i21 >> 9) & 14) | 3456 | (i212 & 57344) | ((i20 << 6) & 3670016) | 12582912);
                    gapComposer = gapComposer;
                    snapFlingBehavior3 = snapFlingBehavior4;
                    pageSize3 = pageSize5;
                    snapPosition2 = snapPosition4;
                    bringIntoViewSpec3 = bringIntoViewSpec4;
                    z5 = z7;
                    i16 = i18;
                    vertical2 = vertical5;
                    androidEdgeEffectOverscrollEffect2 = androidEdgeEffectOverscrollEffectRememberOverscrollEffect;
                } else {
                    gapComposer.skipToGroupEnd();
                    vertical2 = vertical;
                    z5 = z;
                    nestedScrollConnection2 = nestedScrollConnection;
                    snapFlingBehavior3 = snapFlingBehavior2;
                    bringIntoViewSpec3 = bringIntoViewSpec2;
                    snapPosition2 = snapPosition;
                    i16 = i6;
                    pageSize3 = pageSize2;
                    androidEdgeEffectOverscrollEffect2 = androidEdgeEffectOverscrollEffect;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.foundation.pager.PagerKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            ((Integer) obj2).getClass();
                            int iUpdateChangedFlags = Stack.updateChangedFlags(i2 | 1);
                            MathKt.m1872HorizontalPagerIOMxRjY(pagerState, modifier, paddingValuesImpl, pageSize3, i16, f, vertical2, snapFlingBehavior3, z5, nestedScrollConnection2, snapPosition2, androidEdgeEffectOverscrollEffect2, bringIntoViewSpec3, composableLambdaImpl, (Composer) obj, iUpdateChangedFlags, i3);
                            return Unit.INSTANCE;
                        }
                    };
                }
            }
            i4 |= 24576;
            i6 = i;
            if ((i2 & 196608) == 0) {
                if (gapComposer.changed(f)) {
                    i23 = 131072;
                } else {
                    i23 = 65536;
                }
                i4 |= i23;
            }
            i8 = i4 | 1572864;
            if ((i2 & 12582912) == 0) {
                if ((i3 & 128) == 0) {
                    snapFlingBehavior2 = snapFlingBehavior;
                    if (gapComposer.changed(snapFlingBehavior2)) {
                    }
                    i8 |= i25;
                } else {
                    snapFlingBehavior2 = snapFlingBehavior;
                }
                i8 |= i25;
            } else {
                snapFlingBehavior2 = snapFlingBehavior;
            }
            i9 = i3 & 256;
            if (i9 != 0) {
                i8 |= 100663296;
                z2 = z;
            } else {
                z2 = z;
                if ((i2 & 100663296) == 0) {
                    if (gapComposer.changed(z2)) {
                        i10 = 67108864;
                    } else {
                        i10 = 33554432;
                    }
                    i8 |= i10;
                }
            }
            i11 = i8 | 805306368;
            i12 = i3 & 4096;
            if (i12 != 0) {
                i14 = 197014;
            } else {
                if (gapComposer.changed(snapPosition)) {
                    i13 = 256;
                } else {
                    i13 = 128;
                }
                i14 = 196630 | i13;
            }
            int i213 = i14 | 1024;
            if ((i3 & 16384) == 0) {
                bringIntoViewSpec2 = bringIntoViewSpec;
                if (gapComposer.changed(bringIntoViewSpec2)) {
                }
                i15 = i213 | i27;
                z3 = true;
                if ((i11 & 306783379) == 306783378) {
                    z4 = true;
                } else {
                    z4 = true;
                }
                if (gapComposer.shouldExecute(i11 & 1, z4)) {
                    gapComposer.startDefaults();
                    i17 = i2 & 1;
                    orientation = Orientation.Horizontal;
                    if (i17 != 0) {
                        if (i24 != 0) {
                            pageSize2 = PageSize.Fill.INSTANCE;
                        }
                        if (i5 != 0) {
                            i18 = 0;
                        } else {
                            i18 = i6;
                        }
                        vertical3 = Alignment.Companion.CenterVertically;
                        if ((i3 & 128) != 0) {
                            orientation2 = orientation;
                            pagerState2 = pagerState;
                            snapFlingBehaviorFlingBehavior = IntMath.flingBehavior(pagerState2, null, null, gapComposer, (i11 & 14) | 196608, 30);
                            i11 &= -29360129;
                        } else {
                            orientation2 = orientation;
                            pagerState2 = pagerState;
                            snapFlingBehaviorFlingBehavior = snapFlingBehavior2;
                        }
                        if (i9 != 0) {
                            z6 = true;
                        } else {
                            z6 = z;
                        }
                        int i214 = (i11 & 14) | 432;
                        layoutDirection = (LayoutDirection) gapComposer.consume(CompositionLocalsKt.LocalLayoutDirection);
                        snapFlingBehavior4 = snapFlingBehaviorFlingBehavior;
                        zChanged = ((((i214 & 14) ^ 6) <= 4 && gapComposer.changed(pagerState2)) || (i214 & 6) == 4) | gapComposer.changed(layoutDirection.ordinal());
                        objRememberedValue = gapComposer.rememberedValue();
                        NeverEqualPolicy neverEqualPolicy4 = Composer.Companion.Empty;
                        if (zChanged) {
                            objRememberedValue = new DefaultPagerNestedScrollConnection(pagerState2, orientation2, layoutDirection);
                            gapComposer.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new DefaultPagerNestedScrollConnection(pagerState2, orientation2, layoutDirection);
                            gapComposer.updateRememberedValue(objRememberedValue);
                        }
                        DefaultPagerNestedScrollConnection defaultPagerNestedScrollConnection4 = (DefaultPagerNestedScrollConnection) objRememberedValue;
                        if (i12 != 0) {
                            snapPosition3 = SnapPosition.Start.INSTANCE;
                        } else {
                            snapPosition3 = snapPosition;
                        }
                        androidEdgeEffectOverscrollEffectRememberOverscrollEffect = OverscrollKt.rememberOverscrollEffect(gapComposer);
                        nestedScrollConnection2 = defaultPagerNestedScrollConnection4;
                        i19 = i15 & (-7281);
                        if ((i3 & 16384) != 0) {
                            i22 = (i11 & 14) | 48;
                            bringIntoViewSpec5 = (BringIntoViewSpec) gapComposer.consume(BringIntoViewSpec_androidKt.LocalBringIntoViewSpec);
                            layoutDirection2 = (LayoutDirection) gapComposer.consume(CompositionLocalsKt.LocalLayoutDirection);
                            if (((i22 & 14) ^ 6) > 4) {
                            }
                            zChanged2 = z3 | gapComposer.changed(bringIntoViewSpec5) | gapComposer.changed(layoutDirection2.ordinal());
                            objRememberedValue2 = gapComposer.rememberedValue();
                            if (zChanged2) {
                                objRememberedValue2 = new DefaultPagerBringIntoViewSpec(pagerState2, bringIntoViewSpec5, layoutDirection2);
                                gapComposer.updateRememberedValue(objRememberedValue2);
                            } else {
                                objRememberedValue2 = new DefaultPagerBringIntoViewSpec(pagerState2, bringIntoViewSpec5, layoutDirection2);
                                gapComposer.updateRememberedValue(objRememberedValue2);
                            }
                            bringIntoViewSpec4 = (DefaultPagerBringIntoViewSpec) objRememberedValue2;
                            i20 = i15 & (-64625);
                        } else {
                            bringIntoViewSpec4 = bringIntoViewSpec2;
                            i20 = i19;
                        }
                        i21 = i11;
                        z7 = z6;
                        snapPosition4 = snapPosition3;
                    } else {
                        if (i24 != 0) {
                            pageSize2 = PageSize.Fill.INSTANCE;
                        }
                        if (i5 != 0) {
                            i18 = 0;
                        } else {
                            i18 = i6;
                        }
                        vertical3 = Alignment.Companion.CenterVertically;
                        if ((i3 & 128) != 0) {
                            orientation2 = orientation;
                            pagerState2 = pagerState;
                            snapFlingBehaviorFlingBehavior = IntMath.flingBehavior(pagerState2, null, null, gapComposer, (i11 & 14) | 196608, 30);
                            i11 &= -29360129;
                        } else {
                            orientation2 = orientation;
                            pagerState2 = pagerState;
                            snapFlingBehaviorFlingBehavior = snapFlingBehavior2;
                        }
                        if (i9 != 0) {
                            z6 = true;
                        } else {
                            z6 = z;
                        }
                        int i215 = (i11 & 14) | 432;
                        layoutDirection = (LayoutDirection) gapComposer.consume(CompositionLocalsKt.LocalLayoutDirection);
                        snapFlingBehavior4 = snapFlingBehaviorFlingBehavior;
                        zChanged = ((((i215 & 14) ^ 6) <= 4 && gapComposer.changed(pagerState2)) || (i215 & 6) == 4) | gapComposer.changed(layoutDirection.ordinal());
                        objRememberedValue = gapComposer.rememberedValue();
                        NeverEqualPolicy neverEqualPolicy5 = Composer.Companion.Empty;
                        if (zChanged) {
                            objRememberedValue = new DefaultPagerNestedScrollConnection(pagerState2, orientation2, layoutDirection);
                            gapComposer.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new DefaultPagerNestedScrollConnection(pagerState2, orientation2, layoutDirection);
                            gapComposer.updateRememberedValue(objRememberedValue);
                        }
                        DefaultPagerNestedScrollConnection defaultPagerNestedScrollConnection5 = (DefaultPagerNestedScrollConnection) objRememberedValue;
                        if (i12 != 0) {
                            snapPosition3 = SnapPosition.Start.INSTANCE;
                        } else {
                            snapPosition3 = snapPosition;
                        }
                        androidEdgeEffectOverscrollEffectRememberOverscrollEffect = OverscrollKt.rememberOverscrollEffect(gapComposer);
                        nestedScrollConnection2 = defaultPagerNestedScrollConnection5;
                        i19 = i15 & (-7281);
                        if ((i3 & 16384) != 0) {
                            i22 = (i11 & 14) | 48;
                            bringIntoViewSpec5 = (BringIntoViewSpec) gapComposer.consume(BringIntoViewSpec_androidKt.LocalBringIntoViewSpec);
                            layoutDirection2 = (LayoutDirection) gapComposer.consume(CompositionLocalsKt.LocalLayoutDirection);
                            if (((i22 & 14) ^ 6) > 4) {
                            }
                            zChanged2 = z3 | gapComposer.changed(bringIntoViewSpec5) | gapComposer.changed(layoutDirection2.ordinal());
                            objRememberedValue2 = gapComposer.rememberedValue();
                            if (zChanged2) {
                                objRememberedValue2 = new DefaultPagerBringIntoViewSpec(pagerState2, bringIntoViewSpec5, layoutDirection2);
                                gapComposer.updateRememberedValue(objRememberedValue2);
                            } else {
                                objRememberedValue2 = new DefaultPagerBringIntoViewSpec(pagerState2, bringIntoViewSpec5, layoutDirection2);
                                gapComposer.updateRememberedValue(objRememberedValue2);
                            }
                            bringIntoViewSpec4 = (DefaultPagerBringIntoViewSpec) objRememberedValue2;
                            i20 = i15 & (-64625);
                        } else {
                            bringIntoViewSpec4 = bringIntoViewSpec2;
                            i20 = i19;
                        }
                        i21 = i11;
                        z7 = z6;
                        snapPosition4 = snapPosition3;
                    }
                    gapComposer.endDefaults();
                    int i216 = i21 >> 6;
                    int i32 = i21 << 12;
                    PageSize pageSize6 = pageSize2;
                    Alignment.Vertical vertical6 = vertical3;
                    SizeKt.m861PagerWMpiP2s(modifier, pagerState, paddingValuesImpl, orientation2, snapFlingBehavior4, z7, androidEdgeEffectOverscrollEffectRememberOverscrollEffect, i18, f, pageSize6, nestedScrollConnection2, Alignment.Companion.CenterHorizontally, vertical6, snapPosition4, bringIntoViewSpec4, composableLambdaImpl, gapComposer, (i21 & 896) | ((i21 >> 3) & 14) | 24576 | ((i21 << 3) & 112) | ((i21 >> 18) & 7168) | (i216 & 458752) | (i216 & 3670016) | (i32 & 234881024) | (i32 & 1879048192), ((i20 << 9) & 458752) | ((i21 >> 9) & 14) | 3456 | (i216 & 57344) | ((i20 << 6) & 3670016) | 12582912);
                    gapComposer = gapComposer;
                    snapFlingBehavior3 = snapFlingBehavior4;
                    pageSize3 = pageSize6;
                    snapPosition2 = snapPosition4;
                    bringIntoViewSpec3 = bringIntoViewSpec4;
                    z5 = z7;
                    i16 = i18;
                    vertical2 = vertical6;
                    androidEdgeEffectOverscrollEffect2 = androidEdgeEffectOverscrollEffectRememberOverscrollEffect;
                } else {
                    gapComposer.skipToGroupEnd();
                    vertical2 = vertical;
                    z5 = z;
                    nestedScrollConnection2 = nestedScrollConnection;
                    snapFlingBehavior3 = snapFlingBehavior2;
                    bringIntoViewSpec3 = bringIntoViewSpec2;
                    snapPosition2 = snapPosition;
                    i16 = i6;
                    pageSize3 = pageSize2;
                    androidEdgeEffectOverscrollEffect2 = androidEdgeEffectOverscrollEffect;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.foundation.pager.PagerKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            ((Integer) obj2).getClass();
                            int iUpdateChangedFlags = Stack.updateChangedFlags(i2 | 1);
                            MathKt.m1872HorizontalPagerIOMxRjY(pagerState, modifier, paddingValuesImpl, pageSize3, i16, f, vertical2, snapFlingBehavior3, z5, nestedScrollConnection2, snapPosition2, androidEdgeEffectOverscrollEffect2, bringIntoViewSpec3, composableLambdaImpl, (Composer) obj, iUpdateChangedFlags, i3);
                            return Unit.INSTANCE;
                        }
                    };
                }
            }
            bringIntoViewSpec2 = bringIntoViewSpec;
            i15 = i213 | i27;
            z3 = true;
            if ((i11 & 306783379) == 306783378) {
                z4 = true;
            } else {
                z4 = true;
            }
            if (gapComposer.shouldExecute(i11 & 1, z4)) {
                gapComposer.startDefaults();
                i17 = i2 & 1;
                orientation = Orientation.Horizontal;
                if (i17 != 0) {
                    if (i24 != 0) {
                        pageSize2 = PageSize.Fill.INSTANCE;
                    }
                    if (i5 != 0) {
                        i18 = 0;
                    } else {
                        i18 = i6;
                    }
                    vertical3 = Alignment.Companion.CenterVertically;
                    if ((i3 & 128) != 0) {
                        orientation2 = orientation;
                        pagerState2 = pagerState;
                        snapFlingBehaviorFlingBehavior = IntMath.flingBehavior(pagerState2, null, null, gapComposer, (i11 & 14) | 196608, 30);
                        i11 &= -29360129;
                    } else {
                        orientation2 = orientation;
                        pagerState2 = pagerState;
                        snapFlingBehaviorFlingBehavior = snapFlingBehavior2;
                    }
                    if (i9 != 0) {
                        z6 = true;
                    } else {
                        z6 = z;
                    }
                    int i217 = (i11 & 14) | 432;
                    layoutDirection = (LayoutDirection) gapComposer.consume(CompositionLocalsKt.LocalLayoutDirection);
                    snapFlingBehavior4 = snapFlingBehaviorFlingBehavior;
                    zChanged = ((((i217 & 14) ^ 6) <= 4 && gapComposer.changed(pagerState2)) || (i217 & 6) == 4) | gapComposer.changed(layoutDirection.ordinal());
                    objRememberedValue = gapComposer.rememberedValue();
                    NeverEqualPolicy neverEqualPolicy6 = Composer.Companion.Empty;
                    if (zChanged) {
                        objRememberedValue = new DefaultPagerNestedScrollConnection(pagerState2, orientation2, layoutDirection);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new DefaultPagerNestedScrollConnection(pagerState2, orientation2, layoutDirection);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    DefaultPagerNestedScrollConnection defaultPagerNestedScrollConnection6 = (DefaultPagerNestedScrollConnection) objRememberedValue;
                    if (i12 != 0) {
                        snapPosition3 = SnapPosition.Start.INSTANCE;
                    } else {
                        snapPosition3 = snapPosition;
                    }
                    androidEdgeEffectOverscrollEffectRememberOverscrollEffect = OverscrollKt.rememberOverscrollEffect(gapComposer);
                    nestedScrollConnection2 = defaultPagerNestedScrollConnection6;
                    i19 = i15 & (-7281);
                    if ((i3 & 16384) != 0) {
                        i22 = (i11 & 14) | 48;
                        bringIntoViewSpec5 = (BringIntoViewSpec) gapComposer.consume(BringIntoViewSpec_androidKt.LocalBringIntoViewSpec);
                        layoutDirection2 = (LayoutDirection) gapComposer.consume(CompositionLocalsKt.LocalLayoutDirection);
                        if (((i22 & 14) ^ 6) > 4) {
                        }
                        zChanged2 = z3 | gapComposer.changed(bringIntoViewSpec5) | gapComposer.changed(layoutDirection2.ordinal());
                        objRememberedValue2 = gapComposer.rememberedValue();
                        if (zChanged2) {
                            objRememberedValue2 = new DefaultPagerBringIntoViewSpec(pagerState2, bringIntoViewSpec5, layoutDirection2);
                            gapComposer.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new DefaultPagerBringIntoViewSpec(pagerState2, bringIntoViewSpec5, layoutDirection2);
                            gapComposer.updateRememberedValue(objRememberedValue2);
                        }
                        bringIntoViewSpec4 = (DefaultPagerBringIntoViewSpec) objRememberedValue2;
                        i20 = i15 & (-64625);
                    } else {
                        bringIntoViewSpec4 = bringIntoViewSpec2;
                        i20 = i19;
                    }
                    i21 = i11;
                    z7 = z6;
                    snapPosition4 = snapPosition3;
                } else {
                    if (i24 != 0) {
                        pageSize2 = PageSize.Fill.INSTANCE;
                    }
                    if (i5 != 0) {
                        i18 = 0;
                    } else {
                        i18 = i6;
                    }
                    vertical3 = Alignment.Companion.CenterVertically;
                    if ((i3 & 128) != 0) {
                        orientation2 = orientation;
                        pagerState2 = pagerState;
                        snapFlingBehaviorFlingBehavior = IntMath.flingBehavior(pagerState2, null, null, gapComposer, (i11 & 14) | 196608, 30);
                        i11 &= -29360129;
                    } else {
                        orientation2 = orientation;
                        pagerState2 = pagerState;
                        snapFlingBehaviorFlingBehavior = snapFlingBehavior2;
                    }
                    if (i9 != 0) {
                        z6 = true;
                    } else {
                        z6 = z;
                    }
                    int i218 = (i11 & 14) | 432;
                    layoutDirection = (LayoutDirection) gapComposer.consume(CompositionLocalsKt.LocalLayoutDirection);
                    snapFlingBehavior4 = snapFlingBehaviorFlingBehavior;
                    zChanged = ((((i218 & 14) ^ 6) <= 4 && gapComposer.changed(pagerState2)) || (i218 & 6) == 4) | gapComposer.changed(layoutDirection.ordinal());
                    objRememberedValue = gapComposer.rememberedValue();
                    NeverEqualPolicy neverEqualPolicy7 = Composer.Companion.Empty;
                    if (zChanged) {
                        objRememberedValue = new DefaultPagerNestedScrollConnection(pagerState2, orientation2, layoutDirection);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new DefaultPagerNestedScrollConnection(pagerState2, orientation2, layoutDirection);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    DefaultPagerNestedScrollConnection defaultPagerNestedScrollConnection7 = (DefaultPagerNestedScrollConnection) objRememberedValue;
                    if (i12 != 0) {
                        snapPosition3 = SnapPosition.Start.INSTANCE;
                    } else {
                        snapPosition3 = snapPosition;
                    }
                    androidEdgeEffectOverscrollEffectRememberOverscrollEffect = OverscrollKt.rememberOverscrollEffect(gapComposer);
                    nestedScrollConnection2 = defaultPagerNestedScrollConnection7;
                    i19 = i15 & (-7281);
                    if ((i3 & 16384) != 0) {
                        i22 = (i11 & 14) | 48;
                        bringIntoViewSpec5 = (BringIntoViewSpec) gapComposer.consume(BringIntoViewSpec_androidKt.LocalBringIntoViewSpec);
                        layoutDirection2 = (LayoutDirection) gapComposer.consume(CompositionLocalsKt.LocalLayoutDirection);
                        if (((i22 & 14) ^ 6) > 4) {
                        }
                        zChanged2 = z3 | gapComposer.changed(bringIntoViewSpec5) | gapComposer.changed(layoutDirection2.ordinal());
                        objRememberedValue2 = gapComposer.rememberedValue();
                        if (zChanged2) {
                            objRememberedValue2 = new DefaultPagerBringIntoViewSpec(pagerState2, bringIntoViewSpec5, layoutDirection2);
                            gapComposer.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new DefaultPagerBringIntoViewSpec(pagerState2, bringIntoViewSpec5, layoutDirection2);
                            gapComposer.updateRememberedValue(objRememberedValue2);
                        }
                        bringIntoViewSpec4 = (DefaultPagerBringIntoViewSpec) objRememberedValue2;
                        i20 = i15 & (-64625);
                    } else {
                        bringIntoViewSpec4 = bringIntoViewSpec2;
                        i20 = i19;
                    }
                    i21 = i11;
                    z7 = z6;
                    snapPosition4 = snapPosition3;
                }
                gapComposer.endDefaults();
                int i219 = i21 >> 6;
                int i33 = i21 << 12;
                PageSize pageSize7 = pageSize2;
                Alignment.Vertical vertical7 = vertical3;
                SizeKt.m861PagerWMpiP2s(modifier, pagerState, paddingValuesImpl, orientation2, snapFlingBehavior4, z7, androidEdgeEffectOverscrollEffectRememberOverscrollEffect, i18, f, pageSize7, nestedScrollConnection2, Alignment.Companion.CenterHorizontally, vertical7, snapPosition4, bringIntoViewSpec4, composableLambdaImpl, gapComposer, (i21 & 896) | ((i21 >> 3) & 14) | 24576 | ((i21 << 3) & 112) | ((i21 >> 18) & 7168) | (i219 & 458752) | (i219 & 3670016) | (i33 & 234881024) | (i33 & 1879048192), ((i20 << 9) & 458752) | ((i21 >> 9) & 14) | 3456 | (i219 & 57344) | ((i20 << 6) & 3670016) | 12582912);
                gapComposer = gapComposer;
                snapFlingBehavior3 = snapFlingBehavior4;
                pageSize3 = pageSize7;
                snapPosition2 = snapPosition4;
                bringIntoViewSpec3 = bringIntoViewSpec4;
                z5 = z7;
                i16 = i18;
                vertical2 = vertical7;
                androidEdgeEffectOverscrollEffect2 = androidEdgeEffectOverscrollEffectRememberOverscrollEffect;
            } else {
                gapComposer.skipToGroupEnd();
                vertical2 = vertical;
                z5 = z;
                nestedScrollConnection2 = nestedScrollConnection;
                snapFlingBehavior3 = snapFlingBehavior2;
                bringIntoViewSpec3 = bringIntoViewSpec2;
                snapPosition2 = snapPosition;
                i16 = i6;
                pageSize3 = pageSize2;
                androidEdgeEffectOverscrollEffect2 = androidEdgeEffectOverscrollEffect;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.foundation.pager.PagerKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        int iUpdateChangedFlags = Stack.updateChangedFlags(i2 | 1);
                        MathKt.m1872HorizontalPagerIOMxRjY(pagerState, modifier, paddingValuesImpl, pageSize3, i16, f, vertical2, snapFlingBehavior3, z5, nestedScrollConnection2, snapPosition2, androidEdgeEffectOverscrollEffect2, bringIntoViewSpec3, composableLambdaImpl, (Composer) obj, iUpdateChangedFlags, i3);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i4 |= 3072;
        pageSize2 = pageSize;
        i5 = i3 & 16;
        if (i5 != 0) {
            if ((i2 & 24576) == 0) {
                i6 = i;
                if (gapComposer.changed(i6)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i4 |= i7;
            }
            if ((i2 & 196608) == 0) {
                if (gapComposer.changed(f)) {
                    i23 = 131072;
                } else {
                    i23 = 65536;
                }
                i4 |= i23;
            }
            i8 = i4 | 1572864;
            if ((i2 & 12582912) == 0) {
                if ((i3 & 128) == 0) {
                    snapFlingBehavior2 = snapFlingBehavior;
                    if (gapComposer.changed(snapFlingBehavior2)) {
                    }
                    i8 |= i25;
                } else {
                    snapFlingBehavior2 = snapFlingBehavior;
                }
                i8 |= i25;
            } else {
                snapFlingBehavior2 = snapFlingBehavior;
            }
            i9 = i3 & 256;
            if (i9 != 0) {
                i8 |= 100663296;
                z2 = z;
            } else {
                z2 = z;
                if ((i2 & 100663296) == 0) {
                    if (gapComposer.changed(z2)) {
                        i10 = 67108864;
                    } else {
                        i10 = 33554432;
                    }
                    i8 |= i10;
                }
            }
            i11 = i8 | 805306368;
            i12 = i3 & 4096;
            if (i12 != 0) {
                i14 = 197014;
            } else {
                if (gapComposer.changed(snapPosition)) {
                    i13 = 256;
                } else {
                    i13 = 128;
                }
                i14 = 196630 | i13;
            }
            int i2110 = i14 | 1024;
            if ((i3 & 16384) == 0) {
                bringIntoViewSpec2 = bringIntoViewSpec;
                if (gapComposer.changed(bringIntoViewSpec2)) {
                }
                i15 = i2110 | i27;
                z3 = true;
                if ((i11 & 306783379) == 306783378) {
                    z4 = true;
                } else {
                    z4 = true;
                }
                if (gapComposer.shouldExecute(i11 & 1, z4)) {
                    gapComposer.startDefaults();
                    i17 = i2 & 1;
                    orientation = Orientation.Horizontal;
                    if (i17 != 0) {
                        if (i24 != 0) {
                            pageSize2 = PageSize.Fill.INSTANCE;
                        }
                        if (i5 != 0) {
                            i18 = 0;
                        } else {
                            i18 = i6;
                        }
                        vertical3 = Alignment.Companion.CenterVertically;
                        if ((i3 & 128) != 0) {
                            orientation2 = orientation;
                            pagerState2 = pagerState;
                            snapFlingBehaviorFlingBehavior = IntMath.flingBehavior(pagerState2, null, null, gapComposer, (i11 & 14) | 196608, 30);
                            i11 &= -29360129;
                        } else {
                            orientation2 = orientation;
                            pagerState2 = pagerState;
                            snapFlingBehaviorFlingBehavior = snapFlingBehavior2;
                        }
                        if (i9 != 0) {
                            z6 = true;
                        } else {
                            z6 = z;
                        }
                        int i2111 = (i11 & 14) | 432;
                        layoutDirection = (LayoutDirection) gapComposer.consume(CompositionLocalsKt.LocalLayoutDirection);
                        snapFlingBehavior4 = snapFlingBehaviorFlingBehavior;
                        zChanged = ((((i2111 & 14) ^ 6) <= 4 && gapComposer.changed(pagerState2)) || (i2111 & 6) == 4) | gapComposer.changed(layoutDirection.ordinal());
                        objRememberedValue = gapComposer.rememberedValue();
                        NeverEqualPolicy neverEqualPolicy8 = Composer.Companion.Empty;
                        if (zChanged) {
                            objRememberedValue = new DefaultPagerNestedScrollConnection(pagerState2, orientation2, layoutDirection);
                            gapComposer.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new DefaultPagerNestedScrollConnection(pagerState2, orientation2, layoutDirection);
                            gapComposer.updateRememberedValue(objRememberedValue);
                        }
                        DefaultPagerNestedScrollConnection defaultPagerNestedScrollConnection8 = (DefaultPagerNestedScrollConnection) objRememberedValue;
                        if (i12 != 0) {
                            snapPosition3 = SnapPosition.Start.INSTANCE;
                        } else {
                            snapPosition3 = snapPosition;
                        }
                        androidEdgeEffectOverscrollEffectRememberOverscrollEffect = OverscrollKt.rememberOverscrollEffect(gapComposer);
                        nestedScrollConnection2 = defaultPagerNestedScrollConnection8;
                        i19 = i15 & (-7281);
                        if ((i3 & 16384) != 0) {
                            i22 = (i11 & 14) | 48;
                            bringIntoViewSpec5 = (BringIntoViewSpec) gapComposer.consume(BringIntoViewSpec_androidKt.LocalBringIntoViewSpec);
                            layoutDirection2 = (LayoutDirection) gapComposer.consume(CompositionLocalsKt.LocalLayoutDirection);
                            if (((i22 & 14) ^ 6) > 4) {
                            }
                            zChanged2 = z3 | gapComposer.changed(bringIntoViewSpec5) | gapComposer.changed(layoutDirection2.ordinal());
                            objRememberedValue2 = gapComposer.rememberedValue();
                            if (zChanged2) {
                                objRememberedValue2 = new DefaultPagerBringIntoViewSpec(pagerState2, bringIntoViewSpec5, layoutDirection2);
                                gapComposer.updateRememberedValue(objRememberedValue2);
                            } else {
                                objRememberedValue2 = new DefaultPagerBringIntoViewSpec(pagerState2, bringIntoViewSpec5, layoutDirection2);
                                gapComposer.updateRememberedValue(objRememberedValue2);
                            }
                            bringIntoViewSpec4 = (DefaultPagerBringIntoViewSpec) objRememberedValue2;
                            i20 = i15 & (-64625);
                        } else {
                            bringIntoViewSpec4 = bringIntoViewSpec2;
                            i20 = i19;
                        }
                        i21 = i11;
                        z7 = z6;
                        snapPosition4 = snapPosition3;
                    } else {
                        if (i24 != 0) {
                            pageSize2 = PageSize.Fill.INSTANCE;
                        }
                        if (i5 != 0) {
                            i18 = 0;
                        } else {
                            i18 = i6;
                        }
                        vertical3 = Alignment.Companion.CenterVertically;
                        if ((i3 & 128) != 0) {
                            orientation2 = orientation;
                            pagerState2 = pagerState;
                            snapFlingBehaviorFlingBehavior = IntMath.flingBehavior(pagerState2, null, null, gapComposer, (i11 & 14) | 196608, 30);
                            i11 &= -29360129;
                        } else {
                            orientation2 = orientation;
                            pagerState2 = pagerState;
                            snapFlingBehaviorFlingBehavior = snapFlingBehavior2;
                        }
                        if (i9 != 0) {
                            z6 = true;
                        } else {
                            z6 = z;
                        }
                        int i2112 = (i11 & 14) | 432;
                        layoutDirection = (LayoutDirection) gapComposer.consume(CompositionLocalsKt.LocalLayoutDirection);
                        snapFlingBehavior4 = snapFlingBehaviorFlingBehavior;
                        zChanged = ((((i2112 & 14) ^ 6) <= 4 && gapComposer.changed(pagerState2)) || (i2112 & 6) == 4) | gapComposer.changed(layoutDirection.ordinal());
                        objRememberedValue = gapComposer.rememberedValue();
                        NeverEqualPolicy neverEqualPolicy9 = Composer.Companion.Empty;
                        if (zChanged) {
                            objRememberedValue = new DefaultPagerNestedScrollConnection(pagerState2, orientation2, layoutDirection);
                            gapComposer.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new DefaultPagerNestedScrollConnection(pagerState2, orientation2, layoutDirection);
                            gapComposer.updateRememberedValue(objRememberedValue);
                        }
                        DefaultPagerNestedScrollConnection defaultPagerNestedScrollConnection9 = (DefaultPagerNestedScrollConnection) objRememberedValue;
                        if (i12 != 0) {
                            snapPosition3 = SnapPosition.Start.INSTANCE;
                        } else {
                            snapPosition3 = snapPosition;
                        }
                        androidEdgeEffectOverscrollEffectRememberOverscrollEffect = OverscrollKt.rememberOverscrollEffect(gapComposer);
                        nestedScrollConnection2 = defaultPagerNestedScrollConnection9;
                        i19 = i15 & (-7281);
                        if ((i3 & 16384) != 0) {
                            i22 = (i11 & 14) | 48;
                            bringIntoViewSpec5 = (BringIntoViewSpec) gapComposer.consume(BringIntoViewSpec_androidKt.LocalBringIntoViewSpec);
                            layoutDirection2 = (LayoutDirection) gapComposer.consume(CompositionLocalsKt.LocalLayoutDirection);
                            if (((i22 & 14) ^ 6) > 4) {
                            }
                            zChanged2 = z3 | gapComposer.changed(bringIntoViewSpec5) | gapComposer.changed(layoutDirection2.ordinal());
                            objRememberedValue2 = gapComposer.rememberedValue();
                            if (zChanged2) {
                                objRememberedValue2 = new DefaultPagerBringIntoViewSpec(pagerState2, bringIntoViewSpec5, layoutDirection2);
                                gapComposer.updateRememberedValue(objRememberedValue2);
                            } else {
                                objRememberedValue2 = new DefaultPagerBringIntoViewSpec(pagerState2, bringIntoViewSpec5, layoutDirection2);
                                gapComposer.updateRememberedValue(objRememberedValue2);
                            }
                            bringIntoViewSpec4 = (DefaultPagerBringIntoViewSpec) objRememberedValue2;
                            i20 = i15 & (-64625);
                        } else {
                            bringIntoViewSpec4 = bringIntoViewSpec2;
                            i20 = i19;
                        }
                        i21 = i11;
                        z7 = z6;
                        snapPosition4 = snapPosition3;
                    }
                    gapComposer.endDefaults();
                    int i2113 = i21 >> 6;
                    int i34 = i21 << 12;
                    PageSize pageSize8 = pageSize2;
                    Alignment.Vertical vertical8 = vertical3;
                    SizeKt.m861PagerWMpiP2s(modifier, pagerState, paddingValuesImpl, orientation2, snapFlingBehavior4, z7, androidEdgeEffectOverscrollEffectRememberOverscrollEffect, i18, f, pageSize8, nestedScrollConnection2, Alignment.Companion.CenterHorizontally, vertical8, snapPosition4, bringIntoViewSpec4, composableLambdaImpl, gapComposer, (i21 & 896) | ((i21 >> 3) & 14) | 24576 | ((i21 << 3) & 112) | ((i21 >> 18) & 7168) | (i2113 & 458752) | (i2113 & 3670016) | (i34 & 234881024) | (i34 & 1879048192), ((i20 << 9) & 458752) | ((i21 >> 9) & 14) | 3456 | (i2113 & 57344) | ((i20 << 6) & 3670016) | 12582912);
                    gapComposer = gapComposer;
                    snapFlingBehavior3 = snapFlingBehavior4;
                    pageSize3 = pageSize8;
                    snapPosition2 = snapPosition4;
                    bringIntoViewSpec3 = bringIntoViewSpec4;
                    z5 = z7;
                    i16 = i18;
                    vertical2 = vertical8;
                    androidEdgeEffectOverscrollEffect2 = androidEdgeEffectOverscrollEffectRememberOverscrollEffect;
                } else {
                    gapComposer.skipToGroupEnd();
                    vertical2 = vertical;
                    z5 = z;
                    nestedScrollConnection2 = nestedScrollConnection;
                    snapFlingBehavior3 = snapFlingBehavior2;
                    bringIntoViewSpec3 = bringIntoViewSpec2;
                    snapPosition2 = snapPosition;
                    i16 = i6;
                    pageSize3 = pageSize2;
                    androidEdgeEffectOverscrollEffect2 = androidEdgeEffectOverscrollEffect;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.foundation.pager.PagerKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            ((Integer) obj2).getClass();
                            int iUpdateChangedFlags = Stack.updateChangedFlags(i2 | 1);
                            MathKt.m1872HorizontalPagerIOMxRjY(pagerState, modifier, paddingValuesImpl, pageSize3, i16, f, vertical2, snapFlingBehavior3, z5, nestedScrollConnection2, snapPosition2, androidEdgeEffectOverscrollEffect2, bringIntoViewSpec3, composableLambdaImpl, (Composer) obj, iUpdateChangedFlags, i3);
                            return Unit.INSTANCE;
                        }
                    };
                }
            }
            bringIntoViewSpec2 = bringIntoViewSpec;
            i15 = i2110 | i27;
            z3 = true;
            if ((i11 & 306783379) == 306783378) {
                z4 = true;
            } else {
                z4 = true;
            }
            if (gapComposer.shouldExecute(i11 & 1, z4)) {
                gapComposer.startDefaults();
                i17 = i2 & 1;
                orientation = Orientation.Horizontal;
                if (i17 != 0) {
                    if (i24 != 0) {
                        pageSize2 = PageSize.Fill.INSTANCE;
                    }
                    if (i5 != 0) {
                        i18 = 0;
                    } else {
                        i18 = i6;
                    }
                    vertical3 = Alignment.Companion.CenterVertically;
                    if ((i3 & 128) != 0) {
                        orientation2 = orientation;
                        pagerState2 = pagerState;
                        snapFlingBehaviorFlingBehavior = IntMath.flingBehavior(pagerState2, null, null, gapComposer, (i11 & 14) | 196608, 30);
                        i11 &= -29360129;
                    } else {
                        orientation2 = orientation;
                        pagerState2 = pagerState;
                        snapFlingBehaviorFlingBehavior = snapFlingBehavior2;
                    }
                    if (i9 != 0) {
                        z6 = true;
                    } else {
                        z6 = z;
                    }
                    int i2114 = (i11 & 14) | 432;
                    layoutDirection = (LayoutDirection) gapComposer.consume(CompositionLocalsKt.LocalLayoutDirection);
                    snapFlingBehavior4 = snapFlingBehaviorFlingBehavior;
                    zChanged = ((((i2114 & 14) ^ 6) <= 4 && gapComposer.changed(pagerState2)) || (i2114 & 6) == 4) | gapComposer.changed(layoutDirection.ordinal());
                    objRememberedValue = gapComposer.rememberedValue();
                    NeverEqualPolicy neverEqualPolicy10 = Composer.Companion.Empty;
                    if (zChanged) {
                        objRememberedValue = new DefaultPagerNestedScrollConnection(pagerState2, orientation2, layoutDirection);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new DefaultPagerNestedScrollConnection(pagerState2, orientation2, layoutDirection);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    DefaultPagerNestedScrollConnection defaultPagerNestedScrollConnection10 = (DefaultPagerNestedScrollConnection) objRememberedValue;
                    if (i12 != 0) {
                        snapPosition3 = SnapPosition.Start.INSTANCE;
                    } else {
                        snapPosition3 = snapPosition;
                    }
                    androidEdgeEffectOverscrollEffectRememberOverscrollEffect = OverscrollKt.rememberOverscrollEffect(gapComposer);
                    nestedScrollConnection2 = defaultPagerNestedScrollConnection10;
                    i19 = i15 & (-7281);
                    if ((i3 & 16384) != 0) {
                        i22 = (i11 & 14) | 48;
                        bringIntoViewSpec5 = (BringIntoViewSpec) gapComposer.consume(BringIntoViewSpec_androidKt.LocalBringIntoViewSpec);
                        layoutDirection2 = (LayoutDirection) gapComposer.consume(CompositionLocalsKt.LocalLayoutDirection);
                        if (((i22 & 14) ^ 6) > 4) {
                        }
                        zChanged2 = z3 | gapComposer.changed(bringIntoViewSpec5) | gapComposer.changed(layoutDirection2.ordinal());
                        objRememberedValue2 = gapComposer.rememberedValue();
                        if (zChanged2) {
                            objRememberedValue2 = new DefaultPagerBringIntoViewSpec(pagerState2, bringIntoViewSpec5, layoutDirection2);
                            gapComposer.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new DefaultPagerBringIntoViewSpec(pagerState2, bringIntoViewSpec5, layoutDirection2);
                            gapComposer.updateRememberedValue(objRememberedValue2);
                        }
                        bringIntoViewSpec4 = (DefaultPagerBringIntoViewSpec) objRememberedValue2;
                        i20 = i15 & (-64625);
                    } else {
                        bringIntoViewSpec4 = bringIntoViewSpec2;
                        i20 = i19;
                    }
                    i21 = i11;
                    z7 = z6;
                    snapPosition4 = snapPosition3;
                } else {
                    if (i24 != 0) {
                        pageSize2 = PageSize.Fill.INSTANCE;
                    }
                    if (i5 != 0) {
                        i18 = 0;
                    } else {
                        i18 = i6;
                    }
                    vertical3 = Alignment.Companion.CenterVertically;
                    if ((i3 & 128) != 0) {
                        orientation2 = orientation;
                        pagerState2 = pagerState;
                        snapFlingBehaviorFlingBehavior = IntMath.flingBehavior(pagerState2, null, null, gapComposer, (i11 & 14) | 196608, 30);
                        i11 &= -29360129;
                    } else {
                        orientation2 = orientation;
                        pagerState2 = pagerState;
                        snapFlingBehaviorFlingBehavior = snapFlingBehavior2;
                    }
                    if (i9 != 0) {
                        z6 = true;
                    } else {
                        z6 = z;
                    }
                    int i2115 = (i11 & 14) | 432;
                    layoutDirection = (LayoutDirection) gapComposer.consume(CompositionLocalsKt.LocalLayoutDirection);
                    snapFlingBehavior4 = snapFlingBehaviorFlingBehavior;
                    zChanged = ((((i2115 & 14) ^ 6) <= 4 && gapComposer.changed(pagerState2)) || (i2115 & 6) == 4) | gapComposer.changed(layoutDirection.ordinal());
                    objRememberedValue = gapComposer.rememberedValue();
                    NeverEqualPolicy neverEqualPolicy11 = Composer.Companion.Empty;
                    if (zChanged) {
                        objRememberedValue = new DefaultPagerNestedScrollConnection(pagerState2, orientation2, layoutDirection);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new DefaultPagerNestedScrollConnection(pagerState2, orientation2, layoutDirection);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    DefaultPagerNestedScrollConnection defaultPagerNestedScrollConnection11 = (DefaultPagerNestedScrollConnection) objRememberedValue;
                    if (i12 != 0) {
                        snapPosition3 = SnapPosition.Start.INSTANCE;
                    } else {
                        snapPosition3 = snapPosition;
                    }
                    androidEdgeEffectOverscrollEffectRememberOverscrollEffect = OverscrollKt.rememberOverscrollEffect(gapComposer);
                    nestedScrollConnection2 = defaultPagerNestedScrollConnection11;
                    i19 = i15 & (-7281);
                    if ((i3 & 16384) != 0) {
                        i22 = (i11 & 14) | 48;
                        bringIntoViewSpec5 = (BringIntoViewSpec) gapComposer.consume(BringIntoViewSpec_androidKt.LocalBringIntoViewSpec);
                        layoutDirection2 = (LayoutDirection) gapComposer.consume(CompositionLocalsKt.LocalLayoutDirection);
                        if (((i22 & 14) ^ 6) > 4) {
                        }
                        zChanged2 = z3 | gapComposer.changed(bringIntoViewSpec5) | gapComposer.changed(layoutDirection2.ordinal());
                        objRememberedValue2 = gapComposer.rememberedValue();
                        if (zChanged2) {
                            objRememberedValue2 = new DefaultPagerBringIntoViewSpec(pagerState2, bringIntoViewSpec5, layoutDirection2);
                            gapComposer.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new DefaultPagerBringIntoViewSpec(pagerState2, bringIntoViewSpec5, layoutDirection2);
                            gapComposer.updateRememberedValue(objRememberedValue2);
                        }
                        bringIntoViewSpec4 = (DefaultPagerBringIntoViewSpec) objRememberedValue2;
                        i20 = i15 & (-64625);
                    } else {
                        bringIntoViewSpec4 = bringIntoViewSpec2;
                        i20 = i19;
                    }
                    i21 = i11;
                    z7 = z6;
                    snapPosition4 = snapPosition3;
                }
                gapComposer.endDefaults();
                int i2116 = i21 >> 6;
                int i35 = i21 << 12;
                PageSize pageSize9 = pageSize2;
                Alignment.Vertical vertical9 = vertical3;
                SizeKt.m861PagerWMpiP2s(modifier, pagerState, paddingValuesImpl, orientation2, snapFlingBehavior4, z7, androidEdgeEffectOverscrollEffectRememberOverscrollEffect, i18, f, pageSize9, nestedScrollConnection2, Alignment.Companion.CenterHorizontally, vertical9, snapPosition4, bringIntoViewSpec4, composableLambdaImpl, gapComposer, (i21 & 896) | ((i21 >> 3) & 14) | 24576 | ((i21 << 3) & 112) | ((i21 >> 18) & 7168) | (i2116 & 458752) | (i2116 & 3670016) | (i35 & 234881024) | (i35 & 1879048192), ((i20 << 9) & 458752) | ((i21 >> 9) & 14) | 3456 | (i2116 & 57344) | ((i20 << 6) & 3670016) | 12582912);
                gapComposer = gapComposer;
                snapFlingBehavior3 = snapFlingBehavior4;
                pageSize3 = pageSize9;
                snapPosition2 = snapPosition4;
                bringIntoViewSpec3 = bringIntoViewSpec4;
                z5 = z7;
                i16 = i18;
                vertical2 = vertical9;
                androidEdgeEffectOverscrollEffect2 = androidEdgeEffectOverscrollEffectRememberOverscrollEffect;
            } else {
                gapComposer.skipToGroupEnd();
                vertical2 = vertical;
                z5 = z;
                nestedScrollConnection2 = nestedScrollConnection;
                snapFlingBehavior3 = snapFlingBehavior2;
                bringIntoViewSpec3 = bringIntoViewSpec2;
                snapPosition2 = snapPosition;
                i16 = i6;
                pageSize3 = pageSize2;
                androidEdgeEffectOverscrollEffect2 = androidEdgeEffectOverscrollEffect;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.foundation.pager.PagerKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        int iUpdateChangedFlags = Stack.updateChangedFlags(i2 | 1);
                        MathKt.m1872HorizontalPagerIOMxRjY(pagerState, modifier, paddingValuesImpl, pageSize3, i16, f, vertical2, snapFlingBehavior3, z5, nestedScrollConnection2, snapPosition2, androidEdgeEffectOverscrollEffect2, bringIntoViewSpec3, composableLambdaImpl, (Composer) obj, iUpdateChangedFlags, i3);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i4 |= 24576;
        i6 = i;
        if ((i2 & 196608) == 0) {
            if (gapComposer.changed(f)) {
                i23 = 131072;
            } else {
                i23 = 65536;
            }
            i4 |= i23;
        }
        i8 = i4 | 1572864;
        if ((i2 & 12582912) == 0) {
            if ((i3 & 128) == 0) {
                snapFlingBehavior2 = snapFlingBehavior;
                if (gapComposer.changed(snapFlingBehavior2)) {
                }
                i8 |= i25;
            } else {
                snapFlingBehavior2 = snapFlingBehavior;
            }
            i8 |= i25;
        } else {
            snapFlingBehavior2 = snapFlingBehavior;
        }
        i9 = i3 & 256;
        if (i9 != 0) {
            i8 |= 100663296;
            z2 = z;
        } else {
            z2 = z;
            if ((i2 & 100663296) == 0) {
                if (gapComposer.changed(z2)) {
                    i10 = 67108864;
                } else {
                    i10 = 33554432;
                }
                i8 |= i10;
            }
        }
        i11 = i8 | 805306368;
        i12 = i3 & 4096;
        if (i12 != 0) {
            i14 = 197014;
        } else {
            if (gapComposer.changed(snapPosition)) {
                i13 = 256;
            } else {
                i13 = 128;
            }
            i14 = 196630 | i13;
        }
        int i2117 = i14 | 1024;
        if ((i3 & 16384) == 0) {
            bringIntoViewSpec2 = bringIntoViewSpec;
            if (gapComposer.changed(bringIntoViewSpec2)) {
            }
            i15 = i2117 | i27;
            z3 = true;
            if ((i11 & 306783379) == 306783378) {
                z4 = true;
            } else {
                z4 = true;
            }
            if (gapComposer.shouldExecute(i11 & 1, z4)) {
                gapComposer.startDefaults();
                i17 = i2 & 1;
                orientation = Orientation.Horizontal;
                if (i17 != 0) {
                    if (i24 != 0) {
                        pageSize2 = PageSize.Fill.INSTANCE;
                    }
                    if (i5 != 0) {
                        i18 = 0;
                    } else {
                        i18 = i6;
                    }
                    vertical3 = Alignment.Companion.CenterVertically;
                    if ((i3 & 128) != 0) {
                        orientation2 = orientation;
                        pagerState2 = pagerState;
                        snapFlingBehaviorFlingBehavior = IntMath.flingBehavior(pagerState2, null, null, gapComposer, (i11 & 14) | 196608, 30);
                        i11 &= -29360129;
                    } else {
                        orientation2 = orientation;
                        pagerState2 = pagerState;
                        snapFlingBehaviorFlingBehavior = snapFlingBehavior2;
                    }
                    if (i9 != 0) {
                        z6 = true;
                    } else {
                        z6 = z;
                    }
                    int i2118 = (i11 & 14) | 432;
                    layoutDirection = (LayoutDirection) gapComposer.consume(CompositionLocalsKt.LocalLayoutDirection);
                    snapFlingBehavior4 = snapFlingBehaviorFlingBehavior;
                    zChanged = ((((i2118 & 14) ^ 6) <= 4 && gapComposer.changed(pagerState2)) || (i2118 & 6) == 4) | gapComposer.changed(layoutDirection.ordinal());
                    objRememberedValue = gapComposer.rememberedValue();
                    NeverEqualPolicy neverEqualPolicy12 = Composer.Companion.Empty;
                    if (zChanged) {
                        objRememberedValue = new DefaultPagerNestedScrollConnection(pagerState2, orientation2, layoutDirection);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new DefaultPagerNestedScrollConnection(pagerState2, orientation2, layoutDirection);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    DefaultPagerNestedScrollConnection defaultPagerNestedScrollConnection12 = (DefaultPagerNestedScrollConnection) objRememberedValue;
                    if (i12 != 0) {
                        snapPosition3 = SnapPosition.Start.INSTANCE;
                    } else {
                        snapPosition3 = snapPosition;
                    }
                    androidEdgeEffectOverscrollEffectRememberOverscrollEffect = OverscrollKt.rememberOverscrollEffect(gapComposer);
                    nestedScrollConnection2 = defaultPagerNestedScrollConnection12;
                    i19 = i15 & (-7281);
                    if ((i3 & 16384) != 0) {
                        i22 = (i11 & 14) | 48;
                        bringIntoViewSpec5 = (BringIntoViewSpec) gapComposer.consume(BringIntoViewSpec_androidKt.LocalBringIntoViewSpec);
                        layoutDirection2 = (LayoutDirection) gapComposer.consume(CompositionLocalsKt.LocalLayoutDirection);
                        if (((i22 & 14) ^ 6) > 4) {
                        }
                        zChanged2 = z3 | gapComposer.changed(bringIntoViewSpec5) | gapComposer.changed(layoutDirection2.ordinal());
                        objRememberedValue2 = gapComposer.rememberedValue();
                        if (zChanged2) {
                            objRememberedValue2 = new DefaultPagerBringIntoViewSpec(pagerState2, bringIntoViewSpec5, layoutDirection2);
                            gapComposer.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new DefaultPagerBringIntoViewSpec(pagerState2, bringIntoViewSpec5, layoutDirection2);
                            gapComposer.updateRememberedValue(objRememberedValue2);
                        }
                        bringIntoViewSpec4 = (DefaultPagerBringIntoViewSpec) objRememberedValue2;
                        i20 = i15 & (-64625);
                    } else {
                        bringIntoViewSpec4 = bringIntoViewSpec2;
                        i20 = i19;
                    }
                    i21 = i11;
                    z7 = z6;
                    snapPosition4 = snapPosition3;
                } else {
                    if (i24 != 0) {
                        pageSize2 = PageSize.Fill.INSTANCE;
                    }
                    if (i5 != 0) {
                        i18 = 0;
                    } else {
                        i18 = i6;
                    }
                    vertical3 = Alignment.Companion.CenterVertically;
                    if ((i3 & 128) != 0) {
                        orientation2 = orientation;
                        pagerState2 = pagerState;
                        snapFlingBehaviorFlingBehavior = IntMath.flingBehavior(pagerState2, null, null, gapComposer, (i11 & 14) | 196608, 30);
                        i11 &= -29360129;
                    } else {
                        orientation2 = orientation;
                        pagerState2 = pagerState;
                        snapFlingBehaviorFlingBehavior = snapFlingBehavior2;
                    }
                    if (i9 != 0) {
                        z6 = true;
                    } else {
                        z6 = z;
                    }
                    int i2119 = (i11 & 14) | 432;
                    layoutDirection = (LayoutDirection) gapComposer.consume(CompositionLocalsKt.LocalLayoutDirection);
                    snapFlingBehavior4 = snapFlingBehaviorFlingBehavior;
                    zChanged = ((((i2119 & 14) ^ 6) <= 4 && gapComposer.changed(pagerState2)) || (i2119 & 6) == 4) | gapComposer.changed(layoutDirection.ordinal());
                    objRememberedValue = gapComposer.rememberedValue();
                    NeverEqualPolicy neverEqualPolicy13 = Composer.Companion.Empty;
                    if (zChanged) {
                        objRememberedValue = new DefaultPagerNestedScrollConnection(pagerState2, orientation2, layoutDirection);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new DefaultPagerNestedScrollConnection(pagerState2, orientation2, layoutDirection);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    DefaultPagerNestedScrollConnection defaultPagerNestedScrollConnection13 = (DefaultPagerNestedScrollConnection) objRememberedValue;
                    if (i12 != 0) {
                        snapPosition3 = SnapPosition.Start.INSTANCE;
                    } else {
                        snapPosition3 = snapPosition;
                    }
                    androidEdgeEffectOverscrollEffectRememberOverscrollEffect = OverscrollKt.rememberOverscrollEffect(gapComposer);
                    nestedScrollConnection2 = defaultPagerNestedScrollConnection13;
                    i19 = i15 & (-7281);
                    if ((i3 & 16384) != 0) {
                        i22 = (i11 & 14) | 48;
                        bringIntoViewSpec5 = (BringIntoViewSpec) gapComposer.consume(BringIntoViewSpec_androidKt.LocalBringIntoViewSpec);
                        layoutDirection2 = (LayoutDirection) gapComposer.consume(CompositionLocalsKt.LocalLayoutDirection);
                        if (((i22 & 14) ^ 6) > 4) {
                        }
                        zChanged2 = z3 | gapComposer.changed(bringIntoViewSpec5) | gapComposer.changed(layoutDirection2.ordinal());
                        objRememberedValue2 = gapComposer.rememberedValue();
                        if (zChanged2) {
                            objRememberedValue2 = new DefaultPagerBringIntoViewSpec(pagerState2, bringIntoViewSpec5, layoutDirection2);
                            gapComposer.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new DefaultPagerBringIntoViewSpec(pagerState2, bringIntoViewSpec5, layoutDirection2);
                            gapComposer.updateRememberedValue(objRememberedValue2);
                        }
                        bringIntoViewSpec4 = (DefaultPagerBringIntoViewSpec) objRememberedValue2;
                        i20 = i15 & (-64625);
                    } else {
                        bringIntoViewSpec4 = bringIntoViewSpec2;
                        i20 = i19;
                    }
                    i21 = i11;
                    z7 = z6;
                    snapPosition4 = snapPosition3;
                }
                gapComposer.endDefaults();
                int i21110 = i21 >> 6;
                int i36 = i21 << 12;
                PageSize pageSize10 = pageSize2;
                Alignment.Vertical vertical10 = vertical3;
                SizeKt.m861PagerWMpiP2s(modifier, pagerState, paddingValuesImpl, orientation2, snapFlingBehavior4, z7, androidEdgeEffectOverscrollEffectRememberOverscrollEffect, i18, f, pageSize10, nestedScrollConnection2, Alignment.Companion.CenterHorizontally, vertical10, snapPosition4, bringIntoViewSpec4, composableLambdaImpl, gapComposer, (i21 & 896) | ((i21 >> 3) & 14) | 24576 | ((i21 << 3) & 112) | ((i21 >> 18) & 7168) | (i21110 & 458752) | (i21110 & 3670016) | (i36 & 234881024) | (i36 & 1879048192), ((i20 << 9) & 458752) | ((i21 >> 9) & 14) | 3456 | (i21110 & 57344) | ((i20 << 6) & 3670016) | 12582912);
                gapComposer = gapComposer;
                snapFlingBehavior3 = snapFlingBehavior4;
                pageSize3 = pageSize10;
                snapPosition2 = snapPosition4;
                bringIntoViewSpec3 = bringIntoViewSpec4;
                z5 = z7;
                i16 = i18;
                vertical2 = vertical10;
                androidEdgeEffectOverscrollEffect2 = androidEdgeEffectOverscrollEffectRememberOverscrollEffect;
            } else {
                gapComposer.skipToGroupEnd();
                vertical2 = vertical;
                z5 = z;
                nestedScrollConnection2 = nestedScrollConnection;
                snapFlingBehavior3 = snapFlingBehavior2;
                bringIntoViewSpec3 = bringIntoViewSpec2;
                snapPosition2 = snapPosition;
                i16 = i6;
                pageSize3 = pageSize2;
                androidEdgeEffectOverscrollEffect2 = androidEdgeEffectOverscrollEffect;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.foundation.pager.PagerKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        int iUpdateChangedFlags = Stack.updateChangedFlags(i2 | 1);
                        MathKt.m1872HorizontalPagerIOMxRjY(pagerState, modifier, paddingValuesImpl, pageSize3, i16, f, vertical2, snapFlingBehavior3, z5, nestedScrollConnection2, snapPosition2, androidEdgeEffectOverscrollEffect2, bringIntoViewSpec3, composableLambdaImpl, (Composer) obj, iUpdateChangedFlags, i3);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        bringIntoViewSpec2 = bringIntoViewSpec;
        i15 = i2117 | i27;
        z3 = true;
        if ((i11 & 306783379) == 306783378) {
            z4 = true;
        } else {
            z4 = true;
        }
        if (gapComposer.shouldExecute(i11 & 1, z4)) {
            gapComposer.startDefaults();
            i17 = i2 & 1;
            orientation = Orientation.Horizontal;
            if (i17 != 0) {
                if (i24 != 0) {
                    pageSize2 = PageSize.Fill.INSTANCE;
                }
                if (i5 != 0) {
                    i18 = 0;
                } else {
                    i18 = i6;
                }
                vertical3 = Alignment.Companion.CenterVertically;
                if ((i3 & 128) != 0) {
                    orientation2 = orientation;
                    pagerState2 = pagerState;
                    snapFlingBehaviorFlingBehavior = IntMath.flingBehavior(pagerState2, null, null, gapComposer, (i11 & 14) | 196608, 30);
                    i11 &= -29360129;
                } else {
                    orientation2 = orientation;
                    pagerState2 = pagerState;
                    snapFlingBehaviorFlingBehavior = snapFlingBehavior2;
                }
                if (i9 != 0) {
                    z6 = true;
                } else {
                    z6 = z;
                }
                int i21111 = (i11 & 14) | 432;
                layoutDirection = (LayoutDirection) gapComposer.consume(CompositionLocalsKt.LocalLayoutDirection);
                snapFlingBehavior4 = snapFlingBehaviorFlingBehavior;
                zChanged = ((((i21111 & 14) ^ 6) <= 4 && gapComposer.changed(pagerState2)) || (i21111 & 6) == 4) | gapComposer.changed(layoutDirection.ordinal());
                objRememberedValue = gapComposer.rememberedValue();
                NeverEqualPolicy neverEqualPolicy14 = Composer.Companion.Empty;
                if (zChanged) {
                    objRememberedValue = new DefaultPagerNestedScrollConnection(pagerState2, orientation2, layoutDirection);
                    gapComposer.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new DefaultPagerNestedScrollConnection(pagerState2, orientation2, layoutDirection);
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                DefaultPagerNestedScrollConnection defaultPagerNestedScrollConnection14 = (DefaultPagerNestedScrollConnection) objRememberedValue;
                if (i12 != 0) {
                    snapPosition3 = SnapPosition.Start.INSTANCE;
                } else {
                    snapPosition3 = snapPosition;
                }
                androidEdgeEffectOverscrollEffectRememberOverscrollEffect = OverscrollKt.rememberOverscrollEffect(gapComposer);
                nestedScrollConnection2 = defaultPagerNestedScrollConnection14;
                i19 = i15 & (-7281);
                if ((i3 & 16384) != 0) {
                    i22 = (i11 & 14) | 48;
                    bringIntoViewSpec5 = (BringIntoViewSpec) gapComposer.consume(BringIntoViewSpec_androidKt.LocalBringIntoViewSpec);
                    layoutDirection2 = (LayoutDirection) gapComposer.consume(CompositionLocalsKt.LocalLayoutDirection);
                    if (((i22 & 14) ^ 6) > 4) {
                    }
                    zChanged2 = z3 | gapComposer.changed(bringIntoViewSpec5) | gapComposer.changed(layoutDirection2.ordinal());
                    objRememberedValue2 = gapComposer.rememberedValue();
                    if (zChanged2) {
                        objRememberedValue2 = new DefaultPagerBringIntoViewSpec(pagerState2, bringIntoViewSpec5, layoutDirection2);
                        gapComposer.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new DefaultPagerBringIntoViewSpec(pagerState2, bringIntoViewSpec5, layoutDirection2);
                        gapComposer.updateRememberedValue(objRememberedValue2);
                    }
                    bringIntoViewSpec4 = (DefaultPagerBringIntoViewSpec) objRememberedValue2;
                    i20 = i15 & (-64625);
                } else {
                    bringIntoViewSpec4 = bringIntoViewSpec2;
                    i20 = i19;
                }
                i21 = i11;
                z7 = z6;
                snapPosition4 = snapPosition3;
            } else {
                if (i24 != 0) {
                    pageSize2 = PageSize.Fill.INSTANCE;
                }
                if (i5 != 0) {
                    i18 = 0;
                } else {
                    i18 = i6;
                }
                vertical3 = Alignment.Companion.CenterVertically;
                if ((i3 & 128) != 0) {
                    orientation2 = orientation;
                    pagerState2 = pagerState;
                    snapFlingBehaviorFlingBehavior = IntMath.flingBehavior(pagerState2, null, null, gapComposer, (i11 & 14) | 196608, 30);
                    i11 &= -29360129;
                } else {
                    orientation2 = orientation;
                    pagerState2 = pagerState;
                    snapFlingBehaviorFlingBehavior = snapFlingBehavior2;
                }
                if (i9 != 0) {
                    z6 = true;
                } else {
                    z6 = z;
                }
                int i21112 = (i11 & 14) | 432;
                layoutDirection = (LayoutDirection) gapComposer.consume(CompositionLocalsKt.LocalLayoutDirection);
                snapFlingBehavior4 = snapFlingBehaviorFlingBehavior;
                zChanged = ((((i21112 & 14) ^ 6) <= 4 && gapComposer.changed(pagerState2)) || (i21112 & 6) == 4) | gapComposer.changed(layoutDirection.ordinal());
                objRememberedValue = gapComposer.rememberedValue();
                NeverEqualPolicy neverEqualPolicy15 = Composer.Companion.Empty;
                if (zChanged) {
                    objRememberedValue = new DefaultPagerNestedScrollConnection(pagerState2, orientation2, layoutDirection);
                    gapComposer.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new DefaultPagerNestedScrollConnection(pagerState2, orientation2, layoutDirection);
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                DefaultPagerNestedScrollConnection defaultPagerNestedScrollConnection15 = (DefaultPagerNestedScrollConnection) objRememberedValue;
                if (i12 != 0) {
                    snapPosition3 = SnapPosition.Start.INSTANCE;
                } else {
                    snapPosition3 = snapPosition;
                }
                androidEdgeEffectOverscrollEffectRememberOverscrollEffect = OverscrollKt.rememberOverscrollEffect(gapComposer);
                nestedScrollConnection2 = defaultPagerNestedScrollConnection15;
                i19 = i15 & (-7281);
                if ((i3 & 16384) != 0) {
                    i22 = (i11 & 14) | 48;
                    bringIntoViewSpec5 = (BringIntoViewSpec) gapComposer.consume(BringIntoViewSpec_androidKt.LocalBringIntoViewSpec);
                    layoutDirection2 = (LayoutDirection) gapComposer.consume(CompositionLocalsKt.LocalLayoutDirection);
                    if (((i22 & 14) ^ 6) > 4) {
                    }
                    zChanged2 = z3 | gapComposer.changed(bringIntoViewSpec5) | gapComposer.changed(layoutDirection2.ordinal());
                    objRememberedValue2 = gapComposer.rememberedValue();
                    if (zChanged2) {
                        objRememberedValue2 = new DefaultPagerBringIntoViewSpec(pagerState2, bringIntoViewSpec5, layoutDirection2);
                        gapComposer.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new DefaultPagerBringIntoViewSpec(pagerState2, bringIntoViewSpec5, layoutDirection2);
                        gapComposer.updateRememberedValue(objRememberedValue2);
                    }
                    bringIntoViewSpec4 = (DefaultPagerBringIntoViewSpec) objRememberedValue2;
                    i20 = i15 & (-64625);
                } else {
                    bringIntoViewSpec4 = bringIntoViewSpec2;
                    i20 = i19;
                }
                i21 = i11;
                z7 = z6;
                snapPosition4 = snapPosition3;
            }
            gapComposer.endDefaults();
            int i21113 = i21 >> 6;
            int i37 = i21 << 12;
            PageSize pageSize11 = pageSize2;
            Alignment.Vertical vertical11 = vertical3;
            SizeKt.m861PagerWMpiP2s(modifier, pagerState, paddingValuesImpl, orientation2, snapFlingBehavior4, z7, androidEdgeEffectOverscrollEffectRememberOverscrollEffect, i18, f, pageSize11, nestedScrollConnection2, Alignment.Companion.CenterHorizontally, vertical11, snapPosition4, bringIntoViewSpec4, composableLambdaImpl, gapComposer, (i21 & 896) | ((i21 >> 3) & 14) | 24576 | ((i21 << 3) & 112) | ((i21 >> 18) & 7168) | (i21113 & 458752) | (i21113 & 3670016) | (i37 & 234881024) | (i37 & 1879048192), ((i20 << 9) & 458752) | ((i21 >> 9) & 14) | 3456 | (i21113 & 57344) | ((i20 << 6) & 3670016) | 12582912);
            gapComposer = gapComposer;
            snapFlingBehavior3 = snapFlingBehavior4;
            pageSize3 = pageSize11;
            snapPosition2 = snapPosition4;
            bringIntoViewSpec3 = bringIntoViewSpec4;
            z5 = z7;
            i16 = i18;
            vertical2 = vertical11;
            androidEdgeEffectOverscrollEffect2 = androidEdgeEffectOverscrollEffectRememberOverscrollEffect;
        } else {
            gapComposer.skipToGroupEnd();
            vertical2 = vertical;
            z5 = z;
            nestedScrollConnection2 = nestedScrollConnection;
            snapFlingBehavior3 = snapFlingBehavior2;
            bringIntoViewSpec3 = bringIntoViewSpec2;
            snapPosition2 = snapPosition;
            i16 = i6;
            pageSize3 = pageSize2;
            androidEdgeEffectOverscrollEffect2 = androidEdgeEffectOverscrollEffect;
        }
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.foundation.pager.PagerKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(i2 | 1);
                    MathKt.m1872HorizontalPagerIOMxRjY(pagerState, modifier, paddingValuesImpl, pageSize3, i16, f, vertical2, snapFlingBehavior3, z5, nestedScrollConnection2, snapPosition2, androidEdgeEffectOverscrollEffect2, bringIntoViewSpec3, composableLambdaImpl, (Composer) obj, iUpdateChangedFlags, i3);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static FileImageSource ImageSource$default(Path path, FileSystem fileSystem, String str, RealDiskCache.RealSnapshot realSnapshot, int i) {
        if ((i & 4) != 0) {
            str = null;
        }
        if ((i & 8) != 0) {
            realSnapshot = null;
        }
        return new FileImageSource(path, fileSystem, str, realSnapshot);
    }

    /* JADX WARN: Code duplicated, block: B:108:0x0144  */
    /* JADX WARN: Code duplicated, block: B:110:0x014a  */
    /* JADX WARN: Code duplicated, block: B:118:0x0161  */
    /* JADX WARN: Code duplicated, block: B:121:0x016a  */
    /* JADX WARN: Code duplicated, block: B:127:0x0188 A[PHI: r2 r6 r10 r13
      0x0188: PHI (r2v31 int) = (r2v7 int), (r2v33 int) binds: [B:138:0x01a3, B:126:0x017d] A[DONT_GENERATE, DONT_INLINE]
      0x0188: PHI (r6v18 androidx.compose.ui.Alignment$Horizontal) = (r6v12 androidx.compose.ui.Alignment$Horizontal), (r6v19 androidx.compose.ui.Alignment$Horizontal) binds: [B:138:0x01a3, B:126:0x017d] A[DONT_GENERATE, DONT_INLINE]
      0x0188: PHI (r10v13 androidx.compose.foundation.layout.Arrangement$Vertical) = 
      (r10v5 androidx.compose.foundation.layout.Arrangement$Vertical)
      (r10v14 androidx.compose.foundation.layout.Arrangement$Vertical)
     binds: [B:138:0x01a3, B:126:0x017d] A[DONT_GENERATE, DONT_INLINE]
      0x0188: PHI (r13v6 androidx.compose.ui.Alignment$Vertical) = (r13v3 androidx.compose.ui.Alignment$Vertical), (r13v7 androidx.compose.ui.Alignment$Vertical) binds: [B:138:0x01a3, B:126:0x017d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:128:0x018c  */
    /* JADX WARN: Code duplicated, block: B:130:0x0190  */
    /* JADX WARN: Code duplicated, block: B:131:0x0193  */
    /* JADX WARN: Code duplicated, block: B:133:0x0197  */
    /* JADX WARN: Code duplicated, block: B:134:0x019a  */
    /* JADX WARN: Code duplicated, block: B:136:0x019e  */
    /* JADX WARN: Code duplicated, block: B:137:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:139:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:142:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:144:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:150:0x01d9 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:151:0x01db  */
    /* JADX WARN: Code duplicated, block: B:154:0x0232  */
    /* JADX WARN: Code duplicated, block: B:156:0x0238  */
    /* JADX WARN: Code duplicated, block: B:162:0x0249  */
    /* JADX WARN: Code duplicated, block: B:164:0x024f  */
    /* JADX WARN: Code duplicated, block: B:170:0x025d A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:171:0x025f  */
    /* JADX WARN: Code duplicated, block: B:174:0x0270  */
    /* JADX WARN: Code duplicated, block: B:177:0x028f  */
    /* JADX WARN: Code duplicated, block: B:180:0x02c4  */
    /* JADX WARN: Code duplicated, block: B:182:0x02ca  */
    /* JADX WARN: Code duplicated, block: B:188:0x02d9  */
    /* JADX WARN: Code duplicated, block: B:190:0x02df  */
    /* JADX WARN: Code duplicated, block: B:196:0x02ef  */
    /* JADX WARN: Code duplicated, block: B:198:0x02f6  */
    /* JADX WARN: Code duplicated, block: B:204:0x0308  */
    /* JADX WARN: Code duplicated, block: B:206:0x030e  */
    /* JADX WARN: Code duplicated, block: B:212:0x0324  */
    /* JADX WARN: Code duplicated, block: B:214:0x032a  */
    /* JADX WARN: Code duplicated, block: B:220:0x033a  */
    /* JADX WARN: Code duplicated, block: B:222:0x0340  */
    /* JADX WARN: Code duplicated, block: B:228:0x0350  */
    /* JADX WARN: Code duplicated, block: B:230:0x0356  */
    /* JADX WARN: Code duplicated, block: B:236:0x0366  */
    /* JADX WARN: Code duplicated, block: B:238:0x036c  */
    /* JADX WARN: Code duplicated, block: B:244:0x0385 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:247:0x0395  */
    /* JADX WARN: Code duplicated, block: B:250:0x03b5  */
    /* JADX WARN: Code duplicated, block: B:251:0x03b8  */
    /* JADX WARN: Code duplicated, block: B:253:0x03bc  */
    /* JADX WARN: Code duplicated, block: B:255:0x03c8  */
    /* JADX WARN: Code duplicated, block: B:257:0x03ce  */
    /* JADX WARN: Code duplicated, block: B:264:0x03e2 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:265:0x03e4  */
    /* JADX WARN: Code duplicated, block: B:268:0x03fb  */
    /* JADX WARN: Code duplicated, block: B:270:0x040a  */
    /* JADX WARN: Code duplicated, block: B:271:0x040c  */
    /* JADX WARN: Code duplicated, block: B:274:0x0413 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:275:0x0415  */
    /* JADX WARN: Code duplicated, block: B:277:0x0465  */
    /* JADX WARN: Code duplicated, block: B:280:0x047a  */
    /* JADX WARN: Code duplicated, block: B:282:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:121:0x016a, please report this as an issue */
    public static final void LazyList(Modifier modifier, final LazyListState lazyListState, final PaddingValues paddingValues, final boolean z, final FlingBehavior flingBehavior, final boolean z2, final AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect, Alignment.Horizontal horizontal, Arrangement$Vertical arrangement$Vertical, Alignment.Vertical vertical, Arrangement$Horizontal arrangement$Horizontal, final Function1 function1, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        int i5;
        boolean z3;
        Modifier modifier2;
        LazyListState lazyListState2;
        GapComposer gapComposer;
        final Alignment.Horizontal horizontal2;
        final Arrangement$Vertical arrangement$Vertical2;
        final Alignment.Vertical vertical2;
        final Arrangement$Horizontal arrangement$Horizontal2;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        int i6;
        Alignment.Horizontal horizontal3;
        Arrangement$Vertical arrangement$Vertical3;
        final Alignment.Vertical vertical3;
        final Arrangement$Horizontal arrangement$Horizontal3;
        int i7;
        MutableState mutableStateRememberUpdatedState;
        boolean z4;
        Object objRememberedValue;
        NeverEqualPolicy neverEqualPolicy;
        final KProperty0 kProperty0;
        boolean z5;
        Object objRememberedValue2;
        Object objRememberedValue3;
        final CoroutineScope coroutineScope;
        final GraphicsContext graphicsContext;
        final CachedItem.NoKey noKey;
        int i8;
        boolean zChanged;
        Object obj;
        GapComposer gapComposer2;
        final LazyListState lazyListState3;
        int i9;
        KProperty0 kProperty1;
        Arrangement$Vertical arrangement$Vertical4;
        Orientation orientation;
        Modifier modifierLazyLayoutBeyondBoundsModifier;
        boolean z6;
        Object objRememberedValue4;
        boolean zChanged2;
        Object objRememberedValue5;
        GapComposer gapComposer3 = (GapComposer) composer;
        gapComposer3.startRestartGroup(924924659);
        if ((i & 6) == 0) {
            i4 = (gapComposer3.changed(modifier) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i & 48) == 0) {
            i4 |= gapComposer3.changed(lazyListState) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i4 |= gapComposer3.changed(paddingValues) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i4 |= gapComposer3.changed(false) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i4 |= gapComposer3.changed(z) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i4 |= gapComposer3.changed(flingBehavior) ? 131072 : 65536;
        }
        if ((i & 1572864) == 0) {
            i4 |= gapComposer3.changed(z2) ? ByteChannelKt.CHANNEL_MAX_SIZE : 524288;
        }
        if ((i & 12582912) == 0) {
            i4 |= gapComposer3.changed(androidEdgeEffectOverscrollEffect) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i4 |= 33554432;
        }
        int i10 = i3 & 512;
        if (i10 != 0) {
            i4 |= 805306368;
        } else if ((i & 805306368) == 0) {
            i4 |= gapComposer3.changed(horizontal) ? 536870912 : WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
        }
        int i11 = i3 & 1024;
        if (i11 != 0) {
            i5 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i5 = i2 | (gapComposer3.changed(arrangement$Vertical) ? 4 : 2);
        } else {
            i5 = i2;
        }
        int i12 = i3 & 2048;
        if (i12 != 0) {
            i5 |= 48;
        } else if ((i2 & 48) == 0) {
            i5 |= gapComposer3.changed(vertical) ? 32 : 16;
        }
        int i13 = i5;
        int i14 = i3 & 4096;
        if (i14 == 0) {
            if ((i2 & 384) == 0) {
                i13 |= gapComposer3.changed(arrangement$Horizontal) ? 256 : 128;
            }
            if ((i2 & 3072) == 0) {
                i13 |= gapComposer3.changedInstance(function1) ? 2048 : 1024;
            }
            if ((i4 & 306783379) == 306783378 || (i13 & 1171) != 1170) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (gapComposer3.shouldExecute(i4 & 1, z3)) {
                gapComposer3.startDefaults();
                if ((i & 1) != 0 || gapComposer3.getDefaultsInvalid()) {
                    i6 = i4 & (-234881025);
                    if (i10 != 0) {
                        horizontal3 = null;
                    } else {
                        horizontal3 = horizontal;
                    }
                    if (i11 != 0) {
                        arrangement$Vertical3 = null;
                    } else {
                        arrangement$Vertical3 = arrangement$Vertical;
                    }
                    if (i12 != 0) {
                        vertical3 = null;
                    } else {
                        vertical3 = vertical;
                    }
                    if (i14 != 0) {
                        arrangement$Horizontal3 = null;
                    }
                    gapComposer3.endDefaults();
                    i7 = i6 >> 3;
                    int i15 = i7 & 14;
                    int i16 = i15 | ((i13 >> 6) & 112);
                    mutableStateRememberUpdatedState = Stack.rememberUpdatedState(function1, gapComposer3);
                    int i17 = i6;
                    int i18 = i13;
                    z4 = (((i16 & 14) ^ 6) <= 4 && gapComposer3.changed(lazyListState)) || (i16 & 6) == 4;
                    objRememberedValue = gapComposer3.rememberedValue();
                    neverEqualPolicy = Composer.Companion.Empty;
                    if (z4 || objRememberedValue == neverEqualPolicy) {
                        LazyItemScopeImpl lazyItemScopeImpl = new LazyItemScopeImpl();
                        lazyItemScopeImpl.maxWidthState = new ParcelableSnapshotMutableIntState(Integer.MAX_VALUE);
                        lazyItemScopeImpl.maxHeightState = new ParcelableSnapshotMutableIntState(Integer.MAX_VALUE);
                        NeverEqualPolicy neverEqualPolicy2 = NeverEqualPolicy.INSTANCE$1;
                        MainActivity$$ExternalSyntheticLambda29 mainActivity$$ExternalSyntheticLambda29 = new MainActivity$$ExternalSyntheticLambda29(mutableStateRememberUpdatedState, (byte) 1);
                        EmojiProcessor emojiProcessor = SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel;
                        objRememberedValue = new DataStoreKt$dataStore$2$2(new DerivedSnapshotState(new GapComposer$$ExternalSyntheticLambda0(new DerivedSnapshotState(mainActivity$$ExternalSyntheticLambda29, neverEqualPolicy2), lazyListState, lazyItemScopeImpl, (byte) 2), neverEqualPolicy2), State.class, "value", "getValue()Ljava/lang/Object;", 0, (byte) 1);
                        gapComposer3.updateRememberedValue(objRememberedValue);
                    }
                    kProperty0 = (KProperty0) objRememberedValue;
                    int i19 = i17 >> 9;
                    int i20 = i15 | (i19 & 112);
                    z5 = ((((i20 & 112) ^ 48) <= 32 && gapComposer3.changed(z)) || (i20 & 48) == 32) | ((((i20 & 14) ^ 6) <= 4 && gapComposer3.changed(lazyListState)) || (i20 & 6) == 4);
                    objRememberedValue2 = gapComposer3.rememberedValue();
                    if (z5 || objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = new LazyLayoutSemanticState(z) { // from class: androidx.compose.foundation.lazy.LazyLayoutSemanticStateKt$LazyLayoutSemanticState$1
                            public final /* synthetic */ boolean $isVertical;
                            public final DerivedSnapshotState totalItemsCount$delegate;

                            {
                                this.$isVertical = z;
                                this.totalItemsCount$delegate = SnapshotStateKt__DerivedStateKt.derivedStateOf(new LazyListKt$$ExternalSyntheticLambda0(this.$state, (byte) 1));
                            }

                            @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
                            public final CollectionInfo collectionInfo() {
                                boolean z7 = this.$isVertical;
                                DerivedSnapshotState derivedSnapshotState = this.totalItemsCount$delegate;
                                return z7 ? new CollectionInfo(((Number) derivedSnapshotState.getValue()).intValue(), 1) : new CollectionInfo(1, ((Number) derivedSnapshotState.getValue()).intValue());
                            }

                            @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
                            public final int getContentPadding() {
                                LazyListState lazyListState4 = this.$state;
                                return (-lazyListState4.getLayoutInfo().viewportStartOffset) + lazyListState4.getLayoutInfo().afterContentPadding;
                            }

                            @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
                            public final float getMaxScrollOffset() {
                                LazyListState lazyListState4 = this.$state;
                                int firstVisibleItemIndex = lazyListState4.getFirstVisibleItemIndex();
                                int firstVisibleItemScrollOffset = lazyListState4.getFirstVisibleItemScrollOffset();
                                return lazyListState4.getCanScrollForward() ? (firstVisibleItemIndex * CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION) + firstVisibleItemScrollOffset + 100.0f : (firstVisibleItemIndex * CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION) + firstVisibleItemScrollOffset;
                            }

                            @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
                            public final float getScrollOffset() {
                                LazyListState lazyListState4 = this.$state;
                                return (lazyListState4.getFirstVisibleItemIndex() * CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION) + lazyListState4.getFirstVisibleItemScrollOffset();
                            }

                            @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
                            public final int getViewport() {
                                LazyListState lazyListState4 = this.$state;
                                return (int) (lazyListState4.getLayoutInfo().orientation == Orientation.Vertical ? lazyListState4.getLayoutInfo().m162getViewportSizeYbymL2g() & 4294967295L : lazyListState4.getLayoutInfo().m162getViewportSizeYbymL2g() >> 32);
                            }

                            @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
                            public final Object scrollToItem(int i21, PagerState$scrollToPage$2 pagerState$scrollToPage$2) {
                                Object objScrollToItem$default = LazyListState.scrollToItem$default(this.$state, i21, pagerState$scrollToPage$2);
                                return objScrollToItem$default == CoroutineSingletons.COROUTINE_SUSPENDED ? objScrollToItem$default : Unit.INSTANCE;
                            }
                        };
                        gapComposer3.updateRememberedValue(objRememberedValue2);
                    }
                    LazyLayoutSemanticState lazyLayoutSemanticState = (LazyLayoutSemanticState) objRememberedValue2;
                    objRememberedValue3 = gapComposer3.rememberedValue();
                    if (objRememberedValue3 == neverEqualPolicy) {
                        objRememberedValue3 = Stack.createCompositionCoroutineScope(gapComposer3);
                        gapComposer3.updateRememberedValue(objRememberedValue3);
                    }
                    coroutineScope = (CoroutineScope) objRememberedValue3;
                    graphicsContext = (GraphicsContext) gapComposer3.consume(CompositionLocalsKt.LocalGraphicsContext);
                    noKey = ((Boolean) gapComposer3.consume(CompositionLocalsKt.LocalProvidableScrollCaptureInProgress)).booleanValue() ? null : StickyItemsPlacement$Companion.StickToTopPlacement;
                    i8 = i17 & 112;
                    int i21 = i18 << 18;
                    int i22 = (i17 & 65520) | (i19 & 3670016) | (i21 & 29360128) | (i21 & 234881024) | ((i18 << 27) & 1879048192);
                    zChanged = ((((i22 & 896) ^ 384) <= 256 && gapComposer3.changed(paddingValues)) || (i22 & 384) == 256) | ((((i22 & 112) ^ 48) <= 32 && gapComposer3.changed(lazyListState)) || (i22 & 48) == 32) | ((((i22 & 7168) ^ 3072) <= 2048 && gapComposer3.changed(false)) || (i22 & 3072) == 2048) | ((((57344 & i22) ^ 24576) <= 16384 && gapComposer3.changed(z)) || (i22 & 24576) == 16384) | gapComposer3.changed(0) | ((((i22 & 3670016) ^ 1572864) <= 1048576 && gapComposer3.changed(horizontal3)) || (i22 & 1572864) == 1048576) | ((((i22 & 29360128) ^ 12582912) <= 8388608 && gapComposer3.changed(vertical3)) || (i22 & 12582912) == 8388608) | ((((i22 & 234881024) ^ 100663296) <= 67108864 && gapComposer3.changed(arrangement$Horizontal3)) || (i22 & 100663296) == 67108864) | ((((i22 & 1879048192) ^ 805306368) <= 536870912 && gapComposer3.changed(arrangement$Vertical3)) || (i22 & 805306368) == 536870912) | gapComposer3.changed(graphicsContext) | gapComposer3.changed(noKey);
                    Object objRememberedValue6 = gapComposer3.rememberedValue();
                    if (!zChanged || objRememberedValue6 == neverEqualPolicy) {
                        gapComposer2 = gapComposer3;
                        final Arrangement$Vertical arrangement$Vertical5 = arrangement$Vertical3;
                        lazyListState3 = lazyListState;
                        horizontal2 = horizontal3;
                        i9 = 4;
                        obj = new LazyLayoutMeasurePolicy() { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1
                            /* JADX WARN: Code duplicated, block: B:301:0x06ea  */
                            /* JADX WARN: Code duplicated, block: B:302:0x06ef  */
                            /* JADX WARN: Code duplicated, block: B:305:0x06f9  */
                            /* JADX WARN: Code duplicated, block: B:307:0x0700  */
                            /* JADX WARN: Code duplicated, block: B:311:0x070c  */
                            /* JADX WARN: Code duplicated, block: B:314:0x072c  */
                            /* JADX WARN: Code duplicated, block: B:316:0x0734  */
                            /* JADX WARN: Code duplicated, block: B:317:0x073b  */
                            /* JADX WARN: Code duplicated, block: B:318:0x073e  */
                            /* JADX WARN: Code duplicated, block: B:320:0x0746  */
                            /* JADX WARN: Code duplicated, block: B:322:0x074e  */
                            /* JADX WARN: Code duplicated, block: B:324:0x0756  */
                            /* JADX WARN: Code duplicated, block: B:326:0x075f  */
                            /* JADX WARN: Code duplicated, block: B:327:0x0762  */
                            /* JADX WARN: Code duplicated, block: B:329:0x076a  */
                            /* JADX WARN: Code duplicated, block: B:334:0x0779  */
                            /* JADX WARN: Code duplicated, block: B:337:0x07a4  */
                            /* JADX WARN: Code duplicated, block: B:338:0x07a9  */
                            /* JADX WARN: Code duplicated, block: B:340:0x07ad  */
                            /* JADX WARN: Code duplicated, block: B:341:0x07b2  */
                            /* JADX WARN: Code duplicated, block: B:345:0x07bb  */
                            /* JADX WARN: Code duplicated, block: B:348:0x07c6 A[LOOP:15: B:347:0x07c4->B:348:0x07c6, LOOP_END] */
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasurePolicy
                            /* JADX INFO: renamed from: measure-0kLqBqw, reason: not valid java name */
                            public final MeasureResult mo159measure0kLqBqw(LazyLayoutMeasureScopeImpl lazyLayoutMeasureScopeImpl, long j) {
                                float fMo112getSpacingD9Ej5fM;
                                LazyListState lazyListState4;
                                long j2;
                                int i23;
                                int i24;
                                int i25;
                                int i26;
                                int i27;
                                int i28;
                                int i29;
                                float f;
                                LazyListMeasuredItem lazyListMeasuredItem;
                                int i30;
                                List arrayList;
                                int i31;
                                float f2;
                                ArrayList arrayList2;
                                int i32;
                                ArrayDeque arrayDeque;
                                int iM791constrainHeightK40F9xA;
                                LazyListMeasuredItem lazyListMeasuredItem2;
                                int i33;
                                LazyListMeasuredItem lazyListMeasuredItem3;
                                int i34;
                                MutableIntList mutableIntList;
                                List listApplyStickyItems;
                                LazyListMeasuredItem lazyListMeasuredItem4;
                                Integer numValueOf;
                                LazyListMeasuredItem lazyListMeasuredItem5;
                                Integer numValueOf2;
                                int i35;
                                int i36;
                                int iIntValue;
                                int iIntValue2;
                                int size;
                                int i37;
                                int i38;
                                LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1 lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1;
                                SubcomposeMeasureScope subcomposeMeasureScope;
                                LazyListMeasureResult lazyListMeasureResult;
                                LazyListMeasuredItem lazyListMeasuredItem6;
                                LazyListMeasuredItem lazyListMeasuredItem7;
                                int i39;
                                LazyLayoutMeasureScopeImpl lazyLayoutMeasureScopeImpl2;
                                SubcomposeMeasureScope subcomposeMeasureScope2 = lazyLayoutMeasureScopeImpl.subcomposeMeasureScope;
                                LazyListState lazyListState5 = lazyListState3;
                                lazyListState5.measurementScopeInvalidator.getValue();
                                boolean z7 = lazyListState5.hasLookaheadOccurred || subcomposeMeasureScope2.isLookingAhead();
                                Orientation orientation2 = Orientation.Horizontal;
                                Orientation orientation3 = Orientation.Vertical;
                                boolean z8 = z;
                                ImageKt.m44checkScrollableContainerConstraintsK40F9xA(j, z8 ? orientation3 : orientation2);
                                PaddingValues paddingValues2 = paddingValues;
                                int iMo75roundToPx0680j_4 = z8 ? subcomposeMeasureScope2.mo75roundToPx0680j_4(paddingValues2.mo123calculateLeftPaddingu2uoSUM(subcomposeMeasureScope2.getLayoutDirection())) : subcomposeMeasureScope2.mo75roundToPx0680j_4(OffsetKt.calculateStartPadding(paddingValues2, subcomposeMeasureScope2.getLayoutDirection()));
                                int iMo75roundToPx0680j_5 = z8 ? subcomposeMeasureScope2.mo75roundToPx0680j_4(paddingValues2.mo124calculateRightPaddingu2uoSUM(subcomposeMeasureScope2.getLayoutDirection())) : subcomposeMeasureScope2.mo75roundToPx0680j_4(OffsetKt.calculateEndPadding(paddingValues2, subcomposeMeasureScope2.getLayoutDirection()));
                                int iMo75roundToPx0680j_6 = subcomposeMeasureScope2.mo75roundToPx0680j_4(paddingValues2.mo125calculateTopPaddingD9Ej5fM());
                                int iMo75roundToPx0680j_7 = subcomposeMeasureScope2.mo75roundToPx0680j_4(paddingValues2.mo122calculateBottomPaddingD9Ej5fM()) + iMo75roundToPx0680j_6;
                                int i40 = iMo75roundToPx0680j_4 + iMo75roundToPx0680j_5;
                                int i41 = z8 ? iMo75roundToPx0680j_7 : i40;
                                int i42 = z8 ? iMo75roundToPx0680j_6 : !z8 ? iMo75roundToPx0680j_4 : iMo75roundToPx0680j_5;
                                int i43 = i41 - i42;
                                long jM793offsetNN6EwU = ConstraintsKt.m793offsetNN6EwU(-i40, -iMo75roundToPx0680j_7, j);
                                LazyListItemProviderImpl lazyListItemProviderImpl = (LazyListItemProviderImpl) kProperty0.invoke();
                                LazyItemScopeImpl lazyItemScopeImpl2 = lazyListItemProviderImpl.itemScope;
                                int iM784getMaxWidthimpl = Constraints.m784getMaxWidthimpl(jM793offsetNN6EwU);
                                int iM783getMaxHeightimpl = Constraints.m783getMaxHeightimpl(jM793offsetNN6EwU);
                                lazyItemScopeImpl2.maxWidthState.setIntValue(iM784getMaxWidthimpl);
                                lazyItemScopeImpl2.maxHeightState.setIntValue(iM783getMaxHeightimpl);
                                Arrangement$Horizontal arrangement$Horizontal4 = arrangement$Horizontal3;
                                Arrangement$Vertical arrangement$Vertical6 = arrangement$Vertical5;
                                if (z8) {
                                    if (arrangement$Vertical6 == null) {
                                        throw Fragment$5$$ExternalSyntheticOutline0.m("null verticalArrangement when isVertical == true");
                                    }
                                    fMo112getSpacingD9Ej5fM = arrangement$Vertical6.mo112getSpacingD9Ej5fM();
                                } else {
                                    if (arrangement$Horizontal4 == null) {
                                        throw Fragment$5$$ExternalSyntheticOutline0.m("null horizontalAlignment when isVertical == false");
                                    }
                                    fMo112getSpacingD9Ej5fM = arrangement$Horizontal4.mo112getSpacingD9Ej5fM();
                                }
                                int iMo75roundToPx0680j_8 = subcomposeMeasureScope2.mo75roundToPx0680j_4(fMo112getSpacingD9Ej5fM);
                                int itemCount = lazyListItemProviderImpl.getItemCount();
                                long j3 = (((long) iMo75roundToPx0680j_4) << 32) | (((long) iMo75roundToPx0680j_6) & 4294967295L);
                                int iM783getMaxHeightimpl2 = z8 ? Constraints.m783getMaxHeightimpl(j) - iMo75roundToPx0680j_7 : Constraints.m784getMaxWidthimpl(j) - i40;
                                int i44 = i42;
                                LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1 lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2 = new LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1(jM793offsetNN6EwU, z, lazyListItemProviderImpl, lazyLayoutMeasureScopeImpl, itemCount, iMo75roundToPx0680j_8, horizontal2, vertical3, i44, i43, j3, lazyListState3);
                                int i45 = itemCount;
                                LazyListItemProviderImpl lazyListItemProviderImpl2 = lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2.itemProvider;
                                StatusLine statusLine = lazyListItemProviderImpl2.keyIndexMap;
                                Snapshot currentThreadSnapshot = Lock.getCurrentThreadSnapshot();
                                Function1 readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                                Snapshot snapshotMakeCurrentNonObservable = Lock.makeCurrentNonObservable(currentThreadSnapshot);
                                try {
                                    int firstVisibleItemIndex = lazyListState5.getFirstVisibleItemIndex();
                                    LazyListScrollPosition lazyListScrollPosition = lazyListState5.scrollPosition;
                                    LazyListItemProviderImpl lazyListItemProviderImpl3 = lazyListItemProviderImpl2;
                                    int iFindIndexByKey = LazyLayoutKt.findIndexByKey(firstVisibleItemIndex, lazyListItemProviderImpl, lazyListScrollPosition.lastKnownFirstItemKey);
                                    if (firstVisibleItemIndex != iFindIndexByKey) {
                                        lazyListScrollPosition.index$delegate.setIntValue(iFindIndexByKey);
                                        lazyListScrollPosition.nearestRangeState.update(firstVisibleItemIndex);
                                    }
                                    int firstVisibleItemScrollOffset = lazyListState5.getFirstVisibleItemScrollOffset();
                                    Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                                    MutableIntList mutableIntListCalculateLazyLayoutPinnedIndices = LazyLayoutKt.calculateLazyLayoutPinnedIndices(lazyListItemProviderImpl, lazyListState5.pinnedItems, lazyListState5.beyondBoundsInfo);
                                    float fFloatValue = (subcomposeMeasureScope2.isLookingAhead() || !z7) ? lazyListState5.scrollToBeConsumed : ((Number) ((AnimationState) lazyListState5._lazyLayoutScrollDeltaBetweenPasses.referenceQueue).value$delegate.getValue()).floatValue();
                                    LazyLayoutItemAnimator lazyLayoutItemAnimator = lazyListState5.itemAnimator;
                                    boolean zIsLookingAhead = subcomposeMeasureScope2.isLookingAhead();
                                    MutableState mutableState = lazyListState5.placementScopeInvalidator;
                                    boolean z9 = !lazyListState5.skipItemPlacementAnimation;
                                    if (i44 < 0) {
                                        InlineClassHelperKt.throwIllegalArgumentException("invalid beforeContentPadding");
                                    }
                                    if (i43 < 0) {
                                        InlineClassHelperKt.throwIllegalArgumentException("invalid afterContentPadding");
                                    }
                                    EmptyMap emptyMap = EmptyMap.INSTANCE;
                                    boolean z10 = z;
                                    int i46 = firstVisibleItemScrollOffset;
                                    CoroutineScope coroutineScope2 = coroutineScope;
                                    GraphicsContext graphicsContext2 = graphicsContext;
                                    EmptyList emptyList = EmptyList.INSTANCE;
                                    if (i45 <= 0) {
                                        int iM786getMinWidthimpl = Constraints.m786getMinWidthimpl(jM793offsetNN6EwU);
                                        int iM785getMinHeightimpl = Constraints.m785getMinHeightimpl(jM793offsetNN6EwU);
                                        lazyLayoutItemAnimator.onMeasured(0, iM786getMinWidthimpl, iM785getMinHeightimpl, new ArrayList(), statusLine, lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2, z10, zIsLookingAhead, 1, z7, 0, 0, coroutineScope2, graphicsContext2, true);
                                        if (!zIsLookingAhead) {
                                            long jM173getMinSizeToFitDisappearingItemsYbymL2g = lazyLayoutItemAnimator.m173getMinSizeToFitDisappearingItemsYbymL2g();
                                            if (!IntSize.m810equalsimpl0(jM173getMinSizeToFitDisappearingItemsYbymL2g, 0L)) {
                                                iM786getMinWidthimpl = ConstraintsKt.m792constrainWidthK40F9xA((int) (jM173getMinSizeToFitDisappearingItemsYbymL2g >> 32), jM793offsetNN6EwU);
                                                iM785getMinHeightimpl = ConstraintsKt.m791constrainHeightK40F9xA((int) (jM173getMinSizeToFitDisappearingItemsYbymL2g & 4294967295L), jM793offsetNN6EwU);
                                            }
                                        }
                                        MeasureResult measureResultLayout = subcomposeMeasureScope2.layout(ConstraintsKt.m792constrainWidthK40F9xA(iM786getMinWidthimpl + i40, j), ConstraintsKt.m791constrainHeightK40F9xA(iM785getMinHeightimpl + iMo75roundToPx0680j_7, j), emptyMap, new OffsetKt$$ExternalSyntheticLambda0((byte) 13));
                                        int i47 = -i44;
                                        int i48 = iM783getMaxHeightimpl2 + i43;
                                        if (!z10) {
                                            orientation3 = orientation2;
                                        }
                                        subcomposeMeasureScope = subcomposeMeasureScope2;
                                        lazyListState4 = lazyListState5;
                                        lazyListMeasureResult = new LazyListMeasureResult(null, 0, false, CropImageView.DEFAULT_ASPECT_RATIO, measureResultLayout, CropImageView.DEFAULT_ASPECT_RATIO, false, coroutineScope2, lazyLayoutMeasureScopeImpl, lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2.childConstraints, 0, emptyList, i47, i48, 0, orientation3, i43, iMo75roundToPx0680j_8);
                                        lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1 = lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2;
                                    } else {
                                        lazyListState4 = lazyListState5;
                                        int i49 = iMo75roundToPx0680j_7;
                                        int i50 = iM783getMaxHeightimpl2;
                                        if (iFindIndexByKey >= i45) {
                                            iFindIndexByKey = i45 - 1;
                                            i46 = 0;
                                        }
                                        int iRound = Math.round(fFloatValue);
                                        int i51 = i46 - iRound;
                                        if (iFindIndexByKey == 0 && i51 < 0) {
                                            iRound += i51;
                                            i51 = 0;
                                        }
                                        ArrayDeque arrayDeque2 = new ArrayDeque();
                                        int i52 = -i44;
                                        int i53 = iFindIndexByKey;
                                        int i54 = i52 + (iMo75roundToPx0680j_8 < 0 ? iMo75roundToPx0680j_8 : 0);
                                        int mainAxisSizeWithSpacings = i51 + i54;
                                        float f3 = fFloatValue;
                                        int iMax = 0;
                                        while (true) {
                                            j2 = lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2.childConstraints;
                                            if (mainAxisSizeWithSpacings >= 0 || i53 <= 0) {
                                                break;
                                            }
                                            int i55 = i49;
                                            int i56 = i53 - 1;
                                            LazyListMeasuredItem lazyListMeasuredItemM161getAndMeasure0kLqBqw = lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2.m161getAndMeasure0kLqBqw(i56, j2);
                                            arrayDeque2.add(0, lazyListMeasuredItemM161getAndMeasure0kLqBqw);
                                            iMax = Math.max(iMax, lazyListMeasuredItemM161getAndMeasure0kLqBqw.crossAxisSize);
                                            mainAxisSizeWithSpacings += lazyListMeasuredItemM161getAndMeasure0kLqBqw.getMainAxisSizeWithSpacings();
                                            i53 = i56;
                                            i49 = i55;
                                        }
                                        int i57 = i49;
                                        if (mainAxisSizeWithSpacings < i54) {
                                            iRound -= i54 - mainAxisSizeWithSpacings;
                                            mainAxisSizeWithSpacings = i54;
                                        }
                                        int i58 = iRound;
                                        int i59 = mainAxisSizeWithSpacings - i54;
                                        int i60 = i50 + i43;
                                        int i61 = i60 >= 0 ? i60 : 0;
                                        int i62 = iMax;
                                        int mainAxisSizeWithSpacings2 = -i59;
                                        int i63 = i53;
                                        int i64 = 0;
                                        boolean z11 = false;
                                        while (i64 < arrayDeque2.size) {
                                            if (mainAxisSizeWithSpacings2 >= i61) {
                                                arrayDeque2.removeAt(i64);
                                                z11 = true;
                                            } else {
                                                i63++;
                                                int mainAxisSizeWithSpacings3 = ((LazyListMeasuredItem) arrayDeque2.get(i64)).getMainAxisSizeWithSpacings() + mainAxisSizeWithSpacings2;
                                                i64++;
                                                mainAxisSizeWithSpacings2 = mainAxisSizeWithSpacings3;
                                            }
                                        }
                                        int iMax2 = i62;
                                        int mainAxisSizeWithSpacings4 = i59;
                                        boolean z12 = z11;
                                        int i65 = i63;
                                        while (i65 < i45 && (mainAxisSizeWithSpacings2 < i61 || mainAxisSizeWithSpacings2 <= 0 || arrayDeque2.isEmpty())) {
                                            int i66 = i61;
                                            LazyListMeasuredItem lazyListMeasuredItemM161getAndMeasure0kLqBqw2 = lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2.m161getAndMeasure0kLqBqw(i65, j2);
                                            mainAxisSizeWithSpacings2 = lazyListMeasuredItemM161getAndMeasure0kLqBqw2.getMainAxisSizeWithSpacings() + mainAxisSizeWithSpacings2;
                                            if (mainAxisSizeWithSpacings2 <= i54) {
                                                i39 = i54;
                                                if (i65 != i45 - 1) {
                                                    i53 = i65 + 1;
                                                    mainAxisSizeWithSpacings4 -= lazyListMeasuredItemM161getAndMeasure0kLqBqw2.getMainAxisSizeWithSpacings();
                                                    z12 = true;
                                                }
                                                i65++;
                                                i61 = i66;
                                                i54 = i39;
                                            } else {
                                                i39 = i54;
                                            }
                                            iMax2 = Math.max(iMax2, lazyListMeasuredItemM161getAndMeasure0kLqBqw2.crossAxisSize);
                                            arrayDeque2.addLast(lazyListMeasuredItemM161getAndMeasure0kLqBqw2);
                                            i65++;
                                            i61 = i66;
                                            i54 = i39;
                                        }
                                        if (mainAxisSizeWithSpacings2 < i50) {
                                            int i67 = i50 - mainAxisSizeWithSpacings2;
                                            int i68 = mainAxisSizeWithSpacings2 + i67;
                                            int mainAxisSizeWithSpacings5 = mainAxisSizeWithSpacings4 - i67;
                                            while (mainAxisSizeWithSpacings5 < i44 && i53 > 0) {
                                                int i69 = i67;
                                                int i70 = i53 - 1;
                                                int i71 = i68;
                                                LazyListMeasuredItem lazyListMeasuredItemM161getAndMeasure0kLqBqw3 = lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2.m161getAndMeasure0kLqBqw(i70, j2);
                                                i53 = i70;
                                                arrayDeque2.add(0, lazyListMeasuredItemM161getAndMeasure0kLqBqw3);
                                                iMax2 = Math.max(iMax2, lazyListMeasuredItemM161getAndMeasure0kLqBqw3.crossAxisSize);
                                                mainAxisSizeWithSpacings5 += lazyListMeasuredItemM161getAndMeasure0kLqBqw3.getMainAxisSizeWithSpacings();
                                                i68 = i71;
                                                i67 = i69;
                                            }
                                            int i72 = i67;
                                            int i73 = i68;
                                            i23 = i58;
                                            int i74 = i23 + i72;
                                            if (mainAxisSizeWithSpacings5 < 0) {
                                                int i75 = i74 + mainAxisSizeWithSpacings5;
                                                int i76 = i73 + mainAxisSizeWithSpacings5;
                                                i26 = iMax2;
                                                i24 = i76;
                                                i27 = i53;
                                                i28 = i75;
                                                i25 = 0;
                                            } else {
                                                i25 = mainAxisSizeWithSpacings5;
                                                i24 = i73;
                                                i26 = iMax2;
                                                i27 = i53;
                                                i28 = i74;
                                            }
                                        } else {
                                            i23 = i58;
                                            i24 = mainAxisSizeWithSpacings2;
                                            i25 = mainAxisSizeWithSpacings4;
                                            i26 = iMax2;
                                            i27 = i53;
                                            i28 = i23;
                                        }
                                        int i77 = i65;
                                        if (Integer.signum(Math.round(f3)) != Integer.signum(i28) || Math.abs(Math.round(f3)) < Math.abs(i28)) {
                                            i29 = i28;
                                            f = f3;
                                        } else {
                                            i29 = i28;
                                            f = i29;
                                        }
                                        float f4 = f3 - f;
                                        float f5 = CropImageView.DEFAULT_ASPECT_RATIO;
                                        if (zIsLookingAhead && i29 > i23 && f4 <= CropImageView.DEFAULT_ASPECT_RATIO) {
                                            f5 = (i29 - i23) + f4;
                                        }
                                        float f6 = f5;
                                        if (i25 < 0) {
                                            InlineClassHelperKt.throwIllegalArgumentException("negative currentFirstItemScrollOffset");
                                        }
                                        int i78 = -i25;
                                        LazyListMeasuredItem lazyListMeasuredItem8 = (LazyListMeasuredItem) arrayDeque2.first();
                                        if (i44 > 0 || iMo75roundToPx0680j_8 < 0) {
                                            int size2 = arrayDeque2.getSize();
                                            LazyListMeasuredItem lazyListMeasuredItem9 = lazyListMeasuredItem8;
                                            int i79 = 0;
                                            while (i79 < size2) {
                                                int i80 = size2;
                                                int mainAxisSizeWithSpacings6 = ((LazyListMeasuredItem) arrayDeque2.get(i79)).getMainAxisSizeWithSpacings();
                                                if (i25 == 0 || mainAxisSizeWithSpacings6 > i25 || i79 == arrayDeque2.getSize() - 1) {
                                                    break;
                                                }
                                                i25 -= mainAxisSizeWithSpacings6;
                                                i79++;
                                                lazyListMeasuredItem9 = (LazyListMeasuredItem) arrayDeque2.get(i79);
                                                size2 = i80;
                                            }
                                            lazyListMeasuredItem = lazyListMeasuredItem9;
                                        } else {
                                            lazyListMeasuredItem = lazyListMeasuredItem8;
                                        }
                                        int i81 = i25;
                                        int iMax3 = Math.max(0, i27);
                                        int i82 = i27 - 1;
                                        if (iMax3 <= i82) {
                                            List arrayList3 = null;
                                            while (true) {
                                                if (arrayList3 == null) {
                                                    arrayList3 = new ArrayList();
                                                }
                                                i30 = i45;
                                                arrayList = arrayList3;
                                                arrayList.add(lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2.m161getAndMeasure0kLqBqw(i82, j2));
                                                if (i82 == iMax3) {
                                                    break;
                                                }
                                                i82--;
                                                arrayList3 = arrayList;
                                                i45 = i30;
                                            }
                                        } else {
                                            i30 = i45;
                                            arrayList = null;
                                        }
                                        int[] iArr = mutableIntListCalculateLazyLayoutPinnedIndices.content;
                                        for (int i83 = mutableIntListCalculateLazyLayoutPinnedIndices._size - 1; -1 < i83; i83--) {
                                            int i84 = iArr[i83];
                                            if (i84 < iMax3) {
                                                if (arrayList == null) {
                                                    arrayList = new ArrayList();
                                                }
                                                arrayList.add(lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2.m161getAndMeasure0kLqBqw(i84, j2));
                                            }
                                        }
                                        if (arrayList == null) {
                                            arrayList = emptyList;
                                        }
                                        int iMax4 = i26;
                                        int i85 = 0;
                                        for (int size3 = arrayList.size(); i85 < size3; size3 = size3) {
                                            iMax4 = Math.max(iMax4, ((LazyListMeasuredItem) arrayList.get(i85)).crossAxisSize);
                                            i85++;
                                        }
                                        int iMin = Math.min(((LazyListMeasuredItem) CollectionsKt.last(arrayDeque2)).index, i30 - 1);
                                        int i86 = ((LazyListMeasuredItem) CollectionsKt.last(arrayDeque2)).index + 1;
                                        if (i86 <= iMin) {
                                            ArrayList arrayList4 = null;
                                            while (true) {
                                                if (arrayList4 == null) {
                                                    arrayList4 = new ArrayList();
                                                }
                                                i31 = iMax4;
                                                f2 = f;
                                                arrayList2 = arrayList4;
                                                arrayList2.add(lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2.m161getAndMeasure0kLqBqw(i86, j2));
                                                if (i86 == iMin) {
                                                    break;
                                                }
                                                i86++;
                                                arrayList4 = arrayList2;
                                                iMax4 = i31;
                                                f = f2;
                                            }
                                        } else {
                                            i31 = iMax4;
                                            f2 = f;
                                            arrayList2 = null;
                                        }
                                        if (arrayList2 != null && ((LazyListMeasuredItem) CollectionsKt.last(arrayList2)).index > iMin) {
                                            iMin = ((LazyListMeasuredItem) CollectionsKt.last(arrayList2)).index;
                                        }
                                        int[] iArr2 = mutableIntListCalculateLazyLayoutPinnedIndices.content;
                                        int i87 = mutableIntListCalculateLazyLayoutPinnedIndices._size;
                                        List arrayList5 = arrayList2;
                                        int i88 = 0;
                                        while (i88 < i87) {
                                            int i89 = i87;
                                            int i90 = iArr2[i88];
                                            if (i90 > iMin) {
                                                if (arrayList5 == null) {
                                                    arrayList5 = new ArrayList();
                                                }
                                                arrayList5.add(lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2.m161getAndMeasure0kLqBqw(i90, j2));
                                            }
                                            i88++;
                                            i87 = i89;
                                        }
                                        if (arrayList5 == null) {
                                            arrayList5 = emptyList;
                                        }
                                        int size4 = arrayList5.size();
                                        int iMax5 = i31;
                                        for (int i91 = 0; i91 < size4; i91++) {
                                            iMax5 = Math.max(iMax5, ((LazyListMeasuredItem) arrayList5.get(i91)).crossAxisSize);
                                        }
                                        boolean z13 = Intrinsics.areEqual(lazyListMeasuredItem, arrayDeque2.first()) && arrayList.isEmpty() && arrayList5.isEmpty();
                                        int iM792constrainWidthK40F9xA = ConstraintsKt.m792constrainWidthK40F9xA(z10 ? iMax5 : i24, jM793offsetNN6EwU);
                                        if (z10) {
                                            iMax5 = i24;
                                        }
                                        int iM791constrainHeightK40F9xA2 = ConstraintsKt.m791constrainHeightK40F9xA(iMax5, jM793offsetNN6EwU);
                                        int i92 = z10 ? iM791constrainHeightK40F9xA2 : iM792constrainWidthK40F9xA;
                                        boolean z14 = i24 < Math.min(i92, i50);
                                        if (z14 && i78 != 0) {
                                            InlineClassHelperKt.throwIllegalStateException("non-zero itemsScrollOffset");
                                        }
                                        boolean z15 = z13;
                                        ArrayList arrayList6 = new ArrayList(arrayList5.size() + arrayList.size() + arrayDeque2.getSize());
                                        if (z14) {
                                            if (!arrayList.isEmpty() || !arrayList5.isEmpty()) {
                                                InlineClassHelperKt.throwIllegalArgumentException("no extra items");
                                            }
                                            int size5 = arrayDeque2.getSize();
                                            int[] iArr3 = new int[size5];
                                            for (int i93 = 0; i93 < size5; i93++) {
                                                iArr3[i93] = ((LazyListMeasuredItem) arrayDeque2.get(i93)).size;
                                            }
                                            int[] iArr4 = new int[size5];
                                            if (z10) {
                                                if (arrangement$Vertical6 == null) {
                                                    throw Fragment$5$$ExternalSyntheticOutline0.m("null verticalArrangement when isVertical == true");
                                                }
                                                arrangement$Vertical6.arrange(lazyLayoutMeasureScopeImpl, i92, iArr3, iArr4);
                                                i32 = 0;
                                            } else {
                                                if (arrangement$Horizontal4 == null) {
                                                    throw Fragment$5$$ExternalSyntheticOutline0.m("null horizontalArrangement when isVertical == false");
                                                }
                                                i32 = 0;
                                                arrangement$Horizontal4.arrange(lazyLayoutMeasureScopeImpl, i92, iArr3, LayoutDirection.Ltr, iArr4);
                                            }
                                            IntRange indices = ArraysKt.getIndices(iArr4);
                                            int i94 = indices.last;
                                            int i95 = indices.step;
                                            if ((i95 > 0 && i94 >= 0) || (i95 < 0 && i94 <= 0)) {
                                                int i96 = i32;
                                                while (true) {
                                                    int i97 = iArr4[i96];
                                                    LazyListMeasuredItem lazyListMeasuredItem10 = (LazyListMeasuredItem) arrayDeque2.get(i96);
                                                    lazyListMeasuredItem10.position(i97, iM792constrainWidthK40F9xA, iM791constrainHeightK40F9xA2);
                                                    arrayList6.add(lazyListMeasuredItem10);
                                                    if (i96 == i94) {
                                                        break;
                                                    }
                                                    i96 += i95;
                                                }
                                            }
                                        } else {
                                            i50 = i50;
                                            lazyListMeasuredItem = lazyListMeasuredItem;
                                            i32 = 0;
                                            int size6 = arrayList.size();
                                            int mainAxisSizeWithSpacings7 = i78;
                                            int i98 = 0;
                                            while (i98 < size6) {
                                                int i99 = size6;
                                                LazyListMeasuredItem lazyListMeasuredItem11 = (LazyListMeasuredItem) arrayList.get(i98);
                                                mainAxisSizeWithSpacings7 -= lazyListMeasuredItem11.getMainAxisSizeWithSpacings();
                                                lazyListMeasuredItem11.position(mainAxisSizeWithSpacings7, iM792constrainWidthK40F9xA, iM791constrainHeightK40F9xA2);
                                                arrayList6.add(lazyListMeasuredItem11);
                                                i98++;
                                                size6 = i99;
                                            }
                                            int size7 = arrayDeque2.getSize();
                                            int mainAxisSizeWithSpacings8 = i78;
                                            for (int i100 = 0; i100 < size7; i100++) {
                                                LazyListMeasuredItem lazyListMeasuredItem12 = (LazyListMeasuredItem) arrayDeque2.get(i100);
                                                lazyListMeasuredItem12.position(mainAxisSizeWithSpacings8, iM792constrainWidthK40F9xA, iM791constrainHeightK40F9xA2);
                                                arrayList6.add(lazyListMeasuredItem12);
                                                mainAxisSizeWithSpacings8 += lazyListMeasuredItem12.getMainAxisSizeWithSpacings();
                                            }
                                            int size8 = arrayList5.size();
                                            for (int i101 = 0; i101 < size8; i101++) {
                                                LazyListMeasuredItem lazyListMeasuredItem13 = (LazyListMeasuredItem) arrayList5.get(i101);
                                                lazyListMeasuredItem13.position(mainAxisSizeWithSpacings8, iM792constrainWidthK40F9xA, iM791constrainHeightK40F9xA2);
                                                arrayList6.add(lazyListMeasuredItem13);
                                                mainAxisSizeWithSpacings8 += lazyListMeasuredItem13.getMainAxisSizeWithSpacings();
                                            }
                                        }
                                        float f7 = f2;
                                        int i102 = i24;
                                        lazyLayoutItemAnimator.onMeasured((int) f7, iM792constrainWidthK40F9xA, iM791constrainHeightK40F9xA2, arrayList6, statusLine, lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2, z10, zIsLookingAhead, 1, z7, i81, i102, coroutineScope2, graphicsContext2, z9);
                                        if (zIsLookingAhead) {
                                            arrayDeque = arrayDeque2;
                                        } else {
                                            long jM173getMinSizeToFitDisappearingItemsYbymL2g2 = lazyLayoutItemAnimator.m173getMinSizeToFitDisappearingItemsYbymL2g();
                                            arrayDeque = arrayDeque2;
                                            if (!IntSize.m810equalsimpl0(jM173getMinSizeToFitDisappearingItemsYbymL2g2, 0L)) {
                                                int i103 = z10 ? iM791constrainHeightK40F9xA2 : iM792constrainWidthK40F9xA;
                                                iM792constrainWidthK40F9xA = ConstraintsKt.m792constrainWidthK40F9xA(Math.max(iM792constrainWidthK40F9xA, (int) (jM173getMinSizeToFitDisappearingItemsYbymL2g2 >> 32)), jM793offsetNN6EwU);
                                                iM791constrainHeightK40F9xA = ConstraintsKt.m791constrainHeightK40F9xA(Math.max(iM791constrainHeightK40F9xA2, (int) (jM173getMinSizeToFitDisappearingItemsYbymL2g2 & 4294967295L)), jM793offsetNN6EwU);
                                                int i104 = z10 ? iM791constrainHeightK40F9xA : iM792constrainWidthK40F9xA;
                                                if (i104 != i103) {
                                                    int size9 = arrayList6.size();
                                                    for (int i105 = i32; i105 < size9; i105++) {
                                                        LazyListMeasuredItem lazyListMeasuredItem14 = (LazyListMeasuredItem) arrayList6.get(i105);
                                                        lazyListMeasuredItem14.mainAxisLayoutSize = i104;
                                                        lazyListMeasuredItem14.maxMainAxisOffset = lazyListMeasuredItem14.afterContentPadding + i104;
                                                    }
                                                }
                                            }
                                            int i106 = iM792constrainWidthK40F9xA;
                                            lazyListMeasuredItem2 = (LazyListMeasuredItem) arrayDeque.firstOrNull();
                                            if (lazyListMeasuredItem2 != null) {
                                                i33 = lazyListMeasuredItem2.index;
                                            } else {
                                                i33 = i32;
                                            }
                                            lazyListMeasuredItem3 = (LazyListMeasuredItem) arrayDeque.lastOrNull();
                                            if (lazyListMeasuredItem3 != null) {
                                                i34 = lazyListMeasuredItem3.index;
                                            } else {
                                                i34 = i32;
                                            }
                                            mutableIntList = lazyListItemProviderImpl3.intervalContent._headerIndexes;
                                            if (mutableIntList == null) {
                                                mutableIntList = IntListKt.EmptyIntList;
                                            }
                                            int i107 = iM791constrainHeightK40F9xA;
                                            listApplyStickyItems = LazyLayoutKt.applyStickyItems(noKey, i33, i34, arrayList6, mutableIntList, i44, i106, i107, z10, new ScrollState$$ExternalSyntheticLambda0((byte) 13, lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2));
                                            if (z15) {
                                                lazyListMeasuredItem7 = (LazyListMeasuredItem) CollectionsKt.firstOrNull((List) arrayList6);
                                                if (lazyListMeasuredItem7 != null) {
                                                    numValueOf = Integer.valueOf(lazyListMeasuredItem7.index);
                                                } else {
                                                    numValueOf = null;
                                                }
                                            } else {
                                                lazyListMeasuredItem4 = (LazyListMeasuredItem) arrayDeque.firstOrNull();
                                                if (lazyListMeasuredItem4 != null) {
                                                    numValueOf = Integer.valueOf(lazyListMeasuredItem4.index);
                                                } else {
                                                    numValueOf = null;
                                                }
                                            }
                                            if (z15) {
                                                lazyListMeasuredItem6 = (LazyListMeasuredItem) CollectionsKt.lastOrNull(arrayList6);
                                                if (lazyListMeasuredItem6 != null) {
                                                    numValueOf2 = Integer.valueOf(lazyListMeasuredItem6.index);
                                                } else {
                                                    numValueOf2 = null;
                                                }
                                            } else {
                                                lazyListMeasuredItem5 = (LazyListMeasuredItem) arrayDeque.lastOrNull();
                                                if (lazyListMeasuredItem5 != null) {
                                                    numValueOf2 = Integer.valueOf(lazyListMeasuredItem5.index);
                                                } else {
                                                    numValueOf2 = null;
                                                }
                                            }
                                            i35 = i30;
                                            if (i77 >= i35 || i102 > i50) {
                                                i36 = 1;
                                            } else {
                                                i36 = i32;
                                            }
                                            MeasureResult measureResultLayout2 = subcomposeMeasureScope2.layout(ConstraintsKt.m792constrainWidthK40F9xA(i106 + i40, j), ConstraintsKt.m791constrainHeightK40F9xA(i107 + i57, j), emptyMap, new LazyListMeasureKt$$ExternalSyntheticLambda2(mutableState, arrayList6, listApplyStickyItems, zIsLookingAhead, (byte) 0));
                                            if (numValueOf != null) {
                                                iIntValue = numValueOf.intValue();
                                            } else {
                                                iIntValue = i32;
                                            }
                                            if (numValueOf2 != null) {
                                                iIntValue2 = numValueOf2.intValue();
                                            } else {
                                                iIntValue2 = i32;
                                            }
                                            List listUpdatedVisibleItems = LazyLayoutKt.updatedVisibleItems(iIntValue, iIntValue2, arrayList6, listApplyStickyItems);
                                            if (!z10) {
                                                orientation3 = orientation2;
                                            }
                                            size = listApplyStickyItems.size();
                                            i37 = i32;
                                            i38 = i37;
                                            while (i37 < size) {
                                                i38 += ((LazyListMeasuredItem) listApplyStickyItems.get(i37)).size;
                                                i37++;
                                            }
                                            lazyListItemProviderImpl3 = lazyListItemProviderImpl3;
                                            lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1 = lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2;
                                            subcomposeMeasureScope = subcomposeMeasureScope2;
                                            lazyListMeasureResult = new LazyListMeasureResult(lazyListMeasuredItem, i81, i36, f7, measureResultLayout2, f6, z12, coroutineScope2, lazyLayoutMeasureScopeImpl, lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2.childConstraints, i38, listUpdatedVisibleItems, i52, i60, i35, orientation3, i43, iMo75roundToPx0680j_8);
                                        }
                                        iM791constrainHeightK40F9xA = iM791constrainHeightK40F9xA2;
                                        int i108 = iM792constrainWidthK40F9xA;
                                        lazyListMeasuredItem2 = (LazyListMeasuredItem) arrayDeque.firstOrNull();
                                        if (lazyListMeasuredItem2 != null) {
                                            i33 = lazyListMeasuredItem2.index;
                                        } else {
                                            i33 = i32;
                                        }
                                        lazyListMeasuredItem3 = (LazyListMeasuredItem) arrayDeque.lastOrNull();
                                        if (lazyListMeasuredItem3 != null) {
                                            i34 = lazyListMeasuredItem3.index;
                                        } else {
                                            i34 = i32;
                                        }
                                        mutableIntList = lazyListItemProviderImpl3.intervalContent._headerIndexes;
                                        if (mutableIntList == null) {
                                            mutableIntList = IntListKt.EmptyIntList;
                                        }
                                        int i109 = iM791constrainHeightK40F9xA;
                                        listApplyStickyItems = LazyLayoutKt.applyStickyItems(noKey, i33, i34, arrayList6, mutableIntList, i44, i108, i109, z10, new ScrollState$$ExternalSyntheticLambda0((byte) 13, lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2));
                                        if (z15) {
                                            lazyListMeasuredItem7 = (LazyListMeasuredItem) CollectionsKt.firstOrNull((List) arrayList6);
                                            if (lazyListMeasuredItem7 != null) {
                                                numValueOf = Integer.valueOf(lazyListMeasuredItem7.index);
                                            } else {
                                                numValueOf = null;
                                            }
                                        } else {
                                            lazyListMeasuredItem4 = (LazyListMeasuredItem) arrayDeque.firstOrNull();
                                            if (lazyListMeasuredItem4 != null) {
                                                numValueOf = Integer.valueOf(lazyListMeasuredItem4.index);
                                            } else {
                                                numValueOf = null;
                                            }
                                        }
                                        if (z15) {
                                            lazyListMeasuredItem6 = (LazyListMeasuredItem) CollectionsKt.lastOrNull(arrayList6);
                                            if (lazyListMeasuredItem6 != null) {
                                                numValueOf2 = Integer.valueOf(lazyListMeasuredItem6.index);
                                            } else {
                                                numValueOf2 = null;
                                            }
                                        } else {
                                            lazyListMeasuredItem5 = (LazyListMeasuredItem) arrayDeque.lastOrNull();
                                            if (lazyListMeasuredItem5 != null) {
                                                numValueOf2 = Integer.valueOf(lazyListMeasuredItem5.index);
                                            } else {
                                                numValueOf2 = null;
                                            }
                                        }
                                        i35 = i30;
                                        if (i77 >= i35) {
                                            i36 = 1;
                                        } else {
                                            i36 = 1;
                                        }
                                        MeasureResult measureResultLayout3 = subcomposeMeasureScope2.layout(ConstraintsKt.m792constrainWidthK40F9xA(i108 + i40, j), ConstraintsKt.m791constrainHeightK40F9xA(i109 + i57, j), emptyMap, new LazyListMeasureKt$$ExternalSyntheticLambda2(mutableState, arrayList6, listApplyStickyItems, zIsLookingAhead, (byte) 0));
                                        if (numValueOf != null) {
                                            iIntValue = numValueOf.intValue();
                                        } else {
                                            iIntValue = i32;
                                        }
                                        if (numValueOf2 != null) {
                                            iIntValue2 = numValueOf2.intValue();
                                        } else {
                                            iIntValue2 = i32;
                                        }
                                        List listUpdatedVisibleItems2 = LazyLayoutKt.updatedVisibleItems(iIntValue, iIntValue2, arrayList6, listApplyStickyItems);
                                        if (!z10) {
                                            orientation3 = orientation2;
                                        }
                                        size = listApplyStickyItems.size();
                                        i37 = i32;
                                        i38 = i37;
                                        while (i37 < size) {
                                            i38 += ((LazyListMeasuredItem) listApplyStickyItems.get(i37)).size;
                                            i37++;
                                        }
                                        lazyListItemProviderImpl3 = lazyListItemProviderImpl3;
                                        lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1 = lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2;
                                        subcomposeMeasureScope = subcomposeMeasureScope2;
                                        lazyListMeasureResult = new LazyListMeasureResult(lazyListMeasuredItem, i81, i36, f7, measureResultLayout3, f6, z12, coroutineScope2, lazyLayoutMeasureScopeImpl, lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2.childConstraints, i38, listUpdatedVisibleItems2, i52, i60, i35, orientation3, i43, iMo75roundToPx0680j_8);
                                    }
                                    LazyListMeasureResult lazyListMeasureResult2 = lazyListMeasureResult;
                                    LazyListState lazyListState6 = lazyListState4;
                                    lazyListState6.applyMeasureResult$foundation(lazyListMeasureResult2, subcomposeMeasureScope.isLookingAhead(), false);
                                    Object obj2 = lazyListState6.prefetchStrategy;
                                    CacheWindowLogic cacheWindowLogic = obj2 instanceof CacheWindowLogic ? (CacheWindowLogic) obj2 : null;
                                    if (cacheWindowLogic == null) {
                                        return lazyListMeasureResult2;
                                    }
                                    List list = lazyListMeasureResult2.visibleItemsInfo;
                                    Trace.beginSection("compose:lazy:cache_window:keepAroundItems");
                                    try {
                                        if (cacheWindowLogic.hasValidBounds() && !list.isEmpty()) {
                                            int i110 = ((LazyListMeasuredItem) CollectionsKt.first(list)).index;
                                            int i111 = ((LazyListMeasuredItem) CollectionsKt.last(list)).index;
                                            int i112 = cacheWindowLogic.getPerLaneCacheWindowStartIndex()[0];
                                            LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1 lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$3 = lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1;
                                            while (true) {
                                                lazyLayoutMeasureScopeImpl2 = lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$3.measureScope;
                                                if (i112 >= i110) {
                                                    break;
                                                }
                                                if (i112 >= 0 && i112 < lazyListItemProviderImpl3.getItemCount()) {
                                                    lazyLayoutMeasureScopeImpl2.compose(i112);
                                                }
                                                i112++;
                                            }
                                            int i113 = i111 + 1;
                                            int i114 = cacheWindowLogic.getPerLaneCacheWindowEndItemIndex()[0];
                                            if (i113 <= i114) {
                                                while (true) {
                                                    if (i113 >= 0 && i113 < lazyListItemProviderImpl3.getItemCount()) {
                                                        lazyLayoutMeasureScopeImpl2.compose(i113);
                                                    }
                                                    if (i113 == i114) {
                                                        break;
                                                    }
                                                    i113++;
                                                }
                                            }
                                        }
                                        return lazyListMeasureResult2;
                                    } finally {
                                        Trace.endSection();
                                    }
                                } catch (Throwable th) {
                                    Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                                    throw th;
                                }
                            }
                        };
                        kProperty1 = kProperty0;
                        arrangement$Vertical4 = arrangement$Vertical5;
                        gapComposer2.updateRememberedValue(obj);
                    } else {
                        obj = objRememberedValue6;
                        horizontal2 = horizontal3;
                        gapComposer2 = gapComposer3;
                        arrangement$Vertical4 = arrangement$Vertical3;
                        i9 = 4;
                        lazyListState3 = lazyListState;
                        kProperty1 = kProperty0;
                    }
                    LazyLayoutMeasurePolicy lazyLayoutMeasurePolicy = (LazyLayoutMeasurePolicy) obj;
                    if (r4 != 0) {
                        orientation = Orientation.Vertical;
                    } else {
                        orientation = Orientation.Horizontal;
                    }
                    if (z2) {
                        gapComposer2.startReplaceGroup(-2077147368);
                        zChanged2 = ((((i7 & 14) ^ 6) <= i9 && gapComposer2.changed(lazyListState3)) || (i7 & 6) == i9) | gapComposer2.changed(0);
                        objRememberedValue5 = gapComposer2.rememberedValue();
                        if (zChanged2 || objRememberedValue5 == neverEqualPolicy) {
                            objRememberedValue5 = new LazyListBeyondBoundsState(lazyListState3);
                            gapComposer2.updateRememberedValue(objRememberedValue5);
                        }
                        modifierLazyLayoutBeyondBoundsModifier = LazyLayoutKt.lazyLayoutBeyondBoundsModifier((LazyListBeyondBoundsState) objRememberedValue5, lazyListState3.beyondBoundsInfo, orientation);
                        gapComposer2.end(false);
                    } else {
                        gapComposer2.startReplaceGroup(-2076718545);
                        gapComposer2.end(false);
                        modifierLazyLayoutBeyondBoundsModifier = Modifier.Companion.$$INSTANCE;
                    }
                    if (i8 == 32) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    objRememberedValue4 = gapComposer2.rememberedValue();
                    if (z6 || objRememberedValue4 == neverEqualPolicy) {
                        objRememberedValue4 = new LazyListKt$$ExternalSyntheticLambda0(lazyListState3, (byte) 0);
                        gapComposer2.updateRememberedValue(objRememberedValue4);
                    }
                    modifier2 = modifier;
                    lazyListState2 = lazyListState3;
                    gapComposer = gapComposer2;
                    LazyLayoutKt.LazyLayout(kProperty1, ImageKt.scrollableArea(LazyLayoutKt.lazyLayoutItemAnimator(LazyLayoutKt.lazyLayoutSemantics(modifier2.then(lazyListState3.remeasurementModifier).then(lazyListState3.awaitLayoutModifier), kProperty1, lazyLayoutSemanticState, orientation, z2).then(modifierLazyLayoutBeyondBoundsModifier), lazyListState3.itemAnimator), lazyListState3, orientation, androidEdgeEffectOverscrollEffect, z2, flingBehavior, lazyListState3.internalInteractionSource, LazyLayoutKt.rememberLazyLayoutBringIntoViewSpec(i19 & 126, gapComposer2, (Function0) objRememberedValue4, z)), lazyListState2.prefetchState, lazyLayoutMeasurePolicy, gapComposer, 0);
                    arrangement$Vertical2 = arrangement$Vertical4;
                    vertical2 = vertical3;
                    arrangement$Horizontal2 = arrangement$Horizontal3;
                } else {
                    gapComposer3.skipToGroupEnd();
                    i6 = i4 & (-234881025);
                    horizontal3 = horizontal;
                    arrangement$Vertical3 = arrangement$Vertical;
                    vertical3 = vertical;
                }
                arrangement$Horizontal3 = arrangement$Horizontal;
                gapComposer3.endDefaults();
                i7 = i6 >> 3;
                int i110 = i7 & 14;
                int i111 = i110 | ((i13 >> 6) & 112);
                mutableStateRememberUpdatedState = Stack.rememberUpdatedState(function1, gapComposer3);
                int i112 = i6;
                int i113 = i13;
                if (((i111 & 14) ^ 6) <= 4) {
                }
                objRememberedValue = gapComposer3.rememberedValue();
                neverEqualPolicy = Composer.Companion.Empty;
                if (z4) {
                    LazyItemScopeImpl lazyItemScopeImpl2 = new LazyItemScopeImpl();
                    lazyItemScopeImpl2.maxWidthState = new ParcelableSnapshotMutableIntState(Integer.MAX_VALUE);
                    lazyItemScopeImpl2.maxHeightState = new ParcelableSnapshotMutableIntState(Integer.MAX_VALUE);
                    NeverEqualPolicy neverEqualPolicy3 = NeverEqualPolicy.INSTANCE$1;
                    MainActivity$$ExternalSyntheticLambda29 mainActivity$$ExternalSyntheticLambda210 = new MainActivity$$ExternalSyntheticLambda29(mutableStateRememberUpdatedState, (byte) 1);
                    EmojiProcessor emojiProcessor2 = SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel;
                    objRememberedValue = new DataStoreKt$dataStore$2$2(new DerivedSnapshotState(new GapComposer$$ExternalSyntheticLambda0(new DerivedSnapshotState(mainActivity$$ExternalSyntheticLambda210, neverEqualPolicy3), lazyListState, lazyItemScopeImpl2, (byte) 2), neverEqualPolicy3), State.class, "value", "getValue()Ljava/lang/Object;", 0, (byte) 1);
                    gapComposer3.updateRememberedValue(objRememberedValue);
                } else {
                    LazyItemScopeImpl lazyItemScopeImpl3 = new LazyItemScopeImpl();
                    lazyItemScopeImpl3.maxWidthState = new ParcelableSnapshotMutableIntState(Integer.MAX_VALUE);
                    lazyItemScopeImpl3.maxHeightState = new ParcelableSnapshotMutableIntState(Integer.MAX_VALUE);
                    NeverEqualPolicy neverEqualPolicy4 = NeverEqualPolicy.INSTANCE$1;
                    MainActivity$$ExternalSyntheticLambda29 mainActivity$$ExternalSyntheticLambda211 = new MainActivity$$ExternalSyntheticLambda29(mutableStateRememberUpdatedState, (byte) 1);
                    EmojiProcessor emojiProcessor3 = SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel;
                    objRememberedValue = new DataStoreKt$dataStore$2$2(new DerivedSnapshotState(new GapComposer$$ExternalSyntheticLambda0(new DerivedSnapshotState(mainActivity$$ExternalSyntheticLambda211, neverEqualPolicy4), lazyListState, lazyItemScopeImpl3, (byte) 2), neverEqualPolicy4), State.class, "value", "getValue()Ljava/lang/Object;", 0, (byte) 1);
                    gapComposer3.updateRememberedValue(objRememberedValue);
                }
                kProperty0 = (KProperty0) objRememberedValue;
                int i114 = i112 >> 9;
                int i23 = i110 | (i114 & 112);
                z5 = ((((i23 & 112) ^ 48) <= 32 && gapComposer3.changed(z)) || (i23 & 48) == 32) | ((((i23 & 14) ^ 6) <= 4 && gapComposer3.changed(lazyListState)) || (i23 & 6) == 4);
                objRememberedValue2 = gapComposer3.rememberedValue();
                if (z5) {
                    objRememberedValue2 = new LazyLayoutSemanticState(z) { // from class: androidx.compose.foundation.lazy.LazyLayoutSemanticStateKt$LazyLayoutSemanticState$1
                        public final /* synthetic */ boolean $isVertical;
                        public final DerivedSnapshotState totalItemsCount$delegate;

                        {
                            this.$isVertical = z;
                            this.totalItemsCount$delegate = SnapshotStateKt__DerivedStateKt.derivedStateOf(new LazyListKt$$ExternalSyntheticLambda0(this.$state, (byte) 1));
                        }

                        @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
                        public final CollectionInfo collectionInfo() {
                            boolean z7 = this.$isVertical;
                            DerivedSnapshotState derivedSnapshotState = this.totalItemsCount$delegate;
                            return z7 ? new CollectionInfo(((Number) derivedSnapshotState.getValue()).intValue(), 1) : new CollectionInfo(1, ((Number) derivedSnapshotState.getValue()).intValue());
                        }

                        @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
                        public final int getContentPadding() {
                            LazyListState lazyListState4 = this.$state;
                            return (-lazyListState4.getLayoutInfo().viewportStartOffset) + lazyListState4.getLayoutInfo().afterContentPadding;
                        }

                        @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
                        public final float getMaxScrollOffset() {
                            LazyListState lazyListState4 = this.$state;
                            int firstVisibleItemIndex = lazyListState4.getFirstVisibleItemIndex();
                            int firstVisibleItemScrollOffset = lazyListState4.getFirstVisibleItemScrollOffset();
                            return lazyListState4.getCanScrollForward() ? (firstVisibleItemIndex * CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION) + firstVisibleItemScrollOffset + 100.0f : (firstVisibleItemIndex * CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION) + firstVisibleItemScrollOffset;
                        }

                        @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
                        public final float getScrollOffset() {
                            LazyListState lazyListState4 = this.$state;
                            return (lazyListState4.getFirstVisibleItemIndex() * CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION) + lazyListState4.getFirstVisibleItemScrollOffset();
                        }

                        @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
                        public final int getViewport() {
                            LazyListState lazyListState4 = this.$state;
                            return (int) (lazyListState4.getLayoutInfo().orientation == Orientation.Vertical ? lazyListState4.getLayoutInfo().m162getViewportSizeYbymL2g() & 4294967295L : lazyListState4.getLayoutInfo().m162getViewportSizeYbymL2g() >> 32);
                        }

                        @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
                        public final Object scrollToItem(int i24, PagerState$scrollToPage$2 pagerState$scrollToPage$2) {
                            Object objScrollToItem$default = LazyListState.scrollToItem$default(this.$state, i24, pagerState$scrollToPage$2);
                            return objScrollToItem$default == CoroutineSingletons.COROUTINE_SUSPENDED ? objScrollToItem$default : Unit.INSTANCE;
                        }
                    };
                    gapComposer3.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new LazyLayoutSemanticState(z) { // from class: androidx.compose.foundation.lazy.LazyLayoutSemanticStateKt$LazyLayoutSemanticState$1
                        public final /* synthetic */ boolean $isVertical;
                        public final DerivedSnapshotState totalItemsCount$delegate;

                        {
                            this.$isVertical = z;
                            this.totalItemsCount$delegate = SnapshotStateKt__DerivedStateKt.derivedStateOf(new LazyListKt$$ExternalSyntheticLambda0(this.$state, (byte) 1));
                        }

                        @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
                        public final CollectionInfo collectionInfo() {
                            boolean z7 = this.$isVertical;
                            DerivedSnapshotState derivedSnapshotState = this.totalItemsCount$delegate;
                            return z7 ? new CollectionInfo(((Number) derivedSnapshotState.getValue()).intValue(), 1) : new CollectionInfo(1, ((Number) derivedSnapshotState.getValue()).intValue());
                        }

                        @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
                        public final int getContentPadding() {
                            LazyListState lazyListState4 = this.$state;
                            return (-lazyListState4.getLayoutInfo().viewportStartOffset) + lazyListState4.getLayoutInfo().afterContentPadding;
                        }

                        @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
                        public final float getMaxScrollOffset() {
                            LazyListState lazyListState4 = this.$state;
                            int firstVisibleItemIndex = lazyListState4.getFirstVisibleItemIndex();
                            int firstVisibleItemScrollOffset = lazyListState4.getFirstVisibleItemScrollOffset();
                            return lazyListState4.getCanScrollForward() ? (firstVisibleItemIndex * CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION) + firstVisibleItemScrollOffset + 100.0f : (firstVisibleItemIndex * CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION) + firstVisibleItemScrollOffset;
                        }

                        @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
                        public final float getScrollOffset() {
                            LazyListState lazyListState4 = this.$state;
                            return (lazyListState4.getFirstVisibleItemIndex() * CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION) + lazyListState4.getFirstVisibleItemScrollOffset();
                        }

                        @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
                        public final int getViewport() {
                            LazyListState lazyListState4 = this.$state;
                            return (int) (lazyListState4.getLayoutInfo().orientation == Orientation.Vertical ? lazyListState4.getLayoutInfo().m162getViewportSizeYbymL2g() & 4294967295L : lazyListState4.getLayoutInfo().m162getViewportSizeYbymL2g() >> 32);
                        }

                        @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
                        public final Object scrollToItem(int i24, PagerState$scrollToPage$2 pagerState$scrollToPage$2) {
                            Object objScrollToItem$default = LazyListState.scrollToItem$default(this.$state, i24, pagerState$scrollToPage$2);
                            return objScrollToItem$default == CoroutineSingletons.COROUTINE_SUSPENDED ? objScrollToItem$default : Unit.INSTANCE;
                        }
                    };
                    gapComposer3.updateRememberedValue(objRememberedValue2);
                }
                LazyLayoutSemanticState lazyLayoutSemanticState2 = (LazyLayoutSemanticState) objRememberedValue2;
                objRememberedValue3 = gapComposer3.rememberedValue();
                if (objRememberedValue3 == neverEqualPolicy) {
                    objRememberedValue3 = Stack.createCompositionCoroutineScope(gapComposer3);
                    gapComposer3.updateRememberedValue(objRememberedValue3);
                }
                coroutineScope = (CoroutineScope) objRememberedValue3;
                graphicsContext = (GraphicsContext) gapComposer3.consume(CompositionLocalsKt.LocalGraphicsContext);
                noKey = ((Boolean) gapComposer3.consume(CompositionLocalsKt.LocalProvidableScrollCaptureInProgress)).booleanValue() ? null : StickyItemsPlacement$Companion.StickToTopPlacement;
                i8 = i112 & 112;
                int i24 = i113 << 18;
                int i25 = (i112 & 65520) | (i114 & 3670016) | (i24 & 29360128) | (i24 & 234881024) | ((i113 << 27) & 1879048192);
                if (((i25 & 112) ^ 48) <= 32) {
                }
                zChanged = ((((i25 & 896) ^ 384) <= 256 && gapComposer3.changed(paddingValues)) || (i25 & 384) == 256) | ((((i25 & 112) ^ 48) <= 32 && gapComposer3.changed(lazyListState)) || (i25 & 48) == 32) | ((((i25 & 7168) ^ 3072) <= 2048 && gapComposer3.changed(false)) || (i25 & 3072) == 2048) | ((((57344 & i25) ^ 24576) <= 16384 && gapComposer3.changed(z)) || (i25 & 24576) == 16384) | gapComposer3.changed(0) | ((((i25 & 3670016) ^ 1572864) <= 1048576 && gapComposer3.changed(horizontal3)) || (i25 & 1572864) == 1048576) | ((((i25 & 29360128) ^ 12582912) <= 8388608 && gapComposer3.changed(vertical3)) || (i25 & 12582912) == 8388608) | ((((i25 & 234881024) ^ 100663296) <= 67108864 && gapComposer3.changed(arrangement$Horizontal3)) || (i25 & 100663296) == 67108864) | ((((i25 & 1879048192) ^ 805306368) <= 536870912 && gapComposer3.changed(arrangement$Vertical3)) || (i25 & 805306368) == 536870912) | gapComposer3.changed(graphicsContext) | gapComposer3.changed(noKey);
                Object objRememberedValue7 = gapComposer3.rememberedValue();
                if (zChanged) {
                    gapComposer2 = gapComposer3;
                    final Arrangement$Vertical arrangement$Vertical6 = arrangement$Vertical3;
                    lazyListState3 = lazyListState;
                    horizontal2 = horizontal3;
                    i9 = 4;
                    obj = new LazyLayoutMeasurePolicy() { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1
                        /* JADX WARN: Code duplicated, block: B:301:0x06ea  */
                        /* JADX WARN: Code duplicated, block: B:302:0x06ef  */
                        /* JADX WARN: Code duplicated, block: B:305:0x06f9  */
                        /* JADX WARN: Code duplicated, block: B:307:0x0700  */
                        /* JADX WARN: Code duplicated, block: B:311:0x070c  */
                        /* JADX WARN: Code duplicated, block: B:314:0x072c  */
                        /* JADX WARN: Code duplicated, block: B:316:0x0734  */
                        /* JADX WARN: Code duplicated, block: B:317:0x073b  */
                        /* JADX WARN: Code duplicated, block: B:318:0x073e  */
                        /* JADX WARN: Code duplicated, block: B:320:0x0746  */
                        /* JADX WARN: Code duplicated, block: B:322:0x074e  */
                        /* JADX WARN: Code duplicated, block: B:324:0x0756  */
                        /* JADX WARN: Code duplicated, block: B:326:0x075f  */
                        /* JADX WARN: Code duplicated, block: B:327:0x0762  */
                        /* JADX WARN: Code duplicated, block: B:329:0x076a  */
                        /* JADX WARN: Code duplicated, block: B:334:0x0779  */
                        /* JADX WARN: Code duplicated, block: B:337:0x07a4  */
                        /* JADX WARN: Code duplicated, block: B:338:0x07a9  */
                        /* JADX WARN: Code duplicated, block: B:340:0x07ad  */
                        /* JADX WARN: Code duplicated, block: B:341:0x07b2  */
                        /* JADX WARN: Code duplicated, block: B:345:0x07bb  */
                        /* JADX WARN: Code duplicated, block: B:348:0x07c6 A[LOOP:15: B:347:0x07c4->B:348:0x07c6, LOOP_END] */
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasurePolicy
                        /* JADX INFO: renamed from: measure-0kLqBqw, reason: not valid java name */
                        public final MeasureResult mo159measure0kLqBqw(LazyLayoutMeasureScopeImpl lazyLayoutMeasureScopeImpl, long j) {
                            float fMo112getSpacingD9Ej5fM;
                            LazyListState lazyListState4;
                            long j2;
                            int i26;
                            int i27;
                            int i28;
                            int i29;
                            int i210;
                            int i211;
                            int i212;
                            float f;
                            LazyListMeasuredItem lazyListMeasuredItem;
                            int i30;
                            List arrayList;
                            int i31;
                            float f2;
                            ArrayList arrayList2;
                            int i32;
                            ArrayDeque arrayDeque;
                            int iM791constrainHeightK40F9xA;
                            LazyListMeasuredItem lazyListMeasuredItem2;
                            int i33;
                            LazyListMeasuredItem lazyListMeasuredItem3;
                            int i34;
                            MutableIntList mutableIntList;
                            List listApplyStickyItems;
                            LazyListMeasuredItem lazyListMeasuredItem4;
                            Integer numValueOf;
                            LazyListMeasuredItem lazyListMeasuredItem5;
                            Integer numValueOf2;
                            int i35;
                            int i36;
                            int iIntValue;
                            int iIntValue2;
                            int size;
                            int i37;
                            int i38;
                            LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1 lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1;
                            SubcomposeMeasureScope subcomposeMeasureScope;
                            LazyListMeasureResult lazyListMeasureResult;
                            LazyListMeasuredItem lazyListMeasuredItem6;
                            LazyListMeasuredItem lazyListMeasuredItem7;
                            int i39;
                            LazyLayoutMeasureScopeImpl lazyLayoutMeasureScopeImpl2;
                            SubcomposeMeasureScope subcomposeMeasureScope2 = lazyLayoutMeasureScopeImpl.subcomposeMeasureScope;
                            LazyListState lazyListState5 = lazyListState3;
                            lazyListState5.measurementScopeInvalidator.getValue();
                            boolean z7 = lazyListState5.hasLookaheadOccurred || subcomposeMeasureScope2.isLookingAhead();
                            Orientation orientation2 = Orientation.Horizontal;
                            Orientation orientation3 = Orientation.Vertical;
                            boolean z8 = z;
                            ImageKt.m44checkScrollableContainerConstraintsK40F9xA(j, z8 ? orientation3 : orientation2);
                            PaddingValues paddingValues2 = paddingValues;
                            int iMo75roundToPx0680j_4 = z8 ? subcomposeMeasureScope2.mo75roundToPx0680j_4(paddingValues2.mo123calculateLeftPaddingu2uoSUM(subcomposeMeasureScope2.getLayoutDirection())) : subcomposeMeasureScope2.mo75roundToPx0680j_4(OffsetKt.calculateStartPadding(paddingValues2, subcomposeMeasureScope2.getLayoutDirection()));
                            int iMo75roundToPx0680j_5 = z8 ? subcomposeMeasureScope2.mo75roundToPx0680j_4(paddingValues2.mo124calculateRightPaddingu2uoSUM(subcomposeMeasureScope2.getLayoutDirection())) : subcomposeMeasureScope2.mo75roundToPx0680j_4(OffsetKt.calculateEndPadding(paddingValues2, subcomposeMeasureScope2.getLayoutDirection()));
                            int iMo75roundToPx0680j_6 = subcomposeMeasureScope2.mo75roundToPx0680j_4(paddingValues2.mo125calculateTopPaddingD9Ej5fM());
                            int iMo75roundToPx0680j_7 = subcomposeMeasureScope2.mo75roundToPx0680j_4(paddingValues2.mo122calculateBottomPaddingD9Ej5fM()) + iMo75roundToPx0680j_6;
                            int i40 = iMo75roundToPx0680j_4 + iMo75roundToPx0680j_5;
                            int i41 = z8 ? iMo75roundToPx0680j_7 : i40;
                            int i42 = z8 ? iMo75roundToPx0680j_6 : !z8 ? iMo75roundToPx0680j_4 : iMo75roundToPx0680j_5;
                            int i43 = i41 - i42;
                            long jM793offsetNN6EwU = ConstraintsKt.m793offsetNN6EwU(-i40, -iMo75roundToPx0680j_7, j);
                            LazyListItemProviderImpl lazyListItemProviderImpl = (LazyListItemProviderImpl) kProperty0.invoke();
                            LazyItemScopeImpl lazyItemScopeImpl4 = lazyListItemProviderImpl.itemScope;
                            int iM784getMaxWidthimpl = Constraints.m784getMaxWidthimpl(jM793offsetNN6EwU);
                            int iM783getMaxHeightimpl = Constraints.m783getMaxHeightimpl(jM793offsetNN6EwU);
                            lazyItemScopeImpl4.maxWidthState.setIntValue(iM784getMaxWidthimpl);
                            lazyItemScopeImpl4.maxHeightState.setIntValue(iM783getMaxHeightimpl);
                            Arrangement$Horizontal arrangement$Horizontal4 = arrangement$Horizontal3;
                            Arrangement$Vertical arrangement$Vertical7 = arrangement$Vertical6;
                            if (z8) {
                                if (arrangement$Vertical7 == null) {
                                    throw Fragment$5$$ExternalSyntheticOutline0.m("null verticalArrangement when isVertical == true");
                                }
                                fMo112getSpacingD9Ej5fM = arrangement$Vertical7.mo112getSpacingD9Ej5fM();
                            } else {
                                if (arrangement$Horizontal4 == null) {
                                    throw Fragment$5$$ExternalSyntheticOutline0.m("null horizontalAlignment when isVertical == false");
                                }
                                fMo112getSpacingD9Ej5fM = arrangement$Horizontal4.mo112getSpacingD9Ej5fM();
                            }
                            int iMo75roundToPx0680j_8 = subcomposeMeasureScope2.mo75roundToPx0680j_4(fMo112getSpacingD9Ej5fM);
                            int itemCount = lazyListItemProviderImpl.getItemCount();
                            long j3 = (((long) iMo75roundToPx0680j_4) << 32) | (((long) iMo75roundToPx0680j_6) & 4294967295L);
                            int iM783getMaxHeightimpl2 = z8 ? Constraints.m783getMaxHeightimpl(j) - iMo75roundToPx0680j_7 : Constraints.m784getMaxWidthimpl(j) - i40;
                            int i44 = i42;
                            LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1 lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2 = new LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1(jM793offsetNN6EwU, z, lazyListItemProviderImpl, lazyLayoutMeasureScopeImpl, itemCount, iMo75roundToPx0680j_8, horizontal2, vertical3, i44, i43, j3, lazyListState3);
                            int i45 = itemCount;
                            LazyListItemProviderImpl lazyListItemProviderImpl2 = lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2.itemProvider;
                            StatusLine statusLine = lazyListItemProviderImpl2.keyIndexMap;
                            Snapshot currentThreadSnapshot = Lock.getCurrentThreadSnapshot();
                            Function1 readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                            Snapshot snapshotMakeCurrentNonObservable = Lock.makeCurrentNonObservable(currentThreadSnapshot);
                            try {
                                int firstVisibleItemIndex = lazyListState5.getFirstVisibleItemIndex();
                                LazyListScrollPosition lazyListScrollPosition = lazyListState5.scrollPosition;
                                LazyListItemProviderImpl lazyListItemProviderImpl3 = lazyListItemProviderImpl2;
                                int iFindIndexByKey = LazyLayoutKt.findIndexByKey(firstVisibleItemIndex, lazyListItemProviderImpl, lazyListScrollPosition.lastKnownFirstItemKey);
                                if (firstVisibleItemIndex != iFindIndexByKey) {
                                    lazyListScrollPosition.index$delegate.setIntValue(iFindIndexByKey);
                                    lazyListScrollPosition.nearestRangeState.update(firstVisibleItemIndex);
                                }
                                int firstVisibleItemScrollOffset = lazyListState5.getFirstVisibleItemScrollOffset();
                                Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                                MutableIntList mutableIntListCalculateLazyLayoutPinnedIndices = LazyLayoutKt.calculateLazyLayoutPinnedIndices(lazyListItemProviderImpl, lazyListState5.pinnedItems, lazyListState5.beyondBoundsInfo);
                                float fFloatValue = (subcomposeMeasureScope2.isLookingAhead() || !z7) ? lazyListState5.scrollToBeConsumed : ((Number) ((AnimationState) lazyListState5._lazyLayoutScrollDeltaBetweenPasses.referenceQueue).value$delegate.getValue()).floatValue();
                                LazyLayoutItemAnimator lazyLayoutItemAnimator = lazyListState5.itemAnimator;
                                boolean zIsLookingAhead = subcomposeMeasureScope2.isLookingAhead();
                                MutableState mutableState = lazyListState5.placementScopeInvalidator;
                                boolean z9 = !lazyListState5.skipItemPlacementAnimation;
                                if (i44 < 0) {
                                    InlineClassHelperKt.throwIllegalArgumentException("invalid beforeContentPadding");
                                }
                                if (i43 < 0) {
                                    InlineClassHelperKt.throwIllegalArgumentException("invalid afterContentPadding");
                                }
                                EmptyMap emptyMap = EmptyMap.INSTANCE;
                                boolean z10 = z;
                                int i46 = firstVisibleItemScrollOffset;
                                CoroutineScope coroutineScope2 = coroutineScope;
                                GraphicsContext graphicsContext2 = graphicsContext;
                                EmptyList emptyList = EmptyList.INSTANCE;
                                if (i45 <= 0) {
                                    int iM786getMinWidthimpl = Constraints.m786getMinWidthimpl(jM793offsetNN6EwU);
                                    int iM785getMinHeightimpl = Constraints.m785getMinHeightimpl(jM793offsetNN6EwU);
                                    lazyLayoutItemAnimator.onMeasured(0, iM786getMinWidthimpl, iM785getMinHeightimpl, new ArrayList(), statusLine, lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2, z10, zIsLookingAhead, 1, z7, 0, 0, coroutineScope2, graphicsContext2, true);
                                    if (!zIsLookingAhead) {
                                        long jM173getMinSizeToFitDisappearingItemsYbymL2g = lazyLayoutItemAnimator.m173getMinSizeToFitDisappearingItemsYbymL2g();
                                        if (!IntSize.m810equalsimpl0(jM173getMinSizeToFitDisappearingItemsYbymL2g, 0L)) {
                                            iM786getMinWidthimpl = ConstraintsKt.m792constrainWidthK40F9xA((int) (jM173getMinSizeToFitDisappearingItemsYbymL2g >> 32), jM793offsetNN6EwU);
                                            iM785getMinHeightimpl = ConstraintsKt.m791constrainHeightK40F9xA((int) (jM173getMinSizeToFitDisappearingItemsYbymL2g & 4294967295L), jM793offsetNN6EwU);
                                        }
                                    }
                                    MeasureResult measureResultLayout = subcomposeMeasureScope2.layout(ConstraintsKt.m792constrainWidthK40F9xA(iM786getMinWidthimpl + i40, j), ConstraintsKt.m791constrainHeightK40F9xA(iM785getMinHeightimpl + iMo75roundToPx0680j_7, j), emptyMap, new OffsetKt$$ExternalSyntheticLambda0((byte) 13));
                                    int i47 = -i44;
                                    int i48 = iM783getMaxHeightimpl2 + i43;
                                    if (!z10) {
                                        orientation3 = orientation2;
                                    }
                                    subcomposeMeasureScope = subcomposeMeasureScope2;
                                    lazyListState4 = lazyListState5;
                                    lazyListMeasureResult = new LazyListMeasureResult(null, 0, false, CropImageView.DEFAULT_ASPECT_RATIO, measureResultLayout, CropImageView.DEFAULT_ASPECT_RATIO, false, coroutineScope2, lazyLayoutMeasureScopeImpl, lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2.childConstraints, 0, emptyList, i47, i48, 0, orientation3, i43, iMo75roundToPx0680j_8);
                                    lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1 = lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2;
                                } else {
                                    lazyListState4 = lazyListState5;
                                    int i49 = iMo75roundToPx0680j_7;
                                    int i50 = iM783getMaxHeightimpl2;
                                    if (iFindIndexByKey >= i45) {
                                        iFindIndexByKey = i45 - 1;
                                        i46 = 0;
                                    }
                                    int iRound = Math.round(fFloatValue);
                                    int i51 = i46 - iRound;
                                    if (iFindIndexByKey == 0 && i51 < 0) {
                                        iRound += i51;
                                        i51 = 0;
                                    }
                                    ArrayDeque arrayDeque2 = new ArrayDeque();
                                    int i52 = -i44;
                                    int i53 = iFindIndexByKey;
                                    int i54 = i52 + (iMo75roundToPx0680j_8 < 0 ? iMo75roundToPx0680j_8 : 0);
                                    int mainAxisSizeWithSpacings = i51 + i54;
                                    float f3 = fFloatValue;
                                    int iMax = 0;
                                    while (true) {
                                        j2 = lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2.childConstraints;
                                        if (mainAxisSizeWithSpacings >= 0 || i53 <= 0) {
                                            break;
                                        }
                                        int i55 = i49;
                                        int i56 = i53 - 1;
                                        LazyListMeasuredItem lazyListMeasuredItemM161getAndMeasure0kLqBqw = lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2.m161getAndMeasure0kLqBqw(i56, j2);
                                        arrayDeque2.add(0, lazyListMeasuredItemM161getAndMeasure0kLqBqw);
                                        iMax = Math.max(iMax, lazyListMeasuredItemM161getAndMeasure0kLqBqw.crossAxisSize);
                                        mainAxisSizeWithSpacings += lazyListMeasuredItemM161getAndMeasure0kLqBqw.getMainAxisSizeWithSpacings();
                                        i53 = i56;
                                        i49 = i55;
                                    }
                                    int i57 = i49;
                                    if (mainAxisSizeWithSpacings < i54) {
                                        iRound -= i54 - mainAxisSizeWithSpacings;
                                        mainAxisSizeWithSpacings = i54;
                                    }
                                    int i58 = iRound;
                                    int i59 = mainAxisSizeWithSpacings - i54;
                                    int i60 = i50 + i43;
                                    int i61 = i60 >= 0 ? i60 : 0;
                                    int i62 = iMax;
                                    int mainAxisSizeWithSpacings2 = -i59;
                                    int i63 = i53;
                                    int i64 = 0;
                                    boolean z11 = false;
                                    while (i64 < arrayDeque2.size) {
                                        if (mainAxisSizeWithSpacings2 >= i61) {
                                            arrayDeque2.removeAt(i64);
                                            z11 = true;
                                        } else {
                                            i63++;
                                            int mainAxisSizeWithSpacings3 = ((LazyListMeasuredItem) arrayDeque2.get(i64)).getMainAxisSizeWithSpacings() + mainAxisSizeWithSpacings2;
                                            i64++;
                                            mainAxisSizeWithSpacings2 = mainAxisSizeWithSpacings3;
                                        }
                                    }
                                    int iMax2 = i62;
                                    int mainAxisSizeWithSpacings4 = i59;
                                    boolean z12 = z11;
                                    int i65 = i63;
                                    while (i65 < i45 && (mainAxisSizeWithSpacings2 < i61 || mainAxisSizeWithSpacings2 <= 0 || arrayDeque2.isEmpty())) {
                                        int i66 = i61;
                                        LazyListMeasuredItem lazyListMeasuredItemM161getAndMeasure0kLqBqw2 = lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2.m161getAndMeasure0kLqBqw(i65, j2);
                                        mainAxisSizeWithSpacings2 = lazyListMeasuredItemM161getAndMeasure0kLqBqw2.getMainAxisSizeWithSpacings() + mainAxisSizeWithSpacings2;
                                        if (mainAxisSizeWithSpacings2 <= i54) {
                                            i39 = i54;
                                            if (i65 != i45 - 1) {
                                                i53 = i65 + 1;
                                                mainAxisSizeWithSpacings4 -= lazyListMeasuredItemM161getAndMeasure0kLqBqw2.getMainAxisSizeWithSpacings();
                                                z12 = true;
                                            }
                                            i65++;
                                            i61 = i66;
                                            i54 = i39;
                                        } else {
                                            i39 = i54;
                                        }
                                        iMax2 = Math.max(iMax2, lazyListMeasuredItemM161getAndMeasure0kLqBqw2.crossAxisSize);
                                        arrayDeque2.addLast(lazyListMeasuredItemM161getAndMeasure0kLqBqw2);
                                        i65++;
                                        i61 = i66;
                                        i54 = i39;
                                    }
                                    if (mainAxisSizeWithSpacings2 < i50) {
                                        int i67 = i50 - mainAxisSizeWithSpacings2;
                                        int i68 = mainAxisSizeWithSpacings2 + i67;
                                        int mainAxisSizeWithSpacings5 = mainAxisSizeWithSpacings4 - i67;
                                        while (mainAxisSizeWithSpacings5 < i44 && i53 > 0) {
                                            int i69 = i67;
                                            int i70 = i53 - 1;
                                            int i71 = i68;
                                            LazyListMeasuredItem lazyListMeasuredItemM161getAndMeasure0kLqBqw3 = lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2.m161getAndMeasure0kLqBqw(i70, j2);
                                            i53 = i70;
                                            arrayDeque2.add(0, lazyListMeasuredItemM161getAndMeasure0kLqBqw3);
                                            iMax2 = Math.max(iMax2, lazyListMeasuredItemM161getAndMeasure0kLqBqw3.crossAxisSize);
                                            mainAxisSizeWithSpacings5 += lazyListMeasuredItemM161getAndMeasure0kLqBqw3.getMainAxisSizeWithSpacings();
                                            i68 = i71;
                                            i67 = i69;
                                        }
                                        int i72 = i67;
                                        int i73 = i68;
                                        i26 = i58;
                                        int i74 = i26 + i72;
                                        if (mainAxisSizeWithSpacings5 < 0) {
                                            int i75 = i74 + mainAxisSizeWithSpacings5;
                                            int i76 = i73 + mainAxisSizeWithSpacings5;
                                            i29 = iMax2;
                                            i27 = i76;
                                            i210 = i53;
                                            i211 = i75;
                                            i28 = 0;
                                        } else {
                                            i28 = mainAxisSizeWithSpacings5;
                                            i27 = i73;
                                            i29 = iMax2;
                                            i210 = i53;
                                            i211 = i74;
                                        }
                                    } else {
                                        i26 = i58;
                                        i27 = mainAxisSizeWithSpacings2;
                                        i28 = mainAxisSizeWithSpacings4;
                                        i29 = iMax2;
                                        i210 = i53;
                                        i211 = i26;
                                    }
                                    int i77 = i65;
                                    if (Integer.signum(Math.round(f3)) != Integer.signum(i211) || Math.abs(Math.round(f3)) < Math.abs(i211)) {
                                        i212 = i211;
                                        f = f3;
                                    } else {
                                        i212 = i211;
                                        f = i212;
                                    }
                                    float f4 = f3 - f;
                                    float f5 = CropImageView.DEFAULT_ASPECT_RATIO;
                                    if (zIsLookingAhead && i212 > i26 && f4 <= CropImageView.DEFAULT_ASPECT_RATIO) {
                                        f5 = (i212 - i26) + f4;
                                    }
                                    float f6 = f5;
                                    if (i28 < 0) {
                                        InlineClassHelperKt.throwIllegalArgumentException("negative currentFirstItemScrollOffset");
                                    }
                                    int i78 = -i28;
                                    LazyListMeasuredItem lazyListMeasuredItem8 = (LazyListMeasuredItem) arrayDeque2.first();
                                    if (i44 > 0 || iMo75roundToPx0680j_8 < 0) {
                                        int size2 = arrayDeque2.getSize();
                                        LazyListMeasuredItem lazyListMeasuredItem9 = lazyListMeasuredItem8;
                                        int i79 = 0;
                                        while (i79 < size2) {
                                            int i80 = size2;
                                            int mainAxisSizeWithSpacings6 = ((LazyListMeasuredItem) arrayDeque2.get(i79)).getMainAxisSizeWithSpacings();
                                            if (i28 == 0 || mainAxisSizeWithSpacings6 > i28 || i79 == arrayDeque2.getSize() - 1) {
                                                break;
                                            }
                                            i28 -= mainAxisSizeWithSpacings6;
                                            i79++;
                                            lazyListMeasuredItem9 = (LazyListMeasuredItem) arrayDeque2.get(i79);
                                            size2 = i80;
                                        }
                                        lazyListMeasuredItem = lazyListMeasuredItem9;
                                    } else {
                                        lazyListMeasuredItem = lazyListMeasuredItem8;
                                    }
                                    int i81 = i28;
                                    int iMax3 = Math.max(0, i210);
                                    int i82 = i210 - 1;
                                    if (iMax3 <= i82) {
                                        List arrayList3 = null;
                                        while (true) {
                                            if (arrayList3 == null) {
                                                arrayList3 = new ArrayList();
                                            }
                                            i30 = i45;
                                            arrayList = arrayList3;
                                            arrayList.add(lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2.m161getAndMeasure0kLqBqw(i82, j2));
                                            if (i82 == iMax3) {
                                                break;
                                            }
                                            i82--;
                                            arrayList3 = arrayList;
                                            i45 = i30;
                                        }
                                    } else {
                                        i30 = i45;
                                        arrayList = null;
                                    }
                                    int[] iArr = mutableIntListCalculateLazyLayoutPinnedIndices.content;
                                    for (int i83 = mutableIntListCalculateLazyLayoutPinnedIndices._size - 1; -1 < i83; i83--) {
                                        int i84 = iArr[i83];
                                        if (i84 < iMax3) {
                                            if (arrayList == null) {
                                                arrayList = new ArrayList();
                                            }
                                            arrayList.add(lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2.m161getAndMeasure0kLqBqw(i84, j2));
                                        }
                                    }
                                    if (arrayList == null) {
                                        arrayList = emptyList;
                                    }
                                    int iMax4 = i29;
                                    int i85 = 0;
                                    for (int size3 = arrayList.size(); i85 < size3; size3 = size3) {
                                        iMax4 = Math.max(iMax4, ((LazyListMeasuredItem) arrayList.get(i85)).crossAxisSize);
                                        i85++;
                                    }
                                    int iMin = Math.min(((LazyListMeasuredItem) CollectionsKt.last(arrayDeque2)).index, i30 - 1);
                                    int i86 = ((LazyListMeasuredItem) CollectionsKt.last(arrayDeque2)).index + 1;
                                    if (i86 <= iMin) {
                                        ArrayList arrayList4 = null;
                                        while (true) {
                                            if (arrayList4 == null) {
                                                arrayList4 = new ArrayList();
                                            }
                                            i31 = iMax4;
                                            f2 = f;
                                            arrayList2 = arrayList4;
                                            arrayList2.add(lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2.m161getAndMeasure0kLqBqw(i86, j2));
                                            if (i86 == iMin) {
                                                break;
                                            }
                                            i86++;
                                            arrayList4 = arrayList2;
                                            iMax4 = i31;
                                            f = f2;
                                        }
                                    } else {
                                        i31 = iMax4;
                                        f2 = f;
                                        arrayList2 = null;
                                    }
                                    if (arrayList2 != null && ((LazyListMeasuredItem) CollectionsKt.last(arrayList2)).index > iMin) {
                                        iMin = ((LazyListMeasuredItem) CollectionsKt.last(arrayList2)).index;
                                    }
                                    int[] iArr2 = mutableIntListCalculateLazyLayoutPinnedIndices.content;
                                    int i87 = mutableIntListCalculateLazyLayoutPinnedIndices._size;
                                    List arrayList5 = arrayList2;
                                    int i88 = 0;
                                    while (i88 < i87) {
                                        int i89 = i87;
                                        int i90 = iArr2[i88];
                                        if (i90 > iMin) {
                                            if (arrayList5 == null) {
                                                arrayList5 = new ArrayList();
                                            }
                                            arrayList5.add(lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2.m161getAndMeasure0kLqBqw(i90, j2));
                                        }
                                        i88++;
                                        i87 = i89;
                                    }
                                    if (arrayList5 == null) {
                                        arrayList5 = emptyList;
                                    }
                                    int size4 = arrayList5.size();
                                    int iMax5 = i31;
                                    for (int i91 = 0; i91 < size4; i91++) {
                                        iMax5 = Math.max(iMax5, ((LazyListMeasuredItem) arrayList5.get(i91)).crossAxisSize);
                                    }
                                    boolean z13 = Intrinsics.areEqual(lazyListMeasuredItem, arrayDeque2.first()) && arrayList.isEmpty() && arrayList5.isEmpty();
                                    int iM792constrainWidthK40F9xA = ConstraintsKt.m792constrainWidthK40F9xA(z10 ? iMax5 : i27, jM793offsetNN6EwU);
                                    if (z10) {
                                        iMax5 = i27;
                                    }
                                    int iM791constrainHeightK40F9xA2 = ConstraintsKt.m791constrainHeightK40F9xA(iMax5, jM793offsetNN6EwU);
                                    int i92 = z10 ? iM791constrainHeightK40F9xA2 : iM792constrainWidthK40F9xA;
                                    boolean z14 = i27 < Math.min(i92, i50);
                                    if (z14 && i78 != 0) {
                                        InlineClassHelperKt.throwIllegalStateException("non-zero itemsScrollOffset");
                                    }
                                    boolean z15 = z13;
                                    ArrayList arrayList6 = new ArrayList(arrayList5.size() + arrayList.size() + arrayDeque2.getSize());
                                    if (z14) {
                                        if (!arrayList.isEmpty() || !arrayList5.isEmpty()) {
                                            InlineClassHelperKt.throwIllegalArgumentException("no extra items");
                                        }
                                        int size5 = arrayDeque2.getSize();
                                        int[] iArr3 = new int[size5];
                                        for (int i93 = 0; i93 < size5; i93++) {
                                            iArr3[i93] = ((LazyListMeasuredItem) arrayDeque2.get(i93)).size;
                                        }
                                        int[] iArr4 = new int[size5];
                                        if (z10) {
                                            if (arrangement$Vertical7 == null) {
                                                throw Fragment$5$$ExternalSyntheticOutline0.m("null verticalArrangement when isVertical == true");
                                            }
                                            arrangement$Vertical7.arrange(lazyLayoutMeasureScopeImpl, i92, iArr3, iArr4);
                                            i32 = 0;
                                        } else {
                                            if (arrangement$Horizontal4 == null) {
                                                throw Fragment$5$$ExternalSyntheticOutline0.m("null horizontalArrangement when isVertical == false");
                                            }
                                            i32 = 0;
                                            arrangement$Horizontal4.arrange(lazyLayoutMeasureScopeImpl, i92, iArr3, LayoutDirection.Ltr, iArr4);
                                        }
                                        IntRange indices = ArraysKt.getIndices(iArr4);
                                        int i94 = indices.last;
                                        int i95 = indices.step;
                                        if ((i95 > 0 && i94 >= 0) || (i95 < 0 && i94 <= 0)) {
                                            int i96 = i32;
                                            while (true) {
                                                int i97 = iArr4[i96];
                                                LazyListMeasuredItem lazyListMeasuredItem10 = (LazyListMeasuredItem) arrayDeque2.get(i96);
                                                lazyListMeasuredItem10.position(i97, iM792constrainWidthK40F9xA, iM791constrainHeightK40F9xA2);
                                                arrayList6.add(lazyListMeasuredItem10);
                                                if (i96 == i94) {
                                                    break;
                                                }
                                                i96 += i95;
                                            }
                                        }
                                    } else {
                                        i50 = i50;
                                        lazyListMeasuredItem = lazyListMeasuredItem;
                                        i32 = 0;
                                        int size6 = arrayList.size();
                                        int mainAxisSizeWithSpacings7 = i78;
                                        int i98 = 0;
                                        while (i98 < size6) {
                                            int i99 = size6;
                                            LazyListMeasuredItem lazyListMeasuredItem11 = (LazyListMeasuredItem) arrayList.get(i98);
                                            mainAxisSizeWithSpacings7 -= lazyListMeasuredItem11.getMainAxisSizeWithSpacings();
                                            lazyListMeasuredItem11.position(mainAxisSizeWithSpacings7, iM792constrainWidthK40F9xA, iM791constrainHeightK40F9xA2);
                                            arrayList6.add(lazyListMeasuredItem11);
                                            i98++;
                                            size6 = i99;
                                        }
                                        int size7 = arrayDeque2.getSize();
                                        int mainAxisSizeWithSpacings8 = i78;
                                        for (int i100 = 0; i100 < size7; i100++) {
                                            LazyListMeasuredItem lazyListMeasuredItem12 = (LazyListMeasuredItem) arrayDeque2.get(i100);
                                            lazyListMeasuredItem12.position(mainAxisSizeWithSpacings8, iM792constrainWidthK40F9xA, iM791constrainHeightK40F9xA2);
                                            arrayList6.add(lazyListMeasuredItem12);
                                            mainAxisSizeWithSpacings8 += lazyListMeasuredItem12.getMainAxisSizeWithSpacings();
                                        }
                                        int size8 = arrayList5.size();
                                        for (int i101 = 0; i101 < size8; i101++) {
                                            LazyListMeasuredItem lazyListMeasuredItem13 = (LazyListMeasuredItem) arrayList5.get(i101);
                                            lazyListMeasuredItem13.position(mainAxisSizeWithSpacings8, iM792constrainWidthK40F9xA, iM791constrainHeightK40F9xA2);
                                            arrayList6.add(lazyListMeasuredItem13);
                                            mainAxisSizeWithSpacings8 += lazyListMeasuredItem13.getMainAxisSizeWithSpacings();
                                        }
                                    }
                                    float f7 = f2;
                                    int i102 = i27;
                                    lazyLayoutItemAnimator.onMeasured((int) f7, iM792constrainWidthK40F9xA, iM791constrainHeightK40F9xA2, arrayList6, statusLine, lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2, z10, zIsLookingAhead, 1, z7, i81, i102, coroutineScope2, graphicsContext2, z9);
                                    if (zIsLookingAhead) {
                                        arrayDeque = arrayDeque2;
                                    } else {
                                        long jM173getMinSizeToFitDisappearingItemsYbymL2g2 = lazyLayoutItemAnimator.m173getMinSizeToFitDisappearingItemsYbymL2g();
                                        arrayDeque = arrayDeque2;
                                        if (!IntSize.m810equalsimpl0(jM173getMinSizeToFitDisappearingItemsYbymL2g2, 0L)) {
                                            int i103 = z10 ? iM791constrainHeightK40F9xA2 : iM792constrainWidthK40F9xA;
                                            iM792constrainWidthK40F9xA = ConstraintsKt.m792constrainWidthK40F9xA(Math.max(iM792constrainWidthK40F9xA, (int) (jM173getMinSizeToFitDisappearingItemsYbymL2g2 >> 32)), jM793offsetNN6EwU);
                                            iM791constrainHeightK40F9xA = ConstraintsKt.m791constrainHeightK40F9xA(Math.max(iM791constrainHeightK40F9xA2, (int) (jM173getMinSizeToFitDisappearingItemsYbymL2g2 & 4294967295L)), jM793offsetNN6EwU);
                                            int i104 = z10 ? iM791constrainHeightK40F9xA : iM792constrainWidthK40F9xA;
                                            if (i104 != i103) {
                                                int size9 = arrayList6.size();
                                                for (int i105 = i32; i105 < size9; i105++) {
                                                    LazyListMeasuredItem lazyListMeasuredItem14 = (LazyListMeasuredItem) arrayList6.get(i105);
                                                    lazyListMeasuredItem14.mainAxisLayoutSize = i104;
                                                    lazyListMeasuredItem14.maxMainAxisOffset = lazyListMeasuredItem14.afterContentPadding + i104;
                                                }
                                            }
                                        }
                                        int i108 = iM792constrainWidthK40F9xA;
                                        lazyListMeasuredItem2 = (LazyListMeasuredItem) arrayDeque.firstOrNull();
                                        if (lazyListMeasuredItem2 != null) {
                                            i33 = lazyListMeasuredItem2.index;
                                        } else {
                                            i33 = i32;
                                        }
                                        lazyListMeasuredItem3 = (LazyListMeasuredItem) arrayDeque.lastOrNull();
                                        if (lazyListMeasuredItem3 != null) {
                                            i34 = lazyListMeasuredItem3.index;
                                        } else {
                                            i34 = i32;
                                        }
                                        mutableIntList = lazyListItemProviderImpl3.intervalContent._headerIndexes;
                                        if (mutableIntList == null) {
                                            mutableIntList = IntListKt.EmptyIntList;
                                        }
                                        int i109 = iM791constrainHeightK40F9xA;
                                        listApplyStickyItems = LazyLayoutKt.applyStickyItems(noKey, i33, i34, arrayList6, mutableIntList, i44, i108, i109, z10, new ScrollState$$ExternalSyntheticLambda0((byte) 13, lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2));
                                        if (z15) {
                                            lazyListMeasuredItem7 = (LazyListMeasuredItem) CollectionsKt.firstOrNull((List) arrayList6);
                                            if (lazyListMeasuredItem7 != null) {
                                                numValueOf = Integer.valueOf(lazyListMeasuredItem7.index);
                                            } else {
                                                numValueOf = null;
                                            }
                                        } else {
                                            lazyListMeasuredItem4 = (LazyListMeasuredItem) arrayDeque.firstOrNull();
                                            if (lazyListMeasuredItem4 != null) {
                                                numValueOf = Integer.valueOf(lazyListMeasuredItem4.index);
                                            } else {
                                                numValueOf = null;
                                            }
                                        }
                                        if (z15) {
                                            lazyListMeasuredItem6 = (LazyListMeasuredItem) CollectionsKt.lastOrNull(arrayList6);
                                            if (lazyListMeasuredItem6 != null) {
                                                numValueOf2 = Integer.valueOf(lazyListMeasuredItem6.index);
                                            } else {
                                                numValueOf2 = null;
                                            }
                                        } else {
                                            lazyListMeasuredItem5 = (LazyListMeasuredItem) arrayDeque.lastOrNull();
                                            if (lazyListMeasuredItem5 != null) {
                                                numValueOf2 = Integer.valueOf(lazyListMeasuredItem5.index);
                                            } else {
                                                numValueOf2 = null;
                                            }
                                        }
                                        i35 = i30;
                                        if (i77 >= i35 || i102 > i50) {
                                            i36 = 1;
                                        } else {
                                            i36 = i32;
                                        }
                                        MeasureResult measureResultLayout3 = subcomposeMeasureScope2.layout(ConstraintsKt.m792constrainWidthK40F9xA(i108 + i40, j), ConstraintsKt.m791constrainHeightK40F9xA(i109 + i57, j), emptyMap, new LazyListMeasureKt$$ExternalSyntheticLambda2(mutableState, arrayList6, listApplyStickyItems, zIsLookingAhead, (byte) 0));
                                        if (numValueOf != null) {
                                            iIntValue = numValueOf.intValue();
                                        } else {
                                            iIntValue = i32;
                                        }
                                        if (numValueOf2 != null) {
                                            iIntValue2 = numValueOf2.intValue();
                                        } else {
                                            iIntValue2 = i32;
                                        }
                                        List listUpdatedVisibleItems2 = LazyLayoutKt.updatedVisibleItems(iIntValue, iIntValue2, arrayList6, listApplyStickyItems);
                                        if (!z10) {
                                            orientation3 = orientation2;
                                        }
                                        size = listApplyStickyItems.size();
                                        i37 = i32;
                                        i38 = i37;
                                        while (i37 < size) {
                                            i38 += ((LazyListMeasuredItem) listApplyStickyItems.get(i37)).size;
                                            i37++;
                                        }
                                        lazyListItemProviderImpl3 = lazyListItemProviderImpl3;
                                        lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1 = lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2;
                                        subcomposeMeasureScope = subcomposeMeasureScope2;
                                        lazyListMeasureResult = new LazyListMeasureResult(lazyListMeasuredItem, i81, i36, f7, measureResultLayout3, f6, z12, coroutineScope2, lazyLayoutMeasureScopeImpl, lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2.childConstraints, i38, listUpdatedVisibleItems2, i52, i60, i35, orientation3, i43, iMo75roundToPx0680j_8);
                                    }
                                    iM791constrainHeightK40F9xA = iM791constrainHeightK40F9xA2;
                                    int i1010 = iM792constrainWidthK40F9xA;
                                    lazyListMeasuredItem2 = (LazyListMeasuredItem) arrayDeque.firstOrNull();
                                    if (lazyListMeasuredItem2 != null) {
                                        i33 = lazyListMeasuredItem2.index;
                                    } else {
                                        i33 = i32;
                                    }
                                    lazyListMeasuredItem3 = (LazyListMeasuredItem) arrayDeque.lastOrNull();
                                    if (lazyListMeasuredItem3 != null) {
                                        i34 = lazyListMeasuredItem3.index;
                                    } else {
                                        i34 = i32;
                                    }
                                    mutableIntList = lazyListItemProviderImpl3.intervalContent._headerIndexes;
                                    if (mutableIntList == null) {
                                        mutableIntList = IntListKt.EmptyIntList;
                                    }
                                    int i1011 = iM791constrainHeightK40F9xA;
                                    listApplyStickyItems = LazyLayoutKt.applyStickyItems(noKey, i33, i34, arrayList6, mutableIntList, i44, i1010, i1011, z10, new ScrollState$$ExternalSyntheticLambda0((byte) 13, lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2));
                                    if (z15) {
                                        lazyListMeasuredItem7 = (LazyListMeasuredItem) CollectionsKt.firstOrNull((List) arrayList6);
                                        if (lazyListMeasuredItem7 != null) {
                                            numValueOf = Integer.valueOf(lazyListMeasuredItem7.index);
                                        } else {
                                            numValueOf = null;
                                        }
                                    } else {
                                        lazyListMeasuredItem4 = (LazyListMeasuredItem) arrayDeque.firstOrNull();
                                        if (lazyListMeasuredItem4 != null) {
                                            numValueOf = Integer.valueOf(lazyListMeasuredItem4.index);
                                        } else {
                                            numValueOf = null;
                                        }
                                    }
                                    if (z15) {
                                        lazyListMeasuredItem6 = (LazyListMeasuredItem) CollectionsKt.lastOrNull(arrayList6);
                                        if (lazyListMeasuredItem6 != null) {
                                            numValueOf2 = Integer.valueOf(lazyListMeasuredItem6.index);
                                        } else {
                                            numValueOf2 = null;
                                        }
                                    } else {
                                        lazyListMeasuredItem5 = (LazyListMeasuredItem) arrayDeque.lastOrNull();
                                        if (lazyListMeasuredItem5 != null) {
                                            numValueOf2 = Integer.valueOf(lazyListMeasuredItem5.index);
                                        } else {
                                            numValueOf2 = null;
                                        }
                                    }
                                    i35 = i30;
                                    if (i77 >= i35) {
                                        i36 = 1;
                                    } else {
                                        i36 = 1;
                                    }
                                    MeasureResult measureResultLayout4 = subcomposeMeasureScope2.layout(ConstraintsKt.m792constrainWidthK40F9xA(i1010 + i40, j), ConstraintsKt.m791constrainHeightK40F9xA(i1011 + i57, j), emptyMap, new LazyListMeasureKt$$ExternalSyntheticLambda2(mutableState, arrayList6, listApplyStickyItems, zIsLookingAhead, (byte) 0));
                                    if (numValueOf != null) {
                                        iIntValue = numValueOf.intValue();
                                    } else {
                                        iIntValue = i32;
                                    }
                                    if (numValueOf2 != null) {
                                        iIntValue2 = numValueOf2.intValue();
                                    } else {
                                        iIntValue2 = i32;
                                    }
                                    List listUpdatedVisibleItems3 = LazyLayoutKt.updatedVisibleItems(iIntValue, iIntValue2, arrayList6, listApplyStickyItems);
                                    if (!z10) {
                                        orientation3 = orientation2;
                                    }
                                    size = listApplyStickyItems.size();
                                    i37 = i32;
                                    i38 = i37;
                                    while (i37 < size) {
                                        i38 += ((LazyListMeasuredItem) listApplyStickyItems.get(i37)).size;
                                        i37++;
                                    }
                                    lazyListItemProviderImpl3 = lazyListItemProviderImpl3;
                                    lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1 = lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2;
                                    subcomposeMeasureScope = subcomposeMeasureScope2;
                                    lazyListMeasureResult = new LazyListMeasureResult(lazyListMeasuredItem, i81, i36, f7, measureResultLayout4, f6, z12, coroutineScope2, lazyLayoutMeasureScopeImpl, lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2.childConstraints, i38, listUpdatedVisibleItems3, i52, i60, i35, orientation3, i43, iMo75roundToPx0680j_8);
                                }
                                LazyListMeasureResult lazyListMeasureResult2 = lazyListMeasureResult;
                                LazyListState lazyListState6 = lazyListState4;
                                lazyListState6.applyMeasureResult$foundation(lazyListMeasureResult2, subcomposeMeasureScope.isLookingAhead(), false);
                                Object obj2 = lazyListState6.prefetchStrategy;
                                CacheWindowLogic cacheWindowLogic = obj2 instanceof CacheWindowLogic ? (CacheWindowLogic) obj2 : null;
                                if (cacheWindowLogic == null) {
                                    return lazyListMeasureResult2;
                                }
                                List list = lazyListMeasureResult2.visibleItemsInfo;
                                Trace.beginSection("compose:lazy:cache_window:keepAroundItems");
                                try {
                                    if (cacheWindowLogic.hasValidBounds() && !list.isEmpty()) {
                                        int i115 = ((LazyListMeasuredItem) CollectionsKt.first(list)).index;
                                        int i116 = ((LazyListMeasuredItem) CollectionsKt.last(list)).index;
                                        int i117 = cacheWindowLogic.getPerLaneCacheWindowStartIndex()[0];
                                        LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1 lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$3 = lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1;
                                        while (true) {
                                            lazyLayoutMeasureScopeImpl2 = lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$3.measureScope;
                                            if (i117 >= i115) {
                                                break;
                                            }
                                            if (i117 >= 0 && i117 < lazyListItemProviderImpl3.getItemCount()) {
                                                lazyLayoutMeasureScopeImpl2.compose(i117);
                                            }
                                            i117++;
                                        }
                                        int i118 = i116 + 1;
                                        int i119 = cacheWindowLogic.getPerLaneCacheWindowEndItemIndex()[0];
                                        if (i118 <= i119) {
                                            while (true) {
                                                if (i118 >= 0 && i118 < lazyListItemProviderImpl3.getItemCount()) {
                                                    lazyLayoutMeasureScopeImpl2.compose(i118);
                                                }
                                                if (i118 == i119) {
                                                    break;
                                                }
                                                i118++;
                                            }
                                        }
                                    }
                                    return lazyListMeasureResult2;
                                } finally {
                                    Trace.endSection();
                                }
                            } catch (Throwable th) {
                                Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                                throw th;
                            }
                        }
                    };
                    kProperty1 = kProperty0;
                    arrangement$Vertical4 = arrangement$Vertical6;
                    gapComposer2.updateRememberedValue(obj);
                } else {
                    gapComposer2 = gapComposer3;
                    final Arrangement$Vertical arrangement$Vertical7 = arrangement$Vertical3;
                    lazyListState3 = lazyListState;
                    horizontal2 = horizontal3;
                    i9 = 4;
                    obj = new LazyLayoutMeasurePolicy() { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1
                        /* JADX WARN: Code duplicated, block: B:301:0x06ea  */
                        /* JADX WARN: Code duplicated, block: B:302:0x06ef  */
                        /* JADX WARN: Code duplicated, block: B:305:0x06f9  */
                        /* JADX WARN: Code duplicated, block: B:307:0x0700  */
                        /* JADX WARN: Code duplicated, block: B:311:0x070c  */
                        /* JADX WARN: Code duplicated, block: B:314:0x072c  */
                        /* JADX WARN: Code duplicated, block: B:316:0x0734  */
                        /* JADX WARN: Code duplicated, block: B:317:0x073b  */
                        /* JADX WARN: Code duplicated, block: B:318:0x073e  */
                        /* JADX WARN: Code duplicated, block: B:320:0x0746  */
                        /* JADX WARN: Code duplicated, block: B:322:0x074e  */
                        /* JADX WARN: Code duplicated, block: B:324:0x0756  */
                        /* JADX WARN: Code duplicated, block: B:326:0x075f  */
                        /* JADX WARN: Code duplicated, block: B:327:0x0762  */
                        /* JADX WARN: Code duplicated, block: B:329:0x076a  */
                        /* JADX WARN: Code duplicated, block: B:334:0x0779  */
                        /* JADX WARN: Code duplicated, block: B:337:0x07a4  */
                        /* JADX WARN: Code duplicated, block: B:338:0x07a9  */
                        /* JADX WARN: Code duplicated, block: B:340:0x07ad  */
                        /* JADX WARN: Code duplicated, block: B:341:0x07b2  */
                        /* JADX WARN: Code duplicated, block: B:345:0x07bb  */
                        /* JADX WARN: Code duplicated, block: B:348:0x07c6 A[LOOP:15: B:347:0x07c4->B:348:0x07c6, LOOP_END] */
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasurePolicy
                        /* JADX INFO: renamed from: measure-0kLqBqw, reason: not valid java name */
                        public final MeasureResult mo159measure0kLqBqw(LazyLayoutMeasureScopeImpl lazyLayoutMeasureScopeImpl, long j) {
                            float fMo112getSpacingD9Ej5fM;
                            LazyListState lazyListState4;
                            long j2;
                            int i26;
                            int i27;
                            int i28;
                            int i29;
                            int i210;
                            int i211;
                            int i212;
                            float f;
                            LazyListMeasuredItem lazyListMeasuredItem;
                            int i30;
                            List arrayList;
                            int i31;
                            float f2;
                            ArrayList arrayList2;
                            int i32;
                            ArrayDeque arrayDeque;
                            int iM791constrainHeightK40F9xA;
                            LazyListMeasuredItem lazyListMeasuredItem2;
                            int i33;
                            LazyListMeasuredItem lazyListMeasuredItem3;
                            int i34;
                            MutableIntList mutableIntList;
                            List listApplyStickyItems;
                            LazyListMeasuredItem lazyListMeasuredItem4;
                            Integer numValueOf;
                            LazyListMeasuredItem lazyListMeasuredItem5;
                            Integer numValueOf2;
                            int i35;
                            int i36;
                            int iIntValue;
                            int iIntValue2;
                            int size;
                            int i37;
                            int i38;
                            LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1 lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1;
                            SubcomposeMeasureScope subcomposeMeasureScope;
                            LazyListMeasureResult lazyListMeasureResult;
                            LazyListMeasuredItem lazyListMeasuredItem6;
                            LazyListMeasuredItem lazyListMeasuredItem7;
                            int i39;
                            LazyLayoutMeasureScopeImpl lazyLayoutMeasureScopeImpl2;
                            SubcomposeMeasureScope subcomposeMeasureScope2 = lazyLayoutMeasureScopeImpl.subcomposeMeasureScope;
                            LazyListState lazyListState5 = lazyListState3;
                            lazyListState5.measurementScopeInvalidator.getValue();
                            boolean z7 = lazyListState5.hasLookaheadOccurred || subcomposeMeasureScope2.isLookingAhead();
                            Orientation orientation2 = Orientation.Horizontal;
                            Orientation orientation3 = Orientation.Vertical;
                            boolean z8 = z;
                            ImageKt.m44checkScrollableContainerConstraintsK40F9xA(j, z8 ? orientation3 : orientation2);
                            PaddingValues paddingValues2 = paddingValues;
                            int iMo75roundToPx0680j_4 = z8 ? subcomposeMeasureScope2.mo75roundToPx0680j_4(paddingValues2.mo123calculateLeftPaddingu2uoSUM(subcomposeMeasureScope2.getLayoutDirection())) : subcomposeMeasureScope2.mo75roundToPx0680j_4(OffsetKt.calculateStartPadding(paddingValues2, subcomposeMeasureScope2.getLayoutDirection()));
                            int iMo75roundToPx0680j_5 = z8 ? subcomposeMeasureScope2.mo75roundToPx0680j_4(paddingValues2.mo124calculateRightPaddingu2uoSUM(subcomposeMeasureScope2.getLayoutDirection())) : subcomposeMeasureScope2.mo75roundToPx0680j_4(OffsetKt.calculateEndPadding(paddingValues2, subcomposeMeasureScope2.getLayoutDirection()));
                            int iMo75roundToPx0680j_6 = subcomposeMeasureScope2.mo75roundToPx0680j_4(paddingValues2.mo125calculateTopPaddingD9Ej5fM());
                            int iMo75roundToPx0680j_7 = subcomposeMeasureScope2.mo75roundToPx0680j_4(paddingValues2.mo122calculateBottomPaddingD9Ej5fM()) + iMo75roundToPx0680j_6;
                            int i40 = iMo75roundToPx0680j_4 + iMo75roundToPx0680j_5;
                            int i41 = z8 ? iMo75roundToPx0680j_7 : i40;
                            int i42 = z8 ? iMo75roundToPx0680j_6 : !z8 ? iMo75roundToPx0680j_4 : iMo75roundToPx0680j_5;
                            int i43 = i41 - i42;
                            long jM793offsetNN6EwU = ConstraintsKt.m793offsetNN6EwU(-i40, -iMo75roundToPx0680j_7, j);
                            LazyListItemProviderImpl lazyListItemProviderImpl = (LazyListItemProviderImpl) kProperty0.invoke();
                            LazyItemScopeImpl lazyItemScopeImpl4 = lazyListItemProviderImpl.itemScope;
                            int iM784getMaxWidthimpl = Constraints.m784getMaxWidthimpl(jM793offsetNN6EwU);
                            int iM783getMaxHeightimpl = Constraints.m783getMaxHeightimpl(jM793offsetNN6EwU);
                            lazyItemScopeImpl4.maxWidthState.setIntValue(iM784getMaxWidthimpl);
                            lazyItemScopeImpl4.maxHeightState.setIntValue(iM783getMaxHeightimpl);
                            Arrangement$Horizontal arrangement$Horizontal4 = arrangement$Horizontal3;
                            Arrangement$Vertical arrangement$Vertical8 = arrangement$Vertical7;
                            if (z8) {
                                if (arrangement$Vertical8 == null) {
                                    throw Fragment$5$$ExternalSyntheticOutline0.m("null verticalArrangement when isVertical == true");
                                }
                                fMo112getSpacingD9Ej5fM = arrangement$Vertical8.mo112getSpacingD9Ej5fM();
                            } else {
                                if (arrangement$Horizontal4 == null) {
                                    throw Fragment$5$$ExternalSyntheticOutline0.m("null horizontalAlignment when isVertical == false");
                                }
                                fMo112getSpacingD9Ej5fM = arrangement$Horizontal4.mo112getSpacingD9Ej5fM();
                            }
                            int iMo75roundToPx0680j_8 = subcomposeMeasureScope2.mo75roundToPx0680j_4(fMo112getSpacingD9Ej5fM);
                            int itemCount = lazyListItemProviderImpl.getItemCount();
                            long j3 = (((long) iMo75roundToPx0680j_4) << 32) | (((long) iMo75roundToPx0680j_6) & 4294967295L);
                            int iM783getMaxHeightimpl2 = z8 ? Constraints.m783getMaxHeightimpl(j) - iMo75roundToPx0680j_7 : Constraints.m784getMaxWidthimpl(j) - i40;
                            int i44 = i42;
                            LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1 lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2 = new LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1(jM793offsetNN6EwU, z, lazyListItemProviderImpl, lazyLayoutMeasureScopeImpl, itemCount, iMo75roundToPx0680j_8, horizontal2, vertical3, i44, i43, j3, lazyListState3);
                            int i45 = itemCount;
                            LazyListItemProviderImpl lazyListItemProviderImpl2 = lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2.itemProvider;
                            StatusLine statusLine = lazyListItemProviderImpl2.keyIndexMap;
                            Snapshot currentThreadSnapshot = Lock.getCurrentThreadSnapshot();
                            Function1 readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                            Snapshot snapshotMakeCurrentNonObservable = Lock.makeCurrentNonObservable(currentThreadSnapshot);
                            try {
                                int firstVisibleItemIndex = lazyListState5.getFirstVisibleItemIndex();
                                LazyListScrollPosition lazyListScrollPosition = lazyListState5.scrollPosition;
                                LazyListItemProviderImpl lazyListItemProviderImpl3 = lazyListItemProviderImpl2;
                                int iFindIndexByKey = LazyLayoutKt.findIndexByKey(firstVisibleItemIndex, lazyListItemProviderImpl, lazyListScrollPosition.lastKnownFirstItemKey);
                                if (firstVisibleItemIndex != iFindIndexByKey) {
                                    lazyListScrollPosition.index$delegate.setIntValue(iFindIndexByKey);
                                    lazyListScrollPosition.nearestRangeState.update(firstVisibleItemIndex);
                                }
                                int firstVisibleItemScrollOffset = lazyListState5.getFirstVisibleItemScrollOffset();
                                Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                                MutableIntList mutableIntListCalculateLazyLayoutPinnedIndices = LazyLayoutKt.calculateLazyLayoutPinnedIndices(lazyListItemProviderImpl, lazyListState5.pinnedItems, lazyListState5.beyondBoundsInfo);
                                float fFloatValue = (subcomposeMeasureScope2.isLookingAhead() || !z7) ? lazyListState5.scrollToBeConsumed : ((Number) ((AnimationState) lazyListState5._lazyLayoutScrollDeltaBetweenPasses.referenceQueue).value$delegate.getValue()).floatValue();
                                LazyLayoutItemAnimator lazyLayoutItemAnimator = lazyListState5.itemAnimator;
                                boolean zIsLookingAhead = subcomposeMeasureScope2.isLookingAhead();
                                MutableState mutableState = lazyListState5.placementScopeInvalidator;
                                boolean z9 = !lazyListState5.skipItemPlacementAnimation;
                                if (i44 < 0) {
                                    InlineClassHelperKt.throwIllegalArgumentException("invalid beforeContentPadding");
                                }
                                if (i43 < 0) {
                                    InlineClassHelperKt.throwIllegalArgumentException("invalid afterContentPadding");
                                }
                                EmptyMap emptyMap = EmptyMap.INSTANCE;
                                boolean z10 = z;
                                int i46 = firstVisibleItemScrollOffset;
                                CoroutineScope coroutineScope2 = coroutineScope;
                                GraphicsContext graphicsContext2 = graphicsContext;
                                EmptyList emptyList = EmptyList.INSTANCE;
                                if (i45 <= 0) {
                                    int iM786getMinWidthimpl = Constraints.m786getMinWidthimpl(jM793offsetNN6EwU);
                                    int iM785getMinHeightimpl = Constraints.m785getMinHeightimpl(jM793offsetNN6EwU);
                                    lazyLayoutItemAnimator.onMeasured(0, iM786getMinWidthimpl, iM785getMinHeightimpl, new ArrayList(), statusLine, lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2, z10, zIsLookingAhead, 1, z7, 0, 0, coroutineScope2, graphicsContext2, true);
                                    if (!zIsLookingAhead) {
                                        long jM173getMinSizeToFitDisappearingItemsYbymL2g = lazyLayoutItemAnimator.m173getMinSizeToFitDisappearingItemsYbymL2g();
                                        if (!IntSize.m810equalsimpl0(jM173getMinSizeToFitDisappearingItemsYbymL2g, 0L)) {
                                            iM786getMinWidthimpl = ConstraintsKt.m792constrainWidthK40F9xA((int) (jM173getMinSizeToFitDisappearingItemsYbymL2g >> 32), jM793offsetNN6EwU);
                                            iM785getMinHeightimpl = ConstraintsKt.m791constrainHeightK40F9xA((int) (jM173getMinSizeToFitDisappearingItemsYbymL2g & 4294967295L), jM793offsetNN6EwU);
                                        }
                                    }
                                    MeasureResult measureResultLayout = subcomposeMeasureScope2.layout(ConstraintsKt.m792constrainWidthK40F9xA(iM786getMinWidthimpl + i40, j), ConstraintsKt.m791constrainHeightK40F9xA(iM785getMinHeightimpl + iMo75roundToPx0680j_7, j), emptyMap, new OffsetKt$$ExternalSyntheticLambda0((byte) 13));
                                    int i47 = -i44;
                                    int i48 = iM783getMaxHeightimpl2 + i43;
                                    if (!z10) {
                                        orientation3 = orientation2;
                                    }
                                    subcomposeMeasureScope = subcomposeMeasureScope2;
                                    lazyListState4 = lazyListState5;
                                    lazyListMeasureResult = new LazyListMeasureResult(null, 0, false, CropImageView.DEFAULT_ASPECT_RATIO, measureResultLayout, CropImageView.DEFAULT_ASPECT_RATIO, false, coroutineScope2, lazyLayoutMeasureScopeImpl, lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2.childConstraints, 0, emptyList, i47, i48, 0, orientation3, i43, iMo75roundToPx0680j_8);
                                    lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1 = lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2;
                                } else {
                                    lazyListState4 = lazyListState5;
                                    int i49 = iMo75roundToPx0680j_7;
                                    int i50 = iM783getMaxHeightimpl2;
                                    if (iFindIndexByKey >= i45) {
                                        iFindIndexByKey = i45 - 1;
                                        i46 = 0;
                                    }
                                    int iRound = Math.round(fFloatValue);
                                    int i51 = i46 - iRound;
                                    if (iFindIndexByKey == 0 && i51 < 0) {
                                        iRound += i51;
                                        i51 = 0;
                                    }
                                    ArrayDeque arrayDeque2 = new ArrayDeque();
                                    int i52 = -i44;
                                    int i53 = iFindIndexByKey;
                                    int i54 = i52 + (iMo75roundToPx0680j_8 < 0 ? iMo75roundToPx0680j_8 : 0);
                                    int mainAxisSizeWithSpacings = i51 + i54;
                                    float f3 = fFloatValue;
                                    int iMax = 0;
                                    while (true) {
                                        j2 = lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2.childConstraints;
                                        if (mainAxisSizeWithSpacings >= 0 || i53 <= 0) {
                                            break;
                                        }
                                        int i55 = i49;
                                        int i56 = i53 - 1;
                                        LazyListMeasuredItem lazyListMeasuredItemM161getAndMeasure0kLqBqw = lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2.m161getAndMeasure0kLqBqw(i56, j2);
                                        arrayDeque2.add(0, lazyListMeasuredItemM161getAndMeasure0kLqBqw);
                                        iMax = Math.max(iMax, lazyListMeasuredItemM161getAndMeasure0kLqBqw.crossAxisSize);
                                        mainAxisSizeWithSpacings += lazyListMeasuredItemM161getAndMeasure0kLqBqw.getMainAxisSizeWithSpacings();
                                        i53 = i56;
                                        i49 = i55;
                                    }
                                    int i57 = i49;
                                    if (mainAxisSizeWithSpacings < i54) {
                                        iRound -= i54 - mainAxisSizeWithSpacings;
                                        mainAxisSizeWithSpacings = i54;
                                    }
                                    int i58 = iRound;
                                    int i59 = mainAxisSizeWithSpacings - i54;
                                    int i60 = i50 + i43;
                                    int i61 = i60 >= 0 ? i60 : 0;
                                    int i62 = iMax;
                                    int mainAxisSizeWithSpacings2 = -i59;
                                    int i63 = i53;
                                    int i64 = 0;
                                    boolean z11 = false;
                                    while (i64 < arrayDeque2.size) {
                                        if (mainAxisSizeWithSpacings2 >= i61) {
                                            arrayDeque2.removeAt(i64);
                                            z11 = true;
                                        } else {
                                            i63++;
                                            int mainAxisSizeWithSpacings3 = ((LazyListMeasuredItem) arrayDeque2.get(i64)).getMainAxisSizeWithSpacings() + mainAxisSizeWithSpacings2;
                                            i64++;
                                            mainAxisSizeWithSpacings2 = mainAxisSizeWithSpacings3;
                                        }
                                    }
                                    int iMax2 = i62;
                                    int mainAxisSizeWithSpacings4 = i59;
                                    boolean z12 = z11;
                                    int i65 = i63;
                                    while (i65 < i45 && (mainAxisSizeWithSpacings2 < i61 || mainAxisSizeWithSpacings2 <= 0 || arrayDeque2.isEmpty())) {
                                        int i66 = i61;
                                        LazyListMeasuredItem lazyListMeasuredItemM161getAndMeasure0kLqBqw2 = lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2.m161getAndMeasure0kLqBqw(i65, j2);
                                        mainAxisSizeWithSpacings2 = lazyListMeasuredItemM161getAndMeasure0kLqBqw2.getMainAxisSizeWithSpacings() + mainAxisSizeWithSpacings2;
                                        if (mainAxisSizeWithSpacings2 <= i54) {
                                            i39 = i54;
                                            if (i65 != i45 - 1) {
                                                i53 = i65 + 1;
                                                mainAxisSizeWithSpacings4 -= lazyListMeasuredItemM161getAndMeasure0kLqBqw2.getMainAxisSizeWithSpacings();
                                                z12 = true;
                                            }
                                            i65++;
                                            i61 = i66;
                                            i54 = i39;
                                        } else {
                                            i39 = i54;
                                        }
                                        iMax2 = Math.max(iMax2, lazyListMeasuredItemM161getAndMeasure0kLqBqw2.crossAxisSize);
                                        arrayDeque2.addLast(lazyListMeasuredItemM161getAndMeasure0kLqBqw2);
                                        i65++;
                                        i61 = i66;
                                        i54 = i39;
                                    }
                                    if (mainAxisSizeWithSpacings2 < i50) {
                                        int i67 = i50 - mainAxisSizeWithSpacings2;
                                        int i68 = mainAxisSizeWithSpacings2 + i67;
                                        int mainAxisSizeWithSpacings5 = mainAxisSizeWithSpacings4 - i67;
                                        while (mainAxisSizeWithSpacings5 < i44 && i53 > 0) {
                                            int i69 = i67;
                                            int i70 = i53 - 1;
                                            int i71 = i68;
                                            LazyListMeasuredItem lazyListMeasuredItemM161getAndMeasure0kLqBqw3 = lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2.m161getAndMeasure0kLqBqw(i70, j2);
                                            i53 = i70;
                                            arrayDeque2.add(0, lazyListMeasuredItemM161getAndMeasure0kLqBqw3);
                                            iMax2 = Math.max(iMax2, lazyListMeasuredItemM161getAndMeasure0kLqBqw3.crossAxisSize);
                                            mainAxisSizeWithSpacings5 += lazyListMeasuredItemM161getAndMeasure0kLqBqw3.getMainAxisSizeWithSpacings();
                                            i68 = i71;
                                            i67 = i69;
                                        }
                                        int i72 = i67;
                                        int i73 = i68;
                                        i26 = i58;
                                        int i74 = i26 + i72;
                                        if (mainAxisSizeWithSpacings5 < 0) {
                                            int i75 = i74 + mainAxisSizeWithSpacings5;
                                            int i76 = i73 + mainAxisSizeWithSpacings5;
                                            i29 = iMax2;
                                            i27 = i76;
                                            i210 = i53;
                                            i211 = i75;
                                            i28 = 0;
                                        } else {
                                            i28 = mainAxisSizeWithSpacings5;
                                            i27 = i73;
                                            i29 = iMax2;
                                            i210 = i53;
                                            i211 = i74;
                                        }
                                    } else {
                                        i26 = i58;
                                        i27 = mainAxisSizeWithSpacings2;
                                        i28 = mainAxisSizeWithSpacings4;
                                        i29 = iMax2;
                                        i210 = i53;
                                        i211 = i26;
                                    }
                                    int i77 = i65;
                                    if (Integer.signum(Math.round(f3)) != Integer.signum(i211) || Math.abs(Math.round(f3)) < Math.abs(i211)) {
                                        i212 = i211;
                                        f = f3;
                                    } else {
                                        i212 = i211;
                                        f = i212;
                                    }
                                    float f4 = f3 - f;
                                    float f5 = CropImageView.DEFAULT_ASPECT_RATIO;
                                    if (zIsLookingAhead && i212 > i26 && f4 <= CropImageView.DEFAULT_ASPECT_RATIO) {
                                        f5 = (i212 - i26) + f4;
                                    }
                                    float f6 = f5;
                                    if (i28 < 0) {
                                        InlineClassHelperKt.throwIllegalArgumentException("negative currentFirstItemScrollOffset");
                                    }
                                    int i78 = -i28;
                                    LazyListMeasuredItem lazyListMeasuredItem8 = (LazyListMeasuredItem) arrayDeque2.first();
                                    if (i44 > 0 || iMo75roundToPx0680j_8 < 0) {
                                        int size2 = arrayDeque2.getSize();
                                        LazyListMeasuredItem lazyListMeasuredItem9 = lazyListMeasuredItem8;
                                        int i79 = 0;
                                        while (i79 < size2) {
                                            int i80 = size2;
                                            int mainAxisSizeWithSpacings6 = ((LazyListMeasuredItem) arrayDeque2.get(i79)).getMainAxisSizeWithSpacings();
                                            if (i28 == 0 || mainAxisSizeWithSpacings6 > i28 || i79 == arrayDeque2.getSize() - 1) {
                                                break;
                                            }
                                            i28 -= mainAxisSizeWithSpacings6;
                                            i79++;
                                            lazyListMeasuredItem9 = (LazyListMeasuredItem) arrayDeque2.get(i79);
                                            size2 = i80;
                                        }
                                        lazyListMeasuredItem = lazyListMeasuredItem9;
                                    } else {
                                        lazyListMeasuredItem = lazyListMeasuredItem8;
                                    }
                                    int i81 = i28;
                                    int iMax3 = Math.max(0, i210);
                                    int i82 = i210 - 1;
                                    if (iMax3 <= i82) {
                                        List arrayList3 = null;
                                        while (true) {
                                            if (arrayList3 == null) {
                                                arrayList3 = new ArrayList();
                                            }
                                            i30 = i45;
                                            arrayList = arrayList3;
                                            arrayList.add(lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2.m161getAndMeasure0kLqBqw(i82, j2));
                                            if (i82 == iMax3) {
                                                break;
                                            }
                                            i82--;
                                            arrayList3 = arrayList;
                                            i45 = i30;
                                        }
                                    } else {
                                        i30 = i45;
                                        arrayList = null;
                                    }
                                    int[] iArr = mutableIntListCalculateLazyLayoutPinnedIndices.content;
                                    for (int i83 = mutableIntListCalculateLazyLayoutPinnedIndices._size - 1; -1 < i83; i83--) {
                                        int i84 = iArr[i83];
                                        if (i84 < iMax3) {
                                            if (arrayList == null) {
                                                arrayList = new ArrayList();
                                            }
                                            arrayList.add(lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2.m161getAndMeasure0kLqBqw(i84, j2));
                                        }
                                    }
                                    if (arrayList == null) {
                                        arrayList = emptyList;
                                    }
                                    int iMax4 = i29;
                                    int i85 = 0;
                                    for (int size3 = arrayList.size(); i85 < size3; size3 = size3) {
                                        iMax4 = Math.max(iMax4, ((LazyListMeasuredItem) arrayList.get(i85)).crossAxisSize);
                                        i85++;
                                    }
                                    int iMin = Math.min(((LazyListMeasuredItem) CollectionsKt.last(arrayDeque2)).index, i30 - 1);
                                    int i86 = ((LazyListMeasuredItem) CollectionsKt.last(arrayDeque2)).index + 1;
                                    if (i86 <= iMin) {
                                        ArrayList arrayList4 = null;
                                        while (true) {
                                            if (arrayList4 == null) {
                                                arrayList4 = new ArrayList();
                                            }
                                            i31 = iMax4;
                                            f2 = f;
                                            arrayList2 = arrayList4;
                                            arrayList2.add(lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2.m161getAndMeasure0kLqBqw(i86, j2));
                                            if (i86 == iMin) {
                                                break;
                                            }
                                            i86++;
                                            arrayList4 = arrayList2;
                                            iMax4 = i31;
                                            f = f2;
                                        }
                                    } else {
                                        i31 = iMax4;
                                        f2 = f;
                                        arrayList2 = null;
                                    }
                                    if (arrayList2 != null && ((LazyListMeasuredItem) CollectionsKt.last(arrayList2)).index > iMin) {
                                        iMin = ((LazyListMeasuredItem) CollectionsKt.last(arrayList2)).index;
                                    }
                                    int[] iArr2 = mutableIntListCalculateLazyLayoutPinnedIndices.content;
                                    int i87 = mutableIntListCalculateLazyLayoutPinnedIndices._size;
                                    List arrayList5 = arrayList2;
                                    int i88 = 0;
                                    while (i88 < i87) {
                                        int i89 = i87;
                                        int i90 = iArr2[i88];
                                        if (i90 > iMin) {
                                            if (arrayList5 == null) {
                                                arrayList5 = new ArrayList();
                                            }
                                            arrayList5.add(lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2.m161getAndMeasure0kLqBqw(i90, j2));
                                        }
                                        i88++;
                                        i87 = i89;
                                    }
                                    if (arrayList5 == null) {
                                        arrayList5 = emptyList;
                                    }
                                    int size4 = arrayList5.size();
                                    int iMax5 = i31;
                                    for (int i91 = 0; i91 < size4; i91++) {
                                        iMax5 = Math.max(iMax5, ((LazyListMeasuredItem) arrayList5.get(i91)).crossAxisSize);
                                    }
                                    boolean z13 = Intrinsics.areEqual(lazyListMeasuredItem, arrayDeque2.first()) && arrayList.isEmpty() && arrayList5.isEmpty();
                                    int iM792constrainWidthK40F9xA = ConstraintsKt.m792constrainWidthK40F9xA(z10 ? iMax5 : i27, jM793offsetNN6EwU);
                                    if (z10) {
                                        iMax5 = i27;
                                    }
                                    int iM791constrainHeightK40F9xA2 = ConstraintsKt.m791constrainHeightK40F9xA(iMax5, jM793offsetNN6EwU);
                                    int i92 = z10 ? iM791constrainHeightK40F9xA2 : iM792constrainWidthK40F9xA;
                                    boolean z14 = i27 < Math.min(i92, i50);
                                    if (z14 && i78 != 0) {
                                        InlineClassHelperKt.throwIllegalStateException("non-zero itemsScrollOffset");
                                    }
                                    boolean z15 = z13;
                                    ArrayList arrayList6 = new ArrayList(arrayList5.size() + arrayList.size() + arrayDeque2.getSize());
                                    if (z14) {
                                        if (!arrayList.isEmpty() || !arrayList5.isEmpty()) {
                                            InlineClassHelperKt.throwIllegalArgumentException("no extra items");
                                        }
                                        int size5 = arrayDeque2.getSize();
                                        int[] iArr3 = new int[size5];
                                        for (int i93 = 0; i93 < size5; i93++) {
                                            iArr3[i93] = ((LazyListMeasuredItem) arrayDeque2.get(i93)).size;
                                        }
                                        int[] iArr4 = new int[size5];
                                        if (z10) {
                                            if (arrangement$Vertical8 == null) {
                                                throw Fragment$5$$ExternalSyntheticOutline0.m("null verticalArrangement when isVertical == true");
                                            }
                                            arrangement$Vertical8.arrange(lazyLayoutMeasureScopeImpl, i92, iArr3, iArr4);
                                            i32 = 0;
                                        } else {
                                            if (arrangement$Horizontal4 == null) {
                                                throw Fragment$5$$ExternalSyntheticOutline0.m("null horizontalArrangement when isVertical == false");
                                            }
                                            i32 = 0;
                                            arrangement$Horizontal4.arrange(lazyLayoutMeasureScopeImpl, i92, iArr3, LayoutDirection.Ltr, iArr4);
                                        }
                                        IntRange indices = ArraysKt.getIndices(iArr4);
                                        int i94 = indices.last;
                                        int i95 = indices.step;
                                        if ((i95 > 0 && i94 >= 0) || (i95 < 0 && i94 <= 0)) {
                                            int i96 = i32;
                                            while (true) {
                                                int i97 = iArr4[i96];
                                                LazyListMeasuredItem lazyListMeasuredItem10 = (LazyListMeasuredItem) arrayDeque2.get(i96);
                                                lazyListMeasuredItem10.position(i97, iM792constrainWidthK40F9xA, iM791constrainHeightK40F9xA2);
                                                arrayList6.add(lazyListMeasuredItem10);
                                                if (i96 == i94) {
                                                    break;
                                                }
                                                i96 += i95;
                                            }
                                        }
                                    } else {
                                        i50 = i50;
                                        lazyListMeasuredItem = lazyListMeasuredItem;
                                        i32 = 0;
                                        int size6 = arrayList.size();
                                        int mainAxisSizeWithSpacings7 = i78;
                                        int i98 = 0;
                                        while (i98 < size6) {
                                            int i99 = size6;
                                            LazyListMeasuredItem lazyListMeasuredItem11 = (LazyListMeasuredItem) arrayList.get(i98);
                                            mainAxisSizeWithSpacings7 -= lazyListMeasuredItem11.getMainAxisSizeWithSpacings();
                                            lazyListMeasuredItem11.position(mainAxisSizeWithSpacings7, iM792constrainWidthK40F9xA, iM791constrainHeightK40F9xA2);
                                            arrayList6.add(lazyListMeasuredItem11);
                                            i98++;
                                            size6 = i99;
                                        }
                                        int size7 = arrayDeque2.getSize();
                                        int mainAxisSizeWithSpacings8 = i78;
                                        for (int i100 = 0; i100 < size7; i100++) {
                                            LazyListMeasuredItem lazyListMeasuredItem12 = (LazyListMeasuredItem) arrayDeque2.get(i100);
                                            lazyListMeasuredItem12.position(mainAxisSizeWithSpacings8, iM792constrainWidthK40F9xA, iM791constrainHeightK40F9xA2);
                                            arrayList6.add(lazyListMeasuredItem12);
                                            mainAxisSizeWithSpacings8 += lazyListMeasuredItem12.getMainAxisSizeWithSpacings();
                                        }
                                        int size8 = arrayList5.size();
                                        for (int i101 = 0; i101 < size8; i101++) {
                                            LazyListMeasuredItem lazyListMeasuredItem13 = (LazyListMeasuredItem) arrayList5.get(i101);
                                            lazyListMeasuredItem13.position(mainAxisSizeWithSpacings8, iM792constrainWidthK40F9xA, iM791constrainHeightK40F9xA2);
                                            arrayList6.add(lazyListMeasuredItem13);
                                            mainAxisSizeWithSpacings8 += lazyListMeasuredItem13.getMainAxisSizeWithSpacings();
                                        }
                                    }
                                    float f7 = f2;
                                    int i102 = i27;
                                    lazyLayoutItemAnimator.onMeasured((int) f7, iM792constrainWidthK40F9xA, iM791constrainHeightK40F9xA2, arrayList6, statusLine, lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2, z10, zIsLookingAhead, 1, z7, i81, i102, coroutineScope2, graphicsContext2, z9);
                                    if (zIsLookingAhead) {
                                        arrayDeque = arrayDeque2;
                                    } else {
                                        long jM173getMinSizeToFitDisappearingItemsYbymL2g2 = lazyLayoutItemAnimator.m173getMinSizeToFitDisappearingItemsYbymL2g();
                                        arrayDeque = arrayDeque2;
                                        if (!IntSize.m810equalsimpl0(jM173getMinSizeToFitDisappearingItemsYbymL2g2, 0L)) {
                                            int i103 = z10 ? iM791constrainHeightK40F9xA2 : iM792constrainWidthK40F9xA;
                                            iM792constrainWidthK40F9xA = ConstraintsKt.m792constrainWidthK40F9xA(Math.max(iM792constrainWidthK40F9xA, (int) (jM173getMinSizeToFitDisappearingItemsYbymL2g2 >> 32)), jM793offsetNN6EwU);
                                            iM791constrainHeightK40F9xA = ConstraintsKt.m791constrainHeightK40F9xA(Math.max(iM791constrainHeightK40F9xA2, (int) (jM173getMinSizeToFitDisappearingItemsYbymL2g2 & 4294967295L)), jM793offsetNN6EwU);
                                            int i104 = z10 ? iM791constrainHeightK40F9xA : iM792constrainWidthK40F9xA;
                                            if (i104 != i103) {
                                                int size9 = arrayList6.size();
                                                for (int i105 = i32; i105 < size9; i105++) {
                                                    LazyListMeasuredItem lazyListMeasuredItem14 = (LazyListMeasuredItem) arrayList6.get(i105);
                                                    lazyListMeasuredItem14.mainAxisLayoutSize = i104;
                                                    lazyListMeasuredItem14.maxMainAxisOffset = lazyListMeasuredItem14.afterContentPadding + i104;
                                                }
                                            }
                                        }
                                        int i1010 = iM792constrainWidthK40F9xA;
                                        lazyListMeasuredItem2 = (LazyListMeasuredItem) arrayDeque.firstOrNull();
                                        if (lazyListMeasuredItem2 != null) {
                                            i33 = lazyListMeasuredItem2.index;
                                        } else {
                                            i33 = i32;
                                        }
                                        lazyListMeasuredItem3 = (LazyListMeasuredItem) arrayDeque.lastOrNull();
                                        if (lazyListMeasuredItem3 != null) {
                                            i34 = lazyListMeasuredItem3.index;
                                        } else {
                                            i34 = i32;
                                        }
                                        mutableIntList = lazyListItemProviderImpl3.intervalContent._headerIndexes;
                                        if (mutableIntList == null) {
                                            mutableIntList = IntListKt.EmptyIntList;
                                        }
                                        int i1011 = iM791constrainHeightK40F9xA;
                                        listApplyStickyItems = LazyLayoutKt.applyStickyItems(noKey, i33, i34, arrayList6, mutableIntList, i44, i1010, i1011, z10, new ScrollState$$ExternalSyntheticLambda0((byte) 13, lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2));
                                        if (z15) {
                                            lazyListMeasuredItem7 = (LazyListMeasuredItem) CollectionsKt.firstOrNull((List) arrayList6);
                                            if (lazyListMeasuredItem7 != null) {
                                                numValueOf = Integer.valueOf(lazyListMeasuredItem7.index);
                                            } else {
                                                numValueOf = null;
                                            }
                                        } else {
                                            lazyListMeasuredItem4 = (LazyListMeasuredItem) arrayDeque.firstOrNull();
                                            if (lazyListMeasuredItem4 != null) {
                                                numValueOf = Integer.valueOf(lazyListMeasuredItem4.index);
                                            } else {
                                                numValueOf = null;
                                            }
                                        }
                                        if (z15) {
                                            lazyListMeasuredItem6 = (LazyListMeasuredItem) CollectionsKt.lastOrNull(arrayList6);
                                            if (lazyListMeasuredItem6 != null) {
                                                numValueOf2 = Integer.valueOf(lazyListMeasuredItem6.index);
                                            } else {
                                                numValueOf2 = null;
                                            }
                                        } else {
                                            lazyListMeasuredItem5 = (LazyListMeasuredItem) arrayDeque.lastOrNull();
                                            if (lazyListMeasuredItem5 != null) {
                                                numValueOf2 = Integer.valueOf(lazyListMeasuredItem5.index);
                                            } else {
                                                numValueOf2 = null;
                                            }
                                        }
                                        i35 = i30;
                                        if (i77 >= i35 || i102 > i50) {
                                            i36 = 1;
                                        } else {
                                            i36 = i32;
                                        }
                                        MeasureResult measureResultLayout4 = subcomposeMeasureScope2.layout(ConstraintsKt.m792constrainWidthK40F9xA(i1010 + i40, j), ConstraintsKt.m791constrainHeightK40F9xA(i1011 + i57, j), emptyMap, new LazyListMeasureKt$$ExternalSyntheticLambda2(mutableState, arrayList6, listApplyStickyItems, zIsLookingAhead, (byte) 0));
                                        if (numValueOf != null) {
                                            iIntValue = numValueOf.intValue();
                                        } else {
                                            iIntValue = i32;
                                        }
                                        if (numValueOf2 != null) {
                                            iIntValue2 = numValueOf2.intValue();
                                        } else {
                                            iIntValue2 = i32;
                                        }
                                        List listUpdatedVisibleItems3 = LazyLayoutKt.updatedVisibleItems(iIntValue, iIntValue2, arrayList6, listApplyStickyItems);
                                        if (!z10) {
                                            orientation3 = orientation2;
                                        }
                                        size = listApplyStickyItems.size();
                                        i37 = i32;
                                        i38 = i37;
                                        while (i37 < size) {
                                            i38 += ((LazyListMeasuredItem) listApplyStickyItems.get(i37)).size;
                                            i37++;
                                        }
                                        lazyListItemProviderImpl3 = lazyListItemProviderImpl3;
                                        lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1 = lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2;
                                        subcomposeMeasureScope = subcomposeMeasureScope2;
                                        lazyListMeasureResult = new LazyListMeasureResult(lazyListMeasuredItem, i81, i36, f7, measureResultLayout4, f6, z12, coroutineScope2, lazyLayoutMeasureScopeImpl, lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2.childConstraints, i38, listUpdatedVisibleItems3, i52, i60, i35, orientation3, i43, iMo75roundToPx0680j_8);
                                    }
                                    iM791constrainHeightK40F9xA = iM791constrainHeightK40F9xA2;
                                    int i1012 = iM792constrainWidthK40F9xA;
                                    lazyListMeasuredItem2 = (LazyListMeasuredItem) arrayDeque.firstOrNull();
                                    if (lazyListMeasuredItem2 != null) {
                                        i33 = lazyListMeasuredItem2.index;
                                    } else {
                                        i33 = i32;
                                    }
                                    lazyListMeasuredItem3 = (LazyListMeasuredItem) arrayDeque.lastOrNull();
                                    if (lazyListMeasuredItem3 != null) {
                                        i34 = lazyListMeasuredItem3.index;
                                    } else {
                                        i34 = i32;
                                    }
                                    mutableIntList = lazyListItemProviderImpl3.intervalContent._headerIndexes;
                                    if (mutableIntList == null) {
                                        mutableIntList = IntListKt.EmptyIntList;
                                    }
                                    int i1013 = iM791constrainHeightK40F9xA;
                                    listApplyStickyItems = LazyLayoutKt.applyStickyItems(noKey, i33, i34, arrayList6, mutableIntList, i44, i1012, i1013, z10, new ScrollState$$ExternalSyntheticLambda0((byte) 13, lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2));
                                    if (z15) {
                                        lazyListMeasuredItem7 = (LazyListMeasuredItem) CollectionsKt.firstOrNull((List) arrayList6);
                                        if (lazyListMeasuredItem7 != null) {
                                            numValueOf = Integer.valueOf(lazyListMeasuredItem7.index);
                                        } else {
                                            numValueOf = null;
                                        }
                                    } else {
                                        lazyListMeasuredItem4 = (LazyListMeasuredItem) arrayDeque.firstOrNull();
                                        if (lazyListMeasuredItem4 != null) {
                                            numValueOf = Integer.valueOf(lazyListMeasuredItem4.index);
                                        } else {
                                            numValueOf = null;
                                        }
                                    }
                                    if (z15) {
                                        lazyListMeasuredItem6 = (LazyListMeasuredItem) CollectionsKt.lastOrNull(arrayList6);
                                        if (lazyListMeasuredItem6 != null) {
                                            numValueOf2 = Integer.valueOf(lazyListMeasuredItem6.index);
                                        } else {
                                            numValueOf2 = null;
                                        }
                                    } else {
                                        lazyListMeasuredItem5 = (LazyListMeasuredItem) arrayDeque.lastOrNull();
                                        if (lazyListMeasuredItem5 != null) {
                                            numValueOf2 = Integer.valueOf(lazyListMeasuredItem5.index);
                                        } else {
                                            numValueOf2 = null;
                                        }
                                    }
                                    i35 = i30;
                                    if (i77 >= i35) {
                                        i36 = 1;
                                    } else {
                                        i36 = 1;
                                    }
                                    MeasureResult measureResultLayout5 = subcomposeMeasureScope2.layout(ConstraintsKt.m792constrainWidthK40F9xA(i1012 + i40, j), ConstraintsKt.m791constrainHeightK40F9xA(i1013 + i57, j), emptyMap, new LazyListMeasureKt$$ExternalSyntheticLambda2(mutableState, arrayList6, listApplyStickyItems, zIsLookingAhead, (byte) 0));
                                    if (numValueOf != null) {
                                        iIntValue = numValueOf.intValue();
                                    } else {
                                        iIntValue = i32;
                                    }
                                    if (numValueOf2 != null) {
                                        iIntValue2 = numValueOf2.intValue();
                                    } else {
                                        iIntValue2 = i32;
                                    }
                                    List listUpdatedVisibleItems4 = LazyLayoutKt.updatedVisibleItems(iIntValue, iIntValue2, arrayList6, listApplyStickyItems);
                                    if (!z10) {
                                        orientation3 = orientation2;
                                    }
                                    size = listApplyStickyItems.size();
                                    i37 = i32;
                                    i38 = i37;
                                    while (i37 < size) {
                                        i38 += ((LazyListMeasuredItem) listApplyStickyItems.get(i37)).size;
                                        i37++;
                                    }
                                    lazyListItemProviderImpl3 = lazyListItemProviderImpl3;
                                    lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1 = lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2;
                                    subcomposeMeasureScope = subcomposeMeasureScope2;
                                    lazyListMeasureResult = new LazyListMeasureResult(lazyListMeasuredItem, i81, i36, f7, measureResultLayout5, f6, z12, coroutineScope2, lazyLayoutMeasureScopeImpl, lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2.childConstraints, i38, listUpdatedVisibleItems4, i52, i60, i35, orientation3, i43, iMo75roundToPx0680j_8);
                                }
                                LazyListMeasureResult lazyListMeasureResult2 = lazyListMeasureResult;
                                LazyListState lazyListState6 = lazyListState4;
                                lazyListState6.applyMeasureResult$foundation(lazyListMeasureResult2, subcomposeMeasureScope.isLookingAhead(), false);
                                Object obj2 = lazyListState6.prefetchStrategy;
                                CacheWindowLogic cacheWindowLogic = obj2 instanceof CacheWindowLogic ? (CacheWindowLogic) obj2 : null;
                                if (cacheWindowLogic == null) {
                                    return lazyListMeasureResult2;
                                }
                                List list = lazyListMeasureResult2.visibleItemsInfo;
                                Trace.beginSection("compose:lazy:cache_window:keepAroundItems");
                                try {
                                    if (cacheWindowLogic.hasValidBounds() && !list.isEmpty()) {
                                        int i115 = ((LazyListMeasuredItem) CollectionsKt.first(list)).index;
                                        int i116 = ((LazyListMeasuredItem) CollectionsKt.last(list)).index;
                                        int i117 = cacheWindowLogic.getPerLaneCacheWindowStartIndex()[0];
                                        LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1 lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$3 = lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1;
                                        while (true) {
                                            lazyLayoutMeasureScopeImpl2 = lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$3.measureScope;
                                            if (i117 >= i115) {
                                                break;
                                            }
                                            if (i117 >= 0 && i117 < lazyListItemProviderImpl3.getItemCount()) {
                                                lazyLayoutMeasureScopeImpl2.compose(i117);
                                            }
                                            i117++;
                                        }
                                        int i118 = i116 + 1;
                                        int i119 = cacheWindowLogic.getPerLaneCacheWindowEndItemIndex()[0];
                                        if (i118 <= i119) {
                                            while (true) {
                                                if (i118 >= 0 && i118 < lazyListItemProviderImpl3.getItemCount()) {
                                                    lazyLayoutMeasureScopeImpl2.compose(i118);
                                                }
                                                if (i118 == i119) {
                                                    break;
                                                }
                                                i118++;
                                            }
                                        }
                                    }
                                    return lazyListMeasureResult2;
                                } finally {
                                    Trace.endSection();
                                }
                            } catch (Throwable th) {
                                Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                                throw th;
                            }
                        }
                    };
                    kProperty1 = kProperty0;
                    arrangement$Vertical4 = arrangement$Vertical7;
                    gapComposer2.updateRememberedValue(obj);
                }
                LazyLayoutMeasurePolicy lazyLayoutMeasurePolicy2 = (LazyLayoutMeasurePolicy) obj;
                if (r4 != 0) {
                    orientation = Orientation.Vertical;
                } else {
                    orientation = Orientation.Horizontal;
                }
                if (z2) {
                    gapComposer2.startReplaceGroup(-2077147368);
                    zChanged2 = ((((i7 & 14) ^ 6) <= i9 && gapComposer2.changed(lazyListState3)) || (i7 & 6) == i9) | gapComposer2.changed(0);
                    objRememberedValue5 = gapComposer2.rememberedValue();
                    if (zChanged2) {
                        objRememberedValue5 = new LazyListBeyondBoundsState(lazyListState3);
                        gapComposer2.updateRememberedValue(objRememberedValue5);
                    } else {
                        objRememberedValue5 = new LazyListBeyondBoundsState(lazyListState3);
                        gapComposer2.updateRememberedValue(objRememberedValue5);
                    }
                    modifierLazyLayoutBeyondBoundsModifier = LazyLayoutKt.lazyLayoutBeyondBoundsModifier((LazyListBeyondBoundsState) objRememberedValue5, lazyListState3.beyondBoundsInfo, orientation);
                    gapComposer2.end(false);
                } else {
                    gapComposer2.startReplaceGroup(-2076718545);
                    gapComposer2.end(false);
                    modifierLazyLayoutBeyondBoundsModifier = Modifier.Companion.$$INSTANCE;
                }
                if (i8 == 32) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                objRememberedValue4 = gapComposer2.rememberedValue();
                if (z6) {
                    objRememberedValue4 = new LazyListKt$$ExternalSyntheticLambda0(lazyListState3, (byte) 0);
                    gapComposer2.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new LazyListKt$$ExternalSyntheticLambda0(lazyListState3, (byte) 0);
                    gapComposer2.updateRememberedValue(objRememberedValue4);
                }
                modifier2 = modifier;
                lazyListState2 = lazyListState3;
                gapComposer = gapComposer2;
                LazyLayoutKt.LazyLayout(kProperty1, ImageKt.scrollableArea(LazyLayoutKt.lazyLayoutItemAnimator(LazyLayoutKt.lazyLayoutSemantics(modifier2.then(lazyListState3.remeasurementModifier).then(lazyListState3.awaitLayoutModifier), kProperty1, lazyLayoutSemanticState2, orientation, z2).then(modifierLazyLayoutBeyondBoundsModifier), lazyListState3.itemAnimator), lazyListState3, orientation, androidEdgeEffectOverscrollEffect, z2, flingBehavior, lazyListState3.internalInteractionSource, LazyLayoutKt.rememberLazyLayoutBringIntoViewSpec(i114 & 126, gapComposer2, (Function0) objRememberedValue4, z)), lazyListState2.prefetchState, lazyLayoutMeasurePolicy2, gapComposer, 0);
                arrangement$Vertical2 = arrangement$Vertical4;
                vertical2 = vertical3;
                arrangement$Horizontal2 = arrangement$Horizontal3;
            } else {
                modifier2 = modifier;
                lazyListState2 = lazyListState;
                gapComposer = gapComposer3;
                gapComposer.skipToGroupEnd();
                horizontal2 = horizontal;
                arrangement$Vertical2 = arrangement$Vertical;
                vertical2 = vertical;
                arrangement$Horizontal2 = arrangement$Horizontal;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                final LazyListState lazyListState4 = lazyListState2;
                final Alignment.Horizontal horizontal4 = horizontal2;
                final Modifier modifier3 = modifier2;
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.foundation.lazy.LazyListKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        ((Integer) obj3).getClass();
                        int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                        int iUpdateChangedFlags2 = Stack.updateChangedFlags(i2);
                        MathKt.LazyList(modifier3, lazyListState4, paddingValues, z, flingBehavior, z2, androidEdgeEffectOverscrollEffect, horizontal4, arrangement$Vertical2, vertical2, arrangement$Horizontal2, function1, (Composer) obj2, iUpdateChangedFlags, iUpdateChangedFlags2, i3);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i13 |= 384;
        if ((i2 & 3072) == 0) {
            i13 |= gapComposer3.changedInstance(function1) ? 2048 : 1024;
        }
        if ((i4 & 306783379) == 306783378) {
            z3 = true;
        } else {
            z3 = true;
        }
        if (gapComposer3.shouldExecute(i4 & 1, z3)) {
            gapComposer3.startDefaults();
            if ((i & 1) != 0) {
                i6 = i4 & (-234881025);
                if (i10 != 0) {
                    horizontal3 = null;
                } else {
                    horizontal3 = horizontal;
                }
                if (i11 != 0) {
                    arrangement$Vertical3 = null;
                } else {
                    arrangement$Vertical3 = arrangement$Vertical;
                }
                if (i12 != 0) {
                    vertical3 = null;
                } else {
                    vertical3 = vertical;
                }
                if (i14 != 0) {
                    arrangement$Horizontal3 = null;
                } else {
                    arrangement$Horizontal3 = arrangement$Horizontal;
                }
            } else {
                i6 = i4 & (-234881025);
                if (i10 != 0) {
                    horizontal3 = null;
                } else {
                    horizontal3 = horizontal;
                }
                if (i11 != 0) {
                    arrangement$Vertical3 = null;
                } else {
                    arrangement$Vertical3 = arrangement$Vertical;
                }
                if (i12 != 0) {
                    vertical3 = null;
                } else {
                    vertical3 = vertical;
                }
                if (i14 != 0) {
                    arrangement$Horizontal3 = null;
                } else {
                    arrangement$Horizontal3 = arrangement$Horizontal;
                }
            }
            gapComposer3.endDefaults();
            i7 = i6 >> 3;
            int i115 = i7 & 14;
            int i116 = i115 | ((i13 >> 6) & 112);
            mutableStateRememberUpdatedState = Stack.rememberUpdatedState(function1, gapComposer3);
            int i117 = i6;
            int i118 = i13;
            if (((i116 & 14) ^ 6) <= 4) {
            }
            objRememberedValue = gapComposer3.rememberedValue();
            neverEqualPolicy = Composer.Companion.Empty;
            if (z4) {
                LazyItemScopeImpl lazyItemScopeImpl4 = new LazyItemScopeImpl();
                lazyItemScopeImpl4.maxWidthState = new ParcelableSnapshotMutableIntState(Integer.MAX_VALUE);
                lazyItemScopeImpl4.maxHeightState = new ParcelableSnapshotMutableIntState(Integer.MAX_VALUE);
                NeverEqualPolicy neverEqualPolicy5 = NeverEqualPolicy.INSTANCE$1;
                MainActivity$$ExternalSyntheticLambda29 mainActivity$$ExternalSyntheticLambda212 = new MainActivity$$ExternalSyntheticLambda29(mutableStateRememberUpdatedState, (byte) 1);
                EmojiProcessor emojiProcessor4 = SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel;
                objRememberedValue = new DataStoreKt$dataStore$2$2(new DerivedSnapshotState(new GapComposer$$ExternalSyntheticLambda0(new DerivedSnapshotState(mainActivity$$ExternalSyntheticLambda212, neverEqualPolicy5), lazyListState, lazyItemScopeImpl4, (byte) 2), neverEqualPolicy5), State.class, "value", "getValue()Ljava/lang/Object;", 0, (byte) 1);
                gapComposer3.updateRememberedValue(objRememberedValue);
            } else {
                LazyItemScopeImpl lazyItemScopeImpl5 = new LazyItemScopeImpl();
                lazyItemScopeImpl5.maxWidthState = new ParcelableSnapshotMutableIntState(Integer.MAX_VALUE);
                lazyItemScopeImpl5.maxHeightState = new ParcelableSnapshotMutableIntState(Integer.MAX_VALUE);
                NeverEqualPolicy neverEqualPolicy6 = NeverEqualPolicy.INSTANCE$1;
                MainActivity$$ExternalSyntheticLambda29 mainActivity$$ExternalSyntheticLambda213 = new MainActivity$$ExternalSyntheticLambda29(mutableStateRememberUpdatedState, (byte) 1);
                EmojiProcessor emojiProcessor5 = SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel;
                objRememberedValue = new DataStoreKt$dataStore$2$2(new DerivedSnapshotState(new GapComposer$$ExternalSyntheticLambda0(new DerivedSnapshotState(mainActivity$$ExternalSyntheticLambda213, neverEqualPolicy6), lazyListState, lazyItemScopeImpl5, (byte) 2), neverEqualPolicy6), State.class, "value", "getValue()Ljava/lang/Object;", 0, (byte) 1);
                gapComposer3.updateRememberedValue(objRememberedValue);
            }
            kProperty0 = (KProperty0) objRememberedValue;
            int i119 = i117 >> 9;
            int i26 = i115 | (i119 & 112);
            z5 = ((((i26 & 112) ^ 48) <= 32 && gapComposer3.changed(z)) || (i26 & 48) == 32) | ((((i26 & 14) ^ 6) <= 4 && gapComposer3.changed(lazyListState)) || (i26 & 6) == 4);
            objRememberedValue2 = gapComposer3.rememberedValue();
            if (z5) {
                objRememberedValue2 = new LazyLayoutSemanticState(z) { // from class: androidx.compose.foundation.lazy.LazyLayoutSemanticStateKt$LazyLayoutSemanticState$1
                    public final /* synthetic */ boolean $isVertical;
                    public final DerivedSnapshotState totalItemsCount$delegate;

                    {
                        this.$isVertical = z;
                        this.totalItemsCount$delegate = SnapshotStateKt__DerivedStateKt.derivedStateOf(new LazyListKt$$ExternalSyntheticLambda0(this.$state, (byte) 1));
                    }

                    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
                    public final CollectionInfo collectionInfo() {
                        boolean z7 = this.$isVertical;
                        DerivedSnapshotState derivedSnapshotState = this.totalItemsCount$delegate;
                        return z7 ? new CollectionInfo(((Number) derivedSnapshotState.getValue()).intValue(), 1) : new CollectionInfo(1, ((Number) derivedSnapshotState.getValue()).intValue());
                    }

                    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
                    public final int getContentPadding() {
                        LazyListState lazyListState5 = this.$state;
                        return (-lazyListState5.getLayoutInfo().viewportStartOffset) + lazyListState5.getLayoutInfo().afterContentPadding;
                    }

                    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
                    public final float getMaxScrollOffset() {
                        LazyListState lazyListState5 = this.$state;
                        int firstVisibleItemIndex = lazyListState5.getFirstVisibleItemIndex();
                        int firstVisibleItemScrollOffset = lazyListState5.getFirstVisibleItemScrollOffset();
                        return lazyListState5.getCanScrollForward() ? (firstVisibleItemIndex * CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION) + firstVisibleItemScrollOffset + 100.0f : (firstVisibleItemIndex * CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION) + firstVisibleItemScrollOffset;
                    }

                    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
                    public final float getScrollOffset() {
                        LazyListState lazyListState5 = this.$state;
                        return (lazyListState5.getFirstVisibleItemIndex() * CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION) + lazyListState5.getFirstVisibleItemScrollOffset();
                    }

                    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
                    public final int getViewport() {
                        LazyListState lazyListState5 = this.$state;
                        return (int) (lazyListState5.getLayoutInfo().orientation == Orientation.Vertical ? lazyListState5.getLayoutInfo().m162getViewportSizeYbymL2g() & 4294967295L : lazyListState5.getLayoutInfo().m162getViewportSizeYbymL2g() >> 32);
                    }

                    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
                    public final Object scrollToItem(int i27, PagerState$scrollToPage$2 pagerState$scrollToPage$2) {
                        Object objScrollToItem$default = LazyListState.scrollToItem$default(this.$state, i27, pagerState$scrollToPage$2);
                        return objScrollToItem$default == CoroutineSingletons.COROUTINE_SUSPENDED ? objScrollToItem$default : Unit.INSTANCE;
                    }
                };
                gapComposer3.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new LazyLayoutSemanticState(z) { // from class: androidx.compose.foundation.lazy.LazyLayoutSemanticStateKt$LazyLayoutSemanticState$1
                    public final /* synthetic */ boolean $isVertical;
                    public final DerivedSnapshotState totalItemsCount$delegate;

                    {
                        this.$isVertical = z;
                        this.totalItemsCount$delegate = SnapshotStateKt__DerivedStateKt.derivedStateOf(new LazyListKt$$ExternalSyntheticLambda0(this.$state, (byte) 1));
                    }

                    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
                    public final CollectionInfo collectionInfo() {
                        boolean z7 = this.$isVertical;
                        DerivedSnapshotState derivedSnapshotState = this.totalItemsCount$delegate;
                        return z7 ? new CollectionInfo(((Number) derivedSnapshotState.getValue()).intValue(), 1) : new CollectionInfo(1, ((Number) derivedSnapshotState.getValue()).intValue());
                    }

                    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
                    public final int getContentPadding() {
                        LazyListState lazyListState5 = this.$state;
                        return (-lazyListState5.getLayoutInfo().viewportStartOffset) + lazyListState5.getLayoutInfo().afterContentPadding;
                    }

                    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
                    public final float getMaxScrollOffset() {
                        LazyListState lazyListState5 = this.$state;
                        int firstVisibleItemIndex = lazyListState5.getFirstVisibleItemIndex();
                        int firstVisibleItemScrollOffset = lazyListState5.getFirstVisibleItemScrollOffset();
                        return lazyListState5.getCanScrollForward() ? (firstVisibleItemIndex * CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION) + firstVisibleItemScrollOffset + 100.0f : (firstVisibleItemIndex * CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION) + firstVisibleItemScrollOffset;
                    }

                    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
                    public final float getScrollOffset() {
                        LazyListState lazyListState5 = this.$state;
                        return (lazyListState5.getFirstVisibleItemIndex() * CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION) + lazyListState5.getFirstVisibleItemScrollOffset();
                    }

                    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
                    public final int getViewport() {
                        LazyListState lazyListState5 = this.$state;
                        return (int) (lazyListState5.getLayoutInfo().orientation == Orientation.Vertical ? lazyListState5.getLayoutInfo().m162getViewportSizeYbymL2g() & 4294967295L : lazyListState5.getLayoutInfo().m162getViewportSizeYbymL2g() >> 32);
                    }

                    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
                    public final Object scrollToItem(int i27, PagerState$scrollToPage$2 pagerState$scrollToPage$2) {
                        Object objScrollToItem$default = LazyListState.scrollToItem$default(this.$state, i27, pagerState$scrollToPage$2);
                        return objScrollToItem$default == CoroutineSingletons.COROUTINE_SUSPENDED ? objScrollToItem$default : Unit.INSTANCE;
                    }
                };
                gapComposer3.updateRememberedValue(objRememberedValue2);
            }
            LazyLayoutSemanticState lazyLayoutSemanticState3 = (LazyLayoutSemanticState) objRememberedValue2;
            objRememberedValue3 = gapComposer3.rememberedValue();
            if (objRememberedValue3 == neverEqualPolicy) {
                objRememberedValue3 = Stack.createCompositionCoroutineScope(gapComposer3);
                gapComposer3.updateRememberedValue(objRememberedValue3);
            }
            coroutineScope = (CoroutineScope) objRememberedValue3;
            graphicsContext = (GraphicsContext) gapComposer3.consume(CompositionLocalsKt.LocalGraphicsContext);
            noKey = ((Boolean) gapComposer3.consume(CompositionLocalsKt.LocalProvidableScrollCaptureInProgress)).booleanValue() ? null : StickyItemsPlacement$Companion.StickToTopPlacement;
            i8 = i117 & 112;
            int i27 = i118 << 18;
            int i28 = (i117 & 65520) | (i119 & 3670016) | (i27 & 29360128) | (i27 & 234881024) | ((i118 << 27) & 1879048192);
            if (((i28 & 112) ^ 48) <= 32) {
            }
            zChanged = ((((i28 & 896) ^ 384) <= 256 && gapComposer3.changed(paddingValues)) || (i28 & 384) == 256) | ((((i28 & 112) ^ 48) <= 32 && gapComposer3.changed(lazyListState)) || (i28 & 48) == 32) | ((((i28 & 7168) ^ 3072) <= 2048 && gapComposer3.changed(false)) || (i28 & 3072) == 2048) | ((((57344 & i28) ^ 24576) <= 16384 && gapComposer3.changed(z)) || (i28 & 24576) == 16384) | gapComposer3.changed(0) | ((((i28 & 3670016) ^ 1572864) <= 1048576 && gapComposer3.changed(horizontal3)) || (i28 & 1572864) == 1048576) | ((((i28 & 29360128) ^ 12582912) <= 8388608 && gapComposer3.changed(vertical3)) || (i28 & 12582912) == 8388608) | ((((i28 & 234881024) ^ 100663296) <= 67108864 && gapComposer3.changed(arrangement$Horizontal3)) || (i28 & 100663296) == 67108864) | ((((i28 & 1879048192) ^ 805306368) <= 536870912 && gapComposer3.changed(arrangement$Vertical3)) || (i28 & 805306368) == 536870912) | gapComposer3.changed(graphicsContext) | gapComposer3.changed(noKey);
            Object objRememberedValue8 = gapComposer3.rememberedValue();
            if (zChanged) {
                gapComposer2 = gapComposer3;
                final Arrangement$Vertical arrangement$Vertical8 = arrangement$Vertical3;
                lazyListState3 = lazyListState;
                horizontal2 = horizontal3;
                i9 = 4;
                obj = new LazyLayoutMeasurePolicy() { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1
                    /* JADX WARN: Code duplicated, block: B:301:0x06ea  */
                    /* JADX WARN: Code duplicated, block: B:302:0x06ef  */
                    /* JADX WARN: Code duplicated, block: B:305:0x06f9  */
                    /* JADX WARN: Code duplicated, block: B:307:0x0700  */
                    /* JADX WARN: Code duplicated, block: B:311:0x070c  */
                    /* JADX WARN: Code duplicated, block: B:314:0x072c  */
                    /* JADX WARN: Code duplicated, block: B:316:0x0734  */
                    /* JADX WARN: Code duplicated, block: B:317:0x073b  */
                    /* JADX WARN: Code duplicated, block: B:318:0x073e  */
                    /* JADX WARN: Code duplicated, block: B:320:0x0746  */
                    /* JADX WARN: Code duplicated, block: B:322:0x074e  */
                    /* JADX WARN: Code duplicated, block: B:324:0x0756  */
                    /* JADX WARN: Code duplicated, block: B:326:0x075f  */
                    /* JADX WARN: Code duplicated, block: B:327:0x0762  */
                    /* JADX WARN: Code duplicated, block: B:329:0x076a  */
                    /* JADX WARN: Code duplicated, block: B:334:0x0779  */
                    /* JADX WARN: Code duplicated, block: B:337:0x07a4  */
                    /* JADX WARN: Code duplicated, block: B:338:0x07a9  */
                    /* JADX WARN: Code duplicated, block: B:340:0x07ad  */
                    /* JADX WARN: Code duplicated, block: B:341:0x07b2  */
                    /* JADX WARN: Code duplicated, block: B:345:0x07bb  */
                    /* JADX WARN: Code duplicated, block: B:348:0x07c6 A[LOOP:15: B:347:0x07c4->B:348:0x07c6, LOOP_END] */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasurePolicy
                    /* JADX INFO: renamed from: measure-0kLqBqw, reason: not valid java name */
                    public final MeasureResult mo159measure0kLqBqw(LazyLayoutMeasureScopeImpl lazyLayoutMeasureScopeImpl, long j) {
                        float fMo112getSpacingD9Ej5fM;
                        LazyListState lazyListState5;
                        long j2;
                        int i29;
                        int i210;
                        int i211;
                        int i212;
                        int i213;
                        int i214;
                        int i215;
                        float f;
                        LazyListMeasuredItem lazyListMeasuredItem;
                        int i30;
                        List arrayList;
                        int i31;
                        float f2;
                        ArrayList arrayList2;
                        int i32;
                        ArrayDeque arrayDeque;
                        int iM791constrainHeightK40F9xA;
                        LazyListMeasuredItem lazyListMeasuredItem2;
                        int i33;
                        LazyListMeasuredItem lazyListMeasuredItem3;
                        int i34;
                        MutableIntList mutableIntList;
                        List listApplyStickyItems;
                        LazyListMeasuredItem lazyListMeasuredItem4;
                        Integer numValueOf;
                        LazyListMeasuredItem lazyListMeasuredItem5;
                        Integer numValueOf2;
                        int i35;
                        int i36;
                        int iIntValue;
                        int iIntValue2;
                        int size;
                        int i37;
                        int i38;
                        LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1 lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1;
                        SubcomposeMeasureScope subcomposeMeasureScope;
                        LazyListMeasureResult lazyListMeasureResult;
                        LazyListMeasuredItem lazyListMeasuredItem6;
                        LazyListMeasuredItem lazyListMeasuredItem7;
                        int i39;
                        LazyLayoutMeasureScopeImpl lazyLayoutMeasureScopeImpl2;
                        SubcomposeMeasureScope subcomposeMeasureScope2 = lazyLayoutMeasureScopeImpl.subcomposeMeasureScope;
                        LazyListState lazyListState6 = lazyListState3;
                        lazyListState6.measurementScopeInvalidator.getValue();
                        boolean z7 = lazyListState6.hasLookaheadOccurred || subcomposeMeasureScope2.isLookingAhead();
                        Orientation orientation2 = Orientation.Horizontal;
                        Orientation orientation3 = Orientation.Vertical;
                        boolean z8 = z;
                        ImageKt.m44checkScrollableContainerConstraintsK40F9xA(j, z8 ? orientation3 : orientation2);
                        PaddingValues paddingValues2 = paddingValues;
                        int iMo75roundToPx0680j_4 = z8 ? subcomposeMeasureScope2.mo75roundToPx0680j_4(paddingValues2.mo123calculateLeftPaddingu2uoSUM(subcomposeMeasureScope2.getLayoutDirection())) : subcomposeMeasureScope2.mo75roundToPx0680j_4(OffsetKt.calculateStartPadding(paddingValues2, subcomposeMeasureScope2.getLayoutDirection()));
                        int iMo75roundToPx0680j_5 = z8 ? subcomposeMeasureScope2.mo75roundToPx0680j_4(paddingValues2.mo124calculateRightPaddingu2uoSUM(subcomposeMeasureScope2.getLayoutDirection())) : subcomposeMeasureScope2.mo75roundToPx0680j_4(OffsetKt.calculateEndPadding(paddingValues2, subcomposeMeasureScope2.getLayoutDirection()));
                        int iMo75roundToPx0680j_6 = subcomposeMeasureScope2.mo75roundToPx0680j_4(paddingValues2.mo125calculateTopPaddingD9Ej5fM());
                        int iMo75roundToPx0680j_7 = subcomposeMeasureScope2.mo75roundToPx0680j_4(paddingValues2.mo122calculateBottomPaddingD9Ej5fM()) + iMo75roundToPx0680j_6;
                        int i40 = iMo75roundToPx0680j_4 + iMo75roundToPx0680j_5;
                        int i41 = z8 ? iMo75roundToPx0680j_7 : i40;
                        int i42 = z8 ? iMo75roundToPx0680j_6 : !z8 ? iMo75roundToPx0680j_4 : iMo75roundToPx0680j_5;
                        int i43 = i41 - i42;
                        long jM793offsetNN6EwU = ConstraintsKt.m793offsetNN6EwU(-i40, -iMo75roundToPx0680j_7, j);
                        LazyListItemProviderImpl lazyListItemProviderImpl = (LazyListItemProviderImpl) kProperty0.invoke();
                        LazyItemScopeImpl lazyItemScopeImpl6 = lazyListItemProviderImpl.itemScope;
                        int iM784getMaxWidthimpl = Constraints.m784getMaxWidthimpl(jM793offsetNN6EwU);
                        int iM783getMaxHeightimpl = Constraints.m783getMaxHeightimpl(jM793offsetNN6EwU);
                        lazyItemScopeImpl6.maxWidthState.setIntValue(iM784getMaxWidthimpl);
                        lazyItemScopeImpl6.maxHeightState.setIntValue(iM783getMaxHeightimpl);
                        Arrangement$Horizontal arrangement$Horizontal4 = arrangement$Horizontal3;
                        Arrangement$Vertical arrangement$Vertical9 = arrangement$Vertical8;
                        if (z8) {
                            if (arrangement$Vertical9 == null) {
                                throw Fragment$5$$ExternalSyntheticOutline0.m("null verticalArrangement when isVertical == true");
                            }
                            fMo112getSpacingD9Ej5fM = arrangement$Vertical9.mo112getSpacingD9Ej5fM();
                        } else {
                            if (arrangement$Horizontal4 == null) {
                                throw Fragment$5$$ExternalSyntheticOutline0.m("null horizontalAlignment when isVertical == false");
                            }
                            fMo112getSpacingD9Ej5fM = arrangement$Horizontal4.mo112getSpacingD9Ej5fM();
                        }
                        int iMo75roundToPx0680j_8 = subcomposeMeasureScope2.mo75roundToPx0680j_4(fMo112getSpacingD9Ej5fM);
                        int itemCount = lazyListItemProviderImpl.getItemCount();
                        long j3 = (((long) iMo75roundToPx0680j_4) << 32) | (((long) iMo75roundToPx0680j_6) & 4294967295L);
                        int iM783getMaxHeightimpl2 = z8 ? Constraints.m783getMaxHeightimpl(j) - iMo75roundToPx0680j_7 : Constraints.m784getMaxWidthimpl(j) - i40;
                        int i44 = i42;
                        LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1 lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2 = new LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1(jM793offsetNN6EwU, z, lazyListItemProviderImpl, lazyLayoutMeasureScopeImpl, itemCount, iMo75roundToPx0680j_8, horizontal2, vertical3, i44, i43, j3, lazyListState3);
                        int i45 = itemCount;
                        LazyListItemProviderImpl lazyListItemProviderImpl2 = lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2.itemProvider;
                        StatusLine statusLine = lazyListItemProviderImpl2.keyIndexMap;
                        Snapshot currentThreadSnapshot = Lock.getCurrentThreadSnapshot();
                        Function1 readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                        Snapshot snapshotMakeCurrentNonObservable = Lock.makeCurrentNonObservable(currentThreadSnapshot);
                        try {
                            int firstVisibleItemIndex = lazyListState6.getFirstVisibleItemIndex();
                            LazyListScrollPosition lazyListScrollPosition = lazyListState6.scrollPosition;
                            LazyListItemProviderImpl lazyListItemProviderImpl3 = lazyListItemProviderImpl2;
                            int iFindIndexByKey = LazyLayoutKt.findIndexByKey(firstVisibleItemIndex, lazyListItemProviderImpl, lazyListScrollPosition.lastKnownFirstItemKey);
                            if (firstVisibleItemIndex != iFindIndexByKey) {
                                lazyListScrollPosition.index$delegate.setIntValue(iFindIndexByKey);
                                lazyListScrollPosition.nearestRangeState.update(firstVisibleItemIndex);
                            }
                            int firstVisibleItemScrollOffset = lazyListState6.getFirstVisibleItemScrollOffset();
                            Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                            MutableIntList mutableIntListCalculateLazyLayoutPinnedIndices = LazyLayoutKt.calculateLazyLayoutPinnedIndices(lazyListItemProviderImpl, lazyListState6.pinnedItems, lazyListState6.beyondBoundsInfo);
                            float fFloatValue = (subcomposeMeasureScope2.isLookingAhead() || !z7) ? lazyListState6.scrollToBeConsumed : ((Number) ((AnimationState) lazyListState6._lazyLayoutScrollDeltaBetweenPasses.referenceQueue).value$delegate.getValue()).floatValue();
                            LazyLayoutItemAnimator lazyLayoutItemAnimator = lazyListState6.itemAnimator;
                            boolean zIsLookingAhead = subcomposeMeasureScope2.isLookingAhead();
                            MutableState mutableState = lazyListState6.placementScopeInvalidator;
                            boolean z9 = !lazyListState6.skipItemPlacementAnimation;
                            if (i44 < 0) {
                                InlineClassHelperKt.throwIllegalArgumentException("invalid beforeContentPadding");
                            }
                            if (i43 < 0) {
                                InlineClassHelperKt.throwIllegalArgumentException("invalid afterContentPadding");
                            }
                            EmptyMap emptyMap = EmptyMap.INSTANCE;
                            boolean z10 = z;
                            int i46 = firstVisibleItemScrollOffset;
                            CoroutineScope coroutineScope2 = coroutineScope;
                            GraphicsContext graphicsContext2 = graphicsContext;
                            EmptyList emptyList = EmptyList.INSTANCE;
                            if (i45 <= 0) {
                                int iM786getMinWidthimpl = Constraints.m786getMinWidthimpl(jM793offsetNN6EwU);
                                int iM785getMinHeightimpl = Constraints.m785getMinHeightimpl(jM793offsetNN6EwU);
                                lazyLayoutItemAnimator.onMeasured(0, iM786getMinWidthimpl, iM785getMinHeightimpl, new ArrayList(), statusLine, lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2, z10, zIsLookingAhead, 1, z7, 0, 0, coroutineScope2, graphicsContext2, true);
                                if (!zIsLookingAhead) {
                                    long jM173getMinSizeToFitDisappearingItemsYbymL2g = lazyLayoutItemAnimator.m173getMinSizeToFitDisappearingItemsYbymL2g();
                                    if (!IntSize.m810equalsimpl0(jM173getMinSizeToFitDisappearingItemsYbymL2g, 0L)) {
                                        iM786getMinWidthimpl = ConstraintsKt.m792constrainWidthK40F9xA((int) (jM173getMinSizeToFitDisappearingItemsYbymL2g >> 32), jM793offsetNN6EwU);
                                        iM785getMinHeightimpl = ConstraintsKt.m791constrainHeightK40F9xA((int) (jM173getMinSizeToFitDisappearingItemsYbymL2g & 4294967295L), jM793offsetNN6EwU);
                                    }
                                }
                                MeasureResult measureResultLayout = subcomposeMeasureScope2.layout(ConstraintsKt.m792constrainWidthK40F9xA(iM786getMinWidthimpl + i40, j), ConstraintsKt.m791constrainHeightK40F9xA(iM785getMinHeightimpl + iMo75roundToPx0680j_7, j), emptyMap, new OffsetKt$$ExternalSyntheticLambda0((byte) 13));
                                int i47 = -i44;
                                int i48 = iM783getMaxHeightimpl2 + i43;
                                if (!z10) {
                                    orientation3 = orientation2;
                                }
                                subcomposeMeasureScope = subcomposeMeasureScope2;
                                lazyListState5 = lazyListState6;
                                lazyListMeasureResult = new LazyListMeasureResult(null, 0, false, CropImageView.DEFAULT_ASPECT_RATIO, measureResultLayout, CropImageView.DEFAULT_ASPECT_RATIO, false, coroutineScope2, lazyLayoutMeasureScopeImpl, lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2.childConstraints, 0, emptyList, i47, i48, 0, orientation3, i43, iMo75roundToPx0680j_8);
                                lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1 = lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2;
                            } else {
                                lazyListState5 = lazyListState6;
                                int i49 = iMo75roundToPx0680j_7;
                                int i50 = iM783getMaxHeightimpl2;
                                if (iFindIndexByKey >= i45) {
                                    iFindIndexByKey = i45 - 1;
                                    i46 = 0;
                                }
                                int iRound = Math.round(fFloatValue);
                                int i51 = i46 - iRound;
                                if (iFindIndexByKey == 0 && i51 < 0) {
                                    iRound += i51;
                                    i51 = 0;
                                }
                                ArrayDeque arrayDeque2 = new ArrayDeque();
                                int i52 = -i44;
                                int i53 = iFindIndexByKey;
                                int i54 = i52 + (iMo75roundToPx0680j_8 < 0 ? iMo75roundToPx0680j_8 : 0);
                                int mainAxisSizeWithSpacings = i51 + i54;
                                float f3 = fFloatValue;
                                int iMax = 0;
                                while (true) {
                                    j2 = lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2.childConstraints;
                                    if (mainAxisSizeWithSpacings >= 0 || i53 <= 0) {
                                        break;
                                    }
                                    int i55 = i49;
                                    int i56 = i53 - 1;
                                    LazyListMeasuredItem lazyListMeasuredItemM161getAndMeasure0kLqBqw = lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2.m161getAndMeasure0kLqBqw(i56, j2);
                                    arrayDeque2.add(0, lazyListMeasuredItemM161getAndMeasure0kLqBqw);
                                    iMax = Math.max(iMax, lazyListMeasuredItemM161getAndMeasure0kLqBqw.crossAxisSize);
                                    mainAxisSizeWithSpacings += lazyListMeasuredItemM161getAndMeasure0kLqBqw.getMainAxisSizeWithSpacings();
                                    i53 = i56;
                                    i49 = i55;
                                }
                                int i57 = i49;
                                if (mainAxisSizeWithSpacings < i54) {
                                    iRound -= i54 - mainAxisSizeWithSpacings;
                                    mainAxisSizeWithSpacings = i54;
                                }
                                int i58 = iRound;
                                int i59 = mainAxisSizeWithSpacings - i54;
                                int i60 = i50 + i43;
                                int i61 = i60 >= 0 ? i60 : 0;
                                int i62 = iMax;
                                int mainAxisSizeWithSpacings2 = -i59;
                                int i63 = i53;
                                int i64 = 0;
                                boolean z11 = false;
                                while (i64 < arrayDeque2.size) {
                                    if (mainAxisSizeWithSpacings2 >= i61) {
                                        arrayDeque2.removeAt(i64);
                                        z11 = true;
                                    } else {
                                        i63++;
                                        int mainAxisSizeWithSpacings3 = ((LazyListMeasuredItem) arrayDeque2.get(i64)).getMainAxisSizeWithSpacings() + mainAxisSizeWithSpacings2;
                                        i64++;
                                        mainAxisSizeWithSpacings2 = mainAxisSizeWithSpacings3;
                                    }
                                }
                                int iMax2 = i62;
                                int mainAxisSizeWithSpacings4 = i59;
                                boolean z12 = z11;
                                int i65 = i63;
                                while (i65 < i45 && (mainAxisSizeWithSpacings2 < i61 || mainAxisSizeWithSpacings2 <= 0 || arrayDeque2.isEmpty())) {
                                    int i66 = i61;
                                    LazyListMeasuredItem lazyListMeasuredItemM161getAndMeasure0kLqBqw2 = lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2.m161getAndMeasure0kLqBqw(i65, j2);
                                    mainAxisSizeWithSpacings2 = lazyListMeasuredItemM161getAndMeasure0kLqBqw2.getMainAxisSizeWithSpacings() + mainAxisSizeWithSpacings2;
                                    if (mainAxisSizeWithSpacings2 <= i54) {
                                        i39 = i54;
                                        if (i65 != i45 - 1) {
                                            i53 = i65 + 1;
                                            mainAxisSizeWithSpacings4 -= lazyListMeasuredItemM161getAndMeasure0kLqBqw2.getMainAxisSizeWithSpacings();
                                            z12 = true;
                                        }
                                        i65++;
                                        i61 = i66;
                                        i54 = i39;
                                    } else {
                                        i39 = i54;
                                    }
                                    iMax2 = Math.max(iMax2, lazyListMeasuredItemM161getAndMeasure0kLqBqw2.crossAxisSize);
                                    arrayDeque2.addLast(lazyListMeasuredItemM161getAndMeasure0kLqBqw2);
                                    i65++;
                                    i61 = i66;
                                    i54 = i39;
                                }
                                if (mainAxisSizeWithSpacings2 < i50) {
                                    int i67 = i50 - mainAxisSizeWithSpacings2;
                                    int i68 = mainAxisSizeWithSpacings2 + i67;
                                    int mainAxisSizeWithSpacings5 = mainAxisSizeWithSpacings4 - i67;
                                    while (mainAxisSizeWithSpacings5 < i44 && i53 > 0) {
                                        int i69 = i67;
                                        int i70 = i53 - 1;
                                        int i71 = i68;
                                        LazyListMeasuredItem lazyListMeasuredItemM161getAndMeasure0kLqBqw3 = lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2.m161getAndMeasure0kLqBqw(i70, j2);
                                        i53 = i70;
                                        arrayDeque2.add(0, lazyListMeasuredItemM161getAndMeasure0kLqBqw3);
                                        iMax2 = Math.max(iMax2, lazyListMeasuredItemM161getAndMeasure0kLqBqw3.crossAxisSize);
                                        mainAxisSizeWithSpacings5 += lazyListMeasuredItemM161getAndMeasure0kLqBqw3.getMainAxisSizeWithSpacings();
                                        i68 = i71;
                                        i67 = i69;
                                    }
                                    int i72 = i67;
                                    int i73 = i68;
                                    i29 = i58;
                                    int i74 = i29 + i72;
                                    if (mainAxisSizeWithSpacings5 < 0) {
                                        int i75 = i74 + mainAxisSizeWithSpacings5;
                                        int i76 = i73 + mainAxisSizeWithSpacings5;
                                        i212 = iMax2;
                                        i210 = i76;
                                        i213 = i53;
                                        i214 = i75;
                                        i211 = 0;
                                    } else {
                                        i211 = mainAxisSizeWithSpacings5;
                                        i210 = i73;
                                        i212 = iMax2;
                                        i213 = i53;
                                        i214 = i74;
                                    }
                                } else {
                                    i29 = i58;
                                    i210 = mainAxisSizeWithSpacings2;
                                    i211 = mainAxisSizeWithSpacings4;
                                    i212 = iMax2;
                                    i213 = i53;
                                    i214 = i29;
                                }
                                int i77 = i65;
                                if (Integer.signum(Math.round(f3)) != Integer.signum(i214) || Math.abs(Math.round(f3)) < Math.abs(i214)) {
                                    i215 = i214;
                                    f = f3;
                                } else {
                                    i215 = i214;
                                    f = i215;
                                }
                                float f4 = f3 - f;
                                float f5 = CropImageView.DEFAULT_ASPECT_RATIO;
                                if (zIsLookingAhead && i215 > i29 && f4 <= CropImageView.DEFAULT_ASPECT_RATIO) {
                                    f5 = (i215 - i29) + f4;
                                }
                                float f6 = f5;
                                if (i211 < 0) {
                                    InlineClassHelperKt.throwIllegalArgumentException("negative currentFirstItemScrollOffset");
                                }
                                int i78 = -i211;
                                LazyListMeasuredItem lazyListMeasuredItem8 = (LazyListMeasuredItem) arrayDeque2.first();
                                if (i44 > 0 || iMo75roundToPx0680j_8 < 0) {
                                    int size2 = arrayDeque2.getSize();
                                    LazyListMeasuredItem lazyListMeasuredItem9 = lazyListMeasuredItem8;
                                    int i79 = 0;
                                    while (i79 < size2) {
                                        int i80 = size2;
                                        int mainAxisSizeWithSpacings6 = ((LazyListMeasuredItem) arrayDeque2.get(i79)).getMainAxisSizeWithSpacings();
                                        if (i211 == 0 || mainAxisSizeWithSpacings6 > i211 || i79 == arrayDeque2.getSize() - 1) {
                                            break;
                                        }
                                        i211 -= mainAxisSizeWithSpacings6;
                                        i79++;
                                        lazyListMeasuredItem9 = (LazyListMeasuredItem) arrayDeque2.get(i79);
                                        size2 = i80;
                                    }
                                    lazyListMeasuredItem = lazyListMeasuredItem9;
                                } else {
                                    lazyListMeasuredItem = lazyListMeasuredItem8;
                                }
                                int i81 = i211;
                                int iMax3 = Math.max(0, i213);
                                int i82 = i213 - 1;
                                if (iMax3 <= i82) {
                                    List arrayList3 = null;
                                    while (true) {
                                        if (arrayList3 == null) {
                                            arrayList3 = new ArrayList();
                                        }
                                        i30 = i45;
                                        arrayList = arrayList3;
                                        arrayList.add(lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2.m161getAndMeasure0kLqBqw(i82, j2));
                                        if (i82 == iMax3) {
                                            break;
                                        }
                                        i82--;
                                        arrayList3 = arrayList;
                                        i45 = i30;
                                    }
                                } else {
                                    i30 = i45;
                                    arrayList = null;
                                }
                                int[] iArr = mutableIntListCalculateLazyLayoutPinnedIndices.content;
                                for (int i83 = mutableIntListCalculateLazyLayoutPinnedIndices._size - 1; -1 < i83; i83--) {
                                    int i84 = iArr[i83];
                                    if (i84 < iMax3) {
                                        if (arrayList == null) {
                                            arrayList = new ArrayList();
                                        }
                                        arrayList.add(lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2.m161getAndMeasure0kLqBqw(i84, j2));
                                    }
                                }
                                if (arrayList == null) {
                                    arrayList = emptyList;
                                }
                                int iMax4 = i212;
                                int i85 = 0;
                                for (int size3 = arrayList.size(); i85 < size3; size3 = size3) {
                                    iMax4 = Math.max(iMax4, ((LazyListMeasuredItem) arrayList.get(i85)).crossAxisSize);
                                    i85++;
                                }
                                int iMin = Math.min(((LazyListMeasuredItem) CollectionsKt.last(arrayDeque2)).index, i30 - 1);
                                int i86 = ((LazyListMeasuredItem) CollectionsKt.last(arrayDeque2)).index + 1;
                                if (i86 <= iMin) {
                                    ArrayList arrayList4 = null;
                                    while (true) {
                                        if (arrayList4 == null) {
                                            arrayList4 = new ArrayList();
                                        }
                                        i31 = iMax4;
                                        f2 = f;
                                        arrayList2 = arrayList4;
                                        arrayList2.add(lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2.m161getAndMeasure0kLqBqw(i86, j2));
                                        if (i86 == iMin) {
                                            break;
                                        }
                                        i86++;
                                        arrayList4 = arrayList2;
                                        iMax4 = i31;
                                        f = f2;
                                    }
                                } else {
                                    i31 = iMax4;
                                    f2 = f;
                                    arrayList2 = null;
                                }
                                if (arrayList2 != null && ((LazyListMeasuredItem) CollectionsKt.last(arrayList2)).index > iMin) {
                                    iMin = ((LazyListMeasuredItem) CollectionsKt.last(arrayList2)).index;
                                }
                                int[] iArr2 = mutableIntListCalculateLazyLayoutPinnedIndices.content;
                                int i87 = mutableIntListCalculateLazyLayoutPinnedIndices._size;
                                List arrayList5 = arrayList2;
                                int i88 = 0;
                                while (i88 < i87) {
                                    int i89 = i87;
                                    int i90 = iArr2[i88];
                                    if (i90 > iMin) {
                                        if (arrayList5 == null) {
                                            arrayList5 = new ArrayList();
                                        }
                                        arrayList5.add(lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2.m161getAndMeasure0kLqBqw(i90, j2));
                                    }
                                    i88++;
                                    i87 = i89;
                                }
                                if (arrayList5 == null) {
                                    arrayList5 = emptyList;
                                }
                                int size4 = arrayList5.size();
                                int iMax5 = i31;
                                for (int i91 = 0; i91 < size4; i91++) {
                                    iMax5 = Math.max(iMax5, ((LazyListMeasuredItem) arrayList5.get(i91)).crossAxisSize);
                                }
                                boolean z13 = Intrinsics.areEqual(lazyListMeasuredItem, arrayDeque2.first()) && arrayList.isEmpty() && arrayList5.isEmpty();
                                int iM792constrainWidthK40F9xA = ConstraintsKt.m792constrainWidthK40F9xA(z10 ? iMax5 : i210, jM793offsetNN6EwU);
                                if (z10) {
                                    iMax5 = i210;
                                }
                                int iM791constrainHeightK40F9xA2 = ConstraintsKt.m791constrainHeightK40F9xA(iMax5, jM793offsetNN6EwU);
                                int i92 = z10 ? iM791constrainHeightK40F9xA2 : iM792constrainWidthK40F9xA;
                                boolean z14 = i210 < Math.min(i92, i50);
                                if (z14 && i78 != 0) {
                                    InlineClassHelperKt.throwIllegalStateException("non-zero itemsScrollOffset");
                                }
                                boolean z15 = z13;
                                ArrayList arrayList6 = new ArrayList(arrayList5.size() + arrayList.size() + arrayDeque2.getSize());
                                if (z14) {
                                    if (!arrayList.isEmpty() || !arrayList5.isEmpty()) {
                                        InlineClassHelperKt.throwIllegalArgumentException("no extra items");
                                    }
                                    int size5 = arrayDeque2.getSize();
                                    int[] iArr3 = new int[size5];
                                    for (int i93 = 0; i93 < size5; i93++) {
                                        iArr3[i93] = ((LazyListMeasuredItem) arrayDeque2.get(i93)).size;
                                    }
                                    int[] iArr4 = new int[size5];
                                    if (z10) {
                                        if (arrangement$Vertical9 == null) {
                                            throw Fragment$5$$ExternalSyntheticOutline0.m("null verticalArrangement when isVertical == true");
                                        }
                                        arrangement$Vertical9.arrange(lazyLayoutMeasureScopeImpl, i92, iArr3, iArr4);
                                        i32 = 0;
                                    } else {
                                        if (arrangement$Horizontal4 == null) {
                                            throw Fragment$5$$ExternalSyntheticOutline0.m("null horizontalArrangement when isVertical == false");
                                        }
                                        i32 = 0;
                                        arrangement$Horizontal4.arrange(lazyLayoutMeasureScopeImpl, i92, iArr3, LayoutDirection.Ltr, iArr4);
                                    }
                                    IntRange indices = ArraysKt.getIndices(iArr4);
                                    int i94 = indices.last;
                                    int i95 = indices.step;
                                    if ((i95 > 0 && i94 >= 0) || (i95 < 0 && i94 <= 0)) {
                                        int i96 = i32;
                                        while (true) {
                                            int i97 = iArr4[i96];
                                            LazyListMeasuredItem lazyListMeasuredItem10 = (LazyListMeasuredItem) arrayDeque2.get(i96);
                                            lazyListMeasuredItem10.position(i97, iM792constrainWidthK40F9xA, iM791constrainHeightK40F9xA2);
                                            arrayList6.add(lazyListMeasuredItem10);
                                            if (i96 == i94) {
                                                break;
                                            }
                                            i96 += i95;
                                        }
                                    }
                                } else {
                                    i50 = i50;
                                    lazyListMeasuredItem = lazyListMeasuredItem;
                                    i32 = 0;
                                    int size6 = arrayList.size();
                                    int mainAxisSizeWithSpacings7 = i78;
                                    int i98 = 0;
                                    while (i98 < size6) {
                                        int i99 = size6;
                                        LazyListMeasuredItem lazyListMeasuredItem11 = (LazyListMeasuredItem) arrayList.get(i98);
                                        mainAxisSizeWithSpacings7 -= lazyListMeasuredItem11.getMainAxisSizeWithSpacings();
                                        lazyListMeasuredItem11.position(mainAxisSizeWithSpacings7, iM792constrainWidthK40F9xA, iM791constrainHeightK40F9xA2);
                                        arrayList6.add(lazyListMeasuredItem11);
                                        i98++;
                                        size6 = i99;
                                    }
                                    int size7 = arrayDeque2.getSize();
                                    int mainAxisSizeWithSpacings8 = i78;
                                    for (int i100 = 0; i100 < size7; i100++) {
                                        LazyListMeasuredItem lazyListMeasuredItem12 = (LazyListMeasuredItem) arrayDeque2.get(i100);
                                        lazyListMeasuredItem12.position(mainAxisSizeWithSpacings8, iM792constrainWidthK40F9xA, iM791constrainHeightK40F9xA2);
                                        arrayList6.add(lazyListMeasuredItem12);
                                        mainAxisSizeWithSpacings8 += lazyListMeasuredItem12.getMainAxisSizeWithSpacings();
                                    }
                                    int size8 = arrayList5.size();
                                    for (int i101 = 0; i101 < size8; i101++) {
                                        LazyListMeasuredItem lazyListMeasuredItem13 = (LazyListMeasuredItem) arrayList5.get(i101);
                                        lazyListMeasuredItem13.position(mainAxisSizeWithSpacings8, iM792constrainWidthK40F9xA, iM791constrainHeightK40F9xA2);
                                        arrayList6.add(lazyListMeasuredItem13);
                                        mainAxisSizeWithSpacings8 += lazyListMeasuredItem13.getMainAxisSizeWithSpacings();
                                    }
                                }
                                float f7 = f2;
                                int i102 = i210;
                                lazyLayoutItemAnimator.onMeasured((int) f7, iM792constrainWidthK40F9xA, iM791constrainHeightK40F9xA2, arrayList6, statusLine, lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2, z10, zIsLookingAhead, 1, z7, i81, i102, coroutineScope2, graphicsContext2, z9);
                                if (zIsLookingAhead) {
                                    arrayDeque = arrayDeque2;
                                } else {
                                    long jM173getMinSizeToFitDisappearingItemsYbymL2g2 = lazyLayoutItemAnimator.m173getMinSizeToFitDisappearingItemsYbymL2g();
                                    arrayDeque = arrayDeque2;
                                    if (!IntSize.m810equalsimpl0(jM173getMinSizeToFitDisappearingItemsYbymL2g2, 0L)) {
                                        int i103 = z10 ? iM791constrainHeightK40F9xA2 : iM792constrainWidthK40F9xA;
                                        iM792constrainWidthK40F9xA = ConstraintsKt.m792constrainWidthK40F9xA(Math.max(iM792constrainWidthK40F9xA, (int) (jM173getMinSizeToFitDisappearingItemsYbymL2g2 >> 32)), jM793offsetNN6EwU);
                                        iM791constrainHeightK40F9xA = ConstraintsKt.m791constrainHeightK40F9xA(Math.max(iM791constrainHeightK40F9xA2, (int) (jM173getMinSizeToFitDisappearingItemsYbymL2g2 & 4294967295L)), jM793offsetNN6EwU);
                                        int i104 = z10 ? iM791constrainHeightK40F9xA : iM792constrainWidthK40F9xA;
                                        if (i104 != i103) {
                                            int size9 = arrayList6.size();
                                            for (int i105 = i32; i105 < size9; i105++) {
                                                LazyListMeasuredItem lazyListMeasuredItem14 = (LazyListMeasuredItem) arrayList6.get(i105);
                                                lazyListMeasuredItem14.mainAxisLayoutSize = i104;
                                                lazyListMeasuredItem14.maxMainAxisOffset = lazyListMeasuredItem14.afterContentPadding + i104;
                                            }
                                        }
                                    }
                                    int i1012 = iM792constrainWidthK40F9xA;
                                    lazyListMeasuredItem2 = (LazyListMeasuredItem) arrayDeque.firstOrNull();
                                    if (lazyListMeasuredItem2 != null) {
                                        i33 = lazyListMeasuredItem2.index;
                                    } else {
                                        i33 = i32;
                                    }
                                    lazyListMeasuredItem3 = (LazyListMeasuredItem) arrayDeque.lastOrNull();
                                    if (lazyListMeasuredItem3 != null) {
                                        i34 = lazyListMeasuredItem3.index;
                                    } else {
                                        i34 = i32;
                                    }
                                    mutableIntList = lazyListItemProviderImpl3.intervalContent._headerIndexes;
                                    if (mutableIntList == null) {
                                        mutableIntList = IntListKt.EmptyIntList;
                                    }
                                    int i1013 = iM791constrainHeightK40F9xA;
                                    listApplyStickyItems = LazyLayoutKt.applyStickyItems(noKey, i33, i34, arrayList6, mutableIntList, i44, i1012, i1013, z10, new ScrollState$$ExternalSyntheticLambda0((byte) 13, lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2));
                                    if (z15) {
                                        lazyListMeasuredItem7 = (LazyListMeasuredItem) CollectionsKt.firstOrNull((List) arrayList6);
                                        if (lazyListMeasuredItem7 != null) {
                                            numValueOf = Integer.valueOf(lazyListMeasuredItem7.index);
                                        } else {
                                            numValueOf = null;
                                        }
                                    } else {
                                        lazyListMeasuredItem4 = (LazyListMeasuredItem) arrayDeque.firstOrNull();
                                        if (lazyListMeasuredItem4 != null) {
                                            numValueOf = Integer.valueOf(lazyListMeasuredItem4.index);
                                        } else {
                                            numValueOf = null;
                                        }
                                    }
                                    if (z15) {
                                        lazyListMeasuredItem6 = (LazyListMeasuredItem) CollectionsKt.lastOrNull(arrayList6);
                                        if (lazyListMeasuredItem6 != null) {
                                            numValueOf2 = Integer.valueOf(lazyListMeasuredItem6.index);
                                        } else {
                                            numValueOf2 = null;
                                        }
                                    } else {
                                        lazyListMeasuredItem5 = (LazyListMeasuredItem) arrayDeque.lastOrNull();
                                        if (lazyListMeasuredItem5 != null) {
                                            numValueOf2 = Integer.valueOf(lazyListMeasuredItem5.index);
                                        } else {
                                            numValueOf2 = null;
                                        }
                                    }
                                    i35 = i30;
                                    if (i77 >= i35 || i102 > i50) {
                                        i36 = 1;
                                    } else {
                                        i36 = i32;
                                    }
                                    MeasureResult measureResultLayout5 = subcomposeMeasureScope2.layout(ConstraintsKt.m792constrainWidthK40F9xA(i1012 + i40, j), ConstraintsKt.m791constrainHeightK40F9xA(i1013 + i57, j), emptyMap, new LazyListMeasureKt$$ExternalSyntheticLambda2(mutableState, arrayList6, listApplyStickyItems, zIsLookingAhead, (byte) 0));
                                    if (numValueOf != null) {
                                        iIntValue = numValueOf.intValue();
                                    } else {
                                        iIntValue = i32;
                                    }
                                    if (numValueOf2 != null) {
                                        iIntValue2 = numValueOf2.intValue();
                                    } else {
                                        iIntValue2 = i32;
                                    }
                                    List listUpdatedVisibleItems4 = LazyLayoutKt.updatedVisibleItems(iIntValue, iIntValue2, arrayList6, listApplyStickyItems);
                                    if (!z10) {
                                        orientation3 = orientation2;
                                    }
                                    size = listApplyStickyItems.size();
                                    i37 = i32;
                                    i38 = i37;
                                    while (i37 < size) {
                                        i38 += ((LazyListMeasuredItem) listApplyStickyItems.get(i37)).size;
                                        i37++;
                                    }
                                    lazyListItemProviderImpl3 = lazyListItemProviderImpl3;
                                    lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1 = lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2;
                                    subcomposeMeasureScope = subcomposeMeasureScope2;
                                    lazyListMeasureResult = new LazyListMeasureResult(lazyListMeasuredItem, i81, i36, f7, measureResultLayout5, f6, z12, coroutineScope2, lazyLayoutMeasureScopeImpl, lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2.childConstraints, i38, listUpdatedVisibleItems4, i52, i60, i35, orientation3, i43, iMo75roundToPx0680j_8);
                                }
                                iM791constrainHeightK40F9xA = iM791constrainHeightK40F9xA2;
                                int i1014 = iM792constrainWidthK40F9xA;
                                lazyListMeasuredItem2 = (LazyListMeasuredItem) arrayDeque.firstOrNull();
                                if (lazyListMeasuredItem2 != null) {
                                    i33 = lazyListMeasuredItem2.index;
                                } else {
                                    i33 = i32;
                                }
                                lazyListMeasuredItem3 = (LazyListMeasuredItem) arrayDeque.lastOrNull();
                                if (lazyListMeasuredItem3 != null) {
                                    i34 = lazyListMeasuredItem3.index;
                                } else {
                                    i34 = i32;
                                }
                                mutableIntList = lazyListItemProviderImpl3.intervalContent._headerIndexes;
                                if (mutableIntList == null) {
                                    mutableIntList = IntListKt.EmptyIntList;
                                }
                                int i1015 = iM791constrainHeightK40F9xA;
                                listApplyStickyItems = LazyLayoutKt.applyStickyItems(noKey, i33, i34, arrayList6, mutableIntList, i44, i1014, i1015, z10, new ScrollState$$ExternalSyntheticLambda0((byte) 13, lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2));
                                if (z15) {
                                    lazyListMeasuredItem7 = (LazyListMeasuredItem) CollectionsKt.firstOrNull((List) arrayList6);
                                    if (lazyListMeasuredItem7 != null) {
                                        numValueOf = Integer.valueOf(lazyListMeasuredItem7.index);
                                    } else {
                                        numValueOf = null;
                                    }
                                } else {
                                    lazyListMeasuredItem4 = (LazyListMeasuredItem) arrayDeque.firstOrNull();
                                    if (lazyListMeasuredItem4 != null) {
                                        numValueOf = Integer.valueOf(lazyListMeasuredItem4.index);
                                    } else {
                                        numValueOf = null;
                                    }
                                }
                                if (z15) {
                                    lazyListMeasuredItem6 = (LazyListMeasuredItem) CollectionsKt.lastOrNull(arrayList6);
                                    if (lazyListMeasuredItem6 != null) {
                                        numValueOf2 = Integer.valueOf(lazyListMeasuredItem6.index);
                                    } else {
                                        numValueOf2 = null;
                                    }
                                } else {
                                    lazyListMeasuredItem5 = (LazyListMeasuredItem) arrayDeque.lastOrNull();
                                    if (lazyListMeasuredItem5 != null) {
                                        numValueOf2 = Integer.valueOf(lazyListMeasuredItem5.index);
                                    } else {
                                        numValueOf2 = null;
                                    }
                                }
                                i35 = i30;
                                if (i77 >= i35) {
                                    i36 = 1;
                                } else {
                                    i36 = 1;
                                }
                                MeasureResult measureResultLayout6 = subcomposeMeasureScope2.layout(ConstraintsKt.m792constrainWidthK40F9xA(i1014 + i40, j), ConstraintsKt.m791constrainHeightK40F9xA(i1015 + i57, j), emptyMap, new LazyListMeasureKt$$ExternalSyntheticLambda2(mutableState, arrayList6, listApplyStickyItems, zIsLookingAhead, (byte) 0));
                                if (numValueOf != null) {
                                    iIntValue = numValueOf.intValue();
                                } else {
                                    iIntValue = i32;
                                }
                                if (numValueOf2 != null) {
                                    iIntValue2 = numValueOf2.intValue();
                                } else {
                                    iIntValue2 = i32;
                                }
                                List listUpdatedVisibleItems5 = LazyLayoutKt.updatedVisibleItems(iIntValue, iIntValue2, arrayList6, listApplyStickyItems);
                                if (!z10) {
                                    orientation3 = orientation2;
                                }
                                size = listApplyStickyItems.size();
                                i37 = i32;
                                i38 = i37;
                                while (i37 < size) {
                                    i38 += ((LazyListMeasuredItem) listApplyStickyItems.get(i37)).size;
                                    i37++;
                                }
                                lazyListItemProviderImpl3 = lazyListItemProviderImpl3;
                                lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1 = lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2;
                                subcomposeMeasureScope = subcomposeMeasureScope2;
                                lazyListMeasureResult = new LazyListMeasureResult(lazyListMeasuredItem, i81, i36, f7, measureResultLayout6, f6, z12, coroutineScope2, lazyLayoutMeasureScopeImpl, lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2.childConstraints, i38, listUpdatedVisibleItems5, i52, i60, i35, orientation3, i43, iMo75roundToPx0680j_8);
                            }
                            LazyListMeasureResult lazyListMeasureResult2 = lazyListMeasureResult;
                            LazyListState lazyListState7 = lazyListState5;
                            lazyListState7.applyMeasureResult$foundation(lazyListMeasureResult2, subcomposeMeasureScope.isLookingAhead(), false);
                            Object obj2 = lazyListState7.prefetchStrategy;
                            CacheWindowLogic cacheWindowLogic = obj2 instanceof CacheWindowLogic ? (CacheWindowLogic) obj2 : null;
                            if (cacheWindowLogic == null) {
                                return lazyListMeasureResult2;
                            }
                            List list = lazyListMeasureResult2.visibleItemsInfo;
                            Trace.beginSection("compose:lazy:cache_window:keepAroundItems");
                            try {
                                if (cacheWindowLogic.hasValidBounds() && !list.isEmpty()) {
                                    int i1110 = ((LazyListMeasuredItem) CollectionsKt.first(list)).index;
                                    int i1111 = ((LazyListMeasuredItem) CollectionsKt.last(list)).index;
                                    int i1112 = cacheWindowLogic.getPerLaneCacheWindowStartIndex()[0];
                                    LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1 lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$3 = lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1;
                                    while (true) {
                                        lazyLayoutMeasureScopeImpl2 = lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$3.measureScope;
                                        if (i1112 >= i1110) {
                                            break;
                                        }
                                        if (i1112 >= 0 && i1112 < lazyListItemProviderImpl3.getItemCount()) {
                                            lazyLayoutMeasureScopeImpl2.compose(i1112);
                                        }
                                        i1112++;
                                    }
                                    int i1113 = i1111 + 1;
                                    int i1114 = cacheWindowLogic.getPerLaneCacheWindowEndItemIndex()[0];
                                    if (i1113 <= i1114) {
                                        while (true) {
                                            if (i1113 >= 0 && i1113 < lazyListItemProviderImpl3.getItemCount()) {
                                                lazyLayoutMeasureScopeImpl2.compose(i1113);
                                            }
                                            if (i1113 == i1114) {
                                                break;
                                            }
                                            i1113++;
                                        }
                                    }
                                }
                                return lazyListMeasureResult2;
                            } finally {
                                Trace.endSection();
                            }
                        } catch (Throwable th) {
                            Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                            throw th;
                        }
                    }
                };
                kProperty1 = kProperty0;
                arrangement$Vertical4 = arrangement$Vertical8;
                gapComposer2.updateRememberedValue(obj);
            } else {
                gapComposer2 = gapComposer3;
                final Arrangement$Vertical arrangement$Vertical9 = arrangement$Vertical3;
                lazyListState3 = lazyListState;
                horizontal2 = horizontal3;
                i9 = 4;
                obj = new LazyLayoutMeasurePolicy() { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1
                    /* JADX WARN: Code duplicated, block: B:301:0x06ea  */
                    /* JADX WARN: Code duplicated, block: B:302:0x06ef  */
                    /* JADX WARN: Code duplicated, block: B:305:0x06f9  */
                    /* JADX WARN: Code duplicated, block: B:307:0x0700  */
                    /* JADX WARN: Code duplicated, block: B:311:0x070c  */
                    /* JADX WARN: Code duplicated, block: B:314:0x072c  */
                    /* JADX WARN: Code duplicated, block: B:316:0x0734  */
                    /* JADX WARN: Code duplicated, block: B:317:0x073b  */
                    /* JADX WARN: Code duplicated, block: B:318:0x073e  */
                    /* JADX WARN: Code duplicated, block: B:320:0x0746  */
                    /* JADX WARN: Code duplicated, block: B:322:0x074e  */
                    /* JADX WARN: Code duplicated, block: B:324:0x0756  */
                    /* JADX WARN: Code duplicated, block: B:326:0x075f  */
                    /* JADX WARN: Code duplicated, block: B:327:0x0762  */
                    /* JADX WARN: Code duplicated, block: B:329:0x076a  */
                    /* JADX WARN: Code duplicated, block: B:334:0x0779  */
                    /* JADX WARN: Code duplicated, block: B:337:0x07a4  */
                    /* JADX WARN: Code duplicated, block: B:338:0x07a9  */
                    /* JADX WARN: Code duplicated, block: B:340:0x07ad  */
                    /* JADX WARN: Code duplicated, block: B:341:0x07b2  */
                    /* JADX WARN: Code duplicated, block: B:345:0x07bb  */
                    /* JADX WARN: Code duplicated, block: B:348:0x07c6 A[LOOP:15: B:347:0x07c4->B:348:0x07c6, LOOP_END] */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasurePolicy
                    /* JADX INFO: renamed from: measure-0kLqBqw, reason: not valid java name */
                    public final MeasureResult mo159measure0kLqBqw(LazyLayoutMeasureScopeImpl lazyLayoutMeasureScopeImpl, long j) {
                        float fMo112getSpacingD9Ej5fM;
                        LazyListState lazyListState5;
                        long j2;
                        int i29;
                        int i210;
                        int i211;
                        int i212;
                        int i213;
                        int i214;
                        int i215;
                        float f;
                        LazyListMeasuredItem lazyListMeasuredItem;
                        int i30;
                        List arrayList;
                        int i31;
                        float f2;
                        ArrayList arrayList2;
                        int i32;
                        ArrayDeque arrayDeque;
                        int iM791constrainHeightK40F9xA;
                        LazyListMeasuredItem lazyListMeasuredItem2;
                        int i33;
                        LazyListMeasuredItem lazyListMeasuredItem3;
                        int i34;
                        MutableIntList mutableIntList;
                        List listApplyStickyItems;
                        LazyListMeasuredItem lazyListMeasuredItem4;
                        Integer numValueOf;
                        LazyListMeasuredItem lazyListMeasuredItem5;
                        Integer numValueOf2;
                        int i35;
                        int i36;
                        int iIntValue;
                        int iIntValue2;
                        int size;
                        int i37;
                        int i38;
                        LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1 lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1;
                        SubcomposeMeasureScope subcomposeMeasureScope;
                        LazyListMeasureResult lazyListMeasureResult;
                        LazyListMeasuredItem lazyListMeasuredItem6;
                        LazyListMeasuredItem lazyListMeasuredItem7;
                        int i39;
                        LazyLayoutMeasureScopeImpl lazyLayoutMeasureScopeImpl2;
                        SubcomposeMeasureScope subcomposeMeasureScope2 = lazyLayoutMeasureScopeImpl.subcomposeMeasureScope;
                        LazyListState lazyListState6 = lazyListState3;
                        lazyListState6.measurementScopeInvalidator.getValue();
                        boolean z7 = lazyListState6.hasLookaheadOccurred || subcomposeMeasureScope2.isLookingAhead();
                        Orientation orientation2 = Orientation.Horizontal;
                        Orientation orientation3 = Orientation.Vertical;
                        boolean z8 = z;
                        ImageKt.m44checkScrollableContainerConstraintsK40F9xA(j, z8 ? orientation3 : orientation2);
                        PaddingValues paddingValues2 = paddingValues;
                        int iMo75roundToPx0680j_4 = z8 ? subcomposeMeasureScope2.mo75roundToPx0680j_4(paddingValues2.mo123calculateLeftPaddingu2uoSUM(subcomposeMeasureScope2.getLayoutDirection())) : subcomposeMeasureScope2.mo75roundToPx0680j_4(OffsetKt.calculateStartPadding(paddingValues2, subcomposeMeasureScope2.getLayoutDirection()));
                        int iMo75roundToPx0680j_5 = z8 ? subcomposeMeasureScope2.mo75roundToPx0680j_4(paddingValues2.mo124calculateRightPaddingu2uoSUM(subcomposeMeasureScope2.getLayoutDirection())) : subcomposeMeasureScope2.mo75roundToPx0680j_4(OffsetKt.calculateEndPadding(paddingValues2, subcomposeMeasureScope2.getLayoutDirection()));
                        int iMo75roundToPx0680j_6 = subcomposeMeasureScope2.mo75roundToPx0680j_4(paddingValues2.mo125calculateTopPaddingD9Ej5fM());
                        int iMo75roundToPx0680j_7 = subcomposeMeasureScope2.mo75roundToPx0680j_4(paddingValues2.mo122calculateBottomPaddingD9Ej5fM()) + iMo75roundToPx0680j_6;
                        int i40 = iMo75roundToPx0680j_4 + iMo75roundToPx0680j_5;
                        int i41 = z8 ? iMo75roundToPx0680j_7 : i40;
                        int i42 = z8 ? iMo75roundToPx0680j_6 : !z8 ? iMo75roundToPx0680j_4 : iMo75roundToPx0680j_5;
                        int i43 = i41 - i42;
                        long jM793offsetNN6EwU = ConstraintsKt.m793offsetNN6EwU(-i40, -iMo75roundToPx0680j_7, j);
                        LazyListItemProviderImpl lazyListItemProviderImpl = (LazyListItemProviderImpl) kProperty0.invoke();
                        LazyItemScopeImpl lazyItemScopeImpl6 = lazyListItemProviderImpl.itemScope;
                        int iM784getMaxWidthimpl = Constraints.m784getMaxWidthimpl(jM793offsetNN6EwU);
                        int iM783getMaxHeightimpl = Constraints.m783getMaxHeightimpl(jM793offsetNN6EwU);
                        lazyItemScopeImpl6.maxWidthState.setIntValue(iM784getMaxWidthimpl);
                        lazyItemScopeImpl6.maxHeightState.setIntValue(iM783getMaxHeightimpl);
                        Arrangement$Horizontal arrangement$Horizontal4 = arrangement$Horizontal3;
                        Arrangement$Vertical arrangement$Vertical10 = arrangement$Vertical9;
                        if (z8) {
                            if (arrangement$Vertical10 == null) {
                                throw Fragment$5$$ExternalSyntheticOutline0.m("null verticalArrangement when isVertical == true");
                            }
                            fMo112getSpacingD9Ej5fM = arrangement$Vertical10.mo112getSpacingD9Ej5fM();
                        } else {
                            if (arrangement$Horizontal4 == null) {
                                throw Fragment$5$$ExternalSyntheticOutline0.m("null horizontalAlignment when isVertical == false");
                            }
                            fMo112getSpacingD9Ej5fM = arrangement$Horizontal4.mo112getSpacingD9Ej5fM();
                        }
                        int iMo75roundToPx0680j_8 = subcomposeMeasureScope2.mo75roundToPx0680j_4(fMo112getSpacingD9Ej5fM);
                        int itemCount = lazyListItemProviderImpl.getItemCount();
                        long j3 = (((long) iMo75roundToPx0680j_4) << 32) | (((long) iMo75roundToPx0680j_6) & 4294967295L);
                        int iM783getMaxHeightimpl2 = z8 ? Constraints.m783getMaxHeightimpl(j) - iMo75roundToPx0680j_7 : Constraints.m784getMaxWidthimpl(j) - i40;
                        int i44 = i42;
                        LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1 lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2 = new LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1(jM793offsetNN6EwU, z, lazyListItemProviderImpl, lazyLayoutMeasureScopeImpl, itemCount, iMo75roundToPx0680j_8, horizontal2, vertical3, i44, i43, j3, lazyListState3);
                        int i45 = itemCount;
                        LazyListItemProviderImpl lazyListItemProviderImpl2 = lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2.itemProvider;
                        StatusLine statusLine = lazyListItemProviderImpl2.keyIndexMap;
                        Snapshot currentThreadSnapshot = Lock.getCurrentThreadSnapshot();
                        Function1 readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                        Snapshot snapshotMakeCurrentNonObservable = Lock.makeCurrentNonObservable(currentThreadSnapshot);
                        try {
                            int firstVisibleItemIndex = lazyListState6.getFirstVisibleItemIndex();
                            LazyListScrollPosition lazyListScrollPosition = lazyListState6.scrollPosition;
                            LazyListItemProviderImpl lazyListItemProviderImpl3 = lazyListItemProviderImpl2;
                            int iFindIndexByKey = LazyLayoutKt.findIndexByKey(firstVisibleItemIndex, lazyListItemProviderImpl, lazyListScrollPosition.lastKnownFirstItemKey);
                            if (firstVisibleItemIndex != iFindIndexByKey) {
                                lazyListScrollPosition.index$delegate.setIntValue(iFindIndexByKey);
                                lazyListScrollPosition.nearestRangeState.update(firstVisibleItemIndex);
                            }
                            int firstVisibleItemScrollOffset = lazyListState6.getFirstVisibleItemScrollOffset();
                            Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                            MutableIntList mutableIntListCalculateLazyLayoutPinnedIndices = LazyLayoutKt.calculateLazyLayoutPinnedIndices(lazyListItemProviderImpl, lazyListState6.pinnedItems, lazyListState6.beyondBoundsInfo);
                            float fFloatValue = (subcomposeMeasureScope2.isLookingAhead() || !z7) ? lazyListState6.scrollToBeConsumed : ((Number) ((AnimationState) lazyListState6._lazyLayoutScrollDeltaBetweenPasses.referenceQueue).value$delegate.getValue()).floatValue();
                            LazyLayoutItemAnimator lazyLayoutItemAnimator = lazyListState6.itemAnimator;
                            boolean zIsLookingAhead = subcomposeMeasureScope2.isLookingAhead();
                            MutableState mutableState = lazyListState6.placementScopeInvalidator;
                            boolean z9 = !lazyListState6.skipItemPlacementAnimation;
                            if (i44 < 0) {
                                InlineClassHelperKt.throwIllegalArgumentException("invalid beforeContentPadding");
                            }
                            if (i43 < 0) {
                                InlineClassHelperKt.throwIllegalArgumentException("invalid afterContentPadding");
                            }
                            EmptyMap emptyMap = EmptyMap.INSTANCE;
                            boolean z10 = z;
                            int i46 = firstVisibleItemScrollOffset;
                            CoroutineScope coroutineScope2 = coroutineScope;
                            GraphicsContext graphicsContext2 = graphicsContext;
                            EmptyList emptyList = EmptyList.INSTANCE;
                            if (i45 <= 0) {
                                int iM786getMinWidthimpl = Constraints.m786getMinWidthimpl(jM793offsetNN6EwU);
                                int iM785getMinHeightimpl = Constraints.m785getMinHeightimpl(jM793offsetNN6EwU);
                                lazyLayoutItemAnimator.onMeasured(0, iM786getMinWidthimpl, iM785getMinHeightimpl, new ArrayList(), statusLine, lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2, z10, zIsLookingAhead, 1, z7, 0, 0, coroutineScope2, graphicsContext2, true);
                                if (!zIsLookingAhead) {
                                    long jM173getMinSizeToFitDisappearingItemsYbymL2g = lazyLayoutItemAnimator.m173getMinSizeToFitDisappearingItemsYbymL2g();
                                    if (!IntSize.m810equalsimpl0(jM173getMinSizeToFitDisappearingItemsYbymL2g, 0L)) {
                                        iM786getMinWidthimpl = ConstraintsKt.m792constrainWidthK40F9xA((int) (jM173getMinSizeToFitDisappearingItemsYbymL2g >> 32), jM793offsetNN6EwU);
                                        iM785getMinHeightimpl = ConstraintsKt.m791constrainHeightK40F9xA((int) (jM173getMinSizeToFitDisappearingItemsYbymL2g & 4294967295L), jM793offsetNN6EwU);
                                    }
                                }
                                MeasureResult measureResultLayout = subcomposeMeasureScope2.layout(ConstraintsKt.m792constrainWidthK40F9xA(iM786getMinWidthimpl + i40, j), ConstraintsKt.m791constrainHeightK40F9xA(iM785getMinHeightimpl + iMo75roundToPx0680j_7, j), emptyMap, new OffsetKt$$ExternalSyntheticLambda0((byte) 13));
                                int i47 = -i44;
                                int i48 = iM783getMaxHeightimpl2 + i43;
                                if (!z10) {
                                    orientation3 = orientation2;
                                }
                                subcomposeMeasureScope = subcomposeMeasureScope2;
                                lazyListState5 = lazyListState6;
                                lazyListMeasureResult = new LazyListMeasureResult(null, 0, false, CropImageView.DEFAULT_ASPECT_RATIO, measureResultLayout, CropImageView.DEFAULT_ASPECT_RATIO, false, coroutineScope2, lazyLayoutMeasureScopeImpl, lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2.childConstraints, 0, emptyList, i47, i48, 0, orientation3, i43, iMo75roundToPx0680j_8);
                                lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1 = lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2;
                            } else {
                                lazyListState5 = lazyListState6;
                                int i49 = iMo75roundToPx0680j_7;
                                int i50 = iM783getMaxHeightimpl2;
                                if (iFindIndexByKey >= i45) {
                                    iFindIndexByKey = i45 - 1;
                                    i46 = 0;
                                }
                                int iRound = Math.round(fFloatValue);
                                int i51 = i46 - iRound;
                                if (iFindIndexByKey == 0 && i51 < 0) {
                                    iRound += i51;
                                    i51 = 0;
                                }
                                ArrayDeque arrayDeque2 = new ArrayDeque();
                                int i52 = -i44;
                                int i53 = iFindIndexByKey;
                                int i54 = i52 + (iMo75roundToPx0680j_8 < 0 ? iMo75roundToPx0680j_8 : 0);
                                int mainAxisSizeWithSpacings = i51 + i54;
                                float f3 = fFloatValue;
                                int iMax = 0;
                                while (true) {
                                    j2 = lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2.childConstraints;
                                    if (mainAxisSizeWithSpacings >= 0 || i53 <= 0) {
                                        break;
                                    }
                                    int i55 = i49;
                                    int i56 = i53 - 1;
                                    LazyListMeasuredItem lazyListMeasuredItemM161getAndMeasure0kLqBqw = lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2.m161getAndMeasure0kLqBqw(i56, j2);
                                    arrayDeque2.add(0, lazyListMeasuredItemM161getAndMeasure0kLqBqw);
                                    iMax = Math.max(iMax, lazyListMeasuredItemM161getAndMeasure0kLqBqw.crossAxisSize);
                                    mainAxisSizeWithSpacings += lazyListMeasuredItemM161getAndMeasure0kLqBqw.getMainAxisSizeWithSpacings();
                                    i53 = i56;
                                    i49 = i55;
                                }
                                int i57 = i49;
                                if (mainAxisSizeWithSpacings < i54) {
                                    iRound -= i54 - mainAxisSizeWithSpacings;
                                    mainAxisSizeWithSpacings = i54;
                                }
                                int i58 = iRound;
                                int i59 = mainAxisSizeWithSpacings - i54;
                                int i60 = i50 + i43;
                                int i61 = i60 >= 0 ? i60 : 0;
                                int i62 = iMax;
                                int mainAxisSizeWithSpacings2 = -i59;
                                int i63 = i53;
                                int i64 = 0;
                                boolean z11 = false;
                                while (i64 < arrayDeque2.size) {
                                    if (mainAxisSizeWithSpacings2 >= i61) {
                                        arrayDeque2.removeAt(i64);
                                        z11 = true;
                                    } else {
                                        i63++;
                                        int mainAxisSizeWithSpacings3 = ((LazyListMeasuredItem) arrayDeque2.get(i64)).getMainAxisSizeWithSpacings() + mainAxisSizeWithSpacings2;
                                        i64++;
                                        mainAxisSizeWithSpacings2 = mainAxisSizeWithSpacings3;
                                    }
                                }
                                int iMax2 = i62;
                                int mainAxisSizeWithSpacings4 = i59;
                                boolean z12 = z11;
                                int i65 = i63;
                                while (i65 < i45 && (mainAxisSizeWithSpacings2 < i61 || mainAxisSizeWithSpacings2 <= 0 || arrayDeque2.isEmpty())) {
                                    int i66 = i61;
                                    LazyListMeasuredItem lazyListMeasuredItemM161getAndMeasure0kLqBqw2 = lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2.m161getAndMeasure0kLqBqw(i65, j2);
                                    mainAxisSizeWithSpacings2 = lazyListMeasuredItemM161getAndMeasure0kLqBqw2.getMainAxisSizeWithSpacings() + mainAxisSizeWithSpacings2;
                                    if (mainAxisSizeWithSpacings2 <= i54) {
                                        i39 = i54;
                                        if (i65 != i45 - 1) {
                                            i53 = i65 + 1;
                                            mainAxisSizeWithSpacings4 -= lazyListMeasuredItemM161getAndMeasure0kLqBqw2.getMainAxisSizeWithSpacings();
                                            z12 = true;
                                        }
                                        i65++;
                                        i61 = i66;
                                        i54 = i39;
                                    } else {
                                        i39 = i54;
                                    }
                                    iMax2 = Math.max(iMax2, lazyListMeasuredItemM161getAndMeasure0kLqBqw2.crossAxisSize);
                                    arrayDeque2.addLast(lazyListMeasuredItemM161getAndMeasure0kLqBqw2);
                                    i65++;
                                    i61 = i66;
                                    i54 = i39;
                                }
                                if (mainAxisSizeWithSpacings2 < i50) {
                                    int i67 = i50 - mainAxisSizeWithSpacings2;
                                    int i68 = mainAxisSizeWithSpacings2 + i67;
                                    int mainAxisSizeWithSpacings5 = mainAxisSizeWithSpacings4 - i67;
                                    while (mainAxisSizeWithSpacings5 < i44 && i53 > 0) {
                                        int i69 = i67;
                                        int i70 = i53 - 1;
                                        int i71 = i68;
                                        LazyListMeasuredItem lazyListMeasuredItemM161getAndMeasure0kLqBqw3 = lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2.m161getAndMeasure0kLqBqw(i70, j2);
                                        i53 = i70;
                                        arrayDeque2.add(0, lazyListMeasuredItemM161getAndMeasure0kLqBqw3);
                                        iMax2 = Math.max(iMax2, lazyListMeasuredItemM161getAndMeasure0kLqBqw3.crossAxisSize);
                                        mainAxisSizeWithSpacings5 += lazyListMeasuredItemM161getAndMeasure0kLqBqw3.getMainAxisSizeWithSpacings();
                                        i68 = i71;
                                        i67 = i69;
                                    }
                                    int i72 = i67;
                                    int i73 = i68;
                                    i29 = i58;
                                    int i74 = i29 + i72;
                                    if (mainAxisSizeWithSpacings5 < 0) {
                                        int i75 = i74 + mainAxisSizeWithSpacings5;
                                        int i76 = i73 + mainAxisSizeWithSpacings5;
                                        i212 = iMax2;
                                        i210 = i76;
                                        i213 = i53;
                                        i214 = i75;
                                        i211 = 0;
                                    } else {
                                        i211 = mainAxisSizeWithSpacings5;
                                        i210 = i73;
                                        i212 = iMax2;
                                        i213 = i53;
                                        i214 = i74;
                                    }
                                } else {
                                    i29 = i58;
                                    i210 = mainAxisSizeWithSpacings2;
                                    i211 = mainAxisSizeWithSpacings4;
                                    i212 = iMax2;
                                    i213 = i53;
                                    i214 = i29;
                                }
                                int i77 = i65;
                                if (Integer.signum(Math.round(f3)) != Integer.signum(i214) || Math.abs(Math.round(f3)) < Math.abs(i214)) {
                                    i215 = i214;
                                    f = f3;
                                } else {
                                    i215 = i214;
                                    f = i215;
                                }
                                float f4 = f3 - f;
                                float f5 = CropImageView.DEFAULT_ASPECT_RATIO;
                                if (zIsLookingAhead && i215 > i29 && f4 <= CropImageView.DEFAULT_ASPECT_RATIO) {
                                    f5 = (i215 - i29) + f4;
                                }
                                float f6 = f5;
                                if (i211 < 0) {
                                    InlineClassHelperKt.throwIllegalArgumentException("negative currentFirstItemScrollOffset");
                                }
                                int i78 = -i211;
                                LazyListMeasuredItem lazyListMeasuredItem8 = (LazyListMeasuredItem) arrayDeque2.first();
                                if (i44 > 0 || iMo75roundToPx0680j_8 < 0) {
                                    int size2 = arrayDeque2.getSize();
                                    LazyListMeasuredItem lazyListMeasuredItem9 = lazyListMeasuredItem8;
                                    int i79 = 0;
                                    while (i79 < size2) {
                                        int i80 = size2;
                                        int mainAxisSizeWithSpacings6 = ((LazyListMeasuredItem) arrayDeque2.get(i79)).getMainAxisSizeWithSpacings();
                                        if (i211 == 0 || mainAxisSizeWithSpacings6 > i211 || i79 == arrayDeque2.getSize() - 1) {
                                            break;
                                        }
                                        i211 -= mainAxisSizeWithSpacings6;
                                        i79++;
                                        lazyListMeasuredItem9 = (LazyListMeasuredItem) arrayDeque2.get(i79);
                                        size2 = i80;
                                    }
                                    lazyListMeasuredItem = lazyListMeasuredItem9;
                                } else {
                                    lazyListMeasuredItem = lazyListMeasuredItem8;
                                }
                                int i81 = i211;
                                int iMax3 = Math.max(0, i213);
                                int i82 = i213 - 1;
                                if (iMax3 <= i82) {
                                    List arrayList3 = null;
                                    while (true) {
                                        if (arrayList3 == null) {
                                            arrayList3 = new ArrayList();
                                        }
                                        i30 = i45;
                                        arrayList = arrayList3;
                                        arrayList.add(lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2.m161getAndMeasure0kLqBqw(i82, j2));
                                        if (i82 == iMax3) {
                                            break;
                                        }
                                        i82--;
                                        arrayList3 = arrayList;
                                        i45 = i30;
                                    }
                                } else {
                                    i30 = i45;
                                    arrayList = null;
                                }
                                int[] iArr = mutableIntListCalculateLazyLayoutPinnedIndices.content;
                                for (int i83 = mutableIntListCalculateLazyLayoutPinnedIndices._size - 1; -1 < i83; i83--) {
                                    int i84 = iArr[i83];
                                    if (i84 < iMax3) {
                                        if (arrayList == null) {
                                            arrayList = new ArrayList();
                                        }
                                        arrayList.add(lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2.m161getAndMeasure0kLqBqw(i84, j2));
                                    }
                                }
                                if (arrayList == null) {
                                    arrayList = emptyList;
                                }
                                int iMax4 = i212;
                                int i85 = 0;
                                for (int size3 = arrayList.size(); i85 < size3; size3 = size3) {
                                    iMax4 = Math.max(iMax4, ((LazyListMeasuredItem) arrayList.get(i85)).crossAxisSize);
                                    i85++;
                                }
                                int iMin = Math.min(((LazyListMeasuredItem) CollectionsKt.last(arrayDeque2)).index, i30 - 1);
                                int i86 = ((LazyListMeasuredItem) CollectionsKt.last(arrayDeque2)).index + 1;
                                if (i86 <= iMin) {
                                    ArrayList arrayList4 = null;
                                    while (true) {
                                        if (arrayList4 == null) {
                                            arrayList4 = new ArrayList();
                                        }
                                        i31 = iMax4;
                                        f2 = f;
                                        arrayList2 = arrayList4;
                                        arrayList2.add(lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2.m161getAndMeasure0kLqBqw(i86, j2));
                                        if (i86 == iMin) {
                                            break;
                                        }
                                        i86++;
                                        arrayList4 = arrayList2;
                                        iMax4 = i31;
                                        f = f2;
                                    }
                                } else {
                                    i31 = iMax4;
                                    f2 = f;
                                    arrayList2 = null;
                                }
                                if (arrayList2 != null && ((LazyListMeasuredItem) CollectionsKt.last(arrayList2)).index > iMin) {
                                    iMin = ((LazyListMeasuredItem) CollectionsKt.last(arrayList2)).index;
                                }
                                int[] iArr2 = mutableIntListCalculateLazyLayoutPinnedIndices.content;
                                int i87 = mutableIntListCalculateLazyLayoutPinnedIndices._size;
                                List arrayList5 = arrayList2;
                                int i88 = 0;
                                while (i88 < i87) {
                                    int i89 = i87;
                                    int i90 = iArr2[i88];
                                    if (i90 > iMin) {
                                        if (arrayList5 == null) {
                                            arrayList5 = new ArrayList();
                                        }
                                        arrayList5.add(lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2.m161getAndMeasure0kLqBqw(i90, j2));
                                    }
                                    i88++;
                                    i87 = i89;
                                }
                                if (arrayList5 == null) {
                                    arrayList5 = emptyList;
                                }
                                int size4 = arrayList5.size();
                                int iMax5 = i31;
                                for (int i91 = 0; i91 < size4; i91++) {
                                    iMax5 = Math.max(iMax5, ((LazyListMeasuredItem) arrayList5.get(i91)).crossAxisSize);
                                }
                                boolean z13 = Intrinsics.areEqual(lazyListMeasuredItem, arrayDeque2.first()) && arrayList.isEmpty() && arrayList5.isEmpty();
                                int iM792constrainWidthK40F9xA = ConstraintsKt.m792constrainWidthK40F9xA(z10 ? iMax5 : i210, jM793offsetNN6EwU);
                                if (z10) {
                                    iMax5 = i210;
                                }
                                int iM791constrainHeightK40F9xA2 = ConstraintsKt.m791constrainHeightK40F9xA(iMax5, jM793offsetNN6EwU);
                                int i92 = z10 ? iM791constrainHeightK40F9xA2 : iM792constrainWidthK40F9xA;
                                boolean z14 = i210 < Math.min(i92, i50);
                                if (z14 && i78 != 0) {
                                    InlineClassHelperKt.throwIllegalStateException("non-zero itemsScrollOffset");
                                }
                                boolean z15 = z13;
                                ArrayList arrayList6 = new ArrayList(arrayList5.size() + arrayList.size() + arrayDeque2.getSize());
                                if (z14) {
                                    if (!arrayList.isEmpty() || !arrayList5.isEmpty()) {
                                        InlineClassHelperKt.throwIllegalArgumentException("no extra items");
                                    }
                                    int size5 = arrayDeque2.getSize();
                                    int[] iArr3 = new int[size5];
                                    for (int i93 = 0; i93 < size5; i93++) {
                                        iArr3[i93] = ((LazyListMeasuredItem) arrayDeque2.get(i93)).size;
                                    }
                                    int[] iArr4 = new int[size5];
                                    if (z10) {
                                        if (arrangement$Vertical10 == null) {
                                            throw Fragment$5$$ExternalSyntheticOutline0.m("null verticalArrangement when isVertical == true");
                                        }
                                        arrangement$Vertical10.arrange(lazyLayoutMeasureScopeImpl, i92, iArr3, iArr4);
                                        i32 = 0;
                                    } else {
                                        if (arrangement$Horizontal4 == null) {
                                            throw Fragment$5$$ExternalSyntheticOutline0.m("null horizontalArrangement when isVertical == false");
                                        }
                                        i32 = 0;
                                        arrangement$Horizontal4.arrange(lazyLayoutMeasureScopeImpl, i92, iArr3, LayoutDirection.Ltr, iArr4);
                                    }
                                    IntRange indices = ArraysKt.getIndices(iArr4);
                                    int i94 = indices.last;
                                    int i95 = indices.step;
                                    if ((i95 > 0 && i94 >= 0) || (i95 < 0 && i94 <= 0)) {
                                        int i96 = i32;
                                        while (true) {
                                            int i97 = iArr4[i96];
                                            LazyListMeasuredItem lazyListMeasuredItem10 = (LazyListMeasuredItem) arrayDeque2.get(i96);
                                            lazyListMeasuredItem10.position(i97, iM792constrainWidthK40F9xA, iM791constrainHeightK40F9xA2);
                                            arrayList6.add(lazyListMeasuredItem10);
                                            if (i96 == i94) {
                                                break;
                                            }
                                            i96 += i95;
                                        }
                                    }
                                } else {
                                    i50 = i50;
                                    lazyListMeasuredItem = lazyListMeasuredItem;
                                    i32 = 0;
                                    int size6 = arrayList.size();
                                    int mainAxisSizeWithSpacings7 = i78;
                                    int i98 = 0;
                                    while (i98 < size6) {
                                        int i99 = size6;
                                        LazyListMeasuredItem lazyListMeasuredItem11 = (LazyListMeasuredItem) arrayList.get(i98);
                                        mainAxisSizeWithSpacings7 -= lazyListMeasuredItem11.getMainAxisSizeWithSpacings();
                                        lazyListMeasuredItem11.position(mainAxisSizeWithSpacings7, iM792constrainWidthK40F9xA, iM791constrainHeightK40F9xA2);
                                        arrayList6.add(lazyListMeasuredItem11);
                                        i98++;
                                        size6 = i99;
                                    }
                                    int size7 = arrayDeque2.getSize();
                                    int mainAxisSizeWithSpacings8 = i78;
                                    for (int i100 = 0; i100 < size7; i100++) {
                                        LazyListMeasuredItem lazyListMeasuredItem12 = (LazyListMeasuredItem) arrayDeque2.get(i100);
                                        lazyListMeasuredItem12.position(mainAxisSizeWithSpacings8, iM792constrainWidthK40F9xA, iM791constrainHeightK40F9xA2);
                                        arrayList6.add(lazyListMeasuredItem12);
                                        mainAxisSizeWithSpacings8 += lazyListMeasuredItem12.getMainAxisSizeWithSpacings();
                                    }
                                    int size8 = arrayList5.size();
                                    for (int i101 = 0; i101 < size8; i101++) {
                                        LazyListMeasuredItem lazyListMeasuredItem13 = (LazyListMeasuredItem) arrayList5.get(i101);
                                        lazyListMeasuredItem13.position(mainAxisSizeWithSpacings8, iM792constrainWidthK40F9xA, iM791constrainHeightK40F9xA2);
                                        arrayList6.add(lazyListMeasuredItem13);
                                        mainAxisSizeWithSpacings8 += lazyListMeasuredItem13.getMainAxisSizeWithSpacings();
                                    }
                                }
                                float f7 = f2;
                                int i102 = i210;
                                lazyLayoutItemAnimator.onMeasured((int) f7, iM792constrainWidthK40F9xA, iM791constrainHeightK40F9xA2, arrayList6, statusLine, lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2, z10, zIsLookingAhead, 1, z7, i81, i102, coroutineScope2, graphicsContext2, z9);
                                if (zIsLookingAhead) {
                                    arrayDeque = arrayDeque2;
                                } else {
                                    long jM173getMinSizeToFitDisappearingItemsYbymL2g2 = lazyLayoutItemAnimator.m173getMinSizeToFitDisappearingItemsYbymL2g();
                                    arrayDeque = arrayDeque2;
                                    if (!IntSize.m810equalsimpl0(jM173getMinSizeToFitDisappearingItemsYbymL2g2, 0L)) {
                                        int i103 = z10 ? iM791constrainHeightK40F9xA2 : iM792constrainWidthK40F9xA;
                                        iM792constrainWidthK40F9xA = ConstraintsKt.m792constrainWidthK40F9xA(Math.max(iM792constrainWidthK40F9xA, (int) (jM173getMinSizeToFitDisappearingItemsYbymL2g2 >> 32)), jM793offsetNN6EwU);
                                        iM791constrainHeightK40F9xA = ConstraintsKt.m791constrainHeightK40F9xA(Math.max(iM791constrainHeightK40F9xA2, (int) (jM173getMinSizeToFitDisappearingItemsYbymL2g2 & 4294967295L)), jM793offsetNN6EwU);
                                        int i104 = z10 ? iM791constrainHeightK40F9xA : iM792constrainWidthK40F9xA;
                                        if (i104 != i103) {
                                            int size9 = arrayList6.size();
                                            for (int i105 = i32; i105 < size9; i105++) {
                                                LazyListMeasuredItem lazyListMeasuredItem14 = (LazyListMeasuredItem) arrayList6.get(i105);
                                                lazyListMeasuredItem14.mainAxisLayoutSize = i104;
                                                lazyListMeasuredItem14.maxMainAxisOffset = lazyListMeasuredItem14.afterContentPadding + i104;
                                            }
                                        }
                                    }
                                    int i1014 = iM792constrainWidthK40F9xA;
                                    lazyListMeasuredItem2 = (LazyListMeasuredItem) arrayDeque.firstOrNull();
                                    if (lazyListMeasuredItem2 != null) {
                                        i33 = lazyListMeasuredItem2.index;
                                    } else {
                                        i33 = i32;
                                    }
                                    lazyListMeasuredItem3 = (LazyListMeasuredItem) arrayDeque.lastOrNull();
                                    if (lazyListMeasuredItem3 != null) {
                                        i34 = lazyListMeasuredItem3.index;
                                    } else {
                                        i34 = i32;
                                    }
                                    mutableIntList = lazyListItemProviderImpl3.intervalContent._headerIndexes;
                                    if (mutableIntList == null) {
                                        mutableIntList = IntListKt.EmptyIntList;
                                    }
                                    int i1015 = iM791constrainHeightK40F9xA;
                                    listApplyStickyItems = LazyLayoutKt.applyStickyItems(noKey, i33, i34, arrayList6, mutableIntList, i44, i1014, i1015, z10, new ScrollState$$ExternalSyntheticLambda0((byte) 13, lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2));
                                    if (z15) {
                                        lazyListMeasuredItem7 = (LazyListMeasuredItem) CollectionsKt.firstOrNull((List) arrayList6);
                                        if (lazyListMeasuredItem7 != null) {
                                            numValueOf = Integer.valueOf(lazyListMeasuredItem7.index);
                                        } else {
                                            numValueOf = null;
                                        }
                                    } else {
                                        lazyListMeasuredItem4 = (LazyListMeasuredItem) arrayDeque.firstOrNull();
                                        if (lazyListMeasuredItem4 != null) {
                                            numValueOf = Integer.valueOf(lazyListMeasuredItem4.index);
                                        } else {
                                            numValueOf = null;
                                        }
                                    }
                                    if (z15) {
                                        lazyListMeasuredItem6 = (LazyListMeasuredItem) CollectionsKt.lastOrNull(arrayList6);
                                        if (lazyListMeasuredItem6 != null) {
                                            numValueOf2 = Integer.valueOf(lazyListMeasuredItem6.index);
                                        } else {
                                            numValueOf2 = null;
                                        }
                                    } else {
                                        lazyListMeasuredItem5 = (LazyListMeasuredItem) arrayDeque.lastOrNull();
                                        if (lazyListMeasuredItem5 != null) {
                                            numValueOf2 = Integer.valueOf(lazyListMeasuredItem5.index);
                                        } else {
                                            numValueOf2 = null;
                                        }
                                    }
                                    i35 = i30;
                                    if (i77 >= i35 || i102 > i50) {
                                        i36 = 1;
                                    } else {
                                        i36 = i32;
                                    }
                                    MeasureResult measureResultLayout6 = subcomposeMeasureScope2.layout(ConstraintsKt.m792constrainWidthK40F9xA(i1014 + i40, j), ConstraintsKt.m791constrainHeightK40F9xA(i1015 + i57, j), emptyMap, new LazyListMeasureKt$$ExternalSyntheticLambda2(mutableState, arrayList6, listApplyStickyItems, zIsLookingAhead, (byte) 0));
                                    if (numValueOf != null) {
                                        iIntValue = numValueOf.intValue();
                                    } else {
                                        iIntValue = i32;
                                    }
                                    if (numValueOf2 != null) {
                                        iIntValue2 = numValueOf2.intValue();
                                    } else {
                                        iIntValue2 = i32;
                                    }
                                    List listUpdatedVisibleItems5 = LazyLayoutKt.updatedVisibleItems(iIntValue, iIntValue2, arrayList6, listApplyStickyItems);
                                    if (!z10) {
                                        orientation3 = orientation2;
                                    }
                                    size = listApplyStickyItems.size();
                                    i37 = i32;
                                    i38 = i37;
                                    while (i37 < size) {
                                        i38 += ((LazyListMeasuredItem) listApplyStickyItems.get(i37)).size;
                                        i37++;
                                    }
                                    lazyListItemProviderImpl3 = lazyListItemProviderImpl3;
                                    lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1 = lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2;
                                    subcomposeMeasureScope = subcomposeMeasureScope2;
                                    lazyListMeasureResult = new LazyListMeasureResult(lazyListMeasuredItem, i81, i36, f7, measureResultLayout6, f6, z12, coroutineScope2, lazyLayoutMeasureScopeImpl, lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2.childConstraints, i38, listUpdatedVisibleItems5, i52, i60, i35, orientation3, i43, iMo75roundToPx0680j_8);
                                }
                                iM791constrainHeightK40F9xA = iM791constrainHeightK40F9xA2;
                                int i1016 = iM792constrainWidthK40F9xA;
                                lazyListMeasuredItem2 = (LazyListMeasuredItem) arrayDeque.firstOrNull();
                                if (lazyListMeasuredItem2 != null) {
                                    i33 = lazyListMeasuredItem2.index;
                                } else {
                                    i33 = i32;
                                }
                                lazyListMeasuredItem3 = (LazyListMeasuredItem) arrayDeque.lastOrNull();
                                if (lazyListMeasuredItem3 != null) {
                                    i34 = lazyListMeasuredItem3.index;
                                } else {
                                    i34 = i32;
                                }
                                mutableIntList = lazyListItemProviderImpl3.intervalContent._headerIndexes;
                                if (mutableIntList == null) {
                                    mutableIntList = IntListKt.EmptyIntList;
                                }
                                int i1017 = iM791constrainHeightK40F9xA;
                                listApplyStickyItems = LazyLayoutKt.applyStickyItems(noKey, i33, i34, arrayList6, mutableIntList, i44, i1016, i1017, z10, new ScrollState$$ExternalSyntheticLambda0((byte) 13, lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2));
                                if (z15) {
                                    lazyListMeasuredItem7 = (LazyListMeasuredItem) CollectionsKt.firstOrNull((List) arrayList6);
                                    if (lazyListMeasuredItem7 != null) {
                                        numValueOf = Integer.valueOf(lazyListMeasuredItem7.index);
                                    } else {
                                        numValueOf = null;
                                    }
                                } else {
                                    lazyListMeasuredItem4 = (LazyListMeasuredItem) arrayDeque.firstOrNull();
                                    if (lazyListMeasuredItem4 != null) {
                                        numValueOf = Integer.valueOf(lazyListMeasuredItem4.index);
                                    } else {
                                        numValueOf = null;
                                    }
                                }
                                if (z15) {
                                    lazyListMeasuredItem6 = (LazyListMeasuredItem) CollectionsKt.lastOrNull(arrayList6);
                                    if (lazyListMeasuredItem6 != null) {
                                        numValueOf2 = Integer.valueOf(lazyListMeasuredItem6.index);
                                    } else {
                                        numValueOf2 = null;
                                    }
                                } else {
                                    lazyListMeasuredItem5 = (LazyListMeasuredItem) arrayDeque.lastOrNull();
                                    if (lazyListMeasuredItem5 != null) {
                                        numValueOf2 = Integer.valueOf(lazyListMeasuredItem5.index);
                                    } else {
                                        numValueOf2 = null;
                                    }
                                }
                                i35 = i30;
                                if (i77 >= i35) {
                                    i36 = 1;
                                } else {
                                    i36 = 1;
                                }
                                MeasureResult measureResultLayout7 = subcomposeMeasureScope2.layout(ConstraintsKt.m792constrainWidthK40F9xA(i1016 + i40, j), ConstraintsKt.m791constrainHeightK40F9xA(i1017 + i57, j), emptyMap, new LazyListMeasureKt$$ExternalSyntheticLambda2(mutableState, arrayList6, listApplyStickyItems, zIsLookingAhead, (byte) 0));
                                if (numValueOf != null) {
                                    iIntValue = numValueOf.intValue();
                                } else {
                                    iIntValue = i32;
                                }
                                if (numValueOf2 != null) {
                                    iIntValue2 = numValueOf2.intValue();
                                } else {
                                    iIntValue2 = i32;
                                }
                                List listUpdatedVisibleItems6 = LazyLayoutKt.updatedVisibleItems(iIntValue, iIntValue2, arrayList6, listApplyStickyItems);
                                if (!z10) {
                                    orientation3 = orientation2;
                                }
                                size = listApplyStickyItems.size();
                                i37 = i32;
                                i38 = i37;
                                while (i37 < size) {
                                    i38 += ((LazyListMeasuredItem) listApplyStickyItems.get(i37)).size;
                                    i37++;
                                }
                                lazyListItemProviderImpl3 = lazyListItemProviderImpl3;
                                lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1 = lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2;
                                subcomposeMeasureScope = subcomposeMeasureScope2;
                                lazyListMeasureResult = new LazyListMeasureResult(lazyListMeasuredItem, i81, i36, f7, measureResultLayout7, f6, z12, coroutineScope2, lazyLayoutMeasureScopeImpl, lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$2.childConstraints, i38, listUpdatedVisibleItems6, i52, i60, i35, orientation3, i43, iMo75roundToPx0680j_8);
                            }
                            LazyListMeasureResult lazyListMeasureResult2 = lazyListMeasureResult;
                            LazyListState lazyListState7 = lazyListState5;
                            lazyListState7.applyMeasureResult$foundation(lazyListMeasureResult2, subcomposeMeasureScope.isLookingAhead(), false);
                            Object obj2 = lazyListState7.prefetchStrategy;
                            CacheWindowLogic cacheWindowLogic = obj2 instanceof CacheWindowLogic ? (CacheWindowLogic) obj2 : null;
                            if (cacheWindowLogic == null) {
                                return lazyListMeasureResult2;
                            }
                            List list = lazyListMeasureResult2.visibleItemsInfo;
                            Trace.beginSection("compose:lazy:cache_window:keepAroundItems");
                            try {
                                if (cacheWindowLogic.hasValidBounds() && !list.isEmpty()) {
                                    int i1110 = ((LazyListMeasuredItem) CollectionsKt.first(list)).index;
                                    int i1111 = ((LazyListMeasuredItem) CollectionsKt.last(list)).index;
                                    int i1112 = cacheWindowLogic.getPerLaneCacheWindowStartIndex()[0];
                                    LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1 lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$3 = lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1;
                                    while (true) {
                                        lazyLayoutMeasureScopeImpl2 = lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$3.measureScope;
                                        if (i1112 >= i1110) {
                                            break;
                                        }
                                        if (i1112 >= 0 && i1112 < lazyListItemProviderImpl3.getItemCount()) {
                                            lazyLayoutMeasureScopeImpl2.compose(i1112);
                                        }
                                        i1112++;
                                    }
                                    int i1113 = i1111 + 1;
                                    int i1114 = cacheWindowLogic.getPerLaneCacheWindowEndItemIndex()[0];
                                    if (i1113 <= i1114) {
                                        while (true) {
                                            if (i1113 >= 0 && i1113 < lazyListItemProviderImpl3.getItemCount()) {
                                                lazyLayoutMeasureScopeImpl2.compose(i1113);
                                            }
                                            if (i1113 == i1114) {
                                                break;
                                            }
                                            i1113++;
                                        }
                                    }
                                }
                                return lazyListMeasureResult2;
                            } finally {
                                Trace.endSection();
                            }
                        } catch (Throwable th) {
                            Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                            throw th;
                        }
                    }
                };
                kProperty1 = kProperty0;
                arrangement$Vertical4 = arrangement$Vertical9;
                gapComposer2.updateRememberedValue(obj);
            }
            LazyLayoutMeasurePolicy lazyLayoutMeasurePolicy3 = (LazyLayoutMeasurePolicy) obj;
            if (r4 != 0) {
                orientation = Orientation.Vertical;
            } else {
                orientation = Orientation.Horizontal;
            }
            if (z2) {
                gapComposer2.startReplaceGroup(-2077147368);
                zChanged2 = ((((i7 & 14) ^ 6) <= i9 && gapComposer2.changed(lazyListState3)) || (i7 & 6) == i9) | gapComposer2.changed(0);
                objRememberedValue5 = gapComposer2.rememberedValue();
                if (zChanged2) {
                    objRememberedValue5 = new LazyListBeyondBoundsState(lazyListState3);
                    gapComposer2.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = new LazyListBeyondBoundsState(lazyListState3);
                    gapComposer2.updateRememberedValue(objRememberedValue5);
                }
                modifierLazyLayoutBeyondBoundsModifier = LazyLayoutKt.lazyLayoutBeyondBoundsModifier((LazyListBeyondBoundsState) objRememberedValue5, lazyListState3.beyondBoundsInfo, orientation);
                gapComposer2.end(false);
            } else {
                gapComposer2.startReplaceGroup(-2076718545);
                gapComposer2.end(false);
                modifierLazyLayoutBeyondBoundsModifier = Modifier.Companion.$$INSTANCE;
            }
            if (i8 == 32) {
                z6 = true;
            } else {
                z6 = false;
            }
            objRememberedValue4 = gapComposer2.rememberedValue();
            if (z6) {
                objRememberedValue4 = new LazyListKt$$ExternalSyntheticLambda0(lazyListState3, (byte) 0);
                gapComposer2.updateRememberedValue(objRememberedValue4);
            } else {
                objRememberedValue4 = new LazyListKt$$ExternalSyntheticLambda0(lazyListState3, (byte) 0);
                gapComposer2.updateRememberedValue(objRememberedValue4);
            }
            modifier2 = modifier;
            lazyListState2 = lazyListState3;
            gapComposer = gapComposer2;
            LazyLayoutKt.LazyLayout(kProperty1, ImageKt.scrollableArea(LazyLayoutKt.lazyLayoutItemAnimator(LazyLayoutKt.lazyLayoutSemantics(modifier2.then(lazyListState3.remeasurementModifier).then(lazyListState3.awaitLayoutModifier), kProperty1, lazyLayoutSemanticState3, orientation, z2).then(modifierLazyLayoutBeyondBoundsModifier), lazyListState3.itemAnimator), lazyListState3, orientation, androidEdgeEffectOverscrollEffect, z2, flingBehavior, lazyListState3.internalInteractionSource, LazyLayoutKt.rememberLazyLayoutBringIntoViewSpec(i119 & 126, gapComposer2, (Function0) objRememberedValue4, z)), lazyListState2.prefetchState, lazyLayoutMeasurePolicy3, gapComposer, 0);
            arrangement$Vertical2 = arrangement$Vertical4;
            vertical2 = vertical3;
            arrangement$Horizontal2 = arrangement$Horizontal3;
        } else {
            modifier2 = modifier;
            lazyListState2 = lazyListState;
            gapComposer = gapComposer3;
            gapComposer.skipToGroupEnd();
            horizontal2 = horizontal;
            arrangement$Vertical2 = arrangement$Vertical;
            vertical2 = vertical;
            arrangement$Horizontal2 = arrangement$Horizontal;
        }
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            final LazyListState lazyListState5 = lazyListState2;
            final Alignment.Horizontal horizontal5 = horizontal2;
            final Modifier modifier4 = modifier2;
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.foundation.lazy.LazyListKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    ((Integer) obj3).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                    int iUpdateChangedFlags2 = Stack.updateChangedFlags(i2);
                    MathKt.LazyList(modifier4, lazyListState5, paddingValues, z, flingBehavior, z2, androidEdgeEffectOverscrollEffect, horizontal5, arrangement$Vertical2, vertical2, arrangement$Horizontal2, function1, (Composer) obj2, iUpdateChangedFlags, iUpdateChangedFlags2, i3);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX INFO: renamed from: RoundRect-gG7oq9Y, reason: not valid java name */
    public static final RoundRect m1873RoundRectgG7oq9Y(float f, float f2, float f3, float f4, long j) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L));
        long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (4294967295L & ((long) Float.floatToRawIntBits(fIntBitsToFloat2)));
        return new RoundRect(f, f2, f3, f4, jFloatToRawIntBits, jFloatToRawIntBits, jFloatToRawIntBits, jFloatToRawIntBits);
    }

    public static final void TextFieldSelectionHandle(final boolean z, ResolvedTextDirection resolvedTextDirection, final TextFieldSelectionManager textFieldSelectionManager, Composer composer, int i) {
        int i2;
        TextLayoutResultProxy layoutResult;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-1344558920);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changed(resolvedTextDirection.ordinal()) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer.changedInstance(textFieldSelectionManager) ? 256 : 128;
        }
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
            int i3 = i2 & 14;
            boolean zChanged = (i3 == 4) | gapComposer.changed(textFieldSelectionManager);
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (zChanged || objRememberedValue == neverEqualPolicy) {
                objRememberedValue = new TextDragObserver() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$handleDragObserver$1
                    @Override // androidx.compose.foundation.text.TextDragObserver
                    /* JADX INFO: renamed from: onDown-k-4lQ0M */
                    public final void mo200onDownk4lQ0M() {
                        TextLayoutResultProxy layoutResult2;
                        boolean z2 = z;
                        Handle handle = z2 ? Handle.SelectionStart : Handle.SelectionEnd;
                        TextFieldSelectionManager textFieldSelectionManager2 = textFieldSelectionManager;
                        textFieldSelectionManager2.setDraggingHandle(handle);
                        long jM229getAdjustedCoordinatesk4lQ0M = SelectionHandlesKt.m229getAdjustedCoordinatesk4lQ0M(textFieldSelectionManager2.m233getHandlePositiontuRUvjQ$foundation(z2));
                        LegacyTextFieldState legacyTextFieldState = textFieldSelectionManager2.state;
                        if (legacyTextFieldState == null || (layoutResult2 = legacyTextFieldState.getLayoutResult()) == null) {
                            return;
                        }
                        long jM207translateInnerToDecorationCoordinatesMKHz9U$foundation = layoutResult2.m207translateInnerToDecorationCoordinatesMKHz9U$foundation(jM229getAdjustedCoordinatesk4lQ0M);
                        textFieldSelectionManager2.dragBeginPosition = jM207translateInnerToDecorationCoordinatesMKHz9U$foundation;
                        textFieldSelectionManager2.m235setCurrentDragPosition_kEHs6E(new Offset(jM207translateInnerToDecorationCoordinatesMKHz9U$foundation));
                        textFieldSelectionManager2.dragTotalDistance = 0L;
                        textFieldSelectionManager2.previousRawDragOffset = -1;
                        LegacyTextFieldState legacyTextFieldState2 = textFieldSelectionManager2.state;
                        if (legacyTextFieldState2 != null) {
                            legacyTextFieldState2.isInTouchMode$delegate.setValue(Boolean.TRUE);
                        }
                        textFieldSelectionManager2.updateFloatingToolbar(false);
                    }

                    @Override // androidx.compose.foundation.text.TextDragObserver
                    /* JADX INFO: renamed from: onDrag-k-4lQ0M */
                    public final void mo201onDragk4lQ0M(long j) {
                        TextFieldSelectionManager textFieldSelectionManager2 = textFieldSelectionManager;
                        long jM439plusMKHz9U = Offset.m439plusMKHz9U(textFieldSelectionManager2.dragTotalDistance, j);
                        textFieldSelectionManager2.dragTotalDistance = jM439plusMKHz9U;
                        textFieldSelectionManager2.m235setCurrentDragPosition_kEHs6E(new Offset(Offset.m439plusMKHz9U(textFieldSelectionManager2.dragBeginPosition, jM439plusMKHz9U)));
                        TextFieldValue value$foundation = textFieldSelectionManager2.getValue$foundation();
                        Offset offsetM232getCurrentDragPosition_m7T9E = textFieldSelectionManager2.m232getCurrentDragPosition_m7T9E();
                        offsetM232getCurrentDragPosition_m7T9E.getClass();
                        textFieldSelectionManager2.m236updateSelectionjSglsI8(value$foundation, offsetM232getCurrentDragPosition_m7T9E.packedValue, false, z, SelectionAdjustment$Companion.CharacterWithWordAccelerate, true, new HapticFeedbackType(9));
                        textFieldSelectionManager2.updateFloatingToolbar(false);
                    }

                    @Override // androidx.compose.foundation.text.TextDragObserver
                    public final void onStop() {
                        TextFieldSelectionManager textFieldSelectionManager2 = textFieldSelectionManager;
                        textFieldSelectionManager2.setDraggingHandle(null);
                        textFieldSelectionManager2.m235setCurrentDragPosition_kEHs6E(null);
                        textFieldSelectionManager2.updateFloatingToolbar(true);
                    }

                    @Override // androidx.compose.foundation.text.TextDragObserver
                    public final void onUp() {
                        TextFieldSelectionManager textFieldSelectionManager2 = textFieldSelectionManager;
                        textFieldSelectionManager2.setDraggingHandle(null);
                        textFieldSelectionManager2.m235setCurrentDragPosition_kEHs6E(null);
                        textFieldSelectionManager2.updateFloatingToolbar(true);
                    }

                    @Override // androidx.compose.foundation.text.TextDragObserver
                    public final void onCancel() {
                    }

                    @Override // androidx.compose.foundation.text.TextDragObserver
                    /* JADX INFO: renamed from: onStart-3MmeM6k */
                    public final void mo202onStart3MmeM6k(long j, MarqueeSpacing$Companion$$ExternalSyntheticLambda0 marqueeSpacing$Companion$$ExternalSyntheticLambda0) {
                    }
                };
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            TextDragObserver textDragObserver = (TextDragObserver) objRememberedValue;
            boolean zChangedInstance = (i3 == 4) | gapComposer.changedInstance(textFieldSelectionManager);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new OffsetProvider() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManagerKt$TextFieldSelectionHandle$1$1
                    @Override // androidx.compose.foundation.text.selection.OffsetProvider
                    /* JADX INFO: renamed from: provide-F1C5BW0 */
                    public final long mo194provideF1C5BW0() {
                        return textFieldSelectionManager.m233getHandlePositiontuRUvjQ$foundation(z);
                    }
                };
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            OffsetProvider offsetProvider = (OffsetProvider) objRememberedValue2;
            boolean zM745getReversedimpl = TextRange.m745getReversedimpl(textFieldSelectionManager.getValue$foundation().selection);
            int i4 = (int) (z ? textFieldSelectionManager.getValue$foundation().selection >> 32 : textFieldSelectionManager.getValue$foundation().selection & 4294967295L);
            LegacyTextFieldState legacyTextFieldState = textFieldSelectionManager.state;
            float lineHeight = CropImageView.DEFAULT_ASPECT_RATIO;
            if (legacyTextFieldState != null && (layoutResult = legacyTextFieldState.getLayoutResult()) != null) {
                TextLayoutResult textLayoutResult = layoutResult.value;
                if (i4 >= 0) {
                    TextLayoutInput textLayoutInput = textLayoutResult.layoutInput;
                    MultiParagraph multiParagraph = textLayoutResult.multiParagraph;
                    if (textLayoutInput.text.text.length() != 0) {
                        int iMin = Math.min(multiParagraph.getLineForOffset(i4), Math.min(multiParagraph.maxLines - 1, multiParagraph.lineCount - 1));
                        if (i4 <= multiParagraph.getLineEnd(iMin, false)) {
                            multiParagraph.requireLineIndexInRange(iMin);
                            ArrayList arrayList = multiParagraph.paragraphInfoList;
                            ParagraphInfo paragraphInfo = (ParagraphInfo) arrayList.get(TextRangeKt.findParagraphByLineIndex(iMin, arrayList));
                            lineHeight = paragraphInfo.paragraph.layout.getLineHeight(iMin - paragraphInfo.startLineIndex);
                        }
                    }
                }
            }
            float f = lineHeight;
            boolean zChangedInstance2 = gapComposer.changedInstance(textDragObserver);
            Object objRememberedValue3 = gapComposer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue3 == neverEqualPolicy) {
                objRememberedValue3 = new ScrimKt$Scrim$dismissModifier$1$1((byte) 7, textDragObserver);
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            FileSystemsKt.m878SelectionHandlewLIcFTc(offsetProvider, z, resolvedTextDirection, zM745getReversedimpl, 0L, f, SuspendingPointerInputFilterKt.pointerInput(Modifier.Companion.$$INSTANCE, textDragObserver, (PointerInputEventHandler) objRememberedValue3), gapComposer, (i2 << 3) & 1008);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ItemsKt$$ExternalSyntheticLambda67(z, resolvedTextDirection, textFieldSelectionManager, i);
        }
    }

    public static final long Velocity(float f, float f2) {
        return (((long) Float.floatToRawIntBits(f2)) & 4294967295L) | (Float.floatToRawIntBits(f) << 32);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0057, code lost:
    
        if (coil3.size.SizeKt.computeSizeMultiplier(r12.getWidth(), r12.getHeight(), (int) (r3 >> 32), (int) (r3 & 4294967295L), r20, r7) == 1.0d) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap convertToBitmap(Drawable drawable, Bitmap.Config config, Size size, Scale scale, Size size2, boolean z) {
        Bitmap.Config config2 = config;
        Scale scale2 = scale;
        Size size3 = size2;
        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            if (bitmap.getConfig() == ((config2 == null || config2 == Bitmap.Config.HARDWARE) ? Bitmap.Config.ARGB_8888 : config2)) {
                if (!z) {
                    long jM863computeDstSizesEdh43o = SizeKt.m863computeDstSizesEdh43o(bitmap.getWidth(), bitmap.getHeight(), size, scale2, size3);
                    scale2 = scale;
                }
                size3 = size3;
                return bitmap;
            }
        }
        size3 = size3;
        Drawable drawableMutate = drawable.mutate();
        int width = Utils_androidKt.getWidth(drawableMutate);
        if (width <= 0) {
            width = 512;
        }
        int height = Utils_androidKt.getHeight(drawableMutate);
        int i = height > 0 ? height : 512;
        long jM863computeDstSizesEdh43o2 = SizeKt.m863computeDstSizesEdh43o(width, i, size, scale2, size3);
        int i2 = i;
        int i3 = width;
        double dComputeSizeMultiplier = SizeKt.computeSizeMultiplier(i3, i2, (int) (jM863computeDstSizesEdh43o2 >> 32), (int) (jM863computeDstSizesEdh43o2 & 4294967295L), scale2, size3);
        int iRoundToInt = roundToInt(((double) i3) * dComputeSizeMultiplier);
        int iRoundToInt2 = roundToInt(dComputeSizeMultiplier * ((double) i2));
        if (config2 == null || config2 == Bitmap.Config.HARDWARE) {
            config2 = Bitmap.Config.ARGB_8888;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iRoundToInt, iRoundToInt2, config2);
        Rect bounds = drawableMutate.getBounds();
        int i4 = bounds.left;
        int i5 = bounds.top;
        int i6 = bounds.right;
        int i7 = bounds.bottom;
        drawableMutate.setBounds(0, 0, iRoundToInt, iRoundToInt2);
        drawableMutate.draw(new Canvas(bitmapCreateBitmap));
        drawableMutate.setBounds(i4, i5, i6, i7);
        return bitmapCreateBitmap;
    }

    public static final NavHostController createNavController$NavHostControllerKt__NavHostController_androidKt(Context context) {
        context.getClass();
        NavHostController navHostController = new NavHostController(context);
        NavControllerImpl navControllerImpl = navHostController.impl;
        NavigatorProvider navigatorProvider = navControllerImpl._navigatorProvider;
        navigatorProvider.addNavigator(new ComposeNavGraphNavigator(navigatorProvider));
        NavigatorProvider navigatorProvider2 = navControllerImpl._navigatorProvider;
        navigatorProvider2.addNavigator(new ComposeNavigator());
        navigatorProvider2.addNavigator(new DialogNavigator());
        return navHostController;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static long divide(long j, long j2, RoundingMode roundingMode) {
        roundingMode.getClass();
        long j3 = j / j2;
        long j4 = j - (j2 * j3);
        if (j4 == 0) {
            return j3;
        }
        int i = ((int) ((j ^ j2) >> 63)) | 1;
        switch (LongMath$1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                FileSystemsKt.checkRoundingUnnecessary(j4 == 0);
                return j3;
            case 2:
                return j3;
            case 3:
                if (i >= 0) {
                    return j3;
                }
                return j3 + ((long) i);
            case 4:
                return j3 + ((long) i);
            case 5:
                if (i <= 0) {
                    return j3;
                }
                return j3 + ((long) i);
            case 6:
            case 7:
            case 8:
                long jAbs = Math.abs(j4);
                long jAbs2 = jAbs - (Math.abs(j2) - jAbs);
                if (jAbs2 == 0) {
                    if (roundingMode != RoundingMode.HALF_UP && (roundingMode != RoundingMode.HALF_EVEN || (1 & j3) == 0)) {
                        return j3;
                    }
                } else if (jAbs2 <= 0) {
                    return j3;
                }
                return j3 + ((long) i);
            default:
                throw new AssertionError();
        }
    }

    /* JADX INFO: renamed from: dot-Cue6Qto, reason: not valid java name */
    public static final float[] m1874dotCue6Qto(float f, float f2, float f3, float[] fArr) {
        return new float[]{(fArr[2] * f3) + (fArr[1] * f2) + (fArr[0] * f), (fArr[5] * f3) + (fArr[4] * f2) + (fArr[3] * f), (fArr[8] * f3) + (fArr[7] * f2) + (fArr[6] * f)};
    }

    /* JADX INFO: renamed from: dotDiagonal-Cue6Qto, reason: not valid java name */
    public static final float[] m1875dotDiagonalCue6Qto(float f, float f2, float f3, float[] fArr) {
        fArr.getClass();
        return new float[]{fArr[0] * f, fArr[1] * f2, fArr[2] * f3, fArr[3] * f, fArr[4] * f2, fArr[5] * f3, fArr[6] * f, fArr[7] * f2, fArr[8] * f3};
    }

    public static final float dot_sRJ3GRI$f(int i, int i2, float[] fArr, float[] fArr2) {
        int i3 = i2 * 3;
        return (fArr[i3 + 2] * fArr2[6 + i]) + (fArr[i3 + 1] * fArr2[3 + i]) + (fArr2[i] * fArr[i3]);
    }

    public static final Object execSQL(PooledConnection pooledConnection, String str, ContinuationImpl continuationImpl) {
        Object objUsePrepared = pooledConnection.usePrepared(str, new RoomDatabase$$ExternalSyntheticLambda2((byte) 18), continuationImpl);
        return objUsePrepared == CoroutineSingletons.COROUTINE_SUSPENDED ? objUsePrepared : Unit.INSTANCE;
    }

    public static MediaDrmCallback$Response executePost(DataSource dataSource, String str, byte[] bArr, Map map) throws Throwable {
        Throwable th;
        Map map2;
        List list;
        StatsDataSource statsDataSource = new StatsDataSource(dataSource);
        Map map3 = Collections.EMPTY_MAP;
        Uri uri = Uri.parse(str);
        UtilsKt.checkNotNull(uri, "The uri must be set.");
        DataSpec dataSpec = new DataSpec(uri, 0L, 2, bArr, map, 0L, -1L, null, 1);
        int i = 0;
        DataSpec dataSpecBuild = dataSpec;
        while (true) {
            try {
                DataSourceInputStream dataSourceInputStream = new DataSourceInputStream(statsDataSource, dataSpecBuild);
                try {
                    byte[] byteArray = ByteStreams.toByteArray(dataSourceInputStream);
                    DataSpec dataSpec2 = dataSpec;
                    try {
                        LoadEventInfo loadEventInfo = new LoadEventInfo(dataSpec2, statsDataSource.lastOpenedUri, statsDataSource.lastResponseHeaders, SystemClock.elapsedRealtime(), byteArray.length);
                        CallbackWrapper callbackWrapper = new CallbackWrapper((byte) 21, (Object) byteArray);
                        callbackWrapper.mExecutor = loadEventInfo;
                        MediaDrmCallback$Response mediaDrmCallback$Response = new MediaDrmCallback$Response(callbackWrapper);
                        Util.closeQuietly(dataSourceInputStream);
                        return mediaDrmCallback$Response;
                    } catch (HttpDataSource$InvalidResponseCodeException e) {
                        e = e;
                        dataSpec = dataSpec2;
                        try {
                            int i2 = e.responseCode;
                            String str2 = null;
                            if ((i2 == 307 || i2 == 308) && i < 5 && (map2 = e.headerFields) != null && (list = (List) map2.get(HttpHeaders.Location)) != null && !list.isEmpty()) {
                                str2 = (String) list.get(0);
                            }
                            if (str2 == null) {
                                throw e;
                            }
                            i++;
                            DataSpec.Builder builderBuildUpon = dataSpecBuild.buildUpon();
                            builderBuildUpon.uri = Uri.parse(str2);
                            dataSpecBuild = builderBuildUpon.build();
                            Util.closeQuietly(dataSourceInputStream);
                        } catch (Throwable th2) {
                            th = th2;
                            Throwable th3 = th;
                            Util.closeQuietly(dataSourceInputStream);
                            throw th3;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        Throwable th5 = th;
                        Util.closeQuietly(dataSourceInputStream);
                        throw th5;
                    }
                } catch (HttpDataSource$InvalidResponseCodeException e2) {
                    e = e2;
                }
                Util.closeQuietly(dataSourceInputStream);
            } catch (Exception e3) {
                throw new MediaDrmCallbackException(dataSpec, statsDataSource.lastOpenedUri, statsDataSource.dataSource.getResponseHeaders(), statsDataSource.bytesRead, e3);
            }
        }
    }

    public static long gcd(long j, long j2) {
        FileSystemsKt.checkNonNegative(j, "a");
        FileSystemsKt.checkNonNegative(j2, "b");
        if (j == 0) {
            return j2;
        }
        if (j2 == 0) {
            return j;
        }
        int iNumberOfTrailingZeros = Long.numberOfTrailingZeros(j);
        long jNumberOfTrailingZeros = j >> iNumberOfTrailingZeros;
        int iNumberOfTrailingZeros2 = Long.numberOfTrailingZeros(j2);
        long j3 = j2 >> iNumberOfTrailingZeros2;
        while (jNumberOfTrailingZeros != j3) {
            long j4 = jNumberOfTrailingZeros - j3;
            long j5 = (j4 >> 63) & j4;
            long j6 = (j4 - j5) - j5;
            j3 += j5;
            jNumberOfTrailingZeros = j6 >> Long.numberOfTrailingZeros(j6);
        }
        return jNumberOfTrailingZeros << Math.min(iNumberOfTrailingZeros, iNumberOfTrailingZeros2);
    }

    public static final String[] getContentHints(ContentType contentType) {
        contentType.getClass();
        return (String[]) ((AndroidContentType) contentType).androidAutofillHints.toArray(new String[0]);
    }

    public static NavControllerViewModel getInstance(ViewModelStore viewModelStore) {
        InitializerViewModelFactory initializerViewModelFactory = NavControllerViewModelKt.FACTORY;
        CreationExtras.Empty empty = CreationExtras.Empty.INSTANCE;
        initializerViewModelFactory.getClass();
        empty.getClass();
        Dispatcher dispatcher = new Dispatcher(viewModelStore, initializerViewModelFactory, empty);
        ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(NavControllerViewModel.class);
        String qualifiedName = orCreateKotlinClass.getQualifiedName();
        if (qualifiedName != null) {
            return (NavControllerViewModel) dispatcher.getViewModel$lifecycle_viewmodel(orCreateKotlinClass, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(qualifiedName));
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Local and anonymous classes can not be ViewModels");
        return null;
    }

    /* JADX INFO: renamed from: getInt-impl, reason: not valid java name */
    public static final int m1876getIntimpl(String str, Bundle bundle) {
        int i = bundle.getInt(str, Integer.MIN_VALUE);
        if (i != Integer.MIN_VALUE || bundle.getInt(str, Integer.MAX_VALUE) != Integer.MAX_VALUE) {
            return i;
        }
        FileSystemsKt.keyOrValueNotFoundError(str);
        throw null;
    }

    public static final PoolingContainerListenerHolder getPoolingContainerListenerHolder(View view) {
        PoolingContainerListenerHolder poolingContainerListenerHolder = (PoolingContainerListenerHolder) view.getTag(R.id.pooling_container_listener_holder_tag);
        if (poolingContainerListenerHolder != null) {
            return poolingContainerListenerHolder;
        }
        PoolingContainerListenerHolder poolingContainerListenerHolder2 = new PoolingContainerListenerHolder();
        view.setTag(R.id.pooling_container_listener_holder_tag, poolingContainerListenerHolder2);
        return poolingContainerListenerHolder2;
    }

    /* JADX INFO: renamed from: getSavedStateList-impl, reason: not valid java name */
    public static final ArrayList m1877getSavedStateListimpl(String str, Bundle bundle) {
        ArrayList parcelableArrayList = Build.VERSION.SDK_INT >= 34 ? BundleCompat$Api33Impl.getParcelableArrayList(bundle, str, Okio__OkioKt.getJavaClass(Reflection.getOrCreateKotlinClass(Bundle.class))) : bundle.getParcelableArrayList(str);
        if (parcelableArrayList != null) {
            return parcelableArrayList;
        }
        FileSystemsKt.keyOrValueNotFoundError(str);
        throw null;
    }

    public static final int getTotalChangedRows(SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT changes()");
        try {
            sQLiteStatementPrepare.step();
            int i = (int) sQLiteStatementPrepare.getLong(0);
            StringsKt__IndentKt.closeFinally(sQLiteStatementPrepare, null);
            return i;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                StringsKt__IndentKt.closeFinally(sQLiteStatementPrepare, th);
                throw th2;
            }
        }
    }

    public static final boolean hasLinks(AnnotatedString annotatedString) {
        int length = annotatedString.text.length();
        List list = annotatedString.annotations;
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                AnnotatedString.Range range = (AnnotatedString.Range) list.get(i);
                if ((range.item instanceof LinkAnnotation) && AnnotatedStringKt.intersect(0, length, range.start, range.end)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static final int indexSegment(int i, int i2) {
        return (i >> i2) & 31;
    }

    /* JADX INFO: renamed from: inverse-M2Qqt3Q$default, reason: not valid java name */
    public static float[] m1878inverseM2Qqt3Q$default(float[] fArr) {
        double d = fArr[0];
        double d2 = fArr[1];
        double d3 = fArr[2];
        double d4 = fArr[3];
        double d5 = fArr[4];
        double d6 = fArr[5];
        double d7 = fArr[6];
        double d8 = fArr[7];
        double d9 = fArr[8];
        double d10 = (d5 * d9) - (d8 * d6);
        double d11 = (d8 * d3) - (d2 * d9);
        double d12 = (d2 * d6) - (d5 * d3);
        double d13 = (d7 * d12) + (d4 * d11) + (d * d10);
        float[] fArrCopyOf = Arrays.copyOf(fArr, fArr.length);
        fArrCopyOf[0] = (float) (d10 / d13);
        fArrCopyOf[3] = (float) IntIntPair$$ExternalSyntheticOutline0.m(d4, d9, d7 * d6, d13);
        fArrCopyOf[6] = (float) IntIntPair$$ExternalSyntheticOutline0.m(d7, d5, d4 * d8, d13);
        fArrCopyOf[1] = (float) (d11 / d13);
        fArrCopyOf[4] = (float) IntIntPair$$ExternalSyntheticOutline0.m(d7, d3, d * d9, d13);
        fArrCopyOf[7] = (float) IntIntPair$$ExternalSyntheticOutline0.m(d, d8, d7 * d2, d13);
        fArrCopyOf[2] = (float) (d12 / d13);
        fArrCopyOf[5] = (float) IntIntPair$$ExternalSyntheticOutline0.m(d, d6, d4 * d3, d13);
        fArrCopyOf[8] = (float) IntIntPair$$ExternalSyntheticOutline0.m(d4, d2, d * d5, d13);
        return fArrCopyOf;
    }

    public static boolean isFailureToConstructNotProvisionedException(Throwable th) {
        return Build.VERSION.SDK_INT == 34 && (th instanceof NoSuchMethodError) && th.getMessage() != null && th.getMessage().contains("Landroid/media/NotProvisionedException;.<init>(");
    }

    public static boolean isFailureToConstructResourceBusyException(Throwable th) {
        return Build.VERSION.SDK_INT == 34 && (th instanceof NoSuchMethodError) && th.getMessage() != null && th.getMessage().contains("Landroid/media/ResourceBusyException;.<init>(");
    }

    /* JADX INFO: renamed from: isNull-impl, reason: not valid java name */
    public static final boolean m1879isNullimpl(String str, Bundle bundle) {
        str.getClass();
        return bundle.containsKey(str) && bundle.get(str) == null;
    }

    public static final boolean isSelectionHandleInVisibleBoundDefault(TextFieldSelectionManager textFieldSelectionManager, boolean z) {
        LayoutCoordinates layoutCoordinates;
        LegacyTextFieldState legacyTextFieldState = textFieldSelectionManager.state;
        if (legacyTextFieldState == null || (layoutCoordinates = legacyTextFieldState.getLayoutCoordinates()) == null) {
            return false;
        }
        androidx.compose.ui.geometry.Rect rectVisibleBounds = SizeKt.visibleBounds(layoutCoordinates);
        long jM233getHandlePositiontuRUvjQ$foundation = textFieldSelectionManager.m233getHandlePositiontuRUvjQ$foundation(z);
        float f = rectVisibleBounds.left;
        float f2 = rectVisibleBounds.right;
        float fIntBitsToFloat = Float.intBitsToFloat((int) (jM233getHandlePositiontuRUvjQ$foundation >> 32));
        if (f > fIntBitsToFloat || fIntBitsToFloat > f2) {
            return false;
        }
        float f3 = rectVisibleBounds.top;
        float f4 = rectVisibleBounds.bottom;
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (jM233getHandlePositiontuRUvjQ$foundation & 4294967295L));
        return f3 <= fIntBitsToFloat2 && fIntBitsToFloat2 <= f4;
    }

    public static final boolean isSimple(RoundRect roundRect) {
        long j = roundRect.topLeftCornerRadius;
        return (j >>> 32) == (4294967295L & j) && j == roundRect.topRightCornerRadius && j == roundRect.bottomRightCornerRadius && j == roundRect.bottomLeftCornerRadius;
    }

    public static final String pluralStringResource(int i, int i2, Object[] objArr, Composer composer) {
        return ((Resources) ((GapComposer) composer).consume(AndroidCompositionLocals_androidKt.LocalResources)).getQuantityString(i, i2, Arrays.copyOf(objArr, objArr.length));
    }

    public static MetadataList read(MappedByteBuffer mappedByteBuffer) throws IOException {
        long j;
        ByteBuffer byteBufferDuplicate = mappedByteBuffer.duplicate();
        byteBufferDuplicate.order(ByteOrder.BIG_ENDIAN);
        byteBufferDuplicate.position(byteBufferDuplicate.position() + 4);
        int i = byteBufferDuplicate.getShort() & 65535;
        if (i > 100) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$3("Cannot read metadata.");
            return null;
        }
        byteBufferDuplicate.position(byteBufferDuplicate.position() + 6);
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                j = -1;
                break;
            }
            int i3 = byteBufferDuplicate.getInt();
            byteBufferDuplicate.position(byteBufferDuplicate.position() + 4);
            j = ((long) byteBufferDuplicate.getInt()) & 4294967295L;
            byteBufferDuplicate.position(byteBufferDuplicate.position() + 4);
            if (1835365473 == i3) {
                break;
            }
            i2++;
        }
        if (j != -1) {
            byteBufferDuplicate.position(byteBufferDuplicate.position() + ((int) (j - ((long) byteBufferDuplicate.position()))));
            byteBufferDuplicate.position(byteBufferDuplicate.position() + 12);
            long j2 = ((long) byteBufferDuplicate.getInt()) & 4294967295L;
            for (int i4 = 0; i4 < j2; i4++) {
                int i5 = byteBufferDuplicate.getInt();
                long j3 = ((long) byteBufferDuplicate.getInt()) & 4294967295L;
                byteBufferDuplicate.getInt();
                if (1164798569 == i5 || 1701669481 == i5) {
                    byteBufferDuplicate.position((int) (j3 + j));
                    MetadataList metadataList = new MetadataList();
                    byteBufferDuplicate.order(ByteOrder.LITTLE_ENDIAN);
                    int iPosition = byteBufferDuplicate.position() + byteBufferDuplicate.getInt(byteBufferDuplicate.position());
                    metadataList.bb = byteBufferDuplicate;
                    metadataList.bb_pos = iPosition;
                    int i6 = iPosition - byteBufferDuplicate.getInt(iPosition);
                    metadataList.vtable_start = i6;
                    metadataList.vtable_size = ((ByteBuffer) metadataList.bb).getShort(i6);
                    return metadataList;
                }
            }
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$3("Cannot read metadata.");
        return null;
    }

    public static long readPcrFromPacket(ParsableByteArray parsableByteArray, int i, int i2) {
        parsableByteArray.setPosition(i);
        if (parsableByteArray.bytesLeft() < 5) {
            return -9223372036854775807L;
        }
        int i3 = parsableByteArray.readInt();
        if ((8388608 & i3) != 0 || ((2096896 & i3) >> 8) != i2 || (i3 & 32) == 0 || parsableByteArray.readUnsignedByte() < 7 || parsableByteArray.bytesLeft() < 7 || (parsableByteArray.readUnsignedByte() & 16) != 16) {
            return -9223372036854775807L;
        }
        byte[] bArr = new byte[6];
        parsableByteArray.readBytes(bArr, 0, 6);
        return ((((long) bArr[0]) & 255) << 25) | ((((long) bArr[1]) & 255) << 17) | ((((long) bArr[2]) & 255) << 9) | ((((long) bArr[3]) & 255) << 1) | ((((long) bArr[4]) & 255) >> 7);
    }

    public static final ViewModelProvider$Factory rememberHiltViewModelFactory(ViewModelProvider$Factory viewModelProvider$Factory, Composer composer) {
        GapComposer gapComposer = (GapComposer) composer;
        Context baseContext = (Context) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalContext);
        boolean zChanged = gapComposer.changed(baseContext) | gapComposer.changed(viewModelProvider$Factory);
        Object objRememberedValue = gapComposer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.Empty) {
            baseContext.getClass();
            viewModelProvider$Factory.getClass();
            while (baseContext instanceof ContextWrapper) {
                if (baseContext instanceof ComponentActivity) {
                    objRememberedValue = HiltViewModelFactory.createInternal((ComponentActivity) baseContext, viewModelProvider$Factory);
                    gapComposer.updateRememberedValue(objRememberedValue);
                } else {
                    baseContext = ((ContextWrapper) baseContext).getBaseContext();
                    baseContext.getClass();
                }
            }
            PathKt$$ExternalSyntheticBUOutline0.m$1(baseContext, "Expected an activity context for creating a HiltViewModelFactory but instead found: ");
            return null;
        }
        return (ViewModelProvider$Factory) objRememberedValue;
    }

    public static int roundToInt(double d) {
        if (Double.isNaN(d)) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Cannot round NaN value.");
            return 0;
        }
        if (d > 2.147483647E9d) {
            return Integer.MAX_VALUE;
        }
        if (d < -2.147483648E9d) {
            return Integer.MIN_VALUE;
        }
        return (int) Math.round(d);
    }

    public static long roundToLong(double d) {
        if (!Double.isNaN(d)) {
            return Math.round(d);
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Cannot round NaN value.");
        return 0L;
    }

    public static long saturatedMultiply(long j, long j2) {
        int iNumberOfLeadingZeros = Long.numberOfLeadingZeros(~j2) + Long.numberOfLeadingZeros(j2) + Long.numberOfLeadingZeros(~j) + Long.numberOfLeadingZeros(j);
        if (iNumberOfLeadingZeros > 65) {
            return j * j2;
        }
        long j3 = ((j ^ j2) >>> 63) + Long.MAX_VALUE;
        if (!((iNumberOfLeadingZeros < 64) | ((j2 == Long.MIN_VALUE) & (j < 0)))) {
            long j4 = j * j2;
            if (j == 0 || j4 / j == j2) {
                return j4;
            }
        }
        return j3;
    }

    public static void setDecorFitsSystemWindows(Window window, boolean z) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 35) {
            window.setDecorFitsSystemWindows(z);
        } else {
            if (i >= 30) {
                BuildCompat.Api30Impl.setDecorFitsSystemWindows(window, z);
                return;
            }
            View decorView = window.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            decorView.setSystemUiVisibility(z ? systemUiVisibility & (-1793) : systemUiVisibility | 1792);
        }
    }

    public static final String stringResource(int i, Object[] objArr, Composer composer) {
        return ((Resources) ((GapComposer) composer).consume(AndroidCompositionLocals_androidKt.LocalResources)).getString(i, Arrays.copyOf(objArr, objArr.length));
    }

    public static Bitmap toBitmap$default(Drawable drawable, int i) {
        int intrinsicWidth = (i & 1) != 0 ? drawable.getIntrinsicWidth() : 168;
        int intrinsicHeight = (i & 2) != 0 ? drawable.getIntrinsicHeight() : 168;
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() != null) {
                return (intrinsicWidth == bitmapDrawable.getBitmap().getWidth() && intrinsicHeight == bitmapDrawable.getBitmap().getHeight()) ? bitmapDrawable.getBitmap() : Bitmap.createScaledBitmap(bitmapDrawable.getBitmap(), intrinsicWidth, intrinsicHeight, true);
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("bitmap is null");
            return null;
        }
        Rect bounds = drawable.getBounds();
        int i2 = bounds.left;
        int i3 = bounds.top;
        int i4 = bounds.right;
        int i5 = bounds.bottom;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(new Canvas(bitmapCreateBitmap));
        drawable.setBounds(i2, i3, i4, i5);
        return bitmapCreateBitmap;
    }

    public static final String stringResource(int i, Composer composer) {
        return ((Resources) ((GapComposer) composer).consume(AndroidCompositionLocals_androidKt.LocalResources)).getString(i);
    }

    public static int roundToInt(float f) {
        if (!Float.isNaN(f)) {
            return Math.round(f);
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Cannot round NaN value.");
        return 0;
    }
}
