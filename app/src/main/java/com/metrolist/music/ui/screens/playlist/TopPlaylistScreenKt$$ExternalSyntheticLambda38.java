package com.metrolist.music.ui.screens.playlist;

import android.content.Context;
import androidx.media3.exoplayer.offline.DownloadService;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.playback.DownloadUtil;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TopPlaylistScreenKt$$ExternalSyntheticLambda38 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ int f$0;
    public final /* synthetic */ Function0 f$1;
    public final /* synthetic */ List f$2;
    public final /* synthetic */ Context f$3;
    public final /* synthetic */ DownloadUtil f$4;

    public /* synthetic */ TopPlaylistScreenKt$$ExternalSyntheticLambda38(int i, Function0 function0, List list, Context context, DownloadUtil downloadUtil, byte b) {
        this.$r8$classId = b;
        this.f$0 = i;
        this.f$1 = function0;
        this.f$2 = list;
        this.f$3 = context;
        this.f$4 = downloadUtil;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        DownloadUtil downloadUtil = this.f$4;
        Context context = this.f$3;
        List list = this.f$2;
        Function0 function0 = this.f$1;
        int i = this.f$0;
        switch (b) {
            case 0:
                if (i == 2) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        DownloadService.sendRemoveDownload(context, ((Song) it.next()).song.id);
                    }
                } else if (i == 3) {
                    function0.invoke();
                } else {
                    Iterator it2 = list.iterator();
                    while (it2.hasNext()) {
                        downloadUtil.download((Song) it2.next());
                    }
                }
                break;
            default:
                if (i == 2) {
                    Iterator it3 = list.iterator();
                    while (it3.hasNext()) {
                        DownloadService.sendRemoveDownload(context, ((Song) it3.next()).song.id);
                    }
                } else if (i == 3) {
                    function0.invoke();
                } else {
                    Iterator it4 = list.iterator();
                    while (it4.hasNext()) {
                        downloadUtil.download((Song) it4.next());
                    }
                }
                break;
        }
        return unit;
    }
}
