package com.metrolist.music.ui.screens;

import com.metrolist.music.db.entities.Song;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.playback.queues.ListQueue;
import com.metrolist.music.viewmodels.DailyDiscoverItem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.text.HexFormatKt;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class HomeScreenKt$$ExternalSyntheticLambda72 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ List f$0;
    public final /* synthetic */ PlayerConnection f$1;
    public final /* synthetic */ String f$2;

    public /* synthetic */ HomeScreenKt$$ExternalSyntheticLambda72(PlayerConnection playerConnection, String str, List list) {
        this.$r8$classId = (byte) 0;
        this.f$0 = list;
        this.f$1 = playerConnection;
        this.f$2 = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        int i = 0;
        Unit unit = Unit.INSTANCE;
        List list = this.f$0;
        PlayerConnection playerConnection = this.f$1;
        switch (b) {
            case 0:
                ArrayList arrayList = new ArrayList();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(HexFormatKt.toMediaMetadata(((DailyDiscoverItem) it.next()).recommendation));
                }
                if (!arrayList.isEmpty()) {
                    ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
                    int size = arrayList.size();
                    while (i < size) {
                        Object obj = arrayList.get(i);
                        i++;
                        arrayList2.add(UuidKt.toMediaItem((MediaMetadata) obj));
                    }
                    playerConnection.playQueue(new ListQueue(this.f$2, arrayList2, 0, 0L, 12, null));
                }
                break;
            case 1:
                HashSet hashSet = new HashSet();
                ArrayList arrayList3 = new ArrayList();
                for (Object obj2 : list) {
                    if (hashSet.add(((Song) obj2).song.id)) {
                        arrayList3.add(obj2);
                    }
                }
                ArrayList arrayList4 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList3, 10));
                int size2 = arrayList3.size();
                while (i < size2) {
                    Object obj3 = arrayList3.get(i);
                    i++;
                    arrayList4.add(UuidKt.toMediaItem((Song) obj3));
                }
                playerConnection.playQueue(new ListQueue(this.f$2, arrayList4, 0, 0L, 12, null));
                break;
            case 2:
                HashSet hashSet2 = new HashSet();
                ArrayList arrayList5 = new ArrayList();
                for (Object obj4 : list) {
                    if (hashSet2.add(((Song) obj4).song.id)) {
                        arrayList5.add(obj4);
                    }
                }
                ArrayList arrayList6 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList5, 10));
                int size3 = arrayList5.size();
                while (i < size3) {
                    Object obj5 = arrayList5.get(i);
                    i++;
                    arrayList6.add(UuidKt.toMediaItem((Song) obj5));
                }
                playerConnection.playQueue(new ListQueue(this.f$2, arrayList6, 0, 0L, 12, null));
                break;
            case 3:
                List mutableList = CollectionsKt.toMutableList((Iterable) list);
                Collections.shuffle(mutableList);
                ArrayList arrayList7 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(mutableList, 10));
                ArrayList arrayList8 = (ArrayList) mutableList;
                int size4 = arrayList8.size();
                while (i < size4) {
                    Object obj6 = arrayList8.get(i);
                    i++;
                    arrayList7.add(UuidKt.toMediaItem((Song) obj6));
                }
                playerConnection.playQueue(new ListQueue(this.f$2, arrayList7, 0, 0L, 12, null));
                break;
            case 4:
                ArrayList arrayList9 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    arrayList9.add(UuidKt.toMediaItem((Song) it2.next()));
                }
                playerConnection.playQueue(new ListQueue(this.f$2, arrayList9, 0, 0L, 12, null));
                break;
            case 5:
                List mutableList2 = CollectionsKt.toMutableList((Iterable) list);
                Collections.shuffle(mutableList2);
                ArrayList arrayList10 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(mutableList2, 10));
                ArrayList arrayList11 = (ArrayList) mutableList2;
                int size5 = arrayList11.size();
                while (i < size5) {
                    Object obj7 = arrayList11.get(i);
                    i++;
                    arrayList10.add(UuidKt.toMediaItem((Song) obj7));
                }
                playerConnection.playQueue(new ListQueue(this.f$2, arrayList10, 0, 0L, 12, null));
                break;
            default:
                ArrayList arrayList12 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                Iterator it3 = list.iterator();
                while (it3.hasNext()) {
                    arrayList12.add(UuidKt.toMediaItem((Song) it3.next()));
                }
                playerConnection.playQueue(new ListQueue(this.f$2, arrayList12, 0, 0L, 12, null));
                break;
        }
        return unit;
    }

    public /* synthetic */ HomeScreenKt$$ExternalSyntheticLambda72(PlayerConnection playerConnection, String str, List list, byte b) {
        this.$r8$classId = b;
        this.f$1 = playerConnection;
        this.f$2 = str;
        this.f$0 = list;
    }
}
