package androidx.media3.exoplayer;

import androidx.media3.common.FlagSet;
import androidx.media3.common.Player;
import androidx.media3.common.util.BackgroundThreadStateHandler$StateChangeListener;
import androidx.media3.common.util.ListenerSet;
import com.yalantis.ucrop.UCropActivity$$ExternalSyntheticLambda1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ExoPlayerImpl$$ExternalSyntheticLambda20 implements ListenerSet.IterationFinishedEvent, BackgroundThreadStateHandler$StateChangeListener, ListenerSet.Event {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ ExoPlayerImpl f$0;

    public /* synthetic */ ExoPlayerImpl$$ExternalSyntheticLambda20(ExoPlayerImpl exoPlayerImpl, byte b) {
        this.$r8$classId = b;
        this.f$0 = exoPlayerImpl;
    }

    @Override // androidx.media3.common.util.ListenerSet.Event
    public void invoke(Object obj) {
        byte b = this.$r8$classId;
        ExoPlayerImpl exoPlayerImpl = this.f$0;
        Player.Listener listener = (Player.Listener) obj;
        switch (b) {
            case 3:
                listener.onPlaylistMetadataChanged(exoPlayerImpl.playlistMetadata);
                break;
            default:
                listener.onAvailableCommandsChanged(exoPlayerImpl.availableCommands);
                break;
        }
    }

    @Override // androidx.media3.common.util.BackgroundThreadStateHandler$StateChangeListener
    public void onStateChanged(Object obj, Object obj2) {
        ((Integer) obj).getClass();
        Integer num = (Integer) obj2;
        int iIntValue = num.intValue();
        ExoPlayerImpl exoPlayerImpl = this.f$0;
        exoPlayerImpl.verifyApplicationThread();
        exoPlayerImpl.sendRendererMessage(1, 10, num);
        exoPlayerImpl.sendRendererMessage(2, 10, num);
        exoPlayerImpl.listeners.sendEvent(21, new UCropActivity$$ExternalSyntheticLambda1((byte) 2, iIntValue));
    }

    @Override // androidx.media3.common.util.ListenerSet.IterationFinishedEvent
    public void invoke(Object obj, FlagSet flagSet) {
        ((Player.Listener) obj).onEvents(this.f$0.wrappingPlayer, new Player.Events(flagSet));
    }
}
