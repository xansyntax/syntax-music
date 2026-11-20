package com.metrolist.music.viewmodels;

import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import com.metrolist.lrclib.LrcLib$getAllLyrics$$inlined$sortedByDescending$1;
import com.metrolist.music.constants.PlaylistSongSortType;
import com.metrolist.music.db.DatabaseDao$songs$lambda$0$$inlined$compareBy$1;
import com.metrolist.music.db.entities.Artist;
import com.metrolist.music.db.entities.PlaylistSong;
import com.metrolist.music.extensions.StringExtKt;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.text.Collator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ArtistViewModel$isChannelSubscribed$1 extends SuspendLambda implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public /* synthetic */ Object L$0;
    public /* synthetic */ Object L$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ArtistViewModel$isChannelSubscribed$1(int i, Continuation continuation, byte b) {
        super(i, continuation);
        this.$r8$classId = b;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        int i = 3;
        switch (b) {
            case 0:
                ArtistViewModel$isChannelSubscribed$1 artistViewModel$isChannelSubscribed$1 = new ArtistViewModel$isChannelSubscribed$1(i, (Continuation) obj3, (byte) 0);
                artistViewModel$isChannelSubscribed$1.L$0 = (Boolean) obj;
                artistViewModel$isChannelSubscribed$1.L$1 = (Artist) obj2;
                return artistViewModel$isChannelSubscribed$1.invokeSuspend(unit);
            case 1:
                ArtistViewModel$isChannelSubscribed$1 artistViewModel$isChannelSubscribed$2 = new ArtistViewModel$isChannelSubscribed$1(i, (Continuation) obj3, (byte) 1);
                artistViewModel$isChannelSubscribed$2.L$0 = (List) obj;
                artistViewModel$isChannelSubscribed$2.L$1 = (String) obj2;
                return artistViewModel$isChannelSubscribed$2.invokeSuspend(unit);
            default:
                ArtistViewModel$isChannelSubscribed$1 artistViewModel$isChannelSubscribed$3 = new ArtistViewModel$isChannelSubscribed$1(i, (Continuation) obj3, (byte) 2);
                artistViewModel$isChannelSubscribed$3.L$0 = (List) obj;
                artistViewModel$isChannelSubscribed$3.L$1 = (Triple) obj2;
                return artistViewModel$isChannelSubscribed$3.invokeSuspend(unit);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean z = true;
        int i = 0;
        switch (this.$r8$classId) {
            case 0:
                Boolean bool = (Boolean) this.L$0;
                Artist artist = (Artist) this.L$1;
                ResultKt.throwOnFailure(obj);
                if ((artist != null ? artist.artist.bookmarkedAt : null) == null && !Intrinsics.areEqual(bool, Boolean.TRUE)) {
                    z = false;
                }
                return Boolean.valueOf(z);
            case 1:
                List list = (List) this.L$0;
                String str = (String) this.L$1;
                ResultKt.throwOnFailure(obj);
                String strNormalizeForSearch = StringExtKt.normalizeForSearch(str);
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : list) {
                    if (StringExtKt.matchesNormalizedQuery(strNormalizeForSearch, ((Artist) obj2).artist.name)) {
                        arrayList.add(obj2);
                    }
                }
                HashSet hashSet = new HashSet();
                ArrayList arrayList2 = new ArrayList();
                int size = arrayList.size();
                while (i < size) {
                    Object obj3 = arrayList.get(i);
                    i++;
                    if (hashSet.add(((Artist) obj3).artist.id)) {
                        arrayList2.add(obj3);
                    }
                }
                return arrayList2;
            default:
                List listSortedWith = (List) this.L$0;
                Triple triple = (Triple) this.L$1;
                ResultKt.throwOnFailure(obj);
                PlaylistSongSortType playlistSongSortType = (PlaylistSongSortType) triple.first;
                boolean zBooleanValue = ((Boolean) triple.second).booleanValue();
                if (((Boolean) triple.third).booleanValue()) {
                    ArrayList arrayList3 = new ArrayList();
                    for (Object obj4 : listSortedWith) {
                        if (!((PlaylistSong) obj4).song.song.isVideo) {
                            arrayList3.add(obj4);
                        }
                    }
                    listSortedWith = arrayList3;
                }
                int iOrdinal = playlistSongSortType.ordinal();
                if (iOrdinal != 0) {
                    if (iOrdinal == 1) {
                        listSortedWith = CollectionsKt.sortedWith(listSortedWith, new LocalPlaylistViewModel$playlistSongs$2$invokeSuspend$$inlined$sortedBy$1((byte) 0));
                    } else if (iOrdinal == 2) {
                        listSortedWith = CollectionsKt.sortedWith(listSortedWith, new DatabaseDao$songs$lambda$0$$inlined$compareBy$1(Format$$ExternalSyntheticOutline0.m(0), (byte) 21));
                    } else if (iOrdinal == 3) {
                        Collator collatorM = Format$$ExternalSyntheticOutline0.m(0);
                        listSortedWith = CollectionsKt.sortedWith(listSortedWith, new LrcLib$getAllLyrics$$inlined$sortedByDescending$1(new DatabaseDao$songs$lambda$0$$inlined$compareBy$1(collatorM, (byte) 22), collatorM, (byte) 2));
                    } else {
                        if (iOrdinal != 4) {
                            PathKt$$ExternalSyntheticBUOutline0.m$1();
                            return null;
                        }
                        listSortedWith = CollectionsKt.sortedWith(listSortedWith, new LocalPlaylistViewModel$playlistSongs$2$invokeSuspend$$inlined$sortedBy$1((byte) 2));
                    }
                }
                return CollectionsKt__IterablesKt.reversed(listSortedWith, zBooleanValue && playlistSongSortType != PlaylistSongSortType.CUSTOM);
        }
    }
}
