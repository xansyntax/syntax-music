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
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.navigation.NavHostController;
import coil3.util.FileSystemsKt;
import com.google.common.math.IntMath;
import com.metrolist.music.MainActivityKt;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.db.entities.SongEntity;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.playback.DownloadUtil;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.ui.component.BottomSheetState;
import com.metrolist.music.ui.component.DialogKt;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.utils.SyncUtils;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class QueueMenuKt {
    public static final void QueueMenu(final MediaMetadata mediaMetadata, final BottomSheetState bottomSheetState, final Function0 function0, final Function0 function1, Composer composer, int i) {
        GapComposer gapComposer;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        QueueMenuKt$$ExternalSyntheticLambda0 queueMenuKt$$ExternalSyntheticLambda0;
        NeverEqualPolicy neverEqualPolicy;
        final MutableState mutableState;
        boolean z;
        boolean z2;
        SongEntity songEntity;
        GapComposer gapComposer2;
        SongEntity songEntity2;
        SongEntity songEntity3;
        Object queueMenuKt$$ExternalSyntheticLambda5;
        function0.getClass();
        function1.getClass();
        GapComposer gapComposer3 = (GapComposer) composer;
        gapComposer3.startRestartGroup(1580231390);
        int i2 = i | (gapComposer3.changed(mediaMetadata) ? 4 : 2) | (gapComposer3.changed(bottomSheetState) ? 32 : 16) | (gapComposer3.changedInstance(function0) ? 256 : 128) | (gapComposer3.changedInstance(function1) ? 2048 : 1024);
        boolean z3 = false;
        if (gapComposer3.shouldExecute(i2 & 1, (i2 & 1171) != 1170)) {
            List list = mediaMetadata.artists;
            String str = mediaMetadata.id;
            final NavHostController navHostController = (NavHostController) gapComposer3.consume(MainActivityKt.LocalNavController);
            final Context context = (Context) gapComposer3.consume(AndroidCompositionLocals_androidKt.LocalContext);
            final MusicDatabase musicDatabase = (MusicDatabase) gapComposer3.consume(MainActivityKt.LocalDatabase);
            PlayerConnection playerConnection = (PlayerConnection) gapComposer3.consume(MainActivityKt.LocalPlayerConnection);
            if (playerConnection == null) {
                recomposeScopeImplEndRestartGroup = gapComposer3.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup == null) {
                    return;
                } else {
                    queueMenuKt$$ExternalSyntheticLambda0 = new QueueMenuKt$$ExternalSyntheticLambda0(mediaMetadata, bottomSheetState, function0, function1, i, (byte) 0);
                }
            } else {
                Object objRememberedValue = gapComposer3.rememberedValue();
                NeverEqualPolicy neverEqualPolicy2 = Composer.Companion.Empty;
                if (objRememberedValue == neverEqualPolicy2) {
                    objRememberedValue = Stack.createCompositionCoroutineScope(gapComposer3);
                    gapComposer3.updateRememberedValue(objRememberedValue);
                }
                final CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
                SyncUtils syncUtils = (SyncUtils) gapComposer3.consume(MainActivityKt.LocalSyncUtils);
                DownloadUtil downloadUtil = (DownloadUtil) gapComposer3.consume(MainActivityKt.LocalDownloadUtil);
                final MutableState mutableStateCollectAsStateWithLifecycle = FileSystemsKt.collectAsStateWithLifecycle(musicDatabase.$$delegate_0.song(str), null, gapComposer3, 48);
                final MutableState mutableStateCollectAsStateWithLifecycle2 = FileSystemsKt.collectAsStateWithLifecycle(downloadUtil.getDownload(str), null, gapComposer3, 48);
                Object objRememberedValue2 = gapComposer3.rememberedValue();
                if (objRememberedValue2 == neverEqualPolicy2) {
                    objRememberedValue2 = Format$$ExternalSyntheticOutline0.m(CropImageView.DEFAULT_ASPECT_RATIO, gapComposer3);
                }
                final ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = (ParcelableSnapshotMutableFloatState) objRememberedValue2;
                DownloadUtil downloadUtil2 = downloadUtil;
                AnimateAsState animateAsStateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(parcelableSnapshotMutableFloatState.getFloatValue(), ArcSplineKt.tween$default(800, 0, null, 6), "", gapComposer3, 3120, 20);
                boolean zChanged = gapComposer3.changed(list);
                Object objRememberedValue3 = gapComposer3.rememberedValue();
                Object obj = objRememberedValue3;
                if (zChanged || objRememberedValue3 == neverEqualPolicy2) {
                    ArrayList arrayList = new ArrayList();
                    for (Object obj2 : list) {
                        if (((MediaMetadata.Artist) obj2).id != null) {
                            arrayList.add(obj2);
                        }
                    }
                    gapComposer3.updateRememberedValue(arrayList);
                    obj = arrayList;
                }
                final List list2 = (List) obj;
                Object[] objArr = new Object[0];
                Object objRememberedValue4 = gapComposer3.rememberedValue();
                if (objRememberedValue4 == neverEqualPolicy2) {
                    objRememberedValue4 = new AlbumMenuKt$$ExternalSyntheticLambda3((byte) 26);
                    gapComposer3.updateRememberedValue(objRememberedValue4);
                }
                final MutableState mutableState2 = (MutableState) SaverKt.rememberSaveable(objArr, (Function0) objRememberedValue4, gapComposer3, 48);
                boolean zBooleanValue = ((Boolean) mutableState2.getValue()).booleanValue();
                int i3 = i2 & 14;
                boolean zChangedInstance = gapComposer3.changedInstance(musicDatabase) | (i3 == 4);
                Object objRememberedValue5 = gapComposer3.rememberedValue();
                if (zChangedInstance || objRememberedValue5 == neverEqualPolicy2) {
                    objRememberedValue5 = new QueueMenuKt$QueueMenu$2$1(musicDatabase, mediaMetadata, null, (byte) 0);
                    gapComposer3.updateRememberedValue(objRememberedValue5);
                }
                Function1 function2 = (Function1) objRememberedValue5;
                boolean z4 = i3 == 4;
                Object objRememberedValue6 = gapComposer3.rememberedValue();
                if (z4 || objRememberedValue6 == neverEqualPolicy2) {
                    objRememberedValue6 = new QueueMenuKt$QueueMenu$3$1(mediaMetadata, null, (byte) 0);
                    gapComposer3.updateRememberedValue(objRememberedValue6);
                }
                Function1 function3 = (Function1) objRememberedValue6;
                boolean zChanged2 = gapComposer3.changed(mutableState2);
                Object objRememberedValue7 = gapComposer3.rememberedValue();
                if (zChanged2 || objRememberedValue7 == neverEqualPolicy2) {
                    objRememberedValue7 = new QueueMenuKt$$ExternalSyntheticLambda2(mutableState2, (byte) 0);
                    gapComposer3.updateRememberedValue(objRememberedValue7);
                }
                AnimateAsState animateAsState = animateAsStateAnimateFloatAsState;
                PlayerConnection playerConnection2 = playerConnection;
                Modifier modifier = null;
                AlbumMenuKt.AddToPlaylistDialog(zBooleanValue, false, function2, function3, (Function0) objRememberedValue7, null, gapComposer3, 0);
                Object[] objArr2 = new Object[0];
                Object objRememberedValue8 = gapComposer3.rememberedValue();
                if (objRememberedValue8 == neverEqualPolicy2) {
                    objRememberedValue8 = new AlbumMenuKt$$ExternalSyntheticLambda3((byte) 27);
                    gapComposer3.updateRememberedValue(objRememberedValue8);
                }
                MutableState mutableState3 = (MutableState) SaverKt.rememberSaveable(objArr2, (Function0) objRememberedValue8, gapComposer3, 48);
                if (((Boolean) mutableState3.getValue()).booleanValue()) {
                    gapComposer3.startReplaceGroup(-461460490);
                    boolean zChanged3 = gapComposer3.changed(mutableState3);
                    Object objRememberedValue9 = gapComposer3.rememberedValue();
                    if (zChanged3 || objRememberedValue9 == neverEqualPolicy2) {
                        objRememberedValue9 = new QueueMenuKt$$ExternalSyntheticLambda2(mutableState3, (byte) 15);
                        gapComposer3.updateRememberedValue(objRememberedValue9);
                    }
                    Function0 function4 = (Function0) objRememberedValue9;
                    boolean zChangedInstance2 = gapComposer3.changedInstance(list2) | gapComposer3.changedInstance(navHostController) | gapComposer3.changed(mutableState3) | ((i2 & 112) == 32) | ((i2 & 7168) == 2048);
                    Object objRememberedValue10 = gapComposer3.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue10 == neverEqualPolicy2) {
                        neverEqualPolicy = neverEqualPolicy2;
                        mutableState = mutableState3;
                        queueMenuKt$$ExternalSyntheticLambda5 = new QueueMenuKt$$ExternalSyntheticLambda5(list2, navHostController, mutableState, bottomSheetState, function1, (byte) 0);
                        gapComposer3.updateRememberedValue(queueMenuKt$$ExternalSyntheticLambda5);
                    } else {
                        neverEqualPolicy = neverEqualPolicy2;
                        mutableState = mutableState3;
                        queueMenuKt$$ExternalSyntheticLambda5 = objRememberedValue10;
                    }
                    DialogKt.ListDialog(function4, modifier, (Function1) queueMenuKt$$ExternalSyntheticLambda5, gapComposer3, z3);
                    gapComposer3.end(z3);
                } else {
                    mediaMetadata = mediaMetadata;
                    downloadUtil2 = downloadUtil2;
                    i2 = i2;
                    playerConnection2 = playerConnection2;
                    z3 = false;
                    neverEqualPolicy = neverEqualPolicy2;
                    animateAsState = animateAsState;
                    mutableState = mutableState3;
                    modifier = null;
                    gapComposer3.startReplaceGroup(-459847932);
                    gapComposer3.end(false);
                }
                Song song = (Song) mutableStateCollectAsStateWithLifecycle.getValue();
                if ((song == null || (songEntity3 = song.song) == null || !songEntity3.isEpisode) && !mediaMetadata.isEpisode) {
                    Song song2 = (Song) mutableStateCollectAsStateWithLifecycle.getValue();
                    if (song2 == null || (songEntity = song2.song) == null) {
                        z = true;
                    } else {
                        z = true;
                        if (songEntity.liked) {
                            z2 = true;
                        }
                    }
                    z2 = z3;
                } else {
                    Song song3 = (Song) mutableStateCollectAsStateWithLifecycle.getValue();
                    if (((song3 == null || (songEntity2 = song3.song) == null) ? modifier : songEntity2.inLibrary) != null) {
                        z = true;
                        z2 = true;
                    } else {
                        z2 = z3;
                        z = true;
                    }
                }
                boolean z5 = z3;
                int i4 = i2;
                final DownloadUtil downloadUtil3 = downloadUtil2;
                boolean z6 = z;
                boolean z7 = z2;
                final PlayerConnection playerConnection3 = playerConnection2;
                MenuKt.MediaMetadataListItem(mediaMetadata, modifier, Expect_jvmKt.rememberComposableLambda(375833098, new QueueMenuKt$$ExternalSyntheticLambda6(coroutineScope, musicDatabase, mutableStateCollectAsStateWithLifecycle, mediaMetadata, context, syncUtils, z7), gapComposer3), gapComposer3, i3 | 196608);
                CardKt.m261HorizontalDivider9IZ8Weo(null, CropImageView.DEFAULT_ASPECT_RATIO, 0L, gapComposer3, 0, 7);
                OffsetKt.Spacer(gapComposer3, SizeKt.m145height3ABfNKs(Modifier.Companion.$$INSTANCE, 12.0f));
                int i5 = ((Configuration) gapComposer3.consume(AndroidCompositionLocals_androidKt.LocalConfiguration)).orientation;
                WeakHashMap weakHashMap = WindowInsetsHolder.viewMap;
                PaddingValuesImpl paddingValuesImpl = new PaddingValuesImpl(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, OffsetKt.asPaddingValues(OffsetKt.current(gapComposer3).systemBars, gapComposer3).mo122calculateBottomPaddingD9Ej5fM() + 8.0f + CropImageView.DEFAULT_ASPECT_RATIO);
                final AnimateAsState animateAsState2 = animateAsState;
                boolean zChangedInstance3 = ((i4 & 7168) == 2048 ? z6 : z5) | gapComposer3.changedInstance(playerConnection3) | (i3 == 4 ? z6 : z5) | gapComposer3.changed(mutableState2) | gapComposer3.changedInstance(context) | gapComposer3.changed(mutableStateCollectAsStateWithLifecycle) | gapComposer3.changed(mutableStateCollectAsStateWithLifecycle2) | gapComposer3.changedInstance(downloadUtil3) | gapComposer3.changedInstance(list2) | gapComposer3.changedInstance(navHostController) | ((i4 & 112) == 32 ? z6 : z5) | gapComposer3.changed(mutableState) | gapComposer3.changed(animateAsState2) | gapComposer3.changedInstance(coroutineScope) | gapComposer3.changedInstance(musicDatabase);
                if ((i4 & 896) == 256) {
                    z5 = z6;
                }
                boolean z8 = zChangedInstance3 | z5;
                Object objRememberedValue11 = gapComposer3.rememberedValue();
                if (z8 || objRememberedValue11 == neverEqualPolicy) {
                    Function1 function5 = new Function1() { // from class: com.metrolist.music.ui.menu.QueueMenuKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj3) {
                            LazyListIntervalContent lazyListIntervalContent = (LazyListIntervalContent) obj3;
                            lazyListIntervalContent.getClass();
                            Function0 function6 = function1;
                            PlayerConnection playerConnection4 = playerConnection3;
                            MediaMetadata mediaMetadata2 = mediaMetadata;
                            MutableState mutableState4 = mutableState2;
                            Context context2 = context;
                            LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, new ComposableLambdaImpl(true, 2002458483, new QueueMenuKt$$ExternalSyntheticLambda9((Object) function6, (Object) playerConnection4, (Object) mediaMetadata2, (Object) mutableState4, (Object) context2, (byte) 0)), 3);
                            MutableState mutableState5 = mutableStateCollectAsStateWithLifecycle;
                            LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, new ComposableLambdaImpl(true, 1957947114, new SongMenuKt$$ExternalSyntheticLambda34(function6, mutableState5, playerConnection4, mediaMetadata2, (byte) 8)), 3);
                            LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, AlbumMenuKt.lambda$1549923499, 3);
                            LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, new ComposableLambdaImpl(true, 1141899884, new QueueMenuKt$$ExternalSyntheticLambda11(context2, mediaMetadata2, downloadUtil3, mutableStateCollectAsStateWithLifecycle2, (byte) 0)), 3);
                            LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, AlbumMenuKt.lambda$733876269, 3);
                            LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, new ComposableLambdaImpl(true, 325852654, new QueueMenuKt$$ExternalSyntheticLambda12((Object) list2, (Object) mediaMetadata2, (Object) navHostController, (Object) bottomSheetState, (Object) function6, (Object) mutableState, (byte) 0)), 3);
                            LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, AlbumMenuKt.f261lambda$82170961, 3);
                            LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, new ComposableLambdaImpl(true, -490194576, new AlbumMenuKt$$ExternalSyntheticLambda20(coroutineScope, mediaMetadata2, mutableState5, musicDatabase, function0, function6, animateAsState2, parcelableSnapshotMutableFloatState)), 3);
                            return Unit.INSTANCE;
                        }
                    };
                    GapComposer gapComposer4 = gapComposer3;
                    gapComposer4.updateRememberedValue(function5);
                    objRememberedValue11 = function5;
                    gapComposer2 = gapComposer4;
                } else {
                    gapComposer2 = gapComposer3;
                }
                GapComposer gapComposer5 = gapComposer2;
                IntMath.LazyColumn(null, null, paddingValuesImpl, null, null, null, false, null, (Function1) objRememberedValue11, gapComposer5, 0, 507);
                gapComposer = gapComposer5;
            }
            recomposeScopeImplEndRestartGroup.block = queueMenuKt$$ExternalSyntheticLambda0;
        }
        gapComposer3.skipToGroupEnd();
        gapComposer = gapComposer3;
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            queueMenuKt$$ExternalSyntheticLambda0 = new QueueMenuKt$$ExternalSyntheticLambda0(mediaMetadata, bottomSheetState, function0, function1, i, (byte) 2);
            recomposeScopeImplEndRestartGroup.block = queueMenuKt$$ExternalSyntheticLambda0;
        }
    }
}
