package androidx.media3.session;

import androidx.media3.exoplayer.ExoPlayerImpl$$ExternalSyntheticLambda5;
import androidx.media3.exoplayer.ExoPlayerImpl$$ExternalSyntheticLambda6;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MediaSessionStub$$ExternalSyntheticLambda76 implements MediaSessionStub.SessionTask {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MediaSessionStub.SessionTask f$0;

    public /* synthetic */ MediaSessionStub$$ExternalSyntheticLambda76(MediaSessionStub.SessionTask sessionTask, byte b) {
        this.$r8$classId = b;
        this.f$0 = sessionTask;
    }

    @Override // androidx.media3.session.MediaSessionStub.SessionTask
    public final Object run(MediaLibrarySessionImpl mediaLibrarySessionImpl, MediaSession$ControllerInfo mediaSession$ControllerInfo, int i) {
        byte b = this.$r8$classId;
        MediaSessionStub.SessionTask sessionTask = this.f$0;
        switch (b) {
            case 0:
                return MediaSessionStub.handleSessionTaskWhenReady(mediaLibrarySessionImpl, mediaSession$ControllerInfo, i, sessionTask, new ExoPlayerImpl$$ExternalSyntheticLambda6(mediaSession$ControllerInfo, i, (byte) 5));
            default:
                return MediaSessionStub.handleSessionTaskWhenReady(mediaLibrarySessionImpl, mediaSession$ControllerInfo, i, sessionTask, new ExoPlayerImpl$$ExternalSyntheticLambda5(mediaLibrarySessionImpl, mediaSession$ControllerInfo, i, (byte) 6));
        }
    }
}
