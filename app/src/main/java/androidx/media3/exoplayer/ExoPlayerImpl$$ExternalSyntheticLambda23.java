package androidx.media3.exoplayer;

import androidx.media3.common.Player;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.util.ListenerSet;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ExoPlayerImpl$$ExternalSyntheticLambda23 implements ListenerSet.Event {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ TrackSelectionParameters f$0;

    public /* synthetic */ ExoPlayerImpl$$ExternalSyntheticLambda23(TrackSelectionParameters trackSelectionParameters, byte b) {
        this.$r8$classId = b;
        this.f$0 = trackSelectionParameters;
    }

    @Override // androidx.media3.common.util.ListenerSet.Event
    public final void invoke(Object obj) {
        byte b = this.$r8$classId;
        TrackSelectionParameters trackSelectionParameters = this.f$0;
        Player.Listener listener = (Player.Listener) obj;
        switch (b) {
            case 0:
                listener.onTrackSelectionParametersChanged(trackSelectionParameters);
                break;
            default:
                listener.onTrackSelectionParametersChanged(trackSelectionParameters);
                break;
        }
    }
}
