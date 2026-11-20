package com.metrolist.music.ui.menu;

import android.content.Context;
import android.graphics.Typeface;
import android.text.Spannable;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.TransitionInstance;
import androidx.compose.foundation.AbstractClickableNode$handlePressInteractionRelease$1$1;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.MarqueeSpacing$Companion$$ExternalSyntheticLambda0;
import androidx.compose.foundation.contextmenu.ContextMenuColors;
import androidx.compose.foundation.contextmenu.ContextMenuScope;
import androidx.compose.foundation.gestures.DraggableKt$NoOpOnDragStarted$1;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.PressGestureScopeImpl;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.layout.Arrangement$End$1;
import androidx.compose.foundation.layout.Arrangement$SpacedAligned;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.foundation.lazy.grid.LazyGridItemScopeImpl;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.foundation.pager.PagerStateKt;
import androidx.compose.foundation.pager.PagerStateKt$UnitDensity$1;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextFieldPointerModifier_commonKt$$ExternalSyntheticLambda1;
import androidx.compose.foundation.text.selection.SelectionMagnifierKt;
import androidx.compose.material3.BadgeKt$$ExternalSyntheticLambda4;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.ChipKt;
import androidx.compose.material3.FilterChipDefaults;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.RippleKt;
import androidx.compose.material3.RippleNodeFactory;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda5;
import androidx.compose.material3.pulltorefresh.PullToRefreshDefaults;
import androidx.compose.material3.pulltorefresh.PullToRefreshStateImpl;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.SnapshotStateKt__DerivedStateKt;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.ZIndexNode$$ExternalSyntheticLambda0;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.AndroidParagraphIntrinsics;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.android.style.TypefaceSpan;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontFamilyResolverImpl;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.TypefaceResult;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.emoji2.text.EmojiProcessor;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.media3.common.PlaybackException;
import androidx.media3.exoplayer.ExoPlayerImpl;
import androidx.navigation.NavHostController;
import androidx.room.RoomDatabase$closeBarrier$1;
import coil3.ComponentRegistry$Builder$$ExternalSyntheticLambda2;
import coil3.ImageLoader$Builder$$ExternalSyntheticLambda1;
import coil3.RealImageLoader;
import coil3.RealImageLoader$execute$result$1;
import coil3.util.UtilsKt;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.math.IntMath;
import com.metrolist.innertube.models.BrowseEndpoint;
import com.metrolist.innertube.models.PlaylistItem;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.pages.HomePage;
import com.metrolist.innertubex.cipher.QuickJsEngine$evaluate$3;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda1;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda22;
import com.metrolist.music.MainActivityKt;
import com.metrolist.music.constants.MyTopFilter;
import com.metrolist.music.constants.SongFilter;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Album;
import com.metrolist.music.db.entities.AlbumEntity;
import com.metrolist.music.db.entities.AlbumWithSongs;
import com.metrolist.music.db.entities.Artist;
import com.metrolist.music.db.entities.LocalItem;
import com.metrolist.music.listentogether.ListenTogetherManager;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.models.SimilarRecommendation;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.ui.component.DialogKt;
import com.metrolist.music.ui.component.GlassComponentsKt;
import com.metrolist.music.ui.component.Icon;
import com.metrolist.music.ui.component.ItemsKt$$ExternalSyntheticLambda4;
import com.metrolist.music.ui.component.Material3MenuItemData;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.component.SortHeaderKt$SortHeader$1$2$1;
import com.metrolist.music.ui.player.QueueKt;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda16;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda40;
import com.metrolist.music.ui.screens.AccountScreenKt$AccountScreen$1$1$5$1$1$1;
import com.metrolist.music.ui.screens.HistoryScreenKt$$ExternalSyntheticLambda20;
import com.metrolist.music.ui.screens.HomeScreenKt$$ExternalSyntheticLambda120;
import com.metrolist.music.ui.screens.HomeScreenKt$$ExternalSyntheticLambda66;
import com.metrolist.music.ui.screens.HomeScreenKt$$ExternalSyntheticLambda67;
import com.metrolist.music.ui.screens.HomeScreenKt$$ExternalSyntheticLambda72;
import com.metrolist.music.ui.screens.HomeScreenKt$HomeScreen$8$1;
import com.metrolist.music.ui.screens.StatsScreenKt$$ExternalSyntheticLambda7;
import com.metrolist.music.ui.screens.artist.ArtistItemsScreenKt;
import com.metrolist.music.ui.screens.library.LibraryScreenKt;
import com.metrolist.music.ui.screens.library.LibrarySongsScreenKt$$ExternalSyntheticLambda17;
import com.metrolist.music.ui.screens.playlist.TopPlaylistScreenKt;
import com.metrolist.music.ui.screens.podcast.OnlinePodcastScreenKt;
import com.metrolist.music.ui.screens.podcast.OnlinePodcastScreenKt$$ExternalSyntheticLambda16;
import com.metrolist.music.ui.screens.recognition.RecognitionHistoryScreenKt;
import com.metrolist.music.ui.screens.search.SearchScreenKt$$ExternalSyntheticLambda11;
import com.metrolist.music.ui.theme.UiStyleKt;
import com.metrolist.music.viewmodels.AccountContentType;
import com.metrolist.music.viewmodels.AccountViewModel;
import com.metrolist.music.viewmodels.ArtistViewModel;
import com.metrolist.music.viewmodels.LocalFilter;
import com.metrolist.music.viewmodels.LocalSearchViewModel;
import com.metrolist.music.viewmodels.OnlinePlaylistViewModel;
import com.metrolist.music.viewmodels.OnlinePodcastViewModel;
import com.metrolist.music.viewmodels.TopPlaylistViewModel;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.http.MimesKt$$ExternalSyntheticLambda0;
import io.ktor.network.sockets.DatagramKt;
import io.ktor.sse.ServerSentEventKt;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyMap;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.math.MathKt;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AlbumMenuKt$$ExternalSyntheticLambda11 implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ AlbumMenuKt$$ExternalSyntheticLambda11(Object obj, Object obj2, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = obj2;
    }

    private final Object invoke$com$metrolist$music$ui$screens$HomeScreenKt$$ExternalSyntheticLambda38(Object obj, Object obj2, Object obj3) {
        ComposableLambdaImpl composableLambdaImplRememberComposableLambda;
        SimilarRecommendation similarRecommendation = (SimilarRecommendation) this.f$0;
        LocalItem localItem = similarRecommendation.title;
        NavHostController navHostController = (NavHostController) this.f$1;
        Composer composer = (Composer) obj2;
        int iIntValue = ((Integer) obj3).intValue();
        ((LazyItemScopeImpl) obj).getClass();
        GapComposer gapComposer = (GapComposer) composer;
        if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
            byte b = 6;
            Modifier modifierM1473hairlineBottomiJQMabo = DialogKt.m1473hairlineBottomiJQMabo(Modifier.Companion.$$INSTANCE, gapComposer, 6);
            String strStringResource = MathKt.stringResource(R.string.similar_to, gapComposer);
            String title = localItem.getTitle();
            String thumbnailUrl = localItem.getThumbnailUrl();
            if (thumbnailUrl == null) {
                gapComposer.startReplaceGroup(1208605447);
                gapComposer.end(false);
                composableLambdaImplRememberComposableLambda = null;
            } else {
                gapComposer.startReplaceGroup(1208605448);
                composableLambdaImplRememberComposableLambda = Expect_jvmKt.rememberComposableLambda(-393174856, new MainActivity$$ExternalSyntheticLambda1((Object) similarRecommendation, (Object) thumbnailUrl, (byte) 23), gapComposer);
                gapComposer.end(false);
            }
            ComposableLambdaImpl composableLambdaImpl = composableLambdaImplRememberComposableLambda;
            boolean zChangedInstance = gapComposer.changedInstance(similarRecommendation) | gapComposer.changedInstance(navHostController);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = new QueueKt$$ExternalSyntheticLambda16(similarRecommendation, navHostController, b);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            MenuKt.NavigationTitle(title, modifierM1473hairlineBottomiJQMabo, strStringResource, composableLambdaImpl, (Function0) objRememberedValue, null, gapComposer, 0, 32);
        } else {
            gapComposer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private final Object invoke$com$metrolist$music$ui$screens$HomeScreenKt$$ExternalSyntheticLambda5(Object obj, Object obj2, Object obj3) {
        PullToRefreshStateImpl pullToRefreshStateImpl = (PullToRefreshStateImpl) this.f$0;
        MutableState mutableState = (MutableState) this.f$1;
        BoxScope boxScope = (BoxScope) obj;
        Composer composer = (Composer) obj2;
        int iIntValue = ((Integer) obj3).intValue();
        boxScope.getClass();
        if ((iIntValue & 6) == 0) {
            iIntValue |= ((GapComposer) composer).changed(boxScope) ? 4 : 2;
        }
        GapComposer gapComposer = (GapComposer) composer;
        if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 19) != 18)) {
            PullToRefreshDefaults.INSTANCE.m378Indicator2poqoh4(pullToRefreshStateImpl, ((Boolean) mutableState.getValue()).booleanValue(), OffsetKt.padding(boxScope.align(Modifier.Companion.$$INSTANCE, Alignment.Companion.TopCenter), OffsetKt.asPaddingValues((WindowInsets) gapComposer.consume(MainActivityKt.LocalPlayerAwareWindowInsets), gapComposer)), 0L, 0L, CropImageView.DEFAULT_ASPECT_RATIO, gapComposer, 1572864);
        } else {
            gapComposer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private final Object invoke$com$metrolist$music$ui$screens$HomeScreenKt$$ExternalSyntheticLambda51(Object obj, Object obj2, Object obj3) {
        ComposableLambdaImpl composableLambdaImpl;
        HomePage.Section section = (HomePage.Section) this.f$0;
        NavHostController navHostController = (NavHostController) this.f$1;
        Composer composer = (Composer) obj2;
        int iIntValue = ((Integer) obj3).intValue();
        ((LazyItemScopeImpl) obj).getClass();
        byte b = 0;
        GapComposer gapComposer = (GapComposer) composer;
        if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
            Modifier modifierM1473hairlineBottomiJQMabo = DialogKt.m1473hairlineBottomiJQMabo(Modifier.Companion.$$INSTANCE, gapComposer, 6);
            String str = section.title;
            String str2 = section.label;
            String str3 = section.thumbnail;
            Function0 function0 = null;
            if (str3 == null) {
                gapComposer.startReplaceGroup(834561260);
                gapComposer.end(false);
                composableLambdaImpl = null;
            } else {
                gapComposer.startReplaceGroup(834561261);
                ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Expect_jvmKt.rememberComposableLambda(-284194322, new HomeScreenKt$$ExternalSyntheticLambda66(section, str3, b), gapComposer);
                gapComposer.end(false);
                composableLambdaImpl = composableLambdaImplRememberComposableLambda;
            }
            BrowseEndpoint browseEndpoint = section.endpoint;
            if (browseEndpoint == null) {
                gapComposer.startReplaceGroup(835927120);
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(835927121);
                boolean zChangedInstance = gapComposer.changedInstance(browseEndpoint) | gapComposer.changedInstance(navHostController);
                Object objRememberedValue = gapComposer.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.Companion.Empty) {
                    objRememberedValue = new HomeScreenKt$$ExternalSyntheticLambda67(browseEndpoint, navHostController, (byte) 0);
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                function0 = (Function0) objRememberedValue;
                gapComposer.end(false);
            }
            MenuKt.NavigationTitle(str, modifierM1473hairlineBottomiJQMabo, str2, composableLambdaImpl, function0, null, gapComposer, 0, 32);
        } else {
            gapComposer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private final Object invoke$com$metrolist$music$ui$screens$artist$ArtistScreenKt$$ExternalSyntheticLambda1(Object obj, Object obj2, Object obj3) {
        ArtistViewModel artistViewModel = (ArtistViewModel) this.f$0;
        Context context = (Context) this.f$1;
        Composer composer = (Composer) obj2;
        int iIntValue = ((Integer) obj3).intValue();
        ((RowScope) obj).getClass();
        GapComposer gapComposer = (GapComposer) composer;
        if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
            boolean zChangedInstance = gapComposer.changedInstance(artistViewModel) | gapComposer.changedInstance(context);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = new QueueKt$$ExternalSyntheticLambda16(artistViewModel, context, (byte) 11);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            CardKt.IconButton((Function0) objRememberedValue, null, false, null, null, ArtistItemsScreenKt.f339lambda$1221544444, gapComposer, 1572864, 62);
        } else {
            gapComposer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private final Object invoke$com$metrolist$music$ui$screens$library$LibraryPodcastsScreenKt$$ExternalSyntheticLambda10(Object obj, Object obj2, Object obj3) {
        NavHostController navHostController = (NavHostController) this.f$0;
        State state = (State) this.f$1;
        Composer composer = (Composer) obj2;
        int iIntValue = ((Integer) obj3).intValue();
        ((LazyItemScopeImpl) obj).getClass();
        GapComposer gapComposer = (GapComposer) composer;
        if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
            String strStringResource = MathKt.stringResource(R.string.new_episodes, gapComposer);
            PlaylistItem playlistItem = (PlaylistItem) state.getValue();
            String str = playlistItem != null ? playlistItem.thumbnail : null;
            PlaylistItem playlistItem2 = (PlaylistItem) state.getValue();
            String str2 = playlistItem2 != null ? playlistItem2.songCountText : null;
            boolean zChangedInstance = gapComposer.changedInstance(navHostController);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = new SearchScreenKt$$ExternalSyntheticLambda11(navHostController, (byte) 3);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            LibraryScreenKt.AutoPlaylistCard(strStringResource, str, str2, (Function0) objRememberedValue, null, gapComposer, 0);
        } else {
            gapComposer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private final Object invoke$com$metrolist$music$ui$screens$library$LibrarySongsScreenKt$$ExternalSyntheticLambda9(Object obj, Object obj2, Object obj3) {
        long jColor;
        long j;
        long j2;
        Function0 function0 = (Function0) this.f$0;
        MutableState mutableState = (MutableState) this.f$1;
        Composer composer = (Composer) obj2;
        int iIntValue = ((Integer) obj3).intValue();
        ((LazyItemScopeImpl) obj).getClass();
        GapComposer gapComposer = (GapComposer) composer;
        if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
            RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(OffsetKt.Start, Alignment.Companion.Top, gapComposer, 0);
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, companion);
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
            PaddingValuesImpl paddingValuesImpl = FilterChipDefaults.ContentPadding;
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
            long j3 = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.surfaceContainer;
            if (UiStyleKt.isGlassStyle(gapComposer)) {
                gapComposer.startReplaceGroup(-1037210375);
                long j4 = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.primary;
                jColor = ColorKt.Color(Color.m485getRedimpl(j4), Color.m484getGreenimpl(j4), Color.m482getBlueimpl(j4), 0.24f, Color.m483getColorSpaceimpl(j4));
            } else {
                gapComposer.startReplaceGroup(-1037208753);
                jColor = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.onSurface;
            }
            gapComposer.end(false);
            long j5 = jColor;
            if (UiStyleKt.isGlassStyle(gapComposer)) {
                gapComposer.startReplaceGroup(-1037205683);
                j = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.primary;
            } else {
                gapComposer.startReplaceGroup(-1037204435);
                j = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.surface;
            }
            gapComposer.end(false);
            if (UiStyleKt.isGlassStyle(gapComposer)) {
                gapComposer.startReplaceGroup(-1037201235);
                j2 = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.primary;
            } else {
                gapComposer.startReplaceGroup(-1037199987);
                j2 = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.surface;
            }
            gapComposer.end(false);
            ChipKt.FilterChip(true, function0, LibraryScreenKt.f366lambda$1061755591, null, false, LibraryScreenKt.f377lambda$609666692, RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(UiStyleKt.m1516styledRadiusi1RSzL4(50.0f, 8.0f, gapComposer)), FilterChipDefaults.m288filterChipColorsXqyqHi0(j3, 0L, j5, j, j2, gapComposer, 2430), null, null, null, null, gapComposer, 196998, 6, 14936);
            List listListOf = CollectionsKt__IterablesKt.listOf((Object[]) new Pair[]{new Pair(SongFilter.LIKED, MathKt.stringResource(R.string.filter_liked, gapComposer)), new Pair(SongFilter.LIBRARY, MathKt.stringResource(R.string.filter_library, gapComposer)), new Pair(SongFilter.UPLOADED, MathKt.stringResource(R.string.filter_uploaded, gapComposer)), new Pair(SongFilter.DOWNLOADED, MathKt.stringResource(R.string.filter_downloaded, gapComposer))});
            SongFilter songFilter = (SongFilter) mutableState.getValue();
            boolean zChanged = gapComposer.changed(mutableState);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = new StatsScreenKt$$ExternalSyntheticLambda7(mutableState, (byte) 5);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            DialogKt.m1461ChipsRowyrwZFoE(listListOf, songFilter, (Function1) objRememberedValue, new LayoutWeightElement(1.0f, true), 0L, gapComposer, 0, 16);
            gapComposer.end(true);
        } else {
            gapComposer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private final Object invoke$com$metrolist$music$ui$screens$playlist$OnlinePlaylistScreenKt$$ExternalSyntheticLambda13(Object obj, Object obj2, Object obj3) {
        OnlinePlaylistViewModel onlinePlaylistViewModel = (OnlinePlaylistViewModel) this.f$0;
        State state = (State) this.f$1;
        LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj;
        Composer composer = (Composer) obj2;
        int iIntValue = ((Integer) obj3).intValue();
        lazyItemScopeImpl.getClass();
        if ((iIntValue & 6) == 0) {
            iIntValue |= ((GapComposer) composer).changed(lazyItemScopeImpl) ? 4 : 2;
        }
        GapComposer gapComposer = (GapComposer) composer;
        if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 19) != 18)) {
            Modifier modifierM135padding3ABfNKs = OffsetKt.m135padding3ABfNKs(LazyItemScopeImpl.fillParentMaxSize$default(lazyItemScopeImpl), 32.0f);
            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Center, Alignment.Companion.CenterHorizontally, gapComposer, 54);
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierM135padding3ABfNKs);
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
            String strM = (String) state.getValue();
            if (strM == null) {
                strM = Format$$ExternalSyntheticOutline0.m(gapComposer, -450479232, R.string.error_unknown, gapComposer, false);
            } else {
                gapComposer.startReplaceGroup(-450479511);
                gapComposer.end(false);
            }
            TextKt.m352TextNvy7gAk(strM, null, 0L, 0L, null, null, null, 0L, new TextAlign(5), 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).typography.bodyLarge, gapComposer, 0, 0, 130046);
            OffsetKt.Spacer(gapComposer, SizeKt.m145height3ABfNKs(Modifier.Companion.$$INSTANCE, 16.0f));
            boolean zChangedInstance = gapComposer.changedInstance(onlinePlaylistViewModel);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = new ImageLoader$Builder$$ExternalSyntheticLambda1((byte) 15, onlinePlaylistViewModel);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            CardKt.TextButton((Function0) objRememberedValue, null, false, null, null, null, TopPlaylistScreenKt.f404lambda$830310595, gapComposer, 805306368, 510);
            gapComposer.end(true);
        } else {
            gapComposer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private final Object invoke$com$metrolist$music$ui$screens$playlist$TopPlaylistScreenKt$$ExternalSyntheticLambda24(Object obj, Object obj2, Object obj3) {
        float f;
        MutableState mutableState;
        Modifier modifierM137paddingVpY3zN4$default;
        int i;
        MutableState mutableState2;
        State state = (State) this.f$0;
        TopPlaylistViewModel topPlaylistViewModel = (TopPlaylistViewModel) this.f$1;
        Composer composer = (Composer) obj2;
        int iIntValue = ((Integer) obj3).intValue();
        ((LazyItemScopeImpl) obj).getClass();
        GapComposer gapComposer = (GapComposer) composer;
        if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
            BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier modifierM139paddingqDBjuR0$default = OffsetKt.m139paddingqDBjuR0$default(companion, 16.0f, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 14);
            Arrangement$End$1 arrangement$End$1 = OffsetKt.Start;
            RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement$End$1, vertical, gapComposer, 48);
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierM139paddingqDBjuR0$default);
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
            MyTopFilter myTopFilter = (MyTopFilter) state.getValue();
            LayoutWeightElement layoutWeightElement = new LayoutWeightElement(1.0f, true);
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState3 = (MutableState) objRememberedValue;
            Modifier modifierM137paddingVpY3zN4$default2 = OffsetKt.m137paddingVpY3zN4$default(layoutWeightElement, CropImageView.DEFAULT_ASPECT_RATIO, 8.0f, 1);
            if (UiStyleKt.isGlassStyle(gapComposer)) {
                gapComposer.startReplaceGroup(-2138758585);
                mutableState = mutableState3;
                f = 8.0f;
                Modifier modifierGlass = GlassComponentsKt.glass(companion, RoundedCornerShapeKt.RoundedCornerShape(50), false, gapComposer, 6, 2);
                companion = companion;
                modifierM137paddingVpY3zN4$default = OffsetKt.m137paddingVpY3zN4$default(modifierGlass, 8.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2);
                gapComposer.end(false);
            } else {
                f = 8.0f;
                mutableState = mutableState3;
                gapComposer.startReplaceGroup(-2138602190);
                gapComposer.end(false);
                modifierM137paddingVpY3zN4$default = companion;
            }
            Modifier modifierThen = modifierM137paddingVpY3zN4$default2.then(modifierM137paddingVpY3zN4$default);
            RowMeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement$End$1, vertical, gapComposer, 48);
            int iHashCode2 = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer, modifierThen);
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer.useNode();
            }
            Stack.m390setimpl(gapComposer, rowMeasurePolicy2, updater$$ExternalSyntheticLambda0);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer, updater$$ExternalSyntheticLambda2, gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
            int iOrdinal = myTopFilter.ordinal();
            if (iOrdinal == 0) {
                i = R.string.all_time;
            } else if (iOrdinal == 1) {
                i = R.string.past_24_hours;
            } else if (iOrdinal == 2) {
                i = R.string.past_week;
            } else if (iOrdinal == 3) {
                i = R.string.past_month;
            } else {
                if (iOrdinal != 4) {
                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                    return null;
                }
                i = R.string.past_year;
            }
            String upperCase = MathKt.stringResource(i, gapComposer).toUpperCase(Locale.ROOT);
            upperCase.getClass();
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
            long j = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.primary;
            TextStyle textStyle = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).typography.labelMedium;
            FontWeight fontWeight = UiStyleKt.isGlassStyle(gapComposer) ? FontWeight.Bold : null;
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
            }
            MutableInteractionSourceImpl mutableInteractionSourceImpl = (MutableInteractionSourceImpl) objRememberedValue2;
            RippleNodeFactory rippleNodeFactoryM313rippleOu1YvPQ$default = RippleKt.m313rippleOu1YvPQ$default(false, CropImageView.DEFAULT_ASPECT_RATIO, 0L, null, 254);
            Object objRememberedValue3 = gapComposer.rememberedValue();
            if (objRememberedValue3 == neverEqualPolicy) {
                mutableState2 = mutableState;
                objRememberedValue3 = new SortHeaderKt$SortHeader$1$2$1(mutableState2, (byte) 0);
                gapComposer.updateRememberedValue(objRememberedValue3);
            } else {
                mutableState2 = mutableState;
            }
            Modifier.Companion companion2 = companion;
            MutableState mutableState4 = mutableState2;
            TextKt.m352TextNvy7gAk(upperCase, OffsetKt.m136paddingVpY3zN4(ImageKt.m45clickableO2vRcR0$default(companion2, mutableInteractionSourceImpl, rippleNodeFactoryM313rippleOu1YvPQ$default, false, null, (Function0) objRememberedValue3, 28), 4.0f, f), j, 0L, null, fontWeight, null, 0L, null, 0L, 0, false, 0, 0, textStyle, gapComposer, 0, 0, 131000);
            boolean zM1492SortHeader$lambda1 = MenuKt.m1492SortHeader$lambda1(mutableState4);
            Object objRememberedValue4 = gapComposer.rememberedValue();
            if (objRememberedValue4 == neverEqualPolicy) {
                objRememberedValue4 = new SortHeaderKt$SortHeader$1$2$1(mutableState4, (byte) 1);
                gapComposer.updateRememberedValue(objRememberedValue4);
            }
            CardKt.m256DropdownMenuIlH_yew(zM1492SortHeader$lambda1, (Function0) objRememberedValue4, SizeKt.m157widthInVpY3zN4$default(companion2, 172.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2), 0L, null, null, null, 0L, CropImageView.DEFAULT_ASPECT_RATIO, Expect_jvmKt.rememberComposableLambda(-1229424361, new AccountScreenKt$AccountScreen$1$1$5$1$1$1((Object) mutableState4, (Object) myTopFilter, (Object) topPlaylistViewModel, (byte) 5), gapComposer), gapComposer, 432, 2040);
            gapComposer.startReplaceGroup(-412803898);
            gapComposer.end(false);
            gapComposer.end(true);
            gapComposer.end(true);
        } else {
            gapComposer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private final Object invoke$com$metrolist$music$ui$screens$podcast$OnlinePodcastScreenKt$$ExternalSyntheticLambda12(Object obj, Object obj2, Object obj3) {
        OnlinePodcastViewModel onlinePodcastViewModel = (OnlinePodcastViewModel) this.f$0;
        State state = (State) this.f$1;
        Composer composer = (Composer) obj2;
        int iIntValue = ((Integer) obj3).intValue();
        ((LazyItemScopeImpl) obj).getClass();
        byte b = 1;
        GapComposer gapComposer = (GapComposer) composer;
        if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
            Modifier modifierM135padding3ABfNKs = OffsetKt.m135padding3ABfNKs(SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f), 32.0f);
            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(new Arrangement$SpacedAligned(16.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5)), Alignment.Companion.CenterHorizontally, gapComposer, 54);
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierM135padding3ABfNKs);
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
            String strM = (String) state.getValue();
            if (strM == null) {
                strM = Format$$ExternalSyntheticOutline0.m(gapComposer, 312444191, R.string.error_unknown, gapComposer, false);
            } else {
                gapComposer.startReplaceGroup(312443912);
                gapComposer.end(false);
            }
            TextKt.m352TextNvy7gAk(strM, null, 0L, 0L, null, null, null, 0L, new TextAlign(3), 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).typography.bodyLarge, gapComposer, 0, 0, 130046);
            boolean zChangedInstance = gapComposer.changedInstance(onlinePodcastViewModel);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = new OnlinePodcastScreenKt$$ExternalSyntheticLambda16(onlinePodcastViewModel, b);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            CardKt.Button((Function0) objRememberedValue, null, false, null, null, null, null, null, null, OnlinePodcastScreenKt.f411lambda$807733303, gapComposer, 805306368, 510);
            gapComposer.end(true);
        } else {
            gapComposer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private final Object invoke$com$metrolist$music$ui$screens$recognition$RecognitionHistoryScreenKt$$ExternalSyntheticLambda12(Object obj, Object obj2, Object obj3) {
        State state = (State) this.f$0;
        MutableState mutableState = (MutableState) this.f$1;
        Composer composer = (Composer) obj2;
        int iIntValue = ((Integer) obj3).intValue();
        ((RowScope) obj).getClass();
        GapComposer gapComposer = (GapComposer) composer;
        if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
            gapComposer.skipToGroupEnd();
        } else if (((List) state.getValue()).isEmpty()) {
            gapComposer.startReplaceGroup(1560563989);
            gapComposer.end(false);
        } else {
            gapComposer.startReplaceGroup(1560204575);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = new LibrarySongsScreenKt$$ExternalSyntheticLambda17(mutableState, (byte) 28);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            CardKt.IconButton((Function0) objRememberedValue, null, false, null, null, RecognitionHistoryScreenKt.lambda$252004198, gapComposer, 1572870, 62);
            gapComposer.end(false);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:356:0x0b25  */
    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        char c;
        Typeface typeface;
        boolean z;
        int i;
        byte b = this.$r8$classId;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetModifier;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetCompositeKeyHash;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetMeasurePolicy;
        TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        byte b2 = 14;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        Unit unit = Unit.INSTANCE;
        Object obj4 = this.f$1;
        Object obj5 = this.f$0;
        switch (b) {
            case 0:
                MusicDatabase musicDatabase = (MusicDatabase) obj5;
                Album album = (Album) obj4;
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    boolean zChangedInstance = gapComposer.changedInstance(musicDatabase) | gapComposer.changed(album);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new ComponentRegistry$Builder$$ExternalSyntheticLambda2(musicDatabase, album, b2);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    CardKt.IconButton((Function0) objRememberedValue, null, false, null, null, Expect_jvmKt.rememberComposableLambda(379093404, new ItemsKt$$ExternalSyntheticLambda4(album, (byte) 1), gapComposer), gapComposer, 1572864, 62);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                return unit;
            case 1:
                Function1 function1 = (Function1) obj5;
                TransitionInstance transitionInstance = (TransitionInstance) obj4;
                MeasureScope measureScope = (MeasureScope) obj;
                Placeable placeableMo598measureBRTryo0 = ((Measurable) obj2).mo598measureBRTryo0(((Constraints) obj3).value);
                long j = (!measureScope.isLookingAhead() || ((Boolean) function1.invoke(transitionInstance.targetState$delegate.getValue())).booleanValue()) ? (((long) placeableMo598measureBRTryo0.width) << 32) | (((long) placeableMo598measureBRTryo0.height) & 4294967295L) : 0L;
                return measureScope.layout((int) (j >> 32), (int) (4294967295L & j), EmptyMap.INSTANCE, new BadgeKt$$ExternalSyntheticLambda4(placeableMo598measureBRTryo0, (byte) 1));
            case 2:
                Function1 function2 = (Function1) obj5;
                ContextMenuColors contextMenuColors = (ContextMenuColors) obj4;
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                    Object objRememberedValue2 = gapComposer2.rememberedValue();
                    if (objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = new ContextMenuScope();
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    }
                    ContextMenuScope contextMenuScope = (ContextMenuScope) objRememberedValue2;
                    contextMenuScope.composables.clear();
                    function2.invoke(contextMenuScope);
                    contextMenuScope.Content$foundation(contextMenuColors, gapComposer2, 0);
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                return unit;
            case 3:
                PagerState pagerState = (PagerState) obj5;
                LayoutDirection layoutDirection = (LayoutDirection) obj4;
                float fFloatValue = ((Float) obj).floatValue();
                float fFloatValue2 = ((Float) obj2).floatValue();
                float fFloatValue3 = ((Float) obj3).floatValue();
                boolean zIsScrollingForward = UtilsKt.isScrollingForward(pagerState, fFloatValue);
                if (pagerState.getLayoutInfo().orientation != Orientation.Vertical && layoutDirection != LayoutDirection.Ltr) {
                    zIsScrollingForward = !zIsScrollingForward;
                }
                int i2 = pagerState.getLayoutInfo().pageSize;
                float fDragGestureDelta = i2 == 0 ? 0.0f : UtilsKt.dragGestureDelta(pagerState) / i2;
                float f = fDragGestureDelta - ((int) fDragGestureDelta);
                if (Math.abs(fFloatValue) < pagerState.density.mo81toPx0680j_4(400.0f)) {
                    c = 0;
                } else {
                    c = fFloatValue > CropImageView.DEFAULT_ASPECT_RATIO ? (char) 1 : (char) 2;
                }
                if (c == 0) {
                    if (Math.abs(f) <= 0.5f) {
                        float fAbs = Math.abs(fDragGestureDelta);
                        Density density = pagerState.density;
                        PagerStateKt$UnitDensity$1 pagerStateKt$UnitDensity$1 = PagerStateKt.UnitDensity;
                        if (fAbs < Math.abs(Math.min(density.mo81toPx0680j_4(56.0f), pagerState.getPageSize$foundation() / 2.0f) / pagerState.getPageSize$foundation()) ? Math.abs(fFloatValue2) >= Math.abs(fFloatValue3) : !zIsScrollingForward) {
                            fFloatValue2 = fFloatValue3;
                        }
                    } else if (zIsScrollingForward) {
                        fFloatValue2 = fFloatValue3;
                    }
                } else if (c == 1) {
                    fFloatValue2 = fFloatValue3;
                } else if (c != 2) {
                    fFloatValue2 = 0.0f;
                }
                return Float.valueOf(fFloatValue2);
            case 4:
                TextFieldPointerModifier_commonKt$$ExternalSyntheticLambda1 textFieldPointerModifier_commonKt$$ExternalSyntheticLambda1 = (TextFieldPointerModifier_commonKt$$ExternalSyntheticLambda1) obj5;
                final MutableInteractionSourceImpl mutableInteractionSourceImpl = (MutableInteractionSourceImpl) obj4;
                ((Integer) obj3).getClass();
                GapComposer gapComposer3 = (GapComposer) ((Composer) obj2);
                gapComposer3.startReplaceGroup(-102778667);
                Object objRememberedValue3 = gapComposer3.rememberedValue();
                if (objRememberedValue3 == neverEqualPolicy) {
                    objRememberedValue3 = Stack.createCompositionCoroutineScope(gapComposer3);
                    gapComposer3.updateRememberedValue(objRememberedValue3);
                }
                final CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue3;
                Object objRememberedValue4 = gapComposer3.rememberedValue();
                if (objRememberedValue4 == neverEqualPolicy) {
                    objRememberedValue4 = Stack.mutableStateOf$default(null);
                    gapComposer3.updateRememberedValue(objRememberedValue4);
                }
                final MutableState mutableState = (MutableState) objRememberedValue4;
                final MutableState mutableStateRememberUpdatedState = Stack.rememberUpdatedState(textFieldPointerModifier_commonKt$$ExternalSyntheticLambda1, gapComposer3);
                boolean zChanged = gapComposer3.changed(mutableInteractionSourceImpl);
                Object objRememberedValue5 = gapComposer3.rememberedValue();
                if (zChanged || objRememberedValue5 == neverEqualPolicy) {
                    objRememberedValue5 = new ZIndexNode$$ExternalSyntheticLambda0((Object) mutableState, (Object) mutableInteractionSourceImpl, (byte) 4);
                    gapComposer3.updateRememberedValue(objRememberedValue5);
                }
                Stack.DisposableEffect(mutableInteractionSourceImpl, (Function1) objRememberedValue5, gapComposer3);
                boolean zChangedInstance2 = gapComposer3.changedInstance(coroutineScope) | gapComposer3.changed(mutableInteractionSourceImpl) | gapComposer3.changed(mutableStateRememberUpdatedState);
                Object objRememberedValue6 = gapComposer3.rememberedValue();
                if (zChangedInstance2 || objRememberedValue6 == neverEqualPolicy) {
                    objRememberedValue6 = new PointerInputEventHandler() { // from class: androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1

                        /* JADX INFO: renamed from: androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1$1, reason: invalid class name */
                        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                        public final class AnonymousClass1 extends SuspendLambda implements Function3 {
                            public final /* synthetic */ MutableInteractionSourceImpl $interactionSource;
                            public final /* synthetic */ MutableState $pressedInteraction;
                            public final /* synthetic */ CoroutineScope $scope;
                            public /* synthetic */ long J$0;
                            public /* synthetic */ PressGestureScopeImpl L$0;
                            public boolean label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            public AnonymousClass1(CoroutineScope coroutineScope, MutableState mutableState, MutableInteractionSourceImpl mutableInteractionSourceImpl, Continuation continuation) {
                                super(3, continuation);
                                this.$scope = coroutineScope;
                                this.$pressedInteraction = mutableState;
                                this.$interactionSource = mutableInteractionSourceImpl;
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                long j = ((Offset) obj2).packedValue;
                                MutableState mutableState = this.$pressedInteraction;
                                MutableInteractionSourceImpl mutableInteractionSourceImpl = this.$interactionSource;
                                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$scope, mutableState, mutableInteractionSourceImpl, (Continuation) obj3);
                                anonymousClass1.L$0 = (PressGestureScopeImpl) obj;
                                anonymousClass1.J$0 = j;
                                return anonymousClass1.invokeSuspend(Unit.INSTANCE);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                boolean z = this.label;
                                CoroutineScope coroutineScope = this.$scope;
                                if (!z) {
                                    ResultKt.throwOnFailure(obj);
                                    PressGestureScopeImpl pressGestureScopeImpl = this.L$0;
                                    AwaitKt.launch$default(coroutineScope, null, null, new AbstractClickableNode$handlePressInteractionRelease$1$1((Object) this.$pressedInteraction, this.J$0, this.$interactionSource, (Continuation) null, (byte) 2), 3);
                                    this.label = true;
                                    obj = pressGestureScopeImpl.tryAwaitRelease(this);
                                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                                    if (obj == coroutineSingletons) {
                                        return coroutineSingletons;
                                    }
                                } else {
                                    if (!z) {
                                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                                        return null;
                                    }
                                    ResultKt.throwOnFailure(obj);
                                }
                                AwaitKt.launch$default(coroutineScope, null, null, new QuickJsEngine$evaluate$3(this.$pressedInteraction, ((Boolean) obj).booleanValue(), this.$interactionSource, null), 3);
                                return Unit.INSTANCE;
                            }
                        }

                        @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                        public final Object invoke(PointerInputScope pointerInputScope, Continuation continuation) {
                            AnonymousClass1 anonymousClass1 = new AnonymousClass1(coroutineScope, mutableState, mutableInteractionSourceImpl, null);
                            TooltipKt$$ExternalSyntheticLambda5 tooltipKt$$ExternalSyntheticLambda5 = new TooltipKt$$ExternalSyntheticLambda5(mutableStateRememberUpdatedState, (byte) 5);
                            DraggableKt$NoOpOnDragStarted$1 draggableKt$NoOpOnDragStarted$1 = TapGestureDetectorKt.NoPressGesture;
                            Object objCoroutineScope = AwaitKt.coroutineScope(new RealImageLoader$execute$result$1(pointerInputScope, anonymousClass1, tooltipKt$$ExternalSyntheticLambda5, new PressGestureScopeImpl(pointerInputScope), null, (byte) 1), continuation);
                            Unit unit2 = Unit.INSTANCE;
                            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                            if (objCoroutineScope != coroutineSingletons) {
                                objCoroutineScope = unit2;
                            }
                            return objCoroutineScope == coroutineSingletons ? objCoroutineScope : unit2;
                        }
                    };
                    gapComposer3.updateRememberedValue(objRememberedValue6);
                }
                Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(companion, mutableInteractionSourceImpl, (PointerInputEventHandler) objRememberedValue6);
                gapComposer3.end(false);
                return modifierPointerInput;
            case 5:
                Function0 function0 = (Function0) obj5;
                Function1 function3 = (Function1) obj4;
                ((Integer) obj3).getClass();
                GapComposer gapComposer4 = (GapComposer) ((Composer) obj2);
                gapComposer4.startReplaceGroup(759876635);
                Object objRememberedValue7 = gapComposer4.rememberedValue();
                if (objRememberedValue7 == neverEqualPolicy) {
                    objRememberedValue7 = SnapshotStateKt__DerivedStateKt.derivedStateOf(function0);
                    gapComposer4.updateRememberedValue(objRememberedValue7);
                }
                State state = (State) objRememberedValue7;
                Object objRememberedValue8 = gapComposer4.rememberedValue();
                if (objRememberedValue8 == neverEqualPolicy) {
                    Offset offset = (Offset) state.getValue();
                    long j2 = offset.packedValue;
                    objRememberedValue8 = new Animatable(offset, SelectionMagnifierKt.UnspecifiedSafeOffsetVectorConverter, new Offset(SelectionMagnifierKt.OffsetDisplacementThreshold), 8);
                    gapComposer4.updateRememberedValue(objRememberedValue8);
                }
                Animatable animatable = (Animatable) objRememberedValue8;
                boolean zChangedInstance3 = gapComposer4.changedInstance(animatable);
                Object objRememberedValue9 = gapComposer4.rememberedValue();
                if (zChangedInstance3 || objRememberedValue9 == neverEqualPolicy) {
                    objRememberedValue9 = new RealImageLoader.AnonymousClass2(state, animatable, null, (byte) 17);
                    gapComposer4.updateRememberedValue(objRememberedValue9);
                }
                Stack.LaunchedEffect(gapComposer4, unit, (Function2) objRememberedValue9);
                AnimationState animationState = animatable.internalState;
                boolean zChanged2 = gapComposer4.changed(animationState);
                Object objRememberedValue10 = gapComposer4.rememberedValue();
                if (zChanged2 || objRememberedValue10 == neverEqualPolicy) {
                    objRememberedValue10 = new MainActivity$$ExternalSyntheticLambda22(animationState, (byte) 1);
                    gapComposer4.updateRememberedValue(objRememberedValue10);
                }
                Modifier modifier = (Modifier) function3.invoke((Function0) objRememberedValue10);
                gapComposer4.end(false);
                return modifier;
            case 6:
                LayoutDirection layoutDirection2 = (LayoutDirection) obj5;
                ComposableLambdaImpl composableLambdaImpl = (ComposableLambdaImpl) obj4;
                Composer composer3 = (Composer) obj2;
                int iIntValue3 = ((Integer) obj3).intValue();
                GapComposer gapComposer5 = (GapComposer) composer3;
                if (gapComposer5.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                    Stack.CompositionLocalProvider(CompositionLocalsKt.LocalLayoutDirection.defaultProvidedValue$runtime(layoutDirection2), composableLambdaImpl, gapComposer5, 8);
                } else {
                    gapComposer5.skipToGroupEnd();
                }
                return unit;
            case 7:
                Spannable spannable = (Spannable) obj5;
                HistoryScreenKt$$ExternalSyntheticLambda20 historyScreenKt$$ExternalSyntheticLambda20 = (HistoryScreenKt$$ExternalSyntheticLambda20) obj4;
                SpanStyle spanStyle = (SpanStyle) obj;
                int iIntValue4 = ((Integer) obj2).intValue();
                int iIntValue5 = ((Integer) obj3).intValue();
                FontFamily fontFamily = spanStyle.fontFamily;
                FontWeight fontWeight = spanStyle.fontWeight;
                if (fontWeight == null) {
                    fontWeight = FontWeight.Normal;
                }
                FontStyle fontStyle = spanStyle.fontStyle;
                int i3 = fontStyle != null ? fontStyle.value : 0;
                FontSynthesis fontSynthesis = spanStyle.fontSynthesis;
                int i4 = fontSynthesis != null ? fontSynthesis.value : DatagramKt.MAX_DATAGRAM_SIZE;
                AndroidParagraphIntrinsics androidParagraphIntrinsics = (AndroidParagraphIntrinsics) historyScreenKt$$ExternalSyntheticLambda20.f$0;
                TypefaceResult typefaceResultM753resolveDPcqOEQ = ((FontFamilyResolverImpl) androidParagraphIntrinsics.fontFamilyResolver).m753resolveDPcqOEQ(fontFamily, fontWeight, i3, i4);
                if (typefaceResultM753resolveDPcqOEQ instanceof TypefaceResult.Immutable) {
                    Object obj6 = ((TypefaceResult.Immutable) typefaceResultM753resolveDPcqOEQ).value;
                    obj6.getClass();
                    typeface = (Typeface) obj6;
                } else {
                    EmojiProcessor emojiProcessor = new EmojiProcessor(typefaceResultM753resolveDPcqOEQ, androidParagraphIntrinsics.resolvedTypefaces);
                    androidParagraphIntrinsics.resolvedTypefaces = emojiProcessor;
                    Object obj7 = emojiProcessor.mGlyphChecker;
                    obj7.getClass();
                    typeface = (Typeface) obj7;
                }
                spannable.setSpan(new TypefaceSpan((byte) 0, typeface), iIntValue4, iIntValue5, 33);
                return unit;
            case 8:
                Shape shape = (Shape) obj5;
                MutableState mutableState2 = (MutableState) obj4;
                Composer composer4 = (Composer) obj2;
                int iIntValue6 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer6 = (GapComposer) composer4;
                if (gapComposer6.shouldExecute(iIntValue6 & 1, (iIntValue6 & 17) != 16)) {
                    Modifier modifierM1479glassOverlay6a0pyJM = GlassComponentsKt.m1479glassOverlay6a0pyJM(SizeKt.fillMaxWidth(companion, 1.0f), shape, gapComposer6);
                    ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start, gapComposer6, 0);
                    int iHashCode = Long.hashCode(gapComposer6.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer6.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer6, modifierM1479glassOverlay6a0pyJM);
                    ComposeUiNode.Companion.getClass();
                    gapComposer6.startReusableNode();
                    if (gapComposer6.inserting) {
                        gapComposer6.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer6.useNode();
                    }
                    Stack.m390setimpl(gapComposer6, columnMeasurePolicy, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer6, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer6, Integer.valueOf(iHashCode), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer6);
                    Stack.m390setimpl(gapComposer6, modifierMaterializeModifier, updater$$ExternalSyntheticLambda0);
                    ((Function3) mutableState2.getValue()).invoke(ColumnScopeInstance.INSTANCE, gapComposer6, 6);
                    gapComposer6.end(true);
                } else {
                    gapComposer6.skipToGroupEnd();
                }
                return unit;
            case 9:
                Function3 function4 = (Function3) obj5;
                String str = (String) obj4;
                RowScope rowScope = (RowScope) obj;
                Composer composer5 = (Composer) obj2;
                int iIntValue7 = ((Integer) obj3).intValue();
                rowScope.getClass();
                if ((iIntValue7 & 6) == 0) {
                    iIntValue7 |= ((GapComposer) composer5).changed(rowScope) ? 4 : 2;
                }
                GapComposer gapComposer7 = (GapComposer) composer5;
                if (gapComposer7.shouldExecute(iIntValue7 & 1, (iIntValue7 & 19) != 18)) {
                    function4.invoke(rowScope, gapComposer7, Integer.valueOf(iIntValue7 & 14));
                    if (str == null || str.length() == 0) {
                        gapComposer7.startReplaceGroup(2011902231);
                        gapComposer7.end(false);
                    } else {
                        gapComposer7.startReplaceGroup(2011643412);
                        StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                        TextKt.m352TextNvy7gAk(str, null, ((MaterialTheme$Values) gapComposer7.consume(staticProvidableCompositionLocal)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 2, false, 1, 0, ((MaterialTheme$Values) gapComposer7.consume(staticProvidableCompositionLocal)).typography.bodySmall, gapComposer7, 0, 24960, 110586);
                        gapComposer7.end(false);
                    }
                } else {
                    gapComposer7.skipToGroupEnd();
                }
                return unit;
            case 10:
                Function3 function5 = (Function3) obj5;
                Album album2 = (Album) obj4;
                RowScope rowScope2 = (RowScope) obj;
                Composer composer6 = (Composer) obj2;
                int iIntValue8 = ((Integer) obj3).intValue();
                rowScope2.getClass();
                if ((iIntValue8 & 6) == 0) {
                    iIntValue8 |= ((GapComposer) composer6).changed(rowScope2) ? 4 : 2;
                }
                GapComposer gapComposer8 = (GapComposer) composer6;
                if (gapComposer8.shouldExecute(iIntValue8 & 1, (iIntValue8 & 19) != 18)) {
                    function5.invoke(rowScope2, gapComposer8, Integer.valueOf(iIntValue8 & 14));
                    List list = album2.artists;
                    AlbumEntity albumEntity = album2.album;
                    String strM = IntIntPair$$ExternalSyntheticOutline0.m(ServerSentEventKt.SPACE, MathKt.stringResource(R.string.and, gapComposer8), ServerSentEventKt.SPACE);
                    Object objRememberedValue11 = gapComposer8.rememberedValue();
                    if (objRememberedValue11 == neverEqualPolicy) {
                        objRememberedValue11 = new AlbumMenuKt$$ExternalSyntheticLambda13((byte) 15);
                        gapComposer8.updateRememberedValue(objRememberedValue11);
                    }
                    String strJoinToArtistString = com.metrolist.music.utils.UtilsKt.joinToArtistString(list, strM, (Function1) objRememberedValue11);
                    int i5 = albumEntity.songCount;
                    String strPluralStringResource = MathKt.pluralStringResource(R.plurals.n_song, i5, new Object[]{Integer.valueOf(i5)}, gapComposer8);
                    Integer num = albumEntity.year;
                    String strJoinByBullet = com.metrolist.music.utils.UtilsKt.joinByBullet(strJoinToArtistString, strPluralStringResource, num != null ? String.valueOf(num.intValue()) : null);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = MaterialThemeKt._localMaterialTheme;
                    TextKt.m352TextNvy7gAk(strJoinByBullet, null, ((MaterialTheme$Values) gapComposer8.consume(staticProvidableCompositionLocal2)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 2, false, 1, 0, ((MaterialTheme$Values) gapComposer8.consume(staticProvidableCompositionLocal2)).typography.bodySmall, gapComposer8, 0, 24960, 110586);
                } else {
                    gapComposer8.skipToGroupEnd();
                }
                return unit;
            case 11:
                MediaMetadata mediaMetadata = (MediaMetadata) obj5;
                Map map = (Map) obj4;
                Composer composer7 = (Composer) obj2;
                int iIntValue9 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer9 = (GapComposer) composer7;
                if (gapComposer9.shouldExecute(1 & iIntValue9, (iIntValue9 & 17) != 16)) {
                    boolean z2 = mediaMetadata.explicit;
                    String str2 = mediaMetadata.suggestedBy;
                    if (z2) {
                        gapComposer9.startReplaceGroup(-1418101948);
                        Icon.INSTANCE.Explicit(6, gapComposer9);
                        z = false;
                    } else {
                        z = false;
                        gapComposer9.startReplaceGroup(-1011477816);
                    }
                    gapComposer9.end(z);
                    gapComposer9.startReplaceGroup(-1418099556);
                    AnnotatedString.Builder builder = new AnnotatedString.Builder();
                    List list2 = mediaMetadata.artists;
                    String strM2 = IntIntPair$$ExternalSyntheticOutline0.m(ServerSentEventKt.SPACE, MathKt.stringResource(R.string.and, gapComposer9), ServerSentEventKt.SPACE);
                    boolean zChangedInstance4 = gapComposer9.changedInstance(map);
                    Object objRememberedValue12 = gapComposer9.rememberedValue();
                    if (zChangedInstance4 || objRememberedValue12 == neverEqualPolicy) {
                        objRememberedValue12 = new QueueKt$$ExternalSyntheticLambda40(map, (byte) 7);
                        gapComposer9.updateRememberedValue(objRememberedValue12);
                    }
                    String strJoinByBullet2 = com.metrolist.music.utils.UtilsKt.joinByBullet(com.metrolist.music.utils.UtilsKt.joinToArtistString(list2, strM2, (Function1) objRememberedValue12), com.metrolist.music.utils.UtilsKt.makeTimeString(Long.valueOf(((long) mediaMetadata.duration) * 1000)));
                    builder.append(strJoinByBullet2);
                    if (str2 != null && strJoinByBullet2.length() > 0) {
                        builder.append(" • ");
                        int iPushStyle = builder.pushStyle(new SpanStyle(0L, 0L, FontWeight.Bold, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, 65531));
                        try {
                            builder.append(str2);
                            builder.pop(iPushStyle);
                        } catch (Throwable th) {
                            builder.pop(iPushStyle);
                            throw th;
                        }
                    }
                    AnnotatedString annotatedString = builder.toAnnotatedString();
                    gapComposer9.end(false);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal3 = MaterialThemeKt._localMaterialTheme;
                    TextKt.m353TextZ58ophY(annotatedString, null, 0L, 0L, null, 0L, null, 0L, 2, false, 1, 0, null, null, TextStyle.m750copyp1EtxEg$default(((MaterialTheme$Values) gapComposer9.consume(staticProvidableCompositionLocal3)).typography.bodySmall, ((MaterialTheme$Values) gapComposer9.consume(staticProvidableCompositionLocal3)).colorScheme.onSurfaceVariant, 0L, null, null, null, null, 0L, 0L, null, null, 16777214), gapComposer9, 0, 24960, 241662);
                } else {
                    gapComposer9.skipToGroupEnd();
                }
                return unit;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                MusicDatabase musicDatabase2 = (MusicDatabase) obj5;
                Artist artist = (Artist) obj4;
                Composer composer8 = (Composer) obj2;
                int iIntValue10 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer10 = (GapComposer) composer8;
                if (gapComposer10.shouldExecute(1 & iIntValue10, (iIntValue10 & 17) != 16)) {
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Expect_jvmKt.rememberComposableLambda(-1823349415, new ArtistMenuKt$$ExternalSyntheticLambda5(artist, (byte) 0), gapComposer10);
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda2 = Expect_jvmKt.rememberComposableLambda(-622208072, new ArtistMenuKt$$ExternalSyntheticLambda5(artist, (byte) 2), gapComposer10);
                    boolean zChangedInstance5 = gapComposer10.changedInstance(musicDatabase2) | gapComposer10.changed(artist);
                    Object objRememberedValue13 = gapComposer10.rememberedValue();
                    if (zChangedInstance5 || objRememberedValue13 == neverEqualPolicy) {
                        objRememberedValue13 = new ComponentRegistry$Builder$$ExternalSyntheticLambda2((Object) musicDatabase2, (Object) artist, (byte) 15);
                        gapComposer10.updateRememberedValue(objRememberedValue13);
                    }
                    MenuKt.Material3MenuGroup(CollectionsKt__IterablesKt.listOf(new Material3MenuItemData(composableLambdaImplRememberComposableLambda, composableLambdaImplRememberComposableLambda2, null, (Function0) objRememberedValue13, null, null, 52)), gapComposer10, 0);
                } else {
                    gapComposer10.skipToGroupEnd();
                }
                return unit;
            case 13:
                Function0 function6 = (Function0) obj5;
                ListenTogetherManager listenTogetherManager = (ListenTogetherManager) obj4;
                Composer composer9 = (Composer) obj2;
                int iIntValue11 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer11 = (GapComposer) composer9;
                if (gapComposer11.shouldExecute(iIntValue11 & 1, (iIntValue11 & 17) != 16)) {
                    OffsetKt.Spacer(gapComposer11, SizeKt.m145height3ABfNKs(companion, 20.0f));
                    Modifier modifierM137paddingVpY3zN4$default = OffsetKt.m137paddingVpY3zN4$default(SizeKt.fillMaxWidth(companion, 1.0f), 16.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2);
                    RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(new Arrangement$SpacedAligned(12.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5)), Alignment.Companion.Top, gapComposer11, 6);
                    int iHashCode2 = Long.hashCode(gapComposer11.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer11.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer11, modifierM137paddingVpY3zN4$default);
                    ComposeUiNode.Companion.getClass();
                    gapComposer11.startReusableNode();
                    if (gapComposer11.inserting) {
                        gapComposer11.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer11.useNode();
                    }
                    Stack.m390setimpl(gapComposer11, rowMeasurePolicy, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer11, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer11, Integer.valueOf(iHashCode2), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer11);
                    Stack.m390setimpl(gapComposer11, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda0);
                    if (1.0f <= 0.0d) {
                        InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
                    }
                    CardKt.TextButton(function6, new LayoutWeightElement(1.0f > Float.MAX_VALUE ? Float.MAX_VALUE : 1.0f, true), false, null, null, null, AlbumMenuKt.f259lambda$811235825, gapComposer11, 805306368, 508);
                    boolean zChangedInstance6 = gapComposer11.changedInstance(listenTogetherManager) | gapComposer11.changed(function6);
                    Object objRememberedValue14 = gapComposer11.rememberedValue();
                    if (zChangedInstance6 || objRememberedValue14 == neverEqualPolicy) {
                        objRememberedValue14 = new PlayerMenuKt$$ExternalSyntheticLambda90(listenTogetherManager, function6, (byte) 1);
                        gapComposer11.updateRememberedValue(objRememberedValue14);
                    }
                    Function0 function7 = (Function0) objRememberedValue14;
                    if (1.0f <= 0.0d) {
                        InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
                    }
                    LayoutWeightElement layoutWeightElement = new LayoutWeightElement(1.0f > Float.MAX_VALUE ? Float.MAX_VALUE : 1.0f, true);
                    PaddingValuesImpl paddingValuesImpl = ButtonDefaults.ContentPadding;
                    CardKt.Button(function7, layoutWeightElement, false, null, ButtonDefaults.m247buttonColorsro_MJ88(((MaterialTheme$Values) gapComposer11.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.error, 0L, 0L, gapComposer11, 14), null, null, null, null, AlbumMenuKt.f286lambda$990582724, gapComposer11, 805306368, 492);
                    gapComposer11.end(true);
                    OffsetKt.Spacer(gapComposer11, SizeKt.m145height3ABfNKs(companion, 16.0f));
                } else {
                    gapComposer11.skipToGroupEnd();
                }
                return unit;
            case 14:
                MutableState mutableState3 = (MutableState) obj5;
                PlayerConnection playerConnection = (PlayerConnection) obj4;
                Composer composer10 = (Composer) obj2;
                int iIntValue12 = ((Integer) obj3).intValue();
                ((AnimatedVisibilityScope) obj).getClass();
                GapComposer gapComposer12 = (GapComposer) composer10;
                if (gapComposer12.shouldExecute(iIntValue12 & 1, (iIntValue12 & 17) != 16)) {
                    PlaybackException playbackException = (PlaybackException) mutableState3.getValue();
                    if (playbackException == null) {
                        gapComposer12.startReplaceGroup(-2146643162);
                        gapComposer12.end(false);
                    } else {
                        gapComposer12.startReplaceGroup(-2146643161);
                        ExoPlayerImpl playerSafe = playerConnection.getPlayerSafe();
                        boolean zChangedInstance7 = gapComposer12.changedInstance(playerSafe);
                        Object objRememberedValue15 = gapComposer12.rememberedValue();
                        if (zChangedInstance7 || objRememberedValue15 == neverEqualPolicy) {
                            objRememberedValue15 = new RoomDatabase$closeBarrier$1(0, playerSafe, ExoPlayerImpl.class, "prepare", "prepare()V", 0, (byte) 27);
                            gapComposer12.updateRememberedValue(objRememberedValue15);
                        }
                        QueueKt.PlaybackError(playbackException, (Function0) ((KFunction) objRememberedValue15), gapComposer12, 0);
                        gapComposer12.end(false);
                    }
                } else {
                    gapComposer12.skipToGroupEnd();
                }
                return unit;
            case 15:
                AccountViewModel accountViewModel = (AccountViewModel) obj5;
                State state2 = (State) obj4;
                Composer composer11 = (Composer) obj2;
                int iIntValue13 = ((Integer) obj3).intValue();
                ((LazyGridItemScopeImpl) obj).getClass();
                GapComposer gapComposer13 = (GapComposer) composer11;
                if (gapComposer13.shouldExecute(iIntValue13 & 1, (iIntValue13 & 17) != 16)) {
                    List listListOf = CollectionsKt__IterablesKt.listOf((Object[]) new Pair[]{new Pair(AccountContentType.PLAYLISTS, MathKt.stringResource(R.string.filter_playlists, gapComposer13)), new Pair(AccountContentType.ALBUMS, MathKt.stringResource(R.string.filter_albums, gapComposer13)), new Pair(AccountContentType.ARTISTS, MathKt.stringResource(R.string.filter_artists, gapComposer13)), new Pair(AccountContentType.PODCASTS, MathKt.stringResource(R.string.filter_podcasts, gapComposer13))});
                    AccountContentType accountContentType = (AccountContentType) state2.getValue();
                    boolean zChangedInstance8 = gapComposer13.changedInstance(accountViewModel);
                    Object objRememberedValue16 = gapComposer13.rememberedValue();
                    if (zChangedInstance8 || objRememberedValue16 == neverEqualPolicy) {
                        objRememberedValue16 = new MimesKt$$ExternalSyntheticLambda0((byte) 6, accountViewModel);
                        gapComposer13.updateRememberedValue(objRememberedValue16);
                    }
                    DialogKt.m1461ChipsRowyrwZFoE(listListOf, accountContentType, (Function1) objRememberedValue16, null, 0L, gapComposer13, 0, 24);
                } else {
                    gapComposer13.skipToGroupEnd();
                }
                return unit;
            case 16:
                AlbumWithSongs albumWithSongs = (AlbumWithSongs) obj5;
                MenuState menuState = (MenuState) obj4;
                Composer composer12 = (Composer) obj2;
                int iIntValue14 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer14 = (GapComposer) composer12;
                if (gapComposer14.shouldExecute(iIntValue14 & 1, (iIntValue14 & 17) != 16)) {
                    Album album3 = new Album(albumWithSongs.album, albumWithSongs.artists, 0, 0L);
                    boolean zChanged3 = gapComposer14.changed(menuState);
                    Object objRememberedValue17 = gapComposer14.rememberedValue();
                    if (zChanged3 || objRememberedValue17 == neverEqualPolicy) {
                        objRememberedValue17 = new HomeScreenKt$HomeScreen$8$1(0, menuState, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 3);
                        gapComposer14.updateRememberedValue(objRememberedValue17);
                    }
                    AlbumMenuKt.AlbumMenu(album3, (Function0) ((KFunction) objRememberedValue17), gapComposer14, 0);
                } else {
                    gapComposer14.skipToGroupEnd();
                }
                return unit;
            case 17:
                SongItem songItem = (SongItem) obj5;
                MenuState menuState2 = (MenuState) obj4;
                Composer composer13 = (Composer) obj2;
                int iIntValue15 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer15 = (GapComposer) composer13;
                if (gapComposer15.shouldExecute(iIntValue15 & 1, (iIntValue15 & 17) != 16)) {
                    boolean zChanged4 = gapComposer15.changed(menuState2);
                    Object objRememberedValue18 = gapComposer15.rememberedValue();
                    if (zChanged4 || objRememberedValue18 == neverEqualPolicy) {
                        objRememberedValue18 = new HomeScreenKt$$ExternalSyntheticLambda120(menuState2, (byte) 0);
                        gapComposer15.updateRememberedValue(objRememberedValue18);
                    }
                    YouTubeSongMenuKt.YouTubeSongMenu(songItem, (Function0) objRememberedValue18, null, gapComposer15, 0, 4);
                } else {
                    gapComposer15.skipToGroupEnd();
                }
                return unit;
            case 18:
                List list3 = (List) obj5;
                PlayerConnection playerConnection2 = (PlayerConnection) obj4;
                Composer composer14 = (Composer) obj2;
                int iIntValue16 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer16 = (GapComposer) composer14;
                if (gapComposer16.shouldExecute(iIntValue16 & 1, (iIntValue16 & 17) != 16)) {
                    String strStringResource = MathKt.stringResource(R.string.your_daily_discover, gapComposer16);
                    Modifier modifierM1473hairlineBottomiJQMabo = DialogKt.m1473hairlineBottomiJQMabo(companion, gapComposer16, 6);
                    boolean zChangedInstance9 = gapComposer16.changedInstance(list3) | gapComposer16.changedInstance(playerConnection2) | gapComposer16.changed(strStringResource);
                    Object objRememberedValue19 = gapComposer16.rememberedValue();
                    if (zChangedInstance9 || objRememberedValue19 == neverEqualPolicy) {
                        objRememberedValue19 = new HomeScreenKt$$ExternalSyntheticLambda72(playerConnection2, strStringResource, list3);
                        gapComposer16.updateRememberedValue(objRememberedValue19);
                    }
                    MenuKt.NavigationTitle(strStringResource, modifierM1473hairlineBottomiJQMabo, null, null, null, (Function0) objRememberedValue19, gapComposer16, 0, 28);
                } else {
                    gapComposer16.skipToGroupEnd();
                }
                return unit;
            case 19:
                return invoke$com$metrolist$music$ui$screens$HomeScreenKt$$ExternalSyntheticLambda38(obj, obj2, obj3);
            case 20:
                return invoke$com$metrolist$music$ui$screens$HomeScreenKt$$ExternalSyntheticLambda51(obj, obj2, obj3);
            case 21:
                return invoke$com$metrolist$music$ui$screens$HomeScreenKt$$ExternalSyntheticLambda5(obj, obj2, obj3);
            case 22:
                return invoke$com$metrolist$music$ui$screens$artist$ArtistScreenKt$$ExternalSyntheticLambda1(obj, obj2, obj3);
            case 23:
                return invoke$com$metrolist$music$ui$screens$library$LibraryPodcastsScreenKt$$ExternalSyntheticLambda10(obj, obj2, obj3);
            case 24:
                return invoke$com$metrolist$music$ui$screens$library$LibrarySongsScreenKt$$ExternalSyntheticLambda9(obj, obj2, obj3);
            case 25:
                return invoke$com$metrolist$music$ui$screens$playlist$OnlinePlaylistScreenKt$$ExternalSyntheticLambda13(obj, obj2, obj3);
            case 26:
                return invoke$com$metrolist$music$ui$screens$playlist$TopPlaylistScreenKt$$ExternalSyntheticLambda24(obj, obj2, obj3);
            case 27:
                return invoke$com$metrolist$music$ui$screens$podcast$OnlinePodcastScreenKt$$ExternalSyntheticLambda12(obj, obj2, obj3);
            case 28:
                return invoke$com$metrolist$music$ui$screens$recognition$RecognitionHistoryScreenKt$$ExternalSyntheticLambda12(obj, obj2, obj3);
            default:
                LocalSearchViewModel localSearchViewModel = (LocalSearchViewModel) obj5;
                LocalFilter localFilter = (LocalFilter) obj4;
                Composer composer15 = (Composer) obj2;
                int iIntValue17 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer17 = (GapComposer) composer15;
                if (gapComposer17.shouldExecute(iIntValue17 & 1, (iIntValue17 & 17) != 16)) {
                    Arrangement$SpacedAligned arrangement$SpacedAligned = new Arrangement$SpacedAligned(16.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5));
                    BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
                    Modifier modifierM145height3ABfNKs = SizeKt.m145height3ABfNKs(SizeKt.fillMaxWidth(companion, 1.0f), 52.0f);
                    boolean zChangedInstance10 = gapComposer17.changedInstance(localSearchViewModel) | gapComposer17.changed(localFilter.ordinal());
                    Object objRememberedValue20 = gapComposer17.rememberedValue();
                    if (zChangedInstance10 || objRememberedValue20 == neverEqualPolicy) {
                        objRememberedValue20 = new QueueKt$$ExternalSyntheticLambda16(localSearchViewModel, localFilter, (byte) 20);
                        gapComposer17.updateRememberedValue(objRememberedValue20);
                    }
                    Modifier modifierM1473hairlineBottomiJQMabo2 = DialogKt.m1473hairlineBottomiJQMabo(OffsetKt.m139paddingqDBjuR0$default(ImageKt.m46clickableoSLSa3U$default(modifierM145height3ABfNKs, false, null, (Function0) objRememberedValue20, 15), 20.0f, CropImageView.DEFAULT_ASPECT_RATIO, 12.0f, CropImageView.DEFAULT_ASPECT_RATIO, 10), gapComposer17, 0);
                    RowMeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement$SpacedAligned, vertical, gapComposer17, 54);
                    int iHashCode3 = Long.hashCode(gapComposer17.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer17.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer17, modifierM1473hairlineBottomiJQMabo2);
                    ComposeUiNode.Companion.getClass();
                    gapComposer17.startReusableNode();
                    if (gapComposer17.inserting) {
                        gapComposer17.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer17.useNode();
                    }
                    Stack.m390setimpl(gapComposer17, rowMeasurePolicy2, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer17, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer17, Integer.valueOf(iHashCode3), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer17);
                    Stack.m390setimpl(gapComposer17, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda0);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal4 = MaterialThemeKt._localMaterialTheme;
                    long j3 = ((MaterialTheme$Values) gapComposer17.consume(staticProvidableCompositionLocal4)).colorScheme.primary;
                    int iOrdinal = localFilter.ordinal();
                    if (iOrdinal != 0) {
                        if (iOrdinal == 1) {
                            i = R.string.filter_songs;
                        } else if (iOrdinal == 2) {
                            i = R.string.filter_albums;
                        } else if (iOrdinal == 3) {
                            i = R.string.filter_artists;
                        } else if (iOrdinal == 4) {
                            i = R.string.filter_playlists;
                        } else {
                            PathKt$$ExternalSyntheticBUOutline0.m$1();
                        }
                        DialogKt.m1469MicroLabelFNF3uiM(MathKt.stringResource(i, gapComposer17), new LayoutWeightElement(1.0f, true), j3, gapComposer17, 0, 0);
                        IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.navigate_next, 0, gapComposer17), (String) null, (Modifier) null, ((MaterialTheme$Values) gapComposer17.consume(staticProvidableCompositionLocal4)).colorScheme.onSurfaceVariant, gapComposer17, 56, 4);
                        gapComposer17.end(true);
                    } else {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("");
                    }
                    return null;
                }
                gapComposer17.skipToGroupEnd();
                return unit;
        }
    }
}
