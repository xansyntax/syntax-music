package com.metrolist.music.ui.screens.playlist;

import android.content.Context;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.InsetsPaddingValues;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.UnionInsets;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsHolder;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.foundation.lazy.LazyListIntervalContent;
import androidx.compose.foundation.lazy.LazyListKt$$ExternalSyntheticLambda0;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.ScrimKt;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.material3.SwipeToDismissBoxState;
import androidx.compose.material3.SwipeToDismissBoxValue;
import androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda2;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.SnapshotStateKt__DerivedStateKt;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
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
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.datastore.preferences.core.Preferences$Key;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.navigation.NavHostController;
import coil3.util.FileSystemsKt;
import coil3.util.UtilsKt;
import com.google.common.math.IntMath;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda21;
import com.metrolist.music.MainActivityKt;
import com.metrolist.music.constants.PlaylistSongSortType;
import com.metrolist.music.constants.PreferenceKeysKt;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.ArtistEntity;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.db.entities.PlaylistEntity;
import com.metrolist.music.db.entities.PlaylistSong;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.playback.DownloadUtil;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.ui.component.BottomSheetMenuKt;
import com.metrolist.music.ui.component.DialogKt;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.menu.AlbumMenuKt$$ExternalSyntheticLambda16;
import com.metrolist.music.ui.menu.AlbumMenuKt$$ExternalSyntheticLambda20;
import com.metrolist.music.ui.menu.QueueMenuKt$$ExternalSyntheticLambda12;
import com.metrolist.music.ui.menu.QueueMenuKt$$ExternalSyntheticLambda9;
import com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda78;
import com.metrolist.music.ui.player.PlayerKt$BottomSheetPlayer$13$1;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda21;
import com.metrolist.music.ui.player.QueueKt$Queue$5$1$1;
import com.metrolist.music.ui.player.QueueKt$Queue$5$4$1$1$4$1;
import com.metrolist.music.ui.player.QueueKt$Queue$5$reorderableState$1$1;
import com.metrolist.music.ui.screens.AccountScreenKt$AccountScreen$1$1$11$1$1;
import com.metrolist.music.ui.screens.HomeScreenKt$$ExternalSyntheticLambda40;
import com.metrolist.music.ui.screens.StatsScreenKt$$ExternalSyntheticLambda19;
import com.metrolist.music.ui.screens.StatsScreenKt$StatsScreen$1$1;
import com.metrolist.music.ui.screens.library.LibrarySongsScreenKt$$ExternalSyntheticLambda17;
import com.metrolist.music.ui.screens.search.SearchScreenKt$$ExternalSyntheticLambda0;
import com.metrolist.music.ui.screens.search.SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$1;
import com.metrolist.music.ui.screens.settings.AlarmSettingsKt$AlarmEditorDialog$lambda$27$0$0$$inlined$items$default$3;
import com.metrolist.music.utils.DataStoreKt$rememberPreference$1$1;
import com.metrolist.music.utils.SyncUtils;
import com.metrolist.music.utils.SyncUtils$createPlaylist$1;
import com.metrolist.music.viewmodels.LocalPlaylistViewModel;
import com.yalantis.ucrop.view.CropImageView;
import dev.chrisbanes.haze.RenderScriptBlurEffect$updateSurface$2$4;
import dev.chrisbanes.haze.ScrimBlurEffect$drawEffect$$inlined$withAlpha$1$1;
import io.ktor.http.MimesKt$$ExternalSyntheticLambda0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import kotlin.Function;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlowKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import sh.calvin.reorderable.DragGestureDetector$Press;
import sh.calvin.reorderable.ReorderableCollectionItemScopeImpl;
import sh.calvin.reorderable.ReorderableCollectionItemScopeImpl$draggableHandle$1;
import sh.calvin.reorderable.ReorderableLazyCollectionState$findTargetItem$1;
import sh.calvin.reorderable.ReorderableLazyListState;
import sh.calvin.reorderable.Scroller$ScrollInfo$Companion$Null$1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class LocalPlaylistScreenKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v27 */
    /* JADX WARN: Type inference failed for: r10v28 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v23 */
    /* JADX WARN: Type inference failed for: r15v12 */
    /* JADX WARN: Type inference failed for: r15v13 */
    /* JADX WARN: Type inference failed for: r15v23 */
    /* JADX WARN: Type inference failed for: r1v71 */
    /* JADX WARN: Type inference failed for: r26v2, types: [androidx.compose.runtime.Composer, androidx.compose.runtime.GapComposer] */
    /* JADX WARN: Type inference failed for: r32v0, types: [androidx.compose.runtime.Composer] */
    /* JADX WARN: Type inference failed for: r32v1, types: [androidx.compose.runtime.Composer] */
    /* JADX WARN: Type inference failed for: r32v2, types: [androidx.compose.runtime.Composer] */
    /* JADX WARN: Type inference failed for: r3v17, types: [androidx.compose.runtime.Composer, androidx.compose.runtime.GapComposer] */
    /* JADX WARN: Type inference failed for: r3v2, types: [androidx.compose.runtime.GapComposer] */
    /* JADX WARN: Type inference failed for: r3v24, types: [androidx.compose.runtime.Composer, androidx.compose.runtime.GapComposer] */
    /* JADX WARN: Type inference failed for: r3v40 */
    /* JADX WARN: Type inference failed for: r3v41 */
    /* JADX WARN: Type inference failed for: r3v42 */
    /* JADX WARN: Type inference failed for: r3v43 */
    /* JADX WARN: Type inference failed for: r5v37 */
    /* JADX WARN: Type inference failed for: r6v27 */
    /* JADX WARN: Type inference failed for: r6v28 */
    /* JADX WARN: Type inference failed for: r6v29 */
    /* JADX WARN: Type inference failed for: r6v30 */
    /* JADX WARN: Type inference failed for: r6v33 */
    /* JADX WARN: Type inference failed for: r6v34 */
    /* JADX WARN: Type inference failed for: r7v30 */
    /* JADX WARN: Type inference failed for: r8v15, types: [boolean, byte] */
    /* JADX WARN: Type inference failed for: r8v32 */
    /* JADX WARN: Type inference failed for: r8v33 */
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r5v8 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.dex.visitors.ModVisitor.anonymousCallArgMod(ModVisitor.java:535)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:528)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:111)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    public static final void LocalPlaylistHeader(final com.metrolist.music.db.entities.Playlist r67, final java.util.List r68, final com.metrolist.innertube.models.PlaylistItem r69, final kotlin.jvm.functions.Function0 r70, final kotlin.jvm.functions.Function0 r71, final kotlin.jvm.functions.Function0 r72, final kotlin.jvm.functions.Function0 r73, final androidx.compose.material3.SnackbarHostState r74, final androidx.compose.ui.Modifier r75, androidx.compose.runtime.Composer r76, final int r77) {
        /*
            Method dump skipped, instruction units count: 3042
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.metrolist.music.ui.screens.playlist.LocalPlaylistScreenKt.LocalPlaylistHeader(com.metrolist.music.db.entities.Playlist, java.util.List, com.metrolist.innertube.models.PlaylistItem, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, androidx.compose.material3.SnackbarHostState, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX WARN: Code duplicated, block: B:129:0x03ee  */
    /* JADX WARN: Code duplicated, block: B:135:0x042d  */
    /* JADX WARN: Code duplicated, block: B:138:0x0452  */
    /* JADX WARN: Code duplicated, block: B:141:0x0469  */
    /* JADX WARN: Code duplicated, block: B:143:0x0477  */
    /* JADX WARN: Code duplicated, block: B:144:0x047a  */
    /* JADX WARN: Code duplicated, block: B:146:0x047d  */
    /* JADX WARN: Code duplicated, block: B:147:0x0499  */
    /* JADX WARN: Code duplicated, block: B:152:0x04d4  */
    /* JADX WARN: Code duplicated, block: B:155:0x04e6  */
    /* JADX WARN: Code duplicated, block: B:158:0x0537  */
    /* JADX WARN: Code duplicated, block: B:161:0x0557  */
    /* JADX WARN: Code duplicated, block: B:164:0x056f  */
    /* JADX WARN: Code duplicated, block: B:166:0x057b  */
    /* JADX WARN: Code duplicated, block: B:168:0x05c9  */
    /* JADX WARN: Code duplicated, block: B:171:0x05e2  */
    /* JADX WARN: Code duplicated, block: B:174:0x05f9  */
    /* JADX WARN: Code duplicated, block: B:176:0x0605  */
    /* JADX WARN: Code duplicated, block: B:178:0x065c  */
    /* JADX WARN: Code duplicated, block: B:181:0x0687  */
    /* JADX WARN: Code duplicated, block: B:184:0x06a3  */
    /* JADX WARN: Code duplicated, block: B:185:0x06af  */
    /* JADX WARN: Code duplicated, block: B:189:0x06d8  */
    /* JADX WARN: Code duplicated, block: B:194:0x0709  */
    /* JADX WARN: Code duplicated, block: B:197:0x073b  */
    /* JADX WARN: Code duplicated, block: B:198:0x0741  */
    /* JADX WARN: Code duplicated, block: B:204:0x0814  */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void LocalPlaylistScreen(final NavHostController navHostController, LocalPlaylistViewModel localPlaylistViewModel, Composer composer, final int i) {
        final byte b;
        final NavHostController navHostController2;
        final LocalPlaylistViewModel localPlaylistViewModel2;
        GapComposer gapComposer;
        final LocalPlaylistViewModel localPlaylistViewModel3;
        ArrayList arrayList;
        PlaylistSongSortType playlistSongSortType;
        final PlayerConnection playerConnection;
        Object obj;
        MutableState mutableState;
        final MutableState mutableState2;
        Function0 function0;
        boolean zChanged;
        final boolean z;
        Object objRememberedValue;
        PlaylistEntity playlistEntity;
        final SnapshotStateList snapshotStateList;
        final MutableState mutableState3;
        boolean zChanged2;
        Object objRememberedValue2;
        SnapshotStateList snapshotStateList2;
        MutableState mutableState4;
        Object objRememberedValue3;
        final MutableState mutableState5;
        MusicDatabase musicDatabase;
        MutableState mutableState6;
        Object obj2;
        MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda0;
        byte b2;
        GapComposer gapComposer2;
        Object objRememberedValue4;
        final MutableState mutableState7;
        boolean z2;
        MutableState mutableState8;
        MutableState mutableState9;
        Object objRememberedValue5;
        MutableState mutableState10;
        LocalPlaylistViewModel localPlaylistViewModel4;
        final MutableState mutableState11;
        MutableState mutableState12;
        Continuation continuation;
        LazyListState lazyListStateRememberLazyListState;
        Object objRememberedValue6;
        MutableState mutableState13;
        Object objRememberedValue7;
        ReorderableLazyListState reorderableLazyListStateM1880rememberReorderableLazyListStateTN_CM5M;
        boolean zChanged3;
        Object objRememberedValue8;
        ReorderableLazyListState reorderableLazyListState;
        boolean z3;
        MusicDatabase musicDatabase2;
        LazyListState lazyListState;
        LocalPlaylistViewModel localPlaylistViewModel5;
        Object objRememberedValue9;
        final MutableState mutableState14;
        final boolean z4;
        final SnapshotStateList snapshotStateList3;
        final MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda1;
        boolean zChanged4;
        Object objRememberedValue10;
        SnackbarHostState snackbarHostState;
        MutableState mutableState15;
        Object objRememberedValue11;
        Object objRememberedValue12;
        Playlist playlist;
        PlaylistEntity playlistEntity2;
        boolean zChangedInstance;
        Object objRememberedValue13;
        byte b3;
        Object objRememberedValue14;
        boolean z5;
        GapComposer gapComposer3;
        navHostController.getClass();
        GapComposer gapComposer4 = (GapComposer) composer;
        gapComposer4.startRestartGroup(79195026);
        int i2 = (gapComposer4.changedInstance(navHostController) ? 4 : 2) | i | 16;
        final byte b4 = 0;
        if (gapComposer4.shouldExecute(i2 & 1, (i2 & 19) != 18)) {
            gapComposer4.startDefaults();
            if ((i & 1) == 0 || gapComposer4.getDefaultsInvalid()) {
                ViewModelStoreOwner viewModelStoreOwner = (ViewModelStoreOwner) gapComposer4.consume(LocalViewModelStoreOwner.LocalViewModelStoreOwner);
                if (viewModelStoreOwner == null) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                    return;
                }
                localPlaylistViewModel3 = (LocalPlaylistViewModel) UtilsKt.viewModel(Reflection.getOrCreateKotlinClass(LocalPlaylistViewModel.class), viewModelStoreOwner, MathKt.rememberHiltViewModelFactory(ViewModelKt.getViewModelProviderFactory(viewModelStoreOwner), gapComposer4), ViewModelKt.getViewModelCreationExtras(viewModelStoreOwner), gapComposer4);
            } else {
                gapComposer4.skipToGroupEnd();
                localPlaylistViewModel3 = localPlaylistViewModel;
            }
            gapComposer4.endDefaults();
            Context context = (Context) gapComposer4.consume(AndroidCompositionLocals_androidKt.LocalContext);
            MenuState menuState = (MenuState) gapComposer4.consume(BottomSheetMenuKt.LocalMenuState);
            MusicDatabase musicDatabase3 = (MusicDatabase) gapComposer4.consume(MainActivityKt.LocalDatabase);
            final HapticFeedback hapticFeedback = (HapticFeedback) gapComposer4.consume(CompositionLocalsKt.LocalHapticFeedback);
            PlayerConnection playerConnection2 = (PlayerConnection) gapComposer4.consume(MainActivityKt.LocalPlayerConnection);
            if (playerConnection2 == null) {
                RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer4.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new Function2(navHostController, localPlaylistViewModel3, i, b4) { // from class: com.metrolist.music.ui.screens.playlist.LocalPlaylistScreenKt$$ExternalSyntheticLambda0
                        public final /* synthetic */ byte $r8$classId;
                        public final /* synthetic */ NavHostController f$0;
                        public final /* synthetic */ LocalPlaylistViewModel f$1;

                        {
                            this.$r8$classId = b4;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj3, Object obj4) {
                            byte b5 = this.$r8$classId;
                            Unit unit = Unit.INSTANCE;
                            LocalPlaylistViewModel localPlaylistViewModel6 = this.f$1;
                            NavHostController navHostController3 = this.f$0;
                            Composer composer2 = (Composer) obj3;
                            ((Integer) obj4).getClass();
                            switch (b5) {
                                case 0:
                                    LocalPlaylistScreenKt.LocalPlaylistScreen(navHostController3, localPlaylistViewModel6, composer2, Stack.updateChangedFlags(1));
                                    break;
                                default:
                                    LocalPlaylistScreenKt.LocalPlaylistScreen(navHostController3, localPlaylistViewModel6, composer2, Stack.updateChangedFlags(1));
                                    break;
                            }
                            return unit;
                        }
                    };
                    return;
                }
                return;
            }
            final MutableState mutableStateCollectAsStateWithLifecycle = FileSystemsKt.collectAsStateWithLifecycle(playerConnection2.isEffectivelyPlaying, gapComposer4);
            final MutableState mutableStateCollectAsStateWithLifecycle2 = FileSystemsKt.collectAsStateWithLifecycle(playerConnection2.mediaMetadata, gapComposer4);
            MutableState mutableStateCollectAsStateWithLifecycle3 = FileSystemsKt.collectAsStateWithLifecycle(localPlaylistViewModel3.playlist, gapComposer4);
            MutableState mutableStateCollectAsStateWithLifecycle4 = FileSystemsKt.collectAsStateWithLifecycle(localPlaylistViewModel3.playlistSongs, gapComposer4);
            MutableState mutableStateCollectAsStateWithLifecycle5 = FileSystemsKt.collectAsStateWithLifecycle(localPlaylistViewModel3.onlinePlaylist, gapComposer4);
            Object objRememberedValue15 = gapComposer4.rememberedValue();
            Object obj3 = Composer.Companion.Empty;
            if (objRememberedValue15 == obj3) {
                objRememberedValue15 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer4);
            }
            SnapshotStateList snapshotStateList4 = (SnapshotStateList) objRememberedValue15;
            boolean zChanged5 = gapComposer4.changed((List) mutableStateCollectAsStateWithLifecycle4.getValue());
            Object objRememberedValue16 = gapComposer4.rememberedValue();
            if (zChanged5 || objRememberedValue16 == obj3) {
                List list = (List) mutableStateCollectAsStateWithLifecycle4.getValue();
                int size = list.size();
                int i3 = 0;
                for (int i4 = 0; i4 < size; i4++) {
                    i3 += ((PlaylistSong) list.get(i4)).song.song.duration;
                }
                objRememberedValue16 = Integer.valueOf(i3);
                gapComposer4.updateRememberedValue(objRememberedValue16);
            }
            ((Number) objRememberedValue16).intValue();
            Preferences$Key preferences$Key = PreferenceKeysKt.PlaylistSongSortTypeKey;
            Context context2 = (Context) gapComposer4.consume(AndroidCompositionLocals_androidKt.LocalContext);
            Object objRememberedValue17 = gapComposer4.rememberedValue();
            if (objRememberedValue17 == obj3) {
                objRememberedValue17 = Stack.createCompositionCoroutineScope(gapComposer4);
                gapComposer4.updateRememberedValue(objRememberedValue17);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue17;
            Object objRememberedValue18 = gapComposer4.rememberedValue();
            if (objRememberedValue18 == obj3) {
                objRememberedValue18 = StateFlowKt.distinctUntilChanged(new SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$1(com.metrolist.music.utils.UtilsKt.getDataStore(context2).getData(), preferences$Key, (byte) 22));
                gapComposer4.updateRememberedValue(objRememberedValue18);
            }
            MutableState mutableStateCollectAsStateWithLifecycle6 = FileSystemsKt.collectAsStateWithLifecycle((Flow) objRememberedValue18, PlaylistSongSortType.CUSTOM, gapComposer4, 48);
            Object objRememberedValue19 = gapComposer4.rememberedValue();
            if (objRememberedValue19 == obj3) {
                objRememberedValue19 = new LocalPlaylistScreenKt$LocalPlaylistScreen$$inlined$rememberEnumPreference$2(mutableStateCollectAsStateWithLifecycle6, coroutineScope, context2, preferences$Key);
                gapComposer4.updateRememberedValue(objRememberedValue19);
            }
            LocalPlaylistScreenKt$LocalPlaylistScreen$$inlined$rememberEnumPreference$2 localPlaylistScreenKt$LocalPlaylistScreen$$inlined$rememberEnumPreference$2 = (LocalPlaylistScreenKt$LocalPlaylistScreen$$inlined$rememberEnumPreference$2) objRememberedValue19;
            PlaylistSongSortType playlistSongSortType2 = (PlaylistSongSortType) localPlaylistScreenKt$LocalPlaylistScreen$$inlined$rememberEnumPreference$2.component1();
            final RenderScriptBlurEffect$updateSurface$2$4 renderScriptBlurEffect$updateSurface$2$4 = new RenderScriptBlurEffect$updateSurface$2$4((byte) 1, localPlaylistScreenKt$LocalPlaylistScreen$$inlined$rememberEnumPreference$2);
            Preferences$Key preferences$Key2 = PreferenceKeysKt.PlaylistSongSortDescendingKey;
            Boolean bool = Boolean.TRUE;
            DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference = com.metrolist.music.utils.UtilsKt.rememberPreference(preferences$Key2, bool, gapComposer4, 48);
            boolean zBooleanValue = ((Boolean) dataStoreKt$rememberPreference$1$1RememberPreference.$state.getValue()).booleanValue();
            MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda2 = new MimesKt$$ExternalSyntheticLambda0((byte) 18, dataStoreKt$rememberPreference$1$1RememberPreference);
            final DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference2 = com.metrolist.music.utils.UtilsKt.rememberPreference(PreferenceKeysKt.PlaylistEditLockKey, bool, gapComposer4, 48);
            Object objRememberedValue20 = gapComposer4.rememberedValue();
            if (objRememberedValue20 == obj3) {
                objRememberedValue20 = Stack.createCompositionCoroutineScope(gapComposer4);
                gapComposer4.updateRememberedValue(objRememberedValue20);
            }
            final SyncUtils syncUtils = (SyncUtils) gapComposer4.consume(MainActivityKt.LocalSyncUtils);
            Object objRememberedValue21 = gapComposer4.rememberedValue();
            if (objRememberedValue21 == obj3) {
                objRememberedValue21 = new SnackbarHostState();
                gapComposer4.updateRememberedValue(objRememberedValue21);
            }
            final SnackbarHostState snackbarHostState2 = (SnackbarHostState) objRememberedValue21;
            Object[] objArr = new Object[0];
            Object objRememberedValue22 = gapComposer4.rememberedValue();
            byte b5 = 12;
            if (objRememberedValue22 == obj3) {
                objRememberedValue22 = new SearchScreenKt$$ExternalSyntheticLambda0(b5);
                gapComposer4.updateRememberedValue(objRememberedValue22);
            }
            MutableState mutableState16 = (MutableState) SaverKt.rememberSaveable(objArr, (Function0) objRememberedValue22, gapComposer4, 48);
            Object[] objArr2 = new Object[0];
            Object objRememberedValue23 = gapComposer4.rememberedValue();
            if (objRememberedValue23 == obj3) {
                objRememberedValue23 = new SearchScreenKt$$ExternalSyntheticLambda0((byte) 13);
                gapComposer4.updateRememberedValue(objRememberedValue23);
            }
            MutableState mutableStateRememberSaveable = SaverKt.rememberSaveable(objArr2, (Saver) TextFieldValue.Saver, (Function0) objRememberedValue23, (Composer) gapComposer4, 384);
            boolean zChanged6 = gapComposer4.changed((List) mutableStateCollectAsStateWithLifecycle4.getValue()) | gapComposer4.changed((TextFieldValue) mutableStateRememberSaveable.getValue());
            Object objRememberedValue24 = gapComposer4.rememberedValue();
            if (zChanged6 || objRememberedValue24 == obj3) {
                if (((TextFieldValue) mutableStateRememberSaveable.getValue()).annotatedString.text.length() == 0) {
                    arrayList = (List) mutableStateCollectAsStateWithLifecycle4.getValue();
                } else {
                    List list2 = (List) mutableStateCollectAsStateWithLifecycle4.getValue();
                    arrayList = new ArrayList();
                    Iterator it = list2.iterator();
                    while (it.hasNext()) {
                        Object next = it.next();
                        Iterator it2 = it;
                        PlaylistSong playlistSong = (PlaylistSong) next;
                        PlaylistSongSortType playlistSongSortType3 = playlistSongSortType2;
                        PlayerConnection playerConnection3 = playerConnection2;
                        if (StringsKt.contains(playlistSong.song.song.title, ((TextFieldValue) mutableStateRememberSaveable.getValue()).annotatedString.text, true)) {
                            arrayList.add(next);
                            break;
                            break;
                        }
                        List list3 = playlistSong.song.artists;
                        int size2 = list3.size();
                        int i5 = 0;
                        while (i5 < size2) {
                            List list4 = list3;
                            int i6 = size2;
                            if (StringsKt.contains(((ArtistEntity) list3.get(i5)).name, ((TextFieldValue) mutableStateRememberSaveable.getValue()).annotatedString.text, true)) {
                                arrayList.add(next);
                                break;
                            } else {
                                i5++;
                                size2 = i6;
                                list3 = list4;
                            }
                        }
                        it = it2;
                        playlistSongSortType2 = playlistSongSortType3;
                        playerConnection2 = playerConnection3;
                    }
                }
                playlistSongSortType = playlistSongSortType2;
                playerConnection = playerConnection2;
                gapComposer4.updateRememberedValue(arrayList);
                obj = arrayList;
            } else {
                playlistSongSortType = playlistSongSortType2;
                playerConnection = playerConnection2;
                obj = objRememberedValue24;
            }
            final List list5 = (List) obj;
            Object objRememberedValue25 = gapComposer4.rememberedValue();
            if (objRememberedValue25 == obj3) {
                objRememberedValue25 = new FocusRequester();
                gapComposer4.updateRememberedValue(objRememberedValue25);
            }
            FocusRequester focusRequester = (FocusRequester) objRememberedValue25;
            Boolean boolValueOf = Boolean.valueOf(((Boolean) mutableState16.getValue()).booleanValue());
            boolean zChanged7 = gapComposer4.changed(mutableState16);
            Object objRememberedValue26 = gapComposer4.rememberedValue();
            if (zChanged7 || objRememberedValue26 == obj3) {
                objRememberedValue26 = new StatsScreenKt$StatsScreen$1$1(focusRequester, mutableState16, null, (byte) 4);
                gapComposer4.updateRememberedValue(objRememberedValue26);
            }
            Stack.LaunchedEffect(gapComposer4, boolValueOf, (Function2) objRememberedValue26);
            Object objRememberedValue27 = gapComposer4.rememberedValue();
            if (objRememberedValue27 == obj3) {
                objRememberedValue27 = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer4.updateRememberedValue(objRememberedValue27);
            }
            MutableState mutableState17 = (MutableState) objRememberedValue27;
            Object objRememberedValue28 = gapComposer4.rememberedValue();
            if (objRememberedValue28 == obj3) {
                objRememberedValue28 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer4);
            }
            SnapshotStateList snapshotStateList5 = (SnapshotStateList) objRememberedValue28;
            Object objRememberedValue29 = gapComposer4.rememberedValue();
            if (objRememberedValue29 == obj3) {
                objRememberedValue29 = Stack.mutableStateOf$default(null);
                gapComposer4.updateRememberedValue(objRememberedValue29);
            }
            MutableState mutableState18 = (MutableState) objRememberedValue29;
            Object objRememberedValue30 = gapComposer4.rememberedValue();
            if (objRememberedValue30 == obj3) {
                objRememberedValue30 = new LocalPlaylistScreenKt$$ExternalSyntheticLambda12(snapshotStateList5, mutableState17, mutableState18, (byte) 0);
                gapComposer4.updateRememberedValue(objRememberedValue30);
            }
            Function0 function1 = (Function0) objRememberedValue30;
            if (((Boolean) mutableState16.getValue()).booleanValue()) {
                gapComposer4.startReplaceGroup(1364630020);
                boolean zChanged8 = gapComposer4.changed(mutableState16) | gapComposer4.changed(mutableStateRememberSaveable);
                mutableState2 = mutableState17;
                Object objRememberedValue31 = gapComposer4.rememberedValue();
                if (zChanged8 || objRememberedValue31 == obj3) {
                    objRememberedValue31 = new TooltipKt$$ExternalSyntheticLambda2(mutableState16, mutableStateRememberSaveable, (byte) 11);
                    gapComposer4.updateRememberedValue(objRememberedValue31);
                }
                mutableState = mutableStateRememberSaveable;
                UtilsKt.BackHandler(false, (Function0) objRememberedValue31, gapComposer4, 0, 1);
                gapComposer4.end(false);
            } else {
                mutableState = mutableStateRememberSaveable;
                mutableState2 = mutableState17;
                if (LocalPlaylistScreen$lambda$21(mutableState2)) {
                    gapComposer4.startReplaceGroup(1364759383);
                    UtilsKt.BackHandler(false, function1, gapComposer4, 48, 1);
                    gapComposer4.end(false);
                } else {
                    gapComposer4.startReplaceGroup(1364814160);
                    gapComposer4.end(false);
                }
            }
            DownloadUtil downloadUtil = (DownloadUtil) gapComposer4.consume(MainActivityKt.LocalDownloadUtil);
            Object objRememberedValue32 = gapComposer4.rememberedValue();
            if (objRememberedValue32 == obj3) {
                objRememberedValue32 = Fragment$5$$ExternalSyntheticOutline0.m(1, gapComposer4);
            }
            ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = (ParcelableSnapshotMutableIntState) objRememberedValue32;
            Playlist playlist2 = (Playlist) mutableStateCollectAsStateWithLifecycle3.getValue();
            if (playlist2 != null) {
                function0 = function1;
                boolean z6 = playlist2.playlist.isEditable;
                List list6 = (List) mutableStateCollectAsStateWithLifecycle4.getValue();
                zChanged = gapComposer4.changed(mutableStateCollectAsStateWithLifecycle4);
                z = z6;
                objRememberedValue = gapComposer4.rememberedValue();
                if (!zChanged || objRememberedValue == obj3) {
                    objRememberedValue = new SyncUtils$createPlaylist$1.AnonymousClass1((Object) snapshotStateList5, (Object) mutableStateCollectAsStateWithLifecycle4, (Object) mutableState18, (Continuation) null, (byte) 15);
                    playlistEntity = null;
                    snapshotStateList = snapshotStateList5;
                    mutableState3 = mutableState18;
                    gapComposer4.updateRememberedValue(objRememberedValue);
                } else {
                    snapshotStateList = snapshotStateList5;
                    mutableState3 = mutableState18;
                    playlistEntity = null;
                }
                Stack.LaunchedEffect(gapComposer4, list6, (Function2) objRememberedValue);
                List list7 = (List) mutableStateCollectAsStateWithLifecycle4.getValue();
                zChanged2 = gapComposer4.changed(mutableStateCollectAsStateWithLifecycle4) | gapComposer4.changedInstance(downloadUtil);
                objRememberedValue2 = gapComposer4.rememberedValue();
                if (!zChanged2 || objRememberedValue2 == obj3) {
                    objRememberedValue2 = new TopPlaylistScreenKt$TopPlaylistScreen$4$1(snapshotStateList4, downloadUtil, mutableStateCollectAsStateWithLifecycle4, parcelableSnapshotMutableIntState, null, (byte) 2);
                    snapshotStateList2 = snapshotStateList4;
                    mutableState4 = mutableStateCollectAsStateWithLifecycle4;
                    gapComposer4.updateRememberedValue(objRememberedValue2);
                } else {
                    mutableState4 = mutableStateCollectAsStateWithLifecycle4;
                    snapshotStateList2 = snapshotStateList4;
                }
                Stack.LaunchedEffect(gapComposer4, list7, (Function2) objRememberedValue2);
                objRememberedValue3 = gapComposer4.rememberedValue();
                if (objRememberedValue3 == obj3) {
                    objRememberedValue3 = Stack.mutableStateOf$default(Boolean.FALSE);
                    gapComposer4.updateRememberedValue(objRememberedValue3);
                }
                mutableState5 = (MutableState) objRememberedValue3;
                if (((Boolean) mutableState5.getValue()).booleanValue()) {
                    gapComposer4.startReplaceGroup(-1202846259);
                    playlist = (Playlist) mutableStateCollectAsStateWithLifecycle3.getValue();
                    if (playlist != null) {
                        playlistEntity2 = playlist.playlist;
                    } else {
                        playlistEntity2 = playlistEntity;
                    }
                    if (playlistEntity2 == null) {
                        gapComposer4.startReplaceGroup(1366471636);
                        z5 = false;
                        gapComposer4.end(false);
                        musicDatabase = musicDatabase3;
                        mutableState6 = mutableStateCollectAsStateWithLifecycle5;
                        obj2 = obj3;
                        mimesKt$$ExternalSyntheticLambda0 = mimesKt$$ExternalSyntheticLambda2;
                        b2 = 23;
                        gapComposer3 = gapComposer4;
                    } else {
                        gapComposer4.startReplaceGroup(1366471637);
                        String str = playlistEntity2.name;
                        int length = str.length();
                        TextFieldValue textFieldValue = new TextFieldValue(4, TextRangeKt.TextRange(length, length), str);
                        ComposableLambdaImpl composableLambdaImpl = TopPlaylistScreenKt.lambda$1599347233;
                        ComposableLambdaImpl composableLambdaImpl2 = TopPlaylistScreenKt.lambda$1768598818;
                        zChangedInstance = gapComposer4.changedInstance(musicDatabase3) | gapComposer4.changed(playlistEntity2) | gapComposer4.changedInstance(localPlaylistViewModel3);
                        objRememberedValue13 = gapComposer4.rememberedValue();
                        if (!zChangedInstance || objRememberedValue13 == obj3) {
                            b3 = 23;
                            objRememberedValue13 = new MainActivity$$ExternalSyntheticLambda21(musicDatabase3, (Object) localPlaylistViewModel3, (Object) playlistEntity2, b3);
                            gapComposer4.updateRememberedValue(objRememberedValue13);
                        } else {
                            b3 = 23;
                        }
                        Function1 function2 = (Function1) objRememberedValue13;
                        objRememberedValue14 = gapComposer4.rememberedValue();
                        if (objRememberedValue14 == obj3) {
                            objRememberedValue14 = new LibrarySongsScreenKt$$ExternalSyntheticLambda17(mutableState5, (byte) 7);
                            gapComposer4.updateRememberedValue(objRememberedValue14);
                        }
                        Function0 function3 = (Function0) objRememberedValue14;
                        mimesKt$$ExternalSyntheticLambda0 = mimesKt$$ExternalSyntheticLambda2;
                        mutableState6 = mutableStateCollectAsStateWithLifecycle5;
                        b2 = b3;
                        musicDatabase = musicDatabase3;
                        obj2 = obj3;
                        DialogKt.m1470TextFieldDialog5RwOfIE(null, composableLambdaImpl, composableLambdaImpl2, textFieldValue, false, false, 0, null, 0, function2, null, null, null, function3, false, null, gapComposer4, 432, 24576, 113649);
                        GapComposer gapComposer5 = gapComposer4;
                        z5 = false;
                        gapComposer5.end(false);
                        gapComposer3 = gapComposer5;
                    }
                    gapComposer3.end(z5);
                    gapComposer2 = gapComposer3;
                } else {
                    snapshotStateList2 = snapshotStateList2;
                    mutableState16 = mutableState16;
                    musicDatabase = musicDatabase3;
                    mutableState6 = mutableStateCollectAsStateWithLifecycle5;
                    obj2 = obj3;
                    mimesKt$$ExternalSyntheticLambda0 = mimesKt$$ExternalSyntheticLambda2;
                    zBooleanValue = zBooleanValue;
                    menuState = menuState;
                    b2 = 23;
                    gapComposer4.startReplaceGroup(1367610608);
                    gapComposer4.end(false);
                    gapComposer2 = gapComposer4;
                }
                objRememberedValue4 = gapComposer2.rememberedValue();
                if (objRememberedValue4 == obj2) {
                    objRememberedValue4 = Stack.mutableStateOf$default(Boolean.FALSE);
                    gapComposer2.updateRememberedValue(objRememberedValue4);
                }
                mutableState7 = (MutableState) objRememberedValue4;
                if (((Boolean) mutableState7.getValue()).booleanValue()) {
                    gapComposer2.startReplaceGroup(1367779434);
                    objRememberedValue12 = gapComposer2.rememberedValue();
                    if (objRememberedValue12 == obj2) {
                        objRememberedValue12 = new LibrarySongsScreenKt$$ExternalSyntheticLambda17(mutableState7, (byte) 8);
                        gapComposer2.updateRememberedValue(objRememberedValue12);
                    }
                    MutableState mutableState19 = mutableState4;
                    mutableState9 = mutableStateCollectAsStateWithLifecycle3;
                    mutableState8 = mutableState19;
                    DialogKt.DefaultDialog((Function0) objRememberedValue12, null, null, null, Expect_jvmKt.rememberComposableLambda(-1568133321, new AlbumMenuKt$$ExternalSyntheticLambda16(context, mutableStateCollectAsStateWithLifecycle3, mutableState19, mutableState7, musicDatabase, z), gapComposer2), null, Expect_jvmKt.rememberComposableLambda(-746677619, new QueueKt$$ExternalSyntheticLambda21(mutableState9, (byte) 22), gapComposer2), gapComposer2, 1597446, 46);
                    z2 = false;
                    gapComposer2.end(false);
                } else {
                    z2 = false;
                    mutableState8 = mutableState4;
                    mutableState9 = mutableStateCollectAsStateWithLifecycle3;
                    gapComposer2.startReplaceGroup(1369322800);
                    gapComposer2.end(false);
                }
                objRememberedValue5 = gapComposer2.rememberedValue();
                if (objRememberedValue5 == obj2) {
                    objRememberedValue5 = Stack.mutableStateOf$default(Boolean.FALSE);
                    gapComposer2.updateRememberedValue(objRememberedValue5);
                }
                mutableState10 = (MutableState) objRememberedValue5;
                if (((Boolean) mutableState10.getValue()).booleanValue()) {
                    gapComposer2.startReplaceGroup(1369485519);
                    objRememberedValue11 = gapComposer2.rememberedValue();
                    if (objRememberedValue11 == obj2) {
                        objRememberedValue11 = new LibrarySongsScreenKt$$ExternalSyntheticLambda17(mutableState10, (byte) 9);
                        gapComposer2.updateRememberedValue(objRememberedValue11);
                    }
                    continuation = null;
                    byte b6 = b2;
                    localPlaylistViewModel4 = localPlaylistViewModel3;
                    mutableState11 = mutableState10;
                    mutableState12 = mutableState16;
                    DialogKt.DefaultDialog((Function0) objRememberedValue11, null, null, null, Expect_jvmKt.rememberComposableLambda(1832899064, new QueueMenuKt$$ExternalSyntheticLambda9(mutableState9, mutableState10, navHostController, musicDatabase, localPlaylistViewModel4), gapComposer2), null, Expect_jvmKt.rememberComposableLambda(-1640612530, new QueueKt$$ExternalSyntheticLambda21(mutableState9, b6), gapComposer2), gapComposer2, 1597446, 46);
                    gapComposer2.end(z2);
                } else {
                    localPlaylistViewModel4 = localPlaylistViewModel3;
                    mutableState11 = mutableState10;
                    mutableState12 = mutableState16;
                    continuation = null;
                    gapComposer2.startReplaceGroup(1370870320);
                    gapComposer2.end(z2);
                }
                lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(gapComposer2);
                objRememberedValue6 = gapComposer2.rememberedValue();
                if (objRememberedValue6 == obj2) {
                    objRememberedValue6 = Stack.mutableStateOf$default(continuation);
                    gapComposer2.updateRememberedValue(objRememberedValue6);
                }
                mutableState13 = (MutableState) objRememberedValue6;
                ProvidableCompositionLocal providableCompositionLocal = MainActivityKt.LocalPlayerAwareWindowInsets;
                InsetsPaddingValues insetsPaddingValuesAsPaddingValues = OffsetKt.asPaddingValues((WindowInsets) gapComposer2.consume(providableCompositionLocal), gapComposer2);
                objRememberedValue7 = gapComposer2.rememberedValue();
                if (objRememberedValue7 == obj2) {
                    objRememberedValue7 = new QueueKt$Queue$5$reorderableState$1$1(snapshotStateList2, mutableState13, continuation, (byte) 1);
                    gapComposer2.updateRememberedValue(objRememberedValue7);
                }
                reorderableLazyListStateM1880rememberReorderableLazyListStateTN_CM5M = CharsKt.m1880rememberReorderableLazyListStateTN_CM5M(lazyListStateRememberLazyListState, insetsPaddingValuesAsPaddingValues, (Function4) objRememberedValue7, gapComposer2, 12);
                Boolean boolValueOf2 = Boolean.valueOf(reorderableLazyListStateM1880rememberReorderableLazyListStateTN_CM5M.isAnyItemDragging());
                zChanged3 = gapComposer2.changed(reorderableLazyListStateM1880rememberReorderableLazyListStateTN_CM5M) | gapComposer2.changedInstance(localPlaylistViewModel4) | gapComposer2.changedInstance(musicDatabase);
                objRememberedValue8 = gapComposer2.rememberedValue();
                if (!zChanged3 || objRememberedValue8 == obj2) {
                    LocalPlaylistViewModel localPlaylistViewModel6 = localPlaylistViewModel4;
                    reorderableLazyListState = reorderableLazyListStateM1880rememberReorderableLazyListStateTN_CM5M;
                    z3 = true;
                    musicDatabase2 = musicDatabase;
                    lazyListState = lazyListStateRememberLazyListState;
                    Object queueKt$Queue$5$1$1 = new QueueKt$Queue$5$1$1(reorderableLazyListState, mutableState13, localPlaylistViewModel6, musicDatabase2, null, (byte) 7);
                    localPlaylistViewModel5 = localPlaylistViewModel6;
                    gapComposer2.updateRememberedValue(queueKt$Queue$5$1$1);
                    objRememberedValue8 = queueKt$Queue$5$1$1;
                } else {
                    localPlaylistViewModel5 = localPlaylistViewModel4;
                    reorderableLazyListState = reorderableLazyListStateM1880rememberReorderableLazyListStateTN_CM5M;
                    z3 = true;
                    musicDatabase2 = musicDatabase;
                    lazyListState = lazyListStateRememberLazyListState;
                }
                Stack.LaunchedEffect(gapComposer2, boolValueOf2, (Function2) objRememberedValue8);
                objRememberedValue9 = gapComposer2.rememberedValue();
                if (objRememberedValue9 == obj2) {
                    objRememberedValue9 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new LazyListKt$$ExternalSyntheticLambda0(lazyListState, (byte) 6));
                    gapComposer2.updateRememberedValue(objRememberedValue9);
                }
                State state = (State) objRememberedValue9;
                FillElement fillElement = SizeKt.FillWholeMaxSize;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
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
                WindowInsets windowInsets = (WindowInsets) gapComposer2.consume(providableCompositionLocal);
                WeakHashMap weakHashMap = WindowInsetsHolder.viewMap;
                InsetsPaddingValues insetsPaddingValuesAsPaddingValues2 = OffsetKt.asPaddingValues(new UnionInsets(windowInsets, OffsetKt.current(gapComposer2).ime), gapComposer2);
                mutableState14 = mutableState6;
                z4 = zBooleanValue;
                snapshotStateList3 = snapshotStateList2;
                mimesKt$$ExternalSyntheticLambda1 = mimesKt$$ExternalSyntheticLambda0;
                zChanged4 = gapComposer2.changed(mutableState9) | gapComposer2.changed(mutableState12) | gapComposer2.changed(mutableState8) | gapComposer2.changed(mutableState14) | gapComposer2.changed(playlistSongSortType.ordinal()) | gapComposer2.changed(z4) | gapComposer2.changed(renderScriptBlurEffect$updateSurface$2$4) | gapComposer2.changed(mimesKt$$ExternalSyntheticLambda1) | gapComposer2.changed(z) | gapComposer2.changed(dataStoreKt$rememberPreference$1$1RememberPreference2) | gapComposer2.changedInstance(list5) | gapComposer2.changed(reorderableLazyListState) | gapComposer2.changedInstance(musicDatabase2) | gapComposer2.changedInstance(syncUtils) | gapComposer2.changed(mutableStateCollectAsStateWithLifecycle2) | gapComposer2.changed(mutableStateCollectAsStateWithLifecycle) | gapComposer2.changedInstance(hapticFeedback) | gapComposer2.changedInstance(playerConnection) | gapComposer2.changed(menuState);
                objRememberedValue10 = gapComposer2.rememberedValue();
                if (!zChanged4 || objRememberedValue10 == obj2) {
                    final MutableState mutableState20 = mutableState9;
                    final MutableState mutableState21 = mutableState8;
                    final ReorderableLazyListState reorderableLazyListState2 = reorderableLazyListState;
                    final PlaylistSongSortType playlistSongSortType4 = playlistSongSortType;
                    final MenuState menuState2 = menuState;
                    final MusicDatabase musicDatabase4 = musicDatabase2;
                    final MutableState mutableState22 = mutableState12;
                    objRememberedValue10 = new Function1() { // from class: com.metrolist.music.ui.screens.playlist.LocalPlaylistScreenKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj4) {
                            final PlaylistSongSortType playlistSongSortType5;
                            boolean z7;
                            MutableState mutableState23;
                            boolean z8;
                            int i7;
                            String str2;
                            Integer num;
                            LazyListIntervalContent lazyListIntervalContent = (LazyListIntervalContent) obj4;
                            lazyListIntervalContent.getClass();
                            final MutableState mutableState24 = mutableState20;
                            Playlist playlist3 = (Playlist) mutableState24.getValue();
                            final MutableState mutableState25 = mutableState22;
                            final MutableState mutableState26 = mutableState21;
                            PlaylistSongSortType playlistSongSortType6 = playlistSongSortType4;
                            boolean z9 = z;
                            MutableState mutableState27 = dataStoreKt$rememberPreference$1$1RememberPreference2;
                            if (playlist3 == null) {
                                playlistSongSortType5 = playlistSongSortType6;
                                z7 = z9;
                                mutableState23 = mutableState27;
                                mutableState25 = mutableState25;
                                z8 = true;
                            } else if (playlist3.songCount == 0 && (num = playlist3.playlist.remoteSongCount) != null && num.intValue() == 0) {
                                LazyListIntervalContent.item$default(lazyListIntervalContent, "empty_placeholder", null, TopPlaylistScreenKt.f399lambda$412743085, 2);
                                playlistSongSortType5 = playlistSongSortType6;
                                z7 = z9;
                                mutableState23 = mutableState27;
                                mutableState25 = mutableState25;
                                z8 = true;
                            } else {
                                if (((Boolean) mutableState25.getValue()).booleanValue()) {
                                    i7 = 2;
                                    str2 = null;
                                } else {
                                    ComposableLambdaImpl composableLambdaImpl3 = new ComposableLambdaImpl(true, 1700853551, new AlbumMenuKt$$ExternalSyntheticLambda20(playlist3, mutableState25, snackbarHostState2, mutableState26, mutableState14, mutableState5, mutableState7, mutableState11));
                                    i7 = 2;
                                    str2 = null;
                                    LazyListIntervalContent.item$default(lazyListIntervalContent, "playlist_header", null, composableLambdaImpl3, 2);
                                }
                                z7 = z9;
                                mutableState23 = mutableState27;
                                z8 = true;
                                playlistSongSortType5 = playlistSongSortType6;
                                LazyListIntervalContent.item$default(lazyListIntervalContent, "controls_row", str2, new ComposableLambdaImpl(true, 2122362666, new HomeScreenKt$$ExternalSyntheticLambda40(playlistSongSortType6, z4, renderScriptBlurEffect$updateSurface$2$4, mimesKt$$ExternalSyntheticLambda1, z7, mutableState23)), i7);
                            }
                            final List list8 = ((Boolean) mutableState25.getValue()).booleanValue() ? list5 : snapshotStateList3;
                            TopPlaylistScreenKt$$ExternalSyntheticLambda8 topPlaylistScreenKt$$ExternalSyntheticLambda8 = new TopPlaylistScreenKt$$ExternalSyntheticLambda8((byte) 7);
                            int size3 = list8.size();
                            ScrimBlurEffect$drawEffect$$inlined$withAlpha$1$1 scrimBlurEffect$drawEffect$$inlined$withAlpha$1$1 = new ScrimBlurEffect$drawEffect$$inlined$withAlpha$1$1(topPlaylistScreenKt$$ExternalSyntheticLambda8, list8, (byte) 3);
                            AlarmSettingsKt$AlarmEditorDialog$lambda$27$0$0$$inlined$items$default$3 alarmSettingsKt$AlarmEditorDialog$lambda$27$0$0$$inlined$items$default$3 = new AlarmSettingsKt$AlarmEditorDialog$lambda$27$0$0$$inlined$items$default$3(list8, (byte) 7);
                            boolean z10 = z8;
                            final ReorderableLazyListState reorderableLazyListState3 = reorderableLazyListState2;
                            final MusicDatabase musicDatabase5 = musicDatabase4;
                            final SyncUtils syncUtils2 = syncUtils;
                            final SnapshotStateList snapshotStateList6 = snapshotStateList;
                            final HapticFeedback hapticFeedback2 = hapticFeedback;
                            final State state2 = mutableStateCollectAsStateWithLifecycle2;
                            final PlayerConnection playerConnection4 = playerConnection;
                            final State state3 = mutableStateCollectAsStateWithLifecycle;
                            final MutableState mutableState28 = mutableState2;
                            final MutableState mutableState29 = mutableState3;
                            final MenuState menuState3 = menuState2;
                            final List list9 = list8;
                            final MutableState mutableState30 = mutableState23;
                            final boolean z11 = z7;
                            lazyListIntervalContent.items(size3, scrimBlurEffect$drawEffect$$inlined$withAlpha$1$1, alarmSettingsKt$AlarmEditorDialog$lambda$27$0$0$$inlined$items$default$3, new ComposableLambdaImpl(z10, 2039820996, new Function4() { // from class: com.metrolist.music.ui.screens.playlist.LocalPlaylistScreenKt$LocalPlaylistScreen$lambda$57$0$0$$inlined$itemsIndexed$default$3
                                @Override // kotlin.jvm.functions.Function4
                                public final Object invoke(Object obj5, Object obj6, Object obj7, Object obj8) {
                                    int i8;
                                    final LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj5;
                                    final int iIntValue = ((Number) obj6).intValue();
                                    Composer composer2 = (Composer) obj7;
                                    int iIntValue2 = ((Number) obj8).intValue();
                                    if ((iIntValue2 & 6) == 0) {
                                        i8 = (((GapComposer) composer2).changed(lazyItemScopeImpl) ? 4 : 2) | iIntValue2;
                                    } else {
                                        i8 = iIntValue2;
                                    }
                                    if ((iIntValue2 & 48) == 0) {
                                        i8 |= ((GapComposer) composer2).changed(iIntValue) ? 32 : 16;
                                    }
                                    int i9 = i8;
                                    GapComposer gapComposer6 = (GapComposer) composer2;
                                    if (gapComposer6.shouldExecute(i9 & 1, (i9 & 147) != 146)) {
                                        final PlaylistSong playlistSong2 = (PlaylistSong) list8.get(iIntValue);
                                        gapComposer6.startReplaceGroup(-1047776051);
                                        Integer numValueOf = Integer.valueOf(playlistSong2.map.id);
                                        final MutableState mutableState31 = mutableState30;
                                        final MutableState mutableState32 = mutableState25;
                                        final MutableState mutableState33 = mutableState24;
                                        final MusicDatabase musicDatabase6 = musicDatabase5;
                                        final SyncUtils syncUtils3 = syncUtils2;
                                        final SnapshotStateList snapshotStateList7 = snapshotStateList6;
                                        final HapticFeedback hapticFeedback3 = hapticFeedback2;
                                        final List list10 = list9;
                                        final State state4 = state2;
                                        final PlayerConnection playerConnection5 = playerConnection4;
                                        final MutableState mutableState34 = mutableState26;
                                        final State state5 = state3;
                                        final MutableState mutableState35 = mutableState28;
                                        final MutableState mutableState36 = mutableState29;
                                        final MenuState menuState4 = menuState3;
                                        final PlaylistSongSortType playlistSongSortType7 = playlistSongSortType5;
                                        final boolean z12 = z11;
                                        CharsKt.ReorderableItem(lazyItemScopeImpl, reorderableLazyListState3, numValueOf, null, false, null, Expect_jvmKt.rememberComposableLambda(137257390, new Function4() { // from class: com.metrolist.music.ui.screens.playlist.LocalPlaylistScreenKt$LocalPlaylistScreen$13$1$1$3$1
                                            @Override // kotlin.jvm.functions.Function4
                                            public final Object invoke(Object obj9, Object obj10, Object obj11, Object obj12) {
                                                SwipeToDismissBoxValue swipeToDismissBoxValue;
                                                NeverEqualPolicy neverEqualPolicy;
                                                SwipeToDismissBoxState swipeToDismissBoxState;
                                                final ReorderableCollectionItemScopeImpl reorderableCollectionItemScopeImpl = (ReorderableCollectionItemScopeImpl) obj9;
                                                ((Boolean) obj10).getClass();
                                                Composer composer3 = (Composer) obj11;
                                                int iIntValue3 = ((Number) obj12).intValue();
                                                reorderableCollectionItemScopeImpl.getClass();
                                                byte b7 = 2;
                                                if ((iIntValue3 & 6) == 0) {
                                                    iIntValue3 |= ((GapComposer) composer3).changed(reorderableCollectionItemScopeImpl) ? 4 : 2;
                                                }
                                                GapComposer gapComposer7 = (GapComposer) composer3;
                                                if (gapComposer7.shouldExecute(iIntValue3 & 1, (iIntValue3 & 131) != 130)) {
                                                    final PlaylistSong playlistSong3 = playlistSong2;
                                                    MutableState mutableStateRememberUpdatedState = Stack.rememberUpdatedState(playlistSong3, gapComposer7);
                                                    Preferences$Key preferences$Key3 = PreferenceKeysKt.SwipeToRemoveSongKey;
                                                    Boolean bool2 = Boolean.FALSE;
                                                    DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference3 = com.metrolist.music.utils.UtilsKt.rememberPreference(preferences$Key3, bool2, gapComposer7, 48);
                                                    Object objRememberedValue33 = gapComposer7.rememberedValue();
                                                    NeverEqualPolicy neverEqualPolicy2 = Composer.Companion.Empty;
                                                    if (objRememberedValue33 == neverEqualPolicy2) {
                                                        objRememberedValue33 = CachePlaylistScreenKt$CachePlaylistScreen$sortedSongs$1$sorted$3$1.INSTANCE$1;
                                                        gapComposer7.updateRememberedValue(objRememberedValue33);
                                                    }
                                                    SwipeToDismissBoxState swipeToDismissBoxStateRememberSwipeToDismissBoxState = ScrimKt.rememberSwipeToDismissBoxState((Function1) objRememberedValue33, gapComposer7);
                                                    Object objRememberedValue34 = gapComposer7.rememberedValue();
                                                    if (objRememberedValue34 == neverEqualPolicy2) {
                                                        objRememberedValue34 = Stack.mutableStateOf$default(bool2);
                                                        gapComposer7.updateRememberedValue(objRememberedValue34);
                                                    }
                                                    MutableState mutableState37 = (MutableState) objRememberedValue34;
                                                    SwipeToDismissBoxValue currentValue = swipeToDismissBoxStateRememberSwipeToDismissBoxState.getCurrentValue();
                                                    boolean zChangedInstance2 = gapComposer7.changedInstance(swipeToDismissBoxStateRememberSwipeToDismissBoxState) | gapComposer7.changed(dataStoreKt$rememberPreference$1$1RememberPreference3);
                                                    final MutableState mutableState38 = mutableState33;
                                                    boolean zChanged9 = zChangedInstance2 | gapComposer7.changed(mutableState38) | gapComposer7.changed(mutableStateRememberUpdatedState) | gapComposer7.changedInstance(musicDatabase6) | gapComposer7.changedInstance(syncUtils3);
                                                    Object objRememberedValue35 = gapComposer7.rememberedValue();
                                                    if (zChanged9 || objRememberedValue35 == neverEqualPolicy2) {
                                                        swipeToDismissBoxValue = currentValue;
                                                        neverEqualPolicy = neverEqualPolicy2;
                                                        PlayerKt$BottomSheetPlayer$13$1 playerKt$BottomSheetPlayer$13$1 = new PlayerKt$BottomSheetPlayer$13$1(swipeToDismissBoxStateRememberSwipeToDismissBoxState, dataStoreKt$rememberPreference$1$1RememberPreference3, mutableState37, musicDatabase6, syncUtils3, mutableState38, mutableStateRememberUpdatedState, (Continuation) null);
                                                        swipeToDismissBoxState = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                                                        gapComposer7.updateRememberedValue(playerKt$BottomSheetPlayer$13$1);
                                                        objRememberedValue35 = playerKt$BottomSheetPlayer$13$1;
                                                    } else {
                                                        swipeToDismissBoxState = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                                                        swipeToDismissBoxValue = currentValue;
                                                        neverEqualPolicy = neverEqualPolicy2;
                                                    }
                                                    Stack.LaunchedEffect(gapComposer7, swipeToDismissBoxValue, (Function2) objRememberedValue35);
                                                    boolean zChangedInstance3 = gapComposer7.changedInstance(playlistSong3);
                                                    Object objRememberedValue36 = gapComposer7.rememberedValue();
                                                    if (zChangedInstance3 || objRememberedValue36 == neverEqualPolicy) {
                                                        objRememberedValue36 = new ScrimBlurEffect$drawEffect$$inlined$withAlpha$1$1(snapshotStateList7, playlistSong3, b7);
                                                        gapComposer7.updateRememberedValue(objRememberedValue36);
                                                    }
                                                    final Function1 function4 = (Function1) objRememberedValue36;
                                                    final MutableState mutableState39 = mutableState31;
                                                    final MutableState mutableState40 = mutableState32;
                                                    final HapticFeedback hapticFeedback4 = hapticFeedback3;
                                                    final List list11 = list10;
                                                    final int i10 = iIntValue;
                                                    final State state6 = state4;
                                                    final PlayerConnection playerConnection6 = playerConnection5;
                                                    final MutableState mutableState41 = mutableState34;
                                                    final State state7 = state5;
                                                    final SnapshotStateList snapshotStateList8 = snapshotStateList7;
                                                    final MutableState mutableState42 = mutableState35;
                                                    final MutableState mutableState43 = mutableState36;
                                                    final MenuState menuState5 = menuState4;
                                                    final PlaylistSongSortType playlistSongSortType8 = playlistSongSortType7;
                                                    final boolean z13 = z12;
                                                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Expect_jvmKt.rememberComposableLambda(227958157, new Function2() { // from class: com.metrolist.music.ui.screens.playlist.LocalPlaylistScreenKt$LocalPlaylistScreen$13$1$1$3$1$content$1
                                                        @Override // kotlin.jvm.functions.Function2
                                                        public final Object invoke(Object obj13, Object obj14) {
                                                            NeverEqualPolicy neverEqualPolicy3;
                                                            Function1 function5;
                                                            Modifier modifier;
                                                            Composer composer4 = (Composer) obj13;
                                                            int iIntValue4 = ((Number) obj14).intValue();
                                                            GapComposer gapComposer8 = (GapComposer) composer4;
                                                            if (gapComposer8.shouldExecute(iIntValue4 & 1, (iIntValue4 & 3) != 2)) {
                                                                final PlaylistSong playlistSong4 = playlistSong3;
                                                                Song song = playlistSong4.song;
                                                                String str3 = song.song.id;
                                                                State state8 = state6;
                                                                MediaMetadata mediaMetadata = (MediaMetadata) state8.getValue();
                                                                boolean zAreEqual = Intrinsics.areEqual(str3, mediaMetadata != null ? mediaMetadata.id : null);
                                                                boolean zBooleanValue2 = ((Boolean) state7.getValue()).booleanValue();
                                                                Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f);
                                                                boolean zChangedInstance4 = gapComposer8.changedInstance(hapticFeedback4);
                                                                Function1 function6 = function4;
                                                                boolean zChanged10 = zChangedInstance4 | gapComposer8.changed(function6) | gapComposer8.changedInstance(playlistSong4);
                                                                List list12 = list11;
                                                                boolean zChangedInstance5 = zChanged10 | gapComposer8.changedInstance(list12) | gapComposer8.changed(i10);
                                                                Object objRememberedValue37 = gapComposer8.rememberedValue();
                                                                NeverEqualPolicy neverEqualPolicy4 = Composer.Companion.Empty;
                                                                if (zChangedInstance5 || objRememberedValue37 == neverEqualPolicy4) {
                                                                    neverEqualPolicy3 = neverEqualPolicy4;
                                                                    function5 = function6;
                                                                    modifier = modifierFillMaxWidth;
                                                                    OnlinePlaylistScreenKt$OnlinePlaylistScreen$4$1$1$2$4$1$1 onlinePlaylistScreenKt$OnlinePlaylistScreen$4$1$1$2$4$1$1 = new OnlinePlaylistScreenKt$OnlinePlaylistScreen$4$1$1$2$4$1$1(hapticFeedback4, function4, playlistSong4, i10, list12, snapshotStateList8, mutableState42, mutableState43, (byte) 1);
                                                                    gapComposer8.updateRememberedValue(onlinePlaylistScreenKt$OnlinePlaylistScreen$4$1$1$2$4$1$1);
                                                                    objRememberedValue37 = onlinePlaylistScreenKt$OnlinePlaylistScreen$4$1$1$2$4$1$1;
                                                                } else {
                                                                    modifier = modifierFillMaxWidth;
                                                                    function5 = function6;
                                                                    neverEqualPolicy3 = neverEqualPolicy4;
                                                                }
                                                                Function0 function7 = (Function0) objRememberedValue37;
                                                                boolean zChanged11 = gapComposer8.changed(function5) | gapComposer8.changedInstance(playlistSong4) | gapComposer8.changed(state8);
                                                                PlayerConnection playerConnection7 = playerConnection6;
                                                                boolean zChangedInstance6 = zChanged11 | gapComposer8.changedInstance(playerConnection7);
                                                                final MutableState mutableState44 = mutableState38;
                                                                boolean zChanged12 = zChangedInstance6 | gapComposer8.changed(mutableState44);
                                                                MutableState mutableState45 = mutableState41;
                                                                boolean zChanged13 = zChanged12 | gapComposer8.changed(mutableState45);
                                                                Object objRememberedValue38 = gapComposer8.rememberedValue();
                                                                if (zChanged13 || objRememberedValue38 == neverEqualPolicy3) {
                                                                    TopPlaylistScreenKt$TopPlaylistScreen$8$1$1$4$2$1 topPlaylistScreenKt$TopPlaylistScreen$8$1$1$4$2$1 = new TopPlaylistScreenKt$TopPlaylistScreen$8$1$1$4$2$1(function4, snapshotStateList8, playlistSong4, playerConnection7, mutableState42, state6, mutableState44, mutableState45);
                                                                    gapComposer8.updateRememberedValue(topPlaylistScreenKt$TopPlaylistScreen$8$1$1$4$2$1);
                                                                    objRememberedValue38 = topPlaylistScreenKt$TopPlaylistScreen$8$1$1$4$2$1;
                                                                }
                                                                Modifier modifierM48combinedClickablehoGz1lA$default = ImageKt.m48combinedClickablehoGz1lA$default(modifier, false, function7, (Function0) objRememberedValue38, 239);
                                                                final MutableState mutableState46 = mutableState39;
                                                                final MutableState mutableState47 = mutableState40;
                                                                final SnapshotStateList snapshotStateList9 = snapshotStateList8;
                                                                final Function1 function8 = function4;
                                                                final MenuState menuState6 = menuState5;
                                                                final PlaylistSongSortType playlistSongSortType9 = playlistSongSortType8;
                                                                final boolean z14 = z13;
                                                                final ReorderableCollectionItemScopeImpl reorderableCollectionItemScopeImpl2 = reorderableCollectionItemScopeImpl;
                                                                final MutableState mutableState48 = mutableState42;
                                                                MenuKt.SongListItem(song, modifierM48combinedClickablehoGz1lA$default, null, false, true, false, null, null, zAreEqual, zBooleanValue2, false, Expect_jvmKt.rememberComposableLambda(-385861879, new Function3() { // from class: com.metrolist.music.ui.screens.playlist.LocalPlaylistScreenKt$LocalPlaylistScreen$13$1$1$3$1$content$1.3
                                                                    @Override // kotlin.jvm.functions.Function3
                                                                    public final Object invoke(Object obj15, Object obj16, Object obj17) {
                                                                        Composer composer5 = (Composer) obj16;
                                                                        int iIntValue5 = ((Number) obj17).intValue();
                                                                        ((RowScope) obj15).getClass();
                                                                        GapComposer gapComposer9 = (GapComposer) composer5;
                                                                        if (gapComposer9.shouldExecute(iIntValue5 & 1, (iIntValue5 & 17) != 16)) {
                                                                            MutableState mutableState49 = mutableState48;
                                                                            boolean zLocalPlaylistScreen$lambda$21 = LocalPlaylistScreenKt.LocalPlaylistScreen$lambda$21(mutableState49);
                                                                            PlaylistSong playlistSong5 = playlistSong4;
                                                                            if (zLocalPlaylistScreen$lambda$21) {
                                                                                gapComposer9.startReplaceGroup(-1878693020);
                                                                                CardKt.Checkbox(snapshotStateList9.contains(Integer.valueOf(playlistSong5.map.id)), function8, null, false, null, gapComposer9, 0);
                                                                                gapComposer9.end(false);
                                                                            } else {
                                                                                gapComposer9.startReplaceGroup(-1878365474);
                                                                                MenuState menuState7 = menuState6;
                                                                                boolean zChanged14 = gapComposer9.changed(menuState7) | gapComposer9.changedInstance(playlistSong5);
                                                                                MutableState mutableState50 = mutableState44;
                                                                                boolean zChanged15 = zChanged14 | gapComposer9.changed(mutableState50);
                                                                                Object objRememberedValue39 = gapComposer9.rememberedValue();
                                                                                NeverEqualPolicy neverEqualPolicy5 = Composer.Companion.Empty;
                                                                                if (zChanged15 || objRememberedValue39 == neverEqualPolicy5) {
                                                                                    objRememberedValue39 = new AccountScreenKt$AccountScreen$1$1$11$1$1(menuState7, (Object) playlistSong5, (Object) mutableState50, (byte) 3);
                                                                                    gapComposer9.updateRememberedValue(objRememberedValue39);
                                                                                }
                                                                                CardKt.IconButton((Function0) objRememberedValue39, null, false, null, null, TopPlaylistScreenKt.lambda$1093025671, gapComposer9, 1572864, 62);
                                                                                GapComposer gapComposer10 = gapComposer9;
                                                                                if (playlistSongSortType9 != PlaylistSongSortType.CUSTOM || ((Boolean) mutableState46.getValue()).booleanValue() || ((Boolean) mutableState49.getValue()).booleanValue() || ((Boolean) mutableState47.getValue()).booleanValue() || !z14) {
                                                                                    gapComposer10.startReplaceGroup(-1876681895);
                                                                                    gapComposer10.end(false);
                                                                                } else {
                                                                                    gapComposer10.startReplaceGroup(-1877247924);
                                                                                    Object objRememberedValue40 = gapComposer10.rememberedValue();
                                                                                    if (objRememberedValue40 == neverEqualPolicy5) {
                                                                                        objRememberedValue40 = LocalPlaylistScreenKt$LocalPlaylistScreen$13$1$1$3$1$content$1$3$2$1.INSTANCE;
                                                                                        gapComposer10.updateRememberedValue(objRememberedValue40);
                                                                                    }
                                                                                    CardKt.IconButton((Function0) objRememberedValue40, Modifier.Companion.$$INSTANCE.then(new ComposedModifier(new ReorderableCollectionItemScopeImpl$draggableHandle$1(reorderableCollectionItemScopeImpl2, DragGestureDetector$Press.INSTANCE, ReorderableLazyCollectionState$findTargetItem$1.INSTANCE$1, Scroller$ScrollInfo$Companion$Null$1.INSTANCE$1))), false, null, null, TopPlaylistScreenKt.lambda$1521997836, gapComposer10, 1572870, 60);
                                                                                    gapComposer10 = gapComposer10;
                                                                                    gapComposer10.end(false);
                                                                                }
                                                                                gapComposer10.end(false);
                                                                            }
                                                                        } else {
                                                                            gapComposer9.skipToGroupEnd();
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                }, gapComposer8), null, gapComposer8, 24576, 384, 10732);
                                                            } else {
                                                                gapComposer8.skipToGroupEnd();
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    }, gapComposer7);
                                                    boolean zBooleanValue2 = ((Boolean) mutableState31.getValue()).booleanValue();
                                                    Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                                                    LazyItemScopeImpl lazyItemScopeImpl2 = lazyItemScopeImpl;
                                                    if (zBooleanValue2 || LocalPlaylistScreenKt.LocalPlaylistScreen$lambda$21(mutableState35) || !((Boolean) dataStoreKt$rememberPreference$1$1RememberPreference3.getValue()).booleanValue()) {
                                                        gapComposer7.startReplaceGroup(234329596);
                                                        Modifier modifierAnimateItem$default = LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl2, companion);
                                                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
                                                        int iHashCode2 = Long.hashCode(gapComposer7.compositeKeyHashCode);
                                                        PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer7.currentCompositionLocalScope();
                                                        Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer7, modifierAnimateItem$default);
                                                        ComposeUiNode.Companion.getClass();
                                                        gapComposer7.startReusableNode();
                                                        if (gapComposer7.inserting) {
                                                            gapComposer7.createNode(LayoutNode.Constructor);
                                                        } else {
                                                            gapComposer7.useNode();
                                                        }
                                                        Stack.m390setimpl(gapComposer7, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.SetMeasurePolicy);
                                                        Stack.m390setimpl(gapComposer7, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                                                        Stack.m390setimpl(gapComposer7, Integer.valueOf(iHashCode2), ComposeUiNode.Companion.SetCompositeKeyHash);
                                                        Stack.m389reconcileimpl(gapComposer7);
                                                        Stack.m390setimpl(gapComposer7, modifierMaterializeModifier2, ComposeUiNode.Companion.SetModifier);
                                                        composableLambdaImplRememberComposableLambda.invoke((Object) gapComposer7, (Object) 6);
                                                        gapComposer7.end(true);
                                                        gapComposer7.end(false);
                                                    } else {
                                                        gapComposer7.startReplaceGroup(234491726);
                                                        ScrimKt.SwipeToDismissBox(swipeToDismissBoxState, TopPlaylistScreenKt.f407lambda$965880408, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl2, companion), false, false, false, null, Expect_jvmKt.rememberComposableLambda(680189614, new QueueKt$Queue$5$4$1$1$4$1.AnonymousClass2(composableLambdaImplRememberComposableLambda, (byte) 1), gapComposer7), gapComposer7, 12582968, 120);
                                                        gapComposer7.end(false);
                                                    }
                                                } else {
                                                    gapComposer7.skipToGroupEnd();
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        }, gapComposer6), gapComposer6, (i9 & 14) | 1572864);
                                        gapComposer6.end(false);
                                    } else {
                                        gapComposer6.skipToGroupEnd();
                                    }
                                    return Unit.INSTANCE;
                                }
                            }));
                            return Unit.INSTANCE;
                        }
                    };
                    snackbarHostState = snackbarHostState2;
                    mutableState15 = mutableState21;
                    gapComposer2.updateRememberedValue(objRememberedValue10);
                } else {
                    mutableState15 = mutableState8;
                    snackbarHostState = snackbarHostState2;
                }
                GapComposer gapComposer6 = gapComposer2;
                LazyListState lazyListState2 = lazyListState;
                IntMath.LazyColumn(null, lazyListState2, insetsPaddingValuesAsPaddingValues2, null, null, null, false, null, (Function1) objRememberedValue10, gapComposer6, 0, 505);
                InsetsPaddingValues insetsPaddingValuesAsPaddingValues3 = OffsetKt.asPaddingValues(new UnionInsets((WindowInsets) gapComposer6.consume(providableCompositionLocal), OffsetKt.current(gapComposer6).ime), gapComposer6);
                Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                Modifier modifierPadding = OffsetKt.padding(companion, insetsPaddingValuesAsPaddingValues3);
                BiasAlignment biasAlignment = Alignment.Companion.CenterEnd;
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                DialogKt.m1466DraggableScrollbartao0HgU(lazyListState2, boxScopeInstance.align(modifierPadding, biasAlignment), 0L, 0L, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 0, 0, 2, gapComposer6, 0);
                navHostController2 = navHostController;
                boolean z7 = z3;
                MenuKt.m1493TopAppBarGHTll3U(Expect_jvmKt.rememberComposableLambda(967669844, new PlayerKt$$ExternalSyntheticLambda78(snapshotStateList, focusRequester, mutableState, mutableState2, mutableState12, state, mutableState9), gapComposer6), null, Expect_jvmKt.rememberComposableLambda(1181286930, new StatsScreenKt$$ExternalSyntheticLambda19(function0, mutableState12, mutableState, navHostController, mutableState2, (byte) 2), gapComposer6), Expect_jvmKt.rememberComposableLambda(646929993, new QueueMenuKt$$ExternalSyntheticLambda12((List) snapshotStateList, mutableState15, (Object) menuState, (Object) mutableState12, (Object) mutableState2, (Function) function0, (byte) 9), gapComposer6), CropImageView.DEFAULT_ASPECT_RATIO, null, null, null, gapComposer6, 3462, 242);
                GapComposer gapComposer7 = gapComposer6;
                WindowInsets windowInsets2 = (WindowInsets) gapComposer7.consume(providableCompositionLocal);
                WeakHashMap weakHashMap2 = WindowInsetsHolder.viewMap;
                ScrimKt.SnackbarHost(snackbarHostState, boxScopeInstance.align(OffsetKt.windowInsetsPadding(companion, new UnionInsets(windowInsets2, OffsetKt.current(gapComposer7).ime)), Alignment.Companion.BottomCenter), null, gapComposer7, 6, 4);
                gapComposer7.end(z7);
                localPlaylistViewModel2 = localPlaylistViewModel5;
                b = z7;
                gapComposer = gapComposer7;
            } else {
                function0 = function1;
            }
            List list8 = (List) mutableStateCollectAsStateWithLifecycle4.getValue();
            zChanged = gapComposer4.changed(mutableStateCollectAsStateWithLifecycle4);
            z = z6;
            objRememberedValue = gapComposer4.rememberedValue();
            if (zChanged) {
                objRememberedValue = new SyncUtils$createPlaylist$1.AnonymousClass1((Object) snapshotStateList5, (Object) mutableStateCollectAsStateWithLifecycle4, (Object) mutableState18, (Continuation) null, (byte) 15);
                playlistEntity = null;
                snapshotStateList = snapshotStateList5;
                mutableState3 = mutableState18;
                gapComposer4.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new SyncUtils$createPlaylist$1.AnonymousClass1((Object) snapshotStateList5, (Object) mutableStateCollectAsStateWithLifecycle4, (Object) mutableState18, (Continuation) null, (byte) 15);
                playlistEntity = null;
                snapshotStateList = snapshotStateList5;
                mutableState3 = mutableState18;
                gapComposer4.updateRememberedValue(objRememberedValue);
            }
            Stack.LaunchedEffect(gapComposer4, list8, (Function2) objRememberedValue);
            List list9 = (List) mutableStateCollectAsStateWithLifecycle4.getValue();
            zChanged2 = gapComposer4.changed(mutableStateCollectAsStateWithLifecycle4) | gapComposer4.changedInstance(downloadUtil);
            objRememberedValue2 = gapComposer4.rememberedValue();
            if (zChanged2) {
                objRememberedValue2 = new TopPlaylistScreenKt$TopPlaylistScreen$4$1(snapshotStateList4, downloadUtil, mutableStateCollectAsStateWithLifecycle4, parcelableSnapshotMutableIntState, null, (byte) 2);
                snapshotStateList2 = snapshotStateList4;
                mutableState4 = mutableStateCollectAsStateWithLifecycle4;
                gapComposer4.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new TopPlaylistScreenKt$TopPlaylistScreen$4$1(snapshotStateList4, downloadUtil, mutableStateCollectAsStateWithLifecycle4, parcelableSnapshotMutableIntState, null, (byte) 2);
                snapshotStateList2 = snapshotStateList4;
                mutableState4 = mutableStateCollectAsStateWithLifecycle4;
                gapComposer4.updateRememberedValue(objRememberedValue2);
            }
            Stack.LaunchedEffect(gapComposer4, list9, (Function2) objRememberedValue2);
            objRememberedValue3 = gapComposer4.rememberedValue();
            if (objRememberedValue3 == obj3) {
                objRememberedValue3 = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer4.updateRememberedValue(objRememberedValue3);
            }
            mutableState5 = (MutableState) objRememberedValue3;
            if (((Boolean) mutableState5.getValue()).booleanValue()) {
                gapComposer4.startReplaceGroup(-1202846259);
                playlist = (Playlist) mutableStateCollectAsStateWithLifecycle3.getValue();
                if (playlist != null) {
                    playlistEntity2 = playlist.playlist;
                } else {
                    playlistEntity2 = playlistEntity;
                }
                if (playlistEntity2 == null) {
                    gapComposer4.startReplaceGroup(1366471636);
                    z5 = false;
                    gapComposer4.end(false);
                    musicDatabase = musicDatabase3;
                    mutableState6 = mutableStateCollectAsStateWithLifecycle5;
                    obj2 = obj3;
                    mimesKt$$ExternalSyntheticLambda0 = mimesKt$$ExternalSyntheticLambda2;
                    b2 = 23;
                    gapComposer3 = gapComposer4;
                } else {
                    gapComposer4.startReplaceGroup(1366471637);
                    String str2 = playlistEntity2.name;
                    int length2 = str2.length();
                    TextFieldValue textFieldValue2 = new TextFieldValue(4, TextRangeKt.TextRange(length2, length2), str2);
                    ComposableLambdaImpl composableLambdaImpl3 = TopPlaylistScreenKt.lambda$1599347233;
                    ComposableLambdaImpl composableLambdaImpl4 = TopPlaylistScreenKt.lambda$1768598818;
                    zChangedInstance = gapComposer4.changedInstance(musicDatabase3) | gapComposer4.changed(playlistEntity2) | gapComposer4.changedInstance(localPlaylistViewModel3);
                    objRememberedValue13 = gapComposer4.rememberedValue();
                    if (zChangedInstance) {
                        b3 = 23;
                        objRememberedValue13 = new MainActivity$$ExternalSyntheticLambda21(musicDatabase3, (Object) localPlaylistViewModel3, (Object) playlistEntity2, b3);
                        gapComposer4.updateRememberedValue(objRememberedValue13);
                    } else {
                        b3 = 23;
                        objRememberedValue13 = new MainActivity$$ExternalSyntheticLambda21(musicDatabase3, (Object) localPlaylistViewModel3, (Object) playlistEntity2, b3);
                        gapComposer4.updateRememberedValue(objRememberedValue13);
                    }
                    Function1 function4 = (Function1) objRememberedValue13;
                    objRememberedValue14 = gapComposer4.rememberedValue();
                    if (objRememberedValue14 == obj3) {
                        objRememberedValue14 = new LibrarySongsScreenKt$$ExternalSyntheticLambda17(mutableState5, (byte) 7);
                        gapComposer4.updateRememberedValue(objRememberedValue14);
                    }
                    Function0 function5 = (Function0) objRememberedValue14;
                    mimesKt$$ExternalSyntheticLambda0 = mimesKt$$ExternalSyntheticLambda2;
                    mutableState6 = mutableStateCollectAsStateWithLifecycle5;
                    b2 = b3;
                    musicDatabase = musicDatabase3;
                    obj2 = obj3;
                    DialogKt.m1470TextFieldDialog5RwOfIE(null, composableLambdaImpl3, composableLambdaImpl4, textFieldValue2, false, false, 0, null, 0, function4, null, null, null, function5, false, null, gapComposer4, 432, 24576, 113649);
                    GapComposer gapComposer8 = gapComposer4;
                    z5 = false;
                    gapComposer8.end(false);
                    gapComposer3 = gapComposer8;
                }
                gapComposer3.end(z5);
                gapComposer2 = gapComposer3;
            } else {
                snapshotStateList2 = snapshotStateList2;
                mutableState16 = mutableState16;
                musicDatabase = musicDatabase3;
                mutableState6 = mutableStateCollectAsStateWithLifecycle5;
                obj2 = obj3;
                mimesKt$$ExternalSyntheticLambda0 = mimesKt$$ExternalSyntheticLambda2;
                zBooleanValue = zBooleanValue;
                menuState = menuState;
                b2 = 23;
                gapComposer4.startReplaceGroup(1367610608);
                gapComposer4.end(false);
                gapComposer2 = gapComposer4;
            }
            objRememberedValue4 = gapComposer2.rememberedValue();
            if (objRememberedValue4 == obj2) {
                objRememberedValue4 = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer2.updateRememberedValue(objRememberedValue4);
            }
            mutableState7 = (MutableState) objRememberedValue4;
            if (((Boolean) mutableState7.getValue()).booleanValue()) {
                gapComposer2.startReplaceGroup(1367779434);
                objRememberedValue12 = gapComposer2.rememberedValue();
                if (objRememberedValue12 == obj2) {
                    objRememberedValue12 = new LibrarySongsScreenKt$$ExternalSyntheticLambda17(mutableState7, (byte) 8);
                    gapComposer2.updateRememberedValue(objRememberedValue12);
                }
                MutableState mutableState110 = mutableState4;
                mutableState9 = mutableStateCollectAsStateWithLifecycle3;
                mutableState8 = mutableState110;
                DialogKt.DefaultDialog((Function0) objRememberedValue12, null, null, null, Expect_jvmKt.rememberComposableLambda(-1568133321, new AlbumMenuKt$$ExternalSyntheticLambda16(context, mutableStateCollectAsStateWithLifecycle3, mutableState110, mutableState7, musicDatabase, z), gapComposer2), null, Expect_jvmKt.rememberComposableLambda(-746677619, new QueueKt$$ExternalSyntheticLambda21(mutableState9, (byte) 22), gapComposer2), gapComposer2, 1597446, 46);
                z2 = false;
                gapComposer2.end(false);
            } else {
                z2 = false;
                mutableState8 = mutableState4;
                mutableState9 = mutableStateCollectAsStateWithLifecycle3;
                gapComposer2.startReplaceGroup(1369322800);
                gapComposer2.end(false);
            }
            objRememberedValue5 = gapComposer2.rememberedValue();
            if (objRememberedValue5 == obj2) {
                objRememberedValue5 = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer2.updateRememberedValue(objRememberedValue5);
            }
            mutableState10 = (MutableState) objRememberedValue5;
            if (((Boolean) mutableState10.getValue()).booleanValue()) {
                gapComposer2.startReplaceGroup(1369485519);
                objRememberedValue11 = gapComposer2.rememberedValue();
                if (objRememberedValue11 == obj2) {
                    objRememberedValue11 = new LibrarySongsScreenKt$$ExternalSyntheticLambda17(mutableState10, (byte) 9);
                    gapComposer2.updateRememberedValue(objRememberedValue11);
                }
                continuation = null;
                byte b7 = b2;
                localPlaylistViewModel4 = localPlaylistViewModel3;
                mutableState11 = mutableState10;
                mutableState12 = mutableState16;
                DialogKt.DefaultDialog((Function0) objRememberedValue11, null, null, null, Expect_jvmKt.rememberComposableLambda(1832899064, new QueueMenuKt$$ExternalSyntheticLambda9(mutableState9, mutableState10, navHostController, musicDatabase, localPlaylistViewModel4), gapComposer2), null, Expect_jvmKt.rememberComposableLambda(-1640612530, new QueueKt$$ExternalSyntheticLambda21(mutableState9, b7), gapComposer2), gapComposer2, 1597446, 46);
                gapComposer2.end(z2);
            } else {
                localPlaylistViewModel4 = localPlaylistViewModel3;
                mutableState11 = mutableState10;
                mutableState12 = mutableState16;
                continuation = null;
                gapComposer2.startReplaceGroup(1370870320);
                gapComposer2.end(z2);
            }
            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(gapComposer2);
            objRememberedValue6 = gapComposer2.rememberedValue();
            if (objRememberedValue6 == obj2) {
                objRememberedValue6 = Stack.mutableStateOf$default(continuation);
                gapComposer2.updateRememberedValue(objRememberedValue6);
            }
            mutableState13 = (MutableState) objRememberedValue6;
            ProvidableCompositionLocal providableCompositionLocal2 = MainActivityKt.LocalPlayerAwareWindowInsets;
            InsetsPaddingValues insetsPaddingValuesAsPaddingValues4 = OffsetKt.asPaddingValues((WindowInsets) gapComposer2.consume(providableCompositionLocal2), gapComposer2);
            objRememberedValue7 = gapComposer2.rememberedValue();
            if (objRememberedValue7 == obj2) {
                objRememberedValue7 = new QueueKt$Queue$5$reorderableState$1$1(snapshotStateList2, mutableState13, continuation, (byte) 1);
                gapComposer2.updateRememberedValue(objRememberedValue7);
            }
            reorderableLazyListStateM1880rememberReorderableLazyListStateTN_CM5M = CharsKt.m1880rememberReorderableLazyListStateTN_CM5M(lazyListStateRememberLazyListState, insetsPaddingValuesAsPaddingValues4, (Function4) objRememberedValue7, gapComposer2, 12);
            Boolean boolValueOf3 = Boolean.valueOf(reorderableLazyListStateM1880rememberReorderableLazyListStateTN_CM5M.isAnyItemDragging());
            zChanged3 = gapComposer2.changed(reorderableLazyListStateM1880rememberReorderableLazyListStateTN_CM5M) | gapComposer2.changedInstance(localPlaylistViewModel4) | gapComposer2.changedInstance(musicDatabase);
            objRememberedValue8 = gapComposer2.rememberedValue();
            if (zChanged3) {
                LocalPlaylistViewModel localPlaylistViewModel7 = localPlaylistViewModel4;
                reorderableLazyListState = reorderableLazyListStateM1880rememberReorderableLazyListStateTN_CM5M;
                z3 = true;
                musicDatabase2 = musicDatabase;
                lazyListState = lazyListStateRememberLazyListState;
                Object queueKt$Queue$5$1$2 = new QueueKt$Queue$5$1$1(reorderableLazyListState, mutableState13, localPlaylistViewModel7, musicDatabase2, null, (byte) 7);
                localPlaylistViewModel5 = localPlaylistViewModel7;
                gapComposer2.updateRememberedValue(queueKt$Queue$5$1$2);
                objRememberedValue8 = queueKt$Queue$5$1$2;
            } else {
                LocalPlaylistViewModel localPlaylistViewModel8 = localPlaylistViewModel4;
                reorderableLazyListState = reorderableLazyListStateM1880rememberReorderableLazyListStateTN_CM5M;
                z3 = true;
                musicDatabase2 = musicDatabase;
                lazyListState = lazyListStateRememberLazyListState;
                Object queueKt$Queue$5$1$3 = new QueueKt$Queue$5$1$1(reorderableLazyListState, mutableState13, localPlaylistViewModel8, musicDatabase2, null, (byte) 7);
                localPlaylistViewModel5 = localPlaylistViewModel8;
                gapComposer2.updateRememberedValue(queueKt$Queue$5$1$3);
                objRememberedValue8 = queueKt$Queue$5$1$3;
            }
            Stack.LaunchedEffect(gapComposer2, boolValueOf3, (Function2) objRememberedValue8);
            objRememberedValue9 = gapComposer2.rememberedValue();
            if (objRememberedValue9 == obj2) {
                objRememberedValue9 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new LazyListKt$$ExternalSyntheticLambda0(lazyListState, (byte) 6));
                gapComposer2.updateRememberedValue(objRememberedValue9);
            }
            State state2 = (State) objRememberedValue9;
            FillElement fillElement2 = SizeKt.FillWholeMaxSize;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
            int iHashCode2 = Long.hashCode(gapComposer2.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer2, fillElement2);
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
            WindowInsets windowInsets3 = (WindowInsets) gapComposer2.consume(providableCompositionLocal2);
            WeakHashMap weakHashMap3 = WindowInsetsHolder.viewMap;
            InsetsPaddingValues insetsPaddingValuesAsPaddingValues5 = OffsetKt.asPaddingValues(new UnionInsets(windowInsets3, OffsetKt.current(gapComposer2).ime), gapComposer2);
            mutableState14 = mutableState6;
            z4 = zBooleanValue;
            snapshotStateList3 = snapshotStateList2;
            mimesKt$$ExternalSyntheticLambda1 = mimesKt$$ExternalSyntheticLambda0;
            zChanged4 = gapComposer2.changed(mutableState9) | gapComposer2.changed(mutableState12) | gapComposer2.changed(mutableState8) | gapComposer2.changed(mutableState14) | gapComposer2.changed(playlistSongSortType.ordinal()) | gapComposer2.changed(z4) | gapComposer2.changed(renderScriptBlurEffect$updateSurface$2$4) | gapComposer2.changed(mimesKt$$ExternalSyntheticLambda1) | gapComposer2.changed(z) | gapComposer2.changed(dataStoreKt$rememberPreference$1$1RememberPreference2) | gapComposer2.changedInstance(list5) | gapComposer2.changed(reorderableLazyListState) | gapComposer2.changedInstance(musicDatabase2) | gapComposer2.changedInstance(syncUtils) | gapComposer2.changed(mutableStateCollectAsStateWithLifecycle2) | gapComposer2.changed(mutableStateCollectAsStateWithLifecycle) | gapComposer2.changedInstance(hapticFeedback) | gapComposer2.changedInstance(playerConnection) | gapComposer2.changed(menuState);
            objRememberedValue10 = gapComposer2.rememberedValue();
            if (zChanged4) {
                final MutableState mutableState23 = mutableState9;
                final MutableState mutableState24 = mutableState8;
                final ReorderableLazyListState reorderableLazyListState3 = reorderableLazyListState;
                final PlaylistSongSortType playlistSongSortType5 = playlistSongSortType;
                final MenuState menuState3 = menuState;
                final MusicDatabase musicDatabase5 = musicDatabase2;
                final MutableState mutableState25 = mutableState12;
                objRememberedValue10 = new Function1() { // from class: com.metrolist.music.ui.screens.playlist.LocalPlaylistScreenKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj4) {
                        final PlaylistSongSortType playlistSongSortType6;
                        boolean z8;
                        MutableState mutableState26;
                        boolean z9;
                        int i7;
                        String str3;
                        Integer num;
                        LazyListIntervalContent lazyListIntervalContent = (LazyListIntervalContent) obj4;
                        lazyListIntervalContent.getClass();
                        final MutableState mutableState27 = mutableState23;
                        Playlist playlist3 = (Playlist) mutableState27.getValue();
                        final MutableState mutableState28 = mutableState25;
                        final MutableState mutableState29 = mutableState24;
                        PlaylistSongSortType playlistSongSortType7 = playlistSongSortType5;
                        boolean z10 = z;
                        MutableState mutableState210 = dataStoreKt$rememberPreference$1$1RememberPreference2;
                        if (playlist3 == null) {
                            playlistSongSortType6 = playlistSongSortType7;
                            z8 = z10;
                            mutableState26 = mutableState210;
                            mutableState28 = mutableState28;
                            z9 = true;
                        } else if (playlist3.songCount == 0 && (num = playlist3.playlist.remoteSongCount) != null && num.intValue() == 0) {
                            LazyListIntervalContent.item$default(lazyListIntervalContent, "empty_placeholder", null, TopPlaylistScreenKt.f399lambda$412743085, 2);
                            playlistSongSortType6 = playlistSongSortType7;
                            z8 = z10;
                            mutableState26 = mutableState210;
                            mutableState28 = mutableState28;
                            z9 = true;
                        } else {
                            if (((Boolean) mutableState28.getValue()).booleanValue()) {
                                i7 = 2;
                                str3 = null;
                            } else {
                                ComposableLambdaImpl composableLambdaImpl5 = new ComposableLambdaImpl(true, 1700853551, new AlbumMenuKt$$ExternalSyntheticLambda20(playlist3, mutableState28, snackbarHostState2, mutableState29, mutableState14, mutableState5, mutableState7, mutableState11));
                                i7 = 2;
                                str3 = null;
                                LazyListIntervalContent.item$default(lazyListIntervalContent, "playlist_header", null, composableLambdaImpl5, 2);
                            }
                            z8 = z10;
                            mutableState26 = mutableState210;
                            z9 = true;
                            playlistSongSortType6 = playlistSongSortType7;
                            LazyListIntervalContent.item$default(lazyListIntervalContent, "controls_row", str3, new ComposableLambdaImpl(true, 2122362666, new HomeScreenKt$$ExternalSyntheticLambda40(playlistSongSortType7, z4, renderScriptBlurEffect$updateSurface$2$4, mimesKt$$ExternalSyntheticLambda1, z8, mutableState26)), i7);
                        }
                        final List list10 = ((Boolean) mutableState28.getValue()).booleanValue() ? list5 : snapshotStateList3;
                        TopPlaylistScreenKt$$ExternalSyntheticLambda8 topPlaylistScreenKt$$ExternalSyntheticLambda8 = new TopPlaylistScreenKt$$ExternalSyntheticLambda8((byte) 7);
                        int size3 = list10.size();
                        ScrimBlurEffect$drawEffect$$inlined$withAlpha$1$1 scrimBlurEffect$drawEffect$$inlined$withAlpha$1$1 = new ScrimBlurEffect$drawEffect$$inlined$withAlpha$1$1(topPlaylistScreenKt$$ExternalSyntheticLambda8, list10, (byte) 3);
                        AlarmSettingsKt$AlarmEditorDialog$lambda$27$0$0$$inlined$items$default$3 alarmSettingsKt$AlarmEditorDialog$lambda$27$0$0$$inlined$items$default$3 = new AlarmSettingsKt$AlarmEditorDialog$lambda$27$0$0$$inlined$items$default$3(list10, (byte) 7);
                        boolean z11 = z9;
                        final ReorderableLazyListState reorderableLazyListState4 = reorderableLazyListState3;
                        final MusicDatabase musicDatabase6 = musicDatabase5;
                        final SyncUtils syncUtils2 = syncUtils;
                        final SnapshotStateList snapshotStateList6 = snapshotStateList;
                        final HapticFeedback hapticFeedback2 = hapticFeedback;
                        final State state3 = mutableStateCollectAsStateWithLifecycle2;
                        final PlayerConnection playerConnection4 = playerConnection;
                        final State state4 = mutableStateCollectAsStateWithLifecycle;
                        final MutableState mutableState211 = mutableState2;
                        final MutableState mutableState212 = mutableState3;
                        final MenuState menuState4 = menuState3;
                        final List list11 = list10;
                        final MutableState mutableState30 = mutableState26;
                        final boolean z12 = z8;
                        lazyListIntervalContent.items(size3, scrimBlurEffect$drawEffect$$inlined$withAlpha$1$1, alarmSettingsKt$AlarmEditorDialog$lambda$27$0$0$$inlined$items$default$3, new ComposableLambdaImpl(z11, 2039820996, new Function4() { // from class: com.metrolist.music.ui.screens.playlist.LocalPlaylistScreenKt$LocalPlaylistScreen$lambda$57$0$0$$inlined$itemsIndexed$default$3
                            @Override // kotlin.jvm.functions.Function4
                            public final Object invoke(Object obj5, Object obj6, Object obj7, Object obj8) {
                                int i8;
                                final LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj5;
                                final int iIntValue = ((Number) obj6).intValue();
                                Composer composer2 = (Composer) obj7;
                                int iIntValue2 = ((Number) obj8).intValue();
                                if ((iIntValue2 & 6) == 0) {
                                    i8 = (((GapComposer) composer2).changed(lazyItemScopeImpl) ? 4 : 2) | iIntValue2;
                                } else {
                                    i8 = iIntValue2;
                                }
                                if ((iIntValue2 & 48) == 0) {
                                    i8 |= ((GapComposer) composer2).changed(iIntValue) ? 32 : 16;
                                }
                                int i9 = i8;
                                GapComposer gapComposer9 = (GapComposer) composer2;
                                if (gapComposer9.shouldExecute(i9 & 1, (i9 & 147) != 146)) {
                                    final PlaylistSong playlistSong2 = (PlaylistSong) list10.get(iIntValue);
                                    gapComposer9.startReplaceGroup(-1047776051);
                                    Integer numValueOf = Integer.valueOf(playlistSong2.map.id);
                                    final MutableState mutableState31 = mutableState30;
                                    final MutableState mutableState32 = mutableState28;
                                    final MutableState mutableState33 = mutableState27;
                                    final MusicDatabase musicDatabase7 = musicDatabase6;
                                    final SyncUtils syncUtils3 = syncUtils2;
                                    final SnapshotStateList snapshotStateList7 = snapshotStateList6;
                                    final HapticFeedback hapticFeedback3 = hapticFeedback2;
                                    final List list12 = list11;
                                    final State state5 = state3;
                                    final PlayerConnection playerConnection5 = playerConnection4;
                                    final MutableState mutableState34 = mutableState29;
                                    final State state6 = state4;
                                    final MutableState mutableState35 = mutableState211;
                                    final MutableState mutableState36 = mutableState212;
                                    final MenuState menuState5 = menuState4;
                                    final PlaylistSongSortType playlistSongSortType8 = playlistSongSortType6;
                                    final boolean z13 = z12;
                                    CharsKt.ReorderableItem(lazyItemScopeImpl, reorderableLazyListState4, numValueOf, null, false, null, Expect_jvmKt.rememberComposableLambda(137257390, new Function4() { // from class: com.metrolist.music.ui.screens.playlist.LocalPlaylistScreenKt$LocalPlaylistScreen$13$1$1$3$1
                                        @Override // kotlin.jvm.functions.Function4
                                        public final Object invoke(Object obj9, Object obj10, Object obj11, Object obj12) {
                                            SwipeToDismissBoxValue swipeToDismissBoxValue;
                                            NeverEqualPolicy neverEqualPolicy;
                                            SwipeToDismissBoxState swipeToDismissBoxState;
                                            final ReorderableCollectionItemScopeImpl reorderableCollectionItemScopeImpl = (ReorderableCollectionItemScopeImpl) obj9;
                                            ((Boolean) obj10).getClass();
                                            Composer composer3 = (Composer) obj11;
                                            int iIntValue3 = ((Number) obj12).intValue();
                                            reorderableCollectionItemScopeImpl.getClass();
                                            byte b8 = 2;
                                            if ((iIntValue3 & 6) == 0) {
                                                iIntValue3 |= ((GapComposer) composer3).changed(reorderableCollectionItemScopeImpl) ? 4 : 2;
                                            }
                                            GapComposer gapComposer10 = (GapComposer) composer3;
                                            if (gapComposer10.shouldExecute(iIntValue3 & 1, (iIntValue3 & 131) != 130)) {
                                                final PlaylistSong playlistSong3 = playlistSong2;
                                                MutableState mutableStateRememberUpdatedState = Stack.rememberUpdatedState(playlistSong3, gapComposer10);
                                                Preferences$Key preferences$Key3 = PreferenceKeysKt.SwipeToRemoveSongKey;
                                                Boolean bool2 = Boolean.FALSE;
                                                DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference3 = com.metrolist.music.utils.UtilsKt.rememberPreference(preferences$Key3, bool2, gapComposer10, 48);
                                                Object objRememberedValue33 = gapComposer10.rememberedValue();
                                                NeverEqualPolicy neverEqualPolicy2 = Composer.Companion.Empty;
                                                if (objRememberedValue33 == neverEqualPolicy2) {
                                                    objRememberedValue33 = CachePlaylistScreenKt$CachePlaylistScreen$sortedSongs$1$sorted$3$1.INSTANCE$1;
                                                    gapComposer10.updateRememberedValue(objRememberedValue33);
                                                }
                                                SwipeToDismissBoxState swipeToDismissBoxStateRememberSwipeToDismissBoxState = ScrimKt.rememberSwipeToDismissBoxState((Function1) objRememberedValue33, gapComposer10);
                                                Object objRememberedValue34 = gapComposer10.rememberedValue();
                                                if (objRememberedValue34 == neverEqualPolicy2) {
                                                    objRememberedValue34 = Stack.mutableStateOf$default(bool2);
                                                    gapComposer10.updateRememberedValue(objRememberedValue34);
                                                }
                                                MutableState mutableState37 = (MutableState) objRememberedValue34;
                                                SwipeToDismissBoxValue currentValue = swipeToDismissBoxStateRememberSwipeToDismissBoxState.getCurrentValue();
                                                boolean zChangedInstance2 = gapComposer10.changedInstance(swipeToDismissBoxStateRememberSwipeToDismissBoxState) | gapComposer10.changed(dataStoreKt$rememberPreference$1$1RememberPreference3);
                                                final MutableState mutableState38 = mutableState33;
                                                boolean zChanged9 = zChangedInstance2 | gapComposer10.changed(mutableState38) | gapComposer10.changed(mutableStateRememberUpdatedState) | gapComposer10.changedInstance(musicDatabase7) | gapComposer10.changedInstance(syncUtils3);
                                                Object objRememberedValue35 = gapComposer10.rememberedValue();
                                                if (zChanged9 || objRememberedValue35 == neverEqualPolicy2) {
                                                    swipeToDismissBoxValue = currentValue;
                                                    neverEqualPolicy = neverEqualPolicy2;
                                                    PlayerKt$BottomSheetPlayer$13$1 playerKt$BottomSheetPlayer$13$1 = new PlayerKt$BottomSheetPlayer$13$1(swipeToDismissBoxStateRememberSwipeToDismissBoxState, dataStoreKt$rememberPreference$1$1RememberPreference3, mutableState37, musicDatabase7, syncUtils3, mutableState38, mutableStateRememberUpdatedState, (Continuation) null);
                                                    swipeToDismissBoxState = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                                                    gapComposer10.updateRememberedValue(playerKt$BottomSheetPlayer$13$1);
                                                    objRememberedValue35 = playerKt$BottomSheetPlayer$13$1;
                                                } else {
                                                    swipeToDismissBoxState = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                                                    swipeToDismissBoxValue = currentValue;
                                                    neverEqualPolicy = neverEqualPolicy2;
                                                }
                                                Stack.LaunchedEffect(gapComposer10, swipeToDismissBoxValue, (Function2) objRememberedValue35);
                                                boolean zChangedInstance3 = gapComposer10.changedInstance(playlistSong3);
                                                Object objRememberedValue36 = gapComposer10.rememberedValue();
                                                if (zChangedInstance3 || objRememberedValue36 == neverEqualPolicy) {
                                                    objRememberedValue36 = new ScrimBlurEffect$drawEffect$$inlined$withAlpha$1$1(snapshotStateList7, playlistSong3, b8);
                                                    gapComposer10.updateRememberedValue(objRememberedValue36);
                                                }
                                                final Function1 function6 = (Function1) objRememberedValue36;
                                                final MutableState mutableState39 = mutableState31;
                                                final MutableState mutableState40 = mutableState32;
                                                final HapticFeedback hapticFeedback4 = hapticFeedback3;
                                                final List list13 = list12;
                                                final int i10 = iIntValue;
                                                final State state7 = state5;
                                                final PlayerConnection playerConnection6 = playerConnection5;
                                                final MutableState mutableState41 = mutableState34;
                                                final State state8 = state6;
                                                final SnapshotStateList snapshotStateList8 = snapshotStateList7;
                                                final MutableState mutableState42 = mutableState35;
                                                final MutableState mutableState43 = mutableState36;
                                                final MenuState menuState6 = menuState5;
                                                final PlaylistSongSortType playlistSongSortType9 = playlistSongSortType8;
                                                final boolean z14 = z13;
                                                ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Expect_jvmKt.rememberComposableLambda(227958157, new Function2() { // from class: com.metrolist.music.ui.screens.playlist.LocalPlaylistScreenKt$LocalPlaylistScreen$13$1$1$3$1$content$1
                                                    @Override // kotlin.jvm.functions.Function2
                                                    public final Object invoke(Object obj13, Object obj14) {
                                                        NeverEqualPolicy neverEqualPolicy3;
                                                        Function1 function7;
                                                        Modifier modifier;
                                                        Composer composer4 = (Composer) obj13;
                                                        int iIntValue4 = ((Number) obj14).intValue();
                                                        GapComposer gapComposer11 = (GapComposer) composer4;
                                                        if (gapComposer11.shouldExecute(iIntValue4 & 1, (iIntValue4 & 3) != 2)) {
                                                            final PlaylistSong playlistSong4 = playlistSong3;
                                                            Song song = playlistSong4.song;
                                                            String str4 = song.song.id;
                                                            State state9 = state7;
                                                            MediaMetadata mediaMetadata = (MediaMetadata) state9.getValue();
                                                            boolean zAreEqual = Intrinsics.areEqual(str4, mediaMetadata != null ? mediaMetadata.id : null);
                                                            boolean zBooleanValue2 = ((Boolean) state8.getValue()).booleanValue();
                                                            Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f);
                                                            boolean zChangedInstance4 = gapComposer11.changedInstance(hapticFeedback4);
                                                            Function1 function8 = function6;
                                                            boolean zChanged10 = zChangedInstance4 | gapComposer11.changed(function8) | gapComposer11.changedInstance(playlistSong4);
                                                            List list14 = list13;
                                                            boolean zChangedInstance5 = zChanged10 | gapComposer11.changedInstance(list14) | gapComposer11.changed(i10);
                                                            Object objRememberedValue37 = gapComposer11.rememberedValue();
                                                            NeverEqualPolicy neverEqualPolicy4 = Composer.Companion.Empty;
                                                            if (zChangedInstance5 || objRememberedValue37 == neverEqualPolicy4) {
                                                                neverEqualPolicy3 = neverEqualPolicy4;
                                                                function7 = function8;
                                                                modifier = modifierFillMaxWidth;
                                                                OnlinePlaylistScreenKt$OnlinePlaylistScreen$4$1$1$2$4$1$1 onlinePlaylistScreenKt$OnlinePlaylistScreen$4$1$1$2$4$1$1 = new OnlinePlaylistScreenKt$OnlinePlaylistScreen$4$1$1$2$4$1$1(hapticFeedback4, function6, playlistSong4, i10, list14, snapshotStateList8, mutableState42, mutableState43, (byte) 1);
                                                                gapComposer11.updateRememberedValue(onlinePlaylistScreenKt$OnlinePlaylistScreen$4$1$1$2$4$1$1);
                                                                objRememberedValue37 = onlinePlaylistScreenKt$OnlinePlaylistScreen$4$1$1$2$4$1$1;
                                                            } else {
                                                                modifier = modifierFillMaxWidth;
                                                                function7 = function8;
                                                                neverEqualPolicy3 = neverEqualPolicy4;
                                                            }
                                                            Function0 function9 = (Function0) objRememberedValue37;
                                                            boolean zChanged11 = gapComposer11.changed(function7) | gapComposer11.changedInstance(playlistSong4) | gapComposer11.changed(state9);
                                                            PlayerConnection playerConnection7 = playerConnection6;
                                                            boolean zChangedInstance6 = zChanged11 | gapComposer11.changedInstance(playerConnection7);
                                                            final MutableState mutableState44 = mutableState38;
                                                            boolean zChanged12 = zChangedInstance6 | gapComposer11.changed(mutableState44);
                                                            MutableState mutableState45 = mutableState41;
                                                            boolean zChanged13 = zChanged12 | gapComposer11.changed(mutableState45);
                                                            Object objRememberedValue38 = gapComposer11.rememberedValue();
                                                            if (zChanged13 || objRememberedValue38 == neverEqualPolicy3) {
                                                                TopPlaylistScreenKt$TopPlaylistScreen$8$1$1$4$2$1 topPlaylistScreenKt$TopPlaylistScreen$8$1$1$4$2$1 = new TopPlaylistScreenKt$TopPlaylistScreen$8$1$1$4$2$1(function6, snapshotStateList8, playlistSong4, playerConnection7, mutableState42, state7, mutableState44, mutableState45);
                                                                gapComposer11.updateRememberedValue(topPlaylistScreenKt$TopPlaylistScreen$8$1$1$4$2$1);
                                                                objRememberedValue38 = topPlaylistScreenKt$TopPlaylistScreen$8$1$1$4$2$1;
                                                            }
                                                            Modifier modifierM48combinedClickablehoGz1lA$default = ImageKt.m48combinedClickablehoGz1lA$default(modifier, false, function9, (Function0) objRememberedValue38, 239);
                                                            final MutableState mutableState46 = mutableState39;
                                                            final MutableState mutableState47 = mutableState40;
                                                            final SnapshotStateList snapshotStateList9 = snapshotStateList8;
                                                            final Function1 function10 = function6;
                                                            final MenuState menuState7 = menuState6;
                                                            final PlaylistSongSortType playlistSongSortType10 = playlistSongSortType9;
                                                            final boolean z15 = z14;
                                                            final ReorderableCollectionItemScopeImpl reorderableCollectionItemScopeImpl2 = reorderableCollectionItemScopeImpl;
                                                            final MutableState mutableState48 = mutableState42;
                                                            MenuKt.SongListItem(song, modifierM48combinedClickablehoGz1lA$default, null, false, true, false, null, null, zAreEqual, zBooleanValue2, false, Expect_jvmKt.rememberComposableLambda(-385861879, new Function3() { // from class: com.metrolist.music.ui.screens.playlist.LocalPlaylistScreenKt$LocalPlaylistScreen$13$1$1$3$1$content$1.3
                                                                @Override // kotlin.jvm.functions.Function3
                                                                public final Object invoke(Object obj15, Object obj16, Object obj17) {
                                                                    Composer composer5 = (Composer) obj16;
                                                                    int iIntValue5 = ((Number) obj17).intValue();
                                                                    ((RowScope) obj15).getClass();
                                                                    GapComposer gapComposer12 = (GapComposer) composer5;
                                                                    if (gapComposer12.shouldExecute(iIntValue5 & 1, (iIntValue5 & 17) != 16)) {
                                                                        MutableState mutableState49 = mutableState48;
                                                                        boolean zLocalPlaylistScreen$lambda$21 = LocalPlaylistScreenKt.LocalPlaylistScreen$lambda$21(mutableState49);
                                                                        PlaylistSong playlistSong5 = playlistSong4;
                                                                        if (zLocalPlaylistScreen$lambda$21) {
                                                                            gapComposer12.startReplaceGroup(-1878693020);
                                                                            CardKt.Checkbox(snapshotStateList9.contains(Integer.valueOf(playlistSong5.map.id)), function10, null, false, null, gapComposer12, 0);
                                                                            gapComposer12.end(false);
                                                                        } else {
                                                                            gapComposer12.startReplaceGroup(-1878365474);
                                                                            MenuState menuState8 = menuState7;
                                                                            boolean zChanged14 = gapComposer12.changed(menuState8) | gapComposer12.changedInstance(playlistSong5);
                                                                            MutableState mutableState50 = mutableState44;
                                                                            boolean zChanged15 = zChanged14 | gapComposer12.changed(mutableState50);
                                                                            Object objRememberedValue39 = gapComposer12.rememberedValue();
                                                                            NeverEqualPolicy neverEqualPolicy5 = Composer.Companion.Empty;
                                                                            if (zChanged15 || objRememberedValue39 == neverEqualPolicy5) {
                                                                                objRememberedValue39 = new AccountScreenKt$AccountScreen$1$1$11$1$1(menuState8, (Object) playlistSong5, (Object) mutableState50, (byte) 3);
                                                                                gapComposer12.updateRememberedValue(objRememberedValue39);
                                                                            }
                                                                            CardKt.IconButton((Function0) objRememberedValue39, null, false, null, null, TopPlaylistScreenKt.lambda$1093025671, gapComposer12, 1572864, 62);
                                                                            GapComposer gapComposer13 = gapComposer12;
                                                                            if (playlistSongSortType10 != PlaylistSongSortType.CUSTOM || ((Boolean) mutableState46.getValue()).booleanValue() || ((Boolean) mutableState49.getValue()).booleanValue() || ((Boolean) mutableState47.getValue()).booleanValue() || !z15) {
                                                                                gapComposer13.startReplaceGroup(-1876681895);
                                                                                gapComposer13.end(false);
                                                                            } else {
                                                                                gapComposer13.startReplaceGroup(-1877247924);
                                                                                Object objRememberedValue40 = gapComposer13.rememberedValue();
                                                                                if (objRememberedValue40 == neverEqualPolicy5) {
                                                                                    objRememberedValue40 = LocalPlaylistScreenKt$LocalPlaylistScreen$13$1$1$3$1$content$1$3$2$1.INSTANCE;
                                                                                    gapComposer13.updateRememberedValue(objRememberedValue40);
                                                                                }
                                                                                CardKt.IconButton((Function0) objRememberedValue40, Modifier.Companion.$$INSTANCE.then(new ComposedModifier(new ReorderableCollectionItemScopeImpl$draggableHandle$1(reorderableCollectionItemScopeImpl2, DragGestureDetector$Press.INSTANCE, ReorderableLazyCollectionState$findTargetItem$1.INSTANCE$1, Scroller$ScrollInfo$Companion$Null$1.INSTANCE$1))), false, null, null, TopPlaylistScreenKt.lambda$1521997836, gapComposer13, 1572870, 60);
                                                                                gapComposer13 = gapComposer13;
                                                                                gapComposer13.end(false);
                                                                            }
                                                                            gapComposer13.end(false);
                                                                        }
                                                                    } else {
                                                                        gapComposer12.skipToGroupEnd();
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }
                                                            }, gapComposer11), null, gapComposer11, 24576, 384, 10732);
                                                        } else {
                                                            gapComposer11.skipToGroupEnd();
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                }, gapComposer10);
                                                boolean zBooleanValue2 = ((Boolean) mutableState31.getValue()).booleanValue();
                                                Modifier.Companion companion2 = Modifier.Companion.$$INSTANCE;
                                                LazyItemScopeImpl lazyItemScopeImpl2 = lazyItemScopeImpl;
                                                if (zBooleanValue2 || LocalPlaylistScreenKt.LocalPlaylistScreen$lambda$21(mutableState35) || !((Boolean) dataStoreKt$rememberPreference$1$1RememberPreference3.getValue()).booleanValue()) {
                                                    gapComposer10.startReplaceGroup(234329596);
                                                    Modifier modifierAnimateItem$default = LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl2, companion2);
                                                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
                                                    int iHashCode3 = Long.hashCode(gapComposer10.compositeKeyHashCode);
                                                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer10.currentCompositionLocalScope();
                                                    Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer10, modifierAnimateItem$default);
                                                    ComposeUiNode.Companion.getClass();
                                                    gapComposer10.startReusableNode();
                                                    if (gapComposer10.inserting) {
                                                        gapComposer10.createNode(LayoutNode.Constructor);
                                                    } else {
                                                        gapComposer10.useNode();
                                                    }
                                                    Stack.m390setimpl(gapComposer10, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.Companion.SetMeasurePolicy);
                                                    Stack.m390setimpl(gapComposer10, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                                                    Stack.m390setimpl(gapComposer10, Integer.valueOf(iHashCode3), ComposeUiNode.Companion.SetCompositeKeyHash);
                                                    Stack.m389reconcileimpl(gapComposer10);
                                                    Stack.m390setimpl(gapComposer10, modifierMaterializeModifier3, ComposeUiNode.Companion.SetModifier);
                                                    composableLambdaImplRememberComposableLambda.invoke((Object) gapComposer10, (Object) 6);
                                                    gapComposer10.end(true);
                                                    gapComposer10.end(false);
                                                } else {
                                                    gapComposer10.startReplaceGroup(234491726);
                                                    ScrimKt.SwipeToDismissBox(swipeToDismissBoxState, TopPlaylistScreenKt.f407lambda$965880408, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl2, companion2), false, false, false, null, Expect_jvmKt.rememberComposableLambda(680189614, new QueueKt$Queue$5$4$1$1$4$1.AnonymousClass2(composableLambdaImplRememberComposableLambda, (byte) 1), gapComposer10), gapComposer10, 12582968, 120);
                                                    gapComposer10.end(false);
                                                }
                                            } else {
                                                gapComposer10.skipToGroupEnd();
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }, gapComposer9), gapComposer9, (i9 & 14) | 1572864);
                                    gapComposer9.end(false);
                                } else {
                                    gapComposer9.skipToGroupEnd();
                                }
                                return Unit.INSTANCE;
                            }
                        }));
                        return Unit.INSTANCE;
                    }
                };
                snackbarHostState = snackbarHostState2;
                mutableState15 = mutableState24;
                gapComposer2.updateRememberedValue(objRememberedValue10);
            } else {
                final MutableState mutableState26 = mutableState9;
                final MutableState mutableState27 = mutableState8;
                final ReorderableLazyListState reorderableLazyListState4 = reorderableLazyListState;
                final PlaylistSongSortType playlistSongSortType6 = playlistSongSortType;
                final MenuState menuState4 = menuState;
                final MusicDatabase musicDatabase6 = musicDatabase2;
                final MutableState mutableState28 = mutableState12;
                objRememberedValue10 = new Function1() { // from class: com.metrolist.music.ui.screens.playlist.LocalPlaylistScreenKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj4) {
                        final PlaylistSongSortType playlistSongSortType7;
                        boolean z8;
                        MutableState mutableState29;
                        boolean z9;
                        int i7;
                        String str3;
                        Integer num;
                        LazyListIntervalContent lazyListIntervalContent = (LazyListIntervalContent) obj4;
                        lazyListIntervalContent.getClass();
                        final MutableState mutableState210 = mutableState26;
                        Playlist playlist3 = (Playlist) mutableState210.getValue();
                        final MutableState mutableState211 = mutableState28;
                        final MutableState mutableState212 = mutableState27;
                        PlaylistSongSortType playlistSongSortType8 = playlistSongSortType6;
                        boolean z10 = z;
                        MutableState mutableState213 = dataStoreKt$rememberPreference$1$1RememberPreference2;
                        if (playlist3 == null) {
                            playlistSongSortType7 = playlistSongSortType8;
                            z8 = z10;
                            mutableState29 = mutableState213;
                            mutableState211 = mutableState211;
                            z9 = true;
                        } else if (playlist3.songCount == 0 && (num = playlist3.playlist.remoteSongCount) != null && num.intValue() == 0) {
                            LazyListIntervalContent.item$default(lazyListIntervalContent, "empty_placeholder", null, TopPlaylistScreenKt.f399lambda$412743085, 2);
                            playlistSongSortType7 = playlistSongSortType8;
                            z8 = z10;
                            mutableState29 = mutableState213;
                            mutableState211 = mutableState211;
                            z9 = true;
                        } else {
                            if (((Boolean) mutableState211.getValue()).booleanValue()) {
                                i7 = 2;
                                str3 = null;
                            } else {
                                ComposableLambdaImpl composableLambdaImpl5 = new ComposableLambdaImpl(true, 1700853551, new AlbumMenuKt$$ExternalSyntheticLambda20(playlist3, mutableState211, snackbarHostState2, mutableState212, mutableState14, mutableState5, mutableState7, mutableState11));
                                i7 = 2;
                                str3 = null;
                                LazyListIntervalContent.item$default(lazyListIntervalContent, "playlist_header", null, composableLambdaImpl5, 2);
                            }
                            z8 = z10;
                            mutableState29 = mutableState213;
                            z9 = true;
                            playlistSongSortType7 = playlistSongSortType8;
                            LazyListIntervalContent.item$default(lazyListIntervalContent, "controls_row", str3, new ComposableLambdaImpl(true, 2122362666, new HomeScreenKt$$ExternalSyntheticLambda40(playlistSongSortType8, z4, renderScriptBlurEffect$updateSurface$2$4, mimesKt$$ExternalSyntheticLambda1, z8, mutableState29)), i7);
                        }
                        final List list10 = ((Boolean) mutableState211.getValue()).booleanValue() ? list5 : snapshotStateList3;
                        TopPlaylistScreenKt$$ExternalSyntheticLambda8 topPlaylistScreenKt$$ExternalSyntheticLambda8 = new TopPlaylistScreenKt$$ExternalSyntheticLambda8((byte) 7);
                        int size3 = list10.size();
                        ScrimBlurEffect$drawEffect$$inlined$withAlpha$1$1 scrimBlurEffect$drawEffect$$inlined$withAlpha$1$1 = new ScrimBlurEffect$drawEffect$$inlined$withAlpha$1$1(topPlaylistScreenKt$$ExternalSyntheticLambda8, list10, (byte) 3);
                        AlarmSettingsKt$AlarmEditorDialog$lambda$27$0$0$$inlined$items$default$3 alarmSettingsKt$AlarmEditorDialog$lambda$27$0$0$$inlined$items$default$3 = new AlarmSettingsKt$AlarmEditorDialog$lambda$27$0$0$$inlined$items$default$3(list10, (byte) 7);
                        boolean z11 = z9;
                        final ReorderableLazyListState reorderableLazyListState5 = reorderableLazyListState4;
                        final MusicDatabase musicDatabase7 = musicDatabase6;
                        final SyncUtils syncUtils2 = syncUtils;
                        final SnapshotStateList snapshotStateList6 = snapshotStateList;
                        final HapticFeedback hapticFeedback2 = hapticFeedback;
                        final State state3 = mutableStateCollectAsStateWithLifecycle2;
                        final PlayerConnection playerConnection4 = playerConnection;
                        final State state4 = mutableStateCollectAsStateWithLifecycle;
                        final MutableState mutableState214 = mutableState2;
                        final MutableState mutableState215 = mutableState3;
                        final MenuState menuState5 = menuState4;
                        final List list11 = list10;
                        final MutableState mutableState30 = mutableState29;
                        final boolean z12 = z8;
                        lazyListIntervalContent.items(size3, scrimBlurEffect$drawEffect$$inlined$withAlpha$1$1, alarmSettingsKt$AlarmEditorDialog$lambda$27$0$0$$inlined$items$default$3, new ComposableLambdaImpl(z11, 2039820996, new Function4() { // from class: com.metrolist.music.ui.screens.playlist.LocalPlaylistScreenKt$LocalPlaylistScreen$lambda$57$0$0$$inlined$itemsIndexed$default$3
                            @Override // kotlin.jvm.functions.Function4
                            public final Object invoke(Object obj5, Object obj6, Object obj7, Object obj8) {
                                int i8;
                                final LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj5;
                                final int iIntValue = ((Number) obj6).intValue();
                                Composer composer2 = (Composer) obj7;
                                int iIntValue2 = ((Number) obj8).intValue();
                                if ((iIntValue2 & 6) == 0) {
                                    i8 = (((GapComposer) composer2).changed(lazyItemScopeImpl) ? 4 : 2) | iIntValue2;
                                } else {
                                    i8 = iIntValue2;
                                }
                                if ((iIntValue2 & 48) == 0) {
                                    i8 |= ((GapComposer) composer2).changed(iIntValue) ? 32 : 16;
                                }
                                int i9 = i8;
                                GapComposer gapComposer9 = (GapComposer) composer2;
                                if (gapComposer9.shouldExecute(i9 & 1, (i9 & 147) != 146)) {
                                    final PlaylistSong playlistSong2 = (PlaylistSong) list10.get(iIntValue);
                                    gapComposer9.startReplaceGroup(-1047776051);
                                    Integer numValueOf = Integer.valueOf(playlistSong2.map.id);
                                    final MutableState mutableState31 = mutableState30;
                                    final MutableState mutableState32 = mutableState211;
                                    final MutableState mutableState33 = mutableState210;
                                    final MusicDatabase musicDatabase8 = musicDatabase7;
                                    final SyncUtils syncUtils3 = syncUtils2;
                                    final SnapshotStateList snapshotStateList7 = snapshotStateList6;
                                    final HapticFeedback hapticFeedback3 = hapticFeedback2;
                                    final List list12 = list11;
                                    final State state5 = state3;
                                    final PlayerConnection playerConnection5 = playerConnection4;
                                    final MutableState mutableState34 = mutableState212;
                                    final State state6 = state4;
                                    final MutableState mutableState35 = mutableState214;
                                    final MutableState mutableState36 = mutableState215;
                                    final MenuState menuState6 = menuState5;
                                    final PlaylistSongSortType playlistSongSortType9 = playlistSongSortType7;
                                    final boolean z13 = z12;
                                    CharsKt.ReorderableItem(lazyItemScopeImpl, reorderableLazyListState5, numValueOf, null, false, null, Expect_jvmKt.rememberComposableLambda(137257390, new Function4() { // from class: com.metrolist.music.ui.screens.playlist.LocalPlaylistScreenKt$LocalPlaylistScreen$13$1$1$3$1
                                        @Override // kotlin.jvm.functions.Function4
                                        public final Object invoke(Object obj9, Object obj10, Object obj11, Object obj12) {
                                            SwipeToDismissBoxValue swipeToDismissBoxValue;
                                            NeverEqualPolicy neverEqualPolicy;
                                            SwipeToDismissBoxState swipeToDismissBoxState;
                                            final ReorderableCollectionItemScopeImpl reorderableCollectionItemScopeImpl = (ReorderableCollectionItemScopeImpl) obj9;
                                            ((Boolean) obj10).getClass();
                                            Composer composer3 = (Composer) obj11;
                                            int iIntValue3 = ((Number) obj12).intValue();
                                            reorderableCollectionItemScopeImpl.getClass();
                                            byte b8 = 2;
                                            if ((iIntValue3 & 6) == 0) {
                                                iIntValue3 |= ((GapComposer) composer3).changed(reorderableCollectionItemScopeImpl) ? 4 : 2;
                                            }
                                            GapComposer gapComposer10 = (GapComposer) composer3;
                                            if (gapComposer10.shouldExecute(iIntValue3 & 1, (iIntValue3 & 131) != 130)) {
                                                final PlaylistSong playlistSong3 = playlistSong2;
                                                MutableState mutableStateRememberUpdatedState = Stack.rememberUpdatedState(playlistSong3, gapComposer10);
                                                Preferences$Key preferences$Key3 = PreferenceKeysKt.SwipeToRemoveSongKey;
                                                Boolean bool2 = Boolean.FALSE;
                                                DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference3 = com.metrolist.music.utils.UtilsKt.rememberPreference(preferences$Key3, bool2, gapComposer10, 48);
                                                Object objRememberedValue33 = gapComposer10.rememberedValue();
                                                NeverEqualPolicy neverEqualPolicy2 = Composer.Companion.Empty;
                                                if (objRememberedValue33 == neverEqualPolicy2) {
                                                    objRememberedValue33 = CachePlaylistScreenKt$CachePlaylistScreen$sortedSongs$1$sorted$3$1.INSTANCE$1;
                                                    gapComposer10.updateRememberedValue(objRememberedValue33);
                                                }
                                                SwipeToDismissBoxState swipeToDismissBoxStateRememberSwipeToDismissBoxState = ScrimKt.rememberSwipeToDismissBoxState((Function1) objRememberedValue33, gapComposer10);
                                                Object objRememberedValue34 = gapComposer10.rememberedValue();
                                                if (objRememberedValue34 == neverEqualPolicy2) {
                                                    objRememberedValue34 = Stack.mutableStateOf$default(bool2);
                                                    gapComposer10.updateRememberedValue(objRememberedValue34);
                                                }
                                                MutableState mutableState37 = (MutableState) objRememberedValue34;
                                                SwipeToDismissBoxValue currentValue = swipeToDismissBoxStateRememberSwipeToDismissBoxState.getCurrentValue();
                                                boolean zChangedInstance2 = gapComposer10.changedInstance(swipeToDismissBoxStateRememberSwipeToDismissBoxState) | gapComposer10.changed(dataStoreKt$rememberPreference$1$1RememberPreference3);
                                                final MutableState mutableState38 = mutableState33;
                                                boolean zChanged9 = zChangedInstance2 | gapComposer10.changed(mutableState38) | gapComposer10.changed(mutableStateRememberUpdatedState) | gapComposer10.changedInstance(musicDatabase8) | gapComposer10.changedInstance(syncUtils3);
                                                Object objRememberedValue35 = gapComposer10.rememberedValue();
                                                if (zChanged9 || objRememberedValue35 == neverEqualPolicy2) {
                                                    swipeToDismissBoxValue = currentValue;
                                                    neverEqualPolicy = neverEqualPolicy2;
                                                    PlayerKt$BottomSheetPlayer$13$1 playerKt$BottomSheetPlayer$13$1 = new PlayerKt$BottomSheetPlayer$13$1(swipeToDismissBoxStateRememberSwipeToDismissBoxState, dataStoreKt$rememberPreference$1$1RememberPreference3, mutableState37, musicDatabase8, syncUtils3, mutableState38, mutableStateRememberUpdatedState, (Continuation) null);
                                                    swipeToDismissBoxState = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                                                    gapComposer10.updateRememberedValue(playerKt$BottomSheetPlayer$13$1);
                                                    objRememberedValue35 = playerKt$BottomSheetPlayer$13$1;
                                                } else {
                                                    swipeToDismissBoxState = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                                                    swipeToDismissBoxValue = currentValue;
                                                    neverEqualPolicy = neverEqualPolicy2;
                                                }
                                                Stack.LaunchedEffect(gapComposer10, swipeToDismissBoxValue, (Function2) objRememberedValue35);
                                                boolean zChangedInstance3 = gapComposer10.changedInstance(playlistSong3);
                                                Object objRememberedValue36 = gapComposer10.rememberedValue();
                                                if (zChangedInstance3 || objRememberedValue36 == neverEqualPolicy) {
                                                    objRememberedValue36 = new ScrimBlurEffect$drawEffect$$inlined$withAlpha$1$1(snapshotStateList7, playlistSong3, b8);
                                                    gapComposer10.updateRememberedValue(objRememberedValue36);
                                                }
                                                final Function1 function6 = (Function1) objRememberedValue36;
                                                final MutableState mutableState39 = mutableState31;
                                                final MutableState mutableState40 = mutableState32;
                                                final HapticFeedback hapticFeedback4 = hapticFeedback3;
                                                final List list13 = list12;
                                                final int i10 = iIntValue;
                                                final State state7 = state5;
                                                final PlayerConnection playerConnection6 = playerConnection5;
                                                final MutableState mutableState41 = mutableState34;
                                                final State state8 = state6;
                                                final SnapshotStateList snapshotStateList8 = snapshotStateList7;
                                                final MutableState mutableState42 = mutableState35;
                                                final MutableState mutableState43 = mutableState36;
                                                final MenuState menuState7 = menuState6;
                                                final PlaylistSongSortType playlistSongSortType10 = playlistSongSortType9;
                                                final boolean z14 = z13;
                                                ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Expect_jvmKt.rememberComposableLambda(227958157, new Function2() { // from class: com.metrolist.music.ui.screens.playlist.LocalPlaylistScreenKt$LocalPlaylistScreen$13$1$1$3$1$content$1
                                                    @Override // kotlin.jvm.functions.Function2
                                                    public final Object invoke(Object obj13, Object obj14) {
                                                        NeverEqualPolicy neverEqualPolicy3;
                                                        Function1 function7;
                                                        Modifier modifier;
                                                        Composer composer4 = (Composer) obj13;
                                                        int iIntValue4 = ((Number) obj14).intValue();
                                                        GapComposer gapComposer11 = (GapComposer) composer4;
                                                        if (gapComposer11.shouldExecute(iIntValue4 & 1, (iIntValue4 & 3) != 2)) {
                                                            final PlaylistSong playlistSong4 = playlistSong3;
                                                            Song song = playlistSong4.song;
                                                            String str4 = song.song.id;
                                                            State state9 = state7;
                                                            MediaMetadata mediaMetadata = (MediaMetadata) state9.getValue();
                                                            boolean zAreEqual = Intrinsics.areEqual(str4, mediaMetadata != null ? mediaMetadata.id : null);
                                                            boolean zBooleanValue2 = ((Boolean) state8.getValue()).booleanValue();
                                                            Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f);
                                                            boolean zChangedInstance4 = gapComposer11.changedInstance(hapticFeedback4);
                                                            Function1 function8 = function6;
                                                            boolean zChanged10 = zChangedInstance4 | gapComposer11.changed(function8) | gapComposer11.changedInstance(playlistSong4);
                                                            List list14 = list13;
                                                            boolean zChangedInstance5 = zChanged10 | gapComposer11.changedInstance(list14) | gapComposer11.changed(i10);
                                                            Object objRememberedValue37 = gapComposer11.rememberedValue();
                                                            NeverEqualPolicy neverEqualPolicy4 = Composer.Companion.Empty;
                                                            if (zChangedInstance5 || objRememberedValue37 == neverEqualPolicy4) {
                                                                neverEqualPolicy3 = neverEqualPolicy4;
                                                                function7 = function8;
                                                                modifier = modifierFillMaxWidth;
                                                                OnlinePlaylistScreenKt$OnlinePlaylistScreen$4$1$1$2$4$1$1 onlinePlaylistScreenKt$OnlinePlaylistScreen$4$1$1$2$4$1$1 = new OnlinePlaylistScreenKt$OnlinePlaylistScreen$4$1$1$2$4$1$1(hapticFeedback4, function6, playlistSong4, i10, list14, snapshotStateList8, mutableState42, mutableState43, (byte) 1);
                                                                gapComposer11.updateRememberedValue(onlinePlaylistScreenKt$OnlinePlaylistScreen$4$1$1$2$4$1$1);
                                                                objRememberedValue37 = onlinePlaylistScreenKt$OnlinePlaylistScreen$4$1$1$2$4$1$1;
                                                            } else {
                                                                modifier = modifierFillMaxWidth;
                                                                function7 = function8;
                                                                neverEqualPolicy3 = neverEqualPolicy4;
                                                            }
                                                            Function0 function9 = (Function0) objRememberedValue37;
                                                            boolean zChanged11 = gapComposer11.changed(function7) | gapComposer11.changedInstance(playlistSong4) | gapComposer11.changed(state9);
                                                            PlayerConnection playerConnection7 = playerConnection6;
                                                            boolean zChangedInstance6 = zChanged11 | gapComposer11.changedInstance(playerConnection7);
                                                            final MutableState mutableState44 = mutableState38;
                                                            boolean zChanged12 = zChangedInstance6 | gapComposer11.changed(mutableState44);
                                                            MutableState mutableState45 = mutableState41;
                                                            boolean zChanged13 = zChanged12 | gapComposer11.changed(mutableState45);
                                                            Object objRememberedValue38 = gapComposer11.rememberedValue();
                                                            if (zChanged13 || objRememberedValue38 == neverEqualPolicy3) {
                                                                TopPlaylistScreenKt$TopPlaylistScreen$8$1$1$4$2$1 topPlaylistScreenKt$TopPlaylistScreen$8$1$1$4$2$1 = new TopPlaylistScreenKt$TopPlaylistScreen$8$1$1$4$2$1(function6, snapshotStateList8, playlistSong4, playerConnection7, mutableState42, state7, mutableState44, mutableState45);
                                                                gapComposer11.updateRememberedValue(topPlaylistScreenKt$TopPlaylistScreen$8$1$1$4$2$1);
                                                                objRememberedValue38 = topPlaylistScreenKt$TopPlaylistScreen$8$1$1$4$2$1;
                                                            }
                                                            Modifier modifierM48combinedClickablehoGz1lA$default = ImageKt.m48combinedClickablehoGz1lA$default(modifier, false, function9, (Function0) objRememberedValue38, 239);
                                                            final MutableState mutableState46 = mutableState39;
                                                            final MutableState mutableState47 = mutableState40;
                                                            final SnapshotStateList snapshotStateList9 = snapshotStateList8;
                                                            final Function1 function10 = function6;
                                                            final MenuState menuState8 = menuState7;
                                                            final PlaylistSongSortType playlistSongSortType11 = playlistSongSortType10;
                                                            final boolean z15 = z14;
                                                            final ReorderableCollectionItemScopeImpl reorderableCollectionItemScopeImpl2 = reorderableCollectionItemScopeImpl;
                                                            final MutableState mutableState48 = mutableState42;
                                                            MenuKt.SongListItem(song, modifierM48combinedClickablehoGz1lA$default, null, false, true, false, null, null, zAreEqual, zBooleanValue2, false, Expect_jvmKt.rememberComposableLambda(-385861879, new Function3() { // from class: com.metrolist.music.ui.screens.playlist.LocalPlaylistScreenKt$LocalPlaylistScreen$13$1$1$3$1$content$1.3
                                                                @Override // kotlin.jvm.functions.Function3
                                                                public final Object invoke(Object obj15, Object obj16, Object obj17) {
                                                                    Composer composer5 = (Composer) obj16;
                                                                    int iIntValue5 = ((Number) obj17).intValue();
                                                                    ((RowScope) obj15).getClass();
                                                                    GapComposer gapComposer12 = (GapComposer) composer5;
                                                                    if (gapComposer12.shouldExecute(iIntValue5 & 1, (iIntValue5 & 17) != 16)) {
                                                                        MutableState mutableState49 = mutableState48;
                                                                        boolean zLocalPlaylistScreen$lambda$21 = LocalPlaylistScreenKt.LocalPlaylistScreen$lambda$21(mutableState49);
                                                                        PlaylistSong playlistSong5 = playlistSong4;
                                                                        if (zLocalPlaylistScreen$lambda$21) {
                                                                            gapComposer12.startReplaceGroup(-1878693020);
                                                                            CardKt.Checkbox(snapshotStateList9.contains(Integer.valueOf(playlistSong5.map.id)), function10, null, false, null, gapComposer12, 0);
                                                                            gapComposer12.end(false);
                                                                        } else {
                                                                            gapComposer12.startReplaceGroup(-1878365474);
                                                                            MenuState menuState9 = menuState8;
                                                                            boolean zChanged14 = gapComposer12.changed(menuState9) | gapComposer12.changedInstance(playlistSong5);
                                                                            MutableState mutableState50 = mutableState44;
                                                                            boolean zChanged15 = zChanged14 | gapComposer12.changed(mutableState50);
                                                                            Object objRememberedValue39 = gapComposer12.rememberedValue();
                                                                            NeverEqualPolicy neverEqualPolicy5 = Composer.Companion.Empty;
                                                                            if (zChanged15 || objRememberedValue39 == neverEqualPolicy5) {
                                                                                objRememberedValue39 = new AccountScreenKt$AccountScreen$1$1$11$1$1(menuState9, (Object) playlistSong5, (Object) mutableState50, (byte) 3);
                                                                                gapComposer12.updateRememberedValue(objRememberedValue39);
                                                                            }
                                                                            CardKt.IconButton((Function0) objRememberedValue39, null, false, null, null, TopPlaylistScreenKt.lambda$1093025671, gapComposer12, 1572864, 62);
                                                                            GapComposer gapComposer13 = gapComposer12;
                                                                            if (playlistSongSortType11 != PlaylistSongSortType.CUSTOM || ((Boolean) mutableState46.getValue()).booleanValue() || ((Boolean) mutableState49.getValue()).booleanValue() || ((Boolean) mutableState47.getValue()).booleanValue() || !z15) {
                                                                                gapComposer13.startReplaceGroup(-1876681895);
                                                                                gapComposer13.end(false);
                                                                            } else {
                                                                                gapComposer13.startReplaceGroup(-1877247924);
                                                                                Object objRememberedValue40 = gapComposer13.rememberedValue();
                                                                                if (objRememberedValue40 == neverEqualPolicy5) {
                                                                                    objRememberedValue40 = LocalPlaylistScreenKt$LocalPlaylistScreen$13$1$1$3$1$content$1$3$2$1.INSTANCE;
                                                                                    gapComposer13.updateRememberedValue(objRememberedValue40);
                                                                                }
                                                                                CardKt.IconButton((Function0) objRememberedValue40, Modifier.Companion.$$INSTANCE.then(new ComposedModifier(new ReorderableCollectionItemScopeImpl$draggableHandle$1(reorderableCollectionItemScopeImpl2, DragGestureDetector$Press.INSTANCE, ReorderableLazyCollectionState$findTargetItem$1.INSTANCE$1, Scroller$ScrollInfo$Companion$Null$1.INSTANCE$1))), false, null, null, TopPlaylistScreenKt.lambda$1521997836, gapComposer13, 1572870, 60);
                                                                                gapComposer13 = gapComposer13;
                                                                                gapComposer13.end(false);
                                                                            }
                                                                            gapComposer13.end(false);
                                                                        }
                                                                    } else {
                                                                        gapComposer12.skipToGroupEnd();
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }
                                                            }, gapComposer11), null, gapComposer11, 24576, 384, 10732);
                                                        } else {
                                                            gapComposer11.skipToGroupEnd();
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                }, gapComposer10);
                                                boolean zBooleanValue2 = ((Boolean) mutableState31.getValue()).booleanValue();
                                                Modifier.Companion companion2 = Modifier.Companion.$$INSTANCE;
                                                LazyItemScopeImpl lazyItemScopeImpl2 = lazyItemScopeImpl;
                                                if (zBooleanValue2 || LocalPlaylistScreenKt.LocalPlaylistScreen$lambda$21(mutableState35) || !((Boolean) dataStoreKt$rememberPreference$1$1RememberPreference3.getValue()).booleanValue()) {
                                                    gapComposer10.startReplaceGroup(234329596);
                                                    Modifier modifierAnimateItem$default = LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl2, companion2);
                                                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
                                                    int iHashCode3 = Long.hashCode(gapComposer10.compositeKeyHashCode);
                                                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer10.currentCompositionLocalScope();
                                                    Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer10, modifierAnimateItem$default);
                                                    ComposeUiNode.Companion.getClass();
                                                    gapComposer10.startReusableNode();
                                                    if (gapComposer10.inserting) {
                                                        gapComposer10.createNode(LayoutNode.Constructor);
                                                    } else {
                                                        gapComposer10.useNode();
                                                    }
                                                    Stack.m390setimpl(gapComposer10, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.Companion.SetMeasurePolicy);
                                                    Stack.m390setimpl(gapComposer10, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                                                    Stack.m390setimpl(gapComposer10, Integer.valueOf(iHashCode3), ComposeUiNode.Companion.SetCompositeKeyHash);
                                                    Stack.m389reconcileimpl(gapComposer10);
                                                    Stack.m390setimpl(gapComposer10, modifierMaterializeModifier3, ComposeUiNode.Companion.SetModifier);
                                                    composableLambdaImplRememberComposableLambda.invoke((Object) gapComposer10, (Object) 6);
                                                    gapComposer10.end(true);
                                                    gapComposer10.end(false);
                                                } else {
                                                    gapComposer10.startReplaceGroup(234491726);
                                                    ScrimKt.SwipeToDismissBox(swipeToDismissBoxState, TopPlaylistScreenKt.f407lambda$965880408, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl2, companion2), false, false, false, null, Expect_jvmKt.rememberComposableLambda(680189614, new QueueKt$Queue$5$4$1$1$4$1.AnonymousClass2(composableLambdaImplRememberComposableLambda, (byte) 1), gapComposer10), gapComposer10, 12582968, 120);
                                                    gapComposer10.end(false);
                                                }
                                            } else {
                                                gapComposer10.skipToGroupEnd();
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }, gapComposer9), gapComposer9, (i9 & 14) | 1572864);
                                    gapComposer9.end(false);
                                } else {
                                    gapComposer9.skipToGroupEnd();
                                }
                                return Unit.INSTANCE;
                            }
                        }));
                        return Unit.INSTANCE;
                    }
                };
                snackbarHostState = snackbarHostState2;
                mutableState15 = mutableState27;
                gapComposer2.updateRememberedValue(objRememberedValue10);
            }
            GapComposer gapComposer9 = gapComposer2;
            LazyListState lazyListState3 = lazyListState;
            IntMath.LazyColumn(null, lazyListState3, insetsPaddingValuesAsPaddingValues5, null, null, null, false, null, (Function1) objRememberedValue10, gapComposer9, 0, 505);
            InsetsPaddingValues insetsPaddingValuesAsPaddingValues6 = OffsetKt.asPaddingValues(new UnionInsets((WindowInsets) gapComposer9.consume(providableCompositionLocal2), OffsetKt.current(gapComposer9).ime), gapComposer9);
            Modifier.Companion companion2 = Modifier.Companion.$$INSTANCE;
            Modifier modifierPadding2 = OffsetKt.padding(companion2, insetsPaddingValuesAsPaddingValues6);
            BiasAlignment biasAlignment2 = Alignment.Companion.CenterEnd;
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            DialogKt.m1466DraggableScrollbartao0HgU(lazyListState3, boxScopeInstance2.align(modifierPadding2, biasAlignment2), 0L, 0L, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 0, 0, 2, gapComposer9, 0);
            navHostController2 = navHostController;
            boolean z8 = z3;
            MenuKt.m1493TopAppBarGHTll3U(Expect_jvmKt.rememberComposableLambda(967669844, new PlayerKt$$ExternalSyntheticLambda78(snapshotStateList, focusRequester, mutableState, mutableState2, mutableState12, state2, mutableState9), gapComposer9), null, Expect_jvmKt.rememberComposableLambda(1181286930, new StatsScreenKt$$ExternalSyntheticLambda19(function0, mutableState12, mutableState, navHostController, mutableState2, (byte) 2), gapComposer9), Expect_jvmKt.rememberComposableLambda(646929993, new QueueMenuKt$$ExternalSyntheticLambda12((List) snapshotStateList, mutableState15, (Object) menuState, (Object) mutableState12, (Object) mutableState2, (Function) function0, (byte) 9), gapComposer9), CropImageView.DEFAULT_ASPECT_RATIO, null, null, null, gapComposer9, 3462, 242);
            GapComposer gapComposer10 = gapComposer9;
            WindowInsets windowInsets4 = (WindowInsets) gapComposer10.consume(providableCompositionLocal2);
            WeakHashMap weakHashMap4 = WindowInsetsHolder.viewMap;
            ScrimKt.SnackbarHost(snackbarHostState, boxScopeInstance2.align(OffsetKt.windowInsetsPadding(companion2, new UnionInsets(windowInsets4, OffsetKt.current(gapComposer10).ime)), Alignment.Companion.BottomCenter), null, gapComposer10, 6, 4);
            gapComposer10.end(z8);
            localPlaylistViewModel2 = localPlaylistViewModel5;
            b = z8;
            gapComposer = gapComposer10;
        } else {
            b = 1;
            navHostController2 = navHostController;
            gapComposer4.skipToGroupEnd();
            localPlaylistViewModel2 = localPlaylistViewModel;
            gapComposer = gapComposer4;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup2 = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup2 != null) {
            recomposeScopeImplEndRestartGroup2.block = new Function2(navHostController2, localPlaylistViewModel2, i, b) { // from class: com.metrolist.music.ui.screens.playlist.LocalPlaylistScreenKt$$ExternalSyntheticLambda0
                public final /* synthetic */ byte $r8$classId;
                public final /* synthetic */ NavHostController f$0;
                public final /* synthetic */ LocalPlaylistViewModel f$1;

                {
                    this.$r8$classId = b;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj4, Object obj5) {
                    byte b8 = this.$r8$classId;
                    Unit unit = Unit.INSTANCE;
                    LocalPlaylistViewModel localPlaylistViewModel9 = this.f$1;
                    NavHostController navHostController3 = this.f$0;
                    Composer composer2 = (Composer) obj4;
                    ((Integer) obj5).getClass();
                    switch (b8) {
                        case 0:
                            LocalPlaylistScreenKt.LocalPlaylistScreen(navHostController3, localPlaylistViewModel9, composer2, Stack.updateChangedFlags(1));
                            break;
                        default:
                            LocalPlaylistScreenKt.LocalPlaylistScreen(navHostController3, localPlaylistViewModel9, composer2, Stack.updateChangedFlags(1));
                            break;
                    }
                    return unit;
                }
            };
        }
    }

    public static final boolean LocalPlaylistScreen$lambda$21(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }
}
