package com.metrolist.music.ui.menu;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.compose.material3.SheetState;
import androidx.compose.material3.SheetValue;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.PlatformHapticFeedback;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.AnnotatedStringKt;
import androidx.compose.ui.text.StringAnnotation;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.DialogProperties;
import androidx.compose.ui.window.DialogWrapper;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.viewmodel.internal.CloseableCoroutineScope;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.media3.exoplayer.offline.DownloadService;
import androidx.navigation.NavHostController;
import androidx.navigation.compose.NavHostKt$NavHost$29$1;
import coil3.compose.AsyncImagePainter;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.innertube.models.AlbumItem;
import com.metrolist.innertube.models.ArtistItem;
import com.metrolist.innertube.models.EpisodeItem;
import com.metrolist.innertube.models.PlaylistItem;
import com.metrolist.innertube.models.PodcastItem;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.models.WatchEndpoint;
import com.metrolist.innertube.models.YTItem;
import com.metrolist.music.constants.SongFilter;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Album;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.db.entities.PlaylistSong;
import com.metrolist.music.db.entities.PlaylistSongMap;
import com.metrolist.music.db.entities.PodcastEntity;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.listentogether.ListenTogetherManager;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.playback.DownloadUtil;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.playback.alarm.MusicAlarmEntry;
import com.metrolist.music.playback.queues.ListQueue;
import com.metrolist.music.playback.queues.YouTubeQueue;
import com.metrolist.music.ui.component.BottomSheetState;
import com.metrolist.music.ui.component.ItemsKt$reset$1;
import com.metrolist.music.ui.component.LyricsBackgroundStyle;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.screens.StatsScreenKt$$ExternalSyntheticLambda7;
import com.metrolist.music.ui.screens.library.LibrarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$4;
import com.metrolist.music.ui.screens.playlist.PlaylistType;
import com.metrolist.music.ui.screens.playlist.TopPlaylistScreenKt;
import com.metrolist.music.ui.screens.search.OnlineSearchScreenKt$$ExternalSyntheticLambda12;
import com.metrolist.music.ui.screens.settings.AlarmSettingsKt$$ExternalSyntheticLambda21;
import com.metrolist.music.utils.DataStoreKt$get$2;
import com.metrolist.music.utils.SyncUtils;
import com.metrolist.music.utils.SyncUtils$createPlaylist$1;
import com.metrolist.music.viewmodels.CachePlaylistViewModel;
import com.metrolist.music.viewmodels.LocalPlaylistViewModel;
import com.yalantis.ucrop.R;
import io.ktor.http.MimesKt$$ExternalSyntheticLambda0;
import io.ktor.sse.ServerSentEventKt;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.HexFormatKt;
import kotlin.text.StringsKt;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import kotlinx.coroutines.sync.Mutex;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SongMenuKt$$ExternalSyntheticLambda40 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Object f$4;

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda40(MutableState mutableState, MutableState mutableState2, NavHostController navHostController, MusicDatabase musicDatabase, LocalPlaylistViewModel localPlaylistViewModel) {
        this.$r8$classId = (byte) 21;
        this.f$1 = musicDatabase;
        this.f$0 = localPlaylistViewModel;
        this.f$2 = navHostController;
        this.f$3 = mutableState;
        this.f$4 = mutableState2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v31, types: [kotlin.collections.EmptyList] */
    /* JADX WARN: Type inference failed for: r3v32, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v33, types: [java.util.ArrayList] */
    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        ?? arrayList;
        String str;
        String str2;
        byte b = this.$r8$classId;
        byte b2 = 3;
        int i = 0;
        Continuation continuation = null;
        Unit unit = Unit.INSTANCE;
        Object obj = this.f$4;
        Object obj2 = this.f$3;
        Object obj3 = this.f$2;
        Object obj4 = this.f$1;
        Object obj5 = this.f$0;
        switch (b) {
            case 0:
                PlaylistSong playlistSong = (PlaylistSong) obj5;
                String str3 = (String) obj3;
                Function0 function0 = (Function0) obj2;
                SyncUtils syncUtils = (SyncUtils) obj;
                String str4 = playlistSong.map.setVideoId;
                ((MusicDatabase) obj4).transaction(new MimesKt$$ExternalSyntheticLambda0((byte) 2, playlistSong));
                if (str3 != null) {
                    PlaylistSongMap playlistSongMap = playlistSong.map;
                    syncUtils.scheduleRemoveFromPlaylist(str3, playlistSongMap.songId, playlistSongMap.playlistId, new SongMenuKt$SongMenu$14$1$3$1$11$1$1$2$1(str4, null, (byte) 0));
                }
                function0.invoke();
                return unit;
            case 1:
                return new SheetState((Set) obj5, (Function0) obj2, (Function0) obj4, (SheetValue) obj3, (Function1) obj);
            case 2:
                ((DialogWrapper) obj5).updateParameters((Function0) obj2, (DialogProperties) obj4, (LayoutDirection) obj3, (Density) obj);
                return unit;
            case 3:
                Color color = (Color) ((MutableState) obj4).getValue();
                long j = color.value;
                Color color2 = (Color) ((MutableState) obj3).getValue();
                long j2 = color2.value;
                Color color3 = (Color) ((MutableState) obj2).getValue();
                long j3 = color3.value;
                ((Function4) obj5).invoke(color, color2, color3, (LyricsBackgroundStyle) ((MutableState) obj).getValue());
                return unit;
            case 4:
                DefaultScheduler defaultScheduler = Dispatchers.Default;
                AwaitKt.launch$default((CoroutineScope) obj5, DefaultIoScheduler.INSTANCE, null, new AsyncImagePainter.AnonymousClass1((MusicDatabase) obj4, (Album) obj3, (State) obj, null, (byte) 14), 2);
                ((Function0) obj2).invoke();
                return unit;
            case 5:
                Context context = (Context) obj5;
                TextFieldValue textFieldValue = (TextFieldValue) obj3;
                TextFieldValue textFieldValue2 = (TextFieldValue) obj;
                ((MutableState) obj4).setValue(Boolean.FALSE);
                ((Function0) obj2).invoke();
                try {
                    Intent intent = new Intent("android.intent.action.WEB_SEARCH");
                    intent.putExtra("query", textFieldValue.annotatedString.text + ServerSentEventKt.SPACE + textFieldValue2.annotatedString.text + " lyrics");
                    context.startActivity(intent);
                    break;
                } catch (Exception unused) {
                }
                return unit;
            case 6:
                DefaultScheduler defaultScheduler2 = Dispatchers.Default;
                AwaitKt.launch$default((CoroutineScope) obj5, DefaultIoScheduler.INSTANCE, null, new AsyncImagePainter.AnonymousClass1((MusicDatabase) obj4, (MediaMetadata) obj3, (State) obj, null, (byte) 16), 2);
                ((Function0) obj2).invoke();
                return unit;
            case 7:
                Playlist playlist = (Playlist) obj;
                ((MutableState) obj3).setValue(Boolean.FALSE);
                ((Function0) obj2).invoke();
                ((MusicDatabase) obj4).transaction(new PlaylistMenuKt$$ExternalSyntheticLambda25(playlist, (byte) 0));
                DefaultScheduler defaultScheduler3 = Dispatchers.Default;
                AwaitKt.launch$default((CoroutineScope) obj5, DefaultIoScheduler.INSTANCE, null, new SyncUtils.AnonymousClass2(playlist, null, (byte) 25), 2);
                return unit;
            case 8:
                DefaultScheduler defaultScheduler4 = Dispatchers.Default;
                AwaitKt.launch$default((CoroutineScope) obj5, DefaultIoScheduler.INSTANCE, null, new AsyncImagePainter.AnonymousClass1((MusicDatabase) obj4, (Playlist) obj3, (State) obj, null, (byte) 17), 2);
                ((Function0) obj2).invoke();
                return unit;
            case 9:
                ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = (ParcelableSnapshotMutableFloatState) obj3;
                parcelableSnapshotMutableFloatState.setFloatValue(parcelableSnapshotMutableFloatState.getFloatValue() - 360.0f);
                DefaultScheduler defaultScheduler5 = Dispatchers.Default;
                AwaitKt.launch$default((CoroutineScope) obj5, DefaultIoScheduler.INSTANCE, null, new DataStoreKt$get$2(obj2, obj4, obj, (Continuation) null, (byte) 10), 2);
                return unit;
            case 10:
                DefaultScheduler defaultScheduler6 = Dispatchers.Default;
                AwaitKt.launch$default((CoroutineScope) obj5, DefaultIoScheduler.INSTANCE, null, new AsyncImagePainter.AnonymousClass1((MusicDatabase) obj4, (Song) obj3, (State) obj, null, (byte) 18), 2);
                ((Function0) obj2).invoke();
                return unit;
            case 11:
                DefaultScheduler defaultScheduler7 = Dispatchers.Default;
                AwaitKt.launch$default((CoroutineScope) obj5, DefaultIoScheduler.INSTANCE, null, new AsyncImagePainter.AnonymousClass1((MusicDatabase) obj4, (AlbumItem) obj3, (State) obj, null, (byte) 19), 2);
                ((Function0) obj2).invoke();
                return unit;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                DefaultScheduler defaultScheduler8 = Dispatchers.Default;
                AwaitKt.launch$default((CoroutineScope) obj5, DefaultIoScheduler.INSTANCE, null, new AsyncImagePainter.AnonymousClass1((MusicDatabase) obj4, (PlaylistItem) obj3, (State) obj, null, (byte) 21), 2);
                ((Function0) obj2).invoke();
                return unit;
            case 13:
                DefaultScheduler defaultScheduler9 = Dispatchers.Default;
                AwaitKt.launch$default((CoroutineScope) obj5, DefaultIoScheduler.INSTANCE, null, new AsyncImagePainter.AnonymousClass1((MusicDatabase) obj4, (SongItem) obj3, (State) obj, null, (byte) 23), 2);
                ((Function0) obj2).invoke();
                return unit;
            case 14:
                AnnotatedString annotatedString = (AnnotatedString) obj5;
                NavHostController navHostController = (NavHostController) obj2;
                BottomSheetState bottomSheetState = (BottomSheetState) obj;
                Offset offset = (Offset) ((MutableState) obj4).getValue();
                TextLayoutResult textLayoutResult = (TextLayoutResult) ((MutableState) obj3).getValue();
                if (offset != null && textLayoutResult != null) {
                    int iM729getOffsetForPositionk4lQ0M = textLayoutResult.multiParagraph.m729getOffsetForPositionk4lQ0M(offset.packedValue);
                    List list = annotatedString.annotations;
                    if (list != null) {
                        arrayList = new ArrayList(list.size());
                        int size = list.size();
                        while (i < size) {
                            AnnotatedString.Range range = (AnnotatedString.Range) list.get(i);
                            Object obj6 = range.item;
                            int i2 = range.end;
                            int i3 = range.start;
                            if ((obj6 instanceof StringAnnotation) && AnnotatedStringKt.intersect(iM729getOffsetForPositionk4lQ0M, iM729getOffsetForPositionk4lQ0M, i3, i2)) {
                                Object obj7 = range.item;
                                obj7.getClass();
                                arrayList.add(new AnnotatedString.Range(((StringAnnotation) obj7).value, i3, i2, range.tag));
                            }
                            i++;
                        }
                    } else {
                        arrayList = EmptyList.INSTANCE;
                    }
                    AnnotatedString.Range range2 = (AnnotatedString.Range) CollectionsKt.firstOrNull((List) arrayList);
                    if (range2 != null) {
                        String str5 = (String) range2.item;
                        if (!StringsKt.isBlank(str5)) {
                            NavHostController.navigate$default(navHostController, "artist/".concat(str5));
                            bottomSheetState.collapseSoft();
                        }
                    }
                }
                return unit;
            case 15:
                MenuState menuState = (MenuState) obj5;
                menuState.show(new ComposableLambdaImpl(true, 1744016318, new QueueMenuKt$$ExternalSyntheticLambda9(obj4, obj3, obj2, (Object) menuState, obj, (byte) 8)));
                return unit;
            case 16:
                DefaultScheduler defaultScheduler10 = Dispatchers.Default;
                AwaitKt.launch$default((CoroutineScope) obj5, DefaultIoScheduler.INSTANCE, null, new SyncUtils$createPlaylist$1.AnonymousClass1(obj4, obj, obj3, (Continuation) null, (byte) 14), 2);
                ((Function0) obj2).invoke();
                return unit;
            case 17:
                DefaultScheduler defaultScheduler11 = Dispatchers.Default;
                AwaitKt.launch$default((CoroutineScope) obj5, DefaultIoScheduler.INSTANCE, null, new AsyncImagePainter.AnonymousClass1((MusicDatabase) obj4, (PodcastEntity) obj3, (State) obj, null, (byte) 25), 2);
                ((Function0) obj2).invoke();
                return unit;
            case 18:
                ManagedActivityResultLauncher managedActivityResultLauncher = (ManagedActivityResultLauncher) obj5;
                PlayerConnection playerConnection = (PlayerConnection) obj4;
                String str6 = (String) obj3;
                ArrayList arrayList2 = (ArrayList) obj2;
                if (((SongFilter) ((LibrarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$4) obj).getValue()) == SongFilter.UPLOADED) {
                    managedActivityResultLauncher.launch(new String[]{"audio/mpeg", "audio/mp4", "audio/x-m4a", "audio/flac", "audio/ogg", "audio/x-ms-wma"});
                } else {
                    List mutableList = CollectionsKt.toMutableList((Iterable) arrayList2);
                    Collections.shuffle(mutableList);
                    ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(mutableList, 10));
                    ArrayList arrayList4 = (ArrayList) mutableList;
                    int size2 = arrayList4.size();
                    while (i < size2) {
                        Object obj8 = arrayList4.get(i);
                        i++;
                        arrayList3.add(UuidKt.toMediaItem((Song) obj8));
                    }
                    playerConnection.playQueue(new ListQueue(str6, arrayList3, 0, 0L, 12, null));
                }
                return unit;
            case 19:
                MenuState menuState2 = (MenuState) obj5;
                menuState2.show(new ComposableLambdaImpl(true, 1794866378, new QueueMenuKt$$ExternalSyntheticLambda9((List) obj4, (Object) menuState2, (Function0) obj2, obj3, obj, (byte) 11)));
                return unit;
            case 20:
                MenuState menuState3 = (MenuState) obj4;
                List list2 = (List) obj3;
                Function0 function1 = (Function0) obj2;
                CachePlaylistViewModel cachePlaylistViewModel = (CachePlaylistViewModel) obj;
                ArrayList arrayList5 = new ArrayList();
                for (Object obj9 : (List) obj5) {
                    if (list2.contains(((Song) obj9).song.id)) {
                        arrayList5.add(obj9);
                    }
                }
                menuState3.show(new ComposableLambdaImpl(true, 1239243821, new SongMenuKt$$ExternalSyntheticLambda34(arrayList5, menuState3, function1, cachePlaylistViewModel, (byte) 14)));
                return unit;
            case 21:
                MutableState mutableState = (MutableState) obj;
                ((MutableState) obj2).setValue(Boolean.FALSE);
                ((MusicDatabase) obj4).query(new StatsScreenKt$$ExternalSyntheticLambda7(mutableState, (byte) 9));
                CloseableCoroutineScope viewModelScope = ViewModelKt.getViewModelScope((LocalPlaylistViewModel) obj5);
                DefaultScheduler defaultScheduler12 = Dispatchers.Default;
                AwaitKt.launch$default(viewModelScope, DefaultIoScheduler.INSTANCE, null, new ItemsKt$reset$1(mutableState, continuation, b2), 2);
                ((NavHostController) obj3).popBackStack();
                return unit;
            case 22:
                DefaultScheduler defaultScheduler13 = Dispatchers.Default;
                AwaitKt.launch$default((CoroutineScope) obj5, DefaultIoScheduler.INSTANCE, null, new NavHostKt$NavHost$29$1((SyncUtils) obj, (Playlist) obj4, (SnackbarHostState) obj2, (String) obj3, null, (byte) 11), 2);
                return unit;
            case 23:
                Function0 function2 = (Function0) obj2;
                List list3 = (List) obj5;
                Context context2 = (Context) obj3;
                DownloadUtil downloadUtil = (DownloadUtil) obj;
                int intValue = ((ParcelableSnapshotMutableIntState) obj4).getIntValue();
                if (intValue == 2) {
                    Iterator it = list3.iterator();
                    while (it.hasNext()) {
                        DownloadService.sendRemoveDownload(context2, ((PlaylistSong) it.next()).song.song.id);
                    }
                } else if (intValue != 3) {
                    Iterator it2 = list3.iterator();
                    while (it2.hasNext()) {
                        downloadUtil.download(((PlaylistSong) it2.next()).song);
                    }
                } else {
                    function2.invoke();
                }
                return unit;
            case 24:
                Function0 function3 = (Function0) obj2;
                NavHostController navHostController2 = (NavHostController) obj5;
                MutableState mutableState2 = (MutableState) obj4;
                MutableState mutableState3 = (MutableState) obj3;
                MutableState mutableState4 = (MutableState) obj;
                if (((Boolean) mutableState2.getValue()).booleanValue()) {
                    mutableState2.setValue(Boolean.FALSE);
                    mutableState3.setValue(new TextFieldValue(7, 0L, (String) null));
                } else if (TopPlaylistScreenKt.OnlinePlaylistScreen$lambda$20(mutableState4)) {
                    function3.invoke();
                } else {
                    navHostController2.navigateUp();
                }
                return unit;
            case 25:
                Playlist playlist2 = (Playlist) obj5;
                MusicDatabase musicDatabase = (MusicDatabase) obj4;
                CoroutineScope coroutineScope = (CoroutineScope) obj3;
                PlaylistItem playlistItem = (PlaylistItem) obj2;
                List list4 = (List) obj;
                if (playlist2 != null) {
                    musicDatabase.transaction(new SongMenuKt$$ExternalSyntheticLambda4((Object) playlist2, (Object) playlistItem, (byte) 22));
                } else {
                    DefaultScheduler defaultScheduler14 = Dispatchers.Default;
                    AwaitKt.launch$default(coroutineScope, DefaultIoScheduler.INSTANCE, null, new DataStoreKt$get$2((Object) playlistItem, (Object) list4, (Object) musicDatabase, (Continuation) null, (byte) 16), 2);
                }
                return unit;
            case 26:
                YTItem yTItem = (YTItem) obj5;
                PlayerConnection playerConnection2 = (PlayerConnection) obj4;
                NavHostController navHostController3 = (NavHostController) obj3;
                State state = (State) obj2;
                MutableState mutableState5 = (MutableState) obj;
                if (yTItem instanceof SongItem) {
                    SongItem songItem = (SongItem) yTItem;
                    String str7 = songItem.id;
                    MediaMetadata mediaMetadata = (MediaMetadata) state.getValue();
                    if (Intrinsics.areEqual(str7, mediaMetadata != null ? mediaMetadata.id : null)) {
                        playerConnection2.togglePlayPause();
                    } else {
                        playerConnection2.playQueue(((Boolean) mutableState5.getValue()).booleanValue() ? new YouTubeQueue(new WatchEndpoint(62, str7, null, null), HexFormatKt.toMediaMetadata(songItem)) : new ListQueue(songItem.title, CollectionsKt__IterablesKt.listOf(UuidKt.toMediaItem(HexFormatKt.toMediaMetadata(songItem))), 0, 0L, 12, null));
                    }
                } else {
                    if (yTItem instanceof AlbumItem) {
                        str = ((AlbumItem) yTItem).id;
                        str2 = "album/";
                    } else if (yTItem instanceof ArtistItem) {
                        Format$$ExternalSyntheticOutline0.m("artist/", ((ArtistItem) yTItem).id, navHostController3);
                    } else if (yTItem instanceof PlaylistItem) {
                        str = ((PlaylistItem) yTItem).id;
                        str2 = "online_playlist/";
                    } else if (yTItem instanceof PodcastItem) {
                        str = ((PodcastItem) yTItem).id;
                        str2 = "online_podcast/";
                    } else {
                        if (!(yTItem instanceof EpisodeItem)) {
                            PathKt$$ExternalSyntheticBUOutline0.m$1();
                            return null;
                        }
                        EpisodeItem episodeItem = (EpisodeItem) yTItem;
                        String str8 = episodeItem.id;
                        MediaMetadata mediaMetadata2 = (MediaMetadata) state.getValue();
                        if (Intrinsics.areEqual(str8, mediaMetadata2 != null ? mediaMetadata2.id : null)) {
                            playerConnection2.togglePlayPause();
                        } else {
                            playerConnection2.playQueue(new YouTubeQueue(new WatchEndpoint(62, str8, null, null), HexFormatKt.toMediaMetadata(episodeItem)));
                        }
                    }
                    Format$$ExternalSyntheticOutline0.m(str2, str, navHostController3);
                }
                return unit;
            case 27:
                MenuState menuState4 = (MenuState) obj4;
                ((PlatformHapticFeedback) ((HapticFeedback) obj5)).m578performHapticFeedbackCdsT49E(0);
                menuState4.show(new ComposableLambdaImpl(true, 1315638271, new OnlineSearchScreenKt$$ExternalSyntheticLambda12((YTItem) obj3, menuState4, (Function0) obj2, (CoroutineScope) obj, (byte) 1)));
                return unit;
            case 28:
                AwaitKt.launch$default((CoroutineScope) obj4, null, null, new DownloadUtil.AnonymousClass1((Mutex) obj3, new AlarmSettingsKt$$ExternalSyntheticLambda21((MusicAlarmEntry) obj5, (byte) 1), (Context) obj2, (MutableState) obj, null), 3);
                return unit;
            default:
                ListenTogetherManager listenTogetherManager = (ListenTogetherManager) obj5;
                Context context3 = (Context) obj4;
                MutableState mutableState6 = (MutableState) obj2;
                MutableState mutableState7 = (MutableState) obj;
                String string = StringsKt.trim((String) ((MutableState) obj3).getValue()).toString();
                if (StringsKt.isBlank(string)) {
                    Toast.makeText(context3, R.string.error_username_empty, 0).show();
                } else {
                    mutableState6.setValue(string);
                    listenTogetherManager.createRoom(string);
                    mutableState7.setValue(Boolean.FALSE);
                }
                return unit;
        }
    }

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda40(MenuState menuState, List list, Function0 function0, PlaylistType playlistType, List list2) {
        this.$r8$classId = (byte) 19;
        this.f$0 = menuState;
        this.f$1 = list;
        this.f$3 = function0;
        this.f$2 = playlistType;
        this.f$4 = list2;
    }

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda40(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
        this.f$3 = obj4;
        this.f$4 = obj5;
    }

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda40(Object obj, Function0 function0, Object obj2, Object obj3, Object obj4, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$3 = function0;
        this.f$1 = obj2;
        this.f$2 = obj3;
        this.f$4 = obj4;
    }

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda40(Function0 function0, MusicDatabase musicDatabase, CoroutineScope coroutineScope, MutableState mutableState, Playlist playlist) {
        this.$r8$classId = (byte) 7;
        this.f$3 = function0;
        this.f$1 = musicDatabase;
        this.f$0 = coroutineScope;
        this.f$2 = mutableState;
        this.f$4 = playlist;
    }

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda40(Function0 function0, Object obj, MutableState mutableState, Object obj2, Object obj3, byte b) {
        this.$r8$classId = b;
        this.f$3 = function0;
        this.f$0 = obj;
        this.f$1 = mutableState;
        this.f$2 = obj2;
        this.f$4 = obj3;
    }

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda40(CoroutineScope coroutineScope, ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState, MediaMetadata mediaMetadata, MusicDatabase musicDatabase, MutableState mutableState) {
        this.$r8$classId = (byte) 9;
        this.f$0 = coroutineScope;
        this.f$2 = parcelableSnapshotMutableFloatState;
        this.f$3 = mediaMetadata;
        this.f$1 = musicDatabase;
        this.f$4 = mutableState;
    }

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda40(CoroutineScope coroutineScope, SyncUtils syncUtils, Playlist playlist, SnackbarHostState snackbarHostState, String str) {
        this.$r8$classId = (byte) 22;
        this.f$0 = coroutineScope;
        this.f$4 = syncUtils;
        this.f$1 = playlist;
        this.f$3 = snackbarHostState;
        this.f$2 = str;
    }

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda40(CoroutineScope coroutineScope, Function0 function0, MusicDatabase musicDatabase, SyncUtils syncUtils, PodcastEntity podcastEntity) {
        this.$r8$classId = (byte) 16;
        this.f$0 = coroutineScope;
        this.f$3 = function0;
        this.f$1 = musicDatabase;
        this.f$4 = syncUtils;
        this.f$2 = podcastEntity;
    }
}
