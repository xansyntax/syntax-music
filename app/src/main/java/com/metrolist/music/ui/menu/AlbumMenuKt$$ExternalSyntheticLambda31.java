package com.metrolist.music.ui.menu;

import androidx.compose.runtime.MutableState;
import com.metrolist.music.db.entities.AlbumWithSongs;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.playback.DownloadUtil;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AlbumMenuKt$$ExternalSyntheticLambda31 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MutableState f$0;
    public final /* synthetic */ DownloadUtil f$1;

    public /* synthetic */ AlbumMenuKt$$ExternalSyntheticLambda31(MutableState mutableState, DownloadUtil downloadUtil, byte b) {
        this.$r8$classId = b;
        this.f$0 = mutableState;
        this.f$1 = downloadUtil;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        DownloadUtil downloadUtil = this.f$1;
        MutableState mutableState = this.f$0;
        switch (b) {
            case 0:
                Iterator it = ((List) mutableState.getValue()).iterator();
                while (it.hasNext()) {
                    downloadUtil.download((Song) it.next());
                }
                break;
            case 1:
                Iterator it2 = ((List) mutableState.getValue()).iterator();
                while (it2.hasNext()) {
                    downloadUtil.download((Song) it2.next());
                }
                break;
            default:
                AlbumWithSongs albumWithSongs = (AlbumWithSongs) mutableState.getValue();
                if (albumWithSongs != null) {
                    Iterator it3 = albumWithSongs.songs.iterator();
                    while (it3.hasNext()) {
                        downloadUtil.download((Song) it3.next());
                    }
                }
                break;
        }
        return unit;
    }
}
