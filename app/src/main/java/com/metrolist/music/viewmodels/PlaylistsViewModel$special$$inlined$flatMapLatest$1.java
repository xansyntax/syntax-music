package com.metrolist.music.viewmodels;

import com.metrolist.music.constants.AlbumFilter;
import com.metrolist.music.constants.AlbumSortType;
import com.metrolist.music.constants.ArtistFilter;
import com.metrolist.music.constants.ArtistSortType;
import com.metrolist.music.constants.PlaylistSortType;
import com.metrolist.music.constants.SongFilter;
import com.metrolist.music.constants.SongSortType;
import com.metrolist.music.db.DatabaseDao;
import com.metrolist.music.db.DatabaseDao$songs$$inlined$map$3;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.playback.DownloadUtil$getDownload$$inlined$map$1;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$unsafeFlow$1;
import kotlinx.coroutines.flow.FlowKt__ZipKt$combine$1$1;
import kotlinx.coroutines.flow.SafeFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.flow.ThrowingCollector;
import kotlinx.coroutines.flow.internal.CombineKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PlaylistsViewModel$special$$inlined$flatMapLatest$1 extends SuspendLambda implements Function3 {
    public final /* synthetic */ MusicDatabase $database$inlined;
    public final /* synthetic */ byte $r8$classId;
    public /* synthetic */ FlowCollector L$0;
    public /* synthetic */ Object L$1;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PlaylistsViewModel$special$$inlined$flatMapLatest$1(Continuation continuation, MusicDatabase musicDatabase, byte b) {
        super(3, continuation);
        this.$r8$classId = b;
        this.$database$inlined = musicDatabase;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        MusicDatabase musicDatabase = this.$database$inlined;
        FlowCollector flowCollector = (FlowCollector) obj;
        Continuation continuation = (Continuation) obj3;
        switch (b) {
            case 0:
                PlaylistsViewModel$special$$inlined$flatMapLatest$1 playlistsViewModel$special$$inlined$flatMapLatest$1 = new PlaylistsViewModel$special$$inlined$flatMapLatest$1(continuation, musicDatabase, (byte) 0);
                playlistsViewModel$special$$inlined$flatMapLatest$1.L$0 = flowCollector;
                playlistsViewModel$special$$inlined$flatMapLatest$1.L$1 = obj2;
                return playlistsViewModel$special$$inlined$flatMapLatest$1.invokeSuspend(unit);
            case 1:
                PlaylistsViewModel$special$$inlined$flatMapLatest$1 playlistsViewModel$special$$inlined$flatMapLatest$2 = new PlaylistsViewModel$special$$inlined$flatMapLatest$1(continuation, musicDatabase, (byte) 1);
                playlistsViewModel$special$$inlined$flatMapLatest$2.L$0 = flowCollector;
                playlistsViewModel$special$$inlined$flatMapLatest$2.L$1 = obj2;
                return playlistsViewModel$special$$inlined$flatMapLatest$2.invokeSuspend(unit);
            case 2:
                PlaylistsViewModel$special$$inlined$flatMapLatest$1 playlistsViewModel$special$$inlined$flatMapLatest$3 = new PlaylistsViewModel$special$$inlined$flatMapLatest$1(continuation, musicDatabase, (byte) 2);
                playlistsViewModel$special$$inlined$flatMapLatest$3.L$0 = flowCollector;
                playlistsViewModel$special$$inlined$flatMapLatest$3.L$1 = obj2;
                return playlistsViewModel$special$$inlined$flatMapLatest$3.invokeSuspend(unit);
            case 3:
                PlaylistsViewModel$special$$inlined$flatMapLatest$1 playlistsViewModel$special$$inlined$flatMapLatest$4 = new PlaylistsViewModel$special$$inlined$flatMapLatest$1(continuation, musicDatabase, (byte) 3);
                playlistsViewModel$special$$inlined$flatMapLatest$4.L$0 = flowCollector;
                playlistsViewModel$special$$inlined$flatMapLatest$4.L$1 = obj2;
                return playlistsViewModel$special$$inlined$flatMapLatest$4.invokeSuspend(unit);
            case 4:
                PlaylistsViewModel$special$$inlined$flatMapLatest$1 playlistsViewModel$special$$inlined$flatMapLatest$5 = new PlaylistsViewModel$special$$inlined$flatMapLatest$1(continuation, musicDatabase, (byte) 4);
                playlistsViewModel$special$$inlined$flatMapLatest$5.L$0 = flowCollector;
                playlistsViewModel$special$$inlined$flatMapLatest$5.L$1 = obj2;
                return playlistsViewModel$special$$inlined$flatMapLatest$5.invokeSuspend(unit);
            case 5:
                PlaylistsViewModel$special$$inlined$flatMapLatest$1 playlistsViewModel$special$$inlined$flatMapLatest$6 = new PlaylistsViewModel$special$$inlined$flatMapLatest$1(continuation, musicDatabase, (byte) 5);
                playlistsViewModel$special$$inlined$flatMapLatest$6.L$0 = flowCollector;
                playlistsViewModel$special$$inlined$flatMapLatest$6.L$1 = obj2;
                return playlistsViewModel$special$$inlined$flatMapLatest$6.invokeSuspend(unit);
            case 6:
                PlaylistsViewModel$special$$inlined$flatMapLatest$1 playlistsViewModel$special$$inlined$flatMapLatest$7 = new PlaylistsViewModel$special$$inlined$flatMapLatest$1(continuation, musicDatabase, (byte) 6);
                playlistsViewModel$special$$inlined$flatMapLatest$7.L$0 = flowCollector;
                playlistsViewModel$special$$inlined$flatMapLatest$7.L$1 = obj2;
                return playlistsViewModel$special$$inlined$flatMapLatest$7.invokeSuspend(unit);
            case 7:
                PlaylistsViewModel$special$$inlined$flatMapLatest$1 playlistsViewModel$special$$inlined$flatMapLatest$8 = new PlaylistsViewModel$special$$inlined$flatMapLatest$1(continuation, musicDatabase, (byte) 7);
                playlistsViewModel$special$$inlined$flatMapLatest$8.L$0 = flowCollector;
                playlistsViewModel$special$$inlined$flatMapLatest$8.L$1 = obj2;
                return playlistsViewModel$special$$inlined$flatMapLatest$8.invokeSuspend(unit);
            default:
                PlaylistsViewModel$special$$inlined$flatMapLatest$1 playlistsViewModel$special$$inlined$flatMapLatest$9 = new PlaylistsViewModel$special$$inlined$flatMapLatest$1(continuation, musicDatabase, (byte) 8);
                playlistsViewModel$special$$inlined$flatMapLatest$9.L$0 = flowCollector;
                playlistsViewModel$special$$inlined$flatMapLatest$9.L$1 = obj2;
                return playlistsViewModel$special$$inlined$flatMapLatest$9.invokeSuspend(unit);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        DatabaseDao$songs$$inlined$map$3 databaseDao$songs$$inlined$map$3;
        Flow flowArtists;
        ArtistSongsViewModel$songs$lambda$1$$inlined$map$1 artistSongsViewModel$songs$lambda$1$$inlined$map$1;
        Flow downloadUtil$getDownload$$inlined$map$1;
        Flow flowSearchAlbums;
        Flow flowKt__ZipKt$combine$$inlined$unsafeFlow$1;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        MusicDatabase musicDatabase = this.$database$inlined;
        switch (b) {
            case 0:
                FlowCollector flowCollector = this.L$0;
                Object obj2 = this.L$1;
                boolean z = this.label;
                if (z) {
                    if (z) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                Pair pair = (Pair) obj2;
                Flow flowPlaylists = musicDatabase.playlists((PlaylistSortType) pair.first, ((Boolean) pair.second).booleanValue());
                this.L$0 = null;
                this.L$1 = null;
                this.label = true;
                return StateFlowKt.emitAll(flowCollector, flowPlaylists, this) == coroutineSingletons ? coroutineSingletons : unit;
            case 1:
                FlowCollector flowCollector2 = this.L$0;
                Object obj3 = this.L$1;
                boolean z2 = this.label;
                if (!z2) {
                    ResultKt.throwOnFailure(obj);
                    Pair pair2 = (Pair) obj3;
                    Triple triple = (Triple) pair2.first;
                    boolean zBooleanValue = ((Boolean) pair2.second).booleanValue();
                    AlbumFilter albumFilter = (AlbumFilter) triple.first;
                    AlbumSortType albumSortType = (AlbumSortType) triple.second;
                    boolean zBooleanValue2 = ((Boolean) triple.third).booleanValue();
                    int iOrdinal = albumFilter.ordinal();
                    if (iOrdinal == 0) {
                        databaseDao$songs$$inlined$map$3 = new DatabaseDao$songs$$inlined$map$3(musicDatabase.albums(albumSortType, zBooleanValue2), zBooleanValue, (byte) 15);
                    } else if (iOrdinal == 1) {
                        databaseDao$songs$$inlined$map$3 = new DatabaseDao$songs$$inlined$map$3(musicDatabase.albumsLiked(albumSortType, zBooleanValue2), zBooleanValue, (byte) 14);
                    } else if (iOrdinal == 2) {
                        databaseDao$songs$$inlined$map$3 = new DatabaseDao$songs$$inlined$map$3(musicDatabase.albumsUploaded(albumSortType, zBooleanValue2), zBooleanValue, (byte) 16);
                    } else {
                        PathKt$$ExternalSyntheticBUOutline0.m$1();
                    }
                    this.L$0 = null;
                    this.L$1 = null;
                    this.label = true;
                    return StateFlowKt.emitAll(flowCollector2, databaseDao$songs$$inlined$map$3, this) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (z2) {
                    ResultKt.throwOnFailure(obj);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 2:
                FlowCollector flowCollector3 = this.L$0;
                Object obj4 = this.L$1;
                boolean z3 = this.label;
                if (!z3) {
                    ResultKt.throwOnFailure(obj);
                    Triple triple2 = (Triple) obj4;
                    ArtistFilter artistFilter = (ArtistFilter) triple2.first;
                    ArtistSortType artistSortType = (ArtistSortType) triple2.second;
                    boolean zBooleanValue3 = ((Boolean) triple2.third).booleanValue();
                    int iOrdinal2 = artistFilter.ordinal();
                    if (iOrdinal2 == 0) {
                        flowArtists = musicDatabase.artists(artistSortType, zBooleanValue3);
                    } else if (iOrdinal2 == 1) {
                        flowArtists = musicDatabase.artistsBookmarked(artistSortType, zBooleanValue3);
                    } else {
                        PathKt$$ExternalSyntheticBUOutline0.m$1();
                    }
                    this.L$0 = null;
                    this.L$1 = null;
                    this.label = true;
                    return StateFlowKt.emitAll(flowCollector3, flowArtists, this) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (z3) {
                    ResultKt.throwOnFailure(obj);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 3:
                FlowCollector flowCollector4 = this.L$0;
                Object obj5 = this.L$1;
                boolean z4 = this.label;
                if (z4) {
                    if (z4) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                boolean zBooleanValue4 = ((Boolean) obj5).booleanValue();
                musicDatabase.getClass();
                DatabaseDao$songs$$inlined$map$3 databaseDao$songs$$inlined$map$4 = new DatabaseDao$songs$$inlined$map$3(musicDatabase.$$delegate_0.albumsLiked(AlbumSortType.CREATE_DATE, true), zBooleanValue4, (byte) 17);
                this.L$0 = null;
                this.L$1 = null;
                this.label = true;
                return StateFlowKt.emitAll(flowCollector4, databaseDao$songs$$inlined$map$4, this) == coroutineSingletons ? coroutineSingletons : unit;
            case 4:
                FlowCollector flowCollector5 = this.L$0;
                Object obj6 = this.L$1;
                boolean z5 = this.label;
                if (z5) {
                    if (z5) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                Triple triple3 = (Triple) obj6;
                boolean zBooleanValue5 = ((Boolean) triple3.first).booleanValue();
                boolean zBooleanValue6 = ((Boolean) triple3.second).booleanValue();
                musicDatabase.getClass();
                DatabaseDao databaseDao = musicDatabase.$$delegate_0;
                Flow flowSongs = databaseDao.songs(SongSortType.CREATE_DATE, true);
                Flow flowSongsInBookmarkedPlaylists = databaseDao.songsInBookmarkedPlaylists();
                LibraryMixViewModel$songs$2$1 libraryMixViewModel$songs$2$1 = new LibraryMixViewModel$songs$2$1(zBooleanValue5, zBooleanValue6, null);
                this.L$0 = null;
                this.L$1 = null;
                this.label = true;
                if (flowCollector5 instanceof ThrowingCollector) {
                    throw ((ThrowingCollector) flowCollector5).e;
                }
                Object objCombineInternal = CombineKt.combineInternal(this, new FlowKt__ZipKt$combine$1$1(libraryMixViewModel$songs$2$1, (Continuation) null, (byte) 0), flowCollector5, new Flow[]{flowSongs, flowSongsInBookmarkedPlaylists});
                if (objCombineInternal != coroutineSingletons) {
                    objCombineInternal = unit;
                }
                if (objCombineInternal != coroutineSingletons) {
                    objCombineInternal = unit;
                }
                return objCombineInternal == coroutineSingletons ? coroutineSingletons : unit;
            case 5:
                FlowCollector flowCollector6 = this.L$0;
                Object obj7 = this.L$1;
                boolean z6 = this.label;
                if (z6) {
                    if (z6) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                boolean zBooleanValue7 = ((Boolean) obj7).booleanValue();
                musicDatabase.getClass();
                DatabaseDao$songs$$inlined$map$3 databaseDao$songs$$inlined$map$5 = new DatabaseDao$songs$$inlined$map$3(musicDatabase.$$delegate_0.playlists(PlaylistSortType.CREATE_DATE, true), zBooleanValue7, (byte) 18);
                this.L$0 = null;
                this.L$1 = null;
                this.label = true;
                return StateFlowKt.emitAll(flowCollector6, databaseDao$songs$$inlined$map$5, this) == coroutineSingletons ? coroutineSingletons : unit;
            case 6:
                FlowCollector flowCollector7 = this.L$0;
                Object obj8 = this.L$1;
                boolean z7 = this.label;
                if (z7) {
                    if (z7) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                Triple triple4 = (Triple) obj8;
                DatabaseDao$songs$$inlined$map$3 databaseDao$songs$$inlined$map$6 = new DatabaseDao$songs$$inlined$map$3(musicDatabase.playlists((PlaylistSortType) triple4.first, ((Boolean) triple4.second).booleanValue()), ((Boolean) triple4.third).booleanValue(), (byte) 19);
                this.L$0 = null;
                this.L$1 = null;
                this.label = true;
                return StateFlowKt.emitAll(flowCollector7, databaseDao$songs$$inlined$map$6, this) == coroutineSingletons ? coroutineSingletons : unit;
            case 7:
                FlowCollector flowCollector8 = this.L$0;
                Object obj9 = this.L$1;
                boolean z8 = this.label;
                if (!z8) {
                    ResultKt.throwOnFailure(obj);
                    Triple triple5 = (Triple) obj9;
                    Triple triple6 = (Triple) triple5.first;
                    boolean zBooleanValue8 = ((Boolean) triple5.second).booleanValue();
                    boolean zBooleanValue9 = ((Boolean) triple5.third).booleanValue();
                    SongFilter songFilter = (SongFilter) triple6.first;
                    SongSortType songSortType = (SongSortType) triple6.second;
                    boolean zBooleanValue10 = ((Boolean) triple6.third).booleanValue();
                    int iOrdinal3 = songFilter.ordinal();
                    if (iOrdinal3 == 0) {
                        artistSongsViewModel$songs$lambda$1$$inlined$map$1 = new ArtistSongsViewModel$songs$lambda$1$$inlined$map$1(musicDatabase.songs(songSortType, zBooleanValue10), zBooleanValue8, zBooleanValue9, (byte) 5);
                    } else if (iOrdinal3 == 1) {
                        artistSongsViewModel$songs$lambda$1$$inlined$map$1 = new ArtistSongsViewModel$songs$lambda$1$$inlined$map$1(musicDatabase.likedSongs(songSortType, zBooleanValue10), zBooleanValue8, zBooleanValue9, (byte) 6);
                    } else if (iOrdinal3 == 2) {
                        artistSongsViewModel$songs$lambda$1$$inlined$map$1 = new ArtistSongsViewModel$songs$lambda$1$$inlined$map$1(musicDatabase.downloadedSongs(songSortType, zBooleanValue10), zBooleanValue8, zBooleanValue9, (byte) 7);
                    } else if (iOrdinal3 == 3) {
                        artistSongsViewModel$songs$lambda$1$$inlined$map$1 = new ArtistSongsViewModel$songs$lambda$1$$inlined$map$1(musicDatabase.uploadedSongs(songSortType, zBooleanValue10), zBooleanValue8, zBooleanValue9, (byte) 8);
                    } else {
                        PathKt$$ExternalSyntheticBUOutline0.m$1();
                    }
                    this.L$0 = null;
                    this.L$1 = null;
                    this.label = true;
                    return StateFlowKt.emitAll(flowCollector8, artistSongsViewModel$songs$lambda$1$$inlined$map$1, this) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (z8) {
                    ResultKt.throwOnFailure(obj);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            default:
                FlowCollector flowCollector9 = this.L$0;
                Object obj10 = this.L$1;
                boolean z9 = this.label;
                if (!z9) {
                    ResultKt.throwOnFailure(obj);
                    Triple triple7 = (Triple) obj10;
                    String str = (String) triple7.first;
                    LocalFilter localFilter = (LocalFilter) triple7.second;
                    boolean zBooleanValue11 = ((Boolean) triple7.third).booleanValue();
                    if (str.length() == 0) {
                        flowKt__ZipKt$combine$$inlined$unsafeFlow$1 = new SafeFlow((byte) 4, new LocalSearchResult("", localFilter, EmptyMap.INSTANCE));
                    } else {
                        int iOrdinal4 = localFilter.ordinal();
                        if (iOrdinal4 != 0) {
                            if (iOrdinal4 == 1) {
                                musicDatabase.getClass();
                                downloadUtil$getDownload$$inlined$map$1 = new DatabaseDao$songs$$inlined$map$3(musicDatabase.$$delegate_0.searchSongs(Integer.MAX_VALUE, str), zBooleanValue11, (byte) 22);
                            } else if (iOrdinal4 == 2) {
                                musicDatabase.getClass();
                                flowSearchAlbums = musicDatabase.$$delegate_0.searchAlbums(Integer.MAX_VALUE, str);
                            } else if (iOrdinal4 == 3) {
                                musicDatabase.getClass();
                                flowSearchAlbums = musicDatabase.$$delegate_0.searchArtists(Integer.MAX_VALUE, str);
                            } else if (iOrdinal4 == 4) {
                                flowSearchAlbums = musicDatabase.searchPlaylists(Integer.MAX_VALUE, str);
                            } else {
                                PathKt$$ExternalSyntheticBUOutline0.m$1();
                            }
                            flowKt__ZipKt$combine$$inlined$unsafeFlow$1 = new FlowKt__ZipKt$combine$$inlined$unsafeFlow$1(flowSearchAlbums, str, localFilter, (byte) 2);
                        } else {
                            musicDatabase.getClass();
                            DatabaseDao databaseDao2 = musicDatabase.$$delegate_0;
                            downloadUtil$getDownload$$inlined$map$1 = new DownloadUtil$getDownload$$inlined$map$1(new Flow[]{databaseDao2.searchSongs(3, str), databaseDao2.searchAlbums(3, str), databaseDao2.searchArtists(3, str), databaseDao2.searchPlaylists(3, str)}, new LocalSearchViewModel$result$3$1(zBooleanValue11, null), (byte) 10);
                        }
                        flowSearchAlbums = downloadUtil$getDownload$$inlined$map$1;
                        flowKt__ZipKt$combine$$inlined$unsafeFlow$1 = new FlowKt__ZipKt$combine$$inlined$unsafeFlow$1(flowSearchAlbums, str, localFilter, (byte) 2);
                    }
                    this.L$0 = null;
                    this.L$1 = null;
                    this.label = true;
                    return StateFlowKt.emitAll(flowCollector9, flowKt__ZipKt$combine$$inlined$unsafeFlow$1, this) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (z9) {
                    ResultKt.throwOnFailure(obj);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
        }
    }
}
