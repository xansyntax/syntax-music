package androidx.compose.material3;

import androidx.compose.material3.internal.FloatProducer;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import coil3.size.SizeKt;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.ui.player.QueueKt;
import com.metrolist.music.utils.InnerTubeXPlayer;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.EmptySet;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ListItemKt$$ExternalSyntheticLambda14 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ long f$0;
    public final /* synthetic */ Object f$2;

    public /* synthetic */ ListItemKt$$ExternalSyntheticLambda14(long j, ComposableLambdaImpl composableLambdaImpl, int i) {
        this.$r8$classId = (byte) 0;
        this.f$0 = j;
        this.f$2 = composableLambdaImpl;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        long j = this.f$0;
        Object obj3 = this.f$2;
        switch (b) {
            case 0:
                ((Integer) obj2).getClass();
                ListItemKt.m299ContentDecoratorrcwGITA(j, (ComposableLambdaImpl) obj3, (Composer) obj, Stack.updateChangedFlags(1));
                return unit;
            case 1:
                ((Integer) obj2).getClass();
                SizeKt.m860CircularArrowProgressIndicatorRPmYEkk((FloatProducer) obj3, j, (Composer) obj, Stack.updateChangedFlags(1));
                return unit;
            case 2:
                ((Integer) obj2).getClass();
                QueueKt.m1501NewMiniPlayerCoverRPmYEkk((MediaMetadata) obj3, j, (Composer) obj, Stack.updateChangedFlags(1));
                return unit;
            default:
                String str = (String) obj3;
                InnerTubeXPlayer.FailedStreamClients failedStreamClients = (InnerTubeXPlayer.FailedStreamClients) obj2;
                ((String) obj).getClass();
                Set set = failedStreamClients != null ? failedStreamClients.clientNames : null;
                if (set == null) {
                    set = EmptySet.INSTANCE;
                }
                return new InnerTubeXPlayer.FailedStreamClients(SetsKt.plus(set, str), j);
        }
    }

    public /* synthetic */ ListItemKt$$ExternalSyntheticLambda14(long j, String str) {
        this.$r8$classId = (byte) 3;
        this.f$2 = str;
        this.f$0 = j;
    }

    public /* synthetic */ ListItemKt$$ExternalSyntheticLambda14(Object obj, long j, int i, byte b) {
        this.$r8$classId = b;
        this.f$2 = obj;
        this.f$0 = j;
    }
}
