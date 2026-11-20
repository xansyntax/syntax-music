package androidx.media3.session;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MediaSessionLegacyStub$$ExternalSyntheticLambda7 implements MediaSessionLegacyStub.SessionTask {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MediaSessionLegacyStub f$0;
    public final /* synthetic */ int f$1;

    public /* synthetic */ MediaSessionLegacyStub$$ExternalSyntheticLambda7(MediaSessionLegacyStub mediaSessionLegacyStub, int i, byte b) {
        this.$r8$classId = b;
        this.f$0 = mediaSessionLegacyStub;
        this.f$1 = i;
    }

    @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
    public final void run(MediaSession$ControllerInfo mediaSession$ControllerInfo) {
        byte b = this.$r8$classId;
        int i = this.f$1;
        MediaSessionLegacyStub mediaSessionLegacyStub = this.f$0;
        switch (b) {
            case 0:
                mediaSessionLegacyStub.sessionImpl.playerWrapper.setShuffleModeEnabled(LegacyConversions.convertToShuffleModeEnabled(i));
                break;
            default:
                mediaSessionLegacyStub.sessionImpl.playerWrapper.setRepeatMode(LegacyConversions.convertToRepeatMode(i));
                break;
        }
    }
}
