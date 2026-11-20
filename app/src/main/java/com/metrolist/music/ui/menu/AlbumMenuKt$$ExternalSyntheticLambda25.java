package com.metrolist.music.ui.menu;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import com.metrolist.music.db.entities.Album;
import com.metrolist.music.db.entities.AlbumEntity;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.playback.queues.ListQueue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AlbumMenuKt$$ExternalSyntheticLambda25 implements Function2 {
    public final /* synthetic */ byte $r8$classId = 1;
    public final /* synthetic */ Function0 f$0;
    public final /* synthetic */ PlayerConnection f$1;
    public final /* synthetic */ Album f$2;
    public final /* synthetic */ MutableState f$3;

    public /* synthetic */ AlbumMenuKt$$ExternalSyntheticLambda25(Function0 function0, Album album, PlayerConnection playerConnection, MutableState mutableState) {
        this.f$0 = function0;
        this.f$2 = album;
        this.f$1 = playerConnection;
        this.f$3 = mutableState;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        MutableState mutableState = this.f$3;
        PlayerConnection playerConnection = this.f$1;
        Album album = this.f$2;
        Function0 function0 = this.f$0;
        int i = 0;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    function0.invoke();
                    if (!((List) mutableState.getValue()).isEmpty()) {
                        String str = album.album.title;
                        List list = (List) mutableState.getValue();
                        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            arrayList.add(UuidKt.toMediaItem((Song) it.next()));
                        }
                        playerConnection.playQueue(new ListQueue(str, arrayList, 0, 0L, 12, null));
                    }
                }
                break;
            default:
                AlbumEntity albumEntity = album.album;
                Composer composer2 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(1 & iIntValue2, (iIntValue2 & 3) != 2)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    function0.invoke();
                    if (!((List) mutableState.getValue()).isEmpty()) {
                        String str2 = albumEntity.playlistId;
                        if (str2 != null) {
                            playerConnection.service.getAutomix(str2);
                        }
                        String str3 = albumEntity.title;
                        List listShuffled = CollectionsKt__IterablesKt.shuffled((List) mutableState.getValue());
                        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listShuffled, 10));
                        ArrayList arrayList3 = (ArrayList) listShuffled;
                        int size = arrayList3.size();
                        while (i < size) {
                            Object obj3 = arrayList3.get(i);
                            i++;
                            arrayList2.add(UuidKt.toMediaItem((Song) obj3));
                        }
                        playerConnection.playQueue(new ListQueue(str3, arrayList2, 0, 0L, 12, null));
                    }
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ AlbumMenuKt$$ExternalSyntheticLambda25(Function0 function0, PlayerConnection playerConnection, Album album, MutableState mutableState) {
        this.f$0 = function0;
        this.f$1 = playerConnection;
        this.f$2 = album;
        this.f$3 = mutableState;
    }
}
