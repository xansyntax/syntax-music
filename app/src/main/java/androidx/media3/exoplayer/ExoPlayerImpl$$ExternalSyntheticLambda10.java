package androidx.media3.exoplayer;

import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Player;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.session.PlayerWrapper;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ExoPlayerImpl$$ExternalSyntheticLambda10 implements ListenerSet.Event, Consumer {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MediaMetadata f$0;

    public /* synthetic */ ExoPlayerImpl$$ExternalSyntheticLambda10(MediaMetadata mediaMetadata, byte b) {
        this.$r8$classId = b;
        this.f$0 = mediaMetadata;
    }

    @Override // androidx.media3.common.util.Consumer
    public void accept(Object obj) {
        ((PlayerWrapper) obj).setPlaylistMetadata(this.f$0);
    }

    @Override // androidx.media3.common.util.ListenerSet.Event
    public void invoke(Object obj) {
        byte b = this.$r8$classId;
        MediaMetadata mediaMetadata = this.f$0;
        Player.Listener listener = (Player.Listener) obj;
        switch (b) {
            case 0:
                listener.onMediaMetadataChanged(mediaMetadata);
                break;
            default:
                listener.onPlaylistMetadataChanged(mediaMetadata);
                break;
        }
    }
}
