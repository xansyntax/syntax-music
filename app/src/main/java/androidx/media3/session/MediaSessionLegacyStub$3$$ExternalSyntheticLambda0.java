package androidx.media3.session;

import androidx.media3.common.Format$$ExternalSyntheticOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MediaSessionLegacyStub$3$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ PlayerWrapper f$0;
    public final /* synthetic */ int f$1;

    public /* synthetic */ MediaSessionLegacyStub$3$$ExternalSyntheticLambda0(PlayerWrapper playerWrapper, int i, byte b) {
        this.$r8$classId = b;
        this.f$0 = playerWrapper;
        this.f$1 = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        byte b = this.$r8$classId;
        int i = this.f$1;
        PlayerWrapper playerWrapper = this.f$0;
        switch (b) {
            case 0:
                if (playerWrapper.isCommandAvailable(25) || playerWrapper.isCommandAvailable(33)) {
                    if (!playerWrapper.isCommandAvailable(33)) {
                        playerWrapper.setDeviceVolume(i);
                    } else {
                        playerWrapper.setDeviceVolume(i, 1);
                    }
                }
                break;
            default:
                if (playerWrapper.isCommandAvailable(26) || playerWrapper.isCommandAvailable(34)) {
                    if (i == -100) {
                        if (!playerWrapper.isCommandAvailable(34)) {
                            playerWrapper.setDeviceMuted(true);
                        } else {
                            playerWrapper.setDeviceMuted(1, true);
                        }
                    } else if (i == -1) {
                        if (!playerWrapper.isCommandAvailable(34)) {
                            playerWrapper.decreaseDeviceVolume();
                        } else {
                            playerWrapper.decreaseDeviceVolume(1);
                        }
                    } else if (i == 1) {
                        if (!playerWrapper.isCommandAvailable(34)) {
                            playerWrapper.increaseDeviceVolume();
                        } else {
                            playerWrapper.increaseDeviceVolume(1);
                        }
                    } else if (i == 100) {
                        if (!playerWrapper.isCommandAvailable(34)) {
                            playerWrapper.setDeviceMuted(false);
                        } else {
                            playerWrapper.setDeviceMuted(1, false);
                        }
                    } else if (i != 101) {
                        Format$$ExternalSyntheticOutline0.m(i, "onAdjustVolume: Ignoring unknown direction: ", "VolumeProviderCompat");
                    } else if (!playerWrapper.isCommandAvailable(34)) {
                        playerWrapper.setDeviceMuted(!playerWrapper.isDeviceMutedWithCommandCheck());
                    } else {
                        playerWrapper.setDeviceMuted(1, !playerWrapper.isDeviceMutedWithCommandCheck());
                    }
                }
                break;
        }
    }
}
