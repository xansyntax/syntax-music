package com.metrolist.music.ui.menu;

import com.metrolist.music.db.entities.Song;
import java.util.ArrayList;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SelectionSongsMenuKt$SelectionSongMenu$2$1 extends SuspendLambda implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ ArrayList $songSelection;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SelectionSongsMenuKt$SelectionSongMenu$2$1(ArrayList arrayList, Continuation continuation, byte b) {
        super(1, continuation);
        this.$r8$classId = b;
        this.$songSelection = arrayList;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        byte b = this.$r8$classId;
        ArrayList arrayList = this.$songSelection;
        switch (b) {
            case 0:
                return new SelectionSongsMenuKt$SelectionSongMenu$2$1(arrayList, continuation, (byte) 0);
            default:
                return new SelectionSongsMenuKt$SelectionSongMenu$2$1(arrayList, continuation, (byte) 1);
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
        }
        return ((SelectionSongsMenuKt$SelectionSongMenu$2$1) create(continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        int i = 0;
        ArrayList arrayList = this.$songSelection;
        switch (b) {
            case 0:
                ResultKt.throwOnFailure(obj);
                ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
                int size = arrayList.size();
                while (i < size) {
                    Object obj2 = arrayList.get(i);
                    i++;
                    arrayList2.add(((Song) obj2).song.id);
                }
                return arrayList2;
            default:
                ResultKt.throwOnFailure(obj);
                ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
                int size2 = arrayList.size();
                while (i < size2) {
                    Object obj3 = arrayList.get(i);
                    i++;
                    arrayList3.add(((Song) obj3).song.id);
                }
                return arrayList3;
        }
    }
}
