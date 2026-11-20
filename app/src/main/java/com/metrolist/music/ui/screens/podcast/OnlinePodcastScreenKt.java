package com.metrolist.music.ui.screens.podcast;

import android.content.Context;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.MarqueeSpacing$Companion$$ExternalSyntheticLambda0;
import androidx.compose.foundation.layout.Arrangement$SpacedAligned;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.InsetsPaddingValues;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.UnionInsets;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsHolder;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda2;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.style.TextAlign;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.navigation.NavDeepLinkRequest;
import androidx.navigation.NavHostController;
import coil3.compose.AsyncImageKt;
import coil3.request.ImageRequest;
import coil3.util.FileSystemsKt;
import coil3.util.UtilsKt;
import com.google.common.math.IntMath;
import com.metrolist.innertube.models.Artist;
import com.metrolist.innertube.models.EpisodeItem;
import com.metrolist.innertube.models.PodcastItem;
import com.metrolist.music.MainActivityKt;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.ui.component.BottomSheetMenuKt;
import com.metrolist.music.ui.component.GlassComponentsKt;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.player.MiniPlayerKt$$ExternalSyntheticLambda17;
import com.metrolist.music.ui.player.MiniPlayerKt$$ExternalSyntheticLambda28;
import com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda92;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda21;
import com.metrolist.music.ui.screens.AlbumScreenKt$$ExternalSyntheticLambda8;
import com.metrolist.music.ui.screens.StatsScreenKt$StatsScreen$1$1;
import com.metrolist.music.ui.screens.equalizer.ComposableSingletons$EqScreenKt$$ExternalSyntheticLambda5;
import com.metrolist.music.ui.screens.library.LibrarySongsScreenKt$$ExternalSyntheticLambda2;
import com.metrolist.music.ui.screens.playlist.TopPlaylistScreenKt$$ExternalSyntheticLambda8;
import com.metrolist.music.ui.screens.search.SearchScreenKt$$ExternalSyntheticLambda0;
import com.metrolist.music.ui.screens.settings.AiSettingsKt$$ExternalSyntheticLambda10;
import com.metrolist.music.ui.theme.UiStyleKt;
import com.metrolist.music.ui.utils.YouTubeUtilsKt;
import com.metrolist.music.viewmodels.OnlinePodcastViewModel;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class OnlinePodcastScreenKt {

    /* JADX INFO: renamed from: lambda$-1886582408, reason: not valid java name */
    public static final ComposableLambdaImpl f408lambda$1886582408 = new ComposableLambdaImpl(false, -1886582408, new ComposableSingletons$EqScreenKt$$ExternalSyntheticLambda5(28));

    /* JADX INFO: renamed from: lambda$-807733303, reason: not valid java name */
    public static final ComposableLambdaImpl f411lambda$807733303 = new ComposableLambdaImpl(false, -807733303, new ComposableSingletons$EqScreenKt$$ExternalSyntheticLambda5(29));
    public static final ComposableLambdaImpl lambda$704364238 = new ComposableLambdaImpl(false, 704364238, new TopPlaylistScreenKt$$ExternalSyntheticLambda8((byte) 10));
    public static final ComposableLambdaImpl lambda$1117783938 = new ComposableLambdaImpl(false, 1117783938, new TopPlaylistScreenKt$$ExternalSyntheticLambda8((byte) 11));

    /* JADX INFO: renamed from: lambda$-246135284, reason: not valid java name */
    public static final ComposableLambdaImpl f410lambda$246135284 = new ComposableLambdaImpl(false, -246135284, new TopPlaylistScreenKt$$ExternalSyntheticLambda8((byte) 12));
    public static final ComposableLambdaImpl lambda$1686324862 = new ComposableLambdaImpl(false, 1686324862, new TopPlaylistScreenKt$$ExternalSyntheticLambda8((byte) 13));

    /* JADX INFO: renamed from: lambda$-2060943292, reason: not valid java name */
    public static final ComposableLambdaImpl f409lambda$2060943292 = new ComposableLambdaImpl(false, -2060943292, new AiSettingsKt$$ExternalSyntheticLambda10(1));

    /* JADX WARN: Multi-variable type inference failed */
    public static final void OnlinePodcastScreen(final NavHostController navHostController, final NavDeepLinkRequest navDeepLinkRequest, OnlinePodcastViewModel onlinePodcastViewModel, Composer composer, final int i) {
        NavHostController navHostController2;
        final OnlinePodcastViewModel onlinePodcastViewModel2;
        GapComposer gapComposer;
        final OnlinePodcastViewModel onlinePodcastViewModel3;
        int i2;
        ArrayList arrayList;
        Artist artist;
        String str;
        MutableState mutableState;
        MutableState mutableState2;
        Object obj;
        boolean z;
        OnlinePodcastViewModel onlinePodcastViewModel4;
        MutableState mutableState3;
        navHostController.getClass();
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(752702574);
        int i3 = i | (gapComposer2.changedInstance(navHostController) ? 4 : 2) | (gapComposer2.changed(navDeepLinkRequest) ? 32 : 16) | 128;
        if (gapComposer2.shouldExecute(i3 & 1, (i3 & 147) != 146)) {
            gapComposer2.startDefaults();
            if ((i & 1) == 0 || gapComposer2.getDefaultsInvalid()) {
                ViewModelStoreOwner viewModelStoreOwner = (ViewModelStoreOwner) gapComposer2.consume(LocalViewModelStoreOwner.LocalViewModelStoreOwner);
                if (viewModelStoreOwner == null) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                    return;
                } else {
                    onlinePodcastViewModel3 = (OnlinePodcastViewModel) UtilsKt.viewModel(Reflection.getOrCreateKotlinClass(OnlinePodcastViewModel.class), viewModelStoreOwner, MathKt.rememberHiltViewModelFactory(ViewModelKt.getViewModelProviderFactory(viewModelStoreOwner), gapComposer2), ViewModelKt.getViewModelCreationExtras(viewModelStoreOwner), gapComposer2);
                    i2 = i3 & (-897);
                }
            } else {
                gapComposer2.skipToGroupEnd();
                i2 = i3 & (-897);
                onlinePodcastViewModel3 = onlinePodcastViewModel;
            }
            int i4 = i2;
            gapComposer2.endDefaults();
            MenuState menuState = (MenuState) gapComposer2.consume(BottomSheetMenuKt.LocalMenuState);
            HapticFeedback hapticFeedback = (HapticFeedback) gapComposer2.consume(CompositionLocalsKt.LocalHapticFeedback);
            PlayerConnection playerConnection = (PlayerConnection) gapComposer2.consume(MainActivityKt.LocalPlayerConnection);
            if (playerConnection == null) {
                RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    final byte b = 0;
                    recomposeScopeImplEndRestartGroup.block = new Function2(navHostController, navDeepLinkRequest, onlinePodcastViewModel3, i, b) { // from class: com.metrolist.music.ui.screens.podcast.OnlinePodcastScreenKt$$ExternalSyntheticLambda0
                        public final /* synthetic */ byte $r8$classId;
                        public final /* synthetic */ NavHostController f$0;
                        public final /* synthetic */ NavDeepLinkRequest f$1;
                        public final /* synthetic */ OnlinePodcastViewModel f$2;

                        {
                            this.$r8$classId = b;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            byte b2 = this.$r8$classId;
                            Unit unit = Unit.INSTANCE;
                            OnlinePodcastViewModel onlinePodcastViewModel5 = this.f$2;
                            NavDeepLinkRequest navDeepLinkRequest2 = this.f$1;
                            NavHostController navHostController3 = this.f$0;
                            Composer composer2 = (Composer) obj2;
                            ((Integer) obj3).getClass();
                            switch (b2) {
                                case 0:
                                    OnlinePodcastScreenKt.OnlinePodcastScreen(navHostController3, navDeepLinkRequest2, onlinePodcastViewModel5, composer2, Stack.updateChangedFlags(1));
                                    break;
                                default:
                                    OnlinePodcastScreenKt.OnlinePodcastScreen(navHostController3, navDeepLinkRequest2, onlinePodcastViewModel5, composer2, Stack.updateChangedFlags(1));
                                    break;
                            }
                            return unit;
                        }
                    };
                    return;
                }
                return;
            }
            MutableState mutableStateCollectAsStateWithLifecycle = FileSystemsKt.collectAsStateWithLifecycle(playerConnection.isEffectivelyPlaying, gapComposer2);
            MutableState mutableStateCollectAsStateWithLifecycle2 = FileSystemsKt.collectAsStateWithLifecycle(playerConnection.mediaMetadata, gapComposer2);
            MutableState mutableStateCollectAsStateWithLifecycle3 = FileSystemsKt.collectAsStateWithLifecycle(onlinePodcastViewModel3.podcast, gapComposer2);
            MutableState mutableStateCollectAsStateWithLifecycle4 = FileSystemsKt.collectAsStateWithLifecycle(onlinePodcastViewModel3.episodes, gapComposer2);
            MutableState mutableStateCollectAsStateWithLifecycle5 = FileSystemsKt.collectAsStateWithLifecycle(onlinePodcastViewModel3.isLoading, gapComposer2);
            MutableState mutableStateCollectAsStateWithLifecycle6 = FileSystemsKt.collectAsStateWithLifecycle(onlinePodcastViewModel3.error, gapComposer2);
            MutableState mutableStateCollectAsStateWithLifecycle7 = FileSystemsKt.collectAsStateWithLifecycle(onlinePodcastViewModel3.libraryPodcast, gapComposer2);
            LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(gapComposer2);
            Object[] objArr = new Object[0];
            Object objRememberedValue = gapComposer2.rememberedValue();
            Object obj2 = Composer.Companion.Empty;
            if (objRememberedValue == obj2) {
                objRememberedValue = new SearchScreenKt$$ExternalSyntheticLambda0((byte) 19);
                gapComposer2.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState4 = (MutableState) SaverKt.rememberSaveable(objArr, (Function0) objRememberedValue, gapComposer2, 48);
            Object[] objArr2 = new Object[0];
            Object objRememberedValue2 = gapComposer2.rememberedValue();
            if (objRememberedValue2 == obj2) {
                objRememberedValue2 = new SearchScreenKt$$ExternalSyntheticLambda0((byte) 20);
                gapComposer2.updateRememberedValue(objRememberedValue2);
            }
            MutableState mutableStateRememberSaveable = SaverKt.rememberSaveable(objArr2, (Saver) TextFieldValue.Saver, (Function0) objRememberedValue2, (Composer) gapComposer2, 384);
            boolean zChanged = gapComposer2.changed((List) mutableStateCollectAsStateWithLifecycle4.getValue()) | gapComposer2.changed((TextFieldValue) mutableStateRememberSaveable.getValue());
            Object objRememberedValue3 = gapComposer2.rememberedValue();
            if (zChanged || objRememberedValue3 == obj2) {
                if (((TextFieldValue) mutableStateRememberSaveable.getValue()).annotatedString.text.length() == 0) {
                    arrayList = (List) mutableStateCollectAsStateWithLifecycle4.getValue();
                } else {
                    List list = (List) mutableStateCollectAsStateWithLifecycle4.getValue();
                    arrayList = new ArrayList();
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        Object next = it.next();
                        Iterator it2 = it;
                        EpisodeItem episodeItem = (EpisodeItem) next;
                        MutableState mutableState5 = mutableStateCollectAsStateWithLifecycle;
                        MutableState mutableState6 = mutableStateCollectAsStateWithLifecycle2;
                        if (StringsKt.contains(episodeItem.title, ((TextFieldValue) mutableStateRememberSaveable.getValue()).annotatedString.text, true) || ((artist = episodeItem.author) != null && (str = artist.name) != null && StringsKt.contains(str, ((TextFieldValue) mutableStateRememberSaveable.getValue()).annotatedString.text, true))) {
                            arrayList.add(next);
                        }
                        it = it2;
                        mutableStateCollectAsStateWithLifecycle = mutableState5;
                        mutableStateCollectAsStateWithLifecycle2 = mutableState6;
                    }
                }
                mutableState = mutableStateCollectAsStateWithLifecycle2;
                mutableState2 = mutableStateCollectAsStateWithLifecycle;
                gapComposer2.updateRememberedValue(arrayList);
                obj = arrayList;
            } else {
                mutableState = mutableStateCollectAsStateWithLifecycle2;
                mutableState2 = mutableStateCollectAsStateWithLifecycle;
                obj = objRememberedValue3;
            }
            List list2 = (List) obj;
            Object objRememberedValue4 = gapComposer2.rememberedValue();
            if (objRememberedValue4 == obj2) {
                objRememberedValue4 = new FocusRequester();
                gapComposer2.updateRememberedValue(objRememberedValue4);
            }
            FocusRequester focusRequester = (FocusRequester) objRememberedValue4;
            Boolean boolValueOf = Boolean.valueOf(((Boolean) mutableState4.getValue()).booleanValue());
            boolean zChanged2 = gapComposer2.changed(mutableState4);
            Object objRememberedValue5 = gapComposer2.rememberedValue();
            if (zChanged2 || objRememberedValue5 == obj2) {
                objRememberedValue5 = new StatsScreenKt$StatsScreen$1$1(focusRequester, mutableState4, null, (byte) 7);
                gapComposer2.updateRememberedValue(objRememberedValue5);
            }
            Stack.LaunchedEffect(gapComposer2, boolValueOf, (Function2) objRememberedValue5);
            if (((Boolean) mutableState4.getValue()).booleanValue()) {
                gapComposer2.startReplaceGroup(-260295704);
                boolean zChanged3 = gapComposer2.changed(mutableState4) | gapComposer2.changed(mutableStateRememberSaveable);
                Object objRememberedValue6 = gapComposer2.rememberedValue();
                if (zChanged3 || objRememberedValue6 == obj2) {
                    objRememberedValue6 = new TooltipKt$$ExternalSyntheticLambda2(mutableState4, mutableStateRememberSaveable, (byte) 14);
                    gapComposer2.updateRememberedValue(objRememberedValue6);
                }
                z = false;
                UtilsKt.BackHandler(false, (Function0) objRememberedValue6, gapComposer2, 0, 1);
                gapComposer2.end(false);
            } else {
                z = false;
                gapComposer2.startReplaceGroup(-260191916);
                gapComposer2.end(false);
            }
            FillElement fillElement = SizeKt.FillWholeMaxSize;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, z);
            int iHashCode = Long.hashCode(gapComposer2.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer2, fillElement);
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
            WindowInsets windowInsets = (WindowInsets) gapComposer2.consume(MainActivityKt.LocalPlayerAwareWindowInsets);
            WeakHashMap weakHashMap = WindowInsetsHolder.viewMap;
            InsetsPaddingValues insetsPaddingValuesAsPaddingValues = OffsetKt.asPaddingValues(new UnionInsets(windowInsets, OffsetKt.current(gapComposer2).ime), gapComposer2);
            MutableState mutableState7 = mutableState;
            MutableState mutableState8 = mutableState2;
            boolean zChanged4 = gapComposer2.changed(mutableStateCollectAsStateWithLifecycle3) | gapComposer2.changed(mutableStateCollectAsStateWithLifecycle5) | gapComposer2.changed(mutableStateCollectAsStateWithLifecycle6) | gapComposer2.changedInstance(onlinePodcastViewModel3) | gapComposer2.changed(mutableState4) | gapComposer2.changed(mutableStateCollectAsStateWithLifecycle4) | gapComposer2.changed(mutableStateCollectAsStateWithLifecycle7) | gapComposer2.changedInstance(navHostController) | gapComposer2.changedInstance(list2) | gapComposer2.changed(mutableState7) | gapComposer2.changed(mutableState8) | gapComposer2.changedInstance(hapticFeedback) | gapComposer2.changed(menuState) | gapComposer2.changedInstance(playerConnection);
            Object objRememberedValue7 = gapComposer2.rememberedValue();
            if (zChanged4 || objRememberedValue7 == obj2) {
                OnlinePodcastViewModel onlinePodcastViewModel5 = onlinePodcastViewModel3;
                objRememberedValue7 = new LibrarySongsScreenKt$$ExternalSyntheticLambda2(mutableStateCollectAsStateWithLifecycle3, mutableStateCollectAsStateWithLifecycle5, mutableStateCollectAsStateWithLifecycle6, onlinePodcastViewModel5, list2, mutableState4, navHostController, mutableStateCollectAsStateWithLifecycle4, mutableStateCollectAsStateWithLifecycle7, hapticFeedback, menuState, mutableState7, playerConnection, mutableState8);
                onlinePodcastViewModel4 = onlinePodcastViewModel5;
                navHostController2 = navHostController;
                mutableState3 = mutableState4;
                gapComposer2.updateRememberedValue(objRememberedValue7);
            } else {
                onlinePodcastViewModel4 = onlinePodcastViewModel3;
                navHostController2 = navHostController;
                mutableState3 = mutableState4;
            }
            IntMath.LazyColumn(null, lazyListStateRememberLazyListState, insetsPaddingValuesAsPaddingValues, null, null, null, false, null, (Function1) objRememberedValue7, gapComposer2, 0, 505);
            GapComposer gapComposer3 = gapComposer2;
            MutableState mutableState9 = mutableState3;
            MenuKt.m1493TopAppBarGHTll3U(Expect_jvmKt.rememberComposableLambda(1076432236, new PlayerKt$$ExternalSyntheticLambda92(focusRequester, mutableStateRememberSaveable, lazyListStateRememberLazyListState, mutableState3, mutableStateCollectAsStateWithLifecycle3), gapComposer3), null, Expect_jvmKt.rememberComposableLambda(-273977874, new AlbumScreenKt$$ExternalSyntheticLambda8(mutableState9, mutableStateRememberSaveable, (Object) navHostController2, (byte) 10), gapComposer3), Expect_jvmKt.rememberComposableLambda(-126663721, new QueueKt$$ExternalSyntheticLambda21(mutableState9, (byte) 24), gapComposer3), CropImageView.DEFAULT_ASPECT_RATIO, null, null, navDeepLinkRequest, gapComposer3, ((i4 << 18) & 29360128) | 3462, 114);
            gapComposer3.end(true);
            onlinePodcastViewModel2 = onlinePodcastViewModel4;
            gapComposer = gapComposer3;
        } else {
            navHostController2 = navHostController;
            GapComposer gapComposer4 = gapComposer2;
            gapComposer4.skipToGroupEnd();
            onlinePodcastViewModel2 = onlinePodcastViewModel;
            gapComposer = gapComposer4;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup2 = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup2 != null) {
            final byte b2 = 1;
            final NavHostController navHostController3 = navHostController2;
            recomposeScopeImplEndRestartGroup2.block = new Function2(navHostController3, navDeepLinkRequest, onlinePodcastViewModel2, i, b2) { // from class: com.metrolist.music.ui.screens.podcast.OnlinePodcastScreenKt$$ExternalSyntheticLambda0
                public final /* synthetic */ byte $r8$classId;
                public final /* synthetic */ NavHostController f$0;
                public final /* synthetic */ NavDeepLinkRequest f$1;
                public final /* synthetic */ OnlinePodcastViewModel f$2;

                {
                    this.$r8$classId = b2;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj3, Object obj4) {
                    byte b3 = this.$r8$classId;
                    Unit unit = Unit.INSTANCE;
                    OnlinePodcastViewModel onlinePodcastViewModel6 = this.f$2;
                    NavDeepLinkRequest navDeepLinkRequest2 = this.f$1;
                    NavHostController navHostController4 = this.f$0;
                    Composer composer2 = (Composer) obj3;
                    ((Integer) obj4).getClass();
                    switch (b3) {
                        case 0:
                            OnlinePodcastScreenKt.OnlinePodcastScreen(navHostController4, navDeepLinkRequest2, onlinePodcastViewModel6, composer2, Stack.updateChangedFlags(1));
                            break;
                        default:
                            OnlinePodcastScreenKt.OnlinePodcastScreen(navHostController4, navDeepLinkRequest2, onlinePodcastViewModel6, composer2, Stack.updateChangedFlags(1));
                            break;
                    }
                    return unit;
                }
            };
        }
    }

    public static final void PodcastHeader(PodcastItem podcastItem, int i, boolean z, Function0 function0, Function0 function1, Composer composer, int i2) {
        GapComposer gapComposer;
        Brush solidColor;
        float f;
        float f2;
        Modifier.Companion companion;
        long j;
        long j2;
        boolean z2;
        BorderStroke borderStrokeM38BorderStrokecXLIe8U;
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(875967864);
        int i3 = i2 | (gapComposer2.changedInstance(podcastItem) ? 4 : 2) | (gapComposer2.changed(i) ? 32 : 16) | (gapComposer2.changed(z) ? 256 : 128) | (gapComposer2.changedInstance(function0) ? 2048 : 1024) | (gapComposer2.changedInstance(function1) ? 16384 : 8192);
        if (gapComposer2.shouldExecute(i3 & 1, (i3 & 9363) != 9362)) {
            Context context = (Context) gapComposer2.consume(AndroidCompositionLocals_androidKt.LocalContext);
            Modifier.Companion companion2 = Modifier.Companion.$$INSTANCE;
            Modifier modifierM136paddingVpY3zN4 = OffsetKt.m136paddingVpY3zN4(SizeKt.fillMaxWidth(companion2, 1.0f), 20.0f, 8.0f);
            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start, gapComposer2, 48);
            int iHashCode = Long.hashCode(gapComposer2.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer2, modifierM136paddingVpY3zN4);
            ComposeUiNode.Companion.getClass();
            gapComposer2.startReusableNode();
            boolean z3 = gapComposer2.inserting;
            TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
            if (z3) {
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
            ImageRequest.Builder builder = new ImageRequest.Builder(context);
            String str = podcastItem.thumbnail;
            builder.data = str != null ? YouTubeUtilsKt.resize(str, 1080, 1080) : null;
            ImageRequest imageRequestBuild = builder.build();
            Modifier modifierM = Format$$ExternalSyntheticOutline0.m(24.0f, 8.0f, gapComposer2, SizeKt.m151size3ABfNKs(companion2, 200.0f));
            if (UiStyleKt.isGlassStyle(gapComposer2)) {
                gapComposer2.startReplaceGroup(-432543304);
                solidColor = GlassComponentsKt.glassRim(gapComposer2);
                gapComposer2.end(false);
                f = 24.0f;
            } else {
                gapComposer2.startReplaceGroup(-432542750);
                solidColor = new SolidColor(((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.outlineVariant);
                gapComposer2.end(false);
                f = 24.0f;
            }
            AsyncImageKt.m849AsyncImage10Xjiaw(imageRequestBuild, ImageKt.m43borderziNgDLE(modifierM, 1.0f, solidColor, RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(UiStyleKt.m1516styledRadiusi1RSzL4(f, 8.0f, gapComposer2))), ContentScale.Companion.Crop, gapComposer2, 1572912, 1976);
            OffsetKt.Spacer(gapComposer2, SizeKt.m145height3ABfNKs(companion2, 16.0f));
            TextKt.m352TextNvy7gAk(podcastItem.title, null, 0L, 0L, null, null, null, 0L, new TextAlign(5), 0L, 2, false, 2, 0, CardKt.getTypography(gapComposer2).headlineMedium, gapComposer2, 0, 24960, 109566);
            GapComposer gapComposer3 = gapComposer2;
            Artist artist = podcastItem.author;
            String str2 = artist != null ? artist.name : null;
            if (str2 == null) {
                gapComposer3.startReplaceGroup(-523514254);
                gapComposer3.end(false);
                f2 = 4.0f;
                companion = companion2;
            } else {
                gapComposer3.startReplaceGroup(-523514253);
                OffsetKt.Spacer(gapComposer3, SizeKt.m145height3ABfNKs(companion2, 4.0f));
                f2 = 4.0f;
                companion = companion2;
                TextKt.m352TextNvy7gAk(str2, null, CardKt.getColorScheme(gapComposer3).onSurfaceVariant, 0L, null, null, null, 0L, new TextAlign(5), 0L, 0, false, 0, 0, CardKt.getTypography(gapComposer3).bodyLarge, gapComposer3, 0, 0, 130042);
                gapComposer3 = gapComposer3;
                gapComposer3.end(false);
            }
            OffsetKt.Spacer(gapComposer3, SizeKt.m145height3ABfNKs(companion, f2));
            String str3 = podcastItem.episodeCountText;
            if (str3 == null) {
                str3 = i + " episodes";
            }
            GapComposer gapComposer4 = gapComposer3;
            TextKt.m352TextNvy7gAk(str3, null, CardKt.getColorScheme(gapComposer3).onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, CardKt.getTypography(gapComposer3).bodyMedium, gapComposer4, 0, 0, 131066);
            OffsetKt.Spacer(gapComposer4, SizeKt.m145height3ABfNKs(companion, 16.0f));
            RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(new Arrangement$SpacedAligned(8.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5)), Alignment.Companion.CenterVertically, gapComposer4, 54);
            int iHashCode2 = Long.hashCode(gapComposer4.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer4.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer4, companion);
            gapComposer4.startReusableNode();
            if (gapComposer4.inserting) {
                gapComposer4.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer4.useNode();
            }
            Stack.m390setimpl(gapComposer4, rowMeasurePolicy, updater$$ExternalSyntheticLambda0);
            Stack.m390setimpl(gapComposer4, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer4, updater$$ExternalSyntheticLambda2, gapComposer4);
            Stack.m390setimpl(gapComposer4, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
            PaddingValuesImpl paddingValuesImpl = ButtonDefaults.ContentPadding;
            if (z) {
                gapComposer4.startReplaceGroup(-913354650);
                j = CardKt.getColorScheme(gapComposer4).surfaceContainerHigh;
                gapComposer4.end(false);
            } else {
                gapComposer4.startReplaceGroup(-913351591);
                j = CardKt.getColorScheme(gapComposer4).primary;
                gapComposer4.end(false);
            }
            if (z) {
                gapComposer4.startReplaceGroup(-913348101);
                j2 = CardKt.getColorScheme(gapComposer4).onSurface;
                gapComposer4.end(false);
            } else {
                gapComposer4.startReplaceGroup(-913345381);
                j2 = CardKt.getColorScheme(gapComposer4).onPrimary;
                gapComposer4.end(false);
            }
            CardKt.Button(function0, SizeKt.m145height3ABfNKs(companion, 44.0f), false, RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(UiStyleKt.m1516styledRadiusi1RSzL4(50.0f, 8.0f, gapComposer4)), ButtonDefaults.m247buttonColorsro_MJ88(j, j2, 0L, gapComposer4, 12), null, null, null, null, Expect_jvmKt.rememberComposableLambda(-1207980734, new MiniPlayerKt$$ExternalSyntheticLambda17((byte) 4, z), gapComposer4), gapComposer4, ((i3 >> 9) & 14) | 805306416, 484);
            RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(UiStyleKt.m1516styledRadiusi1RSzL4(50.0f, 8.0f, gapComposer4));
            if (UiStyleKt.isGlassStyle(gapComposer4)) {
                gapComposer4.startReplaceGroup(-913319856);
                borderStrokeM38BorderStrokecXLIe8U = new BorderStroke(1.0f, GlassComponentsKt.glassRim(gapComposer4));
                z2 = false;
            } else {
                z2 = false;
                gapComposer4.startReplaceGroup(-913318674);
                borderStrokeM38BorderStrokecXLIe8U = ImageKt.m38BorderStrokecXLIe8U(CardKt.getColorScheme(gapComposer4).outlineVariant, 1.0f);
            }
            gapComposer4.end(z2);
            CardKt.OutlinedButton(function1, SizeKt.m145height3ABfNKs(companion, 44.0f), false, roundedCornerShapeM185RoundedCornerShape0680j_4, null, borderStrokeM38BorderStrokecXLIe8U, null, f409lambda$2060943292, gapComposer4, ((i3 >> 12) & 14) | 805306416, 436);
            gapComposer = gapComposer4;
            gapComposer.end(true);
            OffsetKt.Spacer(gapComposer, SizeKt.m145height3ABfNKs(companion, 16.0f));
            gapComposer.end(true);
        } else {
            gapComposer = gapComposer2;
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new MiniPlayerKt$$ExternalSyntheticLambda28(podcastItem, i, z, function0, function1, i2);
        }
    }
}
