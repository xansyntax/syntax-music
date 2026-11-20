package com.metrolist.music.ui.menu;

import android.content.Context;
import android.content.res.Configuration;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsHolder;
import androidx.compose.foundation.lazy.LazyListIntervalContent;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.ListItemKt$$ExternalSyntheticLambda17;
import androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda2;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.navigation.NavHostController;
import androidx.room.coroutines.FlowUtil$createFlow$$inlined$map$1;
import coil3.util.FileSystemsKt;
import com.dokar.quickjs.QuickJs;
import com.google.common.math.IntMath;
import com.metrolist.innertube.models.AlbumItem;
import com.metrolist.innertube.models.ArtistItem;
import com.metrolist.innertube.models.PlaylistItem;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda21;
import com.metrolist.music.MainActivityKt;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.AlbumEntity;
import com.metrolist.music.db.entities.AlbumWithSongs;
import com.metrolist.music.db.entities.ArtistEntity;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.db.entities.SongEntity;
import com.metrolist.music.listentogether.ListenTogetherManager;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.playback.DownloadUtil;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.ui.component.DialogKt;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda2;
import com.metrolist.music.ui.screens.AlbumScreenKt$$ExternalSyntheticLambda7;
import com.metrolist.music.ui.screens.HistoryScreenKt$$ExternalSyntheticLambda14;
import com.metrolist.music.ui.screens.LoginScreenKt$$ExternalSyntheticLambda0;
import com.metrolist.music.utils.DataStoreKt$get$1;
import com.metrolist.music.utils.SyncUtils;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;
import kotlin.text.HexFormatKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class YouTubeAlbumMenuKt {
    public static final void SelectionMediaMetadataMenu(List list, List list2, Function0 function0, Function0 function1, Composer composer, int i) {
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        SelectionSongsMenuKt$$ExternalSyntheticLambda0 selectionSongsMenuKt$$ExternalSyntheticLambda0;
        boolean z;
        boolean z2;
        Object youTubePlaylistMenuKt$YouTubePlaylistMenu$6$1;
        List list3;
        DownloadUtil downloadUtil;
        DownloadUtil downloadUtil2;
        GapComposer gapComposer;
        boolean z3;
        GapComposer gapComposer2;
        list.getClass();
        list2.getClass();
        function0.getClass();
        function1.getClass();
        GapComposer gapComposer3 = (GapComposer) composer;
        gapComposer3.startRestartGroup(780116171);
        byte b = 2;
        int i2 = i | (gapComposer3.changed(list) ? 4 : 2);
        if ((i & 48) == 0) {
            i2 |= gapComposer3.changed(list2) ? 32 : 16;
        }
        int i3 = i2 | (gapComposer3.changedInstance(function0) ? 256 : 128) | (gapComposer3.changedInstance(function1) ? 2048 : 1024);
        if (gapComposer3.shouldExecute(i3 & 1, (i3 & 1171) != 1170)) {
            Context context = (Context) gapComposer3.consume(AndroidCompositionLocals_androidKt.LocalContext);
            MusicDatabase musicDatabase = (MusicDatabase) gapComposer3.consume(MainActivityKt.LocalDatabase);
            DownloadUtil downloadUtil3 = (DownloadUtil) gapComposer3.consume(MainActivityKt.LocalDownloadUtil);
            Object objRememberedValue = gapComposer3.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Stack.createCompositionCoroutineScope(gapComposer3);
                gapComposer3.updateRememberedValue(objRememberedValue);
            }
            PlayerConnection playerConnection = (PlayerConnection) gapComposer3.consume(MainActivityKt.LocalPlayerConnection);
            if (playerConnection == null) {
                recomposeScopeImplEndRestartGroup = gapComposer3.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup == null) {
                    return;
                } else {
                    selectionSongsMenuKt$$ExternalSyntheticLambda0 = new SelectionSongsMenuKt$$ExternalSyntheticLambda0(list, list2, function0, function1, i, (byte) 0);
                }
            } else {
                ListenTogetherManager listenTogetherManager = (ListenTogetherManager) gapComposer3.consume(MainActivityKt.LocalListenTogetherManager);
                boolean z4 = (listenTogetherManager == null || !listenTogetherManager.client.isInRoom() || listenTogetherManager.isHost()) ? false : true;
                int i4 = i3 & 14;
                boolean z5 = i4 == 4;
                Object objRememberedValue2 = gapComposer3.rememberedValue();
                if (z5 || objRememberedValue2 == neverEqualPolicy) {
                    if (list.isEmpty()) {
                        z = false;
                    } else {
                        if (!list.isEmpty()) {
                            Iterator it = list.iterator();
                            if (it.hasNext()) {
                                ((MediaMetadata) it.next()).getClass();
                                z = false;
                            }
                        }
                        z = true;
                    }
                    objRememberedValue2 = Stack.mutableStateOf$default(Boolean.valueOf(z));
                    gapComposer3.updateRememberedValue(objRememberedValue2);
                }
                MutableState mutableState = (MutableState) objRememberedValue2;
                Object[] objArr = new Object[0];
                Object objRememberedValue3 = gapComposer3.rememberedValue();
                if (objRememberedValue3 == neverEqualPolicy) {
                    objRememberedValue3 = new AlbumMenuKt$$ExternalSyntheticLambda3((byte) 28);
                    gapComposer3.updateRememberedValue(objRememberedValue3);
                }
                MutableState mutableState2 = (MutableState) SaverKt.rememberSaveable(objArr, (Function0) objRememberedValue3, gapComposer3, 48);
                Object objRememberedValue4 = gapComposer3.rememberedValue();
                if (objRememberedValue4 == neverEqualPolicy) {
                    objRememberedValue4 = Stack.mutableStateOf$default(new ArrayList());
                    gapComposer3.updateRememberedValue(objRememberedValue4);
                }
                boolean zBooleanValue = ((Boolean) mutableState2.getValue()).booleanValue();
                boolean zChangedInstance = (i4 == 4) | gapComposer3.changedInstance(musicDatabase);
                Object objRememberedValue5 = gapComposer3.rememberedValue();
                Continuation continuation = null;
                if (zChangedInstance || objRememberedValue5 == neverEqualPolicy) {
                    objRememberedValue5 = new QuickJs.AnonymousClass2(list, musicDatabase, continuation, b);
                    gapComposer3.updateRememberedValue(objRememberedValue5);
                }
                Function1 function2 = (Function1) objRememberedValue5;
                boolean z6 = i4 == 4;
                Object objRememberedValue6 = gapComposer3.rememberedValue();
                if (z6 || objRememberedValue6 == neverEqualPolicy) {
                    objRememberedValue6 = new YouTubePlaylistMenuKt$YouTubePlaylistMenu$3$1(list, continuation, (byte) 1);
                    gapComposer3.updateRememberedValue(objRememberedValue6);
                }
                Function1 function3 = (Function1) objRememberedValue6;
                boolean zChanged = gapComposer3.changed(mutableState2);
                Object objRememberedValue7 = gapComposer3.rememberedValue();
                if (zChanged || objRememberedValue7 == neverEqualPolicy) {
                    objRememberedValue7 = new QueueMenuKt$$ExternalSyntheticLambda2(mutableState2, (byte) 21);
                    gapComposer3.updateRememberedValue(objRememberedValue7);
                }
                boolean z7 = z4;
                Continuation continuation2 = null;
                AlbumMenuKt.AddToPlaylistDialog(zBooleanValue, false, function2, function3, (Function0) objRememberedValue7, null, gapComposer3, 0);
                Object objRememberedValue8 = gapComposer3.rememberedValue();
                if (objRememberedValue8 == neverEqualPolicy) {
                    z2 = true;
                    objRememberedValue8 = Fragment$5$$ExternalSyntheticOutline0.m(1, gapComposer3);
                } else {
                    z2 = true;
                }
                ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = (ParcelableSnapshotMutableIntState) objRememberedValue8;
                boolean zChangedInstance2 = (i4 != 4 ? false : z2) | gapComposer3.changedInstance(downloadUtil3);
                Object objRememberedValue9 = gapComposer3.rememberedValue();
                if (zChangedInstance2 || objRememberedValue9 == neverEqualPolicy) {
                    list3 = list;
                    downloadUtil = downloadUtil3;
                    youTubePlaylistMenuKt$YouTubePlaylistMenu$6$1 = new YouTubePlaylistMenuKt$YouTubePlaylistMenu$6$1(list3, downloadUtil, parcelableSnapshotMutableIntState, continuation2, (byte) 1);
                    gapComposer3.updateRememberedValue(youTubePlaylistMenuKt$YouTubePlaylistMenu$6$1);
                } else {
                    youTubePlaylistMenuKt$YouTubePlaylistMenu$6$1 = objRememberedValue9;
                    downloadUtil = downloadUtil3;
                    list3 = list;
                }
                Stack.LaunchedEffect(gapComposer3, list3, (Function2) youTubePlaylistMenuKt$YouTubePlaylistMenu$6$1);
                Object objRememberedValue10 = gapComposer3.rememberedValue();
                if (objRememberedValue10 == neverEqualPolicy) {
                    objRememberedValue10 = Stack.mutableStateOf$default(Boolean.FALSE);
                    gapComposer3.updateRememberedValue(objRememberedValue10);
                }
                MutableState mutableState3 = (MutableState) objRememberedValue10;
                if (((Boolean) mutableState3.getValue()).booleanValue()) {
                    gapComposer3.startReplaceGroup(375198359);
                    Object objRememberedValue11 = gapComposer3.rememberedValue();
                    if (objRememberedValue11 == neverEqualPolicy) {
                        objRememberedValue11 = new QueueMenuKt$$ExternalSyntheticLambda2(mutableState3, (byte) 25);
                        gapComposer3.updateRememberedValue(objRememberedValue11);
                    }
                    z3 = false;
                    downloadUtil2 = downloadUtil;
                    DialogKt.DefaultDialog((Function0) objRememberedValue11, null, null, null, Expect_jvmKt.rememberComposableLambda(908833342, new SelectionSongsMenuKt$$ExternalSyntheticLambda4((byte) 0, context, mutableState3, list3), gapComposer3), null, AlbumMenuKt.lambda$271762856, gapComposer3, 1597446, 46);
                    gapComposer = gapComposer3;
                    gapComposer.end(false);
                } else {
                    downloadUtil2 = downloadUtil;
                    gapComposer = gapComposer3;
                    z3 = false;
                    gapComposer.startReplaceGroup(376459191);
                    gapComposer.end(false);
                }
                WeakHashMap weakHashMap = WindowInsetsHolder.viewMap;
                PaddingValuesImpl paddingValuesImpl = new PaddingValuesImpl(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, OffsetKt.asPaddingValues(OffsetKt.current(gapComposer).systemBars, gapComposer).mo122calculateBottomPaddingD9Ej5fM() + 8.0f + CropImageView.DEFAULT_ASPECT_RATIO);
                boolean zChanged2 = gapComposer.changed(z7) | ((i3 & 112) != 32 ? z3 : z2) | ((i3 & 896) == 256 ? z2 : z3) | gapComposer.changedInstance(playerConnection) | ((i3 & 7168) == 2048 ? z2 : z3);
                if (i4 == 4) {
                    z3 = z2;
                }
                DownloadUtil downloadUtil4 = downloadUtil2;
                boolean zChanged3 = zChanged2 | z3 | gapComposer.changed(mutableState2) | gapComposer.changed(mutableState) | gapComposer.changedInstance(musicDatabase) | gapComposer.changedInstance(downloadUtil4);
                Object objRememberedValue12 = gapComposer.rememberedValue();
                if (zChanged3 || objRememberedValue12 == neverEqualPolicy) {
                    gapComposer2 = gapComposer;
                    HistoryScreenKt$$ExternalSyntheticLambda14 historyScreenKt$$ExternalSyntheticLambda14 = new HistoryScreenKt$$ExternalSyntheticLambda14(list2, z7, function0, playerConnection, function1, list, mutableState2, musicDatabase, mutableState, downloadUtil4, parcelableSnapshotMutableIntState, mutableState3);
                    gapComposer2.updateRememberedValue(historyScreenKt$$ExternalSyntheticLambda14);
                    objRememberedValue12 = historyScreenKt$$ExternalSyntheticLambda14;
                } else {
                    gapComposer2 = gapComposer;
                }
                GapComposer gapComposer4 = gapComposer2;
                IntMath.LazyColumn(null, null, paddingValuesImpl, null, null, null, false, null, (Function1) objRememberedValue12, gapComposer4, 0, 507);
                gapComposer3 = gapComposer4;
            }
            recomposeScopeImplEndRestartGroup.block = selectionSongsMenuKt$$ExternalSyntheticLambda0;
        }
        gapComposer3.skipToGroupEnd();
        recomposeScopeImplEndRestartGroup = gapComposer3.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            selectionSongsMenuKt$$ExternalSyntheticLambda0 = new SelectionSongsMenuKt$$ExternalSyntheticLambda0(list, list2, function0, function1, i, (byte) 1);
            recomposeScopeImplEndRestartGroup.block = selectionSongsMenuKt$$ExternalSyntheticLambda0;
        }
    }

    public static final void SelectionSongMenu(final ArrayList arrayList, final Function0 function0, final Function0 function1, List list, boolean z, Function0 function2, Composer composer, final int i, final int i2) {
        final Function0 function3;
        List list2;
        int i3;
        boolean z2;
        int i4;
        Function0 function4;
        int i5;
        GapComposer gapComposer;
        final List list3;
        final Function0 function5;
        final boolean z3;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        Function2 function6;
        boolean z4;
        Object selectionSongsMenuKt$SelectionSongMenu$1$1;
        int i6;
        DownloadUtil downloadUtil;
        int i7;
        MutableState mutableState;
        GapComposer gapComposer2;
        boolean z5;
        boolean z6;
        MutableState mutableState2;
        NeverEqualPolicy neverEqualPolicy;
        CoroutineScope coroutineScope;
        MusicDatabase musicDatabase;
        final MutableState mutableState3;
        int i8;
        final List list4;
        final boolean z7;
        GapComposer gapComposer3;
        MutableState mutableState4;
        boolean z8;
        function0.getClass();
        function1.getClass();
        GapComposer gapComposer4 = (GapComposer) composer;
        gapComposer4.startRestartGroup(135370017);
        int i9 = (gapComposer4.changed(arrayList) ? 4 : 2) | i | (gapComposer4.changedInstance(function0) ? 32 : 16);
        if ((i & 384) == 0) {
            function3 = function1;
            i9 |= gapComposer4.changedInstance(function3) ? 256 : 128;
        } else {
            function3 = function1;
        }
        int i10 = i2 & 8;
        if (i10 != 0) {
            i3 = i9 | 3072;
            list2 = list;
        } else {
            list2 = list;
            i3 = i9 | (gapComposer4.changed(list2) ? 2048 : 1024);
        }
        int i11 = i2 & 16;
        if (i11 != 0) {
            i4 = i3 | 24576;
            z2 = z;
        } else {
            z2 = z;
            i4 = i3 | (gapComposer4.changed(z2) ? 16384 : 8192);
        }
        int i12 = i2 & 32;
        if (i12 != 0) {
            i5 = i4 | 196608;
            function4 = function2;
        } else {
            function4 = function2;
            i5 = i4 | (gapComposer4.changedInstance(function4) ? 131072 : 65536);
        }
        if (gapComposer4.shouldExecute(i5 & 1, (i5 & 74899) != 74898)) {
            List list5 = i10 != 0 ? EmptyList.INSTANCE : list2;
            boolean z9 = i11 != 0 ? false : z2;
            final List list6 = list5;
            Function0 function7 = i12 != 0 ? null : function4;
            Context context = (Context) gapComposer4.consume(AndroidCompositionLocals_androidKt.LocalContext);
            MusicDatabase musicDatabase2 = (MusicDatabase) gapComposer4.consume(MainActivityKt.LocalDatabase);
            DownloadUtil downloadUtil2 = (DownloadUtil) gapComposer4.consume(MainActivityKt.LocalDownloadUtil);
            Object objRememberedValue = gapComposer4.rememberedValue();
            NeverEqualPolicy neverEqualPolicy2 = Composer.Companion.Empty;
            if (objRememberedValue == neverEqualPolicy2) {
                objRememberedValue = Stack.createCompositionCoroutineScope(gapComposer4);
                gapComposer4.updateRememberedValue(objRememberedValue);
            }
            CoroutineScope coroutineScope2 = (CoroutineScope) objRememberedValue;
            final PlayerConnection playerConnection = (PlayerConnection) gapComposer4.consume(MainActivityKt.LocalPlayerConnection);
            if (playerConnection == null) {
                recomposeScopeImplEndRestartGroup = gapComposer4.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup == null) {
                    return;
                }
                final byte b = 0;
                final Function0 function8 = function7;
                final boolean z10 = z9;
                function6 = new Function2() { // from class: com.metrolist.music.ui.menu.SelectionSongsMenuKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        byte b2 = b;
                        Unit unit = Unit.INSTANCE;
                        short s = i;
                        switch (b2) {
                            case 0:
                                ((Integer) obj2).getClass();
                                int iUpdateChangedFlags = Stack.updateChangedFlags(s | 1);
                                YouTubeAlbumMenuKt.SelectionSongMenu(arrayList, function0, function3, list6, z10, function8, (Composer) obj, iUpdateChangedFlags, i2);
                                break;
                            default:
                                ((Integer) obj2).getClass();
                                int iUpdateChangedFlags2 = Stack.updateChangedFlags(s | 1);
                                YouTubeAlbumMenuKt.SelectionSongMenu(arrayList, function0, function3, list6, z10, function8, (Composer) obj, iUpdateChangedFlags2, i2);
                                break;
                        }
                        return unit;
                    }
                };
            } else {
                final Function0 function9 = function7;
                boolean z11 = z9;
                final SyncUtils syncUtils = (SyncUtils) gapComposer4.consume(MainActivityKt.LocalSyncUtils);
                String strStringResource = MathKt.stringResource(R.string.deleted_n_songs, gapComposer4);
                ListenTogetherManager listenTogetherManager = (ListenTogetherManager) gapComposer4.consume(MainActivityKt.LocalListenTogetherManager);
                boolean z12 = (listenTogetherManager == null || !listenTogetherManager.client.isInRoom() || listenTogetherManager.isHost()) ? false : true;
                Object objRememberedValue2 = gapComposer4.rememberedValue();
                if (objRememberedValue2 == neverEqualPolicy2) {
                    if (!arrayList.isEmpty()) {
                        int size = arrayList.size();
                        int i13 = 0;
                        while (true) {
                            if (i13 >= size) {
                                z8 = true;
                                break;
                            }
                            Object obj = arrayList.get(i13);
                            i13++;
                            if (((Song) obj).song.inLibrary == null) {
                                z8 = false;
                                break;
                            }
                        }
                    } else {
                        z8 = true;
                        break;
                    }
                    objRememberedValue2 = Stack.mutableStateOf$default(Boolean.valueOf(z8));
                    gapComposer4.updateRememberedValue(objRememberedValue2);
                }
                final MutableState mutableState5 = (MutableState) objRememberedValue2;
                int i14 = i5 & 14;
                boolean z13 = i14 == 4;
                Object objRememberedValue3 = gapComposer4.rememberedValue();
                if (z13 || objRememberedValue3 == neverEqualPolicy2) {
                    if (arrayList.isEmpty()) {
                        z4 = false;
                    } else {
                        if (!arrayList.isEmpty()) {
                            int size2 = arrayList.size();
                            int i15 = 0;
                            while (true) {
                                if (i15 < size2) {
                                    Object obj2 = arrayList.get(i15);
                                    i15++;
                                    if (!((Song) obj2).song.liked) {
                                        z4 = false;
                                    }
                                }
                            }
                        }
                        z4 = true;
                    }
                    objRememberedValue3 = Stack.mutableStateOf$default(Boolean.valueOf(z4));
                    gapComposer4.updateRememberedValue(objRememberedValue3);
                }
                MutableState mutableState6 = (MutableState) objRememberedValue3;
                Object objRememberedValue4 = gapComposer4.rememberedValue();
                if (objRememberedValue4 == neverEqualPolicy2) {
                    objRememberedValue4 = Fragment$5$$ExternalSyntheticOutline0.m(1, gapComposer4);
                }
                final ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = (ParcelableSnapshotMutableIntState) objRememberedValue4;
                boolean zChangedInstance = (i14 == 4) | gapComposer4.changedInstance(downloadUtil2);
                Object objRememberedValue5 = gapComposer4.rememberedValue();
                if (zChangedInstance || objRememberedValue5 == neverEqualPolicy2) {
                    i6 = i5;
                    downloadUtil = downloadUtil2;
                    selectionSongsMenuKt$SelectionSongMenu$1$1 = new SelectionSongsMenuKt$SelectionSongMenu$1$1(arrayList, downloadUtil, parcelableSnapshotMutableIntState, null, (byte) 0);
                    gapComposer4.updateRememberedValue(selectionSongsMenuKt$SelectionSongMenu$1$1);
                } else {
                    i6 = i5;
                    selectionSongsMenuKt$SelectionSongMenu$1$1 = objRememberedValue5;
                    downloadUtil = downloadUtil2;
                }
                Stack.LaunchedEffect(gapComposer4, arrayList, (Function2) selectionSongsMenuKt$SelectionSongMenu$1$1);
                Object[] objArr = new Object[0];
                Object objRememberedValue6 = gapComposer4.rememberedValue();
                if (objRememberedValue6 == neverEqualPolicy2) {
                    objRememberedValue6 = new AlbumMenuKt$$ExternalSyntheticLambda3((byte) 29);
                    gapComposer4.updateRememberedValue(objRememberedValue6);
                }
                final MutableState mutableState7 = (MutableState) SaverKt.rememberSaveable(objArr, (Function0) objRememberedValue6, gapComposer4, 48);
                Object objRememberedValue7 = gapComposer4.rememberedValue();
                if (objRememberedValue7 == neverEqualPolicy2) {
                    objRememberedValue7 = Stack.mutableStateOf$default(new ArrayList());
                    gapComposer4.updateRememberedValue(objRememberedValue7);
                }
                boolean zBooleanValue = ((Boolean) mutableState7.getValue()).booleanValue();
                boolean z14 = i14 == 4;
                Object objRememberedValue8 = gapComposer4.rememberedValue();
                if (z14 || objRememberedValue8 == neverEqualPolicy2) {
                    objRememberedValue8 = new SelectionSongsMenuKt$SelectionSongMenu$2$1(arrayList, null, (byte) 0);
                    gapComposer4.updateRememberedValue(objRememberedValue8);
                }
                Function1 function10 = (Function1) objRememberedValue8;
                boolean z15 = i14 == 4;
                Object objRememberedValue9 = gapComposer4.rememberedValue();
                if (z15 || objRememberedValue9 == neverEqualPolicy2) {
                    objRememberedValue9 = new SelectionSongsMenuKt$SelectionSongMenu$2$1(arrayList, null, (byte) 1);
                    gapComposer4.updateRememberedValue(objRememberedValue9);
                }
                Function1 function11 = (Function1) objRememberedValue9;
                boolean zChanged = gapComposer4.changed(mutableState7);
                Object objRememberedValue10 = gapComposer4.rememberedValue();
                if (zChanged || objRememberedValue10 == neverEqualPolicy2) {
                    objRememberedValue10 = new QueueMenuKt$$ExternalSyntheticLambda2(mutableState7, (byte) 16);
                    gapComposer4.updateRememberedValue(objRememberedValue10);
                }
                AlbumMenuKt.AddToPlaylistDialog(zBooleanValue, false, function10, function11, (Function0) objRememberedValue10, null, gapComposer4, 0);
                Object objRememberedValue11 = gapComposer4.rememberedValue();
                if (objRememberedValue11 == neverEqualPolicy2) {
                    objRememberedValue11 = Stack.mutableStateOf$default(Boolean.FALSE);
                    gapComposer4.updateRememberedValue(objRememberedValue11);
                }
                final MutableState mutableState8 = (MutableState) objRememberedValue11;
                Object objRememberedValue12 = gapComposer4.rememberedValue();
                if (objRememberedValue12 == neverEqualPolicy2) {
                    objRememberedValue12 = Stack.mutableStateOf$default(Boolean.FALSE);
                    gapComposer4.updateRememberedValue(objRememberedValue12);
                }
                MutableState mutableState9 = (MutableState) objRememberedValue12;
                Object objRememberedValue13 = gapComposer4.rememberedValue();
                if (objRememberedValue13 == neverEqualPolicy2) {
                    objRememberedValue13 = Stack.mutableStateOf$default(Boolean.FALSE);
                    gapComposer4.updateRememberedValue(objRememberedValue13);
                }
                MutableState mutableState10 = (MutableState) objRememberedValue13;
                Object objRememberedValue14 = gapComposer4.rememberedValue();
                if (objRememberedValue14 == neverEqualPolicy2) {
                    i7 = 0;
                    objRememberedValue14 = Fragment$5$$ExternalSyntheticOutline0.m(0, gapComposer4);
                } else {
                    i7 = 0;
                }
                ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState2 = (ParcelableSnapshotMutableIntState) objRememberedValue14;
                Object objRememberedValue15 = gapComposer4.rememberedValue();
                if (objRememberedValue15 == neverEqualPolicy2) {
                    objRememberedValue15 = Fragment$5$$ExternalSyntheticOutline0.m(i7, gapComposer4);
                }
                ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState3 = (ParcelableSnapshotMutableIntState) objRememberedValue15;
                byte b2 = 17;
                if (((Boolean) mutableState8.getValue()).booleanValue()) {
                    gapComposer4.startReplaceGroup(-163193892);
                    Object objRememberedValue16 = gapComposer4.rememberedValue();
                    if (objRememberedValue16 == neverEqualPolicy2) {
                        objRememberedValue16 = new QueueMenuKt$$ExternalSyntheticLambda2(mutableState8, b2);
                        gapComposer4.updateRememberedValue(objRememberedValue16);
                    }
                    mutableState = mutableState6;
                    neverEqualPolicy = neverEqualPolicy2;
                    mutableState2 = mutableState10;
                    z5 = false;
                    z6 = true;
                    DialogKt.DefaultDialog((Function0) objRememberedValue16, null, null, null, Expect_jvmKt.rememberComposableLambda(2137421070, new SelectionSongsMenuKt$$ExternalSyntheticLambda12((byte) 0, context, mutableState8, arrayList), gapComposer4), null, AlbumMenuKt.f129lambda$1760716572, gapComposer4, 1597446, 46);
                    gapComposer2 = gapComposer4;
                    gapComposer2.end(false);
                } else {
                    mutableState = mutableState6;
                    gapComposer2 = gapComposer4;
                    z5 = false;
                    z6 = true;
                    mutableState2 = mutableState10;
                    neverEqualPolicy = neverEqualPolicy2;
                    gapComposer2.startReplaceGroup(-161928255);
                    gapComposer2.end(false);
                }
                if (((Boolean) mutableState9.getValue()).booleanValue()) {
                    gapComposer2.startReplaceGroup(-161776696);
                    Object objRememberedValue17 = gapComposer2.rememberedValue();
                    if (objRememberedValue17 == neverEqualPolicy) {
                        mutableState4 = mutableState9;
                        objRememberedValue17 = new TooltipKt$$ExternalSyntheticLambda2(mutableState2, mutableState4, (byte) 3);
                        gapComposer2.updateRememberedValue(objRememberedValue17);
                    } else {
                        mutableState4 = mutableState9;
                    }
                    ComposableLambdaImpl composableLambdaImpl = AlbumMenuKt.f171lambda$206536337;
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Expect_jvmKt.rememberComposableLambda(47853070, new SongMenuKt$$ExternalSyntheticLambda37(mutableState2, (byte) 17), gapComposer2);
                    GapComposer gapComposer5 = gapComposer2;
                    MutableState mutableState11 = mutableState2;
                    coroutineScope = coroutineScope2;
                    PlayerMenuKt$$ExternalSyntheticLambda17 playerMenuKt$$ExternalSyntheticLambda17 = new PlayerMenuKt$$ExternalSyntheticLambda17(context, mutableState11, mutableState4, parcelableSnapshotMutableIntState3, parcelableSnapshotMutableIntState2, musicDatabase2, strStringResource, arrayList, function0, function1, coroutineScope);
                    mutableState3 = mutableState4;
                    musicDatabase = musicDatabase2;
                    i8 = 256;
                    DialogKt.DefaultDialog((Function0) objRememberedValue17, null, composableLambdaImpl, composableLambdaImplRememberComposableLambda, Expect_jvmKt.rememberComposableLambda(671467525, playerMenuKt$$ExternalSyntheticLambda17, gapComposer5), null, Expect_jvmKt.rememberComposableLambda(-227324325, new SongMenuKt$$ExternalSyntheticLambda34(arrayList, mutableState11, parcelableSnapshotMutableIntState2, parcelableSnapshotMutableIntState3, (byte) 9), gapComposer5), gapComposer5, 1600902, 34);
                    gapComposer2 = gapComposer5;
                    z5 = false;
                    gapComposer2.end(false);
                } else {
                    coroutineScope = coroutineScope2;
                    musicDatabase = musicDatabase2;
                    mutableState3 = mutableState9;
                    i8 = 256;
                    gapComposer2.startReplaceGroup(-158185439);
                    gapComposer2.end(z5);
                }
                int i16 = ((Configuration) gapComposer2.consume(AndroidCompositionLocals_androidKt.LocalConfiguration)).orientation;
                WeakHashMap weakHashMap = WindowInsetsHolder.viewMap;
                PaddingValuesImpl paddingValuesImpl = new PaddingValuesImpl(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, OffsetKt.asPaddingValues(OffsetKt.current(gapComposer2).systemBars, gapComposer2).mo122calculateBottomPaddingD9Ej5fM() + 8.0f + CropImageView.DEFAULT_ASPECT_RATIO);
                final DownloadUtil downloadUtil3 = downloadUtil;
                final MutableState mutableState12 = mutableState;
                boolean zChanged2 = gapComposer2.changed(z12) | ((i6 & 112) == 32 ? z6 : z5) | gapComposer2.changedInstance(playerConnection) | (i14 != 4 ? z5 : z6) | ((i6 & 896) == i8 ? z6 : z5) | gapComposer2.changed(mutableState7) | gapComposer2.changedInstance(musicDatabase) | gapComposer2.changedInstance(coroutineScope) | gapComposer2.changedInstance(downloadUtil3) | ((458752 & i6) == 131072 ? z6 : z5) | gapComposer2.changed(mutableState12) | gapComposer2.changedInstance(syncUtils) | ((i6 & 7168) != 2048 ? z5 : z6) | ((57344 & i6) == 16384 ? z6 : z5);
                Object objRememberedValue18 = gapComposer2.rememberedValue();
                if (zChanged2 || objRememberedValue18 == neverEqualPolicy) {
                    GapComposer gapComposer6 = gapComposer2;
                    list4 = r14;
                    final MusicDatabase musicDatabase3 = musicDatabase;
                    final CoroutineScope coroutineScope3 = coroutineScope;
                    final boolean z16 = z12;
                    z7 = z11;
                    Function1 function12 = new Function1() { // from class: com.metrolist.music.ui.menu.SelectionSongsMenuKt$$ExternalSyntheticLambda17
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj3) {
                            LazyListIntervalContent lazyListIntervalContent = (LazyListIntervalContent) obj3;
                            lazyListIntervalContent.getClass();
                            boolean z17 = z16;
                            Function0 function13 = function0;
                            PlayerConnection playerConnection2 = playerConnection;
                            ArrayList arrayList2 = arrayList;
                            Function0 function14 = function1;
                            MutableState mutableState13 = mutableState7;
                            LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, new ComposableLambdaImpl(true, -2016143114, new AlbumMenuKt$$ExternalSyntheticLambda16(z17, function13, playerConnection2, arrayList2, function14, mutableState13)), 3);
                            MusicDatabase musicDatabase4 = musicDatabase3;
                            LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, new ComposableLambdaImpl(true, 2064976941, new AlbumMenuKt$$ExternalSyntheticLambda17(z17, function13, playerConnection2, arrayList2, function14, mutableState13, musicDatabase4, coroutineScope3, mutableState5)), 3);
                            LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, AlbumMenuKt.lambda$1024685102, 3);
                            LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, new ComposableLambdaImpl(true, -15606737, new SelectionSongsMenuKt$$ExternalSyntheticLambda22(arrayList2, downloadUtil3, function9, function13, musicDatabase4, syncUtils, list4, function14, z7, parcelableSnapshotMutableIntState, mutableState8, mutableState12, mutableState3)), 3);
                            return Unit.INSTANCE;
                        }
                    };
                    gapComposer3 = gapComposer6;
                    gapComposer3.updateRememberedValue(function12);
                    objRememberedValue18 = function12;
                } else {
                    list4 = list6;
                    gapComposer3 = gapComposer2;
                    z7 = z11;
                }
                GapComposer gapComposer7 = gapComposer3;
                IntMath.LazyColumn(null, null, paddingValuesImpl, null, null, null, false, null, (Function1) objRememberedValue18, gapComposer7, 0, 507);
                gapComposer = gapComposer7;
                list3 = list4;
                z3 = z7;
                function5 = function9;
            }
            recomposeScopeImplEndRestartGroup.block = function6;
        }
        gapComposer = gapComposer4;
        gapComposer.skipToGroupEnd();
        list3 = list2;
        function5 = function4;
        z3 = z2;
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            final byte b3 = 1;
            function6 = new Function2() { // from class: com.metrolist.music.ui.menu.SelectionSongsMenuKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj3, Object obj4) {
                    byte b4 = b3;
                    Unit unit = Unit.INSTANCE;
                    short s = i;
                    switch (b4) {
                        case 0:
                            ((Integer) obj4).getClass();
                            int iUpdateChangedFlags = Stack.updateChangedFlags(s | 1);
                            YouTubeAlbumMenuKt.SelectionSongMenu(arrayList, function0, function1, list3, z3, function5, (Composer) obj3, iUpdateChangedFlags, i2);
                            break;
                        default:
                            ((Integer) obj4).getClass();
                            int iUpdateChangedFlags2 = Stack.updateChangedFlags(s | 1);
                            YouTubeAlbumMenuKt.SelectionSongMenu(arrayList, function0, function1, list3, z3, function5, (Composer) obj3, iUpdateChangedFlags2, i2);
                            break;
                    }
                    return unit;
                }
            };
            recomposeScopeImplEndRestartGroup.block = function6;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void YouTubeAlbumMenu(final AlbumItem albumItem, final Function0 function0, Composer composer, final int i) {
        final AlbumItem albumItem2;
        final Function0 function1;
        GapComposer gapComposer;
        DownloadUtil downloadUtil;
        int i2;
        Map map;
        byte b;
        NavHostController navHostController;
        GapComposer gapComposer2;
        albumItem.getClass();
        String str = albumItem.id;
        function0.getClass();
        GapComposer gapComposer3 = (GapComposer) composer;
        gapComposer3.startRestartGroup(2123434976);
        int i3 = (gapComposer3.changedInstance(albumItem) ? 4 : 2) | i | (gapComposer3.changedInstance(function0) ? 32 : 16);
        final byte b2 = 0;
        if (gapComposer3.shouldExecute(i3 & 1, (i3 & 19) != 18)) {
            NavHostController navHostController2 = (NavHostController) gapComposer3.consume(MainActivityKt.LocalNavController);
            Context context = (Context) gapComposer3.consume(AndroidCompositionLocals_androidKt.LocalContext);
            MusicDatabase musicDatabase = (MusicDatabase) gapComposer3.consume(MainActivityKt.LocalDatabase);
            DownloadUtil downloadUtil2 = (DownloadUtil) gapComposer3.consume(MainActivityKt.LocalDownloadUtil);
            PlayerConnection playerConnection = (PlayerConnection) gapComposer3.consume(MainActivityKt.LocalPlayerConnection);
            if (playerConnection == null) {
                RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer3.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new Function2(albumItem, function0, i, b2) { // from class: com.metrolist.music.ui.menu.YouTubeAlbumMenuKt$$ExternalSyntheticLambda0
                        public final /* synthetic */ byte $r8$classId;
                        public final /* synthetic */ AlbumItem f$0;
                        public final /* synthetic */ Function0 f$1;

                        {
                            this.$r8$classId = b2;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            byte b3 = this.$r8$classId;
                            Unit unit = Unit.INSTANCE;
                            Function0 function2 = this.f$1;
                            AlbumItem albumItem3 = this.f$0;
                            Composer composer2 = (Composer) obj;
                            ((Integer) obj2).getClass();
                            switch (b3) {
                                case 0:
                                    YouTubeAlbumMenuKt.YouTubeAlbumMenu(albumItem3, function2, composer2, Stack.updateChangedFlags(1));
                                    break;
                                default:
                                    YouTubeAlbumMenuKt.YouTubeAlbumMenu(albumItem3, function2, composer2, Stack.updateChangedFlags(1));
                                    break;
                            }
                            return unit;
                        }
                    };
                    return;
                }
                return;
            }
            ListenTogetherManager listenTogetherManager = (ListenTogetherManager) gapComposer3.consume(MainActivityKt.LocalListenTogetherManager);
            boolean z = (listenTogetherManager == null || !listenTogetherManager.client.isInRoom() || listenTogetherManager.isHost()) ? false : true;
            Continuation continuation = null;
            MutableState mutableStateCollectAsStateWithLifecycle = FileSystemsKt.collectAsStateWithLifecycle(musicDatabase.albumWithSongs(str), null, gapComposer3, 48);
            MutableState mutableStateCollectAsStateWithLifecycle2 = FileSystemsKt.collectAsStateWithLifecycle(musicDatabase.delegate.getSpeedDialDao().isPinned(str), Boolean.FALSE, gapComposer3, 48);
            Map map2 = (Map) gapComposer3.consume(MainActivityKt.LocalArtistNameAliases);
            Object objRememberedValue = gapComposer3.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Stack.createCompositionCoroutineScope(gapComposer3);
                gapComposer3.updateRememberedValue(objRememberedValue);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
            boolean zChangedInstance = gapComposer3.changedInstance(musicDatabase) | gapComposer3.changedInstance(albumItem);
            Object objRememberedValue2 = gapComposer3.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new DataStoreKt$get$1((Object) musicDatabase, (Object) albumItem, continuation, (byte) 2);
                gapComposer3.updateRememberedValue(objRememberedValue2);
            }
            Stack.LaunchedEffect(gapComposer3, Unit.INSTANCE, (Function2) objRememberedValue2);
            Object objRememberedValue3 = gapComposer3.rememberedValue();
            if (objRememberedValue3 == neverEqualPolicy) {
                objRememberedValue3 = Fragment$5$$ExternalSyntheticOutline0.m(1, gapComposer3);
            }
            ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = (ParcelableSnapshotMutableIntState) objRememberedValue3;
            AlbumWithSongs albumWithSongs = (AlbumWithSongs) mutableStateCollectAsStateWithLifecycle.getValue();
            boolean zChanged = gapComposer3.changed(mutableStateCollectAsStateWithLifecycle) | gapComposer3.changedInstance(downloadUtil2);
            Object objRememberedValue4 = gapComposer3.rememberedValue();
            if (zChanged || objRememberedValue4 == neverEqualPolicy) {
                objRememberedValue4 = new AlbumMenuKt$AlbumMenu$2$1(downloadUtil2, mutableStateCollectAsStateWithLifecycle, parcelableSnapshotMutableIntState, continuation, (byte) 2);
                downloadUtil = downloadUtil2;
                gapComposer3.updateRememberedValue(objRememberedValue4);
            } else {
                downloadUtil = downloadUtil2;
            }
            Stack.LaunchedEffect(gapComposer3, albumWithSongs, (Function2) objRememberedValue4);
            Object[] objArr = new Object[0];
            Object objRememberedValue5 = gapComposer3.rememberedValue();
            if (objRememberedValue5 == neverEqualPolicy) {
                objRememberedValue5 = new QueueKt$$ExternalSyntheticLambda2((byte) 6);
                gapComposer3.updateRememberedValue(objRememberedValue5);
            }
            MutableState mutableState = (MutableState) SaverKt.rememberSaveable(objArr, (Function0) objRememberedValue5, gapComposer3, 48);
            Object[] objArr2 = new Object[0];
            Object objRememberedValue6 = gapComposer3.rememberedValue();
            if (objRememberedValue6 == neverEqualPolicy) {
                objRememberedValue6 = new QueueKt$$ExternalSyntheticLambda2((byte) 7);
                gapComposer3.updateRememberedValue(objRememberedValue6);
            }
            MutableState mutableState2 = (MutableState) SaverKt.rememberSaveable(objArr2, (Function0) objRememberedValue6, gapComposer3, 48);
            Object objRememberedValue7 = gapComposer3.rememberedValue();
            if (objRememberedValue7 == neverEqualPolicy) {
                objRememberedValue7 = Stack.mutableStateOf$default(new ArrayList());
                gapComposer3.updateRememberedValue(objRememberedValue7);
            }
            MutableState mutableState3 = (MutableState) objRememberedValue7;
            boolean zBooleanValue = ((Boolean) mutableState.getValue()).booleanValue();
            boolean zChanged2 = gapComposer3.changed(mutableStateCollectAsStateWithLifecycle);
            Object objRememberedValue8 = gapComposer3.rememberedValue();
            if (zChanged2 || objRememberedValue8 == neverEqualPolicy) {
                objRememberedValue8 = new AlbumMenuKt$AlbumMenu$3$1(mutableStateCollectAsStateWithLifecycle, null, (byte) 2);
                gapComposer3.updateRememberedValue(objRememberedValue8);
            }
            Function1 function2 = (Function1) objRememberedValue8;
            boolean zChanged3 = gapComposer3.changed(mutableStateCollectAsStateWithLifecycle);
            Object objRememberedValue9 = gapComposer3.rememberedValue();
            if (zChanged3 || objRememberedValue9 == neverEqualPolicy) {
                objRememberedValue9 = new AlbumMenuKt$AlbumMenu$3$1(mutableStateCollectAsStateWithLifecycle, null, (byte) 3);
                gapComposer3.updateRememberedValue(objRememberedValue9);
            }
            Function1 function3 = (Function1) objRememberedValue9;
            boolean zChanged4 = gapComposer3.changed(mutableState);
            Object objRememberedValue10 = gapComposer3.rememberedValue();
            if (zChanged4 || objRememberedValue10 == neverEqualPolicy) {
                objRememberedValue10 = new SongMenuKt$$ExternalSyntheticLambda2(mutableState, (byte) 8);
                gapComposer3.updateRememberedValue(objRememberedValue10);
            }
            boolean z2 = z;
            DownloadUtil downloadUtil3 = downloadUtil;
            AlbumMenuKt.AddToPlaylistDialog(zBooleanValue, false, function2, function3, (Function0) objRememberedValue10, null, gapComposer3, 0);
            if (((Boolean) mutableState2.getValue()).booleanValue()) {
                gapComposer3.startReplaceGroup(-1319188615);
                boolean zChanged5 = gapComposer3.changed(mutableState2) | ((i3 & 112) == 32);
                Object objRememberedValue11 = gapComposer3.rememberedValue();
                if (zChanged5 || objRememberedValue11 == neverEqualPolicy) {
                    objRememberedValue11 = new SongMenuKt$$ExternalSyntheticLambda3(function0, mutableState2, (byte) 4);
                    gapComposer3.updateRememberedValue(objRememberedValue11);
                }
                Function0 function4 = (Function0) objRememberedValue11;
                boolean zChanged6 = gapComposer3.changed(mutableState2);
                Object objRememberedValue12 = gapComposer3.rememberedValue();
                if (zChanged6 || objRememberedValue12 == neverEqualPolicy) {
                    objRememberedValue12 = new AlbumMenuKt$$ExternalSyntheticLambda8(mutableState2, mutableState3, (byte) 2);
                    gapComposer3.updateRememberedValue(objRememberedValue12);
                }
                i2 = 0;
                DialogKt.ListDialog(function4, null, (Function1) objRememberedValue12, gapComposer3, 0);
                gapComposer3.end(false);
            } else {
                i2 = 0;
                gapComposer3.startReplaceGroup(-1318195902);
                gapComposer3.end(false);
            }
            Object[] objArr3 = new Object[i2];
            Object objRememberedValue13 = gapComposer3.rememberedValue();
            if (objRememberedValue13 == neverEqualPolicy) {
                objRememberedValue13 = new QueueKt$$ExternalSyntheticLambda2((byte) 8);
                gapComposer3.updateRememberedValue(objRememberedValue13);
            }
            MutableState mutableState4 = (MutableState) SaverKt.rememberSaveable(objArr3, (Function0) objRememberedValue13, gapComposer3, 48);
            if (((Boolean) mutableState4.getValue()).booleanValue()) {
                gapComposer3.startReplaceGroup(-1318016505);
                boolean zChanged7 = gapComposer3.changed(mutableState4);
                Object objRememberedValue14 = gapComposer3.rememberedValue();
                if (zChanged7 || objRememberedValue14 == neverEqualPolicy) {
                    objRememberedValue14 = new SongMenuKt$$ExternalSyntheticLambda2(mutableState4, (byte) 9);
                    gapComposer3.updateRememberedValue(objRememberedValue14);
                }
                Function0 function5 = (Function0) objRememberedValue14;
                boolean zChanged8 = gapComposer3.changed(mutableStateCollectAsStateWithLifecycle) | gapComposer3.changedInstance(navHostController2) | gapComposer3.changed(mutableState4) | ((i3 & 112) == 32) | gapComposer3.changedInstance(map2);
                Object objRememberedValue15 = gapComposer3.rememberedValue();
                if (zChanged8 || objRememberedValue15 == neverEqualPolicy) {
                    map = map2;
                    AlbumMenuKt$$ExternalSyntheticLambda40 albumMenuKt$$ExternalSyntheticLambda40 = new AlbumMenuKt$$ExternalSyntheticLambda40(mutableStateCollectAsStateWithLifecycle, navHostController2, mutableState4, function0, map);
                    navHostController = navHostController2;
                    gapComposer3.updateRememberedValue(albumMenuKt$$ExternalSyntheticLambda40);
                    objRememberedValue15 = albumMenuKt$$ExternalSyntheticLambda40;
                } else {
                    map = map2;
                    navHostController = navHostController2;
                }
                b = 0;
                DialogKt.ListDialog(function5, null, (Function1) objRememberedValue15, gapComposer3, 0);
                gapComposer3.end(false);
            } else {
                map = map2;
                mutableStateCollectAsStateWithLifecycle2 = mutableStateCollectAsStateWithLifecycle2;
                b = 0;
                navHostController = navHostController2;
                gapComposer3.startReplaceGroup(-1316268446);
                gapComposer3.end(false);
            }
            byte b3 = b;
            Map map3 = map;
            NavHostController navHostController3 = navHostController;
            MenuKt.YouTubeListItem(albumItem, null, false, false, false, false, null, Expect_jvmKt.rememberComposableLambda(836253031, new YouTubeAlbumMenuKt$$ExternalSyntheticLambda11(musicDatabase, mutableStateCollectAsStateWithLifecycle, b), gapComposer3), AlbumMenuKt.f121lambda$1664528920, gapComposer3, (i3 & 14) | 905969664, 254);
            CardKt.m261HorizontalDivider9IZ8Weo(null, CropImageView.DEFAULT_ASPECT_RATIO, 0L, gapComposer3, 0, 7);
            OffsetKt.Spacer(gapComposer3, SizeKt.m145height3ABfNKs(Modifier.Companion.$$INSTANCE, 12.0f));
            int i4 = ((Configuration) gapComposer3.consume(AndroidCompositionLocals_androidKt.LocalConfiguration)).orientation;
            WeakHashMap weakHashMap = WindowInsetsHolder.viewMap;
            PaddingValuesImpl paddingValuesImpl = new PaddingValuesImpl(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, OffsetKt.asPaddingValues(OffsetKt.current(gapComposer3).systemBars, gapComposer3).mo122calculateBottomPaddingD9Ej5fM() + 8.0f + CropImageView.DEFAULT_ASPECT_RATIO);
            boolean z3 = (((((((((((((gapComposer3.changed(z2) ? 1 : 0) | ((i3 & 112) == 32 ? (byte) 1 : b3)) | (gapComposer3.changed(mutableStateCollectAsStateWithLifecycle) ? 1 : 0) ? 1 : 0) | (gapComposer3.changedInstance(playerConnection) ? 1 : 0)) | (gapComposer3.changedInstance(albumItem) ? 1 : 0) ? 1 : 0) | (gapComposer3.changedInstance(context) ? 1 : 0)) | (gapComposer3.changed(mutableState) ? 1 : 0) ? 1 : 0) | (gapComposer3.changed(mutableStateCollectAsStateWithLifecycle2) ? 1 : 0)) | (gapComposer3.changedInstance(coroutineScope) ? 1 : 0) ? 1 : 0) | (gapComposer3.changedInstance(musicDatabase) ? 1 : 0)) | (gapComposer3.changedInstance(downloadUtil3) ? 1 : 0) ? 1 : 0) | (gapComposer3.changedInstance(map3) ? 1 : 0)) | (gapComposer3.changedInstance(navHostController3) ? 1 : 0) ? 1 : 0) | (gapComposer3.changed(mutableState4) ? 1 : 0);
            Object objRememberedValue16 = gapComposer3.rememberedValue();
            if (z3 != 0 || objRememberedValue16 == neverEqualPolicy) {
                albumItem2 = albumItem;
                objRememberedValue16 = new AlbumScreenKt$$ExternalSyntheticLambda7(albumItem2, z2, function0, mutableStateCollectAsStateWithLifecycle, playerConnection, context, mutableState, coroutineScope, mutableStateCollectAsStateWithLifecycle2, musicDatabase, downloadUtil3, parcelableSnapshotMutableIntState, navHostController3, mutableState4, map3);
                function1 = function0;
                gapComposer2 = gapComposer3;
                gapComposer2.updateRememberedValue(objRememberedValue16);
            } else {
                function1 = function0;
                gapComposer2 = gapComposer3;
                albumItem2 = albumItem;
            }
            GapComposer gapComposer4 = gapComposer2;
            IntMath.LazyColumn(null, null, paddingValuesImpl, null, null, null, false, null, (Function1) objRememberedValue16, gapComposer4, 0, 507);
            gapComposer = gapComposer4;
        } else {
            albumItem2 = albumItem;
            function1 = function0;
            gapComposer = gapComposer3;
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup2 = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup2 != null) {
            final byte b4 = 1;
            recomposeScopeImplEndRestartGroup2.block = new Function2(albumItem2, function1, i, b4) { // from class: com.metrolist.music.ui.menu.YouTubeAlbumMenuKt$$ExternalSyntheticLambda0
                public final /* synthetic */ byte $r8$classId;
                public final /* synthetic */ AlbumItem f$0;
                public final /* synthetic */ Function0 f$1;

                {
                    this.$r8$classId = b4;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    byte b5 = this.$r8$classId;
                    Unit unit = Unit.INSTANCE;
                    Function0 function6 = this.f$1;
                    AlbumItem albumItem3 = this.f$0;
                    Composer composer2 = (Composer) obj;
                    ((Integer) obj2).getClass();
                    switch (b5) {
                        case 0:
                            YouTubeAlbumMenuKt.YouTubeAlbumMenu(albumItem3, function6, composer2, Stack.updateChangedFlags(1));
                            break;
                        default:
                            YouTubeAlbumMenuKt.YouTubeAlbumMenu(albumItem3, function6, composer2, Stack.updateChangedFlags(1));
                            break;
                    }
                    return unit;
                }
            };
        }
    }

    public static final void YouTubeArtistMenu(final ArtistItem artistItem, Function0 function0, Composer composer, final int i) {
        final ArtistItem artistItem2;
        GapComposer gapComposer;
        Object loginScreenKt$$ExternalSyntheticLambda0;
        final Function0 function1 = function0;
        artistItem.getClass();
        String str = artistItem.id;
        function1.getClass();
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(1568036806);
        int i2 = (gapComposer2.changedInstance(artistItem) ? 4 : 2) | i | (gapComposer2.changedInstance(function1) ? 32 : 16);
        final byte b = 0;
        if (gapComposer2.shouldExecute(i2 & 1, (i2 & 19) != 18)) {
            Context context = (Context) gapComposer2.consume(AndroidCompositionLocals_androidKt.LocalContext);
            MusicDatabase musicDatabase = (MusicDatabase) gapComposer2.consume(MainActivityKt.LocalDatabase);
            PlayerConnection playerConnection = (PlayerConnection) gapComposer2.consume(MainActivityKt.LocalPlayerConnection);
            if (playerConnection == null) {
                RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new Function2(artistItem, function1, i, b) { // from class: com.metrolist.music.ui.menu.YouTubeArtistMenuKt$$ExternalSyntheticLambda0
                        public final /* synthetic */ byte $r8$classId;
                        public final /* synthetic */ ArtistItem f$0;
                        public final /* synthetic */ Function0 f$1;

                        {
                            this.$r8$classId = b;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            byte b2 = this.$r8$classId;
                            Unit unit = Unit.INSTANCE;
                            Function0 function2 = this.f$1;
                            ArtistItem artistItem3 = this.f$0;
                            Composer composer2 = (Composer) obj;
                            ((Integer) obj2).getClass();
                            switch (b2) {
                                case 0:
                                    YouTubeAlbumMenuKt.YouTubeArtistMenu(artistItem3, function2, composer2, Stack.updateChangedFlags(1));
                                    break;
                                default:
                                    YouTubeAlbumMenuKt.YouTubeArtistMenu(artistItem3, function2, composer2, Stack.updateChangedFlags(1));
                                    break;
                            }
                            return unit;
                        }
                    };
                    return;
                }
                return;
            }
            MutableState mutableStateCollectAsStateWithLifecycle = FileSystemsKt.collectAsStateWithLifecycle(musicDatabase.artist(str), null, gapComposer2, 48);
            ListenTogetherManager listenTogetherManager = (ListenTogetherManager) gapComposer2.consume(MainActivityKt.LocalListenTogetherManager);
            boolean z = (listenTogetherManager == null || !listenTogetherManager.client.isInRoom() || listenTogetherManager.isHost()) ? false : true;
            MutableState mutableStateCollectAsStateWithLifecycle2 = FileSystemsKt.collectAsStateWithLifecycle(musicDatabase.delegate.getSpeedDialDao().isPinned(str), Boolean.FALSE, gapComposer2, 48);
            Object objRememberedValue = gapComposer2.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Stack.createCompositionCoroutineScope(gapComposer2);
                gapComposer2.updateRememberedValue(objRememberedValue);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
            boolean z2 = z;
            MenuKt.YouTubeListItem(artistItem, null, false, false, false, false, null, AlbumMenuKt.lambda$598731999, null, gapComposer2, (i2 & 14) | 100663296, 766);
            CardKt.m261HorizontalDivider9IZ8Weo(null, CropImageView.DEFAULT_ASPECT_RATIO, 0L, gapComposer2, 0, 7);
            OffsetKt.Spacer(gapComposer2, SizeKt.m145height3ABfNKs(Modifier.Companion.$$INSTANCE, 12.0f));
            int i3 = ((Configuration) gapComposer2.consume(AndroidCompositionLocals_androidKt.LocalConfiguration)).orientation;
            WeakHashMap weakHashMap = WindowInsetsHolder.viewMap;
            PaddingValuesImpl paddingValuesImpl = new PaddingValuesImpl(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, OffsetKt.asPaddingValues(OffsetKt.current(gapComposer2).systemBars, gapComposer2).mo122calculateBottomPaddingD9Ej5fM() + 8.0f + CropImageView.DEFAULT_ASPECT_RATIO);
            boolean zChanged = gapComposer2.changed(z2) | gapComposer2.changedInstance(artistItem) | gapComposer2.changedInstance(playerConnection) | ((i2 & 112) == 32) | gapComposer2.changed(mutableStateCollectAsStateWithLifecycle2) | gapComposer2.changedInstance(coroutineScope) | gapComposer2.changedInstance(musicDatabase) | gapComposer2.changedInstance(context) | gapComposer2.changed(mutableStateCollectAsStateWithLifecycle);
            Object objRememberedValue2 = gapComposer2.rememberedValue();
            if (zChanged || objRememberedValue2 == neverEqualPolicy) {
                artistItem2 = artistItem;
                loginScreenKt$$ExternalSyntheticLambda0 = new LoginScreenKt$$ExternalSyntheticLambda0(z2, artistItem2, playerConnection, function0, mutableStateCollectAsStateWithLifecycle2, coroutineScope, musicDatabase, context, mutableStateCollectAsStateWithLifecycle);
                function1 = function0;
                gapComposer2.updateRememberedValue(loginScreenKt$$ExternalSyntheticLambda0);
            } else {
                artistItem2 = artistItem;
                loginScreenKt$$ExternalSyntheticLambda0 = objRememberedValue2;
                function1 = function0;
            }
            IntMath.LazyColumn(null, null, paddingValuesImpl, null, null, null, false, null, (Function1) loginScreenKt$$ExternalSyntheticLambda0, gapComposer2, 0, 507);
            gapComposer = gapComposer2;
        } else {
            artistItem2 = artistItem;
            gapComposer = gapComposer2;
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup2 = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup2 != null) {
            final byte b2 = 1;
            recomposeScopeImplEndRestartGroup2.block = new Function2(artistItem2, function1, i, b2) { // from class: com.metrolist.music.ui.menu.YouTubeArtistMenuKt$$ExternalSyntheticLambda0
                public final /* synthetic */ byte $r8$classId;
                public final /* synthetic */ ArtistItem f$0;
                public final /* synthetic */ Function0 f$1;

                {
                    this.$r8$classId = b2;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    byte b3 = this.$r8$classId;
                    Unit unit = Unit.INSTANCE;
                    Function0 function2 = this.f$1;
                    ArtistItem artistItem3 = this.f$0;
                    Composer composer2 = (Composer) obj;
                    ((Integer) obj2).getClass();
                    switch (b3) {
                        case 0:
                            YouTubeAlbumMenuKt.YouTubeArtistMenu(artistItem3, function2, composer2, Stack.updateChangedFlags(1));
                            break;
                        default:
                            YouTubeAlbumMenuKt.YouTubeArtistMenu(artistItem3, function2, composer2, Stack.updateChangedFlags(1));
                            break;
                    }
                    return unit;
                }
            };
        }
    }

    public static final void YouTubePlaylistMenu(final PlaylistItem playlistItem, List list, final CoroutineScope coroutineScope, final Function0 function0, Function0 function1, Composer composer, final int i, final int i2) {
        List list2;
        int i3;
        GapComposer gapComposer;
        final List list3;
        final Function0 function2;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        Function2 function3;
        List list4;
        Boolean bool;
        byte b;
        MusicDatabase musicDatabase;
        Continuation continuation;
        DownloadUtil downloadUtil;
        int i4;
        MutableState mutableState;
        GapComposer gapComposer2;
        DownloadUtil downloadUtil2;
        PlaylistItem playlistItem2;
        Function0 function4;
        int i5;
        boolean z;
        boolean z2;
        PlaylistItem playlistItem3;
        Context context;
        MutableState mutableState2;
        List list5;
        GapComposer gapComposer3;
        GapComposer gapComposer4;
        List list6;
        Object obj;
        final Context context2;
        List list7;
        PlaylistItem playlistItem4;
        playlistItem.getClass();
        String str = playlistItem.id;
        coroutineScope.getClass();
        function0.getClass();
        GapComposer gapComposer5 = (GapComposer) composer;
        gapComposer5.startRestartGroup(595416917);
        int i6 = i | (gapComposer5.changedInstance(playlistItem) ? 4 : 2);
        int i7 = i2 & 2;
        if (i7 != 0) {
            i3 = i6 | 48;
            list2 = list;
        } else {
            list2 = list;
            i3 = i6 | (gapComposer5.changed(list2) ? 32 : 16);
        }
        int i8 = 221184 | i3 | (gapComposer5.changed(coroutineScope) ? 256 : 128) | (gapComposer5.changedInstance(function0) ? 2048 : 1024);
        if (gapComposer5.shouldExecute(i8 & 1, (74899 & i8) != 74898)) {
            final List list8 = i7 != 0 ? EmptyList.INSTANCE : list2;
            Object objRememberedValue = gapComposer5.rememberedValue();
            byte b2 = 9;
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = new QueueKt$$ExternalSyntheticLambda2(b2);
                gapComposer5.updateRememberedValue(objRememberedValue);
            }
            final Function0 function5 = (Function0) objRememberedValue;
            Context context3 = (Context) gapComposer5.consume(AndroidCompositionLocals_androidKt.LocalContext);
            MusicDatabase musicDatabase2 = (MusicDatabase) gapComposer5.consume(MainActivityKt.LocalDatabase);
            DownloadUtil downloadUtil3 = (DownloadUtil) gapComposer5.consume(MainActivityKt.LocalDownloadUtil);
            PlayerConnection playerConnection = (PlayerConnection) gapComposer5.consume(MainActivityKt.LocalPlayerConnection);
            if (playerConnection == null) {
                recomposeScopeImplEndRestartGroup = gapComposer5.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup == null) {
                    return;
                }
                final byte b3 = 1;
                function3 = new Function2(playlistItem, list8, coroutineScope, function0, function5, i, i2, b3) { // from class: com.metrolist.music.ui.menu.YouTubePlaylistMenuKt$$ExternalSyntheticLambda8
                    public final /* synthetic */ byte $r8$classId;
                    public final /* synthetic */ PlaylistItem f$0;
                    public final /* synthetic */ List f$1;
                    public final /* synthetic */ CoroutineScope f$2;
                    public final /* synthetic */ Function0 f$3;
                    public final /* synthetic */ Function0 f$4;
                    public final /* synthetic */ byte f$7;

                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        this.$r8$classId = b3;
                        this.f$7 = i2;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        byte b4 = this.$r8$classId;
                        Unit unit = Unit.INSTANCE;
                        switch (b4) {
                            case 0:
                                ((Integer) obj3).getClass();
                                int iUpdateChangedFlags = Stack.updateChangedFlags(1);
                                YouTubeAlbumMenuKt.YouTubePlaylistMenu(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, (Composer) obj2, iUpdateChangedFlags, this.f$7);
                                break;
                            default:
                                ((Integer) obj3).getClass();
                                int iUpdateChangedFlags2 = Stack.updateChangedFlags(1);
                                YouTubeAlbumMenuKt.YouTubePlaylistMenu(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, (Composer) obj2, iUpdateChangedFlags2, this.f$7);
                                break;
                        }
                        return unit;
                    }
                };
            } else {
                ListenTogetherManager listenTogetherManager = (ListenTogetherManager) gapComposer5.consume(MainActivityKt.LocalListenTogetherManager);
                boolean z3 = (listenTogetherManager == null || !listenTogetherManager.client.isInRoom() || listenTogetherManager.isHost()) ? false : true;
                MutableState mutableStateCollectAsStateWithLifecycle = FileSystemsKt.collectAsStateWithLifecycle(musicDatabase2.playlistByBrowseId(str), null, gapComposer5, 48);
                FlowUtil$createFlow$$inlined$map$1 flowUtil$createFlow$$inlined$map$1IsPinned = musicDatabase2.delegate.getSpeedDialDao().isPinned(str);
                Boolean bool2 = Boolean.FALSE;
                MutableState mutableStateCollectAsStateWithLifecycle2 = FileSystemsKt.collectAsStateWithLifecycle(flowUtil$createFlow$$inlined$map$1IsPinned, bool2, gapComposer5, 48);
                Map map = (Map) gapComposer5.consume(MainActivityKt.LocalArtistNameAliases);
                Object[] objArr = new Object[0];
                Object objRememberedValue2 = gapComposer5.rememberedValue();
                byte b4 = 10;
                if (objRememberedValue2 == neverEqualPolicy) {
                    objRememberedValue2 = new QueueKt$$ExternalSyntheticLambda2(b4);
                    gapComposer5.updateRememberedValue(objRememberedValue2);
                }
                MutableState mutableState3 = (MutableState) SaverKt.rememberSaveable(objArr, (Function0) objRememberedValue2, gapComposer5, 48);
                Object[] objArr2 = new Object[0];
                Object objRememberedValue3 = gapComposer5.rememberedValue();
                boolean z4 = z3;
                byte b5 = 11;
                if (objRememberedValue3 == neverEqualPolicy) {
                    objRememberedValue3 = new QueueKt$$ExternalSyntheticLambda2(b5);
                    gapComposer5.updateRememberedValue(objRememberedValue3);
                }
                MutableState mutableState4 = (MutableState) SaverKt.rememberSaveable(objArr2, (Function0) objRememberedValue3, gapComposer5, 48);
                Object[] objArr3 = new Object[0];
                Object objRememberedValue4 = gapComposer5.rememberedValue();
                byte b6 = 12;
                if (objRememberedValue4 == neverEqualPolicy) {
                    objRememberedValue4 = new QueueKt$$ExternalSyntheticLambda2(b6);
                    gapComposer5.updateRememberedValue(objRememberedValue4);
                }
                MutableState mutableState5 = (MutableState) SaverKt.rememberSaveable(objArr3, (Function0) objRememberedValue4, gapComposer5, 48);
                Object objRememberedValue5 = gapComposer5.rememberedValue();
                if (objRememberedValue5 == neverEqualPolicy) {
                    objRememberedValue5 = Stack.mutableStateOf$default(new ArrayList());
                    gapComposer5.updateRememberedValue(objRememberedValue5);
                }
                MutableState mutableState6 = (MutableState) objRememberedValue5;
                boolean zBooleanValue = ((Boolean) mutableState3.getValue()).booleanValue();
                int i9 = i8 & 112;
                boolean zChangedInstance = (i9 == 32) | gapComposer5.changedInstance(playlistItem) | gapComposer5.changedInstance(musicDatabase2);
                Object objRememberedValue6 = gapComposer5.rememberedValue();
                if (zChangedInstance || objRememberedValue6 == neverEqualPolicy) {
                    list4 = list8;
                    bool = bool2;
                    b = 10;
                    objRememberedValue6 = new YouTubePlaylistMenuKt$YouTubePlaylistMenu$2$1(list4, musicDatabase2, playlistItem, null, (byte) 0);
                    musicDatabase = musicDatabase2;
                    continuation = null;
                    gapComposer5.updateRememberedValue(objRememberedValue6);
                } else {
                    list4 = list8;
                    musicDatabase = musicDatabase2;
                    continuation = null;
                    b = 10;
                    bool = bool2;
                }
                Function1 function6 = (Function1) objRememberedValue6;
                boolean z5 = i9 == 32;
                Object objRememberedValue7 = gapComposer5.rememberedValue();
                if (z5 || objRememberedValue7 == neverEqualPolicy) {
                    objRememberedValue7 = new YouTubePlaylistMenuKt$YouTubePlaylistMenu$3$1(list4, continuation, (byte) 0);
                    gapComposer5.updateRememberedValue(objRememberedValue7);
                }
                Function1 function7 = (Function1) objRememberedValue7;
                boolean zChanged = gapComposer5.changed(mutableState3);
                Object objRememberedValue8 = gapComposer5.rememberedValue();
                if (zChanged || objRememberedValue8 == neverEqualPolicy) {
                    objRememberedValue8 = new SongMenuKt$$ExternalSyntheticLambda2(mutableState3, b);
                    gapComposer5.updateRememberedValue(objRememberedValue8);
                }
                Continuation continuation2 = continuation;
                List list9 = list4;
                AlbumMenuKt.AddToPlaylistDialog(zBooleanValue, false, function6, function7, (Function0) objRememberedValue8, null, gapComposer5, 0);
                MusicDatabase musicDatabase3 = musicDatabase;
                byte b7 = 1;
                Boolean bool3 = bool;
                MenuKt.YouTubeListItem(playlistItem, null, false, false, false, false, null, Expect_jvmKt.rememberComposableLambda(-484545810, new QueueMenuKt$$ExternalSyntheticLambda12(playlistItem, list9, mutableStateCollectAsStateWithLifecycle, musicDatabase3, coroutineScope, context3), gapComposer5), null, gapComposer5, (i8 & 14) | 100663296, 766);
                CardKt.m261HorizontalDivider9IZ8Weo(null, CropImageView.DEFAULT_ASPECT_RATIO, 0L, gapComposer5, 0, 7);
                Object objRememberedValue9 = gapComposer5.rememberedValue();
                if (objRememberedValue9 == neverEqualPolicy) {
                    objRememberedValue9 = Fragment$5$$ExternalSyntheticOutline0.m(1, gapComposer5);
                }
                ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = (ParcelableSnapshotMutableIntState) objRememberedValue9;
                boolean zChangedInstance2 = (i9 == 32) | gapComposer5.changedInstance(downloadUtil3);
                Object objRememberedValue10 = gapComposer5.rememberedValue();
                if (zChangedInstance2 || objRememberedValue10 == neverEqualPolicy) {
                    objRememberedValue10 = new YouTubePlaylistMenuKt$YouTubePlaylistMenu$6$1(list9, downloadUtil3, parcelableSnapshotMutableIntState, continuation2, (byte) 0);
                    downloadUtil = downloadUtil3;
                    gapComposer5.updateRememberedValue(objRememberedValue10);
                } else {
                    downloadUtil = downloadUtil3;
                }
                Stack.LaunchedEffect(gapComposer5, (Object) r17, (Function2) objRememberedValue10);
                Object objRememberedValue11 = gapComposer5.rememberedValue();
                if (objRememberedValue11 == neverEqualPolicy) {
                    objRememberedValue11 = Stack.mutableStateOf$default(bool3);
                    gapComposer5.updateRememberedValue(objRememberedValue11);
                }
                MutableState mutableState7 = (MutableState) objRememberedValue11;
                Object objRememberedValue12 = gapComposer5.rememberedValue();
                if (objRememberedValue12 == neverEqualPolicy) {
                    objRememberedValue12 = Stack.mutableStateOf$default(bool3);
                    gapComposer5.updateRememberedValue(objRememberedValue12);
                }
                MutableState mutableState8 = (MutableState) objRememberedValue12;
                if (((Boolean) mutableState7.getValue()).booleanValue()) {
                    gapComposer5.startReplaceGroup(-141364428);
                    Object objRememberedValue13 = gapComposer5.rememberedValue();
                    if (objRememberedValue13 == neverEqualPolicy) {
                        objRememberedValue13 = new SongMenuKt$$ExternalSyntheticLambda2(mutableState7, (byte) 11);
                        gapComposer5.updateRememberedValue(objRememberedValue13);
                    }
                    downloadUtil2 = downloadUtil;
                    mutableState = mutableState7;
                    i4 = i9;
                    DialogKt.DefaultDialog((Function0) objRememberedValue13, null, null, null, Expect_jvmKt.rememberComposableLambda(410434882, new SelectionSongsMenuKt$$ExternalSyntheticLambda4(b7, context3, mutableState7, r17), gapComposer5), null, Expect_jvmKt.rememberComposableLambda(-1451789032, new ListItemKt$$ExternalSyntheticLambda17((byte) 9, (Object) playlistItem), gapComposer5), gapComposer5, 1597446, 46);
                    gapComposer2 = gapComposer5;
                    gapComposer2.end(false);
                } else {
                    i4 = i9;
                    mutableState = mutableState7;
                    gapComposer2 = gapComposer5;
                    downloadUtil2 = downloadUtil;
                    gapComposer2.startReplaceGroup(-140048819);
                    gapComposer2.end(false);
                }
                boolean zBooleanValue2 = ((Boolean) mutableState4.getValue()).booleanValue();
                boolean zChangedInstance3 = (i4 == 32) | gapComposer2.changedInstance(playlistItem) | gapComposer2.changedInstance(musicDatabase3);
                Object objRememberedValue14 = gapComposer2.rememberedValue();
                if (zChangedInstance3 || objRememberedValue14 == neverEqualPolicy) {
                    YouTubePlaylistMenuKt$YouTubePlaylistMenu$2$1 youTubePlaylistMenuKt$YouTubePlaylistMenu$2$1 = new YouTubePlaylistMenuKt$YouTubePlaylistMenu$2$1(list9, musicDatabase3, playlistItem, continuation2, (byte) 1);
                    playlistItem2 = playlistItem;
                    gapComposer2.updateRememberedValue(youTubePlaylistMenuKt$YouTubePlaylistMenu$2$1);
                    objRememberedValue14 = youTubePlaylistMenuKt$YouTubePlaylistMenu$2$1;
                } else {
                    playlistItem2 = playlistItem;
                }
                Function1 function8 = (Function1) objRememberedValue14;
                String str2 = playlistItem2.title;
                boolean zChanged2 = gapComposer2.changed(mutableState4);
                Object objRememberedValue15 = gapComposer2.rememberedValue();
                if (zChanged2 || objRememberedValue15 == neverEqualPolicy) {
                    objRememberedValue15 = new SongMenuKt$$ExternalSyntheticLambda2(mutableState4, (byte) 12);
                    gapComposer2.updateRememberedValue(objRememberedValue15);
                }
                GapComposer gapComposer6 = gapComposer2;
                AlbumMenuKt.ImportPlaylistDialog(zBooleanValue2, function8, str2, (Function0) objRememberedValue15, gapComposer6, 0);
                if (((Boolean) mutableState5.getValue()).booleanValue()) {
                    gapComposer6.startReplaceGroup(-139186244);
                    i5 = i8;
                    boolean zChanged3 = gapComposer6.changed(mutableState5) | ((i5 & 7168) == 2048);
                    Object objRememberedValue16 = gapComposer6.rememberedValue();
                    if (zChanged3 || objRememberedValue16 == neverEqualPolicy) {
                        function4 = function0;
                        objRememberedValue16 = new SongMenuKt$$ExternalSyntheticLambda3(function4, mutableState5, (byte) 5);
                        gapComposer6.updateRememberedValue(objRememberedValue16);
                    } else {
                        function4 = function0;
                    }
                    Function0 function9 = (Function0) objRememberedValue16;
                    boolean zChanged4 = gapComposer6.changed(mutableState5) | gapComposer6.changedInstance(map);
                    Object objRememberedValue17 = gapComposer6.rememberedValue();
                    if (zChanged4 || objRememberedValue17 == neverEqualPolicy) {
                        objRememberedValue17 = new MainActivity$$ExternalSyntheticLambda21((Object) mutableState5, (Object) mutableState6, (Object) map, (byte) 16);
                        gapComposer6.updateRememberedValue(objRememberedValue17);
                    }
                    z = false;
                    DialogKt.ListDialog(function9, null, (Function1) objRememberedValue17, gapComposer6, 0);
                    gapComposer6.end(false);
                } else {
                    function4 = function0;
                    i5 = i8;
                    z = false;
                    gapComposer6.startReplaceGroup(-136863507);
                    gapComposer6.end(false);
                }
                int i10 = ((Configuration) gapComposer6.consume(AndroidCompositionLocals_androidKt.LocalConfiguration)).orientation;
                WeakHashMap weakHashMap = WindowInsetsHolder.viewMap;
                PaddingValuesImpl paddingValuesImpl = new PaddingValuesImpl(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, OffsetKt.asPaddingValues(OffsetKt.current(gapComposer6).systemBars, gapComposer6).mo122calculateBottomPaddingD9Ej5fM() + 8.0f + CropImageView.DEFAULT_ASPECT_RATIO);
                int i11 = i5 & 7168;
                int i12 = i5 & 896;
                boolean zChanged5 = gapComposer6.changed(z4) | gapComposer6.changedInstance(playlistItem2) | gapComposer6.changedInstance(playerConnection) | (i11 == 2048 ? true : z) | (i12 == 256) | (i4 == 32) | gapComposer6.changed(mutableState3) | gapComposer6.changed(mutableStateCollectAsStateWithLifecycle2) | gapComposer6.changedInstance(r2) | gapComposer6.changedInstance(downloadUtil2) | gapComposer6.changedInstance(context3);
                Object objRememberedValue18 = gapComposer6.rememberedValue();
                if (zChanged5 || objRememberedValue18 == neverEqualPolicy) {
                    PlaylistItem playlistItem5 = playlistItem2;
                    z2 = true;
                    objRememberedValue18 = new AlbumScreenKt$$ExternalSyntheticLambda7(z4, playlistItem5, playerConnection, function4, list9, coroutineScope, mutableState3, mutableStateCollectAsStateWithLifecycle2, musicDatabase3, downloadUtil2, context3, function5, parcelableSnapshotMutableIntState, mutableState, mutableState8);
                    playlistItem3 = playlistItem5;
                    context = context3;
                    mutableState2 = mutableState8;
                    list5 = list9;
                    gapComposer3 = gapComposer6;
                    gapComposer3.updateRememberedValue(objRememberedValue18);
                } else {
                    playlistItem3 = playlistItem2;
                    context = context3;
                    mutableState2 = mutableState8;
                    list5 = list9;
                    gapComposer3 = gapComposer6;
                    z2 = true;
                }
                Function1 function10 = (Function1) objRememberedValue18;
                GapComposer gapComposer7 = gapComposer3;
                MutableState mutableState9 = mutableState2;
                IntMath.LazyColumn(null, null, paddingValuesImpl, null, null, null, false, null, function10, gapComposer7, 0, 507);
                if (((Boolean) mutableState9.getValue()).booleanValue()) {
                    gapComposer7.startReplaceGroup(-120563397);
                    Object objRememberedValue19 = gapComposer7.rememberedValue();
                    if (objRememberedValue19 == neverEqualPolicy) {
                        objRememberedValue19 = new SongMenuKt$$ExternalSyntheticLambda2(mutableState9, (byte) 19);
                        gapComposer7.updateRememberedValue(objRememberedValue19);
                    }
                    Function0 function11 = (Function0) objRememberedValue19;
                    int i13 = i4;
                    boolean zChangedInstance4 = (i12 != 256 ? false : z2) | (i13 != 32 ? false : z2) | gapComposer7.changedInstance(playlistItem3) | gapComposer7.changedInstance(context) | (i11 == 2048 ? z2 : false);
                    Object objRememberedValue20 = gapComposer7.rememberedValue();
                    if (zChangedInstance4 || objRememberedValue20 == neverEqualPolicy) {
                        final byte b8 = 0;
                        final PlaylistItem playlistItem6 = playlistItem3;
                        context2 = context;
                        final List list10 = list5;
                        obj = new Function1() { // from class: com.metrolist.music.ui.menu.YouTubePlaylistMenuKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                byte b9 = b8;
                                Unit unit = Unit.INSTANCE;
                                Function0 function12 = function0;
                                CoroutineScope coroutineScope2 = coroutineScope;
                                switch (b9) {
                                    case 0:
                                        String str3 = (String) obj2;
                                        str3.getClass();
                                        AwaitKt.launch$default(coroutineScope2, null, null, new YouTubePlaylistMenuKt$YouTubePlaylistMenu$16$1$1(list10, str3, context2, playlistItem6, null, (byte) 0), 3);
                                        function12.invoke();
                                        break;
                                    default:
                                        String str4 = (String) obj2;
                                        str4.getClass();
                                        AwaitKt.launch$default(coroutineScope2, null, null, new YouTubePlaylistMenuKt$YouTubePlaylistMenu$16$1$1(list10, str4, context2, playlistItem6, null, (byte) 1), 3);
                                        function12.invoke();
                                        break;
                                }
                                return unit;
                            }
                        };
                        list7 = list10;
                        playlistItem4 = playlistItem6;
                        gapComposer7.updateRememberedValue(obj);
                    } else {
                        playlistItem4 = playlistItem3;
                        list7 = list5;
                        obj = objRememberedValue20;
                        context2 = context;
                    }
                    Function1 function12 = (Function1) obj;
                    boolean zChangedInstance5 = (i12 != 256 ? false : z2) | (i13 != 32 ? false : z2) | gapComposer7.changedInstance(playlistItem4) | gapComposer7.changedInstance(context2);
                    if (i11 != 2048) {
                        z2 = false;
                    }
                    boolean z6 = zChangedInstance5 | z2;
                    Object objRememberedValue21 = gapComposer7.rememberedValue();
                    if (z6 || objRememberedValue21 == neverEqualPolicy) {
                        final byte b9 = 1;
                        final PlaylistItem playlistItem7 = playlistItem4;
                        final List list11 = list7;
                        Function1 function13 = new Function1() { // from class: com.metrolist.music.ui.menu.YouTubePlaylistMenuKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                byte b10 = b9;
                                Unit unit = Unit.INSTANCE;
                                Function0 function14 = function0;
                                CoroutineScope coroutineScope2 = coroutineScope;
                                switch (b10) {
                                    case 0:
                                        String str3 = (String) obj2;
                                        str3.getClass();
                                        AwaitKt.launch$default(coroutineScope2, null, null, new YouTubePlaylistMenuKt$YouTubePlaylistMenu$16$1$1(list11, str3, context2, playlistItem7, null, (byte) 0), 3);
                                        function14.invoke();
                                        break;
                                    default:
                                        String str4 = (String) obj2;
                                        str4.getClass();
                                        AwaitKt.launch$default(coroutineScope2, null, null, new YouTubePlaylistMenuKt$YouTubePlaylistMenu$16$1$1(list11, str4, context2, playlistItem7, null, (byte) 1), 3);
                                        function14.invoke();
                                        break;
                                }
                                return unit;
                            }
                        };
                        list6 = list11;
                        gapComposer7.updateRememberedValue(function13);
                        objRememberedValue21 = function13;
                    } else {
                        list6 = list7;
                    }
                    gapComposer4 = gapComposer7;
                    AlbumMenuKt.ExportDialog(function11, null, function12, (Function1) objRememberedValue21, gapComposer4, 6);
                    gapComposer4.end(false);
                } else {
                    gapComposer4 = gapComposer7;
                    list6 = list5;
                    gapComposer4.startReplaceGroup(-117347891);
                    gapComposer4.end(false);
                }
                gapComposer = gapComposer4;
                list3 = list6;
                function2 = function5;
            }
            recomposeScopeImplEndRestartGroup.block = function3;
        }
        gapComposer5.skipToGroupEnd();
        gapComposer = gapComposer5;
        list3 = list2;
        function2 = function1;
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            final byte b10 = 0;
            function3 = new Function2(playlistItem, list3, coroutineScope, function0, function2, i, i2, b10) { // from class: com.metrolist.music.ui.menu.YouTubePlaylistMenuKt$$ExternalSyntheticLambda8
                public final /* synthetic */ byte $r8$classId;
                public final /* synthetic */ PlaylistItem f$0;
                public final /* synthetic */ List f$1;
                public final /* synthetic */ CoroutineScope f$2;
                public final /* synthetic */ Function0 f$3;
                public final /* synthetic */ Function0 f$4;
                public final /* synthetic */ byte f$7;

                /* JADX WARN: Multi-variable type inference failed */
                {
                    this.$r8$classId = b10;
                    this.f$7 = i2;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    byte b11 = this.$r8$classId;
                    Unit unit = Unit.INSTANCE;
                    switch (b11) {
                        case 0:
                            ((Integer) obj3).getClass();
                            int iUpdateChangedFlags = Stack.updateChangedFlags(1);
                            YouTubeAlbumMenuKt.YouTubePlaylistMenu(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, (Composer) obj2, iUpdateChangedFlags, this.f$7);
                            break;
                        default:
                            ((Integer) obj3).getClass();
                            int iUpdateChangedFlags2 = Stack.updateChangedFlags(1);
                            YouTubeAlbumMenuKt.YouTubePlaylistMenu(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, (Composer) obj2, iUpdateChangedFlags2, this.f$7);
                            break;
                    }
                    return unit;
                }
            };
            recomposeScopeImplEndRestartGroup.block = function3;
        }
    }

    /* JADX WARN: Code duplicated, block: B:70:0x013d  */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void YouTubeSelectionSongMenu(final ArrayList arrayList, final Function0 function0, final Function0 function1, Composer composer, final int i) {
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        Function2 function2;
        boolean z;
        boolean z2;
        DownloadUtil downloadUtil;
        ArrayList arrayList2;
        ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState;
        boolean z3;
        DownloadUtil downloadUtil2;
        MutableState mutableState;
        MusicDatabase musicDatabase;
        GapComposer gapComposer;
        MutableState mutableState2;
        byte b;
        byte b2;
        function0.getClass();
        function1.getClass();
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(-243030846);
        int i2 = i | (gapComposer2.changed(arrayList) ? 4 : 2) | (gapComposer2.changedInstance(function0) ? 32 : 16);
        if (gapComposer2.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
            Context context = (Context) gapComposer2.consume(AndroidCompositionLocals_androidKt.LocalContext);
            MusicDatabase musicDatabase2 = (MusicDatabase) gapComposer2.consume(MainActivityKt.LocalDatabase);
            DownloadUtil downloadUtil3 = (DownloadUtil) gapComposer2.consume(MainActivityKt.LocalDownloadUtil);
            PlayerConnection playerConnection = (PlayerConnection) gapComposer2.consume(MainActivityKt.LocalPlayerConnection);
            if (playerConnection == null) {
                recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup == null) {
                    return;
                }
                final byte b3 = 0;
                function2 = new Function2(arrayList, function0, function1, i, b3) { // from class: com.metrolist.music.ui.menu.YouTubeSelectionSongMenuKt$$ExternalSyntheticLambda0
                    public final /* synthetic */ byte $r8$classId;
                    public final /* synthetic */ ArrayList f$0;
                    public final /* synthetic */ Function0 f$1;
                    public final /* synthetic */ Function0 f$2;

                    {
                        this.$r8$classId = b3;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        byte b4 = this.$r8$classId;
                        Unit unit = Unit.INSTANCE;
                        Function0 function3 = this.f$2;
                        Function0 function4 = this.f$1;
                        ArrayList arrayList3 = this.f$0;
                        Composer composer2 = (Composer) obj;
                        ((Integer) obj2).getClass();
                        switch (b4) {
                            case 0:
                                YouTubeAlbumMenuKt.YouTubeSelectionSongMenu(arrayList3, function4, function3, composer2, Stack.updateChangedFlags(385));
                                break;
                            default:
                                YouTubeAlbumMenuKt.YouTubeSelectionSongMenu(arrayList3, function4, function3, composer2, Stack.updateChangedFlags(385));
                                break;
                        }
                        return unit;
                    }
                };
            } else {
                Object objRememberedValue = gapComposer2.rememberedValue();
                NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                if (objRememberedValue == neverEqualPolicy) {
                    objRememberedValue = Stack.createCompositionCoroutineScope(gapComposer2);
                    gapComposer2.updateRememberedValue(objRememberedValue);
                }
                CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
                SyncUtils syncUtils = (SyncUtils) gapComposer2.consume(MainActivityKt.LocalSyncUtils);
                Object[] objArr = new Object[0];
                Object objRememberedValue2 = gapComposer2.rememberedValue();
                if (objRememberedValue2 == neverEqualPolicy) {
                    objRememberedValue2 = new QueueKt$$ExternalSyntheticLambda2((byte) 13);
                    gapComposer2.updateRememberedValue(objRememberedValue2);
                }
                MutableState mutableState3 = (MutableState) SaverKt.rememberSaveable(objArr, (Function0) objRememberedValue2, gapComposer2, 48);
                ListenTogetherManager listenTogetherManager = (ListenTogetherManager) gapComposer2.consume(MainActivityKt.LocalListenTogetherManager);
                boolean z4 = (listenTogetherManager == null || !listenTogetherManager.client.isInRoom() || listenTogetherManager.isHost()) ? false : true;
                Object objRememberedValue3 = gapComposer2.rememberedValue();
                if (objRememberedValue3 == neverEqualPolicy) {
                    objRememberedValue3 = Fragment$5$$ExternalSyntheticOutline0.m(1, gapComposer2);
                }
                ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState2 = (ParcelableSnapshotMutableIntState) objRememberedValue3;
                Object objRememberedValue4 = gapComposer2.rememberedValue();
                if (objRememberedValue4 == neverEqualPolicy) {
                    objRememberedValue4 = Stack.mutableStateOf$default(Boolean.FALSE);
                    gapComposer2.updateRememberedValue(objRememberedValue4);
                }
                MutableState mutableState4 = (MutableState) objRememberedValue4;
                int i3 = i2 & 14;
                boolean z5 = i3 == 4;
                Object objRememberedValue5 = gapComposer2.rememberedValue();
                if (z5 || objRememberedValue5 == neverEqualPolicy) {
                    if (arrayList.isEmpty()) {
                        z = false;
                    } else {
                        if (!arrayList.isEmpty()) {
                            Iterator it = arrayList.iterator();
                            if (it.hasNext()) {
                                HexFormatKt.toMediaMetadata((SongItem) it.next());
                                z = false;
                            }
                        }
                        z = true;
                    }
                    objRememberedValue5 = Stack.mutableStateOf$default(Boolean.valueOf(z));
                    gapComposer2.updateRememberedValue(objRememberedValue5);
                }
                MutableState mutableState5 = (MutableState) objRememberedValue5;
                boolean z6 = i3 == 4;
                Object objRememberedValue6 = gapComposer2.rememberedValue();
                if (z6 || objRememberedValue6 == neverEqualPolicy) {
                    if (arrayList.isEmpty()) {
                        z2 = true;
                    } else {
                        Iterator it2 = arrayList.iterator();
                        if (it2.hasNext()) {
                            HexFormatKt.toMediaMetadata((SongItem) it2.next());
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                    }
                    objRememberedValue6 = Stack.mutableStateOf$default(Boolean.valueOf(z2));
                    gapComposer2.updateRememberedValue(objRememberedValue6);
                }
                MutableState mutableState6 = (MutableState) objRememberedValue6;
                boolean zChangedInstance = (i3 == 4) | gapComposer2.changedInstance(downloadUtil3);
                Object objRememberedValue7 = gapComposer2.rememberedValue();
                boolean z7 = z4;
                Continuation continuation = null;
                if (zChangedInstance || objRememberedValue7 == neverEqualPolicy) {
                    downloadUtil = downloadUtil3;
                    arrayList2 = arrayList;
                    objRememberedValue7 = new SelectionSongsMenuKt$SelectionSongMenu$1$1(arrayList2, downloadUtil, parcelableSnapshotMutableIntState2, continuation, (byte) 1);
                    parcelableSnapshotMutableIntState = parcelableSnapshotMutableIntState2;
                    gapComposer2.updateRememberedValue(objRememberedValue7);
                } else {
                    downloadUtil = downloadUtil3;
                    parcelableSnapshotMutableIntState = parcelableSnapshotMutableIntState2;
                    arrayList2 = arrayList;
                }
                Stack.LaunchedEffect(gapComposer2, arrayList2, (Function2) objRememberedValue7);
                boolean zBooleanValue = ((Boolean) mutableState3.getValue()).booleanValue();
                Object objRememberedValue8 = gapComposer2.rememberedValue();
                if (objRememberedValue8 == neverEqualPolicy) {
                    ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10));
                    int size = arrayList2.size();
                    int i4 = 0;
                    while (i4 < size) {
                        Object obj = arrayList2.get(i4);
                        int i5 = i4 + 1;
                        boolean z8 = zBooleanValue;
                        MediaMetadata mediaMetadata = HexFormatKt.toMediaMetadata((SongItem) obj);
                        MediaMetadata.Album album = mediaMetadata.album;
                        DownloadUtil downloadUtil4 = downloadUtil;
                        SongEntity songEntity = new SongEntity(mediaMetadata.id, mediaMetadata.title, mediaMetadata.duration, mediaMetadata.thumbnailUrl, album != null ? album.id : null, album != null ? album.title : null, false, false, mediaMetadata.libraryAddToken, mediaMetadata.libraryRemoveToken, false, false, null, 133974976);
                        int i6 = size;
                        List<MediaMetadata.Artist> list = mediaMetadata.artists;
                        MutableState mutableState7 = mutableState4;
                        MusicDatabase musicDatabase3 = musicDatabase2;
                        ArrayList arrayList4 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                        for (MediaMetadata.Artist artist : list) {
                            String str = artist.id;
                            if (str == null) {
                                str = "";
                            }
                            arrayList4.add(new ArtistEntity(str, artist.name, null, null, null, false, null, 508));
                        }
                        arrayList3.add(new Song(songEntity, arrayList4, album != null ? new AlbumEntity(album.id, null, album.title, null, mediaMetadata.thumbnailUrl, 0, 0, false, 32554) : null, 20));
                        arrayList2 = arrayList;
                        musicDatabase2 = musicDatabase3;
                        downloadUtil = downloadUtil4;
                        zBooleanValue = z8;
                        size = i6;
                        i4 = i5;
                        mutableState4 = mutableState7;
                    }
                    z3 = zBooleanValue;
                    downloadUtil2 = downloadUtil;
                    mutableState = mutableState4;
                    musicDatabase = musicDatabase2;
                    objRememberedValue8 = Stack.toMutableStateList(arrayList3);
                    gapComposer2.updateRememberedValue(objRememberedValue8);
                } else {
                    z3 = zBooleanValue;
                    downloadUtil2 = downloadUtil;
                    mutableState = mutableState4;
                    musicDatabase = musicDatabase2;
                }
                SnapshotStateList snapshotStateList = (SnapshotStateList) objRememberedValue8;
                boolean zChanged = gapComposer2.changed(mutableState3);
                Object objRememberedValue9 = gapComposer2.rememberedValue();
                if (zChanged || objRememberedValue9 == neverEqualPolicy) {
                    objRememberedValue9 = new SongMenuKt$$ExternalSyntheticLambda2(mutableState3, (byte) 23);
                    gapComposer2.updateRememberedValue(objRememberedValue9);
                }
                Function0 function3 = (Function0) objRememberedValue9;
                Object objRememberedValue10 = gapComposer2.rememberedValue();
                if (objRememberedValue10 == neverEqualPolicy) {
                    objRememberedValue10 = new SongMenuKt$$ExternalSyntheticLambda16((byte) 17);
                    gapComposer2.updateRememberedValue(objRememberedValue10);
                }
                Function1 function4 = (Function1) objRememberedValue10;
                Object objRememberedValue11 = gapComposer2.rememberedValue();
                if (objRememberedValue11 == neverEqualPolicy) {
                    objRememberedValue11 = new SongMenuKt$$ExternalSyntheticLambda16((byte) 18);
                    gapComposer2.updateRememberedValue(objRememberedValue11);
                }
                ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState3 = parcelableSnapshotMutableIntState;
                MusicDatabase musicDatabase4 = musicDatabase;
                DownloadUtil downloadUtil5 = downloadUtil2;
                AlbumMenuKt.AddToPlaylistDialogOnline(z3, false, null, snapshotStateList, function3, function4, (Function1) objRememberedValue11, null, null, gapComposer2, 1772544, 390);
                if (((Boolean) mutableState.getValue()).booleanValue()) {
                    gapComposer2.startReplaceGroup(1187824384);
                    Object objRememberedValue12 = gapComposer2.rememberedValue();
                    if (objRememberedValue12 == neverEqualPolicy) {
                        mutableState2 = mutableState;
                        objRememberedValue12 = new SongMenuKt$$ExternalSyntheticLambda2(mutableState2, (byte) 24);
                        gapComposer2.updateRememberedValue(objRememberedValue12);
                    } else {
                        mutableState2 = mutableState;
                    }
                    b2 = 1;
                    DialogKt.DefaultDialog((Function0) objRememberedValue12, null, null, null, Expect_jvmKt.rememberComposableLambda(2116425967, new SelectionSongsMenuKt$$ExternalSyntheticLambda12(b2, context, mutableState2, arrayList), gapComposer2), null, AlbumMenuKt.lambda$848949317, gapComposer2, 1597446, 46);
                    gapComposer = gapComposer2;
                    b = 0;
                    gapComposer.end(false);
                } else {
                    gapComposer = gapComposer2;
                    mutableState2 = mutableState;
                    b = 0;
                    b2 = 1;
                    gapComposer.startReplaceGroup(1189085216);
                    gapComposer.end(false);
                }
                String strStringResource = MathKt.stringResource(R.string.queue_all_songs, gapComposer);
                WeakHashMap weakHashMap = WindowInsetsHolder.viewMap;
                PaddingValuesImpl paddingValuesImpl = new PaddingValuesImpl(8.0f, 8.0f, 8.0f, OffsetKt.asPaddingValues(OffsetKt.current(gapComposer).systemBars, gapComposer).mo122calculateBottomPaddingD9Ej5fM() + 8.0f + CropImageView.DEFAULT_ASPECT_RATIO);
                boolean z9 = (((gapComposer.changed(z7) ? 1 : 0) | (gapComposer.changedInstance(playerConnection) ? 1 : 0)) | (gapComposer.changed(strStringResource) ? 1 : 0) ? 1 : 0) | (i3 != 4 ? b : b2);
                if ((i2 & 112) != 32) {
                    b2 = b;
                }
                boolean z10 = ((((((z9 | b2) | (gapComposer.changed(mutableState3) ? 1 : 0) ? 1 : 0) | (gapComposer.changed(mutableState6) ? 1 : 0)) | (gapComposer.changedInstance(musicDatabase4) ? 1 : 0) ? 1 : 0) | (gapComposer.changedInstance(coroutineScope) ? 1 : 0)) | (gapComposer.changedInstance(downloadUtil5) ? 1 : 0) ? 1 : 0) | (gapComposer.changed(mutableState5) ? 1 : 0) | (gapComposer.changedInstance(syncUtils) ? 1 : 0);
                GapComposer gapComposer3 = gapComposer;
                Object objRememberedValue13 = gapComposer3.rememberedValue();
                if (z10 != 0 || objRememberedValue13 == neverEqualPolicy) {
                    objRememberedValue13 = new AlbumScreenKt$$ExternalSyntheticLambda7(z7, playerConnection, strStringResource, arrayList, function1, function0, mutableState3, mutableState6, musicDatabase4, coroutineScope, downloadUtil5, mutableState5, syncUtils, parcelableSnapshotMutableIntState3, mutableState2);
                    gapComposer2 = gapComposer3;
                    gapComposer2.updateRememberedValue(objRememberedValue13);
                } else {
                    gapComposer2 = gapComposer3;
                }
                IntMath.LazyColumn(null, null, paddingValuesImpl, null, null, null, false, null, (Function1) objRememberedValue13, gapComposer2, 0, 507);
            }
            recomposeScopeImplEndRestartGroup.block = function2;
        }
        gapComposer2.skipToGroupEnd();
        recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            final byte b4 = 1;
            function2 = new Function2(arrayList, function0, function1, i, b4) { // from class: com.metrolist.music.ui.menu.YouTubeSelectionSongMenuKt$$ExternalSyntheticLambda0
                public final /* synthetic */ byte $r8$classId;
                public final /* synthetic */ ArrayList f$0;
                public final /* synthetic */ Function0 f$1;
                public final /* synthetic */ Function0 f$2;

                {
                    this.$r8$classId = b4;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    byte b5 = this.$r8$classId;
                    Unit unit = Unit.INSTANCE;
                    Function0 function5 = this.f$2;
                    Function0 function6 = this.f$1;
                    ArrayList arrayList5 = this.f$0;
                    Composer composer2 = (Composer) obj2;
                    ((Integer) obj3).getClass();
                    switch (b5) {
                        case 0:
                            YouTubeAlbumMenuKt.YouTubeSelectionSongMenu(arrayList5, function6, function5, composer2, Stack.updateChangedFlags(385));
                            break;
                        default:
                            YouTubeAlbumMenuKt.YouTubeSelectionSongMenu(arrayList5, function6, function5, composer2, Stack.updateChangedFlags(385));
                            break;
                    }
                    return unit;
                }
            };
            recomposeScopeImplEndRestartGroup.block = function2;
        }
    }
}
