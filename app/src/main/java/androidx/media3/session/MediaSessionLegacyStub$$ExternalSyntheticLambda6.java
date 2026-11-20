package androidx.media3.session;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MediaSessionLegacyStub$$ExternalSyntheticLambda6 implements MediaSessionLegacyStub.SessionTask {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MediaSessionLegacyStub f$0;
    public final /* synthetic */ long f$1;

    public /* synthetic */ MediaSessionLegacyStub$$ExternalSyntheticLambda6(MediaSessionLegacyStub mediaSessionLegacyStub, long j, byte b) {
        this.$r8$classId = b;
        this.f$0 = mediaSessionLegacyStub;
        this.f$1 = j;
    }

    @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
    public final void run(MediaSession$ControllerInfo mediaSession$ControllerInfo) {
        byte b = this.$r8$classId;
        long j = this.f$1;
        MediaSessionLegacyStub mediaSessionLegacyStub = this.f$0;
        switch (b) {
            case 0:
                mediaSessionLegacyStub.sessionImpl.playerWrapper.seekTo(j);
                break;
            default:
                mediaSessionLegacyStub.sessionImpl.playerWrapper.seekToDefaultPosition((int) j);
                break;
        }
    }
}
