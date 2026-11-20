package androidx.media3.session.legacy;

import android.media.session.MediaController;
import com.yalantis.ucrop.view.CropImageView;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MediaControllerCompat$TransportControlsApi29 extends MediaBrowserCompat {
    @Override // androidx.media3.session.legacy.MediaBrowserCompat
    public final void setPlaybackSpeed(float f) {
        if (f != CropImageView.DEFAULT_ASPECT_RATIO) {
            ((MediaController.TransportControls) this.impl).setPlaybackSpeed(f);
        } else {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("speed must not be zero");
        }
    }
}
