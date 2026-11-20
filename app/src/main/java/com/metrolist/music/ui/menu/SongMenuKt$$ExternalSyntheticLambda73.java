package com.metrolist.music.ui.menu;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimateAsState;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.TwoWayConverterImpl;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.SaveableHolder;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupLayout;
import androidx.compose.ui.window.PopupProperties;
import androidx.datastore.core.DataStoreImpl$writeData$2;
import androidx.emoji2.text.EmojiProcessor;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.viewmodel.internal.CloseableCoroutineScope;
import androidx.navigation.NavHostController;
import coil3.RealImageLoader;
import coil3.RealImageLoader$execute$result$1;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.innertube.models.AlbumItem;
import com.metrolist.innertube.models.ArtistItem;
import com.metrolist.innertube.models.EpisodeItem;
import com.metrolist.innertube.models.PlaylistItem;
import com.metrolist.innertube.models.PodcastItem;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.models.YTItem;
import com.metrolist.innertube.pages.HistoryPage;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda21;
import com.metrolist.music.constants.HistorySource;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.EventWithSong;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.discord.DiscordRpcManager;
import com.metrolist.music.listentogether.ListenTogetherManager;
import com.metrolist.music.lyrics.LyricsEntry;
import com.metrolist.music.lyrics.LyricsHelper$getAllLyrics$3;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.playback.queues.ListQueue;
import com.metrolist.music.playback.queues.YouTubeQueue;
import com.metrolist.music.utils.SyncUtils;
import com.metrolist.music.viewmodels.BackupRestoreViewModel;
import com.metrolist.music.viewmodels.CsvImportState;
import com.yalantis.ucrop.R;
import io.ktor.http.MimesKt$$ExternalSyntheticLambda0;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.io.TextStreamsKt$$ExternalSyntheticLambda0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.HexFormatKt;
import kotlin.text.StringsKt;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.StandaloneCoroutine;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.ConnectionPool;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SongMenuKt$$ExternalSyntheticLambda73 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Object f$4;
    public final /* synthetic */ Object f$5;

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda73(MutableState mutableState, MutableState mutableState2, BackupRestoreViewModel backupRestoreViewModel, Context context, MutableState mutableState3, MutableState mutableState4) {
        this.$r8$classId = (byte) 15;
        this.f$4 = mutableState;
        this.f$0 = mutableState2;
        this.f$1 = backupRestoreViewModel;
        this.f$2 = context;
        this.f$3 = mutableState3;
        this.f$5 = mutableState4;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x009b  */
    /* JADX WARN: Code duplicated, block: B:20:0x00ab  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0, types: [kotlin.coroutines.Continuation] */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v3, types: [java.lang.Object] */
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
    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() throws IOException {
        boolean z;
        String str;
        List list;
        String str2;
        List list2;
        Collection arrayList;
        byte b = this.$r8$classId;
        byte b2 = 9;
        byte b3 = 3;
        String strJoinToString$default = "";
        byte b4 = 2;
        boolean z2 = false;
        ?? r9 = 0;
        Activity activity = null;
        Object obj = this.f$2;
        Unit unit = Unit.INSTANCE;
        Object obj2 = this.f$5;
        Object obj3 = this.f$3;
        Object obj4 = this.f$4;
        Object obj5 = this.f$1;
        Object obj6 = this.f$0;
        switch (b) {
            case 0:
                Timber.Forest.getClass();
                ConnectionPool.d(new Object[0]);
                DefaultScheduler defaultScheduler = Dispatchers.Default;
                AwaitKt.launch$default((CoroutineScope) obj5, DefaultIoScheduler.INSTANCE, null, new RealImageLoader$execute$result$1((String) obj6, (MusicDatabase) obj3, (MutableState) obj4, (Song) obj2, null, (byte) 12), 2);
                ((Function0) obj).invoke();
                return unit;
            case 1:
                AnimateAsState animateAsState = (AnimateAsState) obj5;
                TwoWayConverterImpl twoWayConverterImpl = (TwoWayConverterImpl) obj3;
                Object springSpec = (AnimationSpec) obj4;
                String str3 = (String) obj6;
                Animatable animatable = animateAsState.animatable;
                if (animatable.typeConverter != twoWayConverterImpl || !Intrinsics.areEqual(animatable.label, str3)) {
                    animateAsState.animatable = new Animatable(animateAsState.animatable.getValue(), twoWayConverterImpl, obj2, str3);
                    z2 = true;
                }
                Object value = animateAsState.animatable.targetValue$delegate.getValue();
                Object obj7 = this.f$2;
                if (!obj7.equals(value)) {
                    z2 = true;
                }
                if (obj2 != null && (springSpec instanceof SpringSpec)) {
                    SpringSpec springSpec2 = (SpringSpec) springSpec;
                    if (!Intrinsics.areEqual(springSpec2.visibilityThreshold, obj2)) {
                        springSpec = new SpringSpec(springSpec2.dampingRatio, springSpec2.stiffness, obj2);
                    }
                }
                Object obj8 = springSpec;
                if (z2) {
                    StandaloneCoroutine standaloneCoroutine = animateAsState.job;
                    Continuation continuation = null;
                    if (standaloneCoroutine != null) {
                        standaloneCoroutine.cancel(null);
                    }
                    if (!Intrinsics.areEqual(animateAsState.animatable.targetValue$delegate.getValue(), obj7)) {
                        animateAsState.job = AwaitKt.launch$default(animateAsState.coroutineScope, null, CoroutineStart.UNDISPATCHED, new RealImageLoader.AnonymousClass2(animateAsState, obj7, obj8, continuation, (byte) 2), 1);
                    }
                }
                return unit;
            case 2:
                SaveableHolder saveableHolder = (SaveableHolder) obj5;
                Saver saver = (Saver) obj;
                SaveableStateRegistry saveableStateRegistry = (SaveableStateRegistry) obj3;
                String str4 = (String) obj6;
                Object[] objArr = (Object[]) obj2;
                if (saveableHolder.registry != saveableStateRegistry) {
                    saveableHolder.registry = saveableStateRegistry;
                    z2 = true;
                }
                if (Intrinsics.areEqual(saveableHolder.key, str4)) {
                    z = z2;
                } else {
                    saveableHolder.key = str4;
                    z = true;
                }
                saveableHolder.saver = saver;
                saveableHolder.value = obj4;
                saveableHolder.inputs = objArr;
                SaveableStateRegistry.Entry entry = saveableHolder.entry;
                if (entry != null && z) {
                    ((EmojiProcessor) entry).unregister();
                    saveableHolder.entry = null;
                    saveableHolder.register$1();
                }
                return unit;
            case 3:
                ((PopupLayout) obj5).updateParameters((Function0) obj, (PopupProperties) obj3, (String) obj6, (LayoutDirection) obj4, (Density) obj2);
                return unit;
            case 4:
                SnapshotStateList snapshotStateList = (SnapshotStateList) obj6;
                MutableState mutableState = (MutableState) obj4;
                State state = (State) obj5;
                MutableState mutableState2 = (MutableState) obj;
                MutableState mutableState3 = (MutableState) obj3;
                MutableState mutableState4 = (MutableState) obj2;
                List listSorted = CollectionsKt.sorted(snapshotStateList);
                ArrayList arrayList2 = new ArrayList();
                Iterator it = listSorted.iterator();
                while (it.hasNext()) {
                    LyricsEntry lyricsEntry = (LyricsEntry) CollectionsKt.getOrNull(((Number) it.next()).intValue(), (List) mutableState.getValue());
                    String str5 = lyricsEntry != null ? lyricsEntry.text : null;
                    if (str5 != null) {
                        arrayList2.add(str5);
                    }
                }
                String strJoinToString$default2 = CollectionsKt.joinToString$default(arrayList2, "\n", null, null, null, 62);
                if (!StringsKt.isBlank(strJoinToString$default2)) {
                    MediaMetadata mediaMetadata = (MediaMetadata) state.getValue();
                    if (mediaMetadata == null || (str = mediaMetadata.title) == null) {
                        str = "";
                    }
                    MediaMetadata mediaMetadata2 = (MediaMetadata) state.getValue();
                    if (mediaMetadata2 != null && (list = mediaMetadata2.artists) != null) {
                        strJoinToString$default = CollectionsKt.joinToString$default(list, null, null, null, new AlbumMenuKt$$ExternalSyntheticLambda13(b2), 31);
                    }
                    mutableState2.setValue(new Triple(strJoinToString$default2, str, strJoinToString$default));
                    mutableState3.setValue(Boolean.TRUE);
                }
                mutableState4.setValue(Boolean.FALSE);
                snapshotStateList.clear();
                return unit;
            case 5:
                Context context = (Context) obj5;
                Intent intent = new Intent();
                intent.setAction("android.intent.action.SEND");
                intent.setType("text/plain");
                StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("\"", (String) obj6, "\"\n\n", (String) obj3, " - ");
                sbM.append((String) obj4);
                sbM.append("\nhttps://music.youtube.com/watch?v=");
                sbM.append((String) obj2);
                intent.putExtra("android.intent.extra.TEXT", sbM.toString());
                context.startActivity(Intent.createChooser(intent, context.getString(R.string.share_lyrics)));
                ((Function0) obj).invoke();
                return unit;
            case 6:
                SnapshotStateList snapshotStateList2 = (SnapshotStateList) obj6;
                List list3 = (List) obj5;
                State state2 = (State) obj;
                MutableState mutableState5 = (MutableState) obj4;
                MutableState mutableState6 = (MutableState) obj3;
                MutableState mutableState7 = (MutableState) obj2;
                if (!snapshotStateList2.isEmpty()) {
                    List listSorted2 = CollectionsKt.sorted(snapshotStateList2);
                    ArrayList arrayList3 = new ArrayList();
                    Iterator it2 = listSorted2.iterator();
                    while (it2.hasNext()) {
                        LyricsEntry lyricsEntry2 = (LyricsEntry) CollectionsKt.getOrNull(((Number) it2.next()).intValue(), list3);
                        String str6 = lyricsEntry2 != null ? lyricsEntry2.text : null;
                        if (str6 != null) {
                            arrayList3.add(str6);
                        }
                    }
                    String strJoinToString$default3 = CollectionsKt.joinToString$default(arrayList3, "\n", null, null, null, 62);
                    if (!StringsKt.isBlank(strJoinToString$default3)) {
                        MediaMetadata mediaMetadata3 = (MediaMetadata) state2.getValue();
                        if (mediaMetadata3 == null || (str2 = mediaMetadata3.title) == null) {
                            str2 = "";
                        }
                        MediaMetadata mediaMetadata4 = (MediaMetadata) state2.getValue();
                        if (mediaMetadata4 != null && (list2 = mediaMetadata4.artists) != null) {
                            strJoinToString$default = CollectionsKt.joinToString$default(list2, null, null, null, new AlbumMenuKt$$ExternalSyntheticLambda13((byte) 18), 31);
                        }
                        mutableState5.setValue(new Triple(strJoinToString$default3, str2, strJoinToString$default));
                        mutableState6.setValue(Boolean.TRUE);
                    }
                    mutableState7.setValue(Boolean.FALSE);
                    snapshotStateList2.clear();
                }
                return unit;
            case 7:
                ((MutableState) obj4).setValue(new Triple((String) obj6, (String) obj5, (String) obj));
                ((MutableState) obj3).setValue(Boolean.TRUE);
                ((MutableState) obj2).setValue(Boolean.FALSE);
                return unit;
            case 8:
                ((Function1) obj6).invoke(new CsvImportState(((CsvImportState) obj5).previewRows, ((ParcelableSnapshotMutableIntState) obj).getIntValue(), ((ParcelableSnapshotMutableIntState) obj3).getIntValue(), ((ParcelableSnapshotMutableIntState) obj2).getIntValue(), ((Boolean) ((MutableState) obj4).getValue()).booleanValue()));
                return unit;
            case 9:
                DefaultScheduler defaultScheduler2 = Dispatchers.Default;
                AwaitKt.launch$default((CoroutineScope) obj5, DefaultIoScheduler.INSTANCE, null, new QueueMenuKt$QueueMenu$7$1$1$1(obj3, obj6, obj4, obj, obj2, (Continuation) null, (byte) 0), 2);
                return unit;
            case 10:
                MusicDatabase musicDatabase = (MusicDatabase) obj3;
                CoroutineScope coroutineScope = (CoroutineScope) obj5;
                State state3 = (State) obj6;
                PlaylistItem playlistItem = (PlaylistItem) obj;
                List list4 = (List) obj4;
                Context context2 = (Context) obj2;
                Playlist playlist = (Playlist) state3.getValue();
                boolean z3 = (playlist != null ? playlist.playlist.bookmarkedAt : null) != null;
                Playlist playlist2 = (Playlist) state3.getValue();
                if ((playlist2 != null ? playlist2.playlist : null) == null) {
                    musicDatabase.transaction(new MimesKt$$ExternalSyntheticLambda0(b3, playlistItem));
                } else {
                    musicDatabase.transaction(new SongMenuKt$$ExternalSyntheticLambda4((Object) playlistItem, (Object) state3, (byte) 11));
                }
                DefaultScheduler defaultScheduler3 = Dispatchers.Default;
                AwaitKt.launch$default(coroutineScope, DefaultIoScheduler.INSTANCE, null, new DataStoreImpl$writeData$2(z3, musicDatabase, playlistItem, list4, context2, (Continuation) null), 2);
                return unit;
            case 11:
                ((MusicDatabase) obj3).transaction(new MainActivity$$ExternalSyntheticLambda21(obj5, obj2, obj4, (byte) 17));
                ((Function0) obj).invoke();
                ((Function0) obj6).invoke();
                return unit;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                MusicDatabase musicDatabase2 = (MusicDatabase) obj3;
                CoroutineScope coroutineScope2 = (CoroutineScope) obj5;
                Function0 function0 = (Function0) obj;
                Function0 function1 = (Function0) obj6;
                ArrayList arrayList4 = (ArrayList) obj2;
                if (((Boolean) ((MutableState) obj4).getValue()).booleanValue()) {
                    musicDatabase2.query(new TextStreamsKt$$ExternalSyntheticLambda0(arrayList4, (byte) 9));
                    AwaitKt.launch$default(coroutineScope2, null, null, new SelectionSongsMenuKt$SelectionSongMenu$11$1$2$1$7$1$2(arrayList4, r9, b4), 3);
                } else {
                    musicDatabase2.transaction(new TextStreamsKt$$ExternalSyntheticLambda0(arrayList4, (byte) 10));
                    AwaitKt.launch$default(coroutineScope2, null, null, new SelectionSongsMenuKt$SelectionSongMenu$11$1$2$1$7$1$2(arrayList4, r9, b3), 3);
                }
                function0.invoke();
                function1.invoke();
                return unit;
            case 13:
                List list5 = (List) obj5;
                PlayerConnection playerConnection = (PlayerConnection) obj;
                String str7 = (String) obj6;
                List list6 = (List) obj3;
                MutableState mutableState8 = (MutableState) obj2;
                if (((HistorySource) ((MutableState) obj4).getValue()) != HistorySource.REMOTE || ((HistoryPage) mutableState8.getValue()) == null) {
                    ArrayList arrayList5 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list6, 10));
                    Iterator it3 = list6.iterator();
                    while (it3.hasNext()) {
                        arrayList5.add(UuidKt.toMediaItem(HexFormatKt.toMediaMetadata(((EventWithSong) it3.next()).song)));
                    }
                    List mutableList = CollectionsKt.toMutableList((Iterable) arrayList5);
                    Collections.shuffle(mutableList);
                    playerConnection.playQueue(new ListQueue(str7, mutableList, 0, 0L, 12, null));
                } else {
                    if (list5 != null) {
                        arrayList = new ArrayList();
                        Iterator it4 = list5.iterator();
                        while (it4.hasNext()) {
                            CollectionsKt__MutableCollectionsKt.addAll(((HistoryPage.HistorySection) it4.next()).songs, arrayList);
                        }
                    } else {
                        arrayList = EmptyList.INSTANCE;
                    }
                    if (!arrayList.isEmpty()) {
                        ArrayList arrayList6 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
                        Iterator it5 = arrayList.iterator();
                        while (it5.hasNext()) {
                            arrayList6.add(UuidKt.toMediaItem((SongItem) it5.next()));
                        }
                        List mutableList2 = CollectionsKt.toMutableList((Iterable) arrayList6);
                        Collections.shuffle(mutableList2);
                        playerConnection.playQueue(new ListQueue(str7, mutableList2, 0, 0L, 12, null));
                    }
                }
                return unit;
            case 14:
                YTItem yTItem = (YTItem) obj6;
                PlayerConnection playerConnection2 = (PlayerConnection) obj5;
                Function0 function2 = (Function0) obj;
                NavHostController navHostController = (NavHostController) obj3;
                State state4 = (State) obj2;
                MutableState mutableState9 = (MutableState) obj4;
                if (yTItem != null) {
                    if (yTItem instanceof SongItem) {
                        SongItem songItem = (SongItem) yTItem;
                        String str8 = songItem.id;
                        MediaMetadata mediaMetadata5 = (MediaMetadata) state4.getValue();
                        if (Intrinsics.areEqual(str8, mediaMetadata5 != null ? mediaMetadata5.id : null)) {
                            playerConnection2.togglePlayPause();
                        } else {
                            playerConnection2.playQueue(((Boolean) mutableState9.getValue()).booleanValue() ? YouTubeQueue.INSTANCE.radio(HexFormatKt.toMediaMetadata(songItem)) : new ListQueue(songItem.title, CollectionsKt__IterablesKt.listOf(UuidKt.toMediaItem(HexFormatKt.toMediaMetadata(songItem))), 0, 0L, 12, null));
                            function2.invoke();
                        }
                    } else if (yTItem instanceof AlbumItem) {
                        NavHostController.navigate$default(navHostController, "album/" + ((AlbumItem) yTItem).id);
                        function2.invoke();
                    } else if (yTItem instanceof ArtistItem) {
                        NavHostController.navigate$default(navHostController, "artist/" + ((ArtistItem) yTItem).id);
                        function2.invoke();
                    } else if (yTItem instanceof PlaylistItem) {
                        NavHostController.navigate$default(navHostController, "online_playlist/" + ((PlaylistItem) yTItem).id);
                        function2.invoke();
                    } else if (yTItem instanceof PodcastItem) {
                        NavHostController.navigate$default(navHostController, "online_podcast/" + ((PodcastItem) yTItem).id);
                        function2.invoke();
                    } else if (yTItem instanceof EpisodeItem) {
                        EpisodeItem episodeItem = (EpisodeItem) yTItem;
                        String str9 = episodeItem.id;
                        MediaMetadata mediaMetadata6 = (MediaMetadata) state4.getValue();
                        if (Intrinsics.areEqual(str9, (Object) (mediaMetadata6 != null ? mediaMetadata6.id : 0))) {
                            playerConnection2.togglePlayPause();
                        } else {
                            playerConnection2.playQueue(YouTubeQueue.INSTANCE.radio(HexFormatKt.toMediaMetadata(episodeItem)));
                            function2.invoke();
                        }
                    }
                    return unit;
                }
                PathKt$$ExternalSyntheticBUOutline0.m$1();
                return null;
            case 15:
                MutableState mutableState10 = (MutableState) obj6;
                BackupRestoreViewModel backupRestoreViewModel = (BackupRestoreViewModel) obj5;
                Context context3 = (Context) obj;
                MutableState mutableState11 = (MutableState) obj3;
                MutableState mutableState12 = (MutableState) obj2;
                Boolean bool = Boolean.FALSE;
                ((MutableState) obj4).setValue(bool);
                Uri uri = (Uri) mutableState10.getValue();
                if (uri != null) {
                    backupRestoreViewModel.getClass();
                    context3.getClass();
                    CloseableCoroutineScope viewModelScope = ViewModelKt.getViewModelScope(backupRestoreViewModel);
                    DefaultScheduler defaultScheduler4 = Dispatchers.Default;
                    AwaitKt.launch$default(viewModelScope, DefaultIoScheduler.INSTANCE, null, new LyricsHelper$getAllLyrics$3(context3, uri, backupRestoreViewModel, null), 2);
                }
                mutableState10.setValue(null);
                mutableState11.setValue(null);
                mutableState12.setValue(bool);
                return unit;
            case 16:
                MutableState mutableState13 = (MutableState) obj4;
                CoroutineScope coroutineScope3 = (CoroutineScope) obj5;
                MutableState mutableState14 = (MutableState) obj;
                MutableState mutableState15 = (MutableState) obj3;
                MutableState mutableState16 = (MutableState) obj2;
                mutableState13.setValue(Boolean.TRUE);
                for (Context baseContext = (Context) obj6; baseContext instanceof ContextWrapper; baseContext = ((ContextWrapper) baseContext).getBaseContext()) {
                    if (baseContext instanceof Activity) {
                        activity = (Activity) baseContext;
                        if (activity == null) {
                            mutableState13.setValue(Boolean.FALSE);
                            Timber.Forest.getClass();
                            ConnectionPool.w(new Object[0]);
                        } else {
                            DiscordRpcManager.INSTANCE.authorize(activity, new AlbumMenuKt$$ExternalSyntheticLambda40(coroutineScope3, mutableState13, mutableState14, mutableState15, mutableState16));
                        }
                        return unit;
                    }
                }
                if (activity == null) {
                    mutableState13.setValue(Boolean.FALSE);
                    Timber.Forest.getClass();
                    ConnectionPool.w(new Object[0]);
                } else {
                    DiscordRpcManager.INSTANCE.authorize(activity, new AlbumMenuKt$$ExternalSyntheticLambda40(coroutineScope3, mutableState13, mutableState14, mutableState15, mutableState16));
                }
                return unit;
            default:
                ListenTogetherManager listenTogetherManager = (ListenTogetherManager) obj6;
                Context context4 = (Context) obj5;
                MutableState mutableState17 = (MutableState) obj;
                MutableState mutableState18 = (MutableState) obj3;
                MutableState mutableState19 = (MutableState) obj2;
                String string = StringsKt.trim((String) ((MutableState) obj4).getValue()).toString();
                if (StringsKt.isBlank(string) || ((String) mutableState17.getValue()).length() != 8) {
                    Toast.makeText(context4, R.string.error_username_empty, 0).show();
                } else {
                    mutableState18.setValue(string);
                    listenTogetherManager.joinRoom((String) mutableState17.getValue(), string);
                    mutableState19.setValue(Boolean.FALSE);
                    mutableState17.setValue("");
                }
                return unit;
        }
    }

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda73(AnimateAsState animateAsState, Object obj, TwoWayConverterImpl twoWayConverterImpl, AnimationSpec animationSpec, Object obj2, String str) {
        this.$r8$classId = (byte) 1;
        this.f$1 = animateAsState;
        this.f$2 = obj;
        this.f$3 = twoWayConverterImpl;
        this.f$4 = animationSpec;
        this.f$5 = obj2;
        this.f$0 = str;
    }

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda73(MusicDatabase musicDatabase, Function0 function0, Function0 function1, ArrayList arrayList, SyncUtils syncUtils, MutableState mutableState) {
        this.$r8$classId = (byte) 11;
        this.f$3 = musicDatabase;
        this.f$2 = function0;
        this.f$0 = function1;
        this.f$1 = arrayList;
        this.f$5 = syncUtils;
        this.f$4 = mutableState;
    }

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda73(MusicDatabase musicDatabase, CoroutineScope coroutineScope, State state, PlaylistItem playlistItem, List list, Context context) {
        this.$r8$classId = (byte) 10;
        this.f$3 = musicDatabase;
        this.f$1 = coroutineScope;
        this.f$0 = state;
        this.f$2 = playlistItem;
        this.f$4 = list;
        this.f$5 = context;
    }

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda73(MusicDatabase musicDatabase, CoroutineScope coroutineScope, Function0 function0, Function0 function1, MutableState mutableState, ArrayList arrayList) {
        this.$r8$classId = (byte) 12;
        this.f$3 = musicDatabase;
        this.f$1 = coroutineScope;
        this.f$2 = function0;
        this.f$0 = function1;
        this.f$4 = mutableState;
        this.f$5 = arrayList;
    }

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda73(ListenTogetherManager listenTogetherManager, Context context, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4) {
        this.$r8$classId = (byte) 17;
        this.f$0 = listenTogetherManager;
        this.f$1 = context;
        this.f$4 = mutableState;
        this.f$2 = mutableState2;
        this.f$3 = mutableState3;
        this.f$5 = mutableState4;
    }

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda73(Object obj, MutableState mutableState, Object obj2, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$4 = mutableState;
        this.f$1 = obj2;
        this.f$2 = mutableState2;
        this.f$3 = mutableState3;
        this.f$5 = mutableState4;
    }

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda73(Object obj, Object obj2, Object obj3, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
        this.f$4 = mutableState;
        this.f$3 = mutableState2;
        this.f$5 = mutableState3;
    }

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda73(Object obj, Object obj2, Object obj3, Object obj4, State state, MutableState mutableState, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
        this.f$3 = obj4;
        this.f$5 = state;
        this.f$4 = mutableState;
    }

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda73(Object obj, Object obj2, Object obj3, String str, Object obj4, Object obj5, byte b) {
        this.$r8$classId = b;
        this.f$1 = obj;
        this.f$2 = obj2;
        this.f$3 = obj3;
        this.f$0 = str;
        this.f$4 = obj4;
        this.f$5 = obj5;
    }

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda73(Object obj, Object obj2, String str, Object obj3, Object obj4, Object obj5, byte b) {
        this.$r8$classId = b;
        this.f$1 = obj;
        this.f$2 = obj2;
        this.f$0 = str;
        this.f$3 = obj3;
        this.f$4 = obj4;
        this.f$5 = obj5;
    }

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda73(String str, CoroutineScope coroutineScope, Function0 function0, MusicDatabase musicDatabase, MutableState mutableState, Song song) {
        this.$r8$classId = (byte) 0;
        this.f$0 = str;
        this.f$1 = coroutineScope;
        this.f$2 = function0;
        this.f$3 = musicDatabase;
        this.f$4 = mutableState;
        this.f$5 = song;
    }

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda73(CoroutineScope coroutineScope, MusicDatabase musicDatabase, MediaMetadata mediaMetadata, MutableState mutableState, SyncUtils syncUtils, Context context) {
        this.$r8$classId = (byte) 9;
        this.f$1 = coroutineScope;
        this.f$3 = musicDatabase;
        this.f$0 = mediaMetadata;
        this.f$4 = mutableState;
        this.f$2 = syncUtils;
        this.f$5 = context;
    }
}
