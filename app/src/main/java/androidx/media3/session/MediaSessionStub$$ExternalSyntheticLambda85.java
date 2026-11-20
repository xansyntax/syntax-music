package androidx.media3.session;

import androidx.media3.common.util.Consumer;
import com.google.common.util.concurrent.ImmediateFuture;
import com.metrolist.music.playback.MediaLibrarySessionCallback;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MediaSessionStub$$ExternalSyntheticLambda85 implements MediaSessionStub.SessionTask, Consumer {
    public final /* synthetic */ CommandButton f$0;

    public /* synthetic */ MediaSessionStub$$ExternalSyntheticLambda85(CommandButton commandButton) {
        this.f$0 = commandButton;
    }

    @Override // androidx.media3.common.util.Consumer
    public void accept(Object obj) {
        this.f$0.executePlayerAction((PlayerWrapper) obj);
    }

    @Override // androidx.media3.session.MediaSessionStub.SessionTask
    public Object run(MediaLibrarySessionImpl mediaLibrarySessionImpl, MediaSession$ControllerInfo mediaSession$ControllerInfo, int i) {
        Object obj = this.f$0.parameter;
        obj.getClass();
        MediaLibrarySessionCallback mediaLibrarySessionCallback = mediaLibrarySessionImpl.callback$1;
        mediaLibrarySessionImpl.resolveControllerInfoForCallback(mediaSession$ControllerInfo);
        mediaLibrarySessionCallback.getClass();
        return new ImmediateFuture(new SessionResult(-6));
    }
}
