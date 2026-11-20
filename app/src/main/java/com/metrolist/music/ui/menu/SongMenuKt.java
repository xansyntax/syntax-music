package com.metrolist.music.ui.menu;

import android.content.Context;
import android.content.res.Configuration;
import androidx.compose.animation.core.AnimateAsState;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsHolder;
import androidx.compose.foundation.lazy.LazyListIntervalContent;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda8;
import androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda2;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.core.provider.CallbackWrapper;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.navigation.NavHostController;
import androidx.room.coroutines.FlowUtil$createFlow$$inlined$map$1;
import coil3.util.FileSystemsKt;
import coil3.util.UtilsKt;
import com.google.common.math.IntMath;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda59;
import com.metrolist.music.MainActivityKt;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Event;
import com.metrolist.music.db.entities.PlaylistSong;
import com.metrolist.music.db.entities.PodcastEntity;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.db.entities.SongEntity;
import com.metrolist.music.listentogether.ListenTogetherManager;
import com.metrolist.music.playback.DownloadUtil;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.ui.component.BottomSheetPageKt;
import com.metrolist.music.ui.component.BottomSheetPageState;
import com.metrolist.music.ui.component.DialogKt;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda2;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda36;
import com.metrolist.music.utils.DataStoreKt$get$2;
import com.metrolist.music.utils.SyncUtils;
import com.metrolist.music.viewmodels.CachePlaylistViewModel;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import java.util.List;
import java.util.WeakHashMap;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class SongMenuKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [boolean, byte, int] */
    /* JADX WARN: Type inference failed for: r0v54, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v64 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r10v15, types: [androidx.compose.runtime.Composer, androidx.compose.runtime.GapComposer] */
    /* JADX WARN: Type inference failed for: r10v19, types: [androidx.compose.runtime.Composer] */
    /* JADX WARN: Type inference failed for: r13v10, types: [androidx.compose.ui.Modifier, kotlin.coroutines.Continuation] */
    /* JADX WARN: Type inference failed for: r13v11, types: [boolean] */
    /* JADX WARN: Type inference failed for: r13v12, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r13v17 */
    /* JADX WARN: Type inference failed for: r13v25 */
    /* JADX WARN: Type inference failed for: r13v26 */
    /* JADX WARN: Type inference failed for: r13v9 */
    /* JADX WARN: Type inference failed for: r14v11, types: [androidx.compose.runtime.Composer, androidx.compose.runtime.GapComposer] */
    /* JADX WARN: Type inference failed for: r14v17, types: [androidx.compose.runtime.GapComposer] */
    /* JADX WARN: Type inference failed for: r14v18 */
    /* JADX WARN: Type inference failed for: r14v19 */
    /* JADX WARN: Type inference failed for: r14v24, types: [androidx.compose.runtime.GapComposer] */
    /* JADX WARN: Type inference failed for: r14v26 */
    /* JADX WARN: Type inference failed for: r14v27 */
    /* JADX WARN: Type inference failed for: r14v28 */
    /* JADX WARN: Type inference failed for: r14v29 */
    /* JADX WARN: Type inference failed for: r14v30 */
    /* JADX WARN: Type inference failed for: r14v6, types: [androidx.compose.runtime.GapComposer] */
    /* JADX WARN: Type inference failed for: r17v12 */
    /* JADX WARN: Type inference failed for: r17v13 */
    /* JADX WARN: Type inference failed for: r17v15 */
    /* JADX WARN: Type inference failed for: r17v28 */
    /* JADX WARN: Type inference failed for: r26v3 */
    /* JADX WARN: Type inference failed for: r26v5 */
    /* JADX WARN: Type inference failed for: r2v66 */
    /* JADX WARN: Type inference failed for: r2v67 */
    /* JADX WARN: Type inference failed for: r2v72 */
    /* JADX WARN: Type inference failed for: r72v0 */
    /* JADX WARN: Type inference failed for: r7v15, types: [androidx.compose.runtime.GapComposer] */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v19 */
    /* JADX WARN: Type inference failed for: r7v4, types: [androidx.compose.runtime.Composer] */
    /* JADX WARN: Type inference failed for: r7v5, types: [androidx.compose.runtime.GapComposer] */
    /* JADX WARN: Type inference failed for: r7v6, types: [androidx.compose.runtime.Composer, androidx.compose.runtime.GapComposer] */
    /* JADX WARN: Type inference failed for: r8v18, types: [androidx.compose.runtime.Composer] */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16 */
    public static final void SongMenu(final Song song, Event event, PlaylistSong playlistSong, String str, final Function0 function0, boolean z, Composer composer, final int i, final int i2) {
        Event event2;
        int i3;
        PlaylistSong playlistSong2;
        int i4;
        int i5;
        final boolean z2;
        final Event event3;
        final PlaylistSong playlistSong3;
        final String str2;
        ?? r14;
        int i6;
        MutableState mutableState;
        MutableState mutableState2;
        MutableState mutableState3;
        Song song2;
        NeverEqualPolicy neverEqualPolicy;
        CoroutineScope coroutineScope;
        MutableState mutableState4;
        PlayerConnection playerConnection;
        int i7;
        MusicDatabase musicDatabase;
        ?? r15;
        ?? r13;
        Object obj;
        byte b;
        Object obj2;
        Function0 function1;
        byte b2;
        Object obj3;
        MutableState mutableState5;
        byte b3;
        Song song3;
        ?? r16;
        ?? r7;
        Song song4;
        NavHostController navHostController;
        char c;
        ?? r17;
        final PlaylistSong playlistSong4;
        final Event event4;
        ?? r18;
        Object obj4;
        ?? r19;
        Object obj5;
        Object obj6;
        Object obj7;
        byte b4;
        Object songMenuKt$$ExternalSyntheticLambda20;
        Song song5;
        PlayerConnection playerConnection2;
        GapComposer gapComposer;
        byte b5;
        song.getClass();
        SongEntity songEntity = song.song;
        function0.getClass();
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(-219838509);
        int i8 = i | (gapComposer2.changed(song) ? 4 : 2);
        int i9 = i2 & 2;
        if (i9 != 0) {
            i3 = i8 | 48;
            event2 = event;
        } else {
            event2 = event;
            i3 = i8 | (gapComposer2.changed(event2) ? 32 : 16);
        }
        int i10 = i2 & 4;
        if (i10 != 0) {
            i4 = i3 | 384;
            playlistSong2 = playlistSong;
        } else {
            playlistSong2 = playlistSong;
            i4 = i3 | (gapComposer2.changed(playlistSong2) ? 256 : 128);
        }
        int i11 = i2 & 8;
        if (i11 != 0) {
            i5 = i4 | 3072;
        } else {
            i5 = i4 | (gapComposer2.changed(str) ? 2048 : 1024);
        }
        int i12 = i5 | (gapComposer2.changedInstance(function0) ? 16384 : 8192);
        int i13 = i2 & 32;
        if (i13 != 0) {
            i12 |= 196608;
        } else if ((i & 196608) == 0) {
            i12 |= gapComposer2.changed(z) ? 131072 : 65536;
        }
        if (gapComposer2.shouldExecute(i12 & 1, (i12 & 74899) != 74898)) {
            Continuation continuation = null;
            final Event event5 = i9 != 0 ? null : event2;
            int i14 = i12;
            final PlaylistSong playlistSong5 = i10 != 0 ? null : playlistSong2;
            final String str3 = i11 != 0 ? null : str;
            final boolean z3 = i13 != 0 ? false : z;
            NavHostController navHostController2 = (NavHostController) gapComposer2.consume(MainActivityKt.LocalNavController);
            final Context context = (Context) gapComposer2.consume(AndroidCompositionLocals_androidKt.LocalContext);
            MusicDatabase musicDatabase2 = (MusicDatabase) gapComposer2.consume(MainActivityKt.LocalDatabase);
            PlayerConnection playerConnection3 = (PlayerConnection) gapComposer2.consume(MainActivityKt.LocalPlayerConnection);
            if (playerConnection3 == null) {
                RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    final byte b6 = 0;
                    recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj8, Object obj9) {
                            byte b7 = b6;
                            Unit unit = Unit.INSTANCE;
                            int i15 = i;
                            switch (b7) {
                                case 0:
                                    ((Integer) obj9).getClass();
                                    int iUpdateChangedFlags = Stack.updateChangedFlags(i15 | 1);
                                    SongMenuKt.SongMenu(song, event5, playlistSong5, str3, function0, z3, (Composer) obj8, iUpdateChangedFlags, i2);
                                    break;
                                default:
                                    ((Integer) obj9).getClass();
                                    int iUpdateChangedFlags2 = Stack.updateChangedFlags(i15 | 1);
                                    SongMenuKt.SongMenu(song, event5, playlistSong5, str3, function0, z3, (Composer) obj8, iUpdateChangedFlags2, i2);
                                    break;
                            }
                            return unit;
                        }
                    };
                    return;
                }
                return;
            }
            Event event6 = event5;
            PlaylistSong playlistSong6 = playlistSong5;
            final String str4 = str3;
            final boolean z4 = z3;
            Song song6 = (Song) FileSystemsKt.collectAsStateWithLifecycle(musicDatabase2.$$delegate_0.song(songEntity.id), song, gapComposer2, (i14 << 3) & 112).getValue();
            Song song7 = song6 == null ? song : song6;
            final DownloadUtil downloadUtil = (DownloadUtil) gapComposer2.consume(MainActivityKt.LocalDownloadUtil);
            MutableState mutableStateCollectAsStateWithLifecycle = FileSystemsKt.collectAsStateWithLifecycle(downloadUtil.getDownload(songEntity.id), null, gapComposer2, 48);
            Object objRememberedValue = gapComposer2.rememberedValue();
            NeverEqualPolicy neverEqualPolicy2 = Composer.Companion.Empty;
            if (objRememberedValue == neverEqualPolicy2) {
                objRememberedValue = Stack.createCompositionCoroutineScope(gapComposer2);
                gapComposer2.updateRememberedValue(objRememberedValue);
            }
            CoroutineScope coroutineScope2 = (CoroutineScope) objRememberedValue;
            final SyncUtils syncUtils = (SyncUtils) gapComposer2.consume(MainActivityKt.LocalSyncUtils);
            final ListenTogetherManager listenTogetherManager = (ListenTogetherManager) gapComposer2.consume(MainActivityKt.LocalListenTogetherManager);
            Object objRememberedValue2 = gapComposer2.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy2) {
                objRememberedValue2 = Stack.createCompositionCoroutineScope(gapComposer2);
                gapComposer2.updateRememberedValue(objRememberedValue2);
            }
            final CoroutineScope coroutineScope3 = (CoroutineScope) objRememberedValue2;
            Object objRememberedValue3 = gapComposer2.rememberedValue();
            if (objRememberedValue3 == neverEqualPolicy2) {
                objRememberedValue3 = Format$$ExternalSyntheticOutline0.m(CropImageView.DEFAULT_ASPECT_RATIO, gapComposer2);
            }
            final ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = (ParcelableSnapshotMutableFloatState) objRememberedValue3;
            ViewModelStoreOwner viewModelStoreOwner = (ViewModelStoreOwner) gapComposer2.consume(LocalViewModelStoreOwner.LocalViewModelStoreOwner);
            if (viewModelStoreOwner == null) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                return;
            }
            final CachePlaylistViewModel cachePlaylistViewModel = (CachePlaylistViewModel) UtilsKt.viewModel(Reflection.getOrCreateKotlinClass(CachePlaylistViewModel.class), viewModelStoreOwner, MathKt.rememberHiltViewModelFactory(ViewModelKt.getViewModelProviderFactory(viewModelStoreOwner), gapComposer2), ViewModelKt.getViewModelCreationExtras(viewModelStoreOwner), gapComposer2);
            final Song song8 = song7;
            final AnimateAsState animateAsStateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(parcelableSnapshotMutableFloatState.getFloatValue(), ArcSplineKt.tween$default(800, 0, null, 6), "", gapComposer2, 3120, 20);
            FlowUtil$createFlow$$inlined$map$1 flowUtil$createFlow$$inlined$map$1IsPinned = musicDatabase2.delegate.getSpeedDialDao().isPinned(song8.song.id);
            Boolean bool = Boolean.FALSE;
            MutableState mutableStateCollectAsStateWithLifecycle2 = FileSystemsKt.collectAsStateWithLifecycle(flowUtil$createFlow$$inlined$map$1IsPinned, bool, gapComposer2, 48);
            boolean zChanged = gapComposer2.changed(song8) | gapComposer2.changedInstance(musicDatabase2);
            Object objRememberedValue4 = gapComposer2.rememberedValue();
            if (zChanged || objRememberedValue4 == neverEqualPolicy2) {
                objRememberedValue4 = new DataStoreKt$get$2(song8, musicDatabase2, continuation, (byte) 11);
                gapComposer2.updateRememberedValue(objRememberedValue4);
            }
            MutableState mutableStateProduceState = Stack.produceState(null, song8, (Function2) objRememberedValue4, gapComposer2);
            PodcastEntity podcastEntity = (PodcastEntity) mutableStateProduceState.getValue();
            boolean z5 = (podcastEntity != null ? podcastEntity.bookmarkedAt : null) != null;
            Object[] objArr = new Object[0];
            Object objRememberedValue5 = gapComposer2.rememberedValue();
            if (objRememberedValue5 == neverEqualPolicy2) {
                objRememberedValue5 = new QueueKt$$ExternalSyntheticLambda2((byte) 1);
                gapComposer2.updateRememberedValue(objRememberedValue5);
            }
            MutableState mutableState6 = (MutableState) SaverKt.rememberSaveable(objArr, (Function0) objRememberedValue5, gapComposer2, 48);
            Object objRememberedValue6 = gapComposer2.rememberedValue();
            if (objRememberedValue6 == neverEqualPolicy2) {
                objRememberedValue6 = new QueueKt$$ExternalSyntheticLambda36((byte) 17);
                gapComposer2.updateRememberedValue(objRememberedValue6);
            }
            Function2 function2 = (Function2) objRememberedValue6;
            Object objRememberedValue7 = gapComposer2.rememberedValue();
            if (objRememberedValue7 == neverEqualPolicy2) {
                objRememberedValue7 = new SongMenuKt$$ExternalSyntheticLambda16((byte) 0);
                gapComposer2.updateRememberedValue(objRememberedValue7);
            }
            CallbackWrapper callbackWrapper = new CallbackWrapper(function2, (Function1) objRememberedValue7, (byte) 7);
            Object[] objArr2 = new Object[0];
            boolean zChanged2 = gapComposer2.changed(song8);
            Object objRememberedValue8 = gapComposer2.rememberedValue();
            if (zChanged2 || objRememberedValue8 == neverEqualPolicy2) {
                i6 = 0;
                final boolean z6 = false ? 1 : 0;
                objRememberedValue8 = new Function0() { // from class: com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        byte b7 = z6;
                        Song song9 = song8;
                        switch (b7) {
                            case 0:
                                return Stack.mutableStateOf$default(new TextFieldValue(6, 0L, song9.song.title));
                            default:
                                return Stack.mutableStateOf$default(new TextFieldValue(6, 0L, CollectionsKt.joinToString$default(song9.getOrderedArtists(), ", ", null, null, new SongMenuKt$$ExternalSyntheticLambda16((byte) 10), 30)));
                        }
                    }
                };
                gapComposer2.updateRememberedValue(objRememberedValue8);
            } else {
                i6 = 0;
            }
            MutableState mutableStateRememberSaveable = SaverKt.rememberSaveable(objArr2, (Saver) callbackWrapper, (Function0) objRememberedValue8, (Composer) gapComposer2, i6);
            Object[] objArr3 = new Object[i6];
            boolean zChanged3 = gapComposer2.changed(song8);
            MutableState mutableState7 = mutableStateCollectAsStateWithLifecycle2;
            Object objRememberedValue9 = gapComposer2.rememberedValue();
            if (zChanged3 || objRememberedValue9 == neverEqualPolicy2) {
                final byte b7 = 1;
                objRememberedValue9 = new Function0() { // from class: com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        byte b8 = b7;
                        Song song9 = song8;
                        switch (b8) {
                            case 0:
                                return Stack.mutableStateOf$default(new TextFieldValue(6, 0L, song9.song.title));
                            default:
                                return Stack.mutableStateOf$default(new TextFieldValue(6, 0L, CollectionsKt.joinToString$default(song9.getOrderedArtists(), ", ", null, null, new SongMenuKt$$ExternalSyntheticLambda16((byte) 10), 30)));
                        }
                    }
                };
                gapComposer2.updateRememberedValue(objRememberedValue9);
            }
            MutableState mutableStateRememberSaveable2 = SaverKt.rememberSaveable(objArr3, (Saver) callbackWrapper, (Function0) objRememberedValue9, (Composer) gapComposer2, 0);
            if (((Boolean) mutableState6.getValue()).booleanValue()) {
                gapComposer2.startReplaceGroup(618549691);
                ComposableLambdaImpl composableLambdaImpl = AlbumMenuKt.lambda$1979795479;
                ComposableLambdaImpl composableLambdaImpl2 = AlbumMenuKt.lambda$1847471734;
                List listListOf = CollectionsKt__IterablesKt.listOf((Object[]) new Pair[]{new Pair(MathKt.stringResource(R.string.song_title, gapComposer2), (TextFieldValue) mutableStateRememberSaveable.getValue()), new Pair(MathKt.stringResource(R.string.artist_name, gapComposer2), (TextFieldValue) mutableStateRememberSaveable2.getValue())});
                boolean zChanged4 = gapComposer2.changed(mutableStateRememberSaveable) | gapComposer2.changed(mutableStateRememberSaveable2);
                Object objRememberedValue10 = gapComposer2.rememberedValue();
                if (zChanged4 || objRememberedValue10 == neverEqualPolicy2) {
                    b4 = 0;
                    objRememberedValue10 = new SongMenuKt$$ExternalSyntheticLambda19(mutableStateRememberSaveable, mutableStateRememberSaveable2, b4);
                    gapComposer2.updateRememberedValue(objRememberedValue10);
                } else {
                    b4 = 0;
                }
                Function2 function3 = (Function2) objRememberedValue10;
                int i15 = (((((gapComposer2.changed(song8) ? 1 : 0) | (gapComposer2.changedInstance(coroutineScope2) ? 1 : 0) ? 1 : 0) | (gapComposer2.changedInstance(musicDatabase2) ? 1 : 0) ? 1 : 0) | (gapComposer2.changedInstance(playerConnection3) ? 1 : 0) ? 1 : 0) | (gapComposer2.changed(mutableState6) ? 1 : 0) ? 1 : 0) | ((i14 & 57344) == 16384 ? (byte) 1 : b4);
                Object objRememberedValue11 = gapComposer2.rememberedValue();
                if (i15 != 0 || objRememberedValue11 == neverEqualPolicy2) {
                    byte b8 = b4;
                    song5 = song8;
                    mutableState2 = mutableStateRememberSaveable2;
                    playerConnection2 = playerConnection3;
                    gapComposer = gapComposer2;
                    b5 = b8;
                    songMenuKt$$ExternalSyntheticLambda20 = new SongMenuKt$$ExternalSyntheticLambda20(song5, coroutineScope2, musicDatabase2, playerConnection2, function0, mutableState6, (byte) 0);
                    coroutineScope = coroutineScope2;
                    musicDatabase = musicDatabase2;
                    gapComposer.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda20);
                } else {
                    mutableState2 = mutableStateRememberSaveable2;
                    songMenuKt$$ExternalSyntheticLambda20 = objRememberedValue11;
                    playerConnection2 = playerConnection3;
                    b5 = b4;
                    gapComposer = gapComposer2;
                    song5 = song8;
                    coroutineScope = coroutineScope2;
                    musicDatabase = musicDatabase2;
                }
                Function1 function4 = (Function1) songMenuKt$$ExternalSyntheticLambda20;
                boolean zChanged5 = gapComposer.changed(mutableState6);
                Object objRememberedValue12 = gapComposer.rememberedValue();
                if (zChanged5 || objRememberedValue12 == neverEqualPolicy2) {
                    objRememberedValue12 = new SongMenuKt$$ExternalSyntheticLambda2(mutableState6, (byte) 1);
                    gapComposer.updateRememberedValue(objRememberedValue12);
                }
                GapComposer gapComposer3 = gapComposer;
                song2 = song5;
                playerConnection = playerConnection2;
                neverEqualPolicy = neverEqualPolicy2;
                mutableState = mutableStateCollectAsStateWithLifecycle;
                mutableState4 = mutableStateRememberSaveable;
                mutableState3 = mutableState6;
                ?? r0 = b5;
                DialogKt.m1470TextFieldDialog5RwOfIE(null, composableLambdaImpl, composableLambdaImpl2, null, false, false, 0, null, 0, null, listListOf, function3, function4, (Function0) objRememberedValue12, false, null, gapComposer3, 432, 0, 100345);
                ?? r110 = gapComposer3;
                r110.end(r0);
                i7 = r0;
                r15 = r110;
            } else {
                mutableState = mutableStateCollectAsStateWithLifecycle;
                mutableState2 = mutableStateRememberSaveable2;
                mutableState3 = mutableState6;
                song2 = song8;
                neverEqualPolicy = neverEqualPolicy2;
                coroutineScope = coroutineScope2;
                mutableState4 = mutableStateRememberSaveable;
                playerConnection = playerConnection3;
                mutableStateProduceState = mutableStateProduceState;
                mutableState7 = mutableState7;
                i7 = 0;
                GapComposer gapComposer4 = gapComposer2;
                musicDatabase = musicDatabase2;
                gapComposer4.startReplaceGroup(620721551);
                gapComposer4.end(false);
                r15 = gapComposer4;
            }
            Object[] objArr4 = new Object[i7];
            Object objRememberedValue13 = r15.rememberedValue();
            NeverEqualPolicy neverEqualPolicy3 = neverEqualPolicy;
            Object obj8 = objRememberedValue13;
            if (objRememberedValue13 == neverEqualPolicy3) {
                QueueKt$$ExternalSyntheticLambda2 queueKt$$ExternalSyntheticLambda2 = new QueueKt$$ExternalSyntheticLambda2((byte) 3);
                r15.updateRememberedValue(queueKt$$ExternalSyntheticLambda2);
                obj8 = queueKt$$ExternalSyntheticLambda2;
            }
            final MutableState mutableState8 = (MutableState) SaverKt.rememberSaveable(objArr4, (Function0) obj8, r15, 48);
            Object[] objArr5 = new Object[i7];
            Object objRememberedValue14 = r15.rememberedValue();
            Object obj9 = objRememberedValue14;
            if (objRememberedValue14 == neverEqualPolicy3) {
                QueueKt$$ExternalSyntheticLambda2 queueKt$$ExternalSyntheticLambda3 = new QueueKt$$ExternalSyntheticLambda2((byte) 2);
                r15.updateRememberedValue(queueKt$$ExternalSyntheticLambda3);
                obj9 = queueKt$$ExternalSyntheticLambda3;
            }
            MutableState mutableState9 = (MutableState) SaverKt.rememberSaveable(objArr5, (Function0) obj9, r15, 48);
            boolean zBooleanValue = ((Boolean) mutableState8.getValue()).booleanValue();
            Song song9 = song2;
            boolean zChanged6 = r15.changed(song9);
            Object objRememberedValue15 = r15.rememberedValue();
            if (zChanged6 || objRememberedValue15 == neverEqualPolicy3) {
                r13 = 0;
                SongMenuKt$SongMenu$4$1 songMenuKt$SongMenu$4$1 = new SongMenuKt$SongMenu$4$1(song9, false ? 1 : 0, i7);
                r15.updateRememberedValue(songMenuKt$SongMenu$4$1);
                obj = songMenuKt$SongMenu$4$1;
            } else {
                r13 = 0;
                obj = objRememberedValue15;
            }
            Function1 function5 = (Function1) obj;
            boolean zChanged7 = r15.changed(song9);
            Object objRememberedValue16 = r15.rememberedValue();
            if (zChanged7 || objRememberedValue16 == neverEqualPolicy3) {
                b = 1;
                SongMenuKt$SongMenu$4$1 songMenuKt$SongMenu$4$2 = new SongMenuKt$SongMenu$4$1(song9, r13, b);
                r15.updateRememberedValue(songMenuKt$SongMenu$4$2);
                obj2 = songMenuKt$SongMenu$4$2;
            } else {
                b = 1;
                obj2 = objRememberedValue16;
            }
            Function1 function6 = (Function1) obj2;
            boolean zChanged8 = r15.changed(mutableState8);
            Object objRememberedValue17 = r15.rememberedValue();
            Object obj10 = objRememberedValue17;
            if (zChanged8 || objRememberedValue17 == neverEqualPolicy3) {
                SongMenuKt$$ExternalSyntheticLambda2 songMenuKt$$ExternalSyntheticLambda2 = new SongMenuKt$$ExternalSyntheticLambda2(mutableState8, i7);
                r15.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda2);
                obj10 = songMenuKt$$ExternalSyntheticLambda2;
            }
            AlbumMenuKt.AddToPlaylistDialog(zBooleanValue, false, function5, function6, (Function0) obj10, null, r15, 0);
            if (((Boolean) mutableState9.getValue()).booleanValue()) {
                r15.startReplaceGroup(621214854);
                int i16 = (r15.changed(mutableState9) ? 1 : 0) | ((i14 & 57344) == 16384 ? b : i7);
                Object objRememberedValue18 = r15.rememberedValue();
                if (i16 != 0 || objRememberedValue18 == neverEqualPolicy3) {
                    function1 = function0;
                    SongMenuKt$$ExternalSyntheticLambda3 songMenuKt$$ExternalSyntheticLambda3 = new SongMenuKt$$ExternalSyntheticLambda3(function1, mutableState9, i7);
                    r15.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda3);
                    obj7 = songMenuKt$$ExternalSyntheticLambda3;
                } else {
                    function1 = function0;
                    obj7 = objRememberedValue18;
                }
                Function0 function7 = (Function0) obj7;
                boolean zChanged9 = r15.changed(mutableState9) | r15.changed(song9);
                Object objRememberedValue19 = r15.rememberedValue();
                Object obj11 = objRememberedValue19;
                if (zChanged9 || objRememberedValue19 == neverEqualPolicy3) {
                    SongMenuKt$$ExternalSyntheticLambda4 songMenuKt$$ExternalSyntheticLambda4 = new SongMenuKt$$ExternalSyntheticLambda4(song9, mutableState9, (byte) i7);
                    r15.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda4);
                    obj11 = songMenuKt$$ExternalSyntheticLambda4;
                }
                DialogKt.ListDialog(function7, r13, (Function1) obj11, r15, i7);
                r15.end(i7);
            } else {
                function1 = function0;
                r15.startReplaceGroup(622207567);
                r15.end(i7);
            }
            Object[] objArr6 = new Object[i7];
            Object objRememberedValue20 = r15.rememberedValue();
            if (objRememberedValue20 == neverEqualPolicy3) {
                b2 = 4;
                QueueKt$$ExternalSyntheticLambda2 queueKt$$ExternalSyntheticLambda4 = new QueueKt$$ExternalSyntheticLambda2(b2);
                r15.updateRememberedValue(queueKt$$ExternalSyntheticLambda4);
                obj3 = queueKt$$ExternalSyntheticLambda4;
            } else {
                b2 = 4;
                obj3 = objRememberedValue20;
            }
            final MutableState mutableState10 = (MutableState) SaverKt.rememberSaveable(objArr6, (Function0) obj3, r15, 48);
            Object[] objArr7 = new Object[i7];
            Object objRememberedValue21 = r15.rememberedValue();
            byte b9 = 5;
            Object obj12 = objRememberedValue21;
            if (objRememberedValue21 == neverEqualPolicy3) {
                QueueKt$$ExternalSyntheticLambda2 queueKt$$ExternalSyntheticLambda5 = new QueueKt$$ExternalSyntheticLambda2(b9);
                r15.updateRememberedValue(queueKt$$ExternalSyntheticLambda5);
                obj12 = queueKt$$ExternalSyntheticLambda5;
            }
            MutableState mutableState11 = (MutableState) SaverKt.rememberSaveable(objArr7, (Function0) obj12, r15, 48);
            Object objRememberedValue22 = r15.rememberedValue();
            Object obj13 = objRememberedValue22;
            if (objRememberedValue22 == neverEqualPolicy3) {
                ParcelableSnapshotMutableState parcelableSnapshotMutableStateMutableStateOf$default = Stack.mutableStateOf$default(bool);
                r15.updateRememberedValue(parcelableSnapshotMutableStateMutableStateOf$default);
                obj13 = parcelableSnapshotMutableStateMutableStateOf$default;
            }
            MutableState mutableState12 = (MutableState) obj13;
            if (((Boolean) mutableState11.getValue()).booleanValue()) {
                r15.startReplaceGroup(622599252);
                boolean zChanged10 = r15.changed(mutableState11);
                Object objRememberedValue23 = r15.rememberedValue();
                if (zChanged10 || objRememberedValue23 == neverEqualPolicy3) {
                    obj6 = objRememberedValue23;
                    TooltipKt$$ExternalSyntheticLambda2 tooltipKt$$ExternalSyntheticLambda2 = new TooltipKt$$ExternalSyntheticLambda2(mutableState12, mutableState11, b2);
                    r15.updateRememberedValue(tooltipKt$$ExternalSyntheticLambda2);
                    obj6 = tooltipKt$$ExternalSyntheticLambda2;
                }
                ComposableLambdaImpl composableLambdaImpl3 = AlbumMenuKt.f131lambda$1766673118;
                ComposableLambdaImpl composableLambdaImpl4 = AlbumMenuKt.f150lambda$1898996863;
                ?? r26 = i7;
                song3 = song9;
                ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Expect_jvmKt.rememberComposableLambda(-1025796808, new SongMenuKt$$ExternalSyntheticLambda8(context, mutableState11, mutableState12, musicDatabase, song9, function1, coroutineScope), r15);
                ComposableLambdaImpl composableLambdaImpl5 = AlbumMenuKt.lambda$1937843470;
                b3 = 5;
                ?? r8 = r15;
                mutableState5 = mutableState11;
                boolean z7 = r26 == true ? 1 : 0;
                DialogKt.DefaultDialog((Function0) obj6, null, composableLambdaImpl3, composableLambdaImpl4, composableLambdaImplRememberComposableLambda, null, composableLambdaImpl5, r8, 1600896, 34);
                ?? r9 = r8;
                r9.end(z7);
                r7 = r9;
                r16 = z7;
            } else {
                ?? r111 = i7;
                mutableState5 = mutableState11;
                b3 = 5;
                song3 = song9;
                ?? r10 = r15;
                r10.startReplaceGroup(626284687);
                r10.end(r111);
                r7 = r10;
                r16 = r111;
            }
            if (((Boolean) mutableState10.getValue()).booleanValue()) {
                r7.startReplaceGroup(626376912);
                boolean zChanged11 = r7.changed(mutableState10);
                Object objRememberedValue24 = r7.rememberedValue();
                if (zChanged11 || objRememberedValue24 == neverEqualPolicy3) {
                    obj5 = objRememberedValue24;
                    SongMenuKt$$ExternalSyntheticLambda2 songMenuKt$$ExternalSyntheticLambda5 = new SongMenuKt$$ExternalSyntheticLambda2(mutableState10, b3);
                    r7.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda5);
                    obj5 = songMenuKt$$ExternalSyntheticLambda5;
                }
                Function0 function8 = (Function0) obj5;
                navHostController = navHostController2;
                c = 16384;
                int i17 = (((r7.changed(song3) ? 1 : 0) | (r7.changedInstance(navHostController) ? 1 : 0) ? 1 : 0) | (r7.changed(mutableState10) ? 1 : 0) ? 1 : 0) | ((r12 & 57344) == 16384 ? 1 : r16);
                Object objRememberedValue25 = r7.rememberedValue();
                if (i17 != 0 || objRememberedValue25 == neverEqualPolicy3) {
                    song4 = song3;
                    MainActivity$$ExternalSyntheticLambda59 mainActivity$$ExternalSyntheticLambda59 = new MainActivity$$ExternalSyntheticLambda59((Object) song4, navHostController, mutableState10, function0, (byte) 16);
                    r7.updateRememberedValue(mainActivity$$ExternalSyntheticLambda59);
                    objRememberedValue25 = mainActivity$$ExternalSyntheticLambda59;
                } else {
                    song4 = song3;
                }
                DialogKt.ListDialog(function8, null, (Function1) objRememberedValue25, r7, r16);
                r7.end(r16);
            } else {
                song4 = song3;
                navHostController = navHostController2;
                c = 16384;
                r7.startReplaceGroup(628190319);
                r7.end(r16);
            }
            final NavHostController navHostController3 = navHostController;
            ?? r11 = r7;
            ?? r27 = r16;
            MenuKt.SongListItem(song4, null, null, false, false, false, null, AlbumMenuKt.lambda$1401506645, false, false, false, Expect_jvmKt.rememberComposableLambda(-159047721, new QueueMenuKt$$ExternalSyntheticLambda9((Object) song4, musicDatabase, (Object) coroutineScope, (Object) context, (Object) syncUtils, (byte) 6), r7), null, r11, 12582912, 384, 12158);
            final Song song10 = song4;
            CardKt.m261HorizontalDivider9IZ8Weo(null, CropImageView.DEFAULT_ASPECT_RATIO, 0L, r11, 0, 7);
            OffsetKt.Spacer(r11, SizeKt.m145height3ABfNKs(Modifier.Companion.$$INSTANCE, 12.0f));
            final BottomSheetPageState bottomSheetPageState = (BottomSheetPageState) r11.consume(BottomSheetPageKt.LocalBottomSheetPageState);
            int i18 = ((Configuration) r11.consume(AndroidCompositionLocals_androidKt.LocalConfiguration)).orientation;
            boolean z8 = (listenTogetherManager == null || !listenTogetherManager.client.isInRoom() || listenTogetherManager.isHost()) ? r27 == true ? 1 : 0 : true;
            WeakHashMap weakHashMap = WindowInsetsHolder.viewMap;
            PaddingValuesImpl paddingValuesImpl = new PaddingValuesImpl(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, OffsetKt.asPaddingValues(OffsetKt.current(r11).systemBars, r11).mo122calculateBottomPaddingD9Ej5fM() + 8.0f + CropImageView.DEFAULT_ASPECT_RATIO);
            final MutableState mutableState13 = mutableState4;
            final MutableState mutableState14 = mutableState2;
            final MutableState mutableState15 = mutableState3;
            boolean z9 = ((((r11.changed(mutableState13) ? 1 : 0) | (r11.changed(song10) ? 1 : 0) ? 1 : 0) | (r11.changed(mutableState14) ? 1 : 0) ? 1 : 0) | (r11.changed(mutableState15) ? 1 : 0) ? 1 : 0) | (r11.changed(mutableState8) ? 1 : 0);
            final PlayerConnection playerConnection4 = playerConnection;
            final MutableState mutableState16 = mutableState7;
            final CoroutineScope coroutineScope4 = coroutineScope;
            final boolean z10 = z8;
            final MutableState mutableState17 = mutableState5;
            final MutableState mutableState18 = mutableState;
            boolean z11 = (((((((((((r12 & 112) == 32 ? true : r27 == true ? 1 : 0) | ((((((((((z9 ? 1 : 0) | ((r12 & 57344) == 16384 ? true : r27 == true ? 1 : 0) ? 1 : 0) | (r11.changedInstance(context) ? 1 : 0) ? 1 : 0) | (r11.changed(z8) ? 1 : 0) ? 1 : 0) | (r11.changedInstance(listenTogetherManager) ? 1 : 0) ? 1 : 0) | (r11.changedInstance(playerConnection4) ? 1 : 0) ? 1 : 0) | (r11.changed(mutableState16) ? 1 : 0) ? 1 : 0) | (r11.changedInstance(coroutineScope4) ? 1 : 0) ? 1 : 0) | (r11.changedInstance(musicDatabase) ? 1 : 0) ? 1 : 0) | (r11.changedInstance(syncUtils) ? 1 : 0) ? 1 : 0) ? 1 : 0) | ((r12 & 896) != 256 ? r27 == true ? 1 : 0 : true) ? 1 : 0) | ((r12 & 7168) == 2048 ? true : r27 == true ? 1 : 0) ? 1 : 0) | ((r12 & 458752) == 131072 ? true : r27 == true ? 1 : 0) ? 1 : 0) | (r11.changedInstance(cachePlaylistViewModel) ? 1 : 0) ? 1 : 0) | (r11.changed(mutableState17) ? 1 : 0) ? 1 : 0) | (r11.changed(mutableState18) ? 1 : 0) ? 1 : 0) | (r11.changedInstance(r11) ? 1 : 0) ? 1 : 0) | (r11.changedInstance(navHostController3) ? 1 : 0) ? 1 : 0) | (r11.changed(mutableState10) ? 1 : 0);
            final boolean z12 = z5;
            boolean z13 = (((((z11 ? 1 : 0) | (r11.changed(z12) ? 1 : 0) ? 1 : 0) | (r11.changed(mutableStateProduceState) ? 1 : 0) ? 1 : 0) | (r11.changed(animateAsStateAnimateFloatAsState) ? 1 : 0) ? 1 : 0) | (r11.changedInstance(coroutineScope3) ? 1 : 0) ? 1 : 0) | (r11.changed(bottomSheetPageState) ? 1 : 0);
            Object objRememberedValue26 = r11.rememberedValue();
            if (z13 == 0) {
                r19 = r11;
                if (objRememberedValue26 != neverEqualPolicy3) {
                    r17 = r19;
                    r18 = r19;
                    event4 = event6;
                    playlistSong4 = playlistSong6;
                    obj4 = objRememberedValue26;
                }
                IntMath.LazyColumn(null, null, paddingValuesImpl, null, null, null, false, null, (Function1) obj4, r18, 0, 507);
                event3 = event4;
                playlistSong3 = playlistSong4;
                str2 = str4;
                z2 = z4;
                r14 = r18;
            } else {
                r17 = r11;
            }
            r17 = r19;
            playlistSong4 = playlistSong6;
            final MusicDatabase musicDatabase3 = musicDatabase;
            final MutableState mutableState19 = mutableStateProduceState;
            event4 = event6;
            Function1 function9 = new Function1() { // from class: com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj14) {
                    LazyListIntervalContent lazyListIntervalContent = (LazyListIntervalContent) obj14;
                    lazyListIntervalContent.getClass();
                    boolean z14 = z10;
                    Song song11 = song10;
                    MutableState mutableState20 = mutableState13;
                    MutableState mutableState21 = mutableState14;
                    MutableState mutableState22 = mutableState15;
                    MutableState mutableState23 = mutableState8;
                    Function0 function10 = function0;
                    Context context2 = context;
                    LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, new ComposableLambdaImpl(true, -1071659288, new TimePickerKt$$ExternalSyntheticLambda8(z14, song11, mutableState20, mutableState21, mutableState22, mutableState23, function10, context2, (byte) 2)), 3);
                    LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, new ComposableLambdaImpl(true, 1228990943, new SongMenuKt$$ExternalSyntheticLambda32(listenTogetherManager, song11, function10, z14, playerConnection4)), 3);
                    LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, AlbumMenuKt.lambda$1238761504, 3);
                    CoroutineScope coroutineScope5 = coroutineScope4;
                    State state = mutableState16;
                    MusicDatabase musicDatabase4 = musicDatabase3;
                    LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, new ComposableLambdaImpl(true, 1248532065, new SongMenuKt$$ExternalSyntheticLambda33(coroutineScope5, state, musicDatabase4, song11, function10, syncUtils, event4, playlistSong4, str4, z4, cachePlaylistViewModel, mutableState17)), 3);
                    LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, AlbumMenuKt.lambda$1258302626, 3);
                    LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, new ComposableLambdaImpl(true, 1268073187, new SongMenuKt$$ExternalSyntheticLambda34(context2, song11, downloadUtil, mutableState18, (byte) 0)), 3);
                    LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, AlbumMenuKt.lambda$1277843748, 3);
                    LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, new ComposableLambdaImpl(true, 1287614309, new SongMenuKt$$ExternalSyntheticLambda33(song11, navHostController3, function10, mutableState10, coroutineScope3, musicDatabase4, bottomSheetPageState, coroutineScope5, mutableState19, z12, animateAsStateAnimateFloatAsState, parcelableSnapshotMutableFloatState)), 3);
                    return Unit.INSTANCE;
                }
            };
            ?? r112 = r17;
            r112.updateRememberedValue(function9);
            obj4 = function9;
            r18 = r112;
            IntMath.LazyColumn(null, null, paddingValuesImpl, null, null, null, false, null, (Function1) obj4, r18, 0, 507);
            event3 = event4;
            playlistSong3 = playlistSong4;
            str2 = str4;
            z2 = z4;
            r14 = r18;
        } else {
            GapComposer gapComposer5 = gapComposer2;
            gapComposer5.skipToGroupEnd();
            z2 = z;
            event3 = event2;
            playlistSong3 = playlistSong2;
            str2 = str;
            r14 = gapComposer5;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup2 = r14.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup2 != null) {
            final byte b10 = 1;
            recomposeScopeImplEndRestartGroup2.block = new Function2() { // from class: com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj14, Object obj15) {
                    byte b11 = b10;
                    Unit unit = Unit.INSTANCE;
                    int i19 = i;
                    switch (b11) {
                        case 0:
                            ((Integer) obj15).getClass();
                            int iUpdateChangedFlags = Stack.updateChangedFlags(i19 | 1);
                            SongMenuKt.SongMenu(song, event3, playlistSong3, str2, function0, z2, (Composer) obj14, iUpdateChangedFlags, i2);
                            break;
                        default:
                            ((Integer) obj15).getClass();
                            int iUpdateChangedFlags2 = Stack.updateChangedFlags(i19 | 1);
                            SongMenuKt.SongMenu(song, event3, playlistSong3, str2, function0, z2, (Composer) obj14, iUpdateChangedFlags2, i2);
                            break;
                    }
                    return unit;
                }
            };
        }
    }
}
