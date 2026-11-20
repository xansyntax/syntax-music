package com.metrolist.music.ui.menu;

import androidx.compose.runtime.MutableState;
import com.metrolist.music.db.entities.AlbumWithSongs;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.playback.PlayerConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AlbumMenuKt$$ExternalSyntheticLambda32 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Function0 f$0;
    public final /* synthetic */ PlayerConnection f$1;
    public final /* synthetic */ MutableState f$2;

    public /* synthetic */ AlbumMenuKt$$ExternalSyntheticLambda32(PlayerConnection playerConnection, Function0 function0, MutableState mutableState, byte b) {
        this.$r8$classId = b;
        this.f$1 = playerConnection;
        this.f$0 = function0;
        this.f$2 = mutableState;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() throws Exception {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        MutableState mutableState = this.f$2;
        Function0 function0 = this.f$0;
        PlayerConnection playerConnection = this.f$1;
        switch (b) {
            case 0:
                function0.invoke();
                List list = (List) mutableState.getValue();
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(UuidKt.toMediaItem((Song) it.next()));
                }
                playerConnection.playNext(arrayList);
                break;
            case 1:
                function0.invoke();
                List list2 = (List) mutableState.getValue();
                ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10));
                Iterator it2 = list2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(UuidKt.toMediaItem((Song) it2.next()));
                }
                playerConnection.addToQueue(arrayList2);
                break;
            case 2:
                function0.invoke();
                List list3 = (List) mutableState.getValue();
                ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10));
                Iterator it3 = list3.iterator();
                while (it3.hasNext()) {
                    arrayList3.add(UuidKt.toMediaItem((Song) it3.next()));
                }
                playerConnection.addToQueue(arrayList3);
                break;
            case 3:
                AlbumWithSongs albumWithSongs = (AlbumWithSongs) mutableState.getValue();
                if (albumWithSongs != null) {
                    List list4 = albumWithSongs.songs;
                    ArrayList arrayList4 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list4, 10));
                    Iterator it4 = list4.iterator();
                    while (it4.hasNext()) {
                        arrayList4.add(UuidKt.toMediaItem((Song) it4.next()));
                    }
                    playerConnection.playNext(arrayList4);
                }
                function0.invoke();
                break;
            default:
                AlbumWithSongs albumWithSongs2 = (AlbumWithSongs) mutableState.getValue();
                if (albumWithSongs2 != null) {
                    List list5 = albumWithSongs2.songs;
                    ArrayList arrayList5 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list5, 10));
                    Iterator it5 = list5.iterator();
                    while (it5.hasNext()) {
                        arrayList5.add(UuidKt.toMediaItem((Song) it5.next()));
                    }
                    playerConnection.addToQueue(arrayList5);
                }
                function0.invoke();
                break;
        }
        return unit;
    }

    public /* synthetic */ AlbumMenuKt$$ExternalSyntheticLambda32(Function0 function0, PlayerConnection playerConnection, MutableState mutableState, byte b) {
        this.$r8$classId = b;
        this.f$0 = function0;
        this.f$1 = playerConnection;
        this.f$2 = mutableState;
    }
}
