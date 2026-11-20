package androidx.media3.session.legacy;

import android.content.Context;
import android.media.session.MediaSession;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteCallbackList;
import android.os.SystemClock;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class MediaSessionCompat$MediaSessionImplApi23 {
    public MediaSessionCompat$Callback callback;
    public final ExtraSession extraSession;
    public MediaMetadataCompat metadata;
    public PlaybackStateCompat playbackState;
    public List queue;
    public MediaSessionManager$RemoteUserInfo remoteUserInfo;
    public int repeatMode;
    public final MediaSession sessionFwk;
    public final Bundle sessionInfo;
    public int shuffleMode;
    public final MediaSessionCompat$Token token;
    public final Object lock = new Object();
    public final RemoteCallbackList extraControllerCallbacks = new RemoteCallbackList();

    public MediaSessionCompat$MediaSessionImplApi23(Context context, String str, Bundle bundle) {
        MediaSession mediaSessionCreateFwkMediaSession = createFwkMediaSession(context, str, bundle);
        this.sessionFwk = mediaSessionCreateFwkMediaSession;
        ExtraSession extraSession = new ExtraSession(this);
        this.extraSession = extraSession;
        this.token = new MediaSessionCompat$Token(mediaSessionCreateFwkMediaSession.getSessionToken(), extraSession);
        this.sessionInfo = bundle;
        mediaSessionCreateFwkMediaSession.setFlags(3);
    }

    public MediaSession createFwkMediaSession(Context context, String str, Bundle bundle) {
        return new MediaSession(context, str);
    }

    public MediaSessionManager$RemoteUserInfo getCurrentControllerInfo() {
        MediaSessionManager$RemoteUserInfo mediaSessionManager$RemoteUserInfo;
        synchronized (this.lock) {
            mediaSessionManager$RemoteUserInfo = this.remoteUserInfo;
        }
        return mediaSessionManager$RemoteUserInfo;
    }

    public void setCurrentControllerInfo(MediaSessionManager$RemoteUserInfo mediaSessionManager$RemoteUserInfo) {
        synchronized (this.lock) {
            this.remoteUserInfo = mediaSessionManager$RemoteUserInfo;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ExtraSession extends Binder implements IMediaSession {
        public static final /* synthetic */ int $r8$clinit = 0;
        public final WeakReference mediaSessionImplRef;

        public ExtraSession(MediaSessionCompat$MediaSessionImplApi23 mediaSessionCompat$MediaSessionImplApi23) {
            attachInterface(this, "android.support.v4.media.session.IMediaSession");
            this.mediaSessionImplRef = new WeakReference(mediaSessionCompat$MediaSessionImplApi23);
        }

        @Override // androidx.media3.session.legacy.IMediaSession
        public final PlaybackStateCompat getPlaybackState() {
            long j;
            MediaSessionCompat$MediaSessionImplApi23 mediaSessionCompat$MediaSessionImplApi23 = (MediaSessionCompat$MediaSessionImplApi23) this.mediaSessionImplRef.get();
            if (mediaSessionCompat$MediaSessionImplApi23 == null) {
                return null;
            }
            PlaybackStateCompat playbackStateCompat = mediaSessionCompat$MediaSessionImplApi23.playbackState;
            MediaMetadataCompat mediaMetadataCompat = mediaSessionCompat$MediaSessionImplApi23.metadata;
            if (playbackStateCompat != null) {
                float f = playbackStateCompat.speed;
                long j2 = playbackStateCompat.updateTime;
                int i = playbackStateCompat.state;
                long j3 = playbackStateCompat.position;
                long j4 = -1;
                if (j3 != -1 && ((i == 3 || i == 4 || i == 5) && j2 > 0)) {
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    long j5 = ((long) (f * (jElapsedRealtime - j2))) + j3;
                    if (mediaMetadataCompat != null && mediaMetadataCompat.bundle.containsKey("android.media.metadata.DURATION")) {
                        j4 = mediaMetadataCompat.getLong("android.media.metadata.DURATION");
                    }
                    if (j4 < 0 || j5 <= j4) {
                        j = j5 < 0 ? 0L : j5;
                    } else {
                        j = j4;
                    }
                    ArrayList arrayList = new ArrayList();
                    long j6 = playbackStateCompat.bufferedPosition;
                    long j7 = playbackStateCompat.actions;
                    int i2 = playbackStateCompat.errorCode;
                    CharSequence charSequence = playbackStateCompat.errorMessage;
                    List list = playbackStateCompat.customActions;
                    if (list != null) {
                        arrayList.addAll(list);
                    }
                    return new PlaybackStateCompat(playbackStateCompat.state, j, j6, playbackStateCompat.speed, j7, i2, charSequence, jElapsedRealtime, arrayList, playbackStateCompat.activeItemId, playbackStateCompat.extras);
                }
            }
            return playbackStateCompat;
        }

        @Override // androidx.media3.session.legacy.IMediaSession
        public final int getRepeatMode() {
            MediaSessionCompat$MediaSessionImplApi23 mediaSessionCompat$MediaSessionImplApi23 = (MediaSessionCompat$MediaSessionImplApi23) this.mediaSessionImplRef.get();
            if (mediaSessionCompat$MediaSessionImplApi23 != null) {
                return mediaSessionCompat$MediaSessionImplApi23.repeatMode;
            }
            return -1;
        }

        @Override // androidx.media3.session.legacy.IMediaSession
        public final int getShuffleMode() {
            MediaSessionCompat$MediaSessionImplApi23 mediaSessionCompat$MediaSessionImplApi23 = (MediaSessionCompat$MediaSessionImplApi23) this.mediaSessionImplRef.get();
            if (mediaSessionCompat$MediaSessionImplApi23 != null) {
                return mediaSessionCompat$MediaSessionImplApi23.shuffleMode;
            }
            return -1;
        }

        @Override // androidx.media3.session.legacy.IMediaSession
        public final boolean isCaptioningEnabled() {
            return false;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            Bundle bundle;
            IMediaControllerCallback iMediaControllerCallback = null;
            bundle = null;
            Bundle bundle2 = null;
            IMediaControllerCallback iMediaControllerCallback2 = null;
            if (i == 3) {
                parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("android.support.v4.media.session.IMediaControllerCallback");
                    if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IMediaControllerCallback)) {
                        IMediaControllerCallback$Stub$Proxy iMediaControllerCallback$Stub$Proxy = new IMediaControllerCallback$Stub$Proxy();
                        iMediaControllerCallback$Stub$Proxy.remote = strongBinder;
                        iMediaControllerCallback = iMediaControllerCallback$Stub$Proxy;
                    } else {
                        iMediaControllerCallback = (IMediaControllerCallback) iInterfaceQueryLocalInterface;
                    }
                }
                registerCallbackListener(iMediaControllerCallback);
                parcel2.getClass();
                parcel2.writeNoException();
                return true;
            }
            if (i == 4) {
                parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("android.support.v4.media.session.IMediaControllerCallback");
                    if (iInterfaceQueryLocalInterface2 == null || !(iInterfaceQueryLocalInterface2 instanceof IMediaControllerCallback)) {
                        IMediaControllerCallback$Stub$Proxy iMediaControllerCallback$Stub$Proxy2 = new IMediaControllerCallback$Stub$Proxy();
                        iMediaControllerCallback$Stub$Proxy2.remote = strongBinder2;
                        iMediaControllerCallback2 = iMediaControllerCallback$Stub$Proxy2;
                    } else {
                        iMediaControllerCallback2 = (IMediaControllerCallback) iInterfaceQueryLocalInterface2;
                    }
                }
                unregisterCallbackListener(iMediaControllerCallback2);
                parcel2.getClass();
                parcel2.writeNoException();
                return true;
            }
            if (i == 28) {
                parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                PlaybackStateCompat playbackState = getPlaybackState();
                parcel2.getClass();
                parcel2.writeNoException();
                if (playbackState == null) {
                    parcel2.writeInt(0);
                    return true;
                }
                parcel2.writeInt(1);
                playbackState.writeToParcel(parcel2, 1);
                return true;
            }
            if (i == 37) {
                parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                int repeatMode = getRepeatMode();
                parcel2.getClass();
                parcel2.writeNoException();
                parcel2.writeInt(repeatMode);
                return true;
            }
            if (i == 45) {
                parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                isCaptioningEnabled();
                parcel2.getClass();
                parcel2.writeNoException();
                parcel2.writeInt(0);
                return true;
            }
            if (i == 47) {
                parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                int shuffleMode = getShuffleMode();
                parcel2.getClass();
                parcel2.writeNoException();
                parcel2.writeInt(shuffleMode);
                return true;
            }
            if (i != 50) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.getClass();
                parcel2.writeString("android.support.v4.media.session.IMediaSession");
                return true;
            }
            parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
            MediaSessionCompat$MediaSessionImplApi23 mediaSessionCompat$MediaSessionImplApi23 = (MediaSessionCompat$MediaSessionImplApi23) this.mediaSessionImplRef.get();
            if (mediaSessionCompat$MediaSessionImplApi23 != null && (bundle = mediaSessionCompat$MediaSessionImplApi23.sessionInfo) != null) {
                bundle2 = new Bundle(bundle);
            }
            parcel2.getClass();
            parcel2.writeNoException();
            if (bundle2 == null) {
                parcel2.writeInt(0);
                return true;
            }
            parcel2.writeInt(1);
            bundle2.writeToParcel(parcel2, 1);
            return true;
        }

        @Override // androidx.media3.session.legacy.IMediaSession
        public final void registerCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
            MediaSessionCompat$MediaSessionImplApi23 mediaSessionCompat$MediaSessionImplApi23 = (MediaSessionCompat$MediaSessionImplApi23) this.mediaSessionImplRef.get();
            if (mediaSessionCompat$MediaSessionImplApi23 == null || iMediaControllerCallback == null) {
                return;
            }
            mediaSessionCompat$MediaSessionImplApi23.extraControllerCallbacks.register(iMediaControllerCallback, new MediaSessionManager$RemoteUserInfo("android.media.session.MediaController", Binder.getCallingPid(), Binder.getCallingUid()));
            synchronized (mediaSessionCompat$MediaSessionImplApi23.lock) {
            }
        }

        @Override // androidx.media3.session.legacy.IMediaSession
        public final void unregisterCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
            MediaSessionCompat$MediaSessionImplApi23 mediaSessionCompat$MediaSessionImplApi23 = (MediaSessionCompat$MediaSessionImplApi23) this.mediaSessionImplRef.get();
            if (mediaSessionCompat$MediaSessionImplApi23 == null || iMediaControllerCallback == null) {
                return;
            }
            mediaSessionCompat$MediaSessionImplApi23.extraControllerCallbacks.unregister(iMediaControllerCallback);
            Binder.getCallingPid();
            Binder.getCallingUid();
            synchronized (mediaSessionCompat$MediaSessionImplApi23.lock) {
            }
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }
    }
}
