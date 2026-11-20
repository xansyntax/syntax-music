package androidx.media3.exoplayer;

import androidx.media3.common.AudioAttributes;
import androidx.media3.common.Player;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.session.MediaLibrarySessionImpl;
import androidx.media3.session.MediaSession$ControllerInfo;
import androidx.media3.session.MediaSessionStub;
import androidx.media3.session.PlayerWrapper;
import com.google.common.collect.ImmutableList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ExoPlayerImpl$$ExternalSyntheticLambda0 implements ListenerSet.Event, MediaSessionStub.SessionTask, Consumer {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ boolean f$1;

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ ExoPlayerImpl$$ExternalSyntheticLambda0(PlaybackInfo playbackInfo, int i) {
        this.$r8$classId = (byte) 0;
        this.f$0 = playbackInfo;
        this.f$1 = i;
    }

    @Override // androidx.media3.common.util.Consumer
    public void accept(Object obj) {
        ((PlayerWrapper) obj).setAudioAttributes((AudioAttributes) this.f$0, this.f$1);
    }

    @Override // androidx.media3.common.util.ListenerSet.Event
    public void invoke(Object obj) {
        ((Player.Listener) obj).onTimelineChanged(((PlaybackInfo) this.f$0).timeline, this.f$1 ? 1 : 0);
    }

    @Override // androidx.media3.session.MediaSessionStub.SessionTask
    public Object run(MediaLibrarySessionImpl mediaLibrarySessionImpl, MediaSession$ControllerInfo mediaSession$ControllerInfo, int i) {
        byte b = this.$r8$classId;
        boolean z = this.f$1;
        Object obj = this.f$0;
        switch (b) {
            case 1:
                return mediaLibrarySessionImpl.onSetMediaItemsOnHandler(mediaSession$ControllerInfo, ImmutableList.of(obj), z ? -1 : mediaLibrarySessionImpl.playerWrapper.getCurrentMediaItemIndex(), z ? -9223372036854775807L : mediaLibrarySessionImpl.playerWrapper.getCurrentPosition());
            default:
                return mediaLibrarySessionImpl.onSetMediaItemsOnHandler(mediaSession$ControllerInfo, (List) obj, z ? -1 : mediaLibrarySessionImpl.playerWrapper.getCurrentMediaItemIndex(), z ? -9223372036854775807L : mediaLibrarySessionImpl.playerWrapper.getCurrentPosition());
        }
    }

    public /* synthetic */ ExoPlayerImpl$$ExternalSyntheticLambda0(Object obj, boolean z, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = z;
    }
}
