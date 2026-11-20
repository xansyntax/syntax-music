package androidx.media3.session;

import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;
import com.google.common.collect.RegularImmutableList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MediaSessionStub$$ExternalSyntheticLambda35 implements ListenerSet.Event, MediaSessionStub.SessionTask {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ List f$0;

    public /* synthetic */ MediaSessionStub$$ExternalSyntheticLambda35(RegularImmutableList regularImmutableList, byte b) {
        this.$r8$classId = b;
        this.f$0 = regularImmutableList;
    }

    @Override // androidx.media3.common.util.ListenerSet.Event
    public void invoke(Object obj) {
        ((Player.Listener) obj).onCues(this.f$0);
    }

    @Override // androidx.media3.session.MediaSessionStub.SessionTask
    public Object run(MediaLibrarySessionImpl mediaLibrarySessionImpl, MediaSession$ControllerInfo mediaSession$ControllerInfo, int i) {
        byte b = this.$r8$classId;
        List list = this.f$0;
        switch (b) {
            case 0:
                break;
        }
        return mediaLibrarySessionImpl.onAddMediaItemsOnHandler(mediaSession$ControllerInfo, list);
    }
}
