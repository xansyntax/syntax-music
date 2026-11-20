package com.metrolist.music.viewmodels;

import com.metrolist.innertube.models.Artist;
import com.metrolist.innertube.models.ArtistItem;
import com.metrolist.innertube.models.WatchEndpoint;
import com.metrolist.music.db.entities.Album;
import com.metrolist.music.db.entities.ArtistEntity;
import com.metrolist.music.db.entities.SongWithStats;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class StatsViewModel$filteredSongs$2 extends SuspendLambda implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public /* synthetic */ List L$0;
    public /* synthetic */ List L$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ StatsViewModel$filteredSongs$2(int i, Continuation continuation, byte b) {
        super(i, continuation);
        this.$r8$classId = b;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        byte b2 = 3;
        List list = (List) obj;
        List list2 = (List) obj2;
        Continuation continuation = (Continuation) obj3;
        switch (b) {
            case 0:
                StatsViewModel$filteredSongs$2 statsViewModel$filteredSongs$2 = new StatsViewModel$filteredSongs$2(b2, continuation, (byte) 0);
                statsViewModel$filteredSongs$2.L$0 = list;
                statsViewModel$filteredSongs$2.L$1 = list2;
                return statsViewModel$filteredSongs$2.invokeSuspend(unit);
            case 1:
                StatsViewModel$filteredSongs$2 statsViewModel$filteredSongs$3 = new StatsViewModel$filteredSongs$2(b2, continuation, (byte) 1);
                statsViewModel$filteredSongs$3.L$0 = list;
                statsViewModel$filteredSongs$3.L$1 = list2;
                return statsViewModel$filteredSongs$3.invokeSuspend(unit);
            case 2:
                StatsViewModel$filteredSongs$2 statsViewModel$filteredSongs$4 = new StatsViewModel$filteredSongs$2(b2, continuation, (byte) 2);
                statsViewModel$filteredSongs$4.L$0 = list;
                statsViewModel$filteredSongs$4.L$1 = list2;
                return statsViewModel$filteredSongs$4.invokeSuspend(unit);
            default:
                StatsViewModel$filteredSongs$2 statsViewModel$filteredSongs$5 = new StatsViewModel$filteredSongs$2(b2, continuation, b2);
                statsViewModel$filteredSongs$5.L$0 = list;
                statsViewModel$filteredSongs$5.L$1 = list2;
                return statsViewModel$filteredSongs$5.invokeSuspend(unit);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                List list = this.L$0;
                List list2 = this.L$1;
                ResultKt.throwOnFailure(obj);
                if (list2.isEmpty()) {
                    return list;
                }
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : list) {
                    List<ArtistEntity> list3 = ((SongWithStats) obj2).artists;
                    if (!list3.isEmpty()) {
                        for (ArtistEntity artistEntity : list3) {
                            if (!list2.isEmpty()) {
                                Iterator it = list2.iterator();
                                while (it.hasNext()) {
                                    if (Intrinsics.areEqual(((Artist) it.next()).id, artistEntity.id)) {
                                        arrayList.add(obj2);
                                    }
                                    break;
                                }
                            }
                        }
                    }
                }
                return arrayList;
            case 1:
                List list4 = this.L$0;
                List list5 = this.L$1;
                ResultKt.throwOnFailure(obj);
                ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list5, 10));
                Iterator it2 = list5.iterator();
                while (it2.hasNext()) {
                    ArtistEntity artistEntity2 = ((com.metrolist.music.db.entities.Artist) it2.next()).artist;
                    arrayList2.add(new ArtistItem(artistEntity2.id, artistEntity2.name, artistEntity2.thumbnailUrl, (String) null, (WatchEndpoint) null, (WatchEndpoint) null, (WatchEndpoint) null, 152));
                }
                ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list4, 10));
                Iterator it3 = list4.iterator();
                while (it3.hasNext()) {
                    arrayList3.add(((ArtistItem) it3.next()).id);
                }
                Set set = CollectionsKt.toSet(arrayList3);
                ArrayList arrayList4 = new ArrayList();
                int size = arrayList2.size();
                int i = 0;
                while (i < size) {
                    Object obj3 = arrayList2.get(i);
                    i++;
                    if (!set.contains(((ArtistItem) obj3).id)) {
                        arrayList4.add(obj3);
                    }
                }
                return CollectionsKt.plus((Iterable) arrayList4, (Collection) list4);
            case 2:
                List list6 = this.L$0;
                List list7 = this.L$1;
                ResultKt.throwOnFailure(obj);
                if (list7.isEmpty()) {
                    return list6;
                }
                ArrayList arrayList5 = new ArrayList();
                for (Object obj4 : list6) {
                    List<ArtistEntity> list8 = ((Album) obj4).artists;
                    if (list8 == null || !list8.isEmpty()) {
                        for (ArtistEntity artistEntity3 : list8) {
                            if (!list7.isEmpty()) {
                                Iterator it4 = list7.iterator();
                                while (it4.hasNext()) {
                                    if (Intrinsics.areEqual(((Artist) it4.next()).id, artistEntity3.id)) {
                                        arrayList5.add(obj4);
                                    }
                                    break;
                                }
                            }
                        }
                    }
                }
                return arrayList5;
            default:
                List list9 = this.L$0;
                List list10 = this.L$1;
                ResultKt.throwOnFailure(obj);
                if (list10.isEmpty()) {
                    return list9;
                }
                ArrayList arrayList6 = new ArrayList();
                for (Object obj5 : list9) {
                    com.metrolist.music.db.entities.Artist artist = (com.metrolist.music.db.entities.Artist) obj5;
                    if (!list10.isEmpty()) {
                        Iterator it5 = list10.iterator();
                        while (it5.hasNext()) {
                            if (Intrinsics.areEqual(((Artist) it5.next()).id, artist.artist.id)) {
                                arrayList6.add(obj5);
                            }
                            break;
                        }
                    }
                }
                return arrayList6;
        }
    }
}
