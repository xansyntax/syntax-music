package com.metrolist.music.ui.screens.playlist;

import com.metrolist.music.db.entities.PlaylistSong;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.playback.queues.ListQueue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.text.HexFormatKt;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TopPlaylistScreenKt$$ExternalSyntheticLambda37 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ PlayerConnection f$0;
    public final /* synthetic */ List f$1;

    public /* synthetic */ TopPlaylistScreenKt$$ExternalSyntheticLambda37(PlayerConnection playerConnection, List list, byte b) {
        this.$r8$classId = b;
        this.f$0 = playerConnection;
        this.f$1 = list;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() throws Exception {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        List list = this.f$1;
        PlayerConnection playerConnection = this.f$0;
        switch (b) {
            case 0:
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(UuidKt.toMediaItem((Song) it.next()));
                }
                playerConnection.addToQueue(arrayList);
                break;
            case 1:
                ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(UuidKt.toMediaItem((Song) it2.next()));
                }
                playerConnection.addToQueue(arrayList2);
                break;
            case 2:
                List listShuffled = CollectionsKt__IterablesKt.shuffled(list);
                ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listShuffled, 10));
                ArrayList arrayList4 = (ArrayList) listShuffled;
                int size = arrayList4.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList4.get(i);
                    i++;
                    arrayList3.add(UuidKt.toMediaItem((Song) obj));
                }
                playerConnection.playQueue(new ListQueue("Cache Songs", arrayList3, 0, 0L, 12, null));
                break;
            case 3:
                ArrayList arrayList5 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                Iterator it3 = list.iterator();
                while (it3.hasNext()) {
                    arrayList5.add(UuidKt.toMediaItem((Song) it3.next()));
                }
                playerConnection.playQueue(new ListQueue("Cache Songs", arrayList5, 0, 0L, 12, null));
                break;
            case 4:
                ArrayList arrayList6 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                Iterator it4 = list.iterator();
                while (it4.hasNext()) {
                    arrayList6.add(UuidKt.toMediaItem((Song) it4.next()));
                }
                playerConnection.addToQueue(arrayList6);
                break;
            default:
                ArrayList arrayList7 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                Iterator it5 = list.iterator();
                while (it5.hasNext()) {
                    arrayList7.add(UuidKt.toMediaItem(HexFormatKt.toMediaMetadata(((PlaylistSong) it5.next()).song)));
                }
                playerConnection.addToQueue(arrayList7);
                break;
        }
        return unit;
    }
}
