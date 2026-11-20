package androidx.media3.exoplayer;

import androidx.media3.common.AudioAttributes;
import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ExoPlayerImpl$$ExternalSyntheticLambda27 implements ListenerSet.Event {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ AudioAttributes f$0;

    public /* synthetic */ ExoPlayerImpl$$ExternalSyntheticLambda27(AudioAttributes audioAttributes, byte b) {
        this.$r8$classId = b;
        this.f$0 = audioAttributes;
    }

    @Override // androidx.media3.common.util.ListenerSet.Event
    public final void invoke(Object obj) {
        byte b = this.$r8$classId;
        AudioAttributes audioAttributes = this.f$0;
        Player.Listener listener = (Player.Listener) obj;
        switch (b) {
            case 0:
                listener.onAudioAttributesChanged(audioAttributes);
                break;
            default:
                listener.onAudioAttributesChanged(audioAttributes);
                break;
        }
    }
}
