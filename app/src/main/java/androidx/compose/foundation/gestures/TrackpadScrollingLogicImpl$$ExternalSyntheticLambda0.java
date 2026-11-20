package androidx.compose.foundation.gestures;

import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.channels.ChannelResult;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TrackpadScrollingLogicImpl$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ BufferedChannel f$0;

    public /* synthetic */ TrackpadScrollingLogicImpl$$ExternalSyntheticLambda0(BufferedChannel bufferedChannel, byte b) {
        this.$r8$classId = b;
        this.f$0 = bufferedChannel;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        BufferedChannel bufferedChannel = this.f$0;
        switch (b) {
            case 0:
                return (TrackpadScrollingLogicImpl.TrackpadScrollDelta) ChannelResult.m1903getOrNullimpl(bufferedChannel.mo1861tryReceivePtdJZtk());
            default:
                return (MouseWheelScrollingLogicImpl.MouseWheelScrollDelta) ChannelResult.m1903getOrNullimpl(bufferedChannel.mo1861tryReceivePtdJZtk());
        }
    }
}
