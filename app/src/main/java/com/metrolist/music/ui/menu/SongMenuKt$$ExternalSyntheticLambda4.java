package com.metrolist.music.ui.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.widget.Toast;
import androidx.activity.compose.BackHandlerKt$BackHandler$lambda$4$0$$inlined$onDispose$1;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.foundation.lazy.LazyListIntervalContent;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.AndroidUriHandler;
import androidx.compose.ui.platform.UriHandler;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.window.AndroidPopup_androidKt$SimpleStack$1$1;
import androidx.lifecycle.LifecycleOwner;
import androidx.media3.exoplayer.ExoPlayerImpl;
import androidx.navigation.internal.NavControllerImpl$$ExternalSyntheticLambda3;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.math.IntMath;
import com.metrolist.innertube.models.ArtistItem;
import com.metrolist.innertube.models.PlaylistItem;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.models.YTItem;
import com.metrolist.innertube.pages.HomePage;
import com.metrolist.music.db.DatabaseDao;
import com.metrolist.music.db.DatabaseDao$$ExternalSyntheticLambda0;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Artist;
import com.metrolist.music.db.entities.ArtistEntity;
import com.metrolist.music.db.entities.LyricsEntity;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.db.entities.PlaylistEntity;
import com.metrolist.music.db.entities.PlaylistSong;
import com.metrolist.music.db.entities.PlaylistSongMap;
import com.metrolist.music.db.entities.PodcastEntity;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.db.entities.SongEntity;
import com.metrolist.music.lyrics.LyricsWithProvider;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.models.SimilarRecommendation;
import com.metrolist.music.playback.CastConnectionHandler;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda21;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda4;
import com.metrolist.music.ui.screens.HomeScreenKt$HomeScreen$lambda$52$0$2$0$3$0$0$$inlined$items$default$4;
import com.metrolist.music.ui.screens.StatsScreenKt$StatsScreen$6$1$1$10$2$1$1;
import com.metrolist.music.ui.screens.search.OnlineSearchScreenKt$OnlineSearchScreen$3$1$7$2$1;
import com.metrolist.music.ui.screens.settings.AboutScreenKt$DevBannerVideo$lambda$1$0$$inlined$onDispose$1;
import com.metrolist.music.ui.screens.settings.AlarmSettingsKt$AlarmEditorDialog$lambda$27$0$0$$inlined$items$default$3;
import com.metrolist.music.ui.screens.settings.integrations.LastFMSettingsKt;
import com.metrolist.music.utils.ArtistNameAliases;
import com.metrolist.music.utils.SyncUtils;
import com.metrolist.music.viewmodels.BackupRestoreViewModel;
import com.metrolist.music.viewmodels.LibraryPodcastsViewModel;
import com.yalantis.ucrop.R;
import dagger.hilt.EntryPoints;
import io.ktor.http.MimesKt$$ExternalSyntheticLambda0;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import kotlin.Pair;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.math.MathKt;
import kotlin.text.CharsKt;
import kotlin.text.HexFormatKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import kotlinx.serialization.internal.HashMapSerializer;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SongMenuKt$$ExternalSyntheticLambda4 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda4(Song song, String str) {
        this.$r8$classId = (byte) 9;
        this.f$1 = str;
        this.f$0 = song;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v0, types: [kotlin.coroutines.Continuation] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v13 */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        byte b2 = 14;
        byte b3 = 3;
        byte b4 = 10;
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        ?? r8 = 0;
        Object failure = null;
        final byte b5 = 1;
        Unit unit = Unit.INSTANCE;
        Object obj2 = this.f$1;
        Object obj3 = this.f$0;
        switch (b) {
            case 0:
                LazyListIntervalContent lazyListIntervalContent = (LazyListIntervalContent) obj;
                lazyListIntervalContent.getClass();
                LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, new ComposableLambdaImpl(true, 811390799, new QueueKt$$ExternalSyntheticLambda21((MutableState) obj2, (byte) 12)), 3);
                List listListOf = CollectionsKt__IterablesKt.listOf((Song) obj3);
                lazyListIntervalContent.items(listListOf.size(), null, new SongMenuKt$SongMenu$lambda$33$0$$inlined$items$default$3(listListOf, (byte) 0), new ComposableLambdaImpl(true, 802480018, new SongMenuKt$SongMenu$lambda$33$0$$inlined$items$default$4(z ? 1 : 0, listListOf)));
                return unit;
            case 1:
                MusicDatabase musicDatabase = (MusicDatabase) obj;
                musicDatabase.getClass();
                musicDatabase.$$delegate_0.upsert(SongEntity.copy$default((SongEntity) obj3, null, 0, null, null, null, false, null, null, null, null, null, 0, ((Boolean) ((MutableState) obj2).getValue()).booleanValue(), false, false, null, 133693439));
                return unit;
            case 2:
                PlayerConnection playerConnection = (PlayerConnection) obj3;
                Float f = (Float) obj;
                f.getClass();
                if (!((Boolean) ((MutableState) obj2).getValue()).booleanValue()) {
                    ((StateFlowImpl) playerConnection.service.getPlayerVolume()).updateState(null, f);
                }
                return unit;
            case 3:
                ((ParcelableSnapshotMutableIntState) obj2).setIntValue(((Integer) obj).intValue());
                ((Function0) obj3).invoke();
                return unit;
            case 4:
                MediaMetadata mediaMetadata = (MediaMetadata) obj3;
                MusicDatabase musicDatabase2 = (MusicDatabase) obj;
                if (((Song) ((MutableState) obj2).getValue()) == null) {
                    musicDatabase2.insert(mediaMetadata, new DatabaseDao$$ExternalSyntheticLambda0(z2 ? 1 : 0));
                }
                return unit;
            case 5:
                Song song = (Song) ((MutableState) obj2).getValue();
                song.getClass();
                ((MusicDatabase) obj).$$delegate_0.update(song, HexFormatKt.toMediaMetadata((SongItem) obj3), true, true);
                return unit;
            case 6:
                Ref$IntRef ref$IntRef = (Ref$IntRef) obj2;
                MusicDatabase musicDatabase3 = (MusicDatabase) obj;
                musicDatabase3.getClass();
                for (PlaylistSongMap playlistSongMap : (List) obj3) {
                    musicDatabase3.move(playlistSongMap.position - ref$IntRef.element, Integer.MAX_VALUE, playlistSongMap.playlistId);
                    musicDatabase3.$$delegate_0.delete(PlaylistSongMap.copy$default(playlistSongMap, Integer.MAX_VALUE, null, 23));
                    ref$IntRef.element++;
                }
                return unit;
            case 7:
                List list = (List) obj3;
                MusicDatabase musicDatabase4 = (MusicDatabase) obj;
                musicDatabase4.getClass();
                DatabaseDao databaseDao = musicDatabase4.$$delegate_0;
                if (((Boolean) ((MutableState) obj2).getValue()).booleanValue()) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        databaseDao.update(((MediaMetadata) it.next()).toSongEntity().toggleLike(true));
                    }
                } else {
                    ArrayList arrayList = new ArrayList();
                    for (Object obj4 : list) {
                        ((MediaMetadata) obj4).getClass();
                        arrayList.add(obj4);
                    }
                    int size = arrayList.size();
                    while (i < size) {
                        Object obj5 = arrayList.get(i);
                        i++;
                        databaseDao.update(((MediaMetadata) obj5).toSongEntity().toggleLike(true));
                    }
                }
                return unit;
            case 8:
                ((MusicDatabase) obj).$$delegate_0.update((Song) obj3, HexFormatKt.toMediaMetadata((SongItem) obj2), true, true);
                return unit;
            case 9:
                String str = (String) obj2;
                Song song2 = (Song) obj3;
                MusicDatabase musicDatabase5 = (MusicDatabase) obj;
                SongEntity songEntity = song2.song;
                String str2 = songEntity.albumName;
                if (str2 == null) {
                    str2 = "Unknown Podcast";
                }
                ArtistEntity artistEntity = (ArtistEntity) CollectionsKt.firstOrNull(song2.artists);
                PodcastEntity podcastEntity = new PodcastEntity(str, str2, artistEntity != null ? artistEntity.name : 0, songEntity.thumbnailUrl, null, null, 496).toggleBookmark();
                musicDatabase5.getClass();
                musicDatabase5.$$delegate_0.insert(podcastEntity);
                return unit;
            case 10:
                ArtistItem artistItem = (ArtistItem) obj3;
                MusicDatabase musicDatabase6 = (MusicDatabase) obj;
                musicDatabase6.getClass();
                DatabaseDao databaseDao2 = musicDatabase6.$$delegate_0;
                Artist artist = (Artist) ((State) obj2).getValue();
                if (artist != null) {
                    databaseDao2.update(artist.artist.toggleLike());
                } else {
                    String str3 = artistItem.id;
                    ArtistNameAliases artistNameAliases = ArtistNameAliases.INSTANCE;
                    databaseDao2.insert(new ArtistEntity(str3, ArtistNameAliases.resolve(str3, artistItem.title), artistItem.thumbnail, artistItem.channelId, null, false, null, 496).toggleLike());
                }
                return unit;
            case 11:
                PlaylistItem playlistItem = (PlaylistItem) obj3;
                MusicDatabase musicDatabase7 = (MusicDatabase) obj;
                musicDatabase7.getClass();
                Playlist playlist = (Playlist) ((State) obj2).getValue();
                playlist.getClass();
                PlaylistEntity playlistEntity = playlist.playlist;
                playlistItem.getClass();
                DatabaseDao databaseDao3 = musicDatabase7.$$delegate_0;
                databaseDao3.update(playlistEntity, playlistItem);
                databaseDao3.update(playlistEntity.toggleLike());
                return unit;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                SongItem songItem = (SongItem) obj3;
                State state = (State) obj2;
                MusicDatabase musicDatabase8 = (MusicDatabase) obj;
                musicDatabase8.getClass();
                DatabaseDao databaseDao4 = musicDatabase8.$$delegate_0;
                if (((Song) state.getValue()) != null) {
                    Song song3 = (Song) state.getValue();
                    song3.getClass();
                    databaseDao4.update(SongEntity.copy$default(song3.song, null, 0, null, null, null, false, null, LocalDateTime.now(), null, null, null, 0, false, false, false, null, 134209535));
                } else {
                    databaseDao4.insert(SongEntity.copy$default(HexFormatKt.toMediaMetadata(songItem).toSongEntity(), null, 0, null, null, null, false, null, LocalDateTime.now(), null, null, null, 0, false, false, false, null, 125820927));
                }
                return unit;
            case 13:
                LyricsWithProvider lyricsWithProvider = (LyricsWithProvider) obj2;
                MusicDatabase musicDatabase9 = (MusicDatabase) obj;
                LyricsEntity lyricsEntity = new LyricsEntity((String) obj3, lyricsWithProvider.lyrics, lyricsWithProvider.provider);
                musicDatabase9.getClass();
                musicDatabase9.$$delegate_0.upsert(lyricsEntity);
                return unit;
            case 14:
                ComposableLambdaImpl composableLambdaImpl = (ComposableLambdaImpl) obj2;
                LazyListIntervalContent lazyListIntervalContent2 = (LazyListIntervalContent) obj;
                lazyListIntervalContent2.getClass();
                List list2 = ((HomePage.Section) obj3).items;
                HashSet hashSet = new HashSet();
                ArrayList arrayList2 = new ArrayList();
                for (Object obj6 : list2) {
                    if (hashSet.add(((YTItem) obj6).getId())) {
                        arrayList2.add(obj6);
                    }
                }
                lazyListIntervalContent2.items(arrayList2.size(), new StatsScreenKt$StatsScreen$6$1$1$10$2$1$1(new QueueKt$$ExternalSyntheticLambda4((byte) 21), arrayList2, (byte) 7), new AndroidPopup_androidKt$SimpleStack$1$1.AnonymousClass3(arrayList2, (byte) 14), new ComposableLambdaImpl(true, 802480018, new HomeScreenKt$HomeScreen$lambda$52$0$2$0$3$0$0$$inlined$items$default$4(arrayList2, composableLambdaImpl, b3)));
                return unit;
            case 15:
                ComposableLambdaImpl composableLambdaImpl2 = (ComposableLambdaImpl) obj2;
                LazyListIntervalContent lazyListIntervalContent3 = (LazyListIntervalContent) obj;
                lazyListIntervalContent3.getClass();
                List list3 = ((SimilarRecommendation) obj3).items;
                HashSet hashSet2 = new HashSet();
                ArrayList arrayList3 = new ArrayList();
                for (Object obj7 : list3) {
                    if (hashSet2.add(((YTItem) obj7).getId())) {
                        arrayList3.add(obj7);
                    }
                }
                lazyListIntervalContent3.items(arrayList3.size(), new StatsScreenKt$StatsScreen$6$1$1$10$2$1$1(new QueueKt$$ExternalSyntheticLambda4((byte) 26), arrayList3, b4), new AndroidPopup_androidKt$SimpleStack$1$1.AnonymousClass3(arrayList3, (byte) 17), new ComposableLambdaImpl(true, 802480018, new HomeScreenKt$HomeScreen$lambda$52$0$2$0$3$0$0$$inlined$items$default$4(arrayList3, composableLambdaImpl2, (byte) 5)));
                return unit;
            case 16:
                final List list4 = (List) obj3;
                final Function1 function1 = (Function1) obj2;
                LazyListIntervalContent lazyListIntervalContent4 = (LazyListIntervalContent) obj;
                lazyListIntervalContent4.getClass();
                int size2 = list4.size();
                SongMenuKt$SongMenu$lambda$33$0$$inlined$items$default$3 songMenuKt$SongMenu$lambda$33$0$$inlined$items$default$3 = new SongMenuKt$SongMenu$lambda$33$0$$inlined$items$default$3(list4, (byte) 29);
                final boolean z5 = z3 ? 1 : 0;
                lazyListIntervalContent4.items(size2, null, songMenuKt$SongMenu$lambda$33$0$$inlined$items$default$3, new ComposableLambdaImpl(true, 802480018, new Function4() { // from class: com.metrolist.music.ui.screens.equalizer.wizard.WizardScreenKt$ModelSelectionStep$lambda$3$2$0$$inlined$items$default$4
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj8, Object obj9, Object obj10, Object obj11) {
                        byte b6 = z5;
                        Unit unit2 = Unit.INSTANCE;
                        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                        List list5 = list4;
                        Function1 function2 = function1;
                        switch (b6) {
                            case 0:
                                LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj8;
                                int iIntValue = ((Number) obj9).intValue();
                                Composer composer = (Composer) obj10;
                                int iIntValue2 = ((Number) obj11).intValue();
                                int i2 = (iIntValue2 & 6) == 0 ? iIntValue2 | (((GapComposer) composer).changed(lazyItemScopeImpl) ? 4 : 2) : iIntValue2;
                                if ((iIntValue2 & 48) == 0) {
                                    i2 |= ((GapComposer) composer).changed(iIntValue) ? 32 : 16;
                                }
                                GapComposer gapComposer = (GapComposer) composer;
                                if (!gapComposer.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
                                    gapComposer.skipToGroupEnd();
                                } else {
                                    DeviceModel deviceModel = (DeviceModel) list5.get(iIntValue);
                                    gapComposer.startReplaceGroup(1717712841);
                                    boolean zChanged = gapComposer.changed(function2) | gapComposer.changedInstance(deviceModel);
                                    Object objRememberedValue = gapComposer.rememberedValue();
                                    if (zChanged || objRememberedValue == neverEqualPolicy) {
                                        objRememberedValue = new Http2Connection.ReaderRunnable(function2, deviceModel, (byte) 14);
                                        gapComposer.updateRememberedValue(objRememberedValue);
                                    }
                                    WizardScreenKt.ModelItem(deviceModel, (Function0) objRememberedValue, gapComposer, 0);
                                    gapComposer.end(false);
                                }
                                break;
                            default:
                                LazyItemScopeImpl lazyItemScopeImpl2 = (LazyItemScopeImpl) obj8;
                                int iIntValue3 = ((Number) obj9).intValue();
                                Composer composer2 = (Composer) obj10;
                                int iIntValue4 = ((Number) obj11).intValue();
                                int i3 = (iIntValue4 & 6) == 0 ? iIntValue4 | (((GapComposer) composer2).changed(lazyItemScopeImpl2) ? 4 : 2) : iIntValue4;
                                if ((iIntValue4 & 48) == 0) {
                                    i3 |= ((GapComposer) composer2).changed(iIntValue3) ? 32 : 16;
                                }
                                GapComposer gapComposer2 = (GapComposer) composer2;
                                if (!gapComposer2.shouldExecute(i3 & 1, (i3 & 147) != 146)) {
                                    gapComposer2.skipToGroupEnd();
                                } else {
                                    String str4 = (String) list5.get(iIntValue3);
                                    gapComposer2.startReplaceGroup(-1512563052);
                                    BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
                                    Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                                    Modifier modifierClip = ClipKt.clip(SizeKt.fillMaxWidth(companion, 1.0f), RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(12.0f));
                                    StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                                    Modifier modifierM135padding3ABfNKs = OffsetKt.m135padding3ABfNKs(ImageKt.m39backgroundbw27NRU(modifierClip, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).colorScheme.surfaceVariant, ColorKt.RectangleShape), 12.0f);
                                    RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(OffsetKt.SpaceBetween, vertical, gapComposer2, 54);
                                    int iHashCode = Long.hashCode(gapComposer2.compositeKeyHashCode);
                                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
                                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer2, modifierM135padding3ABfNKs);
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
                                    Stack.m390setimpl(gapComposer2, rowMeasurePolicy, updater$$ExternalSyntheticLambda0);
                                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                                    Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda1);
                                    Integer numValueOf = Integer.valueOf(iHashCode);
                                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetCompositeKeyHash;
                                    Stack.m390setimpl(gapComposer2, numValueOf, updater$$ExternalSyntheticLambda2);
                                    Stack.m389reconcileimpl(gapComposer2);
                                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetModifier;
                                    Stack.m390setimpl(gapComposer2, modifierMaterializeModifier, updater$$ExternalSyntheticLambda3);
                                    LayoutWeightElement layoutWeightElement = new LayoutWeightElement(1.0f, true);
                                    RowMeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(OffsetKt.Start, vertical, gapComposer2, 48);
                                    int iHashCode2 = Long.hashCode(gapComposer2.compositeKeyHashCode);
                                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer2.currentCompositionLocalScope();
                                    Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer2, layoutWeightElement);
                                    gapComposer2.startReusableNode();
                                    if (gapComposer2.inserting) {
                                        gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
                                    } else {
                                        gapComposer2.useNode();
                                    }
                                    Stack.m390setimpl(gapComposer2, rowMeasurePolicy2, updater$$ExternalSyntheticLambda0);
                                    Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
                                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer2, updater$$ExternalSyntheticLambda2, gapComposer2);
                                    Stack.m390setimpl(gapComposer2, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
                                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.person, 0, gapComposer2), (String) null, SizeKt.m151size3ABfNKs(companion, 20.0f), ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).colorScheme.onSurfaceVariant, gapComposer2, 440, 0);
                                    OffsetKt.Spacer(gapComposer2, SizeKt.m155width3ABfNKs(companion, 8.0f));
                                    TextKt.m352TextNvy7gAk(str4, null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).typography.bodyMedium, gapComposer2, 0, 0, 131070);
                                    gapComposer2.end(true);
                                    boolean zChanged2 = gapComposer2.changed(function2) | gapComposer2.changed(str4);
                                    Object objRememberedValue2 = gapComposer2.rememberedValue();
                                    if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                                        objRememberedValue2 = new OnlineSearchScreenKt$OnlineSearchScreen$3$1$7$2$1((byte) 1, str4, function2);
                                        gapComposer2.updateRememberedValue(objRememberedValue2);
                                    }
                                    CardKt.TextButton((Function0) objRememberedValue2, null, false, null, null, null, LastFMSettingsKt.f605lambda$1366252646, gapComposer2, 805306368, 510);
                                    gapComposer2.end(true);
                                    gapComposer2.end(false);
                                }
                                break;
                        }
                        return unit2;
                    }
                }));
                return unit;
            case 17:
                LifecycleOwner lifecycleOwner = (LifecycleOwner) obj3;
                ((DisposableEffectScope) obj).getClass();
                NavControllerImpl$$ExternalSyntheticLambda3 navControllerImpl$$ExternalSyntheticLambda3 = new NavControllerImpl$$ExternalSyntheticLambda3(b3, (LibraryPodcastsViewModel) obj2);
                lifecycleOwner.getLifecycle().addObserver(navControllerImpl$$ExternalSyntheticLambda3);
                return new BackHandlerKt$BackHandler$lambda$4$0$$inlined$onDispose$1(lifecycleOwner, navControllerImpl$$ExternalSyntheticLambda3, (byte) 16);
            case 18:
                SnapshotStateList snapshotStateList = (SnapshotStateList) obj3;
                MutableState mutableState = (MutableState) obj2;
                ((Boolean) obj).getClass();
                if (snapshotStateList.size() == ((List) mutableState.getValue()).size()) {
                    snapshotStateList.clear();
                } else {
                    snapshotStateList.clear();
                    List list5 = (List) mutableState.getValue();
                    ArrayList arrayList4 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list5, 10));
                    Iterator it2 = list5.iterator();
                    while (it2.hasNext()) {
                        arrayList4.add(Integer.valueOf(((PlaylistSong) it2.next()).map.id));
                    }
                    snapshotStateList.addAll(arrayList4);
                }
                return unit;
            case 19:
                MusicDatabase musicDatabase10 = (MusicDatabase) obj;
                musicDatabase10.getClass();
                musicDatabase10.$$delegate_0.update(PlaylistEntity.copy$default((PlaylistEntity) obj3, (String) obj2, null, LocalDateTime.now(), false, null, null, null, null, null, null, false, 16365));
                return unit;
            case 20:
                MusicDatabase musicDatabase11 = (MusicDatabase) obj;
                PlaylistEntity playlistEntityCopy$default = PlaylistEntity.copy$default(((Playlist) obj3).playlist, null, null, null, false, null, null, null, ((Uri) obj2).toString(), null, null, false, 15871);
                musicDatabase11.getClass();
                musicDatabase11.$$delegate_0.update(playlistEntityCopy$default);
                return unit;
            case 21:
                SnapshotStateList snapshotStateList2 = (SnapshotStateList) obj3;
                List list6 = (List) obj2;
                ((Boolean) obj).booleanValue();
                if (snapshotStateList2.size() == list6.size()) {
                    snapshotStateList2.clear();
                } else {
                    snapshotStateList2.clear();
                    ArrayList arrayList5 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list6, 10));
                    Iterator it3 = list6.iterator();
                    while (it3.hasNext()) {
                        arrayList5.add(((SongItem) ((Pair) it3.next()).second).id);
                    }
                    snapshotStateList2.addAll(arrayList5);
                }
                return unit;
            case 22:
                MusicDatabase musicDatabase12 = (MusicDatabase) obj;
                musicDatabase12.getClass();
                PlaylistEntity playlistEntity2 = ((Playlist) obj3).playlist;
                DatabaseDao databaseDao5 = musicDatabase12.$$delegate_0;
                databaseDao5.update(playlistEntity2, (PlaylistItem) obj2);
                databaseDao5.update(playlistEntity2.toggleLike());
                return unit;
            case 23:
                LifecycleOwner lifecycleOwner2 = (LifecycleOwner) obj3;
                ExoPlayerImpl exoPlayerImpl = (ExoPlayerImpl) obj2;
                ((DisposableEffectScope) obj).getClass();
                NavControllerImpl$$ExternalSyntheticLambda3 navControllerImpl$$ExternalSyntheticLambda4 = new NavControllerImpl$$ExternalSyntheticLambda3((byte) 4, exoPlayerImpl);
                lifecycleOwner2.getLifecycle().addObserver(navControllerImpl$$ExternalSyntheticLambda4);
                return new AboutScreenKt$DevBannerVideo$lambda$1$0$$inlined$onDispose$1(lifecycleOwner2, navControllerImpl$$ExternalSyntheticLambda4, exoPlayerImpl, z4 ? 1 : 0);
            case 24:
                ((MimesKt$$ExternalSyntheticLambda0) obj2).invoke(Integer.valueOf(((Number) ((List) obj3).get(MathKt.roundToInt(((Float) obj).floatValue()))).intValue()));
                return unit;
            case 25:
                Context context = (Context) obj2;
                Boolean bool = (Boolean) obj;
                boolean zBooleanValue = bool.booleanValue();
                ((Function1) obj3).invoke(bool);
                context.getClass();
                PackageManager packageManager = context.getPackageManager();
                ComponentName componentName = new ComponentName(context, "com.metrolist.music.MainActivityAlias");
                ComponentName componentName2 = new ComponentName(context, "com.metrolist.music.MainActivityStatic");
                packageManager.setComponentEnabledSetting(componentName, zBooleanValue ? 1 : 2, 1);
                packageManager.setComponentEnabledSetting(componentName2, zBooleanValue ? 2 : 1, 1);
                return unit;
            case 26:
                BackupRestoreViewModel backupRestoreViewModel = (BackupRestoreViewModel) obj3;
                Context context2 = (Context) obj2;
                Uri uri = (Uri) obj;
                if (uri != null) {
                    backupRestoreViewModel.getClass();
                    context2.getClass();
                    try {
                        OutputStream outputStreamOpenOutputStream = context2.getApplicationContext().getContentResolver().openOutputStream(uri);
                        if (outputStreamOpenOutputStream != null) {
                            try {
                                ZipOutputStream zipOutputStream = new ZipOutputStream(outputStreamOpenOutputStream instanceof BufferedOutputStream ? (BufferedOutputStream) outputStreamOpenOutputStream : new BufferedOutputStream(outputStreamOpenOutputStream, 8192));
                                try {
                                    File filesDir = context2.getFilesDir();
                                    filesDir.getClass();
                                    BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(new File(new File(filesDir, "datastore"), "settings.preferences_pb")), 8192);
                                    try {
                                        zipOutputStream.putNextEntry(new ZipEntry("settings.preferences_pb"));
                                        EntryPoints.copyTo(bufferedInputStream, zipOutputStream);
                                        bufferedInputStream.close();
                                        zipOutputStream.putNextEntry(new ZipEntry("artist_name_aliases.json"));
                                        ArtistNameAliases artistNameAliases2 = ArtistNameAliases.INSTANCE;
                                        Json.Default r3 = Json.Default;
                                        Object value = ArtistNameAliases._aliases.getValue();
                                        r3.getClass();
                                        StringSerializer stringSerializer = StringSerializer.INSTANCE;
                                        zipOutputStream.write(StringsKt__StringsJVMKt.encodeToByteArray(r3.encodeToString(new HashMapSerializer(stringSerializer, stringSerializer, (byte) 1), value)));
                                        DefaultScheduler defaultScheduler = Dispatchers.Default;
                                        AwaitKt.runBlockingK(DefaultIoScheduler.INSTANCE, new SyncUtils.AnonymousClass3(backupRestoreViewModel, r8, b2));
                                        String path = backupRestoreViewModel.database.delegate.getOpenHelper().getWritableDatabase().getPath();
                                        if (path != null) {
                                            FileInputStream fileInputStream = new FileInputStream(path);
                                            try {
                                                zipOutputStream.putNextEntry(new ZipEntry("song.db"));
                                                EntryPoints.copyTo(fileInputStream, zipOutputStream);
                                                fileInputStream.close();
                                                File file = new File(path.concat("-wal"));
                                                if (file.exists()) {
                                                    FileInputStream fileInputStream2 = new FileInputStream(file);
                                                    try {
                                                        zipOutputStream.putNextEntry(new ZipEntry("song.db-wal"));
                                                        EntryPoints.copyTo(fileInputStream2, zipOutputStream);
                                                        fileInputStream2.close();
                                                    } catch (Throwable th) {
                                                        try {
                                                            throw th;
                                                        } catch (Throwable th2) {
                                                            CharsKt.closeFinally(fileInputStream2, th);
                                                            throw th2;
                                                        }
                                                    }
                                                }
                                                File file2 = new File(path.concat("-shm"));
                                                if (file2.exists()) {
                                                    FileInputStream fileInputStream3 = new FileInputStream(file2);
                                                    try {
                                                        zipOutputStream.putNextEntry(new ZipEntry("song.db-shm"));
                                                        EntryPoints.copyTo(fileInputStream3, zipOutputStream);
                                                        fileInputStream3.close();
                                                    } catch (Throwable th3) {
                                                        try {
                                                            throw th3;
                                                        } catch (Throwable th4) {
                                                            CharsKt.closeFinally(fileInputStream3, th3);
                                                            throw th4;
                                                        }
                                                    }
                                                }
                                            } catch (Throwable th5) {
                                                try {
                                                    throw th5;
                                                } catch (Throwable th6) {
                                                    CharsKt.closeFinally(fileInputStream, th5);
                                                    throw th6;
                                                }
                                            }
                                        }
                                        zipOutputStream.close();
                                        outputStreamOpenOutputStream.close();
                                        failure = unit;
                                    } catch (Throwable th7) {
                                        try {
                                            throw th7;
                                        } catch (Throwable th8) {
                                            CharsKt.closeFinally(bufferedInputStream, th7);
                                            throw th8;
                                        }
                                    }
                                } catch (Throwable th9) {
                                    try {
                                        throw th9;
                                    } catch (Throwable th10) {
                                        CharsKt.closeFinally(zipOutputStream, th9);
                                        throw th10;
                                    }
                                }
                            } catch (Throwable th11) {
                                try {
                                    throw th11;
                                } catch (Throwable th12) {
                                    CharsKt.closeFinally(outputStreamOpenOutputStream, th11);
                                    throw th12;
                                }
                            }
                        }
                    } catch (Throwable th13) {
                        failure = new Result.Failure(th13);
                    }
                    if (!(failure instanceof Result.Failure)) {
                        Toast.makeText(context2, R.string.backup_create_success, 0).show();
                    }
                    Throwable thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(failure);
                    if (thM1866exceptionOrNullimpl != null) {
                        thM1866exceptionOrNullimpl.printStackTrace();
                        Toast.makeText(context2, R.string.backup_create_failed, 0).show();
                    }
                }
                return unit;
            case 27:
                UriHandler uriHandler = (UriHandler) obj2;
                int iIntValue = ((Integer) obj).intValue();
                AnnotatedString.Range range = (AnnotatedString.Range) CollectionsKt.firstOrNull(((AnnotatedString) obj3).getStringAnnotations(iIntValue, iIntValue, "URL"));
                if (range != null) {
                    ((AndroidUriHandler) uriHandler).openUri((String) range.item);
                }
                return unit;
            case 28:
                Boolean bool2 = (Boolean) obj;
                bool2.getClass();
                ((MimesKt$$ExternalSyntheticLambda0) obj3).invoke(bool2);
                ((MimesKt$$ExternalSyntheticLambda0) obj2).invoke(bool2);
                return unit;
            default:
                final Function1 function2 = (Function1) obj2;
                LazyListIntervalContent lazyListIntervalContent5 = (LazyListIntervalContent) obj;
                lazyListIntervalContent5.getClass();
                final List list7 = CollectionsKt.toList((Set) obj3);
                lazyListIntervalContent5.items(list7.size(), null, new AlarmSettingsKt$AlarmEditorDialog$lambda$27$0$0$$inlined$items$default$3(list7, (byte) 16), new ComposableLambdaImpl(true, 802480018, new Function4() { // from class: com.metrolist.music.ui.screens.equalizer.wizard.WizardScreenKt$ModelSelectionStep$lambda$3$2$0$$inlined$items$default$4
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj8, Object obj9, Object obj10, Object obj11) {
                        byte b6 = b5;
                        Unit unit2 = Unit.INSTANCE;
                        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                        List list8 = list7;
                        Function1 function3 = function2;
                        switch (b6) {
                            case 0:
                                LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj8;
                                int iIntValue2 = ((Number) obj9).intValue();
                                Composer composer = (Composer) obj10;
                                int iIntValue3 = ((Number) obj11).intValue();
                                int i2 = (iIntValue3 & 6) == 0 ? iIntValue3 | (((GapComposer) composer).changed(lazyItemScopeImpl) ? 4 : 2) : iIntValue3;
                                if ((iIntValue3 & 48) == 0) {
                                    i2 |= ((GapComposer) composer).changed(iIntValue2) ? 32 : 16;
                                }
                                GapComposer gapComposer = (GapComposer) composer;
                                if (!gapComposer.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
                                    gapComposer.skipToGroupEnd();
                                } else {
                                    DeviceModel deviceModel = (DeviceModel) list8.get(iIntValue2);
                                    gapComposer.startReplaceGroup(1717712841);
                                    boolean zChanged = gapComposer.changed(function3) | gapComposer.changedInstance(deviceModel);
                                    Object objRememberedValue = gapComposer.rememberedValue();
                                    if (zChanged || objRememberedValue == neverEqualPolicy) {
                                        objRememberedValue = new Http2Connection.ReaderRunnable(function3, deviceModel, (byte) 14);
                                        gapComposer.updateRememberedValue(objRememberedValue);
                                    }
                                    WizardScreenKt.ModelItem(deviceModel, (Function0) objRememberedValue, gapComposer, 0);
                                    gapComposer.end(false);
                                }
                                break;
                            default:
                                LazyItemScopeImpl lazyItemScopeImpl2 = (LazyItemScopeImpl) obj8;
                                int iIntValue4 = ((Number) obj9).intValue();
                                Composer composer2 = (Composer) obj10;
                                int iIntValue5 = ((Number) obj11).intValue();
                                int i3 = (iIntValue5 & 6) == 0 ? iIntValue5 | (((GapComposer) composer2).changed(lazyItemScopeImpl2) ? 4 : 2) : iIntValue5;
                                if ((iIntValue5 & 48) == 0) {
                                    i3 |= ((GapComposer) composer2).changed(iIntValue4) ? 32 : 16;
                                }
                                GapComposer gapComposer2 = (GapComposer) composer2;
                                if (!gapComposer2.shouldExecute(i3 & 1, (i3 & 147) != 146)) {
                                    gapComposer2.skipToGroupEnd();
                                } else {
                                    String str4 = (String) list8.get(iIntValue4);
                                    gapComposer2.startReplaceGroup(-1512563052);
                                    BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
                                    Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                                    Modifier modifierClip = ClipKt.clip(SizeKt.fillMaxWidth(companion, 1.0f), RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(12.0f));
                                    StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                                    Modifier modifierM135padding3ABfNKs = OffsetKt.m135padding3ABfNKs(ImageKt.m39backgroundbw27NRU(modifierClip, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).colorScheme.surfaceVariant, ColorKt.RectangleShape), 12.0f);
                                    RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(OffsetKt.SpaceBetween, vertical, gapComposer2, 54);
                                    int iHashCode = Long.hashCode(gapComposer2.compositeKeyHashCode);
                                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
                                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer2, modifierM135padding3ABfNKs);
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
                                    Stack.m390setimpl(gapComposer2, rowMeasurePolicy, updater$$ExternalSyntheticLambda0);
                                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                                    Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda1);
                                    Integer numValueOf = Integer.valueOf(iHashCode);
                                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetCompositeKeyHash;
                                    Stack.m390setimpl(gapComposer2, numValueOf, updater$$ExternalSyntheticLambda2);
                                    Stack.m389reconcileimpl(gapComposer2);
                                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetModifier;
                                    Stack.m390setimpl(gapComposer2, modifierMaterializeModifier, updater$$ExternalSyntheticLambda3);
                                    LayoutWeightElement layoutWeightElement = new LayoutWeightElement(1.0f, true);
                                    RowMeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(OffsetKt.Start, vertical, gapComposer2, 48);
                                    int iHashCode2 = Long.hashCode(gapComposer2.compositeKeyHashCode);
                                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer2.currentCompositionLocalScope();
                                    Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer2, layoutWeightElement);
                                    gapComposer2.startReusableNode();
                                    if (gapComposer2.inserting) {
                                        gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
                                    } else {
                                        gapComposer2.useNode();
                                    }
                                    Stack.m390setimpl(gapComposer2, rowMeasurePolicy2, updater$$ExternalSyntheticLambda0);
                                    Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
                                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer2, updater$$ExternalSyntheticLambda2, gapComposer2);
                                    Stack.m390setimpl(gapComposer2, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
                                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.person, 0, gapComposer2), (String) null, SizeKt.m151size3ABfNKs(companion, 20.0f), ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).colorScheme.onSurfaceVariant, gapComposer2, 440, 0);
                                    OffsetKt.Spacer(gapComposer2, SizeKt.m155width3ABfNKs(companion, 8.0f));
                                    TextKt.m352TextNvy7gAk(str4, null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).typography.bodyMedium, gapComposer2, 0, 0, 131070);
                                    gapComposer2.end(true);
                                    boolean zChanged2 = gapComposer2.changed(function3) | gapComposer2.changed(str4);
                                    Object objRememberedValue2 = gapComposer2.rememberedValue();
                                    if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                                        objRememberedValue2 = new OnlineSearchScreenKt$OnlineSearchScreen$3$1$7$2$1((byte) 1, str4, function3);
                                        gapComposer2.updateRememberedValue(objRememberedValue2);
                                    }
                                    CardKt.TextButton((Function0) objRememberedValue2, null, false, null, null, null, LastFMSettingsKt.f605lambda$1366252646, gapComposer2, 805306368, 510);
                                    gapComposer2.end(true);
                                    gapComposer2.end(false);
                                }
                                break;
                        }
                        return unit2;
                    }
                }));
                return unit;
        }
    }

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda4(CastConnectionHandler castConnectionHandler, PlayerConnection playerConnection, MutableState mutableState) {
        this.$r8$classId = (byte) 2;
        this.f$0 = playerConnection;
        this.f$1 = mutableState;
    }

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda4(Object obj, Object obj2, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = obj2;
    }
}
