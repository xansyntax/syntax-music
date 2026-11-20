package androidx.media3.session.legacy;

import android.content.Context;
import android.media.session.MediaController;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.ResultReceiver;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.util.Log;
import androidx.media3.session.MediaControllerImplLegacy;
import androidx.sqlite.SQLite;
import androidx.versionedparcelable.ParcelImpl;
import androidx.versionedparcelable.VersionedParcelable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class MediaControllerCompat$MediaControllerImplApi23 {
    public final MediaController controllerFwk;
    public final MediaSessionCompat$Token sessionToken;
    public final Object lock = new Object();
    public final ArrayList pendingCallbacks = new ArrayList();
    public final HashMap callbackMap = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ExtraBinderRequestResultReceiver extends ResultReceiver {
        public final WeakReference mediaControllerImpl;

        public ExtraBinderRequestResultReceiver(MediaControllerCompat$MediaControllerImplApi23 mediaControllerCompat$MediaControllerImplApi23) {
            super(null);
            this.mediaControllerImpl = new WeakReference(mediaControllerCompat$MediaControllerImplApi23);
        }

        @Override // android.os.ResultReceiver
        public final void onReceiveResult(int i, Bundle bundle) {
            IMediaSession iMediaSession;
            MediaControllerCompat$MediaControllerImplApi23 mediaControllerCompat$MediaControllerImplApi23 = (MediaControllerCompat$MediaControllerImplApi23) this.mediaControllerImpl.get();
            if (mediaControllerCompat$MediaControllerImplApi23 == null || bundle == null) {
                return;
            }
            synchronized (mediaControllerCompat$MediaControllerImplApi23.lock) {
                MediaSessionCompat$Token mediaSessionCompat$Token = mediaControllerCompat$MediaControllerImplApi23.sessionToken;
                IBinder binder = bundle.getBinder("android.support.v4.media.session.EXTRA_BINDER");
                int i2 = MediaSessionCompat$MediaSessionImplApi23.ExtraSession.$r8$clinit;
                VersionedParcelable versionedParcelable = null;
                if (binder == null) {
                    iMediaSession = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = binder.queryLocalInterface("android.support.v4.media.session.IMediaSession");
                    if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IMediaSession)) {
                        IMediaSession$Stub$Proxy iMediaSession$Stub$Proxy = new IMediaSession$Stub$Proxy();
                        iMediaSession$Stub$Proxy.remote = binder;
                        iMediaSession = iMediaSession$Stub$Proxy;
                    } else {
                        iMediaSession = (IMediaSession) iInterfaceQueryLocalInterface;
                    }
                }
                synchronized (mediaSessionCompat$Token.lock) {
                    mediaSessionCompat$Token.extraBinder = iMediaSession;
                }
                MediaSessionCompat$Token mediaSessionCompat$Token2 = mediaControllerCompat$MediaControllerImplApi23.sessionToken;
                try {
                    Bundle bundle2 = (Bundle) bundle.getParcelable("android.support.v4.media.session.SESSION_TOKEN2");
                    if (bundle2 != null) {
                        bundle2.setClassLoader(SQLite.class.getClassLoader());
                        Parcelable parcelable = bundle2.getParcelable("a");
                        if (!(parcelable instanceof ParcelImpl)) {
                            throw new IllegalArgumentException("Invalid parcel");
                        }
                        versionedParcelable = ((ParcelImpl) parcelable).mParcel;
                    }
                } catch (RuntimeException unused) {
                }
                synchronized (mediaSessionCompat$Token2.lock) {
                    mediaSessionCompat$Token2.session2Token = versionedParcelable;
                }
                mediaControllerCompat$MediaControllerImplApi23.processPendingCallbacksLocked();
            }
        }
    }

    public MediaControllerCompat$MediaControllerImplApi23(Context context, MediaSessionCompat$Token mediaSessionCompat$Token) {
        this.sessionToken = mediaSessionCompat$Token;
        MediaController mediaController = new MediaController(context, mediaSessionCompat$Token.inner);
        this.controllerFwk = mediaController;
        if (mediaSessionCompat$Token.getExtraBinder() == null) {
            mediaController.sendCommand("android.support.v4.media.session.command.GET_EXTRA_BINDER", null, new ExtraBinderRequestResultReceiver(this));
        }
    }

    public final MediaControllerCompat$PlaybackInfo getPlaybackInfo() {
        MediaController.PlaybackInfo playbackInfo = this.controllerFwk.getPlaybackInfo();
        if (playbackInfo != null) {
            return new MediaControllerCompat$PlaybackInfo(playbackInfo.getPlaybackType(), AudioAttributes.fromPlatformAudioAttributes(playbackInfo.getAudioAttributes()), playbackInfo.getVolumeControl(), playbackInfo.getMaxVolume(), playbackInfo.getCurrentVolume(), Build.VERSION.SDK_INT >= 30 ? playbackInfo.getVolumeControlId() : null);
        }
        return null;
    }

    public final void processPendingCallbacksLocked() {
        IMediaSession extraBinder = this.sessionToken.getExtraBinder();
        if (extraBinder == null) {
            return;
        }
        ArrayList arrayList = this.pendingCallbacks;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            MediaControllerImplLegacy.ControllerCompatCallback controllerCompatCallback = (MediaControllerImplLegacy.ControllerCompatCallback) obj;
            MediaControllerCompat$Callback$CallbackStub mediaControllerCompat$Callback$CallbackStub = new MediaControllerCompat$Callback$CallbackStub(controllerCompatCallback);
            this.callbackMap.put(controllerCompatCallback, mediaControllerCompat$Callback$CallbackStub);
            controllerCompatCallback.iControllerCallback = mediaControllerCompat$Callback$CallbackStub;
            try {
                extraBinder.registerCallbackListener(mediaControllerCompat$Callback$CallbackStub);
                controllerCompatCallback.postToHandler(13, null);
            } catch (RemoteException | SecurityException e) {
                Log.e("MediaControllerCompat", "Dead object in registerCallback.", e);
            }
        }
        arrayList.clear();
    }

    public final void unregisterCallback(MediaControllerImplLegacy.ControllerCompatCallback controllerCompatCallback) {
        MediaController mediaController = this.controllerFwk;
        MediaControllerCompat$Callback$MediaControllerCallback mediaControllerCompat$Callback$MediaControllerCallback = controllerCompatCallback.callbackFwk;
        mediaControllerCompat$Callback$MediaControllerCallback.getClass();
        mediaController.unregisterCallback(mediaControllerCompat$Callback$MediaControllerCallback);
        synchronized (this.lock) {
            IMediaSession extraBinder = this.sessionToken.getExtraBinder();
            if (extraBinder != null) {
                MediaControllerCompat$Callback$CallbackStub mediaControllerCompat$Callback$CallbackStub = (MediaControllerCompat$Callback$CallbackStub) this.callbackMap.remove(controllerCompatCallback);
                if (mediaControllerCompat$Callback$CallbackStub != null) {
                    controllerCompatCallback.iControllerCallback = null;
                    if (extraBinder.asBinder().isBinderAlive()) {
                        try {
                            extraBinder.unregisterCallbackListener(mediaControllerCompat$Callback$CallbackStub);
                        } catch (RemoteException | SecurityException e) {
                            Log.w("MediaControllerCompat", "Dead object in unregisterCallbackListener.", e);
                        }
                    }
                }
            } else {
                this.pendingCallbacks.remove(controllerCompatCallback);
            }
        }
    }
}
