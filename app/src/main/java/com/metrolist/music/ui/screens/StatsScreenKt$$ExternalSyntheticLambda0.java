package com.metrolist.music.ui.screens;

import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.runtime.snapshots.StateListIterator;
import com.metrolist.innertube.models.Artist;
import io.ktor.http.MimesKt$$ExternalSyntheticLambda0;
import java.util.List;
import java.util.ListIterator;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class StatsScreenKt$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ SnapshotStateList f$0;

    public /* synthetic */ StatsScreenKt$$ExternalSyntheticLambda0(SnapshotStateList snapshotStateList, byte b) {
        this.$r8$classId = b;
        this.f$0 = snapshotStateList;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        StateListIterator stateListIterator;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        SnapshotStateList snapshotStateList = this.f$0;
        switch (b) {
            case 0:
                Artist artist = (Artist) obj;
                artist.getClass();
                if (snapshotStateList != null && snapshotStateList.isEmpty()) {
                    snapshotStateList.add(artist);
                } else {
                    ListIterator listIterator = snapshotStateList.listIterator();
                    do {
                        stateListIterator = (StateListIterator) listIterator;
                        if (!stateListIterator.hasNext()) {
                            snapshotStateList.add(artist);
                            break;
                        }
                    } while (!Intrinsics.areEqual(((Artist) stateListIterator.next()).id, artist.id));
                    CollectionsKt__MutableCollectionsKt.removeAll(snapshotStateList, new MimesKt$$ExternalSyntheticLambda0((byte) 10, artist));
                }
                break;
            default:
                snapshotStateList.clear();
                snapshotStateList.addAll((List) obj);
                break;
        }
        return unit;
    }
}
