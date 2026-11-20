package com.metrolist.music.ui.player;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.view.Window;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.collection.internal.Lock;
import androidx.compose.animation.AnimatedContentScopeImpl;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.CrossfadeKt$$ExternalSyntheticLambda3;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransitionImpl;
import androidx.compose.animation.ExitTransitionImpl;
import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimateAsState;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.BackgroundElement;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.IndicationNodeFactory;
import androidx.compose.foundation.MarqueeSpacing$Companion$$ExternalSyntheticLambda0;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.gestures.snapping.SnapFlingBehavior;
import androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.layout.AddedInsets;
import androidx.compose.foundation.layout.AndroidWindowInsets;
import androidx.compose.foundation.layout.Arrangement$End$1;
import androidx.compose.foundation.layout.Arrangement$SpacedAligned;
import androidx.compose.foundation.layout.Arrangement$Top$1;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsScopeImpl;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.FixedDpInsets;
import androidx.compose.foundation.layout.FlowRowOverflow;
import androidx.compose.foundation.layout.InsetsPaddingValues;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.LimitInsets;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsHolder;
import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.foundation.lazy.LazyListIntervalContent;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.lazy.grid.GridCells$Fixed;
import androidx.compose.foundation.lazy.grid.LazyGridIntervalContent;
import androidx.compose.foundation.lazy.grid.LazyGridItemScopeImpl;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.foundation.lazy.grid.LazyGridStateKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.CardKt$$ExternalSyntheticLambda1;
import androidx.compose.material3.ChipKt$$ExternalSyntheticLambda16;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.ListItemKt$$ExternalSyntheticLambda14;
import androidx.compose.material3.ListItemKt$$ExternalSyntheticLambda17;
import androidx.compose.material3.ListItemKt$$ExternalSyntheticLambda18;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.ScrimKt;
import androidx.compose.material3.ScrimKt$Scrim$dismissModifier$1$1;
import androidx.compose.material3.SliderColors;
import androidx.compose.material3.SliderDefaults;
import androidx.compose.material3.SliderKt;
import androidx.compose.material3.SliderKt$$ExternalSyntheticLambda8;
import androidx.compose.material3.SliderState;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.material3.SwipeToDismissBoxState;
import androidx.compose.material3.SwipeToDismissBoxValue;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda5;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.DerivedSnapshotState;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Latch$await$2$2;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.ParcelableSnapshotMutableLongState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.SnapshotStateKt__DerivedStateKt;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.ComposedModifier;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusTraversalKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.RectangleShapeKt$RectangleShape$1;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.ContentScale$Companion$Fit$1;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.LazyWindowInfo;
import androidx.compose.ui.platform.WindowInfo;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.GenericFontFamily;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.AndroidPopup_androidKt$SimpleStack$1$1;
import androidx.compose.ui.window.DialogProperties;
import androidx.core.provider.CallbackWrapper;
import androidx.core.view.WindowInsetsControllerCompat$Impl26;
import androidx.core.view.WindowInsetsControllerCompat$Impl30;
import androidx.core.view.WindowInsetsControllerCompat$Impl35;
import androidx.datastore.core.AtomicInt;
import androidx.datastore.preferences.core.Preferences$Key;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ProcessLifecycleOwner;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.media3.common.MediaItem;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.Timeline;
import androidx.media3.exoplayer.ExoPlayerImpl;
import androidx.navigation.NavHostController;
import androidx.navigation.compose.NavHostKt$NavHost$33$1;
import androidx.room.RoomDatabase$closeBarrier$1;
import androidx.sqlite.SQLite;
import coil3.ComponentRegistry$Builder$$ExternalSyntheticLambda2;
import coil3.RealImageLoader$execute$result$1;
import coil3.compose.AsyncImageKt;
import coil3.intercept.EngineInterceptor;
import coil3.request.CachePolicy;
import coil3.request.ImageRequest;
import coil3.request.ImageRequests_androidKt;
import coil3.util.FileSystemsKt;
import coil3.util.LifecyclesKt;
import com.google.common.math.IntMath;
import com.metrolist.innertubex.InnerTube$$ExternalSyntheticLambda2;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda1;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda22;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda59;
import com.metrolist.music.MainActivity$MetrolistApp$$inlined$rememberEnumPreference$1;
import com.metrolist.music.MainActivityKt;
import com.metrolist.music.constants.DimensionsKt;
import com.metrolist.music.constants.PlayerBackgroundStyle;
import com.metrolist.music.constants.PreferenceKeysKt;
import com.metrolist.music.constants.SliderStyle;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.LyricsEntity;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.db.entities.SongEntity;
import com.metrolist.music.listentogether.ListenTogetherManager;
import com.metrolist.music.listentogether.RoomRole;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.playback.CastConnectionHandler;
import com.metrolist.music.playback.DownloadUtil;
import com.metrolist.music.playback.MusicService;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.playback.SleepTimer;
import com.metrolist.music.ui.component.BottomSheetMenuKt;
import com.metrolist.music.ui.component.BottomSheetPageKt;
import com.metrolist.music.ui.component.BottomSheetPageState;
import com.metrolist.music.ui.component.BottomSheetState;
import com.metrolist.music.ui.component.BottomSheetState$preUpPostDownNestedScrollConnection$1;
import com.metrolist.music.ui.component.DialogKt;
import com.metrolist.music.ui.component.GlassComponentsKt;
import com.metrolist.music.ui.component.Icon;
import com.metrolist.music.ui.component.ItemsKt$$ExternalSyntheticLambda67;
import com.metrolist.music.ui.component.ItemsKt$reset$1;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.menu.AlbumMenuKt$$ExternalSyntheticLambda11;
import com.metrolist.music.ui.menu.AlbumMenuKt$$ExternalSyntheticLambda13;
import com.metrolist.music.ui.menu.PlayerMenuKt$$ExternalSyntheticLambda120;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda16;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda19;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda2;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda26;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda40;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda63;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda8;
import com.metrolist.music.ui.menu.SongMenuKt$SongMenu$lambda$33$0$$inlined$items$default$3;
import com.metrolist.music.ui.screens.AccountScreenKt$$ExternalSyntheticLambda5;
import com.metrolist.music.ui.screens.AlbumScreenKt$AlbumScreen$3$1$4$1$1;
import com.metrolist.music.ui.screens.AlbumScreenKt$AlbumScreen$3$1$4$2$1;
import com.metrolist.music.ui.screens.LoginScreenKt$$ExternalSyntheticLambda0;
import com.metrolist.music.ui.screens.settings.DarkMode;
import com.metrolist.music.ui.theme.UiStyleKt;
import com.metrolist.music.ui.utils.YouTubeUtilsKt;
import com.metrolist.music.utils.DataStoreKt$get$1;
import com.metrolist.music.utils.DataStoreKt$get$2;
import com.metrolist.music.utils.DataStoreKt$rememberPreference$1$1;
import com.metrolist.music.utils.NetworkConnectivityObserver;
import com.metrolist.music.utils.Updater$getAllReleases$2;
import com.metrolist.music.utils.UtilsKt;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.sse.ServerSentEventKt;
import io.ktor.util.StringValuesKt$$ExternalSyntheticLambda1;
import io.ktor.utils.io.ByteChannelKt;
import io.ktor.websocket.WebSocketDeflateExtensionKt;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.ClosedFloatRange;
import kotlin.reflect.KFunction;
import kotlin.sequences.SequencesKt;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.StandaloneCoroutine;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;
import okhttp3.Handshake$$ExternalSyntheticLambda0;
import org.xmlpull.v1.XmlPullParserException;
import sh.calvin.reorderable.DragGestureDetector$Press;
import sh.calvin.reorderable.ReorderableCollectionItemScopeImpl;
import sh.calvin.reorderable.ReorderableCollectionItemScopeImpl$draggableHandle$1;
import sh.calvin.reorderable.ReorderableLazyCollectionState$findTargetItem$1;
import sh.calvin.reorderable.ReorderableLazyListState;
import sh.calvin.reorderable.Scroller$ScrollInfo$Companion$Null$1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class QueueKt {
    public static final ComposableLambdaImpl lambda$307408888 = new ComposableLambdaImpl(false, 307408888, new ComposableSingletons$MiniPlayerKt$$ExternalSyntheticLambda0((byte) 0));

    /* JADX INFO: renamed from: lambda$-1145968738, reason: not valid java name */
    public static final ComposableLambdaImpl f287lambda$1145968738 = new ComposableLambdaImpl(false, -1145968738, new QueueKt$$ExternalSyntheticLambda36(18));
    public static final ComposableLambdaImpl lambda$273813238 = new ComposableLambdaImpl(false, 273813238, new ComposableSingletons$PlayerKt$$ExternalSyntheticLambda0(26));

    /* JADX INFO: renamed from: lambda$-816311244, reason: not valid java name */
    public static final ComposableLambdaImpl f295lambda$816311244 = new ComposableLambdaImpl(false, -816311244, new ComposableSingletons$PlayerKt$$ExternalSyntheticLambda0(27));
    public static final ComposableLambdaImpl lambda$1811824324 = new ComposableLambdaImpl(false, 1811824324, new ComposableSingletons$PlayerKt$$ExternalSyntheticLambda0(0));
    public static final ComposableLambdaImpl lambda$1200555266 = new ComposableLambdaImpl(false, 1200555266, new ComposableSingletons$PlayerKt$$ExternalSyntheticLambda0(28));
    public static final ComposableLambdaImpl lambda$255603966 = new ComposableLambdaImpl(false, 255603966, new QueueKt$$ExternalSyntheticLambda36(19));

    /* JADX INFO: renamed from: lambda$-50030563, reason: not valid java name */
    public static final ComposableLambdaImpl f293lambda$50030563 = new ComposableLambdaImpl(false, -50030563, new QueueKt$$ExternalSyntheticLambda36(20));

    /* JADX INFO: renamed from: lambda$-1273589771, reason: not valid java name */
    public static final ComposableLambdaImpl f288lambda$1273589771 = new ComposableLambdaImpl(false, -1273589771, new QueueKt$$ExternalSyntheticLambda36(21));
    public static final ComposableLambdaImpl lambda$293011627 = new ComposableLambdaImpl(false, 293011627, new QueueKt$$ExternalSyntheticLambda36(22));

    /* JADX INFO: renamed from: lambda$-365013809, reason: not valid java name */
    public static final ComposableLambdaImpl f292lambda$365013809 = new ComposableLambdaImpl(false, -365013809, new QueueKt$$ExternalSyntheticLambda36(23));
    public static final ComposableLambdaImpl lambda$1323551451 = new ComposableLambdaImpl(false, 1323551451, new ComposableSingletons$PlayerKt$$ExternalSyntheticLambda0(29));
    public static final ComposableLambdaImpl lambda$987304698 = new ComposableLambdaImpl(false, 987304698, new AccountScreenKt$$ExternalSyntheticLambda5(1));
    public static final ComposableLambdaImpl lambda$1790970603 = new ComposableLambdaImpl(false, 1790970603, new AccountScreenKt$$ExternalSyntheticLambda5(5));

    /* JADX INFO: renamed from: lambda$-56133041, reason: not valid java name */
    public static final ComposableLambdaImpl f294lambda$56133041 = new ComposableLambdaImpl(false, -56133041, new AccountScreenKt$$ExternalSyntheticLambda5(6));

    /* JADX INFO: renamed from: lambda$-1741163686, reason: not valid java name */
    public static final ComposableLambdaImpl f290lambda$1741163686 = new ComposableLambdaImpl(false, -1741163686, new AccountScreenKt$$ExternalSyntheticLambda5(7));

    /* JADX INFO: renamed from: lambda$-1566138954, reason: not valid java name */
    public static final ComposableLambdaImpl f289lambda$1566138954 = new ComposableLambdaImpl(false, -1566138954, new AccountScreenKt$$ExternalSyntheticLambda5(8));

    /* JADX INFO: renamed from: lambda$-287535297, reason: not valid java name */
    public static final ComposableLambdaImpl f291lambda$287535297 = new ComposableLambdaImpl(false, -287535297, new QueueKt$$ExternalSyntheticLambda36(29));
    public static final ComposableLambdaImpl lambda$109226664 = new ComposableLambdaImpl(false, 109226664, new QueueKt$$ExternalSyntheticLambda36(24));
    public static final ComposableLambdaImpl lambda$831004483 = new ComposableLambdaImpl(false, 831004483, new AccountScreenKt$$ExternalSyntheticLambda5(2));
    public static final ComposableLambdaImpl lambda$1699533484 = new ComposableLambdaImpl(false, 1699533484, new AccountScreenKt$$ExternalSyntheticLambda5(3));
    public static final ComposableLambdaImpl lambda$142341508 = new ComposableLambdaImpl(false, 142341508, new QueueKt$$ExternalSyntheticLambda36(25));
    public static final ComposableLambdaImpl lambda$1600649581 = new ComposableLambdaImpl(false, 1600649581, new QueueKt$$ExternalSyntheticLambda36(26));
    public static final ComposableLambdaImpl lambda$12398022 = new ComposableLambdaImpl(false, 12398022, new QueueKt$$ExternalSyntheticLambda36(27));
    public static final ComposableLambdaImpl lambda$616998205 = new ComposableLambdaImpl(false, 616998205, new QueueKt$$ExternalSyntheticLambda36(28));

    static {
        new ComposableLambdaImpl(false, 2146115953, new AccountScreenKt$$ExternalSyntheticLambda5((byte) 4));
    }

    /* JADX WARN: Code duplicated, block: B:234:0x0631  */
    /* JADX WARN: Code duplicated, block: B:237:0x063f  */
    /* JADX WARN: Code duplicated, block: B:371:0x0617 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v53 */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r13v1, types: [androidx.compose.runtime.Composer, androidx.compose.runtime.GapComposer] */
    /* JADX WARN: Type inference failed for: r4v0, types: [androidx.compose.runtime.GapComposer] */
    /* JADX WARN: Type inference failed for: r4v1, types: [androidx.compose.runtime.GapComposer] */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v22 */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v24 */
    /* JADX WARN: Type inference failed for: r4v25 */
    /* JADX WARN: Type inference failed for: r4v26, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v27 */
    /* JADX WARN: Type inference failed for: r4v28 */
    /* JADX WARN: Type inference failed for: r4v50 */
    /* JADX WARN: Type inference failed for: r4v53 */
    /* JADX WARN: Type inference failed for: r4v54 */
    /* JADX WARN: Type inference failed for: r4v55 */
    public static final void BottomSheetPlayer(final BottomSheetState bottomSheetState, final NavHostController navHostController, Modifier modifier, final boolean z, Composer composer, int i) {
        Modifier modifier2;
        ?? r4;
        Object obj;
        boolean z2;
        ?? r12;
        Context context;
        BottomSheetState bottomSheetState2;
        boolean z3;
        MutableState mutableState;
        Object obj2;
        long j;
        ?? r5;
        MutableState mutableStateCollectAsStateWithLifecycle;
        CastConnectionHandler castConnectionHandler;
        MutableState mutableStateCollectAsStateWithLifecycle2;
        boolean z4;
        MutableState mutableStateCollectAsStateWithLifecycle3;
        boolean z5;
        MutableState mutableStateCollectAsStateWithLifecycle4;
        boolean z6;
        MutableState mutableStateCollectAsState;
        boolean z7;
        Object obj3;
        Object failure;
        Object obj4;
        Object obj5;
        boolean z8;
        String str;
        Object obj6;
        PlayerConnection playerConnection;
        Object obj7;
        NeverEqualPolicy neverEqualPolicy;
        PlayerConnection playerConnection2;
        int i2;
        ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState;
        Function0 function0;
        Object obj8;
        MutableState mutableState2;
        MutableState mutableState3;
        boolean z9;
        final PlayerConnection playerConnection3;
        MutableState mutableState4;
        ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState2;
        final long j2;
        byte b;
        Object obj9;
        Object obj10;
        Object failure2;
        Object obj11;
        long jLongValue;
        Object obj12;
        Object obj13;
        Object obj14;
        Object obj15;
        navHostController.getClass();
        ?? r13 = (GapComposer) composer;
        r13.startRestartGroup(849535127);
        int i3 = (r13.changed(bottomSheetState) ? 4 : 2) | i | (r13.changedInstance(navHostController) ? 32 : 16) | 384 | (r13.changed(z) ? 2048 : 1024);
        if (r13.shouldExecute(i3 & 1, (i3 & 1171) != 1170)) {
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = AndroidCompositionLocals_androidKt.LocalContext;
            final Context context2 = (Context) r13.consume(staticProvidableCompositionLocal);
            Object systemService = context2.getSystemService("clipboard");
            systemService.getClass();
            final ClipboardManager clipboardManager = (ClipboardManager) systemService;
            final MenuState menuState = (MenuState) r13.consume(BottomSheetMenuKt.LocalMenuState);
            String strStringResource = MathKt.stringResource(R.string.sleep_timer_default_set, r13);
            final String strStringResource2 = MathKt.stringResource(R.string.copied_title, r13);
            final String strStringResource3 = MathKt.stringResource(R.string.copied_artist, r13);
            final BottomSheetPageState bottomSheetPageState = (BottomSheetPageState) r13.consume(BottomSheetPageKt.LocalBottomSheetPageState);
            PlayerConnection playerConnection4 = (PlayerConnection) r13.consume(MainActivityKt.LocalPlayerConnection);
            if (playerConnection4 == null) {
                RecomposeScopeImpl recomposeScopeImplEndRestartGroup = r13.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new StringValuesKt$$ExternalSyntheticLambda1(bottomSheetState, navHostController, z, i);
                    return;
                }
                return;
            }
            MusicService musicService = playerConnection4.service;
            ((Boolean) UtilsKt.rememberPreference(PreferenceKeysKt.UseNewPlayerDesignKey, Boolean.TRUE, r13, 48).$state.getValue()).getClass();
            Preferences$Key preferences$Key = PreferenceKeysKt.HidePlayerThumbnailKey;
            Boolean bool = Boolean.FALSE;
            final boolean zBooleanValue = ((Boolean) UtilsKt.rememberPreference(preferences$Key, bool, r13, 48).$state.getValue()).booleanValue();
            Boolean bool2 = (Boolean) UtilsKt.rememberPreference(PreferenceKeysKt.HideStatusBarOnFullscreenKey, bool, r13, 48).$state.getValue();
            final boolean zBooleanValue2 = bool2.booleanValue();
            final DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference = UtilsKt.rememberPreference(PreferenceKeysKt.CropAlbumArtKey, bool, r13, 48);
            Object[] objArr = new Object[0];
            Object objRememberedValue = r13.rememberedValue();
            NeverEqualPolicy neverEqualPolicy2 = Composer.Companion.Empty;
            if (objRememberedValue == neverEqualPolicy2) {
                QueueKt$$ExternalSyntheticLambda2 queueKt$$ExternalSyntheticLambda2 = new QueueKt$$ExternalSyntheticLambda2((byte) 19);
                r13.updateRememberedValue(queueKt$$ExternalSyntheticLambda2);
                obj = queueKt$$ExternalSyntheticLambda2;
            } else {
                obj = objRememberedValue;
            }
            final MutableState mutableState5 = (MutableState) SaverKt.rememberSaveable(objArr, (Function0) obj, r13, 48);
            Object[] objArr2 = new Object[0];
            Object objRememberedValue2 = r13.rememberedValue();
            Object obj16 = objRememberedValue2;
            if (objRememberedValue2 == neverEqualPolicy2) {
                QueueKt$$ExternalSyntheticLambda2 queueKt$$ExternalSyntheticLambda3 = new QueueKt$$ExternalSyntheticLambda2((byte) 20);
                r13.updateRememberedValue(queueKt$$ExternalSyntheticLambda3);
                obj16 = queueKt$$ExternalSyntheticLambda3;
            }
            final MutableState mutableState6 = (MutableState) SaverKt.rememberSaveable(objArr2, (Function0) obj16, r13, 48);
            final boolean zIsGlassStyle = UiStyleKt.isGlassStyle(r13);
            boolean zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(r13);
            Preferences$Key preferences$Key2 = PreferenceKeysKt.DarkModeKey;
            Context context3 = (Context) r13.consume(staticProvidableCompositionLocal);
            Object objRememberedValue3 = r13.rememberedValue();
            Object obj17 = objRememberedValue3;
            if (objRememberedValue3 == neverEqualPolicy2) {
                CoroutineScope coroutineScopeCreateCompositionCoroutineScope = Stack.createCompositionCoroutineScope(r13);
                r13.updateRememberedValue(coroutineScopeCreateCompositionCoroutineScope);
                obj17 = coroutineScopeCreateCompositionCoroutineScope;
            }
            CoroutineScope coroutineScope = (CoroutineScope) obj17;
            Object objRememberedValue4 = r13.rememberedValue();
            Object obj18 = objRememberedValue4;
            if (objRememberedValue4 == neverEqualPolicy2) {
                Flow flowDistinctUntilChanged = StateFlowKt.distinctUntilChanged(new MainActivity$MetrolistApp$$inlined$rememberEnumPreference$1(UtilsKt.getDataStore(context3).getData(), preferences$Key2, (byte) 17));
                r13.updateRememberedValue(flowDistinctUntilChanged);
                obj18 = flowDistinctUntilChanged;
            }
            DarkMode darkMode = DarkMode.AUTO;
            MutableState mutableStateCollectAsStateWithLifecycle5 = FileSystemsKt.collectAsStateWithLifecycle((Flow) obj18, darkMode, r13, 48);
            Object objRememberedValue5 = r13.rememberedValue();
            Object obj19 = objRememberedValue5;
            if (objRememberedValue5 == neverEqualPolicy2) {
                PlayerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$2 playerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$2 = new PlayerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$2(mutableStateCollectAsStateWithLifecycle5, coroutineScope, context3, preferences$Key2);
                r13.updateRememberedValue(playerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$2);
                obj19 = playerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$2;
            }
            PlayerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$2 playerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$3 = (PlayerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$2) obj19;
            boolean zChanged = r13.changed(((DarkMode) playerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$3.getValue()).ordinal()) | r13.changed(zIsSystemInDarkTheme);
            Object objRememberedValue6 = r13.rememberedValue();
            DarkMode darkMode2 = DarkMode.ON;
            Object obj20 = objRememberedValue6;
            if (zChanged || objRememberedValue6 == neverEqualPolicy2) {
                if (((DarkMode) playerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$3.getValue()) == darkMode) {
                    z2 = zIsSystemInDarkTheme;
                } else {
                    z2 = ((DarkMode) playerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$3.getValue()) == darkMode2;
                }
                Boolean boolValueOf = Boolean.valueOf(z2);
                r13.updateRememberedValue(boolValueOf);
                obj20 = boolValueOf;
            }
            Boolean bool3 = (Boolean) obj20;
            final boolean zBooleanValue3 = bool3.booleanValue();
            boolean zChanged2 = r13.changed(zBooleanValue3);
            Object objRememberedValue7 = r13.rememberedValue();
            if (zChanged2 || objRememberedValue7 == neverEqualPolicy2) {
                r13.updateRememberedValue(bool3);
                objRememberedValue7 = bool3;
            }
            ((Boolean) objRememberedValue7).getClass();
            MutableState mutableStateCollectAsState2 = Stack.collectAsState(playerConnection4.isPlaying, r13, 3);
            boolean z10 = ((Boolean) mutableStateCollectAsState2.getValue()).booleanValue() && ((Boolean) UtilsKt.rememberPreference(PreferenceKeysKt.KeepScreenOn, bool, r13, 48).$state.getValue()).booleanValue();
            Object[] objArr3 = {PlayerBackgroundStyle.DEFAULT, Boolean.valueOf(bottomSheetState.isExpanded()), bool3, Boolean.valueOf(z10), Boolean.valueOf(((Boolean) mutableState6.getValue()).booleanValue()), bool2};
            int i4 = i3 & 14;
            boolean zChangedInstance = r13.changedInstance(context2) | (i4 == 4) | r13.changed(zBooleanValue3) | r13.changed(mutableState6) | r13.changed(zBooleanValue2) | r13.changed(z10);
            final boolean z11 = z10;
            Object objRememberedValue8 = r13.rememberedValue();
            if (zChangedInstance || objRememberedValue8 == neverEqualPolicy2) {
                r12 = 0;
                Function1 function1 = new Function1() { // from class: com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda87
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj21) {
                        LifecyclesKt windowInsetsControllerCompat$Impl30;
                        ((DisposableEffectScope) obj21).getClass();
                        Context context4 = context2;
                        Activity activity = context4 instanceof Activity ? (Activity) context4 : null;
                        final Window window = activity != null ? activity.getWindow() : null;
                        final boolean z12 = zBooleanValue3;
                        if (window != null) {
                            BottomSheetState bottomSheetState3 = bottomSheetState;
                            if (bottomSheetState3.isExpanded()) {
                                AtomicInt atomicInt = new AtomicInt(window.getDecorView());
                                int i5 = Build.VERSION.SDK_INT;
                                if (i5 >= 35) {
                                    windowInsetsControllerCompat$Impl30 = new WindowInsetsControllerCompat$Impl35(window, atomicInt);
                                } else {
                                    windowInsetsControllerCompat$Impl30 = i5 >= 30 ? new WindowInsetsControllerCompat$Impl30(window, atomicInt) : new WindowInsetsControllerCompat$Impl26(window, atomicInt);
                                }
                                windowInsetsControllerCompat$Impl30.setAppearanceLightStatusBars(!z12);
                                if (((Boolean) mutableState6.getValue()).booleanValue() && zBooleanValue2) {
                                    windowInsetsControllerCompat$Impl30.hide();
                                    windowInsetsControllerCompat$Impl30.setSystemBarsBehavior();
                                } else {
                                    windowInsetsControllerCompat$Impl30.show();
                                }
                                if (z11 && bottomSheetState3.isExpanded()) {
                                    window.addFlags(128);
                                } else {
                                    window.clearFlags(128);
                                }
                            }
                        }
                        return new DisposableEffectResult() { // from class: com.metrolist.music.ui.player.PlayerKt$BottomSheetPlayer$lambda$13$0$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public final void dispose() {
                                LifecyclesKt windowInsetsControllerCompat$Impl31;
                                Window window2 = window;
                                if (window2 != null) {
                                    AtomicInt atomicInt2 = new AtomicInt(window2.getDecorView());
                                    int i6 = Build.VERSION.SDK_INT;
                                    if (i6 >= 35) {
                                        windowInsetsControllerCompat$Impl31 = new WindowInsetsControllerCompat$Impl35(window2, atomicInt2);
                                    } else {
                                        windowInsetsControllerCompat$Impl31 = i6 >= 30 ? new WindowInsetsControllerCompat$Impl30(window2, atomicInt2) : new WindowInsetsControllerCompat$Impl26(window2, atomicInt2);
                                    }
                                    windowInsetsControllerCompat$Impl31.setAppearanceLightStatusBars(!z12);
                                    windowInsetsControllerCompat$Impl31.show();
                                    window2.clearFlags(128);
                                }
                            }
                        };
                    }
                };
                context = context2;
                bottomSheetState2 = bottomSheetState;
                z3 = zBooleanValue3;
                mutableState = mutableState6;
                r13.updateRememberedValue(function1);
                obj2 = function1;
            } else {
                bottomSheetState2 = bottomSheetState;
                z3 = zBooleanValue3;
                mutableState = mutableState6;
                r12 = 0;
                context = context2;
                obj2 = objRememberedValue8;
            }
            Stack.DisposableEffect(objArr3, (Function1) obj2, (Composer) r13);
            boolean zIsExpanded = bottomSheetState2.isExpanded();
            ?? r6 = i4 == 4 ? 1 : r12;
            Object objRememberedValue9 = r13.rememberedValue();
            Object obj21 = objRememberedValue9;
            if (r6 != 0 || objRememberedValue9 == neverEqualPolicy2) {
                PlayerKt$$ExternalSyntheticLambda0 playerKt$$ExternalSyntheticLambda0 = new PlayerKt$$ExternalSyntheticLambda0(bottomSheetState2, (byte) 8);
                r13.updateRememberedValue(playerKt$$ExternalSyntheticLambda0);
                obj21 = playerKt$$ExternalSyntheticLambda0;
            }
            coil3.util.UtilsKt.BackHandler(zIsExpanded, (Function0) obj21, r13, r12, r12);
            if (PlayerKt$WhenMappings.$EnumSwitchMapping$0[r12] == 3) {
                r13.startReplaceGroup(359605120);
                j = ((MaterialTheme$Values) r13.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.secondary;
                r13.end(r12);
            } else {
                r13.startReplaceGroup(359606912);
                j = ((MaterialTheme$Values) r13.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.onSurface;
                r13.end(r12);
            }
            final long j3 = j;
            ?? r0 = (r13.changed(((DarkMode) playerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$3.getValue()).ordinal()) ? 1 : 0) | (r13.changed(zIsSystemInDarkTheme) ? 1 : 0) | ((i3 & 7168) == 2048 ? 1 : r12);
            Object objRememberedValue10 = r13.rememberedValue();
            Object obj22 = objRememberedValue10;
            if (r0 != 0 || objRememberedValue10 == neverEqualPolicy2) {
                if (((DarkMode) playerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$3.getValue()) == darkMode) {
                    r5 = zIsSystemInDarkTheme;
                } else {
                    r5 = ((DarkMode) playerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$3.getValue()) == darkMode2 ? 1 : r12;
                }
                Boolean boolValueOf2 = Boolean.valueOf((boolean) ((r5 == 0 || !z) ? r12 : 1));
                r13.updateRememberedValue(boolValueOf2);
                obj22 = boolValueOf2;
            }
            final boolean zBooleanValue4 = ((Boolean) obj22).booleanValue();
            MutableState mutableStateCollectAsState3 = Stack.collectAsState(playerConnection4.playbackState, r13, 3);
            final MutableState mutableStateCollectAsState4 = Stack.collectAsState(playerConnection4.mediaMetadata, r13, 3);
            final MutableState mutableStateCollectAsStateWithLifecycle6 = FileSystemsKt.collectAsStateWithLifecycle(playerConnection4.currentSong, null, r13, 48);
            MutableState mutableStateCollectAsStateWithLifecycle7 = FileSystemsKt.collectAsStateWithLifecycle(musicService.automixItems, r13);
            MutableState mutableStateCollectAsStateWithLifecycle8 = FileSystemsKt.collectAsStateWithLifecycle(playerConnection4.repeatMode, r13);
            final MutableState mutableStateCollectAsStateWithLifecycle9 = FileSystemsKt.collectAsStateWithLifecycle(playerConnection4.canSkipPrevious, r13);
            final MutableState mutableStateCollectAsStateWithLifecycle10 = FileSystemsKt.collectAsStateWithLifecycle(playerConnection4.canSkipNext, r13);
            final MutableState mutableStateCollectAsStateWithLifecycle11 = FileSystemsKt.collectAsStateWithLifecycle(playerConnection4.isMuted, r13);
            final MutableState mutableStateCollectAsStateWithLifecycle12 = FileSystemsKt.collectAsStateWithLifecycle(playerConnection4.shuffleModeEnabled, r13);
            Preferences$Key preferences$Key3 = PreferenceKeysKt.SliderStyleKey;
            Context context4 = (Context) r13.consume(staticProvidableCompositionLocal);
            Object objRememberedValue11 = r13.rememberedValue();
            Object obj23 = objRememberedValue11;
            if (objRememberedValue11 == neverEqualPolicy2) {
                CoroutineScope coroutineScopeCreateCompositionCoroutineScope2 = Stack.createCompositionCoroutineScope(r13);
                r13.updateRememberedValue(coroutineScopeCreateCompositionCoroutineScope2);
                obj23 = coroutineScopeCreateCompositionCoroutineScope2;
            }
            CoroutineScope coroutineScope2 = (CoroutineScope) obj23;
            Object objRememberedValue12 = r13.rememberedValue();
            Object obj24 = objRememberedValue12;
            if (objRememberedValue12 == neverEqualPolicy2) {
                Flow flowDistinctUntilChanged2 = StateFlowKt.distinctUntilChanged(new MainActivity$MetrolistApp$$inlined$rememberEnumPreference$1(UtilsKt.getDataStore(context4).getData(), preferences$Key3, (byte) 18));
                r13.updateRememberedValue(flowDistinctUntilChanged2);
                obj24 = flowDistinctUntilChanged2;
            }
            MutableState mutableStateCollectAsStateWithLifecycle13 = FileSystemsKt.collectAsStateWithLifecycle((Flow) obj24, SliderStyle.DEFAULT, r13, 48);
            Object objRememberedValue13 = r13.rememberedValue();
            Object obj25 = objRememberedValue13;
            if (objRememberedValue13 == neverEqualPolicy2) {
                PlayerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$4 playerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$4 = new PlayerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$4(mutableStateCollectAsStateWithLifecycle13, coroutineScope2, context4, preferences$Key3);
                r13.updateRememberedValue(playerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$4);
                obj25 = playerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$4;
            }
            final PlayerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$4 playerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$5 = (PlayerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$4) obj25;
            final DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference2 = UtilsKt.rememberPreference(PreferenceKeysKt.SquigglySliderKey, bool, r13, 48);
            ListenTogetherManager listenTogetherManager = (ListenTogetherManager) r13.consume(MainActivityKt.LocalListenTogetherManager);
            ReadonlyStateFlow readonlyStateFlow = listenTogetherManager != null ? listenTogetherManager.role : null;
            if (readonlyStateFlow == null) {
                r13.startReplaceGroup(-1735711215);
                r13.end(false);
                mutableStateCollectAsStateWithLifecycle = null;
            } else {
                r13.startReplaceGroup(359651312);
                mutableStateCollectAsStateWithLifecycle = FileSystemsKt.collectAsStateWithLifecycle(readonlyStateFlow, RoomRole.NONE, r13, 48);
                r13.end(false);
            }
            boolean z12 = (mutableStateCollectAsStateWithLifecycle != null ? (RoomRole) mutableStateCollectAsStateWithLifecycle.getValue() : null) == RoomRole.GUEST;
            boolean zChanged3 = r13.changed(playerConnection4);
            Object objRememberedValue14 = r13.rememberedValue();
            if (zChanged3 || objRememberedValue14 == neverEqualPolicy2) {
                try {
                    castConnectionHandler = musicService.castConnectionHandler;
                } catch (Exception unused) {
                    castConnectionHandler = null;
                }
                r13.updateRememberedValue(castConnectionHandler);
                objRememberedValue14 = castConnectionHandler;
            }
            final CastConnectionHandler castConnectionHandler2 = (CastConnectionHandler) objRememberedValue14;
            StateFlowImpl stateFlowImpl = castConnectionHandler2 != null ? castConnectionHandler2.isCasting : null;
            if (stateFlowImpl == null) {
                r13.startReplaceGroup(-1735201203);
                r13.end(false);
                mutableStateCollectAsStateWithLifecycle2 = null;
            } else {
                r13.startReplaceGroup(359667764);
                mutableStateCollectAsStateWithLifecycle2 = FileSystemsKt.collectAsStateWithLifecycle(stateFlowImpl, r13);
                r13.end(false);
            }
            if (mutableStateCollectAsStateWithLifecycle2 == null) {
                r13.startReplaceGroup(-1735168311);
                Object objRememberedValue15 = r13.rememberedValue();
                if (objRememberedValue15 == neverEqualPolicy2) {
                    obj15 = objRememberedValue15;
                    ParcelableSnapshotMutableState parcelableSnapshotMutableStateMutableStateOf$default = Stack.mutableStateOf$default(Boolean.FALSE);
                    r13.updateRememberedValue(parcelableSnapshotMutableStateMutableStateOf$default);
                    obj15 = parcelableSnapshotMutableStateMutableStateOf$default;
                }
                obj15 = objRememberedValue15;
                mutableStateCollectAsStateWithLifecycle2 = (MutableState) obj15;
                z4 = false;
            } else {
                z4 = false;
                r13.startReplaceGroup(359667058);
            }
            r13.end(z4);
            MutableState mutableState7 = mutableStateCollectAsStateWithLifecycle2;
            StateFlowImpl stateFlowImpl2 = castConnectionHandler2 != null ? castConnectionHandler2.castPosition : null;
            if (stateFlowImpl2 == null) {
                r13.startReplaceGroup(-1735083155);
                r13.end(z4);
                mutableStateCollectAsStateWithLifecycle3 = null;
            } else {
                r13.startReplaceGroup(359671572);
                mutableStateCollectAsStateWithLifecycle3 = FileSystemsKt.collectAsStateWithLifecycle(stateFlowImpl2, r13);
                r13.end(false);
            }
            if (mutableStateCollectAsStateWithLifecycle3 == null) {
                r13.startReplaceGroup(-1735050232);
                Object objRememberedValue16 = r13.rememberedValue();
                if (objRememberedValue16 == neverEqualPolicy2) {
                    ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState3 = new ParcelableSnapshotMutableLongState(0L);
                    r13.updateRememberedValue(parcelableSnapshotMutableLongState3);
                    obj14 = parcelableSnapshotMutableLongState3;
                } else {
                    obj14 = objRememberedValue16;
                }
                mutableStateCollectAsStateWithLifecycle3 = (ParcelableSnapshotMutableLongState) obj14;
                z5 = false;
            } else {
                mutableStateCollectAsStateWithLifecycle7 = mutableStateCollectAsStateWithLifecycle7;
                z12 = z12;
                z5 = false;
                r13.startReplaceGroup(359670774);
            }
            r13.end(z5);
            MutableState mutableState8 = mutableStateCollectAsStateWithLifecycle3;
            StateFlowImpl stateFlowImpl3 = castConnectionHandler2 != null ? castConnectionHandler2.castDuration : null;
            if (stateFlowImpl3 == null) {
                r13.startReplaceGroup(-1734964115);
                r13.end(z5);
                mutableStateCollectAsStateWithLifecycle4 = null;
            } else {
                r13.startReplaceGroup(359675412);
                mutableStateCollectAsStateWithLifecycle4 = FileSystemsKt.collectAsStateWithLifecycle(stateFlowImpl3, r13);
                r13.end(z5);
            }
            if (mutableStateCollectAsStateWithLifecycle4 == null) {
                r13.startReplaceGroup(-1734931192);
                Object objRememberedValue17 = r13.rememberedValue();
                if (objRememberedValue17 == neverEqualPolicy2) {
                    obj13 = objRememberedValue17;
                    ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState4 = new ParcelableSnapshotMutableLongState(0L);
                    r13.updateRememberedValue(parcelableSnapshotMutableLongState4);
                    obj13 = parcelableSnapshotMutableLongState4;
                }
                obj13 = objRememberedValue17;
                mutableStateCollectAsStateWithLifecycle4 = (ParcelableSnapshotMutableLongState) obj13;
                z6 = false;
            } else {
                z6 = false;
                r13.startReplaceGroup(359674614);
            }
            r13.end(z6);
            MutableState mutableState9 = mutableStateCollectAsStateWithLifecycle4;
            StateFlowImpl stateFlowImpl4 = castConnectionHandler2 != null ? castConnectionHandler2.castIsPlaying : null;
            if (stateFlowImpl4 == null) {
                r13.startReplaceGroup(-1734843494);
                r13.end(z6);
                mutableStateCollectAsState = null;
            } else {
                r13.startReplaceGroup(359679303);
                mutableStateCollectAsState = Stack.collectAsState(stateFlowImpl4, r13, 3);
                r13.end(z6);
            }
            if (mutableStateCollectAsState == null) {
                r13.startReplaceGroup(-1734823095);
                Object objRememberedValue18 = r13.rememberedValue();
                if (objRememberedValue18 == neverEqualPolicy2) {
                    obj12 = objRememberedValue18;
                    ParcelableSnapshotMutableState parcelableSnapshotMutableStateMutableStateOf$default2 = Stack.mutableStateOf$default(Boolean.FALSE);
                    r13.updateRememberedValue(parcelableSnapshotMutableStateMutableStateOf$default2);
                    obj12 = parcelableSnapshotMutableStateMutableStateOf$default2;
                }
                obj12 = objRememberedValue18;
                mutableStateCollectAsState = (MutableState) obj12;
                z7 = false;
            } else {
                z7 = false;
                r13.startReplaceGroup(359678473);
            }
            r13.end(z7);
            final MutableState mutableState10 = mutableStateCollectAsState;
            Object objRememberedValue19 = r13.rememberedValue();
            Object obj26 = objRememberedValue19;
            if (objRememberedValue19 == neverEqualPolicy2) {
                FocusRequester focusRequester = new FocusRequester();
                r13.updateRememberedValue(focusRequester);
                obj26 = focusRequester;
            }
            final FocusRequester focusRequester2 = (FocusRequester) obj26;
            Boolean boolValueOf3 = Boolean.valueOf(bottomSheetState2.isExpanded());
            boolean z13 = i4 == 4;
            Object objRememberedValue20 = r13.rememberedValue();
            if (z13 || objRememberedValue20 == neverEqualPolicy2) {
                DataStoreKt$get$1 dataStoreKt$get$1 = new DataStoreKt$get$1((Object) bottomSheetState2, (Object) focusRequester2, (Continuation) null, (byte) 3);
                r13.updateRememberedValue(dataStoreKt$get$1);
                obj3 = dataStoreKt$get$1;
            } else {
                obj3 = objRememberedValue20;
            }
            Stack.LaunchedEffect((Composer) r13, boolValueOf3, (Function2) obj3);
            final boolean zBooleanValue5 = ((Boolean) mutableState7.getValue()).booleanValue() ? ((Boolean) mutableState10.getValue()).booleanValue() : ((Boolean) mutableStateCollectAsState2.getValue()).booleanValue();
            Object objRememberedValue21 = r13.rememberedValue();
            if (objRememberedValue21 == neverEqualPolicy2) {
                try {
                    failure = Long.valueOf(playerConnection4.getPlayerSafe().getCurrentPosition());
                } catch (Throwable th) {
                    failure = new Result.Failure(th);
                }
                boolean z14 = failure instanceof Result.Failure;
                Object obj27 = failure;
                if (z14) {
                    obj27 = null;
                }
                ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState5 = new ParcelableSnapshotMutableLongState(((Number) obj27).longValue());
                r13.updateRememberedValue(parcelableSnapshotMutableLongState5);
                objRememberedValue21 = parcelableSnapshotMutableLongState5;
            }
            final ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState6 = (ParcelableSnapshotMutableLongState) objRememberedValue21;
            Object objRememberedValue22 = r13.rememberedValue();
            if (objRememberedValue22 == neverEqualPolicy2) {
                MediaMetadata mediaMetadata = (MediaMetadata) mutableStateCollectAsState4.getValue();
                if (mediaMetadata != null) {
                    int i5 = mediaMetadata.duration;
                    Integer numValueOf = Integer.valueOf(i5);
                    if (i5 <= 0) {
                        numValueOf = null;
                    }
                    if (numValueOf != null) {
                        jLongValue = ((long) numValueOf.intValue()) * 1000;
                    } else {
                        try {
                            failure2 = Long.valueOf(playerConnection4.getPlayerSafe().getDuration());
                        } catch (Throwable th2) {
                            failure2 = new Result.Failure(th2);
                        }
                        obj11 = null;
                        if (!(failure2 instanceof Result.Failure)) {
                            obj11 = failure2;
                        }
                        jLongValue = ((Number) obj11).longValue();
                        if (jLongValue < 0) {
                            jLongValue = 0;
                        }
                    }
                } else {
                    failure2 = Long.valueOf(playerConnection4.getPlayerSafe().getDuration());
                    obj11 = null;
                    if (!(failure2 instanceof Result.Failure)) {
                        obj11 = failure2;
                    }
                    jLongValue = ((Number) obj11).longValue();
                    if (jLongValue < 0) {
                        jLongValue = 0;
                    }
                }
                ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState7 = new ParcelableSnapshotMutableLongState(jLongValue);
                r13.updateRememberedValue(parcelableSnapshotMutableLongState7);
                objRememberedValue22 = parcelableSnapshotMutableLongState7;
            }
            ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState8 = (ParcelableSnapshotMutableLongState) objRememberedValue22;
            Object objRememberedValue23 = r13.rememberedValue();
            if (objRememberedValue23 == neverEqualPolicy2) {
                DerivedSnapshotState derivedSnapshotStateDerivedStateOf = SnapshotStateKt__DerivedStateKt.derivedStateOf(new QueueKt$$ExternalSyntheticLambda24((Object) mutableState7, (Object) mutableState8, (Object) parcelableSnapshotMutableLongState6, (byte) 1));
                r13.updateRememberedValue(derivedSnapshotStateDerivedStateOf);
                obj4 = derivedSnapshotStateDerivedStateOf;
            } else {
                obj4 = objRememberedValue23;
            }
            final State state = (State) obj4;
            Object objRememberedValue24 = r13.rememberedValue();
            if (objRememberedValue24 == neverEqualPolicy2) {
                ParcelableSnapshotMutableState parcelableSnapshotMutableStateMutableStateOf$default3 = Stack.mutableStateOf$default(null);
                r13.updateRememberedValue(parcelableSnapshotMutableStateMutableStateOf$default3);
                obj5 = parcelableSnapshotMutableStateMutableStateOf$default3;
            } else {
                obj5 = objRememberedValue24;
            }
            final MutableState mutableState11 = (MutableState) obj5;
            Object objRememberedValue25 = r13.rememberedValue();
            Object obj28 = objRememberedValue25;
            if (objRememberedValue25 == neverEqualPolicy2) {
                ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState9 = new ParcelableSnapshotMutableLongState(0L);
                r13.updateRememberedValue(parcelableSnapshotMutableLongState9);
                obj28 = parcelableSnapshotMutableLongState9;
            }
            final ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState10 = (ParcelableSnapshotMutableLongState) obj28;
            if (((Boolean) mutableStateCollectAsStateWithLifecycle10.getValue()).booleanValue() || ((List) mutableStateCollectAsStateWithLifecycle7.getValue()).isEmpty()) {
                z8 = false;
            } else {
                z8 = false;
                musicService.addToQueueAutomix(0, (MediaItem) ((List) mutableStateCollectAsStateWithLifecycle7.getValue()).get(0));
            }
            r13.startReplaceGroup(359752067);
            StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = MaterialThemeKt._localMaterialTheme;
            long j4 = ((MaterialTheme$Values) r13.consume(staticProvidableCompositionLocal2)).colorScheme.onBackground;
            r13.end(z8);
            boolean z15 = z12;
            final AnimateAsState animateAsStateM17animateColorAsStateeuL9pac = SingleValueAnimationKt.m17animateColorAsStateeuL9pac(j4, null, "TextBackgroundColor", r13, 384, 10);
            r13.startReplaceGroup(359764190);
            long j5 = ((MaterialTheme$Values) r13.consume(staticProvidableCompositionLocal2)).colorScheme.surface;
            r13.end(false);
            SingleValueAnimationKt.m17animateColorAsStateeuL9pac(j5, null, "icBackgroundColor", r13, 384, 10);
            r13.startReplaceGroup(-1731048690);
            r13.startReplaceGroup(-1730697956);
            final long j6 = ((MaterialTheme$Values) r13.consume(staticProvidableCompositionLocal2)).colorScheme.primary;
            final long j7 = ((MaterialTheme$Values) r13.consume(staticProvidableCompositionLocal2)).colorScheme.onPrimary;
            r13.end(false);
            r13.end(false);
            r13.startReplaceGroup(-1728989825);
            r13.startReplaceGroup(-1728659830);
            long j8 = ((MaterialTheme$Values) r13.consume(staticProvidableCompositionLocal2)).colorScheme.primaryContainer;
            long j9 = ((MaterialTheme$Values) r13.consume(staticProvidableCompositionLocal2)).colorScheme.onPrimaryContainer;
            r13.end(false);
            r13.end(false);
            DownloadUtil downloadUtil = (DownloadUtil) r13.consume(MainActivityKt.LocalDownloadUtil);
            MediaMetadata mediaMetadata2 = (MediaMetadata) mutableStateCollectAsState4.getValue();
            if (mediaMetadata2 == null || (str = mediaMetadata2.id) == null) {
                str = "";
            }
            FileSystemsKt.collectAsStateWithLifecycle(downloadUtil.getDownload(str), null, r13, 48);
            SleepTimer sleepTimer = musicService.sleepTimer;
            Long lValueOf = sleepTimer != null ? Long.valueOf(sleepTimer.triggerTime$delegate.getLongValue()) : null;
            SleepTimer sleepTimer2 = musicService.sleepTimer;
            boolean zChanged4 = r13.changed(lValueOf) | r13.changed(sleepTimer2 != null ? Boolean.valueOf(sleepTimer2.getPauseWhenSongEnd()) : null);
            Object objRememberedValue26 = r13.rememberedValue();
            Object obj29 = objRememberedValue26;
            if (zChanged4 || objRememberedValue26 == neverEqualPolicy2) {
                SleepTimer sleepTimer3 = musicService.sleepTimer;
                Boolean boolValueOf4 = Boolean.valueOf(sleepTimer3 != null ? sleepTimer3.isActive() : false);
                r13.updateRememberedValue(boolValueOf4);
                obj29 = boolValueOf4;
            }
            Boolean bool4 = (Boolean) obj29;
            boolean zBooleanValue6 = bool4.booleanValue();
            Object objRememberedValue27 = r13.rememberedValue();
            if (objRememberedValue27 == neverEqualPolicy2) {
                ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState11 = new ParcelableSnapshotMutableLongState(0L);
                r13.updateRememberedValue(parcelableSnapshotMutableLongState11);
                obj6 = parcelableSnapshotMutableLongState11;
            } else {
                obj6 = objRememberedValue27;
            }
            ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState12 = (ParcelableSnapshotMutableLongState) obj6;
            boolean zChanged5 = r13.changed(zBooleanValue6) | r13.changedInstance(playerConnection4);
            Object objRememberedValue28 = r13.rememberedValue();
            if (zChanged5 || objRememberedValue28 == neverEqualPolicy2) {
                objRememberedValue28 = new QueueKt$Queue$3$1(zBooleanValue6, playerConnection4, parcelableSnapshotMutableLongState12, null, (byte) 1);
                playerConnection = playerConnection4;
                r13.updateRememberedValue(objRememberedValue28);
            } else {
                playerConnection = playerConnection4;
            }
            Stack.LaunchedEffect((Composer) r13, bool4, (Function2) objRememberedValue28);
            Object objRememberedValue29 = r13.rememberedValue();
            Object obj30 = objRememberedValue29;
            if (objRememberedValue29 == neverEqualPolicy2) {
                CoroutineScope coroutineScopeCreateCompositionCoroutineScope3 = Stack.createCompositionCoroutineScope(r13);
                r13.updateRememberedValue(coroutineScopeCreateCompositionCoroutineScope3);
                obj30 = coroutineScopeCreateCompositionCoroutineScope3;
            }
            CoroutineScope coroutineScope3 = (CoroutineScope) obj30;
            Object objRememberedValue30 = r13.rememberedValue();
            Object obj31 = objRememberedValue30;
            if (objRememberedValue30 == neverEqualPolicy2) {
                ParcelableSnapshotMutableState parcelableSnapshotMutableStateMutableStateOf$default4 = Stack.mutableStateOf$default(Boolean.FALSE);
                r13.updateRememberedValue(parcelableSnapshotMutableStateMutableStateOf$default4);
                obj31 = parcelableSnapshotMutableStateMutableStateOf$default4;
            }
            MutableState mutableState12 = (MutableState) obj31;
            DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference3 = UtilsKt.rememberPreference(PreferenceKeysKt.SleepTimerDefaultKey, Float.valueOf(30.0f), r13, 48);
            Object objRememberedValue31 = r13.rememberedValue();
            Object objM = objRememberedValue31;
            if (objRememberedValue31 == neverEqualPolicy2) {
                objM = Format$$ExternalSyntheticOutline0.m(((Number) dataStoreKt$rememberPreference$1$1RememberPreference3.getValue()).floatValue(), (GapComposer) r13);
            }
            ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = (ParcelableSnapshotMutableFloatState) objM;
            Object objRememberedValue32 = r13.rememberedValue();
            Object obj32 = objRememberedValue32;
            if (objRememberedValue32 == neverEqualPolicy2) {
                DerivedSnapshotState derivedSnapshotStateDerivedStateOf2 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new QueueKt$$ExternalSyntheticLambda7(parcelableSnapshotMutableFloatState, dataStoreKt$rememberPreference$1$1RememberPreference3, (byte) 3));
                r13.updateRememberedValue(derivedSnapshotStateDerivedStateOf2);
                obj32 = derivedSnapshotStateDerivedStateOf2;
            }
            State state2 = (State) obj32;
            Float fValueOf = Float.valueOf(((Number) dataStoreKt$rememberPreference$1$1RememberPreference3.getValue()).floatValue());
            boolean zChanged6 = r13.changed(dataStoreKt$rememberPreference$1$1RememberPreference3);
            Object objRememberedValue33 = r13.rememberedValue();
            if (zChanged6 || objRememberedValue33 == neverEqualPolicy2) {
                QueueKt$Queue$2$1 queueKt$Queue$2$1 = new QueueKt$Queue$2$1(dataStoreKt$rememberPreference$1$1RememberPreference3, parcelableSnapshotMutableFloatState, null, (byte) 1);
                r13.updateRememberedValue(queueKt$Queue$2$1);
                obj7 = queueKt$Queue$2$1;
            } else {
                obj7 = objRememberedValue33;
            }
            Stack.LaunchedEffect((Composer) r13, fValueOf, (Function2) obj7);
            Preferences$Key preferences$Key4 = PreferenceKeysKt.SleepTimerStopAfterCurrentSongKey;
            Boolean bool5 = Boolean.FALSE;
            DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference4 = UtilsKt.rememberPreference(preferences$Key4, bool5, r13, 48);
            DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference5 = UtilsKt.rememberPreference(PreferenceKeysKt.SleepTimerFadeOutKey, bool5, r13, 48);
            if (((Boolean) mutableState12.getValue()).booleanValue()) {
                r13.startReplaceGroup(-1726236312);
                DialogProperties dialogProperties = new DialogProperties(3);
                Object objRememberedValue34 = r13.rememberedValue();
                if (objRememberedValue34 == neverEqualPolicy2) {
                    obj10 = objRememberedValue34;
                    PlayerKt$$ExternalSyntheticLambda7 playerKt$$ExternalSyntheticLambda7 = new PlayerKt$$ExternalSyntheticLambda7(mutableState12, (byte) 3);
                    r13.updateRememberedValue(playerKt$$ExternalSyntheticLambda7);
                    obj10 = playerKt$$ExternalSyntheticLambda7;
                }
                obj10 = objRememberedValue34;
                ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Expect_jvmKt.rememberComposableLambda(1172507553, new PlayerKt$$ExternalSyntheticLambda92((Object) playerConnection, (State) dataStoreKt$rememberPreference$1$1RememberPreference4, (Object) dataStoreKt$rememberPreference$1$1RememberPreference5, (Object) mutableState12, (Object) parcelableSnapshotMutableFloatState, (byte) 0), r13);
                ComposableLambdaImpl composableLambdaImplRememberComposableLambda2 = Expect_jvmKt.rememberComposableLambda(561238495, new QueueKt$$ExternalSyntheticLambda39(mutableState12, (byte) 1), r13);
                PlayerConnection playerConnection5 = playerConnection;
                PlayerKt$$ExternalSyntheticLambda78 playerKt$$ExternalSyntheticLambda78 = new PlayerKt$$ExternalSyntheticLambda78(parcelableSnapshotMutableFloatState, coroutineScope3, context, strStringResource, playerConnection5, state2, mutableState12);
                playerConnection2 = playerConnection5;
                neverEqualPolicy = neverEqualPolicy2;
                CardKt.m251AlertDialogOix01E0((Function0) obj10, composableLambdaImplRememberComposableLambda, null, composableLambdaImplRememberComposableLambda2, lambda$255603966, f293lambda$50030563, Expect_jvmKt.rememberComposableLambda(-355665092, playerKt$$ExternalSyntheticLambda78, r13), null, 0L, 0L, 0L, 0L, dialogProperties, r13, 1797174, 3072, 8068);
                i2 = 0;
                r13.end(false);
            } else {
                neverEqualPolicy = neverEqualPolicy2;
                playerConnection2 = playerConnection;
                i2 = 0;
                r13.startReplaceGroup(-1721583925);
                r13.end(false);
            }
            Object[] objArr4 = new Object[i2];
            Object objRememberedValue35 = r13.rememberedValue();
            Object obj33 = objRememberedValue35;
            if (objRememberedValue35 == neverEqualPolicy) {
                QueueKt$$ExternalSyntheticLambda2 queueKt$$ExternalSyntheticLambda4 = new QueueKt$$ExternalSyntheticLambda2((byte) 18);
                r13.updateRememberedValue(queueKt$$ExternalSyntheticLambda4);
                obj33 = queueKt$$ExternalSyntheticLambda4;
            }
            Boolean bool6 = (Boolean) mutableStateCollectAsState2.getValue();
            bool6.getClass();
            Boolean bool7 = (Boolean) mutableState7.getValue();
            bool7.getClass();
            boolean zChanged7 = r13.changed(mutableState7) | r13.changed(mutableStateCollectAsState2) | r13.changedInstance(playerConnection2);
            Object objRememberedValue36 = r13.rememberedValue();
            if (zChanged7 || objRememberedValue36 == neverEqualPolicy) {
                objRememberedValue36 = new EngineInterceptor.AnonymousClass2(playerConnection2, mutableState7, mutableStateCollectAsState2, mutableState11, parcelableSnapshotMutableLongState6, parcelableSnapshotMutableLongState8, null);
                parcelableSnapshotMutableLongState = parcelableSnapshotMutableLongState8;
                r13.updateRememberedValue(objRememberedValue36);
            } else {
                parcelableSnapshotMutableLongState = parcelableSnapshotMutableLongState8;
            }
            Stack.LaunchedEffect(bool6, bool7, (Function2) objRememberedValue36, r13);
            Integer numValueOf2 = Integer.valueOf(((Number) mutableStateCollectAsState3.getValue()).intValue());
            MediaMetadata mediaMetadata3 = (MediaMetadata) mutableStateCollectAsState4.getValue();
            String str2 = mediaMetadata3 != null ? mediaMetadata3.id : null;
            boolean zChanged8 = r13.changed(mutableState7) | r13.changedInstance(playerConnection2) | r13.changed(mutableStateCollectAsState4);
            Object objRememberedValue37 = r13.rememberedValue();
            if (zChanged8 || objRememberedValue37 == neverEqualPolicy) {
                objRememberedValue37 = new NavHostKt$NavHost$33$1(playerConnection2, mutableState7, parcelableSnapshotMutableLongState6, mutableStateCollectAsState4, parcelableSnapshotMutableLongState, null, (byte) 3);
                r13.updateRememberedValue(objRememberedValue37);
            }
            Stack.LaunchedEffect(numValueOf2, str2, (Function2) objRememberedValue37, r13);
            Object objRememberedValue38 = r13.rememberedValue();
            if (objRememberedValue38 == neverEqualPolicy) {
                function0 = null;
                ParcelableSnapshotMutableState parcelableSnapshotMutableStateMutableStateOf$default5 = Stack.mutableStateOf$default(null);
                r13.updateRememberedValue(parcelableSnapshotMutableStateMutableStateOf$default5);
                obj8 = parcelableSnapshotMutableStateMutableStateOf$default5;
            } else {
                function0 = null;
                obj8 = objRememberedValue38;
            }
            MutableState mutableState13 = (MutableState) obj8;
            Integer numValueOf3 = Integer.valueOf(((Number) mutableStateCollectAsState3.getValue()).intValue());
            MediaMetadata mediaMetadata4 = (MediaMetadata) mutableStateCollectAsState4.getValue();
            Object obj34 = mediaMetadata4 != null ? mediaMetadata4.id : function0;
            boolean zChanged9 = r13.changed(mutableStateCollectAsState4) | r13.changed(mutableStateCollectAsState3) | r13.changed(mutableStateCollectAsStateWithLifecycle8) | r13.changed(z15) | r13.changedInstance(playerConnection2);
            Object objRememberedValue39 = r13.rememberedValue();
            if (zChanged9 || objRememberedValue39 == neverEqualPolicy) {
                PlayerConnection playerConnection6 = playerConnection2;
                mutableState2 = mutableStateCollectAsState3;
                mutableState3 = mutableStateCollectAsStateWithLifecycle8;
                z9 = z15;
                objRememberedValue39 = new RealImageLoader$execute$result$1(z9, playerConnection6, mutableStateCollectAsState4, mutableState13, mutableState2, mutableState3, (Continuation) null);
                playerConnection3 = playerConnection6;
                r13.updateRememberedValue(objRememberedValue39);
            } else {
                mutableState2 = mutableStateCollectAsState3;
                mutableState3 = mutableStateCollectAsStateWithLifecycle8;
                z9 = z15;
                playerConnection3 = playerConnection2;
            }
            Stack.LaunchedEffect(numValueOf3, obj34, (Function2) objRememberedValue39, r13);
            Boolean bool8 = (Boolean) mutableState7.getValue();
            bool8.getClass();
            Long lValueOf2 = Long.valueOf(((Number) mutableState8.getValue()).longValue());
            Long lValueOf3 = Long.valueOf(((Number) mutableState9.getValue()).longValue());
            boolean zChanged10 = r13.changed(mutableState7) | r13.changed(mutableState8) | r13.changed(mutableState9);
            Object objRememberedValue40 = r13.rememberedValue();
            if (zChanged10 || objRememberedValue40 == neverEqualPolicy) {
                ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState13 = parcelableSnapshotMutableLongState;
                objRememberedValue40 = new PlayerKt$BottomSheetPlayer$13$1(mutableState7, mutableState11, parcelableSnapshotMutableLongState10, mutableState8, parcelableSnapshotMutableLongState6, mutableState9, parcelableSnapshotMutableLongState13, (Continuation) null);
                mutableState4 = mutableState7;
                parcelableSnapshotMutableLongState2 = parcelableSnapshotMutableLongState13;
                r13.updateRememberedValue(objRememberedValue40);
            } else {
                mutableState4 = mutableState7;
                parcelableSnapshotMutableLongState2 = parcelableSnapshotMutableLongState;
            }
            Stack.LaunchedEffect(bool8, lValueOf2, lValueOf3, (Function2) objRememberedValue40, r13);
            SpringSpec springSpec = DimensionsKt.NavigationBarAnimationSpec;
            WeakHashMap weakHashMap = WindowInsetsHolder.viewMap;
            float fMo122calculateBottomPaddingD9Ej5fM = OffsetKt.asPaddingValues(OffsetKt.current(r13).systemBars, r13).mo122calculateBottomPaddingD9Ej5fM() + 64.0f + CropImageView.DEFAULT_ASPECT_RATIO;
            Comparable comparable = bottomSheetState.animatable.upperBound;
            comparable.getClass();
            NeverEqualPolicy neverEqualPolicy3 = neverEqualPolicy;
            final BottomSheetState bottomSheetStateM1475rememberBottomSheetStatejTDHpeQ = DialogKt.m1475rememberBottomSheetStatejTDHpeQ(fMo122calculateBottomPaddingD9Ej5fM, ((Dp) comparable).value, CropImageView.DEFAULT_ASPECT_RATIO + 1.0f + fMo122calculateBottomPaddingD9Ej5fM, r13, 3072, 0);
            if (zBooleanValue4 != 0) {
                r13.startReplaceGroup(-1718208056);
                r13.end(false);
                j2 = -72057594037927936L;
            } else {
                r13.startReplaceGroup(-1718166702);
                j2 = ((MaterialTheme$Values) r13.consume(staticProvidableCompositionLocal2)).colorScheme.surface;
                r13.end(false);
            }
            final boolean z16 = z3;
            ComposableLambdaImpl composableLambdaImplRememberComposableLambda3 = Expect_jvmKt.rememberComposableLambda(-56804057, new Function3() { // from class: com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda80
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj35, Object obj36, Object obj37) {
                    Composer composer2 = (Composer) obj36;
                    int iIntValue = ((Integer) obj37).intValue();
                    ((BoxScope) obj35).getClass();
                    GapComposer gapComposer = (GapComposer) composer2;
                    if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                        boolean z17 = zIsGlassStyle;
                        long j10 = j2;
                        if (z17) {
                            gapComposer.startReplaceGroup(-32510602);
                            MediaMetadata mediaMetadata5 = (MediaMetadata) mutableStateCollectAsState4.getValue();
                            String str3 = mediaMetadata5 != null ? mediaMetadata5.thumbnailUrl : null;
                            boolean z18 = z16 || zBooleanValue4;
                            BottomSheetState bottomSheetState3 = bottomSheetState;
                            boolean zChanged11 = gapComposer.changed(bottomSheetState3);
                            Object objRememberedValue41 = gapComposer.rememberedValue();
                            if (zChanged11 || objRememberedValue41 == Composer.Companion.Empty) {
                                objRememberedValue41 = new PlayerKt$$ExternalSyntheticLambda0(bottomSheetState3, (byte) 0);
                                gapComposer.updateRememberedValue(objRememberedValue41);
                            }
                            QueueKt.m1504PlayerCoverBackground3IgeMak(0, j10, gapComposer, str3, (Function0) objRememberedValue41, z18);
                            gapComposer.end(false);
                        } else {
                            gapComposer.startReplaceGroup(-32189287);
                            BoxKt.Box(ImageKt.m39backgroundbw27NRU(SizeKt.FillWholeMaxSize, j10, ColorKt.RectangleShape), gapComposer, 0);
                            gapComposer.end(false);
                        }
                    } else {
                        gapComposer.skipToGroupEnd();
                    }
                    return Unit.INSTANCE;
                }
            }, r13);
            if (z9) {
                b = 0;
                r13.startReplaceGroup(-1717267609);
                r13.end(false);
            } else {
                r13.startReplaceGroup(-1717489941);
                boolean zChangedInstance2 = r13.changedInstance(playerConnection3);
                Object objRememberedValue41 = r13.rememberedValue();
                if (zChangedInstance2 || objRememberedValue41 == neverEqualPolicy3) {
                    obj9 = objRememberedValue41;
                    PlayerKt$$ExternalSyntheticLambda41 playerKt$$ExternalSyntheticLambda41 = new PlayerKt$$ExternalSyntheticLambda41(playerConnection3, (byte) 4);
                    r13.updateRememberedValue(playerKt$$ExternalSyntheticLambda41);
                    obj9 = playerKt$$ExternalSyntheticLambda41;
                }
                b = 0;
                r13.end(false);
                function0 = (Function0) obj9;
            }
            final ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState14 = parcelableSnapshotMutableLongState2;
            final Context context5 = context;
            final boolean z17 = z9;
            final MutableState mutableState14 = mutableState4;
            final MutableState mutableState15 = mutableState;
            final MutableState mutableState16 = mutableState2;
            final MutableState mutableState17 = mutableState3;
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            DialogKt.BottomSheet(bottomSheetState, companion, composableLambdaImplRememberComposableLambda3, function0, Expect_jvmKt.rememberComposableLambda(-597233563, new PlayerKt$$ExternalSyntheticLambda82(r61, parcelableSnapshotMutableLongState2, bottomSheetState, b), r13), false, Expect_jvmKt.rememberComposableLambda(-1137663069, new Function3() { // from class: com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda83
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj35, Object obj36, Object obj37) {
                    BottomSheetState bottomSheetState3;
                    float f;
                    BottomSheetState bottomSheetState4;
                    GapComposer gapComposer;
                    boolean z18;
                    int i6;
                    boolean z19;
                    Composer composer2 = (Composer) obj36;
                    int iIntValue = ((Integer) obj37).intValue();
                    Arrangement$Top$1 arrangement$Top$1 = OffsetKt.Top;
                    BiasAlignment.Horizontal horizontal = Alignment.Companion.CenterHorizontally;
                    BiasAlignment biasAlignment = Alignment.Companion.Center;
                    BiasAlignment.Vertical vertical = Alignment.Companion.Top;
                    ((BoxScope) obj35).getClass();
                    GapComposer gapComposer2 = (GapComposer) composer2;
                    if (gapComposer2.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                        final boolean z20 = zIsGlassStyle;
                        final MutableState mutableState18 = mutableState11;
                        final boolean z21 = z17;
                        final boolean z22 = zBooleanValue5;
                        final MutableState mutableState19 = mutableState14;
                        final CastConnectionHandler castConnectionHandler3 = castConnectionHandler2;
                        final PlayerConnection playerConnection7 = playerConnection3;
                        final MutableState mutableState20 = mutableState5;
                        final boolean z23 = zBooleanValue;
                        final MutableState mutableState21 = dataStoreKt$rememberPreference$1$1RememberPreference;
                        final String str3 = strStringResource2;
                        final ClipboardManager clipboardManager2 = clipboardManager;
                        final Context context6 = context5;
                        final State state3 = mutableStateCollectAsStateWithLifecycle6;
                        final NavHostController navHostController2 = navHostController;
                        final BottomSheetState bottomSheetState5 = bottomSheetState;
                        final String str4 = strStringResource3;
                        final MutableState mutableState22 = mutableState15;
                        final MenuState menuState2 = menuState;
                        final BottomSheetPageState bottomSheetPageState2 = bottomSheetPageState;
                        final long j10 = j6;
                        final long j11 = j7;
                        final MutableState mutableState23 = playerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$5;
                        final MutableState mutableState24 = dataStoreKt$rememberPreference$1$1RememberPreference2;
                        final State state4 = state;
                        final ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState15 = parcelableSnapshotMutableLongState14;
                        final ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState16 = parcelableSnapshotMutableLongState10;
                        final ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState17 = parcelableSnapshotMutableLongState6;
                        final State state5 = mutableStateCollectAsStateWithLifecycle12;
                        final State state6 = mutableState10;
                        final MutableState mutableState25 = mutableState16;
                        final FocusRequester focusRequester3 = focusRequester2;
                        final State state7 = mutableState17;
                        final State state8 = mutableStateCollectAsStateWithLifecycle9;
                        final State state9 = mutableStateCollectAsStateWithLifecycle11;
                        final MutableState mutableState26 = mutableStateCollectAsStateWithLifecycle10;
                        ComposableLambdaImpl composableLambdaImplRememberComposableLambda4 = Expect_jvmKt.rememberComposableLambda(1583650721, new Function4() { // from class: com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function4
                            public final Object invoke(Object obj38, Object obj39, Object obj40, Object obj41) {
                                int i7;
                                GapComposer gapComposer3;
                                boolean z24;
                                MediaMetadata mediaMetadata5;
                                BiasAlignment.Vertical vertical2;
                                NeverEqualPolicy neverEqualPolicy4;
                                long j12;
                                Unit unit;
                                AnnotatedString annotatedString;
                                BottomSheetState bottomSheetState6;
                                GapComposer gapComposer4;
                                boolean z25;
                                PlayerKt$$ExternalSyntheticLambda5 playerKt$$ExternalSyntheticLambda5;
                                long j13;
                                boolean z26;
                                ColumnScopeInstance columnScopeInstance = (ColumnScopeInstance) obj38;
                                final MediaMetadata mediaMetadata6 = (MediaMetadata) obj39;
                                Composer composer3 = (Composer) obj40;
                                int iIntValue2 = ((Integer) obj41).intValue();
                                BiasAlignment.Vertical vertical3 = Alignment.Companion.CenterVertically;
                                columnScopeInstance.getClass();
                                mediaMetadata6.getClass();
                                List list = mediaMetadata6.artists;
                                if ((iIntValue2 & 6) == 0) {
                                    i7 = (((GapComposer) composer3).changed(columnScopeInstance) ? 4 : 2) | iIntValue2;
                                } else {
                                    i7 = iIntValue2;
                                }
                                if ((iIntValue2 & 48) == 0) {
                                    i7 |= ((GapComposer) composer3).changed(mediaMetadata6) ? 32 : 16;
                                }
                                int i8 = i7;
                                GapComposer gapComposer5 = (GapComposer) composer3;
                                boolean zShouldExecute = gapComposer5.shouldExecute(i8 & 1, (i8 & 147) != 146);
                                Unit unit2 = Unit.INSTANCE;
                                if (!zShouldExecute) {
                                    gapComposer5.skipToGroupEnd();
                                    return unit2;
                                }
                                StaticProvidableCompositionLocal staticProvidableCompositionLocal3 = MaterialThemeKt._localMaterialTheme;
                                final long j14 = ((MaterialTheme$Values) gapComposer5.consume(staticProvidableCompositionLocal3)).colorScheme.onSurface;
                                final long j15 = ((MaterialTheme$Values) gapComposer5.consume(staticProvidableCompositionLocal3)).colorScheme.onSurfaceVariant;
                                Modifier.Companion companion2 = Modifier.Companion.$$INSTANCE;
                                final boolean z27 = z20;
                                if (z27) {
                                    columnScopeInstance = columnScopeInstance;
                                    gapComposer3 = gapComposer5;
                                    gapComposer3.startReplaceGroup(-1676512127);
                                    gapComposer3.end(false);
                                } else {
                                    gapComposer5.startReplaceGroup(-1676926318);
                                    MediaMetadata.Album album = mediaMetadata6.album;
                                    String str5 = album != null ? album.title : null;
                                    if (str5 == null || StringsKt.isBlank(str5)) {
                                        gapComposer3 = gapComposer5;
                                        z26 = false;
                                        gapComposer3.startReplaceGroup(-1676526015);
                                        gapComposer3.end(false);
                                    } else {
                                        gapComposer5.startReplaceGroup(-1676807185);
                                        DialogKt.m1469MicroLabelFNF3uiM(str5, OffsetKt.m139paddingqDBjuR0$default(SizeKt.fillMaxWidth(companion2, 1.0f), 20.0f, CropImageView.DEFAULT_ASPECT_RATIO, 20.0f, 4.0f, 2), ((MaterialTheme$Values) gapComposer5.consume(staticProvidableCompositionLocal3)).colorScheme.primary, gapComposer5, 48, 0);
                                        gapComposer3 = gapComposer5;
                                        z26 = false;
                                        gapComposer3.end(false);
                                    }
                                    gapComposer3.end(z26);
                                }
                                FlowRowOverflow flowRowOverflow = OffsetKt.SpaceBetween;
                                Modifier modifierM137paddingVpY3zN4$default = OffsetKt.m137paddingVpY3zN4$default(SizeKt.fillMaxWidth(companion2, 1.0f), 20.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2);
                                RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(flowRowOverflow, vertical3, gapComposer3, 54);
                                int iHashCode = Long.hashCode(gapComposer3.compositeKeyHashCode);
                                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer3.currentCompositionLocalScope();
                                Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer3, modifierM137paddingVpY3zN4$default);
                                ComposeUiNode.Companion.getClass();
                                gapComposer3.startReusableNode();
                                boolean z28 = gapComposer3.inserting;
                                TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
                                if (z28) {
                                    gapComposer3.createNode(textKt$$ExternalSyntheticLambda3);
                                } else {
                                    gapComposer3.useNode();
                                }
                                Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetMeasurePolicy;
                                Stack.m390setimpl(gapComposer3, rowMeasurePolicy, updater$$ExternalSyntheticLambda0);
                                Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                                Stack.m390setimpl(gapComposer3, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda1);
                                Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetCompositeKeyHash;
                                IntIntPair$$ExternalSyntheticOutline0.m(iHashCode, gapComposer3, updater$$ExternalSyntheticLambda2, gapComposer3);
                                Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetModifier;
                                Stack.m390setimpl(gapComposer3, modifierMaterializeModifier, updater$$ExternalSyntheticLambda3);
                                MutableState mutableState27 = mutableState20;
                                Boolean bool9 = (Boolean) mutableState27.getValue();
                                bool9.getClass();
                                final boolean z29 = z23;
                                final MutableState mutableState28 = mutableState21;
                                CrossfadeKt.AnimatedContent(bool9, null, null, null, "ThumbnailAnimation", null, Expect_jvmKt.rememberComposableLambda(-1833889062, new Function4() { // from class: com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda20
                                    @Override // kotlin.jvm.functions.Function4
                                    public final Object invoke(Object obj42, Object obj43, Object obj44, Object obj45) {
                                        GapComposer gapComposer6;
                                        boolean zBooleanValue7 = ((Boolean) obj43).booleanValue();
                                        Composer composer4 = (Composer) obj44;
                                        int iIntValue3 = ((Integer) obj45).intValue();
                                        ((AnimatedContentScopeImpl) obj42).getClass();
                                        if ((iIntValue3 & 48) == 0) {
                                            iIntValue3 |= ((GapComposer) composer4).changed(zBooleanValue7) ? 32 : 16;
                                        }
                                        GapComposer gapComposer7 = (GapComposer) composer4;
                                        if (gapComposer7.shouldExecute(iIntValue3 & 1, (iIntValue3 & 145) != 144)) {
                                            Modifier.Companion companion3 = Modifier.Companion.$$INSTANCE;
                                            if (zBooleanValue7) {
                                                gapComposer7.startReplaceGroup(-1404932761);
                                                RowMeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(OffsetKt.Start, Alignment.Companion.Top, gapComposer7, 0);
                                                int iHashCode2 = Long.hashCode(gapComposer7.compositeKeyHashCode);
                                                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer7.currentCompositionLocalScope();
                                                Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer7, companion3);
                                                ComposeUiNode.Companion.getClass();
                                                gapComposer7.startReusableNode();
                                                boolean z30 = gapComposer7.inserting;
                                                TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda4 = LayoutNode.Constructor;
                                                if (z30) {
                                                    gapComposer7.createNode(textKt$$ExternalSyntheticLambda4);
                                                } else {
                                                    gapComposer7.useNode();
                                                }
                                                Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda4 = ComposeUiNode.Companion.SetMeasurePolicy;
                                                Stack.m390setimpl(gapComposer7, rowMeasurePolicy2, updater$$ExternalSyntheticLambda4);
                                                Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda5 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                                                Stack.m390setimpl(gapComposer7, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda5);
                                                Integer numValueOf4 = Integer.valueOf(iHashCode2);
                                                Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda6 = ComposeUiNode.Companion.SetCompositeKeyHash;
                                                Stack.m390setimpl(gapComposer7, numValueOf4, updater$$ExternalSyntheticLambda6);
                                                Stack.m389reconcileimpl(gapComposer7);
                                                Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda7 = ComposeUiNode.Companion.SetModifier;
                                                Stack.m390setimpl(gapComposer7, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda7);
                                                if (z29) {
                                                    gapComposer7.startReplaceGroup(-1339119183);
                                                    Modifier modifierM151size3ABfNKs = SizeKt.m151size3ABfNKs(companion3, 56.0f);
                                                    SpringSpec springSpec2 = DimensionsKt.NavigationBarAnimationSpec;
                                                    Modifier modifierM39backgroundbw27NRU = ImageKt.m39backgroundbw27NRU(ClipKt.clip(modifierM151size3ABfNKs, RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(10.0f)), ((MaterialTheme$Values) gapComposer7.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.surfaceVariant, ColorKt.RectangleShape);
                                                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
                                                    int iHashCode3 = Long.hashCode(gapComposer7.compositeKeyHashCode);
                                                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer7.currentCompositionLocalScope();
                                                    Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer7, modifierM39backgroundbw27NRU);
                                                    gapComposer7.startReusableNode();
                                                    if (gapComposer7.inserting) {
                                                        gapComposer7.createNode(textKt$$ExternalSyntheticLambda4);
                                                    } else {
                                                        gapComposer7.useNode();
                                                    }
                                                    Stack.m390setimpl(gapComposer7, measurePolicyMaybeCachedBoxMeasurePolicy, updater$$ExternalSyntheticLambda4);
                                                    Stack.m390setimpl(gapComposer7, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda5);
                                                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode3, gapComposer7, updater$$ExternalSyntheticLambda6, gapComposer7);
                                                    Stack.m390setimpl(gapComposer7, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda7);
                                                    gapComposer6 = gapComposer7;
                                                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.small_icon, 0, gapComposer7), (String) null, SizeKt.m151size3ABfNKs(companion3, 32.0f), j15, gapComposer6, 440, 0);
                                                    gapComposer6.end(true);
                                                    gapComposer6.end(false);
                                                } else {
                                                    gapComposer7.startReplaceGroup(-1338086480);
                                                    String str6 = mediaMetadata6.thumbnailUrl;
                                                    ContentScale$Companion$Fit$1 contentScale$Companion$Fit$1 = ((Boolean) mutableState28.getValue()).booleanValue() ? ContentScale.Companion.Crop : ContentScale.Companion.Fit;
                                                    Modifier modifierM151size3ABfNKs2 = SizeKt.m151size3ABfNKs(companion3, 56.0f);
                                                    SpringSpec springSpec3 = DimensionsKt.NavigationBarAnimationSpec;
                                                    AsyncImageKt.m849AsyncImage10Xjiaw(str6, ClipKt.clip(modifierM151size3ABfNKs2, RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(10.0f)), contentScale$Companion$Fit$1, gapComposer7, 48, 1976);
                                                    gapComposer6 = gapComposer7;
                                                    gapComposer6.end(false);
                                                }
                                                OffsetKt.Spacer(gapComposer6, SizeKt.m155width3ABfNKs(companion3, 12.0f));
                                                gapComposer6.end(true);
                                                gapComposer6.end(false);
                                            } else {
                                                gapComposer7.startReplaceGroup(-1403170287);
                                                OffsetKt.Spacer(gapComposer7, SizeKt.m155width3ABfNKs(companion3, CropImageView.DEFAULT_ASPECT_RATIO));
                                                gapComposer7.end(false);
                                            }
                                        } else {
                                            gapComposer7.skipToGroupEnd();
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }, gapComposer3), gapComposer3, 1597440, 46);
                                LayoutWeightElement layoutWeightElement = new LayoutWeightElement(1.0f, true);
                                ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start, gapComposer3, 0);
                                int iHashCode2 = Long.hashCode(gapComposer3.compositeKeyHashCode);
                                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer3.currentCompositionLocalScope();
                                Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer3, layoutWeightElement);
                                gapComposer3.startReusableNode();
                                if (gapComposer3.inserting) {
                                    gapComposer3.createNode(textKt$$ExternalSyntheticLambda3);
                                } else {
                                    gapComposer3.useNode();
                                }
                                Stack.m390setimpl(gapComposer3, columnMeasurePolicy, updater$$ExternalSyntheticLambda0);
                                Stack.m390setimpl(gapComposer3, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
                                IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer3, updater$$ExternalSyntheticLambda2, gapComposer3);
                                Stack.m390setimpl(gapComposer3, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
                                String str6 = mediaMetadata6.title;
                                Object objRememberedValue42 = gapComposer3.rememberedValue();
                                NeverEqualPolicy neverEqualPolicy5 = Composer.Companion.Empty;
                                if (objRememberedValue42 == neverEqualPolicy5) {
                                    objRememberedValue42 = new SongMenuKt$$ExternalSyntheticLambda16((byte) 27);
                                    gapComposer3.updateRememberedValue(objRememberedValue42);
                                }
                                final String str7 = str3;
                                final ClipboardManager clipboardManager3 = clipboardManager2;
                                final Context context7 = context6;
                                final State state10 = state3;
                                final NavHostController navHostController3 = navHostController2;
                                final BottomSheetState bottomSheetState7 = bottomSheetState5;
                                Function4 function4 = new Function4() { // from class: com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda23
                                    @Override // kotlin.jvm.functions.Function4
                                    public final Object invoke(Object obj42, Object obj43, Object obj44, Object obj45) {
                                        TextStyle textStyleM750copyp1EtxEg$default;
                                        String str8;
                                        String str9 = (String) obj43;
                                        Composer composer4 = (Composer) obj44;
                                        int iIntValue3 = ((Integer) obj45).intValue();
                                        ((AnimatedContentScopeImpl) obj42).getClass();
                                        str9.getClass();
                                        if ((iIntValue3 & 48) == 0) {
                                            iIntValue3 |= ((GapComposer) composer4).changed(str9) ? 32 : 16;
                                        }
                                        int i9 = iIntValue3;
                                        GapComposer gapComposer6 = (GapComposer) composer4;
                                        if (gapComposer6.shouldExecute(i9 & 1, (i9 & 145) != 144)) {
                                            if (z27) {
                                                gapComposer6.startReplaceGroup(1088819551);
                                                textStyleM750copyp1EtxEg$default = TextStyle.m750copyp1EtxEg$default(((MaterialTheme$Values) gapComposer6.consume(MaterialThemeKt._localMaterialTheme)).typography.headlineSmall, 0L, 0L, FontWeight.Bold, null, null, null, 0L, 0L, null, null, 16777211);
                                            } else {
                                                gapComposer6.startReplaceGroup(1088821611);
                                                textStyleM750copyp1EtxEg$default = ((MaterialTheme$Values) gapComposer6.consume(MaterialThemeKt._localMaterialTheme)).typography.headlineMedium;
                                            }
                                            gapComposer6.end(false);
                                            TextStyle textStyle = textStyleM750copyp1EtxEg$default;
                                            Modifier modifierM41basicMarquee1Mj1MLw$default = ImageKt.m41basicMarquee1Mj1MLw$default(Modifier.Companion.$$INSTANCE, 22);
                                            Object objRememberedValue43 = gapComposer6.rememberedValue();
                                            NeverEqualPolicy neverEqualPolicy6 = Composer.Companion.Empty;
                                            if (objRememberedValue43 == neverEqualPolicy6) {
                                                objRememberedValue43 = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer6);
                                            }
                                            MutableInteractionSourceImpl mutableInteractionSourceImpl = (MutableInteractionSourceImpl) objRememberedValue43;
                                            String str10 = str7;
                                            boolean zChanged11 = gapComposer6.changed(str10);
                                            boolean z30 = (i9 & 112) == 32;
                                            ClipboardManager clipboardManager4 = clipboardManager3;
                                            boolean zChangedInstance3 = zChanged11 | z30 | gapComposer6.changedInstance(clipboardManager4);
                                            Context context8 = context7;
                                            boolean zChangedInstance4 = zChangedInstance3 | gapComposer6.changedInstance(context8);
                                            Object objRememberedValue44 = gapComposer6.rememberedValue();
                                            if (zChangedInstance4 || objRememberedValue44 == neverEqualPolicy6) {
                                                str8 = str9;
                                                SongMenuKt$$ExternalSyntheticLambda63 songMenuKt$$ExternalSyntheticLambda63 = new SongMenuKt$$ExternalSyntheticLambda63(str10, str8, clipboardManager4, context8, (byte) 23);
                                                gapComposer6.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda63);
                                                objRememberedValue44 = songMenuKt$$ExternalSyntheticLambda63;
                                            } else {
                                                str8 = str9;
                                            }
                                            Function0 function2 = (Function0) objRememberedValue44;
                                            MediaMetadata mediaMetadata7 = mediaMetadata6;
                                            boolean zChanged12 = gapComposer6.changed(mediaMetadata7);
                                            State state11 = state10;
                                            boolean zChanged13 = zChanged12 | gapComposer6.changed(state11);
                                            NavHostController navHostController4 = navHostController3;
                                            boolean zChangedInstance5 = zChanged13 | gapComposer6.changedInstance(navHostController4);
                                            BottomSheetState bottomSheetState8 = bottomSheetState7;
                                            boolean zChanged14 = zChangedInstance5 | gapComposer6.changed(bottomSheetState8);
                                            Object objRememberedValue45 = gapComposer6.rememberedValue();
                                            if (zChanged14 || objRememberedValue45 == neverEqualPolicy6) {
                                                objRememberedValue45 = new SongMenuKt$$ExternalSyntheticLambda63(mediaMetadata7, navHostController4, bottomSheetState8, state11, (byte) 24);
                                                gapComposer6.updateRememberedValue(objRememberedValue45);
                                            }
                                            TextKt.m352TextNvy7gAk(str8, ImageKt.m47combinedClickableauXiCPI$default(modifierM41basicMarquee1Mj1MLw$default, mutableInteractionSourceImpl, null, true, null, function2, (Function0) objRememberedValue45, 440), j14, 0L, null, null, null, 0L, null, 0L, 2, false, 1, 0, textStyle, gapComposer6, (i9 >> 3) & 14, 24960, 110584);
                                        } else {
                                            gapComposer6.skipToGroupEnd();
                                        }
                                        return Unit.INSTANCE;
                                    }
                                };
                                MediaMetadata mediaMetadata7 = mediaMetadata6;
                                GapComposer gapComposer6 = gapComposer3;
                                CrossfadeKt.AnimatedContent(str6, null, (Function1) objRememberedValue42, null, "", null, Expect_jvmKt.rememberComposableLambda(184373021, function4, gapComposer3), gapComposer6, 1597824, 42);
                                BiasAlignment.Vertical vertical4 = vertical3;
                                RowMeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(flowRowOverflow, vertical4, gapComposer6, 54);
                                int iHashCode3 = Long.hashCode(gapComposer6.compositeKeyHashCode);
                                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer6.currentCompositionLocalScope();
                                Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer6, companion2);
                                gapComposer6.startReusableNode();
                                if (gapComposer6.inserting) {
                                    gapComposer6.createNode(textKt$$ExternalSyntheticLambda3);
                                } else {
                                    gapComposer6.useNode();
                                }
                                Stack.m390setimpl(gapComposer6, rowMeasurePolicy2, updater$$ExternalSyntheticLambda0);
                                Stack.m390setimpl(gapComposer6, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda1);
                                IntIntPair$$ExternalSyntheticOutline0.m(iHashCode3, gapComposer6, updater$$ExternalSyntheticLambda2, gapComposer6);
                                Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda4 = updater$$ExternalSyntheticLambda3;
                                Stack.m390setimpl(gapComposer6, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda4);
                                if (mediaMetadata7.explicit) {
                                    gapComposer6.startReplaceGroup(1457420525);
                                    Icon.INSTANCE.Explicit(6, gapComposer6);
                                    z24 = false;
                                } else {
                                    z24 = false;
                                    gapComposer6.startReplaceGroup(-2064594369);
                                }
                                gapComposer6.end(z24);
                                if (list == null || !list.isEmpty()) {
                                    Iterator it = list.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            playerKt$$ExternalSyntheticLambda5 = this;
                                            vertical2 = vertical4;
                                            updater$$ExternalSyntheticLambda4 = updater$$ExternalSyntheticLambda4;
                                            mediaMetadata5 = mediaMetadata7;
                                            gapComposer4 = gapComposer6;
                                            bottomSheetState6 = bottomSheetState7;
                                            unit = unit2;
                                            neverEqualPolicy4 = neverEqualPolicy5;
                                            z25 = true;
                                            gapComposer4.startReplaceGroup(-2058975681);
                                            gapComposer4.end(false);
                                        } else if (!StringsKt.isBlank(((MediaMetadata.Artist) it.next()).name)) {
                                            gapComposer6.startReplaceGroup(-2064339983);
                                            gapComposer6.startReplaceGroup(1457426924);
                                            AnnotatedString.Builder builder = new AnnotatedString.Builder();
                                            gapComposer6.startReplaceGroup(1457429401);
                                            Iterator it2 = list.iterator();
                                            int i9 = 0;
                                            while (true) {
                                                mediaMetadata5 = mediaMetadata7;
                                                if (!it2.hasNext()) {
                                                    vertical2 = vertical4;
                                                    BottomSheetState bottomSheetState8 = bottomSheetState7;
                                                    gapComposer6.end(false);
                                                    AnnotatedString annotatedString2 = builder.toAnnotatedString();
                                                    gapComposer6.end(false);
                                                    Modifier modifierM139paddingqDBjuR0$default = OffsetKt.m139paddingqDBjuR0$default(ImageKt.m41basicMarquee1Mj1MLw$default(SizeKt.fillMaxWidth(companion2, 1.0f), 22), CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 12.0f, CropImageView.DEFAULT_ASPECT_RATIO, 11);
                                                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
                                                    int iHashCode4 = Long.hashCode(gapComposer6.compositeKeyHashCode);
                                                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope4 = gapComposer6.currentCompositionLocalScope();
                                                    Modifier modifierMaterializeModifier4 = ZIndexModifierKt.materializeModifier(gapComposer6, modifierM139paddingqDBjuR0$default);
                                                    ComposeUiNode.Companion.getClass();
                                                    gapComposer6.startReusableNode();
                                                    if (gapComposer6.inserting) {
                                                        gapComposer6.createNode(textKt$$ExternalSyntheticLambda3);
                                                    } else {
                                                        gapComposer6.useNode();
                                                    }
                                                    Stack.m390setimpl(gapComposer6, measurePolicyMaybeCachedBoxMeasurePolicy, updater$$ExternalSyntheticLambda0);
                                                    Stack.m390setimpl(gapComposer6, persistentCompositionLocalHashMapCurrentCompositionLocalScope4, updater$$ExternalSyntheticLambda1);
                                                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode4, gapComposer6, updater$$ExternalSyntheticLambda2, gapComposer6);
                                                    Stack.m390setimpl(gapComposer6, modifierMaterializeModifier4, updater$$ExternalSyntheticLambda4);
                                                    Object objRememberedValue43 = gapComposer6.rememberedValue();
                                                    neverEqualPolicy4 = neverEqualPolicy5;
                                                    if (objRememberedValue43 == neverEqualPolicy4) {
                                                        objRememberedValue43 = Stack.mutableStateOf$default(null);
                                                        gapComposer6.updateRememberedValue(objRememberedValue43);
                                                    }
                                                    MutableState mutableState29 = (MutableState) objRememberedValue43;
                                                    Object objRememberedValue44 = gapComposer6.rememberedValue();
                                                    if (objRememberedValue44 == neverEqualPolicy4) {
                                                        objRememberedValue44 = Stack.mutableStateOf$default(null);
                                                        gapComposer6.updateRememberedValue(objRememberedValue44);
                                                    }
                                                    MutableState mutableState30 = (MutableState) objRememberedValue44;
                                                    StaticProvidableCompositionLocal staticProvidableCompositionLocal4 = MaterialThemeKt._localMaterialTheme;
                                                    TextStyle textStyle = ((MaterialTheme$Values) gapComposer6.consume(staticProvidableCompositionLocal4)).typography.titleMedium;
                                                    if (z27) {
                                                        gapComposer6.startReplaceGroup(-156854627);
                                                        long j16 = ((MaterialTheme$Values) gapComposer6.consume(staticProvidableCompositionLocal4)).colorScheme.primary;
                                                        long jColor = ColorKt.Color(Color.m485getRedimpl(j16), Color.m484getGreenimpl(j16), Color.m482getBlueimpl(j16), 0.8f, Color.m483getColorSpaceimpl(j16));
                                                        gapComposer6.end(false);
                                                        j12 = jColor;
                                                    } else {
                                                        gapComposer6.startReplaceGroup(-156853869);
                                                        gapComposer6.end(false);
                                                        j12 = j15;
                                                    }
                                                    TextStyle textStyleM750copyp1EtxEg$default = TextStyle.m750copyp1EtxEg$default(textStyle, j12, 0L, z27 ? FontWeight.Medium : null, null, null, null, 0L, 0L, null, null, 16777210);
                                                    Object objRememberedValue45 = gapComposer6.rememberedValue();
                                                    if (objRememberedValue45 == neverEqualPolicy4) {
                                                        objRememberedValue45 = new ScrimKt$Scrim$dismissModifier$1$1((byte) 9, mutableState30);
                                                        gapComposer6.updateRememberedValue(objRememberedValue45);
                                                    }
                                                    unit = unit2;
                                                    Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(companion2, unit, (PointerInputEventHandler) objRememberedValue45);
                                                    Object objRememberedValue46 = gapComposer6.rememberedValue();
                                                    if (objRememberedValue46 == neverEqualPolicy4) {
                                                        objRememberedValue46 = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer6);
                                                    }
                                                    MutableInteractionSourceImpl mutableInteractionSourceImpl = (MutableInteractionSourceImpl) objRememberedValue46;
                                                    String str8 = str4;
                                                    boolean zChanged11 = gapComposer6.changed(str8) | gapComposer6.changed(annotatedString2) | gapComposer6.changedInstance(clipboardManager3) | gapComposer6.changedInstance(context7);
                                                    Object objRememberedValue47 = gapComposer6.rememberedValue();
                                                    if (zChanged11 || objRememberedValue47 == neverEqualPolicy4) {
                                                        objRememberedValue47 = new SongMenuKt$$ExternalSyntheticLambda63(str8, annotatedString2, clipboardManager3, context7, (byte) 22);
                                                        gapComposer6.updateRememberedValue(objRememberedValue47);
                                                    }
                                                    Function0 function2 = (Function0) objRememberedValue47;
                                                    boolean zChanged12 = gapComposer6.changed(annotatedString2) | gapComposer6.changedInstance(navHostController3) | gapComposer6.changed(bottomSheetState8);
                                                    Object objRememberedValue48 = gapComposer6.rememberedValue();
                                                    if (zChanged12 || objRememberedValue48 == neverEqualPolicy4) {
                                                        annotatedString = annotatedString2;
                                                        bottomSheetState6 = bottomSheetState8;
                                                        objRememberedValue48 = new SongMenuKt$$ExternalSyntheticLambda40((Object) annotatedString, (Object) mutableState30, (Object) mutableState29, (Object) navHostController3, (Object) bottomSheetState6, (byte) 14);
                                                        gapComposer6.updateRememberedValue(objRememberedValue48);
                                                    } else {
                                                        annotatedString = annotatedString2;
                                                        bottomSheetState6 = bottomSheetState8;
                                                    }
                                                    Modifier modifierM47combinedClickableauXiCPI$default = ImageKt.m47combinedClickableauXiCPI$default(modifierPointerInput, mutableInteractionSourceImpl, null, true, null, function2, (Function0) objRememberedValue48, 440);
                                                    Object objRememberedValue49 = gapComposer6.rememberedValue();
                                                    if (objRememberedValue49 == neverEqualPolicy4) {
                                                        objRememberedValue49 = new TooltipKt$$ExternalSyntheticLambda5(mutableState29, (byte) 21);
                                                        gapComposer6.updateRememberedValue(objRememberedValue49);
                                                    }
                                                    TextKt.m353TextZ58ophY(annotatedString, modifierM47combinedClickableauXiCPI$default, 0L, 0L, null, 0L, null, 0L, 2, false, 1, 0, null, (Function1) objRememberedValue49, textStyleM750copyp1EtxEg$default, gapComposer6, 0, 12607872, 110588);
                                                    gapComposer4 = gapComposer6;
                                                    z25 = true;
                                                    gapComposer4.end(true);
                                                    gapComposer4.end(false);
                                                    playerKt$$ExternalSyntheticLambda5 = this;
                                                    break;
                                                }
                                                Object next = it2.next();
                                                int i10 = i9 + 1;
                                                if (i9 < 0) {
                                                    CollectionsKt__IterablesKt.throwIndexOverflow();
                                                    throw null;
                                                }
                                                MediaMetadata.Artist artist = (MediaMetadata.Artist) next;
                                                Iterator it3 = it2;
                                                String str9 = artist.id;
                                                if (str9 == null) {
                                                    str9 = "";
                                                }
                                                BiasAlignment.Vertical vertical5 = vertical4;
                                                String strConcat = "artist_".concat(str9);
                                                String str10 = artist.id;
                                                if (str10 == null) {
                                                    str10 = "";
                                                }
                                                builder.pushStringAnnotation(strConcat, str10);
                                                if (z27) {
                                                    gapComposer6.startReplaceGroup(-1517729648);
                                                    long j17 = ((MaterialTheme$Values) gapComposer6.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.primary;
                                                    long jColor2 = ColorKt.Color(Color.m485getRedimpl(j17), Color.m484getGreenimpl(j17), Color.m482getBlueimpl(j17), 0.8f, Color.m483getColorSpaceimpl(j17));
                                                    gapComposer6.end(false);
                                                    j13 = jColor2;
                                                } else {
                                                    gapComposer6.startReplaceGroup(-1517728890);
                                                    gapComposer6.end(false);
                                                    j13 = j15;
                                                }
                                                int iPushStyle = builder.pushStyle(new SpanStyle(j13, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, 65534));
                                                try {
                                                    builder.append(artist.name);
                                                    builder.pop(iPushStyle);
                                                    builder.pop();
                                                    if (i9 != list.size() - 1) {
                                                        builder.append(", ");
                                                    }
                                                    it2 = it3;
                                                    i9 = i10;
                                                    mediaMetadata7 = mediaMetadata5;
                                                    bottomSheetState7 = bottomSheetState7;
                                                    vertical4 = vertical5;
                                                } catch (Throwable th3) {
                                                    builder.pop(iPushStyle);
                                                    throw th3;
                                                }
                                            }
                                        } else {
                                            context7 = context7;
                                        }
                                    }
                                } else {
                                    playerKt$$ExternalSyntheticLambda5 = this;
                                    vertical2 = vertical4;
                                    updater$$ExternalSyntheticLambda4 = updater$$ExternalSyntheticLambda4;
                                    mediaMetadata5 = mediaMetadata7;
                                    gapComposer4 = gapComposer6;
                                    bottomSheetState6 = bottomSheetState7;
                                    unit = unit2;
                                    neverEqualPolicy4 = neverEqualPolicy5;
                                    z25 = true;
                                    gapComposer4.startReplaceGroup(-2058975681);
                                    gapComposer4.end(false);
                                }
                                gapComposer4.end(z25);
                                gapComposer4.end(z25);
                                OffsetKt.Spacer(gapComposer4, SizeKt.m155width3ABfNKs(companion2, 8.0f));
                                RowMeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(OffsetKt.Start, vertical2, gapComposer4, 48);
                                int iHashCode5 = Long.hashCode(gapComposer4.compositeKeyHashCode);
                                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope5 = gapComposer4.currentCompositionLocalScope();
                                Modifier modifierMaterializeModifier5 = ZIndexModifierKt.materializeModifier(gapComposer4, companion2);
                                ComposeUiNode.Companion.getClass();
                                gapComposer4.startReusableNode();
                                if (gapComposer4.inserting) {
                                    gapComposer4.createNode(textKt$$ExternalSyntheticLambda3);
                                } else {
                                    gapComposer4.useNode();
                                }
                                Stack.m390setimpl(gapComposer4, rowMeasurePolicy3, updater$$ExternalSyntheticLambda0);
                                Stack.m390setimpl(gapComposer4, persistentCompositionLocalHashMapCurrentCompositionLocalScope5, updater$$ExternalSyntheticLambda1);
                                IntIntPair$$ExternalSyntheticOutline0.m(iHashCode5, gapComposer4, updater$$ExternalSyntheticLambda2, gapComposer4);
                                Stack.m390setimpl(gapComposer4, modifierMaterializeModifier5, updater$$ExternalSyntheticLambda4);
                                Boolean bool10 = (Boolean) mutableState27.getValue();
                                bool10.getClass();
                                Unit unit3 = unit;
                                final PlayerConnection playerConnection8 = playerConnection7;
                                boolean z30 = z25;
                                final MutableState mutableState31 = mutableState22;
                                NeverEqualPolicy neverEqualPolicy6 = neverEqualPolicy4;
                                final MenuState menuState3 = menuState2;
                                final BottomSheetPageState bottomSheetPageState3 = bottomSheetPageState2;
                                final long j18 = j10;
                                final long j19 = j11;
                                final MediaMetadata mediaMetadata8 = mediaMetadata5;
                                final BottomSheetState bottomSheetState9 = bottomSheetState6;
                                CrossfadeKt.AnimatedContent(bool10, null, null, null, "LikeButton", null, Expect_jvmKt.rememberComposableLambda(1792962614, new Function4() { // from class: com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda27
                                    /* JADX WARN: Code duplicated, block: B:43:0x0177  */
                                    /* JADX WARN: Code duplicated, block: B:45:0x017b  */
                                    @Override // kotlin.jvm.functions.Function4
                                    public final Object invoke(Object obj42, Object obj43, Object obj44, Object obj45) {
                                        SongEntity songEntity;
                                        final boolean z31;
                                        Modifier.Companion companion3;
                                        Modifier modifierPressScale;
                                        boolean z32;
                                        SongEntity songEntity2;
                                        SongEntity songEntity3;
                                        boolean zBooleanValue7 = ((Boolean) obj43).booleanValue();
                                        Composer composer4 = (Composer) obj44;
                                        int iIntValue3 = ((Integer) obj45).intValue();
                                        Arrangement$End$1 arrangement$End$1 = OffsetKt.Start;
                                        BiasAlignment.Vertical vertical6 = Alignment.Companion.CenterVertically;
                                        ((AnimatedContentScopeImpl) obj42).getClass();
                                        if ((iIntValue3 & 48) == 0) {
                                            iIntValue3 |= ((GapComposer) composer4).changed(zBooleanValue7) ? 32 : 16;
                                        }
                                        GapComposer gapComposer7 = (GapComposer) composer4;
                                        if (gapComposer7.shouldExecute(iIntValue3 & 1, (iIntValue3 & 145) != 144)) {
                                            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda5 = ComposeUiNode.Companion.SetModifier;
                                            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda6 = ComposeUiNode.Companion.SetCompositeKeyHash;
                                            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda7 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                                            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda8 = ComposeUiNode.Companion.SetMeasurePolicy;
                                            Modifier.Companion companion4 = Modifier.Companion.$$INSTANCE;
                                            PlayerConnection playerConnection9 = playerConnection8;
                                            State state11 = state10;
                                            MediaMetadata mediaMetadata9 = mediaMetadata8;
                                            final long j20 = j14;
                                            TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda4 = LayoutNode.Constructor;
                                            NeverEqualPolicy neverEqualPolicy7 = Composer.Companion.Empty;
                                            if (zBooleanValue7) {
                                                gapComposer7.startReplaceGroup(1936070014);
                                                MutableState mutableStateCollectAsStateWithLifecycle14 = FileSystemsKt.collectAsStateWithLifecycle(playerConnection9.currentLyrics, null, gapComposer7, 48);
                                                RowMeasurePolicy rowMeasurePolicy4 = RowKt.rowMeasurePolicy(arrangement$End$1, vertical6, gapComposer7, 48);
                                                int iHashCode6 = Long.hashCode(gapComposer7.compositeKeyHashCode);
                                                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope6 = gapComposer7.currentCompositionLocalScope();
                                                Modifier modifierMaterializeModifier6 = ZIndexModifierKt.materializeModifier(gapComposer7, companion4);
                                                ComposeUiNode.Companion.getClass();
                                                gapComposer7.startReusableNode();
                                                if (gapComposer7.inserting) {
                                                    gapComposer7.createNode(textKt$$ExternalSyntheticLambda4);
                                                } else {
                                                    gapComposer7.useNode();
                                                }
                                                Stack.m390setimpl(gapComposer7, rowMeasurePolicy4, updater$$ExternalSyntheticLambda8);
                                                Stack.m390setimpl(gapComposer7, persistentCompositionLocalHashMapCurrentCompositionLocalScope6, updater$$ExternalSyntheticLambda7);
                                                Stack.m390setimpl(gapComposer7, Integer.valueOf(iHashCode6), updater$$ExternalSyntheticLambda6);
                                                Stack.m389reconcileimpl(gapComposer7);
                                                Stack.m390setimpl(gapComposer7, modifierMaterializeModifier6, updater$$ExternalSyntheticLambda5);
                                                MutableState mutableState32 = mutableState31;
                                                boolean zChanged13 = gapComposer7.changed(mutableState32);
                                                Object objRememberedValue50 = gapComposer7.rememberedValue();
                                                if (zChanged13 || objRememberedValue50 == neverEqualPolicy7) {
                                                    objRememberedValue50 = new PlayerKt$$ExternalSyntheticLambda7(mutableState32, (byte) 2);
                                                    gapComposer7.updateRememberedValue(objRememberedValue50);
                                                }
                                                CardKt.IconButton((Function0) objRememberedValue50, null, false, null, null, Expect_jvmKt.rememberComposableLambda(1920119315, new ListItemKt$$ExternalSyntheticLambda18(j20, (byte) 3), gapComposer7), gapComposer7, 1572864, 62);
                                                MenuState menuState4 = menuState3;
                                                boolean zChanged14 = gapComposer7.changed(menuState4) | gapComposer7.changed(mutableStateCollectAsStateWithLifecycle14) | gapComposer7.changed(state11) | gapComposer7.changed(mediaMetadata9);
                                                BottomSheetPageState bottomSheetPageState4 = bottomSheetPageState3;
                                                boolean zChanged15 = zChanged14 | gapComposer7.changed(bottomSheetPageState4);
                                                Object objRememberedValue51 = gapComposer7.rememberedValue();
                                                if (zChanged15 || objRememberedValue51 == neverEqualPolicy7) {
                                                    SongMenuKt$$ExternalSyntheticLambda40 songMenuKt$$ExternalSyntheticLambda40 = new SongMenuKt$$ExternalSyntheticLambda40((Object) menuState4, (Object) mutableStateCollectAsStateWithLifecycle14, (Object) state11, (Object) mediaMetadata9, (Object) bottomSheetPageState4, (byte) 15);
                                                    gapComposer7.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda40);
                                                    objRememberedValue51 = songMenuKt$$ExternalSyntheticLambda40;
                                                }
                                                CardKt.IconButton((Function0) objRememberedValue51, null, false, null, null, Expect_jvmKt.rememberComposableLambda(267097802, new ListItemKt$$ExternalSyntheticLambda18(j20, (byte) 4), gapComposer7), gapComposer7, 1572864, 62);
                                                gapComposer7.end(true);
                                                gapComposer7.end(false);
                                            } else {
                                                gapComposer7.startReplaceGroup(1938431191);
                                                Song song = (Song) state11.getValue();
                                                if (song == null || (songEntity2 = song.song) == null || !songEntity2.isEpisode) {
                                                    Song song2 = (Song) state11.getValue();
                                                    if (song2 == null || (songEntity = song2.song) == null || !songEntity.liked) {
                                                        z31 = false;
                                                    } else {
                                                        z31 = true;
                                                    }
                                                } else {
                                                    Song song3 = (Song) state11.getValue();
                                                    if (((song3 == null || (songEntity3 = song3.song) == null) ? null : songEntity3.inLibrary) != null) {
                                                        z31 = true;
                                                    } else {
                                                        z31 = false;
                                                    }
                                                }
                                                RowMeasurePolicy rowMeasurePolicy5 = RowKt.rowMeasurePolicy(arrangement$End$1, vertical6, gapComposer7, 48);
                                                int iHashCode7 = Long.hashCode(gapComposer7.compositeKeyHashCode);
                                                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope7 = gapComposer7.currentCompositionLocalScope();
                                                Modifier modifierMaterializeModifier7 = ZIndexModifierKt.materializeModifier(gapComposer7, companion4);
                                                ComposeUiNode.Companion.getClass();
                                                gapComposer7.startReusableNode();
                                                if (gapComposer7.inserting) {
                                                    gapComposer7.createNode(textKt$$ExternalSyntheticLambda4);
                                                } else {
                                                    gapComposer7.useNode();
                                                }
                                                Stack.m390setimpl(gapComposer7, rowMeasurePolicy5, updater$$ExternalSyntheticLambda8);
                                                Stack.m390setimpl(gapComposer7, persistentCompositionLocalHashMapCurrentCompositionLocalScope7, updater$$ExternalSyntheticLambda7);
                                                Stack.m390setimpl(gapComposer7, Integer.valueOf(iHashCode7), updater$$ExternalSyntheticLambda6);
                                                Stack.m389reconcileimpl(gapComposer7);
                                                Stack.m390setimpl(gapComposer7, modifierMaterializeModifier7, updater$$ExternalSyntheticLambda5);
                                                boolean zChangedInstance3 = gapComposer7.changedInstance(playerConnection9);
                                                Object objRememberedValue52 = gapComposer7.rememberedValue();
                                                if (zChangedInstance3 || objRememberedValue52 == neverEqualPolicy7) {
                                                    RoomDatabase$closeBarrier$1 roomDatabase$closeBarrier$1 = new RoomDatabase$closeBarrier$1(0, playerConnection9, PlayerConnection.class, "toggleLike", "toggleLike()V", 0, (byte) 19);
                                                    gapComposer7.updateRememberedValue(roomDatabase$closeBarrier$1);
                                                    objRememberedValue52 = roomDatabase$closeBarrier$1;
                                                }
                                                Function0 function3 = (Function0) ((KFunction) objRememberedValue52);
                                                final boolean z33 = z27;
                                                if (z33) {
                                                    gapComposer7.startReplaceGroup(-993220784);
                                                    companion3 = companion4;
                                                    modifierPressScale = GlassComponentsKt.glass(DialogKt.pressScale(SizeKt.m151size3ABfNKs(companion4, 42.0f), 0.9f), RoundedCornerShapeKt.CircleShape, false, gapComposer7, 0, 2);
                                                    gapComposer7.end(false);
                                                } else {
                                                    companion3 = companion4;
                                                    gapComposer7.startReplaceGroup(-993219730);
                                                    gapComposer7.end(false);
                                                    modifierPressScale = DialogKt.pressScale(companion3, 0.9f);
                                                }
                                                CardKt.IconButton(function3, modifierPressScale, false, null, null, Expect_jvmKt.rememberComposableLambda(425157084, new Function2() { // from class: com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda60
                                                    @Override // kotlin.jvm.functions.Function2
                                                    public final Object invoke(Object obj46, Object obj47) throws XmlPullParserException, IOException {
                                                        long j21;
                                                        Composer composer5 = (Composer) obj46;
                                                        int iIntValue4 = ((Integer) obj47).intValue();
                                                        byte b2 = 1;
                                                        GapComposer gapComposer8 = (GapComposer) composer5;
                                                        if (gapComposer8.shouldExecute(iIntValue4 & 1, (iIntValue4 & 3) != 2)) {
                                                            boolean z34 = z31;
                                                            Painter painterPainterResource = IntMath.painterResource(z34 ? R.drawable.favorite : R.drawable.favorite_border, 0, gapComposer8);
                                                            if (z34) {
                                                                gapComposer8.startReplaceGroup(554086467);
                                                                j21 = ((MaterialTheme$Values) gapComposer8.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.primary;
                                                                gapComposer8.end(false);
                                                            } else {
                                                                gapComposer8.startReplaceGroup(554086884);
                                                                gapComposer8.end(false);
                                                                j21 = j20;
                                                            }
                                                            long j22 = j21;
                                                            Modifier modifierM151size3ABfNKs = SizeKt.m151size3ABfNKs(Modifier.Companion.$$INSTANCE, z33 ? 22.0f : 26.0f);
                                                            modifierM151size3ABfNKs.getClass();
                                                            IconKt.m290Iconww6aTOc(painterPainterResource, (String) null, modifierM151size3ABfNKs.then(new ComposedModifier(new MiniPlayerKt$$ExternalSyntheticLambda17(b2, z34))), j22, gapComposer8, 56, 0);
                                                        } else {
                                                            gapComposer8.skipToGroupEnd();
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                }, gapComposer7), gapComposer7, 1572864, 60);
                                                if (z33) {
                                                    gapComposer7.startReplaceGroup(-993187974);
                                                    OffsetKt.Spacer(gapComposer7, SizeKt.m155width3ABfNKs(companion3, 8.0f));
                                                    z32 = false;
                                                } else {
                                                    z32 = false;
                                                    gapComposer7.startReplaceGroup(-724029212);
                                                }
                                                gapComposer7.end(z32);
                                                QueueKt.m1505PlayerMoreMenuButtonZkgLGzA(mediaMetadata9, bottomSheetState9, z33, j18, j19, gapComposer7, 0);
                                                gapComposer7.end(true);
                                                gapComposer7.end(z32);
                                            }
                                        } else {
                                            gapComposer7.skipToGroupEnd();
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }, gapComposer4), gapComposer4, 1597440, 46);
                                gapComposer4.end(z30);
                                gapComposer4.end(z30);
                                OffsetKt.Spacer(gapComposer4, SizeKt.m145height3ABfNKs(companion2, 20.0f));
                                SliderStyle sliderStyle = (SliderStyle) mutableState23.getValue();
                                boolean zBooleanValue7 = ((Boolean) mutableState24.getValue()).booleanValue();
                                Object objRememberedValue50 = gapComposer4.rememberedValue();
                                if (objRememberedValue50 == neverEqualPolicy6) {
                                    objRememberedValue50 = new MainActivity$$ExternalSyntheticLambda22(state4, (byte) 14);
                                    gapComposer4.updateRememberedValue(objRememberedValue50);
                                }
                                Function0 function3 = (Function0) objRememberedValue50;
                                Object objRememberedValue51 = gapComposer4.rememberedValue();
                                if (objRememberedValue51 == neverEqualPolicy6) {
                                    objRememberedValue51 = new PlayerKt$$ExternalSyntheticLambda29(parcelableSnapshotMutableLongState15, (byte) 0);
                                    gapComposer4.updateRememberedValue(objRememberedValue51);
                                }
                                Function0 function5 = (Function0) objRememberedValue51;
                                final boolean z31 = z21;
                                boolean z32 = !z31;
                                final MutableState mutableState32 = mutableState19;
                                boolean zChanged13 = gapComposer4.changed(mutableState32);
                                final CastConnectionHandler castConnectionHandler4 = castConnectionHandler3;
                                boolean zChangedInstance3 = zChanged13 | gapComposer4.changedInstance(castConnectionHandler4) | gapComposer4.changedInstance(playerConnection8);
                                Object objRememberedValue52 = gapComposer4.rememberedValue();
                                if (zChangedInstance3 || objRememberedValue52 == neverEqualPolicy6) {
                                    MainActivity$$ExternalSyntheticLambda59 mainActivity$$ExternalSyntheticLambda59 = new MainActivity$$ExternalSyntheticLambda59(castConnectionHandler4, playerConnection8, mutableState32, parcelableSnapshotMutableLongState16, parcelableSnapshotMutableLongState17);
                                    gapComposer4.updateRememberedValue(mainActivity$$ExternalSyntheticLambda59);
                                    objRememberedValue52 = mainActivity$$ExternalSyntheticLambda59;
                                }
                                Function1 function6 = (Function1) objRememberedValue52;
                                MutableState mutableState33 = mutableState18;
                                final boolean z33 = z22;
                                QueueKt.m1506PlayerProgressSectiongMrHQkA(sliderStyle, zBooleanValue7, function3, function5, mutableState33, z32, z33, z27, function6, gapComposer4, 12610944);
                                OffsetKt.Spacer(gapComposer4, SizeKt.m145height3ABfNKs(companion2, 16.0f));
                                boolean z34 = (((Boolean) mutableState31.getValue()).booleanValue() ? 1 : 0) ^ (z30 ? 1 : 0);
                                Object objRememberedValue53 = gapComposer4.rememberedValue();
                                if (objRememberedValue53 == neverEqualPolicy6) {
                                    objRememberedValue53 = new AlbumMenuKt$$ExternalSyntheticLambda13((byte) 13);
                                    gapComposer4.updateRememberedValue(objRememberedValue53);
                                }
                                EnterTransitionImpl enterTransitionImplPlus = EnterExitTransitionKt.slideInVertically$default(z30 ? 1 : 0, (Function1) objRememberedValue53).plus(EnterExitTransitionKt.fadeIn$default(null, CropImageView.DEFAULT_ASPECT_RATIO, 3));
                                ExitTransitionImpl exitTransitionImplShrinkVertically$default = EnterExitTransitionKt.shrinkVertically$default(null, 13);
                                Object objRememberedValue54 = gapComposer4.rememberedValue();
                                if (objRememberedValue54 == neverEqualPolicy6) {
                                    objRememberedValue54 = new AlbumMenuKt$$ExternalSyntheticLambda13((byte) 13);
                                    gapComposer4.updateRememberedValue(objRememberedValue54);
                                }
                                ExitTransitionImpl exitTransitionImplPlus = exitTransitionImplShrinkVertically$default.plus(EnterExitTransitionKt.slideOutVertically$default(z30 ? 1 : 0, (Function1) objRememberedValue54)).plus(EnterExitTransitionKt.fadeOut$default(null, CropImageView.DEFAULT_ASPECT_RATIO, 3));
                                final State state11 = state5;
                                final State state12 = state6;
                                final MutableState mutableState34 = mutableState25;
                                final FocusRequester focusRequester4 = focusRequester3;
                                final State state13 = state7;
                                final State state14 = state8;
                                final State state15 = state9;
                                final MutableState mutableState35 = mutableState26;
                                CrossfadeKt.AnimatedVisibility(columnScopeInstance, z34, null, enterTransitionImplPlus, exitTransitionImplPlus, null, Expect_jvmKt.rememberComposableLambda(-1706429495, new Function3() { // from class: com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda21
                                    @Override // kotlin.jvm.functions.Function3
                                    public final Object invoke(Object obj42, Object obj43, Object obj44) {
                                        long jColor3;
                                        long jColor4;
                                        Modifier modifierM39backgroundbw27NRU;
                                        final boolean z35;
                                        MutableState mutableState36;
                                        int i11;
                                        Composer composer4 = (Composer) obj43;
                                        int iIntValue3 = ((Integer) obj44).intValue();
                                        ((AnimatedVisibilityScope) obj42).getClass();
                                        GapComposer gapComposer7 = (GapComposer) composer4;
                                        if (gapComposer7.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                                            FlowRowOverflow flowRowOverflow2 = OffsetKt.SpaceBetween;
                                            BiasAlignment.Vertical vertical6 = Alignment.Companion.CenterVertically;
                                            Modifier.Companion companion3 = Modifier.Companion.$$INSTANCE;
                                            Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion3, 1.0f);
                                            float f2 = CropImageView.DEFAULT_ASPECT_RATIO;
                                            Modifier modifierM1474hairlineTopiJQMabo = DialogKt.m1474hairlineTopiJQMabo(OffsetKt.m137paddingVpY3zN4$default(modifierFillMaxWidth, 20.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2), gapComposer7, 6);
                                            final boolean z36 = z27;
                                            if (!z36) {
                                                f2 = 8.0f;
                                            }
                                            Modifier modifierM139paddingqDBjuR0$default2 = OffsetKt.m139paddingqDBjuR0$default(modifierM1474hairlineTopiJQMabo, CropImageView.DEFAULT_ASPECT_RATIO, f2, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 13);
                                            RowMeasurePolicy rowMeasurePolicy4 = RowKt.rowMeasurePolicy(flowRowOverflow2, vertical6, gapComposer7, 54);
                                            int iHashCode6 = Long.hashCode(gapComposer7.compositeKeyHashCode);
                                            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope6 = gapComposer7.currentCompositionLocalScope();
                                            Modifier modifierMaterializeModifier6 = ZIndexModifierKt.materializeModifier(gapComposer7, modifierM139paddingqDBjuR0$default2);
                                            ComposeUiNode.Companion.getClass();
                                            gapComposer7.startReusableNode();
                                            boolean z37 = gapComposer7.inserting;
                                            TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda4 = LayoutNode.Constructor;
                                            if (z37) {
                                                gapComposer7.createNode(textKt$$ExternalSyntheticLambda4);
                                            } else {
                                                gapComposer7.useNode();
                                            }
                                            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda5 = ComposeUiNode.Companion.SetMeasurePolicy;
                                            Stack.m390setimpl(gapComposer7, rowMeasurePolicy4, updater$$ExternalSyntheticLambda5);
                                            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda6 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                                            Stack.m390setimpl(gapComposer7, persistentCompositionLocalHashMapCurrentCompositionLocalScope6, updater$$ExternalSyntheticLambda6);
                                            Integer numValueOf4 = Integer.valueOf(iHashCode6);
                                            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda7 = ComposeUiNode.Companion.SetCompositeKeyHash;
                                            Stack.m390setimpl(gapComposer7, numValueOf4, updater$$ExternalSyntheticLambda7);
                                            Stack.m389reconcileimpl(gapComposer7);
                                            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda8 = ComposeUiNode.Companion.SetModifier;
                                            Stack.m390setimpl(gapComposer7, modifierMaterializeModifier6, updater$$ExternalSyntheticLambda8);
                                            final boolean z38 = z31;
                                            float f3 = z38 ? 0.38f : 1.0f;
                                            State state16 = state11;
                                            boolean zBooleanValue8 = ((Boolean) state16.getValue()).booleanValue();
                                            long j20 = j15;
                                            if (zBooleanValue8) {
                                                gapComposer7.startReplaceGroup(-1253615028);
                                                jColor3 = ((MaterialTheme$Values) gapComposer7.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.primary;
                                                gapComposer7.end(false);
                                            } else {
                                                gapComposer7.startReplaceGroup(-1253614307);
                                                gapComposer7.end(false);
                                                jColor3 = ColorKt.Color(Color.m485getRedimpl(j20), Color.m484getGreenimpl(j20), Color.m482getBlueimpl(j20), f3, Color.m483getColorSpaceimpl(j20));
                                            }
                                            AnimateAsState animateAsStateM17animateColorAsStateeuL9pac2 = SingleValueAnimationKt.m17animateColorAsStateeuL9pac(jColor3, ArcSplineKt.tween$default(200, 0, null, 6), "shuffleTint", gapComposer7, 432, 8);
                                            State state17 = state13;
                                            if (((Number) state17.getValue()).intValue() != 0) {
                                                gapComposer7.startReplaceGroup(-1253604340);
                                                jColor4 = ((MaterialTheme$Values) gapComposer7.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.primary;
                                                gapComposer7.end(false);
                                            } else {
                                                gapComposer7.startReplaceGroup(-1253603619);
                                                gapComposer7.end(false);
                                                jColor4 = ColorKt.Color(Color.m485getRedimpl(j20), Color.m484getGreenimpl(j20), Color.m482getBlueimpl(j20), f3, Color.m483getColorSpaceimpl(j20));
                                            }
                                            AnimateAsState animateAsStateM17animateColorAsStateeuL9pac3 = SingleValueAnimationKt.m17animateColorAsStateeuL9pac(jColor4, ArcSplineKt.tween$default(200, 0, null, 6), "repeatTint", gapComposer7, 432, 8);
                                            boolean z39 = !z38;
                                            Modifier modifierPressScale = DialogKt.pressScale(companion3, 0.92f);
                                            PlayerConnection playerConnection9 = playerConnection8;
                                            boolean zChangedInstance4 = gapComposer7.changedInstance(playerConnection9) | gapComposer7.changed(state16);
                                            Object objRememberedValue55 = gapComposer7.rememberedValue();
                                            NeverEqualPolicy neverEqualPolicy7 = Composer.Companion.Empty;
                                            if (zChangedInstance4 || objRememberedValue55 == neverEqualPolicy7) {
                                                objRememberedValue55 = new ComponentRegistry$Builder$$ExternalSyntheticLambda2(playerConnection9, state16, (byte) 26);
                                                gapComposer7.updateRememberedValue(objRememberedValue55);
                                            }
                                            CardKt.IconButton((Function0) objRememberedValue55, modifierPressScale, z39, null, null, Expect_jvmKt.rememberComposableLambda(-1904914041, new PlayerKt$$ExternalSyntheticLambda35(animateAsStateM17animateColorAsStateeuL9pac2, (byte) 0), gapComposer7), gapComposer7, 1572864, 56);
                                            boolean zChangedInstance5 = gapComposer7.changedInstance(playerConnection9);
                                            Object objRememberedValue56 = gapComposer7.rememberedValue();
                                            if (zChangedInstance5 || objRememberedValue56 == neverEqualPolicy7) {
                                                objRememberedValue56 = new RoomDatabase$closeBarrier$1(0, playerConnection9, PlayerConnection.class, "seekToPrevious", "seekToPrevious()V", 0, (byte) 20);
                                                gapComposer7.updateRememberedValue(objRememberedValue56);
                                            }
                                            KFunction kFunction = (KFunction) objRememberedValue56;
                                            final State state18 = state14;
                                            boolean z40 = ((Boolean) state18.getValue()).booleanValue() && !z38;
                                            Modifier modifierPressScale2 = z36 ? DialogKt.pressScale(SizeKt.m151size3ABfNKs(companion3, 64.0f), 0.86f) : DialogKt.pressScale(companion3, 0.92f);
                                            final byte b2 = 0;
                                            final long j21 = j14;
                                            CardKt.IconButton((Function0) kFunction, modifierPressScale2, z40, null, null, Expect_jvmKt.rememberComposableLambda(-1623529296, new Function2() { // from class: com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda36
                                                @Override // kotlin.jvm.functions.Function2
                                                public final Object invoke(Object obj45, Object obj46) throws XmlPullParserException, IOException {
                                                    byte b3 = b2;
                                                    Unit unit4 = Unit.INSTANCE;
                                                    Modifier.Companion companion4 = Modifier.Companion.$$INSTANCE;
                                                    State state19 = state18;
                                                    boolean z41 = z36;
                                                    long jColor5 = j21;
                                                    boolean z42 = z38;
                                                    switch (b3) {
                                                        case 0:
                                                            Composer composer5 = (Composer) obj45;
                                                            int iIntValue4 = ((Integer) obj46).intValue();
                                                            GapComposer gapComposer8 = (GapComposer) composer5;
                                                            if (!gapComposer8.shouldExecute(1 & iIntValue4, (iIntValue4 & 3) != 2)) {
                                                                gapComposer8.skipToGroupEnd();
                                                            } else {
                                                                Painter painterPainterResource = IntMath.painterResource(R.drawable.skip_previous, 0, gapComposer8);
                                                                if (!((Boolean) state19.getValue()).booleanValue() || z42) {
                                                                    jColor5 = ColorKt.Color(Color.m485getRedimpl(jColor5), Color.m484getGreenimpl(jColor5), Color.m482getBlueimpl(jColor5), 0.38f, Color.m483getColorSpaceimpl(jColor5));
                                                                }
                                                                IconKt.m290Iconww6aTOc(painterPainterResource, (String) null, SizeKt.m151size3ABfNKs(companion4, z41 ? 42.0f : 34.0f), jColor5, gapComposer8, 56, 0);
                                                            }
                                                            break;
                                                        default:
                                                            MutableState mutableState37 = (MutableState) state19;
                                                            Composer composer6 = (Composer) obj45;
                                                            int iIntValue5 = ((Integer) obj46).intValue();
                                                            GapComposer gapComposer9 = (GapComposer) composer6;
                                                            if (!gapComposer9.shouldExecute(1 & iIntValue5, (iIntValue5 & 3) != 2)) {
                                                                gapComposer9.skipToGroupEnd();
                                                            } else {
                                                                Painter painterPainterResource2 = IntMath.painterResource(R.drawable.skip_next, 0, gapComposer9);
                                                                if (!((Boolean) mutableState37.getValue()).booleanValue() || z42) {
                                                                    jColor5 = ColorKt.Color(Color.m485getRedimpl(jColor5), Color.m484getGreenimpl(jColor5), Color.m482getBlueimpl(jColor5), 0.38f, Color.m483getColorSpaceimpl(jColor5));
                                                                }
                                                                IconKt.m290Iconww6aTOc(painterPainterResource2, (String) null, SizeKt.m151size3ABfNKs(companion4, z41 ? 42.0f : 34.0f), jColor5, gapComposer9, 56, 0);
                                                            }
                                                            break;
                                                    }
                                                    return unit4;
                                                }
                                            }, gapComposer7), gapComposer7, 1572864, 56);
                                            BiasAlignment biasAlignment2 = Alignment.Companion.Center;
                                            Modifier modifierClip = ClipKt.clip(SizeKt.m151size3ABfNKs(DialogKt.pressScale(companion3, z36 ? 0.88f : 0.92f), z36 ? 72.0f : 76.0f), z36 ? RoundedCornerShapeKt.CircleShape : RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(16.0f));
                                            if (z36) {
                                                gapComposer7.startReplaceGroup(-1253540627);
                                                gapComposer7.end(false);
                                                modifierM39backgroundbw27NRU = companion3;
                                            } else {
                                                gapComposer7.startReplaceGroup(-1253539854);
                                                modifierM39backgroundbw27NRU = ImageKt.m39backgroundbw27NRU(companion3, ((MaterialTheme$Values) gapComposer7.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.primary, ColorKt.RectangleShape);
                                                gapComposer7.end(false);
                                            }
                                            Modifier modifierThen = modifierClip.then(modifierM39backgroundbw27NRU);
                                            boolean zChanged14 = gapComposer7.changed(z38) | gapComposer7.changedInstance(playerConnection9);
                                            MutableState mutableState37 = mutableState32;
                                            boolean zChanged15 = zChanged14 | gapComposer7.changed(mutableState37);
                                            State state19 = state12;
                                            boolean zChanged16 = zChanged15 | gapComposer7.changed(state19);
                                            CastConnectionHandler castConnectionHandler5 = castConnectionHandler4;
                                            boolean zChangedInstance6 = zChanged16 | gapComposer7.changedInstance(castConnectionHandler5);
                                            MutableState mutableState38 = mutableState34;
                                            boolean zChanged17 = zChangedInstance6 | gapComposer7.changed(mutableState38);
                                            Object objRememberedValue57 = gapComposer7.rememberedValue();
                                            if (zChanged17 || objRememberedValue57 == neverEqualPolicy7) {
                                                z35 = z38;
                                                mutableState36 = mutableState38;
                                                objRememberedValue57 = new PlayerKt$$ExternalSyntheticLambda37(z35, playerConnection9, castConnectionHandler5, mutableState37, state19, mutableState36);
                                                gapComposer7.updateRememberedValue(objRememberedValue57);
                                            } else {
                                                z35 = z38;
                                                mutableState36 = mutableState38;
                                            }
                                            Modifier modifierFocusRequester = FocusTraversalKt.focusRequester(ImageKt.m46clickableoSLSa3U$default(modifierThen, false, null, (Function0) objRememberedValue57, 15), focusRequester4);
                                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment2, false);
                                            int iHashCode7 = Long.hashCode(gapComposer7.compositeKeyHashCode);
                                            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope7 = gapComposer7.currentCompositionLocalScope();
                                            Modifier modifierMaterializeModifier7 = ZIndexModifierKt.materializeModifier(gapComposer7, modifierFocusRequester);
                                            gapComposer7.startReusableNode();
                                            if (gapComposer7.inserting) {
                                                gapComposer7.createNode(textKt$$ExternalSyntheticLambda4);
                                            } else {
                                                gapComposer7.useNode();
                                            }
                                            Stack.m390setimpl(gapComposer7, measurePolicyMaybeCachedBoxMeasurePolicy2, updater$$ExternalSyntheticLambda5);
                                            Stack.m390setimpl(gapComposer7, persistentCompositionLocalHashMapCurrentCompositionLocalScope7, updater$$ExternalSyntheticLambda6);
                                            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode7, gapComposer7, updater$$ExternalSyntheticLambda7, gapComposer7);
                                            Stack.m390setimpl(gapComposer7, modifierMaterializeModifier7, updater$$ExternalSyntheticLambda8);
                                            final boolean z41 = z33;
                                            final State state20 = state15;
                                            if (z35) {
                                                i11 = ((Boolean) state20.getValue()).booleanValue() ? R.drawable.volume_off : R.drawable.volume_up;
                                            } else if (((Number) mutableState36.getValue()).intValue() == 4) {
                                                i11 = R.drawable.replay;
                                            } else {
                                                i11 = z41 ? R.drawable.pause : R.drawable.play;
                                            }
                                            Integer numValueOf5 = Integer.valueOf(i11);
                                            Object objRememberedValue58 = gapComposer7.rememberedValue();
                                            if (objRememberedValue58 == neverEqualPolicy7) {
                                                objRememberedValue58 = new SongMenuKt$$ExternalSyntheticLambda16((byte) 28);
                                                gapComposer7.updateRememberedValue(objRememberedValue58);
                                            }
                                            CrossfadeKt.AnimatedContent(numValueOf5, null, (Function1) objRememberedValue58, null, "playPauseGlyph", null, Expect_jvmKt.rememberComposableLambda(533265045, new Function4() { // from class: com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda39
                                                @Override // kotlin.jvm.functions.Function4
                                                public final Object invoke(Object obj45, Object obj46, Object obj47, Object obj48) throws XmlPullParserException, IOException {
                                                    int i12;
                                                    int i13;
                                                    String strM;
                                                    long j22;
                                                    int i14;
                                                    int i15;
                                                    int iIntValue4 = ((Integer) obj46).intValue();
                                                    Composer composer5 = (Composer) obj47;
                                                    int iIntValue5 = ((Integer) obj48).intValue();
                                                    ((AnimatedContentScopeImpl) obj45).getClass();
                                                    if ((iIntValue5 & 48) == 0) {
                                                        iIntValue5 |= ((GapComposer) composer5).changed(iIntValue4) ? 32 : 16;
                                                    }
                                                    GapComposer gapComposer8 = (GapComposer) composer5;
                                                    if (gapComposer8.shouldExecute(iIntValue5 & 1, (iIntValue5 & 145) != 144)) {
                                                        Painter painterPainterResource = IntMath.painterResource(iIntValue4, (iIntValue5 >> 3) & 14, gapComposer8);
                                                        if (z35) {
                                                            gapComposer8.startReplaceGroup(-584858314);
                                                            if (((Boolean) state20.getValue()).booleanValue()) {
                                                                i14 = 1366608436;
                                                                i15 = R.string.unmute;
                                                            } else {
                                                                i14 = 1366609618;
                                                                i15 = R.string.mute;
                                                            }
                                                            strM = Format$$ExternalSyntheticOutline0.m(gapComposer8, i14, i15, gapComposer8, false);
                                                            gapComposer8.end(false);
                                                        } else {
                                                            gapComposer8.startReplaceGroup(-584702043);
                                                            if (z41) {
                                                                i12 = 1366613818;
                                                                i13 = R.string.player_pause;
                                                            } else {
                                                                i12 = 1366615186;
                                                                i13 = R.string.play;
                                                            }
                                                            strM = Format$$ExternalSyntheticOutline0.m(gapComposer8, i12, i13, gapComposer8, false);
                                                            gapComposer8.end(false);
                                                        }
                                                        String str11 = strM;
                                                        boolean z42 = z36;
                                                        if (z42) {
                                                            gapComposer8.startReplaceGroup(1366618781);
                                                            gapComposer8.end(false);
                                                            j22 = j21;
                                                        } else {
                                                            gapComposer8.startReplaceGroup(1366620062);
                                                            j22 = ((MaterialTheme$Values) gapComposer8.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.onPrimary;
                                                            gapComposer8.end(false);
                                                        }
                                                        IconKt.m290Iconww6aTOc(painterPainterResource, str11, SizeKt.m151size3ABfNKs(Modifier.Companion.$$INSTANCE, z42 ? 56.0f : 38.0f), j22, gapComposer8, 8, 0);
                                                    } else {
                                                        gapComposer8.skipToGroupEnd();
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            }, gapComposer7), gapComposer7, 1597824, 42);
                                            gapComposer7.end(true);
                                            boolean zChangedInstance7 = gapComposer7.changedInstance(playerConnection9);
                                            Object objRememberedValue59 = gapComposer7.rememberedValue();
                                            if (zChangedInstance7 || objRememberedValue59 == neverEqualPolicy7) {
                                                objRememberedValue59 = new RoomDatabase$closeBarrier$1(0, playerConnection9, PlayerConnection.class, "seekToNext", "seekToNext()V", 0, (byte) 21);
                                                gapComposer7.updateRememberedValue(objRememberedValue59);
                                            }
                                            KFunction kFunction2 = (KFunction) objRememberedValue59;
                                            final MutableState mutableState39 = mutableState35;
                                            final byte b3 = 1;
                                            CardKt.IconButton((Function0) kFunction2, z36 ? DialogKt.pressScale(SizeKt.m151size3ABfNKs(companion3, 64.0f), 0.86f) : DialogKt.pressScale(companion3, 0.92f), ((Boolean) mutableState39.getValue()).booleanValue() && !z35, null, null, Expect_jvmKt.rememberComposableLambda(-607309169, new Function2() { // from class: com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda36
                                                @Override // kotlin.jvm.functions.Function2
                                                public final Object invoke(Object obj45, Object obj46) throws XmlPullParserException, IOException {
                                                    byte b4 = b3;
                                                    Unit unit4 = Unit.INSTANCE;
                                                    Modifier.Companion companion4 = Modifier.Companion.$$INSTANCE;
                                                    State state110 = mutableState39;
                                                    boolean z42 = z36;
                                                    long jColor5 = j21;
                                                    boolean z43 = z35;
                                                    switch (b4) {
                                                        case 0:
                                                            Composer composer5 = (Composer) obj45;
                                                            int iIntValue4 = ((Integer) obj46).intValue();
                                                            GapComposer gapComposer8 = (GapComposer) composer5;
                                                            if (!gapComposer8.shouldExecute(1 & iIntValue4, (iIntValue4 & 3) != 2)) {
                                                                gapComposer8.skipToGroupEnd();
                                                            } else {
                                                                Painter painterPainterResource = IntMath.painterResource(R.drawable.skip_previous, 0, gapComposer8);
                                                                if (!((Boolean) state110.getValue()).booleanValue() || z43) {
                                                                    jColor5 = ColorKt.Color(Color.m485getRedimpl(jColor5), Color.m484getGreenimpl(jColor5), Color.m482getBlueimpl(jColor5), 0.38f, Color.m483getColorSpaceimpl(jColor5));
                                                                }
                                                                IconKt.m290Iconww6aTOc(painterPainterResource, (String) null, SizeKt.m151size3ABfNKs(companion4, z42 ? 42.0f : 34.0f), jColor5, gapComposer8, 56, 0);
                                                            }
                                                            break;
                                                        default:
                                                            MutableState mutableState310 = (MutableState) state110;
                                                            Composer composer6 = (Composer) obj45;
                                                            int iIntValue5 = ((Integer) obj46).intValue();
                                                            GapComposer gapComposer9 = (GapComposer) composer6;
                                                            if (!gapComposer9.shouldExecute(1 & iIntValue5, (iIntValue5 & 3) != 2)) {
                                                                gapComposer9.skipToGroupEnd();
                                                            } else {
                                                                Painter painterPainterResource2 = IntMath.painterResource(R.drawable.skip_next, 0, gapComposer9);
                                                                if (!((Boolean) mutableState310.getValue()).booleanValue() || z43) {
                                                                    jColor5 = ColorKt.Color(Color.m485getRedimpl(jColor5), Color.m484getGreenimpl(jColor5), Color.m482getBlueimpl(jColor5), 0.38f, Color.m483getColorSpaceimpl(jColor5));
                                                                }
                                                                IconKt.m290Iconww6aTOc(painterPainterResource2, (String) null, SizeKt.m151size3ABfNKs(companion4, z42 ? 42.0f : 34.0f), jColor5, gapComposer9, 56, 0);
                                                            }
                                                            break;
                                                    }
                                                    return unit4;
                                                }
                                            }, gapComposer7), gapComposer7, 1572864, 56);
                                            Modifier modifierPressScale3 = DialogKt.pressScale(companion3, 0.92f);
                                            boolean zChangedInstance8 = gapComposer7.changedInstance(playerConnection9);
                                            Object objRememberedValue60 = gapComposer7.rememberedValue();
                                            if (zChangedInstance8 || objRememberedValue60 == neverEqualPolicy7) {
                                                objRememberedValue60 = new PlayerKt$$ExternalSyntheticLambda41(playerConnection9, (byte) 0);
                                                gapComposer7.updateRememberedValue(objRememberedValue60);
                                            }
                                            CardKt.IconButton((Function0) objRememberedValue60, modifierPressScale3, z39, null, null, Expect_jvmKt.rememberComposableLambda(408910958, new MainActivity$$ExternalSyntheticLambda1(state17, animateAsStateM17animateColorAsStateeuL9pac3, (byte) 20), gapComposer7), gapComposer7, 1572864, 56);
                                            gapComposer7.end(true);
                                        } else {
                                            gapComposer7.skipToGroupEnd();
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }, gapComposer4), gapComposer4, (i8 & 14) | 1600512, 18);
                                return unit3;
                            }
                        }, gapComposer2);
                        int i7 = ((Configuration) gapComposer2.consume(AndroidCompositionLocals_androidKt.LocalConfiguration)).orientation;
                        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetModifier;
                        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetCompositeKeyHash;
                        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetMeasurePolicy;
                        Modifier.Companion companion2 = Modifier.Companion.$$INSTANCE;
                        BottomSheetState bottomSheetState6 = bottomSheetStateM1475rememberBottomSheetStatejTDHpeQ;
                        MutableState mutableState27 = mutableState11;
                        final MutableState mutableState28 = mutableStateCollectAsState4;
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        NeverEqualPolicy neverEqualPolicy4 = Composer.Companion.Empty;
                        TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
                        if (i7 == 2) {
                            gapComposer2.startReplaceGroup(-507927459);
                            Density density = (Density) gapComposer2.consume(CompositionLocalsKt.LocalDensity);
                            WeakHashMap weakHashMap2 = WindowInsetsHolder.viewMap;
                            float fMo78toDpu2uoSUM = density.mo78toDpu2uoSUM(Math.max(OffsetKt.current(gapComposer2).systemBars.getInsets$foundation_layout().top, OffsetKt.current(gapComposer2).systemBars.getInsets$foundation_layout().bottom));
                            Modifier modifierThen = OffsetKt.m139paddingqDBjuR0$default(OffsetKt.windowInsetsPadding(companion2, new AddedInsets(new LimitInsets(OffsetKt.current(gapComposer2).systemBars, 15), new FixedDpInsets(CropImageView.DEFAULT_ASPECT_RATIO, fMo78toDpu2uoSUM, fMo78toDpu2uoSUM))), CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 24.0f, 7).then(SizeKt.FillWholeMaxSize);
                            RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(OffsetKt.Start, vertical, gapComposer2, 0);
                            int iHashCode = Long.hashCode(gapComposer2.compositeKeyHashCode);
                            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
                            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer2, modifierThen);
                            ComposeUiNode.Companion.getClass();
                            gapComposer2.startReusableNode();
                            if (gapComposer2.inserting) {
                                gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
                            } else {
                                gapComposer2.useNode();
                            }
                            Stack.m390setimpl(gapComposer2, rowMeasurePolicy, updater$$ExternalSyntheticLambda3);
                            Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda2);
                            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode, gapComposer2, updater$$ExternalSyntheticLambda1, gapComposer2);
                            Stack.m390setimpl(gapComposer2, modifierMaterializeModifier, updater$$ExternalSyntheticLambda0);
                            if (1.0f <= 0.0d) {
                                InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
                            }
                            Modifier modifierNestedScroll = NestedScrollModifierKt.nestedScroll(new LayoutWeightElement(1.0f > Float.MAX_VALUE ? Float.MAX_VALUE : 1.0f, true), new BottomSheetState$preUpPostDownNestedScrollConnection$1(bottomSheetState5), null);
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, false);
                            int iHashCode2 = Long.hashCode(gapComposer2.compositeKeyHashCode);
                            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer2.currentCompositionLocalScope();
                            Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer2, modifierNestedScroll);
                            gapComposer2.startReusableNode();
                            if (gapComposer2.inserting) {
                                gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
                            } else {
                                gapComposer2.useNode();
                            }
                            Stack.m390setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy, updater$$ExternalSyntheticLambda3);
                            Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda2);
                            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer2, updater$$ExternalSyntheticLambda1, gapComposer2);
                            Stack.m390setimpl(gapComposer2, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda0);
                            MutableState mutableStateRememberUpdatedState = Stack.rememberUpdatedState((Long) mutableState27.getValue(), gapComposer2);
                            Object objRememberedValue42 = gapComposer2.rememberedValue();
                            if (objRememberedValue42 == neverEqualPolicy4) {
                                objRememberedValue42 = new PlayerKt$$ExternalSyntheticLambda7(mutableStateRememberUpdatedState, (byte) 0);
                                gapComposer2.updateRememberedValue(objRememberedValue42);
                            }
                            final Function0 function2 = (Function0) objRememberedValue42;
                            boolean zChanged11 = gapComposer2.changed(bottomSheetState5);
                            Object objRememberedValue43 = gapComposer2.rememberedValue();
                            if (zChanged11 || objRememberedValue43 == neverEqualPolicy4) {
                                objRememberedValue43 = new PlayerKt$$ExternalSyntheticLambda0(bottomSheetState5, (byte) 9);
                                gapComposer2.updateRememberedValue(objRememberedValue43);
                            }
                            final Function0 function3 = (Function0) objRememberedValue43;
                            Boolean bool9 = (Boolean) mutableState20.getValue();
                            bool9.getClass();
                            Object objRememberedValue44 = gapComposer2.rememberedValue();
                            if (objRememberedValue44 == neverEqualPolicy4) {
                                objRememberedValue44 = new QueueKt$$ExternalSyntheticLambda4((byte) 1);
                                gapComposer2.updateRememberedValue(objRememberedValue44);
                            }
                            CrossfadeKt.AnimatedContent(bool9, null, (Function1) objRememberedValue44, null, "Lyrics", null, Expect_jvmKt.rememberComposableLambda(-1449351608, new Function4() { // from class: com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function4
                                public final Object invoke(Object obj38, Object obj39, Object obj40, Object obj41) {
                                    boolean zBooleanValue7 = ((Boolean) obj39).booleanValue();
                                    Composer composer3 = (Composer) obj40;
                                    int iIntValue2 = ((Integer) obj41).intValue();
                                    ((AnimatedContentScopeImpl) obj38).getClass();
                                    if ((iIntValue2 & 48) == 0) {
                                        iIntValue2 |= ((GapComposer) composer3).changed(zBooleanValue7) ? 32 : 16;
                                    }
                                    GapComposer gapComposer3 = (GapComposer) composer3;
                                    if (!gapComposer3.shouldExecute(iIntValue2 & 1, (iIntValue2 & 145) != 144)) {
                                        gapComposer3.skipToGroupEnd();
                                    } else if (zBooleanValue7) {
                                        gapComposer3.startReplaceGroup(-327457767);
                                        MediaMetadata mediaMetadata5 = (MediaMetadata) mutableState28.getValue();
                                        Object objRememberedValue45 = gapComposer3.rememberedValue();
                                        if (objRememberedValue45 == Composer.Companion.Empty) {
                                            objRememberedValue45 = new MainActivity$$ExternalSyntheticLambda22(state4, (byte) 15);
                                            gapComposer3.updateRememberedValue(objRememberedValue45);
                                        }
                                        QueueKt.InlineLyricsView((iIntValue2 & 112) | 384, gapComposer3, mediaMetadata5, (Function0) objRememberedValue45, zBooleanValue7);
                                        gapComposer3.end(false);
                                    } else {
                                        gapComposer3.startReplaceGroup(-327128299);
                                        QueueKt.Thumbnail(function2, CrossfadeKt.animateContentSize$default(Modifier.Companion.$$INSTANCE, null, 3), function3, true, z21, gapComposer3, 3078, 0);
                                        gapComposer3.end(false);
                                    }
                                    return Unit.INSTANCE;
                                }
                            }, gapComposer2), gapComposer2, 1597824, 42);
                            gapComposer = gapComposer2;
                            gapComposer.end(true);
                            float f2 = ((Boolean) mutableState20.getValue()).booleanValue() ? 0.65f : 1.0f;
                            if (f2 <= 0.0d) {
                                InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
                            }
                            if (f2 > Float.MAX_VALUE) {
                                f2 = Float.MAX_VALUE;
                            }
                            Modifier modifierWindowInsetsPadding = OffsetKt.windowInsetsPadding(CrossfadeKt.animateContentSize$default(new LayoutWeightElement(f2, false), null, 3), new LimitInsets(OffsetKt.current(gapComposer).systemBars, 16));
                            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement$Top$1, horizontal, gapComposer, 48);
                            int iHashCode3 = Long.hashCode(gapComposer.compositeKeyHashCode);
                            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer.currentCompositionLocalScope();
                            Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer, modifierWindowInsetsPadding);
                            gapComposer.startReusableNode();
                            if (gapComposer.inserting) {
                                gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
                            } else {
                                gapComposer.useNode();
                            }
                            Stack.m390setimpl(gapComposer, columnMeasurePolicy, updater$$ExternalSyntheticLambda3);
                            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda2);
                            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode3, gapComposer, updater$$ExternalSyntheticLambda1, gapComposer);
                            Stack.m390setimpl(gapComposer, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda0);
                            OffsetKt.Spacer(gapComposer, columnScopeInstance.weight(companion2, 1.0f, true));
                            MediaMetadata mediaMetadata5 = (MediaMetadata) mutableState28.getValue();
                            if (mediaMetadata5 == null) {
                                gapComposer.startReplaceGroup(573270077);
                                z19 = false;
                                gapComposer.end(false);
                            } else {
                                z19 = false;
                                gapComposer.startReplaceGroup(573270078);
                                composableLambdaImplRememberComposableLambda4.invoke((Object) columnScopeInstance, (Object) mediaMetadata5, (Object) gapComposer, (Object) 390);
                                gapComposer.end(false);
                            }
                            OffsetKt.Spacer(gapComposer, columnScopeInstance.weight(companion2, 1.0f, true));
                            gapComposer.end(true);
                            gapComposer.end(true);
                            gapComposer.end(z19);
                            bottomSheetState4 = bottomSheetState5;
                            i6 = 1;
                        } else {
                            gapComposer2.startReplaceGroup(-504474865);
                            if (((Boolean) mutableState22.getValue()).booleanValue()) {
                                bottomSheetState3 = bottomSheetState6;
                                f = CropImageView.DEFAULT_ASPECT_RATIO;
                            } else {
                                bottomSheetState3 = bottomSheetState6;
                                f = bottomSheetState3.collapsedBound;
                            }
                            bottomSheetState6 = bottomSheetState3;
                            AnimateAsState animateAsStateM18animateDpAsStateAjpBEmI = AnimateAsStateKt.m18animateDpAsStateAjpBEmI(f, null, "bottomPadding", gapComposer2, 384, 10);
                            WeakHashMap weakHashMap3 = WindowInsetsHolder.viewMap;
                            Modifier modifierAnimateContentSize$default = CrossfadeKt.animateContentSize$default(OffsetKt.m139paddingqDBjuR0$default(OffsetKt.windowInsetsPadding(companion2, new LimitInsets(OffsetKt.current(gapComposer2).systemBars, 15)), CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ((Dp) animateAsStateM18animateDpAsStateAjpBEmI.getValue()).value, 7), null, 3);
                            ColumnMeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement$Top$1, horizontal, gapComposer2, 48);
                            int iHashCode4 = Long.hashCode(gapComposer2.compositeKeyHashCode);
                            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope4 = gapComposer2.currentCompositionLocalScope();
                            Modifier modifierMaterializeModifier4 = ZIndexModifierKt.materializeModifier(gapComposer2, modifierAnimateContentSize$default);
                            ComposeUiNode.Companion.getClass();
                            gapComposer2.startReusableNode();
                            if (gapComposer2.inserting) {
                                gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
                            } else {
                                gapComposer2.useNode();
                            }
                            Stack.m390setimpl(gapComposer2, columnMeasurePolicy2, updater$$ExternalSyntheticLambda3);
                            Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope4, updater$$ExternalSyntheticLambda2);
                            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode4, gapComposer2, updater$$ExternalSyntheticLambda1, gapComposer2);
                            Stack.m390setimpl(gapComposer2, modifierMaterializeModifier4, updater$$ExternalSyntheticLambda0);
                            Modifier modifierWeight = columnScopeInstance.weight(companion2, 1.0f, true);
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, false);
                            int iHashCode5 = Long.hashCode(gapComposer2.compositeKeyHashCode);
                            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope5 = gapComposer2.currentCompositionLocalScope();
                            Modifier modifierMaterializeModifier5 = ZIndexModifierKt.materializeModifier(gapComposer2, modifierWeight);
                            gapComposer2.startReusableNode();
                            if (gapComposer2.inserting) {
                                gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
                            } else {
                                gapComposer2.useNode();
                            }
                            Stack.m390setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy2, updater$$ExternalSyntheticLambda3);
                            Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope5, updater$$ExternalSyntheticLambda2);
                            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode5, gapComposer2, updater$$ExternalSyntheticLambda1, gapComposer2);
                            Stack.m390setimpl(gapComposer2, modifierMaterializeModifier5, updater$$ExternalSyntheticLambda0);
                            MutableState mutableStateRememberUpdatedState2 = Stack.rememberUpdatedState((Long) mutableState27.getValue(), gapComposer2);
                            Object objRememberedValue45 = gapComposer2.rememberedValue();
                            if (objRememberedValue45 == neverEqualPolicy4) {
                                objRememberedValue45 = new SongMenuKt$$ExternalSyntheticLambda2(mutableStateRememberUpdatedState2, (byte) 28);
                                gapComposer2.updateRememberedValue(objRememberedValue45);
                            }
                            final Function0 function4 = (Function0) objRememberedValue45;
                            boolean zChanged12 = gapComposer2.changed(bottomSheetState5);
                            Object objRememberedValue46 = gapComposer2.rememberedValue();
                            if (zChanged12 || objRememberedValue46 == neverEqualPolicy4) {
                                objRememberedValue46 = new PlayerKt$$ExternalSyntheticLambda0(bottomSheetState5, (byte) 6);
                                gapComposer2.updateRememberedValue(objRememberedValue46);
                            }
                            final Function0 function5 = (Function0) objRememberedValue46;
                            Boolean bool10 = (Boolean) mutableState20.getValue();
                            bool10.getClass();
                            Object objRememberedValue47 = gapComposer2.rememberedValue();
                            if (objRememberedValue47 == neverEqualPolicy4) {
                                objRememberedValue47 = new SongMenuKt$$ExternalSyntheticLambda16((byte) 26);
                                gapComposer2.updateRememberedValue(objRememberedValue47);
                            }
                            bottomSheetState4 = bottomSheetState5;
                            CrossfadeKt.AnimatedContent(bool10, null, (Function1) objRememberedValue47, null, "Lyrics", null, Expect_jvmKt.rememberComposableLambda(77044195, new Function4() { // from class: com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda14
                                @Override // kotlin.jvm.functions.Function4
                                public final Object invoke(Object obj38, Object obj39, Object obj40, Object obj41) {
                                    boolean zBooleanValue7 = ((Boolean) obj39).booleanValue();
                                    Composer composer3 = (Composer) obj40;
                                    int iIntValue2 = ((Integer) obj41).intValue();
                                    ((AnimatedContentScopeImpl) obj38).getClass();
                                    if ((iIntValue2 & 48) == 0) {
                                        iIntValue2 |= ((GapComposer) composer3).changed(zBooleanValue7) ? 32 : 16;
                                    }
                                    GapComposer gapComposer3 = (GapComposer) composer3;
                                    if (!gapComposer3.shouldExecute(iIntValue2 & 1, (iIntValue2 & 145) != 144)) {
                                        gapComposer3.skipToGroupEnd();
                                    } else if (zBooleanValue7) {
                                        gapComposer3.startReplaceGroup(1711146654);
                                        MediaMetadata mediaMetadata6 = (MediaMetadata) mutableState28.getValue();
                                        Object objRememberedValue48 = gapComposer3.rememberedValue();
                                        if (objRememberedValue48 == Composer.Companion.Empty) {
                                            objRememberedValue48 = new MainActivity$$ExternalSyntheticLambda22(state4, (byte) 13);
                                            gapComposer3.updateRememberedValue(objRememberedValue48);
                                        }
                                        QueueKt.InlineLyricsView((iIntValue2 & 112) | 384, gapComposer3, mediaMetadata6, (Function0) objRememberedValue48, zBooleanValue7);
                                        gapComposer3.end(false);
                                    } else {
                                        gapComposer3.startReplaceGroup(1711475471);
                                        QueueKt.Thumbnail(function4, NestedScrollModifierKt.nestedScroll(Modifier.Companion.$$INSTANCE, new BottomSheetState$preUpPostDownNestedScrollConnection$1(bottomSheetState5), null), function5, false, z21, gapComposer3, 6, 8);
                                        gapComposer3.end(false);
                                    }
                                    return Unit.INSTANCE;
                                }
                            }, gapComposer2), gapComposer2, 1597824, 42);
                            gapComposer = gapComposer2;
                            gapComposer.end(true);
                            MediaMetadata mediaMetadata6 = (MediaMetadata) mutableState28.getValue();
                            if (mediaMetadata6 == null) {
                                gapComposer.startReplaceGroup(-982634816);
                                z18 = false;
                                gapComposer.end(false);
                            } else {
                                z18 = false;
                                gapComposer.startReplaceGroup(-982634815);
                                composableLambdaImplRememberComposableLambda4.invoke((Object) columnScopeInstance, (Object) mediaMetadata6, (Object) gapComposer, (Object) 390);
                                gapComposer.end(false);
                            }
                            OffsetKt.Spacer(gapComposer, SizeKt.m145height3ABfNKs(companion2, 30.0f));
                            i6 = 1;
                            gapComposer.end(true);
                            gapComposer.end(z18);
                        }
                        boolean z24 = !((Boolean) mutableState22.getValue()).booleanValue();
                        Object objRememberedValue48 = gapComposer.rememberedValue();
                        if (objRememberedValue48 == neverEqualPolicy4) {
                            objRememberedValue48 = new AlbumMenuKt$$ExternalSyntheticLambda13((byte) 13);
                            gapComposer.updateRememberedValue(objRememberedValue48);
                        }
                        EnterTransitionImpl enterTransitionImplPlus = EnterExitTransitionKt.slideInVertically$default(i6, (Function1) objRememberedValue48).plus(EnterExitTransitionKt.fadeIn$default(null, CropImageView.DEFAULT_ASPECT_RATIO, 3));
                        ExitTransitionImpl exitTransitionImplShrinkVertically$default = EnterExitTransitionKt.shrinkVertically$default(null, 13);
                        Object objRememberedValue49 = gapComposer.rememberedValue();
                        if (objRememberedValue49 == neverEqualPolicy4) {
                            objRememberedValue49 = new AlbumMenuKt$$ExternalSyntheticLambda13((byte) 13);
                            gapComposer.updateRememberedValue(objRememberedValue49);
                        }
                        ExitTransitionImpl exitTransitionImplPlus = exitTransitionImplShrinkVertically$default.plus(EnterExitTransitionKt.slideOutVertically$default(1, (Function1) objRememberedValue49)).plus(EnterExitTransitionKt.fadeOut$default(null, CropImageView.DEFAULT_ASPECT_RATIO, 3));
                        final boolean z25 = zBooleanValue4;
                        final long j12 = j3;
                        final boolean z26 = z;
                        final State state10 = animateAsStateM17animateColorAsStateeuL9pac;
                        final BottomSheetState bottomSheetState7 = bottomSheetState6;
                        final BottomSheetState bottomSheetState8 = bottomSheetState4;
                        CrossfadeKt.AnimatedVisibility(z24, null, enterTransitionImplPlus, exitTransitionImplPlus, null, Expect_jvmKt.rememberComposableLambda(-1334855557, new Function3() { // from class: com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj38, Object obj39, Object obj40) {
                                long j13;
                                Composer composer3 = (Composer) obj39;
                                int iIntValue2 = ((Integer) obj40).intValue();
                                ((AnimatedVisibilityScope) obj38).getClass();
                                GapComposer gapComposer3 = (GapComposer) composer3;
                                if (gapComposer3.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                                    if (z25) {
                                        gapComposer3.startReplaceGroup(420478444);
                                        gapComposer3.end(false);
                                        j13 = -72057594037927936L;
                                    } else {
                                        gapComposer3.startReplaceGroup(420543606);
                                        j13 = ((MaterialTheme$Values) gapComposer3.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.surface;
                                        gapComposer3.end(false);
                                    }
                                    long j14 = j13;
                                    long j15 = ((Color) state10.getValue()).value;
                                    MutableState mutableState29 = mutableState20;
                                    boolean zBooleanValue7 = ((Boolean) mutableState29.getValue()).booleanValue();
                                    boolean zChanged13 = gapComposer3.changed(mutableState29);
                                    Object objRememberedValue50 = gapComposer3.rememberedValue();
                                    if (zChanged13 || objRememberedValue50 == Composer.Companion.Empty) {
                                        objRememberedValue50 = new PlayerKt$$ExternalSyntheticLambda7(mutableState29, (byte) 1);
                                        gapComposer3.updateRememberedValue(objRememberedValue50);
                                    }
                                    QueueKt.m1507QueueTBEEUPw(bottomSheetState7, bottomSheetState8, null, j14, j12, j15, j10, j11, z26, zBooleanValue7, (Function0) objRememberedValue50, gapComposer3, 0);
                                } else {
                                    gapComposer3.skipToGroupEnd();
                                }
                                return Unit.INSTANCE;
                            }
                        }, gapComposer), gapComposer, 200064, 18);
                    } else {
                        gapComposer2.skipToGroupEnd();
                    }
                    return Unit.INSTANCE;
                }
            }, r13), r13, i4 | 1597872, 32);
            r4 = r13;
            modifier2 = companion;
        } else {
            ?? r7 = r13;
            r7.skipToGroupEnd();
            modifier2 = modifier;
            r4 = r7;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup2 = r4.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup2 != null) {
            recomposeScopeImplEndRestartGroup2.block = new PlayerKt$$ExternalSyntheticLambda84(bottomSheetState, navHostController, modifier2, z, i);
        }
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0098  */
    /* JADX WARN: Code duplicated, block: B:39:0x009a  */
    /* JADX INFO: renamed from: FavoriteButton-EtIuwbw, reason: not valid java name */
    public static final void m1499FavoriteButtonEtIuwbw(final String str, final long j, final long j2, final long j3, Composer composer, final int i) {
        SongEntity songEntity;
        final boolean z;
        SongEntity songEntity2;
        SongEntity songEntity3;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(1883198036);
        byte b = 2;
        int i2 = i | (gapComposer.changed(str) ? 4 : 2) | (gapComposer.changed(j) ? 32 : 16) | (gapComposer.changed(j3) ? 2048 : 1024);
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 1043) != 1042)) {
            MusicDatabase musicDatabase = (MusicDatabase) gapComposer.consume(MainActivityKt.LocalDatabase);
            PlayerConnection playerConnection = (PlayerConnection) gapComposer.consume(MainActivityKt.LocalPlayerConnection);
            if (playerConnection == null) {
                RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    final byte b2 = 0;
                    recomposeScopeImplEndRestartGroup.block = new Function2(str, j, j2, j3, i, b2) { // from class: com.metrolist.music.ui.player.MiniPlayerKt$$ExternalSyntheticLambda13
                        public final /* synthetic */ byte $r8$classId;
                        public final /* synthetic */ String f$0;
                        public final /* synthetic */ long f$1;
                        public final /* synthetic */ long f$2;
                        public final /* synthetic */ long f$3;

                        {
                            this.$r8$classId = b2;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            byte b3 = this.$r8$classId;
                            Unit unit = Unit.INSTANCE;
                            switch (b3) {
                                case 0:
                                    ((Integer) obj2).getClass();
                                    int iUpdateChangedFlags = Stack.updateChangedFlags(1);
                                    QueueKt.m1499FavoriteButtonEtIuwbw(this.f$0, this.f$1, this.f$2, this.f$3, (Composer) obj, iUpdateChangedFlags);
                                    break;
                                default:
                                    ((Integer) obj2).getClass();
                                    int iUpdateChangedFlags2 = Stack.updateChangedFlags(1);
                                    QueueKt.m1499FavoriteButtonEtIuwbw(this.f$0, this.f$1, this.f$2, this.f$3, (Composer) obj, iUpdateChangedFlags2);
                                    break;
                            }
                            return unit;
                        }
                    };
                    return;
                }
                return;
            }
            LocalDateTime localDateTime = null;
            MutableState mutableStateCollectAsStateWithLifecycle = FileSystemsKt.collectAsStateWithLifecycle(musicDatabase.$$delegate_0.song(str), null, gapComposer, 48);
            Song song = (Song) mutableStateCollectAsStateWithLifecycle.getValue();
            if (song == null || (songEntity2 = song.song) == null || !songEntity2.isEpisode) {
                Song song2 = (Song) mutableStateCollectAsStateWithLifecycle.getValue();
                if (song2 == null || (songEntity = song2.song) == null || !songEntity.liked) {
                    z = false;
                } else {
                    z = true;
                }
            } else {
                Song song3 = (Song) mutableStateCollectAsStateWithLifecycle.getValue();
                if (song3 != null && (songEntity3 = song3.song) != null) {
                    localDateTime = songEntity3.inLibrary;
                }
                if (localDateTime != null) {
                    z = true;
                } else {
                    z = false;
                }
            }
            boolean zChangedInstance = gapComposer.changedInstance(playerConnection);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = new PlayerKt$$ExternalSyntheticLambda41(playerConnection, b);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            CardKt.IconButton((Function0) objRememberedValue, SizeKt.m151size3ABfNKs(Modifier.Companion.$$INSTANCE, 44.0f), false, null, null, Expect_jvmKt.rememberComposableLambda(-1672297102, new Function2() { // from class: com.metrolist.music.ui.player.MiniPlayerKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Composer composer2 = (Composer) obj;
                    int iIntValue = ((Integer) obj2).intValue();
                    GapComposer gapComposer2 = (GapComposer) composer2;
                    if (gapComposer2.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                        boolean z2 = z;
                        IconKt.m290Iconww6aTOc(IntMath.painterResource(z2 ? R.drawable.favorite : R.drawable.favorite_border, 0, gapComposer2), (String) null, SizeKt.m151size3ABfNKs(Modifier.Companion.$$INSTANCE, 22.0f), z2 ? j : j3, gapComposer2, 440, 0);
                    } else {
                        gapComposer2.skipToGroupEnd();
                    }
                    return Unit.INSTANCE;
                }
            }, gapComposer), gapComposer, 1572912, 60);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup2 = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup2 != null) {
            final byte b3 = 1;
            recomposeScopeImplEndRestartGroup2.block = new Function2(str, j, j2, j3, i, b3) { // from class: com.metrolist.music.ui.player.MiniPlayerKt$$ExternalSyntheticLambda13
                public final /* synthetic */ byte $r8$classId;
                public final /* synthetic */ String f$0;
                public final /* synthetic */ long f$1;
                public final /* synthetic */ long f$2;
                public final /* synthetic */ long f$3;

                {
                    this.$r8$classId = b3;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    byte b4 = this.$r8$classId;
                    Unit unit = Unit.INSTANCE;
                    switch (b4) {
                        case 0:
                            ((Integer) obj2).getClass();
                            int iUpdateChangedFlags = Stack.updateChangedFlags(1);
                            QueueKt.m1499FavoriteButtonEtIuwbw(this.f$0, this.f$1, this.f$2, this.f$3, (Composer) obj, iUpdateChangedFlags);
                            break;
                        default:
                            ((Integer) obj2).getClass();
                            int iUpdateChangedFlags2 = Stack.updateChangedFlags(1);
                            QueueKt.m1499FavoriteButtonEtIuwbw(this.f$0, this.f$1, this.f$2, this.f$3, (Composer) obj, iUpdateChangedFlags2);
                            break;
                    }
                    return unit;
                }
            };
        }
    }

    /* JADX INFO: renamed from: HiddenThumbnailPlaceholder-3J-VO9M, reason: not valid java name */
    public static final void m1500HiddenThumbnailPlaceholder3JVO9M(final int i, final long j, Composer composer, final Modifier modifier) throws XmlPullParserException, IOException {
        int i2;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(1354267247);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        int i3 = i2 | 48;
        if (gapComposer.shouldExecute(i3 & 1, (i3 & 19) != 18)) {
            Modifier modifierM39backgroundbw27NRU = ImageKt.m39backgroundbw27NRU(SizeKt.FillWholeMaxSize, ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.surfaceVariant, ColorKt.RectangleShape);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierM39backgroundbw27NRU);
            ComposeUiNode.Companion.getClass();
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(LayoutNode.Constructor);
            } else {
                gapComposer.useNode();
            }
            Stack.m390setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m389reconcileimpl(gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            Painter painterPainterResource = IntMath.painterResource(R.drawable.small_icon, 0, gapComposer);
            String strStringResource = MathKt.stringResource(R.string.hide_player_thumbnail, gapComposer);
            long jColor = ColorKt.Color(Color.m485getRedimpl(j), Color.m484getGreenimpl(j), Color.m482getBlueimpl(j), 0.7f, Color.m483getColorSpaceimpl(j));
            modifier = Modifier.Companion.$$INSTANCE;
            IconKt.m290Iconww6aTOc(painterPainterResource, strStringResource, SizeKt.m151size3ABfNKs(modifier, 120.0f), jColor, gapComposer, 392, 0);
            gapComposer.end(true);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.metrolist.music.ui.player.ThumbnailKt$$ExternalSyntheticLambda18
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) throws XmlPullParserException, IOException {
                    ((Integer) obj2).getClass();
                    QueueKt.m1500HiddenThumbnailPlaceholder3JVO9M(Stack.updateChangedFlags(i | 1), j, (Composer) obj, modifier);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final void InlineLyricsView(int i, Composer composer, MediaMetadata mediaMetadata, Function0 function0, boolean z) {
        int i2;
        boolean z2;
        GapComposer gapComposer;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        PlayerKt$$ExternalSyntheticLambda43 playerKt$$ExternalSyntheticLambda43;
        String str;
        Object realImageLoader$execute$result$1;
        MusicDatabase musicDatabase;
        NeverEqualPolicy neverEqualPolicy;
        String str2;
        boolean z3;
        Function0 function1 = function0;
        function1.getClass();
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(793294620);
        if ((i & 6) == 0) {
            i2 = (gapComposer2.changed(mediaMetadata) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer2.changed(z) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer2.changedInstance(function1) ? 256 : 128;
        }
        int i3 = i2;
        if (gapComposer2.shouldExecute(i3 & 1, (i3 & 147) != 146)) {
            PlayerConnection playerConnection = (PlayerConnection) gapComposer2.consume(MainActivityKt.LocalPlayerConnection);
            if (playerConnection == null) {
                recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup == null) {
                    return;
                } else {
                    playerKt$$ExternalSyntheticLambda43 = new PlayerKt$$ExternalSyntheticLambda43(mediaMetadata, z, function1, i, (byte) 0);
                }
            } else {
                MutableState mutableStateCollectAsStateWithLifecycle = FileSystemsKt.collectAsStateWithLifecycle(playerConnection.currentLyrics, null, gapComposer2, 48);
                MutableState mutableStateCollectAsStateWithLifecycle2 = FileSystemsKt.collectAsStateWithLifecycle(playerConnection.queueWindows, EmptyList.INSTANCE, gapComposer2, 48);
                MutableState mutableStateCollectAsStateWithLifecycle3 = FileSystemsKt.collectAsStateWithLifecycle(playerConnection.currentWindowIndex, -1, gapComposer2, 48);
                boolean zChanged = gapComposer2.changed((LyricsEntity) mutableStateCollectAsStateWithLifecycle.getValue());
                Object objRememberedValue = gapComposer2.rememberedValue();
                NeverEqualPolicy neverEqualPolicy2 = Composer.Companion.Empty;
                if (zChanged || objRememberedValue == neverEqualPolicy2) {
                    LyricsEntity lyricsEntity = (LyricsEntity) mutableStateCollectAsStateWithLifecycle.getValue();
                    objRememberedValue = (lyricsEntity == null || (str = lyricsEntity.lyrics) == null) ? null : StringsKt.trim(str).toString();
                    gapComposer2.updateRememberedValue(objRememberedValue);
                }
                String str3 = (String) objRememberedValue;
                Context context = (Context) gapComposer2.consume(AndroidCompositionLocals_androidKt.LocalContext);
                MusicDatabase musicDatabase2 = (MusicDatabase) gapComposer2.consume(MainActivityKt.LocalDatabase);
                Object objRememberedValue2 = gapComposer2.rememberedValue();
                if (objRememberedValue2 == neverEqualPolicy2) {
                    objRememberedValue2 = Stack.createCompositionCoroutineScope(gapComposer2);
                    gapComposer2.updateRememberedValue(objRememberedValue2);
                }
                CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue2;
                Object objRememberedValue3 = gapComposer2.rememberedValue();
                if (objRememberedValue3 == neverEqualPolicy2) {
                    objRememberedValue3 = Stack.mutableStateOf$default(Boolean.valueOf(ProcessLifecycleOwner.newInstance.registry.state.compareTo(Lifecycle.State.STARTED) >= 0));
                    gapComposer2.updateRememberedValue(objRememberedValue3);
                }
                MutableState mutableState = (MutableState) objRememberedValue3;
                Object objRememberedValue4 = gapComposer2.rememberedValue();
                if (objRememberedValue4 == neverEqualPolicy2) {
                    objRememberedValue4 = new TooltipKt$$ExternalSyntheticLambda5(mutableState, (byte) 22);
                    gapComposer2.updateRememberedValue(objRememberedValue4);
                }
                Stack.DisposableEffect(Unit.INSTANCE, (Function1) objRememberedValue4, gapComposer2);
                boolean zChanged2 = gapComposer2.changed((List) mutableStateCollectAsStateWithLifecycle2.getValue()) | gapComposer2.changed(((Number) mutableStateCollectAsStateWithLifecycle3.getValue()).intValue());
                Object objRememberedValue5 = gapComposer2.rememberedValue();
                if (zChanged2 || objRememberedValue5 == neverEqualPolicy2) {
                    if (((Number) mutableStateCollectAsStateWithLifecycle3.getValue()).intValue() < 0 || ((Number) mutableStateCollectAsStateWithLifecycle3.getValue()).intValue() + 1 >= ((List) mutableStateCollectAsStateWithLifecycle2.getValue()).size()) {
                        objRememberedValue5 = null;
                    } else {
                        MediaItem mediaItem = ((Timeline.Window) ((List) mutableStateCollectAsStateWithLifecycle2.getValue()).get(((Number) mutableStateCollectAsStateWithLifecycle3.getValue()).intValue() + 1)).mediaItem;
                        mediaItem.getClass();
                        objRememberedValue5 = UuidKt.getMetadata(mediaItem);
                    }
                    gapComposer2.updateRememberedValue(objRememberedValue5);
                }
                MediaMetadata mediaMetadata2 = (MediaMetadata) objRememberedValue5;
                String str4 = mediaMetadata != null ? mediaMetadata.id : null;
                LyricsEntity lyricsEntity2 = (LyricsEntity) mutableStateCollectAsStateWithLifecycle.getValue();
                int i4 = i3 & 14;
                boolean zChanged3 = (i4 == 4) | gapComposer2.changed(mutableStateCollectAsStateWithLifecycle) | gapComposer2.changedInstance(coroutineScope) | gapComposer2.changedInstance(context) | gapComposer2.changedInstance(musicDatabase2);
                Object objRememberedValue6 = gapComposer2.rememberedValue();
                if (zChanged3 || objRememberedValue6 == neverEqualPolicy2) {
                    musicDatabase = musicDatabase2;
                    neverEqualPolicy = neverEqualPolicy2;
                    str2 = str3;
                    realImageLoader$execute$result$1 = new RealImageLoader$execute$result$1((Object) mediaMetadata, (Object) coroutineScope, (Object) mutableStateCollectAsStateWithLifecycle, (Object) context, (Object) musicDatabase, (Continuation) null, (byte) 14);
                    gapComposer2.updateRememberedValue(realImageLoader$execute$result$1);
                } else {
                    realImageLoader$execute$result$1 = objRememberedValue6;
                    str2 = str3;
                    neverEqualPolicy = neverEqualPolicy2;
                    musicDatabase = musicDatabase2;
                }
                Stack.LaunchedEffect(str4, lyricsEntity2, (Function2) realImageLoader$execute$result$1, gapComposer2);
                String str5 = mediaMetadata2 != null ? mediaMetadata2.id : null;
                Boolean boolValueOf = Boolean.valueOf(z);
                Boolean bool = (Boolean) mutableState.getValue();
                bool.getClass();
                Object[] objArr = {str5, boolValueOf, bool, mediaMetadata != null ? mediaMetadata.id : null, (LyricsEntity) mutableStateCollectAsStateWithLifecycle.getValue()};
                boolean zChanged4 = ((i3 & 112) == 32) | gapComposer2.changed(mediaMetadata2) | gapComposer2.changed(mutableStateCollectAsStateWithLifecycle) | (i4 == 4) | gapComposer2.changedInstance(musicDatabase) | gapComposer2.changedInstance(context);
                Object objRememberedValue7 = gapComposer2.rememberedValue();
                if (zChanged4 || objRememberedValue7 == neverEqualPolicy) {
                    PlayerKt$InlineLyricsView$3$1 playerKt$InlineLyricsView$3$1 = new PlayerKt$InlineLyricsView$3$1(z, mediaMetadata2, mediaMetadata, mutableState, mutableStateCollectAsStateWithLifecycle, musicDatabase, context, null);
                    gapComposer2.updateRememberedValue(playerKt$InlineLyricsView$3$1);
                    objRememberedValue7 = playerKt$InlineLyricsView$3$1;
                }
                Stack.LaunchedEffect(objArr, (Function2) objRememberedValue7, gapComposer2);
                Modifier modifierClip = ClipKt.clip(SizeKt.FillWholeMaxSize, RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(12.0f));
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
                int iHashCode = Long.hashCode(gapComposer2.compositeKeyHashCode);
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer2, modifierClip);
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
                if (str2 == null) {
                    gapComposer2.startReplaceGroup(1909006001);
                    gapComposer = gapComposer2;
                    DialogKt.m1465ContainedLoadingIndicatoreopBjH0(null, 0L, 0L, null, gapComposer, 0);
                    gapComposer.end(false);
                    z3 = true;
                    function1 = function0;
                    z2 = z;
                } else {
                    gapComposer = gapComposer2;
                    if (str2.equals("LYRICS_NOT_FOUND")) {
                        gapComposer.startReplaceGroup(1909146152);
                        String strStringResource = MathKt.stringResource(R.string.lyrics_not_found, gapComposer);
                        StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                        TextStyle textStyle = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).typography.bodyMedium;
                        long j = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.onSurface;
                        TextKt.m352TextNvy7gAk(strStringResource, null, ColorKt.Color(Color.m485getRedimpl(j), Color.m484getGreenimpl(j), Color.m482getBlueimpl(j), 0.7f, Color.m483getColorSpaceimpl(j)), 0L, null, null, null, 0L, new TextAlign(3), 0L, 0, false, 0, 0, textStyle, gapComposer, 0, 0, 130042);
                        gapComposer = gapComposer;
                        gapComposer.end(false);
                        function1 = function0;
                        z2 = z;
                    } else {
                        gapComposer.startReplaceGroup(1909483153);
                        function1 = function0;
                        z2 = z;
                        TextKt.ProvideTextStyle(TextStyle.m750copyp1EtxEg$default(((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).typography.bodyMedium, 0L, IntMath.getSp(14), null, null, null, null, 0L, 0L, null, null, 16744445), Expect_jvmKt.rememberComposableLambda(-943101852, new CardKt$$ExternalSyntheticLambda1(Expect_jvmKt.rememberComposableLambda(1639820200, new PlayerKt$$ExternalSyntheticLambda45(z2, function1), gapComposer), (byte) 7), gapComposer), gapComposer, 48);
                        gapComposer.end(false);
                    }
                    z3 = true;
                }
                gapComposer.end(z3);
            }
            recomposeScopeImplEndRestartGroup.block = playerKt$$ExternalSyntheticLambda43;
        }
        z2 = z;
        gapComposer = gapComposer2;
        gapComposer.skipToGroupEnd();
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            playerKt$$ExternalSyntheticLambda43 = new PlayerKt$$ExternalSyntheticLambda43(mediaMetadata, z2, function1, i, (byte) 5);
            recomposeScopeImplEndRestartGroup.block = playerKt$$ExternalSyntheticLambda43;
        }
    }

    public static final void LegacyMiniMediaInfo(MediaMetadata mediaMetadata, boolean z, Modifier modifier, Composer composer, int i) {
        MutableState mutableStateCollectAsState;
        String str = mediaMetadata.thumbnailUrl;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-1864151766);
        int i2 = i | (gapComposer.changed(mediaMetadata) ? 4 : 2) | (gapComposer.changed(z) ? 32 : 16);
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
            PlayerConnection playerConnection = (PlayerConnection) gapComposer.consume(MainActivityKt.LocalPlayerConnection);
            StateFlowImpl stateFlowImpl = playerConnection != null ? playerConnection.error : null;
            if (stateFlowImpl == null) {
                gapComposer.startReplaceGroup(-1017947545);
                gapComposer.end(false);
                mutableStateCollectAsState = null;
            } else {
                gapComposer.startReplaceGroup(-448479014);
                mutableStateCollectAsState = Stack.collectAsState(stateFlowImpl, gapComposer, 3);
                gapComposer.end(false);
            }
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (mutableStateCollectAsState == null) {
                gapComposer.startReplaceGroup(-1017927177);
                Object objRememberedValue = gapComposer.rememberedValue();
                if (objRememberedValue == neverEqualPolicy) {
                    objRememberedValue = Stack.mutableStateOf$default(null);
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                mutableStateCollectAsState = (MutableState) objRememberedValue;
            } else {
                gapComposer.startReplaceGroup(-448480155);
            }
            gapComposer.end(false);
            MutableState mutableState = mutableStateCollectAsState;
            DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference = UtilsKt.rememberPreference(PreferenceKeysKt.CropAlbumArtKey, Boolean.FALSE, gapComposer, 48);
            RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(OffsetKt.Start, Alignment.Companion.CenterVertically, gapComposer, 48);
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifier);
            ComposeUiNode.Companion.getClass();
            gapComposer.startReusableNode();
            boolean z2 = gapComposer.inserting;
            TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
            if (z2) {
                gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer.useNode();
            }
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetMeasurePolicy;
            Stack.m390setimpl(gapComposer, rowMeasurePolicy, updater$$ExternalSyntheticLambda0);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda1);
            Integer numValueOf = Integer.valueOf(iHashCode);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetCompositeKeyHash;
            Stack.m390setimpl(gapComposer, numValueOf, updater$$ExternalSyntheticLambda2);
            Stack.m389reconcileimpl(gapComposer);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetModifier;
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier, updater$$ExternalSyntheticLambda3);
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier modifierM151size3ABfNKs = SizeKt.m151size3ABfNKs(OffsetKt.m135padding3ABfNKs(companion, 6.0f), 48.0f);
            SpringSpec springSpec = DimensionsKt.NavigationBarAnimationSpec;
            Modifier modifierClip = ClipKt.clip(modifierM151size3ABfNKs, RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(10.0f));
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
            int iHashCode2 = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer, modifierClip);
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer.useNode();
            }
            Stack.m390setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy, updater$$ExternalSyntheticLambda0);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer, updater$$ExternalSyntheticLambda2, gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
            FillElement fillElement = SizeKt.FillWholeMaxSize;
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
            BoxKt.Box(ImageKt.m39backgroundbw27NRU(fillElement, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.surfaceVariant, ColorKt.RectangleShape), gapComposer, 0);
            List list = mediaMetadata.artists;
            boolean zChanged = gapComposer.changed(str);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = str != null ? YouTubeUtilsKt.resize(str, 144, 144) : null;
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            AsyncImageKt.m849AsyncImage10Xjiaw((String) objRememberedValue2, ClipKt.clip(fillElement, RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(10.0f)), ((Boolean) dataStoreKt$rememberPreference$1$1RememberPreference.$state.getValue()).booleanValue() ? ContentScale.Companion.Crop : ContentScale.Companion.Fit, gapComposer, 48, 1976);
            CrossfadeKt.AnimatedVisibility(((PlaybackException) mutableState.getValue()) != null, null, EnterExitTransitionKt.fadeIn$default(null, CropImageView.DEFAULT_ASPECT_RATIO, 3), EnterExitTransitionKt.fadeOut$default(null, CropImageView.DEFAULT_ASPECT_RATIO, 3), null, Expect_jvmKt.rememberComposableLambda(-1753178328, new MiniPlayerKt$$ExternalSyntheticLambda17((byte) 0, z), gapComposer), gapComposer, 200064, 18);
            gapComposer.end(true);
            Modifier modifierM137paddingVpY3zN4$default = OffsetKt.m137paddingVpY3zN4$default(new LayoutWeightElement(1.0f, true), 6.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2);
            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start, gapComposer, 0);
            int iHashCode3 = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer, modifierM137paddingVpY3zN4$default);
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer.useNode();
            }
            Stack.m390setimpl(gapComposer, columnMeasurePolicy, updater$$ExternalSyntheticLambda0);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda1);
            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode3, gapComposer, updater$$ExternalSyntheticLambda2, gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda3);
            TextKt.m352TextNvy7gAk(mediaMetadata.title, ImageKt.m41basicMarquee1Mj1MLw$default(companion, 63), ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.onSurface, 0L, null, null, null, 0L, null, 0L, 2, false, 1, 0, TextStyle.m750copyp1EtxEg$default(((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).typography.titleLarge, 0L, IntMath.getSp(16), null, null, null, null, 0L, 0L, null, null, 16777213), gapComposer, 48, 24960, 110584);
            gapComposer = gapComposer;
            if (list != null && list.isEmpty()) {
                gapComposer.startReplaceGroup(-1838130798);
                gapComposer.end(false);
                break;
            }
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    gapComposer.startReplaceGroup(-1838130798);
                    gapComposer.end(false);
                    break;
                } else if (!StringsKt.isBlank(((MediaMetadata.Artist) it.next()).name)) {
                    gapComposer.startReplaceGroup(-1838472387);
                    String strM = IntIntPair$$ExternalSyntheticOutline0.m(ServerSentEventKt.SPACE, MathKt.stringResource(R.string.and, gapComposer), ServerSentEventKt.SPACE);
                    Object objRememberedValue3 = gapComposer.rememberedValue();
                    if (objRememberedValue3 == neverEqualPolicy) {
                        objRememberedValue3 = new SongMenuKt$$ExternalSyntheticLambda16((byte) 20);
                        gapComposer.updateRememberedValue(objRememberedValue3);
                    }
                    TextKt.m352TextNvy7gAk(UtilsKt.joinToArtistString(list, strM, (Function1) objRememberedValue3), null, ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.onSurfaceVariant, IntMath.getSp(12), null, null, null, 0L, null, 0L, 2, false, 1, 0, null, gapComposer, 24576, 24960, 241642);
                    gapComposer = gapComposer;
                    gapComposer.end(false);
                    break;
                }
            }
            gapComposer.end(true);
            gapComposer.end(true);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new StringValuesKt$$ExternalSyntheticLambda1(mediaMetadata, z, modifier, i, (byte) 7);
        }
    }

    public static final void LegacyMiniPlayer(final ProgressState progressState, final Modifier modifier, final Function0 function0, Composer composer, final int i) {
        int i2;
        final Function0 function1;
        char c;
        MutableState mutableStateCollectAsStateWithLifecycle;
        boolean z;
        Object objValueOf;
        boolean z2;
        boolean zIsSystemInDarkTheme;
        long j;
        MutableState mutableState;
        PlayerConnection playerConnection;
        int i3;
        Object miniPlayerKt$$ExternalSyntheticLambda5;
        TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3;
        long j2;
        float f;
        boolean z3;
        Function0 function2;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-1806352362);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changed(progressState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changed(modifier) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            function1 = function0;
            i2 |= gapComposer.changedInstance(function1) ? 256 : 128;
        } else {
            function1 = function0;
        }
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
            PlayerConnection playerConnection2 = (PlayerConnection) gapComposer.consume(MainActivityKt.LocalPlayerConnection);
            if (playerConnection2 == null) {
                RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    final byte b = 0;
                    recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.metrolist.music.ui.player.MiniPlayerKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            byte b2 = b;
                            Unit unit = Unit.INSTANCE;
                            int i4 = i;
                            Function0 function3 = function1;
                            Modifier modifier2 = modifier;
                            ProgressState progressState2 = progressState;
                            Composer composer2 = (Composer) obj;
                            ((Integer) obj2).getClass();
                            switch (b2) {
                                case 0:
                                    QueueKt.LegacyMiniPlayer(progressState2, modifier2, function3, composer2, Stack.updateChangedFlags(i4 | 1));
                                    break;
                                default:
                                    QueueKt.LegacyMiniPlayer(progressState2, modifier2, function3, composer2, Stack.updateChangedFlags(i4 | 1));
                                    break;
                            }
                            return unit;
                        }
                    };
                    return;
                }
                return;
            }
            DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference = UtilsKt.rememberPreference(PreferenceKeysKt.PureBlackMiniPlayerKey, Boolean.FALSE, gapComposer, 48);
            MutableState mutableStateCollectAsState = Stack.collectAsState(playerConnection2.playbackState, gapComposer, 3);
            MutableState mutableStateCollectAsState2 = Stack.collectAsState(playerConnection2.mediaMetadata, gapComposer, 3);
            MutableState mutableStateCollectAsStateWithLifecycle2 = FileSystemsKt.collectAsStateWithLifecycle(playerConnection2.canSkipNext, gapComposer);
            MutableState mutableStateCollectAsStateWithLifecycle3 = FileSystemsKt.collectAsStateWithLifecycle(playerConnection2.canSkipPrevious, gapComposer);
            boolean zChanged = gapComposer.changed(playerConnection2);
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (zChanged || objRememberedValue == neverEqualPolicy) {
                try {
                    objRememberedValue = playerConnection2.service.castConnectionHandler;
                } catch (Exception unused) {
                    objRememberedValue = null;
                }
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            CastConnectionHandler castConnectionHandler = (CastConnectionHandler) objRememberedValue;
            StateFlowImpl stateFlowImpl = castConnectionHandler != null ? castConnectionHandler.isCasting : null;
            if (stateFlowImpl == null) {
                gapComposer.startReplaceGroup(-1397105778);
                gapComposer.end(false);
                c = ' ';
                mutableStateCollectAsStateWithLifecycle = null;
            } else {
                c = ' ';
                gapComposer.startReplaceGroup(-737804589);
                mutableStateCollectAsStateWithLifecycle = FileSystemsKt.collectAsStateWithLifecycle(stateFlowImpl, gapComposer);
                gapComposer.end(false);
            }
            if (mutableStateCollectAsStateWithLifecycle == null) {
                gapComposer.startReplaceGroup(-1397072886);
                Object objRememberedValue2 = gapComposer.rememberedValue();
                if (objRememberedValue2 == neverEqualPolicy) {
                    objRememberedValue2 = Stack.mutableStateOf$default(Boolean.FALSE);
                    gapComposer.updateRememberedValue(objRememberedValue2);
                }
                mutableStateCollectAsStateWithLifecycle = (MutableState) objRememberedValue2;
            } else {
                gapComposer.startReplaceGroup(-737805295);
            }
            gapComposer.end(false);
            DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference2 = UtilsKt.rememberPreference(PreferenceKeysKt.SwipeSensitivityKey, Float.valueOf(0.73f), gapComposer, 48);
            DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference3 = UtilsKt.rememberPreference(PreferenceKeysKt.SwipeThumbnailKey, Boolean.TRUE, gapComposer, 48);
            ListenTogetherManager listenTogetherManager = (ListenTogetherManager) gapComposer.consume(MainActivityKt.LocalListenTogetherManager);
            if (listenTogetherManager != null) {
                z = listenTogetherManager.client.isInRoom() && !listenTogetherManager.isHost();
            } else {
                z = false;
            }
            boolean z4 = ((Boolean) dataStoreKt$rememberPreference$1$1RememberPreference3.$state.getValue()).booleanValue() && !z;
            LayoutDirection layoutDirection = (LayoutDirection) gapComposer.consume(CompositionLocalsKt.LocalLayoutDirection);
            Object objRememberedValue3 = gapComposer.rememberedValue();
            if (objRememberedValue3 == neverEqualPolicy) {
                objRememberedValue3 = Stack.createCompositionCoroutineScope(gapComposer);
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue3;
            WindowInfo windowInfo = (WindowInfo) gapComposer.consume(CompositionLocalsKt.LocalWindowInfo);
            Configuration configuration = (Configuration) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalConfiguration);
            Density density = (Density) gapComposer.consume(CompositionLocalsKt.LocalDensity);
            LazyWindowInfo lazyWindowInfo = (LazyWindowInfo) windowInfo;
            boolean zChanged2 = gapComposer.changed((int) (lazyWindowInfo.m715getContainerSizeYbymL2g() >> c)) | gapComposer.changed(configuration.orientation);
            Object objRememberedValue4 = gapComposer.rememberedValue();
            if (zChanged2 || objRememberedValue4 == neverEqualPolicy) {
                objRememberedValue4 = Boolean.valueOf(((float) ((int) (lazyWindowInfo.m715getContainerSizeYbymL2g() >> c))) / density.getDensity() >= 600.0f && configuration.orientation == 2);
                gapComposer.updateRememberedValue(objRememberedValue4);
            }
            boolean zBooleanValue = ((Boolean) objRememberedValue4).booleanValue();
            Object objRememberedValue5 = gapComposer.rememberedValue();
            if (objRememberedValue5 == neverEqualPolicy) {
                objRememberedValue5 = ArcSplineKt.Animatable$default(CropImageView.DEFAULT_ASPECT_RATIO);
                gapComposer.updateRememberedValue(objRememberedValue5);
            }
            Animatable animatable = (Animatable) objRememberedValue5;
            Object objRememberedValue6 = gapComposer.rememberedValue();
            if (objRememberedValue6 == neverEqualPolicy) {
                objRememberedValue6 = new ParcelableSnapshotMutableLongState(0L);
                gapComposer.updateRememberedValue(objRememberedValue6);
            }
            ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState = (ParcelableSnapshotMutableLongState) objRememberedValue6;
            Object objRememberedValue7 = gapComposer.rememberedValue();
            if (objRememberedValue7 == neverEqualPolicy) {
                objRememberedValue7 = Format$$ExternalSyntheticOutline0.m(CropImageView.DEFAULT_ASPECT_RATIO, gapComposer);
            }
            ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = (ParcelableSnapshotMutableFloatState) objRememberedValue7;
            Object objRememberedValue8 = gapComposer.rememberedValue();
            if (objRememberedValue8 == neverEqualPolicy) {
                objRememberedValue8 = ArcSplineKt.spring$default(1.0f, 200.0f, null, 4);
                gapComposer.updateRememberedValue(objRememberedValue8);
            }
            SpringSpec springSpec = (SpringSpec) objRememberedValue8;
            boolean zChanged3 = gapComposer.changed(((Number) dataStoreKt$rememberPreference$1$1RememberPreference2.$state.getValue()).floatValue());
            Object objRememberedValue9 = gapComposer.rememberedValue();
            if (zChanged3 || objRememberedValue9 == neverEqualPolicy) {
                objValueOf = Integer.valueOf(MathKt.roundToInt(600.0d / (Math.exp(-((((double) ((Number) dataStoreKt$rememberPreference$1$1RememberPreference2.$state.getValue()).floatValue()) * (-11.44748d)) + 9.04945d)) + 1.0d)));
                gapComposer.updateRememberedValue(objValueOf);
            } else {
                objValueOf = objRememberedValue9;
            }
            int iIntValue = ((Number) objValueOf).intValue();
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
            long j3 = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.primary;
            long j4 = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.outlineVariant;
            Object objRememberedValue10 = gapComposer.rememberedValue();
            int i4 = i2;
            if (objRememberedValue10 == neverEqualPolicy) {
                objRememberedValue10 = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
            }
            MutableInteractionSourceImpl mutableInteractionSourceImpl = (MutableInteractionSourceImpl) objRememberedValue10;
            gapComposer.startReplaceGroup(-737721259);
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier modifierThen = modifier.then(zBooleanValue ? SizeKt.m155width3ABfNKs(companion, 500.0f) : SizeKt.fillMaxWidth(companion, 1.0f));
            SpringSpec springSpec2 = DimensionsKt.NavigationBarAnimationSpec;
            Modifier modifierM145height3ABfNKs = SizeKt.m145height3ABfNKs(modifierThen, 64.0f);
            WeakHashMap weakHashMap = WindowInsetsHolder.viewMap;
            boolean z5 = z4;
            MutableState mutableState2 = mutableStateCollectAsStateWithLifecycle;
            Modifier modifierClip = ClipKt.clip(OffsetKt.windowInsetsPadding(modifierM145height3ABfNKs, new LimitInsets(OffsetKt.current(gapComposer).systemBars, 15)), RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(CropImageView.DEFAULT_ASPECT_RATIO));
            if (((Boolean) dataStoreKt$rememberPreference$1$1RememberPreference.$state.getValue()).booleanValue()) {
                gapComposer.startReplaceGroup(-737737205);
                zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer);
                z2 = false;
                gapComposer.end(false);
            } else {
                z2 = false;
                gapComposer.startReplaceGroup(-1395015638);
                gapComposer.end(false);
                zIsSystemInDarkTheme = false;
            }
            if (zIsSystemInDarkTheme) {
                gapComposer.startReplaceGroup(-1394992879);
                gapComposer.end(z2);
                j = -72057594037927936L;
            } else {
                gapComposer.startReplaceGroup(-1394927438);
                j = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.surfaceContainer;
                gapComposer.end(z2);
            }
            boolean z6 = z2;
            Modifier modifierM45clickableO2vRcR0$default = ImageKt.m45clickableO2vRcR0$default(ImageKt.m39backgroundbw27NRU(modifierClip, j, ColorKt.RectangleShape), mutableInteractionSourceImpl, (IndicationNodeFactory) gapComposer.consume(IndicationKt.LocalIndication), false, null, function0, 28);
            if (z5) {
                gapComposer.startReplaceGroup(-819271312);
                boolean zChangedInstance = gapComposer.changedInstance(animatable) | gapComposer.changed(dataStoreKt$rememberPreference$1$1RememberPreference2) | gapComposer.changed(iIntValue) | gapComposer.changed(mutableStateCollectAsStateWithLifecycle3) | gapComposer.changedInstance(playerConnection2) | gapComposer.changed(mutableStateCollectAsStateWithLifecycle2) | gapComposer.changedInstance(coroutineScope) | gapComposer.changed(layoutDirection.ordinal());
                Object objRememberedValue11 = gapComposer.rememberedValue();
                if (zChangedInstance || objRememberedValue11 == neverEqualPolicy) {
                    mutableState = mutableStateCollectAsStateWithLifecycle2;
                    playerConnection = playerConnection2;
                    i3 = iIntValue;
                    MiniPlayerKt$NewMiniPlayer$2$1$1 miniPlayerKt$NewMiniPlayer$2$1$1 = new MiniPlayerKt$NewMiniPlayer$2$1$1(parcelableSnapshotMutableLongState, parcelableSnapshotMutableFloatState, animatable, i3, playerConnection, coroutineScope, dataStoreKt$rememberPreference$1$1RememberPreference2, mutableStateCollectAsStateWithLifecycle3, mutableState, springSpec, layoutDirection, (byte) 1);
                    gapComposer.updateRememberedValue(miniPlayerKt$NewMiniPlayer$2$1$1);
                    objRememberedValue11 = miniPlayerKt$NewMiniPlayer$2$1$1;
                } else {
                    mutableState = mutableStateCollectAsStateWithLifecycle2;
                    playerConnection = playerConnection2;
                    i3 = iIntValue;
                }
                modifierM45clickableO2vRcR0$default = SuspendingPointerInputFilterKt.pointerInput(modifierM45clickableO2vRcR0$default, Unit.INSTANCE, (PointerInputEventHandler) objRememberedValue11);
                gapComposer.end(z6);
            } else {
                mutableState = mutableStateCollectAsStateWithLifecycle2;
                playerConnection = playerConnection2;
                i3 = iIntValue;
                gapComposer.startReplaceGroup(-815806783);
                gapComposer.end(z6);
            }
            gapComposer.end(z6);
            BiasAlignment biasAlignment = Alignment.Companion.TopStart;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, z6);
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierM45clickableO2vRcR0$default);
            ComposeUiNode.Companion.getClass();
            gapComposer.startReusableNode();
            boolean z7 = gapComposer.inserting;
            TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda4 = LayoutNode.Constructor;
            if (z7) {
                gapComposer.createNode(textKt$$ExternalSyntheticLambda4);
            } else {
                gapComposer.useNode();
            }
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetMeasurePolicy;
            Stack.m390setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy, updater$$ExternalSyntheticLambda0);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda1);
            Integer numValueOf = Integer.valueOf(iHashCode);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetCompositeKeyHash;
            Stack.m390setimpl(gapComposer, numValueOf, updater$$ExternalSyntheticLambda2);
            Stack.m389reconcileimpl(gapComposer);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetModifier;
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier, updater$$ExternalSyntheticLambda3);
            Modifier modifierM145height3ABfNKs2 = SizeKt.m145height3ABfNKs(SizeKt.fillMaxWidth(companion, 1.0f), 2.0f);
            BiasAlignment biasAlignment2 = Alignment.Companion.TopCenter;
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Modifier modifierAlign = boxScopeInstance.align(modifierM145height3ABfNKs2, biasAlignment2);
            boolean zChanged4 = ((i4 & 14) == 4 ? true : z6) | gapComposer.changed(j4) | gapComposer.changed(j3);
            Object objRememberedValue12 = gapComposer.rememberedValue();
            if (zChanged4 || objRememberedValue12 == neverEqualPolicy) {
                textKt$$ExternalSyntheticLambda3 = textKt$$ExternalSyntheticLambda4;
                j2 = j3;
                miniPlayerKt$$ExternalSyntheticLambda5 = new MiniPlayerKt$$ExternalSyntheticLambda5(progressState, j4, j2);
                gapComposer.updateRememberedValue(miniPlayerKt$$ExternalSyntheticLambda5);
            } else {
                textKt$$ExternalSyntheticLambda3 = textKt$$ExternalSyntheticLambda4;
                j2 = j3;
                miniPlayerKt$$ExternalSyntheticLambda5 = objRememberedValue12;
            }
            BoxKt.Box(ClipKt.drawWithContent(modifierAlign, (Function1) miniPlayerKt$$ExternalSyntheticLambda5), gapComposer, 0);
            BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
            FillElement fillElement = SizeKt.FillWholeMaxSize;
            boolean zChangedInstance2 = gapComposer.changedInstance(animatable);
            Object objRememberedValue13 = gapComposer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue13 == neverEqualPolicy) {
                objRememberedValue13 = new MiniPlayerKt$$ExternalSyntheticLambda2(animatable, (byte) 7);
                gapComposer.updateRememberedValue(objRememberedValue13);
            }
            Modifier modifierM139paddingqDBjuR0$default = OffsetKt.m139paddingqDBjuR0$default(OffsetKt.offset(fillElement, (Function1) objRememberedValue13), CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 12.0f, CropImageView.DEFAULT_ASPECT_RATIO, 11);
            RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(OffsetKt.Start, vertical, gapComposer, 48);
            int iHashCode2 = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer, modifierM139paddingqDBjuR0$default);
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer.useNode();
            }
            Stack.m390setimpl(gapComposer, rowMeasurePolicy, updater$$ExternalSyntheticLambda0);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer, updater$$ExternalSyntheticLambda2, gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
            LayoutWeightElement layoutWeightElement = new LayoutWeightElement(1.0f, true);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, false);
            int iHashCode3 = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer, layoutWeightElement);
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer.useNode();
            }
            Stack.m390setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy2, updater$$ExternalSyntheticLambda0);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda1);
            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode3, gapComposer, updater$$ExternalSyntheticLambda2, gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda3);
            MediaMetadata mediaMetadata = (MediaMetadata) mutableStateCollectAsState2.getValue();
            if (mediaMetadata == null) {
                gapComposer.startReplaceGroup(203480514);
                z3 = false;
                gapComposer.end(false);
                f = CropImageView.DEFAULT_ASPECT_RATIO;
            } else {
                gapComposer.startReplaceGroup(203480515);
                boolean zBooleanValue2 = ((Boolean) dataStoreKt$rememberPreference$1$1RememberPreference.$state.getValue()).booleanValue();
                f = CropImageView.DEFAULT_ASPECT_RATIO;
                LegacyMiniMediaInfo(mediaMetadata, zBooleanValue2, OffsetKt.m137paddingVpY3zN4$default(companion, 6.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2), gapComposer, 384);
                z3 = false;
                gapComposer.end(false);
            }
            byte b2 = 1;
            gapComposer.end(true);
            TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda5 = textKt$$ExternalSyntheticLambda3;
            PlayerConnection playerConnection3 = playerConnection;
            float f2 = f;
            boolean z8 = z3;
            LegacyPlayPauseButton(((Number) mutableStateCollectAsState.getValue()).intValue(), ((Boolean) mutableState2.getValue()).booleanValue(), castConnectionHandler, playerConnection3, listenTogetherManager, gapComposer, 36864);
            boolean z9 = (!((Boolean) mutableState.getValue()).booleanValue() || z) ? z8 ? 1 : 0 : true;
            if (z) {
                gapComposer.startReplaceGroup(990130272);
                Object objRememberedValue14 = gapComposer.rememberedValue();
                if (objRememberedValue14 == neverEqualPolicy) {
                    objRememberedValue14 = new QueueKt$$ExternalSyntheticLambda2((byte) 17);
                    gapComposer.updateRememberedValue(objRememberedValue14);
                }
                function2 = (Function0) objRememberedValue14;
            } else {
                gapComposer.startReplaceGroup(990141153);
                boolean zChangedInstance3 = gapComposer.changedInstance(playerConnection3);
                Object objRememberedValue15 = gapComposer.rememberedValue();
                if (zChangedInstance3 || objRememberedValue15 == neverEqualPolicy) {
                    objRememberedValue15 = new PlayerKt$$ExternalSyntheticLambda41(playerConnection3, b2);
                    gapComposer.updateRememberedValue(objRememberedValue15);
                }
                function2 = (Function0) objRememberedValue15;
            }
            gapComposer.end(z8);
            int i5 = i3;
            CardKt.IconButton(function2, null, z9, null, null, f287lambda$1145968738, gapComposer, 1572864, 58);
            gapComposer = gapComposer;
            gapComposer.end(true);
            if (Math.abs(((Number) animatable.getValue()).floatValue()) > 50.0f) {
                gapComposer.startReplaceGroup(-925275333);
                Modifier modifierM137paddingVpY3zN4$default = OffsetKt.m137paddingVpY3zN4$default(boxScopeInstance.align(companion, ((Number) animatable.getValue()).floatValue() > f2 ? Alignment.Companion.CenterStart : Alignment.Companion.CenterEnd), 16.0f, f2, 2);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, z8);
                int iHashCode4 = Long.hashCode(gapComposer.compositeKeyHashCode);
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope4 = gapComposer.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier4 = ZIndexModifierKt.materializeModifier(gapComposer, modifierM137paddingVpY3zN4$default);
                gapComposer.startReusableNode();
                if (gapComposer.inserting) {
                    gapComposer.createNode(textKt$$ExternalSyntheticLambda5);
                } else {
                    gapComposer.useNode();
                }
                Stack.m390setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy3, updater$$ExternalSyntheticLambda0);
                Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope4, updater$$ExternalSyntheticLambda1);
                IntIntPair$$ExternalSyntheticOutline0.m(iHashCode4, gapComposer, updater$$ExternalSyntheticLambda2, gapComposer);
                Stack.m390setimpl(gapComposer, modifierMaterializeModifier4, updater$$ExternalSyntheticLambda3);
                IconKt.m290Iconww6aTOc(IntMath.painterResource(((Number) animatable.getValue()).floatValue() > CropImageView.DEFAULT_ASPECT_RATIO ? R.drawable.skip_previous : R.drawable.skip_next, z8 ? 1 : 0, gapComposer), (String) null, SizeKt.m151size3ABfNKs(companion, 24.0f), ColorKt.Color(Color.m485getRedimpl(j2), Color.m484getGreenimpl(j2), Color.m482getBlueimpl(j2), UuidKt.coerceIn(Math.abs(((Number) animatable.getValue()).floatValue()) / i5, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f), Color.m483getColorSpaceimpl(j2)), gapComposer, 440, 0);
                gapComposer.end(true);
                gapComposer.end(z8);
            } else {
                gapComposer.startReplaceGroup(-924465210);
                gapComposer.end(z8);
            }
            gapComposer.end(true);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup2 = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup2 != null) {
            final byte b3 = 1;
            recomposeScopeImplEndRestartGroup2.block = new Function2() { // from class: com.metrolist.music.ui.player.MiniPlayerKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    byte b4 = b3;
                    Unit unit = Unit.INSTANCE;
                    int i6 = i;
                    Function0 function3 = function0;
                    Modifier modifier2 = modifier;
                    ProgressState progressState2 = progressState;
                    Composer composer2 = (Composer) obj;
                    ((Integer) obj2).getClass();
                    switch (b4) {
                        case 0:
                            QueueKt.LegacyMiniPlayer(progressState2, modifier2, function3, composer2, Stack.updateChangedFlags(i6 | 1));
                            break;
                        default:
                            QueueKt.LegacyMiniPlayer(progressState2, modifier2, function3, composer2, Stack.updateChangedFlags(i6 | 1));
                            break;
                    }
                    return unit;
                }
            };
        }
    }

    public static final void LegacyPlayPauseButton(int i, boolean z, CastConnectionHandler castConnectionHandler, PlayerConnection playerConnection, ListenTogetherManager listenTogetherManager, Composer composer, int i2) {
        boolean z2;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-128864228);
        int i3 = i2 | (gapComposer.changed(i) ? 4 : 2) | (gapComposer.changed(z) ? 32 : 16) | (gapComposer.changed(castConnectionHandler) ? 256 : 128) | (gapComposer.changedInstance(playerConnection) ? 2048 : 1024) | (gapComposer.changedInstance(listenTogetherManager) ? 16384 : 8192);
        if (gapComposer.shouldExecute(i3 & 1, (i3 & 9363) != 9362)) {
            MutableState mutableStateCollectAsState = Stack.collectAsState(playerConnection.isPlaying, gapComposer, 3);
            MutableState mutableStateCollectAsState2 = null;
            StateFlowImpl stateFlowImpl = castConnectionHandler != null ? castConnectionHandler.castIsPlaying : null;
            if (stateFlowImpl == null) {
                gapComposer.startReplaceGroup(706873141);
            } else {
                gapComposer.startReplaceGroup(715539020);
                mutableStateCollectAsState2 = Stack.collectAsState(stateFlowImpl, gapComposer, 3);
            }
            gapComposer.end(false);
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (mutableStateCollectAsState2 == null) {
                gapComposer.startReplaceGroup(706893540);
                Object objRememberedValue = gapComposer.rememberedValue();
                if (objRememberedValue == neverEqualPolicy) {
                    objRememberedValue = Stack.mutableStateOf$default(Boolean.FALSE);
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                mutableStateCollectAsState2 = (MutableState) objRememberedValue;
            } else {
                gapComposer.startReplaceGroup(715538190);
            }
            gapComposer.end(false);
            boolean zBooleanValue = z ? ((Boolean) mutableStateCollectAsState2.getValue()).booleanValue() : ((Boolean) mutableStateCollectAsState.getValue()).booleanValue();
            boolean z3 = (listenTogetherManager == null || !listenTogetherManager.client.isInRoom() || listenTogetherManager.isHost()) ? false : true;
            MutableState mutableStateCollectAsStateWithLifecycle = FileSystemsKt.collectAsStateWithLifecycle(playerConnection.isMuted, gapComposer);
            boolean zChanged = gapComposer.changed(z3) | ((i3 & 7168) == 2048 || gapComposer.changedInstance(playerConnection)) | ((i3 & 112) == 32) | gapComposer.changed(mutableStateCollectAsState2) | ((i3 & 896) == 256) | ((i3 & 14) == 4);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue2 == neverEqualPolicy) {
                z2 = z3;
                MiniPlayerKt$$ExternalSyntheticLambda20 miniPlayerKt$$ExternalSyntheticLambda20 = new MiniPlayerKt$$ExternalSyntheticLambda20(z2, playerConnection, z, castConnectionHandler, i, mutableStateCollectAsState2, (byte) 1);
                gapComposer.updateRememberedValue(miniPlayerKt$$ExternalSyntheticLambda20);
                objRememberedValue2 = miniPlayerKt$$ExternalSyntheticLambda20;
            } else {
                z2 = z3;
            }
            CardKt.IconButton((Function0) objRememberedValue2, null, false, null, null, Expect_jvmKt.rememberComposableLambda(-25783490, new MiniPlayerKt$$ExternalSyntheticLambda21(z2, i, zBooleanValue, mutableStateCollectAsStateWithLifecycle, (byte) 1), gapComposer), gapComposer, 1572864, 62);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new MiniPlayerKt$$ExternalSyntheticLambda28(i, z, castConnectionHandler, playerConnection, listenTogetherManager, i2);
        }
    }

    public static final void MiniPlayer(ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState, ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState2, Modifier modifier, Function0 function0, Composer composer, int i) {
        Modifier modifier2;
        parcelableSnapshotMutableLongState.getClass();
        parcelableSnapshotMutableLongState2.getClass();
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(1960486423);
        int i2 = i | 384 | (gapComposer.changedInstance(function0) ? 2048 : 1024);
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 1171) != 1170)) {
            DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference = UtilsKt.rememberPreference(PreferenceKeysKt.UseNewMiniPlayerDesignKey, Boolean.TRUE, gapComposer, 48);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = new ProgressState(parcelableSnapshotMutableLongState, parcelableSnapshotMutableLongState2);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            ProgressState progressState = (ProgressState) objRememberedValue;
            boolean zBooleanValue = ((Boolean) dataStoreKt$rememberPreference$1$1RememberPreference.$state.getValue()).booleanValue();
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            if (zBooleanValue) {
                gapComposer.startReplaceGroup(1886183576);
                NewMiniPlayer(progressState, function0, gapComposer, ((i2 >> 3) & 896) | 54);
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(1886338669);
                Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
                int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierFillMaxWidth);
                ComposeUiNode.Companion.getClass();
                gapComposer.startReusableNode();
                if (gapComposer.inserting) {
                    gapComposer.createNode(LayoutNode.Constructor);
                } else {
                    gapComposer.useNode();
                }
                Stack.m390setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
                Stack.m389reconcileimpl(gapComposer);
                Stack.m390setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                LegacyMiniPlayer(progressState, BoxScopeInstance.INSTANCE.align(companion, Alignment.Companion.Center), function0, gapComposer, ((i2 >> 3) & 896) | 6);
                gapComposer.end(true);
                gapComposer.end(false);
            }
            modifier2 = companion;
        } else {
            gapComposer.skipToGroupEnd();
            modifier2 = modifier;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new CrossfadeKt$$ExternalSyntheticLambda3(parcelableSnapshotMutableLongState, parcelableSnapshotMutableLongState2, modifier2, function0, i, (byte) 9);
        }
    }

    public static final void NewMiniPlayer(final ProgressState progressState, final Function0 function0, Composer composer, final int i) {
        int i2;
        final ProgressState progressState2;
        GapComposer gapComposer;
        final byte b;
        MutableState mutableStateCollectAsStateWithLifecycle;
        boolean z;
        PlayerConnection playerConnection;
        MutableState mutableState;
        Animatable animatable;
        boolean z2;
        long j;
        boolean z3;
        Object miniPlayerKt$$ExternalSyntheticLambda5;
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(386020539);
        if ((i & 6) == 0) {
            i2 = (gapComposer2.changed(progressState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        int i3 = i & 48;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        if (i3 == 0) {
            i2 |= gapComposer2.changed(companion) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer2.changedInstance(function0) ? 256 : 128;
        }
        int i4 = i2;
        final byte b2 = 0;
        if (gapComposer2.shouldExecute(i4 & 1, (i4 & 147) != 146)) {
            PlayerConnection playerConnection2 = (PlayerConnection) gapComposer2.consume(MainActivityKt.LocalPlayerConnection);
            if (playerConnection2 == null) {
                RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.metrolist.music.ui.player.MiniPlayerKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            byte b3 = b2;
                            Unit unit = Unit.INSTANCE;
                            int i5 = i;
                            Function0 function1 = function0;
                            ProgressState progressState3 = progressState;
                            Composer composer2 = (Composer) obj;
                            ((Integer) obj2).getClass();
                            switch (b3) {
                                case 0:
                                    QueueKt.NewMiniPlayer(progressState3, function1, composer2, Stack.updateChangedFlags(i5 | 1));
                                    break;
                                default:
                                    QueueKt.NewMiniPlayer(progressState3, function1, composer2, Stack.updateChangedFlags(i5 | 1));
                                    break;
                            }
                            return unit;
                        }
                    };
                    return;
                }
                return;
            }
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = AndroidCompositionLocals_androidKt.LocalContext;
            Object objRememberedValue = gapComposer2.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Stack.mutableStateOf$default(EmptyList.INSTANCE);
                gapComposer2.updateRememberedValue(objRememberedValue);
            }
            boolean zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
            Preferences$Key preferences$Key = PreferenceKeysKt.DarkModeKey;
            Context context = (Context) gapComposer2.consume(staticProvidableCompositionLocal);
            Object objRememberedValue2 = gapComposer2.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = Stack.createCompositionCoroutineScope(gapComposer2);
                gapComposer2.updateRememberedValue(objRememberedValue2);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue2;
            Object objRememberedValue3 = gapComposer2.rememberedValue();
            if (objRememberedValue3 == neverEqualPolicy) {
                objRememberedValue3 = StateFlowKt.distinctUntilChanged(new MainActivity$MetrolistApp$$inlined$rememberEnumPreference$1(UtilsKt.getDataStore(context).getData(), preferences$Key, (byte) 16));
                gapComposer2.updateRememberedValue(objRememberedValue3);
            }
            DarkMode darkMode = DarkMode.AUTO;
            MutableState mutableStateCollectAsStateWithLifecycle2 = FileSystemsKt.collectAsStateWithLifecycle((Flow) objRememberedValue3, darkMode, gapComposer2, 48);
            Object objRememberedValue4 = gapComposer2.rememberedValue();
            if (objRememberedValue4 == neverEqualPolicy) {
                objRememberedValue4 = new MiniPlayerKt$NewMiniPlayer$$inlined$rememberEnumPreference$2(mutableStateCollectAsStateWithLifecycle2, coroutineScope, context, preferences$Key);
                gapComposer2.updateRememberedValue(objRememberedValue4);
            }
            MiniPlayerKt$NewMiniPlayer$$inlined$rememberEnumPreference$2 miniPlayerKt$NewMiniPlayer$$inlined$rememberEnumPreference$2 = (MiniPlayerKt$NewMiniPlayer$$inlined$rememberEnumPreference$2) objRememberedValue4;
            boolean zChanged = gapComposer2.changed(((DarkMode) miniPlayerKt$NewMiniPlayer$$inlined$rememberEnumPreference$2.getValue()).ordinal()) | gapComposer2.changed(zIsSystemInDarkTheme);
            Object objRememberedValue5 = gapComposer2.rememberedValue();
            if (zChanged || objRememberedValue5 == neverEqualPolicy) {
                if (((DarkMode) miniPlayerKt$NewMiniPlayer$$inlined$rememberEnumPreference$2.getValue()) != darkMode) {
                    zIsSystemInDarkTheme = ((DarkMode) miniPlayerKt$NewMiniPlayer$$inlined$rememberEnumPreference$2.getValue()) == DarkMode.ON;
                }
                objRememberedValue5 = Boolean.valueOf(zIsSystemInDarkTheme);
                gapComposer2.updateRememberedValue(objRememberedValue5);
            }
            ((Boolean) objRememberedValue5).getClass();
            MutableState mutableStateCollectAsState = Stack.collectAsState(playerConnection2.playbackState, gapComposer2, 3);
            MutableState mutableStateCollectAsState2 = Stack.collectAsState(playerConnection2.mediaMetadata, gapComposer2, 3);
            MutableState mutableStateCollectAsStateWithLifecycle3 = FileSystemsKt.collectAsStateWithLifecycle(playerConnection2.canSkipNext, gapComposer2);
            MutableState mutableStateCollectAsStateWithLifecycle4 = FileSystemsKt.collectAsStateWithLifecycle(playerConnection2.canSkipPrevious, gapComposer2);
            boolean zChanged2 = gapComposer2.changed(playerConnection2);
            Object objRememberedValue6 = gapComposer2.rememberedValue();
            if (zChanged2 || objRememberedValue6 == neverEqualPolicy) {
                try {
                    objRememberedValue6 = playerConnection2.service.castConnectionHandler;
                } catch (Exception unused) {
                    objRememberedValue6 = null;
                }
                gapComposer2.updateRememberedValue(objRememberedValue6);
            }
            CastConnectionHandler castConnectionHandler = (CastConnectionHandler) objRememberedValue6;
            StateFlowImpl stateFlowImpl = castConnectionHandler != null ? castConnectionHandler.isCasting : null;
            if (stateFlowImpl == null) {
                gapComposer2.startReplaceGroup(-1983058391);
                gapComposer2.end(false);
                mutableStateCollectAsStateWithLifecycle = null;
            } else {
                gapComposer2.startReplaceGroup(1598598360);
                mutableStateCollectAsStateWithLifecycle = FileSystemsKt.collectAsStateWithLifecycle(stateFlowImpl, gapComposer2);
                gapComposer2.end(false);
            }
            if (mutableStateCollectAsStateWithLifecycle == null) {
                gapComposer2.startReplaceGroup(-1983025499);
                Object objRememberedValue7 = gapComposer2.rememberedValue();
                if (objRememberedValue7 == neverEqualPolicy) {
                    objRememberedValue7 = Stack.mutableStateOf$default(Boolean.FALSE);
                    gapComposer2.updateRememberedValue(objRememberedValue7);
                }
                mutableStateCollectAsStateWithLifecycle = (MutableState) objRememberedValue7;
            } else {
                gapComposer2.startReplaceGroup(1598597654);
            }
            gapComposer2.end(false);
            MutableState mutableState2 = mutableStateCollectAsStateWithLifecycle;
            DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference = UtilsKt.rememberPreference(PreferenceKeysKt.SwipeSensitivityKey, Float.valueOf(0.73f), gapComposer2, 48);
            DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference2 = UtilsKt.rememberPreference(PreferenceKeysKt.SwipeThumbnailKey, Boolean.TRUE, gapComposer2, 48);
            ListenTogetherManager listenTogetherManager = (ListenTogetherManager) gapComposer2.consume(MainActivityKt.LocalListenTogetherManager);
            if (listenTogetherManager != null) {
                z = listenTogetherManager.client.isInRoom() && !listenTogetherManager.isHost();
            } else {
                z = false;
            }
            boolean z4 = ((Boolean) dataStoreKt$rememberPreference$1$1RememberPreference2.$state.getValue()).booleanValue() && !z;
            LayoutDirection layoutDirection = (LayoutDirection) gapComposer2.consume(CompositionLocalsKt.LocalLayoutDirection);
            Object objRememberedValue8 = gapComposer2.rememberedValue();
            if (objRememberedValue8 == neverEqualPolicy) {
                objRememberedValue8 = Stack.createCompositionCoroutineScope(gapComposer2);
                gapComposer2.updateRememberedValue(objRememberedValue8);
            }
            CoroutineScope coroutineScope2 = (CoroutineScope) objRememberedValue8;
            WindowInfo windowInfo = (WindowInfo) gapComposer2.consume(CompositionLocalsKt.LocalWindowInfo);
            Configuration configuration = (Configuration) gapComposer2.consume(AndroidCompositionLocals_androidKt.LocalConfiguration);
            boolean z5 = z4;
            Density density = (Density) gapComposer2.consume(CompositionLocalsKt.LocalDensity);
            LazyWindowInfo lazyWindowInfo = (LazyWindowInfo) windowInfo;
            boolean zChanged3 = gapComposer2.changed((int) (lazyWindowInfo.m715getContainerSizeYbymL2g() >> 32)) | gapComposer2.changed(configuration.orientation);
            Object objRememberedValue9 = gapComposer2.rememberedValue();
            if (zChanged3 || objRememberedValue9 == neverEqualPolicy) {
                objRememberedValue9 = Boolean.valueOf(((float) ((int) (lazyWindowInfo.m715getContainerSizeYbymL2g() >> 32))) / density.getDensity() >= 600.0f && configuration.orientation == 2);
                gapComposer2.updateRememberedValue(objRememberedValue9);
            }
            boolean zBooleanValue = ((Boolean) objRememberedValue9).booleanValue();
            Object objRememberedValue10 = gapComposer2.rememberedValue();
            if (objRememberedValue10 == neverEqualPolicy) {
                objRememberedValue10 = ArcSplineKt.Animatable$default(CropImageView.DEFAULT_ASPECT_RATIO);
                gapComposer2.updateRememberedValue(objRememberedValue10);
            }
            Animatable animatable2 = (Animatable) objRememberedValue10;
            Object objRememberedValue11 = gapComposer2.rememberedValue();
            if (objRememberedValue11 == neverEqualPolicy) {
                objRememberedValue11 = new ParcelableSnapshotMutableLongState(0L);
                gapComposer2.updateRememberedValue(objRememberedValue11);
            }
            ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState = (ParcelableSnapshotMutableLongState) objRememberedValue11;
            Object objRememberedValue12 = gapComposer2.rememberedValue();
            if (objRememberedValue12 == neverEqualPolicy) {
                objRememberedValue12 = Format$$ExternalSyntheticOutline0.m(CropImageView.DEFAULT_ASPECT_RATIO, gapComposer2);
            }
            ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = (ParcelableSnapshotMutableFloatState) objRememberedValue12;
            Object objRememberedValue13 = gapComposer2.rememberedValue();
            if (objRememberedValue13 == neverEqualPolicy) {
                objRememberedValue13 = ArcSplineKt.spring$default(1.0f, 200.0f, null, 4);
                gapComposer2.updateRememberedValue(objRememberedValue13);
            }
            SpringSpec springSpec = (SpringSpec) objRememberedValue13;
            boolean zChanged4 = gapComposer2.changed(((Number) dataStoreKt$rememberPreference$1$1RememberPreference.$state.getValue()).floatValue());
            Object objRememberedValue14 = gapComposer2.rememberedValue();
            if (zChanged4 || objRememberedValue14 == neverEqualPolicy) {
                objRememberedValue14 = Integer.valueOf(MathKt.roundToInt(600.0d / (Math.exp(-((((double) ((Number) dataStoreKt$rememberPreference$1$1RememberPreference.$state.getValue()).floatValue()) * (-11.44748d)) + 9.04945d)) + 1.0d)));
                gapComposer2.updateRememberedValue(objRememberedValue14);
            }
            int iIntValue = ((Number) objRememberedValue14).intValue();
            StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = MaterialThemeKt._localMaterialTheme;
            long j2 = ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal2)).colorScheme.primary;
            long j3 = ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal2)).colorScheme.outlineVariant;
            long j4 = ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal2)).colorScheme.onSurface;
            long j5 = ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal2)).colorScheme.error;
            long j6 = ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal2)).colorScheme.surfaceContainer;
            long j7 = ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal2)).colorScheme.outlineVariant;
            gapComposer2.startReplaceGroup(1598674354);
            Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
            SpringSpec springSpec2 = DimensionsKt.NavigationBarAnimationSpec;
            Modifier modifierM145height3ABfNKs = SizeKt.m145height3ABfNKs(modifierFillMaxWidth, 64.0f);
            WeakHashMap weakHashMap = WindowInsetsHolder.viewMap;
            Modifier modifierWindowInsetsPadding = OffsetKt.windowInsetsPadding(modifierM145height3ABfNKs, new LimitInsets(OffsetKt.current(gapComposer2).systemBars, 15));
            if (z5) {
                gapComposer2.startReplaceGroup(-834016047);
                boolean zChangedInstance = gapComposer2.changedInstance(animatable2) | gapComposer2.changed(dataStoreKt$rememberPreference$1$1RememberPreference) | gapComposer2.changed(iIntValue) | gapComposer2.changed(mutableStateCollectAsStateWithLifecycle4) | gapComposer2.changedInstance(playerConnection2) | gapComposer2.changed(mutableStateCollectAsStateWithLifecycle3) | gapComposer2.changedInstance(coroutineScope2) | gapComposer2.changed(layoutDirection.ordinal());
                Object objRememberedValue15 = gapComposer2.rememberedValue();
                if (zChangedInstance || objRememberedValue15 == neverEqualPolicy) {
                    playerConnection = playerConnection2;
                    mutableState = mutableStateCollectAsStateWithLifecycle3;
                    objRememberedValue15 = new MiniPlayerKt$NewMiniPlayer$2$1$1(parcelableSnapshotMutableLongState, parcelableSnapshotMutableFloatState, animatable2, iIntValue, playerConnection, coroutineScope2, dataStoreKt$rememberPreference$1$1RememberPreference, mutableStateCollectAsStateWithLifecycle4, mutableState, springSpec, layoutDirection, (byte) 0);
                    animatable = animatable2;
                    gapComposer2.updateRememberedValue(objRememberedValue15);
                } else {
                    playerConnection = playerConnection2;
                    mutableState = mutableStateCollectAsStateWithLifecycle3;
                    animatable = animatable2;
                }
                modifierWindowInsetsPadding = SuspendingPointerInputFilterKt.pointerInput(modifierWindowInsetsPadding, Unit.INSTANCE, (PointerInputEventHandler) objRememberedValue15);
                z2 = false;
                gapComposer2.end(false);
            } else {
                playerConnection = playerConnection2;
                mutableState = mutableStateCollectAsStateWithLifecycle3;
                animatable = animatable2;
                z2 = false;
                gapComposer2.startReplaceGroup(-830405446);
                gapComposer2.end(false);
            }
            gapComposer2.end(z2);
            BiasAlignment biasAlignment = Alignment.Companion.TopStart;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, z2);
            int iHashCode = Long.hashCode(gapComposer2.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer2, modifierWindowInsetsPadding);
            ComposeUiNode.Companion.getClass();
            gapComposer2.startReusableNode();
            boolean z6 = gapComposer2.inserting;
            TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
            if (z6) {
                gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer2.useNode();
            }
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetMeasurePolicy;
            Stack.m390setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy, updater$$ExternalSyntheticLambda0);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda1);
            Integer numValueOf = Integer.valueOf(iHashCode);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetCompositeKeyHash;
            Stack.m390setimpl(gapComposer2, numValueOf, updater$$ExternalSyntheticLambda2);
            Stack.m389reconcileimpl(gapComposer2);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetModifier;
            Stack.m390setimpl(gapComposer2, modifierMaterializeModifier, updater$$ExternalSyntheticLambda3);
            Object objRememberedValue16 = gapComposer2.rememberedValue();
            if (objRememberedValue16 == neverEqualPolicy) {
                objRememberedValue16 = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer2);
            }
            MutableInteractionSourceImpl mutableInteractionSourceImpl = (MutableInteractionSourceImpl) objRememberedValue16;
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Modifier modifierM45clickableO2vRcR0$default = ImageKt.m45clickableO2vRcR0$default(GlassComponentsKt.m1478glassBlur942rkJo(DialogKt.pressScale(SizeKt.m145height3ABfNKs(zBooleanValue ? boxScopeInstance.align(SizeKt.m155width3ABfNKs(companion, 500.0f), Alignment.Companion.Center) : OffsetKt.m137paddingVpY3zN4$default(SizeKt.fillMaxWidth(companion, 1.0f), 12.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2), 64.0f), 0.985f), GlassComponentsKt.m1480glassShapeixp7dh8(26.0f, 16.0f, gapComposer2), gapComposer2, 0), mutableInteractionSourceImpl, (IndicationNodeFactory) gapComposer2.consume(IndicationKt.LocalIndication), false, null, function0, 28);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, false);
            int iHashCode2 = Long.hashCode(gapComposer2.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer2, modifierM45clickableO2vRcR0$default);
            gapComposer2.startReusableNode();
            if (gapComposer2.inserting) {
                gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer2.useNode();
            }
            Stack.m390setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy2, updater$$ExternalSyntheticLambda0);
            Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer2, updater$$ExternalSyntheticLambda2, gapComposer2);
            Stack.m390setimpl(gapComposer2, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
            BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
            FillElement fillElement = SizeKt.FillWholeMaxSize;
            boolean zChangedInstance2 = gapComposer2.changedInstance(animatable);
            Object objRememberedValue17 = gapComposer2.rememberedValue();
            if (zChangedInstance2 || objRememberedValue17 == neverEqualPolicy) {
                objRememberedValue17 = new MiniPlayerKt$$ExternalSyntheticLambda2(animatable, (byte) 0);
                gapComposer2.updateRememberedValue(objRememberedValue17);
            }
            Modifier modifierM139paddingqDBjuR0$default = OffsetKt.m139paddingqDBjuR0$default(OffsetKt.offset(fillElement, (Function1) objRememberedValue17), 16.0f, CropImageView.DEFAULT_ASPECT_RATIO, 8.0f, CropImageView.DEFAULT_ASPECT_RATIO, 10);
            RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(OffsetKt.Start, vertical, gapComposer2, 48);
            int iHashCode3 = Long.hashCode(gapComposer2.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer2, modifierM139paddingqDBjuR0$default);
            gapComposer2.startReusableNode();
            if (gapComposer2.inserting) {
                gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer2.useNode();
            }
            Stack.m390setimpl(gapComposer2, rowMeasurePolicy, updater$$ExternalSyntheticLambda0);
            Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda1);
            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode3, gapComposer2, updater$$ExternalSyntheticLambda2, gapComposer2);
            Stack.m390setimpl(gapComposer2, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda3);
            m1501NewMiniPlayerCoverRPmYEkk((MediaMetadata) mutableStateCollectAsState2.getValue(), j7, gapComposer2, 0);
            OffsetKt.Spacer(gapComposer2, SizeKt.m155width3ABfNKs(companion, 12.0f));
            m1503NewMiniPlayerSongInfoeopBjH0((MediaMetadata) mutableStateCollectAsState2.getValue(), j4, j5, new LayoutWeightElement(1.0f, true), gapComposer2, 0);
            GapComposer gapComposer3 = gapComposer2;
            OffsetKt.Spacer(gapComposer3, SizeKt.m155width3ABfNKs(companion, 8.0f));
            if (((Boolean) mutableState2.getValue()).booleanValue()) {
                gapComposer3.startReplaceGroup(-752279284);
                z3 = false;
                j = j2;
                IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.cast_connected, 0, gapComposer3), "Casting", SizeKt.m151size3ABfNKs(companion, 20.0f), j, gapComposer3, 440, 0);
                OffsetKt.Spacer(gapComposer3, SizeKt.m155width3ABfNKs(companion, 4.0f));
                gapComposer3.end(false);
            } else {
                j = j2;
                z3 = false;
                gapComposer3.startReplaceGroup(-751930441);
                gapComposer3.end(false);
            }
            MediaMetadata mediaMetadata = (MediaMetadata) mutableStateCollectAsState2.getValue();
            if (mediaMetadata == null) {
                gapComposer3.startReplaceGroup(-751832420);
                gapComposer3.end(z3);
            } else {
                gapComposer3.startReplaceGroup(-751832419);
                long j8 = j;
                m1499FavoriteButtonEtIuwbw(mediaMetadata.id, j8, j3, j4, gapComposer3, 0);
                gapComposer3 = gapComposer3;
                j = j8;
                gapComposer3.end(z3);
            }
            int i5 = i4 & 14;
            GapComposer gapComposer4 = gapComposer3;
            long j9 = j;
            PlayerConnection playerConnection3 = playerConnection;
            m1502NewMiniPlayerPlayButtonSxpAMN0(progressState, ((Number) mutableStateCollectAsState.getValue()).intValue(), ((Boolean) mutableState2.getValue()).booleanValue(), castConnectionHandler, playerConnection3, (MediaMetadata) mutableStateCollectAsState2.getValue(), j9, j3, listenTogetherManager, gapComposer4, 134250496 | i5);
            gapComposer = gapComposer4;
            boolean z7 = ((Boolean) mutableState.getValue()).booleanValue() && !z;
            Modifier modifierM151size3ABfNKs = SizeKt.m151size3ABfNKs(companion, 44.0f);
            boolean zChangedInstance3 = gapComposer.changedInstance(playerConnection3);
            Object objRememberedValue18 = gapComposer.rememberedValue();
            if (zChangedInstance3 || objRememberedValue18 == neverEqualPolicy) {
                objRememberedValue18 = new PlayerKt$$ExternalSyntheticLambda41(playerConnection3, (byte) 3);
                gapComposer.updateRememberedValue(objRememberedValue18);
            }
            CardKt.IconButton((Function0) objRememberedValue18, modifierM151size3ABfNKs, z7, null, null, Expect_jvmKt.rememberComposableLambda(1288999277, new ListItemKt$$ExternalSyntheticLambda18(j4, (byte) 2), gapComposer), gapComposer, 1572912, 56);
            gapComposer.end(true);
            Modifier modifierAlign = boxScopeInstance.align(SizeKt.m145height3ABfNKs(SizeKt.fillMaxWidth(companion, 1.0f), 2.0f), Alignment.Companion.TopCenter);
            boolean zChanged5 = gapComposer.changed(j7) | (i5 == 4) | gapComposer.changed(j9);
            Object objRememberedValue19 = gapComposer.rememberedValue();
            if (zChanged5 || objRememberedValue19 == neverEqualPolicy) {
                progressState2 = progressState;
                miniPlayerKt$$ExternalSyntheticLambda5 = new MiniPlayerKt$$ExternalSyntheticLambda5(j7, progressState2, j9);
                gapComposer.updateRememberedValue(miniPlayerKt$$ExternalSyntheticLambda5);
            } else {
                miniPlayerKt$$ExternalSyntheticLambda5 = objRememberedValue19;
                progressState2 = progressState;
            }
            BoxKt.Box(ClipKt.drawWithContent(modifierAlign, (Function1) miniPlayerKt$$ExternalSyntheticLambda5), gapComposer, 0);
            b = 1;
            gapComposer.end(true);
            gapComposer.end(true);
        } else {
            progressState2 = progressState;
            gapComposer = gapComposer2;
            b = 1;
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup2 = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup2 != null) {
            recomposeScopeImplEndRestartGroup2.block = new Function2() { // from class: com.metrolist.music.ui.player.MiniPlayerKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    byte b3 = b;
                    Unit unit = Unit.INSTANCE;
                    int i6 = i;
                    Function0 function1 = function0;
                    ProgressState progressState3 = progressState2;
                    Composer composer2 = (Composer) obj;
                    ((Integer) obj2).getClass();
                    switch (b3) {
                        case 0:
                            QueueKt.NewMiniPlayer(progressState3, function1, composer2, Stack.updateChangedFlags(i6 | 1));
                            break;
                        default:
                            QueueKt.NewMiniPlayer(progressState3, function1, composer2, Stack.updateChangedFlags(i6 | 1));
                            break;
                    }
                    return unit;
                }
            };
        }
    }

    /* JADX INFO: renamed from: NewMiniPlayerCover-RPmYEkk, reason: not valid java name */
    public static final void m1501NewMiniPlayerCoverRPmYEkk(MediaMetadata mediaMetadata, long j, Composer composer, int i) {
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(1926521921);
        int i2 = (gapComposer.changed(mediaMetadata) ? 4 : 2) | i | (gapComposer.changed(j) ? 32 : 16);
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 19) != 18)) {
            DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference = UtilsKt.rememberPreference(PreferenceKeysKt.CropAlbumArtKey, Boolean.FALSE, gapComposer, 48);
            SpringSpec springSpec = DimensionsKt.NavigationBarAnimationSpec;
            RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(10.0f);
            Modifier modifierM42borderxT4_qwU = ImageKt.m42borderxT4_qwU(ImageKt.m39backgroundbw27NRU(ClipKt.clip(SizeKt.m151size3ABfNKs(Modifier.Companion.$$INSTANCE, 44.0f), roundedCornerShapeM185RoundedCornerShape0680j_4), ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.surfaceVariant, ColorKt.RectangleShape), 1.0f, j, roundedCornerShapeM185RoundedCornerShape0680j_4);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierM42borderxT4_qwU);
            ComposeUiNode.Companion.getClass();
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(LayoutNode.Constructor);
            } else {
                gapComposer.useNode();
            }
            Stack.m390setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m389reconcileimpl(gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            if (mediaMetadata == null) {
                gapComposer.startReplaceGroup(1847818632);
                gapComposer.end(false);
            } else {
                String str = mediaMetadata.thumbnailUrl;
                gapComposer.startReplaceGroup(1847818633);
                boolean zChanged = gapComposer.changed(str);
                Object objRememberedValue = gapComposer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.Companion.Empty) {
                    objRememberedValue = str != null ? YouTubeUtilsKt.resize(str, 132, 132) : null;
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                AsyncImageKt.m849AsyncImage10Xjiaw((String) objRememberedValue, SizeKt.FillWholeMaxSize, ((Boolean) dataStoreKt$rememberPreference$1$1RememberPreference.$state.getValue()).booleanValue() ? ContentScale.Companion.Crop : ContentScale.Companion.Fit, gapComposer, 432, 1976);
                gapComposer.end(false);
            }
            gapComposer.end(true);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ListItemKt$$ExternalSyntheticLambda14(mediaMetadata, j, i, (byte) 2);
        }
    }

    /* JADX INFO: renamed from: NewMiniPlayerPlayButton-SxpAMN0, reason: not valid java name */
    public static final void m1502NewMiniPlayerPlayButtonSxpAMN0(final ProgressState progressState, final int i, final boolean z, final CastConnectionHandler castConnectionHandler, final PlayerConnection playerConnection, final MediaMetadata mediaMetadata, final long j, final long j2, final ListenTogetherManager listenTogetherManager, Composer composer, final int i2) {
        int i3;
        GapComposer gapComposer;
        MutableState mutableStateCollectAsState;
        boolean z2;
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(186423206);
        if ((i2 & 48) == 0) {
            i3 = (gapComposer2.changed(i) ? 32 : 16) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 384) == 0) {
            i3 |= gapComposer2.changed(z) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i3 |= (i2 & 4096) == 0 ? gapComposer2.changed(castConnectionHandler) : gapComposer2.changedInstance(castConnectionHandler) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i3 |= (i2 & 32768) == 0 ? gapComposer2.changed(playerConnection) : gapComposer2.changedInstance(playerConnection) ? 16384 : 8192;
        }
        if ((100663296 & i2) == 0) {
            i3 |= (134217728 & i2) == 0 ? gapComposer2.changed(listenTogetherManager) : gapComposer2.changedInstance(listenTogetherManager) ? 67108864 : 33554432;
        }
        if (gapComposer2.shouldExecute(i3 & 1, (33563793 & i3) != 33563792)) {
            MutableState mutableStateCollectAsState2 = Stack.collectAsState(playerConnection.isPlaying, gapComposer2, 3);
            StateFlowImpl stateFlowImpl = castConnectionHandler != null ? castConnectionHandler.castIsPlaying : null;
            if (stateFlowImpl == null) {
                gapComposer2.startReplaceGroup(341463115);
                gapComposer2.end(false);
                mutableStateCollectAsState = null;
            } else {
                gapComposer2.startReplaceGroup(-1235911050);
                mutableStateCollectAsState = Stack.collectAsState(stateFlowImpl, gapComposer2, 3);
                gapComposer2.end(false);
            }
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (mutableStateCollectAsState == null) {
                gapComposer2.startReplaceGroup(341483514);
                Object objRememberedValue = gapComposer2.rememberedValue();
                if (objRememberedValue == neverEqualPolicy) {
                    objRememberedValue = Stack.mutableStateOf$default(Boolean.FALSE);
                    gapComposer2.updateRememberedValue(objRememberedValue);
                }
                mutableStateCollectAsState = (MutableState) objRememberedValue;
            } else {
                gapComposer2.startReplaceGroup(-1235911880);
            }
            gapComposer2.end(false);
            boolean zBooleanValue = z ? ((Boolean) mutableStateCollectAsState.getValue()).booleanValue() : ((Boolean) mutableStateCollectAsState2.getValue()).booleanValue();
            boolean z3 = (listenTogetherManager == null || !listenTogetherManager.client.isInRoom() || listenTogetherManager.isHost()) ? false : true;
            MutableState mutableStateCollectAsStateWithLifecycle = FileSystemsKt.collectAsStateWithLifecycle(playerConnection.isMuted, gapComposer2);
            Modifier modifierM151size3ABfNKs = SizeKt.m151size3ABfNKs(Modifier.Companion.$$INSTANCE, 44.0f);
            boolean zChanged = ((i3 & 57344) == 16384 || ((i3 & 32768) != 0 && gapComposer2.changedInstance(playerConnection))) | gapComposer2.changed(z3) | ((i3 & 896) == 256) | gapComposer2.changed(mutableStateCollectAsState) | ((i3 & 7168) == 2048 || ((i3 & 4096) != 0 && gapComposer2.changedInstance(castConnectionHandler))) | ((i3 & 112) == 32);
            Object objRememberedValue2 = gapComposer2.rememberedValue();
            if (zChanged || objRememberedValue2 == neverEqualPolicy) {
                boolean z4 = z3;
                MiniPlayerKt$$ExternalSyntheticLambda20 miniPlayerKt$$ExternalSyntheticLambda20 = new MiniPlayerKt$$ExternalSyntheticLambda20(z4, playerConnection, z, castConnectionHandler, i, mutableStateCollectAsState, (byte) 0);
                z2 = z4;
                gapComposer2.updateRememberedValue(miniPlayerKt$$ExternalSyntheticLambda20);
                objRememberedValue2 = miniPlayerKt$$ExternalSyntheticLambda20;
            } else {
                z2 = z3;
            }
            gapComposer = gapComposer2;
            CardKt.IconButton((Function0) objRememberedValue2, modifierM151size3ABfNKs, false, null, null, Expect_jvmKt.rememberComposableLambda(-1675202488, new MiniPlayerKt$$ExternalSyntheticLambda21(z2, i, zBooleanValue, mutableStateCollectAsStateWithLifecycle, (byte) 0), gapComposer2), gapComposer, 1572912, 60);
        } else {
            gapComposer = gapComposer2;
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.metrolist.music.ui.player.MiniPlayerKt$$ExternalSyntheticLambda22
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    QueueKt.m1502NewMiniPlayerPlayButtonSxpAMN0(progressState, i, z, castConnectionHandler, playerConnection, mediaMetadata, j, j2, listenTogetherManager, (Composer) obj, Stack.updateChangedFlags(i2 | 1));
                    return Unit.INSTANCE;
                }
            };
        }
    }

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
    /* JADX INFO: renamed from: NewMiniPlayerSongInfo-eopBjH0, reason: not valid java name */
    public static final void m1503NewMiniPlayerSongInfoeopBjH0(MediaMetadata mediaMetadata, long j, long j2, Modifier modifier, Composer composer, int i) {
        MutableState mutableStateCollectAsState;
        boolean z;
        boolean z2;
        long j3 = j2;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-676198801);
        int i2 = i | (gapComposer.changed(mediaMetadata) ? 4 : 2) | (gapComposer.changed(j) ? 32 : 16) | (gapComposer.changed(j3) ? 256 : 128) | (gapComposer.changed(modifier) ? 2048 : 1024);
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 1171) != 1170)) {
            PlayerConnection playerConnection = (PlayerConnection) gapComposer.consume(MainActivityKt.LocalPlayerConnection);
            StateFlowImpl stateFlowImpl = playerConnection != null ? playerConnection.error : null;
            if (stateFlowImpl == null) {
                gapComposer.startReplaceGroup(-1241657502);
                gapComposer.end(false);
                mutableStateCollectAsState = null;
            } else {
                gapComposer.startReplaceGroup(-1286979457);
                mutableStateCollectAsState = Stack.collectAsState(stateFlowImpl, gapComposer, 3);
                gapComposer.end(false);
            }
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (mutableStateCollectAsState == null) {
                gapComposer.startReplaceGroup(-1241637134);
                Object objRememberedValue = gapComposer.rememberedValue();
                if (objRememberedValue == neverEqualPolicy) {
                    objRememberedValue = Stack.mutableStateOf$default(null);
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                mutableStateCollectAsState = (MutableState) objRememberedValue;
            } else {
                gapComposer.startReplaceGroup(-1286980598);
            }
            gapComposer.end(false);
            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Center, Alignment.Companion.Start, gapComposer, 6);
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifier);
            ComposeUiNode.Companion.getClass();
            gapComposer.startReusableNode();
            boolean z3 = gapComposer.inserting;
            TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
            if (z3) {
                gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer.useNode();
            }
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetMeasurePolicy;
            Stack.m390setimpl(gapComposer, columnMeasurePolicy, updater$$ExternalSyntheticLambda0);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda1);
            Integer numValueOf = Integer.valueOf(iHashCode);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetCompositeKeyHash;
            Stack.m390setimpl(gapComposer, numValueOf, updater$$ExternalSyntheticLambda2);
            Stack.m389reconcileimpl(gapComposer);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetModifier;
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier, updater$$ExternalSyntheticLambda3);
            if (mediaMetadata == null) {
                gapComposer.startReplaceGroup(2113275781);
                gapComposer.end(false);
                z2 = true;
            } else {
                List list = mediaMetadata.artists;
                gapComposer.startReplaceGroup(2113275782);
                String str = mediaMetadata.title;
                TextStyle textStyleM750copyp1EtxEg$default = TextStyle.m750copyp1EtxEg$default(((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).typography.titleLarge, 0L, IntMath.getSp(16), null, null, null, null, 0L, 0L, null, null, 16777213);
                Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                MutableState mutableState = mutableStateCollectAsState;
                TextKt.m352TextNvy7gAk(str, ImageKt.m41basicMarquee1Mj1MLw$default(companion, 22), j, 0L, null, null, null, 0L, null, 0L, 1, false, 1, 0, textStyleM750copyp1EtxEg$default, gapComposer, ((i2 << 3) & 896) | 48, 24960, 110584);
                RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(OffsetKt.SpaceBetween, Alignment.Companion.CenterVertically, gapComposer, 54);
                int iHashCode2 = Long.hashCode(gapComposer.compositeKeyHashCode);
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer, companion);
                gapComposer.startReusableNode();
                if (gapComposer.inserting) {
                    gapComposer = gapComposer;
                    gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
                } else {
                    gapComposer = gapComposer;
                    gapComposer.useNode();
                }
                Stack.m390setimpl(gapComposer, rowMeasurePolicy, updater$$ExternalSyntheticLambda0);
                Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
                IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer, updater$$ExternalSyntheticLambda2, gapComposer);
                Stack.m390setimpl(gapComposer, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
                if (mediaMetadata.explicit) {
                    gapComposer.startReplaceGroup(-767378447);
                    Icon.INSTANCE.Explicit(6, gapComposer);
                    z = false;
                } else {
                    z = false;
                    gapComposer.startReplaceGroup(1981081531);
                }
                gapComposer.end(z);
                if (list == null || !list.isEmpty()) {
                    Iterator it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            gapComposer.startReplaceGroup(1981687643);
                            gapComposer.end(false);
                        } else if (!StringsKt.isBlank(((MediaMetadata.Artist) it.next()).name)) {
                            gapComposer.startReplaceGroup(1981188326);
                            String strM = IntIntPair$$ExternalSyntheticOutline0.m(ServerSentEventKt.SPACE, MathKt.stringResource(R.string.and, gapComposer), ServerSentEventKt.SPACE);
                            Object objRememberedValue2 = gapComposer.rememberedValue();
                            if (objRememberedValue2 == neverEqualPolicy) {
                                objRememberedValue2 = new SongMenuKt$$ExternalSyntheticLambda16((byte) 21);
                                gapComposer.updateRememberedValue(objRememberedValue2);
                            }
                            String strJoinToArtistString = UtilsKt.joinToArtistString(list, strM, (Function1) objRememberedValue2);
                            StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                            TextKt.m352TextNvy7gAk(strJoinToArtistString, ImageKt.m41basicMarquee1Mj1MLw$default(companion, 22), ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 1, false, 1, 0, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).typography.bodySmall, gapComposer, 48, 24960, 110584);
                            gapComposer = gapComposer;
                            gapComposer.end(false);
                        }
                    }
                } else {
                    gapComposer.startReplaceGroup(1981687643);
                    gapComposer.end(false);
                }
                z2 = true;
                char c = 1;
                gapComposer.end(true);
                j3 = j2;
                CrossfadeKt.AnimatedVisibility(ColumnScopeInstance.INSTANCE, ((PlaybackException) mutableState.getValue()) != null, null, EnterExitTransitionKt.fadeIn$default(null, CropImageView.DEFAULT_ASPECT_RATIO, 3), EnterExitTransitionKt.fadeOut$default(null, CropImageView.DEFAULT_ASPECT_RATIO, 3), null, Expect_jvmKt.rememberComposableLambda(148296659, new ChipKt$$ExternalSyntheticLambda16(j3, c == true ? 1 : 0), gapComposer), gapComposer, 1600518, 18);
                gapComposer.end(false);
            }
            gapComposer.end(z2);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new MiniPlayerKt$$ExternalSyntheticLambda25(mediaMetadata, j, j3, modifier, i);
        }
    }

    public static final void PlaybackError(final PlaybackException playbackException, Function0 function0, Composer composer, final int i) throws IOException {
        GapComposer gapComposer;
        final byte b;
        boolean z;
        String strM;
        String str;
        String str2;
        String str3;
        List list;
        final Function0 function1 = function0;
        int i2 = playbackException.errorCode;
        function1.getClass();
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(-1699138176);
        int i3 = (gapComposer2.changedInstance(playbackException) ? 4 : 2) | i | (gapComposer2.changedInstance(function1) ? 32 : 16);
        final byte b2 = 0;
        if (gapComposer2.shouldExecute(i3 & 1, (i3 & 19) != 18)) {
            Context context = (Context) gapComposer2.consume(AndroidCompositionLocals_androidKt.LocalContext);
            PlayerConnection playerConnection = (PlayerConnection) gapComposer2.consume(MainActivityKt.LocalPlayerConnection);
            if (playerConnection == null) {
                RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new Function2(playbackException, function1, i, b2) { // from class: com.metrolist.music.ui.player.PlaybackErrorKt$$ExternalSyntheticLambda0
                        public final /* synthetic */ byte $r8$classId;
                        public final /* synthetic */ PlaybackException f$0;
                        public final /* synthetic */ Function0 f$1;

                        {
                            this.$r8$classId = b2;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) throws IOException {
                            byte b3 = this.$r8$classId;
                            Unit unit = Unit.INSTANCE;
                            Function0 function2 = this.f$1;
                            PlaybackException playbackException2 = this.f$0;
                            Composer composer2 = (Composer) obj;
                            ((Integer) obj2).getClass();
                            switch (b3) {
                                case 0:
                                    QueueKt.PlaybackError(playbackException2, function2, composer2, Stack.updateChangedFlags(1));
                                    break;
                                default:
                                    QueueKt.PlaybackError(playbackException2, function2, composer2, Stack.updateChangedFlags(1));
                                    break;
                            }
                            return unit;
                        }
                    };
                    return;
                }
                return;
            }
            MutableState mutableStateCollectAsState = Stack.collectAsState(playerConnection.mediaMetadata, gapComposer2, 3);
            MutableState mutableStateCollectAsState2 = Stack.collectAsState(playerConnection.currentStreamClient, gapComposer2, 3);
            NetworkConnectivityObserver networkConnectivityObserver = playerConnection.service.connectivityObserver;
            if (networkConnectivityObserver == null) {
                Intrinsics.throwUninitializedPropertyAccessException("connectivityObserver");
                throw null;
            }
            MutableState mutableStateCollectAsState3 = Stack.collectAsState(networkConnectivityObserver.networkStatus, gapComposer2, 3);
            boolean zChanged = gapComposer2.changed(playbackException);
            Object objRememberedValue = gapComposer2.rememberedValue();
            byte b3 = 24;
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (zChanged || objRememberedValue == neverEqualPolicy) {
                objRememberedValue = SequencesKt.toList(SequencesKt.take(SequencesKt.generateSequence(playbackException, new SongMenuKt$$ExternalSyntheticLambda16(b3)), 8));
                gapComposer2.updateRememberedValue(objRememberedValue);
            }
            List list2 = (List) objRememberedValue;
            boolean zChanged2 = gapComposer2.changed(list2);
            Object objRememberedValue2 = gapComposer2.rememberedValue();
            if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                ArrayList arrayList = new ArrayList();
                Iterator it = list2.iterator();
                while (it.hasNext()) {
                    String message = ((Throwable) it.next()).getMessage();
                    String str4 = (message == null || StringsKt.isBlank(message)) ? null : message;
                    if (str4 != null) {
                        arrayList.add(str4);
                    }
                }
                objRememberedValue2 = CollectionsKt.toList(CollectionsKt.toMutableSet(arrayList));
                gapComposer2.updateRememberedValue(objRememberedValue2);
            }
            List list3 = (List) objRememberedValue2;
            if (list3 == null || !list3.isEmpty()) {
                Iterator it2 = list3.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        b2 = 0;
                        break;
                    }
                    String str5 = (String) it2.next();
                    if (StringsKt.contains(str5, "confirm your age", true) || StringsKt.contains(str5, "age-restricted", true) || StringsKt.contains(str5, "LOGIN_REQUIRED", true) || StringsKt.contains(str5, "403", true)) {
                        b2 = 1;
                        break;
                    }
                }
            }
            if (list3 == null || !list3.isEmpty()) {
                Iterator it3 = list3.iterator();
                while (true) {
                    if (it3.hasNext()) {
                        String str6 = (String) it3.next();
                        if (StringsKt.contains(str6, "job", true) && (StringsKt.contains(str6, "cancelled", true) || StringsKt.contains(str6, "canceled", true) || StringsKt.contains(str6, "cancellat", true))) {
                            z = true;
                        }
                    } else {
                        z = false;
                    }
                }
            } else {
                z = false;
            }
            if (b2 != 0) {
                strM = Format$$ExternalSyntheticOutline0.m(gapComposer2, -784171527, R.string.error_explicit_login_recommended, gapComposer2, false);
            } else if (z) {
                strM = Format$$ExternalSyntheticOutline0.m(gapComposer2, -784168724, R.string.error_job_cancelled, gapComposer2, false);
            } else {
                gapComposer2.startReplaceGroup(1460636573);
                gapComposer2.end(false);
                strM = null;
            }
            gapComposer2.startReplaceGroup(-784157326);
            boolean zBooleanValue = ((Boolean) mutableStateCollectAsState3.getValue()).booleanValue();
            String strStringResource = MathKt.stringResource(R.string.error_offline_playback, gapComposer2);
            strStringResource.getClass();
            list3.getClass();
            String strJoinToString$default = CollectionsKt.joinToString$default(zBooleanValue ? CollectionsKt.toList(CollectionsKt.toMutableSet(CollectionsKt.plus((Iterable) list3, (Collection) CollectionsKt__IterablesKt.listOfNotNull(strM)))) : CollectionsKt__IterablesKt.listOf(strStringResource), "\n", null, null, null, 62);
            if (StringsKt.isBlank(strJoinToString$default)) {
                strJoinToString$default = MathKt.stringResource(R.string.error_unknown, gapComposer2);
            }
            gapComposer2.end(false);
            boolean zChanged3 = gapComposer2.changed(list2);
            Object objRememberedValue3 = gapComposer2.rememberedValue();
            if (zChanged3 || objRememberedValue3 == neverEqualPolicy) {
                objRememberedValue3 = CollectionsKt.joinToString$default(CollectionsKt.drop(list2, 1), " → ", null, null, new SongMenuKt$$ExternalSyntheticLambda16((byte) 23), 30);
                gapComposer2.updateRememberedValue(objRememberedValue3);
            }
            String str7 = (String) objRememberedValue3;
            boolean zChanged4 = gapComposer2.changed(playbackException);
            Object objRememberedValue4 = gapComposer2.rememberedValue();
            if (zChanged4 || objRememberedValue4 == neverEqualPolicy) {
                objRememberedValue4 = StringsKt.removePrefix(playbackException.getErrorCodeName(), "ERROR_CODE_");
                gapComposer2.updateRememberedValue(objRememberedValue4);
            }
            String str8 = (String) objRememberedValue4;
            boolean zChanged5 = gapComposer2.changed(playbackException);
            Object objRememberedValue5 = gapComposer2.rememberedValue();
            if (zChanged5 || objRememberedValue5 == neverEqualPolicy) {
                objRememberedValue5 = Instant.now();
                gapComposer2.updateRememberedValue(objRememberedValue5);
            }
            Instant instant = (Instant) objRememberedValue5;
            boolean zChanged6 = gapComposer2.changed(playbackException) | gapComposer2.changed((MediaMetadata) mutableStateCollectAsState.getValue()) | gapComposer2.changed((String) mutableStateCollectAsState2.getValue());
            Object objRememberedValue6 = gapComposer2.rememberedValue();
            String str9 = strJoinToString$default;
            if (zChanged6 || objRememberedValue6 == neverEqualPolicy) {
                MediaMetadata mediaMetadata = (MediaMetadata) mutableStateCollectAsState.getValue();
                String str10 = (String) mutableStateCollectAsState2.getValue();
                instant.getClass();
                StringBuilder sb = new StringBuilder("Auralys Playback Error Report\n================================\n");
                sb.append("Time: " + instant);
                sb.append("\nApp version: 4.1.0 (410)\nArchitecture: universal\n");
                sb.append("Android: " + Build.VERSION.RELEASE + " (API " + Build.VERSION.SDK_INT + ")");
                sb.append('\n');
                sb.append("Device: " + Build.MANUFACTURER + ServerSentEventKt.SPACE + Build.MODEL);
                sb.append("\n\nMedia\n-----\n");
                String strConcat = "Unknown";
                if (mediaMetadata == null || (str = mediaMetadata.title) == null) {
                    str = "Unknown";
                }
                sb.append("Title: ".concat(str));
                sb.append('\n');
                sb.append("Artists: ".concat((mediaMetadata == null || (list = mediaMetadata.artists) == null) ? "Unknown" : CollectionsKt.joinToString$default(list, ", ", null, null, new SongMenuKt$$ExternalSyntheticLambda16((byte) 25), 30)));
                sb.append('\n');
                if (mediaMetadata == null || (str2 = mediaMetadata.id) == null) {
                    str2 = "Unknown";
                }
                sb.append("ID: ".concat(str2));
                sb.append('\n');
                if (mediaMetadata != null && (str3 = mediaMetadata.id) != null) {
                    strConcat = "https://music.youtube.com/watch?v=".concat(str3);
                }
                sb.append("Link: ".concat(strConcat));
                sb.append('\n');
                if (str10 == null) {
                    str10 = "Not resolved";
                }
                sb.append("Stream client: ".concat(str10));
                sb.append("\n\nError\n-----\n");
                sb.append("Code: " + StringsKt.removePrefix(playbackException.getErrorCodeName(), "ERROR_CODE_") + " (" + i2 + ")");
                sb.append('\n');
                int i4 = 0;
                for (Object obj : SequencesKt.toList(SequencesKt.take(SequencesKt.generateSequence(playbackException, new SongMenuKt$$ExternalSyntheticLambda16((byte) 24)), 8))) {
                    int i5 = i4 + 1;
                    if (i4 < 0) {
                        CollectionsKt__IterablesKt.throwIndexOverflow();
                        throw null;
                    }
                    Throwable th = (Throwable) obj;
                    String name = th.getClass().getName();
                    String message2 = th.getMessage();
                    if (message2 == null) {
                        message2 = "(no message)";
                    }
                    sb.append("[" + i4 + "] " + name + ": " + message2);
                    sb.append('\n');
                    i4 = i5;
                }
                sb.append("\nStack trace\n-----------\n");
                sb.append(ResultKt.stackTraceToString(playbackException));
                objRememberedValue6 = sb.toString();
                gapComposer2.updateRememberedValue(objRememberedValue6);
            }
            String str11 = (String) objRememberedValue6;
            BiasAlignment.Horizontal horizontal = Alignment.Companion.CenterHorizontally;
            FlowRowOverflow flowRowOverflow = OffsetKt.Center;
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier modifierM135padding3ABfNKs = OffsetKt.m135padding3ABfNKs(SizeKt.fillMaxWidth(companion, 1.0f), 16.0f);
            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(flowRowOverflow, horizontal, gapComposer2, 54);
            int iHashCode = Long.hashCode(gapComposer2.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer2, modifierM135padding3ABfNKs);
            ComposeUiNode.Companion.getClass();
            gapComposer2.startReusableNode();
            boolean z2 = gapComposer2.inserting;
            TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
            if (z2) {
                gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer2.useNode();
            }
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetMeasurePolicy;
            Stack.m390setimpl(gapComposer2, columnMeasurePolicy, updater$$ExternalSyntheticLambda0);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda1);
            Integer numValueOf = Integer.valueOf(iHashCode);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetCompositeKeyHash;
            Stack.m390setimpl(gapComposer2, numValueOf, updater$$ExternalSyntheticLambda2);
            Stack.m389reconcileimpl(gapComposer2);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetModifier;
            Stack.m390setimpl(gapComposer2, modifierMaterializeModifier, updater$$ExternalSyntheticLambda3);
            IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.error, 0, gapComposer2), (String) null, SizeKt.m151size3ABfNKs(companion, 48.0f), CardKt.getColorScheme(gapComposer2).error, gapComposer2, 440, 0);
            OffsetKt.Spacer(gapComposer2, SizeKt.m145height3ABfNKs(companion, 12.0f));
            TextKt.m352TextNvy7gAk(MathKt.stringResource(((Boolean) mutableStateCollectAsState3.getValue()).booleanValue() ? R.string.error_playback_failed : R.string.error_no_internet_connection, gapComposer2), null, CardKt.getColorScheme(gapComposer2).error, 0L, null, null, null, 0L, new TextAlign(3), 0L, 0, false, 0, 0, CardKt.getTypography(gapComposer2).titleMedium, gapComposer2, 0, 0, 130042);
            OffsetKt.Spacer(gapComposer2, SizeKt.m145height3ABfNKs(companion, 8.0f));
            TextKt.m352TextNvy7gAk(str9, null, CardKt.getColorScheme(gapComposer2).onSurfaceVariant, 0L, null, null, null, 0L, new TextAlign(3), 0L, 2, false, 3, 0, CardKt.getTypography(gapComposer2).bodyMedium, gapComposer2, 0, 24960, 109562);
            OffsetKt.Spacer(gapComposer2, SizeKt.m145height3ABfNKs(companion, 4.0f));
            TextStyle textStyle = CardKt.getTypography(gapComposer2).bodySmall;
            long sp = IntMath.getSp(11);
            GenericFontFamily genericFontFamily = FontFamily.Monospace;
            TextStyle textStyleM750copyp1EtxEg$default = TextStyle.m750copyp1EtxEg$default(textStyle, 0L, sp, null, null, genericFontFamily, null, 0L, 0L, null, null, 16777181);
            long j = CardKt.getColorScheme(gapComposer2).onSurfaceVariant;
            TextKt.m352TextNvy7gAk("Code: " + str8 + " (" + i2 + ")", null, ColorKt.Color(Color.m485getRedimpl(j), Color.m484getGreenimpl(j), Color.m482getBlueimpl(j), 0.7f, Color.m483getColorSpaceimpl(j)), 0L, null, null, null, 0L, new TextAlign(3), 0L, 0, false, 0, 0, textStyleM750copyp1EtxEg$default, gapComposer2, 0, 0, 130042);
            if (str7.length() > 0) {
                gapComposer2.startReplaceGroup(-1889609635);
                OffsetKt.Spacer(gapComposer2, SizeKt.m145height3ABfNKs(companion, 4.0f));
                TextStyle textStyleM750copyp1EtxEg$default2 = TextStyle.m750copyp1EtxEg$default(CardKt.getTypography(gapComposer2).bodySmall, 0L, IntMath.getSp(10), null, null, genericFontFamily, null, 0L, 0L, null, null, 16777181);
                long j2 = CardKt.getColorScheme(gapComposer2).onSurfaceVariant;
                TextKt.m352TextNvy7gAk(str7, null, ColorKt.Color(Color.m485getRedimpl(j2), Color.m484getGreenimpl(j2), Color.m482getBlueimpl(j2), 0.7f, Color.m483getColorSpaceimpl(j2)), 0L, null, null, null, 0L, new TextAlign(3), 0L, 2, false, 1, 0, textStyleM750copyp1EtxEg$default2, gapComposer2, 0, 24960, 109562);
                gapComposer2.end(false);
            } else {
                gapComposer2.startReplaceGroup(-1889091656);
                gapComposer2.end(false);
            }
            OffsetKt.Spacer(gapComposer2, SizeKt.m145height3ABfNKs(companion, 16.0f));
            RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(new Arrangement$SpacedAligned(12.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5)), Alignment.Companion.CenterVertically, gapComposer2, 54);
            int iHashCode2 = Long.hashCode(gapComposer2.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer2, companion);
            gapComposer2.startReusableNode();
            if (gapComposer2.inserting) {
                gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer2.useNode();
            }
            Stack.m390setimpl(gapComposer2, rowMeasurePolicy, updater$$ExternalSyntheticLambda0);
            Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer2, updater$$ExternalSyntheticLambda2, gapComposer2);
            Stack.m390setimpl(gapComposer2, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
            RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(8.0f);
            PaddingValuesImpl paddingValuesImpl = ButtonDefaults.ContentPadding;
            b = 1;
            function1 = function0;
            CardKt.Button(function1, null, false, roundedCornerShapeM185RoundedCornerShape0680j_4, ButtonDefaults.m247buttonColorsro_MJ88(CardKt.getColorScheme(gapComposer2).primary, 0L, 0L, gapComposer2, 14), null, null, null, null, lambda$273813238, gapComposer2, ((i3 >> 3) & 14) | 805306368, 486);
            boolean zChangedInstance = gapComposer2.changedInstance(context) | gapComposer2.changed(str11);
            Object objRememberedValue7 = gapComposer2.rememberedValue();
            if (zChangedInstance || objRememberedValue7 == neverEqualPolicy) {
                objRememberedValue7 = new PlayerMenuKt$$ExternalSyntheticLambda120(context, str11, (byte) 1);
                gapComposer2.updateRememberedValue(objRememberedValue7);
            }
            CardKt.OutlinedButton((Function0) objRememberedValue7, null, false, RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(8.0f), null, null, null, f295lambda$816311244, gapComposer2, 805306368, 502);
            gapComposer = gapComposer2;
            gapComposer.end(true);
            gapComposer.end(true);
        } else {
            gapComposer = gapComposer2;
            b = 1;
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup2 = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup2 != null) {
            recomposeScopeImplEndRestartGroup2.block = new Function2(playbackException, function1, i, b) { // from class: com.metrolist.music.ui.player.PlaybackErrorKt$$ExternalSyntheticLambda0
                public final /* synthetic */ byte $r8$classId;
                public final /* synthetic */ PlaybackException f$0;
                public final /* synthetic */ Function0 f$1;

                {
                    this.$r8$classId = b;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) throws IOException {
                    byte b4 = this.$r8$classId;
                    Unit unit = Unit.INSTANCE;
                    Function0 function2 = this.f$1;
                    PlaybackException playbackException2 = this.f$0;
                    Composer composer2 = (Composer) obj2;
                    ((Integer) obj3).getClass();
                    switch (b4) {
                        case 0:
                            QueueKt.PlaybackError(playbackException2, function2, composer2, Stack.updateChangedFlags(1));
                            break;
                        default:
                            QueueKt.PlaybackError(playbackException2, function2, composer2, Stack.updateChangedFlags(1));
                            break;
                    }
                    return unit;
                }
            };
        }
    }

    /* JADX INFO: renamed from: PlayerCoverBackground-3IgeMak, reason: not valid java name */
    public static final void m1504PlayerCoverBackground3IgeMak(int i, long j, Composer composer, String str, Function0 function0, boolean z) {
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-277963253);
        int i2 = i | (gapComposer.changed(str) ? 4 : 2) | (gapComposer.changed(j) ? 32 : 16) | (gapComposer.changed(z) ? 256 : 128) | (gapComposer.changedInstance(function0) ? 2048 : 1024);
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 1171) != 1170)) {
            Object objRememberedValue = gapComposer.rememberedValue();
            if (objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = SnapshotStateKt__DerivedStateKt.derivedStateOf(function0);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            State state = (State) objRememberedValue;
            Context context = (Context) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalContext);
            FillElement fillElement = SizeKt.FillWholeMaxSize;
            Modifier modifierM39backgroundbw27NRU = ImageKt.m39backgroundbw27NRU(fillElement, j, ColorKt.RectangleShape);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierM39backgroundbw27NRU);
            ComposeUiNode.Companion.getClass();
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(LayoutNode.Constructor);
            } else {
                gapComposer.useNode();
            }
            Stack.m390setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m389reconcileimpl(gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            if (!((Boolean) state.getValue()).booleanValue() || str == null) {
                gapComposer.startReplaceGroup(-1059452355);
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(-1060874635);
                CrossfadeKt.Crossfade(str, null, ArcSplineKt.tween$default(600, 0, null, 6), "coverBackground", Expect_jvmKt.rememberComposableLambda(1367726988, new ListItemKt$$ExternalSyntheticLambda17((byte) 11, (Object) context), gapComposer), gapComposer, (i2 & 14) | 28032, 2);
                BoxKt.Box(fillElement.then(new BackgroundElement(0L, z ? Lock.m11verticalGradient8A3gB4$default(CollectionsKt__IterablesKt.listOf((Object[]) new Color[]{new Color(ColorKt.Color(Color.m485getRedimpl(-72057594037927936L), Color.m484getGreenimpl(-72057594037927936L), Color.m482getBlueimpl(-72057594037927936L), 0.4f, Color.m483getColorSpaceimpl(-72057594037927936L))), new Color(ColorKt.Color(Color.m485getRedimpl(-72057594037927936L), Color.m484getGreenimpl(-72057594037927936L), Color.m482getBlueimpl(-72057594037927936L), 0.62f, Color.m483getColorSpaceimpl(-72057594037927936L)))}), CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 14) : Lock.m11verticalGradient8A3gB4$default(CollectionsKt__IterablesKt.listOf((Object[]) new Color[]{new Color(ColorKt.Color(Color.m485getRedimpl(-4294967296L), Color.m484getGreenimpl(-4294967296L), Color.m482getBlueimpl(-4294967296L), 0.5f, Color.m483getColorSpaceimpl(-4294967296L))), new Color(ColorKt.Color(Color.m485getRedimpl(-4294967296L), Color.m484getGreenimpl(-4294967296L), Color.m482getBlueimpl(-4294967296L), 0.7f, Color.m483getColorSpaceimpl(-4294967296L)))}), CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 14), ColorKt.RectangleShape, 1)), gapComposer, 0);
                gapComposer.end(false);
            }
            gapComposer.end(true);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new PlayerKt$$ExternalSyntheticLambda33(i, j, str, function0, z);
        }
    }

    /* JADX INFO: renamed from: PlayerMoreMenuButton-ZkgLGzA, reason: not valid java name */
    public static final void m1505PlayerMoreMenuButtonZkgLGzA(final MediaMetadata mediaMetadata, final BottomSheetState bottomSheetState, final boolean z, final long j, final long j2, Composer composer, final int i) {
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(937274236);
        int i2 = i | (gapComposer.changed(mediaMetadata) ? 4 : 2) | (gapComposer.changed(bottomSheetState) ? 32 : 16) | (gapComposer.changed(z) ? 256 : 128);
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
            MenuState menuState = (MenuState) gapComposer.consume(BottomSheetMenuKt.LocalMenuState);
            BottomSheetPageState bottomSheetPageState = (BottomSheetPageState) gapComposer.consume(BottomSheetPageKt.LocalBottomSheetPageState);
            Modifier modifierGlass = Modifier.Companion.$$INSTANCE;
            if (z) {
                gapComposer.startReplaceGroup(-1222580178);
                modifierGlass = GlassComponentsKt.glass(SizeKt.m151size3ABfNKs(modifierGlass, 42.0f), RoundedCornerShapeKt.CircleShape, false, gapComposer, 6, 2);
            } else {
                gapComposer.startReplaceGroup(-1222579420);
            }
            gapComposer.end(false);
            Modifier modifier = modifierGlass;
            boolean zChanged = ((i2 & 14) == 4) | gapComposer.changed(menuState) | ((i2 & 112) == 32) | gapComposer.changed(bottomSheetPageState);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.Empty) {
                SongMenuKt$$ExternalSyntheticLambda63 songMenuKt$$ExternalSyntheticLambda63 = new SongMenuKt$$ExternalSyntheticLambda63((Object) menuState, (Object) mediaMetadata, (Object) bottomSheetState, (Object) bottomSheetPageState, (byte) 25);
                gapComposer.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda63);
                objRememberedValue = songMenuKt$$ExternalSyntheticLambda63;
            }
            CardKt.IconButton((Function0) objRememberedValue, modifier, false, null, null, Expect_jvmKt.rememberComposableLambda(343106970, new SongMenuKt$$ExternalSyntheticLambda26((byte) 17, z), gapComposer), gapComposer, 1572864, 60);
            gapComposer = gapComposer;
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2(bottomSheetState, z, j, j2, i) { // from class: com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda64
                public final /* synthetic */ BottomSheetState f$1;
                public final /* synthetic */ boolean f$2;
                public final /* synthetic */ long f$3;
                public final /* synthetic */ long f$4;

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(1);
                    QueueKt.m1505PlayerMoreMenuButtonZkgLGzA(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, (Composer) obj, iUpdateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX WARN: Code duplicated, block: B:142:0x048b  */
    /* JADX INFO: renamed from: PlayerProgressSection-gMrHQkA, reason: not valid java name */
    public static final void m1506PlayerProgressSectiongMrHQkA(final SliderStyle sliderStyle, final boolean z, final Function0 function0, final Function0 function1, final MutableState mutableState, final boolean z2, final boolean z3, final boolean z4, final Function1 function2, Composer composer, final int i) {
        boolean z5;
        long j;
        long jColor;
        long jColor2;
        MutableState mutableState2;
        int i2;
        long j2;
        float f;
        Modifier.Companion companion;
        long j3;
        GapComposer gapComposer;
        TextStyle textStyleM750copyp1EtxEg$default;
        boolean z6;
        long jColor3;
        String strConcat;
        TextStyle textStyleM750copyp1EtxEg$default2;
        boolean z7;
        long jColor4;
        Modifier.Companion companion2;
        float f2;
        boolean z8;
        int i3;
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(-1192203680);
        int i4 = i | (gapComposer2.changed(sliderStyle.ordinal()) ? 4 : 2) | (gapComposer2.changed(z) ? 32 : 16) | (gapComposer2.changed(z2) ? 131072 : 65536) | (gapComposer2.changed(z3) ? ByteChannelKt.CHANNEL_MAX_SIZE : 524288) | (gapComposer2.changed(z4) ? 67108864 : 33554432) | (gapComposer2.changedInstance(function2) ? 536870912 : WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE);
        if (gapComposer2.shouldExecute(i4 & 1, (306783379 & i4) != 306783378)) {
            long jLongValue = ((Number) function1.invoke()).longValue();
            Long l = (Long) mutableState.getValue();
            long jLongValue2 = l != null ? l.longValue() : ((Number) function0.invoke()).longValue();
            ClosedFloatRange closedFloatRange = new ClosedFloatRange(CropImageView.DEFAULT_ASPECT_RATIO, jLongValue == -9223372036854775807L ? 0.0f : jLongValue);
            long j4 = CardKt.getColorScheme(gapComposer2).primary;
            boolean z9 = l != null;
            final AnimateAsState animateAsStateM18animateDpAsStateAjpBEmI = AnimateAsStateKt.m18animateDpAsStateAjpBEmI(z9 ? 8.0f : 4.0f, ArcSplineKt.spring$default(0.7f, 500.0f, null, 4), "glassTrackHeight", gapComposer2, 432, 8);
            AnimateAsState animateAsStateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(z9 ? 1.0f : CropImageView.DEFAULT_ASPECT_RATIO, ArcSplineKt.spring$default(0.6f, 500.0f, null, 4), "thumbScale", gapComposer2, 3120, 20);
            SliderDefaults sliderDefaults = SliderDefaults.INSTANCE;
            if (z4) {
                gapComposer2.startReplaceGroup(1048575433);
                j = CardKt.getColorScheme(gapComposer2).onSurface;
                z5 = false;
                gapComposer2.end(false);
            } else {
                z5 = false;
                gapComposer2.startReplaceGroup(1048575911);
                gapComposer2.end(false);
                j = j4;
            }
            if (z4) {
                gapComposer2.startReplaceGroup(1048579315);
                gapComposer2.end(z5);
                jColor = ColorKt.Color(Color.m485getRedimpl(-4294967296L), Color.m484getGreenimpl(-4294967296L), Color.m482getBlueimpl(-4294967296L), 0.25f, Color.m483getColorSpaceimpl(-4294967296L));
            } else {
                gapComposer2.startReplaceGroup(1048580942);
                jColor = CardKt.getColorScheme(gapComposer2).outlineVariant;
                gapComposer2.end(z5);
            }
            if (z4) {
                gapComposer2.startReplaceGroup(1048586451);
                gapComposer2.end(z5);
                jColor2 = ColorKt.Color(Color.m485getRedimpl(-4294967296L), Color.m484getGreenimpl(-4294967296L), Color.m482getBlueimpl(-4294967296L), 0.25f, Color.m483getColorSpaceimpl(-4294967296L));
            } else {
                gapComposer2.startReplaceGroup(1048588078);
                jColor2 = CardKt.getColorScheme(gapComposer2).outlineVariant;
                gapComposer2.end(z5);
            }
            boolean z10 = z5;
            final SliderColors sliderColorsM328colorsq0g_0yA = SliderDefaults.m328colorsq0g_0yA(j4, j, j4, jColor, 0L, j4, j4, jColor2, gapComposer2, 656);
            int i5 = i4 & 458752;
            boolean z11 = i5 == 131072 ? true : z10;
            Object objRememberedValue = gapComposer2.rememberedValue();
            byte b = 3;
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (z11 || objRememberedValue == neverEqualPolicy) {
                mutableState2 = mutableState;
                objRememberedValue = new SliderKt$$ExternalSyntheticLambda8(z2, mutableState2, b);
                gapComposer2.updateRememberedValue(objRememberedValue);
            } else {
                mutableState2 = mutableState;
            }
            Function1 function3 = (Function1) objRememberedValue;
            boolean z12 = ((i4 & 1879048192) == 536870912) | (i5 == 131072);
            Object objRememberedValue2 = gapComposer2.rememberedValue();
            if (z12 || objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new PlayerKt$$ExternalSyntheticLambda49(z2, mutableState2, function2);
                gapComposer2.updateRememberedValue(objRememberedValue2);
            }
            Function0 function4 = (Function0) objRememberedValue2;
            int iOrdinal = sliderStyle.ordinal();
            Modifier.Companion companion3 = Modifier.Companion.$$INSTANCE;
            if (iOrdinal != 0) {
                if (iOrdinal == 1) {
                    companion2 = companion3;
                    j3 = jLongValue2;
                    f2 = 20.0f;
                    i2 = 2;
                    j2 = jLongValue;
                    gapComposer2.startReplaceGroup(-1851635610);
                    if (z) {
                        gapComposer2.startReplaceGroup(-1851601045);
                        MenuKt.SquigglySlider(j3, function3, OffsetKt.m137paddingVpY3zN4$default(companion2, 20.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2), z2, closedFloatRange, function4, sliderColorsM328colorsq0g_0yA, z3, gapComposer2, ((i4 >> 6) & 7168) | ((i4 << 3) & 29360128), 0);
                        gapComposer = gapComposer2;
                        z8 = false;
                        gapComposer.end(false);
                    } else {
                        gapComposer2.startReplaceGroup(-1851127985);
                        MenuKt.m1496WavySliderf2iHHTE(j3, function3, OffsetKt.m137paddingVpY3zN4$default(companion2, 20.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2), closedFloatRange, function4, sliderColorsM328colorsq0g_0yA, z3, z2, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, gapComposer2, (i4 & 3670016) | (29360128 & (i4 << 6)), 3840);
                        gapComposer = gapComposer2;
                        z8 = false;
                        gapComposer.end(false);
                    }
                    gapComposer.end(z8);
                } else {
                    if (iOrdinal != 2) {
                        throw Format$$ExternalSyntheticOutline0.m(gapComposer2, 1048601584, false);
                    }
                    gapComposer2.startReplaceGroup(-1850628327);
                    float f3 = jLongValue2;
                    boolean zChanged = gapComposer2.changed(closedFloatRange);
                    Object objRememberedValue3 = gapComposer2.rememberedValue();
                    if (zChanged || objRememberedValue3 == neverEqualPolicy) {
                        i3 = 2;
                        objRememberedValue3 = new SliderState(f3, closedFloatRange, 2);
                        gapComposer2.updateRememberedValue(objRememberedValue3);
                    } else {
                        i3 = 2;
                    }
                    SliderState sliderState = (SliderState) objRememberedValue3;
                    sliderState.setValue(f3);
                    Modifier modifierM137paddingVpY3zN4$default = OffsetKt.m137paddingVpY3zN4$default(companion3, 20.0f, CropImageView.DEFAULT_ASPECT_RATIO, i3);
                    final byte b2 = 1;
                    companion2 = companion3;
                    j2 = jLongValue;
                    j3 = jLongValue2;
                    f2 = 20.0f;
                    i2 = 2;
                    SliderKt.Slider(sliderState, modifierM137paddingVpY3zN4$default, z2, function3, function4, null, null, lambda$1323551451, Expect_jvmKt.rememberComposableLambda(-1686353316, new Function3() { // from class: com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda51
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            byte b3 = b2;
                            Unit unit = Unit.INSTANCE;
                            State state = animateAsStateM18animateDpAsStateAjpBEmI;
                            boolean z13 = z4;
                            switch (b3) {
                                case 0:
                                    SliderState sliderState2 = (SliderState) obj;
                                    Composer composer2 = (Composer) obj2;
                                    int iIntValue = ((Integer) obj3).intValue();
                                    sliderState2.getClass();
                                    if ((iIntValue & 6) == 0) {
                                        iIntValue |= (iIntValue & 8) == 0 ? ((GapComposer) composer2).changed(sliderState2) : ((GapComposer) composer2).changedInstance(sliderState2) ? 4 : 2;
                                    }
                                    GapComposer gapComposer3 = (GapComposer) composer2;
                                    if (!gapComposer3.shouldExecute(iIntValue & 1, (iIntValue & 19) != 18)) {
                                        gapComposer3.skipToGroupEnd();
                                    } else {
                                        MenuKt.m1488PlayerSliderTrackjt2gSs(sliderState2, null, sliderColorsM328colorsq0g_0yA, z13 ? ((Dp) state.getValue()).value : 2.0f, gapComposer3, 8 | (iIntValue & 14), 2);
                                    }
                                    break;
                                default:
                                    SliderState sliderState3 = (SliderState) obj;
                                    Composer composer3 = (Composer) obj2;
                                    int iIntValue2 = ((Integer) obj3).intValue();
                                    sliderState3.getClass();
                                    if ((iIntValue2 & 6) == 0) {
                                        iIntValue2 |= (iIntValue2 & 8) == 0 ? ((GapComposer) composer3).changed(sliderState3) : ((GapComposer) composer3).changedInstance(sliderState3) ? 4 : 2;
                                    }
                                    GapComposer gapComposer4 = (GapComposer) composer3;
                                    if (!gapComposer4.shouldExecute(iIntValue2 & 1, (iIntValue2 & 19) != 18)) {
                                        gapComposer4.skipToGroupEnd();
                                    } else {
                                        MenuKt.m1488PlayerSliderTrackjt2gSs(sliderState3, null, sliderColorsM328colorsq0g_0yA, z13 ? ((Dp) state.getValue()).value : 2.0f, gapComposer4, 8 | (iIntValue2 & 14), 2);
                                    }
                                    break;
                            }
                            return unit;
                        }
                    }, gapComposer2), gapComposer2, 113246216 | ((i4 >> 9) & 896), 96);
                    gapComposer = gapComposer2;
                    gapComposer.end(false);
                }
                f = f2;
                companion = companion2;
            } else {
                i2 = 2;
                j2 = jLongValue;
                gapComposer2.startReplaceGroup(-1853100019);
                float f4 = jLongValue2;
                boolean zChanged2 = gapComposer2.changed(closedFloatRange);
                Object objRememberedValue4 = gapComposer2.rememberedValue();
                if (zChanged2 || objRememberedValue4 == neverEqualPolicy) {
                    objRememberedValue4 = new SliderState(f4, closedFloatRange, 2);
                    gapComposer2.updateRememberedValue(objRememberedValue4);
                }
                SliderState sliderState2 = (SliderState) objRememberedValue4;
                sliderState2.setValue(f4);
                f = 20.0f;
                final byte b3 = 0;
                companion = companion3;
                j3 = jLongValue2;
                SliderKt.Slider(sliderState2, OffsetKt.m137paddingVpY3zN4$default(companion3, 20.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2), z2, function3, function4, sliderColorsM328colorsq0g_0yA, null, Expect_jvmKt.rememberComposableLambda(1360481107, new PlayerKt$$ExternalSyntheticLambda50(z4, animateAsStateAnimateFloatAsState, j4), gapComposer2), Expect_jvmKt.rememberComposableLambda(-1927563500, new Function3() { // from class: com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda51
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        byte b4 = b3;
                        Unit unit = Unit.INSTANCE;
                        State state = animateAsStateM18animateDpAsStateAjpBEmI;
                        boolean z13 = z4;
                        switch (b4) {
                            case 0:
                                SliderState sliderState3 = (SliderState) obj;
                                Composer composer2 = (Composer) obj2;
                                int iIntValue = ((Integer) obj3).intValue();
                                sliderState3.getClass();
                                if ((iIntValue & 6) == 0) {
                                    iIntValue |= (iIntValue & 8) == 0 ? ((GapComposer) composer2).changed(sliderState3) : ((GapComposer) composer2).changedInstance(sliderState3) ? 4 : 2;
                                }
                                GapComposer gapComposer3 = (GapComposer) composer2;
                                if (!gapComposer3.shouldExecute(iIntValue & 1, (iIntValue & 19) != 18)) {
                                    gapComposer3.skipToGroupEnd();
                                } else {
                                    MenuKt.m1488PlayerSliderTrackjt2gSs(sliderState3, null, sliderColorsM328colorsq0g_0yA, z13 ? ((Dp) state.getValue()).value : 2.0f, gapComposer3, 8 | (iIntValue & 14), 2);
                                }
                                break;
                            default:
                                SliderState sliderState4 = (SliderState) obj;
                                Composer composer3 = (Composer) obj2;
                                int iIntValue2 = ((Integer) obj3).intValue();
                                sliderState4.getClass();
                                if ((iIntValue2 & 6) == 0) {
                                    iIntValue2 |= (iIntValue2 & 8) == 0 ? ((GapComposer) composer3).changed(sliderState4) : ((GapComposer) composer3).changedInstance(sliderState4) ? 4 : 2;
                                }
                                GapComposer gapComposer4 = (GapComposer) composer3;
                                if (!gapComposer4.shouldExecute(iIntValue2 & 1, (iIntValue2 & 19) != 18)) {
                                    gapComposer4.skipToGroupEnd();
                                } else {
                                    MenuKt.m1488PlayerSliderTrackjt2gSs(sliderState4, null, sliderColorsM328colorsq0g_0yA, z13 ? ((Dp) state.getValue()).value : 2.0f, gapComposer4, 8 | (iIntValue2 & 14), 2);
                                }
                                break;
                        }
                        return unit;
                    }
                }, gapComposer2), gapComposer2, 113246216 | ((i4 >> 9) & 896), 64);
                gapComposer = gapComposer2;
                gapComposer.end(false);
            }
            OffsetKt.Spacer(gapComposer, SizeKt.m145height3ABfNKs(companion, z4 ? 2.0f : 4.0f));
            FlowRowOverflow flowRowOverflow = OffsetKt.SpaceBetween;
            BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
            Modifier modifierM137paddingVpY3zN4$default2 = OffsetKt.m137paddingVpY3zN4$default(SizeKt.fillMaxWidth(companion, 1.0f), z4 ? 24.0f : f, CropImageView.DEFAULT_ASPECT_RATIO, i2);
            RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(flowRowOverflow, vertical, gapComposer, 54);
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierM137paddingVpY3zN4$default2);
            ComposeUiNode.Companion.getClass();
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(LayoutNode.Constructor);
            } else {
                gapComposer.useNode();
            }
            Stack.m390setimpl(gapComposer, rowMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m389reconcileimpl(gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            String strMakeTimeString = UtilsKt.makeTimeString(Long.valueOf(j3));
            if (z4) {
                gapComposer.startReplaceGroup(-91857318);
                textStyleM750copyp1EtxEg$default = TextStyle.m750copyp1EtxEg$default(CardKt.getTypography(gapComposer).labelSmall, 0L, 0L, FontWeight.Bold, null, null, "tnum", 0L, 0L, null, null, 16777147);
                z6 = false;
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(-91721321);
                textStyleM750copyp1EtxEg$default = TextStyle.m750copyp1EtxEg$default(CardKt.getTypography(gapComposer).labelMedium, 0L, 0L, null, null, null, "tnum", 0L, 0L, null, null, 16777151);
                z6 = false;
                gapComposer.end(false);
            }
            TextStyle textStyle = textStyleM750copyp1EtxEg$default;
            if (z4) {
                gapComposer.startReplaceGroup(-695689930);
                long j5 = CardKt.getColorScheme(gapComposer).onSurface;
                jColor3 = ColorKt.Color(Color.m485getRedimpl(j5), Color.m484getGreenimpl(j5), Color.m482getBlueimpl(j5), 0.6f, Color.m483getColorSpaceimpl(j5));
            } else {
                gapComposer.startReplaceGroup(-695688332);
                jColor3 = CardKt.getColorScheme(gapComposer).onSurfaceVariant;
            }
            gapComposer.end(z6);
            GapComposer gapComposer3 = gapComposer;
            TextKt.m352TextNvy7gAk(strMakeTimeString, null, jColor3, 0L, null, null, null, 0L, null, 0L, 0, false, 1, 0, textStyle, gapComposer3, 0, 24576, 114682);
            if (jLongValue != -9223372036854775807L) {
                if (j2 > 0) {
                    long j6 = j2 - j3;
                    strConcat = "-".concat(UtilsKt.makeTimeString(Long.valueOf(j6 >= 0 ? j6 : 0L)));
                } else {
                    strConcat = "";
                }
            } else {
                strConcat = "";
            }
            String str = strConcat;
            if (z4) {
                gapComposer3.startReplaceGroup(-91161926);
                textStyleM750copyp1EtxEg$default2 = TextStyle.m750copyp1EtxEg$default(CardKt.getTypography(gapComposer3).labelSmall, 0L, 0L, FontWeight.Bold, null, null, "tnum", 0L, 0L, null, null, 16777147);
                z7 = false;
                gapComposer3.end(false);
            } else {
                gapComposer3.startReplaceGroup(-91025929);
                textStyleM750copyp1EtxEg$default2 = TextStyle.m750copyp1EtxEg$default(CardKt.getTypography(gapComposer3).labelMedium, 0L, 0L, null, null, null, "tnum", 0L, 0L, null, null, 16777151);
                z7 = false;
                gapComposer3.end(false);
            }
            TextStyle textStyle2 = textStyleM750copyp1EtxEg$default2;
            if (z4) {
                gapComposer3.startReplaceGroup(-695667498);
                long j7 = CardKt.getColorScheme(gapComposer3).onSurface;
                jColor4 = ColorKt.Color(Color.m485getRedimpl(j7), Color.m484getGreenimpl(j7), Color.m482getBlueimpl(j7), 0.6f, Color.m483getColorSpaceimpl(j7));
            } else {
                gapComposer3.startReplaceGroup(-695665900);
                jColor4 = CardKt.getColorScheme(gapComposer3).onSurfaceVariant;
            }
            gapComposer3.end(z7);
            TextKt.m352TextNvy7gAk(str, null, jColor4, 0L, null, null, null, 0L, null, 0L, 0, false, 1, 0, textStyle2, gapComposer3, 0, 24576, 114682);
            gapComposer2 = gapComposer3;
            gapComposer2.end(true);
        } else {
            gapComposer2.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2(z, function0, function1, mutableState, z2, z3, z4, function2, i) { // from class: com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda53
                public final /* synthetic */ boolean f$1;
                public final /* synthetic */ Function0 f$2;
                public final /* synthetic */ Function0 f$3;
                public final /* synthetic */ MutableState f$4;
                public final /* synthetic */ boolean f$5;
                public final /* synthetic */ boolean f$6;
                public final /* synthetic */ boolean f$8;
                public final /* synthetic */ Function1 f$9;

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(12610945);
                    QueueKt.m1506PlayerProgressSectiongMrHQkA(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$8, this.f$9, (Composer) obj, iUpdateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX INFO: renamed from: Queue-TBEEUPw, reason: not valid java name */
    public static final void m1507QueueTBEEUPw(final BottomSheetState bottomSheetState, final BottomSheetState bottomSheetState2, Modifier modifier, final long j, final long j2, final long j3, final long j4, final long j5, final boolean z, final boolean z2, final Function0 function0, Composer composer, final int i) {
        final Modifier modifier2;
        MutableState mutableStateCollectAsStateWithLifecycle;
        MutableState mutableStateCollectAsStateWithLifecycle2;
        MutableState mutableStateCollectAsStateWithLifecycle3;
        Long l;
        CastConnectionHandler castConnectionHandler;
        PlayerConnection playerConnection;
        MutableState mutableState;
        ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState;
        final boolean z3;
        bottomSheetState.getClass();
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(201748074);
        int i2 = i | (gapComposer.changed(bottomSheetState) ? 4 : 2) | (gapComposer.changed(bottomSheetState2) ? 32 : 16) | 384 | (gapComposer.changed(j) ? 2048 : 1024) | (gapComposer.changed(z) ? 67108864 : 33554432) | (gapComposer.changed(z2) ? 536870912 : WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE);
        byte b = 0;
        if (gapComposer.shouldExecute(i2 & 1, ((301991059 & i2) == 301991058 && (((gapComposer.changedInstance(function0) ? ' ' : (char) 16) | 6) & 17) == 16) ? false : true)) {
            final Context context = (Context) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalContext);
            final HapticFeedback hapticFeedback = (HapticFeedback) gapComposer.consume(CompositionLocalsKt.LocalHapticFeedback);
            final MenuState menuState = (MenuState) gapComposer.consume(BottomSheetMenuKt.LocalMenuState);
            final String strStringResource = MathKt.stringResource(R.string.sleep_timer_default_set, gapComposer);
            final BottomSheetPageState bottomSheetPageState = (BottomSheetPageState) gapComposer.consume(BottomSheetPageKt.LocalBottomSheetPageState);
            ListenTogetherManager listenTogetherManager = (ListenTogetherManager) gapComposer.consume(MainActivityKt.LocalListenTogetherManager);
            ReadonlyStateFlow readonlyStateFlow = listenTogetherManager != null ? listenTogetherManager.role : null;
            if (readonlyStateFlow == null) {
                gapComposer.startReplaceGroup(1618607387);
                gapComposer.end(false);
                mutableStateCollectAsStateWithLifecycle = null;
            } else {
                gapComposer.startReplaceGroup(606402470);
                mutableStateCollectAsStateWithLifecycle = FileSystemsKt.collectAsStateWithLifecycle(readonlyStateFlow, RoomRole.NONE, gapComposer, 48);
                gapComposer.end(false);
            }
            final boolean z4 = (mutableStateCollectAsStateWithLifecycle != null ? (RoomRole) mutableStateCollectAsStateWithLifecycle.getValue() : null) == RoomRole.GUEST;
            PlayerConnection playerConnection2 = (PlayerConnection) gapComposer.consume(MainActivityKt.LocalPlayerConnection);
            if (playerConnection2 == null) {
                RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new Function2(bottomSheetState2, j, j2, j3, j4, j5, z, z2, function0, i) { // from class: com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda1
                        public final /* synthetic */ BottomSheetState f$1;
                        public final /* synthetic */ Function0 f$11;
                        public final /* synthetic */ long f$3;
                        public final /* synthetic */ long f$4;
                        public final /* synthetic */ long f$5;
                        public final /* synthetic */ long f$6;
                        public final /* synthetic */ long f$7;
                        public final /* synthetic */ boolean f$8;
                        public final /* synthetic */ boolean f$9;

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            ((Integer) obj2).getClass();
                            int iUpdateChangedFlags = Stack.updateChangedFlags(1);
                            QueueKt.m1507QueueTBEEUPw(this.f$0, this.f$1, Modifier.Companion.$$INSTANCE, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, this.f$8, this.f$9, this.f$11, (Composer) obj, iUpdateChangedFlags);
                            return Unit.INSTANCE;
                        }
                    };
                    return;
                }
                return;
            }
            MusicService musicService = playerConnection2.service;
            final MutableState mutableStateCollectAsStateWithLifecycle4 = FileSystemsKt.collectAsStateWithLifecycle(playerConnection2.isEffectivelyPlaying, gapComposer);
            final MutableState mutableStateCollectAsStateWithLifecycle5 = FileSystemsKt.collectAsStateWithLifecycle(playerConnection2.repeatMode, gapComposer);
            final MutableState mutableStateCollectAsStateWithLifecycle6 = FileSystemsKt.collectAsStateWithLifecycle(playerConnection2.currentWindowIndex, gapComposer);
            final MutableState mutableStateCollectAsStateWithLifecycle7 = FileSystemsKt.collectAsStateWithLifecycle(playerConnection2.mediaMetadata, gapComposer);
            FileSystemsKt.collectAsStateWithLifecycle(playerConnection2.currentFormat, null, gapComposer, 48);
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer);
            }
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer);
            }
            boolean zChanged = gapComposer.changed(playerConnection2);
            Object objRememberedValue3 = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue3 == neverEqualPolicy) {
                try {
                    objRememberedValue3 = musicService.castConnectionHandler;
                } catch (Exception unused) {
                    objRememberedValue3 = null;
                }
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            CastConnectionHandler castConnectionHandler2 = (CastConnectionHandler) objRememberedValue3;
            StateFlowImpl stateFlowImpl = castConnectionHandler2 != null ? castConnectionHandler2.isCasting : null;
            if (stateFlowImpl == null) {
                gapComposer.startReplaceGroup(1619820634);
                gapComposer.end(false);
                mutableStateCollectAsStateWithLifecycle2 = null;
            } else {
                gapComposer.startReplaceGroup(606441607);
                mutableStateCollectAsStateWithLifecycle2 = FileSystemsKt.collectAsStateWithLifecycle(stateFlowImpl, gapComposer);
                gapComposer.end(false);
            }
            if (mutableStateCollectAsStateWithLifecycle2 == null) {
                gapComposer.startReplaceGroup(1619853526);
                Object objRememberedValue4 = gapComposer.rememberedValue();
                if (objRememberedValue4 == neverEqualPolicy) {
                    objRememberedValue4 = Stack.mutableStateOf$default(Boolean.FALSE);
                    gapComposer.updateRememberedValue(objRememberedValue4);
                }
                mutableStateCollectAsStateWithLifecycle2 = (MutableState) objRememberedValue4;
            } else {
                gapComposer.startReplaceGroup(606440901);
            }
            gapComposer.end(false);
            final MutableState mutableState2 = mutableStateCollectAsStateWithLifecycle2;
            StateFlowImpl stateFlowImpl2 = castConnectionHandler2 != null ? castConnectionHandler2.castIsPlaying : null;
            if (stateFlowImpl2 == null) {
                gapComposer.startReplaceGroup(1619940666);
                gapComposer.end(false);
                mutableStateCollectAsStateWithLifecycle3 = null;
            } else {
                gapComposer.startReplaceGroup(606445479);
                mutableStateCollectAsStateWithLifecycle3 = FileSystemsKt.collectAsStateWithLifecycle(stateFlowImpl2, gapComposer);
                gapComposer.end(false);
            }
            if (mutableStateCollectAsStateWithLifecycle3 == null) {
                gapComposer.startReplaceGroup(1619973558);
                Object objRememberedValue5 = gapComposer.rememberedValue();
                if (objRememberedValue5 == neverEqualPolicy) {
                    objRememberedValue5 = Stack.mutableStateOf$default(Boolean.FALSE);
                    gapComposer.updateRememberedValue(objRememberedValue5);
                }
                mutableStateCollectAsStateWithLifecycle3 = (MutableState) objRememberedValue5;
            } else {
                gapComposer.startReplaceGroup(606444649);
            }
            gapComposer.end(false);
            final MutableState mutableState3 = mutableStateCollectAsStateWithLifecycle3;
            Object[] objArr = new Object[0];
            Object objRememberedValue6 = gapComposer.rememberedValue();
            if (objRememberedValue6 == neverEqualPolicy) {
                objRememberedValue6 = new QueueKt$$ExternalSyntheticLambda2(b);
                gapComposer.updateRememberedValue(objRememberedValue6);
            }
            MutableState mutableState4 = (MutableState) SaverKt.rememberSaveable(objArr, (Function0) objRememberedValue6, gapComposer, 48);
            Object[] objArr2 = new Object[0];
            Object objRememberedValue7 = gapComposer.rememberedValue();
            if (objRememberedValue7 == neverEqualPolicy) {
                objRememberedValue7 = new QueueKt$$ExternalSyntheticLambda3(b);
                gapComposer.updateRememberedValue(objRememberedValue7);
            }
            Function2 function2 = (Function2) objRememberedValue7;
            Object objRememberedValue8 = gapComposer.rememberedValue();
            if (objRememberedValue8 == neverEqualPolicy) {
                objRememberedValue8 = new QueueKt$$ExternalSyntheticLambda4(b);
                gapComposer.updateRememberedValue(objRememberedValue8);
            }
            CallbackWrapper callbackWrapperListSaver = SaverKt.listSaver(function2, (Function1) objRememberedValue8);
            Object objRememberedValue9 = gapComposer.rememberedValue();
            if (objRememberedValue9 == neverEqualPolicy) {
                objRememberedValue9 = new QueueKt$$ExternalSyntheticLambda2((byte) 22);
                gapComposer.updateRememberedValue(objRememberedValue9);
            }
            final List list = (List) SaverKt.m393rememberSaveable(objArr2, (Saver) callbackWrapperListSaver, (Function0) objRememberedValue9, (Composer) gapComposer, 384);
            boolean zChanged2 = gapComposer.changed(mutableState4) | gapComposer.changedInstance(list);
            Object objRememberedValue10 = gapComposer.rememberedValue();
            if (zChanged2 || objRememberedValue10 == neverEqualPolicy) {
                objRememberedValue10 = new QueueKt$$ExternalSyntheticLambda6(list, mutableState4, (byte) 0);
                gapComposer.updateRememberedValue(objRememberedValue10);
            }
            final Function0 function1 = (Function0) objRememberedValue10;
            if (((Boolean) mutableState4.getValue()).booleanValue()) {
                gapComposer.startReplaceGroup(1620467295);
                coil3.util.UtilsKt.BackHandler(false, function1, gapComposer, 0, 1);
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(1620522072);
                gapComposer.end(false);
            }
            Preferences$Key preferences$Key = PreferenceKeysKt.QueueEditLockKey;
            Boolean bool = Boolean.TRUE;
            final DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference = UtilsKt.rememberPreference(preferences$Key, bool, gapComposer, 48);
            ((Boolean) UtilsKt.rememberPreference(PreferenceKeysKt.UseNewPlayerDesignKey, bool, gapComposer, 48).$state.getValue()).getClass();
            Object objRememberedValue11 = gapComposer.rememberedValue();
            if (objRememberedValue11 == neverEqualPolicy) {
                objRememberedValue11 = new SnackbarHostState();
                gapComposer.updateRememberedValue(objRememberedValue11);
            }
            final SnackbarHostState snackbarHostState = (SnackbarHostState) objRememberedValue11;
            Object objRememberedValue12 = gapComposer.rememberedValue();
            if (objRememberedValue12 == neverEqualPolicy) {
                objRememberedValue12 = Stack.mutableStateOf$default(null);
                gapComposer.updateRememberedValue(objRememberedValue12);
            }
            final MutableState mutableState5 = (MutableState) objRememberedValue12;
            Object objRememberedValue13 = gapComposer.rememberedValue();
            if (objRememberedValue13 == neverEqualPolicy) {
                objRememberedValue13 = Stack.createCompositionCoroutineScope(gapComposer);
                gapComposer.updateRememberedValue(objRememberedValue13);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue13;
            Object objRememberedValue14 = gapComposer.rememberedValue();
            if (objRememberedValue14 == neverEqualPolicy) {
                objRememberedValue14 = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer.updateRememberedValue(objRememberedValue14);
            }
            final MutableState mutableState6 = (MutableState) objRememberedValue14;
            final DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference2 = UtilsKt.rememberPreference(PreferenceKeysKt.SleepTimerDefaultKey, Float.valueOf(30.0f), gapComposer, 48);
            Object objRememberedValue15 = gapComposer.rememberedValue();
            if (objRememberedValue15 == neverEqualPolicy) {
                objRememberedValue15 = Format$$ExternalSyntheticOutline0.m(((Number) dataStoreKt$rememberPreference$1$1RememberPreference2.getValue()).floatValue(), gapComposer);
            }
            final ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = (ParcelableSnapshotMutableFloatState) objRememberedValue15;
            Object objRememberedValue16 = gapComposer.rememberedValue();
            if (objRememberedValue16 == neverEqualPolicy) {
                objRememberedValue16 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new QueueKt$$ExternalSyntheticLambda7(parcelableSnapshotMutableFloatState, dataStoreKt$rememberPreference$1$1RememberPreference2, b));
                gapComposer.updateRememberedValue(objRememberedValue16);
            }
            final State state = (State) objRememberedValue16;
            Float fValueOf = Float.valueOf(((Number) dataStoreKt$rememberPreference$1$1RememberPreference2.getValue()).floatValue());
            boolean zChanged3 = gapComposer.changed(dataStoreKt$rememberPreference$1$1RememberPreference2);
            Object objRememberedValue17 = gapComposer.rememberedValue();
            if (zChanged3 || objRememberedValue17 == neverEqualPolicy) {
                l = null;
                objRememberedValue17 = new QueueKt$Queue$2$1(dataStoreKt$rememberPreference$1$1RememberPreference2, parcelableSnapshotMutableFloatState, null, (byte) 0);
                gapComposer.updateRememberedValue(objRememberedValue17);
            } else {
                l = null;
            }
            Stack.LaunchedEffect(gapComposer, fValueOf, (Function2) objRememberedValue17);
            Preferences$Key preferences$Key2 = PreferenceKeysKt.SleepTimerStopAfterCurrentSongKey;
            Boolean bool2 = Boolean.FALSE;
            final DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference3 = UtilsKt.rememberPreference(preferences$Key2, bool2, gapComposer, 48);
            final DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference4 = UtilsKt.rememberPreference(PreferenceKeysKt.SleepTimerFadeOutKey, bool2, gapComposer, 48);
            SleepTimer sleepTimer = musicService.sleepTimer;
            Long lValueOf = sleepTimer != null ? Long.valueOf(sleepTimer.triggerTime$delegate.getLongValue()) : l;
            SleepTimer sleepTimer2 = musicService.sleepTimer;
            boolean zChanged4 = gapComposer.changed(lValueOf) | gapComposer.changed(sleepTimer2 != null ? Boolean.valueOf(sleepTimer2.getPauseWhenSongEnd()) : l);
            Object objRememberedValue18 = gapComposer.rememberedValue();
            if (zChanged4 || objRememberedValue18 == neverEqualPolicy) {
                SleepTimer sleepTimer3 = musicService.sleepTimer;
                objRememberedValue18 = Boolean.valueOf(sleepTimer3 != null ? sleepTimer3.isActive() : false);
                gapComposer.updateRememberedValue(objRememberedValue18);
            }
            Boolean bool3 = (Boolean) objRememberedValue18;
            boolean zBooleanValue = bool3.booleanValue();
            Object objRememberedValue19 = gapComposer.rememberedValue();
            if (objRememberedValue19 == neverEqualPolicy) {
                objRememberedValue19 = new ParcelableSnapshotMutableLongState(0L);
                gapComposer.updateRememberedValue(objRememberedValue19);
            }
            ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState2 = (ParcelableSnapshotMutableLongState) objRememberedValue19;
            boolean zChanged5 = gapComposer.changed(zBooleanValue) | gapComposer.changedInstance(playerConnection2);
            Object objRememberedValue20 = gapComposer.rememberedValue();
            if (zChanged5 || objRememberedValue20 == neverEqualPolicy) {
                castConnectionHandler = castConnectionHandler2;
                playerConnection = playerConnection2;
                mutableState = mutableState4;
                parcelableSnapshotMutableLongState = parcelableSnapshotMutableLongState2;
                QueueKt$Queue$3$1 queueKt$Queue$3$1 = new QueueKt$Queue$3$1(zBooleanValue, playerConnection, parcelableSnapshotMutableLongState, null, (byte) 0);
                z3 = zBooleanValue;
                gapComposer.updateRememberedValue(queueKt$Queue$3$1);
                objRememberedValue20 = queueKt$Queue$3$1;
            } else {
                playerConnection = playerConnection2;
                mutableState = mutableState4;
                z3 = zBooleanValue;
                castConnectionHandler = castConnectionHandler2;
                parcelableSnapshotMutableLongState = parcelableSnapshotMutableLongState2;
            }
            Stack.LaunchedEffect(gapComposer, bool3, (Function2) objRememberedValue20);
            final ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState3 = parcelableSnapshotMutableLongState;
            final PlayerConnection playerConnection3 = playerConnection;
            Function3 function3 = new Function3() { // from class: com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Modifier modifierGlass;
                    String strM;
                    PlayerConnection playerConnection4;
                    ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState2;
                    Composer composer2 = (Composer) obj2;
                    int iIntValue = ((Integer) obj3).intValue();
                    ((BoxScope) obj).getClass();
                    GapComposer gapComposer2 = (GapComposer) composer2;
                    if (gapComposer2.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                        BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
                        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                        Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                        WeakHashMap weakHashMap = WindowInsetsHolder.viewMap;
                        Modifier modifierM145height3ABfNKs = SizeKt.m145height3ABfNKs(OffsetKt.m136paddingVpY3zN4(OffsetKt.windowInsetsPadding(modifierFillMaxWidth, new LimitInsets(OffsetKt.current(gapComposer2).systemBars, 47)), 20.0f, 6.0f), UiStyleKt.isGlassStyle(gapComposer2) ? 60.0f : 52.0f);
                        if (UiStyleKt.isGlassStyle(gapComposer2)) {
                            gapComposer2.startReplaceGroup(-1255863424);
                            gapComposer2.end(false);
                            modifierGlass = companion;
                        } else {
                            gapComposer2.startReplaceGroup(-1255862650);
                            modifierGlass = GlassComponentsKt.glass(companion, GlassComponentsKt.m1480glassShapeixp7dh8(30.0f, 12.0f, gapComposer2), true, gapComposer2, 390, 0);
                            gapComposer2.end(false);
                        }
                        Modifier modifierThen = modifierM145height3ABfNKs.then(modifierGlass);
                        RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(OffsetKt.Start, vertical, gapComposer2, 48);
                        int iHashCode = Long.hashCode(gapComposer2.compositeKeyHashCode);
                        PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer2, modifierThen);
                        ComposeUiNode.Companion.getClass();
                        gapComposer2.startReusableNode();
                        if (gapComposer2.inserting) {
                            gapComposer2.createNode(LayoutNode.Constructor);
                        } else {
                            gapComposer2.useNode();
                        }
                        Stack.m390setimpl(gapComposer2, rowMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                        Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                        Stack.m390setimpl(gapComposer2, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
                        Stack.m389reconcileimpl(gapComposer2);
                        Stack.m390setimpl(gapComposer2, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                        String strStringResource2 = MathKt.stringResource(R.string.lyrics, gapComposer2);
                        boolean zIsGlassStyle = UiStyleKt.isGlassStyle(gapComposer2);
                        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                        Modifier modifierWeight = rowScopeInstance.weight(companion, 1.0f, true);
                        Function0 function4 = function0;
                        boolean zChanged6 = gapComposer2.changed(function4);
                        Object objRememberedValue21 = gapComposer2.rememberedValue();
                        NeverEqualPolicy neverEqualPolicy2 = Composer.Companion.Empty;
                        if (zChanged6 || objRememberedValue21 == neverEqualPolicy2) {
                            objRememberedValue21 = new Handshake$$ExternalSyntheticLambda0(function4, (byte) 17);
                            gapComposer2.updateRememberedValue(objRememberedValue21);
                        }
                        QueueKt.QueueStripAction(R.drawable.lyrics, strStringResource2, z2, (Function0) objRememberedValue21, modifierWeight, false, zIsGlassStyle, gapComposer2, 0, 32);
                        String strStringResource3 = MathKt.stringResource(R.string.queue, gapComposer2);
                        boolean zIsGlassStyle2 = UiStyleKt.isGlassStyle(gapComposer2);
                        Modifier modifierWeight2 = rowScopeInstance.weight(companion, 1.0f, true);
                        BottomSheetState bottomSheetState3 = bottomSheetState;
                        boolean zChanged7 = gapComposer2.changed(bottomSheetState3);
                        Object objRememberedValue22 = gapComposer2.rememberedValue();
                        if (zChanged7 || objRememberedValue22 == neverEqualPolicy2) {
                            objRememberedValue22 = new PlayerKt$$ExternalSyntheticLambda0(bottomSheetState3, (byte) 10);
                            gapComposer2.updateRememberedValue(objRememberedValue22);
                        }
                        QueueKt.QueueStripAction(R.drawable.queue_music, strStringResource3, false, (Function0) objRememberedValue22, modifierWeight2, false, zIsGlassStyle2, gapComposer2, 384, 32);
                        String strStringResource4 = MathKt.stringResource(R.string.share, gapComposer2);
                        boolean zIsGlassStyle3 = UiStyleKt.isGlassStyle(gapComposer2);
                        Modifier modifierWeight3 = rowScopeInstance.weight(companion, 1.0f, true);
                        State state2 = mutableStateCollectAsStateWithLifecycle7;
                        boolean zChanged8 = gapComposer2.changed(state2);
                        Context context2 = context;
                        boolean zChangedInstance = zChanged8 | gapComposer2.changedInstance(context2);
                        Object objRememberedValue23 = gapComposer2.rememberedValue();
                        if (zChangedInstance || objRememberedValue23 == neverEqualPolicy2) {
                            objRememberedValue23 = new ComponentRegistry$Builder$$ExternalSyntheticLambda2(state2, context2, (byte) 29);
                            gapComposer2.updateRememberedValue(objRememberedValue23);
                        }
                        QueueKt.QueueStripAction(R.drawable.share, strStringResource4, false, (Function0) objRememberedValue23, modifierWeight3, false, zIsGlassStyle3, gapComposer2, 384, 32);
                        final boolean z5 = z3;
                        if (z5) {
                            gapComposer2.startReplaceGroup(494361164);
                            gapComposer2.end(false);
                            strM = UtilsKt.makeTimeString(Long.valueOf(parcelableSnapshotMutableLongState3.getLongValue()));
                        } else {
                            strM = Format$$ExternalSyntheticOutline0.m(gapComposer2, 494456458, R.string.sleep_timer, gapComposer2, false);
                        }
                        String str = strM;
                        final boolean z6 = z4;
                        boolean z7 = !z6;
                        boolean zIsGlassStyle4 = UiStyleKt.isGlassStyle(gapComposer2);
                        Modifier modifierWeight4 = rowScopeInstance.weight(companion, 1.0f, true);
                        boolean zChanged9 = gapComposer2.changed(z6) | gapComposer2.changed(z5);
                        final PlayerConnection playerConnection5 = playerConnection3;
                        boolean zChangedInstance2 = zChanged9 | gapComposer2.changedInstance(playerConnection5);
                        Object objRememberedValue24 = gapComposer2.rememberedValue();
                        final MutableState mutableState7 = mutableState6;
                        if (zChangedInstance2 || objRememberedValue24 == neverEqualPolicy2) {
                            objRememberedValue24 = new Function0() { // from class: com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda13
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    if (!z6) {
                                        if (z5) {
                                            SleepTimer sleepTimer4 = playerConnection5.service.sleepTimer;
                                            if (sleepTimer4 != null) {
                                                StandaloneCoroutine standaloneCoroutine = sleepTimer4.sleepTimerJob;
                                                if (standaloneCoroutine != null) {
                                                    standaloneCoroutine.cancel(null);
                                                }
                                                sleepTimer4.sleepTimerJob = null;
                                                sleepTimer4.setPauseWhenSongEnd(false);
                                                sleepTimer4.setStopAfterCurrentSongOnTimeout(false);
                                                sleepTimer4.fadeOutEnabled$delegate.setValue(Boolean.FALSE);
                                                sleepTimer4.triggerTime$delegate.setLongValue(-1L);
                                                sleepTimer4.onVolumeMultiplierChanged.invoke(Float.valueOf(1.0f));
                                            }
                                        } else {
                                            mutableState7.setValue(Boolean.TRUE);
                                        }
                                    }
                                    return Unit.INSTANCE;
                                }
                            };
                            gapComposer2.updateRememberedValue(objRememberedValue24);
                        }
                        QueueKt.QueueStripAction(R.drawable.bedtime, str, z5, (Function0) objRememberedValue24, modifierWeight4, z7, zIsGlassStyle4, gapComposer2, 0, 0);
                        gapComposer2.end(true);
                        if (((Boolean) mutableState7.getValue()).booleanValue()) {
                            gapComposer2.startReplaceGroup(-274239385);
                            ComposableLambdaImpl composableLambdaImpl = QueueKt.lambda$1790970603;
                            Object objRememberedValue25 = gapComposer2.rememberedValue();
                            if (objRememberedValue25 == neverEqualPolicy2) {
                                objRememberedValue25 = new PlayerKt$$ExternalSyntheticLambda7(mutableState7, (byte) 4);
                                gapComposer2.updateRememberedValue(objRememberedValue25);
                            }
                            Function0 function5 = (Function0) objRememberedValue25;
                            boolean zChangedInstance3 = gapComposer2.changedInstance(playerConnection5);
                            MutableState mutableState8 = dataStoreKt$rememberPreference$1$1RememberPreference3;
                            boolean zChanged10 = zChangedInstance3 | gapComposer2.changed(mutableState8);
                            MutableState mutableState9 = dataStoreKt$rememberPreference$1$1RememberPreference4;
                            boolean zChanged11 = zChanged10 | gapComposer2.changed(mutableState9);
                            Object objRememberedValue26 = gapComposer2.rememberedValue();
                            ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState3 = parcelableSnapshotMutableFloatState;
                            if (zChanged11 || objRememberedValue26 == neverEqualPolicy2) {
                                playerConnection4 = playerConnection5;
                                objRememberedValue26 = new QueueKt$$ExternalSyntheticLambda15(playerConnection4, mutableState7, parcelableSnapshotMutableFloatState3, mutableState8, mutableState9, (byte) 0);
                                parcelableSnapshotMutableFloatState2 = parcelableSnapshotMutableFloatState3;
                                gapComposer2.updateRememberedValue(objRememberedValue26);
                            } else {
                                playerConnection4 = playerConnection5;
                                parcelableSnapshotMutableFloatState2 = parcelableSnapshotMutableFloatState3;
                            }
                            Function0 function6 = (Function0) objRememberedValue26;
                            DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1 = dataStoreKt$rememberPreference$1$1RememberPreference2;
                            boolean zChanged12 = gapComposer2.changed(dataStoreKt$rememberPreference$1$1);
                            Object objRememberedValue27 = gapComposer2.rememberedValue();
                            if (zChanged12 || objRememberedValue27 == neverEqualPolicy2) {
                                objRememberedValue27 = new QueueKt$$ExternalSyntheticLambda16(dataStoreKt$rememberPreference$1$1, parcelableSnapshotMutableFloatState2, (byte) 0);
                                gapComposer2.updateRememberedValue(objRememberedValue27);
                            }
                            Function0 function7 = (Function0) objRememberedValue27;
                            Object objRememberedValue28 = gapComposer2.rememberedValue();
                            if (objRememberedValue28 == neverEqualPolicy2) {
                                objRememberedValue28 = new PlayerKt$$ExternalSyntheticLambda7(mutableState7, (byte) 5);
                                gapComposer2.updateRememberedValue(objRememberedValue28);
                            }
                            DialogKt.ActionPromptDialog(null, composableLambdaImpl, function5, function6, function7, (Function0) objRememberedValue28, Expect_jvmKt.rememberComposableLambda(1300829400, new SongMenuKt$$ExternalSyntheticLambda8(parcelableSnapshotMutableFloatState2, coroutineScope, context2, strStringResource, playerConnection4, state, mutableState7), gapComposer2), gapComposer2, 1769904, 1);
                            gapComposer2.end(false);
                        } else {
                            gapComposer2.startReplaceGroup(-268639638);
                            gapComposer2.end(false);
                        }
                    } else {
                        gapComposer2.skipToGroupEnd();
                    }
                    return Unit.INSTANCE;
                }
            };
            final boolean z5 = z4;
            final CastConnectionHandler castConnectionHandler3 = castConnectionHandler;
            final MutableState mutableState7 = mutableState;
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            DialogKt.BottomSheet(bottomSheetState, companion, lambda$987304698, null, Expect_jvmKt.rememberComposableLambda(114894136, function3, gapComposer), false, Expect_jvmKt.rememberComposableLambda(-757516426, new Function3() { // from class: com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    ReorderableLazyListState reorderableLazyListState;
                    MutableState mutableState8;
                    boolean z6;
                    Modifier modifierM1478glassBlur942rkJo;
                    Object obj4;
                    Modifier.Companion companion2;
                    final boolean z7;
                    final CoroutineScope coroutineScope2;
                    SnapshotStateList snapshotStateList;
                    MutableState mutableState9;
                    PlayerConnection playerConnection4;
                    long j6;
                    byte b2;
                    BoxScope boxScope = (BoxScope) obj;
                    Composer composer2 = (Composer) obj2;
                    int iIntValue = ((Integer) obj3).intValue();
                    boxScope.getClass();
                    if ((iIntValue & 6) == 0) {
                        iIntValue |= ((GapComposer) composer2).changed(boxScope) ? 4 : 2;
                    }
                    GapComposer gapComposer2 = (GapComposer) composer2;
                    if (gapComposer2.shouldExecute(iIntValue & 1, (iIntValue & 19) != 18)) {
                        final PlayerConnection playerConnection5 = playerConnection3;
                        MutableState mutableStateCollectAsStateWithLifecycle8 = FileSystemsKt.collectAsStateWithLifecycle(playerConnection5.queueTitle, gapComposer2);
                        MutableState mutableStateCollectAsStateWithLifecycle9 = FileSystemsKt.collectAsStateWithLifecycle(playerConnection5.queueWindows, gapComposer2);
                        final MutableState mutableStateCollectAsStateWithLifecycle10 = FileSystemsKt.collectAsStateWithLifecycle(playerConnection5.service.automixItems, gapComposer2);
                        Object objRememberedValue21 = gapComposer2.rememberedValue();
                        NeverEqualPolicy neverEqualPolicy2 = Composer.Companion.Empty;
                        if (objRememberedValue21 == neverEqualPolicy2) {
                            objRememberedValue21 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer2);
                        }
                        final SnapshotStateList snapshotStateList2 = (SnapshotStateList) objRememberedValue21;
                        boolean zChanged6 = gapComposer2.changed((List) mutableStateCollectAsStateWithLifecycle9.getValue());
                        Object objRememberedValue22 = gapComposer2.rememberedValue();
                        if (zChanged6 || objRememberedValue22 == neverEqualPolicy2) {
                            Iterator it = ((List) mutableStateCollectAsStateWithLifecycle9.getValue()).iterator();
                            int i3 = 0;
                            while (it.hasNext()) {
                                MediaItem mediaItem = ((Timeline.Window) it.next()).mediaItem;
                                mediaItem.getClass();
                                MediaMetadata metadata = UuidKt.getMetadata(mediaItem);
                                metadata.getClass();
                                i3 += metadata.duration;
                            }
                            objRememberedValue22 = Integer.valueOf(i3);
                            gapComposer2.updateRememberedValue(objRememberedValue22);
                        }
                        int iIntValue2 = ((Number) objRememberedValue22).intValue();
                        Object objRememberedValue23 = gapComposer2.rememberedValue();
                        if (objRememberedValue23 == neverEqualPolicy2) {
                            objRememberedValue23 = Stack.createCompositionCoroutineScope(gapComposer2);
                            gapComposer2.updateRememberedValue(objRememberedValue23);
                        }
                        CoroutineScope coroutineScope3 = (CoroutineScope) objRememberedValue23;
                        LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(gapComposer2);
                        Object objRememberedValue24 = gapComposer2.rememberedValue();
                        if (objRememberedValue24 == neverEqualPolicy2) {
                            objRememberedValue24 = Stack.mutableStateOf$default(null);
                            gapComposer2.updateRememberedValue(objRememberedValue24);
                        }
                        MutableState mutableState10 = (MutableState) objRememberedValue24;
                        final State state2 = mutableStateCollectAsStateWithLifecycle6;
                        boolean zChanged7 = gapComposer2.changed(((Number) state2.getValue()).intValue()) | gapComposer2.changed((List) mutableStateCollectAsStateWithLifecycle9.getValue());
                        Object objRememberedValue25 = gapComposer2.rememberedValue();
                        if (zChanged7 || objRememberedValue25 == neverEqualPolicy2) {
                            int size = ((List) mutableStateCollectAsStateWithLifecycle9.getValue()).size();
                            int iIntValue3 = ((Number) state2.getValue()).intValue();
                            Object obj5 = (iIntValue3 < 0 || iIntValue3 >= size) ? null : ((Timeline.Window) ((List) mutableStateCollectAsStateWithLifecycle9.getValue()).get(((Number) state2.getValue()).intValue())).uid;
                            gapComposer2.updateRememberedValue(obj5);
                            objRememberedValue25 = obj5;
                        }
                        WeakHashMap weakHashMap = WindowInsetsHolder.viewMap;
                        AndroidWindowInsets androidWindowInsets = OffsetKt.current(gapComposer2).systemBars;
                        SpringSpec springSpec = DimensionsKt.NavigationBarAnimationSpec;
                        InsetsPaddingValues insetsPaddingValuesAsPaddingValues = OffsetKt.asPaddingValues(new AddedInsets(androidWindowInsets, OffsetKt.m129WindowInsetsa9UjIt4$default(64.0f, 64.0f, 5)), gapComposer2);
                        Object objRememberedValue26 = gapComposer2.rememberedValue();
                        if (objRememberedValue26 == neverEqualPolicy2) {
                            objRememberedValue26 = new QueueKt$Queue$5$reorderableState$1$1(snapshotStateList2, mutableState10, null, (byte) 0);
                            gapComposer2.updateRememberedValue(objRememberedValue26);
                        }
                        ReorderableLazyListState reorderableLazyListStateM1880rememberReorderableLazyListStateTN_CM5M = CharsKt.m1880rememberReorderableLazyListStateTN_CM5M(lazyListStateRememberLazyListState, insetsPaddingValuesAsPaddingValues, (Function4) objRememberedValue26, gapComposer2, 12);
                        Boolean boolValueOf = Boolean.valueOf(reorderableLazyListStateM1880rememberReorderableLazyListStateTN_CM5M.isAnyItemDragging());
                        boolean zChanged8 = gapComposer2.changed(reorderableLazyListStateM1880rememberReorderableLazyListStateTN_CM5M) | gapComposer2.changed(mutableStateCollectAsStateWithLifecycle9) | gapComposer2.changedInstance(playerConnection5);
                        Object objRememberedValue27 = gapComposer2.rememberedValue();
                        if (zChanged8 || objRememberedValue27 == neverEqualPolicy2) {
                            reorderableLazyListState = reorderableLazyListStateM1880rememberReorderableLazyListStateTN_CM5M;
                            QueueKt$Queue$5$1$1 queueKt$Queue$5$1$1 = new QueueKt$Queue$5$1$1(reorderableLazyListState, mutableState10, playerConnection5, mutableStateCollectAsStateWithLifecycle9, (Continuation) null);
                            mutableState8 = mutableStateCollectAsStateWithLifecycle9;
                            gapComposer2.updateRememberedValue(queueKt$Queue$5$1$1);
                            objRememberedValue27 = queueKt$Queue$5$1$1;
                        } else {
                            reorderableLazyListState = reorderableLazyListStateM1880rememberReorderableLazyListStateTN_CM5M;
                            mutableState8 = mutableStateCollectAsStateWithLifecycle9;
                        }
                        Stack.LaunchedEffect(gapComposer2, boolValueOf, (Function2) objRememberedValue27);
                        List list2 = (List) mutableState8.getValue();
                        boolean zChanged9 = gapComposer2.changed(mutableState8);
                        Object objRememberedValue28 = gapComposer2.rememberedValue();
                        if (zChanged9 || objRememberedValue28 == neverEqualPolicy2) {
                            objRememberedValue28 = new QueueKt$Queue$5$2$1(snapshotStateList2, mutableState8, null, (byte) 0);
                            gapComposer2.updateRememberedValue(objRememberedValue28);
                        }
                        Stack.LaunchedEffect(gapComposer2, list2, (Function2) objRememberedValue28);
                        Integer numValueOf = Integer.valueOf(((Number) state2.getValue()).intValue());
                        boolean zChanged10 = gapComposer2.changed(state2) | gapComposer2.changed(lazyListStateRememberLazyListState);
                        Object objRememberedValue29 = gapComposer2.rememberedValue();
                        if (zChanged10 || objRememberedValue29 == neverEqualPolicy2) {
                            objRememberedValue29 = new DataStoreKt$get$1(lazyListStateRememberLazyListState, state2, (Continuation) null, (byte) 4);
                            gapComposer2.updateRememberedValue(objRememberedValue29);
                        }
                        Stack.LaunchedEffect(snapshotStateList2, numValueOf, (Function2) objRememberedValue29, gapComposer2);
                        FillElement fillElement = SizeKt.FillWholeMaxSize;
                        boolean zIsGlassStyle = UiStyleKt.isGlassStyle(gapComposer2);
                        RectangleShapeKt$RectangleShape$1 rectangleShapeKt$RectangleShape$1 = ColorKt.RectangleShape;
                        Modifier.Companion companion3 = Modifier.Companion.$$INSTANCE;
                        if (zIsGlassStyle) {
                            gapComposer2.startReplaceGroup(-1409981556);
                            Modifier modifierAmbientGlow = GlassComponentsKt.ambientGlow(gapComposer2, ImageKt.m39backgroundbw27NRU(ClipKt.clip(companion3, GlassComponentsKt.m1482glassTopShapeixp7dh8(CropImageView.DEFAULT_ASPECT_RATIO, gapComposer2)), ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.surface, rectangleShapeKt$RectangleShape$1));
                            z6 = false;
                            gapComposer2.end(false);
                            modifierM1478glassBlur942rkJo = modifierAmbientGlow;
                        } else {
                            z6 = false;
                            gapComposer2.startReplaceGroup(-1409726426);
                            modifierM1478glassBlur942rkJo = GlassComponentsKt.m1478glassBlur942rkJo(companion3, GlassComponentsKt.m1482glassTopShapeixp7dh8(CropImageView.DEFAULT_ASPECT_RATIO, gapComposer2), gapComposer2, 6);
                            gapComposer2.end(false);
                        }
                        Modifier modifierThen = fillElement.then(modifierM1478glassBlur942rkJo);
                        BiasAlignment biasAlignment = Alignment.Companion.TopStart;
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, z6);
                        int iHashCode = Long.hashCode(gapComposer2.compositeKeyHashCode);
                        PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer2, modifierThen);
                        ComposeUiNode.Companion.getClass();
                        gapComposer2.startReusableNode();
                        boolean z8 = gapComposer2.inserting;
                        TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
                        if (z8) {
                            gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
                        } else {
                            gapComposer2.useNode();
                        }
                        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetMeasurePolicy;
                        Stack.m390setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy, updater$$ExternalSyntheticLambda0);
                        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                        Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda1);
                        Integer numValueOf2 = Integer.valueOf(iHashCode);
                        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetCompositeKeyHash;
                        Stack.m390setimpl(gapComposer2, numValueOf2, updater$$ExternalSyntheticLambda2);
                        Stack.m389reconcileimpl(gapComposer2);
                        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetModifier;
                        Stack.m390setimpl(gapComposer2, modifierMaterializeModifier, updater$$ExternalSyntheticLambda3);
                        InsetsPaddingValues insetsPaddingValuesAsPaddingValues2 = OffsetKt.asPaddingValues(new AddedInsets(OffsetKt.current(gapComposer2).systemBars, OffsetKt.m129WindowInsetsa9UjIt4$default(72.0f, 72.0f, 5)), gapComposer2);
                        BottomSheetState bottomSheetState3 = bottomSheetState;
                        bottomSheetState3.getClass();
                        Modifier modifierNestedScroll = NestedScrollModifierKt.nestedScroll(companion3, new BottomSheetState$preUpPostDownNestedScrollConnection$1(bottomSheetState3), null);
                        final MutableState mutableState11 = mutableState7;
                        boolean zChanged11 = gapComposer2.changed(mutableState11) | gapComposer2.changed(reorderableLazyListState) | gapComposer2.changedInstance(objRememberedValue25);
                        boolean z9 = z5;
                        boolean zChanged12 = zChanged11 | gapComposer2.changed(z9) | gapComposer2.changedInstance(playerConnection5) | gapComposer2.changedInstance(coroutineScope3);
                        final List list3 = list;
                        boolean zChangedInstance = zChanged12 | gapComposer2.changedInstance(list3);
                        final State state3 = mutableStateCollectAsStateWithLifecycle4;
                        boolean zChanged13 = zChangedInstance | gapComposer2.changed(state3);
                        final Object obj6 = objRememberedValue25;
                        final long j7 = j;
                        boolean zChanged14 = zChanged13 | gapComposer2.changed(j7);
                        final HapticFeedback hapticFeedback2 = hapticFeedback;
                        boolean zChangedInstance2 = zChanged14 | gapComposer2.changedInstance(hapticFeedback2) | gapComposer2.changed(state2);
                        final State state4 = mutableState2;
                        boolean zChanged15 = zChangedInstance2 | gapComposer2.changed(state4);
                        final State state5 = mutableState3;
                        boolean zChanged16 = zChanged15 | gapComposer2.changed(state5);
                        final CastConnectionHandler castConnectionHandler4 = castConnectionHandler3;
                        boolean zChangedInstance3 = zChanged16 | gapComposer2.changedInstance(castConnectionHandler4);
                        final MenuState menuState2 = menuState;
                        boolean zChanged17 = zChangedInstance3 | gapComposer2.changed(menuState2);
                        final BottomSheetState bottomSheetState4 = bottomSheetState2;
                        boolean zChanged18 = zChanged17 | gapComposer2.changed(bottomSheetState4);
                        final BottomSheetPageState bottomSheetPageState2 = bottomSheetPageState;
                        boolean zChanged19 = zChanged18 | gapComposer2.changed(bottomSheetPageState2);
                        final MutableState mutableState12 = dataStoreKt$rememberPreference$1$1RememberPreference;
                        boolean zChanged20 = zChanged19 | gapComposer2.changed(mutableState12) | gapComposer2.changed(mutableStateCollectAsStateWithLifecycle10);
                        Object objRememberedValue30 = gapComposer2.rememberedValue();
                        final SnackbarHostState snackbarHostState2 = snackbarHostState;
                        if (zChanged20 || objRememberedValue30 == neverEqualPolicy2) {
                            final MutableState mutableState13 = mutableState5;
                            companion2 = companion3;
                            final ReorderableLazyListState reorderableLazyListState2 = reorderableLazyListState;
                            z7 = z9;
                            coroutineScope2 = coroutineScope3;
                            obj4 = new Function1() { // from class: com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda19
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj7) {
                                    LazyListIntervalContent lazyListIntervalContent = (LazyListIntervalContent) obj7;
                                    lazyListIntervalContent.getClass();
                                    final MutableState mutableState14 = mutableState11;
                                    LazyListIntervalContent.item$default(lazyListIntervalContent, "queue_top_spacer", null, new ComposableLambdaImpl(true, 1568869265, new QueueKt$$ExternalSyntheticLambda21(mutableState14, (byte) 16)), 2);
                                    QueueKt$$ExternalSyntheticLambda36 queueKt$$ExternalSyntheticLambda36 = new QueueKt$$ExternalSyntheticLambda36((byte) 0);
                                    final SnapshotStateList snapshotStateList3 = snapshotStateList2;
                                    int size2 = snapshotStateList3.size();
                                    Latch$await$2$2 latch$await$2$2 = new Latch$await$2$2(queueKt$$ExternalSyntheticLambda36, snapshotStateList3, (byte) 16);
                                    SongMenuKt$SongMenu$lambda$33$0$$inlined$items$default$3 songMenuKt$SongMenu$lambda$33$0$$inlined$items$default$3 = new SongMenuKt$SongMenu$lambda$33$0$$inlined$items$default$3(snapshotStateList3, (byte) 15);
                                    final ReorderableLazyListState reorderableLazyListState3 = reorderableLazyListState2;
                                    final Object obj8 = obj6;
                                    final boolean z10 = z7;
                                    final PlayerConnection playerConnection6 = playerConnection5;
                                    final CoroutineScope coroutineScope4 = coroutineScope2;
                                    final List list4 = list3;
                                    final MutableState mutableState15 = mutableState13;
                                    final SnackbarHostState snackbarHostState3 = snackbarHostState2;
                                    final long j8 = j7;
                                    final HapticFeedback hapticFeedback3 = hapticFeedback2;
                                    final State state6 = state2;
                                    final State state7 = state4;
                                    final State state8 = state5;
                                    final CastConnectionHandler castConnectionHandler5 = castConnectionHandler4;
                                    final State state9 = state3;
                                    final MenuState menuState3 = menuState2;
                                    final BottomSheetState bottomSheetState5 = bottomSheetState4;
                                    final BottomSheetPageState bottomSheetPageState3 = bottomSheetPageState2;
                                    final MutableState mutableState16 = mutableState12;
                                    lazyListIntervalContent.items(size2, latch$await$2$2, songMenuKt$SongMenu$lambda$33$0$$inlined$items$default$3, new ComposableLambdaImpl(true, 2039820996, new Function4() { // from class: com.metrolist.music.ui.player.QueueKt$Queue_TBEEUPw$lambda$45$13$0$0$$inlined$itemsIndexed$3
                                        @Override // kotlin.jvm.functions.Function4
                                        public final Object invoke(Object obj9, Object obj10, Object obj11, Object obj12) {
                                            int i4;
                                            final LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj9;
                                            final int iIntValue4 = ((Number) obj10).intValue();
                                            Composer composer3 = (Composer) obj11;
                                            int iIntValue5 = ((Number) obj12).intValue();
                                            if ((iIntValue5 & 6) == 0) {
                                                i4 = (((GapComposer) composer3).changed(lazyItemScopeImpl) ? 4 : 2) | iIntValue5;
                                            } else {
                                                i4 = iIntValue5;
                                            }
                                            if ((iIntValue5 & 48) == 0) {
                                                i4 |= ((GapComposer) composer3).changed(iIntValue4) ? 32 : 16;
                                            }
                                            int i5 = i4;
                                            GapComposer gapComposer3 = (GapComposer) composer3;
                                            if (gapComposer3.shouldExecute(i5 & 1, (i5 & 147) != 146)) {
                                                final Timeline.Window window = (Timeline.Window) snapshotStateList3.get(iIntValue4);
                                                gapComposer3.startReplaceGroup(-1352407382);
                                                Integer numValueOf3 = Integer.valueOf(window.uid.hashCode());
                                                final BottomSheetPageState bottomSheetPageState4 = bottomSheetPageState3;
                                                final MutableState mutableState17 = mutableState16;
                                                final Object obj13 = obj8;
                                                final boolean z11 = z10;
                                                final PlayerConnection playerConnection7 = playerConnection6;
                                                final CoroutineScope coroutineScope5 = coroutineScope4;
                                                final List list5 = list4;
                                                final MutableState mutableState18 = mutableState15;
                                                final SnackbarHostState snackbarHostState4 = snackbarHostState3;
                                                final SnapshotStateList snapshotStateList4 = snapshotStateList3;
                                                final long j9 = j8;
                                                final MutableState mutableState19 = mutableState14;
                                                final HapticFeedback hapticFeedback4 = hapticFeedback3;
                                                final State state10 = state6;
                                                final State state11 = state7;
                                                final State state12 = state8;
                                                final CastConnectionHandler castConnectionHandler6 = castConnectionHandler5;
                                                final State state13 = state9;
                                                final MenuState menuState4 = menuState3;
                                                final BottomSheetState bottomSheetState6 = bottomSheetState5;
                                                CharsKt.ReorderableItem(lazyItemScopeImpl, reorderableLazyListState3, numValueOf3, null, false, null, Expect_jvmKt.rememberComposableLambda(1074867401, new Function4() { // from class: com.metrolist.music.ui.player.QueueKt$Queue$5$4$1$1$4$1

                                                    /* JADX INFO: renamed from: com.metrolist.music.ui.player.QueueKt$Queue$5$4$1$1$4$1$2, reason: invalid class name */
                                                    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                                                    public final class AnonymousClass2 implements Function3 {
                                                        public final /* synthetic */ ComposableLambdaImpl $content;
                                                        public final /* synthetic */ byte $r8$classId;

                                                        public /* synthetic */ AnonymousClass2(ComposableLambdaImpl composableLambdaImpl, byte b) {
                                                            this.$r8$classId = b;
                                                            this.$content = composableLambdaImpl;
                                                        }

                                                        @Override // kotlin.jvm.functions.Function3
                                                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                                                            byte b = this.$r8$classId;
                                                            Unit unit = Unit.INSTANCE;
                                                            ComposableLambdaImpl composableLambdaImpl = this.$content;
                                                            switch (b) {
                                                                case 0:
                                                                    Composer composer = (Composer) obj2;
                                                                    int iIntValue = ((Number) obj3).intValue();
                                                                    ((RowScope) obj).getClass();
                                                                    GapComposer gapComposer = (GapComposer) composer;
                                                                    if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                                                                        gapComposer.skipToGroupEnd();
                                                                    } else {
                                                                        composableLambdaImpl.invoke((Object) gapComposer, (Object) 6);
                                                                    }
                                                                    break;
                                                                default:
                                                                    Composer composer2 = (Composer) obj2;
                                                                    int iIntValue2 = ((Number) obj3).intValue();
                                                                    ((RowScope) obj).getClass();
                                                                    GapComposer gapComposer2 = (GapComposer) composer2;
                                                                    if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                                                                        gapComposer2.skipToGroupEnd();
                                                                    } else {
                                                                        composableLambdaImpl.invoke((Object) gapComposer2, (Object) 6);
                                                                    }
                                                                    break;
                                                            }
                                                            return unit;
                                                        }
                                                    }

                                                    @Override // kotlin.jvm.functions.Function4
                                                    public final Object invoke(Object obj14, Object obj15, Object obj16, Object obj17) {
                                                        String str;
                                                        SwipeToDismissBoxValue swipeToDismissBoxValue;
                                                        SwipeToDismissBoxState swipeToDismissBoxState;
                                                        final ReorderableCollectionItemScopeImpl reorderableCollectionItemScopeImpl = (ReorderableCollectionItemScopeImpl) obj14;
                                                        ((Boolean) obj15).getClass();
                                                        Composer composer4 = (Composer) obj16;
                                                        int iIntValue6 = ((Number) obj17).intValue();
                                                        reorderableCollectionItemScopeImpl.getClass();
                                                        if ((iIntValue6 & 6) == 0) {
                                                            iIntValue6 |= ((GapComposer) composer4).changed(reorderableCollectionItemScopeImpl) ? 4 : 2;
                                                        }
                                                        GapComposer gapComposer4 = (GapComposer) composer4;
                                                        if (gapComposer4.shouldExecute(iIntValue6 & 1, (iIntValue6 & 131) != 130)) {
                                                            final Timeline.Window window2 = window;
                                                            MutableState mutableStateRememberUpdatedState = Stack.rememberUpdatedState(window2, gapComposer4);
                                                            final boolean zAreEqual = Intrinsics.areEqual(window2.uid, obj13);
                                                            Object objRememberedValue31 = gapComposer4.rememberedValue();
                                                            NeverEqualPolicy neverEqualPolicy3 = Composer.Companion.Empty;
                                                            if (objRememberedValue31 == neverEqualPolicy3) {
                                                                objRememberedValue31 = QueueKt$Queue$5$4$1$1$4$1$dismissBoxState$1$1.INSTANCE;
                                                                gapComposer4.updateRememberedValue(objRememberedValue31);
                                                            }
                                                            SwipeToDismissBoxState swipeToDismissBoxStateRememberSwipeToDismissBoxState = ScrimKt.rememberSwipeToDismissBoxState((Function1) objRememberedValue31, gapComposer4);
                                                            Object objRememberedValue32 = gapComposer4.rememberedValue();
                                                            if (objRememberedValue32 == neverEqualPolicy3) {
                                                                objRememberedValue32 = Stack.mutableStateOf$default(Boolean.FALSE);
                                                                gapComposer4.updateRememberedValue(objRememberedValue32);
                                                            }
                                                            MutableState mutableState20 = (MutableState) objRememberedValue32;
                                                            MediaItem mediaItem2 = ((Timeline.Window) mutableStateRememberUpdatedState.getValue()).mediaItem;
                                                            mediaItem2.getClass();
                                                            MediaMetadata metadata2 = UuidKt.getMetadata(mediaItem2);
                                                            if (metadata2 == null || (str = metadata2.title) == null) {
                                                                str = "";
                                                            }
                                                            String strStringResource2 = MathKt.stringResource(R.string.removed_song_from_playlist, new Object[]{str}, gapComposer4);
                                                            String strStringResource3 = MathKt.stringResource(R.string.undo, gapComposer4);
                                                            SwipeToDismissBoxValue currentValue = swipeToDismissBoxStateRememberSwipeToDismissBoxState.getCurrentValue();
                                                            boolean zChangedInstance4 = gapComposer4.changedInstance(swipeToDismissBoxStateRememberSwipeToDismissBoxState) | gapComposer4.changed(z11);
                                                            final PlayerConnection playerConnection8 = playerConnection7;
                                                            boolean zChangedInstance5 = zChangedInstance4 | gapComposer4.changedInstance(playerConnection8) | gapComposer4.changed(mutableStateRememberUpdatedState) | gapComposer4.changedInstance(coroutineScope5) | gapComposer4.changed(strStringResource2) | gapComposer4.changed(strStringResource3);
                                                            Object objRememberedValue33 = gapComposer4.rememberedValue();
                                                            if (zChangedInstance5 || objRememberedValue33 == neverEqualPolicy3) {
                                                                swipeToDismissBoxValue = currentValue;
                                                                QueueKt$Queue$5$4$1$1$4$1$1$1 queueKt$Queue$5$4$1$1$4$1$1$1 = new QueueKt$Queue$5$4$1$1$4$1$1$1(swipeToDismissBoxStateRememberSwipeToDismissBoxState, z11, playerConnection8, coroutineScope5, mutableState20, mutableStateRememberUpdatedState, mutableState18, snackbarHostState4, strStringResource2, strStringResource3, snapshotStateList4, null);
                                                                swipeToDismissBoxState = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                                                                gapComposer4.updateRememberedValue(queueKt$Queue$5$4$1$1$4$1$1$1);
                                                                objRememberedValue33 = queueKt$Queue$5$4$1$1$4$1$1$1;
                                                            } else {
                                                                swipeToDismissBoxState = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                                                                swipeToDismissBoxValue = currentValue;
                                                            }
                                                            Stack.LaunchedEffect(gapComposer4, swipeToDismissBoxValue, (Function2) objRememberedValue33);
                                                            List list6 = list5;
                                                            boolean zChangedInstance6 = gapComposer4.changedInstance(list6) | gapComposer4.changedInstance(window2);
                                                            Object objRememberedValue34 = gapComposer4.rememberedValue();
                                                            if (zChangedInstance6 || objRememberedValue34 == neverEqualPolicy3) {
                                                                objRememberedValue34 = new Latch$await$2$2(list6, window2, (byte) 15);
                                                                gapComposer4.updateRememberedValue(objRememberedValue34);
                                                            }
                                                            final Function1 function4 = (Function1) objRememberedValue34;
                                                            final BottomSheetPageState bottomSheetPageState5 = bottomSheetPageState4;
                                                            final MutableState mutableState21 = mutableState17;
                                                            final LazyItemScopeImpl lazyItemScopeImpl2 = lazyItemScopeImpl;
                                                            final int i6 = iIntValue4;
                                                            final long j10 = j9;
                                                            final MutableState mutableState22 = mutableState19;
                                                            final HapticFeedback hapticFeedback5 = hapticFeedback4;
                                                            final List list7 = list5;
                                                            final boolean z12 = z11;
                                                            final State state14 = state10;
                                                            final State state15 = state11;
                                                            final State state16 = state12;
                                                            final CastConnectionHandler castConnectionHandler7 = castConnectionHandler6;
                                                            final State state17 = state13;
                                                            final MenuState menuState5 = menuState4;
                                                            final BottomSheetState bottomSheetState7 = bottomSheetState6;
                                                            ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Expect_jvmKt.rememberComposableLambda(1433002088, new Function2() { // from class: com.metrolist.music.ui.player.QueueKt$Queue$5$4$1$1$4$1$content$1
                                                                @Override // kotlin.jvm.functions.Function2
                                                                public final Object invoke(Object obj18, Object obj19) {
                                                                    Object albumScreenKt$AlbumScreen$3$1$4$2$1;
                                                                    final boolean z13;
                                                                    MutableState mutableState23;
                                                                    List list8;
                                                                    final Timeline.Window window3;
                                                                    Composer composer5 = (Composer) obj18;
                                                                    int iIntValue7 = ((Number) obj19).intValue();
                                                                    GapComposer gapComposer5 = (GapComposer) composer5;
                                                                    if (gapComposer5.shouldExecute(iIntValue7 & 1, (iIntValue7 & 3) != 2)) {
                                                                        FlowRowOverflow flowRowOverflow = OffsetKt.Center;
                                                                        LazyItemScopeImpl lazyItemScopeImpl3 = lazyItemScopeImpl2;
                                                                        Modifier modifierM39backgroundbw27NRU = Modifier.Companion.$$INSTANCE;
                                                                        Modifier modifierAnimateItem$default = LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl3, modifierM39backgroundbw27NRU);
                                                                        RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(flowRowOverflow, Alignment.Companion.Top, gapComposer5, 6);
                                                                        int iHashCode2 = Long.hashCode(gapComposer5.compositeKeyHashCode);
                                                                        PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer5.currentCompositionLocalScope();
                                                                        Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer5, modifierAnimateItem$default);
                                                                        ComposeUiNode.Companion.getClass();
                                                                        gapComposer5.startReusableNode();
                                                                        if (gapComposer5.inserting) {
                                                                            gapComposer5.createNode(LayoutNode.Constructor);
                                                                        } else {
                                                                            gapComposer5.useNode();
                                                                        }
                                                                        Stack.m390setimpl(gapComposer5, rowMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                                                                        Stack.m390setimpl(gapComposer5, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                                                                        Stack.m390setimpl(gapComposer5, Integer.valueOf(iHashCode2), ComposeUiNode.Companion.SetCompositeKeyHash);
                                                                        Stack.m389reconcileimpl(gapComposer5);
                                                                        Stack.m390setimpl(gapComposer5, modifierMaterializeModifier2, ComposeUiNode.Companion.SetModifier);
                                                                        int i7 = i6;
                                                                        int i8 = i7 + 1;
                                                                        Timeline.Window window4 = window2;
                                                                        MediaItem mediaItem3 = window4.mediaItem;
                                                                        mediaItem3.getClass();
                                                                        MediaMetadata metadata3 = UuidKt.getMetadata(mediaItem3);
                                                                        metadata3.getClass();
                                                                        boolean zBooleanValue2 = ((Boolean) state17.getValue()).booleanValue();
                                                                        boolean z14 = zAreEqual;
                                                                        boolean z15 = zBooleanValue2 && z14;
                                                                        Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(modifierM39backgroundbw27NRU, 1.0f);
                                                                        if (!UiStyleKt.isGlassStyle(gapComposer5)) {
                                                                            modifierM39backgroundbw27NRU = ImageKt.m39backgroundbw27NRU(modifierM39backgroundbw27NRU, j10, ColorKt.RectangleShape);
                                                                        }
                                                                        Modifier modifierThen2 = modifierFillMaxWidth.then(modifierM39backgroundbw27NRU);
                                                                        MutableState mutableState24 = mutableState22;
                                                                        boolean zChanged21 = gapComposer5.changed(mutableState24);
                                                                        HapticFeedback hapticFeedback6 = hapticFeedback5;
                                                                        boolean zChangedInstance7 = zChanged21 | gapComposer5.changedInstance(hapticFeedback6);
                                                                        final Function1 function5 = function4;
                                                                        boolean zChanged22 = zChangedInstance7 | gapComposer5.changed(function5);
                                                                        Object objRememberedValue35 = gapComposer5.rememberedValue();
                                                                        NeverEqualPolicy neverEqualPolicy4 = Composer.Companion.Empty;
                                                                        if (zChanged22 || objRememberedValue35 == neverEqualPolicy4) {
                                                                            objRememberedValue35 = new AlbumScreenKt$AlbumScreen$3$1$4$1$1(hapticFeedback6, function5, mutableState24, (byte) 1);
                                                                            gapComposer5.updateRememberedValue(objRememberedValue35);
                                                                        }
                                                                        Function0 function6 = (Function0) objRememberedValue35;
                                                                        boolean zChanged23 = gapComposer5.changed(mutableState24) | gapComposer5.changed(function5);
                                                                        List list9 = list7;
                                                                        boolean zChangedInstance8 = zChanged23 | gapComposer5.changedInstance(list9) | gapComposer5.changedInstance(window4);
                                                                        boolean z16 = z12;
                                                                        boolean zChanged24 = zChangedInstance8 | gapComposer5.changed(z16) | gapComposer5.changed(i7);
                                                                        State state18 = state14;
                                                                        boolean zChanged25 = zChanged24 | gapComposer5.changed(state18);
                                                                        State state19 = state15;
                                                                        boolean zChanged26 = zChanged25 | gapComposer5.changed(state19);
                                                                        State state20 = state16;
                                                                        boolean zChanged27 = zChanged26 | gapComposer5.changed(state20);
                                                                        CastConnectionHandler castConnectionHandler8 = castConnectionHandler7;
                                                                        boolean zChangedInstance9 = zChanged27 | gapComposer5.changedInstance(castConnectionHandler8);
                                                                        PlayerConnection playerConnection9 = playerConnection8;
                                                                        boolean zChangedInstance10 = zChangedInstance9 | gapComposer5.changedInstance(playerConnection9);
                                                                        Object objRememberedValue36 = gapComposer5.rememberedValue();
                                                                        if (zChangedInstance10 || objRememberedValue36 == neverEqualPolicy4) {
                                                                            z13 = z16;
                                                                            mutableState23 = mutableState24;
                                                                            albumScreenKt$AlbumScreen$3$1$4$2$1 = new AlbumScreenKt$AlbumScreen$3$1$4$2$1(function5, list9, window4, z13, i7, castConnectionHandler8, playerConnection9, mutableState23, state18, state19, state20);
                                                                            list8 = list9;
                                                                            window3 = window4;
                                                                            gapComposer5.updateRememberedValue(albumScreenKt$AlbumScreen$3$1$4$2$1);
                                                                        } else {
                                                                            albumScreenKt$AlbumScreen$3$1$4$2$1 = objRememberedValue36;
                                                                            list8 = list9;
                                                                            window3 = window4;
                                                                            z13 = z16;
                                                                            mutableState23 = mutableState24;
                                                                        }
                                                                        Modifier modifierM48combinedClickablehoGz1lA$default = ImageKt.m48combinedClickablehoGz1lA$default(modifierThen2, false, function6, (Function0) albumScreenKt$AlbumScreen$3$1$4$2$1, 239);
                                                                        Integer numValueOf4 = Integer.valueOf(i8);
                                                                        final MenuState menuState6 = menuState5;
                                                                        final BottomSheetState bottomSheetState8 = bottomSheetState7;
                                                                        final BottomSheetPageState bottomSheetPageState6 = bottomSheetPageState5;
                                                                        final ReorderableCollectionItemScopeImpl reorderableCollectionItemScopeImpl2 = reorderableCollectionItemScopeImpl;
                                                                        final MutableState mutableState25 = mutableState21;
                                                                        final MutableState mutableState26 = mutableState23;
                                                                        final List list10 = list8;
                                                                        QueueKt.QueueTrackRow(numValueOf4, metadata3, modifierM48combinedClickablehoGz1lA$default, z14, z15, Expect_jvmKt.rememberComposableLambda(1099991740, new Function3() { // from class: com.metrolist.music.ui.player.QueueKt$Queue$5$4$1$1$4$1$content$1$1$3
                                                                            @Override // kotlin.jvm.functions.Function3
                                                                            public final Object invoke(Object obj20, Object obj21, Object obj22) {
                                                                                Composer composer6 = (Composer) obj21;
                                                                                int iIntValue8 = ((Number) obj22).intValue();
                                                                                ((RowScope) obj20).getClass();
                                                                                GapComposer gapComposer6 = (GapComposer) composer6;
                                                                                if (gapComposer6.shouldExecute(iIntValue8 & 1, (iIntValue8 & 17) != 16)) {
                                                                                    boolean zBooleanValue3 = ((Boolean) mutableState26.getValue()).booleanValue();
                                                                                    Timeline.Window window5 = window3;
                                                                                    if (zBooleanValue3) {
                                                                                        gapComposer6.startReplaceGroup(-746472605);
                                                                                        CardKt.Checkbox(list10.contains(window5.mediaItem.mediaId), function5, null, false, null, gapComposer6, 0);
                                                                                        gapComposer6.end(false);
                                                                                    } else {
                                                                                        gapComposer6.startReplaceGroup(-746073449);
                                                                                        NeverEqualPolicy neverEqualPolicy5 = Composer.Companion.Empty;
                                                                                        boolean z17 = z13;
                                                                                        if (z17) {
                                                                                            gapComposer6.startReplaceGroup(-744295258);
                                                                                            gapComposer6.end(false);
                                                                                        } else {
                                                                                            gapComposer6.startReplaceGroup(-746026980);
                                                                                            MenuState menuState7 = menuState6;
                                                                                            boolean zChanged28 = gapComposer6.changed(menuState7) | gapComposer6.changedInstance(window5);
                                                                                            BottomSheetState bottomSheetState9 = bottomSheetState8;
                                                                                            boolean zChanged29 = zChanged28 | gapComposer6.changed(bottomSheetState9);
                                                                                            BottomSheetPageState bottomSheetPageState7 = bottomSheetPageState6;
                                                                                            boolean zChanged30 = zChanged29 | gapComposer6.changed(bottomSheetPageState7);
                                                                                            Object objRememberedValue37 = gapComposer6.rememberedValue();
                                                                                            if (zChanged30 || objRememberedValue37 == neverEqualPolicy5) {
                                                                                                QueueKt$Queue$5$4$1$1$7$1$1$1 queueKt$Queue$5$4$1$1$7$1$1$1 = new QueueKt$Queue$5$4$1$1$7$1$1$1(menuState7, window5, bottomSheetState9, bottomSheetPageState7, (byte) 1);
                                                                                                gapComposer6.updateRememberedValue(queueKt$Queue$5$4$1$1$7$1$1$1);
                                                                                                objRememberedValue37 = queueKt$Queue$5$4$1$1$7$1$1$1;
                                                                                            }
                                                                                            CardKt.IconButton((Function0) objRememberedValue37, null, false, null, null, QueueKt.f291lambda$287535297, gapComposer6, 1572864, 62);
                                                                                            gapComposer6.end(false);
                                                                                        }
                                                                                        if (((Boolean) mutableState25.getValue()).booleanValue() || z17) {
                                                                                            gapComposer6.startReplaceGroup(-743548282);
                                                                                            gapComposer6.end(false);
                                                                                        } else {
                                                                                            gapComposer6.startReplaceGroup(-744191191);
                                                                                            Object objRememberedValue38 = gapComposer6.rememberedValue();
                                                                                            if (objRememberedValue38 == neverEqualPolicy5) {
                                                                                                objRememberedValue38 = QueueKt$Queue$5$4$1$1$7$1$2$1.INSTANCE$1;
                                                                                                gapComposer6.updateRememberedValue(objRememberedValue38);
                                                                                            }
                                                                                            CardKt.IconButton((Function0) objRememberedValue38, Modifier.Companion.$$INSTANCE.then(new ComposedModifier(new ReorderableCollectionItemScopeImpl$draggableHandle$1(reorderableCollectionItemScopeImpl2, DragGestureDetector$Press.INSTANCE, ReorderableLazyCollectionState$findTargetItem$1.INSTANCE$1, Scroller$ScrollInfo$Companion$Null$1.INSTANCE$1))), false, null, null, QueueKt.lambda$109226664, gapComposer6, 1572870, 60);
                                                                                            gapComposer6.end(false);
                                                                                        }
                                                                                        gapComposer6.end(false);
                                                                                    }
                                                                                } else {
                                                                                    gapComposer6.skipToGroupEnd();
                                                                                }
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        }, gapComposer5), gapComposer5, 196608, 0);
                                                                        gapComposer5.end(true);
                                                                    } else {
                                                                        gapComposer5.skipToGroupEnd();
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }
                                                            }, gapComposer4);
                                                            if (((Boolean) mutableState17.getValue()).booleanValue()) {
                                                                gapComposer4.startReplaceGroup(-1891279496);
                                                                composableLambdaImplRememberComposableLambda.invoke((Object) gapComposer4, (Object) 6);
                                                                gapComposer4.end(false);
                                                            } else {
                                                                gapComposer4.startReplaceGroup(-1891202058);
                                                                ScrimKt.SwipeToDismissBox(swipeToDismissBoxState, QueueKt.lambda$831004483, null, false, false, false, null, Expect_jvmKt.rememberComposableLambda(-993203767, new AnonymousClass2(composableLambdaImplRememberComposableLambda, (byte) 0), gapComposer4), gapComposer4, 12582968, 124);
                                                                gapComposer4.end(false);
                                                            }
                                                        } else {
                                                            gapComposer4.skipToGroupEnd();
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                }, gapComposer3), gapComposer3, (i5 & 14) | 1572864);
                                                gapComposer3.end(false);
                                            } else {
                                                gapComposer3.skipToGroupEnd();
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }));
                                    State state10 = mutableStateCollectAsStateWithLifecycle10;
                                    if (!((List) state10.getValue()).isEmpty()) {
                                        LazyListIntervalContent.item$default(lazyListIntervalContent, "automix_divider", null, QueueKt.lambda$1699533484, 2);
                                        List list5 = (List) state10.getValue();
                                        lazyListIntervalContent.items(list5.size(), new Latch$await$2$2(new QueueKt$$ExternalSyntheticLambda3((byte) 1), list5, (byte) 17), new SongMenuKt$SongMenu$lambda$33$0$$inlined$items$default$3(list5, (byte) 16), new ComposableLambdaImpl(true, 2039820996, new QueueKt$Queue_TBEEUPw$lambda$45$13$0$0$$inlined$itemsIndexed$6(list5, menuState3, bottomSheetState5, bottomSheetPageState3, z10, playerConnection6)));
                                    }
                                    return Unit.INSTANCE;
                                }
                            };
                            snapshotStateList = snapshotStateList2;
                            mutableState9 = mutableState11;
                            playerConnection4 = playerConnection5;
                            j6 = j7;
                            gapComposer2.updateRememberedValue(obj4);
                        } else {
                            j6 = j7;
                            coroutineScope2 = coroutineScope3;
                            companion2 = companion3;
                            snapshotStateList = snapshotStateList2;
                            playerConnection4 = playerConnection5;
                            mutableState9 = mutableState11;
                            z7 = z9;
                            obj4 = objRememberedValue30;
                        }
                        boolean z10 = z7;
                        PlayerConnection playerConnection6 = playerConnection4;
                        CoroutineScope coroutineScope4 = coroutineScope2;
                        Modifier.Companion companion4 = companion2;
                        SnapshotStateList snapshotStateList3 = snapshotStateList;
                        IntMath.LazyColumn(modifierNestedScroll, lazyListStateRememberLazyListState, insetsPaddingValuesAsPaddingValues2, null, null, null, false, null, (Function1) obj4, gapComposer2, 0, 504);
                        gapComposer2.end(true);
                        Object objRememberedValue31 = gapComposer2.rememberedValue();
                        if (objRememberedValue31 == neverEqualPolicy2) {
                            objRememberedValue31 = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer2);
                        }
                        MutableInteractionSourceImpl mutableInteractionSourceImpl = (MutableInteractionSourceImpl) objRememberedValue31;
                        Object objRememberedValue32 = gapComposer2.rememberedValue();
                        if (objRememberedValue32 == neverEqualPolicy2) {
                            objRememberedValue32 = new QueueKt$$ExternalSyntheticLambda2((byte) 21);
                            gapComposer2.updateRememberedValue(objRememberedValue32);
                        }
                        Modifier modifierM45clickableO2vRcR0$default = ImageKt.m45clickableO2vRcR0$default(companion4, mutableInteractionSourceImpl, null, false, null, (Function0) objRememberedValue32, 28);
                        boolean z11 = z;
                        long j8 = z11 ? -72057594037927936L : j6;
                        Modifier modifierM1473hairlineBottomiJQMabo = DialogKt.m1473hairlineBottomiJQMabo(OffsetKt.windowInsetsPadding(ImageKt.m39backgroundbw27NRU(modifierM45clickableO2vRcR0$default, ColorKt.Color(Color.m485getRedimpl(j8), Color.m484getGreenimpl(j8), Color.m482getBlueimpl(j8), UiStyleKt.isGlassStyle(gapComposer2) ? 0.78f : 1.0f, Color.m483getColorSpaceimpl(j8)), rectangleShapeKt$RectangleShape$1), new LimitInsets(OffsetKt.current(gapComposer2).systemBars, 31)), gapComposer2, 0);
                        Arrangement$Top$1 arrangement$Top$1 = OffsetKt.Top;
                        BiasAlignment.Horizontal horizontal = Alignment.Companion.Start;
                        ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement$Top$1, horizontal, gapComposer2, 0);
                        int iHashCode2 = Long.hashCode(gapComposer2.compositeKeyHashCode);
                        PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer2.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer2, modifierM1473hairlineBottomiJQMabo);
                        gapComposer2.startReusableNode();
                        if (gapComposer2.inserting) {
                            gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
                        } else {
                            gapComposer2.useNode();
                        }
                        Stack.m390setimpl(gapComposer2, columnMeasurePolicy, updater$$ExternalSyntheticLambda0);
                        Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
                        IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer2, updater$$ExternalSyntheticLambda2, gapComposer2);
                        Stack.m390setimpl(gapComposer2, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
                        Arrangement$SpacedAligned arrangement$SpacedAligned = new Arrangement$SpacedAligned(6.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5));
                        BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
                        Modifier modifierM139paddingqDBjuR0$default = OffsetKt.m139paddingqDBjuR0$default(SizeKt.m145height3ABfNKs(companion4, 64.0f), 20.0f, CropImageView.DEFAULT_ASPECT_RATIO, 12.0f, CropImageView.DEFAULT_ASPECT_RATIO, 10);
                        RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement$SpacedAligned, vertical, gapComposer2, 54);
                        int iHashCode3 = Long.hashCode(gapComposer2.compositeKeyHashCode);
                        PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer2.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer2, modifierM139paddingqDBjuR0$default);
                        gapComposer2.startReusableNode();
                        if (gapComposer2.inserting) {
                            gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
                        } else {
                            gapComposer2.useNode();
                        }
                        Stack.m390setimpl(gapComposer2, rowMeasurePolicy, updater$$ExternalSyntheticLambda0);
                        Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda1);
                        IntIntPair$$ExternalSyntheticOutline0.m(iHashCode3, gapComposer2, updater$$ExternalSyntheticLambda2, gapComposer2);
                        Stack.m390setimpl(gapComposer2, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda3);
                        if (1.0f <= 0.0d) {
                            InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
                        }
                        LayoutWeightElement layoutWeightElement = new LayoutWeightElement(1.0f > Float.MAX_VALUE ? Float.MAX_VALUE : 1.0f, true);
                        ColumnMeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement$Top$1, horizontal, gapComposer2, 0);
                        int iHashCode4 = Long.hashCode(gapComposer2.compositeKeyHashCode);
                        PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope4 = gapComposer2.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier4 = ZIndexModifierKt.materializeModifier(gapComposer2, layoutWeightElement);
                        gapComposer2.startReusableNode();
                        if (gapComposer2.inserting) {
                            gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
                        } else {
                            gapComposer2.useNode();
                        }
                        Stack.m390setimpl(gapComposer2, columnMeasurePolicy2, updater$$ExternalSyntheticLambda0);
                        Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope4, updater$$ExternalSyntheticLambda1);
                        IntIntPair$$ExternalSyntheticOutline0.m(iHashCode4, gapComposer2, updater$$ExternalSyntheticLambda2, gapComposer2);
                        Stack.m390setimpl(gapComposer2, modifierMaterializeModifier4, updater$$ExternalSyntheticLambda3);
                        String strStringResource2 = MathKt.stringResource(R.string.queue, gapComposer2);
                        StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                        DialogKt.m1469MicroLabelFNF3uiM(strStringResource2, null, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).colorScheme.primary, gapComposer2, 0, 2);
                        String str = (String) mutableStateCollectAsStateWithLifecycle8.getValue();
                        if (str == null) {
                            str = "";
                        }
                        TextKt.m352TextNvy7gAk(str, null, 0L, 0L, null, null, null, 0L, null, 0L, 2, false, 1, 0, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).typography.titleLarge, gapComposer2, 0, 24960, 110590);
                        gapComposer2.end(true);
                        boolean z12 = !((Boolean) mutableState9.getValue()).booleanValue();
                        EnterTransitionImpl enterTransitionImplFadeIn$default = EnterExitTransitionKt.fadeIn$default(null, CropImageView.DEFAULT_ASPECT_RATIO, 3);
                        Object objRememberedValue33 = gapComposer2.rememberedValue();
                        if (objRememberedValue33 == neverEqualPolicy2) {
                            objRememberedValue33 = new AlbumMenuKt$$ExternalSyntheticLambda13((byte) 13);
                            gapComposer2.updateRememberedValue(objRememberedValue33);
                        }
                        EnterTransitionImpl enterTransitionImplPlus = enterTransitionImplFadeIn$default.plus(EnterExitTransitionKt.slideInVertically$default(1, (Function1) objRememberedValue33));
                        ExitTransitionImpl exitTransitionImplFadeOut$default = EnterExitTransitionKt.fadeOut$default(null, CropImageView.DEFAULT_ASPECT_RATIO, 3);
                        Object objRememberedValue34 = gapComposer2.rememberedValue();
                        if (objRememberedValue34 == neverEqualPolicy2) {
                            objRememberedValue34 = new AlbumMenuKt$$ExternalSyntheticLambda13((byte) 13);
                            gapComposer2.updateRememberedValue(objRememberedValue34);
                        }
                        CrossfadeKt.AnimatedVisibility(z12, null, enterTransitionImplPlus, exitTransitionImplFadeOut$default.plus(EnterExitTransitionKt.slideOutVertically$default(1, (Function1) objRememberedValue34)), null, Expect_jvmKt.rememberComposableLambda(841062696, new QueueKt$$ExternalSyntheticLambda21(mutableState12, (byte) 0), gapComposer2), gapComposer2, 1600518);
                        ColumnMeasurePolicy columnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(new Arrangement$SpacedAligned(2.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5)), Alignment.Companion.End, gapComposer2, 54);
                        int iHashCode5 = Long.hashCode(gapComposer2.compositeKeyHashCode);
                        PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope5 = gapComposer2.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier5 = ZIndexModifierKt.materializeModifier(gapComposer2, companion4);
                        gapComposer2.startReusableNode();
                        if (gapComposer2.inserting) {
                            gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
                        } else {
                            gapComposer2.useNode();
                        }
                        Stack.m390setimpl(gapComposer2, columnMeasurePolicy3, updater$$ExternalSyntheticLambda0);
                        Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope5, updater$$ExternalSyntheticLambda1);
                        IntIntPair$$ExternalSyntheticOutline0.m(iHashCode5, gapComposer2, updater$$ExternalSyntheticLambda2, gapComposer2);
                        Stack.m390setimpl(gapComposer2, modifierMaterializeModifier5, updater$$ExternalSyntheticLambda3);
                        DialogKt.m1469MicroLabelFNF3uiM(MathKt.pluralStringResource(R.plurals.n_song, ((List) mutableState8.getValue()).size(), new Object[]{Integer.valueOf(((List) mutableState8.getValue()).size())}, gapComposer2), null, 0L, gapComposer2, 0, 6);
                        DialogKt.m1469MicroLabelFNF3uiM(UtilsKt.makeTimeString(Long.valueOf(((long) iIntValue2) * 1000)), null, 0L, gapComposer2, 0, 6);
                        gapComposer2.end(true);
                        gapComposer2.end(true);
                        CrossfadeKt.AnimatedVisibility(ColumnScopeInstance.INSTANCE, ((Boolean) mutableState9.getValue()).booleanValue(), null, EnterExitTransitionKt.fadeIn$default(null, CropImageView.DEFAULT_ASPECT_RATIO, 3).plus(EnterExitTransitionKt.expandVertically$default(null, 15)), EnterExitTransitionKt.fadeOut$default(null, CropImageView.DEFAULT_ASPECT_RATIO, 3).plus(EnterExitTransitionKt.shrinkVertically$default(null, 15)), null, Expect_jvmKt.rememberComposableLambda(-1780855100, new QueueKt$$ExternalSyntheticLambda22(list3, snapshotStateList3, function1, menuState2), gapComposer2), gapComposer2, 1600518, 18);
                        gapComposer2.end(true);
                        MutableState mutableStateCollectAsStateWithLifecycle11 = FileSystemsKt.collectAsStateWithLifecycle(playerConnection6.shuffleModeEnabled, gapComposer2);
                        long j9 = z11 ? -72057594037927936L : j6;
                        Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(DialogKt.m1474hairlineTopiJQMabo(ImageKt.m39backgroundbw27NRU(companion4, ColorKt.Color(Color.m485getRedimpl(j9), Color.m484getGreenimpl(j9), Color.m482getBlueimpl(j9), UiStyleKt.isGlassStyle(gapComposer2) ? 0.78f : 1.0f, Color.m483getColorSpaceimpl(j9)), rectangleShapeKt$RectangleShape$1), gapComposer2, 0), 1.0f);
                        SpringSpec springSpec2 = DimensionsKt.NavigationBarAnimationSpec;
                        Modifier modifierM145height3ABfNKs = SizeKt.m145height3ABfNKs(modifierFillMaxWidth, OffsetKt.asPaddingValues(OffsetKt.current(gapComposer2).systemBars, gapComposer2).mo122calculateBottomPaddingD9Ej5fM() + 64.0f + CropImageView.DEFAULT_ASPECT_RATIO);
                        BiasAlignment biasAlignment2 = Alignment.Companion.BottomCenter;
                        Modifier modifierAlign = boxScope.align(modifierM145height3ABfNKs, biasAlignment2);
                        boolean zChanged21 = gapComposer2.changed(bottomSheetState3);
                        Object objRememberedValue35 = gapComposer2.rememberedValue();
                        if (zChanged21 || objRememberedValue35 == neverEqualPolicy2) {
                            objRememberedValue35 = new PlayerKt$$ExternalSyntheticLambda0(bottomSheetState3, (byte) 11);
                            gapComposer2.updateRememberedValue(objRememberedValue35);
                        }
                        Modifier modifierM135padding3ABfNKs = OffsetKt.m135padding3ABfNKs(OffsetKt.windowInsetsPadding(ImageKt.m46clickableoSLSa3U$default(modifierAlign, false, null, (Function0) objRememberedValue35, 15), new LimitInsets(OffsetKt.current(gapComposer2).systemBars, 47)), 12.0f);
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, false);
                        int iHashCode6 = Long.hashCode(gapComposer2.compositeKeyHashCode);
                        PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope6 = gapComposer2.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier6 = ZIndexModifierKt.materializeModifier(gapComposer2, modifierM135padding3ABfNKs);
                        gapComposer2.startReusableNode();
                        if (gapComposer2.inserting) {
                            gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
                        } else {
                            gapComposer2.useNode();
                        }
                        Stack.m390setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy2, updater$$ExternalSyntheticLambda0);
                        Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope6, updater$$ExternalSyntheticLambda1);
                        IntIntPair$$ExternalSyntheticOutline0.m(iHashCode6, gapComposer2, updater$$ExternalSyntheticLambda2, gapComposer2);
                        Stack.m390setimpl(gapComposer2, modifierMaterializeModifier6, updater$$ExternalSyntheticLambda3);
                        boolean z13 = !z10;
                        BiasAlignment biasAlignment3 = Alignment.Companion.CenterStart;
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        Modifier modifierAlign2 = boxScopeInstance.align(companion4, biasAlignment3);
                        boolean zChangedInstance4 = gapComposer2.changedInstance(coroutineScope4) | gapComposer2.changed(lazyListStateRememberLazyListState) | gapComposer2.changedInstance(playerConnection6);
                        Object objRememberedValue36 = gapComposer2.rememberedValue();
                        if (zChangedInstance4 || objRememberedValue36 == neverEqualPolicy2) {
                            b2 = 0;
                            objRememberedValue36 = new QueueKt$$ExternalSyntheticLambda24(coroutineScope4, lazyListStateRememberLazyListState, playerConnection6, (byte) 0);
                            gapComposer2.updateRememberedValue(objRememberedValue36);
                        } else {
                            b2 = 0;
                        }
                        CardKt.IconButton((Function0) objRememberedValue36, modifierAlign2, z13, null, null, Expect_jvmKt.rememberComposableLambda(-1682412463, new QueueKt$$ExternalSyntheticLambda25(z10, mutableStateCollectAsStateWithLifecycle11, b2), gapComposer2), gapComposer2, 1572864, 56);
                        IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.expand_more, b2, gapComposer2), (String) null, boxScopeInstance.align(companion4, Alignment.Companion.Center), 0L, gapComposer2, 56, 8);
                        Modifier modifierAlign3 = boxScopeInstance.align(companion4, Alignment.Companion.CenterEnd);
                        ExoPlayerImpl playerSafe = playerConnection6.getPlayerSafe();
                        boolean zChangedInstance5 = gapComposer2.changedInstance(playerSafe);
                        Object objRememberedValue37 = gapComposer2.rememberedValue();
                        if (zChangedInstance5 || objRememberedValue37 == neverEqualPolicy2) {
                            objRememberedValue37 = new RoomDatabase$closeBarrier$1(0, playerSafe, IntMath.class, "toggleRepeatMode", "toggleRepeatMode(Landroidx/media3/common/Player;)V", 1, (byte) 26);
                            gapComposer2.updateRememberedValue(objRememberedValue37);
                        }
                        CardKt.IconButton((Function0) ((KFunction) objRememberedValue37), modifierAlign3, z13, null, null, Expect_jvmKt.rememberComposableLambda(-116108792, new QueueKt$$ExternalSyntheticLambda25(z10, mutableStateCollectAsStateWithLifecycle5, (byte) 3), gapComposer2), gapComposer2, 1572864, 56);
                        gapComposer2.end(true);
                        SpringSpec springSpec3 = DimensionsKt.NavigationBarAnimationSpec;
                        ScrimKt.SnackbarHost(snackbarHostState2, boxScope.align(OffsetKt.m139paddingqDBjuR0$default(companion4, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, OffsetKt.asPaddingValues(OffsetKt.current(gapComposer2).systemBars, gapComposer2).mo122calculateBottomPaddingD9Ej5fM() + 64.0f + CropImageView.DEFAULT_ASPECT_RATIO, 7), biasAlignment2), null, gapComposer2, 6, 4);
                    } else {
                        gapComposer2.skipToGroupEnd();
                    }
                    return Unit.INSTANCE;
                }
            }, gapComposer), gapComposer, (i2 & 14) | 1597872, 40);
            modifier2 = companion;
        } else {
            gapComposer.skipToGroupEnd();
            modifier2 = modifier;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup2 = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup2 != null) {
            recomposeScopeImplEndRestartGroup2.block = new Function2(bottomSheetState2, modifier2, j, j2, j3, j4, j5, z, z2, function0, i) { // from class: com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda0
                public final /* synthetic */ BottomSheetState f$1;
                public final /* synthetic */ Function0 f$11;
                public final /* synthetic */ Modifier f$2;
                public final /* synthetic */ long f$3;
                public final /* synthetic */ long f$4;
                public final /* synthetic */ long f$5;
                public final /* synthetic */ long f$6;
                public final /* synthetic */ long f$7;
                public final /* synthetic */ boolean f$8;
                public final /* synthetic */ boolean f$9;

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(1);
                    QueueKt.m1507QueueTBEEUPw(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, this.f$8, this.f$9, this.f$11, (Composer) obj, iUpdateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final void QueueStripAction(final int i, final String str, final boolean z, final Function0 function0, final Modifier modifier, boolean z2, final boolean z3, Composer composer, final int i2, final int i3) {
        boolean z4;
        int i4;
        long jColor;
        Modifier.Companion companion;
        boolean z5;
        float f;
        String str2;
        TextStyle textStyleM750copyp1EtxEg$default;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-2100599861);
        int i5 = (gapComposer.changed(i) ? 4 : 2) | i2 | (gapComposer.changed(str) ? 32 : 16);
        if ((i2 & 384) == 0) {
            i5 |= gapComposer.changed(z) ? 256 : 128;
        }
        int i6 = i5 | (gapComposer.changedInstance(function0) ? 2048 : 1024) | (gapComposer.changed(modifier) ? 16384 : 8192);
        int i7 = i3 & 32;
        if (i7 != 0) {
            i4 = i6 | 196608;
            z4 = z2;
        } else {
            z4 = z2;
            i4 = i6 | (gapComposer.changed(z4) ? 131072 : 65536);
        }
        int i8 = i4 | (gapComposer.changed(z3) ? ByteChannelKt.CHANNEL_MAX_SIZE : 524288);
        if (gapComposer.shouldExecute(i8 & 1, (599187 & i8) != 599186)) {
            boolean z6 = i7 != 0 ? true : z4;
            if (z) {
                gapComposer.startReplaceGroup(-41829102);
                jColor = CardKt.getColorScheme(gapComposer).primary;
            } else {
                gapComposer.startReplaceGroup(-41827845);
                jColor = CardKt.getColorScheme(gapComposer).onSurfaceVariant;
            }
            gapComposer.end(false);
            if (!z6) {
                jColor = ColorKt.Color(Color.m485getRedimpl(jColor), Color.m484getGreenimpl(jColor), Color.m482getBlueimpl(jColor), 0.38f, Color.m483getColorSpaceimpl(jColor));
            }
            AnimateAsState animateAsStateM17animateColorAsStateeuL9pac = SingleValueAnimationKt.m17animateColorAsStateeuL9pac(jColor, ArcSplineKt.tween$default(200, 0, null, 6), "stripTint", gapComposer, 432, 8);
            BiasAlignment.Horizontal horizontal = Alignment.Companion.CenterHorizontally;
            FlowRowOverflow flowRowOverflow = OffsetKt.Center;
            Modifier modifierM46clickableoSLSa3U$default = ImageKt.m46clickableoSLSa3U$default(DialogKt.pressScale(modifier, 0.92f).then(SizeKt.FillWholeMaxHeight), z6, null, function0, 14);
            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(flowRowOverflow, horizontal, gapComposer, 54);
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierM46clickableoSLSa3U$default);
            ComposeUiNode.Companion.getClass();
            gapComposer.startReusableNode();
            boolean z7 = gapComposer.inserting;
            TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
            if (z7) {
                gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer.useNode();
            }
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetMeasurePolicy;
            Stack.m390setimpl(gapComposer, columnMeasurePolicy, updater$$ExternalSyntheticLambda0);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda1);
            Integer numValueOf = Integer.valueOf(iHashCode);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetCompositeKeyHash;
            Stack.m390setimpl(gapComposer, numValueOf, updater$$ExternalSyntheticLambda2);
            Stack.m389reconcileimpl(gapComposer);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetModifier;
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier, updater$$ExternalSyntheticLambda3);
            Modifier.Companion companion2 = Modifier.Companion.$$INSTANCE;
            if (z3) {
                gapComposer.startReplaceGroup(-327560148);
                BiasAlignment biasAlignment = Alignment.Companion.Center;
                z5 = false;
                companion = companion2;
                Modifier modifierGlass = GlassComponentsKt.glass(SizeKt.m151size3ABfNKs(companion2, 38.0f), RoundedCornerShapeKt.CircleShape, z, gapComposer, (i8 & 896) | 6, 0);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, false);
                int iHashCode2 = Long.hashCode(gapComposer.compositeKeyHashCode);
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer, modifierGlass);
                gapComposer.startReusableNode();
                if (gapComposer.inserting) {
                    gapComposer = gapComposer;
                    gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
                } else {
                    gapComposer = gapComposer;
                    gapComposer.useNode();
                }
                Stack.m390setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy, updater$$ExternalSyntheticLambda0);
                Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
                IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer, updater$$ExternalSyntheticLambda2, gapComposer);
                Stack.m390setimpl(gapComposer, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
                IconKt.m290Iconww6aTOc(IntMath.painterResource(i, i8 & 14, gapComposer), (String) null, SizeKt.m151size3ABfNKs(companion, 20.0f), ((Color) animateAsStateM17animateColorAsStateeuL9pac.getValue()).value, gapComposer, 440, 0);
                gapComposer.end(true);
                gapComposer.end(false);
            } else {
                companion = companion2;
                z5 = false;
                gapComposer.startReplaceGroup(-327135169);
                IconKt.m290Iconww6aTOc(IntMath.painterResource(i, i8 & 14, gapComposer), (String) null, SizeKt.m151size3ABfNKs(companion, 22.0f), ((Color) animateAsStateM17animateColorAsStateeuL9pac.getValue()).value, gapComposer, 440, 0);
                gapComposer.end(false);
            }
            if (z3) {
                gapComposer = gapComposer;
                f = 2.0f;
            } else {
                gapComposer = gapComposer;
                f = 3.0f;
            }
            OffsetKt.Spacer(gapComposer, SizeKt.m145height3ABfNKs(companion, f));
            if (z3) {
                str2 = str;
            } else {
                String upperCase = str.toUpperCase(Locale.ROOT);
                upperCase.getClass();
                str2 = upperCase;
            }
            if (z3) {
                gapComposer.startReplaceGroup(-1673107497);
                textStyleM750copyp1EtxEg$default = TextStyle.m750copyp1EtxEg$default(CardKt.getTypography(gapComposer).labelSmall, 0L, IntMath.getSp(10), null, null, null, null, 0L, 0L, null, null, 16777213);
            } else {
                gapComposer.startReplaceGroup(-1673105813);
                textStyleM750copyp1EtxEg$default = CardKt.getTypography(gapComposer).labelSmall;
            }
            gapComposer.end(z5);
            TextKt.m352TextNvy7gAk(str2, OffsetKt.m137paddingVpY3zN4$default(companion, 4.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2), ((Color) animateAsStateM17animateColorAsStateeuL9pac.getValue()).value, 0L, null, null, null, 0L, null, 0L, 2, false, 1, 0, textStyleM750copyp1EtxEg$default, gapComposer, 48, 24960, 110584);
            gapComposer.end(true);
            z4 = z6;
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            final boolean z8 = z4;
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda32
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    QueueKt.QueueStripAction(i, str, z, function0, modifier, z8, z3, (Composer) obj, Stack.updateChangedFlags(i2 | 1), i3);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9, types: [boolean, byte, int] */
    public static final void QueueTrackRow(Integer num, MediaMetadata mediaMetadata, Modifier modifier, boolean z, boolean z2, Function3 function3, Composer composer, int i, int i2) {
        int i3;
        boolean z3;
        int i4;
        boolean z4;
        int i5;
        Function3 function4;
        boolean z5;
        boolean z6;
        GapComposer gapComposer;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1;
        long j;
        TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3;
        Map map;
        Modifier.Companion companion;
        ?? r1;
        GapComposer gapComposer2;
        Modifier modifierM42borderxT4_qwU;
        long j2;
        Map map2;
        Modifier.Companion companion2;
        boolean z7;
        GapComposer gapComposer3;
        String str = mediaMetadata.thumbnailUrl;
        GapComposer gapComposer4 = (GapComposer) composer;
        gapComposer4.startRestartGroup(-1156814888);
        if ((i & 6) == 0) {
            i3 = i | (gapComposer4.changed(num) ? 4 : 2);
        } else {
            i3 = i;
        }
        int i6 = i3 | (gapComposer4.changed(mediaMetadata) ? 32 : 16) | (gapComposer4.changed(modifier) ? 256 : 128);
        int i7 = i2 & 8;
        if (i7 != 0) {
            i4 = i6 | 3072;
            z3 = z;
        } else {
            z3 = z;
            i4 = i6 | (gapComposer4.changed(z3) ? 2048 : 1024);
        }
        int i8 = i2 & 16;
        if (i8 != 0) {
            i5 = i4 | 24576;
            z4 = z2;
        } else {
            z4 = z2;
            i5 = i4 | (gapComposer4.changed(z4) ? 16384 : 8192);
        }
        if (gapComposer4.shouldExecute(i5 & 1, (74899 & i5) != 74898)) {
            boolean z8 = i7 != 0 ? false : z3;
            boolean z9 = i8 != 0 ? false : z4;
            Map map3 = (Map) gapComposer4.consume(MainActivityKt.LocalArtistNameAliases);
            long j3 = CardKt.getColorScheme(gapComposer4).primary;
            boolean zIsGlassStyle = UiStyleKt.isGlassStyle(gapComposer4);
            RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(zIsGlassStyle ? 14.0f : 8.0f);
            AnimateAsState animateAsStateM17animateColorAsStateeuL9pac = SingleValueAnimationKt.m17animateColorAsStateeuL9pac((z8 && zIsGlassStyle) ? ColorKt.Color(Color.m485getRedimpl(j3), Color.m484getGreenimpl(j3), Color.m482getBlueimpl(j3), 0.22f, Color.m483getColorSpaceimpl(j3)) : 0L, ArcSplineKt.tween$default(200, 0, null, 6), "queueRowFill", gapComposer4, 432, 8);
            BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
            Modifier modifierM137paddingVpY3zN4$default = OffsetKt.m137paddingVpY3zN4$default(modifier, zIsGlassStyle ? 10.0f : 0.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2);
            SpringSpec springSpec = DimensionsKt.NavigationBarAnimationSpec;
            Modifier modifierClip = ClipKt.clip(SizeKt.m145height3ABfNKs(modifierM137paddingVpY3zN4$default, 64.0f), RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(zIsGlassStyle ? 22.0f : 0.0f));
            long j4 = ((Color) animateAsStateM17animateColorAsStateeuL9pac.getValue()).value;
            RectangleShapeKt$RectangleShape$1 rectangleShapeKt$RectangleShape$1 = ColorKt.RectangleShape;
            Modifier modifierM139paddingqDBjuR0$default = OffsetKt.m139paddingqDBjuR0$default(DialogKt.m1473hairlineBottomiJQMabo(ImageKt.m39backgroundbw27NRU(modifierClip, j4, rectangleShapeKt$RectangleShape$1), gapComposer4, 0), zIsGlassStyle ? 10.0f : 20.0f, CropImageView.DEFAULT_ASPECT_RATIO, zIsGlassStyle ? 4.0f : 8.0f, CropImageView.DEFAULT_ASPECT_RATIO, 10);
            RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(OffsetKt.Start, vertical, gapComposer4, 48);
            int iHashCode = Long.hashCode(gapComposer4.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer4.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer4, modifierM139paddingqDBjuR0$default);
            ComposeUiNode.Companion.getClass();
            gapComposer4.startReusableNode();
            boolean z10 = gapComposer4.inserting;
            TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda4 = LayoutNode.Constructor;
            if (z10) {
                gapComposer4.createNode(textKt$$ExternalSyntheticLambda4);
            } else {
                gapComposer4.useNode();
            }
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetMeasurePolicy;
            Stack.m390setimpl(gapComposer4, rowMeasurePolicy, updater$$ExternalSyntheticLambda2);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Stack.m390setimpl(gapComposer4, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda3);
            Integer numValueOf = Integer.valueOf(iHashCode);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda4 = ComposeUiNode.Companion.SetCompositeKeyHash;
            Stack.m390setimpl(gapComposer4, numValueOf, updater$$ExternalSyntheticLambda4);
            Stack.m389reconcileimpl(gapComposer4);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda5 = ComposeUiNode.Companion.SetModifier;
            Stack.m390setimpl(gapComposer4, modifierMaterializeModifier, updater$$ExternalSyntheticLambda5);
            Modifier.Companion companion3 = Modifier.Companion.$$INSTANCE;
            Modifier modifierM155width3ABfNKs = SizeKt.m155width3ABfNKs(companion3, 28.0f);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.CenterStart, false);
            int iHashCode2 = Long.hashCode(gapComposer4.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer4.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer4, modifierM155width3ABfNKs);
            gapComposer4.startReusableNode();
            if (gapComposer4.inserting) {
                gapComposer4.createNode(textKt$$ExternalSyntheticLambda4);
            } else {
                gapComposer4.useNode();
            }
            Stack.m390setimpl(gapComposer4, measurePolicyMaybeCachedBoxMeasurePolicy, updater$$ExternalSyntheticLambda2);
            Stack.m390setimpl(gapComposer4, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda3);
            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer4, updater$$ExternalSyntheticLambda4, gapComposer4);
            Stack.m390setimpl(gapComposer4, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda5);
            if (z8) {
                gapComposer4.startReplaceGroup(-1805829999);
                if (zIsGlassStyle || !z9) {
                    map2 = map3;
                    updater$$ExternalSyntheticLambda0 = updater$$ExternalSyntheticLambda5;
                    updater$$ExternalSyntheticLambda1 = updater$$ExternalSyntheticLambda2;
                    companion2 = companion3;
                    z7 = false;
                    gapComposer4.startReplaceGroup(-1805443708);
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(z9 ? R.drawable.volume_up : R.drawable.play, 0, gapComposer4), (String) null, SizeKt.m151size3ABfNKs(companion2, 16.0f), j3, gapComposer4, 440, 0);
                    j = j3;
                    GapComposer gapComposer5 = gapComposer4;
                    gapComposer5.end(false);
                    gapComposer3 = gapComposer5;
                } else {
                    gapComposer4.startReplaceGroup(-1805797418);
                    companion2 = companion3;
                    updater$$ExternalSyntheticLambda1 = updater$$ExternalSyntheticLambda2;
                    updater$$ExternalSyntheticLambda0 = updater$$ExternalSyntheticLambda5;
                    z7 = false;
                    MenuKt.m1489PlayingIndicatorc5303Zs(j3, SizeKt.m151size3ABfNKs(companion2, 16.0f), 3, 3.0f, 1.0f, gapComposer4, 28080, 0);
                    GapComposer gapComposer6 = gapComposer4;
                    gapComposer6.end(false);
                    map2 = map3;
                    j = j3;
                    gapComposer3 = gapComposer6;
                }
                gapComposer3.end(z7);
                textKt$$ExternalSyntheticLambda3 = textKt$$ExternalSyntheticLambda4;
                map = map2;
                companion = companion2;
                r1 = z7;
                gapComposer2 = gapComposer3;
            } else {
                rectangleShapeKt$RectangleShape$1 = rectangleShapeKt$RectangleShape$1;
                updater$$ExternalSyntheticLambda3 = updater$$ExternalSyntheticLambda3;
                updater$$ExternalSyntheticLambda0 = updater$$ExternalSyntheticLambda5;
                updater$$ExternalSyntheticLambda4 = updater$$ExternalSyntheticLambda4;
                updater$$ExternalSyntheticLambda1 = updater$$ExternalSyntheticLambda2;
                j = j3;
                if (num != null) {
                    gapComposer4.startReplaceGroup(-1805087177);
                    textKt$$ExternalSyntheticLambda3 = textKt$$ExternalSyntheticLambda4;
                    companion = companion3;
                    r1 = 0;
                    map = map3;
                    TextKt.m352TextNvy7gAk(StringsKt.padStart(2, String.valueOf(num.intValue())), null, CardKt.getColorScheme(gapComposer4).onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 0, false, 1, 0, TextStyle.m750copyp1EtxEg$default(CardKt.getTypography(gapComposer4).labelSmall, 0L, 0L, null, null, null, "tnum, smcp", 0L, 0L, null, null, 16777151), gapComposer4, 0, 24576, 114682);
                    GapComposer gapComposer7 = gapComposer4;
                    gapComposer7.end(false);
                    gapComposer2 = gapComposer7;
                } else {
                    textKt$$ExternalSyntheticLambda3 = textKt$$ExternalSyntheticLambda4;
                    map = map3;
                    companion = companion3;
                    r1 = 0;
                    gapComposer4.startReplaceGroup(-1804787872);
                    gapComposer4.end(false);
                    gapComposer2 = gapComposer4;
                }
            }
            gapComposer2.end(true);
            boolean zChanged = gapComposer2.changed(str);
            Object objRememberedValue = gapComposer2.rememberedValue();
            Object obj = Composer.Companion.Empty;
            if (zChanged || objRememberedValue == obj) {
                String strResize = str != null ? YouTubeUtilsKt.resize(str, 132, 132) : null;
                gapComposer2.updateRememberedValue(strResize);
                objRememberedValue = strResize;
            }
            String str2 = (String) objRememberedValue;
            Modifier modifierM39backgroundbw27NRU = ImageKt.m39backgroundbw27NRU(ClipKt.clip(SizeKt.m151size3ABfNKs(companion, zIsGlassStyle ? 48.0f : 44.0f), roundedCornerShapeM185RoundedCornerShape0680j_4), CardKt.getColorScheme(gapComposer2).surfaceVariant, rectangleShapeKt$RectangleShape$1);
            if (zIsGlassStyle) {
                gapComposer2.startReplaceGroup(2053042049);
                modifierM42borderxT4_qwU = ImageKt.m43borderziNgDLE(companion, 1.0f, GlassComponentsKt.glassRim(gapComposer2), roundedCornerShapeM185RoundedCornerShape0680j_4);
                gapComposer2.end(r1);
            } else {
                gapComposer2.startReplaceGroup(2053149123);
                modifierM42borderxT4_qwU = ImageKt.m42borderxT4_qwU(companion, 1.0f, CardKt.getColorScheme(gapComposer2).outlineVariant, roundedCornerShapeM185RoundedCornerShape0680j_4);
                gapComposer2.end(r1);
            }
            GapComposer gapComposer8 = gapComposer2;
            AsyncImageKt.m849AsyncImage10Xjiaw(str2, modifierM39backgroundbw27NRU.then(modifierM42borderxT4_qwU), ContentScale.Companion.Crop, gapComposer8, 1572912, 1976);
            FlowRowOverflow flowRowOverflow = OffsetKt.Center;
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            Modifier modifierM137paddingVpY3zN4$default2 = OffsetKt.m137paddingVpY3zN4$default(rowScopeInstance.weight(companion, 1.0f, true), 12.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2);
            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(flowRowOverflow, Alignment.Companion.Start, gapComposer8, 6);
            int iHashCode3 = Long.hashCode(gapComposer8.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer8.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer8, modifierM137paddingVpY3zN4$default2);
            gapComposer8.startReusableNode();
            if (gapComposer8.inserting) {
                gapComposer8.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer8.useNode();
            }
            Stack.m390setimpl(gapComposer8, columnMeasurePolicy, updater$$ExternalSyntheticLambda1);
            Stack.m390setimpl(gapComposer8, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda3);
            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode3, gapComposer8, updater$$ExternalSyntheticLambda4, gapComposer8);
            Stack.m390setimpl(gapComposer8, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda0);
            String str3 = mediaMetadata.title;
            TextStyle textStyle = CardKt.getTypography(gapComposer8).bodyLarge;
            if (z8) {
                gapComposer8.startReplaceGroup(188716601);
                gapComposer8.end(r1);
                j2 = j;
            } else {
                gapComposer8.startReplaceGroup(188717851);
                j2 = CardKt.getColorScheme(gapComposer8).onSurface;
                gapComposer8.end(r1);
            }
            TextKt.m352TextNvy7gAk(str3, null, ((Color) SingleValueAnimationKt.m17animateColorAsStateeuL9pac(j2, ArcSplineKt.tween$default(200, r1, null, 6), "queueTitleColor", gapComposer8, 432, 8).getValue()).value, 0L, null, null, null, 0L, null, 0L, 2, false, 1, 0, textStyle, gapComposer8, 0, 24960, 110586);
            List list = mediaMetadata.artists;
            String strM = IntIntPair$$ExternalSyntheticOutline0.m(ServerSentEventKt.SPACE, MathKt.stringResource(R.string.and, gapComposer8), ServerSentEventKt.SPACE);
            Map map4 = map;
            boolean zChangedInstance = gapComposer8.changedInstance(map4);
            Object objRememberedValue2 = gapComposer8.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == obj) {
                objRememberedValue2 = new QueueKt$$ExternalSyntheticLambda40(map4, r1);
                gapComposer8.updateRememberedValue(objRememberedValue2);
            }
            TextKt.m352TextNvy7gAk(UtilsKt.joinToArtistString(list, strM, (Function1) objRememberedValue2), null, CardKt.getColorScheme(gapComposer8).onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 2, false, 1, 0, CardKt.getTypography(gapComposer8).bodySmall, gapComposer8, 0, 24960, 110586);
            gapComposer8.end(true);
            TextKt.m352TextNvy7gAk(UtilsKt.makeTimeString(Long.valueOf(((long) mediaMetadata.duration) * 1000)), OffsetKt.m139paddingqDBjuR0$default(companion, 4.0f, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 14), CardKt.getColorScheme(gapComposer8).onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 0, false, 1, 0, CardKt.getTypography(gapComposer8).labelSmall, gapComposer8, 48, 24576, 114680);
            GapComposer gapComposer9 = gapComposer8;
            Function3 function5 = function3;
            function5.invoke(rowScopeInstance, gapComposer9, 54);
            gapComposer9.end(true);
            z5 = z8;
            z6 = z9;
            function4 = function5;
            gapComposer = gapComposer9;
        } else {
            function4 = function3;
            gapComposer4.skipToGroupEnd();
            z5 = z3;
            z6 = z4;
            gapComposer = gapComposer4;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new QueueKt$$ExternalSyntheticLambda41(num, mediaMetadata, modifier, z5, z6, function4, i, i2);
        }
    }

    public static final void SeekEffectOverlay(String str, Modifier modifier, Composer composer, int i) {
        GapComposer gapComposer;
        Modifier modifier2;
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(-991825803);
        int i2 = i | (gapComposer2.changed(str) ? 4 : 2) | 48;
        if (gapComposer2.shouldExecute(i2 & 1, (i2 & 19) != 18)) {
            long j = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.onSurface;
            long sp = IntMath.getSp(16);
            FontWeight fontWeight = FontWeight.Bold;
            RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(UiStyleKt.isGlassStyle(gapComposer2) ? 16.0f : 8.0f);
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            gapComposer = gapComposer2;
            TextKt.m352TextNvy7gAk(str, OffsetKt.m136paddingVpY3zN4(GlassComponentsKt.glass(companion, roundedCornerShapeM185RoundedCornerShape0680j_4, false, gapComposer2, 6, 2), 12.0f, 8.0f), j, sp, null, fontWeight, null, 0L, new TextAlign(3), 0L, 0, false, 0, 0, null, gapComposer, (i2 & 14) | 1597440, 0, 261032);
            modifier2 = companion;
        } else {
            gapComposer = gapComposer2;
            gapComposer.skipToGroupEnd();
            modifier2 = modifier;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new MainActivity$$ExternalSyntheticLambda1(str, modifier2, i, (byte) 21);
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x033c  */
    /* JADX WARN: Code duplicated, block: B:103:0x0392  */
    /* JADX WARN: Code duplicated, block: B:106:0x03a1  */
    /* JADX WARN: Code duplicated, block: B:107:0x03a8  */
    /* JADX WARN: Code duplicated, block: B:110:0x0404  */
    /* JADX WARN: Code duplicated, block: B:111:0x040f  */
    /* JADX WARN: Code duplicated, block: B:113:0x0451  */
    /* JADX WARN: Code duplicated, block: B:116:0x045c  */
    /* JADX WARN: Code duplicated, block: B:117:0x0470 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:118:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x004e  */
    /* JADX WARN: Code duplicated, block: B:24:0x0051  */
    /* JADX WARN: Code duplicated, block: B:27:0x005b  */
    /* JADX WARN: Code duplicated, block: B:28:0x005d  */
    /* JADX WARN: Code duplicated, block: B:31:0x0065 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:32:0x0067  */
    /* JADX WARN: Code duplicated, block: B:33:0x0069  */
    /* JADX WARN: Code duplicated, block: B:36:0x0075  */
    /* JADX WARN: Code duplicated, block: B:38:0x007b  */
    /* JADX WARN: Code duplicated, block: B:41:0x0089  */
    /* JADX WARN: Code duplicated, block: B:45:0x00db  */
    /* JADX WARN: Code duplicated, block: B:48:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:51:0x0109  */
    /* JADX WARN: Code duplicated, block: B:54:0x012d  */
    /* JADX WARN: Code duplicated, block: B:58:0x017f  */
    /* JADX WARN: Code duplicated, block: B:64:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:67:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:70:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:76:0x0235  */
    /* JADX WARN: Code duplicated, block: B:80:0x0280  */
    /* JADX WARN: Code duplicated, block: B:86:0x02af  */
    /* JADX WARN: Code duplicated, block: B:89:0x02d0  */
    /* JADX WARN: Code duplicated, block: B:92:0x02e0  */
    /* JADX WARN: Code duplicated, block: B:95:0x030e  */
    /* JADX WARN: Code duplicated, block: B:96:0x0314  */
    /* JADX WARN: Code duplicated, block: B:99:0x033a  */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void Thumbnail(final Function0 function0, final Modifier modifier, final Function0 function1, boolean z, final boolean z2, Composer composer, final int i, final int i2) {
        boolean z3;
        int i3;
        int i4;
        boolean z4;
        GapComposer gapComposer;
        final boolean z5;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        Function2 function2;
        boolean z6;
        final PlayerConnection playerConnection;
        final boolean z7;
        MutableState mutableStateCollectAsState;
        MutableState mutableStateCollectAsStateWithLifecycle;
        MutableState mutableStateCollectAsStateWithLifecycle2;
        boolean z8;
        Boolean bool;
        Preferences$Key preferences$Key;
        Context context;
        Object objRememberedValue;
        NeverEqualPolicy neverEqualPolicy;
        CoroutineScope coroutineScope;
        Object objRememberedValue2;
        MutableState mutableStateCollectAsStateWithLifecycle3;
        Object objRememberedValue3;
        LazyGridState lazyGridStateRememberLazyGridState;
        boolean zChanged;
        Object objRememberedValue4;
        State state;
        final ArrayList arrayList;
        int i5;
        boolean zChanged2;
        Object objRememberedValue5;
        byte b;
        byte b2;
        Object objRememberedValue6;
        State state2;
        Object objRememberedValue7;
        State state3;
        boolean zChanged3;
        Object thumbnailKt$Thumbnail$2$1;
        MutableState mutableState;
        MutableState mutableState2;
        int i6;
        boolean zChanged4;
        Object objRememberedValue8;
        Continuation continuation;
        boolean zChanged5;
        Object objRememberedValue9;
        LazyGridState lazyGridState;
        FiniteAnimationSpec finiteAnimationSpec;
        Object objRememberedValue10;
        final MutableState mutableState3;
        Object objRememberedValue11;
        boolean z9;
        Modifier.Companion companion;
        Modifier modifierWindowInsetsPadding;
        Object objRememberedValue12;
        FiniteAnimationSpec finiteAnimationSpec2;
        function0.getClass();
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(-1547444801);
        int i7 = (gapComposer2.changed(modifier) ? 32 : 16) | i | (gapComposer2.changedInstance(function1) ? 256 : 128);
        int i8 = i2 & 8;
        if (i8 == 0) {
            if ((i & 3072) == 0) {
                z3 = z;
                i7 |= gapComposer2.changed(z3) ? 2048 : 1024;
            }
            if (gapComposer2.changed(z2)) {
                i3 = 16384;
            } else {
                i3 = 8192;
            }
            i4 = i7 | i3;
            if ((i4 & 9361) != 9360) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (gapComposer2.shouldExecute(i4 & 1, z4)) {
                if (i8 != 0) {
                    z6 = false;
                } else {
                    z6 = z3;
                }
                playerConnection = (PlayerConnection) gapComposer2.consume(MainActivityKt.LocalPlayerConnection);
                if (playerConnection == null) {
                    recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
                    if (recomposeScopeImplEndRestartGroup != null) {
                        return;
                    }
                    final byte b3 = 0;
                    final boolean z10 = z6;
                    function2 = new Function2() { // from class: com.metrolist.music.ui.player.ThumbnailKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            byte b4 = b3;
                            Unit unit = Unit.INSTANCE;
                            short s = i;
                            switch (b4) {
                                case 0:
                                    ((Integer) obj2).getClass();
                                    int iUpdateChangedFlags = Stack.updateChangedFlags(s | 1);
                                    QueueKt.Thumbnail(function0, modifier, function1, z10, z2, (Composer) obj, iUpdateChangedFlags, i2);
                                    break;
                                default:
                                    ((Integer) obj2).getClass();
                                    int iUpdateChangedFlags2 = Stack.updateChangedFlags(s | 1);
                                    QueueKt.Thumbnail(function0, modifier, function1, z10, z2, (Composer) obj, iUpdateChangedFlags2, i2);
                                    break;
                            }
                            return unit;
                        }
                    };
                } else {
                    z7 = z6;
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal = AndroidCompositionLocals_androidKt.LocalContext;
                    final Context context2 = (Context) gapComposer2.consume(staticProvidableCompositionLocal);
                    final LayoutDirection layoutDirection = (LayoutDirection) gapComposer2.consume(CompositionLocalsKt.LocalLayoutDirection);
                    final MutableState mutableStateCollectAsState2 = Stack.collectAsState(playerConnection.mediaMetadata, gapComposer2, 3);
                    mutableStateCollectAsState = Stack.collectAsState(playerConnection.error, gapComposer2, 3);
                    final MutableState mutableStateCollectAsStateWithLifecycle4 = FileSystemsKt.collectAsStateWithLifecycle(playerConnection.queueTitle, gapComposer2);
                    mutableStateCollectAsStateWithLifecycle = FileSystemsKt.collectAsStateWithLifecycle(playerConnection.canSkipPrevious, gapComposer2);
                    mutableStateCollectAsStateWithLifecycle2 = FileSystemsKt.collectAsStateWithLifecycle(playerConnection.canSkipNext, gapComposer2);
                    if (((Boolean) UtilsKt.rememberPreference(PreferenceKeysKt.SwipeThumbnailKey, Boolean.TRUE, gapComposer2, 48).$state.getValue()).booleanValue() || z2) {
                        z8 = false;
                    } else {
                        z8 = true;
                    }
                    Preferences$Key preferences$Key2 = PreferenceKeysKt.HidePlayerThumbnailKey;
                    bool = Boolean.FALSE;
                    final DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference = UtilsKt.rememberPreference(preferences$Key2, bool, gapComposer2, 48);
                    final DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference2 = UtilsKt.rememberPreference(PreferenceKeysKt.CropAlbumArtKey, bool, gapComposer2, 48);
                    preferences$Key = PreferenceKeysKt.PlayerBackgroundStyleKey;
                    context = (Context) gapComposer2.consume(staticProvidableCompositionLocal);
                    objRememberedValue = gapComposer2.rememberedValue();
                    neverEqualPolicy = Composer.Companion.Empty;
                    if (objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = Stack.createCompositionCoroutineScope(gapComposer2);
                        gapComposer2.updateRememberedValue(objRememberedValue);
                    }
                    coroutineScope = (CoroutineScope) objRememberedValue;
                    objRememberedValue2 = gapComposer2.rememberedValue();
                    if (objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = StateFlowKt.distinctUntilChanged(new MainActivity$MetrolistApp$$inlined$rememberEnumPreference$1(UtilsKt.getDataStore(context).getData(), preferences$Key, (byte) 19));
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    }
                    mutableStateCollectAsStateWithLifecycle3 = FileSystemsKt.collectAsStateWithLifecycle((Flow) objRememberedValue2, PlayerBackgroundStyle.DEFAULT, gapComposer2, 48);
                    objRememberedValue3 = gapComposer2.rememberedValue();
                    if (objRememberedValue3 == neverEqualPolicy) {
                        objRememberedValue3 = new ThumbnailKt$Thumbnail$$inlined$rememberEnumPreference$2(mutableStateCollectAsStateWithLifecycle3, coroutineScope, context, preferences$Key);
                        gapComposer2.updateRememberedValue(objRememberedValue3);
                    }
                    final long j = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.onBackground;
                    lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(gapComposer2);
                    int currentMediaItemIndex = playerConnection.getPlayerSafe().getCurrentMediaItemIndex();
                    ExoPlayerImpl playerSafe = playerConnection.getPlayerSafe();
                    playerSafe.verifyApplicationThread();
                    zChanged = gapComposer2.changed(currentMediaItemIndex) | gapComposer2.changed(playerSafe.shuffleModeEnabled) | gapComposer2.changed(z8) | gapComposer2.changed((MediaMetadata) mutableStateCollectAsState2.getValue());
                    objRememberedValue4 = gapComposer2.rememberedValue();
                    if (zChanged || objRememberedValue4 == neverEqualPolicy) {
                        objRememberedValue4 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ThumbnailKt$$ExternalSyntheticLambda1(playerConnection, z8, (byte) 0));
                        gapComposer2.updateRememberedValue(objRememberedValue4);
                    }
                    state = (State) objRememberedValue4;
                    arrayList = ((MediaItemsData) state.getValue()).items;
                    i5 = ((MediaItemsData) state.getValue()).currentIndex;
                    zChanged2 = gapComposer2.changed(lazyGridStateRememberLazyGridState);
                    objRememberedValue5 = gapComposer2.rememberedValue();
                    b = 2;
                    if (!zChanged2 || objRememberedValue5 == neverEqualPolicy) {
                        QueueKt$$ExternalSyntheticLambda3 queueKt$$ExternalSyntheticLambda3 = new QueueKt$$ExternalSyntheticLambda3(b);
                        lazyGridStateRememberLazyGridState.getClass();
                        b2 = 0;
                        ThumbnailSnapUtilsKt$ThumbnailSnapLayoutInfoProvider$2 thumbnailSnapUtilsKt$ThumbnailSnapLayoutInfoProvider$2 = new ThumbnailSnapUtilsKt$ThumbnailSnapLayoutInfoProvider$2(lazyGridStateRememberLazyGridState, queueKt$$ExternalSyntheticLambda3, b2);
                        gapComposer2.updateRememberedValue(thumbnailSnapUtilsKt$ThumbnailSnapLayoutInfoProvider$2);
                        objRememberedValue5 = thumbnailSnapUtilsKt$ThumbnailSnapLayoutInfoProvider$2;
                    } else {
                        b2 = 0;
                    }
                    final SnapLayoutInfoProvider snapLayoutInfoProvider = (SnapLayoutInfoProvider) objRememberedValue5;
                    objRememberedValue6 = gapComposer2.rememberedValue();
                    if (objRememberedValue6 == neverEqualPolicy) {
                        objRememberedValue6 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ThumbnailKt$$ExternalSyntheticLambda3(lazyGridStateRememberLazyGridState, b2));
                        gapComposer2.updateRememberedValue(objRememberedValue6);
                    }
                    state2 = (State) objRememberedValue6;
                    objRememberedValue7 = gapComposer2.rememberedValue();
                    if (objRememberedValue7 == neverEqualPolicy) {
                        objRememberedValue7 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ThumbnailKt$$ExternalSyntheticLambda3(lazyGridStateRememberLazyGridState, (byte) 3));
                        gapComposer2.updateRememberedValue(objRememberedValue7);
                    }
                    state3 = (State) objRememberedValue7;
                    Integer numValueOf = Integer.valueOf(((Number) state3.getValue()).intValue());
                    zChanged3 = gapComposer2.changed(lazyGridStateRememberLazyGridState) | gapComposer2.changed(z8) | gapComposer2.changed(i5) | gapComposer2.changed(mutableStateCollectAsStateWithLifecycle2) | gapComposer2.changedInstance(playerConnection) | gapComposer2.changed(mutableStateCollectAsStateWithLifecycle);
                    Object objRememberedValue13 = gapComposer2.rememberedValue();
                    if (!zChanged3 || objRememberedValue13 == neverEqualPolicy) {
                        mutableState = mutableStateCollectAsStateWithLifecycle;
                        mutableState2 = mutableStateCollectAsStateWithLifecycle2;
                        i6 = i5;
                        thumbnailKt$Thumbnail$2$1 = new ThumbnailKt$Thumbnail$2$1(lazyGridStateRememberLazyGridState, z8, i6, playerConnection, state3, state2, mutableState2, mutableState, null);
                        playerConnection = playerConnection;
                        gapComposer2.updateRememberedValue(thumbnailKt$Thumbnail$2$1);
                    } else {
                        mutableState = mutableStateCollectAsStateWithLifecycle;
                        mutableState2 = mutableStateCollectAsStateWithLifecycle2;
                        thumbnailKt$Thumbnail$2$1 = objRememberedValue13;
                        i6 = i5;
                    }
                    Stack.LaunchedEffect(gapComposer2, numValueOf, (Function2) thumbnailKt$Thumbnail$2$1);
                    MediaMetadata mediaMetadata = (MediaMetadata) mutableStateCollectAsState2.getValue();
                    Boolean bool2 = (Boolean) mutableState.getValue();
                    bool2.getClass();
                    Boolean bool3 = (Boolean) mutableState2.getValue();
                    bool3.getClass();
                    zChanged4 = gapComposer2.changed(i6) | gapComposer2.changedInstance(arrayList) | gapComposer2.changed(lazyGridStateRememberLazyGridState);
                    objRememberedValue8 = gapComposer2.rememberedValue();
                    continuation = null;
                    if (zChanged4 || objRememberedValue8 == neverEqualPolicy) {
                        objRememberedValue8 = new Updater$getAllReleases$2(i6, arrayList, lazyGridStateRememberLazyGridState, null);
                        gapComposer2.updateRememberedValue(objRememberedValue8);
                    }
                    Stack.LaunchedEffect(mediaMetadata, bool2, bool3, (Function2) objRememberedValue8, gapComposer2);
                    Integer numValueOf2 = Integer.valueOf(playerConnection.getPlayerSafe().getCurrentMediaItemIndex());
                    zChanged5 = gapComposer2.changed(state) | gapComposer2.changed(lazyGridStateRememberLazyGridState);
                    objRememberedValue9 = gapComposer2.rememberedValue();
                    if (!zChanged5 || objRememberedValue9 == neverEqualPolicy) {
                        lazyGridState = lazyGridStateRememberLazyGridState;
                        objRememberedValue9 = new DataStoreKt$get$2((Object) lazyGridState, (Object) state, (Object) state2, continuation, (byte) 13);
                        finiteAnimationSpec = null;
                        gapComposer2.updateRememberedValue(objRememberedValue9);
                    } else {
                        finiteAnimationSpec = null;
                        lazyGridState = lazyGridStateRememberLazyGridState;
                    }
                    Stack.LaunchedEffect(gapComposer2, numValueOf2, (Function2) objRememberedValue9);
                    objRememberedValue10 = gapComposer2.rememberedValue();
                    if (objRememberedValue10 == neverEqualPolicy) {
                        objRememberedValue10 = Stack.mutableStateOf$default(bool);
                        gapComposer2.updateRememberedValue(objRememberedValue10);
                    }
                    mutableState3 = (MutableState) objRememberedValue10;
                    objRememberedValue11 = gapComposer2.rememberedValue();
                    if (objRememberedValue11 == neverEqualPolicy) {
                        objRememberedValue11 = Stack.mutableStateOf$default("");
                        gapComposer2.updateRememberedValue(objRememberedValue11);
                    }
                    final MutableState mutableState4 = (MutableState) objRememberedValue11;
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
                    int iHashCode = Long.hashCode(gapComposer2.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer2, modifier);
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
                    if (((PlaybackException) mutableStateCollectAsState.getValue()) != null) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    EnterTransitionImpl enterTransitionImplFadeIn$default = EnterExitTransitionKt.fadeIn$default(finiteAnimationSpec, CropImageView.DEFAULT_ASPECT_RATIO, 3);
                    boolean z11 = z9;
                    ExitTransitionImpl exitTransitionImplFadeOut$default = EnterExitTransitionKt.fadeOut$default(finiteAnimationSpec, CropImageView.DEFAULT_ASPECT_RATIO, 3);
                    companion = Modifier.Companion.$$INSTANCE;
                    Modifier modifierM135padding3ABfNKs = OffsetKt.m135padding3ABfNKs(companion, 32.0f);
                    BiasAlignment biasAlignment = Alignment.Companion.Center;
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    CrossfadeKt.AnimatedVisibility(z11, boxScopeInstance.align(modifierM135padding3ABfNKs, biasAlignment), enterTransitionImplFadeIn$default, exitTransitionImplFadeOut$default, null, Expect_jvmKt.rememberComposableLambda(648692765, new AlbumMenuKt$$ExternalSyntheticLambda11(mutableStateCollectAsState, playerConnection, (byte) 14), gapComposer2), gapComposer2, 200064, 16);
                    boolean z12 = ((PlaybackException) mutableStateCollectAsState.getValue()) == null;
                    EnterTransitionImpl enterTransitionImplFadeIn$default2 = EnterExitTransitionKt.fadeIn$default(null, CropImageView.DEFAULT_ASPECT_RATIO, 3);
                    ExitTransitionImpl exitTransitionImplFadeOut$default2 = EnterExitTransitionKt.fadeOut$default(null, CropImageView.DEFAULT_ASPECT_RATIO, 3);
                    FillElement fillElement = SizeKt.FillWholeMaxSize;
                    if (z7) {
                        modifierWindowInsetsPadding = companion;
                    } else {
                        modifierWindowInsetsPadding = OffsetKt.windowInsetsPadding(companion, OffsetKt.statusBarsLambda);
                    }
                    Modifier modifierThen = fillElement.then(modifierWindowInsetsPadding);
                    final boolean z13 = z8;
                    final LazyGridState lazyGridState2 = lazyGridState;
                    Function3 function3 = new Function3() { // from class: com.metrolist.music.ui.player.ThumbnailKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            MediaMetadata.Album album;
                            Composer composer2 = (Composer) obj2;
                            int iIntValue = ((Integer) obj3).intValue();
                            ((AnimatedVisibilityScope) obj).getClass();
                            GapComposer gapComposer3 = (GapComposer) composer2;
                            if (gapComposer3.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                                Modifier layoutWeightElement = SizeKt.FillWholeMaxSize;
                                BiasAlignment.Horizontal horizontal = Alignment.Companion.CenterHorizontally;
                                final boolean z14 = z7;
                                ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(z14 ? OffsetKt.Center : OffsetKt.Top, horizontal, gapComposer3, 48);
                                int iHashCode2 = Long.hashCode(gapComposer3.compositeKeyHashCode);
                                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer3.currentCompositionLocalScope();
                                Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer3, layoutWeightElement);
                                ComposeUiNode.Companion.getClass();
                                gapComposer3.startReusableNode();
                                if (gapComposer3.inserting) {
                                    gapComposer3.createNode(LayoutNode.Constructor);
                                } else {
                                    gapComposer3.useNode();
                                }
                                Stack.m390setimpl(gapComposer3, columnMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                                Stack.m390setimpl(gapComposer3, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                                Stack.m390setimpl(gapComposer3, Integer.valueOf(iHashCode2), ComposeUiNode.Companion.SetCompositeKeyHash);
                                Stack.m389reconcileimpl(gapComposer3);
                                Stack.m390setimpl(gapComposer3, modifierMaterializeModifier2, ComposeUiNode.Companion.SetModifier);
                                final long j2 = j;
                                final MutableState mutableState5 = mutableStateCollectAsState2;
                                if (z14) {
                                    gapComposer3.startReplaceGroup(-562664584);
                                    gapComposer3.end(false);
                                } else {
                                    gapComposer3.startReplaceGroup(-562903873);
                                    String str = (String) mutableStateCollectAsStateWithLifecycle4.getValue();
                                    MediaMetadata mediaMetadata2 = (MediaMetadata) mutableState5.getValue();
                                    QueueKt.m1508ThumbnailHeadercf5BqRc(str, (mediaMetadata2 == null || (album = mediaMetadata2.album) == null) ? null : album.title, j2, null, gapComposer3, 0);
                                    gapComposer3.end(false);
                                }
                                BiasAlignment biasAlignment2 = Alignment.Companion.Center;
                                if (z14) {
                                    layoutWeightElement = new LayoutWeightElement(1.0f, false);
                                }
                                Modifier modifier2 = layoutWeightElement;
                                final boolean z15 = z13;
                                final SnapLayoutInfoProvider snapLayoutInfoProvider2 = snapLayoutInfoProvider;
                                final LazyGridState lazyGridState3 = lazyGridState2;
                                final ArrayList arrayList2 = arrayList;
                                final MutableState mutableState6 = dataStoreKt$rememberPreference$1$1RememberPreference;
                                final MutableState mutableState7 = dataStoreKt$rememberPreference$1$1RememberPreference2;
                                final LayoutDirection layoutDirection2 = layoutDirection;
                                final PlayerConnection playerConnection2 = playerConnection;
                                final Context context3 = context2;
                                final boolean z16 = z2;
                                final MutableState mutableState8 = mutableState4;
                                final MutableState mutableState9 = mutableState3;
                                final Function0 function4 = function1;
                                OffsetKt.BoxWithConstraints(modifier2, biasAlignment2, Expect_jvmKt.rememberComposableLambda(-1635403616, new Function3() { // from class: com.metrolist.music.ui.player.ThumbnailKt$$ExternalSyntheticLambda10
                                    @Override // kotlin.jvm.functions.Function3
                                    public final Object invoke(Object obj4, Object obj5, Object obj6) {
                                        float f;
                                        Modifier modifierM151size3ABfNKs;
                                        BoxWithConstraintsScopeImpl boxWithConstraintsScopeImpl = (BoxWithConstraintsScopeImpl) obj4;
                                        Composer composer3 = (Composer) obj5;
                                        int iIntValue2 = ((Integer) obj6).intValue();
                                        boxWithConstraintsScopeImpl.getClass();
                                        if ((iIntValue2 & 6) == 0) {
                                            iIntValue2 |= ((GapComposer) composer3).changed(boxWithConstraintsScopeImpl) ? 4 : 2;
                                        }
                                        byte b4 = 1;
                                        GapComposer gapComposer4 = (GapComposer) composer3;
                                        if (gapComposer4.shouldExecute(iIntValue2 & 1, (iIntValue2 & 19) != 18)) {
                                            boolean zChanged6 = gapComposer4.changed(boxWithConstraintsScopeImpl.m118getMaxWidthD9Ej5fM()) | gapComposer4.changed(boxWithConstraintsScopeImpl.m117getMaxHeightD9Ej5fM());
                                            final boolean z17 = z14;
                                            boolean zChanged7 = zChanged6 | gapComposer4.changed(z17);
                                            Object objRememberedValue14 = gapComposer4.rememberedValue();
                                            NeverEqualPolicy neverEqualPolicy2 = Composer.Companion.Empty;
                                            if (zChanged7 || objRememberedValue14 == neverEqualPolicy2) {
                                                float fM118getMaxWidthD9Ej5fM = boxWithConstraintsScopeImpl.m118getMaxWidthD9Ej5fM();
                                                float fM117getMaxHeightD9Ej5fM = boxWithConstraintsScopeImpl.m117getMaxHeightD9Ej5fM();
                                                if (z17) {
                                                    Dp dp = new Dp(fM118getMaxWidthD9Ej5fM);
                                                    Dp dp2 = new Dp(fM117getMaxHeightD9Ej5fM);
                                                    if (dp.compareTo(dp2) > 0) {
                                                        dp = dp2;
                                                    }
                                                    f = (dp.value - 40.0f) + CropImageView.DEFAULT_ASPECT_RATIO;
                                                } else {
                                                    Dp dp3 = new Dp((fM118getMaxWidthD9Ej5fM - 40.0f) + CropImageView.DEFAULT_ASPECT_RATIO);
                                                    float f2 = (fM117getMaxHeightD9Ej5fM - 8.0f) + CropImageView.DEFAULT_ASPECT_RATIO;
                                                    if (f2 < CropImageView.DEFAULT_ASPECT_RATIO) {
                                                        f2 = 0.0f;
                                                    }
                                                    Dp dp4 = new Dp(f2);
                                                    if (dp3.compareTo(dp4) > 0) {
                                                        dp3 = dp4;
                                                    }
                                                    f = dp3.value;
                                                }
                                                objRememberedValue14 = new ThumbnailDimensions(fM118getMaxWidthD9Ej5fM, fM118getMaxWidthD9Ej5fM, f);
                                                gapComposer4.updateRememberedValue(objRememberedValue14);
                                            }
                                            final ThumbnailDimensions thumbnailDimensions = (ThumbnailDimensions) objRememberedValue14;
                                            Object objRememberedValue15 = gapComposer4.rememberedValue();
                                            if (objRememberedValue15 == neverEqualPolicy2) {
                                                objRememberedValue15 = new SongMenuKt$$ExternalSyntheticLambda19(mutableState8, mutableState9, b4);
                                                gapComposer4.updateRememberedValue(objRememberedValue15);
                                            }
                                            final Function2 function5 = (Function2) objRememberedValue15;
                                            boolean z18 = z15;
                                            boolean zChanged8 = gapComposer4.changed(z18);
                                            Object objRememberedValue16 = gapComposer4.rememberedValue();
                                            if (zChanged8 || objRememberedValue16 == neverEqualPolicy2) {
                                                objRememberedValue16 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ThumbnailKt$$ExternalSyntheticLambda13((byte) 0, function4, z18));
                                                gapComposer4.updateRememberedValue(objRememberedValue16);
                                            }
                                            GridCells$Fixed gridCells$Fixed = new GridCells$Fixed(1);
                                            SnapFlingBehavior snapFlingBehaviorRememberSnapFlingBehavior = SQLite.rememberSnapFlingBehavior(snapLayoutInfoProvider2, gapComposer4);
                                            boolean zBooleanValue = ((Boolean) ((State) objRememberedValue16).getValue()).booleanValue();
                                            if (z17) {
                                                modifierM151size3ABfNKs = SizeKt.m151size3ABfNKs(Modifier.Companion.$$INSTANCE, thumbnailDimensions.thumbnailSize + 40.0f + CropImageView.DEFAULT_ASPECT_RATIO);
                                            } else {
                                                modifierM151size3ABfNKs = SizeKt.FillWholeMaxSize;
                                            }
                                            final ArrayList arrayList3 = arrayList2;
                                            boolean zChangedInstance = gapComposer4.changedInstance(arrayList3) | gapComposer4.changed(thumbnailDimensions);
                                            final MutableState mutableState10 = mutableState6;
                                            boolean zChanged9 = zChangedInstance | gapComposer4.changed(mutableState10);
                                            final MutableState mutableState11 = mutableState7;
                                            boolean zChanged10 = zChanged9 | gapComposer4.changed(mutableState11);
                                            final long j3 = j2;
                                            boolean zChanged11 = zChanged10 | gapComposer4.changed(j3);
                                            final LayoutDirection layoutDirection3 = layoutDirection2;
                                            boolean zChanged12 = zChanged11 | gapComposer4.changed(layoutDirection3.ordinal());
                                            final PlayerConnection playerConnection3 = playerConnection2;
                                            boolean zChangedInstance2 = zChanged12 | gapComposer4.changedInstance(playerConnection3);
                                            final Context context4 = context3;
                                            boolean zChangedInstance3 = zChangedInstance2 | gapComposer4.changedInstance(context4) | gapComposer4.changed(z17);
                                            final boolean z19 = z16;
                                            boolean zChanged13 = zChangedInstance3 | gapComposer4.changed(z19);
                                            final MutableState mutableState12 = mutableState5;
                                            boolean zChanged14 = zChanged13 | gapComposer4.changed(mutableState12);
                                            Object objRememberedValue17 = gapComposer4.rememberedValue();
                                            if (zChanged14 || objRememberedValue17 == neverEqualPolicy2) {
                                                Function1 function6 = new Function1() { // from class: com.metrolist.music.ui.player.ThumbnailKt$$ExternalSyntheticLambda14
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj7) {
                                                        LazyGridIntervalContent lazyGridIntervalContent = (LazyGridIntervalContent) obj7;
                                                        lazyGridIntervalContent.getClass();
                                                        QueueKt$$ExternalSyntheticLambda4 queueKt$$ExternalSyntheticLambda4 = new QueueKt$$ExternalSyntheticLambda4((byte) 2);
                                                        final ArrayList arrayList4 = arrayList3;
                                                        int size = arrayList4.size();
                                                        Latch$await$2$2 latch$await$2$2 = new Latch$await$2$2(queueKt$$ExternalSyntheticLambda4, arrayList4, (byte) 18);
                                                        AndroidPopup_androidKt$SimpleStack$1$1.AnonymousClass3 anonymousClass3 = new AndroidPopup_androidKt$SimpleStack$1$1.AnonymousClass3(arrayList4, (byte) 4);
                                                        final ThumbnailDimensions thumbnailDimensions2 = thumbnailDimensions;
                                                        final long j4 = j3;
                                                        final LayoutDirection layoutDirection4 = layoutDirection3;
                                                        final Function2 function7 = function5;
                                                        final PlayerConnection playerConnection4 = playerConnection3;
                                                        final Context context5 = context4;
                                                        final boolean z20 = z17;
                                                        final boolean z21 = z19;
                                                        final MutableState mutableState13 = mutableState10;
                                                        final MutableState mutableState14 = mutableState11;
                                                        final MutableState mutableState15 = mutableState12;
                                                        lazyGridIntervalContent.items(size, latch$await$2$2, null, anonymousClass3, new ComposableLambdaImpl(true, -1117249557, new Function4() { // from class: com.metrolist.music.ui.player.ThumbnailKt$Thumbnail$lambda$27$1$0$0$4$0$$inlined$items$default$5
                                                            @Override // kotlin.jvm.functions.Function4
                                                            public final Object invoke(Object obj8, Object obj9, Object obj10, Object obj11) throws XmlPullParserException, IOException {
                                                                int i9;
                                                                LazyGridItemScopeImpl lazyGridItemScopeImpl = (LazyGridItemScopeImpl) obj8;
                                                                int iIntValue3 = ((Number) obj9).intValue();
                                                                Composer composer4 = (Composer) obj10;
                                                                int iIntValue4 = ((Number) obj11).intValue();
                                                                if ((iIntValue4 & 6) == 0) {
                                                                    i9 = (((GapComposer) composer4).changed(lazyGridItemScopeImpl) ? 4 : 2) | iIntValue4;
                                                                } else {
                                                                    i9 = iIntValue4;
                                                                }
                                                                if ((iIntValue4 & 48) == 0) {
                                                                    i9 |= ((GapComposer) composer4).changed(iIntValue3) ? 32 : 16;
                                                                }
                                                                GapComposer gapComposer5 = (GapComposer) composer4;
                                                                if (gapComposer5.shouldExecute(i9 & 1, (i9 & 147) != 146)) {
                                                                    MediaItem mediaItem = (MediaItem) arrayList4.get(iIntValue3);
                                                                    gapComposer5.startReplaceGroup(-601929668);
                                                                    boolean zBooleanValue2 = ((Boolean) mutableState13.getValue()).booleanValue();
                                                                    boolean zBooleanValue3 = ((Boolean) mutableState14.getValue()).booleanValue();
                                                                    MutableState mutableState16 = mutableState15;
                                                                    MediaMetadata mediaMetadata3 = (MediaMetadata) mutableState16.getValue();
                                                                    String str2 = mediaMetadata3 != null ? mediaMetadata3.id : null;
                                                                    MediaMetadata mediaMetadata4 = (MediaMetadata) mutableState16.getValue();
                                                                    QueueKt.m1509ThumbnailItemB9xY6lo(mediaItem, thumbnailDimensions2, zBooleanValue2, zBooleanValue3, j4, layoutDirection4, function7, playerConnection4, context5, z20, z21, str2, mediaMetadata4 != null ? mediaMetadata4.thumbnailUrl : null, null, gapComposer5, 18350080);
                                                                    gapComposer5.end(false);
                                                                } else {
                                                                    gapComposer5.skipToGroupEnd();
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        }));
                                                        return Unit.INSTANCE;
                                                    }
                                                };
                                                gapComposer4.updateRememberedValue(function6);
                                                objRememberedValue17 = function6;
                                            }
                                            LifecyclesKt.LazyHorizontalGrid(gridCells$Fixed, modifierM151size3ABfNKs, lazyGridState3, null, null, null, snapFlingBehaviorRememberSnapFlingBehavior, zBooleanValue, null, null, (Function1) objRememberedValue17, gapComposer4, 0, 1656);
                                        } else {
                                            gapComposer4.skipToGroupEnd();
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }, gapComposer3), gapComposer3, 3120, 4);
                                gapComposer3.end(true);
                            } else {
                                gapComposer3.skipToGroupEnd();
                            }
                            return Unit.INSTANCE;
                        }
                    };
                    gapComposer = gapComposer2;
                    CrossfadeKt.AnimatedVisibility(z12, modifierThen, enterTransitionImplFadeIn$default2, exitTransitionImplFadeOut$default2, null, Expect_jvmKt.rememberComposableLambda(2051219412, function3, gapComposer), gapComposer, 200064, 16);
                    Boolean bool4 = (Boolean) mutableState3.getValue();
                    bool4.getClass();
                    objRememberedValue12 = gapComposer.rememberedValue();
                    if (objRememberedValue12 == neverEqualPolicy) {
                        finiteAnimationSpec2 = null;
                        objRememberedValue12 = new ItemsKt$reset$1(mutableState3, 0 == true ? 1 : 0, (byte) 2);
                        gapComposer.updateRememberedValue(objRememberedValue12);
                    } else {
                        finiteAnimationSpec2 = null;
                    }
                    Stack.LaunchedEffect(gapComposer, bool4, (Function2) objRememberedValue12);
                    CrossfadeKt.AnimatedVisibility(((Boolean) mutableState3.getValue()).booleanValue(), boxScopeInstance.align(companion, biasAlignment), EnterExitTransitionKt.fadeIn$default(finiteAnimationSpec2, CropImageView.DEFAULT_ASPECT_RATIO, 3), EnterExitTransitionKt.fadeOut$default(finiteAnimationSpec2, CropImageView.DEFAULT_ASPECT_RATIO, 3), null, Expect_jvmKt.rememberComposableLambda(-1994469483, new QueueKt$$ExternalSyntheticLambda21(mutableState4, (byte) 17), gapComposer), gapComposer, 200064, 16);
                    gapComposer.end(true);
                    z5 = z7;
                }
                recomposeScopeImplEndRestartGroup.block = function2;
            }
            gapComposer = gapComposer2;
            gapComposer.skipToGroupEnd();
            z5 = z3;
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                final byte b4 = 1;
                function2 = new Function2() { // from class: com.metrolist.music.ui.player.ThumbnailKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        byte b5 = b4;
                        Unit unit = Unit.INSTANCE;
                        short s = i;
                        switch (b5) {
                            case 0:
                                ((Integer) obj2).getClass();
                                int iUpdateChangedFlags = Stack.updateChangedFlags(s | 1);
                                QueueKt.Thumbnail(function0, modifier, function1, z5, z2, (Composer) obj, iUpdateChangedFlags, i2);
                                break;
                            default:
                                ((Integer) obj2).getClass();
                                int iUpdateChangedFlags2 = Stack.updateChangedFlags(s | 1);
                                QueueKt.Thumbnail(function0, modifier, function1, z5, z2, (Composer) obj, iUpdateChangedFlags2, i2);
                                break;
                        }
                        return unit;
                    }
                };
                recomposeScopeImplEndRestartGroup.block = function2;
            }
        }
        i7 |= 3072;
        z3 = z;
        if (gapComposer2.changed(z2)) {
            i3 = 16384;
        } else {
            i3 = 8192;
        }
        i4 = i7 | i3;
        if ((i4 & 9361) != 9360) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (gapComposer2.shouldExecute(i4 & 1, z4)) {
            if (i8 != 0) {
                z6 = false;
            } else {
                z6 = z3;
            }
            playerConnection = (PlayerConnection) gapComposer2.consume(MainActivityKt.LocalPlayerConnection);
            if (playerConnection == null) {
                recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    return;
                }
                final byte b5 = 0;
                final boolean z14 = z6;
                function2 = new Function2() { // from class: com.metrolist.music.ui.player.ThumbnailKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        byte b6 = b5;
                        Unit unit = Unit.INSTANCE;
                        short s = i;
                        switch (b6) {
                            case 0:
                                ((Integer) obj2).getClass();
                                int iUpdateChangedFlags = Stack.updateChangedFlags(s | 1);
                                QueueKt.Thumbnail(function0, modifier, function1, z14, z2, (Composer) obj, iUpdateChangedFlags, i2);
                                break;
                            default:
                                ((Integer) obj2).getClass();
                                int iUpdateChangedFlags2 = Stack.updateChangedFlags(s | 1);
                                QueueKt.Thumbnail(function0, modifier, function1, z14, z2, (Composer) obj, iUpdateChangedFlags2, i2);
                                break;
                        }
                        return unit;
                    }
                };
            } else {
                z7 = z6;
                StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = AndroidCompositionLocals_androidKt.LocalContext;
                final Context context3 = (Context) gapComposer2.consume(staticProvidableCompositionLocal2);
                final LayoutDirection layoutDirection2 = (LayoutDirection) gapComposer2.consume(CompositionLocalsKt.LocalLayoutDirection);
                final MutableState mutableStateCollectAsState3 = Stack.collectAsState(playerConnection.mediaMetadata, gapComposer2, 3);
                mutableStateCollectAsState = Stack.collectAsState(playerConnection.error, gapComposer2, 3);
                final MutableState mutableStateCollectAsStateWithLifecycle5 = FileSystemsKt.collectAsStateWithLifecycle(playerConnection.queueTitle, gapComposer2);
                mutableStateCollectAsStateWithLifecycle = FileSystemsKt.collectAsStateWithLifecycle(playerConnection.canSkipPrevious, gapComposer2);
                mutableStateCollectAsStateWithLifecycle2 = FileSystemsKt.collectAsStateWithLifecycle(playerConnection.canSkipNext, gapComposer2);
                if (((Boolean) UtilsKt.rememberPreference(PreferenceKeysKt.SwipeThumbnailKey, Boolean.TRUE, gapComposer2, 48).$state.getValue()).booleanValue()) {
                    z8 = false;
                } else {
                    z8 = false;
                }
                Preferences$Key preferences$Key3 = PreferenceKeysKt.HidePlayerThumbnailKey;
                bool = Boolean.FALSE;
                final DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference3 = UtilsKt.rememberPreference(preferences$Key3, bool, gapComposer2, 48);
                final DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference4 = UtilsKt.rememberPreference(PreferenceKeysKt.CropAlbumArtKey, bool, gapComposer2, 48);
                preferences$Key = PreferenceKeysKt.PlayerBackgroundStyleKey;
                context = (Context) gapComposer2.consume(staticProvidableCompositionLocal2);
                objRememberedValue = gapComposer2.rememberedValue();
                neverEqualPolicy = Composer.Companion.Empty;
                if (objRememberedValue == neverEqualPolicy) {
                    objRememberedValue = Stack.createCompositionCoroutineScope(gapComposer2);
                    gapComposer2.updateRememberedValue(objRememberedValue);
                }
                coroutineScope = (CoroutineScope) objRememberedValue;
                objRememberedValue2 = gapComposer2.rememberedValue();
                if (objRememberedValue2 == neverEqualPolicy) {
                    objRememberedValue2 = StateFlowKt.distinctUntilChanged(new MainActivity$MetrolistApp$$inlined$rememberEnumPreference$1(UtilsKt.getDataStore(context).getData(), preferences$Key, (byte) 19));
                    gapComposer2.updateRememberedValue(objRememberedValue2);
                }
                mutableStateCollectAsStateWithLifecycle3 = FileSystemsKt.collectAsStateWithLifecycle((Flow) objRememberedValue2, PlayerBackgroundStyle.DEFAULT, gapComposer2, 48);
                objRememberedValue3 = gapComposer2.rememberedValue();
                if (objRememberedValue3 == neverEqualPolicy) {
                    objRememberedValue3 = new ThumbnailKt$Thumbnail$$inlined$rememberEnumPreference$2(mutableStateCollectAsStateWithLifecycle3, coroutineScope, context, preferences$Key);
                    gapComposer2.updateRememberedValue(objRememberedValue3);
                }
                final long j2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.onBackground;
                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(gapComposer2);
                int currentMediaItemIndex2 = playerConnection.getPlayerSafe().getCurrentMediaItemIndex();
                ExoPlayerImpl playerSafe2 = playerConnection.getPlayerSafe();
                playerSafe2.verifyApplicationThread();
                zChanged = gapComposer2.changed(currentMediaItemIndex2) | gapComposer2.changed(playerSafe2.shuffleModeEnabled) | gapComposer2.changed(z8) | gapComposer2.changed((MediaMetadata) mutableStateCollectAsState3.getValue());
                objRememberedValue4 = gapComposer2.rememberedValue();
                if (zChanged) {
                    objRememberedValue4 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ThumbnailKt$$ExternalSyntheticLambda1(playerConnection, z8, (byte) 0));
                    gapComposer2.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ThumbnailKt$$ExternalSyntheticLambda1(playerConnection, z8, (byte) 0));
                    gapComposer2.updateRememberedValue(objRememberedValue4);
                }
                state = (State) objRememberedValue4;
                arrayList = ((MediaItemsData) state.getValue()).items;
                i5 = ((MediaItemsData) state.getValue()).currentIndex;
                zChanged2 = gapComposer2.changed(lazyGridStateRememberLazyGridState);
                objRememberedValue5 = gapComposer2.rememberedValue();
                b = 2;
                if (zChanged2) {
                    QueueKt$$ExternalSyntheticLambda3 queueKt$$ExternalSyntheticLambda4 = new QueueKt$$ExternalSyntheticLambda3(b);
                    lazyGridStateRememberLazyGridState.getClass();
                    b2 = 0;
                    ThumbnailSnapUtilsKt$ThumbnailSnapLayoutInfoProvider$2 thumbnailSnapUtilsKt$ThumbnailSnapLayoutInfoProvider$3 = new ThumbnailSnapUtilsKt$ThumbnailSnapLayoutInfoProvider$2(lazyGridStateRememberLazyGridState, queueKt$$ExternalSyntheticLambda4, b2);
                    gapComposer2.updateRememberedValue(thumbnailSnapUtilsKt$ThumbnailSnapLayoutInfoProvider$3);
                    objRememberedValue5 = thumbnailSnapUtilsKt$ThumbnailSnapLayoutInfoProvider$3;
                } else {
                    QueueKt$$ExternalSyntheticLambda3 queueKt$$ExternalSyntheticLambda5 = new QueueKt$$ExternalSyntheticLambda3(b);
                    lazyGridStateRememberLazyGridState.getClass();
                    b2 = 0;
                    ThumbnailSnapUtilsKt$ThumbnailSnapLayoutInfoProvider$2 thumbnailSnapUtilsKt$ThumbnailSnapLayoutInfoProvider$4 = new ThumbnailSnapUtilsKt$ThumbnailSnapLayoutInfoProvider$2(lazyGridStateRememberLazyGridState, queueKt$$ExternalSyntheticLambda5, b2);
                    gapComposer2.updateRememberedValue(thumbnailSnapUtilsKt$ThumbnailSnapLayoutInfoProvider$4);
                    objRememberedValue5 = thumbnailSnapUtilsKt$ThumbnailSnapLayoutInfoProvider$4;
                }
                final SnapLayoutInfoProvider snapLayoutInfoProvider2 = (SnapLayoutInfoProvider) objRememberedValue5;
                objRememberedValue6 = gapComposer2.rememberedValue();
                if (objRememberedValue6 == neverEqualPolicy) {
                    objRememberedValue6 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ThumbnailKt$$ExternalSyntheticLambda3(lazyGridStateRememberLazyGridState, b2));
                    gapComposer2.updateRememberedValue(objRememberedValue6);
                }
                state2 = (State) objRememberedValue6;
                objRememberedValue7 = gapComposer2.rememberedValue();
                if (objRememberedValue7 == neverEqualPolicy) {
                    objRememberedValue7 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ThumbnailKt$$ExternalSyntheticLambda3(lazyGridStateRememberLazyGridState, (byte) 3));
                    gapComposer2.updateRememberedValue(objRememberedValue7);
                }
                state3 = (State) objRememberedValue7;
                Integer numValueOf3 = Integer.valueOf(((Number) state3.getValue()).intValue());
                zChanged3 = gapComposer2.changed(lazyGridStateRememberLazyGridState) | gapComposer2.changed(z8) | gapComposer2.changed(i5) | gapComposer2.changed(mutableStateCollectAsStateWithLifecycle2) | gapComposer2.changedInstance(playerConnection) | gapComposer2.changed(mutableStateCollectAsStateWithLifecycle);
                Object objRememberedValue14 = gapComposer2.rememberedValue();
                if (zChanged3) {
                    mutableState = mutableStateCollectAsStateWithLifecycle;
                    mutableState2 = mutableStateCollectAsStateWithLifecycle2;
                    i6 = i5;
                    thumbnailKt$Thumbnail$2$1 = new ThumbnailKt$Thumbnail$2$1(lazyGridStateRememberLazyGridState, z8, i6, playerConnection, state3, state2, mutableState2, mutableState, null);
                    playerConnection = playerConnection;
                    gapComposer2.updateRememberedValue(thumbnailKt$Thumbnail$2$1);
                } else {
                    mutableState = mutableStateCollectAsStateWithLifecycle;
                    mutableState2 = mutableStateCollectAsStateWithLifecycle2;
                    i6 = i5;
                    thumbnailKt$Thumbnail$2$1 = new ThumbnailKt$Thumbnail$2$1(lazyGridStateRememberLazyGridState, z8, i6, playerConnection, state3, state2, mutableState2, mutableState, null);
                    playerConnection = playerConnection;
                    gapComposer2.updateRememberedValue(thumbnailKt$Thumbnail$2$1);
                }
                Stack.LaunchedEffect(gapComposer2, numValueOf3, (Function2) thumbnailKt$Thumbnail$2$1);
                MediaMetadata mediaMetadata2 = (MediaMetadata) mutableStateCollectAsState3.getValue();
                Boolean bool5 = (Boolean) mutableState.getValue();
                bool5.getClass();
                Boolean bool6 = (Boolean) mutableState2.getValue();
                bool6.getClass();
                zChanged4 = gapComposer2.changed(i6) | gapComposer2.changedInstance(arrayList) | gapComposer2.changed(lazyGridStateRememberLazyGridState);
                objRememberedValue8 = gapComposer2.rememberedValue();
                continuation = null;
                if (zChanged4) {
                    objRememberedValue8 = new Updater$getAllReleases$2(i6, arrayList, lazyGridStateRememberLazyGridState, null);
                    gapComposer2.updateRememberedValue(objRememberedValue8);
                } else {
                    objRememberedValue8 = new Updater$getAllReleases$2(i6, arrayList, lazyGridStateRememberLazyGridState, null);
                    gapComposer2.updateRememberedValue(objRememberedValue8);
                }
                Stack.LaunchedEffect(mediaMetadata2, bool5, bool6, (Function2) objRememberedValue8, gapComposer2);
                Integer numValueOf4 = Integer.valueOf(playerConnection.getPlayerSafe().getCurrentMediaItemIndex());
                zChanged5 = gapComposer2.changed(state) | gapComposer2.changed(lazyGridStateRememberLazyGridState);
                objRememberedValue9 = gapComposer2.rememberedValue();
                if (zChanged5) {
                    lazyGridState = lazyGridStateRememberLazyGridState;
                    objRememberedValue9 = new DataStoreKt$get$2((Object) lazyGridState, (Object) state, (Object) state2, continuation, (byte) 13);
                    finiteAnimationSpec = null;
                    gapComposer2.updateRememberedValue(objRememberedValue9);
                } else {
                    lazyGridState = lazyGridStateRememberLazyGridState;
                    objRememberedValue9 = new DataStoreKt$get$2((Object) lazyGridState, (Object) state, (Object) state2, continuation, (byte) 13);
                    finiteAnimationSpec = null;
                    gapComposer2.updateRememberedValue(objRememberedValue9);
                }
                Stack.LaunchedEffect(gapComposer2, numValueOf4, (Function2) objRememberedValue9);
                objRememberedValue10 = gapComposer2.rememberedValue();
                if (objRememberedValue10 == neverEqualPolicy) {
                    objRememberedValue10 = Stack.mutableStateOf$default(bool);
                    gapComposer2.updateRememberedValue(objRememberedValue10);
                }
                mutableState3 = (MutableState) objRememberedValue10;
                objRememberedValue11 = gapComposer2.rememberedValue();
                if (objRememberedValue11 == neverEqualPolicy) {
                    objRememberedValue11 = Stack.mutableStateOf$default("");
                    gapComposer2.updateRememberedValue(objRememberedValue11);
                }
                final MutableState mutableState5 = (MutableState) objRememberedValue11;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
                int iHashCode2 = Long.hashCode(gapComposer2.compositeKeyHashCode);
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer2.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer2, modifier);
                ComposeUiNode.Companion.getClass();
                gapComposer2.startReusableNode();
                if (gapComposer2.inserting) {
                    gapComposer2.createNode(LayoutNode.Constructor);
                } else {
                    gapComposer2.useNode();
                }
                Stack.m390setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.SetMeasurePolicy);
                Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                Stack.m390setimpl(gapComposer2, Integer.valueOf(iHashCode2), ComposeUiNode.Companion.SetCompositeKeyHash);
                Stack.m389reconcileimpl(gapComposer2);
                Stack.m390setimpl(gapComposer2, modifierMaterializeModifier2, ComposeUiNode.Companion.SetModifier);
                if (((PlaybackException) mutableStateCollectAsState.getValue()) != null) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                EnterTransitionImpl enterTransitionImplFadeIn$default3 = EnterExitTransitionKt.fadeIn$default(finiteAnimationSpec, CropImageView.DEFAULT_ASPECT_RATIO, 3);
                boolean z15 = z9;
                ExitTransitionImpl exitTransitionImplFadeOut$default3 = EnterExitTransitionKt.fadeOut$default(finiteAnimationSpec, CropImageView.DEFAULT_ASPECT_RATIO, 3);
                companion = Modifier.Companion.$$INSTANCE;
                Modifier modifierM135padding3ABfNKs2 = OffsetKt.m135padding3ABfNKs(companion, 32.0f);
                BiasAlignment biasAlignment2 = Alignment.Companion.Center;
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                CrossfadeKt.AnimatedVisibility(z15, boxScopeInstance2.align(modifierM135padding3ABfNKs2, biasAlignment2), enterTransitionImplFadeIn$default3, exitTransitionImplFadeOut$default3, null, Expect_jvmKt.rememberComposableLambda(648692765, new AlbumMenuKt$$ExternalSyntheticLambda11(mutableStateCollectAsState, playerConnection, (byte) 14), gapComposer2), gapComposer2, 200064, 16);
                if (((PlaybackException) mutableStateCollectAsState.getValue()) == null) {
                }
                EnterTransitionImpl enterTransitionImplFadeIn$default4 = EnterExitTransitionKt.fadeIn$default(null, CropImageView.DEFAULT_ASPECT_RATIO, 3);
                ExitTransitionImpl exitTransitionImplFadeOut$default4 = EnterExitTransitionKt.fadeOut$default(null, CropImageView.DEFAULT_ASPECT_RATIO, 3);
                FillElement fillElement2 = SizeKt.FillWholeMaxSize;
                if (z7) {
                    modifierWindowInsetsPadding = OffsetKt.windowInsetsPadding(companion, OffsetKt.statusBarsLambda);
                } else {
                    modifierWindowInsetsPadding = companion;
                }
                Modifier modifierThen2 = fillElement2.then(modifierWindowInsetsPadding);
                final boolean z16 = z8;
                final LazyGridState lazyGridState3 = lazyGridState;
                Function3 function4 = new Function3() { // from class: com.metrolist.music.ui.player.ThumbnailKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        MediaMetadata.Album album;
                        Composer composer2 = (Composer) obj2;
                        int iIntValue = ((Integer) obj3).intValue();
                        ((AnimatedVisibilityScope) obj).getClass();
                        GapComposer gapComposer3 = (GapComposer) composer2;
                        if (gapComposer3.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                            Modifier layoutWeightElement = SizeKt.FillWholeMaxSize;
                            BiasAlignment.Horizontal horizontal = Alignment.Companion.CenterHorizontally;
                            final boolean z17 = z7;
                            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(z17 ? OffsetKt.Center : OffsetKt.Top, horizontal, gapComposer3, 48);
                            int iHashCode3 = Long.hashCode(gapComposer3.compositeKeyHashCode);
                            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer3.currentCompositionLocalScope();
                            Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer3, layoutWeightElement);
                            ComposeUiNode.Companion.getClass();
                            gapComposer3.startReusableNode();
                            if (gapComposer3.inserting) {
                                gapComposer3.createNode(LayoutNode.Constructor);
                            } else {
                                gapComposer3.useNode();
                            }
                            Stack.m390setimpl(gapComposer3, columnMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                            Stack.m390setimpl(gapComposer3, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                            Stack.m390setimpl(gapComposer3, Integer.valueOf(iHashCode3), ComposeUiNode.Companion.SetCompositeKeyHash);
                            Stack.m389reconcileimpl(gapComposer3);
                            Stack.m390setimpl(gapComposer3, modifierMaterializeModifier3, ComposeUiNode.Companion.SetModifier);
                            final long j3 = j2;
                            final MutableState mutableState6 = mutableStateCollectAsState3;
                            if (z17) {
                                gapComposer3.startReplaceGroup(-562664584);
                                gapComposer3.end(false);
                            } else {
                                gapComposer3.startReplaceGroup(-562903873);
                                String str = (String) mutableStateCollectAsStateWithLifecycle5.getValue();
                                MediaMetadata mediaMetadata3 = (MediaMetadata) mutableState6.getValue();
                                QueueKt.m1508ThumbnailHeadercf5BqRc(str, (mediaMetadata3 == null || (album = mediaMetadata3.album) == null) ? null : album.title, j3, null, gapComposer3, 0);
                                gapComposer3.end(false);
                            }
                            BiasAlignment biasAlignment3 = Alignment.Companion.Center;
                            if (z17) {
                                layoutWeightElement = new LayoutWeightElement(1.0f, false);
                            }
                            Modifier modifier2 = layoutWeightElement;
                            final boolean z18 = z16;
                            final SnapLayoutInfoProvider snapLayoutInfoProvider3 = snapLayoutInfoProvider2;
                            final LazyGridState lazyGridState4 = lazyGridState3;
                            final ArrayList arrayList2 = arrayList;
                            final MutableState mutableState7 = dataStoreKt$rememberPreference$1$1RememberPreference3;
                            final MutableState mutableState8 = dataStoreKt$rememberPreference$1$1RememberPreference4;
                            final LayoutDirection layoutDirection3 = layoutDirection2;
                            final PlayerConnection playerConnection2 = playerConnection;
                            final Context context4 = context3;
                            final boolean z19 = z2;
                            final MutableState mutableState9 = mutableState5;
                            final MutableState mutableState10 = mutableState3;
                            final Function0 function5 = function1;
                            OffsetKt.BoxWithConstraints(modifier2, biasAlignment3, Expect_jvmKt.rememberComposableLambda(-1635403616, new Function3() { // from class: com.metrolist.music.ui.player.ThumbnailKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj4, Object obj5, Object obj6) {
                                    float f;
                                    Modifier modifierM151size3ABfNKs;
                                    BoxWithConstraintsScopeImpl boxWithConstraintsScopeImpl = (BoxWithConstraintsScopeImpl) obj4;
                                    Composer composer3 = (Composer) obj5;
                                    int iIntValue2 = ((Integer) obj6).intValue();
                                    boxWithConstraintsScopeImpl.getClass();
                                    if ((iIntValue2 & 6) == 0) {
                                        iIntValue2 |= ((GapComposer) composer3).changed(boxWithConstraintsScopeImpl) ? 4 : 2;
                                    }
                                    byte b6 = 1;
                                    GapComposer gapComposer4 = (GapComposer) composer3;
                                    if (gapComposer4.shouldExecute(iIntValue2 & 1, (iIntValue2 & 19) != 18)) {
                                        boolean zChanged6 = gapComposer4.changed(boxWithConstraintsScopeImpl.m118getMaxWidthD9Ej5fM()) | gapComposer4.changed(boxWithConstraintsScopeImpl.m117getMaxHeightD9Ej5fM());
                                        final boolean z110 = z17;
                                        boolean zChanged7 = zChanged6 | gapComposer4.changed(z110);
                                        Object objRememberedValue15 = gapComposer4.rememberedValue();
                                        NeverEqualPolicy neverEqualPolicy2 = Composer.Companion.Empty;
                                        if (zChanged7 || objRememberedValue15 == neverEqualPolicy2) {
                                            float fM118getMaxWidthD9Ej5fM = boxWithConstraintsScopeImpl.m118getMaxWidthD9Ej5fM();
                                            float fM117getMaxHeightD9Ej5fM = boxWithConstraintsScopeImpl.m117getMaxHeightD9Ej5fM();
                                            if (z110) {
                                                Dp dp = new Dp(fM118getMaxWidthD9Ej5fM);
                                                Dp dp2 = new Dp(fM117getMaxHeightD9Ej5fM);
                                                if (dp.compareTo(dp2) > 0) {
                                                    dp = dp2;
                                                }
                                                f = (dp.value - 40.0f) + CropImageView.DEFAULT_ASPECT_RATIO;
                                            } else {
                                                Dp dp3 = new Dp((fM118getMaxWidthD9Ej5fM - 40.0f) + CropImageView.DEFAULT_ASPECT_RATIO);
                                                float f2 = (fM117getMaxHeightD9Ej5fM - 8.0f) + CropImageView.DEFAULT_ASPECT_RATIO;
                                                if (f2 < CropImageView.DEFAULT_ASPECT_RATIO) {
                                                    f2 = 0.0f;
                                                }
                                                Dp dp4 = new Dp(f2);
                                                if (dp3.compareTo(dp4) > 0) {
                                                    dp3 = dp4;
                                                }
                                                f = dp3.value;
                                            }
                                            objRememberedValue15 = new ThumbnailDimensions(fM118getMaxWidthD9Ej5fM, fM118getMaxWidthD9Ej5fM, f);
                                            gapComposer4.updateRememberedValue(objRememberedValue15);
                                        }
                                        final ThumbnailDimensions thumbnailDimensions = (ThumbnailDimensions) objRememberedValue15;
                                        Object objRememberedValue16 = gapComposer4.rememberedValue();
                                        if (objRememberedValue16 == neverEqualPolicy2) {
                                            objRememberedValue16 = new SongMenuKt$$ExternalSyntheticLambda19(mutableState9, mutableState10, b6);
                                            gapComposer4.updateRememberedValue(objRememberedValue16);
                                        }
                                        final Function2 function6 = (Function2) objRememberedValue16;
                                        boolean z111 = z18;
                                        boolean zChanged8 = gapComposer4.changed(z111);
                                        Object objRememberedValue17 = gapComposer4.rememberedValue();
                                        if (zChanged8 || objRememberedValue17 == neverEqualPolicy2) {
                                            objRememberedValue17 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ThumbnailKt$$ExternalSyntheticLambda13((byte) 0, function5, z111));
                                            gapComposer4.updateRememberedValue(objRememberedValue17);
                                        }
                                        GridCells$Fixed gridCells$Fixed = new GridCells$Fixed(1);
                                        SnapFlingBehavior snapFlingBehaviorRememberSnapFlingBehavior = SQLite.rememberSnapFlingBehavior(snapLayoutInfoProvider3, gapComposer4);
                                        boolean zBooleanValue = ((Boolean) ((State) objRememberedValue17).getValue()).booleanValue();
                                        if (z110) {
                                            modifierM151size3ABfNKs = SizeKt.m151size3ABfNKs(Modifier.Companion.$$INSTANCE, thumbnailDimensions.thumbnailSize + 40.0f + CropImageView.DEFAULT_ASPECT_RATIO);
                                        } else {
                                            modifierM151size3ABfNKs = SizeKt.FillWholeMaxSize;
                                        }
                                        final ArrayList arrayList3 = arrayList2;
                                        boolean zChangedInstance = gapComposer4.changedInstance(arrayList3) | gapComposer4.changed(thumbnailDimensions);
                                        final MutableState mutableState11 = mutableState7;
                                        boolean zChanged9 = zChangedInstance | gapComposer4.changed(mutableState11);
                                        final MutableState mutableState12 = mutableState8;
                                        boolean zChanged10 = zChanged9 | gapComposer4.changed(mutableState12);
                                        final long j4 = j3;
                                        boolean zChanged11 = zChanged10 | gapComposer4.changed(j4);
                                        final LayoutDirection layoutDirection4 = layoutDirection3;
                                        boolean zChanged12 = zChanged11 | gapComposer4.changed(layoutDirection4.ordinal());
                                        final PlayerConnection playerConnection3 = playerConnection2;
                                        boolean zChangedInstance2 = zChanged12 | gapComposer4.changedInstance(playerConnection3);
                                        final Context context5 = context4;
                                        boolean zChangedInstance3 = zChangedInstance2 | gapComposer4.changedInstance(context5) | gapComposer4.changed(z110);
                                        final boolean z112 = z19;
                                        boolean zChanged13 = zChangedInstance3 | gapComposer4.changed(z112);
                                        final MutableState mutableState13 = mutableState6;
                                        boolean zChanged14 = zChanged13 | gapComposer4.changed(mutableState13);
                                        Object objRememberedValue18 = gapComposer4.rememberedValue();
                                        if (zChanged14 || objRememberedValue18 == neverEqualPolicy2) {
                                            Function1 function7 = new Function1() { // from class: com.metrolist.music.ui.player.ThumbnailKt$$ExternalSyntheticLambda14
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Object invoke(Object obj7) {
                                                    LazyGridIntervalContent lazyGridIntervalContent = (LazyGridIntervalContent) obj7;
                                                    lazyGridIntervalContent.getClass();
                                                    QueueKt$$ExternalSyntheticLambda4 queueKt$$ExternalSyntheticLambda6 = new QueueKt$$ExternalSyntheticLambda4((byte) 2);
                                                    final ArrayList arrayList4 = arrayList3;
                                                    int size = arrayList4.size();
                                                    Latch$await$2$2 latch$await$2$2 = new Latch$await$2$2(queueKt$$ExternalSyntheticLambda6, arrayList4, (byte) 18);
                                                    AndroidPopup_androidKt$SimpleStack$1$1.AnonymousClass3 anonymousClass3 = new AndroidPopup_androidKt$SimpleStack$1$1.AnonymousClass3(arrayList4, (byte) 4);
                                                    final ThumbnailDimensions thumbnailDimensions2 = thumbnailDimensions;
                                                    final long j5 = j4;
                                                    final LayoutDirection layoutDirection5 = layoutDirection4;
                                                    final Function2 function8 = function6;
                                                    final PlayerConnection playerConnection4 = playerConnection3;
                                                    final Context context6 = context5;
                                                    final boolean z20 = z110;
                                                    final boolean z21 = z112;
                                                    final MutableState mutableState14 = mutableState11;
                                                    final MutableState mutableState15 = mutableState12;
                                                    final MutableState mutableState16 = mutableState13;
                                                    lazyGridIntervalContent.items(size, latch$await$2$2, null, anonymousClass3, new ComposableLambdaImpl(true, -1117249557, new Function4() { // from class: com.metrolist.music.ui.player.ThumbnailKt$Thumbnail$lambda$27$1$0$0$4$0$$inlined$items$default$5
                                                        @Override // kotlin.jvm.functions.Function4
                                                        public final Object invoke(Object obj8, Object obj9, Object obj10, Object obj11) throws XmlPullParserException, IOException {
                                                            int i9;
                                                            LazyGridItemScopeImpl lazyGridItemScopeImpl = (LazyGridItemScopeImpl) obj8;
                                                            int iIntValue3 = ((Number) obj9).intValue();
                                                            Composer composer4 = (Composer) obj10;
                                                            int iIntValue4 = ((Number) obj11).intValue();
                                                            if ((iIntValue4 & 6) == 0) {
                                                                i9 = (((GapComposer) composer4).changed(lazyGridItemScopeImpl) ? 4 : 2) | iIntValue4;
                                                            } else {
                                                                i9 = iIntValue4;
                                                            }
                                                            if ((iIntValue4 & 48) == 0) {
                                                                i9 |= ((GapComposer) composer4).changed(iIntValue3) ? 32 : 16;
                                                            }
                                                            GapComposer gapComposer5 = (GapComposer) composer4;
                                                            if (gapComposer5.shouldExecute(i9 & 1, (i9 & 147) != 146)) {
                                                                MediaItem mediaItem = (MediaItem) arrayList4.get(iIntValue3);
                                                                gapComposer5.startReplaceGroup(-601929668);
                                                                boolean zBooleanValue2 = ((Boolean) mutableState14.getValue()).booleanValue();
                                                                boolean zBooleanValue3 = ((Boolean) mutableState15.getValue()).booleanValue();
                                                                MutableState mutableState17 = mutableState16;
                                                                MediaMetadata mediaMetadata4 = (MediaMetadata) mutableState17.getValue();
                                                                String str2 = mediaMetadata4 != null ? mediaMetadata4.id : null;
                                                                MediaMetadata mediaMetadata5 = (MediaMetadata) mutableState17.getValue();
                                                                QueueKt.m1509ThumbnailItemB9xY6lo(mediaItem, thumbnailDimensions2, zBooleanValue2, zBooleanValue3, j5, layoutDirection5, function8, playerConnection4, context6, z20, z21, str2, mediaMetadata5 != null ? mediaMetadata5.thumbnailUrl : null, null, gapComposer5, 18350080);
                                                                gapComposer5.end(false);
                                                            } else {
                                                                gapComposer5.skipToGroupEnd();
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    }));
                                                    return Unit.INSTANCE;
                                                }
                                            };
                                            gapComposer4.updateRememberedValue(function7);
                                            objRememberedValue18 = function7;
                                        }
                                        LifecyclesKt.LazyHorizontalGrid(gridCells$Fixed, modifierM151size3ABfNKs, lazyGridState4, null, null, null, snapFlingBehaviorRememberSnapFlingBehavior, zBooleanValue, null, null, (Function1) objRememberedValue18, gapComposer4, 0, 1656);
                                    } else {
                                        gapComposer4.skipToGroupEnd();
                                    }
                                    return Unit.INSTANCE;
                                }
                            }, gapComposer3), gapComposer3, 3120, 4);
                            gapComposer3.end(true);
                        } else {
                            gapComposer3.skipToGroupEnd();
                        }
                        return Unit.INSTANCE;
                    }
                };
                gapComposer = gapComposer2;
                CrossfadeKt.AnimatedVisibility(z12, modifierThen2, enterTransitionImplFadeIn$default4, exitTransitionImplFadeOut$default4, null, Expect_jvmKt.rememberComposableLambda(2051219412, function4, gapComposer), gapComposer, 200064, 16);
                Boolean bool7 = (Boolean) mutableState3.getValue();
                bool7.getClass();
                objRememberedValue12 = gapComposer.rememberedValue();
                if (objRememberedValue12 == neverEqualPolicy) {
                    finiteAnimationSpec2 = null;
                    objRememberedValue12 = new ItemsKt$reset$1(mutableState3, 0 == true ? 1 : 0, (byte) 2);
                    gapComposer.updateRememberedValue(objRememberedValue12);
                } else {
                    finiteAnimationSpec2 = null;
                }
                Stack.LaunchedEffect(gapComposer, bool7, (Function2) objRememberedValue12);
                CrossfadeKt.AnimatedVisibility(((Boolean) mutableState3.getValue()).booleanValue(), boxScopeInstance2.align(companion, biasAlignment2), EnterExitTransitionKt.fadeIn$default(finiteAnimationSpec2, CropImageView.DEFAULT_ASPECT_RATIO, 3), EnterExitTransitionKt.fadeOut$default(finiteAnimationSpec2, CropImageView.DEFAULT_ASPECT_RATIO, 3), null, Expect_jvmKt.rememberComposableLambda(-1994469483, new QueueKt$$ExternalSyntheticLambda21(mutableState5, (byte) 17), gapComposer), gapComposer, 200064, 16);
                gapComposer.end(true);
                z5 = z7;
            }
            recomposeScopeImplEndRestartGroup.block = function2;
        }
        gapComposer = gapComposer2;
        gapComposer.skipToGroupEnd();
        z5 = z3;
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            final byte b6 = 1;
            function2 = new Function2() { // from class: com.metrolist.music.ui.player.ThumbnailKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    byte b7 = b6;
                    Unit unit = Unit.INSTANCE;
                    short s = i;
                    switch (b7) {
                        case 0:
                            ((Integer) obj2).getClass();
                            int iUpdateChangedFlags = Stack.updateChangedFlags(s | 1);
                            QueueKt.Thumbnail(function0, modifier, function1, z5, z2, (Composer) obj, iUpdateChangedFlags, i2);
                            break;
                        default:
                            ((Integer) obj2).getClass();
                            int iUpdateChangedFlags2 = Stack.updateChangedFlags(s | 1);
                            QueueKt.Thumbnail(function0, modifier, function1, z5, z2, (Composer) obj, iUpdateChangedFlags2, i2);
                            break;
                    }
                    return unit;
                }
            };
            recomposeScopeImplEndRestartGroup.block = function2;
        }
    }

    /* JADX INFO: renamed from: ThumbnailHeader-cf5BqRc, reason: not valid java name */
    public static final void m1508ThumbnailHeadercf5BqRc(final String str, final String str2, final long j, Modifier modifier, Composer composer, final int i) {
        Modifier modifier2;
        MutableState mutableStateCollectAsStateWithLifecycle;
        String strM;
        StaticProvidableCompositionLocal staticProvidableCompositionLocal;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-239406885);
        int i2 = i | (gapComposer.changed(str) ? 4 : 2) | (gapComposer.changed(str2) ? 32 : 16) | 3072;
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 1043) != 1042)) {
            ListenTogetherManager listenTogetherManager = (ListenTogetherManager) gapComposer.consume(MainActivityKt.LocalListenTogetherManager);
            ReadonlyStateFlow readonlyStateFlow = listenTogetherManager != null ? listenTogetherManager.role : null;
            if (readonlyStateFlow == null) {
                gapComposer.startReplaceGroup(1770428301);
                gapComposer.end(false);
                mutableStateCollectAsStateWithLifecycle = null;
            } else {
                gapComposer.startReplaceGroup(1858225908);
                mutableStateCollectAsStateWithLifecycle = FileSystemsKt.collectAsStateWithLifecycle(readonlyStateFlow, RoomRole.NONE, gapComposer, 48);
                gapComposer.end(false);
            }
            RoomRole roomRole = mutableStateCollectAsStateWithLifecycle != null ? (RoomRole) mutableStateCollectAsStateWithLifecycle.getValue() : null;
            int i3 = roomRole == null ? -1 : ThumbnailKt$WhenMappings.$EnumSwitchMapping$0[roomRole.ordinal()];
            if (i3 == 1) {
                gapComposer.startReplaceGroup(-1649101927);
                gapComposer.end(false);
                strM = "Hosting Listen Together";
            } else if (i3 != 2) {
                strM = Format$$ExternalSyntheticOutline0.m(gapComposer, 1858233215, R.string.now_playing, gapComposer, false);
            } else {
                gapComposer.startReplaceGroup(784334672);
                gapComposer.end(false);
                strM = "Listening Together";
            }
            String str3 = strM;
            String str4 = str == null ? str2 : str;
            BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier modifierM138paddingqDBjuR0 = OffsetKt.m138paddingqDBjuR0(SizeKt.fillMaxWidth(companion, 1.0f), 20.0f, 8.0f, 12.0f, 12.0f);
            RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(OffsetKt.Start, vertical, gapComposer, 48);
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierM138paddingqDBjuR0);
            ComposeUiNode.Companion.getClass();
            gapComposer.startReusableNode();
            boolean z = gapComposer.inserting;
            TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
            if (z) {
                gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer.useNode();
            }
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetMeasurePolicy;
            Stack.m390setimpl(gapComposer, rowMeasurePolicy, updater$$ExternalSyntheticLambda0);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda1);
            Integer numValueOf = Integer.valueOf(iHashCode);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetCompositeKeyHash;
            Stack.m390setimpl(gapComposer, numValueOf, updater$$ExternalSyntheticLambda2);
            Stack.m389reconcileimpl(gapComposer);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetModifier;
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier, updater$$ExternalSyntheticLambda3);
            LayoutWeightElement layoutWeightElement = new LayoutWeightElement(1.0f, true);
            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start, gapComposer, 0);
            int iHashCode2 = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer, layoutWeightElement);
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer.useNode();
            }
            Stack.m390setimpl(gapComposer, columnMeasurePolicy, updater$$ExternalSyntheticLambda0);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer, updater$$ExternalSyntheticLambda2, gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
            StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = MaterialThemeKt._localMaterialTheme;
            DialogKt.m1469MicroLabelFNF3uiM(str3, null, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal2)).colorScheme.primary, gapComposer, 0, 2);
            gapComposer = gapComposer;
            if (str4 == null || StringsKt.isBlank(str4)) {
                staticProvidableCompositionLocal = staticProvidableCompositionLocal2;
                modifier2 = companion;
                gapComposer.startReplaceGroup(1380973293);
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(1380568712);
                OffsetKt.Spacer(gapComposer, SizeKt.m145height3ABfNKs(companion, 2.0f));
                modifier2 = companion;
                String str5 = str4;
                staticProvidableCompositionLocal = staticProvidableCompositionLocal2;
                TextKt.m352TextNvy7gAk(str5, ImageKt.m41basicMarquee1Mj1MLw$default(companion, 63), ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal2)).colorScheme.onSurface, 0L, new FontStyle(1), null, null, 0L, null, 0L, 0, false, 1, 0, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal2)).typography.titleLarge, gapComposer, 48, 24576, 114648);
                gapComposer = gapComposer;
                gapComposer.end(false);
            }
            gapComposer.end(true);
            DialogKt.m1460CastButtoniJQMabo(null, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.onSurface, gapComposer, 0, 1);
            gapComposer.end(true);
        } else {
            gapComposer.skipToGroupEnd();
            modifier2 = modifier;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            recomposeScopeImplEndRestartGroup.block = new Function2(str, str2, j, modifier3, i) { // from class: com.metrolist.music.ui.player.ThumbnailKt$$ExternalSyntheticLambda11
                public final /* synthetic */ String f$0;
                public final /* synthetic */ String f$1;
                public final /* synthetic */ long f$2;
                public final /* synthetic */ Modifier f$3;

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(1);
                    QueueKt.m1508ThumbnailHeadercf5BqRc(this.f$0, this.f$1, this.f$2, this.f$3, (Composer) obj, iUpdateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final void ThumbnailImage(String str, boolean z, Modifier modifier, Composer composer, int i) {
        int i2;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(1162153805);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changed(z) ? 32 : 16;
        }
        int i3 = i2 | 384;
        byte b = 0;
        if (gapComposer.shouldExecute(i3 & 1, (i3 & 147) != 146)) {
            boolean z2 = (i3 & 14) == 4;
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (z2 || objRememberedValue == neverEqualPolicy) {
                objRememberedValue = ArcSplineKt.Animatable$default(0.97f);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            Animatable animatable = (Animatable) objRememberedValue;
            boolean zChangedInstance = gapComposer.changedInstance(animatable);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new ThumbnailKt$ThumbnailImage$1$1(animatable, null, b);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            Stack.LaunchedEffect(gapComposer, str, (Function2) objRememberedValue2);
            FillElement fillElement = SizeKt.FillWholeMaxSize;
            Modifier modifierM39backgroundbw27NRU = ImageKt.m39backgroundbw27NRU(fillElement, ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.surfaceVariant, ColorKt.RectangleShape);
            boolean zChangedInstance2 = gapComposer.changedInstance(animatable);
            Object objRememberedValue3 = gapComposer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue3 == neverEqualPolicy) {
                objRememberedValue3 = new MiniPlayerKt$$ExternalSyntheticLambda2(animatable, (byte) 8);
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            Modifier modifierGraphicsLayer = ColorKt.graphicsLayer(modifierM39backgroundbw27NRU, (Function1) objRememberedValue3);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierGraphicsLayer);
            ComposeUiNode.Companion.getClass();
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(LayoutNode.Constructor);
            } else {
                gapComposer.useNode();
            }
            Stack.m390setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m389reconcileimpl(gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            ImageRequest.Builder builder = new ImageRequest.Builder((Context) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalContext));
            builder.data = str;
            ImageRequests_androidKt.crossfade(builder, 180);
            CachePolicy cachePolicy = CachePolicy.ENABLED;
            builder.memoryCachePolicy = cachePolicy;
            builder.diskCachePolicy = cachePolicy;
            builder.networkCachePolicy = cachePolicy;
            AsyncImageKt.m849AsyncImage10Xjiaw(builder.build(), fillElement, z ? ContentScale.Companion.Crop : ContentScale.Companion.Fit, gapComposer, 432, 1976);
            gapComposer.end(true);
            modifier = Modifier.Companion.$$INSTANCE;
        } else {
            gapComposer.skipToGroupEnd();
        }
        Modifier modifier2 = modifier;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ItemsKt$$ExternalSyntheticLambda67(str, z, modifier2, i, (byte) 3);
        }
    }

    /* JADX INFO: renamed from: ThumbnailItem-B9xY6lo, reason: not valid java name */
    public static final void m1509ThumbnailItemB9xY6lo(MediaItem mediaItem, final ThumbnailDimensions thumbnailDimensions, final boolean z, boolean z2, final long j, final LayoutDirection layoutDirection, final Function2 function2, final PlayerConnection playerConnection, final Context context, final boolean z3, final boolean z4, String str, final String str2, Modifier modifier, Composer composer, final int i) throws XmlPullParserException, IOException {
        boolean z5;
        GapComposer gapComposer;
        final String str3;
        final Modifier modifier2;
        float f;
        Modifier modifierThen;
        Modifier.Companion companion;
        boolean z6;
        Modifier modifierM135padding3ABfNKs;
        String string;
        final MediaItem mediaItem2 = mediaItem;
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(-1547570648);
        int i2 = i | (gapComposer2.changedInstance(mediaItem2) ? 4 : 2) | (gapComposer2.changed(thumbnailDimensions) ? 32 : 16) | (gapComposer2.changed(z) ? 256 : 128) | (gapComposer2.changed(z2) ? 2048 : 1024) | (gapComposer2.changed(j) ? 16384 : 8192) | (gapComposer2.changed(layoutDirection.ordinal()) ? 131072 : 65536) | (gapComposer2.changedInstance(playerConnection) ? 8388608 : 4194304) | (gapComposer2.changedInstance(context) ? 67108864 : 33554432) | (gapComposer2.changed(z3) ? 536870912 : WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE);
        int i3 = (gapComposer2.changed(z4) ? (char) 4 : (char) 2) | (gapComposer2.changed(str) ? ' ' : (char) 16) | (gapComposer2.changed(str2) ? (char) 256 : (char) 128) | 3072;
        if (gapComposer2.shouldExecute(i2 & 1, ((i2 & 306783379) == 306783378 && (i3 & 1171) == 1170) ? false : true)) {
            final DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference = UtilsKt.rememberPreference(PreferenceKeysKt.SeekExtraSeconds, Boolean.FALSE, gapComposer2, 48);
            Object objRememberedValue = gapComposer2.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Fragment$5$$ExternalSyntheticOutline0.m(1, gapComposer2);
            }
            final ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = (ParcelableSnapshotMutableIntState) objRememberedValue;
            Object objRememberedValue2 = gapComposer2.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new ParcelableSnapshotMutableLongState(0L);
                gapComposer2.updateRememberedValue(objRememberedValue2);
            }
            final ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState = (ParcelableSnapshotMutableLongState) objRememberedValue2;
            Modifier.Companion companion2 = Modifier.Companion.$$INSTANCE;
            if (z3) {
                f = CropImageView.DEFAULT_ASPECT_RATIO;
                modifierThen = SizeKt.m151size3ABfNKs(companion2, thumbnailDimensions.thumbnailSize + 40.0f + CropImageView.DEFAULT_ASPECT_RATIO);
            } else {
                f = CropImageView.DEFAULT_ASPECT_RATIO;
                modifierThen = SizeKt.m155width3ABfNKs(companion2, thumbnailDimensions.itemWidth).then(SizeKt.FillWholeMaxSize);
            }
            Modifier modifierM137paddingVpY3zN4$default = OffsetKt.m137paddingVpY3zN4$default(modifierThen, 20.0f, f, 2);
            boolean zChanged = ((i3 & 14) == 4) | ((i2 & 29360128) == 8388608 || gapComposer2.changedInstance(playerConnection)) | gapComposer2.changed(dataStoreKt$rememberPreference$1$1RememberPreference) | ((i2 & 458752) == 131072) | gapComposer2.changedInstance(context);
            Object objRememberedValue3 = gapComposer2.rememberedValue();
            if (zChanged || objRememberedValue3 == neverEqualPolicy) {
                gapComposer = gapComposer2;
                objRememberedValue3 = new PointerInputEventHandler() { // from class: com.metrolist.music.ui.player.ThumbnailKt$ThumbnailItem$1$1
                    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                    public final Object invoke(PointerInputScope pointerInputScope, Continuation continuation) {
                        Object objDetectTapGestures$default = TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, new LoginScreenKt$$ExternalSyntheticLambda0(z4, playerConnection, layoutDirection, pointerInputScope, function2, context, dataStoreKt$rememberPreference$1$1RememberPreference, parcelableSnapshotMutableLongState, parcelableSnapshotMutableIntState), null, null, continuation, 14);
                        return objDetectTapGestures$default == CoroutineSingletons.COROUTINE_SUSPENDED ? objDetectTapGestures$default : Unit.INSTANCE;
                    }
                };
                gapComposer.updateRememberedValue(objRememberedValue3);
            } else {
                gapComposer = gapComposer2;
            }
            Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(modifierM137paddingVpY3zN4$default, Unit.INSTANCE, (PointerInputEventHandler) objRememberedValue3);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierPointerInput);
            ComposeUiNode.Companion.getClass();
            gapComposer.startReusableNode();
            boolean z7 = gapComposer.inserting;
            TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
            if (z7) {
                gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer.useNode();
            }
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetMeasurePolicy;
            Stack.m390setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy, updater$$ExternalSyntheticLambda0);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda1);
            Integer numValueOf = Integer.valueOf(iHashCode);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetCompositeKeyHash;
            Stack.m390setimpl(gapComposer, numValueOf, updater$$ExternalSyntheticLambda2);
            Stack.m389reconcileimpl(gapComposer);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetModifier;
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier, updater$$ExternalSyntheticLambda3);
            Modifier modifierM151size3ABfNKs = SizeKt.m151size3ABfNKs(r21, thumbnailDimensions.thumbnailSize);
            if (UiStyleKt.isGlassStyle(gapComposer)) {
                gapComposer.startReplaceGroup(1227525700);
                companion = companion2;
                modifierM135padding3ABfNKs = ImageKt.m43borderziNgDLE(ClipKt.clip(ClipKt.m399shadows4CzXII$default(companion2, 28.0f, RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(32.0f), ColorKt.Color(Color.m485getRedimpl(-72057594037927936L), Color.m484getGreenimpl(-72057594037927936L), Color.m482getBlueimpl(-72057594037927936L), 0.45f, Color.m483getColorSpaceimpl(-72057594037927936L)), ColorKt.Color(Color.m485getRedimpl(-72057594037927936L), Color.m484getGreenimpl(-72057594037927936L), Color.m482getBlueimpl(-72057594037927936L), 0.45f, Color.m483getColorSpaceimpl(-72057594037927936L)), 4), RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(32.0f)), 1.0f, GlassComponentsKt.glassRim(gapComposer), RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(32.0f));
                gapComposer.end(false);
                z6 = false;
            } else {
                companion = r21;
                gapComposer.startReplaceGroup(1228074338);
                long j2 = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.onSurface;
                long jColor = ColorKt.Color(Color.m485getRedimpl(j2), Color.m484getGreenimpl(j2), Color.m482getBlueimpl(j2), 0.08f, Color.m483getColorSpaceimpl(j2));
                boolean zChanged2 = gapComposer.changed(jColor) | gapComposer.changed(16.0f);
                Object objRememberedValue4 = gapComposer.rememberedValue();
                if (zChanged2 || objRememberedValue4 == neverEqualPolicy) {
                    objRememberedValue4 = new InnerTube$$ExternalSyntheticLambda2(jColor, (byte) 8);
                    gapComposer.updateRememberedValue(objRememberedValue4);
                }
                z6 = false;
                modifierM135padding3ABfNKs = OffsetKt.m135padding3ABfNKs(DialogKt.m1472editorialPaneleaDK9VM(ClipKt.drawBehind(companion, (Function1) objRememberedValue4), RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(16.0f), gapComposer, 0, 6), 12.0f);
                gapComposer.end(false);
            }
            Modifier modifierThen2 = modifierM151size3ABfNKs.then(modifierM135padding3ABfNKs);
            BiasAlignment biasAlignment = Alignment.Companion.TopStart;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, z6);
            int iHashCode2 = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer, modifierThen2);
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer.useNode();
            }
            Stack.m390setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy2, updater$$ExternalSyntheticLambda0);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer, updater$$ExternalSyntheticLambda2, gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
            Modifier modifierThen3 = SizeKt.FillWholeMaxSize.then(UiStyleKt.isGlassStyle(gapComposer) ? companion : ClipKt.clip(companion, RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(12.0f)));
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, false);
            int iHashCode3 = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer, modifierThen3);
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer.useNode();
            }
            Stack.m390setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy3, updater$$ExternalSyntheticLambda0);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda1);
            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode3, gapComposer, updater$$ExternalSyntheticLambda2, gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda3);
            if (z) {
                gapComposer.startReplaceGroup(-1647236281);
                m1500HiddenThumbnailPlaceholder3JVO9M((i2 >> 12) & 14, j, gapComposer, null);
                gapComposer.end(false);
                mediaItem2 = mediaItem;
                z5 = z2;
                str3 = str;
            } else {
                gapComposer.startReplaceGroup(-1647120000);
                mediaItem2 = mediaItem;
                str3 = str;
                if (!Intrinsics.areEqual(mediaItem2.mediaId, str3) || str2 == null || StringsKt.isBlank(str2)) {
                    Uri uri = mediaItem2.mediaMetadata.artworkUri;
                    string = uri != null ? uri.toString() : null;
                } else {
                    string = str2;
                }
                z5 = z2;
                ThumbnailImage(string, z5, null, gapComposer, (i2 >> 6) & 112);
                gapComposer.end(false);
            }
            if (z3) {
                gapComposer.startReplaceGroup(-1646571238);
                DialogKt.m1460CastButtoniJQMabo(OffsetKt.m135padding3ABfNKs(BoxScopeInstance.INSTANCE.align(companion, Alignment.Companion.TopEnd), 8.0f), j, gapComposer, (i2 >> 9) & 112, 0);
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(-1646338676);
                gapComposer.end(false);
            }
            Fragment$5$$ExternalSyntheticOutline0.m(gapComposer, true, true, true);
            modifier2 = companion;
        } else {
            z5 = z2;
            gapComposer = gapComposer2;
            str3 = str;
            gapComposer.skipToGroupEnd();
            modifier2 = modifier;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            final boolean z8 = z5;
            recomposeScopeImplEndRestartGroup.block = new Function2(thumbnailDimensions, z, z8, j, layoutDirection, function2, playerConnection, context, z3, z4, str3, str2, modifier2, i) { // from class: com.metrolist.music.ui.player.ThumbnailKt$$ExternalSyntheticLambda17
                public final /* synthetic */ ThumbnailDimensions f$1;
                public final /* synthetic */ boolean f$10;
                public final /* synthetic */ String f$11;
                public final /* synthetic */ String f$12;
                public final /* synthetic */ Modifier f$13;
                public final /* synthetic */ boolean f$2;
                public final /* synthetic */ boolean f$3;
                public final /* synthetic */ long f$4;
                public final /* synthetic */ LayoutDirection f$5;
                public final /* synthetic */ Function2 f$6;
                public final /* synthetic */ PlayerConnection f$7;
                public final /* synthetic */ Context f$8;
                public final /* synthetic */ boolean f$9;

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) throws XmlPullParserException, IOException {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(18350081);
                    QueueKt.m1509ThumbnailItemB9xY6lo(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, this.f$8, this.f$9, this.f$10, this.f$11, this.f$12, this.f$13, (Composer) obj, iUpdateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }
}
