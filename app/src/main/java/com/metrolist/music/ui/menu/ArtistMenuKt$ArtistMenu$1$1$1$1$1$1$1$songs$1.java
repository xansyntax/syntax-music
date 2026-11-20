package com.metrolist.music.ui.menu;

import com.metrolist.music.constants.ArtistSongSortType;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Artist;
import com.metrolist.music.db.entities.Song;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlowKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ArtistMenuKt$ArtistMenu$1$1$1$1$1$1$1$songs$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ Artist $artist;
    public final /* synthetic */ MusicDatabase $database;
    public final /* synthetic */ byte $r8$classId;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ArtistMenuKt$ArtistMenu$1$1$1$1$1$1$1$songs$1(MusicDatabase musicDatabase, Artist artist, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$database = musicDatabase;
        this.$artist = artist;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        Artist artist = this.$artist;
        MusicDatabase musicDatabase = this.$database;
        switch (b) {
            case 0:
                return new ArtistMenuKt$ArtistMenu$1$1$1$1$1$1$1$songs$1(musicDatabase, artist, continuation, (byte) 0);
            default:
                return new ArtistMenuKt$ArtistMenu$1$1$1$1$1$1$1$songs$1(musicDatabase, artist, continuation, (byte) 1);
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
        return ((ArtistMenuKt$ArtistMenu$1$1$1$1$1$1$1$songs$1) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        ArtistSongSortType artistSongSortType = ArtistSongSortType.CREATE_DATE;
        Artist artist = this.$artist;
        MusicDatabase musicDatabase = this.$database;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        switch (b) {
            case 0:
                boolean z = this.label;
                if (!z) {
                    ResultKt.throwOnFailure(obj);
                    Flow flowArtistSongs = musicDatabase.artistSongs(artist.artist.id, artistSongSortType, true);
                    this.label = true;
                    obj = StateFlowKt.first(flowArtistSongs, this);
                    if (obj == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                Iterable iterable = (Iterable) obj;
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
                Iterator it = iterable.iterator();
                while (it.hasNext()) {
                    arrayList.add(UuidKt.toMediaItem((Song) it.next()));
                }
                return arrayList;
            default:
                boolean z2 = this.label;
                if (!z2) {
                    ResultKt.throwOnFailure(obj);
                    Flow flowArtistSongs2 = musicDatabase.artistSongs(artist.artist.id, artistSongSortType, true);
                    this.label = true;
                    obj = StateFlowKt.first(flowArtistSongs2, this);
                    if (obj == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                Iterable iterable2 = (Iterable) obj;
                ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable2, 10));
                Iterator it2 = iterable2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(UuidKt.toMediaItem((Song) it2.next()));
                }
                List mutableList = CollectionsKt.toMutableList((Iterable) arrayList2);
                Collections.shuffle(mutableList);
                return mutableList;
        }
    }
}
