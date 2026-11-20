package com.metrolist.music.ui.menu;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.TargetBasedAnimation;
import androidx.compose.material3.BottomSheetKt$$ExternalSyntheticLambda3;
import androidx.compose.material3.BottomSheetKt$BottomSheetImpl$6$1$1$1$1;
import androidx.compose.material3.SheetState;
import androidx.compose.material3.SheetValue;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.PlatformHapticFeedback;
import androidx.compose.ui.text.AnnotatedString;
import androidx.datastore.core.SimpleActor$offer$2;
import androidx.lifecycle.ViewModelKt;
import androidx.media3.exoplayer.ExoPlayerImpl;
import androidx.navigation.NavHostController;
import androidx.navigation.compose.NavHostKt$NavHost$29$1;
import coil3.compose.AsyncImagePainter;
import coil3.network.NetworkFetcher$doFetch$fetchResult$1;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.models.YTItem;
import com.metrolist.innertubex.InnerTube$feedback$2;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Album;
import com.metrolist.music.db.entities.AlbumEntity;
import com.metrolist.music.db.entities.ArtistEntity;
import com.metrolist.music.db.entities.LocalItem;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.db.entities.SongEntity;
import com.metrolist.music.db.entities.SongWithStats;
import com.metrolist.music.listentogether.ListenTogetherManager;
import com.metrolist.music.listentogether.ProtocolKt;
import com.metrolist.music.lyrics.LyricsUtils$$ExternalSyntheticLambda0;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.playback.DownloadUtil;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.ui.component.BottomSheetPageState;
import com.metrolist.music.ui.component.BottomSheetState;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.component.TimeTransferKt$$ExternalSyntheticLambda3;
import com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda82;
import com.metrolist.music.ui.player.ThumbnailKt$ThumbnailImage$1$1;
import com.metrolist.music.ui.screens.OptionStats;
import com.metrolist.music.utils.DataStoreKt$get$1;
import com.metrolist.music.utils.DataStoreKt$get$2;
import com.metrolist.music.utils.SyncUtils;
import com.metrolist.music.utils.Updater$checkForUpdate$2;
import com.metrolist.music.viewmodels.StatsViewModel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.io.TextStreamsKt$$ExternalSyntheticLambda0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.text.HexFormatKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SongMenuKt$$ExternalSyntheticLambda63 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda63(HapticFeedback hapticFeedback, MenuState menuState, LocalItem localItem, CoroutineScope coroutineScope) {
        this.$r8$classId = (byte) 27;
        this.f$1 = hapticFeedback;
        this.f$2 = menuState;
        this.f$3 = localItem;
        this.f$0 = coroutineScope;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r17v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v0, types: [kotlin.coroutines.Continuation] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v9 */
    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() throws IOException {
        long jIntValue;
        SongEntity songEntity;
        SongEntity songEntity2;
        AlbumEntity albumEntity;
        String str;
        byte b = this.$r8$classId;
        byte b2 = 8;
        byte b3 = 2;
        byte b4 = 3;
        ?? r8 = 0;
        str = null;
        String str2 = null;
        boolean z = true;
        z = true;
        int i = 0;
        boolean z2 = false;
        boolean z3 = false;
        Unit unit = Unit.INSTANCE;
        Object obj = this.f$3;
        Object obj2 = this.f$2;
        Object obj3 = this.f$1;
        Object obj4 = this.f$0;
        switch (b) {
            case 0:
                ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = (ParcelableSnapshotMutableFloatState) obj3;
                parcelableSnapshotMutableFloatState.setFloatValue(parcelableSnapshotMutableFloatState.getFloatValue() - 360.0f);
                DefaultScheduler defaultScheduler = Dispatchers.Default;
                AwaitKt.launch$default((CoroutineScope) obj4, DefaultIoScheduler.INSTANCE, null, new DataStoreKt$get$1((Song) obj2, (MusicDatabase) obj, (Continuation) r8, z ? (byte) 1 : (byte) 0), 2);
                break;
            case 1:
                Float f = (Float) obj4;
                InfiniteTransition.TransitionAnimationState transitionAnimationState = (InfiniteTransition.TransitionAnimationState) obj3;
                Float f2 = (Float) obj2;
                InfiniteRepeatableSpec infiniteRepeatableSpec = (InfiniteRepeatableSpec) obj;
                if (!f.equals(transitionAnimationState.initialValue) || !f2.equals(transitionAnimationState.targetValue)) {
                    transitionAnimationState.initialValue = f;
                    transitionAnimationState.targetValue = f2;
                    transitionAnimationState.animation = new TargetBasedAnimation(infiniteRepeatableSpec, ArcSplineKt.FloatToVector, f, f2, null);
                    InfiniteTransition.this.refreshChildNeeded$delegate.setValue(Boolean.TRUE);
                    transitionAnimationState.isFinished = false;
                    transitionAnimationState.startOnTheNextFrame = true;
                }
                break;
            case 2:
                SheetState sheetState = (SheetState) obj3;
                CoroutineScope coroutineScope = (CoroutineScope) obj4;
                Animatable animatable = (Animatable) obj2;
                Function0 function0 = (Function0) obj;
                if (sheetState.getCurrentValue() == SheetValue.Expanded && sheetState.anchoredDraggableState.getAnchors().hasPositionFor(SheetValue.PartiallyExpanded)) {
                    AwaitKt.launch$default(coroutineScope, null, null, new BottomSheetKt$BottomSheetImpl$6$1$1$1$1(sheetState, r8, z ? (byte) 1 : (byte) 0), 3);
                    AwaitKt.launch$default(coroutineScope, null, null, new ThumbnailKt$ThumbnailImage$1$1(animatable, r8, z ? (byte) 1 : (byte) 0), 3);
                } else {
                    AwaitKt.launch$default(coroutineScope, null, null, new BottomSheetKt$BottomSheetImpl$6$1$1$1$1(sheetState, r8, b3), 3).invokeOnCompletion(new BottomSheetKt$$ExternalSyntheticLambda3(sheetState, function0, (byte) 0));
                }
                break;
            case 3:
                ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState2 = (ParcelableSnapshotMutableFloatState) obj3;
                ((Function1) obj4).invoke(((Pair) obj2).first);
                parcelableSnapshotMutableFloatState2.setFloatValue(parcelableSnapshotMutableFloatState2.getFloatValue() - 180.0f);
                ((MutableState) obj).setValue(Boolean.FALSE);
                break;
            case 4:
                DefaultScheduler defaultScheduler2 = Dispatchers.Default;
                AwaitKt.launch$default((CoroutineScope) obj4, DefaultIoScheduler.INSTANCE, null, new NetworkFetcher$doFetch$fetchResult$1((MusicDatabase) obj, (YTItem) obj3, (PlayerConnection) obj2, null), 2);
                break;
            case 5:
                AwaitKt.launch$default((CoroutineScope) obj4, null, null, new DataStoreKt$get$2(obj, obj3, obj2, (Continuation) null, (byte) 7), 3);
                break;
            case 6:
                SongWithStats songWithStats = (SongWithStats) obj4;
                ((MutableState) obj2).setValue(songWithStats.title);
                ((MutableState) obj3).setValue(songWithStats);
                ((MutableState) obj).setValue(Boolean.FALSE);
                break;
            case 7:
                MutableState mutableState = (MutableState) obj4;
                MutableState mutableState2 = (MutableState) obj3;
                StatsViewModel statsViewModel = (StatsViewModel) obj2;
                Function0 function1 = (Function0) obj;
                SongWithStats songWithStats2 = (SongWithStats) mutableState.getValue();
                String str3 = songWithStats2 != null ? songWithStats2.id : null;
                SongWithStats songWithStats3 = (SongWithStats) mutableState2.getValue();
                String str4 = songWithStats3 != null ? songWithStats3.id : null;
                if (str3 != null && str4 != null && !str3.equals(str4)) {
                    AwaitKt.launch$default(ViewModelKt.getViewModelScope(statsViewModel), null, null, new InnerTube$feedback$2((Object) statsViewModel, (Object) str3, (Object) str4, (Object) new TimeTransferKt$$ExternalSyntheticLambda3(mutableState, mutableState2, function1, (byte) 0), (Continuation) null, (byte) 19), 3);
                }
                break;
            case 8:
                NavHostController navHostController = (NavHostController) obj3;
                Function0 function2 = (Function0) obj2;
                MutableState mutableState3 = (MutableState) obj;
                List list = ((Album) obj4).artists;
                if (list.size() != 1) {
                    mutableState3.setValue(Boolean.TRUE);
                } else {
                    NavHostController.navigate$default(navHostController, "artist/" + ((ArtistEntity) list.get(0)).id);
                    function2.invoke();
                }
                break;
            case 9:
                ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState3 = (ParcelableSnapshotMutableFloatState) obj3;
                parcelableSnapshotMutableFloatState3.setFloatValue(parcelableSnapshotMutableFloatState3.getFloatValue() - 360.0f);
                DefaultScheduler defaultScheduler3 = Dispatchers.Default;
                AwaitKt.launch$default((CoroutineScope) obj4, DefaultIoScheduler.INSTANCE, null, new AlbumMenuKt$AlbumMenu$11$1$5$4$1$1((Album) obj2, (MusicDatabase) obj, (Continuation) null), 2);
                break;
            case 10:
                Context context = (Context) obj3;
                ManagedActivityResultLauncher managedActivityResultLauncher = (ManagedActivityResultLauncher) obj2;
                Function0 function3 = (Function0) obj;
                ExoPlayerImpl playerSafe = ((PlayerConnection) obj4).getPlayerSafe();
                playerSafe.verifyApplicationThread();
                int iIntValue = ((Integer) playerSafe.audioSessionIdState.get()).intValue();
                if (iIntValue != 0 && iIntValue > 0) {
                    Intent intent = new Intent("android.media.action.DISPLAY_AUDIO_EFFECT_CONTROL_PANEL");
                    intent.putExtra("android.media.extra.AUDIO_SESSION", iIntValue);
                    intent.putExtra("android.media.extra.PACKAGE_NAME", context.getPackageName());
                    intent.putExtra("android.media.extra.CONTENT_TYPE", 0);
                    if (intent.resolveActivity(context.getPackageManager()) != null) {
                        managedActivityResultLauncher.launch(intent);
                    }
                }
                function3.invoke();
                break;
            case 11:
                DefaultScheduler defaultScheduler4 = Dispatchers.Default;
                AwaitKt.launch$default((CoroutineScope) obj4, DefaultIoScheduler.INSTANCE, null, new SimpleActor$offer$2((String) obj2, (PlayerConnection) obj, r8, (byte) 14), 2);
                ((Function0) obj3).invoke();
                break;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                AwaitKt.launch$default((CoroutineScope) obj4, null, null, new DownloadUtil.AnonymousClass2((PlayerConnection) obj2, (MutableState) obj, r8, (byte) 27), 3);
                ((Function0) obj3).invoke();
                break;
            case 13:
                NavHostController.navigate$default((NavHostController) obj4, "album/" + ((MediaMetadata) obj3).album.id);
                ((BottomSheetState) obj2).collapseSoft();
                ((Function0) obj).invoke();
                break;
            case 14:
                MusicDatabase musicDatabase = (MusicDatabase) obj;
                CoroutineScope coroutineScope2 = (CoroutineScope) obj4;
                ArrayList arrayList = (ArrayList) obj2;
                if (!((Boolean) ((MutableState) obj3).getValue()).booleanValue()) {
                    musicDatabase.transaction(new TextStreamsKt$$ExternalSyntheticLambda0(arrayList, (byte) 8));
                    AwaitKt.launch$default(coroutineScope2, null, null, new SelectionSongsMenuKt$SelectionSongMenu$11$1$2$1$7$1$2(arrayList, r8, z ? (byte) 1 : (byte) 0), 3);
                } else {
                    musicDatabase.query(new TextStreamsKt$$ExternalSyntheticLambda0(arrayList, (byte) 7));
                    AwaitKt.launch$default(coroutineScope2, null, null, new SelectionSongsMenuKt$SelectionSongMenu$11$1$2$1$7$1$2(arrayList, r8, z2 ? 1 : 0), 3);
                }
                break;
            case 15:
                ArrayList arrayList2 = (ArrayList) obj4;
                Function0 function4 = (Function0) obj3;
                MusicDatabase musicDatabase2 = (MusicDatabase) obj;
                SyncUtils syncUtils = (SyncUtils) obj2;
                if (!arrayList2.isEmpty()) {
                    int size = arrayList2.size();
                    int i2 = 0;
                    while (i2 < size) {
                        Object obj5 = arrayList2.get(i2);
                        i2++;
                        if (!((Song) obj5).song.liked) {
                            z = false;
                        }
                    }
                }
                function4.invoke();
                musicDatabase2.query(new LyricsUtils$$ExternalSyntheticLambda0(arrayList2, z, syncUtils, b2));
                break;
            case 16:
                ((Function0) obj4).invoke();
                ((MusicDatabase) obj).query(new SongMenuKt$$ExternalSyntheticLambda4(obj2, (Object) new Ref$IntRef(), (byte) 6));
                ((Function0) obj3).invoke();
                break;
            case 17:
                Song song = (Song) obj2;
                NavHostController navHostController2 = (NavHostController) obj4;
                Function0 function5 = (Function0) obj3;
                MutableState mutableState4 = (MutableState) obj;
                if (song.getOrderedArtists().size() != 1) {
                    mutableState4.setValue(Boolean.TRUE);
                } else {
                    NavHostController.navigate$default(navHostController2, "artist/" + ((ArtistEntity) song.getOrderedArtists().get(0)).id);
                    function5.invoke();
                }
                break;
            case 18:
                ArrayList arrayList3 = (ArrayList) obj4;
                Function0 function6 = (Function0) obj3;
                Function0 function7 = (Function0) obj2;
                DownloadUtil downloadUtil = (DownloadUtil) obj;
                int size2 = arrayList3.size();
                while (i < size2) {
                    Object obj6 = arrayList3.get(i);
                    i++;
                    SongItem songItem = (SongItem) obj6;
                    downloadUtil.getClass();
                    songItem.getClass();
                    downloadUtil.download(HexFormatKt.toMediaMetadata(songItem));
                }
                function6.invoke();
                function7.invoke();
                break;
            case 19:
                SongItem songItem2 = (SongItem) obj4;
                List list2 = (List) obj3;
                ListenTogetherManager listenTogetherManager = (ListenTogetherManager) obj2;
                Function0 function8 = (Function0) obj;
                Integer num = songItem2.duration;
                if (num == null || num.intValue() <= 0) {
                    jIntValue = 180000;
                } else {
                    Integer num2 = songItem2.duration;
                    num2.getClass();
                    jIntValue = ((long) num2.intValue()) * 1000;
                }
                long j = jIntValue;
                String str5 = songItem2.id;
                String str6 = songItem2.title;
                String strJoinToString$default = CollectionsKt.joinToString$default(list2, ", ", null, null, new SongMenuKt$$ExternalSyntheticLambda16((byte) 19), 30);
                com.metrolist.innertube.models.Album album = songItem2.album;
                listenTogetherManager.suggestTrack(ProtocolKt.TrackInfo(str5, str6, strJoinToString$default, album != null ? album.name : 0, j, songItem2.thumbnail, null));
                function8.invoke();
                break;
            case 20:
                AwaitKt.launch$default((CoroutineScope) obj4, null, null, new AsyncImagePainter.AnonymousClass1((SongItem) obj3, (Function0) obj2, (Function0) obj, null, (byte) 22), 3);
                break;
            case 21:
                CoroutineScope coroutineScope3 = (CoroutineScope) obj4;
                MusicDatabase musicDatabase3 = (MusicDatabase) obj;
                SongItem songItem3 = (SongItem) obj2;
                Song song2 = (Song) ((State) obj3).getValue();
                boolean z4 = ((song2 == null || (songEntity = song2.song) == null) ? null : songEntity.inLibrary) != null;
                AwaitKt.launch$default(coroutineScope3, null, null, new Updater$checkForUpdate$2((Object) songItem3, z4, (Continuation) r8, (byte) 4), 3);
                if (!z4) {
                    musicDatabase3.transaction(new YouTubeSongMenuKt$$ExternalSyntheticLambda51(songItem3, b4));
                } else {
                    musicDatabase3.query(new YouTubeSongMenuKt$$ExternalSyntheticLambda51(songItem3, z3 ? 1 : 0));
                }
                break;
            case 22:
                String str7 = (String) obj4;
                ((ClipboardManager) obj2).setPrimaryClip(ClipData.newPlainText(str7, (AnnotatedString) obj3));
                Toast.makeText((Context) obj, str7, 0).show();
                break;
            case 23:
                String str8 = (String) obj4;
                ((ClipboardManager) obj2).setPrimaryClip(ClipData.newPlainText(str8, (String) obj3));
                Toast.makeText((Context) obj, str8, 0).show();
                break;
            case 24:
                NavHostController navHostController3 = (NavHostController) obj3;
                BottomSheetState bottomSheetState = (BottomSheetState) obj2;
                State state = (State) obj;
                MediaMetadata.Album album2 = ((MediaMetadata) obj4).album;
                if (album2 == null || (str = album2.id) == null) {
                    Song song3 = (Song) state.getValue();
                    if (song3 == null || (albumEntity = song3.album) == null) {
                        Song song4 = (Song) state.getValue();
                        if (song4 != null && (songEntity2 = song4.song) != null) {
                            str2 = songEntity2.albumId;
                        }
                    } else {
                        str2 = albumEntity.id;
                    }
                } else {
                    str2 = str;
                }
                if (str2 != null) {
                    NavHostController.navigate$default(navHostController3, "album/".concat(str2));
                    bottomSheetState.collapseSoft();
                }
                break;
            case 25:
                MenuState menuState = (MenuState) obj4;
                menuState.show(new ComposableLambdaImpl(true, -1137200754, new SongMenuKt$$ExternalSyntheticLambda34((MediaMetadata) obj3, (BottomSheetState) obj2, (BottomSheetPageState) obj, menuState, (byte) 11)));
                break;
            case 26:
                DefaultScheduler defaultScheduler5 = Dispatchers.Default;
                AwaitKt.launch$default((CoroutineScope) obj4, DefaultIoScheduler.INSTANCE, null, new NavHostKt$NavHost$29$1(obj3, obj, obj2, (Continuation) null, (byte) 10), 2);
                break;
            case 27:
                MenuState menuState2 = (MenuState) obj2;
                ((PlatformHapticFeedback) ((HapticFeedback) obj3)).m578performHapticFeedbackCdsT49E(0);
                menuState2.show(new ComposableLambdaImpl(true, 1842891300, new PlayerKt$$ExternalSyntheticLambda82((LocalItem) obj, (CoroutineScope) obj4, menuState2, b2)));
                break;
            case 28:
                MutableState mutableState5 = (MutableState) obj3;
                StatsViewModel statsViewModel2 = (StatsViewModel) obj2;
                MutableState mutableState6 = (MutableState) obj;
                ((MutableState) obj4).setValue(Boolean.FALSE);
                OptionStats optionStats = (OptionStats) mutableState5.getValue();
                if (optionStats != null) {
                    StateFlowImpl stateFlowImpl = statsViewModel2.selectedOption;
                    stateFlowImpl.getClass();
                    stateFlowImpl.updateState(null, optionStats);
                }
                Integer num3 = (Integer) mutableState6.getValue();
                if (num3 != null) {
                    int iIntValue2 = num3.intValue();
                    StateFlowImpl stateFlowImpl2 = statsViewModel2.indexChips;
                    Integer numValueOf = Integer.valueOf(iIntValue2);
                    stateFlowImpl2.getClass();
                    stateFlowImpl2.updateState(null, numValueOf);
                }
                mutableState5.setValue(null);
                mutableState6.setValue(null);
                break;
            default:
                MenuState menuState3 = (MenuState) obj4;
                menuState3.show(new ComposableLambdaImpl(true, -80320101, new SongMenuKt$$ExternalSyntheticLambda34((PlayerConnection) obj3, (List) obj2, (DownloadUtil) obj, menuState3, (byte) 15)));
                break;
        }
        return unit;
    }

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda63(SheetState sheetState, CoroutineScope coroutineScope, Animatable animatable, Function0 function0) {
        this.$r8$classId = (byte) 2;
        this.f$1 = sheetState;
        this.f$0 = coroutineScope;
        this.f$2 = animatable;
        this.f$3 = function0;
    }

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda63(MusicDatabase musicDatabase, CoroutineScope coroutineScope, MutableState mutableState, ArrayList arrayList) {
        this.$r8$classId = (byte) 14;
        this.f$3 = musicDatabase;
        this.f$0 = coroutineScope;
        this.f$1 = mutableState;
        this.f$2 = arrayList;
    }

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda63(Song song, NavHostController navHostController, Function0 function0, MutableState mutableState) {
        this.$r8$classId = (byte) 17;
        this.f$2 = song;
        this.f$0 = navHostController;
        this.f$1 = function0;
        this.f$3 = mutableState;
    }

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda63(Object obj, MusicDatabase musicDatabase, Object obj2, Object obj3, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$3 = musicDatabase;
        this.f$1 = obj2;
        this.f$2 = obj3;
    }

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda63(Object obj, Object obj2, MusicDatabase musicDatabase, Object obj3, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$3 = musicDatabase;
        this.f$2 = obj3;
    }

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda63(Object obj, Object obj2, Object obj3, Object obj4, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
        this.f$3 = obj4;
    }

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda63(Function1 function1, Pair pair, ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState, MutableState mutableState) {
        this.$r8$classId = (byte) 3;
        this.f$0 = function1;
        this.f$2 = pair;
        this.f$1 = parcelableSnapshotMutableFloatState;
        this.f$3 = mutableState;
    }
}
