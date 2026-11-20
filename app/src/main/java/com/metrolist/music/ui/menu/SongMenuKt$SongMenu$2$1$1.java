package com.metrolist.music.ui.menu;

import android.net.Uri;
import android.os.Bundle;
import androidx.compose.runtime.MutableState;
import androidx.media3.common.MediaItem;
import androidx.media3.exoplayer.ExoPlayerImpl;
import com.google.common.math.IntMath;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.pages.PlaylistPage;
import com.metrolist.innertubex.InnerTube$feedback$2;
import com.metrolist.music.db.DatabaseDao_Impl$$ExternalSyntheticLambda7;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.utils.SyncUtils;
import com.metrolist.music.utils.SyncUtils$executeSyncLikedSongs$2$1;
import com.metrolist.music.utils.SyncUtils$executeSyncLikedSongs$2$2$1$1;
import com.metrolist.music.utils.UtilsKt;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptySet;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.HexFormatKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlowKt;
import okhttp3.ConnectionPool;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SongMenuKt$SongMenu$2$1$1 extends SuspendLambda implements Function2 {
    public boolean $artistsChanged;
    public Object $database;
    public List $newArtistNames;
    public Object $newTitle;
    public Object $onDismiss;
    public Object $playerConnection;
    public final /* synthetic */ byte $r8$classId = 0;
    public final /* synthetic */ Object $showEditDialog$delegate;
    public Object $song;
    public byte label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SongMenuKt$SongMenu$2$1$1(MusicDatabase musicDatabase, Song song, PlayerConnection playerConnection, Function0 function0, String str, boolean z, List list, MutableState mutableState, Continuation continuation) {
        super(2, continuation);
        this.$database = musicDatabase;
        this.$song = song;
        this.$playerConnection = playerConnection;
        this.$onDismiss = function0;
        this.$newTitle = str;
        this.$artistsChanged = z;
        this.$newArtistNames = list;
        this.$showEditDialog$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        Object obj2 = this.$showEditDialog$delegate;
        switch (b) {
            case 0:
                return new SongMenuKt$SongMenu$2$1$1((MusicDatabase) this.$database, (Song) this.$song, (PlayerConnection) this.$playerConnection, (Function0) this.$onDismiss, (String) this.$newTitle, this.$artistsChanged, this.$newArtistNames, (MutableState) obj2, continuation);
            default:
                return new SongMenuKt$SongMenu$2$1$1((SyncUtils) obj2, continuation);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        CoroutineScope coroutineScope = (CoroutineScope) obj;
        Continuation continuation = (Continuation) obj2;
        switch (b) {
            case 0:
                break;
        }
        return ((SongMenuKt$SongMenu$2$1$1) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    /* JADX WARN: Code duplicated, block: B:106:0x0283  */
    /* JADX WARN: Code duplicated, block: B:108:0x0296  */
    /* JADX WARN: Code duplicated, block: B:110:0x02cd  */
    /* JADX WARN: Code duplicated, block: B:111:0x02d2  */
    /* JADX WARN: Code duplicated, block: B:114:0x02d9  */
    /* JADX WARN: Code duplicated, block: B:115:0x02dc  */
    /* JADX WARN: Code duplicated, block: B:118:0x02e9  */
    /* JADX WARN: Code duplicated, block: B:119:0x02ec  */
    /* JADX WARN: Code duplicated, block: B:122:0x02f6  */
    /* JADX WARN: Code duplicated, block: B:125:0x02ff  */
    /* JADX WARN: Code duplicated, block: B:140:0x0110 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:143:0x0316 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:147:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:148:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:32:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:34:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:38:0x00d9 A[Catch: Exception -> 0x00e8, LOOP:0: B:36:0x00d3->B:38:0x00d9, LOOP_END, TryCatch #0 {Exception -> 0x00e8, blocks: (B:35:0x00c2, B:36:0x00d3, B:38:0x00d9, B:40:0x00eb, B:42:0x00f5, B:44:0x0101, B:46:0x010d, B:47:0x0110, B:48:0x0115, B:50:0x011f, B:52:0x0125, B:58:0x0131, B:64:0x0165), top: B:132:0x00c2 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x00f5 A[Catch: Exception -> 0x00e8, TryCatch #0 {Exception -> 0x00e8, blocks: (B:35:0x00c2, B:36:0x00d3, B:38:0x00d9, B:40:0x00eb, B:42:0x00f5, B:44:0x0101, B:46:0x010d, B:47:0x0110, B:48:0x0115, B:50:0x011f, B:52:0x0125, B:58:0x0131, B:64:0x0165), top: B:132:0x00c2 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x0101 A[Catch: Exception -> 0x00e8, TryCatch #0 {Exception -> 0x00e8, blocks: (B:35:0x00c2, B:36:0x00d3, B:38:0x00d9, B:40:0x00eb, B:42:0x00f5, B:44:0x0101, B:46:0x010d, B:47:0x0110, B:48:0x0115, B:50:0x011f, B:52:0x0125, B:58:0x0131, B:64:0x0165), top: B:132:0x00c2 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x010d A[Catch: Exception -> 0x00e8, TryCatch #0 {Exception -> 0x00e8, blocks: (B:35:0x00c2, B:36:0x00d3, B:38:0x00d9, B:40:0x00eb, B:42:0x00f5, B:44:0x0101, B:46:0x010d, B:47:0x0110, B:48:0x0115, B:50:0x011f, B:52:0x0125, B:58:0x0131, B:64:0x0165), top: B:132:0x00c2 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x011e  */
    /* JADX WARN: Code duplicated, block: B:56:0x012e  */
    /* JADX WARN: Code duplicated, block: B:58:0x0131 A[Catch: Exception -> 0x00e8, TRY_LEAVE, TryCatch #0 {Exception -> 0x00e8, blocks: (B:35:0x00c2, B:36:0x00d3, B:38:0x00d9, B:40:0x00eb, B:42:0x00f5, B:44:0x0101, B:46:0x010d, B:47:0x0110, B:48:0x0115, B:50:0x011f, B:52:0x0125, B:58:0x0131, B:64:0x0165), top: B:132:0x00c2 }] */
    /* JADX WARN: Code duplicated, block: B:61:0x014f  */
    /* JADX WARN: Code duplicated, block: B:64:0x0165 A[Catch: Exception -> 0x00e8, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x00e8, blocks: (B:35:0x00c2, B:36:0x00d3, B:38:0x00d9, B:40:0x00eb, B:42:0x00f5, B:44:0x0101, B:46:0x010d, B:47:0x0110, B:48:0x0115, B:50:0x011f, B:52:0x0125, B:58:0x0131, B:64:0x0165), top: B:132:0x00c2 }] */
    /* JADX WARN: Code duplicated, block: B:69:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:71:0x01bc A[Catch: Exception -> 0x01d5, TRY_ENTER, TryCatch #2 {Exception -> 0x01d5, blocks: (B:11:0x003f, B:71:0x01bc, B:72:0x01c1), top: B:135:0x003f }] */
    /* JADX WARN: Code duplicated, block: B:76:0x01e1  */
    /* JADX WARN: Code duplicated, block: B:79:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:80:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:83:0x01fa  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws IOException {
        Object objFirst;
        Song song;
        PlayerConnection playerConnection;
        ExoPlayerImpl playerOrNull;
        MediaMetadata mediaMetadata;
        int mediaItemCount;
        int i;
        MediaItem mediaItemAt;
        MediaMetadata mediaMetadataWithResolvedArtistNameAliases;
        String str;
        Uri uri;
        MediaMetadata.Album album;
        String str2;
        MediaMetadata.Artist artist;
        String str3;
        Bundle bundle;
        Object objIsLoggedIn;
        Object objM1522withRetryBWLJW6A;
        int i2;
        Object obj2;
        Object obj3;
        List list;
        ArrayList arrayList;
        Iterator it;
        Set set;
        String str4;
        Integer intOrNull;
        boolean z;
        Set setIdsRemovedRemotely;
        Object obj4;
        Set set2;
        Object objLikedSongIds;
        StringBuilder sb;
        int length;
        int i3;
        char cCharAt;
        List list2;
        Set set3;
        MusicDatabase musicDatabase;
        SyncUtils$executeSyncLikedSongs$2$2$1$1 syncUtils$executeSyncLikedSongs$2$2$1$1;
        SyncUtils syncUtils;
        boolean z2;
        List list3;
        Set set4;
        byte b = this.$r8$classId;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i4 = 1;
        Object obj5 = this.$showEditDialog$delegate;
        Unit unit = Unit.INSTANCE;
        byte b2 = 0;
        Continuation continuation = null;
        switch (b) {
            case 0:
                Song song2 = (Song) this.$song;
                MusicDatabase musicDatabase2 = (MusicDatabase) this.$database;
                byte b3 = this.label;
                if (b3 != 0) {
                    if (b3 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        if (b3 != 2) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                        objFirst = obj;
                    }
                    song = (Song) objFirst;
                    if (song != null && (playerOrNull = (playerConnection = (PlayerConnection) this.$playerConnection).getPlayerOrNull()) != null) {
                        mediaMetadata = HexFormatKt.toMediaMetadata(song);
                        mediaItemCount = playerOrNull.getMediaItemCount();
                        for (i = 0; i < mediaItemCount; i++) {
                            mediaItemAt = playerOrNull.getMediaItemAt(i);
                            mediaItemAt.getClass();
                            if (Intrinsics.areEqual(mediaItemAt.mediaId, song.song.id)) {
                                mediaMetadataWithResolvedArtistNameAliases = UuidKt.withResolvedArtistNameAliases(mediaMetadata);
                                String strJoinToString$default = CollectionsKt.joinToString$default(mediaMetadataWithResolvedArtistNameAliases.artists, null, null, null, new DatabaseDao_Impl$$ExternalSyntheticLambda7((byte) 12), 31);
                                MediaItem.Builder builderBuildUpon = mediaItemAt.buildUpon();
                                builderBuildUpon.tag = mediaMetadataWithResolvedArtistNameAliases;
                                androidx.media3.common.MediaMetadata.Builder builderBuildUpon2 = mediaItemAt.mediaMetadata.buildUpon();
                                String str5 = mediaMetadataWithResolvedArtistNameAliases.title;
                                builderBuildUpon2.title = str5;
                                builderBuildUpon2.displayTitle = str5;
                                builderBuildUpon2.subtitle = strJoinToString$default;
                                builderBuildUpon2.artist = strJoinToString$default;
                                str = mediaMetadataWithResolvedArtistNameAliases.thumbnailUrl;
                                if (str != null) {
                                    uri = Uri.parse(str);
                                } else {
                                    uri = null;
                                }
                                builderBuildUpon2.artworkUri = uri;
                                album = mediaMetadataWithResolvedArtistNameAliases.album;
                                if (album != null) {
                                    str2 = album.title;
                                } else {
                                    str2 = null;
                                }
                                builderBuildUpon2.albumTitle = str2;
                                artist = (MediaMetadata.Artist) CollectionsKt.firstOrNull(mediaMetadataWithResolvedArtistNameAliases.artists);
                                if (artist != null) {
                                    str3 = artist.name;
                                } else {
                                    str3 = null;
                                }
                                builderBuildUpon2.albumArtist = str3;
                                bundle = new Bundle();
                                if (str != null) {
                                    bundle.putString("artwork_uri", str);
                                }
                                if (mediaMetadataWithResolvedArtistNameAliases.explicit) {
                                    bundle.putLong("android.media.IS_EXPLICIT", 1L);
                                }
                                builderBuildUpon2.extras = bundle;
                                builderBuildUpon.mediaMetadata = new androidx.media3.common.MediaMetadata(builderBuildUpon2);
                                playerOrNull.replaceMediaItem(i, builderBuildUpon.build());
                            }
                        }
                        playerConnection.mediaMetadata.setValue(IntMath.getCurrentMetadata(playerOrNull));
                    }
                    ((MutableState) obj5).setValue(Boolean.FALSE);
                    ((Function0) this.$onDismiss).invoke();
                    return unit;
                }
                ResultKt.throwOnFailure(obj);
                InnerTube$feedback$2 innerTube$feedback$2 = new InnerTube$feedback$2(song2, (String) this.$newTitle, this.$artistsChanged, this.$newArtistNames, (Continuation) null);
                this.label = (byte) 1;
                if (musicDatabase2.withTransaction(innerTube$feedback$2, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
                Flow flowSong = musicDatabase2.$$delegate_0.song(song2.song.id);
                this.label = (byte) 2;
                objFirst = StateFlowKt.first(flowSong, this);
                if (objFirst == coroutineSingletons) {
                    return coroutineSingletons;
                }
                song = (Song) objFirst;
                if (song != null) {
                    mediaMetadata = HexFormatKt.toMediaMetadata(song);
                    mediaItemCount = playerOrNull.getMediaItemCount();
                    while (i < mediaItemCount) {
                        mediaItemAt = playerOrNull.getMediaItemAt(i);
                        mediaItemAt.getClass();
                        if (Intrinsics.areEqual(mediaItemAt.mediaId, song.song.id)) {
                            mediaMetadataWithResolvedArtistNameAliases = UuidKt.withResolvedArtistNameAliases(mediaMetadata);
                            String strJoinToString$default2 = CollectionsKt.joinToString$default(mediaMetadataWithResolvedArtistNameAliases.artists, null, null, null, new DatabaseDao_Impl$$ExternalSyntheticLambda7((byte) 12), 31);
                            MediaItem.Builder builderBuildUpon3 = mediaItemAt.buildUpon();
                            builderBuildUpon3.tag = mediaMetadataWithResolvedArtistNameAliases;
                            androidx.media3.common.MediaMetadata.Builder builderBuildUpon4 = mediaItemAt.mediaMetadata.buildUpon();
                            String str6 = mediaMetadataWithResolvedArtistNameAliases.title;
                            builderBuildUpon4.title = str6;
                            builderBuildUpon4.displayTitle = str6;
                            builderBuildUpon4.subtitle = strJoinToString$default2;
                            builderBuildUpon4.artist = strJoinToString$default2;
                            str = mediaMetadataWithResolvedArtistNameAliases.thumbnailUrl;
                            if (str != null) {
                                uri = Uri.parse(str);
                            } else {
                                uri = null;
                            }
                            builderBuildUpon4.artworkUri = uri;
                            album = mediaMetadataWithResolvedArtistNameAliases.album;
                            if (album != null) {
                                str2 = album.title;
                            } else {
                                str2 = null;
                            }
                            builderBuildUpon4.albumTitle = str2;
                            artist = (MediaMetadata.Artist) CollectionsKt.firstOrNull(mediaMetadataWithResolvedArtistNameAliases.artists);
                            if (artist != null) {
                                str3 = artist.name;
                            } else {
                                str3 = null;
                            }
                            builderBuildUpon4.albumArtist = str3;
                            bundle = new Bundle();
                            if (str != null) {
                                bundle.putString("artwork_uri", str);
                            }
                            if (mediaMetadataWithResolvedArtistNameAliases.explicit) {
                                bundle.putLong("android.media.IS_EXPLICIT", 1L);
                            }
                            builderBuildUpon4.extras = bundle;
                            builderBuildUpon3.mediaMetadata = new androidx.media3.common.MediaMetadata(builderBuildUpon4);
                            playerOrNull.replaceMediaItem(i, builderBuildUpon3.build());
                        }
                    }
                    playerConnection.mediaMetadata.setValue(IntMath.getCurrentMetadata(playerOrNull));
                }
                ((MutableState) obj5).setValue(Boolean.FALSE);
                ((Function0) this.$onDismiss).invoke();
                return unit;
            default:
                SyncUtils syncUtils2 = (SyncUtils) obj5;
                byte b4 = this.label;
                if (b4 == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = (byte) 1;
                    int i5 = SyncUtils.$r8$clinit;
                    objIsLoggedIn = syncUtils2.isLoggedIn(this);
                    if (objIsLoggedIn == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else if (b4 == 1) {
                    ResultKt.throwOnFailure(obj);
                    objIsLoggedIn = obj;
                } else {
                    if (b4 == 2) {
                        ResultKt.throwOnFailure(obj);
                        objM1522withRetryBWLJW6A = ((Result) obj).value;
                        if (objM1522withRetryBWLJW6A instanceof Result.Failure) {
                            i2 = 0;
                        } else {
                            obj2 = ((Result) objM1522withRetryBWLJW6A).value;
                            if (obj2 instanceof Result.Failure) {
                                i2 = 0;
                            } else {
                                PlaylistPage playlistPage = (PlaylistPage) obj2;
                                try {
                                    list = playlistPage.songs;
                                    arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                                    it = list.iterator();
                                    while (it.hasNext()) {
                                        arrayList.add(((SongItem) it.next()).id);
                                    }
                                    set = CollectionsKt.toSet(arrayList);
                                    str4 = playlistPage.playlist.songCountText;
                                    if (str4 != null) {
                                        sb = new StringBuilder();
                                        length = str4.length();
                                        for (i3 = 0; i3 < length; i3++) {
                                            cCharAt = str4.charAt(i3);
                                            if (Character.isDigit(cCharAt)) {
                                                sb.append(cCharAt);
                                            }
                                        }
                                        intOrNull = StringsKt__StringsJVMKt.toIntOrNull(10, sb.toString());
                                    } else {
                                        intOrNull = null;
                                    }
                                    int size = list.size();
                                    if (intOrNull != null || size >= intOrNull.intValue()) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    if (z) {
                                        MusicDatabase musicDatabase3 = syncUtils2.database;
                                        this.$database = objM1522withRetryBWLJW6A;
                                        this.$song = syncUtils2;
                                        this.$playerConnection = obj2;
                                        this.$newArtistNames = list;
                                        this.$onDismiss = set;
                                        this.$artistsChanged = z;
                                        this.label = (byte) 3;
                                        objLikedSongIds = musicDatabase3.$$delegate_0.likedSongIds(this);
                                        if (objLikedSongIds == coroutineSingletons) {
                                            return coroutineSingletons;
                                        }
                                        obj4 = objM1522withRetryBWLJW6A;
                                        set2 = set;
                                        int i6 = SyncUtils.$r8$clinit;
                                        setIdsRemovedRemotely = UtilsKt.idsRemovedRemotely((Collection) objLikedSongIds, syncUtils2.readSyncSnapshot("sync_snapshot_liked_songs"), set2);
                                    } else {
                                        ConnectionPool connectionPool = Timber.Forest;
                                        list.size();
                                        connectionPool.getClass();
                                        ConnectionPool.w(new Object[0]);
                                        setIdsRemovedRemotely = EmptySet.INSTANCE;
                                        obj4 = objM1522withRetryBWLJW6A;
                                        set2 = set;
                                    }
                                    list2 = list;
                                    set3 = setIdsRemovedRemotely;
                                    int i7 = SyncUtils.$r8$clinit;
                                    Set setFindSongIdsWithoutArtists = syncUtils2.findSongIdsWithoutArtists(set2);
                                    LocalDateTime localDateTimeNow = LocalDateTime.now();
                                    musicDatabase = syncUtils2.database;
                                    syncUtils$executeSyncLikedSongs$2$2$1$1 = new SyncUtils$executeSyncLikedSongs$2$2$1$1(set3, list2, localDateTimeNow, setFindSongIdsWithoutArtists, null);
                                    this.$database = obj4;
                                    this.$song = syncUtils2;
                                    this.$playerConnection = obj2;
                                    this.$newArtistNames = list2;
                                    this.$onDismiss = set3;
                                    this.$newTitle = set2;
                                    this.$artistsChanged = z;
                                    this.label = (byte) 4;
                                    if (musicDatabase.withTransaction(syncUtils$executeSyncLikedSongs$2$2$1$1, this) == coroutineSingletons) {
                                        return coroutineSingletons;
                                    }
                                    syncUtils = syncUtils2;
                                    z2 = z;
                                    obj3 = obj4;
                                    list3 = list2;
                                    set4 = set3;
                                    if (z2) {
                                        int i8 = SyncUtils.$r8$clinit;
                                        syncUtils.writeSyncSnapshot("sync_snapshot_liked_songs", set2);
                                    }
                                    ConnectionPool connectionPool2 = Timber.Forest;
                                    list3.size();
                                    set4.size();
                                    connectionPool2.getClass();
                                    ConnectionPool.d(new Object[0]);
                                    i2 = 0;
                                    objM1522withRetryBWLJW6A = obj3;
                                } catch (Exception unused) {
                                    obj3 = objM1522withRetryBWLJW6A;
                                    i2 = 0;
                                    Timber.Forest.getClass();
                                    ConnectionPool.e$1(new Object[0]);
                                }
                            }
                            if (Result.m1866exceptionOrNullimpl(obj2) != null) {
                                Timber.Forest.getClass();
                                ConnectionPool.e$1(new Object[i2]);
                            }
                        }
                        if (Result.m1866exceptionOrNullimpl(objM1522withRetryBWLJW6A) != null) {
                            Timber.Forest.getClass();
                            ConnectionPool.e$1(new Object[i2]);
                        }
                        return unit;
                    }
                    if (b4 != 3) {
                        if (b4 != 4) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        z2 = this.$artistsChanged;
                        set2 = (Set) this.$newTitle;
                        set4 = (Set) this.$onDismiss;
                        list3 = this.$newArtistNames;
                        obj2 = this.$playerConnection;
                        syncUtils = (SyncUtils) this.$song;
                        obj3 = this.$database;
                        try {
                            ResultKt.throwOnFailure(obj);
                            if (z2) {
                                int i9 = SyncUtils.$r8$clinit;
                                syncUtils.writeSyncSnapshot("sync_snapshot_liked_songs", set2);
                            }
                            ConnectionPool connectionPool3 = Timber.Forest;
                            list3.size();
                            set4.size();
                            connectionPool3.getClass();
                            ConnectionPool.d(new Object[0]);
                            i2 = 0;
                        } catch (Exception unused2) {
                            i2 = 0;
                            Timber.Forest.getClass();
                            ConnectionPool.e$1(new Object[0]);
                        }
                        objM1522withRetryBWLJW6A = obj3;
                        if (Result.m1866exceptionOrNullimpl(obj2) != null) {
                            Timber.Forest.getClass();
                            ConnectionPool.e$1(new Object[i2]);
                        }
                        if (Result.m1866exceptionOrNullimpl(objM1522withRetryBWLJW6A) != null) {
                            Timber.Forest.getClass();
                            ConnectionPool.e$1(new Object[i2]);
                        }
                        return unit;
                    }
                    boolean z3 = this.$artistsChanged;
                    set2 = (Set) this.$onDismiss;
                    List list4 = this.$newArtistNames;
                    obj2 = this.$playerConnection;
                    SyncUtils syncUtils3 = (SyncUtils) this.$song;
                    obj4 = this.$database;
                    try {
                        ResultKt.throwOnFailure(obj);
                        z = z3;
                        syncUtils2 = syncUtils3;
                        list = list4;
                        objLikedSongIds = obj;
                        int i10 = SyncUtils.$r8$clinit;
                        setIdsRemovedRemotely = UtilsKt.idsRemovedRemotely((Collection) objLikedSongIds, syncUtils2.readSyncSnapshot("sync_snapshot_liked_songs"), set2);
                        list2 = list;
                        set3 = setIdsRemovedRemotely;
                        int i11 = SyncUtils.$r8$clinit;
                        Set setFindSongIdsWithoutArtists2 = syncUtils2.findSongIdsWithoutArtists(set2);
                        LocalDateTime localDateTimeNow2 = LocalDateTime.now();
                        musicDatabase = syncUtils2.database;
                        syncUtils$executeSyncLikedSongs$2$2$1$1 = new SyncUtils$executeSyncLikedSongs$2$2$1$1(set3, list2, localDateTimeNow2, setFindSongIdsWithoutArtists2, null);
                        this.$database = obj4;
                        this.$song = syncUtils2;
                        this.$playerConnection = obj2;
                        this.$newArtistNames = list2;
                        this.$onDismiss = set3;
                        this.$newTitle = set2;
                        this.$artistsChanged = z;
                        this.label = (byte) 4;
                        if (musicDatabase.withTransaction(syncUtils$executeSyncLikedSongs$2$2$1$1, this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                        syncUtils = syncUtils2;
                        z2 = z;
                        obj3 = obj4;
                        list3 = list2;
                        set4 = set3;
                        if (z2) {
                            int i12 = SyncUtils.$r8$clinit;
                            syncUtils.writeSyncSnapshot("sync_snapshot_liked_songs", set2);
                        }
                        ConnectionPool connectionPool4 = Timber.Forest;
                        list3.size();
                        set4.size();
                        connectionPool4.getClass();
                        ConnectionPool.d(new Object[0]);
                        i2 = 0;
                        objM1522withRetryBWLJW6A = obj3;
                        if (Result.m1866exceptionOrNullimpl(obj2) != null) {
                            Timber.Forest.getClass();
                            ConnectionPool.e$1(new Object[i2]);
                        }
                        if (Result.m1866exceptionOrNullimpl(objM1522withRetryBWLJW6A) != null) {
                            Timber.Forest.getClass();
                            ConnectionPool.e$1(new Object[i2]);
                        }
                        return unit;
                    } catch (Exception unused3) {
                        obj3 = obj4;
                        i2 = 0;
                        Timber.Forest.getClass();
                        ConnectionPool.e$1(new Object[0]);
                    }
                }
                if (((Boolean) objIsLoggedIn).booleanValue()) {
                    SyncUtils$executeSyncLikedSongs$2$1 syncUtils$executeSyncLikedSongs$2$1 = new SyncUtils$executeSyncLikedSongs$2$1(i4, continuation, b2);
                    this.label = (byte) 2;
                    int i13 = SyncUtils.$r8$clinit;
                    objM1522withRetryBWLJW6A = syncUtils2.m1522withRetryBWLJW6A(3, 1000L, syncUtils$executeSyncLikedSongs$2$1, this);
                    if (objM1522withRetryBWLJW6A == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    if (objM1522withRetryBWLJW6A instanceof Result.Failure) {
                        obj2 = ((Result) objM1522withRetryBWLJW6A).value;
                        if (obj2 instanceof Result.Failure) {
                            PlaylistPage playlistPage2 = (PlaylistPage) obj2;
                            list = playlistPage2.songs;
                            arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                            it = list.iterator();
                            while (it.hasNext()) {
                                arrayList.add(((SongItem) it.next()).id);
                            }
                            set = CollectionsKt.toSet(arrayList);
                            str4 = playlistPage2.playlist.songCountText;
                            if (str4 != null) {
                                sb = new StringBuilder();
                                length = str4.length();
                                while (i3 < length) {
                                    cCharAt = str4.charAt(i3);
                                    if (Character.isDigit(cCharAt)) {
                                        sb.append(cCharAt);
                                    }
                                }
                                intOrNull = StringsKt__StringsJVMKt.toIntOrNull(10, sb.toString());
                            } else {
                                intOrNull = null;
                            }
                            int size2 = list.size();
                            if (intOrNull != null) {
                                z = true;
                            } else {
                                z = true;
                            }
                            if (z) {
                                MusicDatabase musicDatabase4 = syncUtils2.database;
                                this.$database = objM1522withRetryBWLJW6A;
                                this.$song = syncUtils2;
                                this.$playerConnection = obj2;
                                this.$newArtistNames = list;
                                this.$onDismiss = set;
                                this.$artistsChanged = z;
                                this.label = (byte) 3;
                                objLikedSongIds = musicDatabase4.$$delegate_0.likedSongIds(this);
                                if (objLikedSongIds == coroutineSingletons) {
                                    return coroutineSingletons;
                                }
                                obj4 = objM1522withRetryBWLJW6A;
                                set2 = set;
                                int i14 = SyncUtils.$r8$clinit;
                                setIdsRemovedRemotely = UtilsKt.idsRemovedRemotely((Collection) objLikedSongIds, syncUtils2.readSyncSnapshot("sync_snapshot_liked_songs"), set2);
                            } else {
                                ConnectionPool connectionPool5 = Timber.Forest;
                                list.size();
                                connectionPool5.getClass();
                                ConnectionPool.w(new Object[0]);
                                setIdsRemovedRemotely = EmptySet.INSTANCE;
                                obj4 = objM1522withRetryBWLJW6A;
                                set2 = set;
                            }
                            list2 = list;
                            set3 = setIdsRemovedRemotely;
                            int i15 = SyncUtils.$r8$clinit;
                            Set setFindSongIdsWithoutArtists3 = syncUtils2.findSongIdsWithoutArtists(set2);
                            LocalDateTime localDateTimeNow3 = LocalDateTime.now();
                            musicDatabase = syncUtils2.database;
                            syncUtils$executeSyncLikedSongs$2$2$1$1 = new SyncUtils$executeSyncLikedSongs$2$2$1$1(set3, list2, localDateTimeNow3, setFindSongIdsWithoutArtists3, null);
                            this.$database = obj4;
                            this.$song = syncUtils2;
                            this.$playerConnection = obj2;
                            this.$newArtistNames = list2;
                            this.$onDismiss = set3;
                            this.$newTitle = set2;
                            this.$artistsChanged = z;
                            this.label = (byte) 4;
                            if (musicDatabase.withTransaction(syncUtils$executeSyncLikedSongs$2$2$1$1, this) == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                            syncUtils = syncUtils2;
                            z2 = z;
                            obj3 = obj4;
                            list3 = list2;
                            set4 = set3;
                            if (z2) {
                                int i16 = SyncUtils.$r8$clinit;
                                syncUtils.writeSyncSnapshot("sync_snapshot_liked_songs", set2);
                            }
                            ConnectionPool connectionPool6 = Timber.Forest;
                            list3.size();
                            set4.size();
                            connectionPool6.getClass();
                            ConnectionPool.d(new Object[0]);
                            i2 = 0;
                            objM1522withRetryBWLJW6A = obj3;
                        } else {
                            i2 = 0;
                        }
                        if (Result.m1866exceptionOrNullimpl(obj2) != null) {
                            Timber.Forest.getClass();
                            ConnectionPool.e$1(new Object[i2]);
                        }
                    } else {
                        i2 = 0;
                    }
                    if (Result.m1866exceptionOrNullimpl(objM1522withRetryBWLJW6A) != null) {
                        Timber.Forest.getClass();
                        ConnectionPool.e$1(new Object[i2]);
                    }
                } else {
                    Timber.Forest.getClass();
                    ConnectionPool.w(new Object[0]);
                }
                return unit;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SongMenuKt$SongMenu$2$1$1(SyncUtils syncUtils, Continuation continuation) {
        super(2, continuation);
        this.$showEditDialog$delegate = syncUtils;
    }
}
