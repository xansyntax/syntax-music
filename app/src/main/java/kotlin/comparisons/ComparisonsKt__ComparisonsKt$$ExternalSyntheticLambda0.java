package kotlin.comparisons;

import androidx.media3.exoplayer.mediacodec.MediaCodecUtil;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda0;
import java.util.Comparator;
import kotlin.jvm.functions.Function1;
import kotlin.text.RegexKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ComparisonsKt__ComparisonsKt$$ExternalSyntheticLambda0 implements Comparator {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ ComparisonsKt__ComparisonsKt$$ExternalSyntheticLambda0(byte b, Object obj) {
        this.$r8$classId = b;
        this.f$0 = obj;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Object obj3 = this.f$0;
        switch (b) {
            case 0:
                for (Function1 function1 : (Function1[]) obj3) {
                    int iCompareValues = RegexKt.compareValues((Comparable) function1.invoke(obj), (Comparable) function1.invoke(obj2));
                    if (iCompareValues != 0) {
                        return iCompareValues;
                    }
                }
                return 0;
            case 1:
                MediaCodecUtil.ScoreProvider scoreProvider = (MediaCodecUtil.ScoreProvider) obj3;
                return scoreProvider.getScore(obj2) - scoreProvider.getScore(obj);
            default:
                return ((Number) ((MainActivity$$ExternalSyntheticLambda0) obj3).invoke(obj, obj2)).intValue();
        }
    }
}
