package com.metrolist.music.ui.screens;

import com.metrolist.music.db.DatabaseDao$$ExternalSyntheticLambda0;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.db.entities.PlaylistEntity;
import com.metrolist.music.models.MediaMetadata;
import java.util.ArrayList;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class HomeScreenKt$CommunityPlaylistCard$1$3$5$1$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ MusicDatabase $database;
    public final /* synthetic */ PlaylistEntity $playlistEntity;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ ArrayList $songMetadata;
    public /* synthetic */ Object L$0;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HomeScreenKt$CommunityPlaylistCard$1$3$5$1$1$1(PlaylistEntity playlistEntity, ArrayList arrayList, MusicDatabase musicDatabase, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$playlistEntity = playlistEntity;
        this.$songMetadata = arrayList;
        this.$database = musicDatabase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                HomeScreenKt$CommunityPlaylistCard$1$3$5$1$1$1 homeScreenKt$CommunityPlaylistCard$1$3$5$1$1$1 = new HomeScreenKt$CommunityPlaylistCard$1$3$5$1$1$1(this.$playlistEntity, this.$songMetadata, this.$database, continuation, (byte) 0);
                homeScreenKt$CommunityPlaylistCard$1$3$5$1$1$1.L$0 = obj;
                return homeScreenKt$CommunityPlaylistCard$1$3$5$1$1$1;
            default:
                HomeScreenKt$CommunityPlaylistCard$1$3$5$1$1$1 homeScreenKt$CommunityPlaylistCard$1$3$5$1$1$2 = new HomeScreenKt$CommunityPlaylistCard$1$3$5$1$1$1(this.$playlistEntity, this.$songMetadata, this.$database, continuation, (byte) 1);
                homeScreenKt$CommunityPlaylistCard$1$3$5$1$1$2.L$0 = obj;
                return homeScreenKt$CommunityPlaylistCard$1$3$5$1$1$2;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        MusicDatabase musicDatabase = (MusicDatabase) obj;
        Continuation continuation = (Continuation) obj2;
        switch (b) {
            case 0:
                break;
        }
        return ((HomeScreenKt$CommunityPlaylistCard$1$3$5$1$1$1) create(musicDatabase, continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        PlaylistEntity playlistEntity = this.$playlistEntity;
        ArrayList arrayList = this.$songMetadata;
        MusicDatabase musicDatabase = this.$database;
        switch (b) {
            case 0:
                MusicDatabase musicDatabase2 = (MusicDatabase) this.L$0;
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
                musicDatabase2.insert(playlistEntity);
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj2 = arrayList.get(i);
                    i++;
                    musicDatabase2.insert((MediaMetadata) obj2, new DatabaseDao$$ExternalSyntheticLambda0((byte) 0));
                }
                ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
                int size2 = arrayList.size();
                int i2 = 0;
                while (i2 < size2) {
                    Object obj3 = arrayList.get(i2);
                    i2++;
                    MediaMetadata mediaMetadata = (MediaMetadata) obj3;
                    arrayList2.add(new Pair(mediaMetadata.id, mediaMetadata.setVideoId));
                }
                Playlist playlistPlaylistBlocking = musicDatabase.playlistBlocking(playlistEntity.id);
                if (playlistPlaylistBlocking == null) {
                    return unit;
                }
                this.L$0 = null;
                this.label = true;
                return musicDatabase2.addSongsToPlaylist(playlistPlaylistBlocking, arrayList2, false, this) == coroutineSingletons ? coroutineSingletons : unit;
            default:
                MusicDatabase musicDatabase3 = (MusicDatabase) this.L$0;
                boolean z2 = this.label;
                if (!z2) {
                    ResultKt.throwOnFailure(obj);
                    musicDatabase3.getClass();
                    musicDatabase3.$$delegate_0.insert(playlistEntity);
                    int size3 = arrayList.size();
                    int i3 = 0;
                    while (i3 < size3) {
                        Object obj4 = arrayList.get(i3);
                        i3++;
                        musicDatabase3.insert((MediaMetadata) obj4, new DatabaseDao$$ExternalSyntheticLambda0((byte) 0));
                    }
                    ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
                    int size4 = arrayList.size();
                    int i4 = 0;
                    while (i4 < size4) {
                        Object obj5 = arrayList.get(i4);
                        i4++;
                        MediaMetadata mediaMetadata2 = (MediaMetadata) obj5;
                        arrayList3.add(new Pair(mediaMetadata2.id, mediaMetadata2.setVideoId));
                    }
                    Playlist playlistPlaylistBlocking2 = musicDatabase.playlistBlocking(playlistEntity.id);
                    if (playlistPlaylistBlocking2 != null) {
                        this.L$0 = null;
                        this.label = true;
                        return musicDatabase.addSongsToPlaylist(playlistPlaylistBlocking2, arrayList3, false, this) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Failed to create playlist");
                } else {
                    if (z2) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                }
                return null;
        }
    }
}
