package androidx.media3.session;

import androidx.media3.common.util.Util;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MediaSessionLegacyStub$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MediaSessionLegacyStub f$0;

    public /* synthetic */ MediaSessionLegacyStub$$ExternalSyntheticLambda0(MediaSessionLegacyStub mediaSessionLegacyStub, byte b) {
        this.$r8$classId = b;
        this.f$0 = mediaSessionLegacyStub;
    }

    @Override // java.lang.Runnable
    public final void run() {
        byte b = this.$r8$classId;
        MediaSessionLegacyStub mediaSessionLegacyStub = this.f$0;
        switch (b) {
            case 0:
                Util.postOrRun(mediaSessionLegacyStub.sessionImpl.applicationHandler, new MediaSessionLegacyStub$$ExternalSyntheticLambda0(mediaSessionLegacyStub, (byte) 1));
                break;
            default:
                mediaSessionLegacyStub.updateCustomLayoutAndLegacyExtrasForMediaButtonPreferencesAndInformExtrasChanged();
                break;
        }
    }
}
