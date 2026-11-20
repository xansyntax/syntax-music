package com.metrolist.music.viewmodels;

import com.metrolist.music.db.entities.Album;
import com.metrolist.music.db.entities.Artist;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.db.entities.Song;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function5;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LocalSearchViewModel$result$3$1 extends SuspendLambda implements Function5 {
    public final /* synthetic */ boolean $hideVideoSongs;
    public /* synthetic */ List L$0;
    public /* synthetic */ List L$1;
    public /* synthetic */ List L$2;
    public /* synthetic */ List L$3;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalSearchViewModel$result$3$1(boolean z, Continuation continuation) {
        super(5, continuation);
        this.$hideVideoSongs = z;
    }

    @Override // kotlin.jvm.functions.Function5
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        LocalSearchViewModel$result$3$1 localSearchViewModel$result$3$1 = new LocalSearchViewModel$result$3$1(this.$hideVideoSongs, (Continuation) obj5);
        localSearchViewModel$result$3$1.L$0 = (List) obj;
        localSearchViewModel$result$3$1.L$1 = (List) obj2;
        localSearchViewModel$result$3$1.L$2 = (List) obj3;
        localSearchViewModel$result$3$1.L$3 = (List) obj4;
        return localSearchViewModel$result$3$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        List list = this.L$0;
        List list2 = this.L$1;
        List list3 = this.L$2;
        List list4 = this.L$3;
        ResultKt.throwOnFailure(obj);
        if (this.$hideVideoSongs) {
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : list) {
                if (!((Song) obj2).song.isVideo) {
                    arrayList.add(obj2);
                }
            }
            list = arrayList;
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList2.add((Song) it.next());
        }
        ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10));
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            arrayList3.add((Album) it2.next());
        }
        ArrayList arrayList4 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10));
        Iterator it3 = list3.iterator();
        while (it3.hasNext()) {
            arrayList4.add((Artist) it3.next());
        }
        ArrayList arrayList5 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list4, 10));
        Iterator it4 = list4.iterator();
        while (it4.hasNext()) {
            arrayList5.add((Playlist) it4.next());
        }
        return CollectionsKt.plus((Iterable) arrayList5, (Collection) CollectionsKt.plus((Iterable) arrayList4, (Collection) CollectionsKt.plus((Iterable) arrayList3, (Collection) arrayList2)));
    }
}
