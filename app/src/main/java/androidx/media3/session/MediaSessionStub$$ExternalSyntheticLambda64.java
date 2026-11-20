package androidx.media3.session;

import com.google.common.collect.ImmutableList;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MediaSessionStub$$ExternalSyntheticLambda64 implements MediaControllerImplBase.RemoteSessionTask, MediaSessionStub.SessionTask {
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ long f$1;

    public /* synthetic */ MediaSessionStub$$ExternalSyntheticLambda64(long j, Object obj) {
        this.f$0 = obj;
        this.f$1 = j;
    }

    @Override // androidx.media3.session.MediaSessionStub.SessionTask
    public Object run(MediaLibrarySessionImpl mediaLibrarySessionImpl, MediaSession$ControllerInfo mediaSession$ControllerInfo, int i) {
        return mediaLibrarySessionImpl.onSetMediaItemsOnHandler(mediaSession$ControllerInfo, ImmutableList.of(this.f$0), 0, this.f$1);
    }

    @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
    public void run(IMediaSession iMediaSession, int i) {
        MediaControllerImplBase mediaControllerImplBase = (MediaControllerImplBase) this.f$0;
        iMediaSession.seekTo(mediaControllerImplBase.controllerStub, i, this.f$1);
    }
}
