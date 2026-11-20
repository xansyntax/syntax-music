package com.metrolist.music.ui.menu;

import com.metrolist.innertube.models.SongItem;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.playback.queues.ListQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SelectionSongsMenuKt$$ExternalSyntheticLambda40 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Function0 f$0;
    public final /* synthetic */ PlayerConnection f$1;
    public final /* synthetic */ ArrayList f$2;
    public final /* synthetic */ Function0 f$3;

    public /* synthetic */ SelectionSongsMenuKt$$ExternalSyntheticLambda40(PlayerConnection playerConnection, ArrayList arrayList, Function0 function0, Function0 function1) {
        this.$r8$classId = (byte) 3;
        this.f$1 = playerConnection;
        this.f$2 = arrayList;
        this.f$0 = function0;
        this.f$3 = function1;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() throws Exception {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        int i = 0;
        Function0 function0 = this.f$3;
        Function0 function1 = this.f$0;
        ArrayList arrayList = this.f$2;
        PlayerConnection playerConnection = this.f$1;
        switch (b) {
            case 0:
                function1.invoke();
                ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
                int size = arrayList.size();
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    arrayList2.add(UuidKt.toMediaItem((Song) obj));
                }
                playerConnection.playNext(arrayList2);
                function0.invoke();
                break;
            case 1:
                function1.invoke();
                List mutableList = CollectionsKt.toMutableList((Iterable) arrayList);
                Collections.shuffle(mutableList);
                ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(mutableList, 10));
                ArrayList arrayList4 = (ArrayList) mutableList;
                int size2 = arrayList4.size();
                while (i < size2) {
                    Object obj2 = arrayList4.get(i);
                    i++;
                    arrayList3.add(UuidKt.toMediaItem((Song) obj2));
                }
                playerConnection.playQueue(new ListQueue("Selection", arrayList3, 0, 0L, 12, null));
                function0.invoke();
                break;
            case 2:
                function1.invoke();
                ArrayList arrayList5 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
                int size3 = arrayList.size();
                while (i < size3) {
                    Object obj3 = arrayList.get(i);
                    i++;
                    arrayList5.add(UuidKt.toMediaItem((Song) obj3));
                }
                playerConnection.addToQueue(arrayList5);
                function0.invoke();
                break;
            default:
                ArrayList arrayList6 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
                int size4 = arrayList.size();
                while (i < size4) {
                    Object obj4 = arrayList.get(i);
                    i++;
                    arrayList6.add(UuidKt.toMediaItem((SongItem) obj4));
                }
                playerConnection.addToQueue(arrayList6);
                function1.invoke();
                function0.invoke();
                break;
        }
        return unit;
    }

    public /* synthetic */ SelectionSongsMenuKt$$ExternalSyntheticLambda40(Function0 function0, PlayerConnection playerConnection, ArrayList arrayList, Function0 function1, byte b) {
        this.$r8$classId = b;
        this.f$0 = function0;
        this.f$1 = playerConnection;
        this.f$2 = arrayList;
        this.f$3 = function1;
    }
}
