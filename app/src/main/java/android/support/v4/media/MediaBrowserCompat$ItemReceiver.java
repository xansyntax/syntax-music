package android.support.v4.media;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.os.ResultReceiver;
import coil3.util.LifecyclesKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
class MediaBrowserCompat$ItemReceiver extends ResultReceiver {
    @Override // android.support.v4.os.ResultReceiver
    public final void onReceiveResult(int i, Bundle bundle) {
        if (bundle != null) {
            bundle = LifecyclesKt.unparcelWithClassLoader(bundle);
        }
        if (i != 0 || bundle == null || !bundle.containsKey("media_item")) {
            throw null;
        }
        Parcelable parcelable = bundle.getParcelable("media_item");
        if (parcelable != null && !(parcelable instanceof MediaBrowserCompat$MediaItem)) {
            throw null;
        }
        throw null;
    }
}
