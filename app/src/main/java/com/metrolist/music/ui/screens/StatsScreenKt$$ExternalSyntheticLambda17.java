package com.metrolist.music.ui.screens;

import android.content.Context;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.playback.queues.ListQueue;
import com.yalantis.ucrop.R;
import java.util.ArrayList;
import java.util.Collections;
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
public final /* synthetic */ class StatsScreenKt$$ExternalSyntheticLambda17 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ PlayerConnection f$0;
    public final /* synthetic */ Context f$1;
    public final /* synthetic */ List f$2;

    public /* synthetic */ StatsScreenKt$$ExternalSyntheticLambda17(PlayerConnection playerConnection, Context context, List list, byte b) {
        this.$r8$classId = b;
        this.f$0 = playerConnection;
        this.f$1 = context;
        this.f$2 = list;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        List list = this.f$2;
        Context context = this.f$1;
        PlayerConnection playerConnection = this.f$0;
        switch (b) {
            case 0:
                String string = context.getString(R.string.most_played_songs);
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(UuidKt.toMediaItem(HexFormatKt.toMediaMetadata((Song) it.next())));
                }
                List mutableList = CollectionsKt.toMutableList((Iterable) arrayList);
                Collections.shuffle(mutableList);
                playerConnection.playQueue(new ListQueue(string, mutableList, 0, 0L, 12, null));
                break;
            default:
                String string2 = context.getString(R.string.most_played_songs);
                ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(UuidKt.toMediaItem(HexFormatKt.toMediaMetadata((Song) it2.next())));
                }
                playerConnection.playQueue(new ListQueue(string2, arrayList2, 0, 0L, 12, null));
                break;
        }
        return unit;
    }
}
