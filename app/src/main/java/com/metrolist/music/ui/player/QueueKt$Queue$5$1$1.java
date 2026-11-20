package com.metrolist.music.ui.player;

import android.content.Context;
import android.widget.Toast;
import androidx.compose.animation.core.Animatable;
import androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1$1$1;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.material3.SliderState;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.viewmodel.internal.CloseableCoroutineScope;
import androidx.media3.common.Timeline;
import androidx.media3.exoplayer.ExoPlayerImpl;
import androidx.media3.exoplayer.source.ShuffleOrder$DefaultShuffleOrder;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.innertube.models.ArtistItem;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.music.db.DatabaseDao$$ExternalSyntheticLambda0;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Artist;
import com.metrolist.music.db.entities.ArtistEntity;
import com.metrolist.music.db.entities.LyricsEntity;
import com.metrolist.music.db.entities.PlaylistSongMap;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.db.entities.SongEntity;
import com.metrolist.music.discord.DiscordUser;
import com.metrolist.music.lyrics.LyricsTranslationHelper;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.ui.component.OriginalLyricsKt;
import com.metrolist.music.utils.ArtistNameAliases;
import com.metrolist.music.utils.DataStoreKt$get$1;
import com.metrolist.music.utils.DataStoreKt$rememberPreference$1$1;
import com.metrolist.music.utils.InnerTubeXPlayer$$ExternalSyntheticLambda3;
import com.metrolist.music.utils.SyncUtils;
import com.metrolist.music.utils.Updater$getAllReleases$2;
import com.metrolist.music.viewmodels.HomeViewModel$getCommunityPlaylists$2$2$1;
import com.metrolist.music.viewmodels.LocalPlaylistViewModel;
import com.yalantis.ucrop.R;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.HexFormatKt;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import sh.calvin.reorderable.ReorderableLazyListState;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class QueueKt$Queue$5$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ Object $dragInfo$delegate;
    public final /* synthetic */ Object $playerConnection;
    public final /* synthetic */ Object $queueWindows$delegate;
    public final /* synthetic */ byte $r8$classId;
    public /* synthetic */ Object $reorderableState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QueueKt$Queue$5$1$1(MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, Continuation continuation) {
        super(2, continuation);
        this.$r8$classId = (byte) 8;
        this.$dragInfo$delegate = mutableState;
        this.$queueWindows$delegate = mutableState2;
        this.$reorderableState = mutableState3;
        this.$playerConnection = mutableState4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        Object obj2 = this.$playerConnection;
        Object obj3 = this.$queueWindows$delegate;
        Object obj4 = this.$dragInfo$delegate;
        switch (b) {
            case 0:
                return new QueueKt$Queue$5$1$1((ReorderableLazyListState) this.$reorderableState, (MutableState) obj4, (PlayerConnection) obj2, (MutableState) obj3, continuation);
            case 1:
                QueueKt$Queue$5$1$1 queueKt$Queue$5$1$1 = new QueueKt$Queue$5$1$1(obj4, obj3, obj2, continuation, (byte) 1);
                queueKt$Queue$5$1$1.$reorderableState = obj;
                return queueKt$Queue$5$1$1;
            case 2:
                QueueKt$Queue$5$1$1 queueKt$Queue$5$1$2 = new QueueKt$Queue$5$1$1(obj4, obj3, obj2, continuation, (byte) 2);
                queueKt$Queue$5$1$2.$reorderableState = obj;
                return queueKt$Queue$5$1$2;
            case 3:
                return new QueueKt$Queue$5$1$1((ReorderableLazyListState) this.$reorderableState, (Function1) obj3, (List) obj2, (MutableState) obj4, continuation);
            case 4:
                return new QueueKt$Queue$5$1$1((LyricsEntity) this.$reorderableState, (MutableState) obj4, (DataStoreKt$rememberPreference$1$1) obj3, (DataStoreKt$rememberPreference$1$1) obj2, continuation, (byte) 4);
            case 5:
                return new QueueKt$Queue$5$1$1((List) this.$reorderableState, (MutableState) obj4, (DataStoreKt$rememberPreference$1$1) obj3, (DataStoreKt$rememberPreference$1$1) obj2, continuation, (byte) 5);
            case 6:
                return new QueueKt$Queue$5$1$1((Context) this.$reorderableState, (Function0) obj2, (MutableState) obj4, (MutableState) obj3, continuation);
            case 7:
                return new QueueKt$Queue$5$1$1((ReorderableLazyListState) this.$reorderableState, (MutableState) obj4, (LocalPlaylistViewModel) obj3, (MusicDatabase) obj2, continuation, (byte) 7);
            case 8:
                return new QueueKt$Queue$5$1$1((MutableState) obj4, (MutableState) obj3, (MutableState) this.$reorderableState, (MutableState) obj2, continuation);
            case 9:
                return new QueueKt$Queue$5$1$1((DiscordUser) this.$reorderableState, (MutableState) obj4, (MutableState) obj3, (MutableState) obj2, continuation, (byte) 9);
            case 10:
                QueueKt$Queue$5$1$1 queueKt$Queue$5$1$3 = new QueueKt$Queue$5$1$1(obj4, obj3, obj2, continuation, (byte) 10);
                queueKt$Queue$5$1$3.$reorderableState = obj;
                return queueKt$Queue$5$1$3;
            case 11:
                QueueKt$Queue$5$1$1 queueKt$Queue$5$1$4 = new QueueKt$Queue$5$1$1(obj4, obj3, obj2, continuation, (byte) 11);
                queueKt$Queue$5$1$4.$reorderableState = obj;
                return queueKt$Queue$5$1$4;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                QueueKt$Queue$5$1$1 queueKt$Queue$5$1$5 = new QueueKt$Queue$5$1$1(obj4, obj3, obj2, continuation, (byte) 12);
                queueKt$Queue$5$1$5.$reorderableState = obj;
                return queueKt$Queue$5$1$5;
            default:
                QueueKt$Queue$5$1$1 queueKt$Queue$5$1$6 = new QueueKt$Queue$5$1$1(obj4, obj3, obj2, continuation, (byte) 13);
                queueKt$Queue$5$1$6.$reorderableState = obj;
                return queueKt$Queue$5$1$6;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                ((QueueKt$Queue$5$1$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                return unit;
            case 1:
                ((QueueKt$Queue$5$1$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                return unit;
            case 2:
                return ((QueueKt$Queue$5$1$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 3:
                ((QueueKt$Queue$5$1$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                return unit;
            case 4:
                ((QueueKt$Queue$5$1$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                return unit;
            case 5:
                ((QueueKt$Queue$5$1$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                return unit;
            case 6:
                ((QueueKt$Queue$5$1$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                return unit;
            case 7:
                ((QueueKt$Queue$5$1$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                return unit;
            case 8:
                ((QueueKt$Queue$5$1$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                return unit;
            case 9:
                ((QueueKt$Queue$5$1$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                return unit;
            case 10:
                ((QueueKt$Queue$5$1$1) create((MusicDatabase) obj, (Continuation) obj2)).invokeSuspend(unit);
                return unit;
            case 11:
                ((QueueKt$Queue$5$1$1) create((MusicDatabase) obj, (Continuation) obj2)).invokeSuspend(unit);
                return unit;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                ((QueueKt$Queue$5$1$1) create((MusicDatabase) obj, (Continuation) obj2)).invokeSuspend(unit);
                return unit;
            default:
                return ((QueueKt$Queue$5$1$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Pair pair;
        Pair pair2;
        byte b = this.$r8$classId;
        byte b2 = 2;
        Continuation continuation = null;
        int i = 0;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Unit unit = Unit.INSTANCE;
        Object obj2 = this.$queueWindows$delegate;
        Object obj3 = this.$playerConnection;
        Object obj4 = this.$dragInfo$delegate;
        switch (b) {
            case 0:
                MutableState mutableState = (MutableState) obj4;
                ResultKt.throwOnFailure(obj);
                if (!((ReorderableLazyListState) this.$reorderableState).isAnyItemDragging() && (pair = (Pair) mutableState.getValue()) != null) {
                    PlayerConnection playerConnection = (PlayerConnection) obj3;
                    MutableState mutableState2 = (MutableState) obj2;
                    int iIntValue = ((Number) pair.first).intValue();
                    int iIntValue2 = ((Number) pair.second).intValue();
                    int iCoerceIn = UuidKt.coerceIn(iIntValue - 1, 0, CollectionsKt__IterablesKt.getLastIndex((List) mutableState2.getValue()));
                    int iCoerceIn2 = UuidKt.coerceIn(iIntValue2 - 1, 0, CollectionsKt__IterablesKt.getLastIndex((List) mutableState2.getValue()));
                    ExoPlayerImpl playerSafe = playerConnection.getPlayerSafe();
                    playerSafe.verifyApplicationThread();
                    if (playerSafe.shuffleModeEnabled) {
                        ExoPlayerImpl playerSafe2 = playerConnection.getPlayerSafe();
                        List list = (List) mutableState2.getValue();
                        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            arrayList.add(new Integer(((Timeline.Window) it.next()).firstPeriodIndex));
                        }
                        ArrayList arrayList2 = new ArrayList(arrayList);
                        arrayList2.add(iCoerceIn2, arrayList2.remove(iCoerceIn));
                        playerSafe2.setShuffleOrder(new ShuffleOrder$DefaultShuffleOrder(CollectionsKt.toIntArray(arrayList2), System.currentTimeMillis()));
                    } else {
                        playerConnection.getPlayerSafe().moveMediaItem(iCoerceIn, iCoerceIn2);
                    }
                    mutableState.setValue(null);
                }
                return unit;
            case 1:
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.$reorderableState;
                PointerInputScope pointerInputScope = (PointerInputScope) obj4;
                CoreTextFieldKt$TextFieldCursorHandle$2$1$1$1 coreTextFieldKt$TextFieldCursorHandle$2$1$1$1 = new CoreTextFieldKt$TextFieldCursorHandle$2$1$1$1(pointerInputScope, (TextDragObserver) obj2, continuation, objArr == true ? 1 : 0);
                CoroutineStart coroutineStart = CoroutineStart.UNDISPATCHED;
                AwaitKt.launch$default(coroutineScope, null, coroutineStart, coreTextFieldKt$TextFieldCursorHandle$2$1$1$1, 1);
                AwaitKt.launch$default(coroutineScope, null, coroutineStart, new SliderState.AnonymousClass2(pointerInputScope, (TextFieldSelectionManager) obj3, continuation, (byte) 11), 1);
                return unit;
            case 2:
                CoroutineScope coroutineScope2 = (CoroutineScope) this.$reorderableState;
                ResultKt.throwOnFailure(obj);
                AwaitKt.launch$default(coroutineScope2, null, null, new ThumbnailKt$ThumbnailImage$1$1((Animatable) obj4, continuation, b2), 3);
                AwaitKt.launch$default(coroutineScope2, null, null, new ThumbnailKt$ThumbnailImage$1$1((Animatable) obj2, continuation, (byte) 3), 3);
                return AwaitKt.launch$default(coroutineScope2, null, null, new ThumbnailKt$ThumbnailImage$1$1((Animatable) obj3, continuation, (byte) 4), 3);
            case 3:
                MutableState mutableState3 = (MutableState) obj4;
                ResultKt.throwOnFailure(obj);
                if (!((ReorderableLazyListState) this.$reorderableState).isAnyItemDragging() && ((Boolean) mutableState3.getValue()).booleanValue()) {
                    ((Function1) obj2).invoke(CollectionsKt.toList((List) obj3));
                    mutableState3.setValue(Boolean.FALSE);
                }
                return unit;
            case 4:
                LyricsEntity lyricsEntity = (LyricsEntity) this.$reorderableState;
                ResultKt.throwOnFailure(obj);
                MutableState mutableState4 = (MutableState) obj4;
                if (!((List) mutableState4.getValue()).isEmpty() && lyricsEntity != null) {
                    StateFlowImpl stateFlowImpl = LyricsTranslationHelper._status;
                    LyricsTranslationHelper.loadTranslationsFromDatabase((List) mutableState4.getValue(), lyricsEntity, (String) ((DataStoreKt$rememberPreference$1$1) obj2).$state.getValue(), (String) ((DataStoreKt$rememberPreference$1$1) obj3).$state.getValue());
                }
                return unit;
            case 5:
                MutableState mutableState5 = (MutableState) obj4;
                ResultKt.throwOnFailure(obj);
                List list2 = (List) this.$reorderableState;
                if (!list2.isEmpty()) {
                    int i2 = OriginalLyricsKt.$r8$clinit;
                    if (((LyricsEntity) mutableState5.getValue()) != null) {
                        StateFlowImpl stateFlowImpl2 = LyricsTranslationHelper._status;
                        LyricsTranslationHelper.loadTranslationsFromDatabase(list2, (LyricsEntity) mutableState5.getValue(), (String) ((DataStoreKt$rememberPreference$1$1) obj2).$state.getValue(), (String) ((DataStoreKt$rememberPreference$1$1) obj3).$state.getValue());
                    }
                }
                return unit;
            case 6:
                ResultKt.throwOnFailure(obj);
                Toast.makeText((Context) this.$reorderableState, R.string.delete_uploaded_song_success, 0).show();
                Boolean bool = Boolean.FALSE;
                ((MutableState) obj4).setValue(bool);
                ((MutableState) obj2).setValue(bool);
                ((Function0) obj3).invoke();
                return unit;
            case 7:
                MutableState mutableState6 = (MutableState) obj4;
                ResultKt.throwOnFailure(obj);
                if (!((ReorderableLazyListState) this.$reorderableState).isAnyItemDragging() && (pair2 = (Pair) mutableState6.getValue()) != null) {
                    LocalPlaylistViewModel localPlaylistViewModel = (LocalPlaylistViewModel) obj2;
                    int iIntValue3 = ((Number) pair2.first).intValue();
                    int iIntValue4 = ((Number) pair2.second).intValue();
                    CloseableCoroutineScope viewModelScope = ViewModelKt.getViewModelScope(localPlaylistViewModel);
                    DefaultScheduler defaultScheduler = Dispatchers.Default;
                    AwaitKt.launch$default(viewModelScope, DefaultIoScheduler.INSTANCE, null, new Updater$getAllReleases$2((MusicDatabase) obj3, localPlaylistViewModel, iIntValue4, iIntValue3, null), 2);
                    mutableState6.setValue(null);
                }
                return unit;
            case 8:
                ResultKt.throwOnFailure(obj);
                MutableState mutableState7 = (MutableState) obj4;
                if (((DiscordUser) mutableState7.getValue()) != null) {
                    DiscordUser discordUser = (DiscordUser) mutableState7.getValue();
                    discordUser.getClass();
                    ((MutableState) obj2).setValue(discordUser.username);
                    MutableState mutableState8 = (MutableState) this.$reorderableState;
                    DiscordUser discordUser2 = (DiscordUser) mutableState7.getValue();
                    discordUser2.getClass();
                    mutableState8.setValue(discordUser2.name);
                    MutableState mutableState9 = (MutableState) obj3;
                    DiscordUser discordUser3 = (DiscordUser) mutableState7.getValue();
                    discordUser3.getClass();
                    String str = discordUser3.avatar;
                    mutableState9.setValue(str != null ? str : "");
                }
                return unit;
            case 9:
                ResultKt.throwOnFailure(obj);
                DiscordUser discordUser4 = (DiscordUser) this.$reorderableState;
                ((MutableState) obj4).setValue(discordUser4.username);
                ((MutableState) obj2).setValue(discordUser4.name);
                MutableState mutableState10 = (MutableState) obj3;
                String str2 = discordUser4.avatar;
                mutableState10.setValue(str2 != null ? str2 : "");
                return unit;
            case 10:
                String str3 = (String) obj3;
                ArtistItem artistItem = (ArtistItem) obj2;
                String str4 = artistItem.title;
                MusicDatabase musicDatabase = (MusicDatabase) this.$reorderableState;
                ResultKt.throwOnFailure(obj);
                ArtistEntity artistEntity = (ArtistEntity) obj4;
                if (artistEntity == null) {
                    String str5 = artistItem.id;
                    ArtistNameAliases artistNameAliases = ArtistNameAliases.INSTANCE;
                    ArtistEntity artistEntity2 = new ArtistEntity(str5, ArtistNameAliases.resolve(str5, str4), artistItem.thumbnail, (String) obj3, LocalDateTime.now(), false, null, 464);
                    musicDatabase.getClass();
                    musicDatabase.$$delegate_0.insert(artistEntity2);
                } else {
                    String str6 = artistEntity.channelId;
                    LocalDateTime localDateTimeNow = artistEntity.bookmarkedAt;
                    boolean z = str6 == null && str3 != null;
                    ArtistNameAliases artistNameAliases2 = ArtistNameAliases.INSTANCE;
                    String strResolve = ArtistNameAliases.resolve(artistEntity.id, str4);
                    if (localDateTimeNow == null || z || !Intrinsics.areEqual(artistEntity.name, strResolve) || !Intrinsics.areEqual(artistEntity.thumbnailUrl, artistItem.thumbnail)) {
                        String str7 = artistItem.thumbnail;
                        String str8 = str3 == null ? str6 : str3;
                        if (localDateTimeNow == null) {
                            localDateTimeNow = LocalDateTime.now();
                        }
                        LocalDateTime localDateTimeNow2 = LocalDateTime.now();
                        localDateTimeNow2.getClass();
                        ArtistEntity artistEntityCopy$default = ArtistEntity.copy$default(artistEntity, strResolve, str7, str8, localDateTimeNow2, localDateTimeNow, false, null, 449);
                        musicDatabase.getClass();
                        musicDatabase.$$delegate_0.update(artistEntityCopy$default);
                    }
                }
                return unit;
            case 11:
                MusicDatabase musicDatabase2 = (MusicDatabase) this.$reorderableState;
                ResultKt.throwOnFailure(obj);
                ArrayList arrayList3 = (ArrayList) obj4;
                int size = arrayList3.size();
                while (i < size) {
                    Object obj5 = arrayList3.get(i);
                    i++;
                    musicDatabase2.insert((MediaMetadata) obj5, new DatabaseDao$$ExternalSyntheticLambda0((byte) 0));
                }
                SyncUtils syncUtils = (SyncUtils) obj3;
                Iterator it2 = ((List) obj2).iterator();
                while (it2.hasNext()) {
                    syncUtils.database.update((PlaylistSongMap) it2.next());
                }
                return unit;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                SongItem songItem = (SongItem) obj2;
                MusicDatabase musicDatabase3 = (MusicDatabase) this.$reorderableState;
                ResultKt.throwOnFailure(obj);
                SongEntity songEntity = (SongEntity) obj4;
                if (songEntity == null) {
                    musicDatabase3.insert(HexFormatKt.toMediaMetadata(songItem), new InnerTubeXPlayer$$ExternalSyntheticLambda3((byte) 28));
                } else {
                    String str9 = songItem.id;
                    String str10 = songItem.uploadEntityId;
                    if (((Set) obj3).contains(str9)) {
                        musicDatabase3.insert(HexFormatKt.toMediaMetadata(songItem), new DatabaseDao$$ExternalSyntheticLambda0(objArr2 == true ? 1 : 0));
                    }
                    if (!songEntity.isUploaded) {
                        SongEntity songEntityCopy$default = SongEntity.copy$default(songEntity, null, 0, null, null, null, false, null, null, null, null, null, 0, false, true, false, songItem.uploadEntityId, 98566143);
                        musicDatabase3.getClass();
                        musicDatabase3.$$delegate_0.update(songEntityCopy$default);
                    } else if (!Intrinsics.areEqual(songEntity.uploadEntityId, str10) && str10 != null) {
                        SongEntity songEntityCopy$default2 = SongEntity.copy$default((SongEntity) obj4, null, 0, null, null, null, false, null, null, null, null, null, 0, false, false, false, str10, 100663295);
                        musicDatabase3.getClass();
                        musicDatabase3.$$delegate_0.update(songEntityCopy$default2);
                    }
                }
                return unit;
            default:
                CoroutineScope coroutineScope3 = (CoroutineScope) this.$reorderableState;
                ResultKt.throwOnFailure(obj);
                List<Artist> list3 = (List) obj4;
                List list4 = (List) obj3;
                ArrayList arrayList4 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10));
                for (Artist artist : list3) {
                    DefaultScheduler defaultScheduler2 = Dispatchers.Default;
                    arrayList4.add(AwaitKt.launch$default(coroutineScope3, DefaultIoScheduler.INSTANCE, null, new DataStoreKt$get$1((Object) artist, (Object) list4, continuation, (byte) 24), 2));
                }
                List<Song> list5 = (List) obj2;
                ArrayList arrayList5 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list5, 10));
                for (Song song : list5) {
                    DefaultScheduler defaultScheduler3 = Dispatchers.Default;
                    arrayList5.add(AwaitKt.launch$default(coroutineScope3, DefaultIoScheduler.INSTANCE, null, new HomeViewModel$getCommunityPlaylists$2$2$1(song, list4, null), 2));
                }
                return arrayList5;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QueueKt$Queue$5$1$1(Context context, Function0 function0, MutableState mutableState, MutableState mutableState2, Continuation continuation) {
        super(2, continuation);
        this.$r8$classId = (byte) 6;
        this.$reorderableState = context;
        this.$playerConnection = function0;
        this.$dragInfo$delegate = mutableState;
        this.$queueWindows$delegate = mutableState2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ QueueKt$Queue$5$1$1(Object obj, MutableState mutableState, Object obj2, Object obj3, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$reorderableState = obj;
        this.$dragInfo$delegate = mutableState;
        this.$queueWindows$delegate = obj2;
        this.$playerConnection = obj3;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ QueueKt$Queue$5$1$1(Object obj, Object obj2, Object obj3, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$dragInfo$delegate = obj;
        this.$queueWindows$delegate = obj2;
        this.$playerConnection = obj3;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QueueKt$Queue$5$1$1(ReorderableLazyListState reorderableLazyListState, MutableState mutableState, PlayerConnection playerConnection, MutableState mutableState2, Continuation continuation) {
        super(2, continuation);
        this.$r8$classId = (byte) 0;
        this.$reorderableState = reorderableLazyListState;
        this.$dragInfo$delegate = mutableState;
        this.$playerConnection = playerConnection;
        this.$queueWindows$delegate = mutableState2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QueueKt$Queue$5$1$1(ReorderableLazyListState reorderableLazyListState, Function1 function1, List list, MutableState mutableState, Continuation continuation) {
        super(2, continuation);
        this.$r8$classId = (byte) 3;
        this.$reorderableState = reorderableLazyListState;
        this.$queueWindows$delegate = function1;
        this.$playerConnection = list;
        this.$dragInfo$delegate = mutableState;
    }
}
