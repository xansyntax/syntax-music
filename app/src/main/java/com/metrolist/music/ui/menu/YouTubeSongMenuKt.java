package com.metrolist.music.ui.menu;

import android.content.Context;
import android.content.res.Configuration;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsHolder;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.ListItemKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.navigation.NavHostController;
import coil3.compose.AsyncImageKt;
import coil3.util.FileSystemsKt;
import com.google.common.math.IntMath;
import com.metrolist.innertube.models.Artist;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertubex.InnerTube$executeMutation$2$1;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda59;
import com.metrolist.music.MainActivityKt;
import com.metrolist.music.constants.DimensionsKt;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.listentogether.ListenTogetherManager;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.playback.DownloadUtil;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.ui.component.BottomSheetPageKt;
import com.metrolist.music.ui.component.BottomSheetPageState;
import com.metrolist.music.ui.component.DialogKt;
import com.metrolist.music.ui.component.GlassComponentsKt;
import com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda92;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda2;
import com.metrolist.music.ui.utils.YouTubeUtilsKt;
import com.metrolist.music.utils.ArtistNameAliases;
import com.metrolist.music.utils.SyncUtils;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class YouTubeSongMenuKt {
    public static final void YouTubeSongMenu(final SongItem songItem, final Function0 function0, Function0 function1, Composer composer, final int i, final int i2) {
        Function0 function2;
        Function0 function3;
        int i3;
        final Function0 function4;
        GapComposer gapComposer;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        Function2 function5;
        final Function0 function6;
        DownloadUtil downloadUtil;
        MediaMetadata.Artist artist;
        Object obj;
        NavHostController navHostController;
        List list;
        char c;
        GapComposer gapComposer2;
        songItem.getClass();
        List list2 = songItem.artists;
        String str = songItem.id;
        function0.getClass();
        GapComposer gapComposer3 = (GapComposer) composer;
        gapComposer3.startRestartGroup(795631724);
        int i4 = i | (gapComposer3.changedInstance(songItem) ? 4 : 2);
        if ((i & 48) == 0) {
            function2 = function0;
            i4 |= gapComposer3.changedInstance(function2) ? 32 : 16;
        } else {
            function2 = function0;
        }
        int i5 = i2 & 4;
        if (i5 != 0) {
            i3 = i4 | 384;
            function3 = function1;
        } else {
            function3 = function1;
            i3 = i4 | (gapComposer3.changedInstance(function3) ? 256 : 128);
        }
        int i6 = i3;
        if (gapComposer3.shouldExecute(i6 & 1, (i6 & 147) != 146)) {
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (i5 != 0) {
                Object objRememberedValue = gapComposer3.rememberedValue();
                if (objRememberedValue == neverEqualPolicy) {
                    objRememberedValue = new QueueKt$$ExternalSyntheticLambda2((byte) 14);
                    gapComposer3.updateRememberedValue(objRememberedValue);
                }
                function6 = (Function0) objRememberedValue;
            } else {
                function6 = function3;
            }
            NavHostController navHostController2 = (NavHostController) gapComposer3.consume(MainActivityKt.LocalNavController);
            Context context = (Context) gapComposer3.consume(AndroidCompositionLocals_androidKt.LocalContext);
            MusicDatabase musicDatabase = (MusicDatabase) gapComposer3.consume(MainActivityKt.LocalDatabase);
            PlayerConnection playerConnection = (PlayerConnection) gapComposer3.consume(MainActivityKt.LocalPlayerConnection);
            if (playerConnection == null) {
                recomposeScopeImplEndRestartGroup = gapComposer3.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup == null) {
                    return;
                }
                final byte b = 1;
                final Function0 function7 = function2;
                function5 = new Function2() { // from class: com.metrolist.music.ui.menu.YouTubeSongMenuKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        byte b2 = b;
                        Unit unit = Unit.INSTANCE;
                        byte b3 = i;
                        switch (b2) {
                            case 0:
                                ((Integer) obj3).getClass();
                                int iUpdateChangedFlags = Stack.updateChangedFlags(b3 | 1);
                                YouTubeSongMenuKt.YouTubeSongMenu(songItem, function7, function6, (Composer) obj2, iUpdateChangedFlags, i2);
                                break;
                            default:
                                ((Integer) obj3).getClass();
                                int iUpdateChangedFlags2 = Stack.updateChangedFlags(b3 | 1);
                                YouTubeSongMenuKt.YouTubeSongMenu(songItem, function7, function6, (Composer) obj2, iUpdateChangedFlags2, i2);
                                break;
                        }
                        return unit;
                    }
                };
            } else {
                Function0 function8 = function6;
                DownloadUtil downloadUtil2 = (DownloadUtil) gapComposer3.consume(MainActivityKt.LocalDownloadUtil);
                MutableState mutableStateCollectAsStateWithLifecycle = FileSystemsKt.collectAsStateWithLifecycle(musicDatabase.$$delegate_0.song(str), null, gapComposer3, 48);
                MutableState mutableStateCollectAsStateWithLifecycle2 = FileSystemsKt.collectAsStateWithLifecycle(downloadUtil2.getDownload(str), null, gapComposer3, 48);
                Object objRememberedValue2 = gapComposer3.rememberedValue();
                if (objRememberedValue2 == neverEqualPolicy) {
                    objRememberedValue2 = Stack.createCompositionCoroutineScope(gapComposer3);
                    gapComposer3.updateRememberedValue(objRememberedValue2);
                }
                CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue2;
                SyncUtils syncUtils = (SyncUtils) gapComposer3.consume(MainActivityKt.LocalSyncUtils);
                ListenTogetherManager listenTogetherManager = (ListenTogetherManager) gapComposer3.consume(MainActivityKt.LocalListenTogetherManager);
                MutableState mutableStateCollectAsStateWithLifecycle3 = FileSystemsKt.collectAsStateWithLifecycle(musicDatabase.delegate.getSpeedDialDao().isPinned(str), Boolean.FALSE, gapComposer3, 48);
                Map map = (Map) gapComposer3.consume(MainActivityKt.LocalArtistNameAliases);
                boolean zChanged = gapComposer3.changed(list2) | gapComposer3.changed(map);
                Object objRememberedValue3 = gapComposer3.rememberedValue();
                if (zChanged || objRememberedValue3 == neverEqualPolicy) {
                    ArrayList arrayList = new ArrayList();
                    Iterator it = list2.iterator();
                    while (it.hasNext()) {
                        Artist artist2 = (Artist) it.next();
                        Iterator it2 = it;
                        String str2 = artist2.id;
                        DownloadUtil downloadUtil3 = downloadUtil2;
                        if (str2 != null) {
                            ArtistNameAliases artistNameAliases = ArtistNameAliases.INSTANCE;
                            artist = new MediaMetadata.Artist(str2, ArtistNameAliases.resolve(str2, artist2.name, map));
                        } else {
                            artist = null;
                        }
                        if (artist != null) {
                            arrayList.add(artist);
                        }
                        it = it2;
                        downloadUtil2 = downloadUtil3;
                    }
                    downloadUtil = downloadUtil2;
                    gapComposer3.updateRememberedValue(arrayList);
                    obj = arrayList;
                } else {
                    downloadUtil = downloadUtil2;
                    obj = objRememberedValue3;
                }
                List list3 = (List) obj;
                Object[] objArr = new Object[0];
                Object objRememberedValue4 = gapComposer3.rememberedValue();
                if (objRememberedValue4 == neverEqualPolicy) {
                    objRememberedValue4 = new QueueKt$$ExternalSyntheticLambda2((byte) 15);
                    gapComposer3.updateRememberedValue(objRememberedValue4);
                }
                MutableState mutableState = (MutableState) SaverKt.rememberSaveable(objArr, (Function0) objRememberedValue4, gapComposer3, 48);
                boolean zBooleanValue = ((Boolean) mutableState.getValue()).booleanValue();
                boolean zChangedInstance = gapComposer3.changedInstance(musicDatabase) | gapComposer3.changedInstance(songItem);
                Object objRememberedValue5 = gapComposer3.rememberedValue();
                if (zChangedInstance || objRememberedValue5 == neverEqualPolicy) {
                    objRememberedValue5 = new InnerTube$executeMutation$2$1(musicDatabase, songItem, null, (byte) 8);
                    gapComposer3.updateRememberedValue(objRememberedValue5);
                }
                Function1 function9 = (Function1) objRememberedValue5;
                boolean zChangedInstance2 = gapComposer3.changedInstance(songItem);
                Object objRememberedValue6 = gapComposer3.rememberedValue();
                if (zChangedInstance2 || objRememberedValue6 == neverEqualPolicy) {
                    objRememberedValue6 = new Animatable.AnonymousClass2(songItem, null, (byte) 1);
                    gapComposer3.updateRememberedValue(objRememberedValue6);
                }
                Function1 function10 = (Function1) objRememberedValue6;
                boolean zChanged2 = gapComposer3.changed(mutableState);
                Object objRememberedValue7 = gapComposer3.rememberedValue();
                if (zChanged2 || objRememberedValue7 == neverEqualPolicy) {
                    objRememberedValue7 = new SongMenuKt$$ExternalSyntheticLambda2(mutableState, (byte) 26);
                    gapComposer3.updateRememberedValue(objRememberedValue7);
                }
                DownloadUtil downloadUtil4 = downloadUtil;
                byte b2 = 0;
                final byte b3 = 1;
                AlbumMenuKt.AddToPlaylistDialog(zBooleanValue, false, function9, function10, (Function0) objRememberedValue7, null, gapComposer3, 0);
                Object[] objArr2 = new Object[0];
                Object objRememberedValue8 = gapComposer3.rememberedValue();
                if (objRememberedValue8 == neverEqualPolicy) {
                    objRememberedValue8 = new QueueKt$$ExternalSyntheticLambda2((byte) 16);
                    gapComposer3.updateRememberedValue(objRememberedValue8);
                }
                MutableState mutableState2 = (MutableState) SaverKt.rememberSaveable(objArr2, (Function0) objRememberedValue8, gapComposer3, 48);
                if (((Boolean) mutableState2.getValue()).booleanValue()) {
                    gapComposer3.startReplaceGroup(-1257979568);
                    boolean zChanged3 = gapComposer3.changed(mutableState2);
                    Object objRememberedValue9 = gapComposer3.rememberedValue();
                    if (zChanged3 || objRememberedValue9 == neverEqualPolicy) {
                        objRememberedValue9 = new SongMenuKt$$ExternalSyntheticLambda2(mutableState2, (byte) 27);
                        gapComposer3.updateRememberedValue(objRememberedValue9);
                    }
                    Function0 function11 = (Function0) objRememberedValue9;
                    c = ' ';
                    boolean zChangedInstance3 = gapComposer3.changedInstance(list3) | gapComposer3.changedInstance(navHostController2) | gapComposer3.changed(mutableState2) | ((i6 & 112) == 32);
                    Object objRememberedValue10 = gapComposer3.rememberedValue();
                    if (zChangedInstance3 || objRememberedValue10 == neverEqualPolicy) {
                        navHostController = navHostController2;
                        MainActivity$$ExternalSyntheticLambda59 mainActivity$$ExternalSyntheticLambda59 = new MainActivity$$ExternalSyntheticLambda59((Object) list3, navHostController, mutableState2, function0, (byte) 17);
                        list = list3;
                        gapComposer3.updateRememberedValue(mainActivity$$ExternalSyntheticLambda59);
                        objRememberedValue10 = mainActivity$$ExternalSyntheticLambda59;
                    } else {
                        list = list3;
                        navHostController = navHostController2;
                    }
                    DialogKt.ListDialog(function11, null, (Function1) objRememberedValue10, gapComposer3, 0);
                    gapComposer3.end(false);
                } else {
                    navHostController = navHostController2;
                    mutableState2 = mutableState2;
                    list = list3;
                    c = ' ';
                    gapComposer3.startReplaceGroup(-1256343946);
                    gapComposer3.end(false);
                }
                List list4 = list;
                final byte b4 = 0;
                MutableState mutableState3 = mutableState2;
                NavHostController navHostController3 = navHostController;
                ListItemKt.ListItem(null, false, Expect_jvmKt.rememberComposableLambda(2057029964, new Function2() { // from class: com.metrolist.music.ui.menu.YouTubeSongMenuKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        byte b5 = b3;
                        Unit unit = Unit.INSTANCE;
                        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                        SongItem songItem2 = songItem;
                        switch (b5) {
                            case 0:
                                Composer composer2 = (Composer) obj2;
                                int iIntValue = ((Integer) obj3).intValue();
                                GapComposer gapComposer4 = (GapComposer) composer2;
                                if (!gapComposer4.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                                    gapComposer4.skipToGroupEnd();
                                } else {
                                    TextKt.m352TextNvy7gAk(songItem2.title, ImageKt.m41basicMarquee1Mj1MLw$default(companion, 63), 0L, 0L, null, null, null, 0L, null, 0L, 2, false, 1, 0, null, gapComposer4, 48, 24960, 241660);
                                }
                                break;
                            default:
                                Composer composer3 = (Composer) obj2;
                                int iIntValue2 = ((Integer) obj3).intValue();
                                GapComposer gapComposer5 = (GapComposer) composer3;
                                if (!gapComposer5.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                                    gapComposer5.skipToGroupEnd();
                                } else {
                                    BiasAlignment biasAlignment = Alignment.Companion.Center;
                                    SpringSpec springSpec = DimensionsKt.NavigationBarAnimationSpec;
                                    Modifier modifierClip = ClipKt.clip(SizeKt.m151size3ABfNKs(companion, 48.0f), RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(10.0f));
                                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, false);
                                    int iHashCode = Long.hashCode(gapComposer5.compositeKeyHashCode);
                                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer5.currentCompositionLocalScope();
                                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer5, modifierClip);
                                    ComposeUiNode.Companion.getClass();
                                    gapComposer5.startReusableNode();
                                    if (gapComposer5.inserting) {
                                        gapComposer5.createNode(LayoutNode.Constructor);
                                    } else {
                                        gapComposer5.useNode();
                                    }
                                    Stack.m390setimpl(gapComposer5, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                                    Stack.m390setimpl(gapComposer5, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                                    Stack.m390setimpl(gapComposer5, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
                                    Stack.m389reconcileimpl(gapComposer5);
                                    Stack.m390setimpl(gapComposer5, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                                    AsyncImageKt.m849AsyncImage10Xjiaw(YouTubeUtilsKt.resize(songItem2.thumbnail, 200, 200), ClipKt.clip(SizeKt.fillMaxWidth(companion, 1.0f), RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(10.0f)), null, gapComposer5, 48, 2040);
                                    gapComposer5.end(true);
                                }
                                break;
                        }
                        return unit;
                    }
                }, gapComposer3), Expect_jvmKt.rememberComposableLambda(-443751987, new PlayerKt$$ExternalSyntheticLambda92((Object) songItem, (State) mutableStateCollectAsStateWithLifecycle, (Object) musicDatabase, (Object) coroutineScope, (Object) syncUtils, (byte) 7), gapComposer3), Expect_jvmKt.rememberComposableLambda(-1150348593, new YouTubeSongMenuKt$$ExternalSyntheticLambda12(songItem, map, b2), gapComposer3), null, null, GlassComponentsKt.glassListItemColors(gapComposer3), null, null, Expect_jvmKt.rememberComposableLambda(-834468702, new Function2() { // from class: com.metrolist.music.ui.menu.YouTubeSongMenuKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        byte b5 = b4;
                        Unit unit = Unit.INSTANCE;
                        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                        SongItem songItem2 = songItem;
                        switch (b5) {
                            case 0:
                                Composer composer2 = (Composer) obj2;
                                int iIntValue = ((Integer) obj3).intValue();
                                GapComposer gapComposer4 = (GapComposer) composer2;
                                if (!gapComposer4.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                                    gapComposer4.skipToGroupEnd();
                                } else {
                                    TextKt.m352TextNvy7gAk(songItem2.title, ImageKt.m41basicMarquee1Mj1MLw$default(companion, 63), 0L, 0L, null, null, null, 0L, null, 0L, 2, false, 1, 0, null, gapComposer4, 48, 24960, 241660);
                                }
                                break;
                            default:
                                Composer composer3 = (Composer) obj2;
                                int iIntValue2 = ((Integer) obj3).intValue();
                                GapComposer gapComposer5 = (GapComposer) composer3;
                                if (!gapComposer5.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                                    gapComposer5.skipToGroupEnd();
                                } else {
                                    BiasAlignment biasAlignment = Alignment.Companion.Center;
                                    SpringSpec springSpec = DimensionsKt.NavigationBarAnimationSpec;
                                    Modifier modifierClip = ClipKt.clip(SizeKt.m151size3ABfNKs(companion, 48.0f), RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(10.0f));
                                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, false);
                                    int iHashCode = Long.hashCode(gapComposer5.compositeKeyHashCode);
                                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer5.currentCompositionLocalScope();
                                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer5, modifierClip);
                                    ComposeUiNode.Companion.getClass();
                                    gapComposer5.startReusableNode();
                                    if (gapComposer5.inserting) {
                                        gapComposer5.createNode(LayoutNode.Constructor);
                                    } else {
                                        gapComposer5.useNode();
                                    }
                                    Stack.m390setimpl(gapComposer5, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                                    Stack.m390setimpl(gapComposer5, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                                    Stack.m390setimpl(gapComposer5, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
                                    Stack.m389reconcileimpl(gapComposer5);
                                    Stack.m390setimpl(gapComposer5, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                                    AsyncImageKt.m849AsyncImage10Xjiaw(YouTubeUtilsKt.resize(songItem2.thumbnail, 200, 200), ClipKt.clip(SizeKt.fillMaxWidth(companion, 1.0f), RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(10.0f)), null, gapComposer5, 48, 2040);
                                    gapComposer5.end(true);
                                }
                                break;
                        }
                        return unit;
                    }
                }, gapComposer3), gapComposer3, 200064, 1747);
                CardKt.m261HorizontalDivider9IZ8Weo(null, CropImageView.DEFAULT_ASPECT_RATIO, 0L, gapComposer3, 0, 7);
                OffsetKt.Spacer(gapComposer3, SizeKt.m145height3ABfNKs(Modifier.Companion.$$INSTANCE, 12.0f));
                BottomSheetPageState bottomSheetPageState = (BottomSheetPageState) gapComposer3.consume(BottomSheetPageKt.LocalBottomSheetPageState);
                int i7 = ((Configuration) gapComposer3.consume(AndroidCompositionLocals_androidKt.LocalConfiguration)).orientation;
                boolean z = (listenTogetherManager == null || !listenTogetherManager.client.isInRoom() || listenTogetherManager.isHost()) ? false : true;
                WeakHashMap weakHashMap = WindowInsetsHolder.viewMap;
                PaddingValuesImpl paddingValuesImpl = new PaddingValuesImpl(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, OffsetKt.asPaddingValues(OffsetKt.current(gapComposer3).systemBars, gapComposer3).mo122calculateBottomPaddingD9Ej5fM() + 8.0f + CropImageView.DEFAULT_ASPECT_RATIO);
                boolean zChanged4 = gapComposer3.changed(z) | gapComposer3.changedInstance(playerConnection) | gapComposer3.changedInstance(songItem) | ((i6 & 112) == 32) | gapComposer3.changed(mutableState) | gapComposer3.changedInstance(context) | gapComposer3.changedInstance(listenTogetherManager) | gapComposer3.changedInstance(list4) | gapComposer3.changedInstance(musicDatabase) | gapComposer3.changed(mutableStateCollectAsStateWithLifecycle) | gapComposer3.changedInstance(syncUtils) | gapComposer3.changedInstance(coroutineScope) | ((i6 & 896) == 256) | gapComposer3.changed(mutableStateCollectAsStateWithLifecycle3) | gapComposer3.changed(mutableStateCollectAsStateWithLifecycle2) | gapComposer3.changedInstance(downloadUtil4) | gapComposer3.changedInstance(map) | gapComposer3.changedInstance(navHostController3) | gapComposer3.changed(mutableState3) | gapComposer3.changed(bottomSheetPageState);
                Object objRememberedValue11 = gapComposer3.rememberedValue();
                if (zChanged4 || objRememberedValue11 == neverEqualPolicy) {
                    objRememberedValue11 = new YouTubeSongMenuKt$$ExternalSyntheticLambda2(z, playerConnection, songItem, function0, mutableState, context, listenTogetherManager, list4, musicDatabase, mutableStateCollectAsStateWithLifecycle, syncUtils, function8, coroutineScope, mutableStateCollectAsStateWithLifecycle3, downloadUtil4, mutableStateCollectAsStateWithLifecycle2, navHostController3, mutableState3, bottomSheetPageState, map);
                    function8 = function8;
                    GapComposer gapComposer4 = gapComposer3;
                    gapComposer4.updateRememberedValue(objRememberedValue11);
                    gapComposer2 = gapComposer4;
                } else {
                    gapComposer2 = gapComposer3;
                }
                IntMath.LazyColumn(null, null, paddingValuesImpl, null, null, null, false, null, (Function1) objRememberedValue11, gapComposer2, 0, 507);
                function4 = function8;
                gapComposer = gapComposer2;
            }
            recomposeScopeImplEndRestartGroup.block = function5;
        }
        gapComposer3.skipToGroupEnd();
        function4 = function3;
        gapComposer = gapComposer3;
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            final byte b5 = 0;
            function5 = new Function2() { // from class: com.metrolist.music.ui.menu.YouTubeSongMenuKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    byte b6 = b5;
                    Unit unit = Unit.INSTANCE;
                    byte b7 = i;
                    switch (b6) {
                        case 0:
                            ((Integer) obj3).getClass();
                            int iUpdateChangedFlags = Stack.updateChangedFlags(b7 | 1);
                            YouTubeSongMenuKt.YouTubeSongMenu(songItem, function0, function4, (Composer) obj2, iUpdateChangedFlags, i2);
                            break;
                        default:
                            ((Integer) obj3).getClass();
                            int iUpdateChangedFlags2 = Stack.updateChangedFlags(b7 | 1);
                            YouTubeSongMenuKt.YouTubeSongMenu(songItem, function0, function4, (Composer) obj2, iUpdateChangedFlags2, i2);
                            break;
                    }
                    return unit;
                }
            };
            recomposeScopeImplEndRestartGroup.block = function5;
        }
    }
}
