package androidx.media3.session;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.view.Surface;
import coil3.util.LifecyclesKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class IMediaSession$Stub$Proxy implements IMediaSession {
    public IBinder mRemote;

    @Override // androidx.media3.session.IMediaSession
    public final void addMediaItemWithIndex(IMediaController iMediaController, int i, int i2, Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcelObtain.writeStrongInterface(iMediaController);
            parcelObtain.writeInt(i);
            parcelObtain.writeInt(i2);
            LifecyclesKt.writeTypedObject(parcelObtain, bundle);
            this.mRemote.transact(3030, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void addMediaItems(IMediaController iMediaController, int i, IBinder iBinder) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcelObtain.writeStrongInterface(iMediaController);
            parcelObtain.writeInt(i);
            parcelObtain.writeStrongBinder(iBinder);
            this.mRemote.transact(3031, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void addMediaItemsWithIndex(IMediaController iMediaController, int i, int i2, IBinder iBinder) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcelObtain.writeStrongInterface(iMediaController);
            parcelObtain.writeInt(i);
            parcelObtain.writeInt(i2);
            parcelObtain.writeStrongBinder(iBinder);
            this.mRemote.transact(3032, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.mRemote;
    }

    @Override // androidx.media3.session.IMediaSession
    public final void clearMediaItems(IMediaController iMediaController, int i) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcelObtain.writeStrongInterface(iMediaController);
            parcelObtain.writeInt(i);
            this.mRemote.transact(3021, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void connect(IMediaController iMediaController, int i, Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcelObtain.writeStrongInterface(iMediaController);
            parcelObtain.writeInt(i);
            LifecyclesKt.writeTypedObject(parcelObtain, bundle);
            this.mRemote.transact(3015, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void decreaseDeviceVolume(IMediaController iMediaController, int i) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcelObtain.writeStrongInterface(iMediaController);
            parcelObtain.writeInt(i);
            this.mRemote.transact(3005, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void decreaseDeviceVolumeWithFlags(IMediaController iMediaController, int i, int i2) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcelObtain.writeStrongInterface(iMediaController);
            parcelObtain.writeInt(i);
            parcelObtain.writeInt(i2);
            this.mRemote.transact(3053, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void flushCommandQueue(IMediaController iMediaController) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcelObtain.writeStrongInterface(iMediaController);
            this.mRemote.transact(3045, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void increaseDeviceVolume(IMediaController iMediaController, int i) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcelObtain.writeStrongInterface(iMediaController);
            parcelObtain.writeInt(i);
            this.mRemote.transact(3004, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void increaseDeviceVolumeWithFlags(IMediaController iMediaController, int i, int i2) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcelObtain.writeStrongInterface(iMediaController);
            parcelObtain.writeInt(i);
            parcelObtain.writeInt(i2);
            this.mRemote.transact(3052, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void moveMediaItem(IMediaController iMediaController, int i, int i2, int i3) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcelObtain.writeStrongInterface(iMediaController);
            parcelObtain.writeInt(i);
            parcelObtain.writeInt(i2);
            parcelObtain.writeInt(i3);
            this.mRemote.transact(3022, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void moveMediaItems(IMediaController iMediaController, int i, int i2, int i3, int i4) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcelObtain.writeStrongInterface(iMediaController);
            parcelObtain.writeInt(i);
            parcelObtain.writeInt(i2);
            parcelObtain.writeInt(i3);
            parcelObtain.writeInt(i4);
            this.mRemote.transact(3023, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void mute(IMediaController iMediaController, int i) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcelObtain.writeStrongInterface(iMediaController);
            parcelObtain.writeInt(i);
            this.mRemote.transact(3058, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void onControllerResult(IMediaController iMediaController, int i, Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcelObtain.writeStrongInterface(iMediaController);
            parcelObtain.writeInt(i);
            LifecyclesKt.writeTypedObject(parcelObtain, bundle);
            this.mRemote.transact(3014, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void onCustomCommand(IMediaController iMediaController, int i, Bundle bundle, Bundle bundle2) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcelObtain.writeStrongInterface(iMediaController);
            parcelObtain.writeInt(i);
            LifecyclesKt.writeTypedObject(parcelObtain, bundle);
            LifecyclesKt.writeTypedObject(parcelObtain, bundle2);
            this.mRemote.transact(3016, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void onCustomCommandWithProgressUpdate(IMediaController iMediaController, int i, Bundle bundle, Bundle bundle2, boolean z) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcelObtain.writeStrongInterface(iMediaController);
            parcelObtain.writeInt(i);
            LifecyclesKt.writeTypedObject(parcelObtain, bundle);
            LifecyclesKt.writeTypedObject(parcelObtain, bundle2);
            parcelObtain.writeInt(z ? 1 : 0);
            this.mRemote.transact(3060, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void onSurfaceSizeChanged(IMediaController iMediaController, int i, int i2, int i3) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcelObtain.writeStrongInterface(iMediaController);
            parcelObtain.writeInt(i);
            parcelObtain.writeInt(i2);
            parcelObtain.writeInt(i3);
            this.mRemote.transact(3062, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void pause(IMediaController iMediaController, int i) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcelObtain.writeStrongInterface(iMediaController);
            parcelObtain.writeInt(i);
            this.mRemote.transact(3025, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void play(IMediaController iMediaController, int i) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcelObtain.writeStrongInterface(iMediaController);
            parcelObtain.writeInt(i);
            this.mRemote.transact(3024, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void prepare(IMediaController iMediaController, int i) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcelObtain.writeStrongInterface(iMediaController);
            parcelObtain.writeInt(i);
            this.mRemote.transact(3026, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void release(IMediaController iMediaController, int i) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcelObtain.writeStrongInterface(iMediaController);
            parcelObtain.writeInt(i);
            this.mRemote.transact(3035, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void removeMediaItem(IMediaController iMediaController, int i, int i2) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcelObtain.writeStrongInterface(iMediaController);
            parcelObtain.writeInt(i);
            parcelObtain.writeInt(i2);
            this.mRemote.transact(3019, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void removeMediaItems(IMediaController iMediaController, int i, int i2, int i3) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcelObtain.writeStrongInterface(iMediaController);
            parcelObtain.writeInt(i);
            parcelObtain.writeInt(i2);
            parcelObtain.writeInt(i3);
            this.mRemote.transact(3020, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void replaceMediaItem(IMediaController iMediaController, int i, int i2, Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcelObtain.writeStrongInterface(iMediaController);
            parcelObtain.writeInt(i);
            parcelObtain.writeInt(i2);
            LifecyclesKt.writeTypedObject(parcelObtain, bundle);
            this.mRemote.transact(3055, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void replaceMediaItems(IMediaController iMediaController, int i, int i2, int i3, IBinder iBinder) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcelObtain.writeStrongInterface(iMediaController);
            parcelObtain.writeInt(i);
            parcelObtain.writeInt(i2);
            parcelObtain.writeInt(i3);
            parcelObtain.writeStrongBinder(iBinder);
            this.mRemote.transact(3056, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void seekBack(IMediaController iMediaController, int i) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcelObtain.writeStrongInterface(iMediaController);
            parcelObtain.writeInt(i);
            this.mRemote.transact(3040, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void seekForward(IMediaController iMediaController, int i) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcelObtain.writeStrongInterface(iMediaController);
            parcelObtain.writeInt(i);
            this.mRemote.transact(3041, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void seekTo(IMediaController iMediaController, int i, long j) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcelObtain.writeStrongInterface(iMediaController);
            parcelObtain.writeInt(i);
            parcelObtain.writeLong(j);
            this.mRemote.transact(3038, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void seekToDefaultPosition(IMediaController iMediaController, int i) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcelObtain.writeStrongInterface(iMediaController);
            parcelObtain.writeInt(i);
            this.mRemote.transact(3036, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void seekToDefaultPositionWithMediaItemIndex(IMediaController iMediaController, int i, int i2) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcelObtain.writeStrongInterface(iMediaController);
            parcelObtain.writeInt(i);
            parcelObtain.writeInt(i2);
            this.mRemote.transact(3037, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void seekToNext(IMediaController iMediaController, int i) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcelObtain.writeStrongInterface(iMediaController);
            parcelObtain.writeInt(i);
            this.mRemote.transact(3047, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void seekToNextMediaItem(IMediaController iMediaController, int i) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcelObtain.writeStrongInterface(iMediaController);
            parcelObtain.writeInt(i);
            this.mRemote.transact(3043, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void seekToPrevious(IMediaController iMediaController, int i) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcelObtain.writeStrongInterface(iMediaController);
            parcelObtain.writeInt(i);
            this.mRemote.transact(3046, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void seekToPreviousMediaItem(IMediaController iMediaController, int i) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcelObtain.writeStrongInterface(iMediaController);
            parcelObtain.writeInt(i);
            this.mRemote.transact(3042, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void seekToWithMediaItemIndex(IMediaController iMediaController, int i, int i2, long j) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcelObtain.writeStrongInterface(iMediaController);
            parcelObtain.writeInt(i);
            parcelObtain.writeInt(i2);
            parcelObtain.writeLong(j);
            this.mRemote.transact(3039, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void setAudioAttributes(IMediaController iMediaController, int i, Bundle bundle, boolean z) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcelObtain.writeStrongInterface(iMediaController);
            parcelObtain.writeInt(i);
            LifecyclesKt.writeTypedObject(parcelObtain, bundle);
            parcelObtain.writeInt(z ? 1 : 0);
            this.mRemote.transact(3057, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void setDeviceMuted(IMediaController iMediaController, int i, boolean z) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcelObtain.writeStrongInterface(iMediaController);
            parcelObtain.writeInt(i);
            parcelObtain.writeInt(z ? 1 : 0);
            this.mRemote.transact(3006, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void setDeviceMutedWithFlags(IMediaController iMediaController, int i, boolean z, int i2) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcelObtain.writeStrongInterface(iMediaController);
            parcelObtain.writeInt(i);
            parcelObtain.writeInt(z ? 1 : 0);
            parcelObtain.writeInt(i2);
            this.mRemote.transact(3054, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void setDeviceVolume(IMediaController iMediaController, int i, int i2) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcelObtain.writeStrongInterface(iMediaController);
            parcelObtain.writeInt(i);
            parcelObtain.writeInt(i2);
            this.mRemote.transact(3003, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void setDeviceVolumeWithFlags(IMediaController iMediaController, int i, int i2, int i3) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcelObtain.writeStrongInterface(iMediaController);
            parcelObtain.writeInt(i);
            parcelObtain.writeInt(i2);
            parcelObtain.writeInt(i3);
            this.mRemote.transact(3051, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void setMediaItem(IMediaController iMediaController, int i, Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcelObtain.writeStrongInterface(iMediaController);
            parcelObtain.writeInt(i);
            LifecyclesKt.writeTypedObject(parcelObtain, bundle);
            this.mRemote.transact(3007, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void setMediaItemWithResetPosition(IMediaController iMediaController, int i, Bundle bundle, boolean z) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcelObtain.writeStrongInterface(iMediaController);
            parcelObtain.writeInt(i);
            LifecyclesKt.writeTypedObject(parcelObtain, bundle);
            parcelObtain.writeInt(1);
            this.mRemote.transact(3009, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void setMediaItemWithStartPosition(IMediaController iMediaController, int i, Bundle bundle, long j) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcelObtain.writeStrongInterface(iMediaController);
            parcelObtain.writeInt(i);
            LifecyclesKt.writeTypedObject(parcelObtain, bundle);
            parcelObtain.writeLong(j);
            this.mRemote.transact(3008, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void setMediaItemsWithResetPosition(IMediaController iMediaController, int i, IBinder iBinder, boolean z) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcelObtain.writeStrongInterface(iMediaController);
            parcelObtain.writeInt(i);
            parcelObtain.writeStrongBinder(iBinder);
            parcelObtain.writeInt(1);
            this.mRemote.transact(3011, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void setMediaItemsWithStartIndex(IMediaController iMediaController, int i, IBinder iBinder, int i2, long j) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcelObtain.writeStrongInterface(iMediaController);
            parcelObtain.writeInt(i);
            parcelObtain.writeStrongBinder(iBinder);
            parcelObtain.writeInt(i2);
            parcelObtain.writeLong(j);
            this.mRemote.transact(3012, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void setPlayWhenReady(IMediaController iMediaController, int i, boolean z) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcelObtain.writeStrongInterface(iMediaController);
            parcelObtain.writeInt(i);
            parcelObtain.writeInt(z ? 1 : 0);
            this.mRemote.transact(3013, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void setPlaybackParameters(IMediaController iMediaController, int i, Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcelObtain.writeStrongInterface(iMediaController);
            parcelObtain.writeInt(i);
            LifecyclesKt.writeTypedObject(parcelObtain, bundle);
            this.mRemote.transact(3027, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void setPlaybackSpeed(IMediaController iMediaController, int i, float f) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcelObtain.writeStrongInterface(iMediaController);
            parcelObtain.writeInt(i);
            parcelObtain.writeFloat(f);
            this.mRemote.transact(3028, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void setPlaylistMetadata(IMediaController iMediaController, int i, Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcelObtain.writeStrongInterface(iMediaController);
            parcelObtain.writeInt(i);
            LifecyclesKt.writeTypedObject(parcelObtain, bundle);
            this.mRemote.transact(3033, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void setRepeatMode(IMediaController iMediaController, int i, int i2) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcelObtain.writeStrongInterface(iMediaController);
            parcelObtain.writeInt(i);
            parcelObtain.writeInt(i2);
            this.mRemote.transact(3017, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void setShuffleModeEnabled(IMediaController iMediaController, int i, boolean z) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcelObtain.writeStrongInterface(iMediaController);
            parcelObtain.writeInt(i);
            parcelObtain.writeInt(z ? 1 : 0);
            this.mRemote.transact(3018, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void setTrackSelectionParameters(IMediaController iMediaController, int i, Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcelObtain.writeStrongInterface(iMediaController);
            parcelObtain.writeInt(i);
            LifecyclesKt.writeTypedObject(parcelObtain, bundle);
            this.mRemote.transact(3048, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void setVideoSurface(IMediaController iMediaController, int i, Surface surface) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcelObtain.writeStrongInterface(iMediaController);
            parcelObtain.writeInt(i);
            LifecyclesKt.writeTypedObject(parcelObtain, surface);
            this.mRemote.transact(3044, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void setVideoSurfaceWithSize(IMediaController iMediaController, int i, Surface surface, int i2, int i3) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcelObtain.writeStrongInterface(iMediaController);
            parcelObtain.writeInt(i);
            LifecyclesKt.writeTypedObject(parcelObtain, surface);
            parcelObtain.writeInt(i2);
            parcelObtain.writeInt(i3);
            this.mRemote.transact(3061, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void setVolume(IMediaController iMediaController, int i, float f) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcelObtain.writeStrongInterface(iMediaController);
            parcelObtain.writeInt(i);
            parcelObtain.writeFloat(f);
            this.mRemote.transact(3002, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void stop(IMediaController iMediaController, int i) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcelObtain.writeStrongInterface(iMediaController);
            parcelObtain.writeInt(i);
            this.mRemote.transact(3034, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void unmute(IMediaController iMediaController, int i) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcelObtain.writeStrongInterface(iMediaController);
            parcelObtain.writeInt(i);
            this.mRemote.transact(3059, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }
}
