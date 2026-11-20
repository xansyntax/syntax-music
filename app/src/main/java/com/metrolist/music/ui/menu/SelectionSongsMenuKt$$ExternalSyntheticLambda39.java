package com.metrolist.music.ui.menu;

import com.metrolist.innertube.models.SongItem;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.playback.DownloadUtil;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.text.HexFormatKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SelectionSongsMenuKt$$ExternalSyntheticLambda39 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ List f$0;
    public final /* synthetic */ DownloadUtil f$1;

    public /* synthetic */ SelectionSongsMenuKt$$ExternalSyntheticLambda39(List list, DownloadUtil downloadUtil, byte b) {
        this.$r8$classId = b;
        this.f$0 = list;
        this.f$1 = downloadUtil;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        DownloadUtil downloadUtil = this.f$1;
        List<SongItem> list = this.f$0;
        switch (b) {
            case 0:
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    downloadUtil.download((MediaMetadata) it.next());
                }
                break;
            case 1:
                for (SongItem songItem : list) {
                    downloadUtil.getClass();
                    songItem.getClass();
                    downloadUtil.download(HexFormatKt.toMediaMetadata(songItem));
                }
                break;
            default:
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    downloadUtil.download((Song) it2.next());
                }
                break;
        }
        return unit;
    }
}
