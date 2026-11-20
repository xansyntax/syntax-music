package androidx.media3.session;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MediaControllerImplBase$$ExternalSyntheticLambda52 implements Runnable {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MediaControllerImplBase f$0;

    public /* synthetic */ MediaControllerImplBase$$ExternalSyntheticLambda52(MediaControllerImplBase mediaControllerImplBase, byte b) {
        this.$r8$classId = b;
        this.f$0 = mediaControllerImplBase;
    }

    @Override // java.lang.Runnable
    public final void run() {
        byte b = this.$r8$classId;
        MediaControllerImplBase mediaControllerImplBase = this.f$0;
        switch (b) {
            case 0:
                MediaControllerImplBase.SessionServiceConnection sessionServiceConnection = mediaControllerImplBase.serviceConnection;
                if (sessionServiceConnection != null) {
                    mediaControllerImplBase.context.unbindService(sessionServiceConnection);
                    mediaControllerImplBase.serviceConnection = null;
                }
                mediaControllerImplBase.controllerStub.controller.clear();
                break;
            default:
                PlayerInfo playerInfo = mediaControllerImplBase.pendingPlayerInfo;
                if (playerInfo != null) {
                    mediaControllerImplBase.onPlayerInfoChanged(playerInfo, PlayerInfo.BundlingExclusions.NONE);
                }
                break;
        }
    }
}
