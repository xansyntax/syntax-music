package com.metrolist.music.ui.menu;

import androidx.compose.runtime.MutableState;
import com.metrolist.music.db.entities.FormatEntity;
import com.metrolist.music.db.entities.PlaylistSong;
import com.metrolist.music.db.entities.Song;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AlbumMenuKt$AlbumMenu$1$1$1 implements FlowCollector {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MutableState $songs$delegate;

    public /* synthetic */ AlbumMenuKt$AlbumMenu$1$1$1(MutableState mutableState, byte b) {
        this.$r8$classId = b;
        this.$songs$delegate = mutableState;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        MutableState mutableState = this.$songs$delegate;
        switch (b) {
            case 0:
                mutableState.setValue((List) obj);
                break;
            case 1:
                List list = (List) obj;
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(((PlaylistSong) it.next()).song);
                }
                mutableState.setValue(arrayList);
                break;
            case 2:
                mutableState.setValue((Song) obj);
                break;
            default:
                mutableState.setValue((FormatEntity) obj);
                break;
        }
        return unit;
    }
}
