package com.metrolist.music.viewmodels;

import com.metrolist.music.db.entities.Song;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LibraryMixViewModel$songs$2$1 extends SuspendLambda implements Function3 {
    public final /* synthetic */ boolean $hideExplicit;
    public final /* synthetic */ boolean $hideVideoSongs;
    public /* synthetic */ List L$0;
    public /* synthetic */ List L$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LibraryMixViewModel$songs$2$1(boolean z, boolean z2, Continuation continuation) {
        super(3, continuation);
        this.$hideExplicit = z;
        this.$hideVideoSongs = z2;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        LibraryMixViewModel$songs$2$1 libraryMixViewModel$songs$2$1 = new LibraryMixViewModel$songs$2$1(this.$hideExplicit, this.$hideVideoSongs, (Continuation) obj3);
        libraryMixViewModel$songs$2$1.L$0 = (List) obj;
        libraryMixViewModel$songs$2$1.L$1 = (List) obj2;
        return libraryMixViewModel$songs$2$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        List list = this.L$0;
        List list2 = this.L$1;
        ResultKt.throwOnFailure(obj);
        ArrayList arrayListPlus = CollectionsKt.plus((Iterable) list2, (Collection) list);
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        int size = arrayListPlus.size();
        int i = 0;
        while (i < size) {
            Object obj2 = arrayListPlus.get(i);
            i++;
            if (hashSet.add(((Song) obj2).song.id)) {
                arrayList.add(obj2);
            }
        }
        return CollectionsKt__IterablesKt.filterVideoSongs(CollectionsKt__IterablesKt.filterExplicit(arrayList, this.$hideExplicit), this.$hideVideoSongs);
    }
}
