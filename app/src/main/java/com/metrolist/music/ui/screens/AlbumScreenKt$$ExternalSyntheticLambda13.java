package com.metrolist.music.ui.screens;

import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import com.metrolist.music.db.entities.EventWithSong;
import com.metrolist.music.db.entities.Song;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AlbumScreenKt$$ExternalSyntheticLambda13 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ List f$0;
    public final /* synthetic */ List f$1;

    public /* synthetic */ AlbumScreenKt$$ExternalSyntheticLambda13(List list, List list2, byte b) {
        this.$r8$classId = b;
        this.f$0 = list;
        this.f$1 = list2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        List list = this.f$1;
        List list2 = this.f$0;
        switch (b) {
            case 0:
                ((Boolean) obj).booleanValue();
                if (list2.size() == list.size()) {
                    list2.clear();
                } else {
                    list2.clear();
                    ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((Song) it.next()).song.id);
                    }
                    list2.addAll(arrayList);
                }
                break;
            case 1:
                Placeable.PlacementScope placementScope = (Placeable.PlacementScope) obj;
                if (list2 != null) {
                    int size = list2.size();
                    for (int i = 0; i < size; i++) {
                        Pair pair = (Pair) list2.get(i);
                        Placeable.PlacementScope.m619place70tqf50$default(placementScope, (Placeable) pair.first, ((IntOffset) pair.second).packedValue);
                    }
                }
                if (list != null) {
                    int size2 = list.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        Pair pair2 = (Pair) list.get(i2);
                        Placeable placeable = (Placeable) pair2.first;
                        Function0 function0 = (Function0) pair2.second;
                        Placeable.PlacementScope.m619place70tqf50$default(placementScope, placeable, function0 != null ? ((IntOffset) function0.invoke()).packedValue : 0L);
                    }
                }
                break;
            case 2:
                ((Boolean) obj).getClass();
                if (list2.size() == list.size()) {
                    list2.clear();
                } else {
                    list2.clear();
                    ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                    Iterator it2 = list.iterator();
                    while (it2.hasNext()) {
                        arrayList2.add(Long.valueOf(((EventWithSong) it2.next()).event.id));
                    }
                    list2.addAll(arrayList2);
                }
                break;
            case 3:
                ((Boolean) obj).booleanValue();
                if (list2.size() == list.size()) {
                    list2.clear();
                } else {
                    list2.clear();
                    ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                    Iterator it3 = list.iterator();
                    while (it3.hasNext()) {
                        arrayList3.add(((Song) it3.next()).song.id);
                    }
                    list2.addAll(arrayList3);
                }
                break;
            case 4:
                ((Boolean) obj).booleanValue();
                if (list2.size() == list.size()) {
                    list2.clear();
                } else {
                    list2.clear();
                    ArrayList arrayList4 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                    Iterator it4 = list.iterator();
                    while (it4.hasNext()) {
                        arrayList4.add(((Song) it4.next()).song.id);
                    }
                    list2.addAll(arrayList4);
                }
                break;
            default:
                ((Boolean) obj).booleanValue();
                if (list2.size() == list.size()) {
                    list2.clear();
                } else {
                    list2.clear();
                    ArrayList arrayList5 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                    Iterator it5 = list.iterator();
                    while (it5.hasNext()) {
                        arrayList5.add(((Song) it5.next()).song.id);
                    }
                    list2.addAll(arrayList5);
                }
                break;
        }
        return unit;
    }
}
