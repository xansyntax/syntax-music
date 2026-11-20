package com.metrolist.innertubex.extraction;

import com.metrolist.innertubex.models.response.PlayerResponse;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class FormatSelectorsKt$special$$inlined$compareBy$1 implements Comparator {
    public final /* synthetic */ byte $r8$classId;

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                return Integer.valueOf(((PlayerResponse.StreamingData.Format) obj).bitrate).compareTo(Integer.valueOf(((PlayerResponse.StreamingData.Format) obj2).bitrate));
            default:
                Integer num = 0;
                Integer num2 = ((PlayerResponse.StreamingData.Format) obj).height;
                if (num2 == null) {
                    num2 = num;
                }
                Integer num3 = ((PlayerResponse.StreamingData.Format) obj2).height;
                return num2.compareTo(num3 != null ? num3 : 0);
        }
    }
}
