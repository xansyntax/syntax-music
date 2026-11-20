package androidx.media3.session;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.activity.OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0;
import androidx.compose.foundation.text.TextLinkScope$$ExternalSyntheticLambda10;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.media3.common.Player;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.ExoPlayerImpl$$ExternalSyntheticLambda24;
import androidx.media3.exoplayer.ExoPlayerImpl$$ExternalSyntheticLambda6;
import androidx.media3.exoplayer.StreamVolumeManager$$ExternalSyntheticLambda1;
import androidx.room.TransactionExecutor$$ExternalSyntheticLambda0;
import coil3.util.FileSystemsKt;
import com.google.common.base.Splitter$$ExternalSyntheticLambda0;
import com.google.common.collect.ImmutableList;
import com.yalantis.ucrop.UCropActivity$$ExternalSyntheticLambda1;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MediaControllerStub extends Binder implements IMediaController {
    public final WeakReference controller;
    public int sessionInterfaceVersion;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface ControllerTask {
        void run(MediaControllerImplBase mediaControllerImplBase);
    }

    public MediaControllerStub(MediaControllerImplBase mediaControllerImplBase) {
        attachInterface(this, "androidx.media3.session.IMediaController");
        this.controller = new WeakReference(mediaControllerImplBase);
        this.sessionInterfaceVersion = -1;
    }

    public static IMediaController asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("androidx.media3.session.IMediaController");
        if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IMediaController)) {
            return (IMediaController) iInterfaceQueryLocalInterface;
        }
        IMediaController$Stub$Proxy iMediaController$Stub$Proxy = new IMediaController$Stub$Proxy();
        iMediaController$Stub$Proxy.mRemote = iBinder;
        return iMediaController$Stub$Proxy;
    }

    public final void dispatchControllerTaskOnHandler(ControllerTask controllerTask) {
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        try {
            MediaControllerImplBase mediaControllerImplBase = (MediaControllerImplBase) this.controller.get();
            if (mediaControllerImplBase == null) {
                return;
            }
            Util.postOrRun(mediaControllerImplBase.instance.applicationHandler, new TransactionExecutor$$ExternalSyntheticLambda0((Object) mediaControllerImplBase, (Object) controllerTask, (byte) 5));
        } finally {
            Binder.restoreCallingIdentity(jClearCallingIdentity);
        }
    }

    @Override // androidx.media3.session.IMediaController
    public final void onAvailableCommandsChangedFromPlayer(int i, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        try {
            dispatchControllerTaskOnHandler(new MediaSessionImpl$$ExternalSyntheticLambda17(Player.Commands.fromBundle(bundle)));
        } catch (RuntimeException e) {
            Log.w("MediaControllerStub", "Ignoring malformed Bundle for Commands", e);
        }
    }

    @Override // androidx.media3.session.IMediaController
    public final void onConnected(int i, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        try {
            ConnectionState connectionStateFromBundle = ConnectionState.fromBundle(bundle);
            this.sessionInterfaceVersion = connectionStateFromBundle.sessionInterfaceVersion;
            dispatchControllerTaskOnHandler(new OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0((byte) 27, (Object) connectionStateFromBundle));
        } catch (RuntimeException e) {
            Log.w("MediaControllerStub", "Malformed Bundle for ConnectionResult. Disconnected from the session.", e);
            onDisconnected();
        }
    }

    @Override // androidx.media3.session.IMediaController
    public final void onCustomCommand(int i, Bundle bundle, Bundle bundle2) {
        if (bundle == null || bundle2 == null) {
            Log.w("MediaControllerStub", "Ignoring custom command with null args.");
            return;
        }
        try {
            dispatchControllerTaskOnHandler(new ExoPlayerImpl$$ExternalSyntheticLambda6(i, SessionCommand.fromBundle(bundle), bundle2));
        } catch (RuntimeException e) {
            Log.w("MediaControllerStub", "Ignoring malformed Bundle for SessionCommand", e);
        }
    }

    @Override // androidx.media3.session.IMediaController
    public final void onDisconnected() {
        dispatchControllerTaskOnHandler(new MediaSessionStub$$ExternalSyntheticLambda8((byte) 6));
    }

    @Override // androidx.media3.session.IMediaController
    public final void onLibraryResult(int i, Bundle bundle) {
        int i2;
        if (bundle == null || (i2 = this.sessionInterfaceVersion) == -1) {
            return;
        }
        try {
            setControllerFutureResult(i, LibraryResult.fromUnknownBundle(i2, bundle));
        } catch (RuntimeException e) {
            Log.w("MediaControllerStub", "Ignoring malformed Bundle for LibraryResult", e);
        }
    }

    @Override // androidx.media3.session.IMediaController
    public final void onPeriodicSessionPositionInfoChanged(int i, Bundle bundle) {
        int i2;
        if (bundle == null || (i2 = this.sessionInterfaceVersion) == -1) {
            return;
        }
        try {
            dispatchControllerTaskOnHandler(new OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0((byte) 28, (Object) SessionPositionInfo.fromBundle(i2, bundle)));
        } catch (RuntimeException e) {
            Log.w("MediaControllerStub", "Ignoring malformed Bundle for SessionPositionInfo", e);
        }
    }

    @Override // androidx.media3.session.IMediaController
    public final void onPlayerInfoChanged(int i, Bundle bundle, boolean z) {
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean(PlayerInfo.BundlingExclusions.FIELD_IS_TIMELINE_EXCLUDED, z);
        bundle2.putBoolean(PlayerInfo.BundlingExclusions.FIELD_ARE_CURRENT_TRACKS_EXCLUDED, true);
        onPlayerInfoChangedWithExclusions(i, bundle, bundle2);
    }

    @Override // androidx.media3.session.IMediaController
    public final void onPlayerInfoChangedWithExclusions(int i, Bundle bundle, Bundle bundle2) {
        int i2;
        if (bundle == null || bundle2 == null || (i2 = this.sessionInterfaceVersion) == -1) {
            return;
        }
        try {
            try {
                dispatchControllerTaskOnHandler(new TextLinkScope$$ExternalSyntheticLambda10((Object) PlayerInfo.fromBundle(i2, bundle), (Object) new PlayerInfo.BundlingExclusions(bundle2.getBoolean(PlayerInfo.BundlingExclusions.FIELD_IS_TIMELINE_EXCLUDED, false), bundle2.getBoolean(PlayerInfo.BundlingExclusions.FIELD_ARE_CURRENT_TRACKS_EXCLUDED, false)), (byte) 14));
            } catch (RuntimeException e) {
                Log.w("MediaControllerStub", "Ignoring malformed Bundle for BundlingExclusions", e);
            }
        } catch (RuntimeException e2) {
            Log.w("MediaControllerStub", "Ignoring malformed Bundle for PlayerInfo", e2);
        }
    }

    @Override // androidx.media3.session.IMediaController
    public final void onRenderedFirstFrame(int i) {
        dispatchControllerTaskOnHandler(new MediaSessionStub$$ExternalSyntheticLambda8((byte) 5));
    }

    @Override // androidx.media3.session.IMediaController
    public final void onSearchResultChanged(int i, int i2, Bundle bundle, String str) {
        if (TextUtils.isEmpty(str)) {
            Log.w("MediaControllerStub", "onSearchResultChanged(): Ignoring empty query");
            return;
        }
        if (i2 < 0) {
            Format$$ExternalSyntheticOutline0.m(i2, "onSearchResultChanged(): Ignoring negative itemCount: ", "MediaControllerStub");
            return;
        }
        if (bundle != null) {
            try {
                MediaLibraryService.LibraryParams.fromBundle(bundle);
            } catch (RuntimeException e) {
                Log.w("MediaControllerStub", "Ignoring malformed Bundle for LibraryParams", e);
                return;
            }
        }
        dispatchControllerTaskOnHandler(new MediaSessionStub$$ExternalSyntheticLambda8((byte) 7));
    }

    @Override // androidx.media3.session.IMediaController
    public final void onSessionResult(int i, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        try {
            setControllerFutureResult(i, SessionResult.fromBundle(bundle));
        } catch (RuntimeException e) {
            Log.w("MediaControllerStub", "Ignoring malformed Bundle for SessionResult", e);
        }
    }

    @Override // androidx.media3.session.IMediaController
    public final void onSetCustomLayout(int i, List list) {
        if (list == null || this.sessionInterfaceVersion == -1) {
            return;
        }
        try {
            ImmutableList.Builder builder = ImmutableList.builder();
            for (int i2 = 0; i2 < list.size(); i2++) {
                Bundle bundle = (Bundle) list.get(i2);
                bundle.getClass();
                builder.add((Object) CommandButton.fromBundle(this.sessionInterfaceVersion, bundle));
            }
            dispatchControllerTaskOnHandler(new ExoPlayerImpl$$ExternalSyntheticLambda6(i, builder.build(), (byte) 3));
        } catch (RuntimeException e) {
            Log.w("MediaControllerStub", "Ignoring malformed Bundle for CommandButton", e);
        }
    }

    @Override // androidx.media3.session.IMediaController
    public final void onSurfaceSizeChanged(int i, int i2, int i3) {
        dispatchControllerTaskOnHandler(new ExoPlayerImpl$$ExternalSyntheticLambda24(i2, i3, (byte) 2));
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        byte b = 1;
        if (i >= 1 && i <= 16777215) {
            parcel.enforceInterface("androidx.media3.session.IMediaController");
        }
        if (i == 1598968902) {
            parcel2.writeString("androidx.media3.session.IMediaController");
            return true;
        }
        if (i == 4001) {
            parcel.readInt();
            String string = parcel.readString();
            int i3 = parcel.readInt();
            Bundle bundle = (Bundle) FileSystemsKt.readTypedObject(parcel, Bundle.CREATOR);
            if (TextUtils.isEmpty(string)) {
                Log.w("MediaControllerStub", "onChildrenChanged(): Ignoring empty parentId");
            } else if (i3 < 0) {
                Format$$ExternalSyntheticOutline0.m(i3, "onChildrenChanged(): Ignoring negative itemCount: ", "MediaControllerStub");
            } else {
                if (bundle != null) {
                    try {
                        MediaLibraryService.LibraryParams.fromBundle(bundle);
                    } catch (RuntimeException e) {
                        Log.w("MediaControllerStub", "Ignoring malformed Bundle for LibraryParams", e);
                    }
                }
                dispatchControllerTaskOnHandler(new MediaSessionStub$$ExternalSyntheticLambda8((byte) 7));
            }
        } else {
            if (i == 4002) {
                onSearchResultChanged(parcel.readInt(), parcel.readInt(), (Bundle) FileSystemsKt.readTypedObject(parcel, Bundle.CREATOR), parcel.readString());
                return true;
            }
            switch (i) {
                case 3001:
                    onConnected(parcel.readInt(), (Bundle) FileSystemsKt.readTypedObject(parcel, Bundle.CREATOR));
                    return true;
                case 3002:
                    onSessionResult(parcel.readInt(), (Bundle) FileSystemsKt.readTypedObject(parcel, Bundle.CREATOR));
                    return true;
                case 3003:
                    onLibraryResult(parcel.readInt(), (Bundle) FileSystemsKt.readTypedObject(parcel, Bundle.CREATOR));
                    return true;
                case 3004:
                    onSetCustomLayout(parcel.readInt(), parcel.createTypedArrayList(Bundle.CREATOR));
                    return true;
                case 3005:
                    int i4 = parcel.readInt();
                    Parcelable.Creator creator = Bundle.CREATOR;
                    onCustomCommand(i4, (Bundle) FileSystemsKt.readTypedObject(parcel, creator), (Bundle) FileSystemsKt.readTypedObject(parcel, creator));
                    return true;
                case 3006:
                    parcel.readInt();
                    onDisconnected();
                    return true;
                case 3007:
                    onPlayerInfoChanged(parcel.readInt(), (Bundle) FileSystemsKt.readTypedObject(parcel, Bundle.CREATOR), parcel.readInt() != 0);
                    return true;
                case 3008:
                    onPeriodicSessionPositionInfoChanged(parcel.readInt(), (Bundle) FileSystemsKt.readTypedObject(parcel, Bundle.CREATOR));
                    return true;
                case 3009:
                    onAvailableCommandsChangedFromPlayer(parcel.readInt(), (Bundle) FileSystemsKt.readTypedObject(parcel, Bundle.CREATOR));
                    return true;
                case 3010:
                    parcel.readInt();
                    Parcelable.Creator creator2 = Bundle.CREATOR;
                    Bundle bundle2 = (Bundle) FileSystemsKt.readTypedObject(parcel, creator2);
                    Bundle bundle3 = (Bundle) FileSystemsKt.readTypedObject(parcel, creator2);
                    if (bundle2 != null && bundle3 != null) {
                        try {
                            try {
                                dispatchControllerTaskOnHandler(new TextLinkScope$$ExternalSyntheticLambda10((Object) SessionCommands.fromBundle(bundle2), (Object) Player.Commands.fromBundle(bundle3), (byte) 15));
                            } catch (RuntimeException e2) {
                                Log.w("MediaControllerStub", "Ignoring malformed Bundle for Commands", e2);
                            }
                        } catch (RuntimeException e3) {
                            Log.w("MediaControllerStub", "Ignoring malformed Bundle for SessionCommands", e3);
                        }
                    }
                    break;
                case 3011:
                    onRenderedFirstFrame(parcel.readInt());
                    return true;
                case 3012:
                    parcel.readInt();
                    Bundle bundleConvertToNullIfInvalid = Util.convertToNullIfInvalid((Bundle) FileSystemsKt.readTypedObject(parcel, Bundle.CREATOR));
                    if (bundleConvertToNullIfInvalid == null) {
                        Log.w("MediaControllerStub", "Ignoring null Bundle for extras");
                        return true;
                    }
                    dispatchControllerTaskOnHandler(new Splitter$$ExternalSyntheticLambda0(b, bundleConvertToNullIfInvalid));
                    return true;
                case 3013:
                    int i5 = parcel.readInt();
                    Parcelable.Creator creator3 = Bundle.CREATOR;
                    onPlayerInfoChangedWithExclusions(i5, (Bundle) FileSystemsKt.readTypedObject(parcel, creator3), (Bundle) FileSystemsKt.readTypedObject(parcel, creator3));
                    return true;
                case 3014:
                    dispatchControllerTaskOnHandler(new OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0(parcel.readInt(), (PendingIntent) FileSystemsKt.readTypedObject(parcel, PendingIntent.CREATOR)));
                    return true;
                case 3015:
                    parcel.readInt();
                    try {
                        SessionError.fromBundle((Bundle) FileSystemsKt.readTypedObject(parcel, Bundle.CREATOR));
                        dispatchControllerTaskOnHandler(new MediaSessionStub$$ExternalSyntheticLambda8((byte) 4));
                    } catch (RuntimeException e4) {
                        Log.w("MediaControllerStub", "Ignoring malformed Bundle for SessionError", e4);
                    }
                    break;
                case 3016:
                    int i6 = parcel.readInt();
                    ArrayList arrayListCreateTypedArrayList = parcel.createTypedArrayList(Bundle.CREATOR);
                    if (arrayListCreateTypedArrayList != null && this.sessionInterfaceVersion != -1) {
                        try {
                            ImmutableList.Builder builder = ImmutableList.builder();
                            for (int i7 = 0; i7 < arrayListCreateTypedArrayList.size(); i7++) {
                                Bundle bundle4 = (Bundle) arrayListCreateTypedArrayList.get(i7);
                                bundle4.getClass();
                                builder.add((Object) CommandButton.fromBundle(this.sessionInterfaceVersion, bundle4));
                            }
                            dispatchControllerTaskOnHandler(new ExoPlayerImpl$$ExternalSyntheticLambda6(i6, builder.build(), (byte) 2));
                        } catch (RuntimeException e5) {
                            Log.w("MediaControllerStub", "Ignoring malformed Bundle for CommandButton", e5);
                        }
                    }
                    break;
                case 3017:
                    int i8 = parcel.readInt();
                    Parcelable.Creator creator4 = Bundle.CREATOR;
                    Bundle bundle5 = (Bundle) FileSystemsKt.readTypedObject(parcel, creator4);
                    Bundle bundle6 = (Bundle) FileSystemsKt.readTypedObject(parcel, creator4);
                    Bundle bundle7 = (Bundle) FileSystemsKt.readTypedObject(parcel, creator4);
                    if (bundle5 == null || bundle6 == null) {
                        Log.w("MediaControllerStub", "Ignoring custom command progress update with null args.");
                    } else {
                        try {
                            dispatchControllerTaskOnHandler(new UCropActivity$$ExternalSyntheticLambda1(i8, SessionCommand.fromBundle(bundle5), bundle6, bundle7));
                        } catch (RuntimeException e6) {
                            Log.w("MediaControllerStub", "Ignoring malformed Bundle for SessionCommand", e6);
                        }
                    }
                    break;
                case 3018:
                    onSurfaceSizeChanged(parcel.readInt(), parcel.readInt(), parcel.readInt());
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
        return true;
    }

    public final void setControllerFutureResult(int i, Object obj) {
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        try {
            MediaControllerImplBase mediaControllerImplBase = (MediaControllerImplBase) this.controller.get();
            if (mediaControllerImplBase == null) {
                return;
            }
            mediaControllerImplBase.sequencedFutureManager.setFutureResult(i, obj);
            mediaControllerImplBase.instance.runOnApplicationLooper(new StreamVolumeManager$$ExternalSyntheticLambda1(mediaControllerImplBase, i, (byte) 3));
        } finally {
            Binder.restoreCallingIdentity(jClearCallingIdentity);
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }
}
