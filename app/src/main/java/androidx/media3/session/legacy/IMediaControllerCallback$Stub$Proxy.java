package androidx.media3.session.legacy;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class IMediaControllerCallback$Stub$Proxy implements IMediaControllerCallback {
    public IBinder remote;

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.remote;
    }

    @Override // androidx.media3.session.legacy.IMediaControllerCallback
    public final void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
            parcelObtain.writeInt(1);
            playbackStateCompat.writeToParcel(parcelObtain, 0);
            this.remote.transact(3, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // androidx.media3.session.legacy.IMediaControllerCallback
    public final void onRepeatModeChanged(int i) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
            parcelObtain.writeInt(i);
            this.remote.transact(9, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // androidx.media3.session.legacy.IMediaControllerCallback
    public final void onShuffleModeChanged(int i) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
            parcelObtain.writeInt(i);
            this.remote.transact(12, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }
}
