package androidx.media3.session;

import com.google.common.collect.ImmutableList;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MediaSessionImpl$$ExternalSyntheticLambda1 implements MediaSessionImpl$RemoteControllerTask, MediaSessionStub.SessionTask {
    public final /* synthetic */ ImmutableList f$0;

    public /* synthetic */ MediaSessionImpl$$ExternalSyntheticLambda1(ImmutableList immutableList) {
        this.f$0 = immutableList;
    }

    @Override // androidx.media3.session.MediaSessionStub.SessionTask
    public Object run(MediaLibrarySessionImpl mediaLibrarySessionImpl, MediaSession$ControllerInfo mediaSession$ControllerInfo, int i) {
        return mediaLibrarySessionImpl.onAddMediaItemsOnHandler(mediaSession$ControllerInfo, this.f$0);
    }

    @Override // androidx.media3.session.MediaSessionImpl$RemoteControllerTask
    public void run(MediaSession$ControllerCb mediaSession$ControllerCb, int i) {
        mediaSession$ControllerCb.setCustomLayout(i, this.f$0);
    }
}
