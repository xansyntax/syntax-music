package com.metrolist.music.ui.menu;

import androidx.media3.common.Timeline;
import androidx.media3.exoplayer.ExoPlayerImpl;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.playback.queues.ListQueue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SelectionSongsMenuKt$$ExternalSyntheticLambda30 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Function0 f$0;
    public final /* synthetic */ List f$1;
    public final /* synthetic */ Function0 f$2;
    public final /* synthetic */ PlayerConnection f$3;

    public /* synthetic */ SelectionSongsMenuKt$$ExternalSyntheticLambda30(Function0 function0, List list, Function0 function1, PlayerConnection playerConnection) {
        this.$r8$classId = (byte) 0;
        this.f$0 = function0;
        this.f$1 = list;
        this.f$2 = function1;
        this.f$3 = playerConnection;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() throws Exception {
        byte b = this.$r8$classId;
        int i = 0;
        Unit unit = Unit.INSTANCE;
        Function0 function0 = this.f$2;
        List<Timeline.Window> list = this.f$1;
        PlayerConnection playerConnection = this.f$3;
        Function0 function1 = this.f$0;
        switch (b) {
            case 0:
                function1.invoke();
                for (Timeline.Window window : list) {
                    ExoPlayerImpl playerSafe = playerConnection.getPlayerSafe();
                    playerSafe.verifyApplicationThread();
                    if (playerSafe.availableCommands.contains(20)) {
                        playerConnection.getPlayerSafe().removeMediaItem(window.firstPeriodIndex - i);
                        i++;
                    }
                }
                function0.invoke();
                break;
            case 1:
                function1.invoke();
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(UuidKt.toMediaItem((MediaMetadata) it.next()));
                }
                playerConnection.playQueue(new ListQueue("Selection", arrayList, 0, 0L, 12, null));
                function0.invoke();
                break;
            case 2:
                function1.invoke();
                List listShuffled = CollectionsKt__IterablesKt.shuffled(list);
                ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listShuffled, 10));
                ArrayList arrayList3 = (ArrayList) listShuffled;
                int size = arrayList3.size();
                while (i < size) {
                    Object obj = arrayList3.get(i);
                    i++;
                    arrayList2.add(UuidKt.toMediaItem((MediaMetadata) obj));
                }
                playerConnection.playQueue(new ListQueue("Selection", arrayList2, 0, 0L, 12, null));
                function0.invoke();
                break;
            default:
                function1.invoke();
                ArrayList arrayList4 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    arrayList4.add(UuidKt.toMediaItem((MediaMetadata) it2.next()));
                }
                playerConnection.addToQueue(arrayList4);
                function0.invoke();
                break;
        }
        return unit;
    }

    public /* synthetic */ SelectionSongsMenuKt$$ExternalSyntheticLambda30(Function0 function0, PlayerConnection playerConnection, List list, Function0 function1, byte b) {
        this.$r8$classId = b;
        this.f$0 = function0;
        this.f$3 = playerConnection;
        this.f$1 = list;
        this.f$2 = function1;
    }
}
