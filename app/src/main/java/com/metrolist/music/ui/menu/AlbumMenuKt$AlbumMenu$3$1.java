package com.metrolist.music.ui.menu;

import androidx.compose.runtime.MutableState;
import com.metrolist.music.db.entities.AlbumWithSongs;
import com.metrolist.music.db.entities.Song;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AlbumMenuKt$AlbumMenu$3$1 extends SuspendLambda implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MutableState $songs$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AlbumMenuKt$AlbumMenu$3$1(MutableState mutableState, Continuation continuation, byte b) {
        super(1, continuation);
        this.$r8$classId = b;
        this.$songs$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        byte b = this.$r8$classId;
        MutableState mutableState = this.$songs$delegate;
        switch (b) {
            case 0:
                return new AlbumMenuKt$AlbumMenu$3$1(mutableState, continuation, (byte) 0);
            case 1:
                return new AlbumMenuKt$AlbumMenu$3$1(mutableState, continuation, (byte) 1);
            case 2:
                return new AlbumMenuKt$AlbumMenu$3$1(mutableState, continuation, (byte) 2);
            default:
                return new AlbumMenuKt$AlbumMenu$3$1(mutableState, continuation, (byte) 3);
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Continuation continuation = (Continuation) obj;
        switch (b) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
        }
        return ((AlbumMenuKt$AlbumMenu$3$1) create(continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        EmptyList emptyList = EmptyList.INSTANCE;
        ArrayList arrayList = null;
        MutableState mutableState = this.$songs$delegate;
        switch (b) {
            case 0:
                ResultKt.throwOnFailure(obj);
                List list = (List) mutableState.getValue();
                ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList2.add(((Song) it.next()).song.id);
                }
                return arrayList2;
            case 1:
                ResultKt.throwOnFailure(obj);
                List list2 = (List) mutableState.getValue();
                ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10));
                Iterator it2 = list2.iterator();
                while (it2.hasNext()) {
                    arrayList3.add(((Song) it2.next()).song.id);
                }
                return arrayList3;
            case 2:
                ResultKt.throwOnFailure(obj);
                AlbumWithSongs albumWithSongs = (AlbumWithSongs) mutableState.getValue();
                if (albumWithSongs != null) {
                    List list3 = albumWithSongs.songs;
                    arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10));
                    Iterator it3 = list3.iterator();
                    while (it3.hasNext()) {
                        arrayList.add(((Song) it3.next()).song.id);
                    }
                }
                return arrayList == null ? emptyList : arrayList;
            default:
                ResultKt.throwOnFailure(obj);
                AlbumWithSongs albumWithSongs2 = (AlbumWithSongs) mutableState.getValue();
                if (albumWithSongs2 != null) {
                    List list4 = albumWithSongs2.songs;
                    arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list4, 10));
                    Iterator it4 = list4.iterator();
                    while (it4.hasNext()) {
                        arrayList.add(((Song) it4.next()).song.id);
                    }
                }
                return arrayList == null ? emptyList : arrayList;
        }
    }
}
