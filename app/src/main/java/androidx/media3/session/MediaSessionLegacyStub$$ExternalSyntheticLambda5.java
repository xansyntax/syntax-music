package androidx.media3.session;

import androidx.media3.common.Timeline;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MediaSessionLegacyStub$$ExternalSyntheticLambda5 implements Runnable {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MediaSessionLegacyStub f$0;
    public final /* synthetic */ PlayerWrapper f$1;

    public /* synthetic */ MediaSessionLegacyStub$$ExternalSyntheticLambda5(MediaSessionLegacyStub mediaSessionLegacyStub, PlayerWrapper playerWrapper, byte b) {
        this.$r8$classId = b;
        this.f$0 = mediaSessionLegacyStub;
        this.f$1 = playerWrapper;
    }

    @Override // java.lang.Runnable
    public final void run() {
        byte b = this.$r8$classId;
        PlayerWrapper playerWrapper = this.f$1;
        MediaSessionLegacyStub mediaSessionLegacyStub = this.f$0;
        switch (b) {
            case 0:
                mediaSessionLegacyStub.sessionCompat.setPlaybackState(mediaSessionLegacyStub.createPlaybackStateCompat(playerWrapper));
                break;
            default:
                mediaSessionLegacyStub.sessionCompat.setPlaybackState(mediaSessionLegacyStub.createPlaybackStateCompat(playerWrapper));
                mediaSessionLegacyStub.controllerLegacyCbForBroadcast.updateQueue(playerWrapper.getAvailableCommands().contains(17) ? playerWrapper.getCurrentTimeline() : Timeline.EMPTY);
                break;
        }
    }
}
