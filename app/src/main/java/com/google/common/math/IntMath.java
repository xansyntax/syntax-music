package com.google.common.math;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.icu.text.DecimalFormatSymbols;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.StrictMode;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import android.view.ActionMode;
import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.collection.ArrayMap;
import androidx.collection.FloatFloatPair;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterMapKt;
import androidx.compose.animation.SplineBasedFloatDecayAnimationSpec_androidKt;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.DecayAnimationSpecImpl;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect;
import androidx.compose.foundation.OverscrollKt;
import androidx.compose.foundation.gestures.AnchoredDraggableKt$AnchoredDraggableLayoutInfoProvider$1;
import androidx.compose.foundation.gestures.DefaultFlingBehavior;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.snapping.SnapFlingBehavior;
import androidx.compose.foundation.layout.Arrangement$Horizontal;
import androidx.compose.foundation.layout.Arrangement$Vertical;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.pager.PagerSnapDistanceMaxPages;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.foundation.text.selection.SimpleLayoutKt$SimpleLayout$1$1;
import androidx.compose.material3.AlertDialogKt$$ExternalSyntheticLambda2;
import androidx.compose.material3.SliderKt$$ExternalSyntheticLambda4;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.runtime.snapshots.SnapshotDoubleIndexHeap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidImageBitmap;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.BrushKt$ShaderBrush$1;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.painter.BitmapPainter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.PathParser;
import androidx.compose.ui.graphics.vector.PathParserKt;
import androidx.compose.ui.graphics.vector.VectorGroup;
import androidx.compose.ui.graphics.vector.VectorPainter;
import androidx.compose.ui.graphics.vector.VectorPath;
import androidx.compose.ui.graphics.vector.compat.AndroidVectorResources;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.ImageVectorCache;
import androidx.compose.ui.res.ResourceIdCache;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.ResourceFont;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.InlineClassHelperKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.content.res.CamUtils;
import androidx.core.content.res.ColorStateListInflaterCompat;
import androidx.core.os.HandlerCompat$Api28Impl;
import androidx.core.text.PrecomputedTextCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.widget.TextViewCompat$OreoCallback;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.graphics.shapes.CornerRounding;
import androidx.graphics.shapes.RoundedPolygon;
import androidx.graphics.shapes.Utils;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.exoplayer.ExoPlayerImpl;
import androidx.media3.extractor.VorbisBitArray;
import androidx.navigation.NavArgument;
import androidx.navigation.NavHostController;
import androidx.room.RoomDatabase;
import androidx.room.util.ViewInfo;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import coil3.network.HttpException;
import coil3.size.SizeKt;
import coil3.util.FileSystemsKt;
import coil3.util.UtilsKt;
import com.metrolist.music.db.DatabaseDao_Impl;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.ui.menu.AlbumMenuKt$$ExternalSyntheticLambda11;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.websocket.WebSocketDeflateExtensionKt;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.math.RoundingMode;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptyMap;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__IndentKt;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.flow.ReadonlySharedFlow;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Path$$ExternalSyntheticBUOutline0;
import okio.PriorityQueue;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class IntMath implements ViewPropertyAnimatorListener {

    /* JADX INFO: renamed from: com.google.common.math.IntMath$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public abstract /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$java$math$RoundingMode;

        static {
            int[] iArr = new int[RoundingMode.values().length];
            $SwitchMap$java$math$RoundingMode = iArr;
            try {
                iArr[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.FLOOR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.UP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.CEILING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_DOWN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_EVEN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x012a  */
    /* JADX WARN: Code duplicated, block: B:103:0x0141  */
    /* JADX WARN: Code duplicated, block: B:105:0x0145  */
    /* JADX WARN: Code duplicated, block: B:108:0x0152  */
    /* JADX WARN: Code duplicated, block: B:111:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:114:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:116:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x0068  */
    /* JADX WARN: Code duplicated, block: B:39:0x006c  */
    /* JADX WARN: Code duplicated, block: B:41:0x0074  */
    /* JADX WARN: Code duplicated, block: B:42:0x0077  */
    /* JADX WARN: Code duplicated, block: B:45:0x007d  */
    /* JADX WARN: Code duplicated, block: B:48:0x0087  */
    /* JADX WARN: Code duplicated, block: B:51:0x0090  */
    /* JADX WARN: Code duplicated, block: B:53:0x0094  */
    /* JADX WARN: Code duplicated, block: B:55:0x0097  */
    /* JADX WARN: Code duplicated, block: B:57:0x009f  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:62:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:67:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:68:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:73:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:74:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:77:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:90:0x010c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:91:0x010e  */
    /* JADX WARN: Code duplicated, block: B:92:0x0111  */
    /* JADX WARN: Code duplicated, block: B:95:0x0116  */
    /* JADX WARN: Code duplicated, block: B:97:0x011f  */
    public static final void LazyColumn(Modifier modifier, LazyListState lazyListState, PaddingValues paddingValues, Arrangement$Vertical arrangement$Vertical, Alignment.Horizontal horizontal, FlingBehavior flingBehavior, boolean z, AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect, Function1 function1, Composer composer, int i, int i2) {
        Modifier modifier2;
        int i3;
        LazyListState lazyListStateRememberLazyListState;
        PaddingValues paddingValuesImpl;
        int i4;
        Arrangement$Vertical arrangement$Vertical2;
        int i5;
        int i6;
        boolean z2;
        int i7;
        Function1 function2;
        boolean z3;
        GapComposer gapComposer;
        Alignment.Horizontal horizontal2;
        AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect2;
        Modifier modifier3;
        LazyListState lazyListState2;
        PaddingValues paddingValues2;
        Arrangement$Vertical arrangement$Vertical3;
        boolean z4;
        FlingBehavior flingBehavior2;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        DecayAnimationSpecImpl decayAnimationSpecImplRememberSplineBasedDecay;
        boolean zChanged;
        Object objRememberedValue;
        int i8;
        Alignment.Horizontal horizontal3;
        AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffectRememberOverscrollEffect;
        FlingBehavior flingBehavior3;
        int i9;
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(53695811);
        int i10 = i2 & 1;
        if (i10 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (gapComposer2.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                lazyListStateRememberLazyListState = lazyListState;
                int i11 = gapComposer2.changed(lazyListStateRememberLazyListState) ? 32 : 16;
                i3 |= i11;
            } else {
                lazyListStateRememberLazyListState = lazyListState;
            }
            i3 |= i11;
        } else {
            lazyListStateRememberLazyListState = lazyListState;
        }
        int i12 = i2 & 4;
        if (i12 == 0) {
            if ((i & 384) == 0) {
                paddingValuesImpl = paddingValues;
                i3 |= gapComposer2.changed(paddingValuesImpl) ? 256 : 128;
            }
            i4 = i3 | 3072;
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    arrangement$Vertical2 = arrangement$Vertical;
                    int i13 = gapComposer2.changed(arrangement$Vertical2) ? 16384 : 8192;
                    i4 |= i13;
                } else {
                    arrangement$Vertical2 = arrangement$Vertical;
                }
                i4 |= i13;
            } else {
                arrangement$Vertical2 = arrangement$Vertical;
            }
            i5 = 196608 | i4;
            if ((1572864 & i) == 0) {
                i5 = 720896 | i4;
            }
            i6 = i2 & 128;
            if (i6 != 0) {
                if ((12582912 & i) == 0) {
                    z2 = z;
                    if (gapComposer2.changed(z2)) {
                        i7 = 8388608;
                    } else {
                        i7 = 4194304;
                    }
                    i5 |= i7;
                }
                if ((100663296 & i) == 0) {
                    i5 |= 33554432;
                }
                if ((805306368 & i) == 0) {
                    function2 = function1;
                    if (gapComposer2.changedInstance(function2)) {
                        i9 = 536870912;
                    } else {
                        i9 = WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
                    }
                    i5 |= i9;
                } else {
                    function2 = function1;
                }
                if ((306783379 & i5) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (gapComposer2.shouldExecute(i5 & 1, z3)) {
                    gapComposer2.startDefaults();
                    if ((i & 1) != 0 || gapComposer2.getDefaultsInvalid()) {
                        if (i10 != 0) {
                            modifier3 = Modifier.Companion.$$INSTANCE;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 2) != 0) {
                            i5 &= -113;
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(gapComposer2);
                        }
                        if (i12 != 0) {
                            paddingValuesImpl = new PaddingValuesImpl(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO);
                        }
                        if ((i2 & 16) != 0) {
                            i5 &= -57345;
                            arrangement$Vertical2 = OffsetKt.Top;
                        }
                        BiasAlignment.Horizontal horizontal4 = Alignment.Companion.Start;
                        decayAnimationSpecImplRememberSplineBasedDecay = SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay(gapComposer2);
                        zChanged = gapComposer2.changed(decayAnimationSpecImplRememberSplineBasedDecay);
                        objRememberedValue = gapComposer2.rememberedValue();
                        if (zChanged || objRememberedValue == Composer.Companion.Empty) {
                            objRememberedValue = new DefaultFlingBehavior(decayAnimationSpecImplRememberSplineBasedDecay);
                            gapComposer2.updateRememberedValue(objRememberedValue);
                        }
                        DefaultFlingBehavior defaultFlingBehavior = (DefaultFlingBehavior) objRememberedValue;
                        if (i6 != 0) {
                            z2 = true;
                        }
                        i8 = i5 & (-238551041);
                        horizontal3 = horizontal4;
                        androidEdgeEffectOverscrollEffectRememberOverscrollEffect = OverscrollKt.rememberOverscrollEffect(gapComposer2);
                        flingBehavior3 = defaultFlingBehavior;
                    } else {
                        gapComposer2.skipToGroupEnd();
                        if ((i2 & 2) != 0) {
                            i5 &= -113;
                        }
                        if ((i2 & 16) != 0) {
                            i5 &= -57345;
                        }
                        horizontal3 = horizontal;
                        flingBehavior3 = flingBehavior;
                        androidEdgeEffectOverscrollEffectRememberOverscrollEffect = androidEdgeEffectOverscrollEffect;
                        i8 = i5 & (-238551041);
                        modifier3 = modifier2;
                    }
                    LazyListState lazyListState3 = lazyListStateRememberLazyListState;
                    PaddingValues paddingValues3 = paddingValuesImpl;
                    Arrangement$Vertical arrangement$Vertical4 = arrangement$Vertical2;
                    boolean z5 = z2;
                    gapComposer2.endDefaults();
                    gapComposer = gapComposer2;
                    MathKt.LazyList(modifier3, lazyListState3, paddingValues3, true, flingBehavior3, z5, androidEdgeEffectOverscrollEffectRememberOverscrollEffect, horizontal3, arrangement$Vertical4, null, null, function2, gapComposer, (i8 & 14) | 24576 | (i8 & 112) | (i8 & 896) | (i8 & 7168) | ((i8 >> 3) & 3670016) | ((i8 << 12) & 1879048192), ((i8 >> 12) & 14) | ((i8 >> 18) & 7168), 6400);
                    lazyListState2 = lazyListState3;
                    paddingValues2 = paddingValues3;
                    flingBehavior2 = flingBehavior3;
                    z4 = z5;
                    androidEdgeEffectOverscrollEffect2 = androidEdgeEffectOverscrollEffectRememberOverscrollEffect;
                    horizontal2 = horizontal3;
                    arrangement$Vertical3 = arrangement$Vertical4;
                } else {
                    gapComposer = gapComposer2;
                    gapComposer.skipToGroupEnd();
                    horizontal2 = horizontal;
                    androidEdgeEffectOverscrollEffect2 = androidEdgeEffectOverscrollEffect;
                    modifier3 = modifier2;
                    lazyListState2 = lazyListStateRememberLazyListState;
                    paddingValues2 = paddingValuesImpl;
                    arrangement$Vertical3 = arrangement$Vertical2;
                    z4 = z2;
                    flingBehavior2 = flingBehavior;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new SliderKt$$ExternalSyntheticLambda4(modifier3, lazyListState2, paddingValues2, arrangement$Vertical3, horizontal2, flingBehavior2, z4, androidEdgeEffectOverscrollEffect2, function1, i, i2, (byte) 2);
                }
            }
            i5 |= 12582912;
            z2 = z;
            if ((100663296 & i) == 0) {
                i5 |= 33554432;
            }
            if ((805306368 & i) == 0) {
                function2 = function1;
                if (gapComposer2.changedInstance(function2)) {
                    i9 = 536870912;
                } else {
                    i9 = WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
                }
                i5 |= i9;
            } else {
                function2 = function1;
            }
            if ((306783379 & i5) != 306783378) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (gapComposer2.shouldExecute(i5 & 1, z3)) {
                gapComposer2.startDefaults();
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        modifier3 = Modifier.Companion.$$INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        i5 &= -113;
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(gapComposer2);
                    }
                    if (i12 != 0) {
                        paddingValuesImpl = new PaddingValuesImpl(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO);
                    }
                    if ((i2 & 16) != 0) {
                        i5 &= -57345;
                        arrangement$Vertical2 = OffsetKt.Top;
                    }
                    BiasAlignment.Horizontal horizontal5 = Alignment.Companion.Start;
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
                    DefaultFlingBehavior defaultFlingBehavior2 = (DefaultFlingBehavior) objRememberedValue;
                    if (i6 != 0) {
                        z2 = true;
                    }
                    i8 = i5 & (-238551041);
                    horizontal3 = horizontal5;
                    androidEdgeEffectOverscrollEffectRememberOverscrollEffect = OverscrollKt.rememberOverscrollEffect(gapComposer2);
                    flingBehavior3 = defaultFlingBehavior2;
                } else {
                    if (i10 != 0) {
                        modifier3 = Modifier.Companion.$$INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        i5 &= -113;
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(gapComposer2);
                    }
                    if (i12 != 0) {
                        paddingValuesImpl = new PaddingValuesImpl(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO);
                    }
                    if ((i2 & 16) != 0) {
                        i5 &= -57345;
                        arrangement$Vertical2 = OffsetKt.Top;
                    }
                    BiasAlignment.Horizontal horizontal6 = Alignment.Companion.Start;
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
                    DefaultFlingBehavior defaultFlingBehavior3 = (DefaultFlingBehavior) objRememberedValue;
                    if (i6 != 0) {
                        z2 = true;
                    }
                    i8 = i5 & (-238551041);
                    horizontal3 = horizontal6;
                    androidEdgeEffectOverscrollEffectRememberOverscrollEffect = OverscrollKt.rememberOverscrollEffect(gapComposer2);
                    flingBehavior3 = defaultFlingBehavior3;
                }
                LazyListState lazyListState4 = lazyListStateRememberLazyListState;
                PaddingValues paddingValues4 = paddingValuesImpl;
                Arrangement$Vertical arrangement$Vertical5 = arrangement$Vertical2;
                boolean z6 = z2;
                gapComposer2.endDefaults();
                gapComposer = gapComposer2;
                MathKt.LazyList(modifier3, lazyListState4, paddingValues4, true, flingBehavior3, z6, androidEdgeEffectOverscrollEffectRememberOverscrollEffect, horizontal3, arrangement$Vertical5, null, null, function2, gapComposer, (i8 & 14) | 24576 | (i8 & 112) | (i8 & 896) | (i8 & 7168) | ((i8 >> 3) & 3670016) | ((i8 << 12) & 1879048192), ((i8 >> 12) & 14) | ((i8 >> 18) & 7168), 6400);
                lazyListState2 = lazyListState4;
                paddingValues2 = paddingValues4;
                flingBehavior2 = flingBehavior3;
                z4 = z6;
                androidEdgeEffectOverscrollEffect2 = androidEdgeEffectOverscrollEffectRememberOverscrollEffect;
                horizontal2 = horizontal3;
                arrangement$Vertical3 = arrangement$Vertical5;
            } else {
                gapComposer = gapComposer2;
                gapComposer.skipToGroupEnd();
                horizontal2 = horizontal;
                androidEdgeEffectOverscrollEffect2 = androidEdgeEffectOverscrollEffect;
                modifier3 = modifier2;
                lazyListState2 = lazyListStateRememberLazyListState;
                paddingValues2 = paddingValuesImpl;
                arrangement$Vertical3 = arrangement$Vertical2;
                z4 = z2;
                flingBehavior2 = flingBehavior;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new SliderKt$$ExternalSyntheticLambda4(modifier3, lazyListState2, paddingValues2, arrangement$Vertical3, horizontal2, flingBehavior2, z4, androidEdgeEffectOverscrollEffect2, function1, i, i2, (byte) 2);
            }
        }
        i3 |= 384;
        paddingValuesImpl = paddingValues;
        i4 = i3 | 3072;
        if ((i & 24576) == 0) {
            if ((i2 & 16) == 0) {
                arrangement$Vertical2 = arrangement$Vertical;
                if (gapComposer2.changed(arrangement$Vertical2)) {
                }
                i4 |= i13;
            } else {
                arrangement$Vertical2 = arrangement$Vertical;
            }
            i4 |= i13;
        } else {
            arrangement$Vertical2 = arrangement$Vertical;
        }
        i5 = 196608 | i4;
        if ((1572864 & i) == 0) {
            i5 = 720896 | i4;
        }
        i6 = i2 & 128;
        if (i6 != 0) {
            if ((12582912 & i) == 0) {
                z2 = z;
                if (gapComposer2.changed(z2)) {
                    i7 = 8388608;
                } else {
                    i7 = 4194304;
                }
                i5 |= i7;
            }
            if ((100663296 & i) == 0) {
                i5 |= 33554432;
            }
            if ((805306368 & i) == 0) {
                function2 = function1;
                if (gapComposer2.changedInstance(function2)) {
                    i9 = 536870912;
                } else {
                    i9 = WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
                }
                i5 |= i9;
            } else {
                function2 = function1;
            }
            if ((306783379 & i5) != 306783378) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (gapComposer2.shouldExecute(i5 & 1, z3)) {
                gapComposer2.startDefaults();
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        modifier3 = Modifier.Companion.$$INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        i5 &= -113;
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(gapComposer2);
                    }
                    if (i12 != 0) {
                        paddingValuesImpl = new PaddingValuesImpl(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO);
                    }
                    if ((i2 & 16) != 0) {
                        i5 &= -57345;
                        arrangement$Vertical2 = OffsetKt.Top;
                    }
                    BiasAlignment.Horizontal horizontal7 = Alignment.Companion.Start;
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
                    DefaultFlingBehavior defaultFlingBehavior4 = (DefaultFlingBehavior) objRememberedValue;
                    if (i6 != 0) {
                        z2 = true;
                    }
                    i8 = i5 & (-238551041);
                    horizontal3 = horizontal7;
                    androidEdgeEffectOverscrollEffectRememberOverscrollEffect = OverscrollKt.rememberOverscrollEffect(gapComposer2);
                    flingBehavior3 = defaultFlingBehavior4;
                } else {
                    if (i10 != 0) {
                        modifier3 = Modifier.Companion.$$INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        i5 &= -113;
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(gapComposer2);
                    }
                    if (i12 != 0) {
                        paddingValuesImpl = new PaddingValuesImpl(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO);
                    }
                    if ((i2 & 16) != 0) {
                        i5 &= -57345;
                        arrangement$Vertical2 = OffsetKt.Top;
                    }
                    BiasAlignment.Horizontal horizontal8 = Alignment.Companion.Start;
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
                    DefaultFlingBehavior defaultFlingBehavior5 = (DefaultFlingBehavior) objRememberedValue;
                    if (i6 != 0) {
                        z2 = true;
                    }
                    i8 = i5 & (-238551041);
                    horizontal3 = horizontal8;
                    androidEdgeEffectOverscrollEffectRememberOverscrollEffect = OverscrollKt.rememberOverscrollEffect(gapComposer2);
                    flingBehavior3 = defaultFlingBehavior5;
                }
                LazyListState lazyListState5 = lazyListStateRememberLazyListState;
                PaddingValues paddingValues5 = paddingValuesImpl;
                Arrangement$Vertical arrangement$Vertical6 = arrangement$Vertical2;
                boolean z7 = z2;
                gapComposer2.endDefaults();
                gapComposer = gapComposer2;
                MathKt.LazyList(modifier3, lazyListState5, paddingValues5, true, flingBehavior3, z7, androidEdgeEffectOverscrollEffectRememberOverscrollEffect, horizontal3, arrangement$Vertical6, null, null, function2, gapComposer, (i8 & 14) | 24576 | (i8 & 112) | (i8 & 896) | (i8 & 7168) | ((i8 >> 3) & 3670016) | ((i8 << 12) & 1879048192), ((i8 >> 12) & 14) | ((i8 >> 18) & 7168), 6400);
                lazyListState2 = lazyListState5;
                paddingValues2 = paddingValues5;
                flingBehavior2 = flingBehavior3;
                z4 = z7;
                androidEdgeEffectOverscrollEffect2 = androidEdgeEffectOverscrollEffectRememberOverscrollEffect;
                horizontal2 = horizontal3;
                arrangement$Vertical3 = arrangement$Vertical6;
            } else {
                gapComposer = gapComposer2;
                gapComposer.skipToGroupEnd();
                horizontal2 = horizontal;
                androidEdgeEffectOverscrollEffect2 = androidEdgeEffectOverscrollEffect;
                modifier3 = modifier2;
                lazyListState2 = lazyListStateRememberLazyListState;
                paddingValues2 = paddingValuesImpl;
                arrangement$Vertical3 = arrangement$Vertical2;
                z4 = z2;
                flingBehavior2 = flingBehavior;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new SliderKt$$ExternalSyntheticLambda4(modifier3, lazyListState2, paddingValues2, arrangement$Vertical3, horizontal2, flingBehavior2, z4, androidEdgeEffectOverscrollEffect2, function1, i, i2, (byte) 2);
            }
        }
        i5 |= 12582912;
        z2 = z;
        if ((100663296 & i) == 0) {
            i5 |= 33554432;
        }
        if ((805306368 & i) == 0) {
            function2 = function1;
            if (gapComposer2.changedInstance(function2)) {
                i9 = 536870912;
            } else {
                i9 = WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
            }
            i5 |= i9;
        } else {
            function2 = function1;
        }
        if ((306783379 & i5) != 306783378) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (gapComposer2.shouldExecute(i5 & 1, z3)) {
            gapComposer2.startDefaults();
            if ((i & 1) != 0) {
                if (i10 != 0) {
                    modifier3 = Modifier.Companion.$$INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 2) != 0) {
                    i5 &= -113;
                    lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(gapComposer2);
                }
                if (i12 != 0) {
                    paddingValuesImpl = new PaddingValuesImpl(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO);
                }
                if ((i2 & 16) != 0) {
                    i5 &= -57345;
                    arrangement$Vertical2 = OffsetKt.Top;
                }
                BiasAlignment.Horizontal horizontal9 = Alignment.Companion.Start;
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
                DefaultFlingBehavior defaultFlingBehavior6 = (DefaultFlingBehavior) objRememberedValue;
                if (i6 != 0) {
                    z2 = true;
                }
                i8 = i5 & (-238551041);
                horizontal3 = horizontal9;
                androidEdgeEffectOverscrollEffectRememberOverscrollEffect = OverscrollKt.rememberOverscrollEffect(gapComposer2);
                flingBehavior3 = defaultFlingBehavior6;
            } else {
                if (i10 != 0) {
                    modifier3 = Modifier.Companion.$$INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 2) != 0) {
                    i5 &= -113;
                    lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(gapComposer2);
                }
                if (i12 != 0) {
                    paddingValuesImpl = new PaddingValuesImpl(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO);
                }
                if ((i2 & 16) != 0) {
                    i5 &= -57345;
                    arrangement$Vertical2 = OffsetKt.Top;
                }
                BiasAlignment.Horizontal horizontal10 = Alignment.Companion.Start;
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
                DefaultFlingBehavior defaultFlingBehavior7 = (DefaultFlingBehavior) objRememberedValue;
                if (i6 != 0) {
                    z2 = true;
                }
                i8 = i5 & (-238551041);
                horizontal3 = horizontal10;
                androidEdgeEffectOverscrollEffectRememberOverscrollEffect = OverscrollKt.rememberOverscrollEffect(gapComposer2);
                flingBehavior3 = defaultFlingBehavior7;
            }
            LazyListState lazyListState6 = lazyListStateRememberLazyListState;
            PaddingValues paddingValues6 = paddingValuesImpl;
            Arrangement$Vertical arrangement$Vertical7 = arrangement$Vertical2;
            boolean z8 = z2;
            gapComposer2.endDefaults();
            gapComposer = gapComposer2;
            MathKt.LazyList(modifier3, lazyListState6, paddingValues6, true, flingBehavior3, z8, androidEdgeEffectOverscrollEffectRememberOverscrollEffect, horizontal3, arrangement$Vertical7, null, null, function2, gapComposer, (i8 & 14) | 24576 | (i8 & 112) | (i8 & 896) | (i8 & 7168) | ((i8 >> 3) & 3670016) | ((i8 << 12) & 1879048192), ((i8 >> 12) & 14) | ((i8 >> 18) & 7168), 6400);
            lazyListState2 = lazyListState6;
            paddingValues2 = paddingValues6;
            flingBehavior2 = flingBehavior3;
            z4 = z8;
            androidEdgeEffectOverscrollEffect2 = androidEdgeEffectOverscrollEffectRememberOverscrollEffect;
            horizontal2 = horizontal3;
            arrangement$Vertical3 = arrangement$Vertical7;
        } else {
            gapComposer = gapComposer2;
            gapComposer.skipToGroupEnd();
            horizontal2 = horizontal;
            androidEdgeEffectOverscrollEffect2 = androidEdgeEffectOverscrollEffect;
            modifier3 = modifier2;
            lazyListState2 = lazyListStateRememberLazyListState;
            paddingValues2 = paddingValuesImpl;
            arrangement$Vertical3 = arrangement$Vertical2;
            z4 = z2;
            flingBehavior2 = flingBehavior;
        }
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new SliderKt$$ExternalSyntheticLambda4(modifier3, lazyListState2, paddingValues2, arrangement$Vertical3, horizontal2, flingBehavior2, z4, androidEdgeEffectOverscrollEffect2, function1, i, i2, (byte) 2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:26:0x004d  */
    /* JADX WARN: Code duplicated, block: B:28:0x0051  */
    /* JADX WARN: Code duplicated, block: B:30:0x0059  */
    /* JADX WARN: Code duplicated, block: B:31:0x005c  */
    /* JADX WARN: Code duplicated, block: B:34:0x0062  */
    /* JADX WARN: Code duplicated, block: B:37:0x006e  */
    /* JADX WARN: Code duplicated, block: B:39:0x0074  */
    /* JADX WARN: Code duplicated, block: B:40:0x0077  */
    /* JADX WARN: Code duplicated, block: B:44:0x0084  */
    /* JADX WARN: Code duplicated, block: B:45:0x0086  */
    /* JADX WARN: Code duplicated, block: B:48:0x008f  */
    /* JADX WARN: Code duplicated, block: B:58:0x00be A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:59:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:60:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:63:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:66:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:67:0x00db  */
    /* JADX WARN: Code duplicated, block: B:70:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:72:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:75:0x0144  */
    /* JADX WARN: Code duplicated, block: B:78:0x015b  */
    /* JADX WARN: Code duplicated, block: B:80:? A[RETURN, SYNTHETIC] */
    public static final void LazyRow(Modifier modifier, LazyListState lazyListState, PaddingValues paddingValues, Arrangement$Horizontal arrangement$Horizontal, Alignment.Vertical vertical, FlingBehavior flingBehavior, boolean z, AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect, Function1 function1, Composer composer, int i, int i2) {
        Modifier modifier2;
        int i3;
        PaddingValues paddingValuesImpl;
        int i4;
        Arrangement$Horizontal arrangement$Horizontal2;
        int i5;
        boolean z2;
        GapComposer gapComposer;
        Alignment.Vertical vertical2;
        boolean z3;
        AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect2;
        Modifier modifier3;
        Arrangement$Horizontal arrangement$Horizontal3;
        LazyListState lazyListState2;
        FlingBehavior flingBehavior2;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        Modifier modifier4;
        int i6;
        Arrangement$Horizontal arrangement$Horizontal4;
        DecayAnimationSpecImpl decayAnimationSpecImplRememberSplineBasedDecay;
        boolean zChanged;
        Object objRememberedValue;
        Alignment.Vertical vertical3;
        Arrangement$Horizontal arrangement$Horizontal5;
        FlingBehavior flingBehavior3;
        boolean z4;
        AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffectRememberOverscrollEffect;
        Modifier modifier5;
        LazyListState lazyListState3;
        int i7;
        int i8;
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(-1884325601);
        int i9 = i2 & 1;
        if (i9 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (gapComposer2.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        int i10 = i3 | 16;
        int i11 = i2 & 4;
        if (i11 == 0) {
            if ((i & 384) == 0) {
                paddingValuesImpl = paddingValues;
                i10 |= gapComposer2.changed(paddingValuesImpl) ? 256 : 128;
            }
            i4 = i10 | 3072;
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    arrangement$Horizontal2 = arrangement$Horizontal;
                    int i12 = gapComposer2.changed(arrangement$Horizontal2) ? 16384 : 8192;
                    i4 |= i12;
                } else {
                    arrangement$Horizontal2 = arrangement$Horizontal;
                }
                i4 |= i12;
            } else {
                arrangement$Horizontal2 = arrangement$Horizontal;
            }
            i5 = i4 | 46858240;
            if ((805306368 & i) == 0) {
                if (gapComposer2.changedInstance(function1)) {
                    i8 = 536870912;
                } else {
                    i8 = WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
                }
                i5 |= i8;
            }
            if ((306783379 & i5) != 306783378) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (gapComposer2.shouldExecute(i5 & 1, z2)) {
                gapComposer2.startDefaults();
                if ((i & 1) != 0 || gapComposer2.getDefaultsInvalid()) {
                    if (i9 != 0) {
                        modifier4 = Modifier.Companion.$$INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(gapComposer2);
                    i6 = i5 & (-113);
                    if (i11 != 0) {
                        paddingValuesImpl = new PaddingValuesImpl(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO);
                    }
                    if ((i2 & 16) != 0) {
                        arrangement$Horizontal4 = OffsetKt.Start;
                        i6 = i5 & (-57457);
                    } else {
                        arrangement$Horizontal4 = arrangement$Horizontal2;
                    }
                    BiasAlignment.Vertical vertical4 = Alignment.Companion.Top;
                    decayAnimationSpecImplRememberSplineBasedDecay = SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay(gapComposer2);
                    zChanged = gapComposer2.changed(decayAnimationSpecImplRememberSplineBasedDecay);
                    objRememberedValue = gapComposer2.rememberedValue();
                    if (zChanged || objRememberedValue == Composer.Companion.Empty) {
                        objRememberedValue = new DefaultFlingBehavior(decayAnimationSpecImplRememberSplineBasedDecay);
                        gapComposer2.updateRememberedValue(objRememberedValue);
                    }
                    vertical3 = vertical4;
                    arrangement$Horizontal5 = arrangement$Horizontal4;
                    flingBehavior3 = (DefaultFlingBehavior) objRememberedValue;
                    z4 = true;
                    androidEdgeEffectOverscrollEffectRememberOverscrollEffect = OverscrollKt.rememberOverscrollEffect(gapComposer2);
                    modifier5 = modifier4;
                    lazyListState3 = lazyListStateRememberLazyListState;
                    i7 = i6 & (-238551041);
                } else {
                    gapComposer2.skipToGroupEnd();
                    int i13 = i5 & (-113);
                    if ((i2 & 16) != 0) {
                        i13 = i5 & (-57457);
                    }
                    i7 = i13 & (-238551041);
                    lazyListState3 = lazyListState;
                    vertical3 = vertical;
                    flingBehavior3 = flingBehavior;
                    z4 = z;
                    androidEdgeEffectOverscrollEffectRememberOverscrollEffect = androidEdgeEffectOverscrollEffect;
                    modifier5 = modifier2;
                    arrangement$Horizontal5 = arrangement$Horizontal2;
                }
                PaddingValues paddingValues2 = paddingValuesImpl;
                gapComposer2.endDefaults();
                gapComposer = gapComposer2;
                MathKt.LazyList(modifier5, lazyListState3, paddingValues2, false, flingBehavior3, z4, androidEdgeEffectOverscrollEffectRememberOverscrollEffect, null, null, vertical3, arrangement$Horizontal5, function1, gapComposer, (i7 & 14) | 24576 | (i7 & 896) | 1575936, ((i7 >> 6) & 896) | 48 | ((i7 >> 18) & 7168), 1792);
                modifier3 = modifier5;
                lazyListState2 = lazyListState3;
                paddingValuesImpl = paddingValues2;
                flingBehavior2 = flingBehavior3;
                z3 = z4;
                androidEdgeEffectOverscrollEffect2 = androidEdgeEffectOverscrollEffectRememberOverscrollEffect;
                vertical2 = vertical3;
                arrangement$Horizontal3 = arrangement$Horizontal5;
            } else {
                gapComposer = gapComposer2;
                gapComposer.skipToGroupEnd();
                vertical2 = vertical;
                z3 = z;
                androidEdgeEffectOverscrollEffect2 = androidEdgeEffectOverscrollEffect;
                modifier3 = modifier2;
                arrangement$Horizontal3 = arrangement$Horizontal2;
                lazyListState2 = lazyListState;
                flingBehavior2 = flingBehavior;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new SliderKt$$ExternalSyntheticLambda4(modifier3, lazyListState2, paddingValuesImpl, arrangement$Horizontal3, vertical2, flingBehavior2, z3, androidEdgeEffectOverscrollEffect2, function1, i, i2, (byte) 3);
            }
        }
        i10 = i3 | 400;
        paddingValuesImpl = paddingValues;
        i4 = i10 | 3072;
        if ((i & 24576) == 0) {
            if ((i2 & 16) == 0) {
                arrangement$Horizontal2 = arrangement$Horizontal;
                if (gapComposer2.changed(arrangement$Horizontal2)) {
                }
                i4 |= i12;
            } else {
                arrangement$Horizontal2 = arrangement$Horizontal;
            }
            i4 |= i12;
        } else {
            arrangement$Horizontal2 = arrangement$Horizontal;
        }
        i5 = i4 | 46858240;
        if ((805306368 & i) == 0) {
            if (gapComposer2.changedInstance(function1)) {
                i8 = 536870912;
            } else {
                i8 = WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
            }
            i5 |= i8;
        }
        if ((306783379 & i5) != 306783378) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (gapComposer2.shouldExecute(i5 & 1, z2)) {
            gapComposer2.startDefaults();
            if ((i & 1) != 0) {
                if (i9 != 0) {
                    modifier4 = Modifier.Companion.$$INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                LazyListState lazyListStateRememberLazyListState2 = LazyListStateKt.rememberLazyListState(gapComposer2);
                i6 = i5 & (-113);
                if (i11 != 0) {
                    paddingValuesImpl = new PaddingValuesImpl(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO);
                }
                if ((i2 & 16) != 0) {
                    arrangement$Horizontal4 = OffsetKt.Start;
                    i6 = i5 & (-57457);
                } else {
                    arrangement$Horizontal4 = arrangement$Horizontal2;
                }
                BiasAlignment.Vertical vertical5 = Alignment.Companion.Top;
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
                vertical3 = vertical5;
                arrangement$Horizontal5 = arrangement$Horizontal4;
                flingBehavior3 = (DefaultFlingBehavior) objRememberedValue;
                z4 = true;
                androidEdgeEffectOverscrollEffectRememberOverscrollEffect = OverscrollKt.rememberOverscrollEffect(gapComposer2);
                modifier5 = modifier4;
                lazyListState3 = lazyListStateRememberLazyListState2;
                i7 = i6 & (-238551041);
            } else {
                if (i9 != 0) {
                    modifier4 = Modifier.Companion.$$INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                LazyListState lazyListStateRememberLazyListState3 = LazyListStateKt.rememberLazyListState(gapComposer2);
                i6 = i5 & (-113);
                if (i11 != 0) {
                    paddingValuesImpl = new PaddingValuesImpl(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO);
                }
                if ((i2 & 16) != 0) {
                    arrangement$Horizontal4 = OffsetKt.Start;
                    i6 = i5 & (-57457);
                } else {
                    arrangement$Horizontal4 = arrangement$Horizontal2;
                }
                BiasAlignment.Vertical vertical6 = Alignment.Companion.Top;
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
                vertical3 = vertical6;
                arrangement$Horizontal5 = arrangement$Horizontal4;
                flingBehavior3 = (DefaultFlingBehavior) objRememberedValue;
                z4 = true;
                androidEdgeEffectOverscrollEffectRememberOverscrollEffect = OverscrollKt.rememberOverscrollEffect(gapComposer2);
                modifier5 = modifier4;
                lazyListState3 = lazyListStateRememberLazyListState3;
                i7 = i6 & (-238551041);
            }
            PaddingValues paddingValues3 = paddingValuesImpl;
            gapComposer2.endDefaults();
            gapComposer = gapComposer2;
            MathKt.LazyList(modifier5, lazyListState3, paddingValues3, false, flingBehavior3, z4, androidEdgeEffectOverscrollEffectRememberOverscrollEffect, null, null, vertical3, arrangement$Horizontal5, function1, gapComposer, (i7 & 14) | 24576 | (i7 & 896) | 1575936, ((i7 >> 6) & 896) | 48 | ((i7 >> 18) & 7168), 1792);
            modifier3 = modifier5;
            lazyListState2 = lazyListState3;
            paddingValuesImpl = paddingValues3;
            flingBehavior2 = flingBehavior3;
            z3 = z4;
            androidEdgeEffectOverscrollEffect2 = androidEdgeEffectOverscrollEffectRememberOverscrollEffect;
            vertical2 = vertical3;
            arrangement$Horizontal3 = arrangement$Horizontal5;
        } else {
            gapComposer = gapComposer2;
            gapComposer.skipToGroupEnd();
            vertical2 = vertical;
            z3 = z;
            androidEdgeEffectOverscrollEffect2 = androidEdgeEffectOverscrollEffect;
            modifier3 = modifier2;
            arrangement$Horizontal3 = arrangement$Horizontal2;
            lazyListState2 = lazyListState;
            flingBehavior2 = flingBehavior;
        }
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new SliderKt$$ExternalSyntheticLambda4(modifier3, lazyListState2, paddingValuesImpl, arrangement$Horizontal3, vertical2, flingBehavior2, z3, androidEdgeEffectOverscrollEffect2, function1, i, i2, (byte) 3);
        }
    }

    /* JADX INFO: renamed from: Rect-0a9Yr6o, reason: not valid java name */
    public static final Rect m895Rect0a9Yr6o(long j, long j2) {
        return new Rect(Float.intBitsToFloat((int) (j >> 32)), Float.intBitsToFloat((int) (j & 4294967295L)), Float.intBitsToFloat((int) (j2 >> 32)), Float.intBitsToFloat((int) (j2 & 4294967295L)));
    }

    /* JADX INFO: renamed from: Rect-tz77jQw, reason: not valid java name */
    public static final Rect m896Recttz77jQw(long j, long j2) {
        int i = (int) (j >> 32);
        int i2 = (int) (j & 4294967295L);
        return new Rect(Float.intBitsToFloat(i), Float.intBitsToFloat(i2), Float.intBitsToFloat((int) (j2 >> 32)) + Float.intBitsToFloat(i), Float.intBitsToFloat((int) (j2 & 4294967295L)) + Float.intBitsToFloat(i2));
    }

    public static final void SimpleLayout(Modifier modifier, ComposableLambdaImpl composableLambdaImpl, Composer composer, int i) {
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-1854833411);
        int i2 = (gapComposer.changed(modifier) ? 4 : 2) | i;
        byte b = 1;
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 19) != 18)) {
            Object objRememberedValue = gapComposer.rememberedValue();
            if (objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = SimpleLayoutKt$SimpleLayout$1$1.INSTANCE;
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) objRememberedValue;
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifier);
            ComposeUiNode.Companion.getClass();
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(LayoutNode.Constructor);
            } else {
                gapComposer.useNode();
            }
            Stack.m390setimpl(gapComposer, measurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m389reconcileimpl(gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            Fragment$5$$ExternalSyntheticOutline0.m(6, composableLambdaImpl, gapComposer, true);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new AlertDialogKt$$ExternalSyntheticLambda2(modifier, composableLambdaImpl, i, b);
        }
    }

    /* JADX INFO: renamed from: add-impl, reason: not valid java name */
    public static final void m897addimpl(MutableScatterMap mutableScatterMap, Object obj, Object obj2) {
        int iFindInsertIndex = mutableScatterMap.findInsertIndex(obj);
        boolean z = iFindInsertIndex < 0;
        Object obj3 = z ? null : mutableScatterMap.values[iFindInsertIndex];
        if (obj3 != null) {
            if (obj3 instanceof MutableScatterSet) {
                ((MutableScatterSet) obj3).add(obj2);
            } else if (obj3 != obj2) {
                MutableScatterSet mutableScatterSet = new MutableScatterSet();
                mutableScatterSet.add(obj3);
                mutableScatterSet.add(obj2);
                obj2 = mutableScatterSet;
            }
            obj2 = obj3;
        }
        if (!z) {
            mutableScatterMap.values[iFindInsertIndex] = obj2;
            return;
        }
        int i = ~iFindInsertIndex;
        mutableScatterMap.keys[i] = obj;
        mutableScatterMap.values[i] = obj2;
    }

    /* JADX INFO: renamed from: checkArithmetic--R2X_6o, reason: not valid java name */
    public static final void m898checkArithmeticR2X_6o(long j) {
        if ((j & 1095216660480L) == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("Cannot perform operation for Unspecified type.");
        }
    }

    /* JADX INFO: renamed from: constructor-impl$default, reason: not valid java name */
    public static MutableScatterMap m899constructorimpl$default() {
        long[] jArr = ScatterMapKt.EmptyGroup;
        return new MutableScatterMap();
    }

    public static boolean copyToFile(File file, InputStream inputStream) throws Throwable {
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file, false);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i = inputStream.read(bArr);
                        if (i != -1) {
                            fileOutputStream2.write(bArr, 0, i);
                        } else {
                            try {
                                break;
                            } catch (IOException unused) {
                            }
                        }
                    }
                    fileOutputStream2.close();
                    StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
                    return true;
                } catch (IOException e) {
                    e = e;
                    fileOutputStream = fileOutputStream2;
                    Log.e("TypefaceCompatUtil", "Error copying resource contents to temp file: " + e.getMessage());
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static final MutableState currentBackStackEntryAsState(NavHostController navHostController, Composer composer) {
        return Stack.collectAsState(new ReadonlySharedFlow(navHostController.impl._currentBackStackEntryFlow), null, EmptyCoroutineContext.INSTANCE, NeverEqualPolicy.INSTANCE$3, composer, 48);
    }

    public static int divide(int i, int i2) {
        RoundingMode roundingMode = RoundingMode.CEILING;
        roundingMode.getClass();
        if (i2 == 0) {
            throw new ArithmeticException("/ by zero");
        }
        int i3 = i / i2;
        int i4 = i - (i2 * i3);
        if (i4 == 0) {
            return i3;
        }
        int i5 = ((i ^ i2) >> 31) | 1;
        switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                FileSystemsKt.checkRoundingUnnecessary(i4 == 0);
                return i3;
            case 2:
                return i3;
            case 3:
                if (i5 >= 0) {
                    return i3;
                }
                break;
            case 4:
                break;
            case 5:
                if (i5 <= 0) {
                    return i3;
                }
                break;
            case 6:
            case 7:
            case 8:
                int iAbs = Math.abs(i4);
                int iAbs2 = iAbs - (Math.abs(i2) - iAbs);
                if (iAbs2 == 0) {
                    RoundingMode roundingMode2 = RoundingMode.HALF_UP;
                    RoundingMode roundingMode3 = RoundingMode.HALF_EVEN;
                    return i3;
                }
                if (iAbs2 <= 0) {
                    return i3;
                }
                break;
            default:
                throw new AssertionError();
        }
        return i3 + i5;
    }

    /* JADX INFO: renamed from: finalConstraints-tfFHcEY, reason: not valid java name */
    public static final long m900finalConstraintstfFHcEY(long j, boolean z, int i, float f) {
        int iM784getMaxWidthimpl = ((z || i == 2 || i == 4 || i == 5) && Constraints.m780getHasBoundedWidthimpl(j)) ? Constraints.m784getMaxWidthimpl(j) : Integer.MAX_VALUE;
        if (Constraints.m786getMinWidthimpl(j) != iM784getMaxWidthimpl) {
            iM784getMaxWidthimpl = UuidKt.coerceIn(BasicTextKt.ceilToIntPx(f), Constraints.m786getMinWidthimpl(j), iM784getMaxWidthimpl);
        }
        return FileSystemsKt.m880fitPrioritizingWidthZbe2FdA(0, iM784getMaxWidthimpl, 0, Constraints.m783getMaxHeightimpl(j));
    }

    public static final MediaItem findNextMediaItemById(Player player, String str) {
        player.getClass();
        str.getClass();
        int mediaItemCount = player.getMediaItemCount();
        for (int currentMediaItemIndex = player.getCurrentMediaItemIndex(); currentMediaItemIndex < mediaItemCount; currentMediaItemIndex++) {
            if (Intrinsics.areEqual(player.getMediaItemAt(currentMediaItemIndex).mediaId, str)) {
                return player.getMediaItemAt(currentMediaItemIndex);
            }
        }
        return null;
    }

    public static SnapFlingBehavior flingBehavior(PagerState pagerState, PagerSnapDistanceMaxPages pagerSnapDistanceMaxPages, SpringSpec springSpec, Composer composer, int i, int i2) {
        if ((i2 & 2) != 0) {
            pagerSnapDistanceMaxPages = new PagerSnapDistanceMaxPages();
        }
        DecayAnimationSpecImpl decayAnimationSpecImplRememberSplineBasedDecay = SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay(composer);
        byte b = 1;
        if ((i2 & 8) != 0) {
            Map map = VisibilityThresholdsKt.VisibilityThresholdMap;
            springSpec = ArcSplineKt.spring$default(CropImageView.DEFAULT_ASPECT_RATIO, 400.0f, Float.valueOf(1.0f), 1);
        }
        GapComposer gapComposer = (GapComposer) composer;
        Density density = (Density) gapComposer.consume(CompositionLocalsKt.LocalDensity);
        LayoutDirection layoutDirection = (LayoutDirection) gapComposer.consume(CompositionLocalsKt.LocalLayoutDirection);
        boolean zChanged = ((((i & 14) ^ 6) > 4 && gapComposer.changed(pagerState)) || (i & 6) == 4) | gapComposer.changed(decayAnimationSpecImplRememberSplineBasedDecay) | gapComposer.changed(springSpec) | ((((i & 112) ^ 48) > 32 && gapComposer.changed(pagerSnapDistanceMaxPages)) || (i & 48) == 32) | gapComposer.changed(density) | gapComposer.changed(layoutDirection.ordinal());
        Object objRememberedValue = gapComposer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.Empty) {
            SnapFlingBehavior snapFlingBehavior = new SnapFlingBehavior(new AnchoredDraggableKt$AnchoredDraggableLayoutInfoProvider$1(pagerState, new AlbumMenuKt$$ExternalSyntheticLambda11(pagerState, layoutDirection, (byte) 3), pagerSnapDistanceMaxPages, b), decayAnimationSpecImplRememberSplineBasedDecay, springSpec);
            gapComposer.updateRememberedValue(snapFlingBehavior);
            objRememberedValue = snapFlingBehavior;
        }
        return (SnapFlingBehavior) objRememberedValue;
    }

    public static final MediaMetadata getCurrentMetadata(Player player) {
        player.getClass();
        MediaItem currentMediaItem = player.getCurrentMediaItem();
        if (currentMediaItem != null) {
            return UuidKt.getMetadata(currentMediaItem);
        }
        return null;
    }

    public static final int getCurrentQueueIndex(ExoPlayerImpl exoPlayerImpl) {
        exoPlayerImpl.getClass();
        if (exoPlayerImpl.getCurrentTimeline().isEmpty()) {
            return -1;
        }
        int currentMediaItemIndex = exoPlayerImpl.getCurrentMediaItemIndex();
        int i = 0;
        while (currentMediaItemIndex != -1) {
            Timeline currentTimeline = exoPlayerImpl.getCurrentTimeline();
            exoPlayerImpl.verifyApplicationThread();
            currentMediaItemIndex = currentTimeline.getPreviousWindowIndex(currentMediaItemIndex, exoPlayerImpl.shuffleModeEnabled, 0);
            if (currentMediaItemIndex != -1) {
                i++;
            }
        }
        return i;
    }

    public static Set getExclusions() {
        try {
            Object objInvoke = Class.forName("android.text.EmojiConsistency").getMethod("getEmojiConsistencySet", null).invoke(null, null);
            if (objInvoke == null) {
                return Collections.EMPTY_SET;
            }
            Set set = (Set) objInvoke;
            Iterator it = set.iterator();
            while (it.hasNext()) {
                if (!(it.next() instanceof int[])) {
                    return Collections.EMPTY_SET;
                }
            }
            return set;
        } catch (Throwable unused) {
            return Collections.EMPTY_SET;
        }
    }

    public static final List getQueueWindows(ExoPlayerImpl exoPlayerImpl) {
        exoPlayerImpl.getClass();
        Timeline currentTimeline = exoPlayerImpl.getCurrentTimeline();
        currentTimeline.getClass();
        if (currentTimeline.isEmpty()) {
            return EmptyList.INSTANCE;
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        int windowCount = currentTimeline.getWindowCount();
        int currentMediaItemIndex = exoPlayerImpl.getCurrentMediaItemIndex();
        arrayDeque.add(currentTimeline.getWindow(currentMediaItemIndex, new Timeline.Window(), 0L));
        exoPlayerImpl.verifyApplicationThread();
        boolean z = exoPlayerImpl.shuffleModeEnabled;
        int nextWindowIndex = currentMediaItemIndex;
        while (true) {
            if ((currentMediaItemIndex == -1 && nextWindowIndex == -1) || arrayDeque.size() >= windowCount) {
                break;
            }
            if (nextWindowIndex != -1 && (nextWindowIndex = currentTimeline.getNextWindowIndex(nextWindowIndex, z, 0)) != -1) {
                arrayDeque.add(currentTimeline.getWindow(nextWindowIndex, new Timeline.Window(), 0L));
            }
            if (currentMediaItemIndex != -1 && arrayDeque.size() < windowCount && (currentMediaItemIndex = currentTimeline.getPreviousWindowIndex(currentMediaItemIndex, z, 0)) != -1) {
                arrayDeque.addFirst(currentTimeline.getWindow(currentMediaItemIndex, new Timeline.Window(), 0L));
            }
        }
        return CollectionsKt.toList(arrayDeque);
    }

    public static final long getSp(double d) {
        return pack(4294967296L, (float) d);
    }

    public static File getTempFile(Context context) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            return null;
        }
        String str = ".font" + Process.myPid() + "-" + Process.myTid() + "-";
        for (int i = 0; i < 100; i++) {
            File file = new File(cacheDir, IntIntPair$$ExternalSyntheticOutline0.m(i, str));
            try {
                if (file.createNewFile()) {
                    return file;
                }
            } catch (IOException unused) {
            }
        }
        return null;
    }

    public static PrecomputedTextCompat.Params getTextMetricsParams(AppCompatTextView appCompatTextView) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            return new PrecomputedTextCompat.Params(HandlerCompat$Api28Impl.getTextMetricsParams(appCompatTextView));
        }
        TextPaint textPaint = new TextPaint(appCompatTextView.getPaint());
        TextDirectionHeuristic textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR;
        int breakStrategy = appCompatTextView.getBreakStrategy();
        int hyphenationFrequency = appCompatTextView.getHyphenationFrequency();
        if (appCompatTextView.getTransformationMethod() instanceof PasswordTransformationMethod) {
            textDirectionHeuristic = TextDirectionHeuristics.LTR;
        } else if (i < 28 || (appCompatTextView.getInputType() & 15) != 3) {
            boolean z = appCompatTextView.getLayoutDirection() == 1;
            switch (appCompatTextView.getTextDirection()) {
                case 2:
                    textDirectionHeuristic = TextDirectionHeuristics.ANYRTL_LTR;
                    break;
                case 3:
                    textDirectionHeuristic = TextDirectionHeuristics.LTR;
                    break;
                case 4:
                    textDirectionHeuristic = TextDirectionHeuristics.RTL;
                    break;
                case 5:
                    textDirectionHeuristic = TextDirectionHeuristics.LOCALE;
                    break;
                case 6:
                    break;
                case 7:
                    textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_RTL;
                    break;
                default:
                    if (z) {
                        textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_RTL;
                    }
                    break;
            }
        } else {
            byte directionality = Character.getDirectionality(HandlerCompat$Api28Impl.getDigitStrings(DecimalFormatSymbols.getInstance(appCompatTextView.getTextLocale()))[0].codePointAt(0));
            textDirectionHeuristic = (directionality == 1 || directionality == 2) ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
        }
        return new PrecomputedTextCompat.Params(textPaint, textDirectionHeuristic, breakStrategy, hyphenationFrequency);
    }

    public static boolean isBluetoothDevice(int i) {
        if (i == 8 || i == 7) {
            return true;
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 31 || !(i == 26 || i == 27)) {
            return i2 >= 33 && i == 30;
        }
        return true;
    }

    public static int log2(int i) {
        RoundingMode roundingMode = RoundingMode.UNNECESSARY;
        if (i <= 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1(IntIntPair$$ExternalSyntheticOutline0.m(i, "x (", ") must be > 0"));
            return 0;
        }
        switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                FileSystemsKt.checkRoundingUnnecessary((i > 0) & (((i + (-1)) & i) == 0));
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                return 32 - Integer.numberOfLeadingZeros(i - 1);
            case 6:
            case 7:
            case 8:
                int iNumberOfLeadingZeros = Integer.numberOfLeadingZeros(i);
                return (31 - iNumberOfLeadingZeros) + ((~(~(((-1257966797) >>> iNumberOfLeadingZeros) - i))) >>> 31);
            default:
                throw new AssertionError();
        }
        return 31 - Integer.numberOfLeadingZeros(i);
    }

    public static final ArrayList missingRequiredArguments(Map map, Function1 function1) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : map.entrySet()) {
            NavArgument navArgument = (NavArgument) entry.getValue();
            Boolean boolValueOf = navArgument != null ? Boolean.valueOf(navArgument.isNullable) : null;
            boolValueOf.getClass();
            if (!boolValueOf.booleanValue() && !navArgument.isDefaultValuePresent) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        Set setKeySet = linkedHashMap.keySet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : setKeySet) {
            if (((Boolean) function1.invoke((String) obj)).booleanValue()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static MappedByteBuffer mmap(Context context, Uri uri) {
        try {
            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r", null);
            if (parcelFileDescriptorOpenFileDescriptor == null) {
                if (parcelFileDescriptorOpenFileDescriptor != null) {
                    parcelFileDescriptorOpenFileDescriptor.close();
                    return null;
                }
                return null;
            }
            try {
                FileInputStream fileInputStream = new FileInputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
                try {
                    FileChannel channel = fileInputStream.getChannel();
                    MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                    fileInputStream.close();
                    parcelFileDescriptorOpenFileDescriptor.close();
                    return map;
                } catch (Throwable th) {
                    try {
                        fileInputStream.close();
                        throw th;
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                try {
                    parcelFileDescriptorOpenFileDescriptor.close();
                    throw th3;
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                    throw th3;
                }
            }
        } catch (IOException unused) {
        }
    }

    /* JADX INFO: renamed from: modulate-DxMtmZc, reason: not valid java name */
    public static final long m901modulateDxMtmZc(long j, float f) {
        return (Float.isNaN(f) || f >= 1.0f) ? j : ColorKt.Color(Color.m485getRedimpl(j), Color.m484getGreenimpl(j), Color.m482getBlueimpl(j), Color.m481getAlphaimpl(j) * f, Color.m483getColorSpaceimpl(j));
    }

    public static void onCreateInputConnection(EditorInfo editorInfo, InputConnection inputConnection, TextView textView) {
        if (inputConnection == null || editorInfo.hintText != null) {
            return;
        }
        for (ViewParent parent = textView.getParent(); parent instanceof View; parent = parent.getParent()) {
        }
    }

    public static final long pack(long j, float f) {
        return j | (((long) Float.floatToRawIntBits(f)) & 4294967295L);
    }

    /* JADX WARN: Code duplicated, block: B:173:0x0427  */
    /* JADX WARN: Code duplicated, block: B:192:0x04ad  */
    /* JADX WARN: Code duplicated, block: B:193:0x04b2  */
    /* JADX WARN: Code duplicated, block: B:198:0x04ce A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:199:0x04d0  */
    /* JADX WARN: Code duplicated, block: B:200:0x04d8  */
    /* JADX WARN: Code duplicated, block: B:206:0x04f0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:207:0x04f2  */
    /* JADX WARN: Code duplicated, block: B:208:0x04fa  */
    /* JADX WARN: Code duplicated, block: B:211:0x0509  */
    /* JADX WARN: Code duplicated, block: B:212:0x050c  */
    /* JADX WARN: Code duplicated, block: B:215:0x0512  */
    /* JADX WARN: Code duplicated, block: B:77:0x01d5  */
    public static final Painter painterResource(int i, int i2, Composer composer) throws XmlPullParserException, IOException {
        TypedValue typedValue;
        int i3;
        long jColor;
        int i4;
        int i5;
        boolean z;
        byte b;
        int i6;
        TypedArray typedArrayObtainStyledAttributes;
        int i7;
        int i8;
        TypedArray typedArrayObtainStyledAttributes2;
        int i9;
        int i10;
        int i11;
        Shader shader;
        int i12;
        Brush solidColor;
        Shader shader2;
        int i13;
        Brush solidColor2;
        int i14;
        int i15;
        ColorStateList colorStateListCreateFromXml;
        GapComposer gapComposer = (GapComposer) composer;
        Context context = (Context) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalContext);
        Resources resources = (Resources) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalResources);
        ResourceIdCache resourceIdCache = (ResourceIdCache) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalResourceIdCache);
        synchronized (resourceIdCache) {
            typedValue = (TypedValue) resourceIdCache.resIdPathMap.get(i);
            i3 = 1;
            if (typedValue == null) {
                typedValue = new TypedValue();
                resources.getValue(i, typedValue, true);
                MutableIntObjectMap mutableIntObjectMap = resourceIdCache.resIdPathMap;
                int iFindAbsoluteInsertIndex = mutableIntObjectMap.findAbsoluteInsertIndex(i);
                Object[] objArr = mutableIntObjectMap.values;
                Object obj = objArr[iFindAbsoluteInsertIndex];
                mutableIntObjectMap.keys[iFindAbsoluteInsertIndex] = i;
                objArr[iFindAbsoluteInsertIndex] = typedValue;
            }
        }
        CharSequence charSequence = typedValue.string;
        if (charSequence == null || !StringsKt.endsWith$default(charSequence, ".xml")) {
            gapComposer.startReplaceGroup(-1771643000);
            boolean zChanged = gapComposer.changed(context.getTheme()) | gapComposer.changed(charSequence) | ((((i2 & 14) ^ 6) > 4 && gapComposer.changed(i)) || (i2 & 6) == 4);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.Empty) {
                try {
                    Drawable drawable = resources.getDrawable(i, null);
                    drawable.getClass();
                    objRememberedValue = new AndroidImageBitmap(((BitmapDrawable) drawable).getBitmap());
                    gapComposer.updateRememberedValue(objRememberedValue);
                } catch (Exception e) {
                    throw new HttpException("Error attempting to load resource: " + ((Object) charSequence), e);
                }
            }
            ImageBitmap imageBitmap = (ImageBitmap) objRememberedValue;
            BitmapPainter bitmapPainter = new BitmapPainter(imageBitmap, (((long) ((AndroidImageBitmap) imageBitmap).bitmap.getHeight()) & 4294967295L) | (((long) ((AndroidImageBitmap) imageBitmap).bitmap.getWidth()) << 32));
            gapComposer.end(false);
            return bitmapPainter;
        }
        gapComposer.startReplaceGroup(-1771798434);
        Resources.Theme theme = context.getTheme();
        int i16 = typedValue.changingConfigurations;
        ImageVectorCache imageVectorCache = (ImageVectorCache) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalImageVectorCache);
        ImageVectorCache.Key key = new ImageVectorCache.Key(theme, i);
        WeakReference weakReference = (WeakReference) imageVectorCache.map.get(key);
        ImageVectorCache.ImageVectorEntry imageVectorEntry = weakReference != null ? (ImageVectorCache.ImageVectorEntry) weakReference.get() : null;
        if (imageVectorEntry == null) {
            XmlResourceParser xml = resources.getXml(i);
            int next = xml.next();
            while (next != 2 && next != 1) {
                next = xml.next();
            }
            if (next != 2) {
                throw new XmlPullParserException("No start tag found");
            }
            if (!Intrinsics.areEqual(xml.getName(), "vector")) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Only VectorDrawables and rasterized asset types are supported ex. PNG, JPG, WEBP");
                return null;
            }
            AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
            SnapshotDoubleIndexHeap snapshotDoubleIndexHeap = new SnapshotDoubleIndexHeap();
            snapshotDoubleIndexHeap.values = xml;
            snapshotDoubleIndexHeap.size = 0;
            PathParser pathParser = new PathParser();
            pathParser.nodeData = new float[64];
            snapshotDoubleIndexHeap.handles = pathParser;
            int[] iArr = AndroidVectorResources.STYLEABLE_VECTOR_DRAWABLE_TYPE_ARRAY;
            TypedArray typedArrayObtainAttributes = theme == null ? resources.obtainAttributes(attributeSetAsAttributeSet, iArr) : theme.obtainStyledAttributes(attributeSetAsAttributeSet, iArr, 0, 0);
            snapshotDoubleIndexHeap.updateConfig(typedArrayObtainAttributes.getChangingConfigurations());
            boolean z2 = xml.getAttributeValue("http://schemas.android.com/apk/res/android", "autoMirrored") != null ? typedArrayObtainAttributes.getBoolean(5, false) : false;
            snapshotDoubleIndexHeap.updateConfig(typedArrayObtainAttributes.getChangingConfigurations());
            float namedFloat = snapshotDoubleIndexHeap.getNamedFloat(typedArrayObtainAttributes, "viewportWidth", 7, CropImageView.DEFAULT_ASPECT_RATIO);
            float namedFloat2 = snapshotDoubleIndexHeap.getNamedFloat(typedArrayObtainAttributes, "viewportHeight", 8, CropImageView.DEFAULT_ASPECT_RATIO);
            if (namedFloat <= CropImageView.DEFAULT_ASPECT_RATIO) {
                throw new XmlPullParserException(typedArrayObtainAttributes.getPositionDescription() + "<VectorGraphic> tag requires viewportWidth > 0");
            }
            if (namedFloat2 <= CropImageView.DEFAULT_ASPECT_RATIO) {
                throw new XmlPullParserException(typedArrayObtainAttributes.getPositionDescription() + "<VectorGraphic> tag requires viewportHeight > 0");
            }
            float dimension = typedArrayObtainAttributes.getDimension(3, CropImageView.DEFAULT_ASPECT_RATIO);
            snapshotDoubleIndexHeap.updateConfig(typedArrayObtainAttributes.getChangingConfigurations());
            float dimension2 = typedArrayObtainAttributes.getDimension(2, CropImageView.DEFAULT_ASPECT_RATIO);
            snapshotDoubleIndexHeap.updateConfig(typedArrayObtainAttributes.getChangingConfigurations());
            if (typedArrayObtainAttributes.hasValue(1)) {
                TypedValue typedValue2 = new TypedValue();
                typedArrayObtainAttributes.getValue(1, typedValue2);
                if (typedValue2.type == 2) {
                    jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                } else {
                    if (xml.getAttributeValue("http://schemas.android.com/apk/res/android", "tint") != null) {
                        TypedValue typedValue3 = new TypedValue();
                        typedArrayObtainAttributes.getValue(1, typedValue3);
                        int i17 = typedValue3.type;
                        if (i17 == 2) {
                            throw new UnsupportedOperationException("Failed to resolve attribute at index 1: " + typedValue3);
                        }
                        if (i17 < 28 || i17 > 31) {
                            Resources resources2 = typedArrayObtainAttributes.getResources();
                            int resourceId = typedArrayObtainAttributes.getResourceId(1, 0);
                            ThreadLocal threadLocal = ColorStateListInflaterCompat.sTempTypedValue;
                            try {
                                colorStateListCreateFromXml = ColorStateListInflaterCompat.createFromXml(resources2, resources2.getXml(resourceId), theme);
                            } catch (Exception e2) {
                                Log.e("CSLCompat", "Failed to inflate ColorStateList.", e2);
                                colorStateListCreateFromXml = null;
                            }
                        } else {
                            colorStateListCreateFromXml = ColorStateList.valueOf(typedValue3.data);
                        }
                    } else {
                        colorStateListCreateFromXml = null;
                    }
                    snapshotDoubleIndexHeap.updateConfig(typedArrayObtainAttributes.getChangingConfigurations());
                    jColor = colorStateListCreateFromXml != null ? ((long) colorStateListCreateFromXml.getDefaultColor()) << 32 : ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                }
            } else {
                jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
            }
            long j = jColor;
            int i18 = typedArrayObtainAttributes.getInt(6, -1);
            snapshotDoubleIndexHeap.updateConfig(typedArrayObtainAttributes.getChangingConfigurations());
            if (i18 == -1) {
                i4 = 5;
            } else if (i18 == 3) {
                i4 = 3;
            } else if (i18 == 5) {
                i4 = 5;
            } else if (i18 != 9) {
                switch (i18) {
                    case 14:
                        i4 = 13;
                        break;
                    case 15:
                        i4 = 14;
                        break;
                    case 16:
                        i4 = 12;
                        break;
                    default:
                        i4 = 5;
                        break;
                }
            } else {
                i4 = 9;
            }
            float f = (dimension / resources.getDisplayMetrics().density) + CropImageView.DEFAULT_ASPECT_RATIO;
            float f2 = (dimension2 / resources.getDisplayMetrics().density) + CropImageView.DEFAULT_ASPECT_RATIO;
            typedArrayObtainAttributes.recycle();
            ImageVector.Builder builder = new ImageVector.Builder(null, f, f2, namedFloat, namedFloat2, j, i4, z2, 1);
            int i19 = 0;
            while (xml.getEventType() != i3 && (xml.getDepth() >= i3 || xml.getEventType() != 3)) {
                List listPathStringToNodes$default = EmptyList.INSTANCE;
                XmlPullParser xmlPullParser = (XmlPullParser) snapshotDoubleIndexHeap.values;
                int i20 = i3;
                PathParser pathParser2 = (PathParser) snapshotDoubleIndexHeap.handles;
                int eventType = xmlPullParser.getEventType();
                int i21 = i16;
                if (eventType != 2) {
                    if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                        int i22 = i19 + 1;
                        for (int i23 = 0; i23 < i22; i23++) {
                            ArrayList arrayList = builder.nodes;
                            if (builder.isConsumed) {
                                androidx.compose.ui.internal.InlineClassHelperKt.throwIllegalStateException("ImageVector.Builder is single use, create a new instance to create a new ImageVector");
                            }
                            ImageVector.Builder.GroupParams groupParams = (ImageVector.Builder.GroupParams) arrayList.remove(arrayList.size() - 1);
                            ((ImageVector.Builder.GroupParams) arrayList.get(arrayList.size() - 1)).children.add(new VectorGroup(groupParams.name, groupParams.rotate, groupParams.pivotX, groupParams.pivotY, groupParams.scaleX, groupParams.scaleY, groupParams.translationX, groupParams.translationY, groupParams.clipPathData, groupParams.children));
                        }
                        int[] iArr2 = snapshotDoubleIndexHeap.index;
                        if (iArr2 == null || (i15 = snapshotDoubleIndexHeap.firstFreeHandle) == 0) {
                            i7 = i20;
                            i19 = 0;
                        } else {
                            int i24 = i15 - 1;
                            snapshotDoubleIndexHeap.firstFreeHandle = i24;
                            i19 = iArr2[i24];
                            i7 = i20;
                        }
                        z = false;
                        b = -1;
                    }
                    i5 = i19;
                    i7 = i20;
                    z = false;
                    b = -1;
                    i19 = i5;
                } else {
                    String name = xmlPullParser.getName();
                    if (name != null) {
                        int iHashCode = name.hashCode();
                        i5 = i19;
                        if (iHashCode == -1649314686) {
                            z = false;
                            b = -1;
                            if (name.equals("clip-path")) {
                                int[] iArr3 = AndroidVectorResources.STYLEABLE_VECTOR_DRAWABLE_CLIP_PATH;
                                if (theme == null) {
                                    typedArrayObtainStyledAttributes = resources.obtainAttributes(attributeSetAsAttributeSet, iArr3);
                                    i6 = 0;
                                } else {
                                    i6 = 0;
                                    typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSetAsAttributeSet, iArr3, 0, 0);
                                }
                                snapshotDoubleIndexHeap.updateConfig(typedArrayObtainStyledAttributes.getChangingConfigurations());
                                String string = typedArrayObtainStyledAttributes.getString(i6);
                                snapshotDoubleIndexHeap.updateConfig(typedArrayObtainStyledAttributes.getChangingConfigurations());
                                String str = string == null ? "" : string;
                                i7 = 1;
                                String string2 = typedArrayObtainStyledAttributes.getString(1);
                                snapshotDoubleIndexHeap.updateConfig(typedArrayObtainStyledAttributes.getChangingConfigurations());
                                if (string2 != null) {
                                    listPathStringToNodes$default = PathParser.pathStringToNodes$default(pathParser2, string2);
                                }
                                List list = listPathStringToNodes$default;
                                typedArrayObtainStyledAttributes.recycle();
                                if (builder.isConsumed) {
                                    androidx.compose.ui.internal.InlineClassHelperKt.throwIllegalStateException("ImageVector.Builder is single use, create a new instance to create a new ImageVector");
                                }
                                builder.nodes.add(new ImageVector.Builder.GroupParams(str, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f, 1.0f, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, list, 512));
                                i19 = i5 + 1;
                            } else {
                                i7 = 1;
                                i19 = i5;
                            }
                        } else if (iHashCode != 3433509) {
                            if (iHashCode == 98629247 && name.equals("group")) {
                                int[] iArr4 = AndroidVectorResources.STYLEABLE_VECTOR_DRAWABLE_GROUP;
                                TypedArray typedArrayObtainAttributes2 = theme == null ? resources.obtainAttributes(attributeSetAsAttributeSet, iArr4) : theme.obtainStyledAttributes(attributeSetAsAttributeSet, iArr4, 0, 0);
                                snapshotDoubleIndexHeap.updateConfig(typedArrayObtainAttributes2.getChangingConfigurations());
                                float namedFloat3 = snapshotDoubleIndexHeap.getNamedFloat(typedArrayObtainAttributes2, "rotation", 5, CropImageView.DEFAULT_ASPECT_RATIO);
                                float f3 = typedArrayObtainAttributes2.getFloat(i20, CropImageView.DEFAULT_ASPECT_RATIO);
                                snapshotDoubleIndexHeap.updateConfig(typedArrayObtainAttributes2.getChangingConfigurations());
                                float f4 = typedArrayObtainAttributes2.getFloat(2, CropImageView.DEFAULT_ASPECT_RATIO);
                                snapshotDoubleIndexHeap.updateConfig(typedArrayObtainAttributes2.getChangingConfigurations());
                                float namedFloat4 = snapshotDoubleIndexHeap.getNamedFloat(typedArrayObtainAttributes2, "scaleX", 3, 1.0f);
                                float namedFloat5 = snapshotDoubleIndexHeap.getNamedFloat(typedArrayObtainAttributes2, "scaleY", 4, 1.0f);
                                float namedFloat6 = snapshotDoubleIndexHeap.getNamedFloat(typedArrayObtainAttributes2, "translateX", 6, CropImageView.DEFAULT_ASPECT_RATIO);
                                float namedFloat7 = snapshotDoubleIndexHeap.getNamedFloat(typedArrayObtainAttributes2, "translateY", 7, CropImageView.DEFAULT_ASPECT_RATIO);
                                String string3 = typedArrayObtainAttributes2.getString(0);
                                snapshotDoubleIndexHeap.updateConfig(typedArrayObtainAttributes2.getChangingConfigurations());
                                String str2 = string3 == null ? "" : string3;
                                typedArrayObtainAttributes2.recycle();
                                if (builder.isConsumed) {
                                    androidx.compose.ui.internal.InlineClassHelperKt.throwIllegalStateException("ImageVector.Builder is single use, create a new instance to create a new ImageVector");
                                }
                                builder.nodes.add(new ImageVector.Builder.GroupParams(str2, namedFloat3, f3, f4, namedFloat4, namedFloat5, namedFloat6, namedFloat7, listPathStringToNodes$default, 512));
                                int[] iArrCopyOf = snapshotDoubleIndexHeap.index;
                                if (iArrCopyOf == null) {
                                    iArrCopyOf = new int[4];
                                    snapshotDoubleIndexHeap.index = iArrCopyOf;
                                } else if (snapshotDoubleIndexHeap.firstFreeHandle >= iArrCopyOf.length) {
                                    iArrCopyOf = Arrays.copyOf(iArrCopyOf, iArrCopyOf.length * 2);
                                    snapshotDoubleIndexHeap.index = iArrCopyOf;
                                }
                                int i25 = snapshotDoubleIndexHeap.firstFreeHandle;
                                snapshotDoubleIndexHeap.firstFreeHandle = i25 + 1;
                                iArrCopyOf[i25] = i5;
                                i19 = 0;
                                i7 = 1;
                                z = false;
                                b = -1;
                            }
                        } else if (name.equals("path")) {
                            int[] iArr5 = AndroidVectorResources.STYLEABLE_VECTOR_DRAWABLE_PATH;
                            if (theme == null) {
                                typedArrayObtainStyledAttributes2 = resources.obtainAttributes(attributeSetAsAttributeSet, iArr5);
                                i8 = 0;
                            } else {
                                i8 = 0;
                                typedArrayObtainStyledAttributes2 = theme.obtainStyledAttributes(attributeSetAsAttributeSet, iArr5, 0, 0);
                            }
                            snapshotDoubleIndexHeap.updateConfig(typedArrayObtainStyledAttributes2.getChangingConfigurations());
                            if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "pathData") == null) {
                                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("No path data available");
                                return null;
                            }
                            String string4 = typedArrayObtainStyledAttributes2.getString(i8);
                            snapshotDoubleIndexHeap.updateConfig(typedArrayObtainStyledAttributes2.getChangingConfigurations());
                            String str3 = string4 == null ? "" : string4;
                            String string5 = typedArrayObtainStyledAttributes2.getString(2);
                            snapshotDoubleIndexHeap.updateConfig(typedArrayObtainStyledAttributes2.getChangingConfigurations());
                            if (string5 != null) {
                                listPathStringToNodes$default = PathParser.pathStringToNodes$default(pathParser2, string5);
                            }
                            List list2 = listPathStringToNodes$default;
                            PriorityQueue namedComplexColor = snapshotDoubleIndexHeap.getNamedComplexColor(typedArrayObtainStyledAttributes2, theme, "fillColor", 1);
                            float namedFloat8 = snapshotDoubleIndexHeap.getNamedFloat(typedArrayObtainStyledAttributes2, "fillAlpha", 12, 1.0f);
                            int i26 = !CamUtils.hasAttribute((XmlPullParser) snapshotDoubleIndexHeap.values, "strokeLineCap") ? -1 : typedArrayObtainStyledAttributes2.getInt(8, -1);
                            snapshotDoubleIndexHeap.updateConfig(typedArrayObtainStyledAttributes2.getChangingConfigurations());
                            if (i26 == 0) {
                                i9 = 0;
                            } else if (i26 == 1) {
                                i9 = 1;
                            } else if (i26 != 2) {
                                i9 = 0;
                            } else {
                                i9 = 2;
                            }
                            int i27 = !CamUtils.hasAttribute((XmlPullParser) snapshotDoubleIndexHeap.values, "strokeLineJoin") ? -1 : typedArrayObtainStyledAttributes2.getInt(9, -1);
                            snapshotDoubleIndexHeap.updateConfig(typedArrayObtainStyledAttributes2.getChangingConfigurations());
                            if (i27 != 0) {
                                if (i27 == 1) {
                                    i10 = 1;
                                } else if (i27 == 2) {
                                    i10 = 2;
                                }
                                float namedFloat9 = snapshotDoubleIndexHeap.getNamedFloat(typedArrayObtainStyledAttributes2, "strokeMiterLimit", 10, 4.0f);
                                PriorityQueue namedComplexColor2 = snapshotDoubleIndexHeap.getNamedComplexColor(typedArrayObtainStyledAttributes2, theme, "strokeColor", 3);
                                float namedFloat10 = snapshotDoubleIndexHeap.getNamedFloat(typedArrayObtainStyledAttributes2, "strokeAlpha", 11, 1.0f);
                                float namedFloat11 = snapshotDoubleIndexHeap.getNamedFloat(typedArrayObtainStyledAttributes2, "strokeWidth", 4, 1.0f);
                                float namedFloat12 = snapshotDoubleIndexHeap.getNamedFloat(typedArrayObtainStyledAttributes2, "trimPathEnd", 6, 1.0f);
                                z = false;
                                float namedFloat13 = snapshotDoubleIndexHeap.getNamedFloat(typedArrayObtainStyledAttributes2, "trimPathOffset", 7, CropImageView.DEFAULT_ASPECT_RATIO);
                                float namedFloat14 = snapshotDoubleIndexHeap.getNamedFloat(typedArrayObtainStyledAttributes2, "trimPathStart", 5, CropImageView.DEFAULT_ASPECT_RATIO);
                                if (CamUtils.hasAttribute((XmlPullParser) snapshotDoubleIndexHeap.values, "fillType")) {
                                    i11 = typedArrayObtainStyledAttributes2.getInt(13, 0);
                                } else {
                                    i11 = 0;
                                }
                                snapshotDoubleIndexHeap.updateConfig(typedArrayObtainStyledAttributes2.getChangingConfigurations());
                                typedArrayObtainStyledAttributes2.recycle();
                                shader = (Shader) namedComplexColor.array;
                                i12 = namedComplexColor.size;
                                if (shader == null && i12 == 0) {
                                    solidColor = null;
                                } else if (shader != null) {
                                    solidColor = new BrushKt$ShaderBrush$1(shader);
                                } else {
                                    solidColor = new SolidColor(((long) i12) << 32);
                                }
                                shader2 = (Shader) namedComplexColor2.array;
                                i13 = namedComplexColor2.size;
                                if (shader2 == null && i13 == 0) {
                                    solidColor2 = null;
                                } else if (shader2 != null) {
                                    solidColor2 = new BrushKt$ShaderBrush$1(shader2);
                                } else {
                                    solidColor2 = new SolidColor(((long) i13) << 32);
                                }
                                if (i11 == 0) {
                                    i14 = 0;
                                } else {
                                    i14 = 1;
                                }
                                if (builder.isConsumed) {
                                    androidx.compose.ui.internal.InlineClassHelperKt.throwIllegalStateException("ImageVector.Builder is single use, create a new instance to create a new ImageVector");
                                }
                                ArrayList arrayList2 = builder.nodes;
                                ((ImageVector.Builder.GroupParams) arrayList2.get(arrayList2.size() - 1)).children.add(new VectorPath(str3, list2, i14, solidColor, namedFloat8, solidColor2, namedFloat10, namedFloat11, i9, i10, namedFloat9, namedFloat14, namedFloat12, namedFloat13));
                                i19 = i5;
                                i7 = 1;
                                b = -1;
                            }
                            i10 = 0;
                            float namedFloat15 = snapshotDoubleIndexHeap.getNamedFloat(typedArrayObtainStyledAttributes2, "strokeMiterLimit", 10, 4.0f);
                            PriorityQueue namedComplexColor3 = snapshotDoubleIndexHeap.getNamedComplexColor(typedArrayObtainStyledAttributes2, theme, "strokeColor", 3);
                            float namedFloat16 = snapshotDoubleIndexHeap.getNamedFloat(typedArrayObtainStyledAttributes2, "strokeAlpha", 11, 1.0f);
                            float namedFloat17 = snapshotDoubleIndexHeap.getNamedFloat(typedArrayObtainStyledAttributes2, "strokeWidth", 4, 1.0f);
                            float namedFloat18 = snapshotDoubleIndexHeap.getNamedFloat(typedArrayObtainStyledAttributes2, "trimPathEnd", 6, 1.0f);
                            z = false;
                            float namedFloat19 = snapshotDoubleIndexHeap.getNamedFloat(typedArrayObtainStyledAttributes2, "trimPathOffset", 7, CropImageView.DEFAULT_ASPECT_RATIO);
                            float namedFloat110 = snapshotDoubleIndexHeap.getNamedFloat(typedArrayObtainStyledAttributes2, "trimPathStart", 5, CropImageView.DEFAULT_ASPECT_RATIO);
                            if (CamUtils.hasAttribute((XmlPullParser) snapshotDoubleIndexHeap.values, "fillType")) {
                                i11 = 0;
                            } else {
                                i11 = typedArrayObtainStyledAttributes2.getInt(13, 0);
                            }
                            snapshotDoubleIndexHeap.updateConfig(typedArrayObtainStyledAttributes2.getChangingConfigurations());
                            typedArrayObtainStyledAttributes2.recycle();
                            shader = (Shader) namedComplexColor.array;
                            i12 = namedComplexColor.size;
                            if (shader == null) {
                                solidColor = null;
                            } else if (shader != null) {
                                solidColor = new BrushKt$ShaderBrush$1(shader);
                            } else {
                                solidColor = new SolidColor(((long) i12) << 32);
                            }
                            shader2 = (Shader) namedComplexColor3.array;
                            i13 = namedComplexColor3.size;
                            if (shader2 == null) {
                                solidColor2 = null;
                            } else if (shader2 != null) {
                                solidColor2 = new BrushKt$ShaderBrush$1(shader2);
                            } else {
                                solidColor2 = new SolidColor(((long) i13) << 32);
                            }
                            if (i11 == 0) {
                                i14 = 0;
                            } else {
                                i14 = 1;
                            }
                            if (builder.isConsumed) {
                                androidx.compose.ui.internal.InlineClassHelperKt.throwIllegalStateException("ImageVector.Builder is single use, create a new instance to create a new ImageVector");
                            }
                            ArrayList arrayList3 = builder.nodes;
                            ((ImageVector.Builder.GroupParams) arrayList3.get(arrayList3.size() - 1)).children.add(new VectorPath(str3, list2, i14, solidColor, namedFloat8, solidColor2, namedFloat16, namedFloat17, i9, i10, namedFloat15, namedFloat110, namedFloat18, namedFloat19));
                            i19 = i5;
                            i7 = 1;
                            b = -1;
                        } else {
                            i7 = 1;
                            z = false;
                            b = -1;
                            i19 = i5;
                        }
                    } else {
                        i5 = i19;
                    }
                    i7 = i20;
                    z = false;
                    b = -1;
                    i19 = i5;
                }
                xml.next();
                i3 = i7;
                i16 = i21;
            }
            imageVectorEntry = new ImageVectorCache.ImageVectorEntry(builder.build(), i16 | snapshotDoubleIndexHeap.size);
            imageVectorCache.map.put(key, new WeakReference(imageVectorEntry));
        }
        VectorPainter vectorPainterRememberVectorPainter = PathParserKt.rememberVectorPainter(imageVectorEntry.imageVector, gapComposer);
        gapComposer.end(false);
        return vectorPainterRememberVectorPainter;
    }

    public static ViewInfo read(SQLiteConnection sQLiteConnection, String str) {
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT name, sql FROM sqlite_master WHERE type = 'view' AND name = '" + str + '\'');
        try {
            ViewInfo viewInfo = sQLiteStatementPrepare.step() ? new ViewInfo(sQLiteStatementPrepare.getText(0), sQLiteStatementPrepare.getText(1)) : new ViewInfo(str, null);
            StringsKt__IndentKt.closeFinally(sQLiteStatementPrepare, null);
            return viewInfo;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                StringsKt__IndentKt.closeFinally(sQLiteStatementPrepare, th);
                throw th2;
            }
        }
    }

    public static int readEscapedIntValue(VorbisBitArray vorbisBitArray, int i, int i2, int i3) {
        UtilsKt.checkArgument(Math.max(Math.max(i, i2), i3) <= 31);
        int i4 = (1 << i) - 1;
        int i5 = (1 << i2) - 1;
        Math.addExact(Math.addExact(i4, i5), 1 << i3);
        if (vorbisBitArray.bitsLeft() < i) {
            return -1;
        }
        int bits = vorbisBitArray.readBits(i);
        if (bits == i4) {
            if (vorbisBitArray.bitsLeft() < i2) {
                return -1;
            }
            int bits2 = vorbisBitArray.readBits(i2);
            bits += bits2;
            if (bits2 == i5) {
                if (vorbisBitArray.bitsLeft() < i3) {
                    return -1;
                }
                return vorbisBitArray.readBits(i3) + bits;
            }
        }
        return bits;
    }

    public static final void recursiveFetchArrayMap(ArrayMap arrayMap, boolean z, Function1 function1) {
        ArrayMap arrayMap2 = new ArrayMap(999);
        int i = arrayMap.size;
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            if (z) {
                arrayMap2.put(arrayMap.keyAt(i2), arrayMap.valueAt(i2));
            } else {
                arrayMap2.put(arrayMap.keyAt(i2), null);
            }
            i2++;
            i3++;
            if (i3 == 999) {
                function1.invoke(arrayMap2);
                if (!z) {
                    arrayMap.putAll(arrayMap2);
                }
                arrayMap2.clear();
                i3 = 0;
            }
        }
        if (i3 > 0) {
            function1.invoke(arrayMap2);
            if (z) {
                return;
            }
            arrayMap.putAll(arrayMap2);
        }
    }

    /* JADX INFO: renamed from: remove-impl, reason: not valid java name */
    public static final boolean m902removeimpl(MutableScatterMap mutableScatterMap, Object obj, Object obj2) {
        Object obj3 = mutableScatterMap.get(obj);
        if (obj3 == null) {
            return false;
        }
        if (!(obj3 instanceof MutableScatterSet)) {
            if (!obj3.equals(obj2)) {
                return false;
            }
            mutableScatterMap.remove(obj);
            return true;
        }
        MutableScatterSet mutableScatterSet = (MutableScatterSet) obj3;
        boolean zRemove = mutableScatterSet.remove(obj2);
        if (zRemove && mutableScatterSet.isEmpty()) {
            mutableScatterMap.remove(obj);
        }
        return zRemove;
    }

    /* JADX INFO: renamed from: removeScope-impl, reason: not valid java name */
    public static final void m903removeScopeimpl(MutableScatterMap mutableScatterMap, Object obj) {
        boolean zIsEmpty;
        long[] jArr = mutableScatterMap.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128) {
                        int i4 = (i << 3) + i3;
                        Object obj2 = mutableScatterMap.keys[i4];
                        Object obj3 = mutableScatterMap.values[i4];
                        if (obj3 instanceof MutableScatterSet) {
                            MutableScatterSet mutableScatterSet = (MutableScatterSet) obj3;
                            mutableScatterSet.remove(obj);
                            zIsEmpty = mutableScatterSet.isEmpty();
                        } else {
                            zIsEmpty = obj3 == obj;
                        }
                        if (zIsEmpty) {
                            mutableScatterMap.removeValueAt(i4);
                        }
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    public static void setFirstBaselineToTopHeight(TextView textView, int i) {
        if (i < 0) {
            Path$$ExternalSyntheticBUOutline0.m();
            return;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            HandlerCompat$Api28Impl.setFirstBaselineToTopHeight(textView, i);
            return;
        }
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i2 = textView.getIncludeFontPadding() ? fontMetricsInt.top : fontMetricsInt.ascent;
        if (i > Math.abs(i2)) {
            textView.setPadding(textView.getPaddingLeft(), i + i2, textView.getPaddingRight(), textView.getPaddingBottom());
        }
    }

    public static void setLastBaselineToBottomHeight(TextView textView, int i) {
        if (i < 0) {
            Path$$ExternalSyntheticBUOutline0.m();
            return;
        }
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i2 = textView.getIncludeFontPadding() ? fontMetricsInt.bottom : fontMetricsInt.descent;
        if (i > Math.abs(i2)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i - i2);
        }
    }

    public static void setLineHeight(TextView textView, int i) {
        if (i < 0) {
            Path$$ExternalSyntheticBUOutline0.m();
            return;
        }
        int fontMetricsInt = textView.getPaint().getFontMetricsInt(null);
        if (i != fontMetricsInt) {
            textView.setLineSpacing(i - fontMetricsInt, 1.0f);
        }
    }

    public static final void setOffloadEnabled(Player player, boolean z) {
        player.getClass();
        TrackSelectionParameters.Builder builderBuildUpon = player.getTrackSelectionParameters().buildUpon();
        TrackSelectionParameters.AudioOffloadPreferences.Builder builder = new TrackSelectionParameters.AudioOffloadPreferences.Builder();
        builder.audioOffloadMode = z ? 1 : 0;
        player.setTrackSelectionParameters(builderBuildUpon.setAudioOffloadPreferences(new TrackSelectionParameters.AudioOffloadPreferences(builder)).build());
    }

    public static void skipSbrConfig(VorbisBitArray vorbisBitArray) {
        vorbisBitArray.skipBits(3);
        vorbisBitArray.skipBits(8);
        boolean bit = vorbisBitArray.readBit();
        boolean bit2 = vorbisBitArray.readBit();
        if (bit) {
            vorbisBitArray.skipBits(5);
        }
        if (bit2) {
            vorbisBitArray.skipBits(6);
        }
    }

    public static void skipSpeakerConfig3d(VorbisBitArray vorbisBitArray) {
        int bits;
        int bits2 = vorbisBitArray.readBits(2);
        if (bits2 == 0) {
            vorbisBitArray.skipBits(6);
            return;
        }
        int escapedIntValue = readEscapedIntValue(vorbisBitArray, 5, 8, 16) + 1;
        if (bits2 == 1) {
            vorbisBitArray.skipBits(escapedIntValue * 7);
            return;
        }
        if (bits2 == 2) {
            boolean bit = vorbisBitArray.readBit();
            int i = bit ? 1 : 5;
            int i2 = bit ? 7 : 5;
            int i3 = bit ? 8 : 6;
            int i4 = 0;
            while (i4 < escapedIntValue) {
                if (vorbisBitArray.readBit()) {
                    vorbisBitArray.skipBits(7);
                    bits = 0;
                } else {
                    if (vorbisBitArray.readBits(2) == 3 && vorbisBitArray.readBits(i2) * i != 0) {
                        vorbisBitArray.skipBit();
                    }
                    bits = vorbisBitArray.readBits(i3) * i;
                    if (bits != 0 && bits != 180) {
                        vorbisBitArray.skipBit();
                    }
                    vorbisBitArray.skipBit();
                }
                if (bits != 0 && bits != 180 && vorbisBitArray.readBit()) {
                    i4++;
                }
                i4++;
            }
        }
    }

    public static final double spow(double d, double d2) {
        return Math.copySign(Math.pow(Math.abs(d), d2), d);
    }

    public static RoundedPolygon star$default(int i, CornerRounding cornerRounding) {
        cornerRounding.getClass();
        float[] fArr = new float[i * 4];
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            float f = Utils.FloatPi / i;
            long j = Utils.Zero;
            double d = 2.0f * f * i3;
            long jM1066plusybeJwSQ = DatabaseDao_Impl.AnonymousClass17.m1066plusybeJwSQ(DatabaseDao_Impl.AnonymousClass17.m1067timesso9K2fw(FloatFloatPair.m0constructorimpl((float) Math.cos(d), (float) Math.sin(d)), 1.0f), j);
            fArr[i2] = DatabaseDao_Impl.AnonymousClass17.m1063getXDnnuFBc(jM1066plusybeJwSQ) + CropImageView.DEFAULT_ASPECT_RATIO;
            fArr[i2 + 1] = DatabaseDao_Impl.AnonymousClass17.m1064getYDnnuFBc(jM1066plusybeJwSQ) + CropImageView.DEFAULT_ASPECT_RATIO;
            double d2 = f * ((i3 * 2) + 1);
            long jM1066plusybeJwSQ2 = DatabaseDao_Impl.AnonymousClass17.m1066plusybeJwSQ(DatabaseDao_Impl.AnonymousClass17.m1067timesso9K2fw(FloatFloatPair.m0constructorimpl((float) Math.cos(d2), (float) Math.sin(d2)), 0.8f), j);
            int i4 = i2 + 3;
            fArr[i2 + 2] = DatabaseDao_Impl.AnonymousClass17.m1063getXDnnuFBc(jM1066plusybeJwSQ2) + CropImageView.DEFAULT_ASPECT_RATIO;
            i2 += 4;
            fArr[i4] = DatabaseDao_Impl.AnonymousClass17.m1064getYDnnuFBc(jM1066plusybeJwSQ2) + CropImageView.DEFAULT_ASPECT_RATIO;
        }
        return SizeKt.RoundedPolygon(fArr, cornerRounding, null, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0029  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: synthesizeTypeface-FxwP2eA, reason: not valid java name */
    public static final Object m904synthesizeTypefaceFxwP2eA(int i, Object obj, ResourceFont resourceFont, FontWeight fontWeight, int i2) {
        Object[] objArr;
        if (!(obj instanceof Typeface)) {
            return obj;
        }
        boolean z = false;
        int i3 = 0;
        z = false;
        if ((i & 1) == 0 || Intrinsics.areEqual(resourceFont.weight, fontWeight)) {
            objArr = false;
        } else {
            FontWeight fontWeight2 = FontWeight.W600;
            if (fontWeight.compareTo(fontWeight2) < 0 || Intrinsics.compare(resourceFont.weight.weight, fontWeight2.weight) >= 0) {
                objArr = false;
            } else {
                objArr = true;
            }
        }
        Object[] objArr2 = ((i & 2) == 0 || i2 == resourceFont.style) ? false : true;
        if (objArr2 != true && objArr != true) {
            return obj;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            int i4 = objArr != false ? fontWeight.weight : resourceFont.weight.weight;
            if (objArr2 == false ? resourceFont.style : i2 == 1) {
                z = true;
            }
            return Typeface.create((Typeface) obj, i4, z);
        }
        Object[] objArr3 = objArr2 == true && i2 == 1;
        if (objArr3 == true && objArr == true) {
            i3 = 3;
        } else if (objArr == true) {
            i3 = 1;
        } else if (objArr3 != false) {
            i3 = 2;
        }
        return Typeface.create((Typeface) obj, i3);
    }

    public static final void throwIfClosed(RoomDatabase roomDatabase) {
        if (((AtomicBoolean) roomDatabase.closeBarrier.runningSyncCalls).get()) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Database is closed");
        }
    }

    public static final List toImmutableList(List list) {
        int size = list.size();
        if (size != 0) {
            return size != 1 ? Collections.unmodifiableList(new ArrayList(list)) : Collections.singletonList(CollectionsKt.first(list));
        }
        return EmptyList.INSTANCE;
    }

    public static final Map toImmutableMap(Map map) {
        int size = map.size();
        if (size == 0) {
            return EmptyMap.INSTANCE;
        }
        if (size != 1) {
            return Collections.unmodifiableMap(new LinkedHashMap(map));
        }
        Map.Entry entry = (Map.Entry) CollectionsKt.first(map.entrySet());
        return Collections.singletonMap(entry.getKey(), entry.getValue());
    }

    public static final void toggleRepeatMode(Player player) {
        player.getClass();
        int repeatMode = player.getRepeatMode();
        int i = 2;
        if (repeatMode != 0) {
            if (repeatMode == 1) {
                i = 0;
            } else {
                if (repeatMode != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m();
                    return;
                }
                i = 1;
            }
        }
        player.setRepeatMode(i);
    }

    public static final CharSequence trimToSafeLength(CharSequence charSequence) {
        if (charSequence.length() <= 5000) {
            return charSequence;
        }
        return (Character.isHighSurrogate(charSequence.charAt(4999)) && Character.isLowSurrogate(charSequence.charAt(5000))) ? StringsKt.take(charSequence, 4999) : StringsKt.take(charSequence, 5000);
    }

    public static ActionMode.Callback wrapCustomSelectionActionModeCallback(ActionMode.Callback callback, TextView textView) {
        return (Build.VERSION.SDK_INT > 27 || (callback instanceof TextViewCompat$OreoCallback) || callback == null) ? callback : new TextViewCompat$OreoCallback(callback, textView);
    }

    public static final long getSp(float f) {
        return pack(4294967296L, f);
    }

    public static final long getSp(int i) {
        return pack(4294967296L, i);
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListener
    public void onAnimationCancel() {
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListener
    public void onAnimationStart() {
    }
}
