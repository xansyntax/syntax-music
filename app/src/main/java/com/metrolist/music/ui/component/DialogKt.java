package com.metrolist.music.ui.component;

import android.content.Context;
import android.content.res.Configuration;
import androidx.activity.SystemBarStyle$Companion$$ExternalSyntheticLambda0;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.animation.AnimatedContentScopeImpl;
import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransitionImpl;
import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimateAsState;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.DecayAnimationSpecImpl;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.RepeatMode;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.foundation.BorderKt$$ExternalSyntheticLambda0;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.gestures.DefaultDraggableState;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableKt$NoOpOnDragStarted$1;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.FlowRowOverflow;
import androidx.compose.foundation.layout.LimitInsets;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsHolder;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.foundation.lazy.LazyListIntervalContent;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.AlertDialogKt;
import androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda2;
import androidx.compose.material3.AssistChipDefaults;
import androidx.compose.material3.BottomSheetKt$$ExternalSyntheticLambda13;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ChipColors;
import androidx.compose.material3.ChipKt;
import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.ColorSchemeKt;
import androidx.compose.material3.FilterChipDefaults;
import androidx.compose.material3.IconButtonKt$$ExternalSyntheticLambda5;
import androidx.compose.material3.ListItemKt$$ExternalSyntheticLambda11;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.material3.ProgressIndicatorKt$$ExternalSyntheticLambda13;
import androidx.compose.material3.ScrimKt;
import androidx.compose.material3.SelectableChipColors;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextFieldDefaults;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda0;
import androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda41;
import androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda2;
import androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda5;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.ParcelableSnapshotMutableLongState;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.SnapshotStateKt__DerivedStateKt;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.ComposedModifier;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusTraversalKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.BlendModeColorFilter;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.Rgb;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendPointerInputElement;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl;
import androidx.compose.ui.input.pointer.util.VelocityTracker;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.UriHandler;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.compose.ui.window.DialogProperties;
import androidx.datastore.preferences.core.Preferences$Key;
import androidx.emoji2.text.EmojiProcessor;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.navigation.compose.NavHostKt$NavHost$33$1;
import androidx.sqlite.SQLite;
import coil3.network.NetworkFetcher$doFetch$fetchResult$1;
import coil3.util.FileSystemsKt;
import com.dokar.quickjs.QuickJs$$ExternalSyntheticLambda1;
import com.google.common.math.IntMath;
import com.metrolist.innertubex.InnerTube$$ExternalSyntheticLambda2;
import com.metrolist.music.App;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda0;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda21;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda29;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda30;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda44;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda59;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda6;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda9;
import com.metrolist.music.MainActivity$MetrolistApp$$inlined$rememberEnumPreference$1;
import com.metrolist.music.MainActivityKt;
import com.metrolist.music.constants.PlayerBackgroundStyle;
import com.metrolist.music.constants.PreferenceKeysKt;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.CachedItem$$ExternalSyntheticLambda0;
import com.metrolist.music.db.entities.LyricsEntity;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.listentogether.ListenTogetherManager;
import com.metrolist.music.lyrics.LyricsEntry;
import com.metrolist.music.lyrics.LyricsFormatKt;
import com.metrolist.music.lyrics.LyricsTranslationHelper;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.playback.DownloadUtil;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.ui.menu.AlbumMenuKt$$ExternalSyntheticLambda13;
import com.metrolist.music.ui.menu.AlbumMenuKt$$ExternalSyntheticLambda40;
import com.metrolist.music.ui.menu.LoadingScreenKt$$ExternalSyntheticLambda4;
import com.metrolist.music.ui.menu.QueueMenuKt$$ExternalSyntheticLambda6;
import com.metrolist.music.ui.menu.SongMenuKt$SongMenu$lambda$33$0$$inlined$items$default$3;
import com.metrolist.music.ui.player.MiniPlayerKt$$ExternalSyntheticLambda2;
import com.metrolist.music.ui.player.MiniPlayerKt$$ExternalSyntheticLambda25;
import com.metrolist.music.ui.player.MiniPlayerKt$NewMiniPlayer$2$1$1$4$1;
import com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda0;
import com.metrolist.music.ui.player.PlayerKt$BottomSheetPlayer$13$1;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda7;
import com.metrolist.music.ui.player.QueueKt$Queue$5$1$1;
import com.metrolist.music.ui.player.QueueKt$Queue$5$reorderableState$1$1;
import com.metrolist.music.ui.player.ThumbnailKt$ThumbnailImage$1$1;
import com.metrolist.music.ui.screens.OptionStats;
import com.metrolist.music.ui.screens.artist.ArtistScreenKt$ArtistScreen$1$1;
import com.metrolist.music.ui.screens.settings.LyricsPosition;
import com.metrolist.music.ui.screens.settings.RomanizationSettingsKt;
import com.metrolist.music.ui.theme.UiStyle;
import com.metrolist.music.ui.theme.UiStyleKt;
import com.metrolist.music.ui.utils.ShowOffsetDialogKt$$ExternalSyntheticLambda3;
import com.metrolist.music.utils.DataStoreKt$rememberPreference$1$1;
import com.metrolist.music.utils.SyncUtils;
import com.metrolist.music.utils.SyncUtils$createPlaylist$1;
import com.metrolist.music.utils.Updater$checkForUpdate$2;
import com.metrolist.music.utils.UtilsKt;
import com.metrolist.music.viewmodels.LyricsViewModel;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.sse.ServerSentEventKt;
import io.ktor.utils.io.ByteChannelKt;
import io.ktor.websocket.RawWebSocketCommonKt$$ExternalSyntheticLambda0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptySet;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlowKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okhttp3.internal.http2.Http2Connection;
import org.xmlpull.v1.XmlPullParserException;
import sh.calvin.reorderable.ReorderableLazyListState;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class DialogKt {
    public static final float[] SunBands = {150.0f, 250.0f, 258.0f, 278.0f, 290.0f, 304.0f, 320.0f, 326.0f};

    /* JADX INFO: renamed from: lambda$-1173103151, reason: not valid java name */
    public static final ComposableLambdaImpl f12lambda$1173103151;

    /* JADX INFO: renamed from: lambda$-1243164339, reason: not valid java name */
    public static final ComposableLambdaImpl f13lambda$1243164339;

    /* JADX INFO: renamed from: lambda$-127042684, reason: not valid java name */
    public static final ComposableLambdaImpl f14lambda$127042684;

    /* JADX INFO: renamed from: lambda$-1292083341, reason: not valid java name */
    public static final ComposableLambdaImpl f15lambda$1292083341;

    /* JADX INFO: renamed from: lambda$-1295239762, reason: not valid java name */
    public static final ComposableLambdaImpl f16lambda$1295239762;

    /* JADX INFO: renamed from: lambda$-1300370856, reason: not valid java name */
    public static final ComposableLambdaImpl f17lambda$1300370856;

    /* JADX INFO: renamed from: lambda$-1370294970, reason: not valid java name */
    public static final ComposableLambdaImpl f18lambda$1370294970;

    /* JADX INFO: renamed from: lambda$-1382044806, reason: not valid java name */
    public static final ComposableLambdaImpl f19lambda$1382044806;

    /* JADX INFO: renamed from: lambda$-1495682491, reason: not valid java name */
    public static final ComposableLambdaImpl f20lambda$1495682491;

    /* JADX INFO: renamed from: lambda$-1502782614, reason: not valid java name */
    public static final ComposableLambdaImpl f21lambda$1502782614;

    /* JADX INFO: renamed from: lambda$-1695936880, reason: not valid java name */
    public static final ComposableLambdaImpl f22lambda$1695936880;

    /* JADX INFO: renamed from: lambda$-1816687740, reason: not valid java name */
    public static final ComposableLambdaImpl f23lambda$1816687740;

    /* JADX INFO: renamed from: lambda$-1831116798, reason: not valid java name */
    public static final ComposableLambdaImpl f24lambda$1831116798;

    /* JADX INFO: renamed from: lambda$-1875698990, reason: not valid java name */
    public static final ComposableLambdaImpl f25lambda$1875698990;

    /* JADX INFO: renamed from: lambda$-2095624441, reason: not valid java name */
    public static final ComposableLambdaImpl f26lambda$2095624441;

    /* JADX INFO: renamed from: lambda$-2107686734, reason: not valid java name */
    public static final ComposableLambdaImpl f27lambda$2107686734;

    /* JADX INFO: renamed from: lambda$-2215896, reason: not valid java name */
    public static final ComposableLambdaImpl f28lambda$2215896;

    /* JADX INFO: renamed from: lambda$-341175415, reason: not valid java name */
    public static final ComposableLambdaImpl f29lambda$341175415;

    /* JADX INFO: renamed from: lambda$-394851107, reason: not valid java name */
    public static final ComposableLambdaImpl f30lambda$394851107;

    /* JADX INFO: renamed from: lambda$-416583220, reason: not valid java name */
    public static final ComposableLambdaImpl f31lambda$416583220;

    /* JADX INFO: renamed from: lambda$-521944103, reason: not valid java name */
    public static final ComposableLambdaImpl f32lambda$521944103;

    /* JADX INFO: renamed from: lambda$-908072932, reason: not valid java name */
    public static final ComposableLambdaImpl f33lambda$908072932;

    /* JADX INFO: renamed from: lambda$-933231693, reason: not valid java name */
    public static final ComposableLambdaImpl f34lambda$933231693;

    /* JADX INFO: renamed from: lambda$-967816641, reason: not valid java name */
    public static final ComposableLambdaImpl f35lambda$967816641;

    /* JADX INFO: renamed from: lambda$-988255900, reason: not valid java name */
    public static final ComposableLambdaImpl f36lambda$988255900;
    public static final ComposableLambdaImpl lambda$1007107521;
    public static final ComposableLambdaImpl lambda$1106178229;
    public static final ComposableLambdaImpl lambda$1295355648;
    public static final ComposableLambdaImpl lambda$1374912688;
    public static final ComposableLambdaImpl lambda$139505329;
    public static final ComposableLambdaImpl lambda$1421683131;
    public static final ComposableLambdaImpl lambda$1428428444;
    public static final ComposableLambdaImpl lambda$1490944580;
    public static final ComposableLambdaImpl lambda$1502905431;
    public static final ComposableLambdaImpl lambda$1577977796;
    public static final ComposableLambdaImpl lambda$1633512845;
    public static final ComposableLambdaImpl lambda$1713319177;
    public static final ComposableLambdaImpl lambda$1715181715;
    public static final ComposableLambdaImpl lambda$1716948769;
    public static final ComposableLambdaImpl lambda$1743127747;
    public static final ComposableLambdaImpl lambda$1827852123;
    public static final ComposableLambdaImpl lambda$1843256704;
    public static final ComposableLambdaImpl lambda$1988371312;
    public static final ComposableLambdaImpl lambda$2028033804;
    public static final ComposableLambdaImpl lambda$2056500737;
    public static final ComposableLambdaImpl lambda$2082406657;
    public static final ComposableLambdaImpl lambda$2099584596;
    public static final ComposableLambdaImpl lambda$223726883;
    public static final ComposableLambdaImpl lambda$233336693;
    public static final ComposableLambdaImpl lambda$25624799;
    public static final ComposableLambdaImpl lambda$42143121;
    public static final ComposableLambdaImpl lambda$56008067;
    public static final ComposableLambdaImpl lambda$632719135;
    public static final ComposableLambdaImpl lambda$714271667;
    public static final ComposableLambdaImpl lambda$890088552;
    public static volatile boolean shown;

    static {
        byte b = 8;
        byte b2 = 10;
        lambda$2028033804 = new ComposableLambdaImpl(false, 2028033804, new MainActivity$$ExternalSyntheticLambda44(b2));
        byte b3 = 4;
        new ComposableLambdaImpl(false, 1255844089, new MainActivity$$ExternalSyntheticLambda30(b3));
        byte b4 = 5;
        lambda$2082406657 = new ComposableLambdaImpl(false, 2082406657, new MainActivity$$ExternalSyntheticLambda30(b4));
        byte b5 = 11;
        lambda$1374912688 = new ComposableLambdaImpl(false, 1374912688, new MainActivity$$ExternalSyntheticLambda44(b5));
        byte b6 = 6;
        lambda$632719135 = new ComposableLambdaImpl(false, 632719135, new MainActivity$$ExternalSyntheticLambda30(b6));
        byte b7 = 7;
        f12lambda$1173103151 = new ComposableLambdaImpl(false, -1173103151, new MainActivity$$ExternalSyntheticLambda30(b7));
        f25lambda$1875698990 = new ComposableLambdaImpl(false, -1875698990, new MainActivity$$ExternalSyntheticLambda30(b));
        byte b8 = 12;
        new ComposableLambdaImpl(false, -1199305628, new MainActivity$$ExternalSyntheticLambda44(b8));
        byte b9 = 13;
        lambda$714271667 = new ComposableLambdaImpl(false, 714271667, new MainActivity$$ExternalSyntheticLambda44(b9));
        byte b10 = 14;
        lambda$1843256704 = new ComposableLambdaImpl(false, 1843256704, new MainActivity$$ExternalSyntheticLambda44(b10));
        byte b11 = 15;
        f35lambda$967816641 = new ComposableLambdaImpl(false, -967816641, new MainActivity$$ExternalSyntheticLambda44(b11));
        byte b12 = 16;
        f17lambda$1300370856 = new ComposableLambdaImpl(false, -1300370856, new MainActivity$$ExternalSyntheticLambda44(b12));
        f20lambda$1495682491 = new ComposableLambdaImpl(false, -1495682491, new MainActivity$$ExternalSyntheticLambda44((byte) 17));
        f30lambda$394851107 = new ComposableLambdaImpl(false, -394851107, new MainActivity$$ExternalSyntheticLambda30((byte) 9));
        f21lambda$1502782614 = new ComposableLambdaImpl(false, -1502782614, new MainActivity$$ExternalSyntheticLambda44((byte) 18));
        lambda$1428428444 = new ComposableLambdaImpl(false, 1428428444, new MainActivity$$ExternalSyntheticLambda30(b2));
        lambda$1502905431 = new ComposableLambdaImpl(false, 1502905431, new MainActivity$$ExternalSyntheticLambda30(b5));
        new ComposableLambdaImpl(false, -293272359, new MainActivity$$ExternalSyntheticLambda44((byte) 27));
        new ComposableLambdaImpl(false, -1026381540, new MainActivity$$ExternalSyntheticLambda44((byte) 28));
        f14lambda$127042684 = new ComposableLambdaImpl(false, -127042684, new MainActivity$$ExternalSyntheticLambda44((byte) 29));
        new ComposableLambdaImpl(false, 1072399974, new ExperimentalLyricsKt$$ExternalSyntheticLambda25((byte) 1));
        lambda$1577977796 = new ComposableLambdaImpl(false, 1577977796, new ExperimentalLyricsKt$$ExternalSyntheticLambda25((byte) 2));
        lambda$1633512845 = new ComposableLambdaImpl(false, 1633512845, new MainActivity$$ExternalSyntheticLambda44((byte) 20));
        lambda$139505329 = new ComposableLambdaImpl(false, 139505329, new MainActivity$$ExternalSyntheticLambda44((byte) 21));
        lambda$1713319177 = new ComposableLambdaImpl(false, 1713319177, new MainActivity$$ExternalSyntheticLambda44((byte) 22));
        new ComposableLambdaImpl(false, 558171817, new MainActivity$$ExternalSyntheticLambda44((byte) 19));
        new ComposableLambdaImpl(false, 96399470, new MainActivity$$ExternalSyntheticLambda44((byte) 23));
        f34lambda$933231693 = new ComposableLambdaImpl(false, -933231693, new MainActivity$$ExternalSyntheticLambda44((byte) 24));
        lambda$2056500737 = new ComposableLambdaImpl(false, 2056500737, new MainActivity$$ExternalSyntheticLambda44((byte) 25));
        lambda$25624799 = new ComposableLambdaImpl(false, 25624799, new MainActivity$$ExternalSyntheticLambda44((byte) 26));
        lambda$890088552 = new ComposableLambdaImpl(false, 890088552, new MainActivity$$ExternalSyntheticLambda30(b8));
        lambda$223726883 = new ComposableLambdaImpl(false, 223726883, new MainActivity$$ExternalSyntheticLambda30(b9));
        f18lambda$1370294970 = new ComposableLambdaImpl(false, -1370294970, new MainActivity$$ExternalSyntheticLambda30(b10));
        lambda$56008067 = new ComposableLambdaImpl(false, 56008067, new MainActivity$$ExternalSyntheticLambda30(b11));
        lambda$1295355648 = new ComposableLambdaImpl(false, 1295355648, new MainActivity$$ExternalSyntheticLambda30(b12));
        f28lambda$2215896 = new ComposableLambdaImpl(false, -2215896, new ExperimentalLyricsKt$$ExternalSyntheticLambda25((byte) 3));
        lambda$1988371312 = new ComposableLambdaImpl(false, 1988371312, new ExperimentalLyricsKt$$ExternalSyntheticLambda25(b3));
        lambda$1106178229 = new ComposableLambdaImpl(false, 1106178229, new ExperimentalLyricsKt$$ExternalSyntheticLambda25(b4));
        f22lambda$1695936880 = new ComposableLambdaImpl(false, -1695936880, new ExperimentalLyricsKt$$ExternalSyntheticLambda25(b6));
        f26lambda$2095624441 = new ComposableLambdaImpl(false, -2095624441, new ExperimentalLyricsKt$$ExternalSyntheticLambda25(b7));
        f31lambda$416583220 = new ComposableLambdaImpl(false, -416583220, new ExperimentalLyricsKt$$ExternalSyntheticLambda25(b));
        f33lambda$908072932 = new ComposableLambdaImpl(false, -908072932, new ExperimentalLyricsKt$$ExternalSyntheticLambda25((byte) 9));
        lambda$1827852123 = new ComposableLambdaImpl(false, 1827852123, new ExperimentalLyricsKt$$ExternalSyntheticLambda25(b2));
        lambda$1715181715 = new ComposableLambdaImpl(false, 1715181715, new ExperimentalLyricsKt$$ExternalSyntheticLambda25(b5));
        lambda$1490944580 = new ComposableLambdaImpl(false, 1490944580, new ExperimentalLyricsKt$$ExternalSyntheticLambda25(b8));
        f29lambda$341175415 = new ComposableLambdaImpl(false, -341175415, new ExperimentalLyricsKt$$ExternalSyntheticLambda25(b9));
        f27lambda$2107686734 = new ComposableLambdaImpl(false, -2107686734, new ExperimentalLyricsKt$$ExternalSyntheticLambda25(b10));
        lambda$1007107521 = new ComposableLambdaImpl(false, 1007107521, new ExperimentalLyricsKt$$ExternalSyntheticLambda25(b11));
        f15lambda$1292083341 = new ComposableLambdaImpl(false, -1292083341, new MainActivity$$ExternalSyntheticLambda30((byte) 17));
        f32lambda$521944103 = new ComposableLambdaImpl(false, -521944103, new ExperimentalLyricsKt$$ExternalSyntheticLambda25(b12));
        lambda$233336693 = new ComposableLambdaImpl(false, 233336693, new ExperimentalLyricsKt$$ExternalSyntheticLambda25((byte) 17));
        lambda$1743127747 = new ComposableLambdaImpl(false, 1743127747, new MainActivity$$ExternalSyntheticLambda30((byte) 18));
        f19lambda$1382044806 = new ComposableLambdaImpl(false, -1382044806, new MainActivity$$ExternalSyntheticLambda30((byte) 19));
        lambda$1421683131 = new ComposableLambdaImpl(false, 1421683131, new MainActivity$$ExternalSyntheticLambda30((byte) 20));
        lambda$42143121 = new ComposableLambdaImpl(false, 42143121, new ExperimentalLyricsKt$$ExternalSyntheticLambda25((byte) 18));
        f23lambda$1816687740 = new ComposableLambdaImpl(false, -1816687740, new ExperimentalLyricsKt$$ExternalSyntheticLambda25((byte) 19));
        f16lambda$1295239762 = new ComposableLambdaImpl(false, -1295239762, new ExperimentalLyricsKt$$ExternalSyntheticLambda25((byte) 20));
        byte b13 = 21;
        lambda$1716948769 = new ComposableLambdaImpl(false, 1716948769, new ExperimentalLyricsKt$$ExternalSyntheticLambda25(b13));
        f24lambda$1831116798 = new ComposableLambdaImpl(false, -1831116798, new MainActivity$$ExternalSyntheticLambda30(b13));
        byte b14 = 22;
        f36lambda$988255900 = new ComposableLambdaImpl(false, -988255900, new ExperimentalLyricsKt$$ExternalSyntheticLambda25(b14));
        lambda$2099584596 = new ComposableLambdaImpl(false, 2099584596, new MainActivity$$ExternalSyntheticLambda30(b14));
        f13lambda$1243164339 = new ComposableLambdaImpl(false, -1243164339, new ExperimentalLyricsKt$$ExternalSyntheticLambda25((byte) 23));
    }

    /* JADX WARN: Code duplicated, block: B:23:0x004c  */
    /* JADX WARN: Code duplicated, block: B:24:0x004f  */
    /* JADX WARN: Code duplicated, block: B:27:0x0056  */
    /* JADX WARN: Code duplicated, block: B:28:0x005b  */
    /* JADX WARN: Code duplicated, block: B:30:0x0063  */
    /* JADX WARN: Code duplicated, block: B:31:0x0066  */
    /* JADX WARN: Code duplicated, block: B:35:0x0074  */
    /* JADX WARN: Code duplicated, block: B:36:0x0076  */
    /* JADX WARN: Code duplicated, block: B:39:0x007e  */
    /* JADX WARN: Code duplicated, block: B:41:0x0081  */
    /* JADX WARN: Code duplicated, block: B:43:0x0084  */
    /* JADX WARN: Code duplicated, block: B:44:0x0086  */
    /* JADX WARN: Code duplicated, block: B:46:0x0089  */
    /* JADX WARN: Code duplicated, block: B:47:0x008b  */
    /* JADX WARN: Code duplicated, block: B:49:0x008e  */
    /* JADX WARN: Code duplicated, block: B:51:0x00a5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:52:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:53:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:56:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:59:0x0100  */
    /* JADX WARN: Code duplicated, block: B:61:? A[RETURN, SYNTHETIC] */
    public static final void ActionPromptDialog(String str, Function3 function3, Function0 function0, Function0 function1, Function0 function2, Function0 function4, ComposableLambdaImpl composableLambdaImpl, Composer composer, int i, int i2) {
        String str2;
        int i3;
        Function3 function5;
        int i4;
        int i5;
        int i6;
        Function0 function6;
        int i7;
        int i8;
        byte b;
        byte b2;
        boolean z;
        Function3 function7;
        Function0 function8;
        String str3;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        ComposableLambdaImpl composableLambdaImplRememberComposableLambda;
        Function3 function9;
        Function0 function10;
        function0.getClass();
        function1.getClass();
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-1914120703);
        int i9 = i2 & 1;
        byte b3 = 4;
        byte b4 = 2;
        if (i9 != 0) {
            i3 = i | 6;
            str2 = str;
        } else {
            str2 = str;
            i3 = i | (gapComposer.changed(str2) ? 4 : 2);
        }
        int i10 = i2 & 2;
        if (i10 == 0) {
            if ((i & 48) == 0) {
                function5 = function3;
                i3 |= gapComposer.changedInstance(function5) ? 32 : 16;
            }
            if (gapComposer.changedInstance(function1)) {
                i4 = 2048;
            } else {
                i4 = 1024;
            }
            i5 = i3 | i4;
            i6 = i2 & 16;
            if (i6 != 0) {
                i8 = i5 | 24576;
                function6 = function2;
            } else {
                function6 = function2;
                if (gapComposer.changedInstance(function6)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i8 = i5 | i7;
            }
            b = 0;
            b2 = 1;
            if ((599187 & i8) != 599186) {
                z = true;
            } else {
                z = false;
            }
            if (gapComposer.shouldExecute(i8 & 1, z)) {
                composableLambdaImplRememberComposableLambda = null;
                if (i9 != 0) {
                    str2 = null;
                }
                if (i10 != 0) {
                    function9 = null;
                } else {
                    function9 = function5;
                }
                if (i6 != 0) {
                    function10 = null;
                } else {
                    function10 = function6;
                }
                if (function9 != null) {
                    gapComposer.startReplaceGroup(711315467);
                    composableLambdaImplRememberComposableLambda = Expect_jvmKt.rememberComposableLambda(1183568033, new AppBarKt$$ExternalSyntheticLambda2(function9, b2), gapComposer);
                    gapComposer.end(false);
                } else if (str2 != null) {
                    gapComposer.startReplaceGroup(711401616);
                    composableLambdaImplRememberComposableLambda = Expect_jvmKt.rememberComposableLambda(-1546265142, new MainActivity$$ExternalSyntheticLambda6(str2, b3), gapComposer);
                    gapComposer.end(false);
                } else {
                    gapComposer.startReplaceGroup(711701789);
                    gapComposer.end(false);
                }
                DefaultDialog(function0, null, null, composableLambdaImplRememberComposableLambda, Expect_jvmKt.rememberComposableLambda(-783918033, new DialogKt$$ExternalSyntheticLambda4(function10, function4, function1, b), gapComposer), null, Expect_jvmKt.rememberComposableLambda(-308983911, new ItemsKt$$ExternalSyntheticLambda9(composableLambdaImpl, b4), gapComposer), gapComposer, 1597446, 38);
                function7 = function9;
                function8 = function10;
            } else {
                gapComposer.skipToGroupEnd();
                function7 = function5;
                function8 = function6;
            }
            str3 = str2;
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new DialogKt$$ExternalSyntheticLambda6(str3, function7, function0, function1, function8, function4, composableLambdaImpl, i, i2);
            }
        }
        i3 |= 48;
        function5 = function3;
        if (gapComposer.changedInstance(function1)) {
            i4 = 2048;
        } else {
            i4 = 1024;
        }
        i5 = i3 | i4;
        i6 = i2 & 16;
        if (i6 != 0) {
            i8 = i5 | 24576;
            function6 = function2;
        } else {
            function6 = function2;
            if (gapComposer.changedInstance(function6)) {
                i7 = 16384;
            } else {
                i7 = 8192;
            }
            i8 = i5 | i7;
        }
        b = 0;
        b2 = 1;
        if ((599187 & i8) != 599186) {
            z = true;
        } else {
            z = false;
        }
        if (gapComposer.shouldExecute(i8 & 1, z)) {
            composableLambdaImplRememberComposableLambda = null;
            if (i9 != 0) {
                str2 = null;
            }
            if (i10 != 0) {
                function9 = null;
            } else {
                function9 = function5;
            }
            if (i6 != 0) {
                function10 = null;
            } else {
                function10 = function6;
            }
            if (function9 != null) {
                gapComposer.startReplaceGroup(711315467);
                composableLambdaImplRememberComposableLambda = Expect_jvmKt.rememberComposableLambda(1183568033, new AppBarKt$$ExternalSyntheticLambda2(function9, b2), gapComposer);
                gapComposer.end(false);
            } else if (str2 != null) {
                gapComposer.startReplaceGroup(711401616);
                composableLambdaImplRememberComposableLambda = Expect_jvmKt.rememberComposableLambda(-1546265142, new MainActivity$$ExternalSyntheticLambda6(str2, b3), gapComposer);
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(711701789);
                gapComposer.end(false);
            }
            DefaultDialog(function0, null, null, composableLambdaImplRememberComposableLambda, Expect_jvmKt.rememberComposableLambda(-783918033, new DialogKt$$ExternalSyntheticLambda4(function10, function4, function1, b), gapComposer), null, Expect_jvmKt.rememberComposableLambda(-308983911, new ItemsKt$$ExternalSyntheticLambda9(composableLambdaImpl, b4), gapComposer), gapComposer, 1597446, 38);
            function7 = function9;
            function8 = function10;
        } else {
            gapComposer.skipToGroupEnd();
            function7 = function5;
            function8 = function6;
        }
        str3 = str2;
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new DialogKt$$ExternalSyntheticLambda6(str3, function7, function0, function1, function8, function4, composableLambdaImpl, i, i2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:60:0x015f  */
    /* JADX WARN: Code duplicated, block: B:62:0x0163  */
    /* JADX WARN: Code duplicated, block: B:64:0x016c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:65:0x016e  */
    /* JADX WARN: Code duplicated, block: B:66:0x0171  */
    /* JADX WARN: Code duplicated, block: B:68:0x0185  */
    /* JADX INFO: renamed from: AnimatedFilterChip-FNF3uiM, reason: not valid java name */
    public static final void m1457AnimatedFilterChipFNF3uiM(int i, long j, Composer composer, String str, Function0 function0, boolean z) {
        int i2;
        long j2;
        long j3;
        RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_4;
        BorderStroke borderStrokeM38BorderStrokecXLIe8U;
        long jColor;
        long j4;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(582868428);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changed(z) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer.changed(j) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= gapComposer.changedInstance(function0) ? 2048 : 1024;
        }
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 1171) != 1170)) {
            boolean zIsGlassStyle = UiStyleKt.isGlassStyle(gapComposer);
            long jGlassFill = GlassComponentsKt.glassFill(false, gapComposer, 1);
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
            long j5 = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.primary;
            if (zIsGlassStyle) {
                if (z) {
                    jGlassFill = ColorKt.Color(Color.m485getRedimpl(j5), Color.m484getGreenimpl(j5), Color.m482getBlueimpl(j5), 0.26f, Color.m483getColorSpaceimpl(j5));
                }
            } else if (z) {
                gapComposer.startReplaceGroup(1790821813);
                jGlassFill = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.onSurface;
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(1790822298);
                gapComposer.end(false);
                jGlassFill = j;
            }
            AnimateAsState animateAsStateM17animateColorAsStateeuL9pac = SingleValueAnimationKt.m17animateColorAsStateeuL9pac(jGlassFill, ArcSplineKt.tween$default(180, 0, null, 6), "chipBg", gapComposer, 432, 8);
            if (zIsGlassStyle) {
                if (z) {
                    gapComposer.startReplaceGroup(1790833395);
                    gapComposer.end(false);
                    j3 = j5;
                } else {
                    gapComposer.startReplaceGroup(1790834652);
                    j2 = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.onSurfaceVariant;
                    gapComposer.end(false);
                }
                AnimateAsState animateAsStateM17animateColorAsStateeuL9pac2 = SingleValueAnimationKt.m17animateColorAsStateeuL9pac(j3, ArcSplineKt.tween$default(180, 0, null, 6), "chipFg", gapComposer, 432, 8);
                PaddingValuesImpl paddingValuesImpl = FilterChipDefaults.ContentPadding;
                SelectableChipColors selectableChipColorsM288filterChipColorsXqyqHi0 = FilterChipDefaults.m288filterChipColorsXqyqHi0(((Color) animateAsStateM17animateColorAsStateeuL9pac.getValue()).value, ((Color) animateAsStateM17animateColorAsStateeuL9pac2.getValue()).value, ((Color) animateAsStateM17animateColorAsStateeuL9pac.getValue()).value, ((Color) animateAsStateM17animateColorAsStateeuL9pac2.getValue()).value, 0L, gapComposer, 3452);
                if (zIsGlassStyle) {
                    roundedCornerShapeM185RoundedCornerShape0680j_4 = RoundedCornerShapeKt.CircleShape;
                } else {
                    roundedCornerShapeM185RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(8.0f);
                }
                RoundedCornerShape roundedCornerShape = roundedCornerShapeM185RoundedCornerShape0680j_4;
                if (zIsGlassStyle) {
                    if (z) {
                        jColor = j5;
                    } else {
                        jColor = ColorKt.Color(Color.m485getRedimpl(-4294967296L), Color.m484getGreenimpl(-4294967296L), Color.m482getBlueimpl(-4294967296L), 0.35f, Color.m483getColorSpaceimpl(-4294967296L));
                    }
                    borderStrokeM38BorderStrokecXLIe8U = ImageKt.m38BorderStrokecXLIe8U(jColor, 1.0f);
                } else {
                    borderStrokeM38BorderStrokecXLIe8U = null;
                }
                ChipKt.FilterChip(z, function0, Expect_jvmKt.rememberComposableLambda(-921862727, new MainActivity$$ExternalSyntheticLambda6(str, (byte) 2), gapComposer), pressScale(Modifier.Companion.$$INSTANCE, 0.95f), false, null, roundedCornerShape, selectableChipColorsM288filterChipColorsXqyqHi0, null, borderStrokeM38BorderStrokecXLIe8U, null, null, gapComposer, ((i2 >> 3) & 14) | 384 | ((i2 >> 6) & 112), 0, 14960);
                gapComposer = gapComposer;
            } else {
                gapComposer.startReplaceGroup(1790829515);
                if (z) {
                    gapComposer.startReplaceGroup(1790830707);
                    j4 = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.surface;
                } else {
                    gapComposer.startReplaceGroup(1790831964);
                    j4 = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.onSurfaceVariant;
                }
                gapComposer.end(false);
                j2 = j4;
                gapComposer.end(false);
            }
            j3 = j2;
            AnimateAsState animateAsStateM17animateColorAsStateeuL9pac3 = SingleValueAnimationKt.m17animateColorAsStateeuL9pac(j3, ArcSplineKt.tween$default(180, 0, null, 6), "chipFg", gapComposer, 432, 8);
            PaddingValuesImpl paddingValuesImpl2 = FilterChipDefaults.ContentPadding;
            SelectableChipColors selectableChipColorsM288filterChipColorsXqyqHi1 = FilterChipDefaults.m288filterChipColorsXqyqHi0(((Color) animateAsStateM17animateColorAsStateeuL9pac.getValue()).value, ((Color) animateAsStateM17animateColorAsStateeuL9pac3.getValue()).value, ((Color) animateAsStateM17animateColorAsStateeuL9pac.getValue()).value, ((Color) animateAsStateM17animateColorAsStateeuL9pac3.getValue()).value, 0L, gapComposer, 3452);
            if (zIsGlassStyle) {
                roundedCornerShapeM185RoundedCornerShape0680j_4 = RoundedCornerShapeKt.CircleShape;
            } else {
                roundedCornerShapeM185RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(8.0f);
            }
            RoundedCornerShape roundedCornerShape2 = roundedCornerShapeM185RoundedCornerShape0680j_4;
            if (zIsGlassStyle) {
                if (z) {
                    jColor = j5;
                } else {
                    jColor = ColorKt.Color(Color.m485getRedimpl(-4294967296L), Color.m484getGreenimpl(-4294967296L), Color.m482getBlueimpl(-4294967296L), 0.35f, Color.m483getColorSpaceimpl(-4294967296L));
                }
                borderStrokeM38BorderStrokecXLIe8U = ImageKt.m38BorderStrokecXLIe8U(jColor, 1.0f);
            } else {
                borderStrokeM38BorderStrokecXLIe8U = null;
            }
            ChipKt.FilterChip(z, function0, Expect_jvmKt.rememberComposableLambda(-921862727, new MainActivity$$ExternalSyntheticLambda6(str, (byte) 2), gapComposer), pressScale(Modifier.Companion.$$INSTANCE, 0.95f), false, null, roundedCornerShape2, selectableChipColorsM288filterChipColorsXqyqHi1, null, borderStrokeM38BorderStrokecXLIe8U, null, null, gapComposer, ((i2 >> 3) & 14) | 384 | ((i2 >> 6) & 112), 0, 14960);
            gapComposer = gapComposer;
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ChipsRowKt$$ExternalSyntheticLambda12(i, j, str, function0, z);
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x004a  */
    /* JADX WARN: Code duplicated, block: B:24:0x004d  */
    /* JADX WARN: Code duplicated, block: B:27:0x0056  */
    /* JADX WARN: Code duplicated, block: B:36:0x006f  */
    /* JADX WARN: Code duplicated, block: B:38:0x0073  */
    /* JADX WARN: Code duplicated, block: B:58:0x010c  */
    /* JADX WARN: Code duplicated, block: B:60:0x0123  */
    /* JADX WARN: Code duplicated, block: B:63:0x012d  */
    /* JADX WARN: Code duplicated, block: B:65:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: AuralysLoader-RIQooxk, reason: not valid java name */
    public static final void m1458AuralysLoaderRIQooxk(final Modifier modifier, final long j, long j2, Composer composer, final int i, final int i2) {
        int i3;
        final long j3;
        int i4;
        boolean z;
        GapComposer gapComposer;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        long j4;
        InfiniteTransition.TransitionAnimationState transitionAnimationStateAnimateFloat;
        InfiniteTransition.TransitionAnimationState transitionAnimationStateAnimateFloat2;
        boolean zChanged;
        Object objRememberedValue;
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(1260132025);
        if ((i & 6) == 0) {
            i3 = i | (gapComposer2.changed(modifier) ? 4 : 2);
        } else {
            i3 = i;
        }
        int i5 = i3 | (gapComposer2.changed(j) ? 32 : 16);
        if ((i2 & 4) == 0) {
            j3 = j2;
            int i6 = gapComposer2.changed(j3) ? 256 : 128;
            i4 = i5 | i6;
            if ((i4 & 147) != 146) {
                z = true;
            } else {
                z = false;
            }
            if (gapComposer2.shouldExecute(i4 & 1, z)) {
                gapComposer2.startDefaults();
                if ((i & 1) == 0 && !gapComposer2.getDefaultsInvalid()) {
                    gapComposer2.skipToGroupEnd();
                    if ((i2 & 4) != 0) {
                        i4 &= -897;
                    }
                } else if ((i2 & 4) != 0) {
                    j3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.onSurface;
                    i4 &= -897;
                }
                j4 = j3;
                gapComposer2.endDefaults();
                InfiniteTransition infiniteTransitionRememberInfiniteTransition = ArcSplineKt.rememberInfiniteTransition(0, gapComposer2);
                transitionAnimationStateAnimateFloat = ArcSplineKt.animateFloat(infiniteTransitionRememberInfiniteTransition, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f, ArcSplineKt.m19infiniteRepeatable9IiC70o$default(ArcSplineKt.tween$default(1300, 0, EasingKt.LinearEasing, 2), null, 0L, 6), "wavePhase", gapComposer2, 29112, 0);
                transitionAnimationStateAnimateFloat2 = ArcSplineKt.animateFloat(infiniteTransitionRememberInfiniteTransition, 0.82f, 1.0f, ArcSplineKt.m19infiniteRepeatable9IiC70o$default(ArcSplineKt.tween$default(1300, 0, EasingKt.FastOutSlowInEasing, 2), RepeatMode.Reverse, 0L, 4), "sunRise", gapComposer2, 29112, 0);
                gapComposer = gapComposer2;
                zChanged = ((((i4 & 112) ^ 48) <= 32 && gapComposer.changed(j)) || (i4 & 48) == 32) | ((((i4 & 896) ^ 384) <= 256 && gapComposer.changed(j4)) || (i4 & 384) == 256) | gapComposer.changed(transitionAnimationStateAnimateFloat2) | gapComposer.changed(transitionAnimationStateAnimateFloat);
                objRememberedValue = gapComposer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.Companion.Empty) {
                    BorderKt$$ExternalSyntheticLambda0 borderKt$$ExternalSyntheticLambda0 = new BorderKt$$ExternalSyntheticLambda0(j, j4, transitionAnimationStateAnimateFloat2, transitionAnimationStateAnimateFloat, (byte) 1);
                    gapComposer.updateRememberedValue(borderKt$$ExternalSyntheticLambda0);
                    objRememberedValue = borderKt$$ExternalSyntheticLambda0;
                }
                ImageKt.Canvas(i4 & 14, gapComposer, modifier, (Function1) objRememberedValue);
                j3 = j4;
            } else {
                gapComposer = gapComposer2;
                gapComposer.skipToGroupEnd();
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.metrolist.music.ui.component.AuralysBrandKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        DialogKt.m1458AuralysLoaderRIQooxk(modifier, j, j3, (Composer) obj, Stack.updateChangedFlags(i | 1), i2);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        j3 = j2;
        i4 = i5 | i6;
        if ((i4 & 147) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (gapComposer2.shouldExecute(i4 & 1, z)) {
            gapComposer2.startDefaults();
            if ((i & 1) == 0) {
                if ((i2 & 4) != 0) {
                    j3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.onSurface;
                    i4 &= -897;
                }
            } else if ((i2 & 4) != 0) {
                j3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.onSurface;
                i4 &= -897;
            }
            j4 = j3;
            gapComposer2.endDefaults();
            InfiniteTransition infiniteTransitionRememberInfiniteTransition2 = ArcSplineKt.rememberInfiniteTransition(0, gapComposer2);
            transitionAnimationStateAnimateFloat = ArcSplineKt.animateFloat(infiniteTransitionRememberInfiniteTransition2, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f, ArcSplineKt.m19infiniteRepeatable9IiC70o$default(ArcSplineKt.tween$default(1300, 0, EasingKt.LinearEasing, 2), null, 0L, 6), "wavePhase", gapComposer2, 29112, 0);
            transitionAnimationStateAnimateFloat2 = ArcSplineKt.animateFloat(infiniteTransitionRememberInfiniteTransition2, 0.82f, 1.0f, ArcSplineKt.m19infiniteRepeatable9IiC70o$default(ArcSplineKt.tween$default(1300, 0, EasingKt.FastOutSlowInEasing, 2), RepeatMode.Reverse, 0L, 4), "sunRise", gapComposer2, 29112, 0);
            gapComposer = gapComposer2;
            zChanged = ((((i4 & 112) ^ 48) <= 32 && gapComposer.changed(j)) || (i4 & 48) == 32) | ((((i4 & 896) ^ 384) <= 256 && gapComposer.changed(j4)) || (i4 & 384) == 256) | gapComposer.changed(transitionAnimationStateAnimateFloat2) | gapComposer.changed(transitionAnimationStateAnimateFloat);
            objRememberedValue = gapComposer.rememberedValue();
            if (zChanged) {
                BorderKt$$ExternalSyntheticLambda0 borderKt$$ExternalSyntheticLambda1 = new BorderKt$$ExternalSyntheticLambda0(j, j4, transitionAnimationStateAnimateFloat2, transitionAnimationStateAnimateFloat, (byte) 1);
                gapComposer.updateRememberedValue(borderKt$$ExternalSyntheticLambda1);
                objRememberedValue = borderKt$$ExternalSyntheticLambda1;
            } else {
                BorderKt$$ExternalSyntheticLambda0 borderKt$$ExternalSyntheticLambda2 = new BorderKt$$ExternalSyntheticLambda0(j, j4, transitionAnimationStateAnimateFloat2, transitionAnimationStateAnimateFloat, (byte) 1);
                gapComposer.updateRememberedValue(borderKt$$ExternalSyntheticLambda2);
                objRememberedValue = borderKt$$ExternalSyntheticLambda2;
            }
            ImageKt.Canvas(i4 & 14, gapComposer, modifier, (Function1) objRememberedValue);
            j3 = j4;
        } else {
            gapComposer = gapComposer2;
            gapComposer.skipToGroupEnd();
        }
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.metrolist.music.ui.component.AuralysBrandKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    DialogKt.m1458AuralysLoaderRIQooxk(modifier, j, j3, (Composer) obj, Stack.updateChangedFlags(i | 1), i2);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX INFO: renamed from: AuralysMark-qi6gXK8, reason: not valid java name */
    public static final void m1459AuralysMarkqi6gXK8(Modifier modifier, long j, long j2, float f, float f2, Composer composer, final int i) {
        final Modifier modifier2;
        final long j3;
        final long j4;
        final float f3;
        final float f4;
        long j5;
        long j6;
        float f5;
        float f6;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-498872381);
        int i2 = i | 224400;
        if (gapComposer.shouldExecute(i2 & 1, (74899 & i2) != 74898)) {
            gapComposer.startDefaults();
            if ((i & 1) == 0 || gapComposer.getDefaultsInvalid()) {
                StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                j5 = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.primary;
                j6 = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.onSurface;
                f5 = 1.0f;
                f6 = 1.0f;
            } else {
                gapComposer.skipToGroupEnd();
                j5 = j;
                j6 = j2;
                f5 = f;
                f6 = f2;
            }
            gapComposer.endDefaults();
            boolean zChanged = gapComposer.changed(j5) | gapComposer.changed(j6);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.Empty) {
                final float f7 = f5;
                final long j7 = j5;
                final long j8 = j6;
                final float f8 = f6;
                objRememberedValue = new Function1() { // from class: com.metrolist.music.ui.component.AuralysBrandKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        DrawScope drawScope = (DrawScope) obj;
                        drawScope.getClass();
                        DialogKt.m1471drawAuralysMarkRIQooxk(drawScope, j7, j8, f7, f8, CropImageView.DEFAULT_ASPECT_RATIO);
                        return Unit.INSTANCE;
                    }
                };
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            modifier2 = modifier;
            ImageKt.Canvas(6, gapComposer, modifier2, (Function1) objRememberedValue);
            f3 = f5;
            j3 = j5;
            j4 = j6;
            f4 = f6;
        } else {
            modifier2 = modifier;
            gapComposer.skipToGroupEnd();
            j3 = j;
            j4 = j2;
            f3 = f;
            f4 = f2;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2(j3, j4, f3, f4, i) { // from class: com.metrolist.music.ui.component.AuralysBrandKt$$ExternalSyntheticLambda4
                public final /* synthetic */ long f$1;
                public final /* synthetic */ long f$2;
                public final /* synthetic */ float f$3;
                public final /* synthetic */ float f$4;

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(7);
                    DialogKt.m1459AuralysMarkqi6gXK8(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, (Composer) obj, iUpdateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX WARN: Code duplicated, block: B:57:0x01fa  */
    public static final void AuralysSplash(Function0 function0, Function0 function1, Modifier modifier, Composer composer, int i) {
        Modifier modifier2;
        Object obj;
        NeverEqualPolicy neverEqualPolicy;
        long j;
        boolean zChangedInstance;
        boolean z;
        Object obj2;
        function0.getClass();
        function1.getClass();
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-1653540269);
        int i2 = i | (gapComposer.changedInstance(function0) ? 4 : 2) | (gapComposer.changedInstance(function1) ? 32 : 16) | 384;
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy2 = Composer.Companion.Empty;
            if (objRememberedValue == neverEqualPolicy2) {
                obj = objRememberedValue;
                Animatable animatableAnimatable$default = ArcSplineKt.Animatable$default(CropImageView.DEFAULT_ASPECT_RATIO);
                gapComposer.updateRememberedValue(animatableAnimatable$default);
                obj = animatableAnimatable$default;
            }
            obj = objRememberedValue;
            Animatable animatable = (Animatable) obj;
            Object objRememberedValue2 = gapComposer.rememberedValue();
            Object obj3 = objRememberedValue2;
            if (objRememberedValue2 == neverEqualPolicy2) {
                Animatable animatableAnimatable$default2 = ArcSplineKt.Animatable$default(CropImageView.DEFAULT_ASPECT_RATIO);
                gapComposer.updateRememberedValue(animatableAnimatable$default2);
                obj3 = animatableAnimatable$default2;
            }
            Animatable animatable2 = (Animatable) obj3;
            Object objRememberedValue3 = gapComposer.rememberedValue();
            Object obj4 = objRememberedValue3;
            if (objRememberedValue3 == neverEqualPolicy2) {
                Animatable animatableAnimatable$default3 = ArcSplineKt.Animatable$default(CropImageView.DEFAULT_ASPECT_RATIO);
                gapComposer.updateRememberedValue(animatableAnimatable$default3);
                obj4 = animatableAnimatable$default3;
            }
            Animatable animatable3 = (Animatable) obj4;
            Object objRememberedValue4 = gapComposer.rememberedValue();
            Object obj5 = objRememberedValue4;
            if (objRememberedValue4 == neverEqualPolicy2) {
                Animatable animatableAnimatable$default4 = ArcSplineKt.Animatable$default(1.0f);
                gapComposer.updateRememberedValue(animatableAnimatable$default4);
                obj5 = animatableAnimatable$default4;
            }
            Animatable animatable4 = (Animatable) obj5;
            MutableState mutableStateRememberUpdatedState = Stack.rememberUpdatedState(function0, gapComposer);
            MutableState mutableStateRememberUpdatedState2 = Stack.rememberUpdatedState(function1, gapComposer);
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
            long j2 = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.primary;
            long j3 = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.onSurface;
            long j4 = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.surface;
            boolean zChangedInstance2 = gapComposer.changedInstance(animatable) | gapComposer.changedInstance(animatable2) | gapComposer.changedInstance(animatable3) | gapComposer.changed(mutableStateRememberUpdatedState) | gapComposer.changedInstance(animatable4) | gapComposer.changed(mutableStateRememberUpdatedState2);
            Object objRememberedValue5 = gapComposer.rememberedValue();
            Object obj6 = objRememberedValue5;
            if (zChangedInstance2 || objRememberedValue5 == neverEqualPolicy2) {
                NetworkFetcher$doFetch$fetchResult$1 networkFetcher$doFetch$fetchResult$1 = new NetworkFetcher$doFetch$fetchResult$1(animatable4, animatable, animatable2, animatable3, mutableStateRememberUpdatedState, mutableStateRememberUpdatedState2, null, (byte) 3);
                gapComposer.updateRememberedValue(networkFetcher$doFetch$fetchResult$1);
                obj6 = networkFetcher$doFetch$fetchResult$1;
            }
            Stack.LaunchedEffect(gapComposer, Unit.INSTANCE, (Function2) obj6);
            FillElement fillElement = SizeKt.FillWholeMaxSize;
            boolean zChangedInstance3 = gapComposer.changedInstance(animatable4);
            Object objRememberedValue6 = gapComposer.rememberedValue();
            Object obj7 = objRememberedValue6;
            if (zChangedInstance3 || objRememberedValue6 == neverEqualPolicy2) {
                MiniPlayerKt$$ExternalSyntheticLambda2 miniPlayerKt$$ExternalSyntheticLambda2 = new MiniPlayerKt$$ExternalSyntheticLambda2(animatable4, (byte) 2);
                gapComposer.updateRememberedValue(miniPlayerKt$$ExternalSyntheticLambda2);
                obj7 = miniPlayerKt$$ExternalSyntheticLambda2;
            }
            Modifier modifierM39backgroundbw27NRU = ImageKt.m39backgroundbw27NRU(ColorKt.graphicsLayer(fillElement, (Function1) obj7), j4, ColorKt.RectangleShape);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierM39backgroundbw27NRU);
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
            Stack.m390setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy, updater$$ExternalSyntheticLambda0);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda1);
            Integer numValueOf = Integer.valueOf(iHashCode);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetCompositeKeyHash;
            Stack.m390setimpl(gapComposer, numValueOf, updater$$ExternalSyntheticLambda2);
            Stack.m389reconcileimpl(gapComposer);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetModifier;
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier, updater$$ExternalSyntheticLambda3);
            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.CenterHorizontally, gapComposer, 48);
            int iHashCode2 = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer.currentCompositionLocalScope();
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer, companion);
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
            Modifier modifierM151size3ABfNKs = SizeKt.m151size3ABfNKs(companion, 168.0f);
            boolean zChanged = gapComposer.changed(j2) | gapComposer.changed(j3) | gapComposer.changedInstance(animatable) | gapComposer.changedInstance(animatable2);
            Object objRememberedValue7 = gapComposer.rememberedValue();
            if (zChanged) {
                neverEqualPolicy = neverEqualPolicy2;
            } else {
                neverEqualPolicy = neverEqualPolicy2;
                if (objRememberedValue7 != neverEqualPolicy) {
                    j = j3;
                }
                ImageKt.Canvas(6, gapComposer, modifierM151size3ABfNKs, (Function1) objRememberedValue7);
                OffsetKt.Spacer(gapComposer, SizeKt.m145height3ABfNKs(companion, 6.0f));
                TextStyle textStyle = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).typography.headlineLarge;
                zChangedInstance = gapComposer.changedInstance(r30);
                Object objRememberedValue8 = gapComposer.rememberedValue();
                if (!zChangedInstance || objRememberedValue8 == neverEqualPolicy) {
                    z = true;
                    MiniPlayerKt$$ExternalSyntheticLambda2 miniPlayerKt$$ExternalSyntheticLambda3 = new MiniPlayerKt$$ExternalSyntheticLambda2(animatable3, true ? 1 : 0);
                    gapComposer.updateRememberedValue(miniPlayerKt$$ExternalSyntheticLambda3);
                    obj2 = miniPlayerKt$$ExternalSyntheticLambda3;
                } else {
                    z = true;
                    obj2 = objRememberedValue8;
                }
                TextKt.m352TextNvy7gAk("Auralys", ColorKt.graphicsLayer(companion, (Function1) obj2), j, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, textStyle, gapComposer, 6, 0, 131064);
                gapComposer.end(z);
                gapComposer.end(z);
                modifier2 = companion;
            }
            j = j3;
            BorderKt$$ExternalSyntheticLambda0 borderKt$$ExternalSyntheticLambda0 = new BorderKt$$ExternalSyntheticLambda0(j2, j, animatable, animatable2, (byte) 2);
            gapComposer.updateRememberedValue(borderKt$$ExternalSyntheticLambda0);
            objRememberedValue7 = borderKt$$ExternalSyntheticLambda0;
            ImageKt.Canvas(6, gapComposer, modifierM151size3ABfNKs, (Function1) objRememberedValue7);
            OffsetKt.Spacer(gapComposer, SizeKt.m145height3ABfNKs(companion, 6.0f));
            TextStyle textStyle2 = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).typography.headlineLarge;
            zChangedInstance = gapComposer.changedInstance(r30);
            Object objRememberedValue9 = gapComposer.rememberedValue();
            if (zChangedInstance) {
                z = true;
                MiniPlayerKt$$ExternalSyntheticLambda2 miniPlayerKt$$ExternalSyntheticLambda4 = new MiniPlayerKt$$ExternalSyntheticLambda2(animatable3, true ? 1 : 0);
                gapComposer.updateRememberedValue(miniPlayerKt$$ExternalSyntheticLambda4);
                obj2 = miniPlayerKt$$ExternalSyntheticLambda4;
            } else {
                z = true;
                MiniPlayerKt$$ExternalSyntheticLambda2 miniPlayerKt$$ExternalSyntheticLambda5 = new MiniPlayerKt$$ExternalSyntheticLambda2(animatable3, true ? 1 : 0);
                gapComposer.updateRememberedValue(miniPlayerKt$$ExternalSyntheticLambda5);
                obj2 = miniPlayerKt$$ExternalSyntheticLambda5;
            }
            TextKt.m352TextNvy7gAk("Auralys", ColorKt.graphicsLayer(companion, (Function1) obj2), j, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, textStyle2, gapComposer, 6, 0, 131064);
            gapComposer.end(z);
            gapComposer.end(z);
            modifier2 = companion;
        } else {
            gapComposer.skipToGroupEnd();
            modifier2 = modifier;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new MainActivity$$ExternalSyntheticLambda9((byte) 15, i, function0, function1, modifier2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:104:0x01be  */
    /* JADX WARN: Code duplicated, block: B:105:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:109:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:112:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:113:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:129:0x0247  */
    /* JADX WARN: Code duplicated, block: B:132:0x0258  */
    /* JADX WARN: Code duplicated, block: B:134:0x0261  */
    /* JADX WARN: Code duplicated, block: B:135:0x0263  */
    /* JADX WARN: Code duplicated, block: B:139:0x026c  */
    /* JADX WARN: Code duplicated, block: B:141:0x029a  */
    /* JADX WARN: Code duplicated, block: B:148:0x02bc  */
    /* JADX WARN: Code duplicated, block: B:179:0x0390  */
    /* JADX WARN: Code duplicated, block: B:182:0x039d  */
    /* JADX WARN: Code duplicated, block: B:184:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x0067  */
    /* JADX WARN: Code duplicated, block: B:39:0x006d  */
    /* JADX WARN: Code duplicated, block: B:40:0x0070  */
    /* JADX WARN: Code duplicated, block: B:44:0x007b  */
    /* JADX WARN: Code duplicated, block: B:46:0x0083  */
    /* JADX WARN: Code duplicated, block: B:47:0x0086  */
    /* JADX WARN: Code duplicated, block: B:49:0x008a  */
    /* JADX WARN: Code duplicated, block: B:52:0x0096  */
    /* JADX WARN: Code duplicated, block: B:53:0x0098  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:57:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:65:0x00be  */
    /* JADX WARN: Code duplicated, block: B:66:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:70:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:73:0x010d  */
    /* JADX WARN: Code duplicated, block: B:75:0x0113  */
    /* JADX WARN: Code duplicated, block: B:78:0x0152  */
    /* JADX WARN: Code duplicated, block: B:79:0x0155  */
    /* JADX WARN: Code duplicated, block: B:85:0x0162  */
    /* JADX WARN: Code duplicated, block: B:88:0x017e  */
    /* JADX WARN: Code duplicated, block: B:90:0x0182  */
    /* JADX WARN: Code duplicated, block: B:92:0x0187  */
    /* JADX WARN: Code duplicated, block: B:93:0x0189  */
    /* JADX WARN: Code duplicated, block: B:96:0x0196  */
    /* JADX WARN: Code duplicated, block: B:97:0x0198  */
    public static final void BottomSheet(final BottomSheetState bottomSheetState, Modifier modifier, Function3 function3, Function0 function0, ComposableLambdaImpl composableLambdaImpl, boolean z, ComposableLambdaImpl composableLambdaImpl2, Composer composer, int i, int i2) {
        int i3;
        int i4;
        final byte b;
        boolean z2;
        Function0 function1;
        boolean z3;
        ComposableLambdaImpl composableLambdaImpl3;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        Function0 function2;
        float f;
        int i5;
        boolean z4;
        Object obj;
        FillElement fillElement;
        boolean z5;
        TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3;
        boolean z6;
        boolean z7;
        Object obj2;
        int i6;
        boolean z8;
        boolean z9;
        int i7;
        boolean z10;
        boolean z11;
        Object obj3;
        boolean z12;
        boolean zChanged;
        Object obj4;
        boolean z13;
        TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda4;
        boolean z14;
        int i8;
        ComposableLambdaImpl composableLambdaImpl4;
        boolean z15;
        boolean z16;
        Object obj5;
        Object obj6;
        int i9;
        int i10;
        ComposableLambdaImpl composableLambdaImpl5 = composableLambdaImpl;
        bottomSheetState.getClass();
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(2021597860);
        if ((i & 6) == 0) {
            i3 = (gapComposer.changed(bottomSheetState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= gapComposer.changed(modifier) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= gapComposer.changedInstance(function3) ? 256 : 128;
        }
        int i11 = i2 & 8;
        if (i11 == 0) {
            if ((i & 3072) == 0) {
                i3 |= gapComposer.changedInstance(function0) ? 2048 : 1024;
            }
            if ((i & 24576) == 0) {
                if (gapComposer.changedInstance(composableLambdaImpl5)) {
                    i10 = 16384;
                } else {
                    i10 = 8192;
                }
                i3 |= i10;
            }
            i4 = i3 | 196608;
            if ((1572864 & i) != 0) {
                if (gapComposer.changedInstance(composableLambdaImpl2)) {
                    i9 = ByteChannelKt.CHANNEL_MAX_SIZE;
                } else {
                    i9 = 524288;
                }
                i4 |= i9;
            }
            b = 0;
            if ((599187 & i4) != 599186) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (gapComposer.shouldExecute(i4 & 1, z2)) {
                if (i11 != 0) {
                    function2 = null;
                } else {
                    function2 = function0;
                }
                if (UiStyleKt.isGlassStyle(gapComposer)) {
                    f = 28.0f;
                } else {
                    f = 16.0f;
                }
                i5 = i4 & 14;
                if (i5 == 4) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                Object objRememberedValue = gapComposer.rememberedValue();
                NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                obj = objRememberedValue;
                if (z4 || objRememberedValue == neverEqualPolicy) {
                    Function1 function4 = new Function1() { // from class: com.metrolist.music.ui.component.BottomSheetKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj7) {
                            byte b2 = b;
                            Unit unit = Unit.INSTANCE;
                            float f2 = CropImageView.DEFAULT_ASPECT_RATIO;
                            BottomSheetState bottomSheetState2 = bottomSheetState;
                            ReusableGraphicsLayerScope reusableGraphicsLayerScope = (ReusableGraphicsLayerScope) obj7;
                            reusableGraphicsLayerScope.getClass();
                            switch (b2) {
                                case 0:
                                    float progress = bottomSheetState2.getProgress();
                                    if (progress < 0.1f) {
                                        progress = 0.1f;
                                    }
                                    reusableGraphicsLayerScope.setAlpha(UuidKt.coerceIn(((float) Math.pow(progress - 0.1f, 0.5d)) * 1.4f, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f));
                                    break;
                                case 1:
                                    Comparable comparable = bottomSheetState2.animatable.upperBound;
                                    comparable.getClass();
                                    float density = reusableGraphicsLayerScope.graphicsDensity.getDensity() * ((((Dp) comparable).value - bottomSheetState2.m1456getValueD9Ej5fM()) + CropImageView.DEFAULT_ASPECT_RATIO);
                                    if (density >= CropImageView.DEFAULT_ASPECT_RATIO) {
                                        f2 = density;
                                    }
                                    reusableGraphicsLayerScope.setTranslationY(f2);
                                    break;
                                case 2:
                                    float fCoerceIn = UuidKt.coerceIn(bottomSheetState2.getProgress(), CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
                                    float fCoerceIn2 = UuidKt.coerceIn((fCoerceIn - 0.08f) / 0.92f, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
                                    reusableGraphicsLayerScope.setAlpha(UuidKt.coerceIn((fCoerceIn - 0.1f) * 3.2f, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f));
                                    float f3 = (0.05f * fCoerceIn2) + 0.95f;
                                    reusableGraphicsLayerScope.setScaleX(f3);
                                    reusableGraphicsLayerScope.setScaleY(f3);
                                    reusableGraphicsLayerScope.setTranslationY(reusableGraphicsLayerScope.graphicsDensity.getDensity() * 36.0f * (1.0f - fCoerceIn2));
                                    reusableGraphicsLayerScope.m517setTransformOrigin__ExYCQ(ColorKt.TransformOrigin(0.5f, 0.35f));
                                    break;
                                default:
                                    float fCoerceIn3 = UuidKt.coerceIn(bottomSheetState2.getProgress(), CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
                                    float f4 = 3.2f * fCoerceIn3;
                                    if (f4 > 1.0f) {
                                        f4 = 1.0f;
                                    }
                                    reusableGraphicsLayerScope.setAlpha(1.0f - f4);
                                    float f5 = (fCoerceIn3 * 0.12f) + 1.0f;
                                    reusableGraphicsLayerScope.setScaleX(f5);
                                    reusableGraphicsLayerScope.setScaleY(f5);
                                    reusableGraphicsLayerScope.m517setTransformOrigin__ExYCQ(ColorKt.TransformOrigin(0.5f, CropImageView.DEFAULT_ASPECT_RATIO));
                                    break;
                            }
                            return unit;
                        }
                    };
                    gapComposer.updateRememberedValue(function4);
                    obj = function4;
                }
                Modifier modifierGraphicsLayer = ColorKt.graphicsLayer(modifier, (Function1) obj);
                fillElement = SizeKt.FillWholeMaxSize;
                Modifier modifierThen = modifierGraphicsLayer.then(fillElement);
                int i12 = (i4 << 3) & 7168;
                BiasAlignment biasAlignment = Alignment.Companion.TopStart;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, false);
                int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierThen);
                ComposeUiNode.Companion.getClass();
                gapComposer.startReusableNode();
                z5 = gapComposer.inserting;
                textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
                if (z5) {
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
                Object objValueOf = Integer.valueOf(((i12 >> 6) & 112) | 6);
                Object obj7 = BoxScopeInstance.INSTANCE;
                function3.invoke(obj7, gapComposer, objValueOf);
                gapComposer.end(true);
                Modifier modifierThen2 = modifier.then(fillElement);
                if (i5 == 4) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                Object objRememberedValue2 = gapComposer.rememberedValue();
                if (!z6 || objRememberedValue2 == neverEqualPolicy) {
                    z7 = true;
                    final boolean z17 = true ? 1 : 0;
                    Function1 function5 = new Function1() { // from class: com.metrolist.music.ui.component.BottomSheetKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj8) {
                            byte b2 = z17;
                            Unit unit = Unit.INSTANCE;
                            float f2 = CropImageView.DEFAULT_ASPECT_RATIO;
                            BottomSheetState bottomSheetState2 = bottomSheetState;
                            ReusableGraphicsLayerScope reusableGraphicsLayerScope = (ReusableGraphicsLayerScope) obj8;
                            reusableGraphicsLayerScope.getClass();
                            switch (b2) {
                                case 0:
                                    float progress = bottomSheetState2.getProgress();
                                    if (progress < 0.1f) {
                                        progress = 0.1f;
                                    }
                                    reusableGraphicsLayerScope.setAlpha(UuidKt.coerceIn(((float) Math.pow(progress - 0.1f, 0.5d)) * 1.4f, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f));
                                    break;
                                case 1:
                                    Comparable comparable = bottomSheetState2.animatable.upperBound;
                                    comparable.getClass();
                                    float density = reusableGraphicsLayerScope.graphicsDensity.getDensity() * ((((Dp) comparable).value - bottomSheetState2.m1456getValueD9Ej5fM()) + CropImageView.DEFAULT_ASPECT_RATIO);
                                    if (density >= CropImageView.DEFAULT_ASPECT_RATIO) {
                                        f2 = density;
                                    }
                                    reusableGraphicsLayerScope.setTranslationY(f2);
                                    break;
                                case 2:
                                    float fCoerceIn = UuidKt.coerceIn(bottomSheetState2.getProgress(), CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
                                    float fCoerceIn2 = UuidKt.coerceIn((fCoerceIn - 0.08f) / 0.92f, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
                                    reusableGraphicsLayerScope.setAlpha(UuidKt.coerceIn((fCoerceIn - 0.1f) * 3.2f, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f));
                                    float f3 = (0.05f * fCoerceIn2) + 0.95f;
                                    reusableGraphicsLayerScope.setScaleX(f3);
                                    reusableGraphicsLayerScope.setScaleY(f3);
                                    reusableGraphicsLayerScope.setTranslationY(reusableGraphicsLayerScope.graphicsDensity.getDensity() * 36.0f * (1.0f - fCoerceIn2));
                                    reusableGraphicsLayerScope.m517setTransformOrigin__ExYCQ(ColorKt.TransformOrigin(0.5f, 0.35f));
                                    break;
                                default:
                                    float fCoerceIn3 = UuidKt.coerceIn(bottomSheetState2.getProgress(), CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
                                    float f4 = 3.2f * fCoerceIn3;
                                    if (f4 > 1.0f) {
                                        f4 = 1.0f;
                                    }
                                    reusableGraphicsLayerScope.setAlpha(1.0f - f4);
                                    float f5 = (fCoerceIn3 * 0.12f) + 1.0f;
                                    reusableGraphicsLayerScope.setScaleX(f5);
                                    reusableGraphicsLayerScope.setScaleY(f5);
                                    reusableGraphicsLayerScope.m517setTransformOrigin__ExYCQ(ColorKt.TransformOrigin(0.5f, CropImageView.DEFAULT_ASPECT_RATIO));
                                    break;
                            }
                            return unit;
                        }
                    };
                    gapComposer.updateRememberedValue(function5);
                    obj2 = function5;
                } else {
                    z7 = true;
                    obj2 = objRememberedValue2;
                }
                Modifier modifierGraphicsLayer2 = ColorKt.graphicsLayer(modifierThen2, (Function1) obj2);
                Boolean boolValueOf = Boolean.valueOf(z7);
                i6 = 458752 & i4;
                if (i6 == 131072) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                if (i5 == 4) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                boolean z18 = z8 | z9;
                i7 = i4;
                if ((i4 & 7168) == 2048) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                z11 = z18 | z10;
                Object objRememberedValue3 = gapComposer.rememberedValue();
                obj3 = objRememberedValue3;
                if (z11 || objRememberedValue3 == neverEqualPolicy) {
                    BottomSheetKt$BottomSheet$3$1 bottomSheetKt$BottomSheet$3$1 = new BottomSheetKt$BottomSheet$3$1(bottomSheetState, function2, (byte) 0);
                    gapComposer.updateRememberedValue(bottomSheetKt$BottomSheet$3$1);
                    obj3 = bottomSheetKt$BottomSheet$3$1;
                }
                PointerEvent pointerEvent = SuspendingPointerInputFilterKt.EmptyPointerEvent;
                Function0 function6 = function2;
                Modifier modifierThen3 = modifierGraphicsLayer2.then(new SuspendPointerInputElement(bottomSheetState, boolValueOf, (PointerInputEventHandler) obj3, 4));
                if (i5 == 4) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                zChanged = z12 | gapComposer.changed(f);
                Object objRememberedValue4 = gapComposer.rememberedValue();
                obj4 = objRememberedValue4;
                if (zChanged || objRememberedValue4 == neverEqualPolicy) {
                    BottomSheetKt$$ExternalSyntheticLambda13 bottomSheetKt$$ExternalSyntheticLambda13 = new BottomSheetKt$$ExternalSyntheticLambda13(bottomSheetState, f, (byte) 4);
                    gapComposer.updateRememberedValue(bottomSheetKt$$ExternalSyntheticLambda13);
                    obj4 = bottomSheetKt$$ExternalSyntheticLambda13;
                }
                Modifier modifierGraphicsLayer3 = ColorKt.graphicsLayer(modifierThen3, (Function1) obj4);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, false);
                int iHashCode2 = Long.hashCode(gapComposer.compositeKeyHashCode);
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer, modifierGraphicsLayer3);
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
                if (!bottomSheetState.isCollapsed() || bottomSheetState.isDismissed()) {
                    z13 = false;
                    gapComposer.startReplaceGroup(-1438508319);
                    gapComposer.end(false);
                } else {
                    gapComposer.startReplaceGroup(-1439070504);
                    boolean z19 = i5 == 4;
                    Object objRememberedValue5 = gapComposer.rememberedValue();
                    if (z19 || objRememberedValue5 == neverEqualPolicy) {
                        App.C01391 c01391 = new App.C01391((Object) bottomSheetState, (Continuation) null, (byte) 25);
                        gapComposer.updateRememberedValue(c01391);
                        obj6 = c01391;
                    } else {
                        obj6 = objRememberedValue5;
                    }
                    z13 = false;
                    SQLite.PredictiveBackHandler(false, (Function2) obj6, gapComposer, 0, 1);
                    gapComposer.end(false);
                }
                if (bottomSheetState.isCollapsed()) {
                    textKt$$ExternalSyntheticLambda4 = textKt$$ExternalSyntheticLambda3;
                    z14 = z13;
                    i8 = 131072;
                    gapComposer.startReplaceGroup(-1437640319);
                    gapComposer.end(z14);
                } else {
                    gapComposer.startReplaceGroup(-1438425456);
                    if (i5 == 4) {
                        z16 = true;
                    } else {
                        z16 = z13;
                    }
                    Object objRememberedValue6 = gapComposer.rememberedValue();
                    obj5 = objRememberedValue6;
                    if (z16 || objRememberedValue6 == neverEqualPolicy) {
                        final byte b2 = 2;
                        Function1 function7 = new Function1() { // from class: com.metrolist.music.ui.component.BottomSheetKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj8) {
                                byte b3 = b2;
                                Unit unit = Unit.INSTANCE;
                                float f2 = CropImageView.DEFAULT_ASPECT_RATIO;
                                BottomSheetState bottomSheetState2 = bottomSheetState;
                                ReusableGraphicsLayerScope reusableGraphicsLayerScope = (ReusableGraphicsLayerScope) obj8;
                                reusableGraphicsLayerScope.getClass();
                                switch (b3) {
                                    case 0:
                                        float progress = bottomSheetState2.getProgress();
                                        if (progress < 0.1f) {
                                            progress = 0.1f;
                                        }
                                        reusableGraphicsLayerScope.setAlpha(UuidKt.coerceIn(((float) Math.pow(progress - 0.1f, 0.5d)) * 1.4f, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f));
                                        break;
                                    case 1:
                                        Comparable comparable = bottomSheetState2.animatable.upperBound;
                                        comparable.getClass();
                                        float density = reusableGraphicsLayerScope.graphicsDensity.getDensity() * ((((Dp) comparable).value - bottomSheetState2.m1456getValueD9Ej5fM()) + CropImageView.DEFAULT_ASPECT_RATIO);
                                        if (density >= CropImageView.DEFAULT_ASPECT_RATIO) {
                                            f2 = density;
                                        }
                                        reusableGraphicsLayerScope.setTranslationY(f2);
                                        break;
                                    case 2:
                                        float fCoerceIn = UuidKt.coerceIn(bottomSheetState2.getProgress(), CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
                                        float fCoerceIn2 = UuidKt.coerceIn((fCoerceIn - 0.08f) / 0.92f, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
                                        reusableGraphicsLayerScope.setAlpha(UuidKt.coerceIn((fCoerceIn - 0.1f) * 3.2f, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f));
                                        float f3 = (0.05f * fCoerceIn2) + 0.95f;
                                        reusableGraphicsLayerScope.setScaleX(f3);
                                        reusableGraphicsLayerScope.setScaleY(f3);
                                        reusableGraphicsLayerScope.setTranslationY(reusableGraphicsLayerScope.graphicsDensity.getDensity() * 36.0f * (1.0f - fCoerceIn2));
                                        reusableGraphicsLayerScope.m517setTransformOrigin__ExYCQ(ColorKt.TransformOrigin(0.5f, 0.35f));
                                        break;
                                    default:
                                        float fCoerceIn3 = UuidKt.coerceIn(bottomSheetState2.getProgress(), CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
                                        float f4 = 3.2f * fCoerceIn3;
                                        if (f4 > 1.0f) {
                                            f4 = 1.0f;
                                        }
                                        reusableGraphicsLayerScope.setAlpha(1.0f - f4);
                                        float f5 = (fCoerceIn3 * 0.12f) + 1.0f;
                                        reusableGraphicsLayerScope.setScaleX(f5);
                                        reusableGraphicsLayerScope.setScaleY(f5);
                                        reusableGraphicsLayerScope.m517setTransformOrigin__ExYCQ(ColorKt.TransformOrigin(0.5f, CropImageView.DEFAULT_ASPECT_RATIO));
                                        break;
                                }
                                return unit;
                            }
                        };
                        gapComposer.updateRememberedValue(function7);
                        obj5 = function7;
                    }
                    textKt$$ExternalSyntheticLambda4 = textKt$$ExternalSyntheticLambda3;
                    i8 = 131072;
                    z14 = z13;
                    OffsetKt.BoxWithConstraints(ColorKt.graphicsLayer(fillElement, (Function1) obj5), null, composableLambdaImpl2, gapComposer, (i7 >> 9) & 7168, 6);
                    gapComposer.end(z14);
                }
                if (!bottomSheetState.isExpanded() || (function6 != null && bottomSheetState.isDismissed())) {
                    composableLambdaImpl4 = composableLambdaImpl;
                    z15 = true;
                    gapComposer.startReplaceGroup(-1436576895);
                    gapComposer.end(z14);
                } else {
                    gapComposer.startReplaceGroup(-1437532129);
                    boolean z20 = i5 == 4 ? true : z14;
                    Object objRememberedValue7 = gapComposer.rememberedValue();
                    final byte b3 = 3;
                    Object obj8 = objRememberedValue7;
                    if (z20 || objRememberedValue7 == neverEqualPolicy) {
                        Function1 function8 = new Function1() { // from class: com.metrolist.music.ui.component.BottomSheetKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj9) {
                                byte b4 = b3;
                                Unit unit = Unit.INSTANCE;
                                float f2 = CropImageView.DEFAULT_ASPECT_RATIO;
                                BottomSheetState bottomSheetState2 = bottomSheetState;
                                ReusableGraphicsLayerScope reusableGraphicsLayerScope = (ReusableGraphicsLayerScope) obj9;
                                reusableGraphicsLayerScope.getClass();
                                switch (b4) {
                                    case 0:
                                        float progress = bottomSheetState2.getProgress();
                                        if (progress < 0.1f) {
                                            progress = 0.1f;
                                        }
                                        reusableGraphicsLayerScope.setAlpha(UuidKt.coerceIn(((float) Math.pow(progress - 0.1f, 0.5d)) * 1.4f, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f));
                                        break;
                                    case 1:
                                        Comparable comparable = bottomSheetState2.animatable.upperBound;
                                        comparable.getClass();
                                        float density = reusableGraphicsLayerScope.graphicsDensity.getDensity() * ((((Dp) comparable).value - bottomSheetState2.m1456getValueD9Ej5fM()) + CropImageView.DEFAULT_ASPECT_RATIO);
                                        if (density >= CropImageView.DEFAULT_ASPECT_RATIO) {
                                            f2 = density;
                                        }
                                        reusableGraphicsLayerScope.setTranslationY(f2);
                                        break;
                                    case 2:
                                        float fCoerceIn = UuidKt.coerceIn(bottomSheetState2.getProgress(), CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
                                        float fCoerceIn2 = UuidKt.coerceIn((fCoerceIn - 0.08f) / 0.92f, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
                                        reusableGraphicsLayerScope.setAlpha(UuidKt.coerceIn((fCoerceIn - 0.1f) * 3.2f, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f));
                                        float f3 = (0.05f * fCoerceIn2) + 0.95f;
                                        reusableGraphicsLayerScope.setScaleX(f3);
                                        reusableGraphicsLayerScope.setScaleY(f3);
                                        reusableGraphicsLayerScope.setTranslationY(reusableGraphicsLayerScope.graphicsDensity.getDensity() * 36.0f * (1.0f - fCoerceIn2));
                                        reusableGraphicsLayerScope.m517setTransformOrigin__ExYCQ(ColorKt.TransformOrigin(0.5f, 0.35f));
                                        break;
                                    default:
                                        float fCoerceIn3 = UuidKt.coerceIn(bottomSheetState2.getProgress(), CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
                                        float f4 = 3.2f * fCoerceIn3;
                                        if (f4 > 1.0f) {
                                            f4 = 1.0f;
                                        }
                                        reusableGraphicsLayerScope.setAlpha(1.0f - f4);
                                        float f5 = (fCoerceIn3 * 0.12f) + 1.0f;
                                        reusableGraphicsLayerScope.setScaleX(f5);
                                        reusableGraphicsLayerScope.setScaleY(f5);
                                        reusableGraphicsLayerScope.m517setTransformOrigin__ExYCQ(ColorKt.TransformOrigin(0.5f, CropImageView.DEFAULT_ASPECT_RATIO));
                                        break;
                                }
                                return unit;
                            }
                        };
                        gapComposer.updateRememberedValue(function8);
                        obj8 = function8;
                    }
                    Modifier modifierGraphicsLayer4 = ColorKt.graphicsLayer(Modifier.Companion.$$INSTANCE, (Function1) obj8);
                    Object objRememberedValue8 = gapComposer.rememberedValue();
                    Object objM = objRememberedValue8;
                    if (objRememberedValue8 == neverEqualPolicy) {
                        objM = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                    }
                    MutableInteractionSourceImpl mutableInteractionSourceImpl = (MutableInteractionSourceImpl) objM;
                    boolean z21 = (i5 == 4 ? true : z14) | (i6 == i8 ? true : z14);
                    Object objRememberedValue9 = gapComposer.rememberedValue();
                    Object obj9 = objRememberedValue9;
                    if (z21 || objRememberedValue9 == neverEqualPolicy) {
                        PlayerKt$$ExternalSyntheticLambda0 playerKt$$ExternalSyntheticLambda0 = new PlayerKt$$ExternalSyntheticLambda0(bottomSheetState, (byte) 1);
                        gapComposer.updateRememberedValue(playerKt$$ExternalSyntheticLambda0);
                        obj9 = playerKt$$ExternalSyntheticLambda0;
                    }
                    Modifier modifierM145height3ABfNKs = SizeKt.m145height3ABfNKs(SizeKt.fillMaxWidth(ImageKt.focusable(ImageKt.m45clickableO2vRcR0$default(modifierGraphicsLayer4, mutableInteractionSourceImpl, null, false, null, (Function0) obj9, 28), z14, null), 1.0f), bottomSheetState.collapsedBound);
                    int i13 = (i7 >> 3) & 7168;
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, z14);
                    int iHashCode3 = Long.hashCode(gapComposer.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer, modifierM145height3ABfNKs);
                    gapComposer.startReusableNode();
                    if (gapComposer.inserting) {
                        gapComposer.createNode(textKt$$ExternalSyntheticLambda4);
                    } else {
                        gapComposer.useNode();
                    }
                    Stack.m390setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy3, updater$$ExternalSyntheticLambda0);
                    Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda1);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode3, gapComposer, updater$$ExternalSyntheticLambda2, gapComposer);
                    Stack.m390setimpl(gapComposer, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda3);
                    ComposableLambdaImpl composableLambdaImpl6 = composableLambdaImpl;
                    composableLambdaImpl6.invoke(obj7, gapComposer, Integer.valueOf(((i13 >> 6) & 112) | 6));
                    z15 = true;
                    gapComposer.end(true);
                    gapComposer.end(z14);
                    composableLambdaImpl4 = composableLambdaImpl6;
                }
                gapComposer.end(z15);
                z3 = z15;
                function1 = function6;
                composableLambdaImpl3 = composableLambdaImpl4;
            } else {
                gapComposer.skipToGroupEnd();
                function1 = function0;
                z3 = z;
                composableLambdaImpl3 = composableLambdaImpl5;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new BottomSheetKt$$ExternalSyntheticLambda6(bottomSheetState, modifier, function3, function1, composableLambdaImpl3, z3, composableLambdaImpl2, i, i2);
            }
        }
        i3 |= 3072;
        if ((i & 24576) == 0) {
            if (gapComposer.changedInstance(composableLambdaImpl5)) {
                i10 = 16384;
            } else {
                i10 = 8192;
            }
            i3 |= i10;
        }
        i4 = i3 | 196608;
        if ((1572864 & i) != 0) {
            if (gapComposer.changedInstance(composableLambdaImpl2)) {
                i9 = ByteChannelKt.CHANNEL_MAX_SIZE;
            } else {
                i9 = 524288;
            }
            i4 |= i9;
        }
        b = 0;
        if ((599187 & i4) != 599186) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (gapComposer.shouldExecute(i4 & 1, z2)) {
            if (i11 != 0) {
                function2 = null;
            } else {
                function2 = function0;
            }
            if (UiStyleKt.isGlassStyle(gapComposer)) {
                f = 28.0f;
            } else {
                f = 16.0f;
            }
            i5 = i4 & 14;
            if (i5 == 4) {
                z4 = true;
            } else {
                z4 = false;
            }
            Object objRememberedValue10 = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy2 = Composer.Companion.Empty;
            obj = objRememberedValue10;
            if (z4) {
                Function1 function9 = new Function1() { // from class: com.metrolist.music.ui.component.BottomSheetKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj10) {
                        byte b4 = b;
                        Unit unit = Unit.INSTANCE;
                        float f2 = CropImageView.DEFAULT_ASPECT_RATIO;
                        BottomSheetState bottomSheetState2 = bottomSheetState;
                        ReusableGraphicsLayerScope reusableGraphicsLayerScope = (ReusableGraphicsLayerScope) obj10;
                        reusableGraphicsLayerScope.getClass();
                        switch (b4) {
                            case 0:
                                float progress = bottomSheetState2.getProgress();
                                if (progress < 0.1f) {
                                    progress = 0.1f;
                                }
                                reusableGraphicsLayerScope.setAlpha(UuidKt.coerceIn(((float) Math.pow(progress - 0.1f, 0.5d)) * 1.4f, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f));
                                break;
                            case 1:
                                Comparable comparable = bottomSheetState2.animatable.upperBound;
                                comparable.getClass();
                                float density = reusableGraphicsLayerScope.graphicsDensity.getDensity() * ((((Dp) comparable).value - bottomSheetState2.m1456getValueD9Ej5fM()) + CropImageView.DEFAULT_ASPECT_RATIO);
                                if (density >= CropImageView.DEFAULT_ASPECT_RATIO) {
                                    f2 = density;
                                }
                                reusableGraphicsLayerScope.setTranslationY(f2);
                                break;
                            case 2:
                                float fCoerceIn = UuidKt.coerceIn(bottomSheetState2.getProgress(), CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
                                float fCoerceIn2 = UuidKt.coerceIn((fCoerceIn - 0.08f) / 0.92f, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
                                reusableGraphicsLayerScope.setAlpha(UuidKt.coerceIn((fCoerceIn - 0.1f) * 3.2f, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f));
                                float f3 = (0.05f * fCoerceIn2) + 0.95f;
                                reusableGraphicsLayerScope.setScaleX(f3);
                                reusableGraphicsLayerScope.setScaleY(f3);
                                reusableGraphicsLayerScope.setTranslationY(reusableGraphicsLayerScope.graphicsDensity.getDensity() * 36.0f * (1.0f - fCoerceIn2));
                                reusableGraphicsLayerScope.m517setTransformOrigin__ExYCQ(ColorKt.TransformOrigin(0.5f, 0.35f));
                                break;
                            default:
                                float fCoerceIn3 = UuidKt.coerceIn(bottomSheetState2.getProgress(), CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
                                float f4 = 3.2f * fCoerceIn3;
                                if (f4 > 1.0f) {
                                    f4 = 1.0f;
                                }
                                reusableGraphicsLayerScope.setAlpha(1.0f - f4);
                                float f5 = (fCoerceIn3 * 0.12f) + 1.0f;
                                reusableGraphicsLayerScope.setScaleX(f5);
                                reusableGraphicsLayerScope.setScaleY(f5);
                                reusableGraphicsLayerScope.m517setTransformOrigin__ExYCQ(ColorKt.TransformOrigin(0.5f, CropImageView.DEFAULT_ASPECT_RATIO));
                                break;
                        }
                        return unit;
                    }
                };
                gapComposer.updateRememberedValue(function9);
                obj = function9;
            } else {
                Function1 function10 = new Function1() { // from class: com.metrolist.music.ui.component.BottomSheetKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj10) {
                        byte b4 = b;
                        Unit unit = Unit.INSTANCE;
                        float f2 = CropImageView.DEFAULT_ASPECT_RATIO;
                        BottomSheetState bottomSheetState2 = bottomSheetState;
                        ReusableGraphicsLayerScope reusableGraphicsLayerScope = (ReusableGraphicsLayerScope) obj10;
                        reusableGraphicsLayerScope.getClass();
                        switch (b4) {
                            case 0:
                                float progress = bottomSheetState2.getProgress();
                                if (progress < 0.1f) {
                                    progress = 0.1f;
                                }
                                reusableGraphicsLayerScope.setAlpha(UuidKt.coerceIn(((float) Math.pow(progress - 0.1f, 0.5d)) * 1.4f, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f));
                                break;
                            case 1:
                                Comparable comparable = bottomSheetState2.animatable.upperBound;
                                comparable.getClass();
                                float density = reusableGraphicsLayerScope.graphicsDensity.getDensity() * ((((Dp) comparable).value - bottomSheetState2.m1456getValueD9Ej5fM()) + CropImageView.DEFAULT_ASPECT_RATIO);
                                if (density >= CropImageView.DEFAULT_ASPECT_RATIO) {
                                    f2 = density;
                                }
                                reusableGraphicsLayerScope.setTranslationY(f2);
                                break;
                            case 2:
                                float fCoerceIn = UuidKt.coerceIn(bottomSheetState2.getProgress(), CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
                                float fCoerceIn2 = UuidKt.coerceIn((fCoerceIn - 0.08f) / 0.92f, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
                                reusableGraphicsLayerScope.setAlpha(UuidKt.coerceIn((fCoerceIn - 0.1f) * 3.2f, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f));
                                float f3 = (0.05f * fCoerceIn2) + 0.95f;
                                reusableGraphicsLayerScope.setScaleX(f3);
                                reusableGraphicsLayerScope.setScaleY(f3);
                                reusableGraphicsLayerScope.setTranslationY(reusableGraphicsLayerScope.graphicsDensity.getDensity() * 36.0f * (1.0f - fCoerceIn2));
                                reusableGraphicsLayerScope.m517setTransformOrigin__ExYCQ(ColorKt.TransformOrigin(0.5f, 0.35f));
                                break;
                            default:
                                float fCoerceIn3 = UuidKt.coerceIn(bottomSheetState2.getProgress(), CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
                                float f4 = 3.2f * fCoerceIn3;
                                if (f4 > 1.0f) {
                                    f4 = 1.0f;
                                }
                                reusableGraphicsLayerScope.setAlpha(1.0f - f4);
                                float f5 = (fCoerceIn3 * 0.12f) + 1.0f;
                                reusableGraphicsLayerScope.setScaleX(f5);
                                reusableGraphicsLayerScope.setScaleY(f5);
                                reusableGraphicsLayerScope.m517setTransformOrigin__ExYCQ(ColorKt.TransformOrigin(0.5f, CropImageView.DEFAULT_ASPECT_RATIO));
                                break;
                        }
                        return unit;
                    }
                };
                gapComposer.updateRememberedValue(function10);
                obj = function10;
            }
            Modifier modifierGraphicsLayer5 = ColorKt.graphicsLayer(modifier, (Function1) obj);
            fillElement = SizeKt.FillWholeMaxSize;
            Modifier modifierThen4 = modifierGraphicsLayer5.then(fillElement);
            int i14 = (i4 << 3) & 7168;
            BiasAlignment biasAlignment2 = Alignment.Companion.TopStart;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment2, false);
            int iHashCode4 = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope4 = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier4 = ZIndexModifierKt.materializeModifier(gapComposer, modifierThen4);
            ComposeUiNode.Companion.getClass();
            gapComposer.startReusableNode();
            z5 = gapComposer.inserting;
            textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
            if (z5) {
                gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer.useNode();
            }
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda4 = ComposeUiNode.Companion.SetMeasurePolicy;
            Stack.m390setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy4, updater$$ExternalSyntheticLambda4);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda5 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope4, updater$$ExternalSyntheticLambda5);
            Integer numValueOf2 = Integer.valueOf(iHashCode4);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda6 = ComposeUiNode.Companion.SetCompositeKeyHash;
            Stack.m390setimpl(gapComposer, numValueOf2, updater$$ExternalSyntheticLambda6);
            Stack.m389reconcileimpl(gapComposer);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda7 = ComposeUiNode.Companion.SetModifier;
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier4, updater$$ExternalSyntheticLambda7);
            Object objValueOf2 = Integer.valueOf(((i14 >> 6) & 112) | 6);
            Object obj10 = BoxScopeInstance.INSTANCE;
            function3.invoke(obj10, gapComposer, objValueOf2);
            gapComposer.end(true);
            Modifier modifierThen5 = modifier.then(fillElement);
            if (i5 == 4) {
                z6 = true;
            } else {
                z6 = false;
            }
            Object objRememberedValue11 = gapComposer.rememberedValue();
            if (z6) {
                z7 = true;
                final byte z110 = true ? 1 : 0;
                Function1 function11 = new Function1() { // from class: com.metrolist.music.ui.component.BottomSheetKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj11) {
                        byte b4 = z110;
                        Unit unit = Unit.INSTANCE;
                        float f2 = CropImageView.DEFAULT_ASPECT_RATIO;
                        BottomSheetState bottomSheetState2 = bottomSheetState;
                        ReusableGraphicsLayerScope reusableGraphicsLayerScope = (ReusableGraphicsLayerScope) obj11;
                        reusableGraphicsLayerScope.getClass();
                        switch (b4) {
                            case 0:
                                float progress = bottomSheetState2.getProgress();
                                if (progress < 0.1f) {
                                    progress = 0.1f;
                                }
                                reusableGraphicsLayerScope.setAlpha(UuidKt.coerceIn(((float) Math.pow(progress - 0.1f, 0.5d)) * 1.4f, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f));
                                break;
                            case 1:
                                Comparable comparable = bottomSheetState2.animatable.upperBound;
                                comparable.getClass();
                                float density = reusableGraphicsLayerScope.graphicsDensity.getDensity() * ((((Dp) comparable).value - bottomSheetState2.m1456getValueD9Ej5fM()) + CropImageView.DEFAULT_ASPECT_RATIO);
                                if (density >= CropImageView.DEFAULT_ASPECT_RATIO) {
                                    f2 = density;
                                }
                                reusableGraphicsLayerScope.setTranslationY(f2);
                                break;
                            case 2:
                                float fCoerceIn = UuidKt.coerceIn(bottomSheetState2.getProgress(), CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
                                float fCoerceIn2 = UuidKt.coerceIn((fCoerceIn - 0.08f) / 0.92f, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
                                reusableGraphicsLayerScope.setAlpha(UuidKt.coerceIn((fCoerceIn - 0.1f) * 3.2f, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f));
                                float f3 = (0.05f * fCoerceIn2) + 0.95f;
                                reusableGraphicsLayerScope.setScaleX(f3);
                                reusableGraphicsLayerScope.setScaleY(f3);
                                reusableGraphicsLayerScope.setTranslationY(reusableGraphicsLayerScope.graphicsDensity.getDensity() * 36.0f * (1.0f - fCoerceIn2));
                                reusableGraphicsLayerScope.m517setTransformOrigin__ExYCQ(ColorKt.TransformOrigin(0.5f, 0.35f));
                                break;
                            default:
                                float fCoerceIn3 = UuidKt.coerceIn(bottomSheetState2.getProgress(), CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
                                float f4 = 3.2f * fCoerceIn3;
                                if (f4 > 1.0f) {
                                    f4 = 1.0f;
                                }
                                reusableGraphicsLayerScope.setAlpha(1.0f - f4);
                                float f5 = (fCoerceIn3 * 0.12f) + 1.0f;
                                reusableGraphicsLayerScope.setScaleX(f5);
                                reusableGraphicsLayerScope.setScaleY(f5);
                                reusableGraphicsLayerScope.m517setTransformOrigin__ExYCQ(ColorKt.TransformOrigin(0.5f, CropImageView.DEFAULT_ASPECT_RATIO));
                                break;
                        }
                        return unit;
                    }
                };
                gapComposer.updateRememberedValue(function11);
                obj2 = function11;
            } else {
                z7 = true;
                final byte z111 = true ? 1 : 0;
                Function1 function12 = new Function1() { // from class: com.metrolist.music.ui.component.BottomSheetKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj11) {
                        byte b4 = z111;
                        Unit unit = Unit.INSTANCE;
                        float f2 = CropImageView.DEFAULT_ASPECT_RATIO;
                        BottomSheetState bottomSheetState2 = bottomSheetState;
                        ReusableGraphicsLayerScope reusableGraphicsLayerScope = (ReusableGraphicsLayerScope) obj11;
                        reusableGraphicsLayerScope.getClass();
                        switch (b4) {
                            case 0:
                                float progress = bottomSheetState2.getProgress();
                                if (progress < 0.1f) {
                                    progress = 0.1f;
                                }
                                reusableGraphicsLayerScope.setAlpha(UuidKt.coerceIn(((float) Math.pow(progress - 0.1f, 0.5d)) * 1.4f, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f));
                                break;
                            case 1:
                                Comparable comparable = bottomSheetState2.animatable.upperBound;
                                comparable.getClass();
                                float density = reusableGraphicsLayerScope.graphicsDensity.getDensity() * ((((Dp) comparable).value - bottomSheetState2.m1456getValueD9Ej5fM()) + CropImageView.DEFAULT_ASPECT_RATIO);
                                if (density >= CropImageView.DEFAULT_ASPECT_RATIO) {
                                    f2 = density;
                                }
                                reusableGraphicsLayerScope.setTranslationY(f2);
                                break;
                            case 2:
                                float fCoerceIn = UuidKt.coerceIn(bottomSheetState2.getProgress(), CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
                                float fCoerceIn2 = UuidKt.coerceIn((fCoerceIn - 0.08f) / 0.92f, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
                                reusableGraphicsLayerScope.setAlpha(UuidKt.coerceIn((fCoerceIn - 0.1f) * 3.2f, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f));
                                float f3 = (0.05f * fCoerceIn2) + 0.95f;
                                reusableGraphicsLayerScope.setScaleX(f3);
                                reusableGraphicsLayerScope.setScaleY(f3);
                                reusableGraphicsLayerScope.setTranslationY(reusableGraphicsLayerScope.graphicsDensity.getDensity() * 36.0f * (1.0f - fCoerceIn2));
                                reusableGraphicsLayerScope.m517setTransformOrigin__ExYCQ(ColorKt.TransformOrigin(0.5f, 0.35f));
                                break;
                            default:
                                float fCoerceIn3 = UuidKt.coerceIn(bottomSheetState2.getProgress(), CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
                                float f4 = 3.2f * fCoerceIn3;
                                if (f4 > 1.0f) {
                                    f4 = 1.0f;
                                }
                                reusableGraphicsLayerScope.setAlpha(1.0f - f4);
                                float f5 = (fCoerceIn3 * 0.12f) + 1.0f;
                                reusableGraphicsLayerScope.setScaleX(f5);
                                reusableGraphicsLayerScope.setScaleY(f5);
                                reusableGraphicsLayerScope.m517setTransformOrigin__ExYCQ(ColorKt.TransformOrigin(0.5f, CropImageView.DEFAULT_ASPECT_RATIO));
                                break;
                        }
                        return unit;
                    }
                };
                gapComposer.updateRememberedValue(function12);
                obj2 = function12;
            }
            Modifier modifierGraphicsLayer6 = ColorKt.graphicsLayer(modifierThen5, (Function1) obj2);
            Boolean boolValueOf2 = Boolean.valueOf(z7);
            i6 = 458752 & i4;
            if (i6 == 131072) {
                z8 = true;
            } else {
                z8 = false;
            }
            if (i5 == 4) {
                z9 = true;
            } else {
                z9 = false;
            }
            boolean z112 = z8 | z9;
            i7 = i4;
            if ((i4 & 7168) == 2048) {
                z10 = true;
            } else {
                z10 = false;
            }
            z11 = z112 | z10;
            Object objRememberedValue12 = gapComposer.rememberedValue();
            obj3 = objRememberedValue12;
            if (z11) {
                BottomSheetKt$BottomSheet$3$1 bottomSheetKt$BottomSheet$3$2 = new BottomSheetKt$BottomSheet$3$1(bottomSheetState, function2, (byte) 0);
                gapComposer.updateRememberedValue(bottomSheetKt$BottomSheet$3$2);
                obj3 = bottomSheetKt$BottomSheet$3$2;
            } else {
                BottomSheetKt$BottomSheet$3$1 bottomSheetKt$BottomSheet$3$3 = new BottomSheetKt$BottomSheet$3$1(bottomSheetState, function2, (byte) 0);
                gapComposer.updateRememberedValue(bottomSheetKt$BottomSheet$3$3);
                obj3 = bottomSheetKt$BottomSheet$3$3;
            }
            PointerEvent pointerEvent2 = SuspendingPointerInputFilterKt.EmptyPointerEvent;
            Function0 function13 = function2;
            Modifier modifierThen6 = modifierGraphicsLayer6.then(new SuspendPointerInputElement(bottomSheetState, boolValueOf2, (PointerInputEventHandler) obj3, 4));
            if (i5 == 4) {
                z12 = true;
            } else {
                z12 = false;
            }
            zChanged = z12 | gapComposer.changed(f);
            Object objRememberedValue13 = gapComposer.rememberedValue();
            obj4 = objRememberedValue13;
            if (zChanged) {
                BottomSheetKt$$ExternalSyntheticLambda13 bottomSheetKt$$ExternalSyntheticLambda14 = new BottomSheetKt$$ExternalSyntheticLambda13(bottomSheetState, f, (byte) 4);
                gapComposer.updateRememberedValue(bottomSheetKt$$ExternalSyntheticLambda14);
                obj4 = bottomSheetKt$$ExternalSyntheticLambda14;
            } else {
                BottomSheetKt$$ExternalSyntheticLambda13 bottomSheetKt$$ExternalSyntheticLambda15 = new BottomSheetKt$$ExternalSyntheticLambda13(bottomSheetState, f, (byte) 4);
                gapComposer.updateRememberedValue(bottomSheetKt$$ExternalSyntheticLambda15);
                obj4 = bottomSheetKt$$ExternalSyntheticLambda15;
            }
            Modifier modifierGraphicsLayer7 = ColorKt.graphicsLayer(modifierThen6, (Function1) obj4);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy5 = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment2, false);
            int iHashCode5 = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope5 = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier5 = ZIndexModifierKt.materializeModifier(gapComposer, modifierGraphicsLayer7);
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer.useNode();
            }
            Stack.m390setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy5, updater$$ExternalSyntheticLambda4);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope5, updater$$ExternalSyntheticLambda5);
            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode5, gapComposer, updater$$ExternalSyntheticLambda6, gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier5, updater$$ExternalSyntheticLambda7);
            if (bottomSheetState.isCollapsed()) {
                z13 = false;
                gapComposer.startReplaceGroup(-1438508319);
                gapComposer.end(false);
            } else {
                z13 = false;
                gapComposer.startReplaceGroup(-1438508319);
                gapComposer.end(false);
            }
            if (bottomSheetState.isCollapsed()) {
                gapComposer.startReplaceGroup(-1438425456);
                if (i5 == 4) {
                    z16 = true;
                } else {
                    z16 = z13;
                }
                Object objRememberedValue14 = gapComposer.rememberedValue();
                obj5 = objRememberedValue14;
                if (z16) {
                    final byte b4 = 2;
                    Function1 function14 = new Function1() { // from class: com.metrolist.music.ui.component.BottomSheetKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj11) {
                            byte b5 = b4;
                            Unit unit = Unit.INSTANCE;
                            float f2 = CropImageView.DEFAULT_ASPECT_RATIO;
                            BottomSheetState bottomSheetState2 = bottomSheetState;
                            ReusableGraphicsLayerScope reusableGraphicsLayerScope = (ReusableGraphicsLayerScope) obj11;
                            reusableGraphicsLayerScope.getClass();
                            switch (b5) {
                                case 0:
                                    float progress = bottomSheetState2.getProgress();
                                    if (progress < 0.1f) {
                                        progress = 0.1f;
                                    }
                                    reusableGraphicsLayerScope.setAlpha(UuidKt.coerceIn(((float) Math.pow(progress - 0.1f, 0.5d)) * 1.4f, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f));
                                    break;
                                case 1:
                                    Comparable comparable = bottomSheetState2.animatable.upperBound;
                                    comparable.getClass();
                                    float density = reusableGraphicsLayerScope.graphicsDensity.getDensity() * ((((Dp) comparable).value - bottomSheetState2.m1456getValueD9Ej5fM()) + CropImageView.DEFAULT_ASPECT_RATIO);
                                    if (density >= CropImageView.DEFAULT_ASPECT_RATIO) {
                                        f2 = density;
                                    }
                                    reusableGraphicsLayerScope.setTranslationY(f2);
                                    break;
                                case 2:
                                    float fCoerceIn = UuidKt.coerceIn(bottomSheetState2.getProgress(), CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
                                    float fCoerceIn2 = UuidKt.coerceIn((fCoerceIn - 0.08f) / 0.92f, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
                                    reusableGraphicsLayerScope.setAlpha(UuidKt.coerceIn((fCoerceIn - 0.1f) * 3.2f, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f));
                                    float f3 = (0.05f * fCoerceIn2) + 0.95f;
                                    reusableGraphicsLayerScope.setScaleX(f3);
                                    reusableGraphicsLayerScope.setScaleY(f3);
                                    reusableGraphicsLayerScope.setTranslationY(reusableGraphicsLayerScope.graphicsDensity.getDensity() * 36.0f * (1.0f - fCoerceIn2));
                                    reusableGraphicsLayerScope.m517setTransformOrigin__ExYCQ(ColorKt.TransformOrigin(0.5f, 0.35f));
                                    break;
                                default:
                                    float fCoerceIn3 = UuidKt.coerceIn(bottomSheetState2.getProgress(), CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
                                    float f4 = 3.2f * fCoerceIn3;
                                    if (f4 > 1.0f) {
                                        f4 = 1.0f;
                                    }
                                    reusableGraphicsLayerScope.setAlpha(1.0f - f4);
                                    float f5 = (fCoerceIn3 * 0.12f) + 1.0f;
                                    reusableGraphicsLayerScope.setScaleX(f5);
                                    reusableGraphicsLayerScope.setScaleY(f5);
                                    reusableGraphicsLayerScope.m517setTransformOrigin__ExYCQ(ColorKt.TransformOrigin(0.5f, CropImageView.DEFAULT_ASPECT_RATIO));
                                    break;
                            }
                            return unit;
                        }
                    };
                    gapComposer.updateRememberedValue(function14);
                    obj5 = function14;
                } else {
                    final byte b5 = 2;
                    Function1 function15 = new Function1() { // from class: com.metrolist.music.ui.component.BottomSheetKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj11) {
                            byte b6 = b5;
                            Unit unit = Unit.INSTANCE;
                            float f2 = CropImageView.DEFAULT_ASPECT_RATIO;
                            BottomSheetState bottomSheetState2 = bottomSheetState;
                            ReusableGraphicsLayerScope reusableGraphicsLayerScope = (ReusableGraphicsLayerScope) obj11;
                            reusableGraphicsLayerScope.getClass();
                            switch (b6) {
                                case 0:
                                    float progress = bottomSheetState2.getProgress();
                                    if (progress < 0.1f) {
                                        progress = 0.1f;
                                    }
                                    reusableGraphicsLayerScope.setAlpha(UuidKt.coerceIn(((float) Math.pow(progress - 0.1f, 0.5d)) * 1.4f, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f));
                                    break;
                                case 1:
                                    Comparable comparable = bottomSheetState2.animatable.upperBound;
                                    comparable.getClass();
                                    float density = reusableGraphicsLayerScope.graphicsDensity.getDensity() * ((((Dp) comparable).value - bottomSheetState2.m1456getValueD9Ej5fM()) + CropImageView.DEFAULT_ASPECT_RATIO);
                                    if (density >= CropImageView.DEFAULT_ASPECT_RATIO) {
                                        f2 = density;
                                    }
                                    reusableGraphicsLayerScope.setTranslationY(f2);
                                    break;
                                case 2:
                                    float fCoerceIn = UuidKt.coerceIn(bottomSheetState2.getProgress(), CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
                                    float fCoerceIn2 = UuidKt.coerceIn((fCoerceIn - 0.08f) / 0.92f, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
                                    reusableGraphicsLayerScope.setAlpha(UuidKt.coerceIn((fCoerceIn - 0.1f) * 3.2f, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f));
                                    float f3 = (0.05f * fCoerceIn2) + 0.95f;
                                    reusableGraphicsLayerScope.setScaleX(f3);
                                    reusableGraphicsLayerScope.setScaleY(f3);
                                    reusableGraphicsLayerScope.setTranslationY(reusableGraphicsLayerScope.graphicsDensity.getDensity() * 36.0f * (1.0f - fCoerceIn2));
                                    reusableGraphicsLayerScope.m517setTransformOrigin__ExYCQ(ColorKt.TransformOrigin(0.5f, 0.35f));
                                    break;
                                default:
                                    float fCoerceIn3 = UuidKt.coerceIn(bottomSheetState2.getProgress(), CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
                                    float f4 = 3.2f * fCoerceIn3;
                                    if (f4 > 1.0f) {
                                        f4 = 1.0f;
                                    }
                                    reusableGraphicsLayerScope.setAlpha(1.0f - f4);
                                    float f5 = (fCoerceIn3 * 0.12f) + 1.0f;
                                    reusableGraphicsLayerScope.setScaleX(f5);
                                    reusableGraphicsLayerScope.setScaleY(f5);
                                    reusableGraphicsLayerScope.m517setTransformOrigin__ExYCQ(ColorKt.TransformOrigin(0.5f, CropImageView.DEFAULT_ASPECT_RATIO));
                                    break;
                            }
                            return unit;
                        }
                    };
                    gapComposer.updateRememberedValue(function15);
                    obj5 = function15;
                }
                textKt$$ExternalSyntheticLambda4 = textKt$$ExternalSyntheticLambda3;
                i8 = 131072;
                z14 = z13;
                OffsetKt.BoxWithConstraints(ColorKt.graphicsLayer(fillElement, (Function1) obj5), null, composableLambdaImpl2, gapComposer, (i7 >> 9) & 7168, 6);
                gapComposer.end(z14);
            } else {
                textKt$$ExternalSyntheticLambda4 = textKt$$ExternalSyntheticLambda3;
                z14 = z13;
                i8 = 131072;
                gapComposer.startReplaceGroup(-1437640319);
                gapComposer.end(z14);
            }
            if (bottomSheetState.isExpanded()) {
                composableLambdaImpl4 = composableLambdaImpl;
                z15 = true;
                gapComposer.startReplaceGroup(-1436576895);
                gapComposer.end(z14);
            } else {
                composableLambdaImpl4 = composableLambdaImpl;
                z15 = true;
                gapComposer.startReplaceGroup(-1436576895);
                gapComposer.end(z14);
            }
            gapComposer.end(z15);
            z3 = z15;
            function1 = function13;
            composableLambdaImpl3 = composableLambdaImpl4;
        } else {
            gapComposer.skipToGroupEnd();
            function1 = function0;
            z3 = z;
            composableLambdaImpl3 = composableLambdaImpl5;
        }
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new BottomSheetKt$$ExternalSyntheticLambda6(bottomSheetState, modifier, function3, function1, composableLambdaImpl3, z3, composableLambdaImpl2, i, i2);
        }
    }

    /* JADX INFO: renamed from: CastButton-iJQMabo, reason: not valid java name */
    public static final void m1460CastButtoniJQMabo(Modifier modifier, long j, Composer composer, int i, int i2) {
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-194457798);
        int i3 = i & 1;
        if (gapComposer.shouldExecute(i3, i3 != 0)) {
            gapComposer.startDefaults();
            if (i3 != 0 && !gapComposer.getDefaultsInvalid()) {
                gapComposer.skipToGroupEnd();
            } else if ((i2 & 1) != 0) {
                modifier = Modifier.Companion.$$INSTANCE;
            }
            gapComposer.endDefaults();
        } else {
            gapComposer.skipToGroupEnd();
        }
        Modifier modifier2 = modifier;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new TimePickerKt$$ExternalSyntheticLambda41(modifier2, j, i, i2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:27:0x005b  */
    /* JADX WARN: Code duplicated, block: B:28:0x005d  */
    /* JADX WARN: Code duplicated, block: B:31:0x0066  */
    /* JADX WARN: Code duplicated, block: B:37:0x0080 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:38:0x0082  */
    /* JADX WARN: Code duplicated, block: B:42:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:43:0x00de  */
    /* JADX WARN: Code duplicated, block: B:47:0x0115  */
    /* JADX WARN: Code duplicated, block: B:49:0x012e  */
    /* JADX WARN: Code duplicated, block: B:50:0x0130  */
    /* JADX WARN: Code duplicated, block: B:55:0x0141  */
    /* JADX WARN: Code duplicated, block: B:58:0x016a  */
    /* JADX WARN: Code duplicated, block: B:61:0x0176  */
    /* JADX WARN: Code duplicated, block: B:66:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: ChipsRow-yrwZFoE, reason: not valid java name */
    public static final void m1461ChipsRowyrwZFoE(final List list, final Object obj, final Function1 function1, Modifier modifier, long j, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        byte b;
        boolean z;
        final Modifier modifier3;
        final long j2;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        int i4;
        Modifier.Companion companion;
        long j3;
        int i5;
        Iterator it;
        Object obj2;
        boolean z2;
        boolean zChangedInstance;
        Object objRememberedValue;
        function1.getClass();
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-989326304);
        int i6 = (gapComposer.changed(list) ? 4 : 2) | i | (gapComposer.changed(obj) ? 32 : 16) | (gapComposer.changedInstance(function1) ? 256 : 128);
        int i7 = i2 & 8;
        if (i7 == 0) {
            if ((i & 3072) == 0) {
                modifier2 = modifier;
                i6 |= gapComposer.changed(modifier2) ? 2048 : 1024;
            }
            i3 = i6 | 8192;
            b = 0;
            if ((i3 & 9363) != 9362) {
                z = true;
            } else {
                z = false;
            }
            if (gapComposer.shouldExecute(i3 & 1, z)) {
                gapComposer.startDefaults();
                i4 = i & 1;
                companion = Modifier.Companion.$$INSTANCE;
                if (i4 != 0 || gapComposer.getDefaultsInvalid()) {
                    if (i7 != 0) {
                        modifier2 = companion;
                    }
                    j3 = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.surfaceContainer;
                    i5 = i3 & (-57345);
                } else {
                    gapComposer.skipToGroupEnd();
                    i5 = i3 & (-57345);
                    j3 = j;
                }
                gapComposer.endDefaults();
                Modifier modifierScroll$default = ImageKt.scroll$default(SizeKt.fillMaxWidth(modifier2, 1.0f), ImageKt.rememberScrollState(gapComposer), false);
                WeakHashMap weakHashMap = WindowInsetsHolder.viewMap;
                Modifier modifierWindowInsetsPadding = OffsetKt.windowInsetsPadding(modifierScroll$default, new LimitInsets(OffsetKt.current(gapComposer).systemBars, 15));
                RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(OffsetKt.Start, Alignment.Companion.Top, gapComposer, 0);
                Modifier modifier4 = modifier2;
                int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierWindowInsetsPadding);
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
                OffsetKt.Spacer(gapComposer, SizeKt.m155width3ABfNKs(companion, 12.0f));
                gapComposer.startReplaceGroup(-502633);
                it = list.iterator();
                while (it.hasNext()) {
                    Pair pair = (Pair) it.next();
                    obj2 = pair.first;
                    String str = (String) pair.second;
                    Modifier.Companion companion2 = companion;
                    long j4 = j3;
                    boolean zAreEqual = Intrinsics.areEqual(obj, obj2);
                    if ((i5 & 896) == 256) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    zChangedInstance = z2 | gapComposer.changedInstance(obj2);
                    objRememberedValue = gapComposer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == Composer.Companion.Empty) {
                        objRememberedValue = new ChipsRowKt$$ExternalSyntheticLambda2(function1, obj2, b);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    m1457AnimatedFilterChipFNF3uiM(0, j4, gapComposer, str, (Function0) objRememberedValue, zAreEqual);
                    OffsetKt.Spacer(gapComposer, SizeKt.m155width3ABfNKs(companion2, 8.0f));
                    j3 = j4;
                    companion = companion2;
                }
                gapComposer.end(false);
                gapComposer.end(true);
                modifier3 = modifier4;
                j2 = j3;
            } else {
                gapComposer.skipToGroupEnd();
                modifier3 = modifier2;
                j2 = j;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.metrolist.music.ui.component.ChipsRowKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj3, Object obj4) {
                        ((Integer) obj4).getClass();
                        DialogKt.m1461ChipsRowyrwZFoE(list, obj, function1, modifier3, j2, (Composer) obj3, Stack.updateChangedFlags(i | 1), i2);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i6 |= 3072;
        modifier2 = modifier;
        i3 = i6 | 8192;
        b = 0;
        if ((i3 & 9363) != 9362) {
            z = true;
        } else {
            z = false;
        }
        if (gapComposer.shouldExecute(i3 & 1, z)) {
            gapComposer.startDefaults();
            i4 = i & 1;
            companion = Modifier.Companion.$$INSTANCE;
            if (i4 != 0) {
                if (i7 != 0) {
                    modifier2 = companion;
                }
                j3 = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.surfaceContainer;
                i5 = i3 & (-57345);
            } else {
                if (i7 != 0) {
                    modifier2 = companion;
                }
                j3 = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.surfaceContainer;
                i5 = i3 & (-57345);
            }
            gapComposer.endDefaults();
            Modifier modifierScroll$default2 = ImageKt.scroll$default(SizeKt.fillMaxWidth(modifier2, 1.0f), ImageKt.rememberScrollState(gapComposer), false);
            WeakHashMap weakHashMap2 = WindowInsetsHolder.viewMap;
            Modifier modifierWindowInsetsPadding2 = OffsetKt.windowInsetsPadding(modifierScroll$default2, new LimitInsets(OffsetKt.current(gapComposer).systemBars, 15));
            RowMeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(OffsetKt.Start, Alignment.Companion.Top, gapComposer, 0);
            Modifier modifier5 = modifier2;
            int iHashCode2 = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer, modifierWindowInsetsPadding2);
            ComposeUiNode.Companion.getClass();
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(LayoutNode.Constructor);
            } else {
                gapComposer.useNode();
            }
            Stack.m390setimpl(gapComposer, rowMeasurePolicy2, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode2), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m389reconcileimpl(gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier2, ComposeUiNode.Companion.SetModifier);
            OffsetKt.Spacer(gapComposer, SizeKt.m155width3ABfNKs(companion, 12.0f));
            gapComposer.startReplaceGroup(-502633);
            it = list.iterator();
            while (it.hasNext()) {
                Pair pair2 = (Pair) it.next();
                obj2 = pair2.first;
                String str2 = (String) pair2.second;
                Modifier.Companion companion3 = companion;
                long j5 = j3;
                boolean zAreEqual2 = Intrinsics.areEqual(obj, obj2);
                if ((i5 & 896) == 256) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                zChangedInstance = z2 | gapComposer.changedInstance(obj2);
                objRememberedValue = gapComposer.rememberedValue();
                if (zChangedInstance) {
                    objRememberedValue = new ChipsRowKt$$ExternalSyntheticLambda2(function1, obj2, b);
                    gapComposer.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new ChipsRowKt$$ExternalSyntheticLambda2(function1, obj2, b);
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                m1457AnimatedFilterChipFNF3uiM(0, j5, gapComposer, str2, (Function0) objRememberedValue, zAreEqual2);
                OffsetKt.Spacer(gapComposer, SizeKt.m155width3ABfNKs(companion3, 8.0f));
                j3 = j5;
                companion = companion3;
            }
            gapComposer.end(false);
            gapComposer.end(true);
            modifier3 = modifier5;
            j2 = j3;
        } else {
            gapComposer.skipToGroupEnd();
            modifier3 = modifier2;
            j2 = j;
        }
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.metrolist.music.ui.component.ChipsRowKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj3, Object obj4) {
                    ((Integer) obj4).getClass();
                    DialogKt.m1461ChipsRowyrwZFoE(list, obj, function1, modifier3, j2, (Composer) obj3, Stack.updateChangedFlags(i | 1), i2);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX INFO: renamed from: ChoiceChipsRow-88mDfTA, reason: not valid java name */
    public static final void m1462ChoiceChipsRow88mDfTA(final List list, final List list2, final OptionStats optionStats, Function1 function1, final Integer num, final Function1 function2, Modifier modifier, long j, Composer composer, final int i) {
        final Modifier modifier2;
        final long j2;
        int i2;
        Modifier modifier3;
        long j3;
        long jGlassFill;
        final Function1 function3 = function1;
        list.getClass();
        optionStats.getClass();
        function3.getClass();
        function2.getClass();
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(1758454550);
        int i3 = i | (gapComposer.changed(list) ? 4 : 2) | (gapComposer.changed(list2) ? 32 : 16) | (gapComposer.changed(optionStats.ordinal()) ? 256 : 128) | (gapComposer.changedInstance(function3) ? 2048 : 1024) | (gapComposer.changed(num) ? 16384 : 8192) | (gapComposer.changedInstance(function2) ? 131072 : 65536) | 5767168;
        if (gapComposer.shouldExecute(i3 & 1, (4793491 & i3) != 4793490)) {
            gapComposer.startDefaults();
            int i4 = i & 1;
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            if (i4 == 0 || gapComposer.getDefaultsInvalid()) {
                i2 = i3 & (-29360129);
                modifier3 = companion;
                j3 = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.surfaceContainer;
            } else {
                gapComposer.skipToGroupEnd();
                j3 = j;
                i2 = i3 & (-29360129);
                modifier3 = modifier;
            }
            gapComposer.endDefaults();
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Format$$ExternalSyntheticOutline0.m(CropImageView.DEFAULT_ASPECT_RATIO, gapComposer);
            }
            ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = (ParcelableSnapshotMutableFloatState) objRememberedValue;
            AnimateAsState animateAsStateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(parcelableSnapshotMutableFloatState.getFloatValue(), ArcSplineKt.tween$default(400, 0, null, 6), "", gapComposer, 3120, 20);
            Modifier modifierM139paddingqDBjuR0$default = OffsetKt.m139paddingqDBjuR0$default(SizeKt.fillMaxWidth(modifier3, 1.0f), 12.0f, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 14);
            WeakHashMap weakHashMap = WindowInsetsHolder.viewMap;
            Modifier modifierWindowInsetsPadding = OffsetKt.windowInsetsPadding(modifierM139paddingqDBjuR0$default, new LimitInsets(OffsetKt.current(gapComposer).systemBars, 15));
            RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(OffsetKt.Start, Alignment.Companion.Top, gapComposer, 0);
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierWindowInsetsPadding);
            ComposeUiNode.Companion.getClass();
            gapComposer.startReusableNode();
            boolean z = gapComposer.inserting;
            Modifier modifier4 = modifier3;
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
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            MutableState mutableState = (MutableState) objRememberedValue2;
            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start, gapComposer, 0);
            int iHashCode2 = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer, companion);
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
            RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_4 = UiStyleKt.isGlassStyle(gapComposer) ? RoundedCornerShapeKt.CircleShape : RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(8.0f);
            BorderStroke borderStrokeM38BorderStrokecXLIe8U = UiStyleKt.isGlassStyle(gapComposer) ? ImageKt.m38BorderStrokecXLIe8U(ColorKt.Color(Color.m485getRedimpl(-4294967296L), Color.m484getGreenimpl(-4294967296L), Color.m482getBlueimpl(-4294967296L), 0.35f, Color.m483getColorSpaceimpl(-4294967296L)), 1.0f) : null;
            PaddingValuesImpl paddingValuesImpl = AssistChipDefaults.ContentPadding;
            if (UiStyleKt.isGlassStyle(gapComposer)) {
                gapComposer.startReplaceGroup(-1703539033);
                jGlassFill = GlassComponentsKt.glassFill(false, gapComposer, 1);
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(-1703538486);
                gapComposer.end(false);
                jGlassFill = j3;
            }
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
            long j4 = jGlassFill;
            long j5 = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.onSurface;
            Rgb rgb = ColorSpaces.Unspecified;
            long jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
            long jColor2 = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
            long jColor3 = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
            long jColor4 = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
            long jColor5 = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
            long jColor6 = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
            ColorScheme colorScheme = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme;
            ChipColors chipColors = colorScheme.defaultAssistChipColorsCached;
            if (chipColors == null) {
                long jM284fromToken_Htp75A = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 17);
                long jM284fromToken_Htp75A2 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 25);
                long jM284fromToken_Htp75A3 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 25);
                long jM284fromToken_Htp75A4 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 17);
                long jColor7 = ColorKt.Color(Color.m485getRedimpl(jM284fromToken_Htp75A4), Color.m484getGreenimpl(jM284fromToken_Htp75A4), Color.m482getBlueimpl(jM284fromToken_Htp75A4), 0.38f, Color.m483getColorSpaceimpl(jM284fromToken_Htp75A4));
                long jM284fromToken_Htp75A5 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 17);
                long jColor8 = ColorKt.Color(Color.m485getRedimpl(jM284fromToken_Htp75A5), Color.m484getGreenimpl(jM284fromToken_Htp75A5), Color.m482getBlueimpl(jM284fromToken_Htp75A5), 0.38f, Color.m483getColorSpaceimpl(jM284fromToken_Htp75A5));
                long jM284fromToken_Htp75A6 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 17);
                chipColors = new ChipColors(0L, jM284fromToken_Htp75A, jM284fromToken_Htp75A2, jM284fromToken_Htp75A3, 0L, jColor7, jColor8, ColorKt.Color(Color.m485getRedimpl(jM284fromToken_Htp75A6), Color.m484getGreenimpl(jM284fromToken_Htp75A6), Color.m482getBlueimpl(jM284fromToken_Htp75A6), 0.38f, Color.m483getColorSpaceimpl(jM284fromToken_Htp75A6)));
                colorScheme.defaultAssistChipColorsCached = chipColors;
            }
            long j6 = j4 != 16 ? j4 : chipColors.containerColor;
            if (j5 == r7) {
                j5 = chipColors.labelColor;
            }
            ChipColors chipColors2 = new ChipColors(j6, j5, jColor != r7 ? jColor : chipColors.leadingIconContentColor, jColor2 != r7 ? jColor2 : chipColors.trailingIconContentColor, jColor3 != r7 ? jColor3 : chipColors.disabledContainerColor, jColor4 != r7 ? jColor4 : chipColors.disabledLabelColor, jColor5 != r7 ? jColor5 : chipColors.disabledLeadingIconContentColor, jColor6 != 16 ? jColor6 : chipColors.disabledTrailingIconContentColor);
            Object objRememberedValue3 = r8.rememberedValue();
            if (objRememberedValue3 == neverEqualPolicy) {
                objRememberedValue3 = new QueueKt$$ExternalSyntheticLambda7(mutableState, parcelableSnapshotMutableFloatState, (byte) 2);
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            ChipKt.AssistChip((Function0) objRememberedValue3, Expect_jvmKt.rememberComposableLambda(468615929, new MainActivity$$ExternalSyntheticLambda0((byte) 7, optionStats), r8), null, false, Expect_jvmKt.rememberComposableLambda(1565696373, new ListItemKt$$ExternalSyntheticLambda11(animateAsStateAnimateFloatAsState, (byte) 1), r8), roundedCornerShapeM185RoundedCornerShape0680j_4, chipColors2, null, borderStrokeM38BorderStrokecXLIe8U, null, null, r8, 196662);
            gapComposer = r8;
            boolean zBooleanValue = ((Boolean) mutableState.getValue()).booleanValue();
            EnterTransitionImpl enterTransitionImplPlus = EnterExitTransitionKt.expandIn$default().plus(EnterExitTransitionKt.fadeIn$default(null, CropImageView.DEFAULT_ASPECT_RATIO, 3));
            Map map = VisibilityThresholdsKt.VisibilityThresholdMap;
            function3 = function1;
            CrossfadeKt.AnimatedVisibility(ColumnScopeInstance.INSTANCE, zBooleanValue, null, enterTransitionImplPlus, EnterExitTransitionKt.shrinkOut(ArcSplineKt.spring$default(CropImageView.DEFAULT_ASPECT_RATIO, 400.0f, new IntSize(4294967297L), 1), Alignment.Companion.BottomEnd, new SystemBarStyle$Companion$$ExternalSyntheticLambda0((byte) 20)).plus(EnterExitTransitionKt.fadeOut$default(null, CropImageView.DEFAULT_ASPECT_RATIO, 3)), null, Expect_jvmKt.rememberComposableLambda(-824231132, new ChipsRowKt$$ExternalSyntheticLambda7(mutableState, parcelableSnapshotMutableFloatState, list2, function3), gapComposer), gapComposer, 1600518, 18);
            gapComposer.end(true);
            Object objRememberedValue4 = gapComposer.rememberedValue();
            if (objRememberedValue4 == neverEqualPolicy) {
                objRememberedValue4 = new AlbumMenuKt$$ExternalSyntheticLambda13((byte) 5);
                gapComposer.updateRememberedValue(objRememberedValue4);
            }
            final long j7 = j3;
            CrossfadeKt.AnimatedContent(optionStats, null, (Function1) objRememberedValue4, null, "", null, Expect_jvmKt.rememberComposableLambda(1112441677, new Function4() { // from class: com.metrolist.music.ui.component.ChipsRowKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    Composer composer2 = (Composer) obj3;
                    int iIntValue = ((Integer) obj4).intValue();
                    ((AnimatedContentScopeImpl) obj).getClass();
                    ((OptionStats) obj2).getClass();
                    GapComposer gapComposer2 = (GapComposer) composer2;
                    if (gapComposer2.shouldExecute(iIntValue & 1, (iIntValue & 129) != 128)) {
                        Modifier.Companion companion2 = Modifier.Companion.$$INSTANCE;
                        Modifier modifierScroll$default = ImageKt.scroll$default(SizeKt.fillMaxWidth(companion2, 1.0f), ImageKt.rememberScrollState(gapComposer2), false);
                        WeakHashMap weakHashMap2 = WindowInsetsHolder.viewMap;
                        Modifier modifierWindowInsetsPadding2 = OffsetKt.windowInsetsPadding(modifierScroll$default, new LimitInsets(OffsetKt.current(gapComposer2).systemBars, 15));
                        RowMeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(OffsetKt.Start, Alignment.Companion.Top, gapComposer2, 0);
                        int iHashCode3 = Long.hashCode(gapComposer2.compositeKeyHashCode);
                        PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer2.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer2, modifierWindowInsetsPadding2);
                        ComposeUiNode.Companion.getClass();
                        gapComposer2.startReusableNode();
                        if (gapComposer2.inserting) {
                            gapComposer2.createNode(LayoutNode.Constructor);
                        } else {
                            gapComposer2.useNode();
                        }
                        Stack.m390setimpl(gapComposer2, rowMeasurePolicy2, ComposeUiNode.Companion.SetMeasurePolicy);
                        Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                        Stack.m390setimpl(gapComposer2, Integer.valueOf(iHashCode3), ComposeUiNode.Companion.SetCompositeKeyHash);
                        Stack.m389reconcileimpl(gapComposer2);
                        Stack.m390setimpl(gapComposer2, modifierMaterializeModifier3, ComposeUiNode.Companion.SetModifier);
                        gapComposer2.startReplaceGroup(1845514212);
                        for (Pair pair : list) {
                            Object obj5 = pair.first;
                            String str = (String) pair.second;
                            OffsetKt.Spacer(gapComposer2, SizeKt.m155width3ABfNKs(companion2, 8.0f));
                            boolean zEquals = num.equals(obj5);
                            Function1 function4 = function2;
                            boolean zChanged = gapComposer2.changed(function4) | gapComposer2.changedInstance(obj5);
                            Object objRememberedValue5 = gapComposer2.rememberedValue();
                            if (zChanged || objRememberedValue5 == Composer.Companion.Empty) {
                                objRememberedValue5 = new ChipsRowKt$$ExternalSyntheticLambda2(function4, obj5, (byte) 1);
                                gapComposer2.updateRememberedValue(objRememberedValue5);
                            }
                            DialogKt.m1457AnimatedFilterChipFNF3uiM(0, j7, gapComposer2, str, (Function0) objRememberedValue5, zEquals);
                        }
                        gapComposer2.end(false);
                        gapComposer2.end(true);
                    } else {
                        gapComposer2.skipToGroupEnd();
                    }
                    return Unit.INSTANCE;
                }
            }, gapComposer), gapComposer, ((i2 >> 6) & 14) | 1597824, 42);
            gapComposer.end(true);
            j2 = j7;
            modifier2 = modifier4;
        } else {
            gapComposer.skipToGroupEnd();
            modifier2 = modifier;
            j2 = j;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2(list, list2, optionStats, function3, num, function2, modifier2, j2, i) { // from class: com.metrolist.music.ui.component.ChipsRowKt$$ExternalSyntheticLambda10
                public final /* synthetic */ List f$0;
                public final /* synthetic */ List f$1;
                public final /* synthetic */ OptionStats f$2;
                public final /* synthetic */ Function1 f$3;
                public final /* synthetic */ Integer f$4;
                public final /* synthetic */ Function1 f$5;
                public final /* synthetic */ Modifier f$6;
                public final /* synthetic */ long f$7;

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(1);
                    DialogKt.m1462ChoiceChipsRow88mDfTA(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, (Composer) obj, iUpdateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX INFO: renamed from: CircularProgressIndicator-IyT6zlY, reason: not valid java name */
    public static final void m1463CircularProgressIndicatorIyT6zlY(Function0 function0, Modifier modifier, long j, float f, long j2, int i, float f2, Composer composer, int i2) {
        int i3;
        GapComposer gapComposer;
        int i4;
        float f3;
        int i5;
        float f4;
        int i6;
        function0.getClass();
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(1151554702);
        if ((i2 & 6) == 0) {
            i3 = (gapComposer2.changedInstance(function0) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= gapComposer2.changed(modifier) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= gapComposer2.changed(j) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i3 |= gapComposer2.changed(f) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i3 |= gapComposer2.changed(j2) ? 16384 : 8192;
        }
        if ((196608 & i2) == 0) {
            i3 |= 65536;
        }
        int i7 = i3 | 1572864;
        if (gapComposer2.shouldExecute(i7 & 1, (599187 & i7) != 599186)) {
            gapComposer2.startDefaults();
            if ((i2 & 1) == 0 || gapComposer2.getDefaultsInvalid()) {
                i5 = i7 & (-458753);
                f4 = 4.0f;
                i6 = 1;
            } else {
                gapComposer2.skipToGroupEnd();
                i5 = i7 & (-458753);
                i6 = i;
                f4 = f2;
            }
            gapComposer2.endDefaults();
            gapComposer2.startReplaceGroup(-1457480514);
            long j3 = j != 16 ? j : ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.primary;
            gapComposer2.end(false);
            gapComposer2.startReplaceGroup(-1457476763);
            long j4 = j2 != 16 ? j2 : ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.outlineVariant;
            gapComposer2.end(false);
            gapComposer = gapComposer2;
            ProgressIndicatorKt.m308CircularProgressIndicatorIyT6zlY(function0, modifier, j3, f, j4, i6, f4, gapComposer, i5 & 4136062);
            i4 = i6;
            f3 = f4;
        } else {
            gapComposer = gapComposer2;
            gapComposer.skipToGroupEnd();
            i4 = i;
            f3 = f2;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ProgressIndicatorKt$$ExternalSyntheticLambda13(function0, modifier, j, f, j2, i4, f3, i2, (byte) 1);
        }
    }

    /* JADX INFO: renamed from: CircularProgressIndicator-LxG7B9w, reason: not valid java name */
    public static final void m1464CircularProgressIndicatorLxG7B9w(float f, int i, final int i2, final int i3, long j, long j2, Composer composer, Modifier modifier) {
        Modifier modifier2;
        int i4;
        long jColor;
        int i5;
        final float f2;
        final int i6;
        final long j3;
        final Modifier modifier3;
        final long j4;
        Modifier modifier4;
        float f3;
        long jColor2;
        long j5;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(1785317538);
        int i7 = i3 & 1;
        if (i7 != 0) {
            i4 = i2 | 6;
            modifier2 = modifier;
        } else if ((i2 & 6) == 0) {
            modifier2 = modifier;
            i4 = i2 | (gapComposer.changed(modifier2) ? 4 : 2);
        } else {
            modifier2 = modifier;
            i4 = i2;
        }
        int i8 = i3 & 2;
        if (i8 != 0) {
            i5 = i4 | 48;
            jColor = j;
        } else {
            jColor = j;
            i5 = i4 | (gapComposer.changed(jColor) ? 32 : 16);
        }
        int i9 = 1;
        if (gapComposer.shouldExecute(i5 & 1, (i5 & 19) != 18)) {
            gapComposer.startDefaults();
            if ((i2 & 1) == 0 || gapComposer.getDefaultsInvalid()) {
                Modifier modifier5 = i7 != 0 ? Modifier.Companion.$$INSTANCE : modifier2;
                if (i8 != 0) {
                    jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                }
                modifier4 = modifier5;
                f3 = (i3 & 4) != 0 ? 4.0f : f;
                jColor2 = (i3 & 8) != 0 ? ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified) : j2;
            } else {
                gapComposer.skipToGroupEnd();
                f3 = f;
                i9 = i;
                jColor2 = j2;
                modifier4 = modifier2;
            }
            long j6 = jColor;
            gapComposer.endDefaults();
            gapComposer.startReplaceGroup(1998210738);
            long j7 = j6 != 16 ? j6 : ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.primary;
            gapComposer.end(false);
            if (ULong.m1869equalsimpl0(j6, ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified))) {
                gapComposer.startReplaceGroup(1998214571);
                j5 = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.onSurface;
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(1998215047);
                gapComposer.end(false);
                j5 = j6;
            }
            m1458AuralysLoaderRIQooxk(SizeKt.m151size3ABfNKs(modifier4, 40.0f), j7, j5, gapComposer, 0, 0);
            f2 = f3;
            i6 = i9;
            j4 = j6;
            j3 = jColor2;
            modifier3 = modifier4;
        } else {
            gapComposer.skipToGroupEnd();
            f2 = f;
            i6 = i;
            j3 = j2;
            modifier3 = modifier2;
            j4 = jColor;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.metrolist.music.ui.component.AuralysBrandKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(i2 | 1);
                    float f4 = f2;
                    boolean z = i6;
                    byte b = i3;
                    long j8 = j4;
                    long j9 = j3;
                    DialogKt.m1464CircularProgressIndicatorLxG7B9w(f4, z ? 1 : 0, iUpdateChangedFlags, b, j8, j9, (Composer) obj, modifier3);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX INFO: renamed from: ContainedLoadingIndicator-eopBjH0, reason: not valid java name */
    public static final void m1465ContainedLoadingIndicatoreopBjH0(Modifier modifier, long j, long j2, Shape shape, Composer composer, int i) {
        Modifier modifier2;
        long j3;
        long j4;
        Shape shape2;
        long jColor;
        Shape shape3;
        Modifier modifier3;
        long j5;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(1185905300);
        int i2 = i | 1462;
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 1171) != 1170)) {
            gapComposer.startDefaults();
            int i3 = i & 1;
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            if (i3 == 0 || gapComposer.getDefaultsInvalid()) {
                Rgb rgb = ColorSpaces.Unspecified;
                jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
                long jColor2 = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
                shape3 = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).shapes.large;
                modifier3 = companion;
                j5 = jColor2;
            } else {
                gapComposer.skipToGroupEnd();
                modifier3 = modifier;
                jColor = j;
                j5 = j2;
                shape3 = shape;
            }
            gapComposer.endDefaults();
            Modifier modifierM151size3ABfNKs = SizeKt.m151size3ABfNKs(modifier3, 56.0f);
            gapComposer.startReplaceGroup(1488669837);
            long j6 = jColor != 16 ? jColor : ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.surfaceContainer;
            gapComposer.end(false);
            Modifier modifierM39backgroundbw27NRU = ImageKt.m39backgroundbw27NRU(modifierM151size3ABfNKs, j6, shape3);
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
            Modifier modifierM151size3ABfNKs2 = SizeKt.m151size3ABfNKs(companion, 36.0f);
            gapComposer.startReplaceGroup(2096371274);
            long j7 = j5 != 16 ? j5 : ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.primary;
            gapComposer.end(false);
            m1458AuralysLoaderRIQooxk(modifierM151size3ABfNKs2, j7, 0L, gapComposer, 6, 4);
            gapComposer.end(true);
            shape2 = shape3;
            j3 = jColor;
            modifier2 = modifier3;
            j4 = j5;
        } else {
            gapComposer.skipToGroupEnd();
            modifier2 = modifier;
            j3 = j;
            j4 = j2;
            shape2 = shape;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new MiniPlayerKt$$ExternalSyntheticLambda25(modifier2, j3, j4, shape2, i);
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0042  */
    /* JADX WARN: Code duplicated, block: B:25:0x0047  */
    /* JADX WARN: Code duplicated, block: B:27:0x004b  */
    /* JADX WARN: Code duplicated, block: B:29:0x0053  */
    /* JADX WARN: Code duplicated, block: B:30:0x0056  */
    /* JADX WARN: Code duplicated, block: B:34:0x005d  */
    /* JADX WARN: Code duplicated, block: B:36:0x0062  */
    /* JADX WARN: Code duplicated, block: B:38:0x0066  */
    /* JADX WARN: Code duplicated, block: B:40:0x006e  */
    /* JADX WARN: Code duplicated, block: B:41:0x0071  */
    /* JADX WARN: Code duplicated, block: B:45:0x007a  */
    /* JADX WARN: Code duplicated, block: B:46:0x007c  */
    /* JADX WARN: Code duplicated, block: B:49:0x0085  */
    /* JADX WARN: Code duplicated, block: B:51:0x0088  */
    /* JADX WARN: Code duplicated, block: B:53:0x008b  */
    /* JADX WARN: Code duplicated, block: B:54:0x008e  */
    /* JADX WARN: Code duplicated, block: B:56:0x0092  */
    /* JADX WARN: Code duplicated, block: B:57:0x0095  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:66:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:67:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:71:0x0102  */
    /* JADX WARN: Code duplicated, block: B:74:0x011e  */
    /* JADX WARN: Code duplicated, block: B:75:0x0121  */
    /* JADX WARN: Code duplicated, block: B:78:0x012b A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:81:0x0133  */
    /* JADX WARN: Code duplicated, block: B:83:0x018e  */
    /* JADX WARN: Code duplicated, block: B:86:0x019c  */
    /* JADX WARN: Code duplicated, block: B:88:? A[RETURN, SYNTHETIC] */
    public static final void CreatePlaylistDialog(Function0 function0, String str, boolean z, Function1 function1, Composer composer, int i, int i2) {
        int i3;
        String str2;
        int i4;
        boolean z2;
        int i5;
        int i6;
        Function1 function2;
        int i7;
        boolean z3;
        GapComposer gapComposer;
        String str3;
        boolean z4;
        Function1 function3;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        boolean z5;
        Function1 function4;
        SyncUtils syncUtils;
        Object objRememberedValue;
        NeverEqualPolicy neverEqualPolicy;
        Object objRememberedValue2;
        MutableState mutableState;
        Context context;
        boolean z6;
        String strStringResource;
        boolean z7;
        boolean z8;
        Object objRememberedValue3;
        Context context2;
        function0.getClass();
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(1781977434);
        if ((i & 6) == 0) {
            i3 = (gapComposer2.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i8 = i2 & 2;
        if (i8 == 0) {
            if ((i & 48) == 0) {
                str2 = str;
                i3 |= gapComposer2.changed(str2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    z2 = z;
                    if (gapComposer2.changed(z2)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    if ((i & 3072) == 0) {
                        function2 = function1;
                        if (gapComposer2.changedInstance(function2)) {
                            i7 = 2048;
                        } else {
                            i7 = 1024;
                        }
                        i3 |= i7;
                    }
                    if ((i3 & 1171) != 1170) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (gapComposer2.shouldExecute(i3 & 1, z3)) {
                        if (i8 != 0) {
                            str2 = null;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function4 = null;
                        } else {
                            function4 = function2;
                        }
                        syncUtils = (SyncUtils) gapComposer2.consume(MainActivityKt.LocalSyncUtils);
                        objRememberedValue = gapComposer2.rememberedValue();
                        neverEqualPolicy = Composer.Companion.Empty;
                        if (objRememberedValue == neverEqualPolicy) {
                            objRememberedValue = Stack.createCompositionCoroutineScope(gapComposer2);
                            gapComposer2.updateRememberedValue(objRememberedValue);
                        }
                        CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
                        objRememberedValue2 = gapComposer2.rememberedValue();
                        if (objRememberedValue2 == neverEqualPolicy) {
                            objRememberedValue2 = Stack.mutableStateOf$default(Boolean.FALSE);
                            gapComposer2.updateRememberedValue(objRememberedValue2);
                        }
                        mutableState = (MutableState) objRememberedValue2;
                        context = (Context) gapComposer2.consume(AndroidCompositionLocals_androidKt.LocalContext);
                        if (((String) UtilsKt.rememberPreference(PreferenceKeysKt.InnerTubeCookieKey, "", gapComposer2, 48).$state.getValue()).length() > 0) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        String strStringResource2 = MathKt.stringResource(R.string.not_logged_in_youtube, gapComposer2);
                        String strStringResource3 = MathKt.stringResource(R.string.sync_disabled, gapComposer2);
                        strStringResource = MathKt.stringResource(R.string.playlist_created_locally, gapComposer2);
                        boolean z9 = z6;
                        TextFieldValue textFieldValue = new TextFieldValue(6, 0L, str2 != null ? str2 : "");
                        boolean zChangedInstance = gapComposer2.changedInstance(syncUtils) | gapComposer2.changedInstance(context) | gapComposer2.changed(strStringResource);
                        if ((i3 & 7168) == 2048) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        z8 = zChangedInstance | z7;
                        objRememberedValue3 = gapComposer2.rememberedValue();
                        if (!z8 || objRememberedValue3 == neverEqualPolicy) {
                            objRememberedValue3 = new AlbumMenuKt$$ExternalSyntheticLambda40(syncUtils, mutableState, context, strStringResource, function4);
                            context2 = context;
                            gapComposer2.updateRememberedValue(objRememberedValue3);
                        } else {
                            context2 = context;
                        }
                        z4 = z5;
                        gapComposer = gapComposer2;
                        m1470TextFieldDialog5RwOfIE(null, f12lambda$1173103151, f25lambda$1875698990, textFieldValue, false, false, 0, null, 0, (Function1) objRememberedValue3, null, null, null, function0, false, Expect_jvmKt.rememberComposableLambda(-327759315, new IconButtonKt$$ExternalSyntheticLambda5(z5, coroutineScope, context2, z9, strStringResource2, strStringResource3, mutableState), gapComposer2), gapComposer, 432, ((i3 << 12) & 57344) | 1572864, 48113);
                        str3 = str2;
                        function3 = function4;
                    } else {
                        gapComposer = gapComposer2;
                        gapComposer.skipToGroupEnd();
                        str3 = str2;
                        z4 = z2;
                        function3 = function2;
                    }
                    recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                    if (recomposeScopeImplEndRestartGroup != null) {
                        recomposeScopeImplEndRestartGroup.block = new ItemsKt$$ExternalSyntheticLambda25(function0, str3, z4, function3, i, i2);
                    }
                }
                i3 |= 3072;
                function2 = function1;
                if ((i3 & 1171) != 1170) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (gapComposer2.shouldExecute(i3 & 1, z3)) {
                    if (i8 != 0) {
                        str2 = null;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        function4 = null;
                    } else {
                        function4 = function2;
                    }
                    syncUtils = (SyncUtils) gapComposer2.consume(MainActivityKt.LocalSyncUtils);
                    objRememberedValue = gapComposer2.rememberedValue();
                    neverEqualPolicy = Composer.Companion.Empty;
                    if (objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = Stack.createCompositionCoroutineScope(gapComposer2);
                        gapComposer2.updateRememberedValue(objRememberedValue);
                    }
                    CoroutineScope coroutineScope2 = (CoroutineScope) objRememberedValue;
                    objRememberedValue2 = gapComposer2.rememberedValue();
                    if (objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = Stack.mutableStateOf$default(Boolean.FALSE);
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState = (MutableState) objRememberedValue2;
                    context = (Context) gapComposer2.consume(AndroidCompositionLocals_androidKt.LocalContext);
                    if (((String) UtilsKt.rememberPreference(PreferenceKeysKt.InnerTubeCookieKey, "", gapComposer2, 48).$state.getValue()).length() > 0) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    String strStringResource4 = MathKt.stringResource(R.string.not_logged_in_youtube, gapComposer2);
                    String strStringResource5 = MathKt.stringResource(R.string.sync_disabled, gapComposer2);
                    strStringResource = MathKt.stringResource(R.string.playlist_created_locally, gapComposer2);
                    boolean z10 = z6;
                    TextFieldValue textFieldValue2 = new TextFieldValue(6, 0L, str2 != null ? str2 : "");
                    boolean zChangedInstance2 = gapComposer2.changedInstance(syncUtils) | gapComposer2.changedInstance(context) | gapComposer2.changed(strStringResource);
                    if ((i3 & 7168) == 2048) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    z8 = zChangedInstance2 | z7;
                    objRememberedValue3 = gapComposer2.rememberedValue();
                    if (z8) {
                        objRememberedValue3 = new AlbumMenuKt$$ExternalSyntheticLambda40(syncUtils, mutableState, context, strStringResource, function4);
                        context2 = context;
                        gapComposer2.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new AlbumMenuKt$$ExternalSyntheticLambda40(syncUtils, mutableState, context, strStringResource, function4);
                        context2 = context;
                        gapComposer2.updateRememberedValue(objRememberedValue3);
                    }
                    z4 = z5;
                    gapComposer = gapComposer2;
                    m1470TextFieldDialog5RwOfIE(null, f12lambda$1173103151, f25lambda$1875698990, textFieldValue2, false, false, 0, null, 0, (Function1) objRememberedValue3, null, null, null, function0, false, Expect_jvmKt.rememberComposableLambda(-327759315, new IconButtonKt$$ExternalSyntheticLambda5(z5, coroutineScope2, context2, z10, strStringResource4, strStringResource5, mutableState), gapComposer2), gapComposer, 432, ((i3 << 12) & 57344) | 1572864, 48113);
                    str3 = str2;
                    function3 = function4;
                } else {
                    gapComposer = gapComposer2;
                    gapComposer.skipToGroupEnd();
                    str3 = str2;
                    z4 = z2;
                    function3 = function2;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new ItemsKt$$ExternalSyntheticLambda25(function0, str3, z4, function3, i, i2);
                }
            }
            i3 |= 384;
            z2 = z;
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 3072) == 0) {
                    function2 = function1;
                    if (gapComposer2.changedInstance(function2)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                if ((i3 & 1171) != 1170) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (gapComposer2.shouldExecute(i3 & 1, z3)) {
                    if (i8 != 0) {
                        str2 = null;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        function4 = null;
                    } else {
                        function4 = function2;
                    }
                    syncUtils = (SyncUtils) gapComposer2.consume(MainActivityKt.LocalSyncUtils);
                    objRememberedValue = gapComposer2.rememberedValue();
                    neverEqualPolicy = Composer.Companion.Empty;
                    if (objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = Stack.createCompositionCoroutineScope(gapComposer2);
                        gapComposer2.updateRememberedValue(objRememberedValue);
                    }
                    CoroutineScope coroutineScope3 = (CoroutineScope) objRememberedValue;
                    objRememberedValue2 = gapComposer2.rememberedValue();
                    if (objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = Stack.mutableStateOf$default(Boolean.FALSE);
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState = (MutableState) objRememberedValue2;
                    context = (Context) gapComposer2.consume(AndroidCompositionLocals_androidKt.LocalContext);
                    if (((String) UtilsKt.rememberPreference(PreferenceKeysKt.InnerTubeCookieKey, "", gapComposer2, 48).$state.getValue()).length() > 0) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    String strStringResource6 = MathKt.stringResource(R.string.not_logged_in_youtube, gapComposer2);
                    String strStringResource7 = MathKt.stringResource(R.string.sync_disabled, gapComposer2);
                    strStringResource = MathKt.stringResource(R.string.playlist_created_locally, gapComposer2);
                    boolean z11 = z6;
                    TextFieldValue textFieldValue3 = new TextFieldValue(6, 0L, str2 != null ? str2 : "");
                    boolean zChangedInstance3 = gapComposer2.changedInstance(syncUtils) | gapComposer2.changedInstance(context) | gapComposer2.changed(strStringResource);
                    if ((i3 & 7168) == 2048) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    z8 = zChangedInstance3 | z7;
                    objRememberedValue3 = gapComposer2.rememberedValue();
                    if (z8) {
                        objRememberedValue3 = new AlbumMenuKt$$ExternalSyntheticLambda40(syncUtils, mutableState, context, strStringResource, function4);
                        context2 = context;
                        gapComposer2.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new AlbumMenuKt$$ExternalSyntheticLambda40(syncUtils, mutableState, context, strStringResource, function4);
                        context2 = context;
                        gapComposer2.updateRememberedValue(objRememberedValue3);
                    }
                    z4 = z5;
                    gapComposer = gapComposer2;
                    m1470TextFieldDialog5RwOfIE(null, f12lambda$1173103151, f25lambda$1875698990, textFieldValue3, false, false, 0, null, 0, (Function1) objRememberedValue3, null, null, null, function0, false, Expect_jvmKt.rememberComposableLambda(-327759315, new IconButtonKt$$ExternalSyntheticLambda5(z5, coroutineScope3, context2, z11, strStringResource6, strStringResource7, mutableState), gapComposer2), gapComposer, 432, ((i3 << 12) & 57344) | 1572864, 48113);
                    str3 = str2;
                    function3 = function4;
                } else {
                    gapComposer = gapComposer2;
                    gapComposer.skipToGroupEnd();
                    str3 = str2;
                    z4 = z2;
                    function3 = function2;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new ItemsKt$$ExternalSyntheticLambda25(function0, str3, z4, function3, i, i2);
                }
            }
            i3 |= 3072;
            function2 = function1;
            if ((i3 & 1171) != 1170) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (gapComposer2.shouldExecute(i3 & 1, z3)) {
                if (i8 != 0) {
                    str2 = null;
                }
                if (i4 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                if (i6 != 0) {
                    function4 = null;
                } else {
                    function4 = function2;
                }
                syncUtils = (SyncUtils) gapComposer2.consume(MainActivityKt.LocalSyncUtils);
                objRememberedValue = gapComposer2.rememberedValue();
                neverEqualPolicy = Composer.Companion.Empty;
                if (objRememberedValue == neverEqualPolicy) {
                    objRememberedValue = Stack.createCompositionCoroutineScope(gapComposer2);
                    gapComposer2.updateRememberedValue(objRememberedValue);
                }
                CoroutineScope coroutineScope4 = (CoroutineScope) objRememberedValue;
                objRememberedValue2 = gapComposer2.rememberedValue();
                if (objRememberedValue2 == neverEqualPolicy) {
                    objRememberedValue2 = Stack.mutableStateOf$default(Boolean.FALSE);
                    gapComposer2.updateRememberedValue(objRememberedValue2);
                }
                mutableState = (MutableState) objRememberedValue2;
                context = (Context) gapComposer2.consume(AndroidCompositionLocals_androidKt.LocalContext);
                if (((String) UtilsKt.rememberPreference(PreferenceKeysKt.InnerTubeCookieKey, "", gapComposer2, 48).$state.getValue()).length() > 0) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                String strStringResource8 = MathKt.stringResource(R.string.not_logged_in_youtube, gapComposer2);
                String strStringResource9 = MathKt.stringResource(R.string.sync_disabled, gapComposer2);
                strStringResource = MathKt.stringResource(R.string.playlist_created_locally, gapComposer2);
                boolean z12 = z6;
                TextFieldValue textFieldValue4 = new TextFieldValue(6, 0L, str2 != null ? str2 : "");
                boolean zChangedInstance4 = gapComposer2.changedInstance(syncUtils) | gapComposer2.changedInstance(context) | gapComposer2.changed(strStringResource);
                if ((i3 & 7168) == 2048) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                z8 = zChangedInstance4 | z7;
                objRememberedValue3 = gapComposer2.rememberedValue();
                if (z8) {
                    objRememberedValue3 = new AlbumMenuKt$$ExternalSyntheticLambda40(syncUtils, mutableState, context, strStringResource, function4);
                    context2 = context;
                    gapComposer2.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new AlbumMenuKt$$ExternalSyntheticLambda40(syncUtils, mutableState, context, strStringResource, function4);
                    context2 = context;
                    gapComposer2.updateRememberedValue(objRememberedValue3);
                }
                z4 = z5;
                gapComposer = gapComposer2;
                m1470TextFieldDialog5RwOfIE(null, f12lambda$1173103151, f25lambda$1875698990, textFieldValue4, false, false, 0, null, 0, (Function1) objRememberedValue3, null, null, null, function0, false, Expect_jvmKt.rememberComposableLambda(-327759315, new IconButtonKt$$ExternalSyntheticLambda5(z5, coroutineScope4, context2, z12, strStringResource8, strStringResource9, mutableState), gapComposer2), gapComposer, 432, ((i3 << 12) & 57344) | 1572864, 48113);
                str3 = str2;
                function3 = function4;
            } else {
                gapComposer = gapComposer2;
                gapComposer.skipToGroupEnd();
                str3 = str2;
                z4 = z2;
                function3 = function2;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new ItemsKt$$ExternalSyntheticLambda25(function0, str3, z4, function3, i, i2);
            }
        }
        i3 |= 48;
        str2 = str;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 384) == 0) {
                z2 = z;
                if (gapComposer2.changed(z2)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 3072) == 0) {
                    function2 = function1;
                    if (gapComposer2.changedInstance(function2)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                if ((i3 & 1171) != 1170) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (gapComposer2.shouldExecute(i3 & 1, z3)) {
                    if (i8 != 0) {
                        str2 = null;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        function4 = null;
                    } else {
                        function4 = function2;
                    }
                    syncUtils = (SyncUtils) gapComposer2.consume(MainActivityKt.LocalSyncUtils);
                    objRememberedValue = gapComposer2.rememberedValue();
                    neverEqualPolicy = Composer.Companion.Empty;
                    if (objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = Stack.createCompositionCoroutineScope(gapComposer2);
                        gapComposer2.updateRememberedValue(objRememberedValue);
                    }
                    CoroutineScope coroutineScope5 = (CoroutineScope) objRememberedValue;
                    objRememberedValue2 = gapComposer2.rememberedValue();
                    if (objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = Stack.mutableStateOf$default(Boolean.FALSE);
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState = (MutableState) objRememberedValue2;
                    context = (Context) gapComposer2.consume(AndroidCompositionLocals_androidKt.LocalContext);
                    if (((String) UtilsKt.rememberPreference(PreferenceKeysKt.InnerTubeCookieKey, "", gapComposer2, 48).$state.getValue()).length() > 0) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    String strStringResource10 = MathKt.stringResource(R.string.not_logged_in_youtube, gapComposer2);
                    String strStringResource11 = MathKt.stringResource(R.string.sync_disabled, gapComposer2);
                    strStringResource = MathKt.stringResource(R.string.playlist_created_locally, gapComposer2);
                    boolean z13 = z6;
                    TextFieldValue textFieldValue5 = new TextFieldValue(6, 0L, str2 != null ? str2 : "");
                    boolean zChangedInstance5 = gapComposer2.changedInstance(syncUtils) | gapComposer2.changedInstance(context) | gapComposer2.changed(strStringResource);
                    if ((i3 & 7168) == 2048) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    z8 = zChangedInstance5 | z7;
                    objRememberedValue3 = gapComposer2.rememberedValue();
                    if (z8) {
                        objRememberedValue3 = new AlbumMenuKt$$ExternalSyntheticLambda40(syncUtils, mutableState, context, strStringResource, function4);
                        context2 = context;
                        gapComposer2.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new AlbumMenuKt$$ExternalSyntheticLambda40(syncUtils, mutableState, context, strStringResource, function4);
                        context2 = context;
                        gapComposer2.updateRememberedValue(objRememberedValue3);
                    }
                    z4 = z5;
                    gapComposer = gapComposer2;
                    m1470TextFieldDialog5RwOfIE(null, f12lambda$1173103151, f25lambda$1875698990, textFieldValue5, false, false, 0, null, 0, (Function1) objRememberedValue3, null, null, null, function0, false, Expect_jvmKt.rememberComposableLambda(-327759315, new IconButtonKt$$ExternalSyntheticLambda5(z5, coroutineScope5, context2, z13, strStringResource10, strStringResource11, mutableState), gapComposer2), gapComposer, 432, ((i3 << 12) & 57344) | 1572864, 48113);
                    str3 = str2;
                    function3 = function4;
                } else {
                    gapComposer = gapComposer2;
                    gapComposer.skipToGroupEnd();
                    str3 = str2;
                    z4 = z2;
                    function3 = function2;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new ItemsKt$$ExternalSyntheticLambda25(function0, str3, z4, function3, i, i2);
                }
            }
            i3 |= 3072;
            function2 = function1;
            if ((i3 & 1171) != 1170) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (gapComposer2.shouldExecute(i3 & 1, z3)) {
                if (i8 != 0) {
                    str2 = null;
                }
                if (i4 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                if (i6 != 0) {
                    function4 = null;
                } else {
                    function4 = function2;
                }
                syncUtils = (SyncUtils) gapComposer2.consume(MainActivityKt.LocalSyncUtils);
                objRememberedValue = gapComposer2.rememberedValue();
                neverEqualPolicy = Composer.Companion.Empty;
                if (objRememberedValue == neverEqualPolicy) {
                    objRememberedValue = Stack.createCompositionCoroutineScope(gapComposer2);
                    gapComposer2.updateRememberedValue(objRememberedValue);
                }
                CoroutineScope coroutineScope6 = (CoroutineScope) objRememberedValue;
                objRememberedValue2 = gapComposer2.rememberedValue();
                if (objRememberedValue2 == neverEqualPolicy) {
                    objRememberedValue2 = Stack.mutableStateOf$default(Boolean.FALSE);
                    gapComposer2.updateRememberedValue(objRememberedValue2);
                }
                mutableState = (MutableState) objRememberedValue2;
                context = (Context) gapComposer2.consume(AndroidCompositionLocals_androidKt.LocalContext);
                if (((String) UtilsKt.rememberPreference(PreferenceKeysKt.InnerTubeCookieKey, "", gapComposer2, 48).$state.getValue()).length() > 0) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                String strStringResource12 = MathKt.stringResource(R.string.not_logged_in_youtube, gapComposer2);
                String strStringResource13 = MathKt.stringResource(R.string.sync_disabled, gapComposer2);
                strStringResource = MathKt.stringResource(R.string.playlist_created_locally, gapComposer2);
                boolean z14 = z6;
                TextFieldValue textFieldValue6 = new TextFieldValue(6, 0L, str2 != null ? str2 : "");
                boolean zChangedInstance6 = gapComposer2.changedInstance(syncUtils) | gapComposer2.changedInstance(context) | gapComposer2.changed(strStringResource);
                if ((i3 & 7168) == 2048) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                z8 = zChangedInstance6 | z7;
                objRememberedValue3 = gapComposer2.rememberedValue();
                if (z8) {
                    objRememberedValue3 = new AlbumMenuKt$$ExternalSyntheticLambda40(syncUtils, mutableState, context, strStringResource, function4);
                    context2 = context;
                    gapComposer2.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new AlbumMenuKt$$ExternalSyntheticLambda40(syncUtils, mutableState, context, strStringResource, function4);
                    context2 = context;
                    gapComposer2.updateRememberedValue(objRememberedValue3);
                }
                z4 = z5;
                gapComposer = gapComposer2;
                m1470TextFieldDialog5RwOfIE(null, f12lambda$1173103151, f25lambda$1875698990, textFieldValue6, false, false, 0, null, 0, (Function1) objRememberedValue3, null, null, null, function0, false, Expect_jvmKt.rememberComposableLambda(-327759315, new IconButtonKt$$ExternalSyntheticLambda5(z5, coroutineScope6, context2, z14, strStringResource12, strStringResource13, mutableState), gapComposer2), gapComposer, 432, ((i3 << 12) & 57344) | 1572864, 48113);
                str3 = str2;
                function3 = function4;
            } else {
                gapComposer = gapComposer2;
                gapComposer.skipToGroupEnd();
                str3 = str2;
                z4 = z2;
                function3 = function2;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new ItemsKt$$ExternalSyntheticLambda25(function0, str3, z4, function3, i, i2);
            }
        }
        i3 |= 384;
        z2 = z;
        i6 = i2 & 8;
        if (i6 != 0) {
            if ((i & 3072) == 0) {
                function2 = function1;
                if (gapComposer2.changedInstance(function2)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i3 |= i7;
            }
            if ((i3 & 1171) != 1170) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (gapComposer2.shouldExecute(i3 & 1, z3)) {
                if (i8 != 0) {
                    str2 = null;
                }
                if (i4 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                if (i6 != 0) {
                    function4 = null;
                } else {
                    function4 = function2;
                }
                syncUtils = (SyncUtils) gapComposer2.consume(MainActivityKt.LocalSyncUtils);
                objRememberedValue = gapComposer2.rememberedValue();
                neverEqualPolicy = Composer.Companion.Empty;
                if (objRememberedValue == neverEqualPolicy) {
                    objRememberedValue = Stack.createCompositionCoroutineScope(gapComposer2);
                    gapComposer2.updateRememberedValue(objRememberedValue);
                }
                CoroutineScope coroutineScope7 = (CoroutineScope) objRememberedValue;
                objRememberedValue2 = gapComposer2.rememberedValue();
                if (objRememberedValue2 == neverEqualPolicy) {
                    objRememberedValue2 = Stack.mutableStateOf$default(Boolean.FALSE);
                    gapComposer2.updateRememberedValue(objRememberedValue2);
                }
                mutableState = (MutableState) objRememberedValue2;
                context = (Context) gapComposer2.consume(AndroidCompositionLocals_androidKt.LocalContext);
                if (((String) UtilsKt.rememberPreference(PreferenceKeysKt.InnerTubeCookieKey, "", gapComposer2, 48).$state.getValue()).length() > 0) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                String strStringResource14 = MathKt.stringResource(R.string.not_logged_in_youtube, gapComposer2);
                String strStringResource15 = MathKt.stringResource(R.string.sync_disabled, gapComposer2);
                strStringResource = MathKt.stringResource(R.string.playlist_created_locally, gapComposer2);
                boolean z15 = z6;
                TextFieldValue textFieldValue7 = new TextFieldValue(6, 0L, str2 != null ? str2 : "");
                boolean zChangedInstance7 = gapComposer2.changedInstance(syncUtils) | gapComposer2.changedInstance(context) | gapComposer2.changed(strStringResource);
                if ((i3 & 7168) == 2048) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                z8 = zChangedInstance7 | z7;
                objRememberedValue3 = gapComposer2.rememberedValue();
                if (z8) {
                    objRememberedValue3 = new AlbumMenuKt$$ExternalSyntheticLambda40(syncUtils, mutableState, context, strStringResource, function4);
                    context2 = context;
                    gapComposer2.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new AlbumMenuKt$$ExternalSyntheticLambda40(syncUtils, mutableState, context, strStringResource, function4);
                    context2 = context;
                    gapComposer2.updateRememberedValue(objRememberedValue3);
                }
                z4 = z5;
                gapComposer = gapComposer2;
                m1470TextFieldDialog5RwOfIE(null, f12lambda$1173103151, f25lambda$1875698990, textFieldValue7, false, false, 0, null, 0, (Function1) objRememberedValue3, null, null, null, function0, false, Expect_jvmKt.rememberComposableLambda(-327759315, new IconButtonKt$$ExternalSyntheticLambda5(z5, coroutineScope7, context2, z15, strStringResource14, strStringResource15, mutableState), gapComposer2), gapComposer, 432, ((i3 << 12) & 57344) | 1572864, 48113);
                str3 = str2;
                function3 = function4;
            } else {
                gapComposer = gapComposer2;
                gapComposer.skipToGroupEnd();
                str3 = str2;
                z4 = z2;
                function3 = function2;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new ItemsKt$$ExternalSyntheticLambda25(function0, str3, z4, function3, i, i2);
            }
        }
        i3 |= 3072;
        function2 = function1;
        if ((i3 & 1171) != 1170) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (gapComposer2.shouldExecute(i3 & 1, z3)) {
            if (i8 != 0) {
                str2 = null;
            }
            if (i4 != 0) {
                z5 = true;
            } else {
                z5 = z2;
            }
            if (i6 != 0) {
                function4 = null;
            } else {
                function4 = function2;
            }
            syncUtils = (SyncUtils) gapComposer2.consume(MainActivityKt.LocalSyncUtils);
            objRememberedValue = gapComposer2.rememberedValue();
            neverEqualPolicy = Composer.Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Stack.createCompositionCoroutineScope(gapComposer2);
                gapComposer2.updateRememberedValue(objRememberedValue);
            }
            CoroutineScope coroutineScope8 = (CoroutineScope) objRememberedValue;
            objRememberedValue2 = gapComposer2.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer2.updateRememberedValue(objRememberedValue2);
            }
            mutableState = (MutableState) objRememberedValue2;
            context = (Context) gapComposer2.consume(AndroidCompositionLocals_androidKt.LocalContext);
            if (((String) UtilsKt.rememberPreference(PreferenceKeysKt.InnerTubeCookieKey, "", gapComposer2, 48).$state.getValue()).length() > 0) {
                z6 = true;
            } else {
                z6 = false;
            }
            String strStringResource16 = MathKt.stringResource(R.string.not_logged_in_youtube, gapComposer2);
            String strStringResource17 = MathKt.stringResource(R.string.sync_disabled, gapComposer2);
            strStringResource = MathKt.stringResource(R.string.playlist_created_locally, gapComposer2);
            boolean z16 = z6;
            TextFieldValue textFieldValue8 = new TextFieldValue(6, 0L, str2 != null ? str2 : "");
            boolean zChangedInstance8 = gapComposer2.changedInstance(syncUtils) | gapComposer2.changedInstance(context) | gapComposer2.changed(strStringResource);
            if ((i3 & 7168) == 2048) {
                z7 = true;
            } else {
                z7 = false;
            }
            z8 = zChangedInstance8 | z7;
            objRememberedValue3 = gapComposer2.rememberedValue();
            if (z8) {
                objRememberedValue3 = new AlbumMenuKt$$ExternalSyntheticLambda40(syncUtils, mutableState, context, strStringResource, function4);
                context2 = context;
                gapComposer2.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new AlbumMenuKt$$ExternalSyntheticLambda40(syncUtils, mutableState, context, strStringResource, function4);
                context2 = context;
                gapComposer2.updateRememberedValue(objRememberedValue3);
            }
            z4 = z5;
            gapComposer = gapComposer2;
            m1470TextFieldDialog5RwOfIE(null, f12lambda$1173103151, f25lambda$1875698990, textFieldValue8, false, false, 0, null, 0, (Function1) objRememberedValue3, null, null, null, function0, false, Expect_jvmKt.rememberComposableLambda(-327759315, new IconButtonKt$$ExternalSyntheticLambda5(z5, coroutineScope8, context2, z16, strStringResource16, strStringResource17, mutableState), gapComposer2), gapComposer, 432, ((i3 << 12) & 57344) | 1572864, 48113);
            str3 = str2;
            function3 = function4;
        } else {
            gapComposer = gapComposer2;
            gapComposer.skipToGroupEnd();
            str3 = str2;
            z4 = z2;
            function3 = function2;
        }
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ItemsKt$$ExternalSyntheticLambda25(function0, str3, z4, function3, i, i2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0040  */
    /* JADX WARN: Code duplicated, block: B:25:0x0045  */
    /* JADX WARN: Code duplicated, block: B:27:0x0049  */
    /* JADX WARN: Code duplicated, block: B:29:0x0051  */
    /* JADX WARN: Code duplicated, block: B:30:0x0054  */
    /* JADX WARN: Code duplicated, block: B:34:0x005b  */
    /* JADX WARN: Code duplicated, block: B:36:0x0060  */
    /* JADX WARN: Code duplicated, block: B:38:0x0064  */
    /* JADX WARN: Code duplicated, block: B:40:0x006c  */
    /* JADX WARN: Code duplicated, block: B:41:0x006f  */
    /* JADX WARN: Code duplicated, block: B:45:0x0076  */
    /* JADX WARN: Code duplicated, block: B:47:0x007b  */
    /* JADX WARN: Code duplicated, block: B:49:0x007f  */
    /* JADX WARN: Code duplicated, block: B:51:0x0087  */
    /* JADX WARN: Code duplicated, block: B:52:0x008a  */
    /* JADX WARN: Code duplicated, block: B:56:0x0093  */
    /* JADX WARN: Code duplicated, block: B:58:0x0097  */
    /* JADX WARN: Code duplicated, block: B:60:0x009a  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:63:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:67:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:69:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:70:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:72:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:75:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:76:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:79:0x00d4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:80:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:81:0x00db  */
    /* JADX WARN: Code duplicated, block: B:84:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:85:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:87:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:88:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:90:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:91:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:93:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:94:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:96:0x0124  */
    /* JADX WARN: Code duplicated, block: B:99:0x0132  */
    public static final void DefaultDialog(Function0 function0, Modifier modifier, Function2 function2, Function2 function3, Function3 function4, Alignment.Horizontal horizontal, ComposableLambdaImpl composableLambdaImpl, Composer composer, int i, int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        Function2 function5;
        int i5;
        int i6;
        Function2 function6;
        int i7;
        int i8;
        Function3 function7;
        int i9;
        int i10;
        Alignment.Horizontal horizontal2;
        int i11;
        ComposableLambdaImpl composableLambdaImpl2;
        int i12;
        boolean z;
        Modifier modifier3;
        Function2 function8;
        Function2 function9;
        Function3 function10;
        Alignment.Horizontal horizontal3;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        Modifier modifier4;
        Function2 function11;
        Function2 function12;
        Function3 function13;
        Alignment.Horizontal horizontal4;
        int i13;
        function0.getClass();
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(1942361696);
        if ((i & 6) == 0) {
            i3 = (gapComposer.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i14 = i2 & 2;
        if (i14 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= gapComposer.changed(modifier2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    function5 = function2;
                    if (gapComposer.changedInstance(function5)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    if ((i & 3072) == 0) {
                        function6 = function3;
                        if (gapComposer.changedInstance(function6)) {
                            i7 = 2048;
                        } else {
                            i7 = 1024;
                        }
                        i3 |= i7;
                    }
                    i8 = i2 & 16;
                    if (i8 != 0) {
                        if ((i & 24576) == 0) {
                            function7 = function4;
                            if (gapComposer.changedInstance(function7)) {
                                i9 = 16384;
                            } else {
                                i9 = 8192;
                            }
                            i3 |= i9;
                        }
                        i10 = i2 & 32;
                        if (i10 != 0) {
                            if ((196608 & i) == 0) {
                                horizontal2 = horizontal;
                                if (gapComposer.changed(horizontal2)) {
                                    i11 = 131072;
                                } else {
                                    i11 = 65536;
                                }
                                i3 |= i11;
                            }
                            if ((1572864 & i) == 0) {
                                composableLambdaImpl2 = composableLambdaImpl;
                                if (gapComposer.changedInstance(composableLambdaImpl2)) {
                                    i13 = ByteChannelKt.CHANNEL_MAX_SIZE;
                                } else {
                                    i13 = 524288;
                                }
                                i3 |= i13;
                            } else {
                                composableLambdaImpl2 = composableLambdaImpl;
                            }
                            i12 = i3;
                            if ((599187 & i3) != 599186) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (gapComposer.shouldExecute(i12 & 1, z)) {
                                if (i14 != 0) {
                                    modifier4 = Modifier.Companion.$$INSTANCE;
                                } else {
                                    modifier4 = modifier2;
                                }
                                if (i4 != 0) {
                                    function11 = null;
                                } else {
                                    function11 = function5;
                                }
                                if (i6 != 0) {
                                    function12 = null;
                                } else {
                                    function12 = function6;
                                }
                                if (i8 != 0) {
                                    function13 = null;
                                } else {
                                    function13 = function7;
                                }
                                if (i10 != 0) {
                                    horizontal4 = Alignment.Companion.CenterHorizontally;
                                } else {
                                    horizontal4 = horizontal2;
                                }
                                AndroidDialog_androidKt.Dialog(function0, new DialogProperties(3), Expect_jvmKt.rememberComposableLambda(-472271511, new DialogKt$$ExternalSyntheticLambda7(modifier4, horizontal4, function11, function12, composableLambdaImpl2, function13, (byte) 0), gapComposer), gapComposer, (i12 & 14) | 432);
                                modifier3 = modifier4;
                                horizontal3 = horizontal4;
                                function8 = function11;
                                function9 = function12;
                                function10 = function13;
                            } else {
                                gapComposer.skipToGroupEnd();
                                modifier3 = modifier2;
                                function8 = function5;
                                function9 = function6;
                                function10 = function7;
                                horizontal3 = horizontal2;
                            }
                            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                            if (recomposeScopeImplEndRestartGroup != null) {
                                recomposeScopeImplEndRestartGroup.block = new DialogKt$$ExternalSyntheticLambda6(function0, modifier3, function8, function9, function10, horizontal3, composableLambdaImpl, i, i2);
                            }
                        }
                        i3 |= 196608;
                        horizontal2 = horizontal;
                        if ((1572864 & i) == 0) {
                            composableLambdaImpl2 = composableLambdaImpl;
                            if (gapComposer.changedInstance(composableLambdaImpl2)) {
                                i13 = ByteChannelKt.CHANNEL_MAX_SIZE;
                            } else {
                                i13 = 524288;
                            }
                            i3 |= i13;
                        } else {
                            composableLambdaImpl2 = composableLambdaImpl;
                        }
                        i12 = i3;
                        if ((599187 & i3) != 599186) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (gapComposer.shouldExecute(i12 & 1, z)) {
                            if (i14 != 0) {
                                modifier4 = Modifier.Companion.$$INSTANCE;
                            } else {
                                modifier4 = modifier2;
                            }
                            if (i4 != 0) {
                                function11 = null;
                            } else {
                                function11 = function5;
                            }
                            if (i6 != 0) {
                                function12 = null;
                            } else {
                                function12 = function6;
                            }
                            if (i8 != 0) {
                                function13 = null;
                            } else {
                                function13 = function7;
                            }
                            if (i10 != 0) {
                                horizontal4 = Alignment.Companion.CenterHorizontally;
                            } else {
                                horizontal4 = horizontal2;
                            }
                            AndroidDialog_androidKt.Dialog(function0, new DialogProperties(3), Expect_jvmKt.rememberComposableLambda(-472271511, new DialogKt$$ExternalSyntheticLambda7(modifier4, horizontal4, function11, function12, composableLambdaImpl2, function13, (byte) 0), gapComposer), gapComposer, (i12 & 14) | 432);
                            modifier3 = modifier4;
                            horizontal3 = horizontal4;
                            function8 = function11;
                            function9 = function12;
                            function10 = function13;
                        } else {
                            gapComposer.skipToGroupEnd();
                            modifier3 = modifier2;
                            function8 = function5;
                            function9 = function6;
                            function10 = function7;
                            horizontal3 = horizontal2;
                        }
                        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                        if (recomposeScopeImplEndRestartGroup != null) {
                            recomposeScopeImplEndRestartGroup.block = new DialogKt$$ExternalSyntheticLambda6(function0, modifier3, function8, function9, function10, horizontal3, composableLambdaImpl, i, i2);
                        }
                    }
                    i3 |= 24576;
                    function7 = function4;
                    i10 = i2 & 32;
                    if (i10 != 0) {
                        if ((196608 & i) == 0) {
                            horizontal2 = horizontal;
                            if (gapComposer.changed(horizontal2)) {
                                i11 = 131072;
                            } else {
                                i11 = 65536;
                            }
                            i3 |= i11;
                        }
                        if ((1572864 & i) == 0) {
                            composableLambdaImpl2 = composableLambdaImpl;
                            if (gapComposer.changedInstance(composableLambdaImpl2)) {
                                i13 = ByteChannelKt.CHANNEL_MAX_SIZE;
                            } else {
                                i13 = 524288;
                            }
                            i3 |= i13;
                        } else {
                            composableLambdaImpl2 = composableLambdaImpl;
                        }
                        i12 = i3;
                        if ((599187 & i3) != 599186) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (gapComposer.shouldExecute(i12 & 1, z)) {
                            if (i14 != 0) {
                                modifier4 = Modifier.Companion.$$INSTANCE;
                            } else {
                                modifier4 = modifier2;
                            }
                            if (i4 != 0) {
                                function11 = null;
                            } else {
                                function11 = function5;
                            }
                            if (i6 != 0) {
                                function12 = null;
                            } else {
                                function12 = function6;
                            }
                            if (i8 != 0) {
                                function13 = null;
                            } else {
                                function13 = function7;
                            }
                            if (i10 != 0) {
                                horizontal4 = Alignment.Companion.CenterHorizontally;
                            } else {
                                horizontal4 = horizontal2;
                            }
                            AndroidDialog_androidKt.Dialog(function0, new DialogProperties(3), Expect_jvmKt.rememberComposableLambda(-472271511, new DialogKt$$ExternalSyntheticLambda7(modifier4, horizontal4, function11, function12, composableLambdaImpl2, function13, (byte) 0), gapComposer), gapComposer, (i12 & 14) | 432);
                            modifier3 = modifier4;
                            horizontal3 = horizontal4;
                            function8 = function11;
                            function9 = function12;
                            function10 = function13;
                        } else {
                            gapComposer.skipToGroupEnd();
                            modifier3 = modifier2;
                            function8 = function5;
                            function9 = function6;
                            function10 = function7;
                            horizontal3 = horizontal2;
                        }
                        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                        if (recomposeScopeImplEndRestartGroup != null) {
                            recomposeScopeImplEndRestartGroup.block = new DialogKt$$ExternalSyntheticLambda6(function0, modifier3, function8, function9, function10, horizontal3, composableLambdaImpl, i, i2);
                        }
                    }
                    i3 |= 196608;
                    horizontal2 = horizontal;
                    if ((1572864 & i) == 0) {
                        composableLambdaImpl2 = composableLambdaImpl;
                        if (gapComposer.changedInstance(composableLambdaImpl2)) {
                            i13 = ByteChannelKt.CHANNEL_MAX_SIZE;
                        } else {
                            i13 = 524288;
                        }
                        i3 |= i13;
                    } else {
                        composableLambdaImpl2 = composableLambdaImpl;
                    }
                    i12 = i3;
                    if ((599187 & i3) != 599186) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (gapComposer.shouldExecute(i12 & 1, z)) {
                        if (i14 != 0) {
                            modifier4 = Modifier.Companion.$$INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i4 != 0) {
                            function11 = null;
                        } else {
                            function11 = function5;
                        }
                        if (i6 != 0) {
                            function12 = null;
                        } else {
                            function12 = function6;
                        }
                        if (i8 != 0) {
                            function13 = null;
                        } else {
                            function13 = function7;
                        }
                        if (i10 != 0) {
                            horizontal4 = Alignment.Companion.CenterHorizontally;
                        } else {
                            horizontal4 = horizontal2;
                        }
                        AndroidDialog_androidKt.Dialog(function0, new DialogProperties(3), Expect_jvmKt.rememberComposableLambda(-472271511, new DialogKt$$ExternalSyntheticLambda7(modifier4, horizontal4, function11, function12, composableLambdaImpl2, function13, (byte) 0), gapComposer), gapComposer, (i12 & 14) | 432);
                        modifier3 = modifier4;
                        horizontal3 = horizontal4;
                        function8 = function11;
                        function9 = function12;
                        function10 = function13;
                    } else {
                        gapComposer.skipToGroupEnd();
                        modifier3 = modifier2;
                        function8 = function5;
                        function9 = function6;
                        function10 = function7;
                        horizontal3 = horizontal2;
                    }
                    recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                    if (recomposeScopeImplEndRestartGroup != null) {
                        recomposeScopeImplEndRestartGroup.block = new DialogKt$$ExternalSyntheticLambda6(function0, modifier3, function8, function9, function10, horizontal3, composableLambdaImpl, i, i2);
                    }
                }
                i3 |= 3072;
                function6 = function3;
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((i & 24576) == 0) {
                        function7 = function4;
                        if (gapComposer.changedInstance(function7)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    i10 = i2 & 32;
                    if (i10 != 0) {
                        if ((196608 & i) == 0) {
                            horizontal2 = horizontal;
                            if (gapComposer.changed(horizontal2)) {
                                i11 = 131072;
                            } else {
                                i11 = 65536;
                            }
                            i3 |= i11;
                        }
                        if ((1572864 & i) == 0) {
                            composableLambdaImpl2 = composableLambdaImpl;
                            if (gapComposer.changedInstance(composableLambdaImpl2)) {
                                i13 = ByteChannelKt.CHANNEL_MAX_SIZE;
                            } else {
                                i13 = 524288;
                            }
                            i3 |= i13;
                        } else {
                            composableLambdaImpl2 = composableLambdaImpl;
                        }
                        i12 = i3;
                        if ((599187 & i3) != 599186) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (gapComposer.shouldExecute(i12 & 1, z)) {
                            if (i14 != 0) {
                                modifier4 = Modifier.Companion.$$INSTANCE;
                            } else {
                                modifier4 = modifier2;
                            }
                            if (i4 != 0) {
                                function11 = null;
                            } else {
                                function11 = function5;
                            }
                            if (i6 != 0) {
                                function12 = null;
                            } else {
                                function12 = function6;
                            }
                            if (i8 != 0) {
                                function13 = null;
                            } else {
                                function13 = function7;
                            }
                            if (i10 != 0) {
                                horizontal4 = Alignment.Companion.CenterHorizontally;
                            } else {
                                horizontal4 = horizontal2;
                            }
                            AndroidDialog_androidKt.Dialog(function0, new DialogProperties(3), Expect_jvmKt.rememberComposableLambda(-472271511, new DialogKt$$ExternalSyntheticLambda7(modifier4, horizontal4, function11, function12, composableLambdaImpl2, function13, (byte) 0), gapComposer), gapComposer, (i12 & 14) | 432);
                            modifier3 = modifier4;
                            horizontal3 = horizontal4;
                            function8 = function11;
                            function9 = function12;
                            function10 = function13;
                        } else {
                            gapComposer.skipToGroupEnd();
                            modifier3 = modifier2;
                            function8 = function5;
                            function9 = function6;
                            function10 = function7;
                            horizontal3 = horizontal2;
                        }
                        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                        if (recomposeScopeImplEndRestartGroup != null) {
                            recomposeScopeImplEndRestartGroup.block = new DialogKt$$ExternalSyntheticLambda6(function0, modifier3, function8, function9, function10, horizontal3, composableLambdaImpl, i, i2);
                        }
                    }
                    i3 |= 196608;
                    horizontal2 = horizontal;
                    if ((1572864 & i) == 0) {
                        composableLambdaImpl2 = composableLambdaImpl;
                        if (gapComposer.changedInstance(composableLambdaImpl2)) {
                            i13 = ByteChannelKt.CHANNEL_MAX_SIZE;
                        } else {
                            i13 = 524288;
                        }
                        i3 |= i13;
                    } else {
                        composableLambdaImpl2 = composableLambdaImpl;
                    }
                    i12 = i3;
                    if ((599187 & i3) != 599186) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (gapComposer.shouldExecute(i12 & 1, z)) {
                        if (i14 != 0) {
                            modifier4 = Modifier.Companion.$$INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i4 != 0) {
                            function11 = null;
                        } else {
                            function11 = function5;
                        }
                        if (i6 != 0) {
                            function12 = null;
                        } else {
                            function12 = function6;
                        }
                        if (i8 != 0) {
                            function13 = null;
                        } else {
                            function13 = function7;
                        }
                        if (i10 != 0) {
                            horizontal4 = Alignment.Companion.CenterHorizontally;
                        } else {
                            horizontal4 = horizontal2;
                        }
                        AndroidDialog_androidKt.Dialog(function0, new DialogProperties(3), Expect_jvmKt.rememberComposableLambda(-472271511, new DialogKt$$ExternalSyntheticLambda7(modifier4, horizontal4, function11, function12, composableLambdaImpl2, function13, (byte) 0), gapComposer), gapComposer, (i12 & 14) | 432);
                        modifier3 = modifier4;
                        horizontal3 = horizontal4;
                        function8 = function11;
                        function9 = function12;
                        function10 = function13;
                    } else {
                        gapComposer.skipToGroupEnd();
                        modifier3 = modifier2;
                        function8 = function5;
                        function9 = function6;
                        function10 = function7;
                        horizontal3 = horizontal2;
                    }
                    recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                    if (recomposeScopeImplEndRestartGroup != null) {
                        recomposeScopeImplEndRestartGroup.block = new DialogKt$$ExternalSyntheticLambda6(function0, modifier3, function8, function9, function10, horizontal3, composableLambdaImpl, i, i2);
                    }
                }
                i3 |= 24576;
                function7 = function4;
                i10 = i2 & 32;
                if (i10 != 0) {
                    if ((196608 & i) == 0) {
                        horizontal2 = horizontal;
                        if (gapComposer.changed(horizontal2)) {
                            i11 = 131072;
                        } else {
                            i11 = 65536;
                        }
                        i3 |= i11;
                    }
                    if ((1572864 & i) == 0) {
                        composableLambdaImpl2 = composableLambdaImpl;
                        if (gapComposer.changedInstance(composableLambdaImpl2)) {
                            i13 = ByteChannelKt.CHANNEL_MAX_SIZE;
                        } else {
                            i13 = 524288;
                        }
                        i3 |= i13;
                    } else {
                        composableLambdaImpl2 = composableLambdaImpl;
                    }
                    i12 = i3;
                    if ((599187 & i3) != 599186) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (gapComposer.shouldExecute(i12 & 1, z)) {
                        if (i14 != 0) {
                            modifier4 = Modifier.Companion.$$INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i4 != 0) {
                            function11 = null;
                        } else {
                            function11 = function5;
                        }
                        if (i6 != 0) {
                            function12 = null;
                        } else {
                            function12 = function6;
                        }
                        if (i8 != 0) {
                            function13 = null;
                        } else {
                            function13 = function7;
                        }
                        if (i10 != 0) {
                            horizontal4 = Alignment.Companion.CenterHorizontally;
                        } else {
                            horizontal4 = horizontal2;
                        }
                        AndroidDialog_androidKt.Dialog(function0, new DialogProperties(3), Expect_jvmKt.rememberComposableLambda(-472271511, new DialogKt$$ExternalSyntheticLambda7(modifier4, horizontal4, function11, function12, composableLambdaImpl2, function13, (byte) 0), gapComposer), gapComposer, (i12 & 14) | 432);
                        modifier3 = modifier4;
                        horizontal3 = horizontal4;
                        function8 = function11;
                        function9 = function12;
                        function10 = function13;
                    } else {
                        gapComposer.skipToGroupEnd();
                        modifier3 = modifier2;
                        function8 = function5;
                        function9 = function6;
                        function10 = function7;
                        horizontal3 = horizontal2;
                    }
                    recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                    if (recomposeScopeImplEndRestartGroup != null) {
                        recomposeScopeImplEndRestartGroup.block = new DialogKt$$ExternalSyntheticLambda6(function0, modifier3, function8, function9, function10, horizontal3, composableLambdaImpl, i, i2);
                    }
                }
                i3 |= 196608;
                horizontal2 = horizontal;
                if ((1572864 & i) == 0) {
                    composableLambdaImpl2 = composableLambdaImpl;
                    if (gapComposer.changedInstance(composableLambdaImpl2)) {
                        i13 = ByteChannelKt.CHANNEL_MAX_SIZE;
                    } else {
                        i13 = 524288;
                    }
                    i3 |= i13;
                } else {
                    composableLambdaImpl2 = composableLambdaImpl;
                }
                i12 = i3;
                if ((599187 & i3) != 599186) {
                    z = true;
                } else {
                    z = false;
                }
                if (gapComposer.shouldExecute(i12 & 1, z)) {
                    if (i14 != 0) {
                        modifier4 = Modifier.Companion.$$INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        function11 = null;
                    } else {
                        function11 = function5;
                    }
                    if (i6 != 0) {
                        function12 = null;
                    } else {
                        function12 = function6;
                    }
                    if (i8 != 0) {
                        function13 = null;
                    } else {
                        function13 = function7;
                    }
                    if (i10 != 0) {
                        horizontal4 = Alignment.Companion.CenterHorizontally;
                    } else {
                        horizontal4 = horizontal2;
                    }
                    AndroidDialog_androidKt.Dialog(function0, new DialogProperties(3), Expect_jvmKt.rememberComposableLambda(-472271511, new DialogKt$$ExternalSyntheticLambda7(modifier4, horizontal4, function11, function12, composableLambdaImpl2, function13, (byte) 0), gapComposer), gapComposer, (i12 & 14) | 432);
                    modifier3 = modifier4;
                    horizontal3 = horizontal4;
                    function8 = function11;
                    function9 = function12;
                    function10 = function13;
                } else {
                    gapComposer.skipToGroupEnd();
                    modifier3 = modifier2;
                    function8 = function5;
                    function9 = function6;
                    function10 = function7;
                    horizontal3 = horizontal2;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new DialogKt$$ExternalSyntheticLambda6(function0, modifier3, function8, function9, function10, horizontal3, composableLambdaImpl, i, i2);
                }
            }
            i3 |= 384;
            function5 = function2;
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 3072) == 0) {
                    function6 = function3;
                    if (gapComposer.changedInstance(function6)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((i & 24576) == 0) {
                        function7 = function4;
                        if (gapComposer.changedInstance(function7)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    i10 = i2 & 32;
                    if (i10 != 0) {
                        if ((196608 & i) == 0) {
                            horizontal2 = horizontal;
                            if (gapComposer.changed(horizontal2)) {
                                i11 = 131072;
                            } else {
                                i11 = 65536;
                            }
                            i3 |= i11;
                        }
                        if ((1572864 & i) == 0) {
                            composableLambdaImpl2 = composableLambdaImpl;
                            if (gapComposer.changedInstance(composableLambdaImpl2)) {
                                i13 = ByteChannelKt.CHANNEL_MAX_SIZE;
                            } else {
                                i13 = 524288;
                            }
                            i3 |= i13;
                        } else {
                            composableLambdaImpl2 = composableLambdaImpl;
                        }
                        i12 = i3;
                        if ((599187 & i3) != 599186) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (gapComposer.shouldExecute(i12 & 1, z)) {
                            if (i14 != 0) {
                                modifier4 = Modifier.Companion.$$INSTANCE;
                            } else {
                                modifier4 = modifier2;
                            }
                            if (i4 != 0) {
                                function11 = null;
                            } else {
                                function11 = function5;
                            }
                            if (i6 != 0) {
                                function12 = null;
                            } else {
                                function12 = function6;
                            }
                            if (i8 != 0) {
                                function13 = null;
                            } else {
                                function13 = function7;
                            }
                            if (i10 != 0) {
                                horizontal4 = Alignment.Companion.CenterHorizontally;
                            } else {
                                horizontal4 = horizontal2;
                            }
                            AndroidDialog_androidKt.Dialog(function0, new DialogProperties(3), Expect_jvmKt.rememberComposableLambda(-472271511, new DialogKt$$ExternalSyntheticLambda7(modifier4, horizontal4, function11, function12, composableLambdaImpl2, function13, (byte) 0), gapComposer), gapComposer, (i12 & 14) | 432);
                            modifier3 = modifier4;
                            horizontal3 = horizontal4;
                            function8 = function11;
                            function9 = function12;
                            function10 = function13;
                        } else {
                            gapComposer.skipToGroupEnd();
                            modifier3 = modifier2;
                            function8 = function5;
                            function9 = function6;
                            function10 = function7;
                            horizontal3 = horizontal2;
                        }
                        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                        if (recomposeScopeImplEndRestartGroup != null) {
                            recomposeScopeImplEndRestartGroup.block = new DialogKt$$ExternalSyntheticLambda6(function0, modifier3, function8, function9, function10, horizontal3, composableLambdaImpl, i, i2);
                        }
                    }
                    i3 |= 196608;
                    horizontal2 = horizontal;
                    if ((1572864 & i) == 0) {
                        composableLambdaImpl2 = composableLambdaImpl;
                        if (gapComposer.changedInstance(composableLambdaImpl2)) {
                            i13 = ByteChannelKt.CHANNEL_MAX_SIZE;
                        } else {
                            i13 = 524288;
                        }
                        i3 |= i13;
                    } else {
                        composableLambdaImpl2 = composableLambdaImpl;
                    }
                    i12 = i3;
                    if ((599187 & i3) != 599186) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (gapComposer.shouldExecute(i12 & 1, z)) {
                        if (i14 != 0) {
                            modifier4 = Modifier.Companion.$$INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i4 != 0) {
                            function11 = null;
                        } else {
                            function11 = function5;
                        }
                        if (i6 != 0) {
                            function12 = null;
                        } else {
                            function12 = function6;
                        }
                        if (i8 != 0) {
                            function13 = null;
                        } else {
                            function13 = function7;
                        }
                        if (i10 != 0) {
                            horizontal4 = Alignment.Companion.CenterHorizontally;
                        } else {
                            horizontal4 = horizontal2;
                        }
                        AndroidDialog_androidKt.Dialog(function0, new DialogProperties(3), Expect_jvmKt.rememberComposableLambda(-472271511, new DialogKt$$ExternalSyntheticLambda7(modifier4, horizontal4, function11, function12, composableLambdaImpl2, function13, (byte) 0), gapComposer), gapComposer, (i12 & 14) | 432);
                        modifier3 = modifier4;
                        horizontal3 = horizontal4;
                        function8 = function11;
                        function9 = function12;
                        function10 = function13;
                    } else {
                        gapComposer.skipToGroupEnd();
                        modifier3 = modifier2;
                        function8 = function5;
                        function9 = function6;
                        function10 = function7;
                        horizontal3 = horizontal2;
                    }
                    recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                    if (recomposeScopeImplEndRestartGroup != null) {
                        recomposeScopeImplEndRestartGroup.block = new DialogKt$$ExternalSyntheticLambda6(function0, modifier3, function8, function9, function10, horizontal3, composableLambdaImpl, i, i2);
                    }
                }
                i3 |= 24576;
                function7 = function4;
                i10 = i2 & 32;
                if (i10 != 0) {
                    if ((196608 & i) == 0) {
                        horizontal2 = horizontal;
                        if (gapComposer.changed(horizontal2)) {
                            i11 = 131072;
                        } else {
                            i11 = 65536;
                        }
                        i3 |= i11;
                    }
                    if ((1572864 & i) == 0) {
                        composableLambdaImpl2 = composableLambdaImpl;
                        if (gapComposer.changedInstance(composableLambdaImpl2)) {
                            i13 = ByteChannelKt.CHANNEL_MAX_SIZE;
                        } else {
                            i13 = 524288;
                        }
                        i3 |= i13;
                    } else {
                        composableLambdaImpl2 = composableLambdaImpl;
                    }
                    i12 = i3;
                    if ((599187 & i3) != 599186) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (gapComposer.shouldExecute(i12 & 1, z)) {
                        if (i14 != 0) {
                            modifier4 = Modifier.Companion.$$INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i4 != 0) {
                            function11 = null;
                        } else {
                            function11 = function5;
                        }
                        if (i6 != 0) {
                            function12 = null;
                        } else {
                            function12 = function6;
                        }
                        if (i8 != 0) {
                            function13 = null;
                        } else {
                            function13 = function7;
                        }
                        if (i10 != 0) {
                            horizontal4 = Alignment.Companion.CenterHorizontally;
                        } else {
                            horizontal4 = horizontal2;
                        }
                        AndroidDialog_androidKt.Dialog(function0, new DialogProperties(3), Expect_jvmKt.rememberComposableLambda(-472271511, new DialogKt$$ExternalSyntheticLambda7(modifier4, horizontal4, function11, function12, composableLambdaImpl2, function13, (byte) 0), gapComposer), gapComposer, (i12 & 14) | 432);
                        modifier3 = modifier4;
                        horizontal3 = horizontal4;
                        function8 = function11;
                        function9 = function12;
                        function10 = function13;
                    } else {
                        gapComposer.skipToGroupEnd();
                        modifier3 = modifier2;
                        function8 = function5;
                        function9 = function6;
                        function10 = function7;
                        horizontal3 = horizontal2;
                    }
                    recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                    if (recomposeScopeImplEndRestartGroup != null) {
                        recomposeScopeImplEndRestartGroup.block = new DialogKt$$ExternalSyntheticLambda6(function0, modifier3, function8, function9, function10, horizontal3, composableLambdaImpl, i, i2);
                    }
                }
                i3 |= 196608;
                horizontal2 = horizontal;
                if ((1572864 & i) == 0) {
                    composableLambdaImpl2 = composableLambdaImpl;
                    if (gapComposer.changedInstance(composableLambdaImpl2)) {
                        i13 = ByteChannelKt.CHANNEL_MAX_SIZE;
                    } else {
                        i13 = 524288;
                    }
                    i3 |= i13;
                } else {
                    composableLambdaImpl2 = composableLambdaImpl;
                }
                i12 = i3;
                if ((599187 & i3) != 599186) {
                    z = true;
                } else {
                    z = false;
                }
                if (gapComposer.shouldExecute(i12 & 1, z)) {
                    if (i14 != 0) {
                        modifier4 = Modifier.Companion.$$INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        function11 = null;
                    } else {
                        function11 = function5;
                    }
                    if (i6 != 0) {
                        function12 = null;
                    } else {
                        function12 = function6;
                    }
                    if (i8 != 0) {
                        function13 = null;
                    } else {
                        function13 = function7;
                    }
                    if (i10 != 0) {
                        horizontal4 = Alignment.Companion.CenterHorizontally;
                    } else {
                        horizontal4 = horizontal2;
                    }
                    AndroidDialog_androidKt.Dialog(function0, new DialogProperties(3), Expect_jvmKt.rememberComposableLambda(-472271511, new DialogKt$$ExternalSyntheticLambda7(modifier4, horizontal4, function11, function12, composableLambdaImpl2, function13, (byte) 0), gapComposer), gapComposer, (i12 & 14) | 432);
                    modifier3 = modifier4;
                    horizontal3 = horizontal4;
                    function8 = function11;
                    function9 = function12;
                    function10 = function13;
                } else {
                    gapComposer.skipToGroupEnd();
                    modifier3 = modifier2;
                    function8 = function5;
                    function9 = function6;
                    function10 = function7;
                    horizontal3 = horizontal2;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new DialogKt$$ExternalSyntheticLambda6(function0, modifier3, function8, function9, function10, horizontal3, composableLambdaImpl, i, i2);
                }
            }
            i3 |= 3072;
            function6 = function3;
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((i & 24576) == 0) {
                    function7 = function4;
                    if (gapComposer.changedInstance(function7)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                i10 = i2 & 32;
                if (i10 != 0) {
                    if ((196608 & i) == 0) {
                        horizontal2 = horizontal;
                        if (gapComposer.changed(horizontal2)) {
                            i11 = 131072;
                        } else {
                            i11 = 65536;
                        }
                        i3 |= i11;
                    }
                    if ((1572864 & i) == 0) {
                        composableLambdaImpl2 = composableLambdaImpl;
                        if (gapComposer.changedInstance(composableLambdaImpl2)) {
                            i13 = ByteChannelKt.CHANNEL_MAX_SIZE;
                        } else {
                            i13 = 524288;
                        }
                        i3 |= i13;
                    } else {
                        composableLambdaImpl2 = composableLambdaImpl;
                    }
                    i12 = i3;
                    if ((599187 & i3) != 599186) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (gapComposer.shouldExecute(i12 & 1, z)) {
                        if (i14 != 0) {
                            modifier4 = Modifier.Companion.$$INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i4 != 0) {
                            function11 = null;
                        } else {
                            function11 = function5;
                        }
                        if (i6 != 0) {
                            function12 = null;
                        } else {
                            function12 = function6;
                        }
                        if (i8 != 0) {
                            function13 = null;
                        } else {
                            function13 = function7;
                        }
                        if (i10 != 0) {
                            horizontal4 = Alignment.Companion.CenterHorizontally;
                        } else {
                            horizontal4 = horizontal2;
                        }
                        AndroidDialog_androidKt.Dialog(function0, new DialogProperties(3), Expect_jvmKt.rememberComposableLambda(-472271511, new DialogKt$$ExternalSyntheticLambda7(modifier4, horizontal4, function11, function12, composableLambdaImpl2, function13, (byte) 0), gapComposer), gapComposer, (i12 & 14) | 432);
                        modifier3 = modifier4;
                        horizontal3 = horizontal4;
                        function8 = function11;
                        function9 = function12;
                        function10 = function13;
                    } else {
                        gapComposer.skipToGroupEnd();
                        modifier3 = modifier2;
                        function8 = function5;
                        function9 = function6;
                        function10 = function7;
                        horizontal3 = horizontal2;
                    }
                    recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                    if (recomposeScopeImplEndRestartGroup != null) {
                        recomposeScopeImplEndRestartGroup.block = new DialogKt$$ExternalSyntheticLambda6(function0, modifier3, function8, function9, function10, horizontal3, composableLambdaImpl, i, i2);
                    }
                }
                i3 |= 196608;
                horizontal2 = horizontal;
                if ((1572864 & i) == 0) {
                    composableLambdaImpl2 = composableLambdaImpl;
                    if (gapComposer.changedInstance(composableLambdaImpl2)) {
                        i13 = ByteChannelKt.CHANNEL_MAX_SIZE;
                    } else {
                        i13 = 524288;
                    }
                    i3 |= i13;
                } else {
                    composableLambdaImpl2 = composableLambdaImpl;
                }
                i12 = i3;
                if ((599187 & i3) != 599186) {
                    z = true;
                } else {
                    z = false;
                }
                if (gapComposer.shouldExecute(i12 & 1, z)) {
                    if (i14 != 0) {
                        modifier4 = Modifier.Companion.$$INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        function11 = null;
                    } else {
                        function11 = function5;
                    }
                    if (i6 != 0) {
                        function12 = null;
                    } else {
                        function12 = function6;
                    }
                    if (i8 != 0) {
                        function13 = null;
                    } else {
                        function13 = function7;
                    }
                    if (i10 != 0) {
                        horizontal4 = Alignment.Companion.CenterHorizontally;
                    } else {
                        horizontal4 = horizontal2;
                    }
                    AndroidDialog_androidKt.Dialog(function0, new DialogProperties(3), Expect_jvmKt.rememberComposableLambda(-472271511, new DialogKt$$ExternalSyntheticLambda7(modifier4, horizontal4, function11, function12, composableLambdaImpl2, function13, (byte) 0), gapComposer), gapComposer, (i12 & 14) | 432);
                    modifier3 = modifier4;
                    horizontal3 = horizontal4;
                    function8 = function11;
                    function9 = function12;
                    function10 = function13;
                } else {
                    gapComposer.skipToGroupEnd();
                    modifier3 = modifier2;
                    function8 = function5;
                    function9 = function6;
                    function10 = function7;
                    horizontal3 = horizontal2;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new DialogKt$$ExternalSyntheticLambda6(function0, modifier3, function8, function9, function10, horizontal3, composableLambdaImpl, i, i2);
                }
            }
            i3 |= 24576;
            function7 = function4;
            i10 = i2 & 32;
            if (i10 != 0) {
                if ((196608 & i) == 0) {
                    horizontal2 = horizontal;
                    if (gapComposer.changed(horizontal2)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i3 |= i11;
                }
                if ((1572864 & i) == 0) {
                    composableLambdaImpl2 = composableLambdaImpl;
                    if (gapComposer.changedInstance(composableLambdaImpl2)) {
                        i13 = ByteChannelKt.CHANNEL_MAX_SIZE;
                    } else {
                        i13 = 524288;
                    }
                    i3 |= i13;
                } else {
                    composableLambdaImpl2 = composableLambdaImpl;
                }
                i12 = i3;
                if ((599187 & i3) != 599186) {
                    z = true;
                } else {
                    z = false;
                }
                if (gapComposer.shouldExecute(i12 & 1, z)) {
                    if (i14 != 0) {
                        modifier4 = Modifier.Companion.$$INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        function11 = null;
                    } else {
                        function11 = function5;
                    }
                    if (i6 != 0) {
                        function12 = null;
                    } else {
                        function12 = function6;
                    }
                    if (i8 != 0) {
                        function13 = null;
                    } else {
                        function13 = function7;
                    }
                    if (i10 != 0) {
                        horizontal4 = Alignment.Companion.CenterHorizontally;
                    } else {
                        horizontal4 = horizontal2;
                    }
                    AndroidDialog_androidKt.Dialog(function0, new DialogProperties(3), Expect_jvmKt.rememberComposableLambda(-472271511, new DialogKt$$ExternalSyntheticLambda7(modifier4, horizontal4, function11, function12, composableLambdaImpl2, function13, (byte) 0), gapComposer), gapComposer, (i12 & 14) | 432);
                    modifier3 = modifier4;
                    horizontal3 = horizontal4;
                    function8 = function11;
                    function9 = function12;
                    function10 = function13;
                } else {
                    gapComposer.skipToGroupEnd();
                    modifier3 = modifier2;
                    function8 = function5;
                    function9 = function6;
                    function10 = function7;
                    horizontal3 = horizontal2;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new DialogKt$$ExternalSyntheticLambda6(function0, modifier3, function8, function9, function10, horizontal3, composableLambdaImpl, i, i2);
                }
            }
            i3 |= 196608;
            horizontal2 = horizontal;
            if ((1572864 & i) == 0) {
                composableLambdaImpl2 = composableLambdaImpl;
                if (gapComposer.changedInstance(composableLambdaImpl2)) {
                    i13 = ByteChannelKt.CHANNEL_MAX_SIZE;
                } else {
                    i13 = 524288;
                }
                i3 |= i13;
            } else {
                composableLambdaImpl2 = composableLambdaImpl;
            }
            i12 = i3;
            if ((599187 & i3) != 599186) {
                z = true;
            } else {
                z = false;
            }
            if (gapComposer.shouldExecute(i12 & 1, z)) {
                if (i14 != 0) {
                    modifier4 = Modifier.Companion.$$INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i4 != 0) {
                    function11 = null;
                } else {
                    function11 = function5;
                }
                if (i6 != 0) {
                    function12 = null;
                } else {
                    function12 = function6;
                }
                if (i8 != 0) {
                    function13 = null;
                } else {
                    function13 = function7;
                }
                if (i10 != 0) {
                    horizontal4 = Alignment.Companion.CenterHorizontally;
                } else {
                    horizontal4 = horizontal2;
                }
                AndroidDialog_androidKt.Dialog(function0, new DialogProperties(3), Expect_jvmKt.rememberComposableLambda(-472271511, new DialogKt$$ExternalSyntheticLambda7(modifier4, horizontal4, function11, function12, composableLambdaImpl2, function13, (byte) 0), gapComposer), gapComposer, (i12 & 14) | 432);
                modifier3 = modifier4;
                horizontal3 = horizontal4;
                function8 = function11;
                function9 = function12;
                function10 = function13;
            } else {
                gapComposer.skipToGroupEnd();
                modifier3 = modifier2;
                function8 = function5;
                function9 = function6;
                function10 = function7;
                horizontal3 = horizontal2;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new DialogKt$$ExternalSyntheticLambda6(function0, modifier3, function8, function9, function10, horizontal3, composableLambdaImpl, i, i2);
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 384) == 0) {
                function5 = function2;
                if (gapComposer.changedInstance(function5)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 3072) == 0) {
                    function6 = function3;
                    if (gapComposer.changedInstance(function6)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((i & 24576) == 0) {
                        function7 = function4;
                        if (gapComposer.changedInstance(function7)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    i10 = i2 & 32;
                    if (i10 != 0) {
                        if ((196608 & i) == 0) {
                            horizontal2 = horizontal;
                            if (gapComposer.changed(horizontal2)) {
                                i11 = 131072;
                            } else {
                                i11 = 65536;
                            }
                            i3 |= i11;
                        }
                        if ((1572864 & i) == 0) {
                            composableLambdaImpl2 = composableLambdaImpl;
                            if (gapComposer.changedInstance(composableLambdaImpl2)) {
                                i13 = ByteChannelKt.CHANNEL_MAX_SIZE;
                            } else {
                                i13 = 524288;
                            }
                            i3 |= i13;
                        } else {
                            composableLambdaImpl2 = composableLambdaImpl;
                        }
                        i12 = i3;
                        if ((599187 & i3) != 599186) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (gapComposer.shouldExecute(i12 & 1, z)) {
                            if (i14 != 0) {
                                modifier4 = Modifier.Companion.$$INSTANCE;
                            } else {
                                modifier4 = modifier2;
                            }
                            if (i4 != 0) {
                                function11 = null;
                            } else {
                                function11 = function5;
                            }
                            if (i6 != 0) {
                                function12 = null;
                            } else {
                                function12 = function6;
                            }
                            if (i8 != 0) {
                                function13 = null;
                            } else {
                                function13 = function7;
                            }
                            if (i10 != 0) {
                                horizontal4 = Alignment.Companion.CenterHorizontally;
                            } else {
                                horizontal4 = horizontal2;
                            }
                            AndroidDialog_androidKt.Dialog(function0, new DialogProperties(3), Expect_jvmKt.rememberComposableLambda(-472271511, new DialogKt$$ExternalSyntheticLambda7(modifier4, horizontal4, function11, function12, composableLambdaImpl2, function13, (byte) 0), gapComposer), gapComposer, (i12 & 14) | 432);
                            modifier3 = modifier4;
                            horizontal3 = horizontal4;
                            function8 = function11;
                            function9 = function12;
                            function10 = function13;
                        } else {
                            gapComposer.skipToGroupEnd();
                            modifier3 = modifier2;
                            function8 = function5;
                            function9 = function6;
                            function10 = function7;
                            horizontal3 = horizontal2;
                        }
                        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                        if (recomposeScopeImplEndRestartGroup != null) {
                            recomposeScopeImplEndRestartGroup.block = new DialogKt$$ExternalSyntheticLambda6(function0, modifier3, function8, function9, function10, horizontal3, composableLambdaImpl, i, i2);
                        }
                    }
                    i3 |= 196608;
                    horizontal2 = horizontal;
                    if ((1572864 & i) == 0) {
                        composableLambdaImpl2 = composableLambdaImpl;
                        if (gapComposer.changedInstance(composableLambdaImpl2)) {
                            i13 = ByteChannelKt.CHANNEL_MAX_SIZE;
                        } else {
                            i13 = 524288;
                        }
                        i3 |= i13;
                    } else {
                        composableLambdaImpl2 = composableLambdaImpl;
                    }
                    i12 = i3;
                    if ((599187 & i3) != 599186) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (gapComposer.shouldExecute(i12 & 1, z)) {
                        if (i14 != 0) {
                            modifier4 = Modifier.Companion.$$INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i4 != 0) {
                            function11 = null;
                        } else {
                            function11 = function5;
                        }
                        if (i6 != 0) {
                            function12 = null;
                        } else {
                            function12 = function6;
                        }
                        if (i8 != 0) {
                            function13 = null;
                        } else {
                            function13 = function7;
                        }
                        if (i10 != 0) {
                            horizontal4 = Alignment.Companion.CenterHorizontally;
                        } else {
                            horizontal4 = horizontal2;
                        }
                        AndroidDialog_androidKt.Dialog(function0, new DialogProperties(3), Expect_jvmKt.rememberComposableLambda(-472271511, new DialogKt$$ExternalSyntheticLambda7(modifier4, horizontal4, function11, function12, composableLambdaImpl2, function13, (byte) 0), gapComposer), gapComposer, (i12 & 14) | 432);
                        modifier3 = modifier4;
                        horizontal3 = horizontal4;
                        function8 = function11;
                        function9 = function12;
                        function10 = function13;
                    } else {
                        gapComposer.skipToGroupEnd();
                        modifier3 = modifier2;
                        function8 = function5;
                        function9 = function6;
                        function10 = function7;
                        horizontal3 = horizontal2;
                    }
                    recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                    if (recomposeScopeImplEndRestartGroup != null) {
                        recomposeScopeImplEndRestartGroup.block = new DialogKt$$ExternalSyntheticLambda6(function0, modifier3, function8, function9, function10, horizontal3, composableLambdaImpl, i, i2);
                    }
                }
                i3 |= 24576;
                function7 = function4;
                i10 = i2 & 32;
                if (i10 != 0) {
                    if ((196608 & i) == 0) {
                        horizontal2 = horizontal;
                        if (gapComposer.changed(horizontal2)) {
                            i11 = 131072;
                        } else {
                            i11 = 65536;
                        }
                        i3 |= i11;
                    }
                    if ((1572864 & i) == 0) {
                        composableLambdaImpl2 = composableLambdaImpl;
                        if (gapComposer.changedInstance(composableLambdaImpl2)) {
                            i13 = ByteChannelKt.CHANNEL_MAX_SIZE;
                        } else {
                            i13 = 524288;
                        }
                        i3 |= i13;
                    } else {
                        composableLambdaImpl2 = composableLambdaImpl;
                    }
                    i12 = i3;
                    if ((599187 & i3) != 599186) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (gapComposer.shouldExecute(i12 & 1, z)) {
                        if (i14 != 0) {
                            modifier4 = Modifier.Companion.$$INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i4 != 0) {
                            function11 = null;
                        } else {
                            function11 = function5;
                        }
                        if (i6 != 0) {
                            function12 = null;
                        } else {
                            function12 = function6;
                        }
                        if (i8 != 0) {
                            function13 = null;
                        } else {
                            function13 = function7;
                        }
                        if (i10 != 0) {
                            horizontal4 = Alignment.Companion.CenterHorizontally;
                        } else {
                            horizontal4 = horizontal2;
                        }
                        AndroidDialog_androidKt.Dialog(function0, new DialogProperties(3), Expect_jvmKt.rememberComposableLambda(-472271511, new DialogKt$$ExternalSyntheticLambda7(modifier4, horizontal4, function11, function12, composableLambdaImpl2, function13, (byte) 0), gapComposer), gapComposer, (i12 & 14) | 432);
                        modifier3 = modifier4;
                        horizontal3 = horizontal4;
                        function8 = function11;
                        function9 = function12;
                        function10 = function13;
                    } else {
                        gapComposer.skipToGroupEnd();
                        modifier3 = modifier2;
                        function8 = function5;
                        function9 = function6;
                        function10 = function7;
                        horizontal3 = horizontal2;
                    }
                    recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                    if (recomposeScopeImplEndRestartGroup != null) {
                        recomposeScopeImplEndRestartGroup.block = new DialogKt$$ExternalSyntheticLambda6(function0, modifier3, function8, function9, function10, horizontal3, composableLambdaImpl, i, i2);
                    }
                }
                i3 |= 196608;
                horizontal2 = horizontal;
                if ((1572864 & i) == 0) {
                    composableLambdaImpl2 = composableLambdaImpl;
                    if (gapComposer.changedInstance(composableLambdaImpl2)) {
                        i13 = ByteChannelKt.CHANNEL_MAX_SIZE;
                    } else {
                        i13 = 524288;
                    }
                    i3 |= i13;
                } else {
                    composableLambdaImpl2 = composableLambdaImpl;
                }
                i12 = i3;
                if ((599187 & i3) != 599186) {
                    z = true;
                } else {
                    z = false;
                }
                if (gapComposer.shouldExecute(i12 & 1, z)) {
                    if (i14 != 0) {
                        modifier4 = Modifier.Companion.$$INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        function11 = null;
                    } else {
                        function11 = function5;
                    }
                    if (i6 != 0) {
                        function12 = null;
                    } else {
                        function12 = function6;
                    }
                    if (i8 != 0) {
                        function13 = null;
                    } else {
                        function13 = function7;
                    }
                    if (i10 != 0) {
                        horizontal4 = Alignment.Companion.CenterHorizontally;
                    } else {
                        horizontal4 = horizontal2;
                    }
                    AndroidDialog_androidKt.Dialog(function0, new DialogProperties(3), Expect_jvmKt.rememberComposableLambda(-472271511, new DialogKt$$ExternalSyntheticLambda7(modifier4, horizontal4, function11, function12, composableLambdaImpl2, function13, (byte) 0), gapComposer), gapComposer, (i12 & 14) | 432);
                    modifier3 = modifier4;
                    horizontal3 = horizontal4;
                    function8 = function11;
                    function9 = function12;
                    function10 = function13;
                } else {
                    gapComposer.skipToGroupEnd();
                    modifier3 = modifier2;
                    function8 = function5;
                    function9 = function6;
                    function10 = function7;
                    horizontal3 = horizontal2;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new DialogKt$$ExternalSyntheticLambda6(function0, modifier3, function8, function9, function10, horizontal3, composableLambdaImpl, i, i2);
                }
            }
            i3 |= 3072;
            function6 = function3;
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((i & 24576) == 0) {
                    function7 = function4;
                    if (gapComposer.changedInstance(function7)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                i10 = i2 & 32;
                if (i10 != 0) {
                    if ((196608 & i) == 0) {
                        horizontal2 = horizontal;
                        if (gapComposer.changed(horizontal2)) {
                            i11 = 131072;
                        } else {
                            i11 = 65536;
                        }
                        i3 |= i11;
                    }
                    if ((1572864 & i) == 0) {
                        composableLambdaImpl2 = composableLambdaImpl;
                        if (gapComposer.changedInstance(composableLambdaImpl2)) {
                            i13 = ByteChannelKt.CHANNEL_MAX_SIZE;
                        } else {
                            i13 = 524288;
                        }
                        i3 |= i13;
                    } else {
                        composableLambdaImpl2 = composableLambdaImpl;
                    }
                    i12 = i3;
                    if ((599187 & i3) != 599186) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (gapComposer.shouldExecute(i12 & 1, z)) {
                        if (i14 != 0) {
                            modifier4 = Modifier.Companion.$$INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i4 != 0) {
                            function11 = null;
                        } else {
                            function11 = function5;
                        }
                        if (i6 != 0) {
                            function12 = null;
                        } else {
                            function12 = function6;
                        }
                        if (i8 != 0) {
                            function13 = null;
                        } else {
                            function13 = function7;
                        }
                        if (i10 != 0) {
                            horizontal4 = Alignment.Companion.CenterHorizontally;
                        } else {
                            horizontal4 = horizontal2;
                        }
                        AndroidDialog_androidKt.Dialog(function0, new DialogProperties(3), Expect_jvmKt.rememberComposableLambda(-472271511, new DialogKt$$ExternalSyntheticLambda7(modifier4, horizontal4, function11, function12, composableLambdaImpl2, function13, (byte) 0), gapComposer), gapComposer, (i12 & 14) | 432);
                        modifier3 = modifier4;
                        horizontal3 = horizontal4;
                        function8 = function11;
                        function9 = function12;
                        function10 = function13;
                    } else {
                        gapComposer.skipToGroupEnd();
                        modifier3 = modifier2;
                        function8 = function5;
                        function9 = function6;
                        function10 = function7;
                        horizontal3 = horizontal2;
                    }
                    recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                    if (recomposeScopeImplEndRestartGroup != null) {
                        recomposeScopeImplEndRestartGroup.block = new DialogKt$$ExternalSyntheticLambda6(function0, modifier3, function8, function9, function10, horizontal3, composableLambdaImpl, i, i2);
                    }
                }
                i3 |= 196608;
                horizontal2 = horizontal;
                if ((1572864 & i) == 0) {
                    composableLambdaImpl2 = composableLambdaImpl;
                    if (gapComposer.changedInstance(composableLambdaImpl2)) {
                        i13 = ByteChannelKt.CHANNEL_MAX_SIZE;
                    } else {
                        i13 = 524288;
                    }
                    i3 |= i13;
                } else {
                    composableLambdaImpl2 = composableLambdaImpl;
                }
                i12 = i3;
                if ((599187 & i3) != 599186) {
                    z = true;
                } else {
                    z = false;
                }
                if (gapComposer.shouldExecute(i12 & 1, z)) {
                    if (i14 != 0) {
                        modifier4 = Modifier.Companion.$$INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        function11 = null;
                    } else {
                        function11 = function5;
                    }
                    if (i6 != 0) {
                        function12 = null;
                    } else {
                        function12 = function6;
                    }
                    if (i8 != 0) {
                        function13 = null;
                    } else {
                        function13 = function7;
                    }
                    if (i10 != 0) {
                        horizontal4 = Alignment.Companion.CenterHorizontally;
                    } else {
                        horizontal4 = horizontal2;
                    }
                    AndroidDialog_androidKt.Dialog(function0, new DialogProperties(3), Expect_jvmKt.rememberComposableLambda(-472271511, new DialogKt$$ExternalSyntheticLambda7(modifier4, horizontal4, function11, function12, composableLambdaImpl2, function13, (byte) 0), gapComposer), gapComposer, (i12 & 14) | 432);
                    modifier3 = modifier4;
                    horizontal3 = horizontal4;
                    function8 = function11;
                    function9 = function12;
                    function10 = function13;
                } else {
                    gapComposer.skipToGroupEnd();
                    modifier3 = modifier2;
                    function8 = function5;
                    function9 = function6;
                    function10 = function7;
                    horizontal3 = horizontal2;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new DialogKt$$ExternalSyntheticLambda6(function0, modifier3, function8, function9, function10, horizontal3, composableLambdaImpl, i, i2);
                }
            }
            i3 |= 24576;
            function7 = function4;
            i10 = i2 & 32;
            if (i10 != 0) {
                if ((196608 & i) == 0) {
                    horizontal2 = horizontal;
                    if (gapComposer.changed(horizontal2)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i3 |= i11;
                }
                if ((1572864 & i) == 0) {
                    composableLambdaImpl2 = composableLambdaImpl;
                    if (gapComposer.changedInstance(composableLambdaImpl2)) {
                        i13 = ByteChannelKt.CHANNEL_MAX_SIZE;
                    } else {
                        i13 = 524288;
                    }
                    i3 |= i13;
                } else {
                    composableLambdaImpl2 = composableLambdaImpl;
                }
                i12 = i3;
                if ((599187 & i3) != 599186) {
                    z = true;
                } else {
                    z = false;
                }
                if (gapComposer.shouldExecute(i12 & 1, z)) {
                    if (i14 != 0) {
                        modifier4 = Modifier.Companion.$$INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        function11 = null;
                    } else {
                        function11 = function5;
                    }
                    if (i6 != 0) {
                        function12 = null;
                    } else {
                        function12 = function6;
                    }
                    if (i8 != 0) {
                        function13 = null;
                    } else {
                        function13 = function7;
                    }
                    if (i10 != 0) {
                        horizontal4 = Alignment.Companion.CenterHorizontally;
                    } else {
                        horizontal4 = horizontal2;
                    }
                    AndroidDialog_androidKt.Dialog(function0, new DialogProperties(3), Expect_jvmKt.rememberComposableLambda(-472271511, new DialogKt$$ExternalSyntheticLambda7(modifier4, horizontal4, function11, function12, composableLambdaImpl2, function13, (byte) 0), gapComposer), gapComposer, (i12 & 14) | 432);
                    modifier3 = modifier4;
                    horizontal3 = horizontal4;
                    function8 = function11;
                    function9 = function12;
                    function10 = function13;
                } else {
                    gapComposer.skipToGroupEnd();
                    modifier3 = modifier2;
                    function8 = function5;
                    function9 = function6;
                    function10 = function7;
                    horizontal3 = horizontal2;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new DialogKt$$ExternalSyntheticLambda6(function0, modifier3, function8, function9, function10, horizontal3, composableLambdaImpl, i, i2);
                }
            }
            i3 |= 196608;
            horizontal2 = horizontal;
            if ((1572864 & i) == 0) {
                composableLambdaImpl2 = composableLambdaImpl;
                if (gapComposer.changedInstance(composableLambdaImpl2)) {
                    i13 = ByteChannelKt.CHANNEL_MAX_SIZE;
                } else {
                    i13 = 524288;
                }
                i3 |= i13;
            } else {
                composableLambdaImpl2 = composableLambdaImpl;
            }
            i12 = i3;
            if ((599187 & i3) != 599186) {
                z = true;
            } else {
                z = false;
            }
            if (gapComposer.shouldExecute(i12 & 1, z)) {
                if (i14 != 0) {
                    modifier4 = Modifier.Companion.$$INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i4 != 0) {
                    function11 = null;
                } else {
                    function11 = function5;
                }
                if (i6 != 0) {
                    function12 = null;
                } else {
                    function12 = function6;
                }
                if (i8 != 0) {
                    function13 = null;
                } else {
                    function13 = function7;
                }
                if (i10 != 0) {
                    horizontal4 = Alignment.Companion.CenterHorizontally;
                } else {
                    horizontal4 = horizontal2;
                }
                AndroidDialog_androidKt.Dialog(function0, new DialogProperties(3), Expect_jvmKt.rememberComposableLambda(-472271511, new DialogKt$$ExternalSyntheticLambda7(modifier4, horizontal4, function11, function12, composableLambdaImpl2, function13, (byte) 0), gapComposer), gapComposer, (i12 & 14) | 432);
                modifier3 = modifier4;
                horizontal3 = horizontal4;
                function8 = function11;
                function9 = function12;
                function10 = function13;
            } else {
                gapComposer.skipToGroupEnd();
                modifier3 = modifier2;
                function8 = function5;
                function9 = function6;
                function10 = function7;
                horizontal3 = horizontal2;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new DialogKt$$ExternalSyntheticLambda6(function0, modifier3, function8, function9, function10, horizontal3, composableLambdaImpl, i, i2);
            }
        }
        i3 |= 384;
        function5 = function2;
        i6 = i2 & 8;
        if (i6 != 0) {
            if ((i & 3072) == 0) {
                function6 = function3;
                if (gapComposer.changedInstance(function6)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i3 |= i7;
            }
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((i & 24576) == 0) {
                    function7 = function4;
                    if (gapComposer.changedInstance(function7)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                i10 = i2 & 32;
                if (i10 != 0) {
                    if ((196608 & i) == 0) {
                        horizontal2 = horizontal;
                        if (gapComposer.changed(horizontal2)) {
                            i11 = 131072;
                        } else {
                            i11 = 65536;
                        }
                        i3 |= i11;
                    }
                    if ((1572864 & i) == 0) {
                        composableLambdaImpl2 = composableLambdaImpl;
                        if (gapComposer.changedInstance(composableLambdaImpl2)) {
                            i13 = ByteChannelKt.CHANNEL_MAX_SIZE;
                        } else {
                            i13 = 524288;
                        }
                        i3 |= i13;
                    } else {
                        composableLambdaImpl2 = composableLambdaImpl;
                    }
                    i12 = i3;
                    if ((599187 & i3) != 599186) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (gapComposer.shouldExecute(i12 & 1, z)) {
                        if (i14 != 0) {
                            modifier4 = Modifier.Companion.$$INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i4 != 0) {
                            function11 = null;
                        } else {
                            function11 = function5;
                        }
                        if (i6 != 0) {
                            function12 = null;
                        } else {
                            function12 = function6;
                        }
                        if (i8 != 0) {
                            function13 = null;
                        } else {
                            function13 = function7;
                        }
                        if (i10 != 0) {
                            horizontal4 = Alignment.Companion.CenterHorizontally;
                        } else {
                            horizontal4 = horizontal2;
                        }
                        AndroidDialog_androidKt.Dialog(function0, new DialogProperties(3), Expect_jvmKt.rememberComposableLambda(-472271511, new DialogKt$$ExternalSyntheticLambda7(modifier4, horizontal4, function11, function12, composableLambdaImpl2, function13, (byte) 0), gapComposer), gapComposer, (i12 & 14) | 432);
                        modifier3 = modifier4;
                        horizontal3 = horizontal4;
                        function8 = function11;
                        function9 = function12;
                        function10 = function13;
                    } else {
                        gapComposer.skipToGroupEnd();
                        modifier3 = modifier2;
                        function8 = function5;
                        function9 = function6;
                        function10 = function7;
                        horizontal3 = horizontal2;
                    }
                    recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                    if (recomposeScopeImplEndRestartGroup != null) {
                        recomposeScopeImplEndRestartGroup.block = new DialogKt$$ExternalSyntheticLambda6(function0, modifier3, function8, function9, function10, horizontal3, composableLambdaImpl, i, i2);
                    }
                }
                i3 |= 196608;
                horizontal2 = horizontal;
                if ((1572864 & i) == 0) {
                    composableLambdaImpl2 = composableLambdaImpl;
                    if (gapComposer.changedInstance(composableLambdaImpl2)) {
                        i13 = ByteChannelKt.CHANNEL_MAX_SIZE;
                    } else {
                        i13 = 524288;
                    }
                    i3 |= i13;
                } else {
                    composableLambdaImpl2 = composableLambdaImpl;
                }
                i12 = i3;
                if ((599187 & i3) != 599186) {
                    z = true;
                } else {
                    z = false;
                }
                if (gapComposer.shouldExecute(i12 & 1, z)) {
                    if (i14 != 0) {
                        modifier4 = Modifier.Companion.$$INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        function11 = null;
                    } else {
                        function11 = function5;
                    }
                    if (i6 != 0) {
                        function12 = null;
                    } else {
                        function12 = function6;
                    }
                    if (i8 != 0) {
                        function13 = null;
                    } else {
                        function13 = function7;
                    }
                    if (i10 != 0) {
                        horizontal4 = Alignment.Companion.CenterHorizontally;
                    } else {
                        horizontal4 = horizontal2;
                    }
                    AndroidDialog_androidKt.Dialog(function0, new DialogProperties(3), Expect_jvmKt.rememberComposableLambda(-472271511, new DialogKt$$ExternalSyntheticLambda7(modifier4, horizontal4, function11, function12, composableLambdaImpl2, function13, (byte) 0), gapComposer), gapComposer, (i12 & 14) | 432);
                    modifier3 = modifier4;
                    horizontal3 = horizontal4;
                    function8 = function11;
                    function9 = function12;
                    function10 = function13;
                } else {
                    gapComposer.skipToGroupEnd();
                    modifier3 = modifier2;
                    function8 = function5;
                    function9 = function6;
                    function10 = function7;
                    horizontal3 = horizontal2;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new DialogKt$$ExternalSyntheticLambda6(function0, modifier3, function8, function9, function10, horizontal3, composableLambdaImpl, i, i2);
                }
            }
            i3 |= 24576;
            function7 = function4;
            i10 = i2 & 32;
            if (i10 != 0) {
                if ((196608 & i) == 0) {
                    horizontal2 = horizontal;
                    if (gapComposer.changed(horizontal2)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i3 |= i11;
                }
                if ((1572864 & i) == 0) {
                    composableLambdaImpl2 = composableLambdaImpl;
                    if (gapComposer.changedInstance(composableLambdaImpl2)) {
                        i13 = ByteChannelKt.CHANNEL_MAX_SIZE;
                    } else {
                        i13 = 524288;
                    }
                    i3 |= i13;
                } else {
                    composableLambdaImpl2 = composableLambdaImpl;
                }
                i12 = i3;
                if ((599187 & i3) != 599186) {
                    z = true;
                } else {
                    z = false;
                }
                if (gapComposer.shouldExecute(i12 & 1, z)) {
                    if (i14 != 0) {
                        modifier4 = Modifier.Companion.$$INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        function11 = null;
                    } else {
                        function11 = function5;
                    }
                    if (i6 != 0) {
                        function12 = null;
                    } else {
                        function12 = function6;
                    }
                    if (i8 != 0) {
                        function13 = null;
                    } else {
                        function13 = function7;
                    }
                    if (i10 != 0) {
                        horizontal4 = Alignment.Companion.CenterHorizontally;
                    } else {
                        horizontal4 = horizontal2;
                    }
                    AndroidDialog_androidKt.Dialog(function0, new DialogProperties(3), Expect_jvmKt.rememberComposableLambda(-472271511, new DialogKt$$ExternalSyntheticLambda7(modifier4, horizontal4, function11, function12, composableLambdaImpl2, function13, (byte) 0), gapComposer), gapComposer, (i12 & 14) | 432);
                    modifier3 = modifier4;
                    horizontal3 = horizontal4;
                    function8 = function11;
                    function9 = function12;
                    function10 = function13;
                } else {
                    gapComposer.skipToGroupEnd();
                    modifier3 = modifier2;
                    function8 = function5;
                    function9 = function6;
                    function10 = function7;
                    horizontal3 = horizontal2;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new DialogKt$$ExternalSyntheticLambda6(function0, modifier3, function8, function9, function10, horizontal3, composableLambdaImpl, i, i2);
                }
            }
            i3 |= 196608;
            horizontal2 = horizontal;
            if ((1572864 & i) == 0) {
                composableLambdaImpl2 = composableLambdaImpl;
                if (gapComposer.changedInstance(composableLambdaImpl2)) {
                    i13 = ByteChannelKt.CHANNEL_MAX_SIZE;
                } else {
                    i13 = 524288;
                }
                i3 |= i13;
            } else {
                composableLambdaImpl2 = composableLambdaImpl;
            }
            i12 = i3;
            if ((599187 & i3) != 599186) {
                z = true;
            } else {
                z = false;
            }
            if (gapComposer.shouldExecute(i12 & 1, z)) {
                if (i14 != 0) {
                    modifier4 = Modifier.Companion.$$INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i4 != 0) {
                    function11 = null;
                } else {
                    function11 = function5;
                }
                if (i6 != 0) {
                    function12 = null;
                } else {
                    function12 = function6;
                }
                if (i8 != 0) {
                    function13 = null;
                } else {
                    function13 = function7;
                }
                if (i10 != 0) {
                    horizontal4 = Alignment.Companion.CenterHorizontally;
                } else {
                    horizontal4 = horizontal2;
                }
                AndroidDialog_androidKt.Dialog(function0, new DialogProperties(3), Expect_jvmKt.rememberComposableLambda(-472271511, new DialogKt$$ExternalSyntheticLambda7(modifier4, horizontal4, function11, function12, composableLambdaImpl2, function13, (byte) 0), gapComposer), gapComposer, (i12 & 14) | 432);
                modifier3 = modifier4;
                horizontal3 = horizontal4;
                function8 = function11;
                function9 = function12;
                function10 = function13;
            } else {
                gapComposer.skipToGroupEnd();
                modifier3 = modifier2;
                function8 = function5;
                function9 = function6;
                function10 = function7;
                horizontal3 = horizontal2;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new DialogKt$$ExternalSyntheticLambda6(function0, modifier3, function8, function9, function10, horizontal3, composableLambdaImpl, i, i2);
            }
        }
        i3 |= 3072;
        function6 = function3;
        i8 = i2 & 16;
        if (i8 != 0) {
            if ((i & 24576) == 0) {
                function7 = function4;
                if (gapComposer.changedInstance(function7)) {
                    i9 = 16384;
                } else {
                    i9 = 8192;
                }
                i3 |= i9;
            }
            i10 = i2 & 32;
            if (i10 != 0) {
                if ((196608 & i) == 0) {
                    horizontal2 = horizontal;
                    if (gapComposer.changed(horizontal2)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i3 |= i11;
                }
                if ((1572864 & i) == 0) {
                    composableLambdaImpl2 = composableLambdaImpl;
                    if (gapComposer.changedInstance(composableLambdaImpl2)) {
                        i13 = ByteChannelKt.CHANNEL_MAX_SIZE;
                    } else {
                        i13 = 524288;
                    }
                    i3 |= i13;
                } else {
                    composableLambdaImpl2 = composableLambdaImpl;
                }
                i12 = i3;
                if ((599187 & i3) != 599186) {
                    z = true;
                } else {
                    z = false;
                }
                if (gapComposer.shouldExecute(i12 & 1, z)) {
                    if (i14 != 0) {
                        modifier4 = Modifier.Companion.$$INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        function11 = null;
                    } else {
                        function11 = function5;
                    }
                    if (i6 != 0) {
                        function12 = null;
                    } else {
                        function12 = function6;
                    }
                    if (i8 != 0) {
                        function13 = null;
                    } else {
                        function13 = function7;
                    }
                    if (i10 != 0) {
                        horizontal4 = Alignment.Companion.CenterHorizontally;
                    } else {
                        horizontal4 = horizontal2;
                    }
                    AndroidDialog_androidKt.Dialog(function0, new DialogProperties(3), Expect_jvmKt.rememberComposableLambda(-472271511, new DialogKt$$ExternalSyntheticLambda7(modifier4, horizontal4, function11, function12, composableLambdaImpl2, function13, (byte) 0), gapComposer), gapComposer, (i12 & 14) | 432);
                    modifier3 = modifier4;
                    horizontal3 = horizontal4;
                    function8 = function11;
                    function9 = function12;
                    function10 = function13;
                } else {
                    gapComposer.skipToGroupEnd();
                    modifier3 = modifier2;
                    function8 = function5;
                    function9 = function6;
                    function10 = function7;
                    horizontal3 = horizontal2;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new DialogKt$$ExternalSyntheticLambda6(function0, modifier3, function8, function9, function10, horizontal3, composableLambdaImpl, i, i2);
                }
            }
            i3 |= 196608;
            horizontal2 = horizontal;
            if ((1572864 & i) == 0) {
                composableLambdaImpl2 = composableLambdaImpl;
                if (gapComposer.changedInstance(composableLambdaImpl2)) {
                    i13 = ByteChannelKt.CHANNEL_MAX_SIZE;
                } else {
                    i13 = 524288;
                }
                i3 |= i13;
            } else {
                composableLambdaImpl2 = composableLambdaImpl;
            }
            i12 = i3;
            if ((599187 & i3) != 599186) {
                z = true;
            } else {
                z = false;
            }
            if (gapComposer.shouldExecute(i12 & 1, z)) {
                if (i14 != 0) {
                    modifier4 = Modifier.Companion.$$INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i4 != 0) {
                    function11 = null;
                } else {
                    function11 = function5;
                }
                if (i6 != 0) {
                    function12 = null;
                } else {
                    function12 = function6;
                }
                if (i8 != 0) {
                    function13 = null;
                } else {
                    function13 = function7;
                }
                if (i10 != 0) {
                    horizontal4 = Alignment.Companion.CenterHorizontally;
                } else {
                    horizontal4 = horizontal2;
                }
                AndroidDialog_androidKt.Dialog(function0, new DialogProperties(3), Expect_jvmKt.rememberComposableLambda(-472271511, new DialogKt$$ExternalSyntheticLambda7(modifier4, horizontal4, function11, function12, composableLambdaImpl2, function13, (byte) 0), gapComposer), gapComposer, (i12 & 14) | 432);
                modifier3 = modifier4;
                horizontal3 = horizontal4;
                function8 = function11;
                function9 = function12;
                function10 = function13;
            } else {
                gapComposer.skipToGroupEnd();
                modifier3 = modifier2;
                function8 = function5;
                function9 = function6;
                function10 = function7;
                horizontal3 = horizontal2;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new DialogKt$$ExternalSyntheticLambda6(function0, modifier3, function8, function9, function10, horizontal3, composableLambdaImpl, i, i2);
            }
        }
        i3 |= 24576;
        function7 = function4;
        i10 = i2 & 32;
        if (i10 != 0) {
            if ((196608 & i) == 0) {
                horizontal2 = horizontal;
                if (gapComposer.changed(horizontal2)) {
                    i11 = 131072;
                } else {
                    i11 = 65536;
                }
                i3 |= i11;
            }
            if ((1572864 & i) == 0) {
                composableLambdaImpl2 = composableLambdaImpl;
                if (gapComposer.changedInstance(composableLambdaImpl2)) {
                    i13 = ByteChannelKt.CHANNEL_MAX_SIZE;
                } else {
                    i13 = 524288;
                }
                i3 |= i13;
            } else {
                composableLambdaImpl2 = composableLambdaImpl;
            }
            i12 = i3;
            if ((599187 & i3) != 599186) {
                z = true;
            } else {
                z = false;
            }
            if (gapComposer.shouldExecute(i12 & 1, z)) {
                if (i14 != 0) {
                    modifier4 = Modifier.Companion.$$INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i4 != 0) {
                    function11 = null;
                } else {
                    function11 = function5;
                }
                if (i6 != 0) {
                    function12 = null;
                } else {
                    function12 = function6;
                }
                if (i8 != 0) {
                    function13 = null;
                } else {
                    function13 = function7;
                }
                if (i10 != 0) {
                    horizontal4 = Alignment.Companion.CenterHorizontally;
                } else {
                    horizontal4 = horizontal2;
                }
                AndroidDialog_androidKt.Dialog(function0, new DialogProperties(3), Expect_jvmKt.rememberComposableLambda(-472271511, new DialogKt$$ExternalSyntheticLambda7(modifier4, horizontal4, function11, function12, composableLambdaImpl2, function13, (byte) 0), gapComposer), gapComposer, (i12 & 14) | 432);
                modifier3 = modifier4;
                horizontal3 = horizontal4;
                function8 = function11;
                function9 = function12;
                function10 = function13;
            } else {
                gapComposer.skipToGroupEnd();
                modifier3 = modifier2;
                function8 = function5;
                function9 = function6;
                function10 = function7;
                horizontal3 = horizontal2;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new DialogKt$$ExternalSyntheticLambda6(function0, modifier3, function8, function9, function10, horizontal3, composableLambdaImpl, i, i2);
            }
        }
        i3 |= 196608;
        horizontal2 = horizontal;
        if ((1572864 & i) == 0) {
            composableLambdaImpl2 = composableLambdaImpl;
            if (gapComposer.changedInstance(composableLambdaImpl2)) {
                i13 = ByteChannelKt.CHANNEL_MAX_SIZE;
            } else {
                i13 = 524288;
            }
            i3 |= i13;
        } else {
            composableLambdaImpl2 = composableLambdaImpl;
        }
        i12 = i3;
        if ((599187 & i3) != 599186) {
            z = true;
        } else {
            z = false;
        }
        if (gapComposer.shouldExecute(i12 & 1, z)) {
            if (i14 != 0) {
                modifier4 = Modifier.Companion.$$INSTANCE;
            } else {
                modifier4 = modifier2;
            }
            if (i4 != 0) {
                function11 = null;
            } else {
                function11 = function5;
            }
            if (i6 != 0) {
                function12 = null;
            } else {
                function12 = function6;
            }
            if (i8 != 0) {
                function13 = null;
            } else {
                function13 = function7;
            }
            if (i10 != 0) {
                horizontal4 = Alignment.Companion.CenterHorizontally;
            } else {
                horizontal4 = horizontal2;
            }
            AndroidDialog_androidKt.Dialog(function0, new DialogProperties(3), Expect_jvmKt.rememberComposableLambda(-472271511, new DialogKt$$ExternalSyntheticLambda7(modifier4, horizontal4, function11, function12, composableLambdaImpl2, function13, (byte) 0), gapComposer), gapComposer, (i12 & 14) | 432);
            modifier3 = modifier4;
            horizontal3 = horizontal4;
            function8 = function11;
            function9 = function12;
            function10 = function13;
        } else {
            gapComposer.skipToGroupEnd();
            modifier3 = modifier2;
            function8 = function5;
            function9 = function6;
            function10 = function7;
            horizontal3 = horizontal2;
        }
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new DialogKt$$ExternalSyntheticLambda6(function0, modifier3, function8, function9, function10, horizontal3, composableLambdaImpl, i, i2);
        }
    }

    public static final void DraggableLyricsProviderList(List list, Function1 function1, Modifier modifier, Composer composer, int i) {
        List list2;
        ReorderableLazyListState reorderableLazyListState;
        list.getClass();
        function1.getClass();
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(731019412);
        int i2 = i | (gapComposer.changedInstance(function1) ? 32 : 16) | (gapComposer.changed(modifier) ? 256 : 128);
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
            LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(gapComposer);
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState = (MutableState) objRememberedValue;
            Object objRememberedValue2 = gapComposer.rememberedValue();
            Continuation continuation = null;
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new QueueKt$Queue$5$reorderableState$1$1(list, mutableState, continuation, (byte) 2);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            ReorderableLazyListState reorderableLazyListStateM1880rememberReorderableLazyListStateTN_CM5M = CharsKt.m1880rememberReorderableLazyListStateTN_CM5M(lazyListStateRememberLazyListState, null, (Function4) objRememberedValue2, gapComposer, 14);
            Boolean boolValueOf = Boolean.valueOf(reorderableLazyListStateM1880rememberReorderableLazyListStateTN_CM5M.isAnyItemDragging());
            boolean zChanged = gapComposer.changed(reorderableLazyListStateM1880rememberReorderableLazyListStateTN_CM5M) | ((i2 & 112) == 32);
            Object objRememberedValue3 = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue3 == neverEqualPolicy) {
                reorderableLazyListState = reorderableLazyListStateM1880rememberReorderableLazyListStateTN_CM5M;
                QueueKt$Queue$5$1$1 queueKt$Queue$5$1$1 = new QueueKt$Queue$5$1$1(reorderableLazyListState, function1, list, mutableState, (Continuation) null);
                gapComposer.updateRememberedValue(queueKt$Queue$5$1$1);
                objRememberedValue3 = queueKt$Queue$5$1$1;
            } else {
                reorderableLazyListState = reorderableLazyListStateM1880rememberReorderableLazyListStateTN_CM5M;
            }
            Stack.LaunchedEffect(gapComposer, boolValueOf, (Function2) objRememberedValue3);
            boolean zChanged2 = gapComposer.changed(reorderableLazyListState);
            Object objRememberedValue4 = gapComposer.rememberedValue();
            if (zChanged2 || objRememberedValue4 == neverEqualPolicy) {
                objRememberedValue4 = new QuickJs$$ExternalSyntheticLambda1(list, reorderableLazyListState, (byte) 26);
                gapComposer.updateRememberedValue(objRememberedValue4);
            }
            IntMath.LazyColumn(modifier, lazyListStateRememberLazyListState, null, null, null, null, false, null, (Function1) objRememberedValue4, gapComposer, (i2 >> 6) & 14, 508);
        } else {
            list2 = list;
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new MainActivity$$ExternalSyntheticLambda9((byte) 16, i, list2, function1, modifier);
        }
    }

    /* JADX WARN: Failed to calculate best type for var: r12v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r12v1 ??, new type: androidx.compose.runtime.GapComposer
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r12v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r12v1 ??, new type: androidx.compose.runtime.GapComposer
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r2v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v1 ??, new type: androidx.compose.runtime.GapComposer
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r2v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v1 ??, new type: androidx.compose.runtime.GapComposer
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r2v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v2 ??, new type: androidx.compose.runtime.GapComposer
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r2v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v2 ??, new type: androidx.compose.runtime.GapComposer
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r2v9 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v9 ??, new type: androidx.compose.runtime.GapComposer
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r6v8 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r6v8 ??, new type: boolean
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r6v9 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r6v9 ??, new type: boolean
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r8v7 ??, new type: boolean
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:186)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:245)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
        	... 5 more
        */
    /* JADX INFO: renamed from: DraggableScrollbar-tao0HgU, reason: not valid java name */
    public static final void m1466DraggableScrollbartao0HgU(androidx.compose.foundation.lazy.LazyListState r32, androidx.compose.ui.Modifier r33, long r34, long r36, float r38, float r39, float r40, float r41, int r42, int r43, int r44, androidx.compose.runtime.Composer r45, int r46) {
        /*
            Method dump skipped, instruction units count: 642
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.metrolist.music.ui.component.DialogKt.m1466DraggableScrollbartao0HgU(androidx.compose.foundation.lazy.LazyListState, androidx.compose.ui.Modifier, long, long, float, float, float, float, int, int, int, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: renamed from: EditorialDivider-iJQMabo, reason: not valid java name */
    public static final void m1467EditorialDivideriJQMabo(Modifier modifier, long j, Composer composer, final int i, final int i2) {
        int i3;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-2016954811);
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = i | (gapComposer.changed(modifier) ? 4 : 2);
        } else {
            i3 = i;
        }
        int i5 = i3 | 16;
        if (gapComposer.shouldExecute(i5 & 1, (i5 & 19) != 18)) {
            gapComposer.startDefaults();
            if ((i & 1) == 0 || gapComposer.getDefaultsInvalid()) {
                if (i4 != 0) {
                    modifier = Modifier.Companion.$$INSTANCE;
                }
                if (gapComposer.consume(UiStyleKt.LocalUiStyle) == UiStyle.GLASS) {
                    gapComposer.startReplaceGroup(-1263317736);
                    long j2 = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.outlineVariant;
                    j = ColorKt.Color(Color.m485getRedimpl(j2), Color.m484getGreenimpl(j2), Color.m482getBlueimpl(j2), 0.35f, Color.m483getColorSpaceimpl(j2));
                    gapComposer.end(false);
                } else {
                    gapComposer.startReplaceGroup(-1263315981);
                    j = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.outlineVariant;
                    gapComposer.end(false);
                }
            } else {
                gapComposer.skipToGroupEnd();
            }
            gapComposer.endDefaults();
            BoxKt.Box(ImageKt.m39backgroundbw27NRU(SizeKt.m145height3ABfNKs(SizeKt.fillMaxWidth(modifier, 1.0f), 1.0f), j, ColorKt.RectangleShape), gapComposer, 0);
        } else {
            gapComposer.skipToGroupEnd();
        }
        final Modifier modifier2 = modifier;
        final long j3 = j;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.metrolist.music.ui.component.EditorialComponentsKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    DialogKt.m1467EditorialDivideriJQMabo(modifier2, j3, (Composer) obj, Stack.updateChangedFlags(i | 1), i2);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0055  */
    /* JADX WARN: Code duplicated, block: B:31:0x0057  */
    /* JADX WARN: Code duplicated, block: B:34:0x0060  */
    /* JADX WARN: Code duplicated, block: B:36:0x0064  */
    /* JADX WARN: Code duplicated, block: B:37:0x0066  */
    /* JADX WARN: Code duplicated, block: B:40:0x009b  */
    /* JADX WARN: Code duplicated, block: B:41:0x009f  */
    /* JADX WARN: Code duplicated, block: B:44:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:45:0x00db  */
    /* JADX WARN: Code duplicated, block: B:48:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:49:0x0103  */
    /* JADX WARN: Code duplicated, block: B:51:0x0192  */
    /* JADX WARN: Code duplicated, block: B:54:0x019b  */
    /* JADX WARN: Code duplicated, block: B:56:? A[RETURN, SYNTHETIC] */
    public static final void EmptyPlaceholder(final int i, final int i2, final int i3, Composer composer, Modifier modifier, final String str) throws XmlPullParserException, IOException {
        int i4;
        final Modifier modifier2;
        boolean z;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        Modifier.Companion companion;
        Modifier modifier3;
        boolean z2;
        TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3;
        Modifier modifierGlassCard;
        str.getClass();
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(589303227);
        if ((i2 & 6) == 0) {
            i4 = (gapComposer.changed(i) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= gapComposer.changed(str) ? 32 : 16;
        }
        int i5 = i3 & 4;
        if (i5 == 0) {
            if ((i2 & 384) == 0) {
                modifier2 = modifier;
                i4 |= gapComposer.changed(modifier2) ? 256 : 128;
            }
            if ((i4 & 147) != 146) {
                z = true;
            } else {
                z = false;
            }
            if (gapComposer.shouldExecute(i4 & 1, z)) {
                companion = Modifier.Companion.$$INSTANCE;
                if (i5 != 0) {
                    modifier3 = companion;
                } else {
                    modifier3 = modifier2;
                }
                BiasAlignment.Horizontal horizontal = Alignment.Companion.CenterHorizontally;
                FlowRowOverflow flowRowOverflow = OffsetKt.Center;
                Modifier modifierM136paddingVpY3zN4 = OffsetKt.m136paddingVpY3zN4(modifier3.then(SizeKt.FillWholeMaxSize), 32.0f, 24.0f);
                ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(flowRowOverflow, horizontal, gapComposer, 54);
                int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierM136paddingVpY3zN4);
                ComposeUiNode.Companion.getClass();
                gapComposer.startReusableNode();
                z2 = gapComposer.inserting;
                textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
                if (z2) {
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
                BiasAlignment biasAlignment = Alignment.Companion.Center;
                if (UiStyleKt.isGlassStyle(gapComposer)) {
                    gapComposer.startReplaceGroup(329502023);
                    modifierGlassCard = GlassComponentsKt.glassCard(SizeKt.m151size3ABfNKs(companion, 88.0f), RoundedCornerShapeKt.CircleShape, gapComposer);
                    gapComposer.end(false);
                } else {
                    gapComposer.startReplaceGroup(329502905);
                    gapComposer.end(false);
                    modifierGlassCard = companion;
                }
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, false);
                Modifier modifier4 = modifier3;
                int iHashCode2 = Long.hashCode(gapComposer.compositeKeyHashCode);
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer, modifierGlassCard);
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
                Painter painterPainterResource = IntMath.painterResource(i, i4 & 14, gapComposer);
                StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                ImageKt.Image(painterPainterResource, null, SizeKt.m151size3ABfNKs(companion, 40.0f), null, null, CropImageView.DEFAULT_ASPECT_RATIO, new BlendModeColorFilter(((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.primary, 5), gapComposer, 440, 56);
                gapComposer.end(true);
                OffsetKt.Spacer(gapComposer, SizeKt.m145height3ABfNKs(companion, 16.0f));
                TextKt.m352TextNvy7gAk(str, null, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.onSurface, 0L, null, null, null, 0L, new TextAlign(3), 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).typography.titleLarge, gapComposer, (i4 >> 3) & 14, 0, 130042);
                gapComposer = gapComposer;
                gapComposer.end(true);
                modifier2 = modifier4;
            } else {
                gapComposer.skipToGroupEnd();
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.metrolist.music.ui.component.EmptyPlaceholderKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) throws XmlPullParserException, IOException {
                        ((Integer) obj2).getClass();
                        int iUpdateChangedFlags = Stack.updateChangedFlags(i2 | 1);
                        DialogKt.EmptyPlaceholder(i, iUpdateChangedFlags, i3, (Composer) obj, modifier2, str);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i4 |= 384;
        modifier2 = modifier;
        if ((i4 & 147) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (gapComposer.shouldExecute(i4 & 1, z)) {
            companion = Modifier.Companion.$$INSTANCE;
            if (i5 != 0) {
                modifier3 = companion;
            } else {
                modifier3 = modifier2;
            }
            BiasAlignment.Horizontal horizontal2 = Alignment.Companion.CenterHorizontally;
            FlowRowOverflow flowRowOverflow2 = OffsetKt.Center;
            Modifier modifierM136paddingVpY3zN5 = OffsetKt.m136paddingVpY3zN4(modifier3.then(SizeKt.FillWholeMaxSize), 32.0f, 24.0f);
            ColumnMeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(flowRowOverflow2, horizontal2, gapComposer, 54);
            int iHashCode3 = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer, modifierM136paddingVpY3zN5);
            ComposeUiNode.Companion.getClass();
            gapComposer.startReusableNode();
            z2 = gapComposer.inserting;
            textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
            if (z2) {
                gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer.useNode();
            }
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda4 = ComposeUiNode.Companion.SetMeasurePolicy;
            Stack.m390setimpl(gapComposer, columnMeasurePolicy2, updater$$ExternalSyntheticLambda4);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda5 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda5);
            Integer numValueOf2 = Integer.valueOf(iHashCode3);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda6 = ComposeUiNode.Companion.SetCompositeKeyHash;
            Stack.m390setimpl(gapComposer, numValueOf2, updater$$ExternalSyntheticLambda6);
            Stack.m389reconcileimpl(gapComposer);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda7 = ComposeUiNode.Companion.SetModifier;
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda7);
            BiasAlignment biasAlignment2 = Alignment.Companion.Center;
            if (UiStyleKt.isGlassStyle(gapComposer)) {
                gapComposer.startReplaceGroup(329502023);
                modifierGlassCard = GlassComponentsKt.glassCard(SizeKt.m151size3ABfNKs(companion, 88.0f), RoundedCornerShapeKt.CircleShape, gapComposer);
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(329502905);
                gapComposer.end(false);
                modifierGlassCard = companion;
            }
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment2, false);
            Modifier modifier5 = modifier3;
            int iHashCode4 = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope4 = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier4 = ZIndexModifierKt.materializeModifier(gapComposer, modifierGlassCard);
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer.useNode();
            }
            Stack.m390setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy2, updater$$ExternalSyntheticLambda4);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope4, updater$$ExternalSyntheticLambda5);
            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode4, gapComposer, updater$$ExternalSyntheticLambda6, gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier4, updater$$ExternalSyntheticLambda7);
            Painter painterPainterResource2 = IntMath.painterResource(i, i4 & 14, gapComposer);
            StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = MaterialThemeKt._localMaterialTheme;
            ImageKt.Image(painterPainterResource2, null, SizeKt.m151size3ABfNKs(companion, 40.0f), null, null, CropImageView.DEFAULT_ASPECT_RATIO, new BlendModeColorFilter(((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal2)).colorScheme.primary, 5), gapComposer, 440, 56);
            gapComposer.end(true);
            OffsetKt.Spacer(gapComposer, SizeKt.m145height3ABfNKs(companion, 16.0f));
            TextKt.m352TextNvy7gAk(str, null, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal2)).colorScheme.onSurface, 0L, null, null, null, 0L, new TextAlign(3), 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal2)).typography.titleLarge, gapComposer, (i4 >> 3) & 14, 0, 130042);
            gapComposer = gapComposer;
            gapComposer.end(true);
            modifier2 = modifier5;
        } else {
            gapComposer.skipToGroupEnd();
        }
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.metrolist.music.ui.component.EmptyPlaceholderKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) throws XmlPullParserException, IOException {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(i2 | 1);
                    DialogKt.EmptyPlaceholder(i, iUpdateChangedFlags, i3, (Composer) obj, modifier2, str);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final void EnumDialog(final Function0 function0, final Function1 function1, final String str, final Object obj, final List list, final Function3 function3, Function3 function4, Composer composer, final int i, final int i2) {
        int i3;
        Function3 function5;
        int i4;
        final Function3 function6;
        final int i5;
        function0.getClass();
        function1.getClass();
        str.getClass();
        list.getClass();
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(2135081216);
        if ((i & 6) == 0) {
            i3 = (gapComposer.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i6 = i3 | (gapComposer.changedInstance(function1) ? 32 : 16) | (gapComposer.changed(obj) ? 2048 : 1024);
        if ((i & 24576) == 0) {
            i6 |= gapComposer.changed(list) ? 16384 : 8192;
        }
        int i7 = i6 | (gapComposer.changedInstance(function3) ? 131072 : 65536);
        int i8 = i2 & 64;
        if (i8 != 0) {
            i4 = i7 | 1572864;
            function5 = function4;
        } else {
            function5 = function4;
            i4 = i7 | (gapComposer.changedInstance(function5) ? ByteChannelKt.CHANNEL_MAX_SIZE : 524288);
        }
        if (gapComposer.shouldExecute(i4 & 1, (599059 & i4) != 599058)) {
            final Function3 function7 = i8 != 0 ? null : function5;
            boolean z = ((57344 & i4) == 16384) | ((i4 & 112) == 32) | ((i4 & 7168) == 2048) | ((458752 & i4) == 131072) | ((3670016 & i4) == 1048576);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (z || objRememberedValue == Composer.Companion.Empty) {
                i5 = i4;
                Function1 function2 = new Function1() { // from class: com.metrolist.music.ui.component.EnumDialogKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        LazyListIntervalContent lazyListIntervalContent = (LazyListIntervalContent) obj2;
                        lazyListIntervalContent.getClass();
                        final List list2 = list;
                        int size = list2.size();
                        SongMenuKt$SongMenu$lambda$33$0$$inlined$items$default$3 songMenuKt$SongMenu$lambda$33$0$$inlined$items$default$3 = new SongMenuKt$SongMenu$lambda$33$0$$inlined$items$default$3(list2, (byte) 2);
                        final Function1 function8 = function1;
                        final Object obj3 = obj;
                        final Function3 function9 = function3;
                        final int i9 = i5;
                        final Function3 function10 = function7;
                        lazyListIntervalContent.items(size, null, songMenuKt$SongMenu$lambda$33$0$$inlined$items$default$3, new ComposableLambdaImpl(true, 802480018, new Function4() { // from class: com.metrolist.music.ui.component.EnumDialogKt$EnumDialog$lambda$0$0$$inlined$items$default$4
                            @Override // kotlin.jvm.functions.Function4
                            public final Object invoke(Object obj4, Object obj5, Object obj6, Object obj7) {
                                int i10;
                                LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj4;
                                int iIntValue = ((Number) obj5).intValue();
                                Composer composer2 = (Composer) obj6;
                                int iIntValue2 = ((Number) obj7).intValue();
                                if ((iIntValue2 & 6) == 0) {
                                    i10 = (((GapComposer) composer2).changed(lazyItemScopeImpl) ? 4 : 2) | iIntValue2;
                                } else {
                                    i10 = iIntValue2;
                                }
                                if ((iIntValue2 & 48) == 0) {
                                    i10 |= ((GapComposer) composer2).changed(iIntValue) ? 32 : 16;
                                }
                                GapComposer gapComposer2 = (GapComposer) composer2;
                                if (gapComposer2.shouldExecute(i10 & 1, (i10 & 147) != 146)) {
                                    Object obj8 = list2.get(iIntValue);
                                    gapComposer2.startReplaceGroup(-1767902668);
                                    BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
                                    Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                                    Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                                    Function1 function11 = function8;
                                    boolean zChanged = gapComposer2.changed(function11) | gapComposer2.changedInstance(obj8);
                                    Object objRememberedValue2 = gapComposer2.rememberedValue();
                                    if (zChanged || objRememberedValue2 == Composer.Companion.Empty) {
                                        objRememberedValue2 = new Http2Connection.ReaderRunnable(function11, obj8, (byte) 1);
                                        gapComposer2.updateRememberedValue(objRememberedValue2);
                                    }
                                    Modifier modifierM136paddingVpY3zN4 = OffsetKt.m136paddingVpY3zN4(ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth, false, null, (Function0) objRememberedValue2, 15), 16.0f, 12.0f);
                                    RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(OffsetKt.Start, vertical, gapComposer2, 48);
                                    int iHashCode = Long.hashCode(gapComposer2.compositeKeyHashCode);
                                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
                                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer2, modifierM136paddingVpY3zN4);
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
                                    Stack.m390setimpl(gapComposer2, rowMeasurePolicy, updater$$ExternalSyntheticLambda0);
                                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                                    Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda1);
                                    Integer numValueOf = Integer.valueOf(iHashCode);
                                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetCompositeKeyHash;
                                    Stack.m390setimpl(gapComposer2, numValueOf, updater$$ExternalSyntheticLambda2);
                                    Stack.m389reconcileimpl(gapComposer2);
                                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetModifier;
                                    Stack.m390setimpl(gapComposer2, modifierMaterializeModifier, updater$$ExternalSyntheticLambda3);
                                    ScrimKt.RadioButton(Intrinsics.areEqual(obj8, obj3), null, null, false, null, gapComposer2, 48);
                                    Modifier modifierM139paddingqDBjuR0$default = OffsetKt.m139paddingqDBjuR0$default(companion, 16.0f, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 14);
                                    ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start, gapComposer2, 0);
                                    int iHashCode2 = Long.hashCode(gapComposer2.compositeKeyHashCode);
                                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer2.currentCompositionLocalScope();
                                    Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer2, modifierM139paddingqDBjuR0$default);
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
                                    int i11 = (i9 >> 9) & 8;
                                    TextKt.m352TextNvy7gAk((String) function9.invoke(obj8, gapComposer2, Integer.valueOf(i11)), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer2, 0, 0, 262142);
                                    GapComposer gapComposer3 = gapComposer2;
                                    Function3 function12 = function10;
                                    if (function12 != null) {
                                        gapComposer3.startReplaceGroup(-496200899);
                                        String str2 = (String) function12.invoke(obj8, gapComposer3, Integer.valueOf(i11));
                                        StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                                        TextKt.m352TextNvy7gAk(str2, null, ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal)).typography.bodySmall, gapComposer3, 0, 0, 131066);
                                        gapComposer3 = gapComposer3;
                                        gapComposer3.end(false);
                                    } else {
                                        gapComposer3.startReplaceGroup(-495945552);
                                        gapComposer3.end(false);
                                    }
                                    Fragment$5$$ExternalSyntheticOutline0.m(gapComposer3, true, true, false);
                                } else {
                                    gapComposer2.skipToGroupEnd();
                                }
                                return Unit.INSTANCE;
                            }
                        }));
                        return Unit.INSTANCE;
                    }
                };
                gapComposer.updateRememberedValue(function2);
                objRememberedValue = function2;
            } else {
                i5 = i4;
            }
            ListDialog(function0, 0, (Function1) objRememberedValue, gapComposer, i5 & 14);
            function6 = function7;
        } else {
            gapComposer.skipToGroupEnd();
            function6 = function5;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.metrolist.music.ui.component.EnumDialogKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    ((Integer) obj3).getClass();
                    DialogKt.EnumDialog(function0, function1, str, obj, list, function3, function6, (Composer) obj2, Stack.updateChangedFlags(i | 1), i2);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0274  */
    /* JADX WARN: Code duplicated, block: B:104:0x02ad  */
    /* JADX WARN: Code duplicated, block: B:107:0x02e8  */
    /* JADX WARN: Code duplicated, block: B:109:0x02fa  */
    /* JADX WARN: Code duplicated, block: B:112:0x0305  */
    /* JADX WARN: Code duplicated, block: B:119:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:27:0x0053  */
    /* JADX WARN: Code duplicated, block: B:28:0x0055  */
    /* JADX WARN: Code duplicated, block: B:31:0x005e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:32:0x0060  */
    /* JADX WARN: Code duplicated, block: B:33:0x0062  */
    /* JADX WARN: Code duplicated, block: B:36:0x0067  */
    /* JADX WARN: Code duplicated, block: B:37:0x006a  */
    /* JADX WARN: Code duplicated, block: B:40:0x0075  */
    /* JADX WARN: Code duplicated, block: B:43:0x0091  */
    /* JADX WARN: Code duplicated, block: B:46:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:47:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:50:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:51:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:55:0x00e1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:56:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:74:0x0159  */
    /* JADX WARN: Code duplicated, block: B:78:0x0189  */
    /* JADX WARN: Code duplicated, block: B:79:0x018f  */
    /* JADX WARN: Code duplicated, block: B:82:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:84:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:88:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:94:0x0226  */
    /* JADX WARN: Code duplicated, block: B:97:0x025e  */
    /* JADX WARN: Code duplicated, block: B:99:0x0270  */
    public static final void ExpandableText(final String str, List list, Modifier modifier, Composer composer, final int i, final int i2) {
        List list2;
        int i3;
        Modifier modifier2;
        boolean z;
        final List list3;
        final Modifier modifier3;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        List list4;
        Modifier.Companion companion;
        Modifier modifier4;
        Object objRememberedValue;
        NeverEqualPolicy neverEqualPolicy;
        MutableState mutableState;
        Object objRememberedValue2;
        byte b;
        MutableState mutableState2;
        UriHandler uriHandler;
        boolean z2;
        boolean z3;
        boolean zChanged;
        Object objRememberedValue3;
        AnnotatedString annotatedString;
        long j;
        AnnotatedString annotatedString2;
        StaticProvidableCompositionLocal staticProvidableCompositionLocal;
        int i4;
        boolean zChanged2;
        Object objRememberedValue4;
        boolean zChanged3;
        Object objRememberedValue5;
        AnnotatedString annotatedString3;
        MutableState mutableState3;
        MutableState mutableState4;
        int i5;
        MutableState mutableState5;
        boolean zChanged4;
        Object objRememberedValue6;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(789354139);
        int i6 = (gapComposer.changed(str) ? 4 : 2) | i;
        int i7 = i2 & 2;
        if (i7 != 0) {
            i3 = i6 | 48;
            list2 = list;
        } else {
            list2 = list;
            i3 = i6 | (gapComposer.changed(list2) ? 32 : 16);
        }
        int i8 = i2 & 4;
        if (i8 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= gapComposer.changed(modifier2) ? 256 : 128;
            }
            if ((i3 & 1171) != 1170) {
                z = true;
            } else {
                z = false;
            }
            if (gapComposer.shouldExecute(i3 & 1, z)) {
                if (i7 != 0) {
                    list4 = null;
                } else {
                    list4 = list2;
                }
                companion = Modifier.Companion.$$INSTANCE;
                if (i8 != 0) {
                    modifier4 = companion;
                } else {
                    modifier4 = modifier2;
                }
                Object[] objArr = new Object[0];
                objRememberedValue = gapComposer.rememberedValue();
                neverEqualPolicy = Composer.Companion.Empty;
                if (objRememberedValue == neverEqualPolicy) {
                    objRememberedValue = new CachedItem$$ExternalSyntheticLambda0((byte) 13);
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) SaverKt.rememberSaveable(objArr, (Function0) objRememberedValue, gapComposer, 48);
                Object[] objArr2 = new Object[0];
                objRememberedValue2 = gapComposer.rememberedValue();
                b = 14;
                if (objRememberedValue2 == neverEqualPolicy) {
                    objRememberedValue2 = new CachedItem$$ExternalSyntheticLambda0(b);
                    gapComposer.updateRememberedValue(objRememberedValue2);
                }
                mutableState2 = (MutableState) SaverKt.rememberSaveable(objArr2, (Function0) objRememberedValue2, gapComposer, 48);
                uriHandler = (UriHandler) gapComposer.consume(CompositionLocalsKt.LocalUriHandler);
                StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = MaterialThemeKt._localMaterialTheme;
                long j2 = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal2)).colorScheme.primary;
                long j3 = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal2)).colorScheme.onSurfaceVariant;
                if ((i3 & 14) == 4) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if ((i3 & 112) != 32) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                zChanged = z3 | z2 | gapComposer.changed(j2);
                objRememberedValue3 = gapComposer.rememberedValue();
                if (zChanged || objRememberedValue3 == neverEqualPolicy) {
                    if (list4 != null || list4.isEmpty()) {
                        annotatedString = new AnnotatedString(str);
                    } else {
                        AnnotatedString.Builder builder = new AnnotatedString.Builder();
                        Iterator it = list4.iterator();
                        while (it.hasNext()) {
                            LinkSegment linkSegment = (LinkSegment) it.next();
                            String str2 = linkSegment.url;
                            String str3 = linkSegment.text;
                            if (str2 != null) {
                                builder.pushStringAnnotation("URL", str2);
                                j = j2;
                                int iPushStyle = builder.pushStyle(new SpanStyle(j, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, 65534));
                                try {
                                    builder.append(str3);
                                    builder.pop(iPushStyle);
                                    builder.pop();
                                } catch (Throwable th) {
                                    builder.pop(iPushStyle);
                                    throw th;
                                }
                            } else {
                                j = j2;
                                builder.append(str3);
                            }
                            it = it;
                            j2 = j;
                        }
                        annotatedString = builder.toAnnotatedString();
                    }
                    objRememberedValue3 = annotatedString;
                    gapComposer.updateRememberedValue(objRememberedValue3);
                }
                annotatedString2 = (AnnotatedString) objRememberedValue3;
                ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start, gapComposer, 0);
                Modifier modifier5 = modifier4;
                int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifier5);
                ComposeUiNode.Companion.getClass();
                gapComposer.startReusableNode();
                if (gapComposer.inserting) {
                    gapComposer.createNode(LayoutNode.Constructor);
                } else {
                    gapComposer.useNode();
                }
                Stack.m390setimpl(gapComposer, columnMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
                Stack.m389reconcileimpl(gapComposer);
                Stack.m390setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                TextStyle textStyleM750copyp1EtxEg$default = TextStyle.m750copyp1EtxEg$default(((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).typography.bodyMedium, j3, 0L, null, null, null, null, 0L, 0L, null, null, 16777214);
                if (((Boolean) mutableState.getValue()).booleanValue()) {
                    i4 = Integer.MAX_VALUE;
                } else {
                    i4 = 3;
                }
                int i9 = i4;
                zChanged2 = gapComposer.changed(mutableState2);
                objRememberedValue4 = gapComposer.rememberedValue();
                if (zChanged2 || objRememberedValue4 == neverEqualPolicy) {
                    objRememberedValue4 = new TooltipKt$$ExternalSyntheticLambda5(mutableState2, (byte) 11);
                    gapComposer.updateRememberedValue(objRememberedValue4);
                }
                Function1 function1 = (Function1) objRememberedValue4;
                zChanged3 = gapComposer.changed(annotatedString2) | gapComposer.changedInstance(uriHandler) | gapComposer.changed(mutableState2) | gapComposer.changed(mutableState);
                objRememberedValue5 = gapComposer.rememberedValue();
                if (!zChanged3 || objRememberedValue5 == neverEqualPolicy) {
                    annotatedString3 = annotatedString2;
                    mutableState3 = mutableState2;
                    mutableState4 = mutableState;
                    objRememberedValue5 = new MainActivity$$ExternalSyntheticLambda59((Object) annotatedString3, (Object) uriHandler, (Object) mutableState3, (Object) mutableState4, (byte) 10);
                    gapComposer.updateRememberedValue(objRememberedValue5);
                } else {
                    annotatedString3 = annotatedString2;
                    mutableState3 = mutableState2;
                    mutableState4 = mutableState;
                }
                List list5 = list4;
                BasicTextKt.m188ClickableText4YKlhWE(annotatedString3, null, textStyleM750copyp1EtxEg$default, false, 2, i9, function1, (Function1) objRememberedValue5, gapComposer, 24576, 10);
                if (((Boolean) mutableState3.getValue()).booleanValue()) {
                    gapComposer.startReplaceGroup(-1895419290);
                    if (((Boolean) mutableState4.getValue()).booleanValue()) {
                        i5 = R.string.show_less;
                    } else {
                        i5 = R.string.show_more;
                    }
                    String strStringResource = MathKt.stringResource(i5, gapComposer);
                    TextStyle textStyle = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).typography.labelLarge;
                    long j4 = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.primary;
                    Modifier modifierM139paddingqDBjuR0$default = OffsetKt.m139paddingqDBjuR0$default(companion, CropImageView.DEFAULT_ASPECT_RATIO, 4.0f, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 13);
                    mutableState5 = mutableState4;
                    zChanged4 = gapComposer.changed(mutableState5);
                    objRememberedValue6 = gapComposer.rememberedValue();
                    if (zChanged4 || objRememberedValue6 == neverEqualPolicy) {
                        objRememberedValue6 = new MainActivity$$ExternalSyntheticLambda29(mutableState5, (byte) 14);
                        gapComposer.updateRememberedValue(objRememberedValue6);
                    }
                    TextKt.m352TextNvy7gAk(strStringResource, ImageKt.m46clickableoSLSa3U$default(modifierM139paddingqDBjuR0$default, false, null, (Function0) objRememberedValue6, 15), j4, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, textStyle, gapComposer, 0, 0, 131064);
                    gapComposer = gapComposer;
                    gapComposer.end(false);
                } else {
                    gapComposer.startReplaceGroup(-1895048995);
                    gapComposer.end(false);
                }
                gapComposer.end(true);
                modifier3 = modifier5;
                list3 = list5;
            } else {
                gapComposer.skipToGroupEnd();
                list3 = list2;
                modifier3 = modifier2;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.metrolist.music.ui.component.ExpandableTextKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        DialogKt.ExpandableText(str, list3, modifier3, (Composer) obj, Stack.updateChangedFlags(i | 1), i2);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        if ((i3 & 1171) != 1170) {
            z = true;
        } else {
            z = false;
        }
        if (gapComposer.shouldExecute(i3 & 1, z)) {
            if (i7 != 0) {
                list4 = null;
            } else {
                list4 = list2;
            }
            companion = Modifier.Companion.$$INSTANCE;
            if (i8 != 0) {
                modifier4 = companion;
            } else {
                modifier4 = modifier2;
            }
            Object[] objArr3 = new Object[0];
            objRememberedValue = gapComposer.rememberedValue();
            neverEqualPolicy = Composer.Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = new CachedItem$$ExternalSyntheticLambda0((byte) 13);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            mutableState = (MutableState) SaverKt.rememberSaveable(objArr3, (Function0) objRememberedValue, gapComposer, 48);
            Object[] objArr4 = new Object[0];
            objRememberedValue2 = gapComposer.rememberedValue();
            b = 14;
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new CachedItem$$ExternalSyntheticLambda0(b);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            mutableState2 = (MutableState) SaverKt.rememberSaveable(objArr4, (Function0) objRememberedValue2, gapComposer, 48);
            uriHandler = (UriHandler) gapComposer.consume(CompositionLocalsKt.LocalUriHandler);
            StaticProvidableCompositionLocal staticProvidableCompositionLocal3 = MaterialThemeKt._localMaterialTheme;
            long j5 = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal3)).colorScheme.primary;
            long j6 = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal3)).colorScheme.onSurfaceVariant;
            if ((i3 & 14) == 4) {
                z2 = true;
            } else {
                z2 = false;
            }
            if ((i3 & 112) != 32) {
                z3 = false;
            } else {
                z3 = true;
            }
            zChanged = z3 | z2 | gapComposer.changed(j5);
            objRememberedValue3 = gapComposer.rememberedValue();
            if (zChanged) {
                if (list4 != null) {
                    annotatedString = new AnnotatedString(str);
                } else {
                    annotatedString = new AnnotatedString(str);
                }
                objRememberedValue3 = annotatedString;
                gapComposer.updateRememberedValue(objRememberedValue3);
            } else {
                if (list4 != null) {
                    annotatedString = new AnnotatedString(str);
                } else {
                    annotatedString = new AnnotatedString(str);
                }
                objRememberedValue3 = annotatedString;
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            annotatedString2 = (AnnotatedString) objRememberedValue3;
            ColumnMeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start, gapComposer, 0);
            Modifier modifier6 = modifier4;
            int iHashCode2 = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer, modifier6);
            ComposeUiNode.Companion.getClass();
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(LayoutNode.Constructor);
            } else {
                gapComposer.useNode();
            }
            Stack.m390setimpl(gapComposer, columnMeasurePolicy2, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode2), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m389reconcileimpl(gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier2, ComposeUiNode.Companion.SetModifier);
            staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
            TextStyle textStyleM750copyp1EtxEg$default2 = TextStyle.m750copyp1EtxEg$default(((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).typography.bodyMedium, j6, 0L, null, null, null, null, 0L, 0L, null, null, 16777214);
            if (((Boolean) mutableState.getValue()).booleanValue()) {
                i4 = Integer.MAX_VALUE;
            } else {
                i4 = 3;
            }
            int i10 = i4;
            zChanged2 = gapComposer.changed(mutableState2);
            objRememberedValue4 = gapComposer.rememberedValue();
            if (zChanged2) {
                objRememberedValue4 = new TooltipKt$$ExternalSyntheticLambda5(mutableState2, (byte) 11);
                gapComposer.updateRememberedValue(objRememberedValue4);
            } else {
                objRememberedValue4 = new TooltipKt$$ExternalSyntheticLambda5(mutableState2, (byte) 11);
                gapComposer.updateRememberedValue(objRememberedValue4);
            }
            Function1 function2 = (Function1) objRememberedValue4;
            zChanged3 = gapComposer.changed(annotatedString2) | gapComposer.changedInstance(uriHandler) | gapComposer.changed(mutableState2) | gapComposer.changed(mutableState);
            objRememberedValue5 = gapComposer.rememberedValue();
            if (zChanged3) {
                annotatedString3 = annotatedString2;
                mutableState3 = mutableState2;
                mutableState4 = mutableState;
                objRememberedValue5 = new MainActivity$$ExternalSyntheticLambda59((Object) annotatedString3, (Object) uriHandler, (Object) mutableState3, (Object) mutableState4, (byte) 10);
                gapComposer.updateRememberedValue(objRememberedValue5);
            } else {
                annotatedString3 = annotatedString2;
                mutableState3 = mutableState2;
                mutableState4 = mutableState;
                objRememberedValue5 = new MainActivity$$ExternalSyntheticLambda59((Object) annotatedString3, (Object) uriHandler, (Object) mutableState3, (Object) mutableState4, (byte) 10);
                gapComposer.updateRememberedValue(objRememberedValue5);
            }
            List list6 = list4;
            BasicTextKt.m188ClickableText4YKlhWE(annotatedString3, null, textStyleM750copyp1EtxEg$default2, false, 2, i10, function2, (Function1) objRememberedValue5, gapComposer, 24576, 10);
            if (((Boolean) mutableState3.getValue()).booleanValue()) {
                gapComposer.startReplaceGroup(-1895419290);
                if (((Boolean) mutableState4.getValue()).booleanValue()) {
                    i5 = R.string.show_less;
                } else {
                    i5 = R.string.show_more;
                }
                String strStringResource2 = MathKt.stringResource(i5, gapComposer);
                TextStyle textStyle2 = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).typography.labelLarge;
                long j7 = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.primary;
                Modifier modifierM139paddingqDBjuR0$default2 = OffsetKt.m139paddingqDBjuR0$default(companion, CropImageView.DEFAULT_ASPECT_RATIO, 4.0f, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 13);
                mutableState5 = mutableState4;
                zChanged4 = gapComposer.changed(mutableState5);
                objRememberedValue6 = gapComposer.rememberedValue();
                if (zChanged4) {
                    objRememberedValue6 = new MainActivity$$ExternalSyntheticLambda29(mutableState5, (byte) 14);
                    gapComposer.updateRememberedValue(objRememberedValue6);
                } else {
                    objRememberedValue6 = new MainActivity$$ExternalSyntheticLambda29(mutableState5, (byte) 14);
                    gapComposer.updateRememberedValue(objRememberedValue6);
                }
                TextKt.m352TextNvy7gAk(strStringResource2, ImageKt.m46clickableoSLSa3U$default(modifierM139paddingqDBjuR0$default2, false, null, (Function0) objRememberedValue6, 15), j7, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, textStyle2, gapComposer, 0, 0, 131064);
                gapComposer = gapComposer;
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(-1895048995);
                gapComposer.end(false);
            }
            gapComposer.end(true);
            modifier3 = modifier6;
            list3 = list6;
        } else {
            gapComposer.skipToGroupEnd();
            list3 = list2;
            modifier3 = modifier2;
        }
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.metrolist.music.ui.component.ExpandableTextKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    DialogKt.ExpandableText(str, list3, modifier3, (Composer) obj, Stack.updateChangedFlags(i | 1), i2);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX WARN: Code duplicated, block: B:205:0x06b6  */
    /* JADX WARN: Code duplicated, block: B:208:0x06ca  */
    /* JADX WARN: Code duplicated, block: B:209:0x06d7  */
    /* JADX WARN: Code duplicated, block: B:212:0x06e9  */
    /* JADX WARN: Code duplicated, block: B:215:0x06fc  */
    /* JADX WARN: Code duplicated, block: B:218:0x0710  */
    /* JADX WARN: Code duplicated, block: B:221:0x072e  */
    /* JADX WARN: Code duplicated, block: B:224:0x0746  */
    /* JADX WARN: Code duplicated, block: B:227:0x0759  */
    /* JADX WARN: Code duplicated, block: B:230:0x076c  */
    /* JADX WARN: Code duplicated, block: B:233:0x077d  */
    /* JADX WARN: Code duplicated, block: B:236:0x078e  */
    /* JADX WARN: Code duplicated, block: B:239:0x07a4  */
    /* JADX WARN: Code duplicated, block: B:240:0x07b1  */
    /* JADX WARN: Code duplicated, block: B:243:0x07c5  */
    /* JADX WARN: Code duplicated, block: B:246:0x07d1  */
    /* JADX WARN: Code duplicated, block: B:249:0x07e2  */
    /* JADX WARN: Code duplicated, block: B:257:0x07ff  */
    /* JADX WARN: Code duplicated, block: B:260:0x0809  */
    /* JADX WARN: Code duplicated, block: B:261:0x0816  */
    /* JADX WARN: Code duplicated, block: B:267:0x0838  */
    /* JADX WARN: Code duplicated, block: B:273:0x0862  */
    /* JADX WARN: Code duplicated, block: B:277:0x088e  */
    /* JADX WARN: Code duplicated, block: B:280:0x089b  */
    /* JADX WARN: Code duplicated, block: B:281:0x08a8  */
    /* JADX WARN: Code duplicated, block: B:284:0x08cb  */
    /* JADX WARN: Code duplicated, block: B:285:0x08cd  */
    /* JADX WARN: Code duplicated, block: B:291:0x08fb  */
    /* JADX WARN: Code duplicated, block: B:297:0x0953  */
    /* JADX WARN: Code duplicated, block: B:303:0x098e  */
    /* JADX WARN: Code duplicated, block: B:306:0x09ad  */
    /* JADX WARN: Code duplicated, block: B:312:0x09df  */
    /* JADX WARN: Code duplicated, block: B:315:0x0a08  */
    /* JADX WARN: Code duplicated, block: B:318:0x0a19  */
    /* JADX WARN: Code duplicated, block: B:321:0x0a2a  */
    /* JADX WARN: Code duplicated, block: B:325:0x0a4a  */
    /* JADX WARN: Code duplicated, block: B:329:0x0a6c  */
    /* JADX WARN: Code duplicated, block: B:335:0x0a97  */
    /* JADX WARN: Code duplicated, block: B:338:0x0ac3  */
    /* JADX WARN: Code duplicated, block: B:339:0x0ac5  */
    /* JADX WARN: Code duplicated, block: B:345:0x0ad7  */
    /* JADX WARN: Code duplicated, block: B:348:0x0b66  */
    /* JADX WARN: Code duplicated, block: B:350:0x0b74  */
    /* JADX WARN: Code duplicated, block: B:352:0x0b94  */
    /* JADX WARN: Code duplicated, block: B:370:0x0c1d  */
    /* JADX WARN: Code duplicated, block: B:389:0x0cf8  */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void ExperimentalLyrics(final Function0 function0, final Modifier modifier, final boolean z, final LyricsViewModel lyricsViewModel, Composer composer, final int i) {
        int i2;
        GapComposer gapComposer;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        Function2 function2;
        String str;
        ArrayList arrayList;
        Object[] objArr;
        NeverEqualPolicy neverEqualPolicy;
        String str2;
        boolean z2;
        LyricsEntity lyricsEntity;
        MutableState mutableState;
        DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1;
        Context context;
        final MutableState mutableState2;
        final MutableState mutableState3;
        GapComposer gapComposer2;
        NeverEqualPolicy neverEqualPolicy2;
        Continuation continuation;
        Object objRememberedValue;
        EmptySet emptySet;
        final MutableState mutableState4;
        Object objRememberedValue2;
        final ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState;
        Object objRememberedValue3;
        MutableState mutableState5;
        Object objRememberedValue4;
        ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState;
        Object objRememberedValue5;
        final ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState2;
        Object objRememberedValue6;
        byte b;
        final ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState2;
        Object objRememberedValue7;
        MutableState mutableState6;
        Object objRememberedValue8;
        MutableState mutableState7;
        Object objRememberedValue9;
        final MutableState mutableState8;
        Object objRememberedValue10;
        MutableState mutableState9;
        Object objRememberedValue11;
        Object objRememberedValue12;
        MutableState mutableState10;
        Object objRememberedValue13;
        SnapshotStateList snapshotStateList;
        Object objRememberedValue14;
        final MutableState mutableState11;
        final LyricsEntity lyricsEntity2;
        boolean z3;
        Object objRememberedValue15;
        MutableState mutableState12;
        boolean zChanged;
        Object objRememberedValue16;
        boolean zChangedInstance;
        Object objRememberedValue17;
        boolean zChanged2;
        Object objRememberedValue18;
        ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState3;
        Object objRememberedValue19;
        ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState3;
        boolean z4;
        boolean zChanged3;
        Object objRememberedValue20;
        ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState4;
        final PlayerConnection playerConnection;
        boolean zChanged4;
        Object objRememberedValue21;
        Continuation continuation2;
        boolean zChanged5;
        Object objRememberedValue22;
        Continuation continuation3;
        Object objRememberedValue23;
        final ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState;
        boolean zChanged6;
        Object objRememberedValue24;
        SnapshotStateList snapshotStateList2;
        MutableState mutableState13;
        final MutableState mutableState14;
        Object objRememberedValue25;
        Object objRememberedValue26;
        Object objRememberedValue27;
        boolean zChanged7;
        Object objRememberedValue28;
        boolean zChanged8;
        Object objRememberedValue29;
        boolean zChanged9;
        MutableState mutableState15;
        Object objDerivedStateOf;
        Context context2;
        boolean z5;
        boolean z6;
        Object objRememberedValue30;
        NeverEqualPolicy neverEqualPolicy3;
        GapComposer gapComposer3;
        NeverEqualPolicy neverEqualPolicy4;
        boolean z7;
        GapComposer gapComposer4;
        MutableState mutableState16;
        GapComposer gapComposer5;
        String str3;
        String str4;
        String str5;
        Object objRememberedValue31;
        String str6;
        function0.getClass();
        GapComposer gapComposer6 = (GapComposer) composer;
        gapComposer6.startRestartGroup(1313053917);
        if ((i & 6) == 0) {
            i2 = (gapComposer6.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer6.changed(modifier) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer6.changed(z) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= (i & 4096) == 0 ? gapComposer6.changed(lyricsViewModel) : gapComposer6.changedInstance(lyricsViewModel) ? 2048 : 1024;
        }
        int i3 = i2;
        if (gapComposer6.shouldExecute(i3 & 1, (i3 & 1171) != 1170)) {
            gapComposer6.startDefaults();
            if ((i & 1) != 0 && !gapComposer6.getDefaultsInvalid()) {
                gapComposer6.skipToGroupEnd();
            }
            gapComposer6.endDefaults();
            PlayerConnection playerConnection2 = (PlayerConnection) gapComposer6.consume(MainActivityKt.LocalPlayerConnection);
            if (playerConnection2 == null) {
                recomposeScopeImplEndRestartGroup = gapComposer6.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup == null) {
                    return;
                }
                final byte b2 = 0;
                function2 = new Function2() { // from class: com.metrolist.music.ui.component.ExperimentalLyricsKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        byte b3 = b2;
                        Unit unit = Unit.INSTANCE;
                        int i4 = i;
                        switch (b3) {
                            case 0:
                                ((Integer) obj2).getClass();
                                int iUpdateChangedFlags = Stack.updateChangedFlags(i4 | 1);
                                DialogKt.ExperimentalLyrics(function0, modifier, z, lyricsViewModel, (Composer) obj, iUpdateChangedFlags);
                                break;
                            default:
                                ((Integer) obj2).getClass();
                                int iUpdateChangedFlags2 = Stack.updateChangedFlags(i4 | 1);
                                DialogKt.ExperimentalLyrics(function0, modifier, z, lyricsViewModel, (Composer) obj, iUpdateChangedFlags2);
                                break;
                        }
                        return unit;
                    }
                };
            } else {
                MusicDatabase musicDatabase = (MusicDatabase) gapComposer6.consume(MainActivityKt.LocalDatabase);
                final Density density = (Density) gapComposer6.consume(CompositionLocalsKt.LocalDensity);
                StaticProvidableCompositionLocal staticProvidableCompositionLocal = AndroidCompositionLocals_androidKt.LocalContext;
                Context context3 = (Context) gapComposer6.consume(staticProvidableCompositionLocal);
                Configuration configuration = (Configuration) gapComposer6.consume(AndroidCompositionLocals_androidKt.LocalConfiguration);
                ListenTogetherManager listenTogetherManager = (ListenTogetherManager) gapComposer6.consume(MainActivityKt.LocalListenTogetherManager);
                final boolean z8 = (listenTogetherManager == null || !listenTogetherManager.client.isInRoom() || listenTogetherManager.isHost()) ? false : true;
                Preferences$Key preferences$Key = PreferenceKeysKt.LyricsTextPositionKey;
                Context context4 = (Context) gapComposer6.consume(staticProvidableCompositionLocal);
                Object objRememberedValue32 = gapComposer6.rememberedValue();
                NeverEqualPolicy neverEqualPolicy5 = Composer.Companion.Empty;
                if (objRememberedValue32 == neverEqualPolicy5) {
                    objRememberedValue32 = Stack.createCompositionCoroutineScope(gapComposer6);
                    gapComposer6.updateRememberedValue(objRememberedValue32);
                }
                CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue32;
                Object objRememberedValue33 = gapComposer6.rememberedValue();
                if (objRememberedValue33 == neverEqualPolicy5) {
                    objRememberedValue33 = StateFlowKt.distinctUntilChanged(new MainActivity$MetrolistApp$$inlined$rememberEnumPreference$1(UtilsKt.getDataStore(context4).getData(), preferences$Key, (byte) 4));
                    gapComposer6.updateRememberedValue(objRememberedValue33);
                }
                MutableState mutableStateCollectAsStateWithLifecycle = FileSystemsKt.collectAsStateWithLifecycle((Flow) objRememberedValue33, LyricsPosition.CENTER, gapComposer6, 48);
                Object objRememberedValue34 = gapComposer6.rememberedValue();
                if (objRememberedValue34 == neverEqualPolicy5) {
                    objRememberedValue34 = new ExperimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$2(mutableStateCollectAsStateWithLifecycle, coroutineScope, context4, preferences$Key);
                    gapComposer6.updateRememberedValue(objRememberedValue34);
                }
                final ExperimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$2 experimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$2 = (ExperimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$2) objRememberedValue34;
                Preferences$Key preferences$Key2 = PreferenceKeysKt.LyricsClickKey;
                Boolean bool = Boolean.TRUE;
                final DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference = UtilsKt.rememberPreference(preferences$Key2, bool, gapComposer6, 48);
                DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference2 = UtilsKt.rememberPreference(PreferenceKeysKt.LyricsRomanizeList, "", gapComposer6, 48);
                Preferences$Key preferences$Key3 = PreferenceKeysKt.LyricsRomanizeAsMainKey;
                Boolean bool2 = Boolean.FALSE;
                final DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference3 = UtilsKt.rememberPreference(preferences$Key3, bool2, gapComposer6, 48);
                DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference4 = UtilsKt.rememberPreference(PreferenceKeysKt.LyricsRomanizeCyrillicByLineKey, bool2, gapComposer6, 48);
                final DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference5 = UtilsKt.rememberPreference(PreferenceKeysKt.RespectAgentPositioningKey, bool, gapComposer6, 48);
                DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference6 = UtilsKt.rememberPreference(PreferenceKeysKt.ShowIntervalIndicatorKey, bool, gapComposer6, 48);
                DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference7 = UtilsKt.rememberPreference(PreferenceKeysKt.OpenRouterApiKey, "", gapComposer6, 48);
                DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference8 = UtilsKt.rememberPreference(PreferenceKeysKt.DeeplApiKey, "", gapComposer6, 48);
                DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference9 = UtilsKt.rememberPreference(PreferenceKeysKt.AiProviderKey, "OpenRouter", gapComposer6, 48);
                DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference10 = UtilsKt.rememberPreference(PreferenceKeysKt.OpenRouterBaseUrlKey, "https://openrouter.ai/api/v1/chat/completions", gapComposer6, 48);
                DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference11 = UtilsKt.rememberPreference(PreferenceKeysKt.OpenRouterModelKey, "google/gemini-2.5-flash-lite", gapComposer6, 48);
                DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference12 = UtilsKt.rememberPreference(PreferenceKeysKt.TranslateLanguageKey, "en", gapComposer6, 48);
                DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference13 = UtilsKt.rememberPreference(PreferenceKeysKt.TranslateModeKey, "Literal", gapComposer6, 48);
                DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference14 = UtilsKt.rememberPreference(PreferenceKeysKt.DeeplFormalityKey, "default", gapComposer6, 48);
                DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference15 = UtilsKt.rememberPreference(PreferenceKeysKt.AiSystemPromptKey, "", gapComposer6, 48);
                Object objRememberedValue35 = gapComposer6.rememberedValue();
                if (objRememberedValue35 == neverEqualPolicy5) {
                    objRememberedValue35 = Stack.createCompositionCoroutineScope(gapComposer6);
                    gapComposer6.updateRememberedValue(objRememberedValue35);
                }
                final CoroutineScope coroutineScope2 = (CoroutineScope) objRememberedValue35;
                final MutableState mutableStateCollectAsStateWithLifecycle2 = FileSystemsKt.collectAsStateWithLifecycle(playerConnection2.mediaMetadata, gapComposer6);
                final MutableState mutableStateCollectAsStateWithLifecycle3 = FileSystemsKt.collectAsStateWithLifecycle(LyricsTranslationHelper.status, gapComposer6);
                MutableState mutableStateCollectAsStateWithLifecycle4 = FileSystemsKt.collectAsStateWithLifecycle(playerConnection2.currentLyrics, null, gapComposer6, 48);
                Object objRememberedValue36 = gapComposer6.rememberedValue();
                if (objRememberedValue36 == neverEqualPolicy5) {
                    objRememberedValue36 = Stack.mutableStateOf$default(null);
                    gapComposer6.updateRememberedValue(objRememberedValue36);
                }
                MutableState mutableState17 = (MutableState) objRememberedValue36;
                LyricsEntity lyricsEntity3 = (LyricsEntity) mutableStateCollectAsStateWithLifecycle4.getValue();
                boolean zChanged10 = gapComposer6.changed(mutableStateCollectAsStateWithLifecycle4);
                Object objRememberedValue37 = gapComposer6.rememberedValue();
                if (zChanged10 || objRememberedValue37 == neverEqualPolicy5) {
                    objRememberedValue37 = new ArtistScreenKt$ArtistScreen$1$1(mutableStateCollectAsStateWithLifecycle4, mutableState17, null, (byte) 1);
                    gapComposer6.updateRememberedValue(objRememberedValue37);
                }
                Stack.LaunchedEffect(gapComposer6, lyricsEntity3, (Function2) objRememberedValue37);
                boolean zChanged11 = gapComposer6.changed((LyricsEntity) mutableStateCollectAsStateWithLifecycle4.getValue()) | gapComposer6.changed((LyricsTranslationHelper.TranslationStatus) mutableStateCollectAsStateWithLifecycle3.getValue());
                Object objRememberedValue38 = gapComposer6.rememberedValue();
                if (zChanged11 || objRememberedValue38 == neverEqualPolicy5) {
                    if (((LyricsEntity) mutableStateCollectAsStateWithLifecycle4.getValue()) != null) {
                        objRememberedValue38 = (LyricsEntity) mutableStateCollectAsStateWithLifecycle4.getValue();
                    } else {
                        objRememberedValue38 = ((((LyricsTranslationHelper.TranslationStatus) mutableStateCollectAsStateWithLifecycle3.getValue()) instanceof LyricsTranslationHelper.TranslationStatus.Translating) || (((LyricsTranslationHelper.TranslationStatus) mutableStateCollectAsStateWithLifecycle3.getValue()) instanceof LyricsTranslationHelper.TranslationStatus.Success)) ? (LyricsEntity) mutableState17.getValue() : null;
                    }
                    gapComposer6.updateRememberedValue(objRememberedValue38);
                }
                LyricsEntity lyricsEntity4 = (LyricsEntity) objRememberedValue38;
                MutableState mutableStateCollectAsStateWithLifecycle5 = FileSystemsKt.collectAsStateWithLifecycle(playerConnection2.currentSong, null, gapComposer6, 48);
                boolean zChanged12 = gapComposer6.changed(lyricsEntity4);
                Object objRememberedValue39 = gapComposer6.rememberedValue();
                if (zChanged12 || objRememberedValue39 == neverEqualPolicy5) {
                    String string = (lyricsEntity4 == null || (str = lyricsEntity4.lyrics) == null) ? null : StringsKt.trim(str).toString();
                    gapComposer6.updateRememberedValue(string);
                    objRememberedValue39 = string;
                }
                String str7 = (String) objRememberedValue39;
                Preferences$Key preferences$Key4 = PreferenceKeysKt.PlayerBackgroundStyleKey;
                Context context5 = (Context) gapComposer6.consume(staticProvidableCompositionLocal);
                Object objRememberedValue40 = gapComposer6.rememberedValue();
                if (objRememberedValue40 == neverEqualPolicy5) {
                    objRememberedValue40 = Stack.createCompositionCoroutineScope(gapComposer6);
                    gapComposer6.updateRememberedValue(objRememberedValue40);
                }
                CoroutineScope coroutineScope3 = (CoroutineScope) objRememberedValue40;
                Object objRememberedValue41 = gapComposer6.rememberedValue();
                if (objRememberedValue41 == neverEqualPolicy5) {
                    objRememberedValue41 = StateFlowKt.distinctUntilChanged(new MainActivity$MetrolistApp$$inlined$rememberEnumPreference$1(UtilsKt.getDataStore(context5).getData(), preferences$Key4, (byte) 5));
                    gapComposer6.updateRememberedValue(objRememberedValue41);
                }
                MutableState mutableStateCollectAsStateWithLifecycle6 = FileSystemsKt.collectAsStateWithLifecycle((Flow) objRememberedValue41, PlayerBackgroundStyle.DEFAULT, gapComposer6, 48);
                Object objRememberedValue42 = gapComposer6.rememberedValue();
                if (objRememberedValue42 == neverEqualPolicy5) {
                    objRememberedValue42 = new ExperimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$4(mutableStateCollectAsStateWithLifecycle6, coroutineScope3, context5, preferences$Key4);
                    gapComposer6.updateRememberedValue(objRememberedValue42);
                }
                State state = dataStoreKt$rememberPreference$1$1RememberPreference2.$state;
                State state2 = dataStoreKt$rememberPreference$1$1RememberPreference2.$state;
                boolean zChanged13 = gapComposer6.changed((String) state.getValue());
                Object objRememberedValue43 = gapComposer6.rememberedValue();
                Object obj = objRememberedValue43;
                if (zChanged13 || objRememberedValue43 == neverEqualPolicy5) {
                    if (((CharSequence) state2.getValue()).length() == 0) {
                        arrayList = RomanizationSettingsKt.defaultList;
                    } else {
                        int i4 = 6;
                        List listSplit$default = StringsKt.split$default((CharSequence) state2.getValue(), new String[]{","}, 0, 6);
                        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listSplit$default, 10));
                        Iterator it = listSplit$default.iterator();
                        while (it.hasNext()) {
                            List listSplit$default2 = StringsKt.split$default((String) it.next(), new String[]{ServerSentEventKt.COLON}, 0, i4);
                            arrayList2.add(new Pair((String) listSplit$default2.get(0), Boolean.valueOf(Boolean.parseBoolean((String) listSplit$default2.get(1)))));
                            i4 = 6;
                        }
                        arrayList = arrayList2;
                    }
                    ArrayList arrayList3 = new ArrayList();
                    int size = arrayList.size();
                    int i5 = 0;
                    while (i5 < size) {
                        Object obj2 = arrayList.get(i5);
                        i5++;
                        if (((Boolean) ((Pair) obj2).second).booleanValue()) {
                            arrayList3.add(obj2);
                        }
                    }
                    ArrayList arrayList4 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList3, 10));
                    int size2 = arrayList3.size();
                    int i6 = 0;
                    while (i6 < size2) {
                        Object obj3 = arrayList3.get(i6);
                        i6++;
                        arrayList4.add((String) ((Pair) obj3).first);
                    }
                    gapComposer6.updateRememberedValue(arrayList4);
                    obj = arrayList4;
                }
                final List list = (List) obj;
                MutableState mutableStateCollectAsStateWithLifecycle7 = FileSystemsKt.collectAsStateWithLifecycle(lyricsViewModel.lines, gapComposer6);
                MutableState mutableStateCollectAsStateWithLifecycle8 = FileSystemsKt.collectAsStateWithLifecycle(lyricsViewModel.mergedLyricsList, gapComposer6);
                Boolean bool3 = (Boolean) dataStoreKt$rememberPreference$1$1RememberPreference4.$state.getValue();
                bool3.getClass();
                Boolean bool4 = (Boolean) dataStoreKt$rememberPreference$1$1RememberPreference6.$state.getValue();
                bool4.getClass();
                Object[] objArr2 = {str7, list, bool3, bool4};
                boolean zChanged14 = ((((i3 & 7168) ^ 3072) > 2048 && gapComposer6.changedInstance(lyricsViewModel)) || (i3 & 3072) == 2048) | gapComposer6.changed(str7) | gapComposer6.changedInstance(list) | gapComposer6.changed(dataStoreKt$rememberPreference$1$1RememberPreference4) | gapComposer6.changed(dataStoreKt$rememberPreference$1$1RememberPreference6);
                Object objRememberedValue44 = gapComposer6.rememberedValue();
                if (zChanged14 || objRememberedValue44 == neverEqualPolicy5) {
                    objArr = objArr2;
                    neverEqualPolicy = neverEqualPolicy5;
                    NavHostKt$NavHost$33$1 navHostKt$NavHost$33$1 = new NavHostKt$NavHost$33$1(lyricsViewModel, str7, list, dataStoreKt$rememberPreference$1$1RememberPreference4, dataStoreKt$rememberPreference$1$1RememberPreference6, null, (byte) 2);
                    str2 = str7;
                    gapComposer6.updateRememberedValue(navHostKt$NavHost$33$1);
                    objRememberedValue44 = navHostKt$NavHost$33$1;
                } else {
                    objArr = objArr2;
                    str2 = str7;
                    neverEqualPolicy = neverEqualPolicy5;
                }
                Stack.LaunchedEffect(objArr, (Function2) objRememberedValue44, gapComposer6);
                boolean zChanged15 = gapComposer6.changed(str2);
                Object objRememberedValue45 = gapComposer6.rememberedValue();
                if (zChanged15 || objRememberedValue45 == neverEqualPolicy) {
                    objRememberedValue45 = Boolean.valueOf(LyricsFormatKt.lyricsTextLooksSynced(str2));
                    gapComposer6.updateRememberedValue(objRememberedValue45);
                }
                final boolean zBooleanValue = ((Boolean) objRememberedValue45).booleanValue();
                boolean zChanged16 = gapComposer6.changed((List) mutableStateCollectAsStateWithLifecycle7.getValue());
                Object objRememberedValue46 = gapComposer6.rememberedValue();
                if (zChanged16 || objRememberedValue46 == neverEqualPolicy) {
                    List list2 = (List) mutableStateCollectAsStateWithLifecycle7.getValue();
                    if (list2 == null || !list2.isEmpty()) {
                        Iterator it2 = list2.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                z2 = false;
                                break;
                            }
                            List list3 = ((LyricsEntry) it2.next()).words;
                            if (list3 != null && (!list3.isEmpty())) {
                                z2 = true;
                                break;
                            }
                        }
                    } else {
                        z2 = false;
                    }
                    objRememberedValue46 = Boolean.valueOf(z2);
                    gapComposer6.updateRememberedValue(objRememberedValue46);
                }
                boolean zBooleanValue2 = ((Boolean) objRememberedValue46).booleanValue();
                Object objRememberedValue47 = gapComposer6.rememberedValue();
                if (objRememberedValue47 == neverEqualPolicy) {
                    objRememberedValue47 = new AlbumMenuKt$$ExternalSyntheticLambda13((byte) 10);
                    gapComposer6.updateRememberedValue(objRememberedValue47);
                }
                Stack.DisposableEffect(Unit.INSTANCE, (Function1) objRememberedValue47, gapComposer6);
                Object[] objArr3 = {(List) mutableStateCollectAsStateWithLifecycle7.getValue(), lyricsEntity4, (String) dataStoreKt$rememberPreference$1$1RememberPreference12.$state.getValue(), (String) dataStoreKt$rememberPreference$1$1RememberPreference13.$state.getValue()};
                boolean zChanged17 = gapComposer6.changed(mutableStateCollectAsStateWithLifecycle7) | gapComposer6.changedInstance(lyricsEntity4) | gapComposer6.changed(dataStoreKt$rememberPreference$1$1RememberPreference12) | gapComposer6.changed(dataStoreKt$rememberPreference$1$1RememberPreference13);
                Object objRememberedValue48 = gapComposer6.rememberedValue();
                if (zChanged17 || objRememberedValue48 == neverEqualPolicy) {
                    lyricsEntity = lyricsEntity4;
                    objRememberedValue48 = new QueueKt$Queue$5$1$1(lyricsEntity, mutableStateCollectAsStateWithLifecycle7, dataStoreKt$rememberPreference$1$1RememberPreference12, dataStoreKt$rememberPreference$1$1RememberPreference13, null, (byte) 4);
                    mutableState = mutableStateCollectAsStateWithLifecycle7;
                    dataStoreKt$rememberPreference$1$1 = dataStoreKt$rememberPreference$1$1RememberPreference12;
                    gapComposer6.updateRememberedValue(objRememberedValue48);
                } else {
                    lyricsEntity = lyricsEntity4;
                    mutableState = mutableStateCollectAsStateWithLifecycle7;
                    dataStoreKt$rememberPreference$1$1 = dataStoreKt$rememberPreference$1$1RememberPreference12;
                }
                Stack.LaunchedEffect(objArr3, (Function2) objRememberedValue48, gapComposer6);
                Object[] objArr4 = {Boolean.valueOf(z), (List) mutableState.getValue(), (String) dataStoreKt$rememberPreference$1$1RememberPreference9.$state.getValue(), (String) dataStoreKt$rememberPreference$1$1RememberPreference7.$state.getValue(), (String) dataStoreKt$rememberPreference$1$1RememberPreference8.$state.getValue(), (String) dataStoreKt$rememberPreference$1$1RememberPreference10.$state.getValue(), (String) dataStoreKt$rememberPreference$1$1RememberPreference11.$state.getValue(), (String) dataStoreKt$rememberPreference$1$1.$state.getValue(), (String) dataStoreKt$rememberPreference$1$1RememberPreference13.$state.getValue(), (String) dataStoreKt$rememberPreference$1$1RememberPreference14.$state.getValue(), (String) r20.$state.getValue(), (Song) mutableStateCollectAsStateWithLifecycle5.getValue(), musicDatabase};
                final String str8 = str2;
                int i7 = i3 & 896;
                boolean zChanged18 = gapComposer6.changed(dataStoreKt$rememberPreference$1$1RememberPreference9) | gapComposer6.changed(dataStoreKt$rememberPreference$1$1RememberPreference8) | gapComposer6.changed(dataStoreKt$rememberPreference$1$1RememberPreference7) | (i7 == 256) | gapComposer6.changed(mutableState) | gapComposer6.changed(dataStoreKt$rememberPreference$1$1) | gapComposer6.changed(dataStoreKt$rememberPreference$1$1RememberPreference10) | gapComposer6.changed(dataStoreKt$rememberPreference$1$1RememberPreference11) | gapComposer6.changed(dataStoreKt$rememberPreference$1$1RememberPreference13) | gapComposer6.changedInstance(coroutineScope2) | gapComposer6.changedInstance(r22) | gapComposer6.changed(dataStoreKt$rememberPreference$1$1RememberPreference14) | gapComposer6.changed(mutableStateCollectAsStateWithLifecycle5) | gapComposer6.changedInstance(musicDatabase) | gapComposer6.changed(r20);
                Object objRememberedValue49 = gapComposer6.rememberedValue();
                if (zChanged18 || objRememberedValue49 == neverEqualPolicy) {
                    MutableState mutableState18 = mutableState;
                    objRememberedValue49 = new ExperimentalLyricsKt$ExperimentalLyrics$5$1(z, coroutineScope2, r22, musicDatabase, dataStoreKt$rememberPreference$1$1RememberPreference9, dataStoreKt$rememberPreference$1$1RememberPreference8, dataStoreKt$rememberPreference$1$1RememberPreference7, mutableState18, dataStoreKt$rememberPreference$1$1, dataStoreKt$rememberPreference$1$1RememberPreference10, dataStoreKt$rememberPreference$1$1RememberPreference11, dataStoreKt$rememberPreference$1$1RememberPreference13, dataStoreKt$rememberPreference$1$1RememberPreference14, mutableStateCollectAsStateWithLifecycle5, dataStoreKt$rememberPreference$1$1RememberPreference15, null);
                    context = r22;
                    mutableState2 = mutableState18;
                    mutableState3 = mutableStateCollectAsStateWithLifecycle5;
                    GapComposer gapComposer7 = gapComposer6;
                    gapComposer7.updateRememberedValue(objRememberedValue49);
                    gapComposer2 = gapComposer7;
                } else {
                    mutableState3 = mutableStateCollectAsStateWithLifecycle5;
                    gapComposer2 = gapComposer6;
                    context = context3;
                    mutableState2 = mutableState;
                }
                Stack.LaunchedEffect(objArr4, (Function2) objRememberedValue49, gapComposer2);
                List list4 = (List) mutableState2.getValue();
                boolean zChanged19 = gapComposer2.changed(mutableState2);
                Object objRememberedValue50 = gapComposer2.rememberedValue();
                if (zChanged19) {
                    neverEqualPolicy2 = neverEqualPolicy;
                } else {
                    neverEqualPolicy2 = neverEqualPolicy;
                    if (objRememberedValue50 != neverEqualPolicy2) {
                        continuation = null;
                    }
                    Stack.LaunchedEffect(gapComposer2, list4, (Function2) objRememberedValue50);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = MaterialThemeKt._localMaterialTheme;
                    final long j = ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal2)).colorScheme.onSurface;
                    final long j2 = ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal2)).colorScheme.primary;
                    objRememberedValue = gapComposer2.rememberedValue();
                    emptySet = EmptySet.INSTANCE;
                    if (objRememberedValue == neverEqualPolicy2) {
                        objRememberedValue = Stack.mutableStateOf$default(emptySet);
                        gapComposer2.updateRememberedValue(objRememberedValue);
                    }
                    mutableState4 = (MutableState) objRememberedValue;
                    Object[] objArr5 = new Object[0];
                    objRememberedValue2 = gapComposer2.rememberedValue();
                    if (objRememberedValue2 == neverEqualPolicy2) {
                        objRememberedValue2 = new CachedItem$$ExternalSyntheticLambda0((byte) 19);
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    }
                    parcelableSnapshotMutableIntState = (ParcelableSnapshotMutableIntState) SaverKt.rememberSaveable(objArr5, (Function0) objRememberedValue2, gapComposer2, 48);
                    objRememberedValue3 = gapComposer2.rememberedValue();
                    if (objRememberedValue3 == neverEqualPolicy2) {
                        objRememberedValue3 = Stack.mutableStateOf$default(emptySet);
                        gapComposer2.updateRememberedValue(objRememberedValue3);
                    }
                    mutableState5 = (MutableState) objRememberedValue3;
                    objRememberedValue4 = gapComposer2.rememberedValue();
                    if (objRememberedValue4 == neverEqualPolicy2) {
                        objRememberedValue4 = new ParcelableSnapshotMutableLongState(0L);
                        gapComposer2.updateRememberedValue(objRememberedValue4);
                    }
                    parcelableSnapshotMutableLongState = (ParcelableSnapshotMutableLongState) objRememberedValue4;
                    Object[] objArr6 = new Object[0];
                    objRememberedValue5 = gapComposer2.rememberedValue();
                    if (objRememberedValue5 == neverEqualPolicy2) {
                        objRememberedValue5 = new CachedItem$$ExternalSyntheticLambda0((byte) 20);
                        gapComposer2.updateRememberedValue(objRememberedValue5);
                    }
                    parcelableSnapshotMutableIntState2 = (ParcelableSnapshotMutableIntState) SaverKt.rememberSaveable(objArr6, (Function0) objRememberedValue5, gapComposer2, 48);
                    Object[] objArr7 = new Object[0];
                    objRememberedValue6 = gapComposer2.rememberedValue();
                    b = 15;
                    if (objRememberedValue6 == neverEqualPolicy2) {
                        objRememberedValue6 = new CachedItem$$ExternalSyntheticLambda0(b);
                        gapComposer2.updateRememberedValue(objRememberedValue6);
                    }
                    parcelableSnapshotMutableLongState2 = (ParcelableSnapshotMutableLongState) SaverKt.rememberSaveable(objArr7, (Function0) objRememberedValue6, gapComposer2, 48);
                    objRememberedValue7 = gapComposer2.rememberedValue();
                    if (objRememberedValue7 == neverEqualPolicy2) {
                        objRememberedValue7 = Stack.mutableStateOf$default(Boolean.FALSE);
                        gapComposer2.updateRememberedValue(objRememberedValue7);
                    }
                    mutableState6 = (MutableState) objRememberedValue7;
                    objRememberedValue8 = gapComposer2.rememberedValue();
                    if (objRememberedValue8 == neverEqualPolicy2) {
                        objRememberedValue8 = Stack.mutableStateOf$default(Boolean.FALSE);
                        gapComposer2.updateRememberedValue(objRememberedValue8);
                    }
                    mutableState7 = (MutableState) objRememberedValue8;
                    objRememberedValue9 = gapComposer2.rememberedValue();
                    if (objRememberedValue9 == neverEqualPolicy2) {
                        objRememberedValue9 = Stack.mutableStateOf$default(Boolean.FALSE);
                        gapComposer2.updateRememberedValue(objRememberedValue9);
                    }
                    mutableState8 = (MutableState) objRememberedValue9;
                    objRememberedValue10 = gapComposer2.rememberedValue();
                    if (objRememberedValue10 == neverEqualPolicy2) {
                        objRememberedValue10 = Stack.mutableStateOf$default(Boolean.FALSE);
                        gapComposer2.updateRememberedValue(objRememberedValue10);
                    }
                    mutableState9 = (MutableState) objRememberedValue10;
                    objRememberedValue11 = gapComposer2.rememberedValue();
                    if (objRememberedValue11 == neverEqualPolicy2) {
                        objRememberedValue11 = Stack.mutableStateOf$default(continuation);
                        gapComposer2.updateRememberedValue(objRememberedValue11);
                    }
                    final MutableState mutableState19 = (MutableState) objRememberedValue11;
                    Object[] objArr8 = new Object[0];
                    objRememberedValue12 = gapComposer2.rememberedValue();
                    if (objRememberedValue12 == neverEqualPolicy2) {
                        objRememberedValue12 = new CachedItem$$ExternalSyntheticLambda0((byte) 16);
                        gapComposer2.updateRememberedValue(objRememberedValue12);
                    }
                    mutableState10 = (MutableState) SaverKt.rememberSaveable(objArr8, (Function0) objRememberedValue12, gapComposer2, 48);
                    objRememberedValue13 = gapComposer2.rememberedValue();
                    if (objRememberedValue13 == neverEqualPolicy2) {
                        objRememberedValue13 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer2);
                    }
                    snapshotStateList = (SnapshotStateList) objRememberedValue13;
                    objRememberedValue14 = gapComposer2.rememberedValue();
                    if (objRememberedValue14 == neverEqualPolicy2) {
                        objRememberedValue14 = Stack.mutableStateOf$default(Boolean.FALSE);
                        gapComposer2.updateRememberedValue(objRememberedValue14);
                    }
                    mutableState11 = (MutableState) objRememberedValue14;
                    lyricsEntity2 = lyricsEntity;
                    if (lyricsEntity2 != null) {
                        str6 = lyricsEntity2.provider;
                        if (!Intrinsics.areEqual(str6, "Unknown") || Intrinsics.areEqual(str6, "Manual") || ExperimentalLyrics$lambda$71(mutableState10)) {
                            z3 = false;
                        } else {
                            z3 = true;
                        }
                    } else {
                        z3 = false;
                    }
                    Object[] objArr9 = new Object[0];
                    objRememberedValue15 = gapComposer2.rememberedValue();
                    if (objRememberedValue15 == neverEqualPolicy2) {
                        objRememberedValue15 = new CachedItem$$ExternalSyntheticLambda0((byte) 17);
                        gapComposer2.updateRememberedValue(objRememberedValue15);
                    }
                    mutableState12 = (MutableState) SaverKt.rememberSaveable(objArr9, (Function0) objRememberedValue15, gapComposer2, 48);
                    boolean zExperimentalLyrics$lambda$71 = ExperimentalLyrics$lambda$71(mutableState10);
                    zChanged = gapComposer2.changed(mutableState10);
                    objRememberedValue16 = gapComposer2.rememberedValue();
                    if (zChanged || objRememberedValue16 == neverEqualPolicy2) {
                        objRememberedValue16 = new OriginalLyricsKt$$ExternalSyntheticLambda1(snapshotStateList, mutableState10, (byte) 1);
                        gapComposer2.updateRememberedValue(objRememberedValue16);
                    }
                    coil3.util.UtilsKt.BackHandler(zExperimentalLyrics$lambda$71, (Function0) objRememberedValue16, gapComposer2, 0, 0);
                    Boolean bool5 = (Boolean) mutableState11.getValue();
                    bool5.getClass();
                    zChangedInstance = gapComposer2.changedInstance(context);
                    objRememberedValue17 = gapComposer2.rememberedValue();
                    if (zChangedInstance || objRememberedValue17 == neverEqualPolicy2) {
                        objRememberedValue17 = new DownloadUtil.AnonymousClass2(context, mutableState11, continuation, (byte) 23);
                        gapComposer2.updateRememberedValue(objRememberedValue17);
                    }
                    Stack.LaunchedEffect(gapComposer2, bool5, (Function2) objRememberedValue17);
                    zChanged2 = gapComposer2.changed((List) mutableState2.getValue()) | gapComposer2.changed(str8);
                    objRememberedValue18 = gapComposer2.rememberedValue();
                    if (zChanged2 || objRememberedValue18 == neverEqualPolicy2) {
                        objRememberedValue18 = Fragment$5$$ExternalSyntheticOutline0.m(-1, gapComposer2);
                    }
                    parcelableSnapshotMutableIntState3 = (ParcelableSnapshotMutableIntState) objRememberedValue18;
                    objRememberedValue19 = gapComposer2.rememberedValue();
                    if (objRememberedValue19 == neverEqualPolicy2) {
                        objRememberedValue19 = new ParcelableSnapshotMutableLongState(0L);
                        gapComposer2.updateRememberedValue(objRememberedValue19);
                    }
                    parcelableSnapshotMutableLongState3 = (ParcelableSnapshotMutableLongState) objRememberedValue19;
                    List list5 = (List) mutableState2.getValue();
                    boolean zChanged20 = gapComposer2.changed(str8) | gapComposer2.changed(mutableState2) | gapComposer2.changedInstance(playerConnection2);
                    if ((i3 & 14) == 4) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    zChanged3 = zChanged20 | z4 | gapComposer2.changed(mutableState3) | gapComposer2.changed(zBooleanValue2) | gapComposer2.changed(parcelableSnapshotMutableIntState) | gapComposer2.changed(parcelableSnapshotMutableIntState3);
                    objRememberedValue20 = gapComposer2.rememberedValue();
                    if (!zChanged3 || objRememberedValue20 == neverEqualPolicy2) {
                        objRememberedValue20 = new ExperimentalLyricsKt$ExperimentalLyrics$9$1(str8, playerConnection2, function0, zBooleanValue2, mutableState2, mutableState4, mutableState6, parcelableSnapshotMutableLongState, parcelableSnapshotMutableLongState3, mutableState3, parcelableSnapshotMutableIntState, mutableState5, parcelableSnapshotMutableIntState3, null);
                        parcelableSnapshotMutableLongState4 = parcelableSnapshotMutableLongState;
                        mutableState5 = mutableState5;
                        playerConnection = playerConnection2;
                        gapComposer2.updateRememberedValue(objRememberedValue20);
                    } else {
                        playerConnection = playerConnection2;
                        parcelableSnapshotMutableLongState4 = parcelableSnapshotMutableLongState;
                    }
                    Stack.LaunchedEffect(str8, list5, (Function2) objRememberedValue20, gapComposer2);
                    Boolean boolValueOf = Boolean.valueOf(((Boolean) mutableState6.getValue()).booleanValue());
                    Long lValueOf = Long.valueOf(parcelableSnapshotMutableLongState2.getLongValue());
                    zChanged4 = gapComposer2.changed(parcelableSnapshotMutableLongState2);
                    final ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState5 = parcelableSnapshotMutableLongState4;
                    objRememberedValue21 = gapComposer2.rememberedValue();
                    if (!zChanged4 || objRememberedValue21 == neverEqualPolicy2) {
                        continuation2 = null;
                        objRememberedValue21 = new OriginalLyricsKt$OriginalLyrics$11$1(mutableState6, parcelableSnapshotMutableLongState2, continuation2, (byte) 1);
                        gapComposer2.updateRememberedValue(objRememberedValue21);
                    } else {
                        continuation2 = null;
                    }
                    Stack.LaunchedEffect(boolValueOf, lValueOf, (Function2) objRememberedValue21, gapComposer2);
                    Integer numValueOf = Integer.valueOf(parcelableSnapshotMutableIntState.getIntValue());
                    Boolean boolValueOf2 = Boolean.valueOf(ExperimentalLyrics$lambda$78(mutableState12));
                    zChanged5 = gapComposer2.changed(parcelableSnapshotMutableIntState) | gapComposer2.changed(mutableState12) | gapComposer2.changed(parcelableSnapshotMutableIntState2);
                    objRememberedValue22 = gapComposer2.rememberedValue();
                    if (!zChanged5 || objRememberedValue22 == neverEqualPolicy2) {
                        continuation3 = continuation2;
                        objRememberedValue22 = new SyncUtils$createPlaylist$1.AnonymousClass1((Object) parcelableSnapshotMutableIntState, (Object) mutableState12, (Object) parcelableSnapshotMutableIntState2, continuation3, (byte) 9);
                        gapComposer2.updateRememberedValue(objRememberedValue22);
                    } else {
                        continuation3 = continuation2;
                    }
                    Stack.LaunchedEffect(numValueOf, boolValueOf2, (Function2) objRememberedValue22, gapComposer2);
                    objRememberedValue23 = gapComposer2.rememberedValue();
                    if (objRememberedValue23 == neverEqualPolicy2) {
                        objRememberedValue23 = Format$$ExternalSyntheticOutline0.m(CropImageView.DEFAULT_ASPECT_RATIO, gapComposer2);
                    }
                    parcelableSnapshotMutableFloatState = (ParcelableSnapshotMutableFloatState) objRememberedValue23;
                    List list6 = (List) mutableState2.getValue();
                    zChanged6 = gapComposer2.changed(mutableState12) | gapComposer2.changed(parcelableSnapshotMutableIntState) | gapComposer2.changed(parcelableSnapshotMutableIntState2) | gapComposer2.changed(mutableState10);
                    objRememberedValue24 = gapComposer2.rememberedValue();
                    if (!zChanged6 || objRememberedValue24 == neverEqualPolicy2) {
                        snapshotStateList2 = snapshotStateList;
                        objRememberedValue24 = new PlayerKt$BottomSheetPlayer$13$1(snapshotStateList2, mutableState12, parcelableSnapshotMutableFloatState, parcelableSnapshotMutableIntState, parcelableSnapshotMutableIntState2, mutableState10, mutableState5, (Continuation) null);
                        mutableState13 = mutableState12;
                        parcelableSnapshotMutableFloatState = parcelableSnapshotMutableFloatState;
                        mutableState14 = mutableState10;
                        gapComposer2.updateRememberedValue(objRememberedValue24);
                    } else {
                        mutableState14 = mutableState10;
                        mutableState13 = mutableState12;
                        snapshotStateList2 = snapshotStateList;
                    }
                    Stack.LaunchedEffect(str8, list6, (Function2) objRememberedValue24, gapComposer2);
                    objRememberedValue25 = gapComposer2.rememberedValue();
                    if (objRememberedValue25 == neverEqualPolicy2) {
                        objRememberedValue25 = Stack.mutableStateOf$default(continuation3);
                        gapComposer2.updateRememberedValue(objRememberedValue25);
                    }
                    final MutableState mutableState20 = (MutableState) objRememberedValue25;
                    objRememberedValue26 = gapComposer2.rememberedValue();
                    if (objRememberedValue26 == neverEqualPolicy2) {
                        objRememberedValue26 = new VelocityTracker();
                        gapComposer2.updateRememberedValue(objRememberedValue26);
                    }
                    final VelocityTracker velocityTracker = (VelocityTracker) objRememberedValue26;
                    objRememberedValue27 = gapComposer2.rememberedValue();
                    if (objRememberedValue27 == neverEqualPolicy2) {
                        objRememberedValue27 = ArcSplineKt.exponentialDecay$default(2);
                        gapComposer2.updateRememberedValue(objRememberedValue27);
                    }
                    final DecayAnimationSpecImpl decayAnimationSpecImpl = (DecayAnimationSpecImpl) objRememberedValue27;
                    zChanged7 = gapComposer2.changed((List) mutableStateCollectAsStateWithLifecycle8.getValue()) | gapComposer2.changed(str8);
                    objRememberedValue28 = gapComposer2.rememberedValue();
                    if (zChanged7 || objRememberedValue28 == neverEqualPolicy2) {
                        objRememberedValue28 = new SnapshotStateMap();
                        gapComposer2.updateRememberedValue(objRememberedValue28);
                    }
                    final SnapshotStateMap snapshotStateMap = (SnapshotStateMap) objRememberedValue28;
                    zChanged8 = gapComposer2.changed((List) mutableStateCollectAsStateWithLifecycle8.getValue()) | gapComposer2.changed(str8);
                    objRememberedValue29 = gapComposer2.rememberedValue();
                    if (zChanged8 || objRememberedValue29 == neverEqualPolicy2) {
                        objRememberedValue29 = Stack.mutableStateOf$default(Boolean.TRUE);
                        gapComposer2.updateRememberedValue(objRememberedValue29);
                    }
                    final MutableState mutableState21 = (MutableState) objRememberedValue29;
                    zChanged9 = gapComposer2.changed((List) mutableStateCollectAsStateWithLifecycle8.getValue()) | gapComposer2.changed(parcelableSnapshotMutableIntState2.getIntValue());
                    Object objRememberedValue51 = gapComposer2.rememberedValue();
                    if (!zChanged9 || objRememberedValue51 == neverEqualPolicy2) {
                        mutableState15 = mutableStateCollectAsStateWithLifecycle8;
                        objDerivedStateOf = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ShowOffsetDialogKt$$ExternalSyntheticLambda3(mutableState15, parcelableSnapshotMutableIntState2));
                        gapComposer2.updateRememberedValue(objDerivedStateOf);
                    } else {
                        objDerivedStateOf = objRememberedValue51;
                        mutableState15 = mutableStateCollectAsStateWithLifecycle8;
                    }
                    final State state3 = (State) objDerivedStateOf;
                    Boolean boolValueOf3 = Boolean.valueOf(z);
                    context2 = context;
                    boolean zChangedInstance2 = gapComposer2.changedInstance(context2);
                    if (i7 == 256) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    z6 = zChangedInstance2 | z5;
                    objRememberedValue30 = gapComposer2.rememberedValue();
                    if (z6 || objRememberedValue30 == neverEqualPolicy2) {
                        objRememberedValue30 = new OriginalLyricsKt$$ExternalSyntheticLambda2(context2, z, (byte) 1);
                        gapComposer2.updateRememberedValue(objRememberedValue30);
                    }
                    Stack.DisposableEffect(boolValueOf3, (Function1) objRememberedValue30, gapComposer2);
                    BiasAlignment biasAlignment = Alignment.Companion.TopCenter;
                    Modifier modifierM139paddingqDBjuR0$default = OffsetKt.m139paddingqDBjuR0$default(modifier.then(SizeKt.FillWholeMaxSize), CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 12.0f, 7);
                    neverEqualPolicy3 = neverEqualPolicy2;
                    final boolean z9 = z3;
                    final MutableState mutableState22 = mutableState13;
                    final MutableState mutableState23 = mutableState15;
                    final SnapshotStateList snapshotStateList3 = snapshotStateList2;
                    Function3 function3 = new Function3() { // from class: com.metrolist.music.ui.component.ExperimentalLyricsKt$$ExternalSyntheticLambda1
                        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
                            jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r19v27 com.metrolist.music.lyrics.LyricsEntry
                            	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
                            	at jadx.core.dex.visitors.ModVisitor.anonymousCallArgMod(ModVisitor.java:535)
                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                            	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:528)
                            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:111)
                            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
                            */
                        @Override // kotlin.jvm.functions.Function3
                        public final java.lang.Object invoke(java.lang.Object r74, java.lang.Object r75, java.lang.Object r76) {
                            /*
                                Method dump skipped, instruction units count: 3971
                                To view this dump add '--comments-level debug' option
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.metrolist.music.ui.component.ExperimentalLyricsKt$$ExternalSyntheticLambda1.invoke(java.lang.Object, java.lang.Object, java.lang.Object):java.lang.Object");
                        }
                    };
                    gapComposer3 = gapComposer2;
                    OffsetKt.BoxWithConstraints(modifierM139paddingqDBjuR0$default, biasAlignment, Expect_jvmKt.rememberComposableLambda(-33078969, function3, gapComposer3), gapComposer3, 3120, 4);
                    if (((Boolean) mutableState7.getValue()).booleanValue()) {
                        gapComposer3.startReplaceGroup(-1336067145);
                        objRememberedValue31 = gapComposer3.rememberedValue();
                        neverEqualPolicy4 = neverEqualPolicy3;
                        if (objRememberedValue31 == neverEqualPolicy4) {
                            objRememberedValue31 = new CachedItem$$ExternalSyntheticLambda0((byte) 18);
                            gapComposer3.updateRememberedValue(objRememberedValue31);
                        }
                        AlertDialogKt.BasicAlertDialog((Function0) objRememberedValue31, null, null, lambda$1428428444, gapComposer3, 3078, 6);
                        GapComposer gapComposer8 = gapComposer3;
                        z7 = false;
                        gapComposer8.end(false);
                        gapComposer4 = gapComposer8;
                    } else {
                        neverEqualPolicy4 = neverEqualPolicy3;
                        z7 = false;
                        gapComposer3.startReplaceGroup(-1335715419);
                        gapComposer3.end(false);
                        gapComposer4 = gapComposer3;
                    }
                    if (((Boolean) mutableState8.getValue()).booleanValue() || ((Triple) mutableState19.getValue()) == null) {
                        mutableState16 = mutableState9;
                        gapComposer4.startReplaceGroup(-1335301755);
                        gapComposer4.end(z7);
                        gapComposer5 = gapComposer4;
                    } else {
                        gapComposer4.startReplaceGroup(-1335650598);
                        Triple triple = (Triple) mutableState19.getValue();
                        triple.getClass();
                        String str9 = (String) triple.first;
                        String str10 = (String) triple.second;
                        String str11 = (String) triple.third;
                        MediaMetadata mediaMetadata = (MediaMetadata) mutableStateCollectAsStateWithLifecycle2.getValue();
                        if (mediaMetadata == null || (str5 = mediaMetadata.id) == null) {
                            str5 = "";
                        }
                        Object objRememberedValue52 = gapComposer4.rememberedValue();
                        if (objRememberedValue52 == neverEqualPolicy4) {
                            objRememberedValue52 = new MainActivity$$ExternalSyntheticLambda29(mutableState8, (byte) 15);
                            gapComposer4.updateRememberedValue(objRememberedValue52);
                        }
                        Function0 function1 = (Function0) objRememberedValue52;
                        Object objRememberedValue53 = gapComposer4.rememberedValue();
                        if (objRememberedValue53 == neverEqualPolicy4) {
                            mutableState16 = mutableState9;
                            objRememberedValue53 = new TooltipKt$$ExternalSyntheticLambda2(mutableState8, mutableState16, (byte) 1);
                            gapComposer4.updateRememberedValue(objRememberedValue53);
                        } else {
                            mutableState16 = mutableState9;
                        }
                        Function0 function4 = (Function0) objRememberedValue53;
                        GapComposer gapComposer9 = gapComposer4;
                        MenuKt.LyricsShareDialog(str9, str10, str11, str5, function1, function4, gapComposer9, 221184);
                        GapComposer gapComposer10 = gapComposer9;
                        gapComposer10.end(z7);
                        gapComposer5 = gapComposer10;
                    }
                    if (((Boolean) mutableState16.getValue()).booleanValue() || ((Triple) mutableState19.getValue()) == null) {
                        gapComposer5.startReplaceGroup(-1332793979);
                        gapComposer5.end(z7);
                        gapComposer = gapComposer5;
                    } else {
                        gapComposer5.startReplaceGroup(-1335165727);
                        Triple triple2 = (Triple) mutableState19.getValue();
                        triple2.getClass();
                        String str12 = (String) triple2.first;
                        String str13 = (String) triple2.second;
                        String str14 = (String) triple2.third;
                        MediaMetadata mediaMetadata2 = (MediaMetadata) mutableStateCollectAsStateWithLifecycle2.getValue();
                        Object obj4 = mediaMetadata2 != null ? mediaMetadata2.thumbnailUrl : continuation3;
                        LyricsPosition lyricsPosition = (LyricsPosition) experimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$2.getValue();
                        Object objRememberedValue54 = gapComposer5.rememberedValue();
                        if (objRememberedValue54 == neverEqualPolicy4) {
                            objRememberedValue54 = new MainActivity$$ExternalSyntheticLambda29(mutableState16, (byte) 16);
                            gapComposer5.updateRememberedValue(objRememberedValue54);
                        }
                        Function0 function5 = (Function0) objRememberedValue54;
                        boolean zChangedInstance3 = gapComposer5.changedInstance(coroutineScope2) | gapComposer5.changedInstance(context2) | gapComposer5.changed(mutableStateCollectAsStateWithLifecycle2) | gapComposer5.changed(str13) | gapComposer5.changed(str14) | gapComposer5.changed(str12) | gapComposer5.changedInstance(configuration) | gapComposer5.changed(density) | gapComposer5.changed(experimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$2);
                        Object objRememberedValue55 = gapComposer5.rememberedValue();
                        if (zChangedInstance3 || objRememberedValue55 == neverEqualPolicy4) {
                            str3 = str12;
                            objRememberedValue55 = new ExperimentalLyricsKt$ExperimentalLyrics$19$1(coroutineScope2, mutableState16, mutableState7, context2, str13, str14, str3, configuration, density, mutableStateCollectAsStateWithLifecycle2, experimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$2);
                            str4 = str13;
                            gapComposer5.updateRememberedValue(objRememberedValue55);
                        } else {
                            str3 = str12;
                            str4 = str13;
                        }
                        Function4 function6 = (Function4) objRememberedValue55;
                        String str15 = obj4;
                        GapComposer gapComposer11 = gapComposer5;
                        MenuKt.LyricsColorPickerDialog(str3, str4, str14, str15, lyricsPosition, function5, function6, gapComposer11, 196608);
                        GapComposer gapComposer12 = gapComposer11;
                        gapComposer12.end(false);
                        gapComposer = gapComposer12;
                    }
                }
                continuation = null;
                objRememberedValue50 = new ItemsKt$reset$1(mutableState2, continuation, (byte) 1);
                gapComposer2.updateRememberedValue(objRememberedValue50);
                Stack.LaunchedEffect(gapComposer2, list4, (Function2) objRememberedValue50);
                StaticProvidableCompositionLocal staticProvidableCompositionLocal3 = MaterialThemeKt._localMaterialTheme;
                final long j3 = ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal3)).colorScheme.onSurface;
                final long j4 = ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal3)).colorScheme.primary;
                objRememberedValue = gapComposer2.rememberedValue();
                emptySet = EmptySet.INSTANCE;
                if (objRememberedValue == neverEqualPolicy2) {
                    objRememberedValue = Stack.mutableStateOf$default(emptySet);
                    gapComposer2.updateRememberedValue(objRememberedValue);
                }
                mutableState4 = (MutableState) objRememberedValue;
                Object[] objArr10 = new Object[0];
                objRememberedValue2 = gapComposer2.rememberedValue();
                if (objRememberedValue2 == neverEqualPolicy2) {
                    objRememberedValue2 = new CachedItem$$ExternalSyntheticLambda0((byte) 19);
                    gapComposer2.updateRememberedValue(objRememberedValue2);
                }
                parcelableSnapshotMutableIntState = (ParcelableSnapshotMutableIntState) SaverKt.rememberSaveable(objArr10, (Function0) objRememberedValue2, gapComposer2, 48);
                objRememberedValue3 = gapComposer2.rememberedValue();
                if (objRememberedValue3 == neverEqualPolicy2) {
                    objRememberedValue3 = Stack.mutableStateOf$default(emptySet);
                    gapComposer2.updateRememberedValue(objRememberedValue3);
                }
                mutableState5 = (MutableState) objRememberedValue3;
                objRememberedValue4 = gapComposer2.rememberedValue();
                if (objRememberedValue4 == neverEqualPolicy2) {
                    objRememberedValue4 = new ParcelableSnapshotMutableLongState(0L);
                    gapComposer2.updateRememberedValue(objRememberedValue4);
                }
                parcelableSnapshotMutableLongState = (ParcelableSnapshotMutableLongState) objRememberedValue4;
                Object[] objArr11 = new Object[0];
                objRememberedValue5 = gapComposer2.rememberedValue();
                if (objRememberedValue5 == neverEqualPolicy2) {
                    objRememberedValue5 = new CachedItem$$ExternalSyntheticLambda0((byte) 20);
                    gapComposer2.updateRememberedValue(objRememberedValue5);
                }
                parcelableSnapshotMutableIntState2 = (ParcelableSnapshotMutableIntState) SaverKt.rememberSaveable(objArr11, (Function0) objRememberedValue5, gapComposer2, 48);
                Object[] objArr12 = new Object[0];
                objRememberedValue6 = gapComposer2.rememberedValue();
                b = 15;
                if (objRememberedValue6 == neverEqualPolicy2) {
                    objRememberedValue6 = new CachedItem$$ExternalSyntheticLambda0(b);
                    gapComposer2.updateRememberedValue(objRememberedValue6);
                }
                parcelableSnapshotMutableLongState2 = (ParcelableSnapshotMutableLongState) SaverKt.rememberSaveable(objArr12, (Function0) objRememberedValue6, gapComposer2, 48);
                objRememberedValue7 = gapComposer2.rememberedValue();
                if (objRememberedValue7 == neverEqualPolicy2) {
                    objRememberedValue7 = Stack.mutableStateOf$default(Boolean.FALSE);
                    gapComposer2.updateRememberedValue(objRememberedValue7);
                }
                mutableState6 = (MutableState) objRememberedValue7;
                objRememberedValue8 = gapComposer2.rememberedValue();
                if (objRememberedValue8 == neverEqualPolicy2) {
                    objRememberedValue8 = Stack.mutableStateOf$default(Boolean.FALSE);
                    gapComposer2.updateRememberedValue(objRememberedValue8);
                }
                mutableState7 = (MutableState) objRememberedValue8;
                objRememberedValue9 = gapComposer2.rememberedValue();
                if (objRememberedValue9 == neverEqualPolicy2) {
                    objRememberedValue9 = Stack.mutableStateOf$default(Boolean.FALSE);
                    gapComposer2.updateRememberedValue(objRememberedValue9);
                }
                mutableState8 = (MutableState) objRememberedValue9;
                objRememberedValue10 = gapComposer2.rememberedValue();
                if (objRememberedValue10 == neverEqualPolicy2) {
                    objRememberedValue10 = Stack.mutableStateOf$default(Boolean.FALSE);
                    gapComposer2.updateRememberedValue(objRememberedValue10);
                }
                mutableState9 = (MutableState) objRememberedValue10;
                objRememberedValue11 = gapComposer2.rememberedValue();
                if (objRememberedValue11 == neverEqualPolicy2) {
                    objRememberedValue11 = Stack.mutableStateOf$default(continuation);
                    gapComposer2.updateRememberedValue(objRememberedValue11);
                }
                final MutableState mutableState110 = (MutableState) objRememberedValue11;
                Object[] objArr13 = new Object[0];
                objRememberedValue12 = gapComposer2.rememberedValue();
                if (objRememberedValue12 == neverEqualPolicy2) {
                    objRememberedValue12 = new CachedItem$$ExternalSyntheticLambda0((byte) 16);
                    gapComposer2.updateRememberedValue(objRememberedValue12);
                }
                mutableState10 = (MutableState) SaverKt.rememberSaveable(objArr13, (Function0) objRememberedValue12, gapComposer2, 48);
                objRememberedValue13 = gapComposer2.rememberedValue();
                if (objRememberedValue13 == neverEqualPolicy2) {
                    objRememberedValue13 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer2);
                }
                snapshotStateList = (SnapshotStateList) objRememberedValue13;
                objRememberedValue14 = gapComposer2.rememberedValue();
                if (objRememberedValue14 == neverEqualPolicy2) {
                    objRememberedValue14 = Stack.mutableStateOf$default(Boolean.FALSE);
                    gapComposer2.updateRememberedValue(objRememberedValue14);
                }
                mutableState11 = (MutableState) objRememberedValue14;
                lyricsEntity2 = lyricsEntity;
                if (lyricsEntity2 != null) {
                    str6 = lyricsEntity2.provider;
                    if (Intrinsics.areEqual(str6, "Unknown")) {
                        z3 = false;
                    } else {
                        z3 = false;
                    }
                } else {
                    z3 = false;
                }
                Object[] objArr14 = new Object[0];
                objRememberedValue15 = gapComposer2.rememberedValue();
                if (objRememberedValue15 == neverEqualPolicy2) {
                    objRememberedValue15 = new CachedItem$$ExternalSyntheticLambda0((byte) 17);
                    gapComposer2.updateRememberedValue(objRememberedValue15);
                }
                mutableState12 = (MutableState) SaverKt.rememberSaveable(objArr14, (Function0) objRememberedValue15, gapComposer2, 48);
                boolean zExperimentalLyrics$lambda$72 = ExperimentalLyrics$lambda$71(mutableState10);
                zChanged = gapComposer2.changed(mutableState10);
                objRememberedValue16 = gapComposer2.rememberedValue();
                if (zChanged) {
                    objRememberedValue16 = new OriginalLyricsKt$$ExternalSyntheticLambda1(snapshotStateList, mutableState10, (byte) 1);
                    gapComposer2.updateRememberedValue(objRememberedValue16);
                } else {
                    objRememberedValue16 = new OriginalLyricsKt$$ExternalSyntheticLambda1(snapshotStateList, mutableState10, (byte) 1);
                    gapComposer2.updateRememberedValue(objRememberedValue16);
                }
                coil3.util.UtilsKt.BackHandler(zExperimentalLyrics$lambda$72, (Function0) objRememberedValue16, gapComposer2, 0, 0);
                Boolean bool6 = (Boolean) mutableState11.getValue();
                bool6.getClass();
                zChangedInstance = gapComposer2.changedInstance(context);
                objRememberedValue17 = gapComposer2.rememberedValue();
                if (zChangedInstance) {
                    objRememberedValue17 = new DownloadUtil.AnonymousClass2(context, mutableState11, continuation, (byte) 23);
                    gapComposer2.updateRememberedValue(objRememberedValue17);
                } else {
                    objRememberedValue17 = new DownloadUtil.AnonymousClass2(context, mutableState11, continuation, (byte) 23);
                    gapComposer2.updateRememberedValue(objRememberedValue17);
                }
                Stack.LaunchedEffect(gapComposer2, bool6, (Function2) objRememberedValue17);
                zChanged2 = gapComposer2.changed((List) mutableState2.getValue()) | gapComposer2.changed(str8);
                objRememberedValue18 = gapComposer2.rememberedValue();
                if (zChanged2) {
                    objRememberedValue18 = Fragment$5$$ExternalSyntheticOutline0.m(-1, gapComposer2);
                } else {
                    objRememberedValue18 = Fragment$5$$ExternalSyntheticOutline0.m(-1, gapComposer2);
                }
                parcelableSnapshotMutableIntState3 = (ParcelableSnapshotMutableIntState) objRememberedValue18;
                objRememberedValue19 = gapComposer2.rememberedValue();
                if (objRememberedValue19 == neverEqualPolicy2) {
                    objRememberedValue19 = new ParcelableSnapshotMutableLongState(0L);
                    gapComposer2.updateRememberedValue(objRememberedValue19);
                }
                parcelableSnapshotMutableLongState3 = (ParcelableSnapshotMutableLongState) objRememberedValue19;
                List list7 = (List) mutableState2.getValue();
                boolean zChanged21 = gapComposer2.changed(str8) | gapComposer2.changed(mutableState2) | gapComposer2.changedInstance(playerConnection2);
                if ((i3 & 14) == 4) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                zChanged3 = zChanged21 | z4 | gapComposer2.changed(mutableState3) | gapComposer2.changed(zBooleanValue2) | gapComposer2.changed(parcelableSnapshotMutableIntState) | gapComposer2.changed(parcelableSnapshotMutableIntState3);
                objRememberedValue20 = gapComposer2.rememberedValue();
                if (zChanged3) {
                    objRememberedValue20 = new ExperimentalLyricsKt$ExperimentalLyrics$9$1(str8, playerConnection2, function0, zBooleanValue2, mutableState2, mutableState4, mutableState6, parcelableSnapshotMutableLongState, parcelableSnapshotMutableLongState3, mutableState3, parcelableSnapshotMutableIntState, mutableState5, parcelableSnapshotMutableIntState3, null);
                    parcelableSnapshotMutableLongState4 = parcelableSnapshotMutableLongState;
                    mutableState5 = mutableState5;
                    playerConnection = playerConnection2;
                    gapComposer2.updateRememberedValue(objRememberedValue20);
                } else {
                    objRememberedValue20 = new ExperimentalLyricsKt$ExperimentalLyrics$9$1(str8, playerConnection2, function0, zBooleanValue2, mutableState2, mutableState4, mutableState6, parcelableSnapshotMutableLongState, parcelableSnapshotMutableLongState3, mutableState3, parcelableSnapshotMutableIntState, mutableState5, parcelableSnapshotMutableIntState3, null);
                    parcelableSnapshotMutableLongState4 = parcelableSnapshotMutableLongState;
                    mutableState5 = mutableState5;
                    playerConnection = playerConnection2;
                    gapComposer2.updateRememberedValue(objRememberedValue20);
                }
                Stack.LaunchedEffect(str8, list7, (Function2) objRememberedValue20, gapComposer2);
                Boolean boolValueOf4 = Boolean.valueOf(((Boolean) mutableState6.getValue()).booleanValue());
                Long lValueOf2 = Long.valueOf(parcelableSnapshotMutableLongState2.getLongValue());
                zChanged4 = gapComposer2.changed(parcelableSnapshotMutableLongState2);
                final ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState6 = parcelableSnapshotMutableLongState4;
                objRememberedValue21 = gapComposer2.rememberedValue();
                if (zChanged4) {
                    continuation2 = null;
                    objRememberedValue21 = new OriginalLyricsKt$OriginalLyrics$11$1(mutableState6, parcelableSnapshotMutableLongState2, continuation2, (byte) 1);
                    gapComposer2.updateRememberedValue(objRememberedValue21);
                } else {
                    continuation2 = null;
                    objRememberedValue21 = new OriginalLyricsKt$OriginalLyrics$11$1(mutableState6, parcelableSnapshotMutableLongState2, continuation2, (byte) 1);
                    gapComposer2.updateRememberedValue(objRememberedValue21);
                }
                Stack.LaunchedEffect(boolValueOf4, lValueOf2, (Function2) objRememberedValue21, gapComposer2);
                Integer numValueOf2 = Integer.valueOf(parcelableSnapshotMutableIntState.getIntValue());
                Boolean boolValueOf5 = Boolean.valueOf(ExperimentalLyrics$lambda$78(mutableState12));
                zChanged5 = gapComposer2.changed(parcelableSnapshotMutableIntState) | gapComposer2.changed(mutableState12) | gapComposer2.changed(parcelableSnapshotMutableIntState2);
                objRememberedValue22 = gapComposer2.rememberedValue();
                if (zChanged5) {
                    continuation3 = continuation2;
                    objRememberedValue22 = new SyncUtils$createPlaylist$1.AnonymousClass1((Object) parcelableSnapshotMutableIntState, (Object) mutableState12, (Object) parcelableSnapshotMutableIntState2, continuation3, (byte) 9);
                    gapComposer2.updateRememberedValue(objRememberedValue22);
                } else {
                    continuation3 = continuation2;
                    objRememberedValue22 = new SyncUtils$createPlaylist$1.AnonymousClass1((Object) parcelableSnapshotMutableIntState, (Object) mutableState12, (Object) parcelableSnapshotMutableIntState2, continuation3, (byte) 9);
                    gapComposer2.updateRememberedValue(objRememberedValue22);
                }
                Stack.LaunchedEffect(numValueOf2, boolValueOf5, (Function2) objRememberedValue22, gapComposer2);
                objRememberedValue23 = gapComposer2.rememberedValue();
                if (objRememberedValue23 == neverEqualPolicy2) {
                    objRememberedValue23 = Format$$ExternalSyntheticOutline0.m(CropImageView.DEFAULT_ASPECT_RATIO, gapComposer2);
                }
                parcelableSnapshotMutableFloatState = (ParcelableSnapshotMutableFloatState) objRememberedValue23;
                List list8 = (List) mutableState2.getValue();
                zChanged6 = gapComposer2.changed(mutableState12) | gapComposer2.changed(parcelableSnapshotMutableIntState) | gapComposer2.changed(parcelableSnapshotMutableIntState2) | gapComposer2.changed(mutableState10);
                objRememberedValue24 = gapComposer2.rememberedValue();
                if (zChanged6) {
                    snapshotStateList2 = snapshotStateList;
                    objRememberedValue24 = new PlayerKt$BottomSheetPlayer$13$1(snapshotStateList2, mutableState12, parcelableSnapshotMutableFloatState, parcelableSnapshotMutableIntState, parcelableSnapshotMutableIntState2, mutableState10, mutableState5, (Continuation) null);
                    mutableState13 = mutableState12;
                    parcelableSnapshotMutableFloatState = parcelableSnapshotMutableFloatState;
                    mutableState14 = mutableState10;
                    gapComposer2.updateRememberedValue(objRememberedValue24);
                } else {
                    snapshotStateList2 = snapshotStateList;
                    objRememberedValue24 = new PlayerKt$BottomSheetPlayer$13$1(snapshotStateList2, mutableState12, parcelableSnapshotMutableFloatState, parcelableSnapshotMutableIntState, parcelableSnapshotMutableIntState2, mutableState10, mutableState5, (Continuation) null);
                    mutableState13 = mutableState12;
                    parcelableSnapshotMutableFloatState = parcelableSnapshotMutableFloatState;
                    mutableState14 = mutableState10;
                    gapComposer2.updateRememberedValue(objRememberedValue24);
                }
                Stack.LaunchedEffect(str8, list8, (Function2) objRememberedValue24, gapComposer2);
                objRememberedValue25 = gapComposer2.rememberedValue();
                if (objRememberedValue25 == neverEqualPolicy2) {
                    objRememberedValue25 = Stack.mutableStateOf$default(continuation3);
                    gapComposer2.updateRememberedValue(objRememberedValue25);
                }
                final MutableState mutableState24 = (MutableState) objRememberedValue25;
                objRememberedValue26 = gapComposer2.rememberedValue();
                if (objRememberedValue26 == neverEqualPolicy2) {
                    objRememberedValue26 = new VelocityTracker();
                    gapComposer2.updateRememberedValue(objRememberedValue26);
                }
                final VelocityTracker velocityTracker2 = (VelocityTracker) objRememberedValue26;
                objRememberedValue27 = gapComposer2.rememberedValue();
                if (objRememberedValue27 == neverEqualPolicy2) {
                    objRememberedValue27 = ArcSplineKt.exponentialDecay$default(2);
                    gapComposer2.updateRememberedValue(objRememberedValue27);
                }
                final DecayAnimationSpecImpl decayAnimationSpecImpl2 = (DecayAnimationSpecImpl) objRememberedValue27;
                zChanged7 = gapComposer2.changed((List) mutableStateCollectAsStateWithLifecycle8.getValue()) | gapComposer2.changed(str8);
                objRememberedValue28 = gapComposer2.rememberedValue();
                if (zChanged7) {
                    objRememberedValue28 = new SnapshotStateMap();
                    gapComposer2.updateRememberedValue(objRememberedValue28);
                } else {
                    objRememberedValue28 = new SnapshotStateMap();
                    gapComposer2.updateRememberedValue(objRememberedValue28);
                }
                final SnapshotStateMap snapshotStateMap2 = (SnapshotStateMap) objRememberedValue28;
                zChanged8 = gapComposer2.changed((List) mutableStateCollectAsStateWithLifecycle8.getValue()) | gapComposer2.changed(str8);
                objRememberedValue29 = gapComposer2.rememberedValue();
                if (zChanged8) {
                    objRememberedValue29 = Stack.mutableStateOf$default(Boolean.TRUE);
                    gapComposer2.updateRememberedValue(objRememberedValue29);
                } else {
                    objRememberedValue29 = Stack.mutableStateOf$default(Boolean.TRUE);
                    gapComposer2.updateRememberedValue(objRememberedValue29);
                }
                final MutableState mutableState25 = (MutableState) objRememberedValue29;
                zChanged9 = gapComposer2.changed((List) mutableStateCollectAsStateWithLifecycle8.getValue()) | gapComposer2.changed(parcelableSnapshotMutableIntState2.getIntValue());
                Object objRememberedValue56 = gapComposer2.rememberedValue();
                if (zChanged9) {
                    mutableState15 = mutableStateCollectAsStateWithLifecycle8;
                    objDerivedStateOf = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ShowOffsetDialogKt$$ExternalSyntheticLambda3(mutableState15, parcelableSnapshotMutableIntState2));
                    gapComposer2.updateRememberedValue(objDerivedStateOf);
                } else {
                    mutableState15 = mutableStateCollectAsStateWithLifecycle8;
                    objDerivedStateOf = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ShowOffsetDialogKt$$ExternalSyntheticLambda3(mutableState15, parcelableSnapshotMutableIntState2));
                    gapComposer2.updateRememberedValue(objDerivedStateOf);
                }
                final State state4 = (State) objDerivedStateOf;
                Boolean boolValueOf6 = Boolean.valueOf(z);
                context2 = context;
                boolean zChangedInstance4 = gapComposer2.changedInstance(context2);
                if (i7 == 256) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                z6 = zChangedInstance4 | z5;
                objRememberedValue30 = gapComposer2.rememberedValue();
                if (z6) {
                    objRememberedValue30 = new OriginalLyricsKt$$ExternalSyntheticLambda2(context2, z, (byte) 1);
                    gapComposer2.updateRememberedValue(objRememberedValue30);
                } else {
                    objRememberedValue30 = new OriginalLyricsKt$$ExternalSyntheticLambda2(context2, z, (byte) 1);
                    gapComposer2.updateRememberedValue(objRememberedValue30);
                }
                Stack.DisposableEffect(boolValueOf6, (Function1) objRememberedValue30, gapComposer2);
                BiasAlignment biasAlignment2 = Alignment.Companion.TopCenter;
                Modifier modifierM139paddingqDBjuR0$default2 = OffsetKt.m139paddingqDBjuR0$default(modifier.then(SizeKt.FillWholeMaxSize), CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 12.0f, 7);
                neverEqualPolicy3 = neverEqualPolicy2;
                final boolean z10 = z3;
                final MutableState mutableState26 = mutableState13;
                final MutableState mutableState27 = mutableState15;
                final SnapshotStateList snapshotStateList4 = snapshotStateList2;
                Function3 function7 = new Function3() { // from class: com.metrolist.music.ui.component.ExperimentalLyricsKt$$ExternalSyntheticLambda1
                    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
                        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r19v27 com.metrolist.music.lyrics.LyricsEntry
                        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
                        	at jadx.core.dex.visitors.ModVisitor.anonymousCallArgMod(ModVisitor.java:535)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:528)
                        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:111)
                        */
                    @Override // kotlin.jvm.functions.Function3
                    public final java.lang.Object invoke(java.lang.Object r74, java.lang.Object r75, java.lang.Object r76) {
                        /*
                            Method dump skipped, instruction units count: 3971
                            To view this dump add '--comments-level debug' option
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.metrolist.music.ui.component.ExperimentalLyricsKt$$ExternalSyntheticLambda1.invoke(java.lang.Object, java.lang.Object, java.lang.Object):java.lang.Object");
                    }
                };
                gapComposer3 = gapComposer2;
                OffsetKt.BoxWithConstraints(modifierM139paddingqDBjuR0$default2, biasAlignment2, Expect_jvmKt.rememberComposableLambda(-33078969, function7, gapComposer3), gapComposer3, 3120, 4);
                if (((Boolean) mutableState7.getValue()).booleanValue()) {
                    gapComposer3.startReplaceGroup(-1336067145);
                    objRememberedValue31 = gapComposer3.rememberedValue();
                    neverEqualPolicy4 = neverEqualPolicy3;
                    if (objRememberedValue31 == neverEqualPolicy4) {
                        objRememberedValue31 = new CachedItem$$ExternalSyntheticLambda0((byte) 18);
                        gapComposer3.updateRememberedValue(objRememberedValue31);
                    }
                    AlertDialogKt.BasicAlertDialog((Function0) objRememberedValue31, null, null, lambda$1428428444, gapComposer3, 3078, 6);
                    GapComposer gapComposer13 = gapComposer3;
                    z7 = false;
                    gapComposer13.end(false);
                    gapComposer4 = gapComposer13;
                } else {
                    neverEqualPolicy4 = neverEqualPolicy3;
                    z7 = false;
                    gapComposer3.startReplaceGroup(-1335715419);
                    gapComposer3.end(false);
                    gapComposer4 = gapComposer3;
                }
                if (((Boolean) mutableState8.getValue()).booleanValue()) {
                    mutableState16 = mutableState9;
                    gapComposer4.startReplaceGroup(-1335301755);
                    gapComposer4.end(z7);
                    gapComposer5 = gapComposer4;
                } else {
                    mutableState16 = mutableState9;
                    gapComposer4.startReplaceGroup(-1335301755);
                    gapComposer4.end(z7);
                    gapComposer5 = gapComposer4;
                }
                if (((Boolean) mutableState16.getValue()).booleanValue()) {
                    gapComposer5.startReplaceGroup(-1332793979);
                    gapComposer5.end(z7);
                    gapComposer = gapComposer5;
                } else {
                    gapComposer5.startReplaceGroup(-1332793979);
                    gapComposer5.end(z7);
                    gapComposer = gapComposer5;
                }
            }
            recomposeScopeImplEndRestartGroup.block = function2;
        }
        GapComposer gapComposer14 = gapComposer6;
        gapComposer14.skipToGroupEnd();
        gapComposer = gapComposer14;
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            final byte b3 = 1;
            function2 = new Function2() { // from class: com.metrolist.music.ui.component.ExperimentalLyricsKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj5, Object obj6) {
                    byte b4 = b3;
                    Unit unit = Unit.INSTANCE;
                    int i8 = i;
                    switch (b4) {
                        case 0:
                            ((Integer) obj6).getClass();
                            int iUpdateChangedFlags = Stack.updateChangedFlags(i8 | 1);
                            DialogKt.ExperimentalLyrics(function0, modifier, z, lyricsViewModel, (Composer) obj5, iUpdateChangedFlags);
                            break;
                        default:
                            ((Integer) obj6).getClass();
                            int iUpdateChangedFlags2 = Stack.updateChangedFlags(i8 | 1);
                            DialogKt.ExperimentalLyrics(function0, modifier, z, lyricsViewModel, (Composer) obj5, iUpdateChangedFlags2);
                            break;
                    }
                    return unit;
                }
            };
            recomposeScopeImplEndRestartGroup.block = function2;
        }
    }

    public static final List ExperimentalLyrics$lambda$28(MutableState mutableState) {
        return (List) mutableState.getValue();
    }

    public static final boolean ExperimentalLyrics$lambda$71(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    public static final boolean ExperimentalLyrics$lambda$78(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    public static final void ListDialog(Function0 function0, Modifier modifier, Function1 function1, Composer composer, int i) {
        int i2;
        function0.getClass();
        function1.getClass();
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-266069010);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        int i3 = i2 | 48;
        if ((i & 384) == 0) {
            i3 |= gapComposer.changedInstance(function1) ? 256 : 128;
        }
        byte b = 0;
        if (gapComposer.shouldExecute(i3 & 1, (i3 & 147) != 146)) {
            AndroidDialog_androidKt.Dialog(function0, new DialogProperties(3), Expect_jvmKt.rememberComposableLambda(-1806851721, new DialogKt$$ExternalSyntheticLambda0(function1, b), gapComposer), gapComposer, (i3 & 14) | 432);
            modifier = Modifier.Companion.$$INSTANCE;
        } else {
            gapComposer.skipToGroupEnd();
        }
        Modifier modifier2 = modifier;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new TimePickerKt$$ExternalSyntheticLambda0((byte) 15, i, (Object) function0, (Object) modifier2, (Object) function1);
        }
    }

    /* JADX INFO: renamed from: LoadingIndicator-iJQMabo, reason: not valid java name */
    public static final void m1468LoadingIndicatoriJQMabo(int i, long j, Composer composer, Modifier modifier) {
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(929994377);
        int i2 = (gapComposer.changed(j) ? 32 : 16) | i;
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 19) != 18)) {
            gapComposer.startReplaceGroup(371402585);
            long j2 = j != 16 ? j : ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.primary;
            gapComposer.end(false);
            m1458AuralysLoaderRIQooxk(SizeKt.m151size3ABfNKs(modifier, 48.0f), j2, 0L, gapComposer, 0, 4);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new AuralysBrandKt$$ExternalSyntheticLambda6(i, j, modifier);
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0039  */
    /* JADX WARN: Code duplicated, block: B:21:0x0041  */
    /* JADX WARN: Code duplicated, block: B:22:0x0044  */
    /* JADX WARN: Code duplicated, block: B:26:0x004f  */
    /* JADX WARN: Code duplicated, block: B:27:0x0051  */
    /* JADX WARN: Code duplicated, block: B:30:0x005a  */
    /* JADX WARN: Code duplicated, block: B:32:0x0061  */
    /* JADX WARN: Code duplicated, block: B:39:0x0072 A[PHI: r2 r3
      0x0072: PHI (r2v15 int) = (r2v7 int), (r2v16 int) binds: [B:44:0x007c, B:38:0x0071] A[DONT_GENERATE, DONT_INLINE]
      0x0072: PHI (r3v8 androidx.compose.ui.Modifier) = (r3v4 androidx.compose.ui.Modifier), (r3v10 androidx.compose.ui.Modifier) binds: [B:44:0x007c, B:38:0x0071] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:40:0x0074 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:41:0x0076  */
    /* JADX WARN: Code duplicated, block: B:42:0x0079  */
    /* JADX WARN: Code duplicated, block: B:45:0x007e  */
    /* JADX WARN: Code duplicated, block: B:47:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:50:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:52:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: MicroLabel-FNF3uiM, reason: not valid java name */
    public static final void m1469MicroLabelFNF3uiM(final String str, Modifier modifier, long j, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        long j2;
        int i3;
        boolean z;
        GapComposer gapComposer;
        final Modifier modifier3;
        final long j3;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        Modifier modifier4;
        long j4;
        str.getClass();
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(1491031118);
        int i4 = i | (gapComposer2.changed(str) ? 4 : 2);
        int i5 = i2 & 2;
        if (i5 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i4 |= gapComposer2.changed(modifier2) ? 32 : 16;
            }
            if ((i2 & 4) == 0) {
                j2 = j;
                int i6 = gapComposer2.changed(j2) ? 256 : 128;
                i3 = i4 | i6;
                if ((i3 & 147) != 146) {
                    z = true;
                } else {
                    z = false;
                }
                if (gapComposer2.shouldExecute(i3 & 1, z)) {
                    gapComposer2.startDefaults();
                    if ((i & 1) != 0 || gapComposer2.getDefaultsInvalid()) {
                        if (i5 != 0) {
                            modifier4 = Modifier.Companion.$$INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            j4 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.onSurfaceVariant;
                            i3 &= -897;
                        }
                        gapComposer2.endDefaults();
                        String upperCase = str.toUpperCase(Locale.ROOT);
                        upperCase.getClass();
                        gapComposer = gapComposer2;
                        TextKt.m352TextNvy7gAk(upperCase, modifier4, j4, 0L, null, null, null, 0L, null, 0L, 2, false, 1, 0, ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography.labelSmall, gapComposer, i3 & 1008, 24960, 110584);
                        modifier3 = modifier4;
                        j3 = j4;
                    } else {
                        gapComposer2.skipToGroupEnd();
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                        }
                        modifier4 = modifier2;
                    }
                    j4 = j2;
                    gapComposer2.endDefaults();
                    String upperCase2 = str.toUpperCase(Locale.ROOT);
                    upperCase2.getClass();
                    gapComposer = gapComposer2;
                    TextKt.m352TextNvy7gAk(upperCase2, modifier4, j4, 0L, null, null, null, 0L, null, 0L, 2, false, 1, 0, ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography.labelSmall, gapComposer, i3 & 1008, 24960, 110584);
                    modifier3 = modifier4;
                    j3 = j4;
                } else {
                    gapComposer = gapComposer2;
                    gapComposer.skipToGroupEnd();
                    modifier3 = modifier2;
                    j3 = j2;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.metrolist.music.ui.component.EditorialComponentsKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            ((Integer) obj2).getClass();
                            DialogKt.m1469MicroLabelFNF3uiM(str, modifier3, j3, (Composer) obj, Stack.updateChangedFlags(i | 1), i2);
                            return Unit.INSTANCE;
                        }
                    };
                }
            }
            j2 = j;
            i3 = i4 | i6;
            if ((i3 & 147) != 146) {
                z = true;
            } else {
                z = false;
            }
            if (gapComposer2.shouldExecute(i3 & 1, z)) {
                gapComposer2.startDefaults();
                if ((i & 1) != 0) {
                    if (i5 != 0) {
                        modifier4 = Modifier.Companion.$$INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        j4 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.onSurfaceVariant;
                        i3 &= -897;
                    } else {
                        j4 = j2;
                    }
                } else {
                    if (i5 != 0) {
                        modifier4 = Modifier.Companion.$$INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        j4 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.onSurfaceVariant;
                        i3 &= -897;
                    } else {
                        j4 = j2;
                    }
                }
                gapComposer2.endDefaults();
                String upperCase3 = str.toUpperCase(Locale.ROOT);
                upperCase3.getClass();
                gapComposer = gapComposer2;
                TextKt.m352TextNvy7gAk(upperCase3, modifier4, j4, 0L, null, null, null, 0L, null, 0L, 2, false, 1, 0, ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography.labelSmall, gapComposer, i3 & 1008, 24960, 110584);
                modifier3 = modifier4;
                j3 = j4;
            } else {
                gapComposer = gapComposer2;
                gapComposer.skipToGroupEnd();
                modifier3 = modifier2;
                j3 = j2;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.metrolist.music.ui.component.EditorialComponentsKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        DialogKt.m1469MicroLabelFNF3uiM(str, modifier3, j3, (Composer) obj, Stack.updateChangedFlags(i | 1), i2);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i4 |= 48;
        modifier2 = modifier;
        if ((i2 & 4) == 0) {
            j2 = j;
            if (gapComposer2.changed(j2)) {
            }
            i3 = i4 | i6;
            if ((i3 & 147) != 146) {
                z = true;
            } else {
                z = false;
            }
            if (gapComposer2.shouldExecute(i3 & 1, z)) {
                gapComposer2.startDefaults();
                if ((i & 1) != 0) {
                    if (i5 != 0) {
                        modifier4 = Modifier.Companion.$$INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        j4 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.onSurfaceVariant;
                        i3 &= -897;
                    } else {
                        j4 = j2;
                    }
                } else {
                    if (i5 != 0) {
                        modifier4 = Modifier.Companion.$$INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        j4 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.onSurfaceVariant;
                        i3 &= -897;
                    } else {
                        j4 = j2;
                    }
                }
                gapComposer2.endDefaults();
                String upperCase4 = str.toUpperCase(Locale.ROOT);
                upperCase4.getClass();
                gapComposer = gapComposer2;
                TextKt.m352TextNvy7gAk(upperCase4, modifier4, j4, 0L, null, null, null, 0L, null, 0L, 2, false, 1, 0, ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography.labelSmall, gapComposer, i3 & 1008, 24960, 110584);
                modifier3 = modifier4;
                j3 = j4;
            } else {
                gapComposer = gapComposer2;
                gapComposer.skipToGroupEnd();
                modifier3 = modifier2;
                j3 = j2;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.metrolist.music.ui.component.EditorialComponentsKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        DialogKt.m1469MicroLabelFNF3uiM(str, modifier3, j3, (Composer) obj, Stack.updateChangedFlags(i | 1), i2);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        j2 = j;
        i3 = i4 | i6;
        if ((i3 & 147) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (gapComposer2.shouldExecute(i3 & 1, z)) {
            gapComposer2.startDefaults();
            if ((i & 1) != 0) {
                if (i5 != 0) {
                    modifier4 = Modifier.Companion.$$INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if ((i2 & 4) != 0) {
                    j4 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.onSurfaceVariant;
                    i3 &= -897;
                } else {
                    j4 = j2;
                }
            } else {
                if (i5 != 0) {
                    modifier4 = Modifier.Companion.$$INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if ((i2 & 4) != 0) {
                    j4 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.onSurfaceVariant;
                    i3 &= -897;
                } else {
                    j4 = j2;
                }
            }
            gapComposer2.endDefaults();
            String upperCase5 = str.toUpperCase(Locale.ROOT);
            upperCase5.getClass();
            gapComposer = gapComposer2;
            TextKt.m352TextNvy7gAk(upperCase5, modifier4, j4, 0L, null, null, null, 0L, null, 0L, 2, false, 1, 0, ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography.labelSmall, gapComposer, i3 & 1008, 24960, 110584);
            modifier3 = modifier4;
            j3 = j4;
        } else {
            gapComposer = gapComposer2;
            gapComposer.skipToGroupEnd();
            modifier3 = modifier2;
            j3 = j2;
        }
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.metrolist.music.ui.component.EditorialComponentsKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    DialogKt.m1469MicroLabelFNF3uiM(str, modifier3, j3, (Composer) obj, Stack.updateChangedFlags(i | 1), i2);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0145  */
    /* JADX WARN: Code duplicated, block: B:104:0x014d  */
    /* JADX WARN: Code duplicated, block: B:105:0x0150  */
    /* JADX WARN: Code duplicated, block: B:107:0x0155  */
    /* JADX WARN: Code duplicated, block: B:110:0x015d  */
    /* JADX WARN: Code duplicated, block: B:111:0x0164  */
    /* JADX WARN: Code duplicated, block: B:113:0x016a  */
    /* JADX WARN: Code duplicated, block: B:115:0x0170  */
    /* JADX WARN: Code duplicated, block: B:116:0x0173  */
    /* JADX WARN: Code duplicated, block: B:124:0x0195  */
    /* JADX WARN: Code duplicated, block: B:127:0x019f  */
    /* JADX WARN: Code duplicated, block: B:136:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:138:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:139:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:141:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:143:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:144:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:147:0x01f5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:148:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:149:0x01fa  */
    /* JADX WARN: Code duplicated, block: B:152:0x0201  */
    /* JADX WARN: Code duplicated, block: B:154:0x0207  */
    /* JADX WARN: Code duplicated, block: B:157:0x0215  */
    /* JADX WARN: Code duplicated, block: B:159:0x021b  */
    /* JADX WARN: Code duplicated, block: B:161:0x0227  */
    /* JADX WARN: Code duplicated, block: B:163:0x022b  */
    /* JADX WARN: Code duplicated, block: B:164:0x022d  */
    /* JADX WARN: Code duplicated, block: B:166:0x0231  */
    /* JADX WARN: Code duplicated, block: B:167:0x0233  */
    /* JADX WARN: Code duplicated, block: B:169:0x0237  */
    /* JADX WARN: Code duplicated, block: B:170:0x0239  */
    /* JADX WARN: Code duplicated, block: B:173:0x023f  */
    /* JADX WARN: Code duplicated, block: B:174:0x0252  */
    /* JADX WARN: Code duplicated, block: B:177:0x026d  */
    /* JADX WARN: Code duplicated, block: B:180:0x027e  */
    /* JADX WARN: Code duplicated, block: B:183:0x028f  */
    /* JADX WARN: Code duplicated, block: B:187:0x0299  */
    /* JADX WARN: Code duplicated, block: B:189:0x0313  */
    /* JADX WARN: Code duplicated, block: B:192:0x0332  */
    /* JADX WARN: Code duplicated, block: B:194:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0055  */
    /* JADX WARN: Code duplicated, block: B:24:0x005a  */
    /* JADX WARN: Code duplicated, block: B:26:0x0060  */
    /* JADX WARN: Code duplicated, block: B:28:0x0066  */
    /* JADX WARN: Code duplicated, block: B:29:0x0069  */
    /* JADX WARN: Code duplicated, block: B:33:0x0073  */
    /* JADX WARN: Code duplicated, block: B:35:0x0079  */
    /* JADX WARN: Code duplicated, block: B:37:0x0081  */
    /* JADX WARN: Code duplicated, block: B:38:0x0084  */
    /* JADX WARN: Code duplicated, block: B:41:0x008b  */
    /* JADX WARN: Code duplicated, block: B:44:0x0097  */
    /* JADX WARN: Code duplicated, block: B:45:0x009c  */
    /* JADX WARN: Code duplicated, block: B:47:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:49:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:50:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:54:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:55:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:57:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:59:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:60:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:62:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:65:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:67:0x00db  */
    /* JADX WARN: Code duplicated, block: B:69:0x00df  */
    /* JADX WARN: Code duplicated, block: B:71:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:72:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:74:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:75:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:79:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:80:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:82:0x0105  */
    /* JADX WARN: Code duplicated, block: B:84:0x010d  */
    /* JADX WARN: Code duplicated, block: B:85:0x0110  */
    /* JADX WARN: Code duplicated, block: B:88:0x0117  */
    /* JADX WARN: Code duplicated, block: B:91:0x0120  */
    /* JADX WARN: Code duplicated, block: B:92:0x0127  */
    /* JADX WARN: Code duplicated, block: B:94:0x012d  */
    /* JADX WARN: Code duplicated, block: B:96:0x0135  */
    /* JADX WARN: Code duplicated, block: B:97:0x0138  */
    /* JADX WARN: Code duplicated, block: B:99:0x013d  */
    /* JADX INFO: renamed from: TextFieldDialog-5RwOfIE, reason: not valid java name */
    public static final void m1470TextFieldDialog5RwOfIE(Modifier modifier, final Function2 function2, final Function2 function3, TextFieldValue textFieldValue, boolean z, boolean z2, int i, Function1 function1, int i2, Function1 function4, List list, Function2 function5, Function1 function6, final Function0 function0, boolean z3, Function2 function7, Composer composer, final int i3, final int i4, final int i5) {
        TextFieldValue textFieldValue2;
        int i6;
        final boolean z4;
        int i7;
        boolean z5;
        int i8;
        int i9;
        int i10;
        int i11;
        Function1 function8;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        boolean zChangedInstance;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        int i30;
        boolean z6;
        GapComposer gapComposer;
        final Modifier modifier2;
        final boolean z7;
        final Function1 function9;
        final List list2;
        final Function1 function10;
        final Function2 function11;
        final TextFieldValue textFieldValue3;
        final int i31;
        final Function1 function12;
        final int i32;
        final Function2 function13;
        final boolean z8;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        int i33;
        NeverEqualPolicy neverEqualPolicy;
        byte b;
        TextFieldValue textFieldValue4;
        boolean z9;
        Function1 function14;
        List list3;
        Function2 function15;
        Function1 function16;
        Modifier modifier3;
        final Function2 function17;
        final Function1 function18;
        final boolean z10;
        final List list4;
        final Function2 function19;
        final Function1 function20;
        final int i34;
        final int i35;
        final boolean z11;
        Object objRememberedValue;
        Object objRememberedValue2;
        int i36;
        Object objRememberedValue3;
        Object objRememberedValue4;
        final FocusRequester focusRequester;
        boolean z12;
        Object objRememberedValue5;
        int i37;
        function0.getClass();
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(-1293620601);
        int i38 = i3 | 6;
        int i39 = i5 & 8;
        if (i39 != 0) {
            i6 = i3 | 3078;
            textFieldValue2 = textFieldValue;
        } else {
            textFieldValue2 = textFieldValue;
            i6 = i38 | (gapComposer2.changed(textFieldValue2) ? 2048 : 1024);
        }
        int i40 = i6 | 24576;
        int i41 = i5 & 32;
        if (i41 == 0) {
            if ((i3 & 196608) == 0) {
                z4 = z;
                i40 |= gapComposer2.changed(z4) ? 131072 : 65536;
            }
            i7 = i5 & 64;
            if (i7 != 0) {
                i40 |= 1572864;
                z5 = z2;
            } else {
                z5 = z2;
                if ((i3 & 1572864) == 0) {
                    if (gapComposer2.changed(z5)) {
                        i8 = ByteChannelKt.CHANNEL_MAX_SIZE;
                    } else {
                        i8 = 524288;
                    }
                    i40 |= i8;
                }
            }
            if ((i3 & 12582912) == 0) {
                i10 = 65536;
                if ((i5 & 128) == 0) {
                    i9 = i;
                    int i42 = gapComposer2.changed(i9) ? 8388608 : 4194304;
                    i40 |= i42;
                } else {
                    i9 = i;
                }
                i40 |= i42;
            } else {
                i9 = i;
                i10 = 65536;
            }
            i11 = i5 & 256;
            if (i11 != 0) {
                i40 |= 100663296;
                function8 = function1;
            } else {
                function8 = function1;
                if ((i3 & 100663296) == 0) {
                    if (gapComposer2.changedInstance(function8)) {
                        i12 = 67108864;
                    } else {
                        i12 = 33554432;
                    }
                    i40 |= i12;
                }
            }
            i13 = i40 | 805306368;
            i14 = i5 & 1024;
            if (i14 != 0) {
                i15 = i4 | 6;
            } else if ((i4 & 6) == 0) {
                if (gapComposer2.changedInstance(function4)) {
                    i16 = 4;
                } else {
                    i16 = 2;
                }
                i15 = i4 | i16;
            } else {
                i15 = i4;
            }
            i17 = i5 & 2048;
            if (i17 != 0) {
                i15 |= 48;
            } else if ((i4 & 48) == 0) {
                if ((i4 & 64) == 0) {
                    zChangedInstance = gapComposer2.changed(list);
                } else {
                    zChangedInstance = gapComposer2.changedInstance(list);
                }
                if (zChangedInstance) {
                    i18 = 32;
                } else {
                    i18 = 16;
                }
                i15 |= i18;
            }
            i19 = i15;
            i20 = i5 & 4096;
            if (i20 != 0) {
                i22 = i19 | 384;
            } else {
                i21 = i19;
                if ((i4 & 384) != 0) {
                    if (gapComposer2.changedInstance(function5)) {
                        i23 = 256;
                    } else {
                        i23 = 128;
                    }
                    i21 |= i23;
                }
                i22 = i21;
            }
            i24 = i5 & 8192;
            if (i24 != 0) {
                i26 = i22 | 3072;
            } else {
                i25 = i22;
                if ((i4 & 3072) == 0) {
                    if (gapComposer2.changedInstance(function6)) {
                        i27 = 2048;
                    } else {
                        i27 = 1024;
                    }
                    i26 = i25 | i27;
                } else {
                    i26 = i25;
                }
            }
            if ((i4 & 24576) != 0) {
                if (gapComposer2.changedInstance(function0)) {
                    i37 = 16384;
                } else {
                    i37 = 8192;
                }
                i26 |= i37;
            }
            i28 = i26 | 196608;
            i29 = i5 & i10;
            if (i29 != 0) {
                i28 = i26 | 1769472;
            } else if ((i4 & 1572864) == 0) {
                if (gapComposer2.changedInstance(function7)) {
                    i30 = ByteChannelKt.CHANNEL_MAX_SIZE;
                } else {
                    i30 = 524288;
                }
                i28 |= i30;
            }
            if ((i13 & 306783379) == 306783378 || (i28 & 599187) != 599186) {
                z6 = true;
            } else {
                z6 = false;
            }
            if (gapComposer2.shouldExecute(i13 & 1, z6)) {
                gapComposer2.startDefaults();
                i33 = i3 & 1;
                neverEqualPolicy = Composer.Companion.Empty;
                if (i33 != 0 || gapComposer2.getDefaultsInvalid()) {
                    b = 7;
                    if (i39 != 0) {
                        textFieldValue4 = new TextFieldValue(7, 0L, (String) null);
                    } else {
                        textFieldValue4 = textFieldValue2;
                    }
                    if (i41 != 0) {
                        z4 = true;
                    }
                    if (i7 != 0) {
                        z9 = true;
                    } else {
                        z9 = z2;
                    }
                    if ((i5 & 128) != 0) {
                        if (z4) {
                            i36 = 1;
                        } else {
                            i36 = 10;
                        }
                        i13 &= -29360129;
                        i9 = i36;
                    }
                    if (i11 != 0) {
                        objRememberedValue2 = gapComposer2.rememberedValue();
                        if (objRememberedValue2 == neverEqualPolicy) {
                            objRememberedValue2 = new AlbumMenuKt$$ExternalSyntheticLambda13(b);
                            gapComposer2.updateRememberedValue(objRememberedValue2);
                        }
                        function8 = (Function1) objRememberedValue2;
                    }
                    if (i14 != 0) {
                        objRememberedValue = gapComposer2.rememberedValue();
                        if (objRememberedValue == neverEqualPolicy) {
                            objRememberedValue = new AlbumMenuKt$$ExternalSyntheticLambda13((byte) 6);
                            gapComposer2.updateRememberedValue(objRememberedValue);
                        }
                        function14 = (Function1) objRememberedValue;
                    } else {
                        function14 = function4;
                    }
                    if (i17 != 0) {
                        list3 = null;
                    } else {
                        list3 = list;
                    }
                    if (i20 != 0) {
                        function15 = null;
                    } else {
                        function15 = function5;
                    }
                    if (i24 != 0) {
                        function16 = null;
                    } else {
                        function16 = function6;
                    }
                    modifier3 = Modifier.Companion.$$INSTANCE;
                    if (i29 != 0) {
                        function18 = function14;
                        z10 = z4;
                        list4 = list3;
                        function19 = function15;
                        function20 = function16;
                        i34 = i9;
                        i35 = 1;
                        z11 = true;
                        function17 = null;
                    } else {
                        function17 = function7;
                        function18 = function14;
                        z10 = z4;
                        list4 = list3;
                        function19 = function15;
                        function20 = function16;
                        i34 = i9;
                        i35 = 1;
                        z11 = true;
                    }
                } else {
                    gapComposer2.skipToGroupEnd();
                    if ((i5 & 128) != 0) {
                        i13 &= -29360129;
                    }
                    modifier3 = modifier;
                    i35 = i2;
                    function18 = function4;
                    list4 = list;
                    function19 = function5;
                    function20 = function6;
                    z11 = z3;
                    function17 = function7;
                    z10 = z4;
                    z9 = z5;
                    textFieldValue4 = textFieldValue2;
                    i34 = i9;
                }
                gapComposer2.endDefaults();
                objRememberedValue3 = gapComposer2.rememberedValue();
                if (objRememberedValue3 == neverEqualPolicy) {
                    objRememberedValue3 = Stack.mutableStateOf$default(textFieldValue4);
                    gapComposer2.updateRememberedValue(objRememberedValue3);
                }
                final MutableState mutableState = (MutableState) objRememberedValue3;
                objRememberedValue4 = gapComposer2.rememberedValue();
                if (objRememberedValue4 == neverEqualPolicy) {
                    objRememberedValue4 = new FocusRequester();
                    gapComposer2.updateRememberedValue(objRememberedValue4);
                }
                focusRequester = (FocusRequester) objRememberedValue4;
                z12 = (3670016 & i13) == 1048576;
                objRememberedValue5 = gapComposer2.rememberedValue();
                if (z12 || objRememberedValue5 == neverEqualPolicy) {
                    objRememberedValue5 = new Updater$checkForUpdate$2(z9, (Object) focusRequester, (Continuation) null, (byte) 3);
                    gapComposer2.updateRememberedValue(objRememberedValue5);
                }
                Stack.LaunchedEffect(gapComposer2, Unit.INSTANCE, (Function2) objRememberedValue5);
                DefaultDialog(function0, modifier3, function2, function3, Expect_jvmKt.rememberComposableLambda(-1644797899, new QueueMenuKt$$ExternalSyntheticLambda6(function0, list4, function8, mutableState, function18, z11, function20), gapComposer2), null, Expect_jvmKt.rememberComposableLambda(1005687327, new Function3() { // from class: com.metrolist.music.ui.component.DialogKt$$ExternalSyntheticLambda12
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.functions.Function2] */
                    /* JADX WARN: Type inference failed for: r12v14 */
                    /* JADX WARN: Type inference failed for: r12v17 */
                    /* JADX WARN: Type inference failed for: r12v18 */
                    /* JADX WARN: Type inference failed for: r12v19 */
                    /* JADX WARN: Type inference failed for: r12v8, types: [androidx.compose.runtime.GapComposer, java.lang.Object] */
                    /* JADX WARN: Type inference failed for: r12v9, types: [int] */
                    /* JADX WARN: Type inference failed for: r1v10 */
                    /* JADX WARN: Type inference failed for: r1v12, types: [boolean, int] */
                    /* JADX WARN: Type inference failed for: r1v15 */
                    /* JADX WARN: Type inference failed for: r1v25 */
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
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        MutableState mutableState2;
                        ?? r1;
                        ?? r12;
                        List list5;
                        boolean z13;
                        Function0 function21;
                        char c;
                        ColumnScopeInstance columnScopeInstance = (ColumnScopeInstance) obj;
                        Composer composer2 = (Composer) obj2;
                        int iIntValue = ((Integer) obj3).intValue();
                        columnScopeInstance.getClass();
                        if ((iIntValue & 6) == 0) {
                            iIntValue |= ((GapComposer) composer2).changed(columnScopeInstance) ? 4 : 2;
                        }
                        GapComposer gapComposer3 = (GapComposer) composer2;
                        boolean zShouldExecute = gapComposer3.shouldExecute(iIntValue & 1, (iIntValue & 19) != 18);
                        Unit unit = Unit.INSTANCE;
                        if (!zShouldExecute) {
                            gapComposer3.skipToGroupEnd();
                            return unit;
                        }
                        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                        Modifier modifierWeight = columnScopeInstance.weight(companion, 1.0f, false);
                        ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start, gapComposer3, 0);
                        int iHashCode = Long.hashCode(gapComposer3.compositeKeyHashCode);
                        PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer3.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer3, modifierWeight);
                        ComposeUiNode.Companion.getClass();
                        gapComposer3.startReusableNode();
                        boolean z14 = gapComposer3.inserting;
                        TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
                        if (z14) {
                            gapComposer3.createNode(textKt$$ExternalSyntheticLambda3);
                        } else {
                            gapComposer3.useNode();
                        }
                        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetMeasurePolicy;
                        Stack.m390setimpl(gapComposer3, columnMeasurePolicy, updater$$ExternalSyntheticLambda0);
                        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                        Stack.m390setimpl(gapComposer3, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda1);
                        Integer numValueOf = Integer.valueOf(iHashCode);
                        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetCompositeKeyHash;
                        Stack.m390setimpl(gapComposer3, numValueOf, updater$$ExternalSyntheticLambda2);
                        Stack.m389reconcileimpl(gapComposer3);
                        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetModifier;
                        Stack.m390setimpl(gapComposer3, modifierMaterializeModifier, updater$$ExternalSyntheticLambda3);
                        List list6 = list4;
                        boolean z15 = z10;
                        boolean z16 = i35;
                        boolean z17 = z11;
                        Function0 function22 = function0;
                        FocusRequester focusRequester2 = focusRequester;
                        byte b2 = i34;
                        NeverEqualPolicy neverEqualPolicy2 = Composer.Companion.Empty;
                        int i43 = 6;
                        if (list6 != null) {
                            gapComposer3.startReplaceGroup(341435606);
                            int i44 = 0;
                            ?? r13 = z16;
                            for (Object obj4 : list6) {
                                int i45 = i44 + 1;
                                if (i44 < 0) {
                                    CollectionsKt__IterablesKt.throwIndexOverflow();
                                    throw null;
                                }
                                Pair pair = (Pair) obj4;
                                String str = (String) pair.first;
                                TextFieldValue textFieldValue5 = (TextFieldValue) pair.second;
                                TextFieldColors textFieldColorsColors = TextFieldDefaults.colors(i43, gapComposer3);
                                byte b3 = b2;
                                boolean z18 = z15;
                                KeyboardOptions keyboardOptions = new KeyboardOptions(r13, z15 ? 7 : 0, 115);
                                Function1 function23 = function20;
                                boolean zChanged = gapComposer3.changed(function23) | gapComposer3.changedInstance(list6) | gapComposer3.changed(z17) | gapComposer3.changed(function22);
                                Object objRememberedValue6 = gapComposer3.rememberedValue();
                                if (zChanged || objRememberedValue6 == neverEqualPolicy2) {
                                    boolean z19 = z17;
                                    Function0 function24 = function22;
                                    List list7 = list6;
                                    objRememberedValue6 = new DialogKt$$ExternalSyntheticLambda16(function23, list7, z19, function24, (byte) 0);
                                    list5 = list7;
                                    z13 = z19;
                                    function21 = function24;
                                    gapComposer3.updateRememberedValue(objRememberedValue6);
                                } else {
                                    Function0 function25 = function22;
                                    z13 = z17;
                                    list5 = list6;
                                    function21 = function25;
                                }
                                List list8 = list5;
                                KeyboardActions keyboardActions = new KeyboardActions((Function1) objRememberedValue6, null, 62);
                                Modifier modifierThen = OffsetKt.m139paddingqDBjuR0$default(SizeKt.fillMaxWidth(companion, 1.0f), CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, i44 < list8.size() + (-1) ? 12.0f : CropImageView.DEFAULT_ASPECT_RATIO, 7).then(i44 == 0 ? FocusTraversalKt.focusRequester(companion, focusRequester2) : companion);
                                Function2 function26 = function19;
                                boolean zChanged2 = gapComposer3.changed(function26) | gapComposer3.changed(i44);
                                Object objRememberedValue7 = gapComposer3.rememberedValue();
                                if (zChanged2 || objRememberedValue7 == neverEqualPolicy2) {
                                    c = 4;
                                    objRememberedValue7 = new RawWebSocketCommonKt$$ExternalSyntheticLambda0(function26, i44, (byte) 4);
                                    gapComposer3.updateRememberedValue(objRememberedValue7);
                                } else {
                                    c = 4;
                                }
                                GapComposer gapComposer4 = gapComposer3;
                                ScrimKt.TextField(textFieldValue5, (Function1) objRememberedValue7, modifierThen, false, null, Expect_jvmKt.rememberComposableLambda(-1501551384, new MainActivity$$ExternalSyntheticLambda6(str, (byte) 3), gapComposer3), null, keyboardOptions, keyboardActions, z18, b3, 0, null, textFieldColorsColors, gapComposer4, 12582912, 0, 3702648);
                                r13 = r13 == true ? 1 : 0;
                                focusRequester2 = focusRequester2;
                                neverEqualPolicy2 = neverEqualPolicy2;
                                z17 = z13;
                                function22 = function21;
                                i43 = 6;
                                z15 = z18;
                                b2 = b3;
                                gapComposer3 = gapComposer4;
                                i44 = i45;
                                list6 = list8;
                            }
                            GapComposer gapComposer5 = gapComposer3;
                            r1 = 0;
                            gapComposer5.end(false);
                            r12 = gapComposer5;
                        } else {
                            gapComposer3.startReplaceGroup(342993945);
                            Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                            Object objRememberedValue8 = gapComposer3.rememberedValue();
                            if (objRememberedValue8 == neverEqualPolicy2) {
                                objRememberedValue8 = DialogKt$TextFieldDialog$5$1$2$1.INSTANCE;
                                gapComposer3.updateRememberedValue(objRememberedValue8);
                            }
                            Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(modifierFillMaxWidth, unit, (PointerInputEventHandler) objRememberedValue8);
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
                            int iHashCode2 = Long.hashCode(gapComposer3.compositeKeyHashCode);
                            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer3.currentCompositionLocalScope();
                            Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer3, modifierPointerInput);
                            gapComposer3.startReusableNode();
                            if (gapComposer3.inserting) {
                                gapComposer3.createNode(textKt$$ExternalSyntheticLambda3);
                            } else {
                                gapComposer3.useNode();
                            }
                            Stack.m390setimpl(gapComposer3, measurePolicyMaybeCachedBoxMeasurePolicy, updater$$ExternalSyntheticLambda0);
                            Stack.m390setimpl(gapComposer3, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
                            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer3, updater$$ExternalSyntheticLambda2, gapComposer3);
                            Stack.m390setimpl(gapComposer3, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
                            MutableState mutableState3 = mutableState;
                            TextFieldValue textFieldValue6 = (TextFieldValue) mutableState3.getValue();
                            TextFieldColors textFieldColorsColors2 = TextFieldDefaults.colors(6, gapComposer3);
                            KeyboardOptions keyboardOptions2 = new KeyboardOptions(z16 ? 1 : 0, z15 ? 7 : 0, 115);
                            Function1 function27 = function18;
                            boolean zChanged3 = gapComposer3.changed(function27) | gapComposer3.changed(z17) | gapComposer3.changed(function22);
                            Object objRememberedValue9 = gapComposer3.rememberedValue();
                            if (zChanged3 || objRememberedValue9 == neverEqualPolicy2) {
                                objRememberedValue9 = new DialogKt$$ExternalSyntheticLambda16(function27, mutableState3, z17, function22, (byte) 2);
                                mutableState2 = mutableState3;
                                gapComposer3.updateRememberedValue(objRememberedValue9);
                            } else {
                                mutableState2 = mutableState3;
                            }
                            KeyboardActions keyboardActions2 = new KeyboardActions((Function1) objRememberedValue9, null, 62);
                            Modifier modifierFocusRequester = FocusTraversalKt.focusRequester(SizeKt.fillMaxWidth(companion, 1.0f), focusRequester2);
                            Object objRememberedValue10 = gapComposer3.rememberedValue();
                            if (objRememberedValue10 == neverEqualPolicy2) {
                                objRememberedValue10 = new TooltipKt$$ExternalSyntheticLambda5(mutableState2, (byte) 10);
                                gapComposer3.updateRememberedValue(objRememberedValue10);
                            }
                            ScrimKt.TextField(textFieldValue6, (Function1) objRememberedValue10, modifierFocusRequester, false, null, null, null, keyboardOptions2, keyboardActions2, z15, b2, 0, null, textFieldColorsColors2, gapComposer3, 48, 0, 3702648);
                            GapComposer gapComposer6 = gapComposer3;
                            gapComposer6.end(true);
                            r1 = 0;
                            gapComposer6.end(false);
                            r12 = gapComposer6;
                        }
                        ?? r0 = function17;
                        if (r0 == 0) {
                            r12.startReplaceGroup(344701796);
                        } else {
                            r12.startReplaceGroup(288214077);
                            r0.invoke(r12, Integer.valueOf((int) r1));
                        }
                        r12.end(r1);
                        r12.end(true);
                        return unit;
                    }
                }, gapComposer2), gapComposer2, ((i28 >> 12) & 14) | 1600944, 32);
                gapComposer = gapComposer2;
                textFieldValue3 = textFieldValue4;
                z7 = z9;
                modifier2 = modifier3;
                function12 = function8;
                list2 = list4;
                function11 = function17;
                z4 = z10;
                i32 = i35;
                function10 = function20;
                z8 = z11;
                function13 = function19;
                i31 = i34;
                function9 = function18;
            } else {
                gapComposer = gapComposer2;
                gapComposer.skipToGroupEnd();
                modifier2 = modifier;
                z7 = z2;
                function9 = function4;
                list2 = list;
                function10 = function6;
                function11 = function7;
                textFieldValue3 = textFieldValue2;
                i31 = i9;
                function12 = function8;
                i32 = i2;
                function13 = function5;
                z8 = z3;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.metrolist.music.ui.component.DialogKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        int iUpdateChangedFlags = Stack.updateChangedFlags(i3 | 1);
                        int iUpdateChangedFlags2 = Stack.updateChangedFlags(i4);
                        Modifier modifier4 = modifier2;
                        Function2 function21 = function2;
                        Function2 function22 = function3;
                        TextFieldValue textFieldValue5 = textFieldValue3;
                        boolean z13 = z4;
                        boolean z14 = z7;
                        byte b2 = i31;
                        Function1 function23 = function12;
                        boolean z15 = i32;
                        Function1 function24 = function9;
                        List list5 = list2;
                        Function2 function25 = function13;
                        Function1 function26 = function10;
                        Function0 function27 = function0;
                        boolean z16 = z8;
                        Function2 function28 = function11;
                        int i43 = i5;
                        DialogKt.m1470TextFieldDialog5RwOfIE(modifier4, function21, function22, textFieldValue5, z13, z14, b2, function23, z15 ? 1 : 0, function24, list5, function25, function26, function27, z16, function28, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i43);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i40 = 221184 | i6;
        z4 = z;
        i7 = i5 & 64;
        if (i7 != 0) {
            i40 |= 1572864;
            z5 = z2;
        } else {
            z5 = z2;
            if ((i3 & 1572864) == 0) {
                if (gapComposer2.changed(z5)) {
                    i8 = ByteChannelKt.CHANNEL_MAX_SIZE;
                } else {
                    i8 = 524288;
                }
                i40 |= i8;
            }
        }
        if ((i3 & 12582912) == 0) {
            i10 = 65536;
            if ((i5 & 128) == 0) {
                i9 = i;
                if (gapComposer2.changed(i9)) {
                }
                i40 |= i42;
            } else {
                i9 = i;
            }
            i40 |= i42;
        } else {
            i9 = i;
            i10 = 65536;
        }
        i11 = i5 & 256;
        if (i11 != 0) {
            i40 |= 100663296;
            function8 = function1;
        } else {
            function8 = function1;
            if ((i3 & 100663296) == 0) {
                if (gapComposer2.changedInstance(function8)) {
                    i12 = 67108864;
                } else {
                    i12 = 33554432;
                }
                i40 |= i12;
            }
        }
        i13 = i40 | 805306368;
        i14 = i5 & 1024;
        if (i14 != 0) {
            i15 = i4 | 6;
        } else if ((i4 & 6) == 0) {
            if (gapComposer2.changedInstance(function4)) {
                i16 = 4;
            } else {
                i16 = 2;
            }
            i15 = i4 | i16;
        } else {
            i15 = i4;
        }
        i17 = i5 & 2048;
        if (i17 != 0) {
            i15 |= 48;
        } else if ((i4 & 48) == 0) {
            if ((i4 & 64) == 0) {
                zChangedInstance = gapComposer2.changed(list);
            } else {
                zChangedInstance = gapComposer2.changedInstance(list);
            }
            if (zChangedInstance) {
                i18 = 32;
            } else {
                i18 = 16;
            }
            i15 |= i18;
        }
        i19 = i15;
        i20 = i5 & 4096;
        if (i20 != 0) {
            i22 = i19 | 384;
        } else {
            i21 = i19;
            if ((i4 & 384) != 0) {
                if (gapComposer2.changedInstance(function5)) {
                    i23 = 256;
                } else {
                    i23 = 128;
                }
                i21 |= i23;
            }
            i22 = i21;
        }
        i24 = i5 & 8192;
        if (i24 != 0) {
            i26 = i22 | 3072;
        } else {
            i25 = i22;
            if ((i4 & 3072) == 0) {
                if (gapComposer2.changedInstance(function6)) {
                    i27 = 2048;
                } else {
                    i27 = 1024;
                }
                i26 = i25 | i27;
            } else {
                i26 = i25;
            }
        }
        if ((i4 & 24576) != 0) {
            if (gapComposer2.changedInstance(function0)) {
                i37 = 16384;
            } else {
                i37 = 8192;
            }
            i26 |= i37;
        }
        i28 = i26 | 196608;
        i29 = i5 & i10;
        if (i29 != 0) {
            i28 = i26 | 1769472;
        } else if ((i4 & 1572864) == 0) {
            if (gapComposer2.changedInstance(function7)) {
                i30 = ByteChannelKt.CHANNEL_MAX_SIZE;
            } else {
                i30 = 524288;
            }
            i28 |= i30;
        }
        if ((i13 & 306783379) == 306783378) {
            z6 = true;
        } else {
            z6 = true;
        }
        if (gapComposer2.shouldExecute(i13 & 1, z6)) {
            gapComposer2.startDefaults();
            i33 = i3 & 1;
            neverEqualPolicy = Composer.Companion.Empty;
            if (i33 != 0) {
                b = 7;
                if (i39 != 0) {
                    textFieldValue4 = new TextFieldValue(7, 0L, (String) null);
                } else {
                    textFieldValue4 = textFieldValue2;
                }
                if (i41 != 0) {
                    z4 = true;
                }
                if (i7 != 0) {
                    z9 = true;
                } else {
                    z9 = z2;
                }
                if ((i5 & 128) != 0) {
                    if (z4) {
                        i36 = 1;
                    } else {
                        i36 = 10;
                    }
                    i13 &= -29360129;
                    i9 = i36;
                }
                if (i11 != 0) {
                    objRememberedValue2 = gapComposer2.rememberedValue();
                    if (objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = new AlbumMenuKt$$ExternalSyntheticLambda13(b);
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    }
                    function8 = (Function1) objRememberedValue2;
                }
                if (i14 != 0) {
                    objRememberedValue = gapComposer2.rememberedValue();
                    if (objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new AlbumMenuKt$$ExternalSyntheticLambda13((byte) 6);
                        gapComposer2.updateRememberedValue(objRememberedValue);
                    }
                    function14 = (Function1) objRememberedValue;
                } else {
                    function14 = function4;
                }
                if (i17 != 0) {
                    list3 = null;
                } else {
                    list3 = list;
                }
                if (i20 != 0) {
                    function15 = null;
                } else {
                    function15 = function5;
                }
                if (i24 != 0) {
                    function16 = null;
                } else {
                    function16 = function6;
                }
                modifier3 = Modifier.Companion.$$INSTANCE;
                if (i29 != 0) {
                    function18 = function14;
                    z10 = z4;
                    list4 = list3;
                    function19 = function15;
                    function20 = function16;
                    i34 = i9;
                    i35 = 1;
                    z11 = true;
                    function17 = null;
                } else {
                    function17 = function7;
                    function18 = function14;
                    z10 = z4;
                    list4 = list3;
                    function19 = function15;
                    function20 = function16;
                    i34 = i9;
                    i35 = 1;
                    z11 = true;
                }
            } else {
                b = 7;
                if (i39 != 0) {
                    textFieldValue4 = new TextFieldValue(7, 0L, (String) null);
                } else {
                    textFieldValue4 = textFieldValue2;
                }
                if (i41 != 0) {
                    z4 = true;
                }
                if (i7 != 0) {
                    z9 = true;
                } else {
                    z9 = z2;
                }
                if ((i5 & 128) != 0) {
                    if (z4) {
                        i36 = 1;
                    } else {
                        i36 = 10;
                    }
                    i13 &= -29360129;
                    i9 = i36;
                }
                if (i11 != 0) {
                    objRememberedValue2 = gapComposer2.rememberedValue();
                    if (objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = new AlbumMenuKt$$ExternalSyntheticLambda13(b);
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    }
                    function8 = (Function1) objRememberedValue2;
                }
                if (i14 != 0) {
                    objRememberedValue = gapComposer2.rememberedValue();
                    if (objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new AlbumMenuKt$$ExternalSyntheticLambda13((byte) 6);
                        gapComposer2.updateRememberedValue(objRememberedValue);
                    }
                    function14 = (Function1) objRememberedValue;
                } else {
                    function14 = function4;
                }
                if (i17 != 0) {
                    list3 = null;
                } else {
                    list3 = list;
                }
                if (i20 != 0) {
                    function15 = null;
                } else {
                    function15 = function5;
                }
                if (i24 != 0) {
                    function16 = null;
                } else {
                    function16 = function6;
                }
                modifier3 = Modifier.Companion.$$INSTANCE;
                if (i29 != 0) {
                    function18 = function14;
                    z10 = z4;
                    list4 = list3;
                    function19 = function15;
                    function20 = function16;
                    i34 = i9;
                    i35 = 1;
                    z11 = true;
                    function17 = null;
                } else {
                    function17 = function7;
                    function18 = function14;
                    z10 = z4;
                    list4 = list3;
                    function19 = function15;
                    function20 = function16;
                    i34 = i9;
                    i35 = 1;
                    z11 = true;
                }
            }
            gapComposer2.endDefaults();
            objRememberedValue3 = gapComposer2.rememberedValue();
            if (objRememberedValue3 == neverEqualPolicy) {
                objRememberedValue3 = Stack.mutableStateOf$default(textFieldValue4);
                gapComposer2.updateRememberedValue(objRememberedValue3);
            }
            final MutableState mutableState2 = (MutableState) objRememberedValue3;
            objRememberedValue4 = gapComposer2.rememberedValue();
            if (objRememberedValue4 == neverEqualPolicy) {
                objRememberedValue4 = new FocusRequester();
                gapComposer2.updateRememberedValue(objRememberedValue4);
            }
            focusRequester = (FocusRequester) objRememberedValue4;
            if ((3670016 & i13) == 1048576) {
            }
            objRememberedValue5 = gapComposer2.rememberedValue();
            if (z12) {
                objRememberedValue5 = new Updater$checkForUpdate$2(z9, (Object) focusRequester, (Continuation) null, (byte) 3);
                gapComposer2.updateRememberedValue(objRememberedValue5);
            } else {
                objRememberedValue5 = new Updater$checkForUpdate$2(z9, (Object) focusRequester, (Continuation) null, (byte) 3);
                gapComposer2.updateRememberedValue(objRememberedValue5);
            }
            Stack.LaunchedEffect(gapComposer2, Unit.INSTANCE, (Function2) objRememberedValue5);
            DefaultDialog(function0, modifier3, function2, function3, Expect_jvmKt.rememberComposableLambda(-1644797899, new QueueMenuKt$$ExternalSyntheticLambda6(function0, list4, function8, mutableState2, function18, z11, function20), gapComposer2), null, Expect_jvmKt.rememberComposableLambda(1005687327, new Function3() { // from class: com.metrolist.music.ui.component.DialogKt$$ExternalSyntheticLambda12
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.functions.Function2] */
                /* JADX WARN: Type inference failed for: r12v14 */
                /* JADX WARN: Type inference failed for: r12v17 */
                /* JADX WARN: Type inference failed for: r12v18 */
                /* JADX WARN: Type inference failed for: r12v19 */
                /* JADX WARN: Type inference failed for: r12v8, types: [androidx.compose.runtime.GapComposer, java.lang.Object] */
                /* JADX WARN: Type inference failed for: r12v9, types: [int] */
                /* JADX WARN: Type inference failed for: r1v10 */
                /* JADX WARN: Type inference failed for: r1v12, types: [boolean, int] */
                /* JADX WARN: Type inference failed for: r1v15 */
                /* JADX WARN: Type inference failed for: r1v25 */
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
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    MutableState mutableState3;
                    ?? r1;
                    ?? r12;
                    List list5;
                    boolean z13;
                    Function0 function21;
                    char c;
                    ColumnScopeInstance columnScopeInstance = (ColumnScopeInstance) obj;
                    Composer composer2 = (Composer) obj2;
                    int iIntValue = ((Integer) obj3).intValue();
                    columnScopeInstance.getClass();
                    if ((iIntValue & 6) == 0) {
                        iIntValue |= ((GapComposer) composer2).changed(columnScopeInstance) ? 4 : 2;
                    }
                    GapComposer gapComposer3 = (GapComposer) composer2;
                    boolean zShouldExecute = gapComposer3.shouldExecute(iIntValue & 1, (iIntValue & 19) != 18);
                    Unit unit = Unit.INSTANCE;
                    if (!zShouldExecute) {
                        gapComposer3.skipToGroupEnd();
                        return unit;
                    }
                    Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                    Modifier modifierWeight = columnScopeInstance.weight(companion, 1.0f, false);
                    ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start, gapComposer3, 0);
                    int iHashCode = Long.hashCode(gapComposer3.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer3.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer3, modifierWeight);
                    ComposeUiNode.Companion.getClass();
                    gapComposer3.startReusableNode();
                    boolean z14 = gapComposer3.inserting;
                    TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
                    if (z14) {
                        gapComposer3.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer3.useNode();
                    }
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetMeasurePolicy;
                    Stack.m390setimpl(gapComposer3, columnMeasurePolicy, updater$$ExternalSyntheticLambda0);
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                    Stack.m390setimpl(gapComposer3, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda1);
                    Integer numValueOf = Integer.valueOf(iHashCode);
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetCompositeKeyHash;
                    Stack.m390setimpl(gapComposer3, numValueOf, updater$$ExternalSyntheticLambda2);
                    Stack.m389reconcileimpl(gapComposer3);
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetModifier;
                    Stack.m390setimpl(gapComposer3, modifierMaterializeModifier, updater$$ExternalSyntheticLambda3);
                    List list6 = list4;
                    boolean z15 = z10;
                    boolean z16 = i35;
                    boolean z17 = z11;
                    Function0 function22 = function0;
                    FocusRequester focusRequester2 = focusRequester;
                    byte b2 = i34;
                    NeverEqualPolicy neverEqualPolicy2 = Composer.Companion.Empty;
                    int i43 = 6;
                    if (list6 != null) {
                        gapComposer3.startReplaceGroup(341435606);
                        int i44 = 0;
                        ?? r13 = z16;
                        for (Object obj4 : list6) {
                            int i45 = i44 + 1;
                            if (i44 < 0) {
                                CollectionsKt__IterablesKt.throwIndexOverflow();
                                throw null;
                            }
                            Pair pair = (Pair) obj4;
                            String str = (String) pair.first;
                            TextFieldValue textFieldValue5 = (TextFieldValue) pair.second;
                            TextFieldColors textFieldColorsColors = TextFieldDefaults.colors(i43, gapComposer3);
                            byte b3 = b2;
                            boolean z18 = z15;
                            KeyboardOptions keyboardOptions = new KeyboardOptions(r13, z15 ? 7 : 0, 115);
                            Function1 function23 = function20;
                            boolean zChanged = gapComposer3.changed(function23) | gapComposer3.changedInstance(list6) | gapComposer3.changed(z17) | gapComposer3.changed(function22);
                            Object objRememberedValue6 = gapComposer3.rememberedValue();
                            if (zChanged || objRememberedValue6 == neverEqualPolicy2) {
                                boolean z19 = z17;
                                Function0 function24 = function22;
                                List list7 = list6;
                                objRememberedValue6 = new DialogKt$$ExternalSyntheticLambda16(function23, list7, z19, function24, (byte) 0);
                                list5 = list7;
                                z13 = z19;
                                function21 = function24;
                                gapComposer3.updateRememberedValue(objRememberedValue6);
                            } else {
                                Function0 function25 = function22;
                                z13 = z17;
                                list5 = list6;
                                function21 = function25;
                            }
                            List list8 = list5;
                            KeyboardActions keyboardActions = new KeyboardActions((Function1) objRememberedValue6, null, 62);
                            Modifier modifierThen = OffsetKt.m139paddingqDBjuR0$default(SizeKt.fillMaxWidth(companion, 1.0f), CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, i44 < list8.size() + (-1) ? 12.0f : CropImageView.DEFAULT_ASPECT_RATIO, 7).then(i44 == 0 ? FocusTraversalKt.focusRequester(companion, focusRequester2) : companion);
                            Function2 function26 = function19;
                            boolean zChanged2 = gapComposer3.changed(function26) | gapComposer3.changed(i44);
                            Object objRememberedValue7 = gapComposer3.rememberedValue();
                            if (zChanged2 || objRememberedValue7 == neverEqualPolicy2) {
                                c = 4;
                                objRememberedValue7 = new RawWebSocketCommonKt$$ExternalSyntheticLambda0(function26, i44, (byte) 4);
                                gapComposer3.updateRememberedValue(objRememberedValue7);
                            } else {
                                c = 4;
                            }
                            GapComposer gapComposer4 = gapComposer3;
                            ScrimKt.TextField(textFieldValue5, (Function1) objRememberedValue7, modifierThen, false, null, Expect_jvmKt.rememberComposableLambda(-1501551384, new MainActivity$$ExternalSyntheticLambda6(str, (byte) 3), gapComposer3), null, keyboardOptions, keyboardActions, z18, b3, 0, null, textFieldColorsColors, gapComposer4, 12582912, 0, 3702648);
                            r13 = r13 == true ? 1 : 0;
                            focusRequester2 = focusRequester2;
                            neverEqualPolicy2 = neverEqualPolicy2;
                            z17 = z13;
                            function22 = function21;
                            i43 = 6;
                            z15 = z18;
                            b2 = b3;
                            gapComposer3 = gapComposer4;
                            i44 = i45;
                            list6 = list8;
                        }
                        GapComposer gapComposer5 = gapComposer3;
                        r1 = 0;
                        gapComposer5.end(false);
                        r12 = gapComposer5;
                    } else {
                        gapComposer3.startReplaceGroup(342993945);
                        Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                        Object objRememberedValue8 = gapComposer3.rememberedValue();
                        if (objRememberedValue8 == neverEqualPolicy2) {
                            objRememberedValue8 = DialogKt$TextFieldDialog$5$1$2$1.INSTANCE;
                            gapComposer3.updateRememberedValue(objRememberedValue8);
                        }
                        Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(modifierFillMaxWidth, unit, (PointerInputEventHandler) objRememberedValue8);
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
                        int iHashCode2 = Long.hashCode(gapComposer3.compositeKeyHashCode);
                        PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer3.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer3, modifierPointerInput);
                        gapComposer3.startReusableNode();
                        if (gapComposer3.inserting) {
                            gapComposer3.createNode(textKt$$ExternalSyntheticLambda3);
                        } else {
                            gapComposer3.useNode();
                        }
                        Stack.m390setimpl(gapComposer3, measurePolicyMaybeCachedBoxMeasurePolicy, updater$$ExternalSyntheticLambda0);
                        Stack.m390setimpl(gapComposer3, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
                        IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer3, updater$$ExternalSyntheticLambda2, gapComposer3);
                        Stack.m390setimpl(gapComposer3, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
                        MutableState mutableState4 = mutableState2;
                        TextFieldValue textFieldValue6 = (TextFieldValue) mutableState4.getValue();
                        TextFieldColors textFieldColorsColors2 = TextFieldDefaults.colors(6, gapComposer3);
                        KeyboardOptions keyboardOptions2 = new KeyboardOptions(z16 ? 1 : 0, z15 ? 7 : 0, 115);
                        Function1 function27 = function18;
                        boolean zChanged3 = gapComposer3.changed(function27) | gapComposer3.changed(z17) | gapComposer3.changed(function22);
                        Object objRememberedValue9 = gapComposer3.rememberedValue();
                        if (zChanged3 || objRememberedValue9 == neverEqualPolicy2) {
                            objRememberedValue9 = new DialogKt$$ExternalSyntheticLambda16(function27, mutableState4, z17, function22, (byte) 2);
                            mutableState3 = mutableState4;
                            gapComposer3.updateRememberedValue(objRememberedValue9);
                        } else {
                            mutableState3 = mutableState4;
                        }
                        KeyboardActions keyboardActions2 = new KeyboardActions((Function1) objRememberedValue9, null, 62);
                        Modifier modifierFocusRequester = FocusTraversalKt.focusRequester(SizeKt.fillMaxWidth(companion, 1.0f), focusRequester2);
                        Object objRememberedValue10 = gapComposer3.rememberedValue();
                        if (objRememberedValue10 == neverEqualPolicy2) {
                            objRememberedValue10 = new TooltipKt$$ExternalSyntheticLambda5(mutableState3, (byte) 10);
                            gapComposer3.updateRememberedValue(objRememberedValue10);
                        }
                        ScrimKt.TextField(textFieldValue6, (Function1) objRememberedValue10, modifierFocusRequester, false, null, null, null, keyboardOptions2, keyboardActions2, z15, b2, 0, null, textFieldColorsColors2, gapComposer3, 48, 0, 3702648);
                        GapComposer gapComposer6 = gapComposer3;
                        gapComposer6.end(true);
                        r1 = 0;
                        gapComposer6.end(false);
                        r12 = gapComposer6;
                    }
                    ?? r0 = function17;
                    if (r0 == 0) {
                        r12.startReplaceGroup(344701796);
                    } else {
                        r12.startReplaceGroup(288214077);
                        r0.invoke(r12, Integer.valueOf((int) r1));
                    }
                    r12.end(r1);
                    r12.end(true);
                    return unit;
                }
            }, gapComposer2), gapComposer2, ((i28 >> 12) & 14) | 1600944, 32);
            gapComposer = gapComposer2;
            textFieldValue3 = textFieldValue4;
            z7 = z9;
            modifier2 = modifier3;
            function12 = function8;
            list2 = list4;
            function11 = function17;
            z4 = z10;
            i32 = i35;
            function10 = function20;
            z8 = z11;
            function13 = function19;
            i31 = i34;
            function9 = function18;
        } else {
            gapComposer = gapComposer2;
            gapComposer.skipToGroupEnd();
            modifier2 = modifier;
            z7 = z2;
            function9 = function4;
            list2 = list;
            function10 = function6;
            function11 = function7;
            textFieldValue3 = textFieldValue2;
            i31 = i9;
            function12 = function8;
            i32 = i2;
            function13 = function5;
            z8 = z3;
        }
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.metrolist.music.ui.component.DialogKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(i3 | 1);
                    int iUpdateChangedFlags2 = Stack.updateChangedFlags(i4);
                    Modifier modifier4 = modifier2;
                    Function2 function21 = function2;
                    Function2 function22 = function3;
                    TextFieldValue textFieldValue5 = textFieldValue3;
                    boolean z13 = z4;
                    boolean z14 = z7;
                    byte b2 = i31;
                    Function1 function23 = function12;
                    boolean z15 = i32;
                    Function1 function24 = function9;
                    List list5 = list2;
                    Function2 function25 = function13;
                    Function1 function26 = function10;
                    Function0 function27 = function0;
                    boolean z16 = z8;
                    Function2 function28 = function11;
                    int i43 = i5;
                    DialogKt.m1470TextFieldDialog5RwOfIE(modifier4, function21, function22, textFieldValue5, z13, z14, b2, function23, z15 ? 1 : 0, function24, list5, function25, function26, function27, z16, function28, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i43);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final ButtonColors dialogConfirmColors(GapComposer gapComposer) {
        if (!UiStyleKt.isGlassStyle(gapComposer)) {
            gapComposer.startReplaceGroup(73078859);
            PaddingValuesImpl paddingValuesImpl = ButtonDefaults.ContentPadding;
            ButtonColors defaultButtonColors$material3 = ButtonDefaults.getDefaultButtonColors$material3(((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme);
            gapComposer.end(false);
            return defaultButtonColors$material3;
        }
        gapComposer.startReplaceGroup(72770719);
        PaddingValuesImpl paddingValuesImpl2 = ButtonDefaults.ContentPadding;
        StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
        long j = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.onPrimary;
        long j2 = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.onPrimary;
        ButtonColors buttonColorsM247buttonColorsro_MJ88 = ButtonDefaults.m247buttonColorsro_MJ88(0L, j, ColorKt.Color(Color.m485getRedimpl(j2), Color.m484getGreenimpl(j2), Color.m482getBlueimpl(j2), 0.5f, Color.m483getColorSpaceimpl(j2)), gapComposer, 0);
        gapComposer.end(false);
        return buttonColorsM247buttonColorsro_MJ88;
    }

    public static final String dialogLabel(String str, GapComposer gapComposer) {
        if (UiStyleKt.isGlassStyle(gapComposer)) {
            return str;
        }
        String upperCase = str.toUpperCase(Locale.ROOT);
        upperCase.getClass();
        return upperCase;
    }

    /* JADX INFO: renamed from: drawAuralysMark-RIQooxk, reason: not valid java name */
    public static final void m1471drawAuralysMarkRIQooxk(DrawScope drawScope, long j, long j2, float f, float f2, float f3) {
        float fM448getMinDimensionimpl = Size.m448getMinDimensionimpl(drawScope.mo556getSizeNHjbRc()) / 512.0f;
        char c = ' ';
        float f4 = 512.0f * fM448getMinDimensionimpl;
        float fIntBitsToFloat = (Float.intBitsToFloat((int) (drawScope.mo556getSizeNHjbRc() >> 32)) - f4) / 2.0f;
        long j3 = 4294967295L;
        float fIntBitsToFloat2 = (Float.intBitsToFloat((int) (drawScope.mo556getSizeNHjbRc() & 4294967295L)) - f4) / 2.0f;
        EmojiProcessor drawContext = drawScope.getDrawContext();
        long jM831getSizeNHjbRc = drawContext.m831getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            DrawResult drawResult = (DrawResult) drawContext.mSpanFactory;
            drawResult.translate(fIntBitsToFloat, fIntBitsToFloat2);
            drawResult.m403scale0AR0LA0(fM448getMinDimensionimpl, fM448getMinDimensionimpl, 0L);
            EmojiProcessor drawContext2 = drawScope.getDrawContext();
            long jM831getSizeNHjbRc2 = drawContext2.m831getSizeNHjbRc();
            drawContext2.getCanvas().save();
            try {
                ((DrawResult) drawContext2.mSpanFactory).m401clipRectN_I0leg(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 512.0f, 340.0f, 1);
                float f5 = (1.0f - f) * 210.0f;
                int i = 0;
                while (true) {
                    float[] fArr = SunBands;
                    if (i >= 8) {
                        break;
                    }
                    float f6 = fArr[i] + f5;
                    float f7 = fArr[i + 1] + f5;
                    EmojiProcessor drawContext3 = drawScope.getDrawContext();
                    long j4 = j3;
                    long jM831getSizeNHjbRc3 = drawContext3.m831getSizeNHjbRc();
                    drawContext3.getCanvas().save();
                    try {
                        ((DrawResult) drawContext3.mSpanFactory).m401clipRectN_I0leg(CropImageView.DEFAULT_ASPECT_RATIO, f6, 512.0f, f7, 1);
                        int i2 = i;
                        char c2 = c;
                        DrawScope.m543drawCircleVaOC9Bg$default(drawScope, j, 190.0f, (((long) Float.floatToRawIntBits(256.0f)) << c2) | (((long) Float.floatToRawIntBits(f5 + 340.0f)) & j4), null, 0, 120);
                        drawContext3.getCanvas().restore();
                        drawContext3.m832setSizeuvyYCjk(jM831getSizeNHjbRc3);
                        i = i2 + 2;
                        c = c2;
                        j3 = j4;
                    } catch (Throwable th) {
                        drawContext3.getCanvas().restore();
                        drawContext3.m832setSizeuvyYCjk(jM831getSizeNHjbRc3);
                        throw th;
                    }
                }
                char c3 = c;
                long j5 = j3;
                drawContext2.getCanvas().restore();
                drawContext2.m832setSizeuvyYCjk(jM831getSizeNHjbRc2);
                DrawScope.m552drawRoundRectuAw5IA$default(drawScope, j2, (((long) Float.floatToRawIntBits(96.0f)) << c3) | (((long) Float.floatToRawIntBits(340.0f)) & j5), (((long) Float.floatToRawIntBits(320.0f)) << c3) | (((long) Float.floatToRawIntBits(10.0f)) & j5), (((long) Float.floatToRawIntBits(5.0f)) << c3) | (((long) Float.floatToRawIntBits(5.0f)) & j5), null, 240);
                if (f2 > 0.001f) {
                    AndroidPath androidPathPath = AndroidPath_androidKt.Path();
                    int iCoerceIn = (int) (UuidKt.coerceIn(f2, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f) * 60.0f);
                    if (iCoerceIn < 1) {
                        iCoerceIn = 1;
                    }
                    if (iCoerceIn >= 0) {
                        int i3 = 0;
                        while (true) {
                            float f8 = i3 / 60.0f;
                            float f9 = (160.0f * f8) + 176.0f;
                            float fSin = 392.0f - (((float) Math.sin(((((double) f8) * 3.0d) + ((double) f3)) * 6.283185307179586d)) * 12.0f);
                            if (i3 == 0) {
                                androidPathPath.moveTo(f9, fSin);
                            } else {
                                androidPathPath.lineTo(f9, fSin);
                            }
                            if (i3 == iCoerceIn) {
                                break;
                            } else {
                                i3++;
                            }
                        }
                    }
                    DrawScope.m548drawPathLG529CI$default(drawScope, androidPathPath, j2, CropImageView.DEFAULT_ASPECT_RATIO, new Stroke(9.0f, CropImageView.DEFAULT_ASPECT_RATIO, 1, 1, 18), 52);
                }
                IntIntPair$$ExternalSyntheticOutline0.m(drawContext, jM831getSizeNHjbRc);
            } catch (Throwable th2) {
                drawContext2.getCanvas().restore();
                drawContext2.m832setSizeuvyYCjk(jM831getSizeNHjbRc2);
                throw th2;
            }
        } catch (Throwable th3) {
            IntIntPair$$ExternalSyntheticOutline0.m(drawContext, jM831getSizeNHjbRc);
            throw th3;
        }
    }

    /* JADX INFO: renamed from: editorialPanel-eaDK9VM, reason: not valid java name */
    public static final Modifier m1472editorialPaneleaDK9VM(Modifier modifier, RoundedCornerShape roundedCornerShape, Composer composer, int i, int i2) {
        modifier.getClass();
        if ((i2 & 1) != 0) {
            roundedCornerShape = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(12.0f);
        }
        Rgb rgb = ColorSpaces.Unspecified;
        ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
        ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
        GapComposer gapComposer = (GapComposer) composer;
        if (gapComposer.consume(UiStyleKt.LocalUiStyle) == UiStyle.GLASS) {
            roundedCornerShape = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(22.0f);
        }
        return GlassComponentsKt.glass(modifier, roundedCornerShape, false, gapComposer, i & 14, 2);
    }

    /* JADX INFO: renamed from: hairlineBottom-iJQMabo, reason: not valid java name */
    public static final Modifier m1473hairlineBottomiJQMabo(Modifier modifier, Composer composer, int i) {
        modifier.getClass();
        long j = ((MaterialTheme$Values) ((GapComposer) composer).consume(MaterialThemeKt._localMaterialTheme)).colorScheme.outlineVariant;
        GapComposer gapComposer = (GapComposer) composer;
        if (gapComposer.consume(UiStyleKt.LocalUiStyle) == UiStyle.GLASS) {
            gapComposer.startReplaceGroup(-1687212507);
        } else {
            gapComposer.startReplaceGroup(-1687211889);
            boolean zChanged = gapComposer.changed(j);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = new InnerTube$$ExternalSyntheticLambda2(j, (byte) 6);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            modifier = ClipKt.drawBehind(modifier, (Function1) objRememberedValue);
        }
        gapComposer.end(false);
        return modifier;
    }

    /* JADX INFO: renamed from: hairlineTop-iJQMabo, reason: not valid java name */
    public static final Modifier m1474hairlineTopiJQMabo(Modifier modifier, GapComposer gapComposer, int i) {
        modifier.getClass();
        long j = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.outlineVariant;
        if (gapComposer.consume(UiStyleKt.LocalUiStyle) == UiStyle.GLASS) {
            gapComposer.startReplaceGroup(802503249);
        } else {
            gapComposer.startReplaceGroup(802503838);
            boolean zChanged = gapComposer.changed(j);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = new InnerTube$$ExternalSyntheticLambda2(j, (byte) 5);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            modifier = ClipKt.drawBehind(modifier, (Function1) objRememberedValue);
        }
        gapComposer.end(false);
        return modifier;
    }

    public static final Modifier pressScale(Modifier modifier, final float f) {
        modifier.getClass();
        return modifier.then(new ComposedModifier(new Function3() { // from class: com.metrolist.music.ui.component.EditorialComponentsKt$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Modifier modifier2 = (Modifier) obj;
                ((Integer) obj3).getClass();
                modifier2.getClass();
                GapComposer gapComposer = (GapComposer) ((Composer) obj2);
                gapComposer.startReplaceGroup(-167156744);
                Object objRememberedValue = gapComposer.rememberedValue();
                NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                if (objRememberedValue == neverEqualPolicy) {
                    objRememberedValue = ArcSplineKt.Animatable$default(1.0f);
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                final Animatable animatable = (Animatable) objRememberedValue;
                Object objRememberedValue2 = gapComposer.rememberedValue();
                if (objRememberedValue2 == neverEqualPolicy) {
                    objRememberedValue2 = Stack.createCompositionCoroutineScope(gapComposer);
                    gapComposer.updateRememberedValue(objRememberedValue2);
                }
                final CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue2;
                boolean zChangedInstance = gapComposer.changedInstance(coroutineScope) | gapComposer.changedInstance(animatable);
                final float f2 = f;
                boolean zChanged = zChangedInstance | gapComposer.changed(f2);
                Object objRememberedValue3 = gapComposer.rememberedValue();
                if (zChanged || objRememberedValue3 == neverEqualPolicy) {
                    objRememberedValue3 = new PointerInputEventHandler() { // from class: com.metrolist.music.ui.component.EditorialComponentsKt$pressScale$1$1$1

                        /* JADX INFO: renamed from: com.metrolist.music.ui.component.EditorialComponentsKt$pressScale$1$1$1$1, reason: invalid class name */
                        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                        public final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2 {
                            public final /* synthetic */ float $pressedScale;
                            public final /* synthetic */ Animatable $scale;
                            public final /* synthetic */ CoroutineScope $scope;
                            public /* synthetic */ Object L$0;
                            public byte label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            public AnonymousClass1(CoroutineScope coroutineScope, Animatable animatable, float f, Continuation continuation) {
                                super(2, continuation);
                                this.$scope = coroutineScope;
                                this.$scale = animatable;
                                this.$pressedScale = f;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation create(Object obj, Continuation continuation) {
                                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$scope, this.$scale, this.$pressedScale, continuation);
                                anonymousClass1.L$0 = obj;
                                return anonymousClass1;
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ((AnonymousClass1) create((SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
                            }

                            /* JADX WARN: Code restructure failed: missing block: B:14:0x0046, code lost:
                            
                                if (androidx.compose.foundation.gestures.TapGestureDetectorKt.waitForUpOrCancellation(r0, androidx.compose.ui.input.pointer.PointerEventPass.Main, r9) == r8) goto L15;
                             */
                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                            */
                            public final Object invokeSuspend(Object obj) {
                                SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine pointerEventHandlerCoroutine = (SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) this.L$0;
                                byte b = this.label;
                                CoroutineScope coroutineScope = this.$scope;
                                Animatable animatable = this.$scale;
                                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                                if (b == 0) {
                                    ResultKt.throwOnFailure(obj);
                                    this.L$0 = pointerEventHandlerCoroutine;
                                    this.label = (byte) 1;
                                    if (TapGestureDetectorKt.awaitFirstDown$default(pointerEventHandlerCoroutine, this, 2) != coroutineSingletons) {
                                    }
                                    return coroutineSingletons;
                                }
                                if (b == 1) {
                                    ResultKt.throwOnFailure(obj);
                                } else {
                                    if (b != 2) {
                                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                                        return null;
                                    }
                                    ResultKt.throwOnFailure(obj);
                                }
                                AwaitKt.launch$default(coroutineScope, null, null, new ThumbnailKt$ThumbnailImage$1$1(animatable, null, (byte) 5), 3);
                                return Unit.INSTANCE;
                                AwaitKt.launch$default(coroutineScope, null, null, new MiniPlayerKt$NewMiniPlayer$2$1$1$4$1(animatable, this.$pressedScale, null, (byte) 3), 3);
                                this.L$0 = null;
                                this.label = (byte) 2;
                            }
                        }

                        @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                        public final Object invoke(PointerInputScope pointerInputScope, Continuation continuation) {
                            Object objAwaitEachGesture = ScrollableKt.awaitEachGesture(pointerInputScope, new AnonymousClass1(coroutineScope, animatable, f2, null), continuation);
                            return objAwaitEachGesture == CoroutineSingletons.COROUTINE_SUSPENDED ? objAwaitEachGesture : Unit.INSTANCE;
                        }
                    };
                    gapComposer.updateRememberedValue(objRememberedValue3);
                }
                Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(modifier2, Unit.INSTANCE, (PointerInputEventHandler) objRememberedValue3);
                boolean zChangedInstance2 = gapComposer.changedInstance(animatable);
                Object objRememberedValue4 = gapComposer.rememberedValue();
                if (zChangedInstance2 || objRememberedValue4 == neverEqualPolicy) {
                    objRememberedValue4 = new MiniPlayerKt$$ExternalSyntheticLambda2(animatable, (byte) 4);
                    gapComposer.updateRememberedValue(objRememberedValue4);
                }
                Modifier modifierGraphicsLayer = ColorKt.graphicsLayer(modifierPointerInput, (Function1) objRememberedValue4);
                gapComposer.end(false);
                return modifierGraphicsLayer;
            }
        }));
    }

    /* JADX INFO: renamed from: rememberBottomSheetState-jTDHpeQ, reason: not valid java name */
    public static final BottomSheetState m1475rememberBottomSheetStatejTDHpeQ(float f, float f2, float f3, Composer composer, int i, int i2) {
        float f4;
        byte b = 1;
        byte b2 = 0;
        int i3 = (i2 & 8) != 0 ? 0 : 1;
        GapComposer gapComposer = (GapComposer) composer;
        Density density = (Density) gapComposer.consume(CompositionLocalsKt.LocalDensity);
        Object objRememberedValue = gapComposer.rememberedValue();
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        if (objRememberedValue == neverEqualPolicy) {
            objRememberedValue = Stack.createCompositionCoroutineScope(gapComposer);
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
        Object[] objArr = new Object[0];
        boolean z = (((i & 7168) ^ 3072) > 2048 && gapComposer.changed(i3)) || (i & 3072) == 2048;
        Object objRememberedValue2 = gapComposer.rememberedValue();
        if (z || objRememberedValue2 == neverEqualPolicy) {
            objRememberedValue2 = new LoadingScreenKt$$ExternalSyntheticLambda4(b, i3);
            gapComposer.updateRememberedValue(objRememberedValue2);
        }
        ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = (ParcelableSnapshotMutableIntState) SaverKt.rememberSaveable(objArr, (Function0) objRememberedValue2, gapComposer, 0);
        Object objRememberedValue3 = gapComposer.rememberedValue();
        Continuation continuation = null;
        if (objRememberedValue3 == neverEqualPolicy) {
            objRememberedValue3 = new Animatable(new Dp(CropImageView.DEFAULT_ASPECT_RATIO), ArcSplineKt.DpToVector, continuation, 12);
            gapComposer.updateRememberedValue(objRememberedValue3);
        }
        Animatable animatable = (Animatable) objRememberedValue3;
        boolean zChanged = ((((i & 14) ^ 6) > 4 && gapComposer.changed(f)) || (i & 6) == 4) | gapComposer.changed(f2) | gapComposer.changed(f3) | gapComposer.changed(coroutineScope);
        Object objRememberedValue4 = gapComposer.rememberedValue();
        if (zChanged || objRememberedValue4 == neverEqualPolicy) {
            int intValue = parcelableSnapshotMutableIntState.getIntValue();
            byte b3 = 2;
            if (intValue == 0) {
                f4 = f;
            } else if (intValue == 1) {
                f4 = f3;
            } else {
                if (intValue != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Unknown BottomSheet anchor");
                    return null;
                }
                f4 = f2;
            }
            Dp dp = new Dp(f);
            Dp dp2 = new Dp(f2);
            if (dp.compareTo(dp2) > 0) {
                dp = dp2;
            }
            animatable.updateBounds(dp, new Dp(f2));
            AwaitKt.launch$default(coroutineScope, null, null, new MiniPlayerKt$NewMiniPlayer$2$1$1$4$1(animatable, f4, continuation, b3), 3);
            MainActivity$$ExternalSyntheticLambda21 mainActivity$$ExternalSyntheticLambda21 = new MainActivity$$ExternalSyntheticLambda21((Object) coroutineScope, (Object) animatable, (Object) density, (byte) 9);
            DraggableKt$NoOpOnDragStarted$1 draggableKt$NoOpOnDragStarted$1 = DraggableKt.NoOpOnDragStarted;
            BottomSheetState bottomSheetState = new BottomSheetState(new DefaultDraggableState(mainActivity$$ExternalSyntheticLambda21), coroutineScope, animatable, new BottomSheetKt$$ExternalSyntheticLambda9(parcelableSnapshotMutableIntState, b2), f3);
            gapComposer.updateRememberedValue(bottomSheetState);
            objRememberedValue4 = bottomSheetState;
        }
        return (BottomSheetState) objRememberedValue4;
    }

    /* JADX INFO: renamed from: riseIn-wH6b6FI$default, reason: not valid java name */
    public static Modifier m1476riseInwH6b6FI$default(Modifier modifier, final int i) {
        modifier.getClass();
        return modifier.then(new ComposedModifier(new Function3() { // from class: com.metrolist.music.ui.component.EditorialComponentsKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Modifier modifier2 = (Modifier) obj;
                ((Integer) obj3).getClass();
                modifier2.getClass();
                GapComposer gapComposer = (GapComposer) ((Composer) obj2);
                gapComposer.startReplaceGroup(549041854);
                Object objRememberedValue = gapComposer.rememberedValue();
                NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                if (objRememberedValue == neverEqualPolicy) {
                    objRememberedValue = ArcSplineKt.Animatable$default(CropImageView.DEFAULT_ASPECT_RATIO);
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                Animatable animatable = (Animatable) objRememberedValue;
                boolean zChangedInstance = gapComposer.changedInstance(animatable);
                short s = i;
                boolean zChanged = zChangedInstance | gapComposer.changed((int) s);
                Object objRememberedValue2 = gapComposer.rememberedValue();
                if (zChanged || objRememberedValue2 == neverEqualPolicy) {
                    objRememberedValue2 = new EditorialComponentsKt$riseIn$1$1$1(animatable, s, null);
                    gapComposer.updateRememberedValue(objRememberedValue2);
                }
                Stack.LaunchedEffect(gapComposer, Unit.INSTANCE, (Function2) objRememberedValue2);
                boolean zChangedInstance2 = gapComposer.changedInstance(animatable) | gapComposer.changed(14.0f);
                Object objRememberedValue3 = gapComposer.rememberedValue();
                if (zChangedInstance2 || objRememberedValue3 == neverEqualPolicy) {
                    objRememberedValue3 = new MiniPlayerKt$$ExternalSyntheticLambda2(animatable, (byte) 3);
                    gapComposer.updateRememberedValue(objRememberedValue3);
                }
                Modifier modifierGraphicsLayer = ColorKt.graphicsLayer(modifier2, (Function1) objRememberedValue3);
                gapComposer.end(false);
                return modifierGraphicsLayer;
            }
        }));
    }
}
