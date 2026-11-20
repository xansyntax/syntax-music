package androidx.media3.session.legacy;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import androidx.media3.session.MediaControllerImplLegacy;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MediaControllerCompat$Callback$CallbackStub extends Binder implements IMediaControllerCallback {
    public final WeakReference callback;

    public MediaControllerCompat$Callback$CallbackStub(MediaControllerImplLegacy.ControllerCompatCallback controllerCompatCallback) {
        attachInterface(this, "android.support.v4.media.session.IMediaControllerCallback");
        this.callback = new WeakReference(controllerCompatCallback);
    }

    @Override // androidx.media3.session.legacy.IMediaControllerCallback
    public final void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat) {
        MediaControllerImplLegacy.ControllerCompatCallback controllerCompatCallback = (MediaControllerImplLegacy.ControllerCompatCallback) this.callback.get();
        if (controllerCompatCallback != null) {
            controllerCompatCallback.postToHandler(2, playbackStateCompat);
        }
    }

    @Override // androidx.media3.session.legacy.IMediaControllerCallback
    public final void onRepeatModeChanged(int i) {
        MediaControllerImplLegacy.ControllerCompatCallback controllerCompatCallback = (MediaControllerImplLegacy.ControllerCompatCallback) this.callback.get();
        if (controllerCompatCallback != null) {
            controllerCompatCallback.postToHandler(9, Integer.valueOf(i));
        }
    }

    @Override // androidx.media3.session.legacy.IMediaControllerCallback
    public final void onShuffleModeChanged(int i) {
        MediaControllerImplLegacy.ControllerCompatCallback controllerCompatCallback = (MediaControllerImplLegacy.ControllerCompatCallback) this.callback.get();
        if (controllerCompatCallback != null) {
            controllerCompatCallback.postToHandler(12, Integer.valueOf(i));
        }
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 3) {
            parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            onPlaybackStateChanged(parcel.readInt() != 0 ? PlaybackStateCompat.CREATOR.createFromParcel(parcel) : null);
            return true;
        }
        if (i == 9) {
            parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            onRepeatModeChanged(parcel.readInt());
            return true;
        }
        if (i == 1598968902) {
            parcel2.getClass();
            parcel2.writeString("android.support.v4.media.session.IMediaControllerCallback");
            return true;
        }
        WeakReference weakReference = this.callback;
        switch (i) {
            case 11:
                parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                boolean z = parcel.readInt() != 0;
                MediaControllerImplLegacy.ControllerCompatCallback controllerCompatCallback = (MediaControllerImplLegacy.ControllerCompatCallback) weakReference.get();
                if (controllerCompatCallback != null) {
                    controllerCompatCallback.postToHandler(11, Boolean.valueOf(z));
                }
                return true;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                onShuffleModeChanged(parcel.readInt());
                return true;
            case 13:
                parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                MediaControllerImplLegacy.ControllerCompatCallback controllerCompatCallback2 = (MediaControllerImplLegacy.ControllerCompatCallback) weakReference.get();
                if (controllerCompatCallback2 != null) {
                    controllerCompatCallback2.postToHandler(13, null);
                    return true;
                }
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }
}
